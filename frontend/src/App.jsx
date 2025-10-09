import { Link, Route, Routes } from "react-router-dom";
import SingUp from "./pages/singUp";
import Activation from "./pages/activation/Index.jsx";

import LanguageSelector from "./shared/components/LanguageSelector";
import Home from "./pages/home";
import NavBar from "./shared/components/NavBar.jsx";


function App() {
  return (
    <>
      <NavBar/>
      <div className="container mt-3">
        <Routes>
          <Route path="*" element={<Home />} />
        <Route path="/activation/:token" element={<Activation />} />
        <Route path="/singup" element={<SingUp />} />
      </Routes>
      </div>
       <LanguageSelector />
      
    </>
  );
}

export default App;
