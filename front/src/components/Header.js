import "./Header.css";

const Header = ({ text, style }) => {
    return (
        <div className={style}>{text}</div>
    );
}

export default Header;