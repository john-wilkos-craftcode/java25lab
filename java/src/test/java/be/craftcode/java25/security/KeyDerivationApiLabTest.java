package be.craftcode.java25.security;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class KeyDerivationApiLabTest {

    private final KeyDerivationApiLab lab = new KeyDerivationApiLab();

    @Test
    void demoPreviewMatchesVector() {
        assertEquals("Ug4QvE/VGEfSMOE1LjzX6uTyeNeR2HAyYGdJiZKoYdU=", lab.previewHkdf("space-cadet"));
    }

    @Test
    void todoDeriveKeyUsesHkdfSteps() {
        byte[] bytes = lab.deriveKey(
                "space-cadet".getBytes(StandardCharsets.UTF_8),
                "salty".getBytes(StandardCharsets.UTF_8),
                "mission-control".getBytes(StandardCharsets.UTF_8),
                42
        );
        assertEquals("33yS+nl+dn36hBiPdJEgJCQZuAeCfhp7vRCqwjVKhUQqVYbUc7WmYE+Z", Base64.getEncoder().encodeToString(bytes));
    }
}
