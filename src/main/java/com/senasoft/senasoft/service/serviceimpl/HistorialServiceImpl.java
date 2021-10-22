
package com.senasoft.senasoft.service.serviceimpl;

import com.senasoft.senasoft.dao.HistorialDao;
import com.senasoft.senasoft.modelo.Historial;
import com.senasoft.senasoft.service.HistorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    HistorialDao historialDao;
    
    @Override
    public List<Historial> listar() {
       return historialDao.findAll();
    }

    @Override
    public Historial buscarPorId(Long id) {
        return historialDao.findById(id).orElse(null);
    }

    @Override
    public void registrar(Historial historial) {
       historialDao.save(historial);
    }

    @Override
    public void modificar(Historial historial) {
      historialDao.save(historial);
    }

    @Override
    public void eliminar(Historial historial) {
       historialDao.delete(historial);
    }

    @Override
    public List<Historial> listarPorIdPaciente(Long id) {
        return historialDao.listarPorIdPaciente(id);
    }
    
}
