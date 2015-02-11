/*     */ package com.alipay.sdk.data;
/*     */ 
/*     */ import org.apache.http.Header;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class Response
/*     */ {
/*     */   public static final int a = 1000;
/*     */   public static final int b = 503;
/*     */   public static final int c = 0;
/*  22 */   private int f = 0;
/*  23 */   private String g = "";
/*  24 */   private long h = 0L;
/*  25 */   private String i = "";
/*  26 */   private String j = null;
/*  27 */   private String k = null;
/*     */ 
/*  29 */   private JSONObject l = null;
/*     */   private String m;
/*  33 */   private boolean n = true;
/*     */ 
/*  38 */   Envelope d = null;
/*     */ 
/*  43 */   Header[] e = null;
/*     */ 
/*     */   public final Envelope a()
/*     */   {
/*  52 */     return this.d;
/*     */   }
/*     */ 
/*     */   public final void b() {
/*  56 */     this.n = false;
/*     */   }
/*     */ 
/*     */   private boolean e() {
/*  60 */     return this.n;
/*     */   }
/*     */ 
/*     */   public final int c() {
/*  64 */     return this.f;
/*     */   }
/*     */ 
/*     */   public final void a(int paramInt) {
/*  68 */     this.f = paramInt;
/*     */   }
/*     */ 
/*     */   public final String d() {
/*  72 */     return this.g;
/*     */   }
/*     */ 
/*     */   public final void a(String paramString) {
/*  76 */     this.g = paramString;
/*     */   }
/*     */ 
/*     */   private String f() {
/*  80 */     return this.i;
/*     */   }
/*     */ 
/*     */   public final void b(String paramString) {
/*  84 */     this.i = paramString;
/*     */   }
/*     */ 
/*     */   private String g() {
/*  88 */     return this.j;
/*     */   }
/*     */ 
/*     */   public final void c(String paramString) {
/*  92 */     this.j = paramString;
/*     */   }
/*     */ 
/*     */   private String h() {
/*  96 */     return this.k;
/*     */   }
/*     */ 
/*     */   public final void d(String paramString) {
/* 100 */     this.k = paramString;
/*     */   }
/*     */ 
/*     */   public final void a(long paramLong) {
/* 104 */     this.h = paramLong;
/*     */   }
/*     */ 
/*     */   public final void a(JSONObject paramJSONObject) {
/* 108 */     this.l = paramJSONObject;
/*     */   }
/*     */ 
/*     */   public final void e(String paramString) {
/* 112 */     this.m = paramString;
/*     */   }
/*     */ 
/*     */   private String i() {
/* 116 */     return this.m;
/*     */   }
/*     */ 
/*     */   public final void a(Envelope paramEnvelope) {
/* 120 */     this.d = paramEnvelope;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 128 */     String str = this.d.toString() + ", code = " + this.f + ", errorMsg = " + this.g + ", timeStamp = " + this.h + ", endCode = " + this.i;
/*     */ 
/* 132 */     if (this.l != null) {
/* 133 */       str = str + ", reflectedData = " + this.l;
/*     */     }
/*     */ 
/* 136 */     return str;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.data.Response
 * JD-Core Version:    0.6.2
 */