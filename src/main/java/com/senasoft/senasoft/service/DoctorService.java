
package com.senasoft.senasoft.service;

import com.senasoft.senasoft.modelo.Doctor;
import java.util.List;



public interface DoctorService {
    public List<Doctor> listar();
    public Doctor buscarPorId(Long id);
    public void registrar(Doctor doctor);
    public void modificar(Doctor doctor);
    public void eliminar(Doctor doctor);
    public Doctor buscarPorCedula(String cedula);
}
