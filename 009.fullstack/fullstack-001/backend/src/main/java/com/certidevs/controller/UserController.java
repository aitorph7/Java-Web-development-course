package com.certidevs.controller;

import com.certidevs.dto.Login;
import com.certidevs.dto.Register;
import com.certidevs.model.User;
import com.certidevs.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.NoSuchElementException;

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
        User user = new User(null, null, register.email(), register.password());
        // Guardar el objeto User
        this.userRepository.save(user);
    }
    @PostMapping("users/login")
    public void login(@RequestBody Login login){

        // si el email no existe no se puede logear
        if(!this.userRepository.existsByEmail(login.email())){
            throw new NoSuchElementException("User not found");
        }
        // recuperar usuario
        User user = this.userRepository.findByEmail(login.email()).orElseThrow();
        // comparar contraseñas
        if (user.getPassword().equals(login.password())){
            throw new RuntimeException("Incorrect password");
        }
        // JWT Json Web Token: jwt.io
        // Generar TOKEN de acceso importando una librería
        // Generar el token: https://github.com/...
        String token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor("admin".getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", "JWT")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (3600 * 24 * 1000)))
                .claim("email", user.getEmail())
                .claim("role", "admin")
                .compact();
    }
}
