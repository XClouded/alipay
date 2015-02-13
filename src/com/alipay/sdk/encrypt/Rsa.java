package com.alipay.sdk.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class Rsa
{
    private static final String b = "RSA";
    public static final String a = "SHA1WithRSA";

    private static PublicKey b(String paramString1, String paramString2) throws NoSuchAlgorithmException, Exception {
        paramString2 = Base64.a(paramString2);
        paramString2 = new X509EncodedKeySpec(paramString2);

        return KeyFactory.getInstance(paramString1).generatePublic(paramString2);
    }

    public static String a(String paramString1, String paramString2) {
        String str1 = null;
        ByteArrayOutputStream localByteArrayOutputStream = null;
        try {
            Object localObject = paramString2;
            paramString2 = "RSA";
            localObject = Base64.a((String)localObject);
            localObject = new X509EncodedKeySpec((byte[])localObject);
            paramString2 = KeyFactory.getInstance(paramString2).generatePublic((KeySpec)localObject);
            (localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding")).init(1, paramString2);
            paramString1 = paramString1.getBytes("UTF-8");
            paramString2 = ((Cipher)localObject).getBlockSize();
            localByteArrayOutputStream = new ByteArrayOutputStream();

            int i;
            for (String str2 = 0; str2 < paramString1.length; str2 += paramString2) {
                localByteArrayOutputStream.write(((Cipher)localObject).doFinal(paramString1, str2, paramString1.length - str2 < paramString2 ? paramString1.length - str2 : paramString2));
            }

            str1 = new String(Base64.a(localByteArrayOutputStream.toByteArray()));
            try {
                localByteArrayOutputStream.close();
            } catch (IOException localIOException1) {
                localIOException1.printStackTrace();
            }
        } catch (Exception localException) {

        } finally {
            if (localByteArrayOutputStream != null) {
                try {
                    localByteArrayOutputStream.close();
                } catch (IOException localIOException3) {
                    localIOException3.printStackTrace();
                }
            }

        }

        return str1;
    }

    private static String c(String paramString1, String paramString2) {
        ByteArrayOutputStream localByteArrayOutputStream = null;
        String str1 = null;
        try {
            paramString2 = new PKCS8EncodedKeySpec(Base64.a(paramString2));
            paramString2 = KeyFactory.getInstance("RSA").generatePrivate(paramString2);
            Cipher localCipher;
            (localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")).init(2, paramString2);

            paramString1 = Base64.a(paramString1);

            paramString2 = localCipher.getBlockSize();
            localByteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            for (String str2 = 0; str2 < paramString1.length; str2 += paramString2) {
                localByteArrayOutputStream.write(localCipher.doFinal(paramString1, str2, paramString1.length - str2 < paramString2 ? paramString1.length - str2 : paramString2));
            }

            str1 = new String(localByteArrayOutputStream.toByteArray());
            try {
                localByteArrayOutputStream.close();
            } catch (IOException localIOException1) {
                localIOException1.printStackTrace();
            }
        } catch (Exception localException) {

        } finally {
            if (localByteArrayOutputStream != null) {
                try {
                    localByteArrayOutputStream.close();
                } catch (IOException localIOException3) {
                    localIOException3.printStackTrace();
                }
            }

        }

        return str1;
    }

    private static String d(String paramString1, String paramString2) {
        String str = "utf-8";
        try {
            paramString2 = new PKCS8EncodedKeySpec(Base64.a(paramString2));
            paramString2 = KeyFactory.getInstance("RSA").generatePrivate(paramString2);
            Signature localSignature;
            (localSignature = Signature.getInstance("SHA1WithRSA")).initSign(paramString2);
            localSignature.update(paramString1.getBytes(str));

            return Base64.a(localSignature.sign());
        } catch (Exception localException) {
            localException.printStackTrace();
        }

        return null;
    }

    private static boolean a(String paramString1, String paramString2, String paramString3) {
        try {
            Object localObject = KeyFactory.getInstance("RSA");
            paramString3 = Base64.a(paramString3);
            paramString3 = ((KeyFactory)localObject).generatePublic(new X509EncodedKeySpec(paramString3));

            (localObject = Signature.getInstance("SHA1WithRSA")).initVerify(paramString3);
            ((Signature)localObject).update(paramString1.getBytes("utf-8"));

            return ((Signature)localObject).verify(Base64.a(paramString2));
        } catch (Exception localException) {
            localException.printStackTrace();
        }

        return false;
    }

}
