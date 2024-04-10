package com.certidevs.controller;

import com.certidevs.dto.Login;
import com.certidevs.dto.Register;
import com.certidevs.dto.Token;
import com.certidevs.model.Role;
import com.certidevs.model.User;
import com.certidevs.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    @PostMapping("users/register")
    public void register(@RequestBody Register register){
        // si el email está ocupado no registro al usuario
        if (this.userRepository.existsByEmail(register.email())){
            throw new RuntimeException("Busy email");
        }
        // Crear el objeto User
        // TODO cifrar la contraseña con BCrypt
        User user = new User(null, null, register.email(), register.password(), Role.USER);
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
        // TODO cuando la contraseña esté cifrada cambiar el proceso de comparación.
        if (!user.getPassword().equals(login.password())){
            throw new RuntimeException("Incorrect password");
        }
        /*
         TODO Lo ideal sería trasladar este proceso a un Servicio.
         JWT Json Web Token: jwt.io
         Generar TOKEN de acceso: eyJhbGciOiJIUzI1NiIsIn......
         Tutorial para generar un token: https://github.com/jwtk/jjwt?tab=readme-ov-file#creating-a-jwt
        */
        Date issuedDate = new Date();
        long nextWeekMillis = TimeUnit.DAYS.toMillis(7);
        Date expirationDate = new Date(issuedDate.getTime() + nextWeekMillis);
        byte[] key = Base64.getDecoder().decode("PwUAIxpZLYjsyjzi62bY4or99ZLFISl7y47RWBmm+bs=");

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
}
