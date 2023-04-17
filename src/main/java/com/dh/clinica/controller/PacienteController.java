package com.dh.clinica.controller;

import com.dh.clinica.exception.PacienteSinDomicilioException;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        if (paciente.getDomicilio() == null) {
            try {
                throw new PacienteSinDomicilioException("Hace falta un domicilio, por favor ingreselo.");
            } catch (PacienteSinDomicilioException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscar(id).orElse(null);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;
        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (pacienteService.buscar(id).isPresent()) {
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
}
