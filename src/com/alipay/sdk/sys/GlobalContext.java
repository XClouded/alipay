package com.alipay.sdk.sys;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.MspConfig;
import com.alipay.sdk.util.Utils;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

public class GlobalContext
{
    private static GlobalContext a;
    private Context b;
    private MspConfig c;

    public static GlobalContext a() {
        if (a == null) {
        a = new GlobalContext();
        }

        return a;
    }

    public final Context b() {
        return this.b;
    }

    public final void a(Context paramContext, MspConfig paramMspConfig) {
        this.b = paramContext.getApplicationContext();
        this.c = paramMspConfig;
    }

    public final MspConfig c() {
        return this.c;
    }

    public static boolean d() {
        return false;
    }

    public static boolean e() {
        Object localObject = { "/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/" };
        try {
            for (int i = 0; i < localObject.length; i++) {
                String str = localObject[i] + "su";
                if (new File(str).exists()) {
                    if ((TextUtils.isEmpty(localObject = a(new String[] { "ls", "-l", str }))) || (((String)localObject).indexOf("root") == ((String)localObject).lastIndexOf("root"))) {
                        return false;
                    }
                    return true;
                }
            }
        } catch (Exception localException) {
        }
        return false;
    }

  // ERROR //
  private static String a(String[] paramArrayOfString) { // Byte code:
    //   0: ldc 1
    //   2: astore_1
    //   3: aconst_null
    //   4: astore_2
    //   5: new 25	java/lang/ProcessBuilder
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 50	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   13: dup
    //   14: astore_0
    //   15: iconst_0
    //   16: invokevirtual 51	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   19: pop
    //   20: aload_0
    //   21: invokevirtual 52	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   24: astore_2
    //   25: new 20	java/io/DataOutputStream
    //   28: dup
    //   29: aload_2
    //   30: invokevirtual 48	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   33: invokespecial 40	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: astore_0
    //   37: new 19	java/io/DataInputStream
    //   40: dup
    //   41: aload_2
    //   42: invokevirtual 47	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   45: invokespecial 38	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: invokevirtual 39	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: ldc 8
    //   55: invokevirtual 42	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: invokevirtual 41	java/io/DataOutputStream:flush	()V
    //   62: aload_2
    //   63: invokevirtual 49	java/lang/Process:waitFor	()I
    //   66: pop
    //   67: aload_2
    //   68: invokevirtual 46	java/lang/Process:destroy	()V
    //   71: goto +30 -> 101
    //   74: pop
    //   75: goto +26 -> 101
    //   78: pop
    //   79: aload_2
    //   80: invokevirtual 46	java/lang/Process:destroy	()V
    //   83: goto +18 -> 101
    //   86: pop
    //   87: goto +14 -> 101
    //   90: astore_0
    //   91: aload_2
    //   92: invokevirtual 46	java/lang/Process:destroy	()V
    //   95: goto +4 -> 99
    //   98: pop
    //   99: aload_0
    //   100: athrow
    //   101: aload_1
    //   102: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   67	71	74	java/lang/Exception
    //   5	67	78	java/lang/Exception
    //   79	83	86	java/lang/Exception
    //   5	67	90	finally
    //   91	95	98	java/lang/Exception }
    public static String f() {
        return Utils.d();
    }


    public final String g() {
        String str;
        if (!TextUtils.isEmpty(str = UTDevice.getUtdid(this.b))) {
            Object localObject = str;
            char[] arrayOfChar = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '=' };
            int i = 0;
            localObject = ((String)localObject).toCharArray();
            int j = 0;
            for (int k = localObject.length; j < k; j++) {
                i = 0;
                int m = localObject[j];
                int n = 0;
                for (int i1 = arrayOfChar.length; n < i1; n++)
                    if (m == arrayOfChar[n]) i = 1;
                if (i == 0) break;
            }
            if (i != 0)
                return str;
        }
        return "";
    }

    private static boolean a(String paramString) {
        char[] arrayOfChar = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '=' };

        boolean bool = false;
        paramString = paramString.toCharArray();
        int i = 0;
        for (int j = paramString.length; i < j; ) {
            bool = false;
            int k = paramString[i];
            int m = 0;
            for (int n = arrayOfChar.length; m < n; m++) {
                if (k == arrayOfChar[m])
                    bool = true;
            }
            if (!bool)
                break;
            i++;
        }
        return bool;
    }

}
