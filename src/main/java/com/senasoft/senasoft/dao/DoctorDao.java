package com.senasoft.senasoft.dao;

import com.senasoft.senasoft.modelo.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Long> {
    
}
