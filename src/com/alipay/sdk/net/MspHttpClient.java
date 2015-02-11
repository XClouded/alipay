/*     */ package com.alipay.sdk.net;
/*     */ 
/*     */ import android.os.Build.VERSION;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.client.ResponseHandler;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.params.HttpClientParams;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.params.ConnManagerParams;
/*     */ import org.apache.http.conn.params.ConnPerRoute;
/*     */ import org.apache.http.conn.params.ConnPerRouteBean;
/*     */ import org.apache.http.conn.scheme.PlainSocketFactory;
/*     */ import org.apache.http.conn.scheme.Scheme;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.conn.scheme.SocketFactory;
/*     */ import org.apache.http.conn.ssl.SSLSocketFactory;
/*     */ import org.apache.http.impl.client.DefaultHttpClient;
/*     */ import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
/*     */ import org.apache.http.params.BasicHttpParams;
/*     */ import org.apache.http.params.HttpConnectionParams;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.params.HttpProtocolParams;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ 
/*     */ public final class MspHttpClient
/*     */ {
/*     */   public static final String a = "msp";
/*     */   private static MspHttpClient b;
/*     */   private final DefaultHttpClient c;
/*     */ 
/*     */   private static MspHttpClient d()
/*     */   {
/*  77 */     return b;
/*     */   }
/*     */ 
/*     */   private static void e()
/*     */   {
/*  84 */     b = null;
/*     */   }
/*     */ 
/*     */   private MspHttpClient(HttpParams paramHttpParams)
/*     */   {
/*  90 */     this.c = new DefaultHttpClient(paramHttpParams);
/*     */   }
/*     */ 
/*     */   private MspHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
/*  94 */     this.c = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams);
/*     */   }
/*     */ 
/*     */   public static MspHttpClient a()
/*     */   {
/* 105 */     if (b == null)
/*     */     {
/*     */       BasicHttpParams localBasicHttpParams;
/* 108 */       HttpProtocolParams.setVersion(localBasicHttpParams = new BasicHttpParams(), 
/* 108 */         HttpVersion.HTTP_1_1);
/*     */ 
/* 112 */       HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
/* 113 */       localBasicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
/*     */ 
/* 116 */       ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 50);
/*     */ 
/* 118 */       Object localObject = new ConnPerRouteBean(30);
/* 119 */       ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, (ConnPerRoute)localObject);
/*     */ 
/* 121 */       ConnManagerParams.setTimeout(localBasicHttpParams, 1000L);
/*     */ 
/* 124 */       HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
/*     */ 
/* 126 */       HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
/* 127 */       HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 16384);
/*     */ 
/* 129 */       HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
/*     */ 
/* 134 */       HttpClientParams.setRedirecting(localBasicHttpParams, true);
/* 135 */       HttpClientParams.setAuthenticating(localBasicHttpParams, false);
/*     */ 
/* 138 */       HttpProtocolParams.setUserAgent(localBasicHttpParams, "msp");
/*     */       try
/*     */       {
/* 155 */         (
/* 157 */           localObject = SSLSocketFactory.getSocketFactory())
/* 157 */           .setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
/* 158 */         localObject = new Scheme("https", (SocketFactory)localObject, 443);
/* 159 */         Scheme localScheme = new Scheme("http", PlainSocketFactory.getSocketFactory(), 80);
/*     */         SchemeRegistry localSchemeRegistry;
/* 162 */         (
/* 163 */           localSchemeRegistry = new SchemeRegistry())
/* 163 */           .register((Scheme)localObject);
/* 164 */         localSchemeRegistry.register(localScheme);
/*     */ 
/* 167 */         localObject = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
/*     */ 
/* 170 */         b = new MspHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
/*     */       } catch (Exception localException) {
/* 172 */         b = new MspHttpClient(localBasicHttpParams);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 179 */     return b;
/*     */   }
/*     */ 
/*     */   private void f()
/*     */   {
/*     */     ClientConnectionManager localClientConnectionManager;
/* 188 */     if ((
/* 188 */       localClientConnectionManager = this.c.getConnectionManager()) != null)
/*     */     {
/* 189 */       localClientConnectionManager.closeExpiredConnections();
/* 190 */       if (Build.VERSION.SDK_INT >= 9)
/*     */       {
/* 192 */         localClientConnectionManager.closeIdleConnections(30L, TimeUnit.MINUTES);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public final void b()
/*     */   {
/*     */     ClientConnectionManager localClientConnectionManager;
/* 199 */     if ((
/* 199 */       localClientConnectionManager = this.c.getConnectionManager()) != null)
/*     */     {
/* 200 */       localClientConnectionManager.shutdown();
/* 201 */       b = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public final HttpParams c() {
/* 206 */     return this.c.getParams();
/*     */   }
/*     */ 
/*     */   private ClientConnectionManager g() {
/* 210 */     return this.c.getConnectionManager();
/*     */   }
/*     */ 
/*     */   public final HttpResponse a(HttpUriRequest paramHttpUriRequest) throws Exception {
/*     */     try {
/* 215 */       return this.c.execute(paramHttpUriRequest); } catch (Exception paramHttpUriRequest) {
/*     */     }
/* 217 */     throw new Exception(paramHttpUriRequest);
/*     */   }
/*     */ 
/*     */   private HttpResponse a(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 224 */       return this.c.execute(paramHttpUriRequest, paramHttpContext); } catch (Exception paramHttpUriRequest) {
/*     */     }
/* 226 */     throw new Exception(paramHttpUriRequest);
/*     */   }
/*     */ 
/*     */   private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 234 */       paramHttpHost = null; return this.c.execute(paramHttpHost, paramHttpRequest);
/*     */     } catch (Exception paramHttpHost) {
/*     */     }
/* 236 */     throw new Exception(paramHttpHost);
/*     */   }
/*     */ 
/*     */   private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 243 */       return this.c.execute(paramHttpHost, paramHttpRequest, paramHttpContext); } catch (Exception paramHttpHost) {
/*     */     }
/* 245 */     throw new Exception(paramHttpHost);
/*     */   }
/*     */ 
/*     */   private Object a(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler) throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 252 */       return this.c.execute(paramHttpUriRequest, paramResponseHandler); } catch (Exception paramHttpUriRequest) {
/*     */     }
/* 254 */     throw new Exception(paramHttpUriRequest);
/*     */   }
/*     */ 
/*     */   private Object a(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 262 */       return this.c.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext); } catch (Exception paramHttpUriRequest) {
/*     */     }
/* 264 */     throw new Exception(paramHttpUriRequest);
/*     */   }
/*     */ 
/*     */   private Object a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler) throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 271 */       return this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler); } catch (Exception paramHttpHost) {
/*     */     }
/* 273 */     throw new Exception(paramHttpHost);
/*     */   }
/*     */ 
/*     */   private Object a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 281 */       return this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext); } catch (Exception paramHttpHost) {
/*     */     }
/* 283 */     throw new Exception(paramHttpHost);
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.net.MspHttpClient
 * JD-Core Version:    0.6.2
 */