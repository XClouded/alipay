package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alipay.sdk.cons.GlobalConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
    static final String a = "com.alipay.android.app";
    static final String b = "com.eg.android.AlipayGphone";
    private static final String c = "7.0.0";
    private static final String d = "5.0.0";

    public static String a(byte[] paramArrayOfByte) {
        try {
            paramArrayOfByte = null;
            if ((paramArrayOfByte = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramArrayOfByte))).getPublicKey().toString()).indexOf("modulus") != -1) {
                return paramArrayOfByte.substring(paramArrayOfByte.indexOf("modulus") + 8, paramArrayOfByte.lastIndexOf(",")).trim();
            }
        } catch (Exception localException) {

        }
        return null;
    }

    public static byte[] a(Context paramContext, String paramString) {
        paramContext = paramContext.getPackageManager().getInstalledPackages(64).iterator();
        while (paramContext.hasNext()) {
            PackageInfo localPackageInfo;
            if ((localPackageInfo = (PackageInfo)paramContext.next()).packageName.equals(paramString)) {
                return localPackageInfo.signatures[0].toByteArray();
            }
        }
        return null;
    }

    public static boolean a(Context paramContext) {
        try {
            if (paramContext.getPackageManager().getPackageInfo("com.alipay.android.app", 128) == null) {
                return false;
            }
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            return false;
        }
        return true;
    }

    public static boolean b(Context paramContext) {
        try {
            paramContext = null;
            if ((paramContext = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128)) == null) {
                return false;
            }
            if (b(paramContext.versionName, "7.0.0") < 0)
                return false;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            return false;
        }
        return true;
    }

    private static boolean g(Context paramContext) {
        try {
            if (b(paramContext.getPackageManager().getPackageInfo("com.alipay.android.app", 128).versionName, "5.0.0") >= 0)
                return true;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            return false;
        }
        return false;
    }

    private static void a(String paramString1, String paramString2) {
        try {
            paramString1 = "chmod " + paramString1 + " " + paramString2;
            Runtime.getRuntime().exec(paramString1);
            return;
        } catch (IOException localIOException) {
        }
    }

    public static String c(Context paramContext) {
        String str1 = a();
        String str2 = b();
        String str3 = d(paramContext);
        paramContext = e(paramContext);
        return " (" + str1 + ";" + str2 + ";" + str3 + ";;" + paramContext + ")(sdk android)";
    }

    public static String a() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String b() {
        String str;
        int i;
        if ((i = (str = e()).indexOf("-")) != -1) {
            str = str.substring(0, i);
        }
        if ((i = str.indexOf("\n")) != -1) {
            str = str.substring(0, i);
        }
        return "Linux " + str;
    }

    private static String e() {
        try {
            BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            Matcher localMatcher;
            try {
                String str = localBufferedReader.readLine();
                localBufferedReader.close();
            } finally {
                localBufferedReader.close();
            }
            return "Unavailable";
            if (localMatcher.groupCount() < 4) {
                return "Unavailable";
            }
            return localMatcher.group(1) + "\n" + localMatcher.group(2) + " " + localMatcher.group(3) + "\n" + localMatcher.group(4);
        } catch (IOException localIOException) {
        }
        return "Unavailable";
    }

    public static String d(Context paramContext) {
        return paramContext.getResources().getConfiguration().locale.toString();
    }

    public static String e(Context paramContext) {
        Object localObject = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        paramContext = (Context)localObject;
        (localObject = new StringBuilder()).append(paramContext.widthPixels);
        ((StringBuilder)localObject).append("*");
        ((StringBuilder)localObject).append(paramContext.heightPixels);

        return ((StringBuilder)localObject).toString();
    }

    private static DisplayMetrics h(Context paramContext) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics;
    }

    private static boolean a(Context paramContext, String paramString1, String paramString2) {
        try {
            paramContext = paramContext.getAssets().open(paramString1);
            (paramString1 = new File(paramString2)).createNewFile();
            paramString1 = new FileOutputStream(paramString1);
            paramString2 = new byte[1024];
            int i = 0;
            while ((i = paramContext.read(paramString2)) > 0) {
                paramString1.write(paramString2, 0, i);
            }
            paramString1.close();
            paramContext.close();
        } catch (IOException localIOException) {
            return false;
        }
        return true;
    }

    public static void a(Activity paramActivity, String paramString) {
        String str = paramString; Object localObject = "777";
        try {
            localObject = "chmod " + (String)localObject + " " + str;
            Runtime.getRuntime().exec((String)localObject);
        } catch (IOException localIOException) {
        }
        (localObject = new Intent("android.intent.action.VIEW")).addFlags(268435456);
        ((Intent)localObject).setDataAndType(Uri.parse("file://" + paramString), "application/vnd.android.package-archive");
        paramActivity.startActivity((Intent)localObject);
    }

    public static boolean b(Context paramContext, String paramString) {
        boolean bool = false;
        try {
            if (paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1) != null) {
                bool = true;
            } else {
                bool = false;
            }
        } catch (Exception localException) {
            bool = false;
        }
        return bool;
    }

    public static String c() {
        String str;
        return (str = GlobalConstants.b).substring(0, str.indexOf("://"));
    }

    public static String f(Context paramContext) {
        String str = "-1;-1";
        try {
            if ((paramContext = (GsmCellLocation)((TelephonyManager)paramContext.getSystemService("phone")).getCellLocation()) != null) {
                int i = paramContext.getCid();
                paramContext = paramContext.getLac();
                StringBuilder localStringBuilder;
                (localStringBuilder = new StringBuilder()).append(paramContext);
                localStringBuilder.append(";");
                localStringBuilder.append(i);
                str = localStringBuilder.toString();
            }
        } catch (Exception localException) {
        }
        return str;
    }

    public static String d() {
        Random localRandom = new Random();
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; i < 24; i++) {
            int j = localRandom.nextInt(3);
            long l = 0L;
            switch (j) {
                case 0:
                    l = Math.round(Math.random() * 25.0D + 65.0D);
                    localStringBuffer.append(String.valueOf((char)(int)l));
                    break;
                case 1:
                    l = Math.round(Math.random() * 25.0D + 97.0D);
                    localStringBuffer.append(String.valueOf((char)(int)l));
                    break;
                case 2:
                    localStringBuffer.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return localStringBuffer.toString();
    }

    private static int b(String paramString1, String paramString2) {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.addAll(Arrays.asList(paramString1.split("\\.")));
        localArrayList2.addAll(Arrays.asList(paramString2.split("\\.")));

        paramString1 = Math.max(localArrayList1.size(), localArrayList2.size());

        while (localArrayList1.size() < paramString1) {
            localArrayList1.add("0");
        }

        while (localArrayList2.size() < paramString1) {
            localArrayList2.add("0");
        }

        for (paramString2 = 0; paramString2 < paramString1; paramString2++) {
            if (Integer.parseInt((String)localArrayList1.get(paramString2)) != Integer.parseInt((String)localArrayList2.get(paramString2))) {
                return Integer.parseInt((String)localArrayList1.get(paramString2)) - Integer.parseInt((String)localArrayList2.get(paramString2));
            }
        }

        return 0;
    }

    public static boolean a(String paramString) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$")
            .matcher(paramString)
            .matches();
    }

}
