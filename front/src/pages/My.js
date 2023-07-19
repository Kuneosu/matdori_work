import BottomBar from "../components/BottomBar";
import "./My.css";
const My = () => {
    return (
        <div className="MY">
            <div className="MY_CONTENT">
                <div id="MY_NAME">닉네임</div>
                <center className="MY_PROFILE">
                    <img id="MY_IMAGE" src="https://images.unsplash.com/photo-1587691592099-24045742c181?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1173&q=80" />
                </center>
                <center>
                    <button className="MY_INFO">회원정보 수정</button>
                    <button className="MY_INFO">내 게시글</button>
                    <button className="MY_INFO">로그아웃</button>
                </center>
            </div>
            <BottomBar />
        </div>
    )
};

export default My;