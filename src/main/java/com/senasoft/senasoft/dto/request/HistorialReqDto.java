package com.senasoft.senasoft.dto.request;

import com.senasoft.senasoft.modelo.Doctor;
import com.senasoft.senasoft.modelo.Paciente;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Data
public class HistorialReqDto {
    
    private MultipartFile historial;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;
    private Long idDoctor;
    private Long idPaciente;
    
}
