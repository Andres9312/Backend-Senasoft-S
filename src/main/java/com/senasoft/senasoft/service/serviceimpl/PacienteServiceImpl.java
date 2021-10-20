
package com.senasoft.senasoft.service.serviceimpl;

import com.senasoft.senasoft.dao.PacienteDao;
import com.senasoft.senasoft.modelo.Paciente;
import com.senasoft.senasoft.service.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService{

    
    @Autowired
    PacienteDao pacienteDao;
    
    @Override
    public List<Paciente> listar() {
      return pacienteDao.findAll();
    }
    
}
