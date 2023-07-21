import "./InputText.css";

const InputText = ({ text, type, value, onChange }) => {
    return (
        <input className="INPUT" type={type}
            placeholder={[`${text}`, "를 입력하세요."].join("")}
            value={value}
            onChange={onChange} />
    );
};

export default InputText;