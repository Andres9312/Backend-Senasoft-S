package com.senasoft.senasoft.service.serviceimpl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.senasoft.senasoft.service.AlmacenamientoService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AlmacenamientoServiceImpl implements AlmacenamientoService {

    static final String ABSOLUTE_STORAGE = "C:/xampp/htdocs/Almacenamiento/";
    static final String LOCALHOST_STORAGE = "http://localhost/Almacenamiento/";
    static final String TEMP_FILE = "src/main/resources/targetFile.jpg";

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    @Override
    public String almacenarArchivo(MultipartFile archivo) throws IOException {
        String nombreArchivo = randomString(20) + archivo.getOriginalFilename();
        archivo.transferTo(new File(ABSOLUTE_STORAGE + nombreArchivo));

        return LOCALHOST_STORAGE + nombreArchivo;
    }

    @Override
    public String almacenarComoPdf(MultipartFile mpf) throws FileNotFoundException, DocumentException, IOException {
        File file = new File(TEMP_FILE);

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(mpf.getBytes());
        }

        File root = new File(ABSOLUTE_STORAGE);
        String outputFile = randomString(20) + ".pdf";

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File(root, outputFile)));
        document.open();

        document.newPage();
        Image image = Image.getInstance(TEMP_FILE);
        image.setAbsolutePosition(0, 0);
        image.setBorderWidth(0);
        image.scaleAbsolute(PageSize.A4);
        document.add(image);

        document.close();

        return LOCALHOST_STORAGE + outputFile;
    }

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

}
