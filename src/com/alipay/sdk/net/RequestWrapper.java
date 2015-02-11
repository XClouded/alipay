/*     */ package com.alipay.sdk.net;
/*     */
/*     */ import android.content.Context;
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.data.Envelope;
/*     */ import com.alipay.sdk.data.FrameUtils;
/*     */ import com.alipay.sdk.data.InteractionData;
/*     */ import com.alipay.sdk.data.MspConfig;
/*     */ import com.alipay.sdk.data.Request;
/*     */ import com.alipay.sdk.data.Response;
/*     */ import com.alipay.sdk.encrypt.Base64;
/*     */ import com.alipay.sdk.encrypt.MD5;
/*     */ import com.alipay.sdk.encrypt.TriDes;
/*     */ import com.alipay.sdk.exception.AppErrorException;
/*     */ import com.alipay.sdk.exception.FailOperatingException;
/*     */ import com.alipay.sdk.exception.NetErrorException;
/*     */ import com.alipay.sdk.exception.UnZipException;
/*     */ import com.alipay.sdk.protocol.FrameData;
/*     */ import com.alipay.sdk.protocol.FrameFactoryManager;
/*     */ import com.alipay.sdk.sys.GlobalContext;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Calendar;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */
/*     */ public class RequestWrapper
/*     */ {
/*  49 */   private int a = 0;
/*     */   private InteractionData b;
/*     */
/*     */   public RequestWrapper(InteractionData paramInteractionData)
/*     */   {
/*  56 */     this.b = paramInteractionData;
/*     */   }
/*     */
/*     */   public RequestWrapper()
/*     */   {
/*     */   }
/*     */
/*     */   public final FrameData a(Context paramContext, Request paramRequest, boolean paramBoolean)
/*     */     throws NetErrorException, FailOperatingException, AppErrorException, UnZipException
/*     */   {
/*  67 */     Response localResponse = new Response();
/*     */     Object localObject;
/*  74 */     if ((
/*  73 */       paramContext = a(paramContext, paramRequest, localResponse))
/*  73 */       .optBoolean("gzip"))
/*     */     {
/*  76 */       if (((
/*  76 */         localObject = paramContext.optJSONObject("form")) != null) &&
/*  76 */         (((JSONObject)localObject).has("quickpay")))
/*     */       {
/*  78 */         localObject = Base64.a(((JSONObject)localObject).optString("quickpay"));
/*     */         try
/*     */         {
/*  81 */           String str1 = MD5.a(localObject = FrameUtils.a((byte[])localObject));
/*     */
/*  82 */           String str2 = paramContext.optString("md5");
/*  83 */           if (TextUtils.equals(str1, str2)) {
/*  84 */             localObject = new String((byte[])localObject, "utf-8");
/*  85 */             paramContext.put("form", new JSONObject((String)localObject)); break label165;
/*     */           }
/*  87 */           throw new UnZipException("client md5  not equal server md5");
/*     */         }
/*     */         catch (UnsupportedEncodingException localUnsupportedEncodingException)
/*     */         {
/*  91 */           throw new UnZipException("unzip byte array unsupport encoding");
/*     */         } catch (UnZipException localUnZipException) {
/*  93 */           throw localUnZipException;
/*     */         }
/*     */         catch (JSONException localJSONException)
/*     */         {
/*  96 */           throw new UnZipException("unzip string not jsonObject");
/*     */         }
/*     */       }
/*     */     }
/* 100 */     else localResponse.b();
/*     */
/* 102 */     label165: new StringBuilder("responsestring decoded ").append(paramContext).toString();
/* 103 */     (
/* 104 */       localObject = new FrameData(paramRequest, localResponse))
/* 104 */       .a(paramContext);
/* 105 */     if (paramBoolean) {
/* 106 */       return localObject;
/*     */     }
/* 108 */     return FrameFactoryManager.a((FrameData)localObject);
/*     */   }
/*     */
/*     */   private JSONObject a(Context paramContext, Request paramRequest, Response paramResponse)
/*     */     throws NetErrorException, FailOperatingException, AppErrorException
/*     */   {
/* 114 */     Object localObject1 = GlobalContext.f();
/*     */     try {
/* 116 */       Object localObject2 = a(paramContext, paramRequest.a(), paramRequest.a((String)localObject1).toString(), paramRequest.b(), paramResponse);
/*     */
/* 123 */       paramResponse.a(Calendar.getInstance().getTimeInMillis());
/*     */
/* 126 */       if (paramRequest.c()) {
/* 127 */         Object localObject3 = localObject2;
                  localObject2 = localObject1;
                  localObject1 = paramResponse;
                  paramResponse = paramRequest;
                  paramRequest = paramContext;
                  paramContext = this;
                  localObject3 = a((String)localObject3, (Response)localObject1);
                  paramContext.a += 1;
                  if (((Response)localObject1).c() != 0)
                      throw new FailOperatingException(((Response)localObject1).d());
                      paramContext.a = 0;
                  if (TextUtils.isEmpty(paramRequest = ((JSONObject)localObject3).optString("res_data")))
                      throw new AppErrorException(paramContext.getClass(), "response data is empty");
                      paramContext = TriDes.b((String)localObject2, paramRequest);
                      new StringBuilder("respData:").append(paramContext).toString();
                      paramContext = (((Response)localObject1).c() == 1000) && (paramContext.a < 3) ? paramContext.a(paramRequest, paramResponse, (Response)localObject1) : new JSONObject(paramContext);
/*     */       }
/*     */       else {
/* 130 */             localObject1 = localObject2;
                      paramResponse = paramResponse;
                      paramRequest = null;
                      paramContext = null;
                      localObject2 = a((String)localObject1, paramResponse);
                      new StringBuilder("respData:").append(((JSONObject)localObject2).toString()).toString();
                }
                return (Context)localObject2;
/*     */     }
/*     */     catch (NetErrorException localNetErrorException)
/*     */     {
/* 136 */       throw localNetErrorException;
/*     */     }
/*     */     catch (FailOperatingException localFailOperatingException) {
/* 138 */       throw localFailOperatingException;
/*     */     }
/*     */     catch (AppErrorException localAppErrorException)
/*     */     {
/* 140 */       throw localAppErrorException;
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/* 143 */     throw new NetErrorException();
/*     */   }
/*     */
/*     */   private static String a(String paramString)
/*     */   {
/* 149 */     FileInputStream localFileInputStream = null;
/*     */     try
/*     */     {
/* 152 */       localFileInputStream = new FileInputStream(paramString);
/* 153 */       paramString = new BufferedReader(new InputStreamReader(localFileInputStream));
/*     */
/* 155 */       char[] arrayOfChar = new char[2048];
/* 156 */       StringBuilder localStringBuilder = new StringBuilder();
/* 157 */       int i = 0;
/* 158 */       while ((i = paramString.read(arrayOfChar)) > 0) {
/* 159 */         localStringBuilder.append(arrayOfChar, 0, i);
/*     */       }
/*     */
/* 162 */       paramString.close();
/* 163 */       paramString = localStringBuilder.toString();
/*     */       try
/*     */       {
/* 167 */         localFileInputStream.close();
/*     */       }
/*     */       catch (IOException localIOException1)
/*     */       {
/* 172 */         localIOException1.printStackTrace();
/*     */       }
/* 172 */       return paramString;
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */     finally
/*     */     {
/* 167 */       if (localFileInputStream != null) {
/*     */         try {
/* 169 */           localFileInputStream.close();
/*     */         }
/*     */         catch (IOException localIOException3) {
/* 172 */           localIOException3.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */
/* 175 */     return null;
/*     */   }
/*     */
/*     */   private JSONObject a(Context paramContext, Request paramRequest, Response paramResponse, String paramString1, String paramString2)
/*     */     throws JSONException, AppErrorException, NetErrorException, FailOperatingException
/*     */   {
/* 183 */     paramString2 = a(paramString2, paramResponse);
/* 184 */     if ((paramResponse.c() == 1000) && (this.a < 3))
/*     */     {
/* 186 */       this.a += 1;
/* 187 */       return a(paramContext, paramRequest, paramResponse);
/* 188 */     }if (paramResponse.c() != 0) {
/* 189 */       throw new FailOperatingException(paramResponse.d());
/*     */     }
/* 191 */     this.a = 0;
/*     */
/* 195 */     if (TextUtils.isEmpty(paramContext = paramString2.optString("res_data")))
/*     */     {
/* 196 */       throw new AppErrorException(getClass(), "response data is empty");
/*     */     }
/*     */
/* 200 */     paramContext = TriDes.b(paramString1, paramContext);
/* 201 */     new StringBuilder("respData:").append(paramContext).toString();
/* 202 */     return new JSONObject(paramContext);
/*     */   }
/*     */
/*     */   private static JSONObject a(Response paramResponse, String paramString)
/*     */     throws JSONException, AppErrorException
/*     */   {
/* 208 */     paramResponse = a(paramString, paramResponse);
/* 209 */     new StringBuilder("respData:").append(paramResponse.toString()).toString();
/*     */
/* 211 */     return paramResponse;
/*     */   }
/*     */
/*     */   private String a(Context paramContext, String paramString1, String paramString2, InteractionData paramInteractionData, Response paramResponse)
/*     */     throws NetErrorException
/*     */   {
/*     */     try
/*     */     {
/* 222 */       paramString1 = (
/* 222 */         paramContext = RequestUtils.a(paramContext, paramString1, paramString2, paramInteractionData))
/* 222 */         .getStatusLine();
/* 223 */       paramResponse.a(paramString1.getStatusCode());
/* 224 */       paramResponse.a(paramString1.getReasonPhrase());
/*     */
/* 226 */       FrameUtils.a(this.b, paramContext);
/*     */
/* 230 */       return RequestUtils.a(paramContext);
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 232 */       throw new NetErrorException();
/*     */     } finally {
/* 234 */       RequestUtils.a(); } throw paramContext;
/*     */   }
/*     */
/*     */   private static JSONObject a(String paramString, Response paramResponse)
/*     */     throws JSONException, AppErrorException
/*     */   {
/* 244 */     if ((
/* 244 */       paramString = new JSONObject(paramString)
/* 242 */       .optJSONObject("data")) != null)
/*     */     {
/* 246 */       paramResponse.a(paramString.optInt("code", 503));
/* 247 */       paramResponse.a(paramString.optString("error_msg", ""));
/*     */
/* 250 */       if ((
/* 250 */         paramString = paramString.optJSONObject("params")) != null)
/*     */       {
/*     */         Object localObject;
/* 251 */         if (paramResponse.c() == 1000)
/*     */         {
/* 253 */           if (!TextUtils.isEmpty(localObject = paramString.optString("public_key"))) GlobalContext.a().c().a((String)localObject);
/*     */         }
/*     */
/* 256 */         (
/* 257 */           localObject = new Envelope())
/* 257 */           .d(paramString.optString("next_api_name"));
/* 258 */         ((Envelope)localObject).e(paramString.optString("next_api_version"));
/* 259 */         ((Envelope)localObject).c(paramString.optString("next_namespace"));
/* 260 */         ((Envelope)localObject).b(paramString.optString("next_request_url"));
/* 261 */         paramResponse.a((Envelope)localObject);
/*     */
/* 263 */         return paramString;
/* 264 */       }paramResponse.c();
/*     */     }
/*     */     else
/*     */     {
/* 268 */       paramResponse.a(503);
/* 269 */       paramResponse.a("");
/*     */     }
/* 271 */     return null;
/*     */   }
/*     */
/*     */   private static void a(JSONObject paramJSONObject)
/*     */   {
/* 276 */     if (!TextUtils.isEmpty(paramJSONObject = paramJSONObject.optString("public_key")))
/*     */     {
/* 277 */       GlobalContext.a().c().a(paramJSONObject);
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.net.RequestWrapper
 * JD-Core Version:    0.6.2
 */
