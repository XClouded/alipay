/*     */ package com.alipay.sdk.app;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.AlertDialog.Builder;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.Intent;
/*     */ import android.content.res.Configuration;
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.http.SslError;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.Message;
/*     */ import android.text.TextUtils;
/*     */ import android.webkit.CookieManager;
/*     */ import android.webkit.CookieSyncManager;
/*     */ import android.webkit.JsPromptResult;
/*     */ import android.webkit.JsResult;
/*     */ import android.webkit.SslErrorHandler;
/*     */ import android.webkit.WebChromeClient;
/*     */ import android.webkit.WebSettings;
/*     */ import android.webkit.WebSettings.RenderPriority;
/*     */ import android.webkit.WebView;
/*     */ import android.webkit.WebViewClient;
/*     */ import android.widget.LinearLayout;
/*     */ import android.widget.LinearLayout.LayoutParams;
/*     */ import com.alipay.sdk.cons.GlobalConstants;
/*     */ import com.alipay.sdk.util.Utils;
/*     */ import com.alipay.sdk.widget.Loading;
/*     */ import com.alipay.sdk.widget.SystemDefaultDialog;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URLDecoder;
/*     */ 
/*     */ public class H5PayActivity extends Activity
/*     */ {
/*     */   private WebView a;
/*     */   private Loading b;
/*  45 */   private Handler c = new Handler();
/*     */   private boolean d;
/*     */   private boolean e;
/* 465 */   private Runnable f = new Runnable()
/*     */   {
/*     */     public void run()
/*     */     {
/* 469 */       H5PayActivity.f(H5PayActivity.this);
/*     */     }
/* 465 */   };
/*     */ 
/*     */   protected void onCreate(Bundle paramBundle)
/*     */   {
/*  53 */     super.onCreate(paramBundle);
/*     */ 
/*  55 */     if ((
/*  55 */       paramBundle = getIntent().getExtras()) == null) {
/*  56 */       finish();
/*     */       return;
/*     */     }String str;
/*     */     try { str = paramBundle.getString("url"); }
/*     */     catch (Exception localException1)
/*     */     {
/*  63 */       finish();
/*  64 */       return;
/*     */     }
/*     */ 
/*  67 */     if (!Utils.a(str))
/*     */     {
/*  68 */       finish();
/*  69 */       return;
/*     */     }
/*     */ 
/*  72 */     super.requestWindowFeature(1);
/*     */ 
/*  74 */     if (!TextUtils.isEmpty(paramBundle = paramBundle.getString("cookie")))
/*     */     {
/*  75 */       CookieSyncManager.createInstance(this)
/*  77 */         .sync();
/*  78 */       CookieManager.getInstance()
/*  79 */         .setCookie(str, paramBundle);
/*  80 */       CookieSyncManager.getInstance().sync();
/*     */     }
/*     */ 
/*  83 */     paramBundle = new LinearLayout(this);
/*  84 */     LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
/*     */ 
/*  86 */     paramBundle.setOrientation(1);
/*  87 */     setContentView(paramBundle, localLayoutParams);
/*     */ 
/*  89 */     this.a = new WebView(this);
/*  90 */     localLayoutParams.weight = 1.0F;
/*  91 */     this.a.setVisibility(0);
/*  92 */     paramBundle.addView(this.a, localLayoutParams);
/*     */ 
/*  94 */     (
/*  95 */       paramBundle = this.a.getSettings())
/*  95 */       .setUserAgentString(paramBundle.getUserAgentString() + Utils.c(this));
/*     */ 
/*  97 */     paramBundle.setRenderPriority(WebSettings.RenderPriority.HIGH);
/*  98 */     paramBundle.setSupportMultipleWindows(true);
/*  99 */     paramBundle.setJavaScriptEnabled(true);
/* 100 */     paramBundle.setSavePassword(false);
/* 101 */     paramBundle.setJavaScriptCanOpenWindowsAutomatically(true);
/* 102 */     paramBundle.setMinimumFontSize(paramBundle.getMinimumFontSize() + 8);
/* 103 */     paramBundle.setAllowFileAccess(false);
/* 104 */     this.a.setVerticalScrollbarOverlay(true);
/* 105 */     this.a.setWebViewClient(new MyWebViewClient((byte)0));
/* 106 */     this.a.setWebChromeClient(new MyWebChromeClient((byte)0));
/*     */ 
/* 110 */     this.a.loadUrl(str);
/*     */ 
/* 112 */     if (Build.VERSION.SDK_INT >= 7)
/*     */     {
/*     */       try
/*     */       {
/* 116 */         if ((
/* 116 */           paramBundle = this.a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE })) != null)
/*     */         {
/* 117 */           paramBundle.invoke(this.a.getSettings(), new Object[] { Boolean.valueOf(true) });
/*     */         }
/*     */       }
/*     */       catch (Exception localException2)
/*     */       {
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/* 126 */       if ((
/* 126 */         paramBundle = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0])) != null)
/*     */       {
/* 127 */         paramBundle.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
/*     */       }
/*     */ 
/* 131 */       return; } catch (Exception localException3) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onBackPressed() {
/* 136 */     if (this.a.canGoBack()) {
/* 137 */       if (this.d)
/*     */       {
/*     */         ResultStatus localResultStatus;
/* 140 */         Result.a(Result.a((
/* 140 */           localResultStatus = ResultStatus.a(ResultStatus.d.a()))
/* 140 */           .a(), localResultStatus.b(), ""));
/*     */ 
/* 142 */         finish();
/* 143 */         return;
/*     */       }
/* 145 */       return;
/*     */     }
/* 147 */     Result.a(Result.b());
/* 148 */     finish();
/*     */   }
/*     */ 
/*     */   public void finish()
/*     */   {
/* 153 */     synchronized (localObject1 = PayTask.a)
/*     */     {
/*     */       try
/*     */       {
/* 153 */         Object localObject1;
/* 153 */         localObject1.notify(); } catch (Exception localException) { localException.printStackTrace(); } 
/* 154 */     }super.finish();
/*     */   }
/*     */ 
/*     */   private static void a() {
/* 158 */     synchronized (
/* 160 */       localObject1 = PayTask.a)
/*     */     {
/*     */       try
/*     */       {
/*     */         Object localObject1;
/* 162 */         localObject1.notify();
/*     */       }
/*     */       catch (Exception localException) {
/* 165 */         localException.printStackTrace();
/*     */       }
/*     */ 
/* 166 */       return;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onConfigurationChanged(Configuration paramConfiguration) {
/* 171 */     super.onConfigurationChanged(paramConfiguration);
/*     */   }
/*     */ 
/*     */   private void b()
/*     */   {
/* 474 */     if (this.b == null)
/* 475 */       this.b = new Loading(this);
/* 476 */     this.b.b();
/*     */   }
/*     */ 
/*     */   private void c() {
/* 480 */     if ((this.b != null) && (this.b.a()))
/* 481 */       this.b.c();
/* 482 */     this.b = null;
/*     */   }
/*     */ 
/*     */   private class MyWebChromeClient extends WebChromeClient
/*     */   {
/*     */     private MyWebChromeClient()
/*     */     {
/*     */     }
/*     */ 
/*     */     public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult)
/*     */     {
/* 382 */       new AlertDialog.Builder(H5PayActivity.this)
/* 384 */         .setTitle("提示").setMessage(paramString2).setPositiveButton("确定", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/* 392 */           paramJsResult.confirm();
/*     */         }
/*     */       }).setNegativeButton("取消", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/* 401 */           paramJsResult.cancel();
/*     */         }
/*     */       }).show();
/*     */ 
/* 405 */       return true;
/*     */     }
/*     */ 
/*     */     public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult)
/*     */     {
/* 411 */       new AlertDialog.Builder(H5PayActivity.this)
/* 413 */         .setTitle("提示").setMessage(paramString2).setPositiveButton("确定", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/* 421 */           paramJsResult.confirm();
/*     */         }
/*     */       }).setNegativeButton("取消", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/* 430 */           paramJsResult.cancel();
/*     */         }
/*     */       }).show();
/*     */ 
/* 433 */       return true;
/*     */     }
/*     */ 
/*     */     public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, final JsPromptResult paramJsPromptResult)
/*     */     {
/* 439 */       new AlertDialog.Builder(H5PayActivity.this)
/* 441 */         .setTitle("提示").setMessage(paramString2).setPositiveButton("确定", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/* 449 */           paramJsPromptResult.confirm();
/*     */         }
/*     */       }).setNegativeButton("取消", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */         {
/* 458 */           paramJsPromptResult.cancel();
/*     */         }
/*     */       }).show();
/*     */ 
/* 461 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class MyWebViewClient extends WebViewClient
/*     */   {
/*     */     private MyWebViewClient()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
/*     */     {
/* 179 */       H5PayActivity.a(H5PayActivity.this);
/* 180 */       super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
/*     */     }
/*     */ 
/*     */     public void onReceivedSslError(WebView paramWebView, final SslErrorHandler paramSslErrorHandler, SslError paramSslError)
/*     */     {
/* 189 */       if (H5PayActivity.b(H5PayActivity.this)) {
/* 190 */         paramSslErrorHandler.proceed();
/* 191 */         H5PayActivity.a(H5PayActivity.this, false);
/* 192 */         return;
/*     */       }
/*     */ 
/* 195 */       H5PayActivity.this.runOnUiThread(new Runnable() {
/*     */         public void run() {
/* 197 */           SystemDefaultDialog.a(H5PayActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 205 */               H5PayActivity.a(H5PayActivity.this, true);
/* 206 */               H5PayActivity.MyWebViewClient.1.this.a.proceed();
/* 207 */               paramAnonymous2DialogInterface.dismiss();
/*     */             }
/*     */           }
/*     */           , "退出", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 214 */               H5PayActivity.MyWebViewClient.1.this.a.cancel();
/* 215 */               H5PayActivity.a(H5PayActivity.this, false);
/* 216 */               Result.a(Result.b());
/* 217 */               H5PayActivity.this.finish();
/*     */             }
/*     */           });
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/*     */     public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
/*     */     {
/*     */     }
/*     */ 
/*     */     public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
/*     */     {
/* 234 */       if (paramString.startsWith("alipays://platformapi/startApp?")) {
/* 235 */         return false;
/*     */       }
/* 237 */       if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")))
/*     */       {
/* 239 */         Result.a(Result.b());
/* 240 */         H5PayActivity.this.finish();
/* 241 */         return true;
/*     */       }
/*     */ 
/* 244 */       if (paramString.startsWith("sdklite://h5quit?result="))
/*     */       {
/*     */         try
/*     */         {
/*     */           String tmp66_63 = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
/*     */           Object localObject;
/* 253 */           if (((
/* 253 */             paramWebView = Integer.parseInt(tmp66_63
/* 249 */             .substring(tmp66_63
/* 249 */             .lastIndexOf("&end_code=") + 10))) == 
/* 253 */             ResultStatus.a.a()) || (paramWebView == ResultStatus.f.a()))
/*     */           {
/* 255 */             localObject = new StringBuilder();
/*     */             String str1;
/*     */             String str2;
/* 256 */             if (GlobalConstants.n)
/*     */             {
/*     */               String tmp126_123 = URLDecoder.decode(str1 = URLDecoder.decode(paramString));
/*     */ 
/* 274 */               str2 = tmp126_123
/* 263 */                 .substring((str2 = tmp126_123)
/* 263 */                 .indexOf("sdklite://h5quit?result=") + 24, str2.lastIndexOf("&end_code="))
/* 272 */                 .split("&return_url=")[
/* 274 */                 0];
/*     */ 
/* 278 */               paramString = str1.indexOf("&return_url=") + 
/* 278 */                 12;
/*     */ 
/* 281 */               ((StringBuilder)localObject).append(str2).append("&return_url=").append(str1.substring(paramString, str1.indexOf("&", paramString))).append(str1.substring(str1.indexOf("&", paramString)));
/*     */ 
/* 290 */               paramString = ((StringBuilder)localObject).toString();
/*     */             }
/*     */             else
/*     */             {
/*     */               String tmp225_222 = URLDecoder.decode(paramString);
/*     */ 
/* 302 */               if ((
/* 302 */                 paramString = tmp225_222
/* 293 */                 .substring((str1 = tmp225_222)
/* 293 */                 .indexOf("sdklite://h5quit?result=") + 24, str1.lastIndexOf("&end_code=")))
/* 302 */                 .contains("&return_url=\""))
/*     */               {
/* 306 */                 str2 = paramString.split("&return_url=\"")[
/* 306 */                   0];
/*     */ 
/* 310 */                 int i = paramString.indexOf("&return_url=\"") + 
/* 310 */                   13;
/*     */ 
/* 314 */                 ((StringBuilder)localObject).append(str2).append("&return_url=\"").append(paramString.substring(i, paramString.indexOf("\"&", i))).append(paramString.substring(paramString.indexOf("\"&", i)));
/*     */ 
/* 323 */                 paramString = ((StringBuilder)localObject).toString();
/*     */               }
/*     */             }
/*     */             ResultStatus localResultStatus;
/* 328 */             Result.a(Result.a((
/* 328 */               localResultStatus = ResultStatus.a(paramWebView))
/* 328 */               .a(), localResultStatus.b(), paramString));
/*     */           }
/*     */           else
/*     */           {
/* 335 */             Result.a(Result.a((
/* 335 */               localObject = ResultStatus.a(ResultStatus.b.a()))
/* 335 */               .a(), ((ResultStatus)localObject).b(), ""));
/*     */           }
/*     */         }
/*     */         catch (Exception localException)
/*     */         {
/* 340 */           Result.a(Result.c());
/*     */         }
/* 342 */         paramWebView = new Runnable()
/*     */         {
/*     */           public void run() {
/* 345 */             H5PayActivity.this.finish();
/*     */           }
/*     */         };
/* 348 */         H5PayActivity.this.runOnUiThread(paramWebView);
/*     */ 
/* 350 */         return true;
/*     */       }
/*     */ 
/* 353 */       paramWebView.loadUrl(paramString);
/* 354 */       return true;
/*     */     }
/*     */ 
/*     */     public void onLoadResource(WebView paramWebView, String paramString)
/*     */     {
/*     */     }
/*     */ 
/*     */     public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
/* 362 */       H5PayActivity.c(H5PayActivity.this);
/* 363 */       H5PayActivity.e(H5PayActivity.this).postDelayed(H5PayActivity.d(H5PayActivity.this), 30000L);
/* 364 */       super.onPageStarted(paramWebView, paramString, paramBitmap);
/*     */     }
/*     */ 
/*     */     public void onPageFinished(WebView paramWebView, String paramString)
/*     */     {
/* 369 */       H5PayActivity.f(H5PayActivity.this);
/* 370 */       H5PayActivity.e(H5PayActivity.this).removeCallbacks(H5PayActivity.d(H5PayActivity.this));
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.app.H5PayActivity
 * JD-Core Version:    0.6.2
 */