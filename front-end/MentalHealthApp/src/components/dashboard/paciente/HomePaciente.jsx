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
          <DailyEmotions></DailyEmotions>
        </div>
       
        <h1>hola paciente</h1>
      </div>
    </div>
  );
};

export default HomePaciente;



// import React from 'react';
// import Sidebar from '../sidebar/Sidebar';
// import './HomePaciente.css';
// import DataPaciente from "./dataPaciente/DataPaciente"

// const HomePaciente = () => {
//   return (
//     <div className="dashboard-paciente">
//       <Sidebar></Sidebar>
//       <div className='data-paciente'>
//       <DataPaciente></DataPaciente>
//       </div>
//       <hr className="divider" />
      
//       <h1>hola paciente</h1>

//     </div>
//   );
// };

// export default HomePaciente;