import { Home } from "./components/Home"
import { Login } from "./components/login/Login"
import { CreateUser } from "./components/createuser/CreateUser"
import { HomeProfesional } from "./components/dashboard/profesional/Home"
import { HomePaciente } from "./components/dashboard/paciente/home"

import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signup" element={<CreateUser />} />
        <Route path="/login" element={<Login />} />
        <Route path="/dashboard/profesional" element={<HomeProfesional />} />
        <Route path="/dashboard/paciente" element={<HomePaciente />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
