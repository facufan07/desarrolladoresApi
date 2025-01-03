package com.Facundo.AdministracionDevs.service;

import com.Facundo.AdministracionDevs.entity.Desarrollador;
import com.Facundo.AdministracionDevs.repository.IDesarrolladorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesarrolladorService implements IDesarrolladorService {
    @Autowired
    private IDesarrolladorRepository desarrolladorRepository;

    @Override
    public List<Desarrollador> getAll() {
        return this.desarrolladorRepository.findAll();
    }

    @Override
    public Desarrollador findById(Long id) {
        return this.desarrolladorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Desarrollador no encontrado"));
    }

    @Override
    public void save(Desarrollador desarrollador) {
        this.desarrolladorRepository.save(desarrollador);
    }

    @Override
    public void delete(Long id) {
        this.desarrolladorRepository.deleteById(id);
    }

    @Override
    public void update(Desarrollador desarrollador) {
        if(this.desarrolladorRepository.existsById(desarrollador.getId())){
            this.save(desarrollador);
        }else{
            throw new RuntimeException("No se pudo actualizar el desarrollador");
        }
    }
}
