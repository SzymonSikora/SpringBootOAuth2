package com.webservice.dexter_service.Security;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.yaml")
public abstract class RSA {

    @Value("${rsa.private-key}")
    private static BigInteger privateKey = new BigInteger(
            "55103533001172214695157399389114379488154991803062533903103443952341730772887");

    @Value("${rsa.public-key}")
    private static BigInteger publicKey = new BigInteger("84551");

    @Value("${rsa.modulus}")
    private static BigInteger modulus = new BigInteger(
            "89678340399632589546133106379785765983373648158804531096283277835934935171051");

    public static BigInteger getPublicKey() {
        return publicKey;
    }

    public static String encrypt(String encryptedMess) {
        byte[] bytes = encryptedMess.getBytes();
        BigInteger mess = new BigInteger(bytes);
        return mess.modPow(publicKey, modulus).toString();
    }

    public static String decrypt(String decryptedMess) {
        BigInteger dec = new BigInteger(decryptedMess);
        return new String(dec.modPow(privateKey, modulus).toByteArray());
    }

    public String toString() {
        String s = "";
        return s;
    }
}
