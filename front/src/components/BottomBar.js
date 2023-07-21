import "./BottomBar.css";
import { useNavigate } from "react-router-dom";

const BottomBar = () => {
    const navigate = useNavigate();
    const moveHome = () => {
        navigate(`/home`);
    }
    const moveDic = () => {
        navigate(`/dictionary`);
    }
    const moveMy = () => {
        navigate(`/my`);
    }
    return (
        <div className="BOTTOM_BAR">
            <button className="BOTTOM_BAR_ICON FIRST_ICON" onClick={moveHome}></button>
            <button className="BOTTOM_BAR_ICON SECOND_ICON" onClick={moveDic}></button>
            <button className="BOTTOM_BAR_ICON THIRD_ICON" onClick={moveMy}></button>
        </div >
    );
};

export default BottomBar;