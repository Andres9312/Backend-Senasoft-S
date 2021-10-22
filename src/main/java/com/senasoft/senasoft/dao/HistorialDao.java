package com.senasoft.senasoft.dao;

import com.senasoft.senasoft.modelo.Historial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialDao extends JpaRepository<Historial, Long> {
    
    @Query(value = "SELECT * FROM historiales WHERE pacientes_id = ?1", nativeQuery = true)
    public List<Historial> listarPorIdPaciente(Long id);
}
