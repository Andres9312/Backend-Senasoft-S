package com.senasoft.senasoft.feignclients;

import com.senasoft.senasoft.dto.request.ValidacionFormularioReqDto;
import com.senasoft.senasoft.dto.response.ValidacionFormularioResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "validacion", url = "http://localhost:5000")
public interface ValidacionClient {

    @PostMapping(value = "/validate-form", consumes = "multipart/form-data")
    public ValidacionFormularioResDto validarFormulario(
            @RequestPart("formulario") MultipartFile formulario,
            @RequestPart("firma") MultipartFile firma);

}
