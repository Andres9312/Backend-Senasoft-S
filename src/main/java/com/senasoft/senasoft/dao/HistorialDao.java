package com.senasoft.senasoft.dao;

import com.senasoft.senasoft.modelo.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialDao extends JpaRepository<Historial, Long> {
    
}
