package com.mysite.matdori.security.jwt;

import com.mysite.matdori.security.MyUserDetails;
import com.mysite.matdori.user.entity.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h

    @Autowired
    private MyUserDetails myUserDetails;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String userID, List<UserRole> userRoles) {
        logger.info("토큰을 생성합니다. 사용자 ID: {}", userID);

        Claims claims = Jwts.claims().setSubject(userID);
        logger.info("JWT claims 생성 완료. 사용자 ID: {}", userID);

        claims.put("auth", userRoles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority()))
                .filter(Objects::nonNull).collect(Collectors.toList()));
        logger.info("사용자 권한이 claims에 추가되었습니다. 사용자 권한: {}", userRoles);

        Date now = new Date();
        logger.info("현재 시간 생성 완료: {}", now);

        Date validity = new Date(now.getTime() + validityInMilliseconds);
        logger.info("유효 시간 생성 완료: {}", validity);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        logger.info("토큰 생성 완료. 토큰: {}", token);

        return token;
    }


    public Authentication getAuthentication(String token) {
        logger.info("토큰으로부터 인증 정보를 얻습니다. 토큰: {}", token);

        UserDetails userDetails = myUserDetails.loadUserByUsername(getUserID(token));
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

        logger.info("인증 정보를 성공적으로 얻었습니다.");
        return authentication;
    }

    public String getUserID(String token) {
        logger.info("토큰으로부터 사용자 ID를 얻습니다. 토큰: {}", token);

        String userID = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();

        logger.info("사용자 ID를 성공적으로 얻었습니다. 사용자 ID: {}", userID);
        return userID;
    }

    public String resolveToken(HttpServletRequest req) {
        logger.info("HttpServletRequest에서 토큰을 해석합니다.");

        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken = bearerToken.substring(7);
            logger.info("토큰을 성공적으로 해석하였습니다. 토큰: {}", bearerToken);
        } else {
            logger.warn("HttpServletRequest에서 토큰을 해석하지 못했습니다.");
        }

        return bearerToken;
    }

    public boolean validateToken(String token) {
        logger.info("토큰을 검증합니다. 토큰: {}", token);

        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            logger.info("토큰 검증에 성공하였습니다.");
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            logger.error("토큰 검증에 실패하였습니다. 에러: {}", e.getMessage());
            return false;
        }
    }
}
