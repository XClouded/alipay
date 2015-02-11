/*     */ package com.alipay.sdk.protocol;
/*     */ 
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.data.Envelope;
/*     */ import com.alipay.sdk.data.Request;
/*     */ import com.alipay.sdk.data.Response;
/*     */ import com.alipay.sdk.exception.AppErrorException;
/*     */ import com.alipay.sdk.exception.FailOperatingException;
/*     */ import com.alipay.sdk.exception.NetErrorException;
/*     */ import com.alipay.sdk.tid.TidInfo;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class MiniFrameFactory
/*     */ {
/*     */   public static MiniWindowFrame a(FrameData paramFrameData)
/*     */     throws NetErrorException, FailOperatingException, AppErrorException
/*     */   {
/*  34 */     Request localRequest = paramFrameData.a();
/*  35 */     Response localResponse = paramFrameData.b();
/*  36 */     JSONObject localJSONObject = paramFrameData.c();
/*  37 */     String str = "程序发生错误";
/*  38 */     MiniWindowFrame localMiniWindowFrame = null;
/*     */ 
/*  40 */     if (localJSONObject.has("form")) {
/*  41 */       (
/*  42 */         localMiniWindowFrame = new MiniWindowFrame(localRequest, localResponse))
/*  42 */         .a(paramFrameData.c());
/*  43 */     } else if (localJSONObject.has("status"))
/*     */     {
/*  45 */       paramFrameData = MiniStatus.a(localJSONObject.optString("status"));
/*     */ 
/*  46 */       switch (1.a[paramFrameData.ordinal()]) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*  50 */         (
/*  51 */           localMiniWindowFrame = new MiniWindowFrame(localRequest, localResponse))
/*  51 */           .a(localJSONObject);
/*  52 */         break;
/*     */       case 4:
/*  54 */         TidInfo.d();
/*  55 */         break;
/*     */       default:
/*  58 */         paramFrameData = TextUtils.isEmpty(paramFrameData = localJSONObject.optString("msg")) ? 
/*  58 */           str : paramFrameData;
/*  59 */         throw new FailOperatingException(paramFrameData);
/*     */       }
/*     */     } else { throw new FailOperatingException(str); }
/*     */ 
/*     */ 
/*  66 */     return localMiniWindowFrame;
/*     */   }
/*     */ 
/*     */   public final void b(FrameData paramFrameData) throws NetErrorException, FailOperatingException, AppErrorException
/*     */   {
/*  71 */     Response localResponse = paramFrameData.b();
/*  72 */     JSONObject localJSONObject = paramFrameData.c();
/*     */ 
/*  74 */     Object localObject1 = paramFrameData.a().d();
/*     */     Object localObject2;
/*  76 */     if (TextUtils.isEmpty((
/*  76 */       localObject2 = paramFrameData.b().a())
/*  76 */       .d())) {
/*  77 */       ((Envelope)localObject2).d(((Envelope)localObject1).d());
/*     */     }
/*  79 */     if (TextUtils.isEmpty(((Envelope)localObject2).e())) {
/*  80 */       ((Envelope)localObject2).e(((Envelope)localObject1).e());
/*     */     }
/*  82 */     if (TextUtils.isEmpty(((Envelope)localObject2).c())) {
/*  83 */       ((Envelope)localObject2).c(((Envelope)localObject1).c());
/*     */     }
/*  85 */     if (TextUtils.isEmpty(((Envelope)localObject2).b())) {
/*  86 */       ((Envelope)localObject2).b(((Envelope)localObject1).b());
/*     */     }
/*     */ 
/*  89 */     localObject1 = "session";
/*     */ 
/*  91 */     if ((
/*  91 */       localObject2 = localJSONObject.optJSONObject("reflected_data")) != null)
/*     */     {
/*  93 */       new StringBuilder("session = ").append(((JSONObject)localObject2).optString((String)localObject1, "")).toString();
/*  94 */       paramFrameData.b().a((JSONObject)localObject2);
/*  95 */     } else if (localJSONObject.has((String)localObject1)) {
/*  96 */       localObject2 = new JSONObject();
/*     */       try {
/*  98 */         ((JSONObject)localObject2).put((String)localObject1, localJSONObject.optString((String)localObject1));
/*     */ 
/* 100 */         if (!TextUtils.isEmpty(paramFrameData = TidInfo.c().a()))
/*     */         {
/* 101 */           ((JSONObject)localObject2).put("tid", paramFrameData);
/*     */         }
/* 103 */         localResponse.a((JSONObject)localObject2);
/*     */       } catch (JSONException localJSONException) {
/* 105 */         throw new AppErrorException(getClass(), "can not put reflected values");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 111 */     localResponse.b(localJSONObject.optString("end_code", "0"));
/* 112 */     localResponse.e(localJSONObject.optString("user_id", ""));
/* 113 */     paramFrameData = localJSONObject.optString("result");
/*     */     try {
/* 115 */       paramFrameData = URLDecoder.decode(localJSONObject.optString("result"), "UTF-8");
/*     */     } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
/*     */     }
/* 118 */     localResponse.c(paramFrameData);
/*     */ 
/* 121 */     localResponse.d(localJSONObject.optString("memo", ""));
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.MiniFrameFactory
 * JD-Core Version:    0.6.2
 */