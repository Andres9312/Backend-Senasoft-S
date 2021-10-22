package com.senasoft.senasoft.service;

import com.senasoft.senasoft.modelo.Historial;
import java.util.List;

public interface HistorialService {

    public List<Historial> listar();

    public Historial buscarPorId(Long id);

    public void registrar(Historial historial);

    public void modificar(Historial historial);

    public void eliminar(Historial historial);

    public List<Historial> listarPorIdPaciente(Long id);

}
