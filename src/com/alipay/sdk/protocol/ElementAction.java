/*     */ package com.alipay.sdk.protocol;
/*     */ 
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.cons.GlobalConstants;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class ElementAction
/*     */ {
/*     */   private String a;
/*     */   private String b;
/*     */   private String c;
/*     */   private String d;
/*     */   private String e;
/*     */   private boolean f;
/*  26 */   private boolean g = true;
/*  27 */   private boolean h = true;
/*     */   private String i;
/*     */   private String j;
/*     */   private String k;
/*     */   private JSONObject l;
/*     */ 
/*     */   private ElementAction(String paramString)
/*     */   {
/*  34 */     this.a = paramString;
/*     */   }
/*     */ 
/*     */   public final JSONObject a()
/*     */   {
/*  39 */     return this.l;
/*     */   }
/*     */ 
/*     */   public final String b() {
/*  43 */     return this.k;
/*     */   }
/*     */ 
/*     */   public final String c() {
/*  47 */     return this.i;
/*     */   }
/*     */ 
/*     */   public final String d() {
/*  51 */     return this.j;
/*     */   }
/*     */ 
/*     */   private static ElementAction a(JSONObject paramJSONObject) {
/*  55 */     String str1 = null;
/*  56 */     if ((paramJSONObject != null) && (paramJSONObject.has("name"))) {
/*  57 */       str1 = paramJSONObject.optString("name");
/*     */     }
/*  59 */     String str2 = null;
/*  60 */     if ((paramJSONObject != null) && (paramJSONObject.has("host"))) {
/*  61 */       str2 = paramJSONObject.optString("host");
/*     */     }
/*  63 */     String str3 = null;
/*  64 */     if ((paramJSONObject != null) && (paramJSONObject.has("params"))) {
/*  65 */       str3 = paramJSONObject.optString("params");
/*     */     }
/*  67 */     String str4 = null;
/*  68 */     if ((paramJSONObject != null) && (paramJSONObject.has("enctype"))) {
/*  69 */       str4 = paramJSONObject.optString("enctype");
/*     */     }
/*  71 */     String str5 = null;
/*  72 */     if ((paramJSONObject != null) && (paramJSONObject.has("request_param"))) {
/*  73 */       str5 = paramJSONObject.optString("request_param");
/*     */     }
/*  75 */     boolean bool1 = true;
/*  76 */     if ((paramJSONObject != null) && (paramJSONObject.has("validate"))) {
/*  77 */       bool1 = paramJSONObject.optBoolean("validate", true);
/*     */     }
/*     */ 
/*  80 */     boolean bool2 = true;
/*  81 */     if ((paramJSONObject != null) && (paramJSONObject.has("https"))) {
/*  82 */       bool2 = !paramJSONObject.optBoolean("https");
/*     */     }
/*     */ 
/*  85 */     boolean bool3 = true;
/*  86 */     if ((paramJSONObject != null) && (paramJSONObject.has("formSubmit"))) {
/*  87 */       bool3 = paramJSONObject.optBoolean("formSubmit");
/*     */     }
/*     */ 
/*  90 */     String str6 = "";
/*  91 */     if ((paramJSONObject != null) && (paramJSONObject.has("namespace"))) {
/*  92 */       str6 = paramJSONObject.optString("namespace");
/*     */     }
/*     */ 
/*  95 */     String str7 = "";
/*  96 */     if ((paramJSONObject != null) && (paramJSONObject.has("apiVersion"))) {
/*  97 */       str7 = paramJSONObject.optString("apiVersion");
/*     */     }
/*     */ 
/* 100 */     String str8 = "";
/* 101 */     if ((paramJSONObject != null) && (paramJSONObject.has("apiName"))) {
/* 102 */       str8 = paramJSONObject.optString("apiName");
/*     */     }
/*     */ 
/* 105 */     return a(str1, str2, str3, str4, str5, bool1, bool2, bool3, str6, str7, str8, paramJSONObject);
/*     */   }
/*     */ 
/*     */   public static ElementAction a(JSONObject paramJSONObject, String paramString)
/*     */   {
/* 111 */     paramJSONObject = paramJSONObject.optJSONObject(paramString);
/* 111 */     paramString = null; if ((paramJSONObject != null) && (paramJSONObject.has("name"))) paramString = paramJSONObject.optString("name"); String str1 = null; if ((paramJSONObject != null) && (paramJSONObject.has("host"))) str1 = paramJSONObject.optString("host"); String str2 = null; if ((paramJSONObject != null) && (paramJSONObject.has("params"))) str2 = paramJSONObject.optString("params"); String str3 = null; if ((paramJSONObject != null) && (paramJSONObject.has("enctype"))) str3 = paramJSONObject.optString("enctype"); String str4 = null; if ((paramJSONObject != null) && (paramJSONObject.has("request_param"))) str4 = paramJSONObject.optString("request_param"); boolean bool1 = true; if ((paramJSONObject != null) && (paramJSONObject.has("validate"))) bool1 = paramJSONObject.optBoolean("validate", true); boolean bool2 = true; if ((paramJSONObject != null) && (paramJSONObject.has("https"))) bool2 = !paramJSONObject.optBoolean("https"); boolean bool3 = true; if ((paramJSONObject != null) && (paramJSONObject.has("formSubmit"))) bool3 = paramJSONObject.optBoolean("formSubmit"); String str5 = ""; if ((paramJSONObject != null) && (paramJSONObject.has("namespace"))) str5 = paramJSONObject.optString("namespace"); String str6 = ""; if ((paramJSONObject != null) && (paramJSONObject.has("apiVersion"))) str6 = paramJSONObject.optString("apiVersion"); String str7 = ""; if ((paramJSONObject != null) && (paramJSONObject.has("apiName"))) str7 = paramJSONObject.optString("apiName"); return a(paramString, str1, str2, str3, str4, bool1, bool2, bool3, str5, str6, str7, paramJSONObject);
/*     */   }
/*     */ 
/*     */   private static ElementAction a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString6, String paramString7, String paramString8, JSONObject paramJSONObject)
/*     */   {
/* 118 */     if (TextUtils.isEmpty(paramString1))
/* 119 */       return null;
/*     */     ElementAction localElementAction;
/* 121 */     (
/* 122 */       localElementAction = new ElementAction(paramString1)).a = 
/* 122 */       paramString1;
/* 123 */     localElementAction.b = (TextUtils.isEmpty(paramString2) ? null : paramString2.trim());
/* 124 */     localElementAction.c = paramString3;
/* 125 */     localElementAction.d = paramString4;
/* 126 */     localElementAction.e = paramString5;
/* 127 */     localElementAction.f = paramBoolean1;
/* 128 */     localElementAction.g = paramBoolean2;
/* 129 */     localElementAction.h = paramBoolean3;
/* 130 */     localElementAction.i = paramString6;
/* 131 */     localElementAction.j = paramString7;
/* 132 */     localElementAction.k = paramString8;
/* 133 */     localElementAction.l = paramJSONObject;
/* 134 */     return localElementAction;
/*     */   }
/*     */ 
/*     */   public static ElementAction a(String paramString, ActionType paramActionType) {
/* 138 */     return a(paramString, paramActionType.f(), paramActionType.l(), paramActionType.g(), paramActionType.h(), paramActionType.i(), paramActionType.j(), paramActionType.k(), paramActionType.c(), paramActionType.d(), paramActionType.b(), paramActionType.a());
/*     */   }
/*     */ 
/*     */   public final String e()
/*     */   {
/* 146 */     return this.a;
/*     */   }
/*     */ 
/*     */   public final String f() {
/* 150 */     if (TextUtils.isEmpty(this.b)) {
/* 151 */       this.b = GlobalConstants.b;
/*     */     }
/* 153 */     return this.b;
/*     */   }
/*     */ 
/*     */   public final String g() {
/* 157 */     return this.c;
/*     */   }
/*     */ 
/*     */   public final JSONObject h() {
/* 161 */     JSONObject localJSONObject = null;
/*     */     try {
/* 163 */       localJSONObject = new JSONObject(this.c);
/*     */     } catch (Exception localException) {
/*     */     }
/* 166 */     return localJSONObject;
/*     */   }
/*     */ 
/*     */   public final String i() {
/* 170 */     return this.d;
/*     */   }
/*     */ 
/*     */   public final String j() {
/* 174 */     return this.e;
/*     */   }
/*     */ 
/*     */   public final boolean k() {
/* 178 */     return this.f;
/*     */   }
/*     */ 
/*     */   public final boolean l() {
/* 182 */     return this.g;
/*     */   }
/*     */ 
/*     */   public final boolean m() {
/* 186 */     return this.h;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.ElementAction
 * JD-Core Version:    0.6.2
 */