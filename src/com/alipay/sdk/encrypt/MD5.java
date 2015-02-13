package com.alipay.sdk.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
    private static String a(String paramString) {
        try {
            MessageDigest localMessageDigest;
            (localMessageDigest = MessageDigest.getInstance("MD5")).update(paramString.getBytes());
            return b(localMessageDigest.digest());
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
        return "";
    }

    public static String a(byte[] paramArrayOfByte) {
        try {
            MessageDigest localMessageDigest;
            (localMessageDigest = MessageDigest.getInstance("MD5")).update(paramArrayOfByte);
            return b(localMessageDigest.digest());
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
        return "";
    }

    private static String b(byte[] paramArrayOfByte) {
        StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
        for (int i = 0; i < paramArrayOfByte.length; i++) {
            localStringBuffer.append(Character.forDigit((paramArrayOfByte[i] & 0xF0) >> 4, 16));
            localStringBuffer.append(Character.forDigit(paramArrayOfByte[i] & 0xF, 16));
        }
        return localStringBuffer.toString();
    }
}
