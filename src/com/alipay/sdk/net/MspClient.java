/*     */ package com.alipay.sdk.net;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.ConnectivityManager;
/*     */ import android.net.NetworkInfo;
/*     */ import android.net.Proxy;
/*     */ import android.os.Build.VERSION;
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.data.InteractionData;
/*     */ import com.alipay.sdk.exception.NetErrorException;
/*     */ import com.alipay.sdk.sys.GlobalContext;
/*     */ import java.io.IOException;
/*     */ import java.net.SocketException;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.client.methods.HttpGet;
/*     */ import org.apache.http.client.methods.HttpPost;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.conn.ConnectTimeoutException;
/*     */ import org.apache.http.entity.ByteArrayEntity;
/*     */ import org.apache.http.params.HttpParams;
/*     */ 
/*     */ public class MspClient
/*     */ {
/*     */   private Context a;
/*     */   private String b;
/*     */ 
/*     */   private MspClient(Context paramContext)
/*     */   {
/*  49 */     this(paramContext, null);
/*     */   }
/*     */ 
/*     */   public MspClient(Context paramContext, String paramString) {
/*  53 */     this.a = paramContext;
/*  54 */     this.b = paramString;
/*     */   }
/*     */ 
/*     */   public final void a(String paramString) {
/*  58 */     this.b = paramString;
/*     */   }
/*     */ 
/*     */   public final String a() {
/*  62 */     return this.b;
/*     */   }
/*     */ 
/*     */   private URL b() {
/*  66 */     URL localURL = null;
/*     */     try
/*     */     {
/*  69 */       localURL = new URL(this.b); } catch (Exception localException) {
/*     */     }
/*  71 */     return localURL;
/*     */   }
/*     */ 
/*     */   private static ByteArrayEntity a(InteractionData paramInteractionData, String paramString)
/*     */     throws IOException
/*     */   {
/*  80 */     String str = null;
/*  81 */     if (paramInteractionData != null) {
/*  82 */       str = paramInteractionData.b();
/*  83 */       if (!TextUtils.isEmpty(paramInteractionData.c())) {
/*  84 */         paramString = paramInteractionData.c() + "=" + paramString;
/*     */       }
/*     */     }
/*  87 */     if (TextUtils.isEmpty(str)) {
/*  88 */       str = "application/octet-stream;binary/octet-stream";
/*     */     }
/*  90 */     paramInteractionData = paramString.getBytes("utf-8");
/*  91 */     (
/* 104 */       paramInteractionData = new ByteArrayEntity(paramInteractionData))
/* 104 */       .setContentType(str);
/* 105 */     return paramInteractionData;
/*     */   }
/*     */ 
/*     */   public final HttpResponse b(String paramString)
/*     */     throws NetErrorException
/*     */   {
/* 111 */     return a(paramString, null);
/*     */   }
/*     */ 
/*     */   public final HttpResponse a(String paramString, InteractionData paramInteractionData)
/*     */     throws NetErrorException
/*     */   {
/* 129 */     Object localObject1 = null;
/*     */     MspHttpClient localMspHttpClient;
/* 133 */     if ((
/* 133 */       localMspHttpClient = MspHttpClient.a()) == null)
/*     */     {
/* 134 */       return null;
/*     */     }
/*     */     try
/*     */     {
/* 138 */       localObject1 = localMspHttpClient.c();
/* 139 */       Object localObject2 = this; Object localObject3 = localObject2; localObject2 = null;
/*     */       Object localObject4;
/* 139 */       if ((localObject3 = ((MspClient)localObject3).b()) != null) { String str = ((URL)localObject3).getProtocol(); "https".equalsIgnoreCase(str); localObject3 = System.getProperty("https.proxyHost"); localObject4 = System.getProperty("https.proxyPort"); if (!TextUtils.isEmpty((CharSequence)localObject3)) localObject2 = new HttpHost((String)localObject3, Integer.parseInt((String)localObject4));  } localObject3 = localObject2; localObject2 = null; if (((localObject4 = ((MspClient)localObject3).f()) != null) && (((NetworkInfo)localObject4).isAvailable()) && (((NetworkInfo)localObject4).getType() == 0)) { localObject3 = Proxy.getDefaultHost(); int i = Proxy.getDefaultPort(); if (localObject3 != null) localObject2 = new HttpHost((String)localObject3, i); 
/*     */       }
/* 140 */       if ((
/* 140 */         localObject2 = Build.VERSION.SDK_INT >= 11 ? localObject2 : ((localObject4 = ((MspClient)localObject3).g()) != null) && (!((String)localObject4).contains("wap")) ? null : localObject2) != null)
/*     */       {
/* 141 */         ((HttpParams)localObject1).setParameter("http.route.default-proxy", localObject2);
/*     */       }
/* 143 */       new StringBuilder("requestUrl : ").append(this.b).toString();
/*     */ 
/* 145 */       if (TextUtils.isEmpty(paramString)) {
/* 146 */         localObject1 = new HttpGet(this.b);
/*     */       } else {
/* 148 */         localObject1 = new HttpPost(this.b);
/*     */ 
/* 150 */         localObject3 = paramString; localObject2 = paramInteractionData; localObject4 = null; if (localObject2 != null) { localObject4 = ((InteractionData)localObject2).b(); if (!TextUtils.isEmpty(((InteractionData)localObject2).c())) localObject3 = ((InteractionData)localObject2).c() + "=" + (String)localObject3;  } if (TextUtils.isEmpty((CharSequence)localObject4)) localObject4 = "application/octet-stream;binary/octet-stream"; localObject3 = ((String)localObject3).getBytes("utf-8");
/*     */         ByteArrayEntity localByteArrayEntity;
/* 150 */         (localByteArrayEntity = new ByteArrayEntity((byte[])localObject3)).setContentType((String)localObject4); paramString = localByteArrayEntity;
/*     */ 
/* 152 */         ((HttpPost)localObject1).setEntity(paramString);
/* 153 */         ((HttpUriRequest)localObject1).addHeader("Accept-Charset", "UTF-8");
/* 154 */         ((HttpUriRequest)localObject1).addHeader("Accept-Encoding", "gzip");
/* 155 */         ((HttpUriRequest)localObject1).addHeader("Connection", "Keep-Alive");
/* 156 */         ((HttpUriRequest)localObject1).addHeader("Keep-Alive", "timeout=180, max=100");
/*     */       }
/*     */ 
/* 162 */       if (paramInteractionData != null)
/*     */       {
/* 164 */         if ((
/* 164 */           paramString = paramInteractionData.a()) != null)
/*     */         {
/* 165 */           for (paramString = paramString.iterator(); paramString.hasNext(); ) { paramInteractionData = (Header)paramString.next();
/* 166 */             ((HttpUriRequest)localObject1).addHeader(paramInteractionData); }
/*     */         }
/*     */       }
/* 169 */       GlobalContext.a(); GlobalContext.d();
/*     */ 
/* 177 */       if (((
/* 177 */         paramString = (
/* 176 */         localObject1 = localMspHttpClient.a((HttpUriRequest)localObject1))
/* 176 */         .getHeaders("X-Hostname")) != null) && 
/* 177 */         (paramString.length > 0) && (paramString[0] != null))
/*     */       {
/* 179 */         localObject1.getHeaders("X-Hostname")[0].toString();
/*     */       }
/*     */ 
/* 184 */       if (((
/* 184 */         paramString = ((HttpResponse)localObject1).getHeaders("X-ExecuteTime")) != null) && 
/* 184 */         (paramString.length > 0) && (paramString[0] != null))
/*     */       {
/* 186 */         localObject1.getHeaders("X-ExecuteTime")[0].toString();
/*     */       }
/*     */     } catch (NetErrorException localNetErrorException) {
/* 189 */       throw 
/* 207 */         localNetErrorException;
/*     */     }
/*     */     catch (ConnectTimeoutException localConnectTimeoutException)
/*     */     {
/* 192 */       if (localMspHttpClient != null)
/* 193 */         localMspHttpClient.b();
/* 194 */       throw new NetErrorException();
/*     */     }
/*     */     catch (SocketException localSocketException) {
/* 197 */       throw new NetErrorException();
/*     */     }
/*     */     catch (SocketTimeoutException localSocketTimeoutException) {
/* 200 */       if (localMspHttpClient != null)
/* 201 */         localMspHttpClient.b();
/* 202 */       throw new NetErrorException();
/*     */     }
/*     */     catch (Exception localException) {
/* 205 */       throw new NetErrorException();
/*     */     }
/*     */ 
/* 209 */     return localObject1;
/*     */   }
/*     */ 
/*     */   private HttpHost c()
/*     */   {
/*     */     Object localObject2;
/* 218 */     if (Build.VERSION.SDK_INT >= 11) {
/* 219 */       localObject1 = this; localHttpHost = null; if (((localObject2 = ((MspClient)localObject1).g()) != null) && (!((String)localObject2).contains("wap"))) return null; if ((localObject1 = ((MspClient)localObject1).b()) != null) { localObject2 = ((URL)localObject1).getProtocol(); "https".equalsIgnoreCase((String)localObject2); localObject1 = System.getProperty("https.proxyHost"); localObject2 = System.getProperty("https.proxyPort"); if (!TextUtils.isEmpty((CharSequence)localObject1)) localHttpHost = new HttpHost((String)localObject1, Integer.parseInt((String)localObject2));  } return localHttpHost;
/*     */     }
/* 221 */     Object localObject1 = this; HttpHost localHttpHost = null; if (((localObject2 = ((MspClient)localObject1).f()) != null) && (((NetworkInfo)localObject2).isAvailable()) && (((NetworkInfo)localObject2).getType() == 0)) { localObject1 = Proxy.getDefaultHost(); int i = Proxy.getDefaultPort(); if (localObject1 != null) localHttpHost = new HttpHost((String)localObject1, i);  } return localHttpHost;
/*     */   }
/*     */ 
/*     */   private HttpHost d()
/*     */   {
/* 231 */     HttpHost localHttpHost = null;
/*     */     Object localObject;
/* 233 */     if (((
/* 233 */       localObject = f()) != null) && 
/* 233 */       (((NetworkInfo)localObject).isAvailable()) && (((NetworkInfo)localObject).getType() == 0))
/*     */     {
/* 235 */       localObject = Proxy.getDefaultHost();
/* 236 */       int i = Proxy.getDefaultPort();
/* 237 */       if (localObject != null) {
/* 238 */         localHttpHost = new HttpHost((String)localObject, i);
/*     */       }
/*     */     }
/* 241 */     return localHttpHost;
/*     */   }
/*     */ 
/*     */   private HttpHost e()
/*     */   {
/* 250 */     HttpHost localHttpHost = null;
/*     */     Object localObject;
/* 253 */     if (((
/* 253 */       localObject = g()) != null) && 
/* 253 */       (!((String)localObject).contains("wap"))) {
/* 254 */       return null;
/*     */     }
/*     */ 
/* 258 */     if ((
/* 258 */       localObject = b()) != null)
/*     */     {
/* 259 */       localObject = ((URL)localObject).getProtocol();
/*     */ 
/* 264 */       "https".equalsIgnoreCase((String)localObject);
/* 265 */       localObject = System.getProperty("https.proxyHost");
/*     */ 
/* 269 */       String str = System.getProperty("https.proxyPort");
/*     */ 
/* 272 */       if (!TextUtils.isEmpty((CharSequence)localObject)) {
/* 273 */         localHttpHost = new HttpHost((String)localObject, Integer.parseInt(str));
/*     */       }
/*     */     }
/*     */ 
/* 277 */     return localHttpHost;
/*     */   }
/*     */ 
/*     */   private NetworkInfo f()
/*     */   {
/* 286 */     NetworkInfo localNetworkInfo = null;
/*     */     try
/*     */     {
/* 290 */       localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity"))
/* 290 */         .getActiveNetworkInfo();
/*     */     } catch (Exception localException) {
/*     */     }
/* 293 */     return localNetworkInfo;
/*     */   }
/*     */ 
/*     */   private String g()
/*     */   {
/*     */     try
/*     */     {
/*     */       NetworkInfo localNetworkInfo;
/* 300 */       if (((
/* 300 */         localNetworkInfo = f()) != null) && 
/* 300 */         (localNetworkInfo.isAvailable())) {
/* 301 */         if (localNetworkInfo.getType() == 1) {
/* 302 */           return "wifi";
/*     */         }
/* 304 */         return localNetworkInfo.getExtraInfo().toLowerCase();
/*     */       }
/*     */ 
/* 307 */       return "none";
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/* 312 */     return "none";
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.net.MspClient
 * JD-Core Version:    0.6.2
 */