/*     */ package com.alipay.sdk.app;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.AlertDialog;
/*     */ import android.app.AlertDialog.Builder;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.Intent;
/*     */ import android.content.res.Configuration;
/*     */ import android.graphics.Bitmap;
/*     */ import android.net.Uri;
/*     */ import android.net.http.SslError;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.text.TextUtils;
/*     */ import android.webkit.ConsoleMessage;
/*     */ import android.webkit.DownloadListener;
/*     */ import android.webkit.SslErrorHandler;
/*     */ import android.webkit.WebChromeClient;
/*     */ import android.webkit.WebSettings;
/*     */ import android.webkit.WebSettings.RenderPriority;
/*     */ import android.webkit.WebView;
/*     */ import android.webkit.WebViewClient;
/*     */ import android.widget.LinearLayout;
/*     */ import android.widget.LinearLayout.LayoutParams;
/*     */ import com.alipay.sdk.authjs.CallInfo;
/*     */ import com.alipay.sdk.authjs.IJsCallback;
/*     */ import com.alipay.sdk.authjs.JsBridge;
/*     */ import com.alipay.sdk.data.Envelope;
/*     */ import com.alipay.sdk.data.FrameUtils;
/*     */ import com.alipay.sdk.data.InteractionData;
/*     */ import com.alipay.sdk.data.MspConfig;
/*     */ import com.alipay.sdk.data.Request;
/*     */ import com.alipay.sdk.exception.FailOperatingException;
/*     */ import com.alipay.sdk.exception.NetErrorException;
/*     */ import com.alipay.sdk.net.RequestWrapper;
/*     */ import com.alipay.sdk.protocol.ActionType;
/*     */ import com.alipay.sdk.protocol.ElementAction;
/*     */ import com.alipay.sdk.protocol.FrameData;
/*     */ import com.alipay.sdk.sys.GlobalContext;
/*     */ import com.alipay.sdk.util.AuthHelper;
/*     */ import com.alipay.sdk.util.Utils;
/*     */ import com.alipay.sdk.widget.Loading;
/*     */ import com.alipay.sdk.widget.SystemDefaultDialog;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URLDecoder;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class H5AuthActivity extends Activity
/*     */ {
/*     */   private WebView a;
/*     */   private Loading b;
/*  69 */   private Handler c = new Handler();
/*     */   private boolean d;
/* 472 */   private Runnable e = new Runnable()
/*     */   {
/*     */     public void run()
/*     */     {
/* 476 */       H5AuthActivity.i(H5AuthActivity.this);
/* 477 */       H5AuthActivity.b(H5AuthActivity.this);
/*     */     }
/* 472 */   };
/*     */ 
/*     */   protected void onCreate(Bundle paramBundle)
/*     */   {
/*  74 */     super.onCreate(paramBundle);
/*     */ 
/*  76 */     if (getIntent().getExtras() == null)
/*     */     {
/*  77 */       finish();
/*  78 */       return;
/*     */     }
/*     */ 
/*  81 */     super.requestWindowFeature(1);
/*  82 */     GlobalContext.a().a(this, MspConfig.a());
/*     */ 
/*  84 */     paramBundle = new LinearLayout(this);
/*  85 */     LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
/*     */ 
/*  87 */     paramBundle.setOrientation(1);
/*  88 */     setContentView(paramBundle, localLayoutParams);
/*     */ 
/*  90 */     this.a = new WebView(this);
/*  91 */     localLayoutParams.weight = 1.0F;
/*  92 */     this.a.setVisibility(0);
/*  93 */     paramBundle.addView(this.a, localLayoutParams);
/*     */ 
/*  95 */     (
/*  96 */       paramBundle = this.a.getSettings())
/*  96 */       .setUserAgentString(paramBundle.getUserAgentString() + Utils.c(this));
/*     */ 
/*  98 */     paramBundle.setRenderPriority(WebSettings.RenderPriority.HIGH);
/*  99 */     paramBundle.setSupportMultipleWindows(true);
/* 100 */     paramBundle.setJavaScriptEnabled(true);
/* 101 */     paramBundle.setSavePassword(false);
/* 102 */     paramBundle.setJavaScriptCanOpenWindowsAutomatically(true);
/* 103 */     paramBundle.setMinimumFontSize(paramBundle.getMinimumFontSize() + 8);
/* 104 */     paramBundle.setAllowFileAccess(false);
/* 105 */     this.a.setVerticalScrollbarOverlay(true);
/* 106 */     this.a.setWebViewClient(new MyWebViewClient((byte)0));
/* 107 */     this.a.setWebChromeClient(new MyWebChromeClient((byte)0));
/* 108 */     this.a.setDownloadListener(new DownloadListener()
/*     */     {
/*     */       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
/*     */       {
/* 114 */         paramAnonymousString1 = Uri.parse(paramAnonymousString1);
/* 115 */         paramAnonymousString1 = new Intent("android.intent.action.VIEW", paramAnonymousString1);
/* 116 */         H5AuthActivity.this.startActivity(paramAnonymousString1);
/*     */       }
/*     */     });
/* 120 */     new Thread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 124 */         H5AuthActivity.a(H5AuthActivity.this);
/*     */       }
/*     */     }).start();
/*     */ 
/* 128 */     if (Build.VERSION.SDK_INT >= 7)
/*     */     {
/*     */       try
/*     */       {
/* 132 */         if ((
/* 132 */           paramBundle = this.a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE })) != null)
/*     */         {
/* 133 */           paramBundle.invoke(this.a.getSettings(), new Object[] { Boolean.valueOf(true) });
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */     }
/*     */     try {
/* 141 */       if ((
/* 141 */         paramBundle = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0])) != null)
/*     */       {
/* 142 */         paramBundle.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
/*     */       }
/*     */ 
/* 146 */       return; } catch (Exception localException2) {
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void onDestroy() {
/* 151 */     super.onDestroy();
/*     */   }
/*     */ 
/*     */   public void finish()
/*     */   {
/* 156 */     synchronized (localObject1 = AuthHelper.a)
/*     */     {
/*     */       try
/*     */       {
/* 156 */         Object localObject1;
/* 156 */         localObject1.notify(); } catch (Exception localException) { localException.printStackTrace(); } 
/* 157 */     }super.finish();
/*     */   }
/*     */ 
/*     */   private static void a() {
/* 161 */     synchronized (
/* 163 */       localObject1 = AuthHelper.a)
/*     */     {
/*     */       try
/*     */       {
/*     */         Object localObject1;
/* 165 */         localObject1.notify();
/*     */       }
/*     */       catch (Exception localException) {
/* 168 */         localException.printStackTrace();
/*     */       }
/*     */ 
/* 169 */       return;
/*     */     }
/*     */   }
/*     */ 
/* 173 */   private void b() { e();
/*     */ 
/* 175 */     Object localObject1 = getIntent().getExtras().getString("params");
/* 176 */     (
/* 178 */       localObject1 = FrameUtils.a(new InteractionData(), (String)localObject1, new JSONObject()))
/* 178 */       .d().c("com.alipay.mobilecashier");
/* 179 */     ((Request)localObject1).d().a("com.alipay.mcpay");
/* 180 */     ((Request)localObject1).d().e("4.0.3");
/* 181 */     ((Request)localObject1).d().d("/cashier/main");
/* 182 */     RequestWrapper localRequestWrapper = new RequestWrapper(new InteractionData());
/*     */     try
/*     */     {
/* 186 */       localObject1 = localRequestWrapper.a(this, (Request)localObject1, false)
/* 186 */         .c();
/*     */ 
/* 188 */       f();
/*     */ 
/* 190 */       a((JSONObject)localObject1);
/*     */     } catch (NetErrorException localNetErrorException) {
/* 192 */       runOnUiThread(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 196 */           H5AuthActivity.b(H5AuthActivity.this);
/*     */         }
/*     */       });
/*     */     }
/*     */     catch (Exception localException) {
/* 201 */       runOnUiThread(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 205 */           H5AuthActivity.c(H5AuthActivity.this);
/*     */         } } );
/*     */     }
/*     */     finally {
/* 209 */       f();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void a(final JSONObject paramJSONObject)
/*     */     throws FailOperatingException
/*     */   {
/* 216 */     if ((
/* 216 */       paramJSONObject = ElementAction.a(paramJSONObject.optJSONObject("form"), "onload")) == null)
/*     */     {
/* 217 */       throw new FailOperatingException();
/*     */     }
/*     */ 
/* 221 */     int i = (paramJSONObject = ActionType.a(paramJSONObject)).length;
/*     */ 
/* 221 */     for (int j = 0; j < i; j++)
/*     */     {
/*     */       Object localObject;
/* 222 */       if ((
/* 222 */         localObject = paramJSONObject[j]) == 
/* 222 */         ActionType.a)
/*     */       {
/* 226 */         if (!Utils.a(paramJSONObject = com.alipay.sdk.util.ActionUtil.a(localObject.e())[
/* 224 */           0]))
/*     */         {
/* 227 */           finish(); return;
/*     */         }
/*     */ 
/* 230 */         runOnUiThread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 234 */             H5AuthActivity.d(H5AuthActivity.this).loadUrl(paramJSONObject);
/*     */           }
/*     */         });
/* 238 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void c()
/*     */   {
/*     */     AlertDialog.Builder localBuilder;
/* 389 */     (
/* 390 */       localBuilder = new AlertDialog.Builder(this))
/* 390 */       .setMessage("不能连接到服务器，是否重试？");
/* 391 */     localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 395 */         new Thread()
/*     */         {
/*     */           public void run() {
/* 398 */             H5AuthActivity.a(H5AuthActivity.this);
/*     */           }
/*     */         }
/* 395 */         .start();
/*     */       }
/*     */     });
/* 404 */     localBuilder.setNeutralButton("取消", new DialogInterface.OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 408 */         H5AuthActivity.this.finish();
/*     */       }
/*     */     });
/* 412 */     localBuilder.create().show();
/*     */   }
/*     */ 
/*     */   private void d()
/*     */   {
/*     */     AlertDialog.Builder localBuilder;
/* 416 */     (
/* 417 */       localBuilder = new AlertDialog.Builder(this))
/* 417 */       .setMessage("系统繁忙，请稍后再试");
/* 418 */     localBuilder.setNeutralButton("确定", new DialogInterface.OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 422 */         H5AuthActivity.this.finish();
/*     */       }
/*     */     });
/* 426 */     localBuilder.create().show();
/*     */   }
/*     */ 
/*     */   private void a(String paramString) {
/* 430 */     new JsBridge(this, new IJsCallback()
/*     */     {
/*     */       public final void a(CallInfo paramAnonymousCallInfo)
/*     */       {
/* 434 */         H5AuthActivity.a(H5AuthActivity.this, paramAnonymousCallInfo);
/*     */       }
/*     */     }).a(paramString);
/*     */   }
/*     */ 
/*     */   private void a(final CallInfo paramCallInfo)
/*     */   {
/* 443 */     if ((this.a == null) || (paramCallInfo == null)) {
/* 444 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 448 */       paramCallInfo = paramCallInfo.d();
/*     */ 
/* 451 */       paramCallInfo = String.format("AlipayJSBridge._invokeJS(%s)", new Object[] { paramCallInfo });
/*     */ 
/* 454 */       paramCallInfo = new Runnable()
/*     */       {
/*     */         public void run() {
/*     */           try { H5AuthActivity.d(H5AuthActivity.this).loadUrl("javascript:" + paramCallInfo);
/*     */             return;
/*     */           }
/*     */           catch (Exception localException) {
/* 462 */             localException.printStackTrace();
/*     */           }
/*     */         } } ;
/* 465 */       runOnUiThread(paramCallInfo);
/*     */       return;
/*     */     }
/*     */     catch (JSONException localJSONException) {
/* 469 */       localJSONException.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void e()
/*     */   {
/* 482 */     if (this.b == null)
/* 483 */       this.b = new Loading(this); try { this.b.b();
/*     */       return;
/*     */     } catch (Exception localException) {
/* 487 */       this.b = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void f() {
/* 492 */     if ((this.b != null) && (this.b.a()))
/* 493 */       this.b.c();
/* 494 */     this.b = null;
/*     */   }
/*     */ 
/*     */   public void onConfigurationChanged(Configuration paramConfiguration)
/*     */   {
/* 499 */     super.onConfigurationChanged(paramConfiguration);
/*     */   }
/*     */ 
/*     */   private class MyWebChromeClient extends WebChromeClient
/*     */   {
/*     */     private MyWebChromeClient()
/*     */     {
/*     */     }
/*     */ 
/*     */     public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
/*     */     {
/*     */       String str1;
/* 370 */       if (TextUtils.isEmpty(str1 = paramConsoleMessage.message()))
/*     */       {
/* 371 */         return super.onConsoleMessage(paramConsoleMessage);
/*     */       }
/*     */ 
/* 374 */       String str2 = null;
/* 375 */       if (str1.startsWith("h5container.message: ")) {
/* 376 */         str2 = str1.replaceFirst("h5container.message: ", "");
/*     */       }
/*     */ 
/* 379 */       if (TextUtils.isEmpty(str2)) {
/* 380 */         return super.onConsoleMessage(paramConsoleMessage);
/*     */       }
/* 382 */       H5AuthActivity.a(H5AuthActivity.this, str2);
/* 383 */       return super.onConsoleMessage(paramConsoleMessage);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class MyWebViewClient extends WebViewClient
/*     */   {
/*     */     private MyWebViewClient()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void onReceivedSslError(WebView paramWebView, final SslErrorHandler paramSslErrorHandler, SslError paramSslError)
/*     */     {
/* 251 */       if (H5AuthActivity.e(H5AuthActivity.this)) {
/* 252 */         paramSslErrorHandler.proceed();
/* 253 */         H5AuthActivity.a(H5AuthActivity.this, false);
/* 254 */         return;
/*     */       }
/*     */ 
/* 257 */       H5AuthActivity.this.runOnUiThread(new Runnable() {
/*     */         public void run() {
/* 259 */           SystemDefaultDialog.a(H5AuthActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 267 */               H5AuthActivity.a(H5AuthActivity.this, true);
/* 268 */               H5AuthActivity.MyWebViewClient.1.this.a.proceed();
/* 269 */               paramAnonymous2DialogInterface.dismiss();
/*     */             }
/*     */           }
/*     */           , "退出", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 276 */               H5AuthActivity.MyWebViewClient.1.this.a.cancel();
/* 277 */               H5AuthActivity.a(H5AuthActivity.this, false);
/* 278 */               Result.a(Result.b());
/* 279 */               H5AuthActivity.this.finish();
/*     */             }
/*     */           });
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/*     */     public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
/*     */     {
/* 289 */       if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit")))
/*     */       {
/* 291 */         Result.a(Result.b());
/* 292 */         H5AuthActivity.this.finish();
/* 293 */         return true;
/*     */       }
/*     */ 
/* 296 */       if (paramString.startsWith("sdklite://h5quit?result="))
/*     */       {
/*     */         try
/*     */         {
/*     */           String tmp55_52 = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
/*     */ 
/* 305 */           if ((
/* 305 */             paramWebView = Integer.parseInt(tmp55_52
/* 301 */             .substring(tmp55_52
/* 301 */             .lastIndexOf("&end_code=") + 10))) == 
/* 305 */             ResultStatus.a.a())
/*     */           {
/*     */             String tmp85_82 = URLDecoder.decode(paramString);
/* 307 */             paramString = tmp85_82
/* 307 */               .substring((paramString = tmp85_82)
/* 307 */               .indexOf("sdklite://h5quit?result=") + 24, paramString.lastIndexOf("&end_code="));
/*     */ 
/* 318 */             Result.a(Result.a((
/* 318 */               paramWebView = ResultStatus.a(paramWebView))
/* 318 */               .a(), paramWebView.b(), paramString));
/*     */           }
/*     */           else
/*     */           {
/* 325 */             Result.a(Result.a((
/* 325 */               paramString = ResultStatus.a(ResultStatus.b.a()))
/* 325 */               .a(), paramString.b(), ""));
/*     */           }
/*     */         }
/*     */         catch (Exception localException)
/*     */         {
/* 330 */           Result.a(Result.c());
/*     */         }
/* 332 */         paramWebView = new Runnable()
/*     */         {
/*     */           public void run() {
/* 335 */             H5AuthActivity.this.finish();
/*     */           }
/*     */         };
/* 338 */         H5AuthActivity.this.runOnUiThread(paramWebView);
/*     */ 
/* 340 */         return true;
/*     */       }
/*     */ 
/* 343 */       paramWebView.loadUrl(paramString);
/* 344 */       return true;
/*     */     }
/*     */ 
/*     */     public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
/*     */     {
/* 350 */       H5AuthActivity.f(H5AuthActivity.this);
/* 351 */       H5AuthActivity.h(H5AuthActivity.this).postDelayed(H5AuthActivity.g(H5AuthActivity.this), 30000L);
/* 352 */       super.onPageStarted(paramWebView, paramString, paramBitmap);
/*     */     }
/*     */ 
/*     */     public void onPageFinished(WebView paramWebView, String paramString)
/*     */     {
/* 357 */       H5AuthActivity.i(H5AuthActivity.this);
/* 358 */       H5AuthActivity.h(H5AuthActivity.this).removeCallbacks(H5AuthActivity.g(H5AuthActivity.this));
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.app.H5AuthActivity
 * JD-Core Version:    0.6.2
 */