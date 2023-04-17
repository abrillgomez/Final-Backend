package com.dh.clinica.service;

import com.dh.clinica.model.Paciente;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;

    public void cargarDataSet() {
        pacienteService.guardar(new Paciente("Abril", "Gomez", "12345678"));
    }

    @Test
    public void agregarYBuscarPacienteTest() {
        Paciente paciente = pacienteService.guardar(new Paciente("Lautaro", "Leguizamon", "9101112"));
        Assert.assertTrue(paciente.getId() != null);
    }

    @Test
    public void eliminarUnPaciente(){
        cargarDataSet();
        pacienteService.eliminar(1L);
    }
    @Test
    public void BuscarUnPaciente(){
        cargarDataSet();
        pacienteService.buscar(1L);
    }
}