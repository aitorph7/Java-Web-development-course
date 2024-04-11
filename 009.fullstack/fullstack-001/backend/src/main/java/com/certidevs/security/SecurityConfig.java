package com.certidevs.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor // para asegurarme de que se hace bien la inyección de dependencias.
@Configuration //para crear Beans para Spring y utilizar objetos customizados.
public class SecurityConfig {

    private final RequestJWTFilter jwtFilter;

    // Voy a sobreescribir/personalizar la seguridad (el objeto HttpSecurity de Spring Security)
    // para usar mi filtro JWT y proteger controladores

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // le voy a decir qué rutas quiero proteger y cuáles quiero dejar abiertas.

                    // PARA LAS NUEVAS VERSIONES DE SPRING > 6.1:
            //        http
            //                .csrf(csrf -> csrf.disable())
            //                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            //                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
            //                        .requestMatchers("/users/login").permitAll()
            //                        .requestMatchers("/users/register").permitAll()
            //                        .anyRequest().authenticated()
            //                ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            //                .build();

        // PARA LAS VERSIONES ANTERIORES A SPRING 6.1:
        // mi aplicación va a ser 'sin estados' (sin sesiones Http), ya que uso tokens JWT
        // La autenticación JWT es 'sin estado' y no depende de sesiones o cookies.
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // proteger rutas:
        http.authorizeHttpRequests()
                .requestMatchers("users/login").permitAll()
                .requestMatchers("users/register").permitAll()
                .requestMatchers("albums").permitAll() // permito ver álbumes por ser como la Home de mi aplicación.
                // .requestMatchers("albums").hasAnyAuthority("ADMIN")
                // lo que no sea 'login' o 'register' es obligatorio estar autenticado:
                .anyRequest()
                .authenticated();

        // Asignar mi filtro personalizado de JWT antes de cualquier inspección de Spring Security:
        // (le digo a Spring Security dónde quiero que actúe el filtro)
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
