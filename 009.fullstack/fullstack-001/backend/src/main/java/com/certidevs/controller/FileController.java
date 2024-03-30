package com.certidevs.controller;

import com.certidevs.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*") // Permitir acceso desde cualquier dominio desde el exterior.
@AllArgsConstructor
@Slf4j
/* Controlador para poder servir archivos al Frontend. Crear aquí un método y
 servir los archivos que se han guardado.
 */
public class FileController {

    private final FileService fileService;
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
