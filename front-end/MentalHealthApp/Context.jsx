import React, {createContext, useState} from "react";
import { useEffect } from "react";

export const Context = createContext();

export const CustomeProvider = ({children}) => {

  const [authState, setAuthState] = useState({
    userId: null,
    token: null,
    isAuthenticated: false,
  });

  // Recuperar el token y los datos del usuario del almacenamiento local cuando el componente se monta
  useEffect(() => {
    const token = localStorage.getItem('jwtToken');
    const userId = JSON.parse(localStorage.getItem('user'));
    if (token && userId) {
      setAuthState({ userId, token, isAuthenticated: true });
    }
  }, []);

  const login = (userId, token) => {
    localStorage.setItem('jwtToken', token);
    localStorage.setItem('userId', JSON.stringify(userId));
    setAuthState({ userId, token, isAuthenticated: true });
  };

  const logout = () => {
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('userId');
    setAuthState({ user: null, token: null, isAuthenticated: false });
  };

  return(
    <Context.Provider value={{authState, login, logout}}>
      {children}
    </Context.Provider>
  )
}