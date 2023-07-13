import "./BottomSignup.css";
import { useNavigate } from "react-router-dom";

const BottomSignup = () => {
    const navigate = useNavigate();
    const onClickSignup = () => {
        navigate('../signup');
    }
    return (
        <div className="BOTTOM">
            <div>아직 회원이 아니신가요 ?</div>
            <button className="Signup" onClick={onClickSignup}>회원가입</button>
        </div>
    );
}

export default BottomSignup;