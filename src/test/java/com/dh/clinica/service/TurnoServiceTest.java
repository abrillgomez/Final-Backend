package com.dh.clinica.service;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.Turno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    TurnoService service;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    OdontologoService odontologoService;

    @Test
    public void crearUnTurno () {
        Paciente paciente = new Paciente();
        paciente.setApellido("Pablo");
        paciente.setNombre("Aimar");
        pacienteService.guardar(paciente);

        Odontologo odontologo = new Odontologo();
        odontologo.setApellido("Angel");
        odontologo.setNombre("Correa");
        odontologoService.registrarOdontologo(odontologo);

        Turno turno = new Turno();
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
    }
}