/*     */ package com.alipay.sdk.sys;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.location.Location;
/*     */ import android.location.LocationManager;
/*     */ 
/*     */ public class UserLocation
/*     */ {
/*  18 */   private static double a = -1.0D;
/*     */ 
/*  22 */   private static double b = -1.0D;
/*     */ 
/*     */   private static void a(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/*  34 */       if ((
/*  34 */         paramContext = (LocationManager)paramContext.getSystemService("location"))
/*  34 */         .isProviderEnabled("gps"))
/*     */       {
/*  37 */         if ((
/*  37 */           paramContext = paramContext.getLastKnownLocation("gps")) != null)
/*     */         {
/*  38 */           a = paramContext.getLatitude();
/*  39 */           b = paramContext.getLongitude();
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  82 */       return;
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private static double b() {
/*  90 */     return a;
/*     */   }
/*     */ 
/*     */   private static double c()
/*     */   {
/*  98 */     return b;
/*     */   }
/*     */ 
/*     */   public static String a() {
/* 102 */     return b + ";" + a;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.sys.UserLocation
 * JD-Core Version:    0.6.2
 */