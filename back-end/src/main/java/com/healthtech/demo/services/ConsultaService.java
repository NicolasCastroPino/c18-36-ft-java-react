package com.healthtech.demo.services;

import com.healthtech.demo.dto.CrearConsultaDTO;
import com.healthtech.demo.dto.DetallesConsultaDTO;
import com.healthtech.demo.entities.Consulta;
import com.healthtech.demo.entities.Psicologo;
import com.healthtech.demo.filtroConsultas.FiltroDeConsultas;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.repositories.ConsultaRepository;
import com.healthtech.demo.repositories.PacienteRepository;
import com.healthtech.demo.repositories.PsicologoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PsicologoRepository psicologoRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    
    List<FiltroDeConsultas> filtroConsultas;

    public ResponseEntity<DetallesConsultaDTO> Agendar(CrearConsultaDTO datos) {

        //Devuelve un Optional - Trata de recuperar toda la Entidad - Más costoso
        if (!pacienteRepository.findById(datos.idPaciente()).isPresent()) {
            throw new ValidacionDeIntegridad("Este id para el paciente no fue encontrado");
        }
        //Devuelve un True o False - No trata de recuperar toda la Entidad - Menos costoso
        if (datos.idPsicologo() != null && !psicologoRepository.existsById(datos.idPsicologo())) {
            throw new ValidacionDeIntegridad("Este id para el psicologo no fue encontrado");
        }
        
        //Usamos la interfaz FiltroDeConsultas para aplicar de una vez todas las clases de filtrado que implementen su interfaz
        filtroConsultas.forEach(filtrar -> filtrar.filtrarConsulta(datos));
        
        //Traemos al Entidad Paciente con el id en cuestion
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        //Traemos al Entidad Psicologo con el id en cuestion
        var psicologo = psicologoRepository.findById(datos.idPsicologo()).get();

        
        //var psicologo = seleccionarPsicologo(datos);

        if (psicologo == null) {
            throw new ValidacionDeIntegridad("no existen psicologos disponibles para este horario y especialidad");
        }
        
        //Creamos una nueva Entidad Consulta
        var consulta = new Consulta(psicologo, paciente, datos.fecha());

        //Guardamos la nueva Entidad Consulta en la Base de Datos
        consultaRepository.save(consulta);

       return ResponseEntity.ok(new DetallesConsultaDTO(consulta));
    }

    
    //Esto devuelve un psicologo aleatorio, que este disponible para el horario ingresado y que cumpla con la especialidad elegida
//    public Psicologo seleccionarPsicologo(CrearConsultaDTO datos) {
//        if (datos.idPsicologo() != null) {
//            return psicologoRepository.getReferenceById(datos.idPsicologo());
//        }
//        if (datos.especilidad() == null) {
//            throw new ValidacionDeIntegridad("debe seleccionarse una especialidad para el medico");
//        }
//        return psicologoRepository.seleccionarPsciologoConEspecialidadEnFecha(datos.especilidad(), datos.fecha());
//    }
}
