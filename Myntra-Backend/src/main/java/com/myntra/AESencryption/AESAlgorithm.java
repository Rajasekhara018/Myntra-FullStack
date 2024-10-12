package com.myntra.AESencryption;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.myntra.constants.MyntraConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Base64;

@Configuration
@Service
public class AESAlgorithm {
//    private SecretKey key;
//
//    @Value("${ENCODED_SECRET_KEY}")
//    private String encodedKey;
//
//    @Value("${TLEN}")
//    private int TLEN;
//
//    private Cipher encryptionCipher;
//
//    public void init() throws Exception {
//        byte[] decodedKey = Base64.getDecoder().decode(MyntraConstants.ENCODED_KEY);
//        key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//        System.out.println("SecretKey initialized successfully: " + key);
//    }
//
//    public String encrypt(String message) throws Exception {
//        byte[] messageInBytes = message.getBytes();
//        encryptionCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
//        return encode(encryptedBytes);
//    }
//
//    public String decrypt(String encryptedMessage) throws Exception {
//        byte[] messageInBytes = decode(encryptedMessage);
//        Cipher decryptionCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        decryptionCipher.init(Cipher.DECRYPT_MODE, key);
//        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
//        return new String(decryptedBytes);
//    }
//
//    private String encode(byte[] data) {
//        return Base64.getEncoder().encodeToString(data);
//    }
//
//    private byte[] decode(String data) {
//        return Base64.getDecoder().decode(data);
//    }
public static String encrypt(String strToEncrypt,String secret) {
    try {
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), MyntraConstants.SECRETKEYSPEC);
        Cipher cipher = Cipher.getInstance(MyntraConstants.ENCRYPT_DECRYPT_INSTANCE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
    } catch (Exception e) {
        System.out.println(MyntraConstants.ENCRYPTION_FALSE + e.toString());
        return null;
    }
}

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), MyntraConstants.SECRETKEYSPEC);
            Cipher cipher = Cipher.getInstance(MyntraConstants.ENCRYPT_DECRYPT_INSTANCE);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(MyntraConstants.DECRYPTION_FALSE  + e.toString());
            return null;
        }
    }
}