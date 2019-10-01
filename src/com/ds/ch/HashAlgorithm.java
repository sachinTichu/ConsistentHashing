package com.ds.ch;
import java.security.MessageDigest;

public class HashAlgorithm implements HashingFunction
{
    private MessageDigest instance;

    public HashAlgorithm()
    {
        try{
            instance = MessageDigest.getInstance("MD5");
        }
        catch(Exception e){

        }
    }

    @Override
    public Long getHash(String key) {
        instance.reset();
        instance.update(key.getBytes());

        byte[] digest = instance.digest();

        long h = 0;
        for (int i = 0; i < 4; i++) {
            h <<= 8;
            h |= ((int) digest[i]) & 0xFF;
        }
        return h;
    }
}
