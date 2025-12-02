package be.craftcode.java25.security;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * +--------------------------------+
 * |   JEP 510: KDF API (Preview)   |
 * +--------------------------------+
 * Java 25 introduces a standard Key Derivation Function API. Until the API is
 * finalized we can mirror the HKDF workflow manually for reference tests.
 */
public class KeyDerivationApiLab {

    public String previewHkdf(String secret) {
        byte[] salt = "salty".getBytes(StandardCharsets.UTF_8);
        byte[] info = "lab-demo".getBytes(StandardCharsets.UTF_8);
        byte[] derived = hkdfSha256(secret.getBytes(StandardCharsets.UTF_8), salt, info, 32);
        String encoded = Base64.getEncoder().encodeToString(derived);
        System.out.println(encoded);
        return encoded;
    }

    /** 
     * TODO 1: Implement HKDF-SHA256 manually until the baked-in API arrives.
     * Follow RFC 5869: PRK = HMAC(salt, ikm); then generate blocks by repeatedly
     * hashing the previous block + info + counter. Return exactly {@code length}
     * bytes (truncate the final block if necessary). Resist the urge to call
     * {@link #hkdfSha256(byte[], byte[], byte[], int)}; the goal is to practice
     * the actual steps (or use the upcoming API once available).
     */
    public byte[] deriveKey(byte[] ikm, byte[] salt, byte[] info, int length) {
        throw new UnsupportedOperationException("TODO: implement HKDF-SHA256 expansion.");
    }

    private static byte[] hkdfSha256(byte[] ikm, byte[] salt, byte[] info, int length) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] actualSalt = salt == null || salt.length == 0 ? new byte[mac.getMacLength()] : salt;
            mac.init(new SecretKeySpec(actualSalt, "HmacSHA256"));
            byte[] prk = mac.doFinal(ikm);

            byte[] okm = new byte[length];
            byte[] previous = new byte[0];
            int generated = 0;
            int counter = 1;
            while (generated < length) {
                mac.reset();
                mac.init(new SecretKeySpec(prk, "HmacSHA256"));
                mac.update(previous);
                mac.update(info);
                mac.update((byte) counter);
                byte[] block = mac.doFinal();
                int bytesToCopy = Math.min(block.length, length - generated);
                System.arraycopy(block, 0, okm, generated, bytesToCopy);
                generated += bytesToCopy;
                previous = block;
                counter++;
            }
            return okm;
        } catch (Exception e) {
            throw new IllegalStateException("HKDF preview failed", e);
        }
    }
}
