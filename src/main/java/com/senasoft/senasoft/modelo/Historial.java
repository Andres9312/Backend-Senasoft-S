package com.senasoft.senasoft.modelo;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "historiales")
public class Historial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "fecha")
    private LocalDate fecha;
    
    @ManyToOne
    @JoinColumn (name = "doctores_id")
    private Doctor doctor;
    
    @ManyToOne
    @JoinColumn (name = "pacientes_id")
    private Paciente paciente;
    
}

