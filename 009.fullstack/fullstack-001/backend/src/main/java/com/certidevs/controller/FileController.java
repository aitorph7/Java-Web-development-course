package com.certidevs.controller;

import com.certidevs.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") // Permitir acceso desde cualquier dominio desde el exterior.
@AllArgsConstructor
@Slf4j
@RestControllerAdvice
/* Controlador para poder servir archivos al Frontend. Crear aquí un método y
 servir los archivos que se han guardado.
 */
public class FileController {

    private final FileService fileService;

    // ejemplo de ruta: http://localhost:8080/files/author-f6946523-59fb-4775-a6f9-d081b24a2618.webp
    @GetMapping("files/{name:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String name){
        /*
         'Resource' es una interface para representar los inputStreams
         y que sean accesibles desde una url.
        */
        Resource file = fileService.load(name);
        return ResponseEntity.ok(file);
    }
}
