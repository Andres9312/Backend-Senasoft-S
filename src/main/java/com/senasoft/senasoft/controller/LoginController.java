package com.senasoft.senasoft.controller;

import com.senasoft.senasoft.modelo.Doctor;
import com.senasoft.senasoft.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LoginController {
    
    @Autowired
    DoctorService doctorService;
    
    @PostMapping("/login")
    public ResponseEntity<Doctor> login (@RequestBody Doctor doctor){
      Doctor doctorLogin = doctorService.buscarPorCedula(doctor.getCedula());
      if(doctorLogin == null){
          return new ResponseEntity(HttpStatus.FORBIDDEN);
      }
      if(doctorLogin.getClave().equals(doctor.getClave())){
          return ResponseEntity.ok(doctorLogin);
      }
      return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
    
    @PostMapping("/cedula")
    public Doctor buscarPorCedula(@RequestBody Doctor doctor){
        return doctorService.buscarPorCedula(doctor.getCedula());
    }
    
    
    
}
