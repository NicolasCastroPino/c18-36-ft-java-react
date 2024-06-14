import { useEffect, useState, useContext } from "react"
import { Link, useNavigate } from 'react-router-dom'
import { Context } from "../../../Context"
import { jwtDecode } from 'jwt-decode'

import brain from "../../assets/brain.png"
import logo from "../../assets/logo.webp"

import styles from './Login.module.css'

export const Login = () => {
  const { login } = useContext(Context); // Obtener la función de login del contexto
  const [user, setUser] = useState({
    usuario: '',
    contrasenia: ''
  });
  const [csrfToken, setcsrfToken] = useState('');
  const navigate = useNavigate();

  //CATCH TOKEN

  useEffect(() => {
    const fetchToken = async () => {
      try {
        const res = await fetch('https://c18-36-ft-java-react.onrender.com/csrf-token', {
          method: 'GET',
          credentials: 'include'
        });

        if (!res.ok) {
          throw new Error('Failed to fetch CSRF token');
        }

        const data = await res.json();
        if (!data || !data.token) {
          throw new Error('Invalid CSRF token response')
        }

        setcsrfToken(data.token);

      } catch (error) {
        console.error('Error al obtener el token CSRF');
      }
    };
    fetchToken();
  }, []);


  const catchInputs = (e) => {
    const { name, value } = e.target;
    setUser(prevState => ({ ...prevState, [name]: value }));
  };

  //LOGIN FUNCIÓN

  const logIn = async (e) => {
    e.preventDefault();
    const userDTO = {
      usuario: user.usuario,
      contrasenia: user.contrasenia
    };

    //TERMINO DE FORMAR EL TOKEN

    try {
      const res = await fetch('https://c18-36-ft-java-react.onrender.com/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'X-XSRF-TOKEN': csrfToken
        },
        credentials: 'include',
        body: JSON.stringify(userDTO)
      });

      const data = await res.json();

      if (!data || !data.jwTtoken) {
        throw new Error('Failed to catch data');
      }

      const token = data.jwTtoken;
      const decodedToken = jwtDecode(token);
      const userId = decodedToken.id;

      console.log('Decoded: ', decodedToken);

      //ACA OBTENGO LOS DATOS DEL PACIENTE/PROFESIONAL

      const URL_PATIENT = `https://c18-36-ft-java-react.onrender.com/paciente/seleccionar/${userId}`;
      // const URL_PSYCHOLOGIST = `https://c18-36-ft-java-react.onrender.com/psicologo/seleccionar/${userId}`;

      const psychologistResponse = await fetch(URL_PATIENT, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        }
      });

      if (!psychologistResponse.ok) {
        throw new Error('Failed to fetch user data')
      }

      // const patientResponse = await fetch(URL_PATIENT, {
      //   method: 'GET',
      //   headers: {
      //     'Content-Type': 'application/json',
      //     'Authorization': `Bearer ${token}`
      //   }
      // });

      // if (!patientResponse.ok) {
      //   throw new Error('Failed to fetch user data')
      // }

      const userData = await psychologistResponse.json();

      console.log(userData);

      login(userData, token);

      if (userData.rol === "PSICOLOGO") {
        navigate("/dashboard/profesional/home");
      } else{
        navigate("/dashboard/paciente")
      }

    } catch (error) {
      console.error('Hubo un error al iniciar sesion: ', error);
    }
  };

  return (
    <>
      <img className={styles.brain} src={brain} alt="cerebro" />

      {/* WAVES */}
      <div className={styles.wave1} />
      <div className={styles.wave2} />
      <div className={styles.wave3} />

      <div className={styles.card}>

        <Link to="/">
          <img className={styles.logo} src={logo} alt="logo" />
        </Link>

        <h1>Iniciar Sesion</h1>
        <form className={styles.form} onSubmit={logIn}>
          <input
            className={styles.input}
            placeholder="Usuario o correo electronico"
            type="text"
            name="usuario"
            onChange={catchInputs}
          />
          <input
            className={styles.input}
            placeholder="Contraseña"
            type="password"
            name="contrasenia"
            onChange={catchInputs}
          />
          <div className={styles.checkbox_container}>
            <input type="checkbox" />
            <span>Recordarme</span>
          </div>
          <button className={styles.button}>
            Ingresar
          </button>
        </form>
        <span>
          No tienes cuenta? <Link className={styles.link} to="/signup">Registrate</Link>
        </span>
      </div>
    </>
  );
};