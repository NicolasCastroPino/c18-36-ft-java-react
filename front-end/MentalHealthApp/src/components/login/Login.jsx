import { useState } from "react"
import { Link } from 'react-router-dom'

import styles from './Login.module.css'

export const Login = () => {
  const [user, setUser] = useState('')

  const catchInputs = (e) => {
    const { name, value } = e.target;
    const newValues = ({ ...user, [name]: value });
    setUser(newValues)
  }

  const logIn = (e) => {
    e.preventDefault();
    console.log(user)
  }

  return (
    <div className={styles.card}>
      <h1>Iniciar Sesion</h1>
      <form className={styles.form}
        onSubmit={logIn}>
        <input className={styles.input}
          placeholder="Nombre de usuario o email"
          type="text"
          name="user"
          onChange={catchInputs} />
        <input className={styles.input}
          placeholder="Contraseña"
          type="password"
          name="password"
          onChange={catchInputs} />
        <span>
          <input type="checkbox" />
          Recordarme
        </span>
        <button className={styles.button}>
          Login
        </button>
      </form>
      <span>
      No tienes cuenta? <Link to="createuser">Registrate</Link>
      </span>
    </div>
  )
}