package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class TriDes
{
    private static String a = "DESede/ECB/PKCS5Padding";

    public static String a(String paramString1, String paramString2) {
        String str = null;
        try {
            paramString1 = new SecretKeySpec(paramString1.getBytes(), "DESede");
            Cipher localCipher;
            (localCipher = Cipher.getInstance(a)).init(1, paramString1);
            str = Base64.a(localCipher.doFinal(paramString2.getBytes()));
        } catch (Exception localException) {
            localException.printStackTrace();
        }

        return str;
    }

    public static String b(String paramString1, String paramString2) {
        String str = null;
        try {
            paramString1 = new SecretKeySpec(paramString1.getBytes(), "DESede");
            Cipher localCipher;
            (localCipher = Cipher.getInstance(a)).init(2, paramString1);
            paramString1 = localCipher.doFinal(Base64.a(paramString2));
            str = new String(paramString1);
        }
        catch (Exception localException) {
            localException.printStackTrace();
        }
        return str;
    }

}
