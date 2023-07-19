import axios from 'axios';

const Edit = () => {
    const signUp = () => {
        axios.post('http://localhost:8080/api/user/signup', {
            email: "temp@test.com",
            userID: "temp123",
            password: "12345",
            username: "홍길동동",
            nickname: "맛도링"
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    const signIn = () => {
        axios.post('http://localhost:8080/api/user/signin', {
            userID: "temp123",
            password: "12345"
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    const checkId = () => {
        axios.get(`http://localhost:8080/api/user/check/temp123`)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    return (
        <div>
            <h1>API TEST2</h1>
            <button onClick={signUp}>Signup</button>
            <button onClick={signIn}>SignIn</button>
            <button onClick={checkId}>CheckID</button>
        </div>
    );
};

export default Edit;