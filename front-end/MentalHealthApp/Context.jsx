import React, {createContext, useState} from "react";

export const Context = createContext();

export const CustomeProvider = ({children}) => {

  const professional = {
    id: 0,
    nombre: "Marta",
    apellido: "Rodriguez",
    email: "martarodriguez@gmail.com",
    telefono: "27272727",
    documento: "9999999",
    valoracion: 3,
    especialidad: "PSICOLOGIA CLINICA"
  };

  const patient = {
    id: 0,
    nombre: "Juan",
    apellido: "Perez",
    email: "juanperez@gmail.com",
    telefono: 10101010,
    documento: 9999999
  }

  return(
    <Context.Provider value={{professional, patient}}>
      {children}
    </Context.Provider>
  )
}