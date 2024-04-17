package com.certidevs.security;

// Clase para:
// 1. interceptar las peticiones HTTP entrantes,
// 2. extraer el token JWT de las cabeceras (headers),
// 3. verificar que el token es correcto y
// 4. extraer el usuario del token.

// Esto permite saber qué usuario es el que está lanzando peticiones al backend.
// o de lo contrario saber que se trata de un usuario no registrado (no tiene
// token).

import com.certidevs.model.User;
import com.certidevs.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor // para asegurarte de que se hace bien la inyección de dependencias.
public class RequestJWTFilter extends OncePerRequestFilter {

    private final UserRepository userRepository; // así puedo comprobar si el usuario existe en BD.

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Hola, ejecutando filtro para JWT");

        // 1. Extraer de la cabecera Authorization de la request.

        String bearerToken = request.getHeader("Authorization");
        if (!StringUtils.hasLength(bearerToken) || !bearerToken.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }
        String token = bearerToken.substring("Bearer ".length());

        // 2. Verificar el token JWT:
        // TODO almacenar clave en variable de entorno
        // Long userId = verifyTokenAndExtractUserId(token);

        byte[] key = Base64.getDecoder().decode("PwUAIxpZLYjsyjzi62bY4or99ZLFISl7y47RWBmm+bs=");

        String userId = Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(key))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        log.info("Id de usuario {}", userId);

        // 3. Obtener el usuario de BD cuyo Id he extraído del token JWT:
        Optional<User> userOptional = this.userRepository.findById(Long.valueOf(userId)); // el String devuelto me lo ha parseado a Long
        if (userOptional.isEmpty()) {
            // no hay usuario (sería un caso raro) devuelvo un error 'Unauthorized 401'
            log.warn("Usuario con Id {} no encontrado", userId);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 4. Crear objeto 'Authentication' con datos del usuario y guardarlo en el contexto de seguridad de Spring Security:
        // (OBLIGATORIO: TENER EL STARTER 'Spring Security' en el pom.xml)
        User user = userOptional.get();
        log.info("Rol del usuario {}", user.getRole().toString());
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(user.getRole().toString());
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, List.of(role));
        // guardar el usuario en una memoria de Spring:
        SecurityContextHolder.getContext().setAuthentication(auth); // permite que en otras partes de la aplicación puedas...
        // ... obtener la autenticación así: SecurityContextHolder.getContext().getAuthentication(auth);


        // dejar pasar a la petición para que continúe
        filterChain.doFilter(request, response);
    }
}
