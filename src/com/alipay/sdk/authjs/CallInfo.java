/*     */ package com.alipay.sdk.authjs;
/*     */ 
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class CallInfo
/*     */ {
/*     */   public static final String a = "CallInfo";
/*     */   public static final String b = "call";
/*     */   public static final String c = "callback";
/*     */   public static final String d = "bundleName";
/*     */   public static final String e = "clientId";
/*     */   public static final String f = "param";
/*     */   public static final String g = "func";
/*     */   public static final String h = "msgType";
/*     */   private String i;
/*     */   private String j;
/*     */   private String k;
/*     */   private String l;
/*     */   private JSONObject m;
/*  58 */   private boolean n = false;
/*     */ 
/*     */   private static String a(CallError paramCallError)
/*     */   {
/*  29 */     switch (1.a[paramCallError.ordinal()])
/*     */     {
/*     */     case 1:
/*  32 */       paramCallError = "function not found";
/*  33 */       break;
/*     */     case 2:
/*  35 */       paramCallError = "invalid parameter";
/*  36 */       break;
/*     */     case 3:
/*  38 */       paramCallError = "runtime error";
/*  39 */       break;
/*     */     default:
/*  41 */       paramCallError = "none";
/*     */     }
/*     */ 
/*  45 */     return paramCallError;
/*     */   }
/*     */ 
/*     */   private boolean e()
/*     */   {
/*  61 */     return this.n;
/*     */   }
/*     */ 
/*     */   private void a(boolean paramBoolean) {
/*  65 */     this.n = paramBoolean;
/*     */   }
/*     */ 
/*     */   public CallInfo(String paramString) {
/*  69 */     this.l = paramString;
/*     */   }
/*     */ 
/*     */   public final String a() {
/*  73 */     return this.i;
/*     */   }
/*     */ 
/*     */   public final void a(String paramString) {
/*  77 */     this.i = paramString;
/*     */   }
/*     */ 
/*     */   private String f() {
/*  81 */     return this.j;
/*     */   }
/*     */ 
/*     */   public final void b(String paramString) {
/*  85 */     this.j = paramString;
/*     */   }
/*     */ 
/*     */   public final String b() {
/*  89 */     return this.k;
/*     */   }
/*     */ 
/*     */   public final void c(String paramString) {
/*  93 */     this.k = paramString;
/*     */   }
/*     */ 
/*     */   private String g() {
/*  97 */     return this.l;
/*     */   }
/*     */ 
/*     */   private void d(String paramString) {
/* 101 */     this.l = paramString;
/*     */   }
/*     */ 
/*     */   public final JSONObject c() {
/* 105 */     return this.m;
/*     */   }
/*     */ 
/*     */   public final void a(JSONObject paramJSONObject) {
/* 109 */     this.m = paramJSONObject;
/*     */   }
/*     */ 
/*     */   public final String d()
/*     */     throws JSONException
/*     */   {
/*     */     JSONObject localJSONObject;
/* 113 */     (
/* 114 */       localJSONObject = new JSONObject())
/* 114 */       .put("clientId", this.i);
/* 115 */     localJSONObject.put("func", this.k);
/* 116 */     localJSONObject.put("param", this.m);
/* 117 */     localJSONObject.put("msgType", this.l);
/* 118 */     return localJSONObject.toString();
/*     */   }
/*     */ 
/*     */   public static enum CallError
/*     */   {
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.authjs.CallInfo
 * JD-Core Version:    0.6.2
 */