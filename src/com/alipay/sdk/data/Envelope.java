/*     */ package com.alipay.sdk.data;
/*     */ 
/*     */ public class Envelope
/*     */ {
/*     */   private String a;
/*     */   private String b;
/*     */   private String c;
/*     */   private String d;
/*  21 */   private String e = "com.alipay.mcpay";
/*     */ 
/*     */   public final String a()
/*     */   {
/*  25 */     return this.e;
/*     */   }
/*     */ 
/*     */   public final void a(String paramString) {
/*  29 */     this.e = paramString;
/*     */   }
/*     */ 
/*     */   public final String b()
/*     */   {
/*  36 */     return this.a;
/*     */   }
/*     */ 
/*     */   public final void b(String paramString)
/*     */   {
/*  44 */     this.a = paramString;
/*     */   }
/*     */ 
/*     */   public final String c()
/*     */   {
/*  51 */     return this.b;
/*     */   }
/*     */ 
/*     */   public final void c(String paramString)
/*     */   {
/*  59 */     this.b = paramString;
/*     */   }
/*     */ 
/*     */   public final String d()
/*     */   {
/*  66 */     return this.c;
/*     */   }
/*     */ 
/*     */   public final void d(String paramString)
/*     */   {
/*  74 */     this.c = paramString;
/*     */   }
/*     */ 
/*     */   public final String e()
/*     */   {
/*  81 */     return this.d;
/*     */   }
/*     */ 
/*     */   public final void e(String paramString)
/*     */   {
/*  89 */     this.d = paramString;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  97 */     return "requestUrl = " + this.a + ", namespace = " + this.b + ", apiName = " + this.c + ", apiVersion = " + this.d;
/*     */   }
/*     */ 
/*     */   private static String f(String paramString)
/*     */   {
/* 102 */     return paramString;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.data.Envelope
 * JD-Core Version:    0.6.2
 */