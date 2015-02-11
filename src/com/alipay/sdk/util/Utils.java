/*     */ package com.alipay.sdk.util;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.content.pm.Signature;
/*     */ import android.content.res.AssetManager;
/*     */ import android.content.res.Configuration;
/*     */ import android.content.res.Resources;
/*     */ import android.net.Uri;
/*     */ import android.os.Build.VERSION;
/*     */ import android.telephony.TelephonyManager;
/*     */ import android.telephony.gsm.GsmCellLocation;
/*     */ import android.util.DisplayMetrics;
/*     */ import android.view.Display;
/*     */ import android.view.WindowManager;
/*     */ import com.alipay.sdk.cons.GlobalConstants;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.cert.CertificateFactory;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class Utils
/*     */ {
/*     */   static final String a = "com.alipay.android.app";
/*     */   static final String b = "com.eg.android.AlipayGphone";
/*     */   private static final String c = "7.0.0";
/*     */   private static final String d = "5.0.0";
/*     */ 
/*     */   public static String a(byte[] paramArrayOfByte)
/*     */   {
/*     */     try
/*     */     {
/*  64 */       paramArrayOfByte = null;
/*     */ 
/*  66 */       if ((
/*  66 */         paramArrayOfByte = ((X509Certificate)CertificateFactory.getInstance("X.509")
/*  61 */         .generateCertificate(new ByteArrayInputStream(paramArrayOfByte)))
/*  64 */         .getPublicKey().toString())
/*  66 */         .indexOf("modulus") != -1)
/*     */       {
/*  70 */         return paramArrayOfByte.substring(paramArrayOfByte.indexOf("modulus") + 8, paramArrayOfByte.lastIndexOf(",")).trim();
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */ 
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */   public static byte[] a(Context paramContext, String paramString)
/*     */   {
/*  81 */     paramContext = paramContext.getPackageManager()
/*  79 */       .getInstalledPackages(64)
/*  81 */       .iterator();
/*     */ 
/*  83 */     while (paramContext.hasNext())
/*     */     {
/*     */       PackageInfo localPackageInfo;
/*  86 */       if ((
/*  85 */         localPackageInfo = (PackageInfo)paramContext.next()).packageName
/*  86 */         .equals(paramString)) {
/*  87 */         return localPackageInfo.signatures[0].toByteArray();
/*     */       }
/*     */     }
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */   public static boolean a(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/*  98 */       if (paramContext.getPackageManager()
/*  96 */         .getPackageInfo("com.alipay.android.app", 128) == null)
/*     */       {
/*  99 */         return false;
/*     */       }
/*     */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) { return false; }
/*     */ 
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean b(Context paramContext)
/*     */   {
/*     */     try {
/* 109 */       paramContext = null;
/*     */ 
/* 111 */       if ((
/* 111 */         paramContext = paramContext.getPackageManager()
/* 109 */         .getPackageInfo("com.eg.android.AlipayGphone", 128)) == null)
/*     */       {
/* 112 */         return false;
/*     */       }
/* 114 */       if (b(paramContext.versionName, 
/* 114 */         "7.0.0") < 0)
/* 115 */         return false;
/*     */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   private static boolean g(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/* 128 */       if (b(paramContext.getPackageManager()
/* 125 */         .getPackageInfo("com.alipay.android.app", 128).versionName, 
/* 128 */         "5.0.0") >= 0)
/* 129 */         return true;
/*     */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 131 */       return false;
/*     */     }
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */   private static void a(String paramString1, String paramString2) {
/*     */     try {
/* 138 */       paramString1 = "chmod " + paramString1 + " " + paramString2;
/* 139 */       Runtime.getRuntime()
/* 142 */         .exec(paramString1);
/*     */ 
/* 144 */       return; } catch (IOException localIOException) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String c(Context paramContext) {
/* 149 */     String str1 = a();
/*     */ 
/* 152 */     String str2 = b();
/*     */ 
/* 155 */     String str3 = d(paramContext);
/*     */ 
/* 158 */     paramContext = e(paramContext);
/*     */ 
/* 161 */     return " (" + 
/* 161 */       str1 + ";" + str2 + ";" + str3 + ";;" + paramContext + ")(sdk android)";
/*     */   }
/*     */ 
/*     */   public static String a()
/*     */   {
/* 167 */     return "Android " + Build.VERSION.RELEASE;
/*     */   }
/*     */ 
/*     */   public static String b()
/*     */   {
/*     */     String str;
/*     */     int i;
/* 173 */     if ((
/* 173 */       i = (
/* 172 */       str = e())
/* 172 */       .indexOf("-")) != 
/* 173 */       -1) {
/* 174 */       str = str.substring(0, i);
/*     */     }
/*     */ 
/* 177 */     if ((
/* 177 */       i = str.indexOf("\n")) != 
/* 177 */       -1) {
/* 178 */       str = str.substring(0, i);
/*     */     }
/* 180 */     return "Linux " + str;
/*     */   }
/*     */ 
/*     */   private static String e()
/*     */   {
/*     */     try {
/* 187 */       BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
/*     */       Matcher localMatcher;
/*     */       try {
/* 190 */         String str = localBufferedReader.readLine();
/*     */ 
/* 192 */         localBufferedReader.close(); } finally { localBufferedReader.close(); }
/*     */ 
/*     */ 
/* 212 */       return "Unavailable";
/* 213 */       if (localMatcher.groupCount() < 4) {
/* 214 */         return "Unavailable";
/*     */       }
/* 216 */       return localMatcher.group(1) + "\n" + localMatcher.group(2) + " " + localMatcher.group(3) + "\n" + localMatcher.group(4);
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*     */     }
/* 221 */     return "Unavailable";
/*     */   }
/*     */ 
/*     */   public static String d(Context paramContext)
/*     */   {
/* 229 */     return paramContext.getResources()
/* 227 */       .getConfiguration().locale
/* 229 */       .toString();
/*     */   }
/*     */ 
/*     */   public static String e(Context paramContext) {
/* 233 */     Object localObject = new DisplayMetrics(); ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject); paramContext = (Context)localObject;
/* 234 */     (
/* 235 */       localObject = new StringBuilder())
/* 235 */       .append(paramContext.widthPixels);
/* 236 */     ((StringBuilder)localObject).append("*");
/* 237 */     ((StringBuilder)localObject).append(paramContext.heightPixels);
/*     */ 
/* 239 */     return ((StringBuilder)localObject).toString();
/*     */   }
/*     */ 
/*     */   private static DisplayMetrics h(Context paramContext) {
/* 243 */     DisplayMetrics localDisplayMetrics = new DisplayMetrics();
/* 244 */     ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay()
/* 246 */       .getMetrics(localDisplayMetrics);
/*     */ 
/* 248 */     return localDisplayMetrics;
/*     */   }
/*     */ 
/*     */   private static boolean a(Context paramContext, String paramString1, String paramString2) {
/*     */     try {
/* 253 */       paramContext = paramContext.getAssets().open(paramString1);
/*     */ 
/* 258 */       (
/* 259 */         paramString1 = new File(paramString2))
/* 259 */         .createNewFile();
/* 260 */       paramString1 = new FileOutputStream(paramString1);
/*     */ 
/* 262 */       paramString2 = new byte[1024];
/* 263 */       int i = 0;
/* 264 */       while ((i = paramContext.read(paramString2)) > 0) {
/* 265 */         paramString1.write(paramString2, 0, i);
/*     */       }
/*     */ 
/* 268 */       paramString1.close();
/* 269 */       paramContext.close();
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/* 274 */       return false;
/*     */     }
/*     */ 
/* 277 */     return true;
/*     */   }
/*     */ 
/*     */   public static void a(Activity paramActivity, String paramString) {
/* 281 */     String str = paramString; Object localObject = "777";
/*     */     try { localObject = "chmod " + (String)localObject + " " + str; Runtime.getRuntime().exec((String)localObject); } catch (IOException localIOException) {
/* 282 */     }(
/* 283 */       localObject = new Intent("android.intent.action.VIEW"))
/* 283 */       .addFlags(268435456);
/* 284 */     ((Intent)localObject).setDataAndType(Uri.parse("file://" + paramString), "application/vnd.android.package-archive");
/*     */ 
/* 286 */     paramActivity.startActivity((Intent)localObject);
/*     */   }
/*     */ 
/*     */   public static boolean b(Context paramContext, String paramString) {
/* 290 */     boolean bool = false;
/*     */     try
/*     */     {
/* 295 */       if (paramContext.getPackageManager()
/* 293 */         .getPackageArchiveInfo(paramString, 1) != null)
/*     */       {
/* 296 */         bool = true;
/*     */       }
/* 298 */       else bool = false; 
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 301 */       bool = false;
/*     */     }
/* 303 */     return bool;
/*     */   }
/*     */ 
/*     */   public static String c()
/*     */   {
/*     */     String str;
/* 309 */     return (
/* 308 */       str = GlobalConstants.b)
/* 308 */       .substring(0, str.indexOf("://"));
/*     */   }
/*     */ 
/*     */   public static String f(Context paramContext)
/*     */   {
/* 313 */     String str = "-1;-1";
/*     */     try
/*     */     {
/* 319 */       if ((
/* 319 */         paramContext = (GsmCellLocation)((TelephonyManager)paramContext.getSystemService("phone"))
/* 318 */         .getCellLocation()) != null)
/*     */       {
/* 320 */         int i = paramContext.getCid();
/* 321 */         paramContext = paramContext.getLac();
/*     */         StringBuilder localStringBuilder;
/* 323 */         (
/* 324 */           localStringBuilder = new StringBuilder())
/* 324 */           .append(paramContext);
/* 325 */         localStringBuilder.append(";");
/* 326 */         localStringBuilder.append(i);
/*     */ 
/* 328 */         str = localStringBuilder.toString();
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/* 333 */     return str;
/*     */   }
/*     */ 
/*     */   public static String d() {
/* 337 */     Random localRandom = new Random();
/* 338 */     StringBuffer localStringBuffer = new StringBuffer();
/* 339 */     for (int i = 0; i < 24; i++) {
/* 340 */       int j = localRandom.nextInt(3);
/* 341 */       long l = 0L;
/* 342 */       switch (j) {
/*     */       case 0:
/* 344 */         l = Math.round(Math.random() * 25.0D + 65.0D);
/* 345 */         localStringBuffer.append(String.valueOf((char)(int)l));
/* 346 */         break;
/*     */       case 1:
/* 348 */         l = Math.round(Math.random() * 25.0D + 97.0D);
/* 349 */         localStringBuffer.append(String.valueOf((char)(int)l));
/* 350 */         break;
/*     */       case 2:
/* 352 */         localStringBuffer.append(String.valueOf(new Random().nextInt(10)));
/*     */       }
/*     */     }
/*     */ 
/* 356 */     return localStringBuffer.toString();
/*     */   }
/*     */ 
/*     */   private static int b(String paramString1, String paramString2) {
/* 360 */     ArrayList localArrayList1 = new ArrayList();
/* 361 */     ArrayList localArrayList2 = new ArrayList();
/* 362 */     localArrayList1.addAll(Arrays.asList(paramString1.split("\\.")));
/* 363 */     localArrayList2.addAll(Arrays.asList(paramString2.split("\\.")));
/*     */ 
/* 365 */     paramString1 = Math.max(localArrayList1.size(), localArrayList2.size());
/*     */ 
/* 367 */     while (localArrayList1.size() < paramString1) {
/* 368 */       localArrayList1.add("0");
/*     */     }
/*     */ 
/* 371 */     while (localArrayList2.size() < paramString1) {
/* 372 */       localArrayList2.add("0");
/*     */     }
/*     */ 
/* 375 */     for (paramString2 = 0; paramString2 < paramString1; paramString2++) {
/* 376 */       if (Integer.parseInt((String)localArrayList1.get(paramString2)) != Integer.parseInt((String)localArrayList2.get(paramString2))) {
/* 377 */         return Integer.parseInt((String)localArrayList1.get(paramString2)) - Integer.parseInt((String)localArrayList2.get(paramString2));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 384 */     return 0;
/*     */   }
/*     */ 
/*     */   public static boolean a(String paramString)
/*     */   {
/* 397 */     return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$")
/* 396 */       .matcher(paramString)
/* 397 */       .matches();
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.Utils
 * JD-Core Version:    0.6.2
 */