import { useState } from "react";
import { useNavigate } from "react-router-dom";
import BottomSignup from "../components/BottomSignup.js";
import Button from "../components/Button.js";
import FindButton from "../components/FindButton.js";
import Header from "../components/Header.js";
import InputText from "../components/InputText.js";
import axios from "axios";
import "./Login.css";

const Login = () => {
    const [idValue, setIdValue] = useState();
    const [passwordValue, setPasswordValue] = useState();
    const navigate = useNavigate();

    const moveHome = () => {
        navigate('../home');
    };

    // 로그인 버튼을 누르면
    // InputText ID 랑
    // InputText PW 를 받아와서
    // axios.POST 해주고
    // response 가 200 일때 로그인
    const handleLogin = () => {
        // Do axios.POST with the idValue and passwordValue
        // Assuming you have an axios.post() method to handle the login process.
        // Make sure to add the necessary code to handle the login logic.
        axios.post('/login', {
            id: idValue,
            password: passwordValue,
        })
            .then((response) => {
                // Assuming login is successful when the response status is 200.
                if (response.status === 200) {
                    // Navigate to the home page
                    alert("로그인 성공");
                    moveHome();
                } else {
                    // Handle login failure here (e.g., show error message)
                }
            })
            .catch((error) => {
                alert("잘못된 정보 입니다.")
            });
    };

    return (
        <div className="LOGIN">
            <Header className="LOGIN_TITLE" text={"LOGIN"} style={"NORMAL"} />
            <InputText text={"ID"}
                type={"text"}
                value={idValue}
                onChange={(e) => setIdValue(e.target.value)} />
            <InputText text={"PASSWORD"}
                type={"password"}
                value={passwordValue}
                onChange={(e) => setPasswordValue(e.target.value)} />
            <Button text={"로그인"} onClick={handleLogin} />
            <FindButton />
            <BottomSignup />
        </div>
    );
};

export default Login;