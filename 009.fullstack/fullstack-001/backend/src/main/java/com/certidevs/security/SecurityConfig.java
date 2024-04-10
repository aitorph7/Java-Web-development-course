package com.certidevs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //para crear Beans para Spring y utilizar objetos customizados.
public class SecurityConfig {

    // Voy a sobreescribir/personalizar la seguridad (el objeto HttpSecurity de Spring Security)
    // para usar mi filtro JWT y proteger controladores
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // le voy a decir qué rutas quiero proteger y cuáles quiero dejar abiertas.

        // mi aplicación va a ser 'sin estados' (sin sesiones Http), ya que uso tokens JWT
        // La autenticación JWT es 'sin estado' y no depende de sesiones o cookies.
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // proteger rutas:
        http.authorizeHttpRequests()
                .requestMatchers("/users/login").permitAll()
                .requestMatchers("/users/register").permitAll()
                // lo que no sea 'login' o 'register' es obligatorio estar autenticado:
                .anyRequest().authenticated();

        // asignar mi filtro personalizado de JWT antes de cualquier inspección de Spring Security:
        // (le digo a Spring Security dónde quiero que actúe el filtro)
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
