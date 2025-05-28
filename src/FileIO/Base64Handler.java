package FileIO;

import java.util.Base64;

public class Base64Handler {
    private Base64Handler() {}

    public static String getEncodedString(byte[] data) {
        System.out.println("> GETTING ENCODED STRING...");
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] getEncodedData(byte[] data) {
        System.out.println("> GETTING ENCODED DATA...");
        return Base64.getEncoder().encode(data);
    }

    public static String getDecodedString(byte[] data) {
        System.out.println("> GETTING DECODED STRING...");
        return new String(data);
    }

    public static byte[] getDecodedData(byte[] data) {
        System.out.println("> GETTING DECODED DATA...");
        return Base64.getDecoder().decode(data);
    }

    public static String bytesToString(byte[] data) {
        return new String(data);
    }

    public static byte[] cleanBase64(byte[] data) { 
        String base64 = bytesToString(data).replaceAll("[^A-Za-z0-9+/=]", "");

        int padding = 4 - (base64.length() % 4);
        if (padding < 4) {
            base64 += "=".repeat(padding);
        }
        
        return base64.getBytes();
    }
}
