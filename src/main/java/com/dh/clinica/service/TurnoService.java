package com.dh.clinica.service;

import com.dh.clinica.model.Turno;
import com.dh.clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
    public List<Turno> listar(){
        return turnoRepository.findAll();
    }
    public void eliminar(Long id){
        turnoRepository.deleteById(id);
    }
    public Turno actualizar(Turno turno){
        return turnoRepository.save(turno);
    }
    public Optional<Turno> buscar(Long id){
        return Optional.of(turnoRepository.findById(id).get());
    }

}
