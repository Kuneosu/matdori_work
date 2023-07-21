import BottomBar from "../components/BottomBar";
import DictionaryCard from "../components/DictionaryCard";
import HomeTag from "../components/HomeTag";
import "./Dictionary.css";

const Dictionary = () => {
    return (
        <div className="DICTIONARY">
            <div className="DICTIONARY_CONTENTS">
                <div className="DICTIONARY_TITLE">
                    7월 14일
                </div>
                <HomeTag />
                <div className="DICTIONARY_POSTS">
                    <DictionaryCard />
                    <DictionaryCard />
                    <DictionaryCard />
                </div>
            </div>
            <BottomBar />
        </div>
    );
};

export default Dictionary;