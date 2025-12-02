package be.craftcode.java25.security;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * +-------------------------------+
 * |   JEP 470: PEM API Updates    |
 * +-------------------------------+
 * Java 25 ships native PEM encoders/decoders. This class keeps a lightweight
 * regex-based version so we can reason about the expected behavior.
 */
public class PemSupportLab {

    private static final Pattern PEM_PATTERN = Pattern.compile("-----BEGIN (.+?)-----(.*?)-----END \\1-----", Pattern.DOTALL);

    public byte[] decodeSection(String pemBlob) {
        Matcher matcher = PEM_PATTERN.matcher(pemBlob.replace("\r", ""));
        if (!matcher.find()) {
            throw new IllegalArgumentException("No PEM section found");
        }
        String base64 = matcher.group(2).replaceAll("\\s+", "");
        byte[] decoded = Base64.getDecoder().decode(base64);
        System.out.println("Decoded " + decoded.length + " bytes");
        return decoded;
    }

    /**
     * TODO 1: Encode arbitrary bytes into a PEM block with the given label.
     * Requirements:
     *  - Wrap the base64 data at 64 characters per line.
     *  - Surround it with BEGIN/END lines that reuse the label.
     */
    public String encodeSection(String label, byte[] data) {
        throw new UnsupportedOperationException("TODO: wrap the base64 payload inside PEM guards.");
    }
}
