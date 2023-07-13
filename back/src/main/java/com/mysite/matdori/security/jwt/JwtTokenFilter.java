package com.mysite.matdori.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override

    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        logger.info("doFilterInternal 시작");
        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        try {
            logger.info("토큰 확인: " + token);
            if (token != null && jwtTokenProvider.validateToken(token)) {
                logger.info("토큰 검증 통과");
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception ex) {
            logger.error("예외 발생: " + ex.getMessage());
            SecurityContextHolder.clearContext();
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            logger.info("sendError 호출 후");
            return;
        }
        logger.info("filterChain.doFilter 호출 전");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        logger.info("filterChain.doFilter 호출 후");
    }
}
