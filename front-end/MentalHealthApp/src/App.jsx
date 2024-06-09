import { Home } from "./components/Home"
import { Login } from "./components/login/Login"
import { CreateUser } from "./components/createuser/CreateUser"
import { HomePaciente } from "./components/dashboard/paciente/HomePaciente";
import { HomeProfesional } from "./components/dashboard/profesional/Home/HomeProfesional";

import { CustomeProvider } from "../Context";
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <BrowserRouter>
      <CustomeProvider>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/signup" element={<CreateUser />} />
          <Route path="/login" element={<Login />} />
          <Route path="/dashboard/profesional" element={<HomeProfesional />} />
          <Route path="/dashboard/paciente" element={<HomePaciente />} />
        </Routes>
      </CustomeProvider>
    </BrowserRouter>
  )
}

export default App
