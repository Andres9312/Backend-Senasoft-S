
package com.senasoft.senasoft.service.serviceimpl;

import com.senasoft.senasoft.service.DoctorService;
import java.util.List;
import org.springframework.stereotype.Service;
import com.senasoft.senasoft.dao.DoctorDao;
import com.senasoft.senasoft.modelo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorDao doctorDao;

    @Override
    public List<Doctor> listar() {
      return doctorDao.findAll();
    }

    @Override
    public Doctor buscarPorId(Long id) {
       return doctorDao.findById(id).orElse(null);
    }

    @Override
    public void registrar(Doctor doctor) {
        doctorDao.save(doctor);
    }

    @Override
    public void modificar(Doctor doctor) {
       doctorDao.save(doctor);
    }

    @Override
    public void eliminar(Doctor doctor) {
       doctorDao.delete(doctor);
    }
    
    
}
  
