
package com.senasoft.senasoft.service;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;


public interface AlmacenamientoService {
    
    public String almacenarArchivo(MultipartFile archivo) throws IOException;
    public String almacenarComoPdf(MultipartFile mpf) throws FileNotFoundException, DocumentException, IOException;
    
}
