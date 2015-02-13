package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Des
{
    public static String a(String paramString1, String paramString2) {
        return a(1, paramString1, paramString2);
    }

    public static String b(String paramString1, String paramString2) {
        return a(2, paramString1, paramString2);
    }

    private static String a(int paramInt, String paramString1, String paramString2) {
        try {
            paramString2 = new SecretKeySpec(paramString2.getBytes(), "DES");
            Cipher localCipher;
            (localCipher = Cipher.getInstance("DES")).init(paramInt, paramString2);

            if (paramInt == 2) {
                paramString1 = Base64.a(paramString1);
            } else {
                paramString1 = paramString1.getBytes("UTF-8");
            }

            paramString1 = localCipher.doFinal(paramString1);

            if (paramInt == 2) {
                paramInt = new String(paramString1);
            }
            return Base64.a(paramString1);
        } catch (Exception localException) {

        }
        return null;
    }
}
