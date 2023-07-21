import { useState } from "react";
import "./HomeCard.css";

const HomeCard = () => {
    const [expanded, setExpanded] = useState(false);

    const handleClick = () => {
        setExpanded(!expanded);
    };

    return (
        <div className={`HOME_CARD ${expanded ? "expanded" : ""}`}
            onClick={handleClick}>
            <div className="HOME_HEADER">
                <div className="HOME_PROFILE">
                    <img alt="프로필이미지" src="https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?size=626&ext=jpg&ga=GA1.2.1969849226.1689050998&semt=sph" className="HOME_PROFILE_IMAGE" />
                </div>
                <div className="HOME_LINE"></div>
                <div className="HOME_CONTENT_HEADER">
                    <div className="HOME_CONTENT_TITLE">
                        게시글 제목
                    </div>
                    <div className="HOME_CONTENT_DATE">
                        2023.07.14
                    </div>
                </div>
            </div>
            <div className="HOME_CONTENT">
                내용
            </div>
        </div>
    );
};

export default HomeCard;