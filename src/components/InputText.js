import "./InputText.css";

const InputText = ({ text, type }) => {
    return (
        <input className="INPUT" type={type}
            placeholder={[`${text}`, "를 입력하세요."].join("")} />
    );
};

export default InputText;