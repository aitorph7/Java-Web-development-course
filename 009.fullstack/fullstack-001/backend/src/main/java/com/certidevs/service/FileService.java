package com.certidevs.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class FileService {
    public String store(MultipartFile file) {

        /* OPCIONAL (...pero recomendable):
         Generar un nombre único para el archivo de imagen y evitar errores por
         duplicidad en el nombre (2 personas pueden subir un archivo con el
          mismo nombre, P. ej. 'avatar.jpg').
        */
        String originalFileName = file.getOriginalFilename();
        if(originalFileName == null)
            return ""; // devuelvo un String vacío.

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = StringUtils.getFilenameExtension(fileName);
        String fileNameWithoutExt = fileName.replace("." + extension, "");

        String newFileName = fileNameWithoutExt + "-" + UUID.randomUUID() + "." + extension;
        System.out.println(newFileName);

        // OBLIGATORIO: Guardar el archivo en el file system.

        return "";

    }
}
