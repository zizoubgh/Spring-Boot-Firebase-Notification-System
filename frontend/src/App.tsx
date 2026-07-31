import { useEffect } from "react";

import './App.css'
import Navbar from './components/Navbar'
import Home from './pages/Home'

import {
    
    getFCMToken,
    listenNotification
} from "./firebase";
function App() {
 useEffect(()=>{

        getFCMToken();

        listenNotification();

   


},[]);
  return (
    <>

        <>

            <Navbar />

            <Home />

        </>
    </>
  )
}

export default App
