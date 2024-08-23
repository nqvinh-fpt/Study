
import './App.css';
import Header from './Header';
import Home from './Home';
import Foot from './Foot';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Products from './Products';
import Login from './Login';

function App() {
  return (
    <>
   

<Router>

<Routes>
  <Route path='/' element={<><Header/><Home/><Products/></>}/>
  <Route path='/login' element={<Login/>}/>
</Routes>
<Foot/>
</Router>
    </>
    
    
  );
}

export default App;
