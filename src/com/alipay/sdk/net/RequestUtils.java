/*     */ package com.alipay.sdk.net;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.data.InteractionData;
/*     */ import com.alipay.sdk.exception.NetErrorException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ 
/*     */ public class RequestUtils
/*     */ {
/*     */   private static MspClient a;
/*     */ 
/*     */   public static HttpResponse a(Context paramContext, String paramString1, String paramString2, InteractionData paramInteractionData)
/*     */     throws NetErrorException
/*     */   {
/*  36 */     if (a == null)
/*  37 */       a = new MspClient(paramContext, paramString1);
/*  38 */     else if (!TextUtils.equals(paramString1, a.a())) {
/*  39 */       a.a(paramString1);
/*     */     }
/*     */ 
/*  44 */     if (paramInteractionData != null)
/*  45 */       paramContext = a.a(paramString2, paramInteractionData);
/*     */     else {
/*  47 */       paramContext = a.b(paramString2);
/*     */     }
/*     */ 
/*  50 */     return paramContext;
/*     */   }
/*     */ 
/*     */   public static String a(HttpResponse paramHttpResponse)
/*     */     throws NetErrorException
/*     */   {
/*     */     Object localObject1;
/*  56 */     int j = (
/*  56 */       localObject1 = paramHttpResponse.getStatusLine())
/*  56 */       .getStatusCode();
/*     */ 
/*  58 */     paramHttpResponse = paramHttpResponse.getEntity();
/*  59 */     Object localObject2 = null;
/*     */     try {
/*  61 */       localObject2 = paramHttpResponse.getContent();
/*  62 */       if ((((StatusLine)localObject1).getStatusCode() != 200) || (localObject2 == null))
/*     */       {
/*  64 */         throw new NetErrorException(j + " " + ((StatusLine)localObject1).getReasonPhrase());
/*     */       }
/*     */ 
/*  70 */       if (((
/*  70 */         localObject1 = paramHttpResponse.getContentEncoding()) != null) && 
/*  71 */         (((Header)localObject1).getValue().contains("gzip")))
/*  72 */         localObject2 = new GZIPInputStream((InputStream)localObject2);
/*     */       int i;
/*  77 */       if ((
/*  77 */         i = (int)paramHttpResponse.getContentLength()) < 0)
/*     */       {
/*  78 */         i = 4096;
/*     */       }
/*     */ 
/*  83 */       if ((
/*  83 */         paramHttpResponse = EntityUtils.getContentCharSet(paramHttpResponse)) == null)
/*     */       {
/*  84 */         paramHttpResponse = "UTF-8";
/*     */       }
/*  86 */       paramHttpResponse = new InputStreamReader((InputStream)localObject2, paramHttpResponse);
/*  87 */       CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(i);
/*  88 */       char[] arrayOfChar = new char[1024];
/*     */       int k;
/*  90 */       while ((k = paramHttpResponse.read(arrayOfChar)) != -1) {
/*  91 */         localCharArrayBuffer.append(arrayOfChar, 0, k);
/*     */       }
/*  93 */       return localCharArrayBuffer.toString();
/*     */     } catch (Exception localException2) {
/*  95 */       throw new NetErrorException();
/*     */     }
/*     */     finally {
/*     */       try {
/*  99 */         ((InputStream)localObject2).close(); } catch (Exception localException3) {  }
/*     */     }
/* 101 */     throw paramHttpResponse;
/*     */   }
/*     */ 
/*     */   public static void a()
/*     */   {
/* 108 */     a = null;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.net.RequestUtils
 * JD-Core Version:    0.6.2
 */