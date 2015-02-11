/*     */ package com.alipay.sdk.data;
/*     */ 
/*     */ import android.os.Build;
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.util.JsonUtils;
/*     */ import java.lang.ref.WeakReference;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class Request
/*     */ {
/*     */   private Envelope a;
/*     */   private JSONObject b;
/*     */   private JSONObject c;
/*     */   private long d;
/*  26 */   private WeakReference e = null;
/*  27 */   private boolean f = true;
/*     */ 
/*  30 */   private boolean g = true;
/*     */ 
/*     */   public final void a(boolean paramBoolean) {
/*  33 */     this.g = paramBoolean;
/*     */   }
/*     */ 
/*     */   private boolean e() {
/*  37 */     return this.g;
/*     */   }
/*     */ 
/*     */   public Request(Envelope paramEnvelope, JSONObject paramJSONObject)
/*     */   {
/*  50 */     this(paramEnvelope, paramJSONObject, (byte)0);
/*     */   }
/*     */ 
/*     */   private Request(Envelope paramEnvelope, JSONObject paramJSONObject, byte paramByte)
/*     */   {
/*  55 */     this.a = paramEnvelope;
/*  56 */     this.b = paramJSONObject;
/*  57 */     this.c = null;
/*  58 */     this.e = new WeakReference(null);
/*     */   }
/*     */ 
/*     */   public final String a()
/*     */   {
/*  65 */     return this.a.b();
/*     */   }
/*     */ 
/*     */   private void b(boolean paramBoolean) {
/*  69 */     this.f = paramBoolean;
/*     */   }
/*     */ 
/*     */   private long f()
/*     */   {
/*  76 */     return this.d;
/*     */   }
/*     */ 
/*     */   private void a(long paramLong)
/*     */   {
/*  84 */     this.d = paramLong;
/*     */   }
/*     */ 
/*     */   public final InteractionData b() {
/*  88 */     return (InteractionData)this.e.get();
/*     */   }
/*     */ 
/*     */   public final void a(InteractionData paramInteractionData) {
/*  92 */     this.e = new WeakReference(paramInteractionData);
/*     */   }
/*     */ 
/*     */   private void a(JSONObject paramJSONObject) {
/*  96 */     this.c = paramJSONObject;
/*     */   }
/*     */ 
/*     */   public final JSONObject a(String paramString)
/*     */   {
/* 105 */     JSONObject localJSONObject1 = new JSONObject();
/*     */     try
/*     */     {
/*     */       JSONObject localJSONObject2;
/* 107 */       (
/* 108 */         localJSONObject2 = new JSONObject())
/* 108 */         .put("device", Build.MODEL);
/*     */ 
/* 110 */       JSONObject localJSONObject3 = new JSONObject();
/* 111 */       (
/* 112 */         localJSONObject2 = JsonUtils.a(localJSONObject2, this.c))
/* 112 */         .put("namespace", this.a.c());
/* 113 */       localJSONObject2.put("api_name", this.a.a());
/* 114 */       localJSONObject2.put("api_version", this.a.e());
/* 115 */       if (this.b == null) {
/* 116 */         this.b = new JSONObject();
/*     */       }
/* 118 */       this.b.put("action", localJSONObject3);
/*     */       Object localObject;
/* 120 */       if (!TextUtils.isEmpty(localObject = this.a.d()))
/*     */         try
/*     */         {
/* 122 */           localObject = ((String)localObject).split("/");
/* 123 */           localJSONObject3.put("type", localObject[1]);
/* 124 */           if (localObject.length > 1)
/* 125 */             localJSONObject3.put("method", localObject[2]);
/*     */         }
/*     */         catch (Exception localException2)
/*     */         {
/*     */         }
/* 130 */       this.b.put("gzip", this.g);
/* 131 */       if (this.f) {
/* 132 */         localObject = new JSONObject();
/* 133 */         new StringBuilder("requestData before: ").append(this.b.toString()).toString();
/* 134 */         ((JSONObject)localObject).put("req_data", JsonUtils.a(paramString, this.b.toString()));
/*     */ 
/* 138 */         localJSONObject2.put("params", localObject);
/*     */       } else {
/* 140 */         localJSONObject2.put("params", this.b);
/*     */       }
/* 142 */       localJSONObject1.put("data", localJSONObject2);
/*     */     } catch (Exception localException1) {
/*     */     }
/* 145 */     new StringBuilder("requestData : ").append(localJSONObject1.toString()).toString();
/*     */ 
/* 148 */     return localJSONObject1;
/*     */   }
/*     */ 
/*     */   public final boolean c() {
/* 152 */     return this.f;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 157 */     return this.a.toString() + ", requestData = " + JsonUtils.a(this.b, this.c) + ", timeStamp = " + this.d;
/*     */   }
/*     */ 
/*     */   public final Envelope d()
/*     */   {
/* 163 */     return this.a;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.data.Request
 * JD-Core Version:    0.6.2
 */