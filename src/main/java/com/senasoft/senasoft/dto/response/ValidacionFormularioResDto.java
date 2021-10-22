package com.senasoft.senasoft.dto.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class ValidacionFormularioResDto implements Serializable {

    private String firma;
    private String tinta;
    private String campos;

}
