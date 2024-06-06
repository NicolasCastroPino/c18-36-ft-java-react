import { Home } from "./components/Home"
import { Login } from "./components/login/Login"
import { CreateUser } from "./components/createuser/CreateUser"
import { Dashboard } from "./components/dashboard/Dashboard"

import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signup" element={<CreateUser />} />
        <Route path="/login" element={<Login />} />
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
