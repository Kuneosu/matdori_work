import "./DictionaryCard.css";

const DictionaryCard = () => {
    return (
        <div className="DICTIONARY_CARD">
            <div className="DICTIONARY_HEADER">
                <div className="DICTIONARY_THUMBNAIL">
                    <img alt="썸네일이미지" src="https://img.freepik.com/free-photo/adorable-kitty-looking-like-it-want-to-hunt_23-2149167099.jpg?size=626&ext=jpg&ga=GA1.2.1969849226.1689050998&semt=sph" className="DICTIONARY_THUMBNAIL_IMAGE" />
                </div>
                <div className="DICTIONARY_LINE"></div>
                <div className="DICTIONARY_CONTENT_HEADER">
                    <div className="DICTIONARY_CONTENT_TITLE">
                        게시글 제목
                    </div>
                    <div className="DICTIONARY_CONTENT_DATE">
                        2023.07.14
                    </div>
                </div>
            </div>

        </div>
    );
};

export default DictionaryCard;