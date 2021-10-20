
package com.senasoft.senasoft.controller;

import com.senasoft.senasoft.modelo.Doctor;
import com.senasoft.senasoft.service.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    
    
}
