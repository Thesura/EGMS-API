package com.egms.api.service;

import java.security.*;
import java.util.Arrays;

public class Encrypt {

    public static String getHash(String toHash){//hashing function
        byte[] hashByte = null;
        String hash = null;

        try {
            MessageDigest message = MessageDigest.getInstance("SHA-256");
            message.update(toHash.getBytes());
            hashByte = message.digest();
            hash = Arrays.toString(hashByte);

        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return hash;
    }
}
