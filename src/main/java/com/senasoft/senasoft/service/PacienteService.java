
package com.senasoft.senasoft.service;

import com.senasoft.senasoft.modelo.Paciente;
import java.util.List;


public interface PacienteService {
    public List<Paciente> listar();
    public Paciente buscarPorId(Long id);
    public void registrar(Paciente paciente);
    public void modificar(Paciente paciente);
    public void eliminar(Paciente paciente);
    
}
