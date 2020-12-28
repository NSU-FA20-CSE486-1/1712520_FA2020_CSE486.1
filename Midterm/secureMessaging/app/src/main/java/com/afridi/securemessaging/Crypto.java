package com.afridi.securemessaging;

public class Crypto {
    public static final String str = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+<>?~' ";

    public String encrypt(String plaint, int key) {
        plaint = plaint.toLowerCase();
        StringBuilder ciphert = new StringBuilder();

        for (int i = 0; i < plaint.length(); i++) {
            int charpos = str.indexOf(plaint.charAt(i));
            int keyval = (charpos + key) % 54;
            char replaceval = str.charAt(keyval);
            ciphert.append(replaceval) ;
        }
        return ciphert.toString();
    }

    public String decrypt(String ciphert, int key) {
        ciphert = ciphert.toLowerCase();
        StringBuilder plaint = new StringBuilder();

        for (int i = 0; i < ciphert.length(); i++) {
            int charpos = str.indexOf(ciphert.charAt(i));
            int keyval = (charpos - key) % 54;
            if (keyval < 0) {
                keyval = str.length() + keyval;
            }
            char replaceval = str.charAt(keyval);
            plaint.append(replaceval);
        }
        return plaint.toString();
    }
}