import { useState } from 'react'

import { Link } from 'react-router-dom'

import brain from "../../assets/brain.png"
import logo from "../../assets/logo.webp"

import styles from './CreateUser.module.css'

export const CreateUser = () => {

  const [newUser, setNewUser] = useState({
    name: '',
    lastname: '',
    email: '',
    phone: '',
    DNI: '',
    user: {
      username: '',
      password: ''
    }
  })


  const catchInputs = (e) => {
    const { name, value } = e.target;
    const newUser = ({ ...user, [name]: value })
    setUser(newUser)
  }

  return (
    <>
      <img className={styles.brain}
        src={brain}
        alt="cerebro" />

      {/* WAVES */}
      <div className={styles.wave1} />
      <div className={styles.wave2} />
      <div className={styles.wave3} />

      <div className={styles.card}>

        <Link to="/">
          <img className={styles.logo}
            src={logo}
            alt="logo" />
        </Link>

        <h1>Crear una cuenta</h1>
        <form className={styles.form}>
          <div className={styles.input_container}>
            <input className={styles.input}
              placeholder="Nombre"
              type="text"
              name="username"
              onChange={catchInputs} />
            <input className={styles.input}
              placeholder="Apellido"
              type="text"
              name="username"
              onChange={catchInputs} />
            <input className={styles.input}
              placeholder="E-mail"
              type="email"
              name="email"
              onChange={catchInputs} />
            <input className={styles.input}
              placeholder="DNI"
              type="text"
              name="DNI"
              onChange={catchInputs} />
          </div>
          <h1>Nuevo usuario</h1>
          <div className={styles.input_container}>
            <input className={styles.input}
              placeholder="Nombre de usuario"
              type="text"
              name="username"
              onChange={catchInputs} />
            <input className={styles.input}
              placeholder="Contraseña"
              type="password"
              name="password"
              onChange={catchInputs} />
          </div>
          <button className={styles.button}>
            Crear
          </button>
        </form>
        <span>
          Ya tienes cuenta? <Link className={styles.link} to="/login">Ingresa</Link>
        </span>
      </div>
    </>

  )
}