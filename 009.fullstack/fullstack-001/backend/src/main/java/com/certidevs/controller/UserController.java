package com.certidevs.controller;

import com.certidevs.dto.Login;
import com.certidevs.dto.Register;
import com.certidevs.dto.Token;
import com.certidevs.model.Role;
import com.certidevs.model.User;
import com.certidevs.repository.UserRepository;
import com.certidevs.security.SecurityUtils;
import com.certidevs.service.FileService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final FileService fileService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("users/register")
    public void register(@RequestBody Register register){
        // si el email está ocupado no registro al usuario
        if (this.userRepository.existsByEmail(register.email())){
            throw new RuntimeException("Busy email");
        }
        // Crear el objeto User
        // Cifrar la contraseña con BCrypt
        User user = User.builder()
                .email(register.email())
                .password(passwordEncoder.encode(register.password()))
                .role(Role.USER)
                .build();

        // Guardar el objeto User
        this.userRepository.save(user);
    }
    @PostMapping("users/login")
    public Token login(@RequestBody Login login){

        // si el email no existe no se puede logear
        if(!this.userRepository.existsByEmail(login.email())){
            throw new NoSuchElementException("User not found");
        }
        // recuperar usuario
        User user = this.userRepository.findByEmail(login.email()).orElseThrow();

        // comparar contraseñas
        boolean correctPassword = passwordEncoder.matches(login.password(), user.getPassword());
        boolean incorrectPassword = !correctPassword;
        if (incorrectPassword){
            throw new RuntimeException("Incorrect password");
        }
//        if (!passwordEncoder.matches(login.password(), user.getPassword())){
//            throw new RuntimeException("Incorrect password");
//        }

        /*
         TODO Lo ideal sería trasladar este proceso a un Servicio.
         JWT Json Web Token: jwt.io
         Generar TOKEN de acceso: eyJhbGciOiJIUzI1NiIsIn......
         Tutorial para generar un token: https://github.com/jwtk/jjwt?tab=readme-ov-file#creating-a-jwt
        */
        Date issuedDate = new Date();
        long nextWeekMillis = TimeUnit.DAYS.toMillis(7);
        Date expirationDate = new Date(issuedDate.getTime() + nextWeekMillis);
        byte[] key = Base64.getDecoder().decode("PwUAIxpZLYjsyjzi62bY4or99ZLFISl7y47RWBmm+bs="); // Clave secreta almacenada en una variable de entorno.

        String token = Jwts.builder()
                // id del usuario:
                .subject(String.valueOf(user.getId()))
                // la clave secreta para firmar el token y saber que es nuestro cuando lleguen las peticiones del frontend:
                .signWith(Keys.hmacShaKeyFor(key))
                // fecha emisión del token:
                .issuedAt(issuedDate)
                // fecha de expiración del token:
                .expiration(expirationDate)
                // información personalizada: rol, username, email...
                .claim("role", user.getRole())
                .claim("email", user.getEmail())
                // construye el token:
                .compact();
        return new Token(token);
        // TODO necesitaré validar los tokens y que estén firmados con esta misma clave cuando lleguen del frontend
        //  en las siguientes peticiones.
    }

    // Get account: para obtener en el frontend los datos del usuario
    @GetMapping("users/account")
    public User getCurrentUser(){
        return SecurityUtils.getAuthUser().orElseThrow();
    }

    // Put account: para actualizar los datos del usuario
    @PutMapping("users/account")
    public User update(@RequestBody User user){
        // Si está autenticado y es ADMIN o es el mismo usuario que la variable 'user' permito
        // actualizar, en caso contrario no lo permito.
        SecurityUtils.getAuthUser().ifPresent(currentUser -> {
            if (currentUser.getRole() == Role.ADMIN || Objects.equals(currentUser.getId(), user.getId())){
                this.userRepository.save(user);
            } else {
                throw new RuntimeException("No tiene permiso para actualizar"); // TODO reemplazar por excepción personalizada
            }
        });
        return user;
    }

    // Subir avatar
    @PostMapping("users/account/avatar")
    public User uploadAvatar(
            @RequestParam(value = "photo") MultipartFile file
    ){
        User user = SecurityUtils.getAuthUser().orElseThrow();
        // si hay archivo, le guardo ese archivo y devuelvo el user con el 'return' de +abajo
        if (file != null && !file.isEmpty()){
            String filename = fileService.store(file);
            user.setPhotoUrl(filename);
            this.userRepository.save(user);
        }
        return user; // si no hay archivo devuelvo el user tal cual lo tengo
    }
}
