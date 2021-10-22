package com.senasoft.senasoft.controller;

import com.itextpdf.text.DocumentException;
import com.senasoft.senasoft.dto.request.HistorialReqDto;
import com.senasoft.senasoft.dto.request.ValidacionFormularioReqDto;
import com.senasoft.senasoft.dto.response.ValidacionFormularioResDto;
import com.senasoft.senasoft.modelo.Doctor;
import com.senasoft.senasoft.modelo.Historial;
import com.senasoft.senasoft.modelo.Paciente;
import com.senasoft.senasoft.service.AlmacenamientoService;
import com.senasoft.senasoft.service.HistorialService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;
import com.senasoft.senasoft.feignclients.FirmaClient;
import com.senasoft.senasoft.service.DoctorService;
import com.senasoft.senasoft.service.PacienteService;
import com.senasoft.senasoft.feignclients.ValidacionClient;
import com.senasoft.senasoft.utils.BASE64DecodedMultipartFile;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HistorialController {
    
    @Autowired
    HistorialService historialService;
    
    @Autowired
    AlmacenamientoService almacenamientoService;
    
    @Autowired
    DoctorService doctorService;
    
    @Autowired
    PacienteService pacienteService;
    
    @Autowired
    ValidacionClient validacionClient;
    
    @Autowired
    FirmaClient imagenClient;
    
    @GetMapping("/listar")
    public List<Historial> listar() {
        return historialService.listar();
    }
    
    @GetMapping("/paciente/{id}")
    public List<Historial> listarPorPacienteId(@PathVariable Long id) {
        return historialService.listarPorIdPaciente(id);
    }
    
    @GetMapping("/id/{id}")
    public Historial buscarPorId(@PathVariable Long id) {
        return historialService.buscarPorId(id);
    }
    
    @PostMapping("/registrar")
    public ResponseEntity registrar(@ModelAttribute HistorialReqDto historialDto) throws IOException, FileNotFoundException, DocumentException {

        //Historial que será almacenado
        Historial historial = new Historial();
        
        Long doctorId = historialDto.getIdDoctor();
        Long pacienteId = historialDto.getIdPaciente();

        //Doctor y paciente
        Doctor doctor = doctorService.buscarPorId(doctorId);
        Paciente paciente = pacienteService.buscarPorId(pacienteId);

        //Imagen que contiene la firma del doctor
        byte[] firma = imagenClient.descargarFirma(doctor.getUrlFirma());
        MultipartFile mpFirma = new BASE64DecodedMultipartFile(firma);

        //Validación de formulario
        ValidacionFormularioResDto validacion = validacionClient.validarFormulario(historialDto.getHistorial(), mpFirma);
        
        String valFirma = validacion.getFirma();
        String valCampos = validacion.getCampos();
        String valTinta = validacion.getTinta();
        
        if (!valFirma.equals("similar") || !valCampos.equals("completos") || !valTinta.equals("negra")) {
            return new ResponseEntity(validacion, HttpStatus.CONFLICT);
        }
        
        historial.setDoctor(doctor);
        historial.setPaciente(paciente);
        historial.setFecha(historialDto.getFecha());
        
        String url = almacenamientoService.almacenarComoPdf(historialDto.getHistorial());
        historial.setUrlHistorial(url);
        
        historialService.registrar(historial);
        
        return ResponseEntity.ok(historial);
    }
    
    @PutMapping("/modificar")
    public void modificar(@RequestBody Historial historial) {
        historialService.modificar(historial);
    }
    
    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody Historial historial) {
        historialService.eliminar(historial);
    }
    
    @PostMapping("/validar-formulario")
    public ValidacionFormularioResDto validarFormulario(@ModelAttribute ValidacionFormularioReqDto validacionFormularioReqDto) {
        return validacionClient.validarFormulario(validacionFormularioReqDto.getFormulario(), validacionFormularioReqDto.getFirma());
    }
    
    @GetMapping("/imagen/{nombreImagen}")
    public ResponseEntity descargarImagen(@PathVariable String nombreImagen) {
        
        byte[] imagen = imagenClient.descargarFirma(nombreImagen);
        return ResponseEntity
                .ok()
                .contentLength(imagen.length)
                .contentType(MediaType.IMAGE_JPEG)
                .body(imagen);
    }
    
    @PostMapping("/cargar-firma")
    public ResponseEntity cargarFirma(@ModelAttribute("firma") MultipartFile firma) throws IOException {
        almacenamientoService.almacenarArchivo(firma);
        return ResponseEntity.ok().body("Firma cargada");
    }
    
}
