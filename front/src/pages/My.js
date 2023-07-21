import BottomBar from "../components/BottomBar";
import "./My.css";
const My = () => {
    return (
        <div className="MY">
            <div className="MY_CONTENT">
                <div id="MY_NAME">닉네임</div>
                <center className="MY_PROFILE">
                    <img alt="내프로필이미지" id="MY_IMAGE" src="https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?size=626&ext=jpg&ga=GA1.2.1969849226.1689050998&semt=sph" />
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