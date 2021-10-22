package com.senasoft.senasoft.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

public class BASE64DecodedMultipartFile implements MultipartFile {

    private final byte[] imgContent;

    public BASE64DecodedMultipartFile(byte[] imgContent) {
        this.imgContent = imgContent;
    }

    @Override
    public String getName() {
        // TODO - implementation depends on your requirements 
        return "firma.jpg";
    }

    @Override
    public String getOriginalFilename() {
        // TODO - implementation depends on your requirements
        return "firma.jpg";
    }

    @Override
    public String getContentType() {
        // TODO - implementation depends on your requirements
        return MediaType.IMAGE_JPEG_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }

    @Override
    public Resource getResource() {
        return MultipartFile.super.getResource(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transferTo(Path dest) throws IOException, IllegalStateException {
        MultipartFile.super.transferTo(dest); //To change body of generated methods, choose Tools | Templates.
    }

}
