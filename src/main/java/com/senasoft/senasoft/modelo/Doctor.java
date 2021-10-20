
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
@Table (name = "Doctores")
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    
    @Column (name = "nombres")
    private String nombres;
    
    @Column (name = "apellidos")
    private String apellidos;
    
    @Column (name = "cedula")
    private String cedula;
    
    @Column (name = "clave")
    private String clave;
    
    @Column (name = "url_firma")
    private String urlFirma;
    
    @Column (name = "url_imagen")
    private String urlImagen;

    
}
