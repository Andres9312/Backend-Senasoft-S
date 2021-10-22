
package com.senasoft.senasoft.dto.request;

import java.io.Serializable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ValidacionFormularioReqDto implements Serializable {
    
    private MultipartFile formulario;
    private MultipartFile firma;
    
}
