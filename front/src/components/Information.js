import "./Information.css";

const Information = () => {
    return (
        <div className="INFORMATION">
            <div className="ID_CHECK">
                <input type="text" className="ID_INPUT" placeholder="아이디" />
                <button className="ID_BUTTON">중복확인</button>
            </div>
            <div className="OTHER_INFO">
                <input type="password" placeholder="비밀번호 (숫자/영문 조합 8자리)" />
                <input type="password" placeholder="비밀번호 확인" />
                <input type="email" placeholder="이메일" />
                <input type="text" placeholder="닉네임" />
            </div>
        </div>
    );
}

export default Information;