package com.senasoft.senasoft.dao;

import com.senasoft.senasoft.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteDao extends JpaRepository<Paciente, Long> {
    
}
