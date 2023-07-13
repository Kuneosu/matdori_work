import BottomSignup from "../components/BottomSignup.js";
import Button from "../components/Button.js";
import FindButton from "../components/FindButton.js";
import Header from "../components/Header.js";
import InputText from "../components/InputText.js";
import "./Login.css";

const Login = () => {

    return (
        <div className="LOGIN">
            <Header className="LOGIN_TITLE" text={"LOGIN"} style={"NORMAL"} />
            <InputText text={"ID"} type={"text"} />
            <InputText text={"PASSWORD"} type={"password"} />
            <Button text={"로그인"} />
            <FindButton />
            <BottomSignup />
        </div>
    );
};

export default Login;