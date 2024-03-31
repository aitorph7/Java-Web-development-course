package com.certidevs.service;

import com.certidevs.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class FileService {
    public String store(MultipartFile file) {

        /* OPCIONAL (...pero recomendable):
         Generar un nombre único para el archivo de imagen y evitar errores por
         duplicidad en el nombre (2 usuarios pueden subir un archivo con el
          mismo nombre, P. ej. 'avatar.svg').
        */
        String newFileName = generateUniqueName(file);
        // TODO (previamente arriba había un bloque de código de 5-6 líneas) toda esta 1ª parte la he extraído
        //  a un método 'GenerateUniqueName' P. ej., seleccionando todo el bloque + clic dcho. "extract method".
        /*
        Ahora que tengo un nuevo nombre...
        OBLIGATORIO: Guardar el archivo en el file system:
        'InputStream' es una de las APIs para poder interactuar con entrada y salida. Al intentar acceder al archivo
        puede lanzar una excepción, que puedo capturar con 'tryCatch'
         */
        try {
            InputStream inputStream = file.getInputStream(); // 1º extraigo el contenido del archivo
            Path filePath = Paths.get("uploads").resolve(newFileName); // 2º obtengo la ruta del sistema
            // ...donde se va a guardar el archivo.
            Files.copy(inputStream, filePath); // 3º copio el contenido del archivo en esa ruta.
            return newFileName; // nombre del archivo almacenado
        } catch (IOException e) {
            log.error("Reading/Saving file error", e);
            throw new FileException("Reading/Saving file error");
        }
        /* este método solo ha guardado el archivo...
        TODO almacenarlo en el artista + idear cómo servirlo (acceder a él a través de un 'FileController' P. ej.)
         */
    }

    public Resource load(String name) {
        /*
         'Resource' es una interface para representar los inputStreams
         y que sean accesibles desde una url.
        */
        Path file = Paths.get("uploads").resolve(name);
        try {
            Resource resource = new UrlResource(file.toUri());
            if(!resource.exists() || !resource.isReadable())
                throw new FileException("Uploading file error");

            return resource;
        } catch (MalformedURLException e) {
            throw new FileException("Uploading file error");
        }
    }

    private String generateUniqueName(MultipartFile file) { // al extraer el método 'generateUniqueName' he debido
        // eliminar la declaración 'static' de este otro método
        String originalFileName = file.getOriginalFilename();
        if(!StringUtils.hasLength(originalFileName) || file.isEmpty())
            throw new FileException("Reading file error");

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = StringUtils.getFilenameExtension(fileName);
        String fileNameWithoutExt = fileName.replace("." + extension, "");
        return fileNameWithoutExt + "-" + UUID.randomUUID() + "." + extension;
    }
    /* Se suelen colocar 1º los métodos públicos y al final los privados.
        El siguiente paso:
        Si voy a usar FileService en muchos métodos de diferentes controladores, tendré
        que incluir un 'try catch' en todos.
        Será mejor crear una clase que se encargue de administrar todas las
        excepciones de forma personalizada y que les ponga un mensaje en la salida.
        ... así que creo el package 'exception'.
    */
}
