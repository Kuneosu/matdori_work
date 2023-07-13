import "./Signup.css";
import Button from "../components/Button";
import Header from "../components/Header";
import Information from "../components/Information";

const Signup = () => {
    const onClick = () => {
        alert("회원가입 완료");
    };
    return (
        <div className="SIGNUP">
            <Header className="SIGNUP_TITLE" text={"JOIN"} style={"NORMAL"} />
            <Information />
            <Button text={"회원가입"} onClick={onClick} />
        </div>
    );
};

export default Signup;