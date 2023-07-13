import { useNavigate } from "react-router-dom";
import Button from "../components/Button";
import Card from "../components/Card";
import "./Start.css";

const Start = () => {
    const navigate = useNavigate();
    const moveLogin = () => {
        navigate('../login');
    };
    const moveSignup = () => {
        navigate('../signup'
        );
    };
    return (
        <div className="START">
            <section className="TITLE">
                맛있는 경제 정보
                <span id="matdori">맛도리</span>
            </section>
            <section className="CARD_SECTION">
                <Card />
            </section>
            <section className="BUTTON_SECTION">
                <Button text={"로그인"} onClick={moveLogin} />
                <Button text={"회원가입"} style={"WHITE"} onClick={moveSignup} />
            </section>
        </div>
    )
};

export default Start;
