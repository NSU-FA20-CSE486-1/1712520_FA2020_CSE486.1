package com.afridi.securemessaging;

public class Crypto {
    public static final String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+?/.,><[]{}:; ";

    public String encrypt(String plainText, int key) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            int charPos = str.indexOf(plainText.charAt(i));
            int keyValue = (charPos + key) % str.length();
            char replaceValue = str.charAt(keyValue);
            cipherText.append(replaceValue) ;
        }
        return cipherText.toString();
    }

    public String decrypt(String cipherText, int key) {

        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            int charPos = str.indexOf(cipherText.charAt(i));
            int keyValue = (charPos - key) % str.length();

            if (keyValue < 0) {
                keyValue = str.length() + keyValue;
            }
            char replaceValue = str.charAt(keyValue);
            plainText.append(replaceValue);
        }
        return plainText.toString();
    }
}