/*     */ package com.alipay.sdk.data;
/*     */ 
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.cons.GlobalConstants;
/*     */ import com.alipay.sdk.exception.UnZipException;
/*     */ import com.alipay.sdk.sys.GlobalContext;
/*     */ import com.alipay.sdk.tid.TidInfo;
/*     */ import com.alipay.sdk.util.DeviceInfo;
/*     */ import com.alipay.sdk.util.JsonUtils;
/*     */ import com.alipay.sdk.util.Utils;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.message.BasicHeader;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class FrameUtils
/*     */ {
/*     */   private static final String a = "Msp-Param";
/*     */ 
/*     */   public static Request a(InteractionData paramInteractionData, String paramString, JSONObject paramJSONObject)
/*     */   {
/*  40 */     Object localObject1 = GlobalContext.a();
/*     */ 
/*  42 */     Object localObject2 = TidInfo.c();
/*     */ 
/*  44 */     paramJSONObject = JsonUtils.a(null, paramJSONObject);
/*     */     try {
/*  46 */       paramJSONObject.put("tid", ((TidInfo)localObject2).a());
/*     */ 
/*  48 */       paramJSONObject.put("user_agent", ((GlobalContext)localObject1).c().a((TidInfo)localObject2));
/*     */ 
/*  50 */       paramJSONObject.put("has_alipay", Utils.b(((GlobalContext)localObject1).b()));
/*     */ 
/*  52 */       paramJSONObject.put("has_msp_app", Utils.a(((GlobalContext)localObject1).b()));
/*     */ 
/*  55 */       paramJSONObject.put("external_info", paramString);
/*  56 */       paramJSONObject.put("app_key", "2014052600006128");
/*  57 */       paramJSONObject.put("utdid", ((GlobalContext)localObject1).g());
/*  58 */       paramJSONObject.put("new_client_key", ((TidInfo)localObject2).b()); } catch (JSONException localJSONException) {
/*     */     }
/*  60 */     localObject1 = paramJSONObject;
/*     */     Object localObject3;
/*  60 */     (localObject3 = new Envelope()).b(GlobalConstants.b); ((Envelope)localObject3).c("com.alipay.mobilecashier"); ((Envelope)localObject3).d("/cashier/main"); ((Envelope)localObject3).e("4.0.2"); Object localObject4 = null; if (localObject1 != null) (localObject4 = new Request((Envelope)localObject3, (JSONObject)localObject1)).a(true);
/*     */ 
/*  64 */     if ((
/*  64 */       paramJSONObject = localObject4) != null)
/*     */     {
/*  65 */       localObject3 = paramString; localObject2 = paramJSONObject; localObject1 = paramInteractionData; if ((!TextUtils.isEmpty((CharSequence)localObject3)) && ((localObject4 = ((String)localObject3).split("&")).length != 0)) { paramInteractionData = null; paramString = null; localObject3 = null; Object localObject5 = null; for (Object localObject6 : localObject4)
/*     */         {
/*  65 */           Object localObject7;
/*  65 */           if (TextUtils.isEmpty(paramInteractionData)) paramInteractionData = !(localObject7 = localObject6).contains("biz_type") ? null : d(localObject7); if (TextUtils.isEmpty(paramString)) paramString = !(localObject7 = localObject6).contains("biz_no") ? null : d(localObject7); if (TextUtils.isEmpty((CharSequence)localObject3)) localObject3 = (!(localObject7 = localObject6).contains("trade_no")) || (localObject7.startsWith("out_trade_no")) ? null : d(localObject7); if (TextUtils.isEmpty((CharSequence)localObject5)) localObject5 = !(localObject7 = localObject6).contains("app_userid") ? null : d(localObject7);  } localObject4 = new StringBuilder(); if (!TextUtils.isEmpty(paramInteractionData)) ((StringBuilder)localObject4).append("biz_type=" + paramInteractionData + ";"); if (!TextUtils.isEmpty(paramString)) ((StringBuilder)localObject4).append("biz_no=" + paramString + ";"); if (!TextUtils.isEmpty((CharSequence)localObject3)) ((StringBuilder)localObject4).append("trade_no=" + (String)localObject3 + ";"); if (!TextUtils.isEmpty((CharSequence)localObject5)) ((StringBuilder)localObject4).append("app_userid=" + (String)localObject5 + ";"); if (((StringBuilder)localObject4).length() != 0)
/*     */         {
/*  65 */           String str;
/*  65 */           if ((str = ((StringBuilder)localObject4).toString()).endsWith(";")) str = str.substring(0, str.length() - 1); ((InteractionData)localObject1).a(new Header[] { new BasicHeader("Msp-Param", str) }); ((Request)localObject2).a((InteractionData)localObject1);
/*     */         } } 
/*     */     }
/*  67 */     return paramJSONObject;
/*     */   }
/*     */ 
/*     */   private static Request a(JSONObject paramJSONObject, boolean paramBoolean)
/*     */   {
/*     */     Envelope localEnvelope;
/*  72 */     (
/*  73 */       localEnvelope = new Envelope())
/*  73 */       .b(GlobalConstants.b);
/*  74 */     localEnvelope.c("com.alipay.mobilecashier");
/*  75 */     localEnvelope.d("/cashier/main");
/*  76 */     localEnvelope.e("4.0.2");
/*  77 */     Request localRequest = null;
/*  78 */     if (paramJSONObject != null) {
/*  79 */       (
/*  80 */         localRequest = new Request(localEnvelope, paramJSONObject))
/*  80 */         .a(paramBoolean);
/*     */     }
/*  82 */     return localRequest;
/*     */   }
/*     */ 
/*     */   private static void a(InteractionData paramInteractionData, Request paramRequest, String paramString)
/*     */   {
/*  93 */     if (TextUtils.isEmpty(paramString)) {
/*  94 */       return;
/*     */     }
/*     */ 
/* 104 */     if ((
/* 104 */       paramString = paramString.split("&")).length == 0)
/*     */     {
/* 105 */       return;
/*     */     }
/*     */ 
/* 108 */     Object localObject1 = null;
/* 109 */     Object localObject2 = null;
/* 110 */     Object localObject3 = null;
/* 111 */     Object localObject4 = null;
/* 112 */     for (Object localObject5 : paramString)
/*     */     {
/*     */       Object localObject6;
/* 113 */       if (TextUtils.isEmpty((CharSequence)localObject1)) {
/* 114 */         localObject1 = !(localObject6 = localObject5).contains("biz_type") ? null : d(localObject6);
/*     */       }
/*     */ 
/* 117 */       if (TextUtils.isEmpty((CharSequence)localObject2)) {
/* 118 */         localObject2 = !(localObject6 = localObject5).contains("biz_no") ? null : d(localObject6);
/*     */       }
/*     */ 
/* 121 */       if (TextUtils.isEmpty((CharSequence)localObject3)) {
/* 122 */         localObject3 = (!(localObject6 = localObject5).contains("trade_no")) || (localObject6.startsWith("out_trade_no")) ? null : d(localObject6);
/*     */       }
/* 124 */       if (TextUtils.isEmpty((CharSequence)localObject4)) {
/* 125 */         localObject4 = !(localObject6 = localObject5).contains("app_userid") ? null : d(localObject6);
/*     */       }
/*     */     }
/*     */ 
/* 129 */     paramString = new StringBuilder();
/* 130 */     if (!TextUtils.isEmpty((CharSequence)localObject1)) {
/* 131 */       paramString.append("biz_type=" + (String)localObject1 + ";");
/*     */     }
/*     */ 
/* 134 */     if (!TextUtils.isEmpty((CharSequence)localObject2)) {
/* 135 */       paramString.append("biz_no=" + (String)localObject2 + ";");
/*     */     }
/*     */ 
/* 138 */     if (!TextUtils.isEmpty((CharSequence)localObject3)) {
/* 139 */       paramString.append("trade_no=" + (String)localObject3 + ";");
/*     */     }
/*     */ 
/* 142 */     if (!TextUtils.isEmpty((CharSequence)localObject4)) {
/* 143 */       paramString.append("app_userid=" + (String)localObject4 + ";");
/*     */     }
/*     */ 
/* 146 */     if (paramString.length() == 0)
/*     */       return;
/*     */     String str;
/* 151 */     if ((
/* 151 */       str = paramString.toString())
/* 151 */       .endsWith(";"))
/*     */     {
/* 153 */       str = str.substring(0, str.length() - 1);
/*     */     }
/*     */ 
/* 156 */     paramInteractionData.a(new Header[] { new BasicHeader("Msp-Param", str) });
/*     */ 
/* 158 */     paramRequest.a(paramInteractionData);
/*     */   }
/*     */ 
/*     */   private static String a(String paramString)
/*     */   {
/* 166 */     if (!paramString.contains("biz_type")) {
/* 167 */       return null;
/*     */     }
/*     */ 
/* 172 */     return d(paramString);
/*     */   }
/*     */ 
/*     */   private static String b(String paramString)
/*     */   {
/* 180 */     if (!paramString.contains("biz_no")) {
/* 181 */       return null;
/*     */     }
/*     */ 
/* 186 */     return d(paramString);
/*     */   }
/*     */ 
/*     */   private static String c(String paramString)
/*     */   {
/* 195 */     if ((!paramString.contains("trade_no")) || (paramString.startsWith("out_trade_no"))) {
/* 196 */       return null;
/*     */     }
/*     */ 
/* 201 */     return d(paramString);
/*     */   }
/*     */ 
/*     */   private static String d(String paramString) {
/* 205 */     paramString = paramString.split("=");
/* 206 */     String str = null;
/* 207 */     if (paramString.length > 1)
/*     */     {
/* 209 */       if ((
/* 209 */         str = paramString[1])
/* 209 */         .contains("\"")) {
/* 210 */         str = str.replaceAll("\"", "");
/*     */       }
/*     */     }
/* 213 */     return str;
/*     */   }
/*     */ 
/*     */   private static String e(String paramString)
/*     */   {
/* 221 */     if (!paramString.contains("app_userid")) {
/* 222 */       return null;
/*     */     }
/*     */ 
/* 227 */     return d(paramString);
/*     */   }
/*     */ 
/*     */   public static void a(InteractionData paramInteractionData, HttpResponse paramHttpResponse)
/*     */   {
/* 232 */     paramHttpResponse = paramHttpResponse.getHeaders("Msp-Param");
/* 233 */     if ((paramInteractionData != null) && (paramHttpResponse.length > 0))
/* 234 */       paramInteractionData.a(paramHttpResponse);
/*     */   }
/*     */ 
/*     */   public static byte[] a(byte[] paramArrayOfByte)
/*     */     throws UnZipException
/*     */   {
/* 240 */     byte[] arrayOfByte = null;
/*     */     try {
/* 242 */       paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
/* 243 */       GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
/* 244 */       arrayOfByte = new byte[4096];
/* 245 */       int i = 0;
/* 246 */       ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 247 */       while ((i = localGZIPInputStream.read(arrayOfByte, 0, arrayOfByte.length)) != -1) {
/* 248 */         localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/* 250 */       arrayOfByte = localByteArrayOutputStream.toByteArray();
/* 251 */       localByteArrayOutputStream.flush();
/* 252 */       localByteArrayOutputStream.close();
/* 253 */       localGZIPInputStream.close();
/* 254 */       paramArrayOfByte.close();
/*     */     }
/*     */     catch (UnsupportedEncodingException localUnsupportedEncodingException)
/*     */     {
/* 261 */       localUnsupportedEncodingException.printStackTrace();
/*     */ 
/* 257 */       throw new UnZipException("UnsupportedEncodingException"); } catch (IOException localIOException) { localIOException
/* 258 */         .printStackTrace();
/*     */ 
/* 260 */       throw new UnZipException("IOException");
/*     */     }
/*     */ 
/* 263 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   public static Request a()
/*     */   {
/*     */     Envelope localEnvelope;
/* 267 */     (
/* 268 */       localEnvelope = new Envelope())
/* 268 */       .b(GlobalConstants.b);
/* 269 */     localEnvelope.c("com.alipay.mobilecashier");
/* 270 */     localEnvelope.d("/device/findAccount");
/* 271 */     localEnvelope.e("3.0.0");
/*     */ 
/* 273 */     GlobalContext localGlobalContext = GlobalContext.a();
/* 274 */     TidInfo localTidInfo = TidInfo.c();
/* 275 */     JSONObject localJSONObject = new JSONObject();
/*     */     try {
/* 277 */       if (!TextUtils.isEmpty(localTidInfo.a()))
/* 278 */         localJSONObject.put("tid", localTidInfo.a());
/*     */       else {
/* 280 */         localTidInfo.b(localTidInfo.b());
/*     */       }
/* 282 */       localJSONObject.put("utdid", localGlobalContext.g());
/* 283 */       localJSONObject.put("app_key", "2014052600006128");
/* 284 */       localJSONObject.put("new_client_key", localTidInfo.b());
/*     */ 
/* 286 */       localJSONObject.put("imei", DeviceInfo.a(localGlobalContext.b()).b());
/*     */ 
/* 289 */       localJSONObject.put("imsi", DeviceInfo.a(localGlobalContext.b()).a());
/*     */     }
/*     */     catch (JSONException localJSONException) {
/*     */     }
/* 293 */     return new Request(localEnvelope, localJSONObject);
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.data.FrameUtils
 * JD-Core Version:    0.6.2
 */