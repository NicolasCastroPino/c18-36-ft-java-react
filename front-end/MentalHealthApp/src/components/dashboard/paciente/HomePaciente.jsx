import React from 'react';
import Sidebar from '../sidebar/Sidebar';
import './HomePaciente.css';
import DataPaciente from './dataPaciente/DataPaciente';
import DailyEmotions from './dailyEmotions/DailyEmotions';

const HomePaciente = () => {
  return (
    <div className="dashboard-paciente">
      <Sidebar />
      <div className="content">
        <div className="data-paciente">
          <DataPaciente />
        </div>
        <div className='daily-part'>
          <DailyEmotions />
        </div>
        <h1>hola paciente</h1>
      </div>
    </div>
  );
};

export default HomePaciente;
