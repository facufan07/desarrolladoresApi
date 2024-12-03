package com.Facundo.AdministracionDevs.service;

import com.Facundo.AdministracionDevs.entity.Desarrollador;

import java.util.List;

public interface IDesarrolladorService {
    public List<Desarrollador> getAll();

    public Desarrollador findById(Long id);

    public void save(Desarrollador desarrollador);

    public void delete(Long id);

    public void update(Desarrollador desarrollador);
}
