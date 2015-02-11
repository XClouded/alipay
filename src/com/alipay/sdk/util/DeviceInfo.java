/*     */ package com.alipay.sdk.util;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.ConnectivityManager;
/*     */ import android.net.NetworkInfo;
/*     */ import android.text.TextUtils;
/*     */ 
/*     */ public class DeviceInfo
/*     */ {
/*     */   static final String a = "com.alipay.android.app";
/*     */   static final String b = "com.eg.android.AlipayGphone";
/*     */   static final String c = "com.eg.android.AlipayGphoneRC";
/*     */   private static final String d = "00:00:00:00:00:00";
/*     */   private String e;
/*     */   private String f;
/*     */   private String g;
/*  23 */   private static DeviceInfo h = null;
/*     */ 
/*     */   public static DeviceInfo a(Context paramContext) {
/*  26 */     if (h == null) {
/*  27 */       h = new DeviceInfo(paramContext);
/*     */     }
/*     */ 
/*  30 */     return h; } 
/*     */   // ERROR //
/*     */   private DeviceInfo(Context paramContext) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial 46	java/lang/Object:<init>	()V
/*     */     //   4: aload_1
/*     */     //   5: ldc 7
/*     */     //   7: invokevirtual 31	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   10: checkcast 16	android/telephony/TelephonyManager
/*     */     //   13: astore_2
/*     */     //   14: aload_0
/*     */     //   15: aload_2
/*     */     //   16: invokevirtual 37	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
/*     */     //   19: invokespecial 44	com/alipay/sdk/util/DeviceInfo:b	(Ljava/lang/String;)V
/*     */     //   22: aload_0
/*     */     //   23: aload_2
/*     */     //   24: invokevirtual 38	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
/*     */     //   27: astore_3
/*     */     //   28: astore_2
/*     */     //   29: aload_3
/*     */     //   30: ifnull +29 -> 59
/*     */     //   33: new 23	java/lang/StringBuilder
/*     */     //   36: dup
/*     */     //   37: invokespecial 50	java/lang/StringBuilder:<init>	()V
/*     */     //   40: aload_3
/*     */     //   41: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   44: ldc 1
/*     */     //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   49: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   52: iconst_0
/*     */     //   53: bipush 15
/*     */     //   55: invokevirtual 49	java/lang/String:substring	(II)Ljava/lang/String;
/*     */     //   58: astore_3
/*     */     //   59: aload_2
/*     */     //   60: aload_3
/*     */     //   61: putfield 25	com/alipay/sdk/util/DeviceInfo:e	Ljava/lang/String;
/*     */     //   64: aload_1
/*     */     //   65: ldc 8
/*     */     //   67: invokevirtual 31	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   70: checkcast 15	android/net/wifi/WifiManager
/*     */     //   73: aconst_null
/*     */     //   74: astore_1
/*     */     //   75: invokevirtual 36	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
/*     */     //   78: astore_1
/*     */     //   79: aload_0
/*     */     //   80: aload_1
/*     */     //   81: invokevirtual 35	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
/*     */     //   84: putfield 27	com/alipay/sdk/util/DeviceInfo:g	Ljava/lang/String;
/*     */     //   87: aload_0
/*     */     //   88: getfield 27	com/alipay/sdk/util/DeviceInfo:g	Ljava/lang/String;
/*     */     //   91: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
/*     */     //   94: ifeq +47 -> 141
/*     */     //   97: aload_0
/*     */     //   98: ldc 2
/*     */     //   100: putfield 27	com/alipay/sdk/util/DeviceInfo:g	Ljava/lang/String;
/*     */     //   103: return
/*     */     //   104: astore_2
/*     */     //   105: aload_0
/*     */     //   106: getfield 27	com/alipay/sdk/util/DeviceInfo:g	Ljava/lang/String;
/*     */     //   109: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
/*     */     //   112: ifeq +29 -> 141
/*     */     //   115: aload_0
/*     */     //   116: ldc 2
/*     */     //   118: putfield 27	com/alipay/sdk/util/DeviceInfo:g	Ljava/lang/String;
/*     */     //   121: return
/*     */     //   122: astore_1
/*     */     //   123: aload_0
/*     */     //   124: getfield 27	com/alipay/sdk/util/DeviceInfo:g	Ljava/lang/String;
/*     */     //   127: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
/*     */     //   130: ifeq +9 -> 139
/*     */     //   133: aload_0
/*     */     //   134: ldc 2
/*     */     //   136: putfield 27	com/alipay/sdk/util/DeviceInfo:g	Ljava/lang/String;
/*     */     //   139: aload_1
/*     */     //   140: athrow
/*     */     //   141: return
/*     */     //
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   4	87	104	java/lang/Exception
/*     */     //   4	87	122	finally } 
/*  54 */   public final String a() { if (TextUtils.isEmpty(this.e)) {
/*  55 */       this.e = "000000000000000";
/*     */     }
/*     */ 
/*  58 */     return this.e; }
/*     */ 
/*     */   public final String b()
/*     */   {
/*  62 */     if (TextUtils.isEmpty(this.f)) {
/*  63 */       this.f = "000000000000000";
/*     */     }
/*     */ 
/*  66 */     return this.f;
/*     */   }
/*     */ 
/*     */   private void a(String paramString) {
/*  70 */     if (paramString != null)
/*     */     {
/*  72 */       paramString = (paramString + "000000000000000")
/*  72 */         .substring(0, 15);
/*     */     }
/*     */ 
/*  75 */     this.e = paramString;
/*     */   }
/*     */ 
/*     */   private void b(String paramString) {
/*  79 */     if (paramString != null) {
/*  80 */       paramString = paramString.getBytes();
/*  81 */       for (int i = 0; i < paramString.length; i++) {
/*  82 */         if ((paramString[i] < 48) || (paramString[i] > 57)) {
/*  83 */           paramString[i] = 48;
/*     */         }
/*     */       }
/*     */ 
/*  87 */       paramString = new String(paramString);
/*     */ 
/*  89 */       paramString = (paramString + "000000000000000")
/*  89 */         .substring(0, 15);
/*     */     }
/*     */ 
/*  92 */     this.f = paramString;
/*     */   }
/*     */ 
/*     */   private String d()
/*     */   {
/*  97 */     String str1 = b();
/*     */ 
/* 101 */     str1 = str1 + "|";
/*     */     String str2;
/* 105 */     if (TextUtils.isEmpty(str2 = a()))
/*     */     {
/* 106 */       str1 = str1 + "000000000000000";
/*     */     }
/* 108 */     else str1 = str1 + str2;
/*     */ 
/* 110 */     return str1;
/*     */   }
/*     */ 
/*     */   public final String c() {
/* 114 */     return this.g;
/*     */   }
/*     */ 
/*     */   public static NetConnectionType b(Context paramContext)
/*     */   {
/* 124 */     paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
/*     */     try
/*     */     {
/* 128 */       if (((
/* 128 */         paramContext = paramContext.getActiveNetworkInfo()) != null) && 
/* 128 */         (paramContext.getType() == 0))
/*     */       {
/* 130 */         return NetConnectionType.a(paramContext.getSubtype());
/* 131 */       }if ((paramContext != null) && (paramContext.getType() == 1))
/*     */       {
/* 133 */         return NetConnectionType.a;
/*     */       }
/* 135 */       return NetConnectionType.o;
/*     */     } catch (Exception localException) {
/*     */     }
/* 138 */     return NetConnectionType.o;
/*     */   }
/*     */ 
/*     */   public static String c(Context paramContext)
/*     */   {
/* 143 */     String str = (paramContext = a(paramContext)).b(); str = str + "|"; if (TextUtils.isEmpty(paramContext = paramContext.a())) str = str + "000000000000000"; else str = str + paramContext;
/*     */ 
/* 146 */     return str
/* 144 */       .substring(0, 8);
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.DeviceInfo
 * JD-Core Version:    0.6.2
 */