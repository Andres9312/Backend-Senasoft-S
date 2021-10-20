
package com.senasoft.senasoft.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "pacientes")
public class Paciente {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    @Column (name = "id")
    private Long id;
    
    @Column (name = "nombres")
    private String nombre;
    
    @Column (name = "apellidos")
    private String apellidos;
    
    @Column (name = "edad")
    private int edad;
    
    @Column (name = "cedula")
    private String cedula;
    
    @Column (name = "url:imagen")
    private String urlImagen;
    
}
