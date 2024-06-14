import React from 'react';
import { Link } from 'react-router-dom';
import styles from "./Sidebar.module.css"
// import logo from "./Logo.svg"

const Sidebar = () => {
  return (
    <div className={styles.sidebar}>
      <div className={styles.logo}>
        {/* <img src={logo} alt="VitalMind Logo" /> */}
      </div>
      <nav className={styles.menu}>
        <ul>
          <li>
            <Link>Home</Link>
          </li>
          <li>
            <Link>Agendar Consulta</Link>
          </li>
          <li>
            <Link>Material de Apoyo</Link>
          </li>
        </ul>
      </nav>
      <div className={styles.logout}>
        <button className={styles.button_logout} onClick={() => { /* handle logout */ }}>Log out</button>
      </div>
    </div>
  );
}

export default Sidebar;
