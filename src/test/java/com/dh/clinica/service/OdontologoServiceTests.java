package com.dh.clinica.service;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.service.OdontologoService;
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
public class OdontologoServiceTests {
    @Autowired
    private OdontologoService odontologoService;

    public void cargarDataSet() {
        this.odontologoService.registrarOdontologo(new Odontologo("Lionel", "Messi", 10));
    }

    @Test
    public void agregarOdontologo() {
        Odontologo odontologo = odontologoService.registrarOdontologo(new Odontologo("Dibu", "Martinez", 23));
        Assert.assertTrue(odontologo.getId() != null);
    }

    @Test
    public void BuscarUnOdontologo(){
        cargarDataSet();
        odontologoService.buscar(1L);
    }

    @Test
    public void eliminarUnOdontologo(){
        cargarDataSet();
        odontologoService.eliminar(1L);
    }
}