import { useState } from "react"
import { Link } from 'react-router-dom'

import brain from "../../assets/brain.png"

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
    <>
      <img className={styles.brain}
        src={brain}
        alt="cerebro" />
      <div className={styles.card}>
        <h1>Iniciar Sesion</h1>
        <form className={styles.form}
          onSubmit={logIn}>
          <input className={styles.input}
            placeholder="Usuario o correo electronico"
            type="text"
            name="user"
            onChange={catchInputs} />
          <input className={styles.input}
            placeholder="Contraseña"
            type="password"
            name="password"
            onChange={catchInputs} />
          <div className={styles.checkbox_container}>
            <input type="checkbox" />
            <span>Recordarme</span>
          </div>
          <button className={styles.button}>
            Ingresar
          </button>
        </form>
        <span>
          No tienes cuenta? <Link className={styles.link} to="createuser">Registrate</Link>
        </span>
      </div>
    </>

  )
}