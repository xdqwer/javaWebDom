package com.dxm.web.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public String md5(String s) throws NoSuchAlgorithmException {
        byte[] old = s.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] newbytes = md.digest(old);
            BASE64Encoder encoder = new BASE64Encoder();
            String newstr = encoder.encode(newbytes);
            return newstr;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
