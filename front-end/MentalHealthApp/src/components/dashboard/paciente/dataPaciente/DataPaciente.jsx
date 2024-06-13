import React from 'react';
import "./DataPaciente.css"
import { FaUserCircle } from 'react-icons/fa';

const HomePaciente = () => {
  return (
    <div className="data-card">
      <div className="pic-paciente">
        <FaUserCircle size={100} color="#1d4738" /> 
      </div>
      <div className="info">
        <h2 className='name-paciente'>Juan Perez</h2>
        <p><strong>Edad:</strong> 26 años</p>
        <p><strong>Ubicación:</strong> Bs As, Argentina</p>
        <p><strong>Terapia:</strong> cognitivo-conductual</p>
        <p><strong>Atendido por:</strong> María Marta Gomez</p>
        <hr className="divider" />
      </div>

    </div>
  );
};

export default HomePaciente;