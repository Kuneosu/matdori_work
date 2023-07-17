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

        </div>
    );
};

export default HomeCard;