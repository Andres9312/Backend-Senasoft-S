
package com.senasoft.senasoft.controller;

import com.itextpdf.text.DocumentException;
import com.senasoft.senasoft.dto.request.HistorialReqDto;
import com.senasoft.senasoft.modelo.Doctor;
import com.senasoft.senasoft.modelo.Historial;
import com.senasoft.senasoft.modelo.Paciente;
import com.senasoft.senasoft.service.AlmacenamientoService;
import com.senasoft.senasoft.service.HistorialService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HistorialController {
    
    @Autowired
    HistorialService historialService;
    
    @Autowired
    AlmacenamientoService almacenamientoService;
    
    @GetMapping("/listar")
    public List<Historial> listar(){
       return historialService.listar();
     }
    
    @GetMapping("/id/{id}")
    public Historial buscarPorId(@PathVariable Long id){
        return historialService.buscarPorId(id);
    }
    
    @PostMapping("/registrar")
    public void registrar(@ModelAttribute HistorialReqDto historialDto) throws IOException, FileNotFoundException, DocumentException{
        
        Historial historial = new Historial();
        
        Long doctorId = historialDto.getIdDoctor();
        Long pacienteId = historialDto.getIdPaciente();
        
        Doctor doctor = new Doctor();
        doctor.setId(doctorId);
        
        Paciente paciente = new Paciente();
        paciente.setId(pacienteId);
                
        historial.setDoctor(doctor);
        historial.setPaciente(paciente);
        
        historial.setFecha(historialDto.getFecha());
        
        String url = almacenamientoService.almacenarComoPdf(historialDto.getHistorial());
        
        historial.setUrlHistorial(url);
        historialService.registrar(historial);
    }
    
    @PutMapping("/modificar")
    public void modificar(@RequestBody Historial historial){
        historialService.modificar(historial);
    }
    
    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody Historial historial){
        historialService.eliminar(historial);
    }
    
    
}
