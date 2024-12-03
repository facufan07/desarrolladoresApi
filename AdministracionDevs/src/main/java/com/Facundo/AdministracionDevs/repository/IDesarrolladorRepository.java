package com.Facundo.AdministracionDevs.repository;

import com.Facundo.AdministracionDevs.entity.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDesarrolladorRepository extends JpaRepository<Desarrollador, Long> {
}
