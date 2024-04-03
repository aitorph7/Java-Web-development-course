package com.certidevs;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGeneratorTest {

    @Test
    void generateSecureKey(){
        SecureRandom random = new SecureRandom();
        // 32 bytes equivale a 256 bits, tamaño suficiente para el algoritmo HMAC-SHA-256
        byte[] key = new byte[32];
        random.nextBytes(key); // así lo rellenas con números aleatorios.
        // convertir a base64 para mayor comodidad
        String base64Key = Base64.getEncoder().encodeToString(key);
        System.out.println(base64Key);
    }
}
