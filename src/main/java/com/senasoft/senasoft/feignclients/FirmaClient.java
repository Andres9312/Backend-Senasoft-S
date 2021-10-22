package com.senasoft.senasoft.feignclients;

import com.senasoft.senasoft.dto.response.ValidacionFormularioResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "imagen", url = "http://localhost/Almacenamiento")
public interface FirmaClient {

    @GetMapping("/{nombreImagen}")
    public byte[] descargarFirma(@PathVariable String nombreImagen);

}
