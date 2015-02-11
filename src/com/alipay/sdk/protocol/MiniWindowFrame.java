/*     */ package com.alipay.sdk.protocol;
/*     */ 
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.data.Request;
/*     */ import com.alipay.sdk.data.Response;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class MiniWindowFrame extends WindowData
/*     */ {
/*     */   private int i;
/*  23 */   private boolean j = false;
/*     */ 
/*     */   protected MiniWindowFrame(Request paramRequest, Response paramResponse) {
/*  26 */     super(paramRequest, paramResponse);
/*     */   }
/*     */ 
/*     */   public final boolean d()
/*     */   {
/*  37 */     return (this.i == 4) || (this.i == 9);
/*     */   }
/*     */ 
/*     */   public final int e()
/*     */   {
/*  47 */     return this.i;
/*     */   }
/*     */ 
/*     */   public final String f()
/*     */   {
/*  57 */     return null;
/*     */   }
/*     */ 
/*     */   private boolean g() {
/*  61 */     return this.j;
/*     */   }
/*     */ 
/*     */   public final void a(JSONObject paramJSONObject)
/*     */   {
/*  66 */     super.a(paramJSONObject);
/*  67 */     if (paramJSONObject.has("form"))
/*     */     {
/*  69 */       String str = (
/*  69 */         paramJSONObject = paramJSONObject.optJSONObject("form"))
/*  69 */         .optString("type");
/*  70 */       int m = Boolean.parseBoolean(paramJSONObject.optString("oneTime"));
/*     */ 
/*  72 */       this.h = m;
/*  73 */       if (TextUtils.equals("page", str))
/*     */       {
/*  75 */         this.j = true;
/*  76 */         this.i = 9; return;
/*  77 */       }if (TextUtils.equals("dialog", str)) {
/*  78 */         this.i = 7;
/*  79 */         this.j = false;
/*     */         return;
/*     */       }
/*     */       int k;
/*  80 */       if (TextUtils.equals("toast", str))
/*     */       {
/*  82 */         paramJSONObject = ElementAction.a(paramJSONObject, "onload");
/*     */ 
/*  84 */         this.i = 6;
/*  85 */         if (paramJSONObject != null)
/*     */         {
/*  87 */           k = (paramJSONObject = ActionType.a(paramJSONObject)).length;
/*  87 */           for (m = 0; m < k; m++)
/*     */           {
/*     */             Object localObject;
/*  88 */             if (((
/*  88 */               localObject = paramJSONObject[m]) == 
/*  88 */               ActionType.d) || (localObject == ActionType.e)) {
/*  89 */               this.i = 10;
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*  94 */         return; } if (!TextUtils.equals("confirm", k))
/*     */       {
/*  97 */         this.j = TextUtils.equals(k, "fullscreen");
/*  98 */         this.i = 4;
/*     */       }
/* 100 */       return;
/*     */     }
/*     */ 
/* 103 */     if (MiniStatus.a(paramJSONObject.optString("status")) == 
/* 103 */       MiniStatus.c) {
/* 104 */       this.i = -10; return;
/*     */     }
/* 106 */     this.i = 8;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.MiniWindowFrame
 * JD-Core Version:    0.6.2
 */