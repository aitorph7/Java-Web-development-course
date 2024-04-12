package com.certidevs.security;

import com.certidevs.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.swing.*;
import java.util.Optional;

public class SecurityUtils {

    /** next method: devuelve el usuario autenticado extraído de Spring Security.
     * Se utilizará así:
     * User user = SecurityUtils.getAuthUser().orElseThrow();
    */
    public static Optional<User> getAuthUser(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // devuelve un Object

        if (principal instanceof User user){
            return Optional.of(user); // con esto soluciono el problema de la conversión del object --> user
        } else {
            return Optional.empty();
        }
    }
}
