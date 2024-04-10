package com.certidevs.security;

// Clase para:
// 1. filtrar las peticiones HTTP entrantes,
// 2. extraer el token JWT de las cabeceras,
// 3. verificar que el token es correcto y
// 4. extraer el usuario del token.

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
@Slf4j
public class RequestJWTFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Hola, ejecutando filtro para JWT");

        // 1. Extraer de la cabecera Authorization de la request.

        String bearerToken = request.getHeader("Authorization");
        String token = "";
        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith("Bearer")) {
            token = bearerToken.substring("Bearer ".length());
        } else {
            filterChain.doFilter(request, response);
            return; // si no hay token.
        }
        log.info("Extraído token JWT {}", token);

        // 2. Verificar el token JWT:
        byte[] key = Base64.getDecoder().decode("PwUAIxpZLYjsyjzi62bY4or99ZLFISl7y47RWBmm+bs=");

        String userId = Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(key))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        log.info("Id de usuario {}", userId);

        // dejar pasar a la petición para que continúe
        filterChain.doFilter(request, response);




    }
}
