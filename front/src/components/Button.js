import "./Button.css";

const Button = ({ text, onClick, style }) => {
    return (
        <button className={["BUTTON", `${style}`].join(" ")} onClick={onClick}>{text}</button>
    );
};

export default Button;