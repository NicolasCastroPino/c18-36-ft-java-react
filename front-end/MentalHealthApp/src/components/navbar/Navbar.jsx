import React from 'react'

import { Link } from 'react-router-dom'

import logo from '../../assets/logo.webp'

import styles from './Navbar.module.css'

const Navbar = () => {
  return (
      <header className={styles.container}>
        <img className={styles.logo} 
        src={logo} alt="sadj" />
        <div className={styles.button_container}>
          <button className={styles.button_transparent}>
            Ingresar
            <Link to={'/login'}/>
          </button>
          <button className={styles.button}>
            Registrarme
            <Link to={'/signup'}/>
          </button>
        </div>
      </header>
  )
}

export default Navbar;