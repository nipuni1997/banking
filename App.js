import React from 'react';
import './App.css';
import Home from './pages/Banktable';
import Persontable from './pages/Persontable';
import AddPerson from './pages/Addperson';
import AddBank from './pages/Addbank';
import {BrowserRouter as Router ,Switch ,Route} from "react-router-dom";
function App() {
  return (
    <Router>
<Switch>
  <Route path='/' exact component={Home}/>
<Route path='/Persontable' component={Persontable}/>
<Route path='/AddPerson' component={AddPerson}/>
<Route path='/AddBank' component={AddBank}/>





</Switch>
   </Router>


  );
}

export default App;
