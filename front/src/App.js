import './App.css';
import Start from './pages/Start';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Home from './pages/Home';
import My from './pages/My';
import Posts from './pages/Posts';
import Edit from './pages/Edit';
import Dictionary from './pages/Dictionary';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Start />} />
        <Route path='/login' element={<Login />} />
        <Route path='/signup' element={<Signup />} />
        <Route path='/home' element={<Home />} />
        <Route path='/my' element={<My />} />
        <Route path='/posts' element={<Posts />} />
        <Route path='/edit' element={<Edit />} />
        <Route path='/dictionary' element={<Dictionary />} />
      </Routes>
    </div>
  );
}

export default App;
