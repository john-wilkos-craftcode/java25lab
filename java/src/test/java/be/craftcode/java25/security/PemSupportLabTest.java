package be.craftcode.java25.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PemSupportLabTest {

    private final PemSupportLab lab = new PemSupportLab();

    @Test
    void demoDecodesSection() {
        String pem = """
                -----BEGIN TEST-----
                SGVsbG8=
                -----END TEST-----
                """;
        assertArrayEquals("Hello".getBytes(), lab.decodeSection(pem));
    }

    @Test
    void todoEncodesSectionWithWrapping() {
        byte[] bytes = ("We expect the PEM encoder to wrap every 64 characters, so let's make this a little longer than usual so the test proves it.")
                .getBytes();
        String pem = lab.encodeSection("MESSAGE", bytes);
        assertEquals("""
                -----BEGIN MESSAGE-----
                V2UgZXhwZWN0IHRoZSBQRU0gZW5jb2RlciB0byB3cmFwIGV2ZXJ5IDY0IGNoYXJh
                Y3RlcnMsIHNvIGxldCdzIG1ha2UgdGhpcyBhIGxpdHRsZSBsb25nZXIgdGhhbiB1
                c3VhbCBzbyB0aGUgdGVzdCBwcm92ZXMgaXQu
                -----END MESSAGE-----
                """.trim(), pem.trim());
    }
}
