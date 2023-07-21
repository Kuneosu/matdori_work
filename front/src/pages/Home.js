import BottomBar from "../components/BottomBar";
import HomeCard from "../components/HomeCard";
import HomeTag from "../components/HomeTag";
import "./Home.css";


const Home = () => {

    return (
        <div className="HOME">
            <div className="HOME_CONTENTS">
                <div className="HOME_TITLE">
                    7월 14일
                </div>
                <HomeTag />
                <div className="HOME_POSTS">
                    <HomeCard />
                    <HomeCard />
                    <HomeCard />
                    <HomeCard />
                    <HomeCard />
                    <HomeCard />
                </div>
            </div>
            <BottomBar />
        </div>
    );
};

export default Home;