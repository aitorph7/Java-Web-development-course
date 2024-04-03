package com.certidevs.dto;
// Actúa como Data Transfer Object: un tipo de datos
// que no se almacenan tal cual en BD.
public record Register(
        String email,
        String password
) {
}
