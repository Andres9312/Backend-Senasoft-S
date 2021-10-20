
package com.senasoft.senasoft.controller;

import com.senasoft.senasoft.modelo.Historial;
import com.senasoft.senasoft.service.HistorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HistorialController {
    
    @Autowired
    HistorialService historialService;
    
    @GetMapping("/listar")
    public List<Historial> listar(){
       return historialService.listar();
     }
    
    @GetMapping("/id/{id}")
    public Historial buscarPorId(@PathVariable Long id){
        return historialService.buscarPorId(id);
    }
    
    @PostMapping("/registrar")
    public void registrar(Historial historial){
        historialService.registrar(historial);
    }
    
    @PutMapping("/modificar")
    public void modificar(Historial historial){
        historialService.modificar(historial);
    }
    
    @DeleteMapping("/eliminar")
    public void eliminar(Historial historial){
        historialService.eliminar(historial);
    }
        
    

    
    
}
