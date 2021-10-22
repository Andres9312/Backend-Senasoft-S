
package com.senasoft.senasoft.controller;

import com.senasoft.senasoft.modelo.Paciente;
import com.senasoft.senasoft.service.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paciente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PacienteController {
    
    @Autowired
    PacienteService pacienteService;
    
    @GetMapping("/listar")
    public List<Paciente> listar(){
        return pacienteService.listar();
     }
    
    @GetMapping("/id/{id}")
    public Paciente buscarPorId(@PathVariable Long id){
       return pacienteService.buscarPorId(id);
    }
    
    @PostMapping("/registrar")
    public void registrar(@RequestBody Paciente paciente){
        pacienteService.registrar(paciente);
    }
    
    @PutMapping("/modificar")
    public void modificar(@RequestBody Paciente paciente){
        pacienteService.modificar(paciente);
    }
    
    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody Paciente paciente){
        pacienteService.eliminar(paciente);
    }
    
}
