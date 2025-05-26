package FileIO;

import java.util.Base64;

public class Base64Handler {
    private Base64Handler() {}

    public static String getEncodedString(byte[] data) {
        System.out.println(">GETTING ENCODED STRING...");
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] getDecodedData(byte[] data) {
        System.out.println(">GETTING DECODED DATA");
        return Base64.getDecoder().decode(data);
    }
}
