package com.cletus.facturacion.service.impl;

import com.cletus.facturacion.service.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final static String UPLOADS_FOLDER = "uploads";


    @Override
    public Resource load(String filename) throws MalformedURLException {
        Resource recurso = new UrlResource(getPath(filename).toUri());
        if(!recurso.exists() || !recurso.isReadable()){
            throw new RuntimeException("Error: no sepuede cargar la imagen: " + getPath(filename).toString());
        }
        return recurso;
    }

    @Override
    public String copy(MultipartFile multipartFile) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString() +"_" + multipartFile.getOriginalFilename();
        Path rootAbsolutPath =  getPath(uniqueFilename);
        //byte[] bytes = multipartFile.getBytes();
        //Path rutaCompleta = Paths.get(rootPath + "//" + multipartFile.getOriginalFilename());
        //Files.write(rutaCompleta,bytes);
        Files.copy(multipartFile.getInputStream(), rootAbsolutPath);

        return uniqueFilename;
    }

    @Override
    public boolean delete(String filename) {

        File archivo = getPath(filename).toFile();
        if(archivo.exists() && archivo.canRead()){
            return archivo.delete();
        }
        return false;
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());
    }

    @Override
    public void init() throws IOException {
        Files.createDirectory(Paths.get(UPLOADS_FOLDER));
    }

    public Path getPath(String filename){
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }
}
