
package com.senasoft.senasoft.controller;

import com.senasoft.senasoft.modelo.Doctor;
import com.senasoft.senasoft.service.DoctorService;
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
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DoctorController {
    
    @Autowired
    DoctorService doctorService;
    
    
    @GetMapping("/listar")
    public List<Doctor> listar(){
        return doctorService.listar();
     }
    
    @GetMapping("/id/{id}")
    public Doctor buscarPorId(@PathVariable Long id){
        return doctorService.buscarPorId(id);
    }
    
    @PostMapping("/registrar")
    public void registrar(@RequestBody Doctor doctor){
        doctorService.registrar(doctor);
    }
    
    @PutMapping("modificar")
    public void modificar(@RequestBody Doctor doctor){
        doctorService.modificar(doctor);
    }
    
    @DeleteMapping("/elimianr")
    public void elimianr(@RequestBody Doctor doctor){
       doctorService.eliminar(doctor);
    }
    
    
    
}
