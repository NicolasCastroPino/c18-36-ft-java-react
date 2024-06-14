import { Home } from "./components/Home"
import { Login } from "./components/login/Login"
import { CreateUser } from "./components/createuser/CreateUser"
import { HomeProfesional } from "./components/dashboard/profesional/HomeProfesional"
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import HomePaciente from "./components/dashboard/paciente/HomePaciente"
import Consulta from "./components/dashboard/paciente/consulta/Consulta"


function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signup" element={<CreateUser />} />
        <Route path="/login" element={<Login />} />
        <Route path="/dashboard/profesional" element={<HomeProfesional />} />
       
        <Route path="/dashboard/paciente" element={<HomePaciente />} />
        <Route path="/dashboard/paciente/consulta" element={<Consulta />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
