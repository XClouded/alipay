/*     */ package com.alipay.sdk.tid;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.sys.GlobalContext;
/*     */ import com.alipay.sdk.util.DeviceInfo;
/*     */ 
/*     */ public class TidInfo
/*     */ {
/*     */   private static TidInfo a;
/*     */   private String b;
/*     */   private String c;
/*     */ 
/*     */   public final String a()
/*     */   {
/*  31 */     return this.b;
/*     */   }
/*     */ 
/*     */   public final void a(String paramString)
/*     */   {
/*  39 */     this.b = paramString;
/*     */   }
/*     */ 
/*     */   public final String b()
/*     */   {
/*  46 */     return this.c;
/*     */   }
/*     */ 
/*     */   public final void b(String paramString)
/*     */   {
/*  54 */     this.c = paramString;
/*     */   }
/*     */ 
/*     */   public final void a(Context paramContext) {
/*  58 */     TidDbHelper localTidDbHelper = new TidDbHelper(paramContext);
/*     */     try { String str = DeviceInfo.a(paramContext).a();
/*  61 */       paramContext = DeviceInfo.a(paramContext).b();
/*  62 */       localTidDbHelper.a(str, paramContext, this.b, this.c);
/*     */       return; } catch (Exception localException) {
/*  66 */       return; } finally { localTidDbHelper.close(); } throw paramContext;
/*     */   }
/*     */ 
/*     */   private boolean e()
/*     */   {
/*  71 */     return TextUtils.isEmpty(this.b);
/*     */   }
/*     */ 
/*     */   public static synchronized TidInfo c() {
/*  75 */     if (a == null) {
/*  76 */       a = new TidInfo();
/*  77 */       Object localObject = GlobalContext.a().b();
/*  78 */       TidDbHelper localTidDbHelper = new TidDbHelper((Context)localObject);
/*     */ 
/*  80 */       String str1 = DeviceInfo.a((Context)localObject).a();
/*  81 */       localObject = DeviceInfo.a((Context)localObject).b();
/*  82 */       a.b = localTidDbHelper.b(str1, (String)localObject);
/*  83 */       a.c = localTidDbHelper.c(str1, (String)localObject);
/*  84 */       if (TextUtils.isEmpty(a.c))
/*     */       {
/*  85 */         String str2;
/*  85 */         if ((str2 = Long.toHexString(System.currentTimeMillis())).length() > 10) str2 = str2.substring(str2.length() - 10); a.c = str2;
/*     */       }
/*  87 */       localTidDbHelper.a(str1, (String)localObject, a.b, a.c);
/*     */     }
/*  89 */     return a;
/*     */   }
/*     */ 
/*     */   public static void d()
/*     */   {
/*     */     Object localObject;
/*  94 */     String str1 = DeviceInfo.a(localObject = GlobalContext.a().b())
/*  94 */       .a();
/*  95 */     String str2 = DeviceInfo.a((Context)localObject).b();
/*     */ 
/*  97 */     (
/*  98 */       localObject = new TidDbHelper((Context)localObject))
/*  98 */       .a(str1, str2);
/*  99 */     ((TidDbHelper)localObject).close();
/*     */   }
/*     */ 
/*     */   private static String f()
/*     */   {
/*     */     String str;
/* 105 */     if ((
/* 105 */       str = Long.toHexString(System.currentTimeMillis()))
/* 105 */       .length() > 10) {
/* 106 */       str = str.substring(str.length() - 10);
/*     */     }
/* 108 */     return str;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.tid.TidInfo
 * JD-Core Version:    0.6.2
 */