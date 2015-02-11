/*     */ package com.alipay.sdk.auth;
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
/*     */ import com.alipay.sdk.app.Result;
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
/*     */ import com.alipay.sdk.util.Utils;
/*     */ import com.alipay.sdk.widget.Loading;
/*     */ import com.alipay.sdk.widget.SystemDefaultDialog;
/*     */ import java.lang.reflect.Method;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class AuthActivity extends Activity
/*     */ {
/*     */   static final String a = "params";
/*     */   static final String b = "redirectUri";
/*     */   private WebView c;
/*     */   private String d;
/*     */   private Loading e;
/*  71 */   private Handler f = new Handler();
/*     */   private boolean g;
/* 429 */   private Runnable h = new Runnable()
/*     */   {
/*     */     public void run()
/*     */     {
/* 433 */       AuthActivity.i(AuthActivity.this);
/* 434 */       AuthActivity.b(AuthActivity.this);
/*     */     }
/* 429 */   };
/*     */ 
/*     */   protected void onCreate(Bundle paramBundle)
/*     */   {
/*  76 */     super.onCreate(paramBundle);
/*     */ 
/*  78 */     if (getIntent().getExtras() == null)
/*     */     {
/*  79 */       finish();
/*  80 */       return;
/*     */     }
/*     */ 
/*  83 */     super.requestWindowFeature(1);
/*  84 */     GlobalContext.a().a(this, MspConfig.a());
/*     */ 
/*  86 */     paramBundle = new LinearLayout(this);
/*  87 */     LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
/*     */ 
/*  89 */     paramBundle.setOrientation(1);
/*  90 */     setContentView(paramBundle, localLayoutParams);
/*     */ 
/*  92 */     this.c = new WebView(this);
/*  93 */     localLayoutParams.weight = 1.0F;
/*  94 */     this.c.setVisibility(0);
/*  95 */     paramBundle.addView(this.c, localLayoutParams);
/*     */ 
/*  97 */     (
/*  98 */       paramBundle = this.c.getSettings())
/*  98 */       .setUserAgentString(paramBundle.getUserAgentString() + Utils.c(this));
/*     */ 
/* 100 */     paramBundle.setRenderPriority(WebSettings.RenderPriority.HIGH);
/* 101 */     paramBundle.setSupportMultipleWindows(true);
/* 102 */     paramBundle.setJavaScriptEnabled(true);
/* 103 */     paramBundle.setSavePassword(false);
/* 104 */     paramBundle.setJavaScriptCanOpenWindowsAutomatically(true);
/* 105 */     paramBundle.setMinimumFontSize(paramBundle.getMinimumFontSize() + 8);
/* 106 */     paramBundle.setAllowFileAccess(false);
/* 107 */     this.c.setVerticalScrollbarOverlay(true);
/* 108 */     this.c.setWebViewClient(new MyWebViewClient((byte)0));
/* 109 */     this.c.setWebChromeClient(new MyWebChromeClient((byte)0));
/* 110 */     this.c.setDownloadListener(new DownloadListener()
/*     */     {
/*     */       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
/*     */       {
/* 116 */         paramAnonymousString1 = Uri.parse(paramAnonymousString1);
/* 117 */         paramAnonymousString1 = new Intent("android.intent.action.VIEW", paramAnonymousString1);
/* 118 */         AuthActivity.this.startActivity(paramAnonymousString1);
/*     */       }
/*     */     });
/* 122 */     new Thread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 126 */         AuthActivity.a(AuthActivity.this);
/*     */       }
/*     */     }).start();
/*     */ 
/* 130 */     if (Build.VERSION.SDK_INT >= 7)
/*     */     {
/*     */       try
/*     */       {
/* 134 */         if ((
/* 134 */           paramBundle = this.c.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE })) != null)
/*     */         {
/* 135 */           paramBundle.invoke(this.c.getSettings(), new Object[] { Boolean.valueOf(true) });
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */       }
/*     */     }
/*     */     try {
/* 143 */       if ((
/* 143 */         paramBundle = this.c.getClass().getMethod("removeJavascriptInterface", new Class[0])) != null)
/*     */       {
/* 144 */         paramBundle.invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
/*     */       }
/*     */ 
/* 148 */       return; } catch (Exception localException2) {
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void onDestroy() {
/* 153 */     super.onDestroy();
/*     */   }
/*     */ 
/*     */   private void a() {
/* 157 */     d();
/*     */ 
/* 159 */     Object localObject1 = null;
/*     */     try {
/* 161 */       localObject1 = getIntent().getExtras().getString("params");
/* 162 */       this.d = getIntent().getExtras().getString("redirectUri");
/*     */     } catch (Exception localException1) {
/* 164 */       e();
/* 165 */       finish();
/* 166 */       return;
/*     */     }
/* 168 */     (
/* 170 */       localObject1 = FrameUtils.a(new InteractionData(), (String)localObject1, new JSONObject()))
/* 170 */       .d().c("com.alipay.mobilecashier");
/* 171 */     ((Request)localObject1).d().a("com.alipay.mcpay");
/* 172 */     ((Request)localObject1).d().e("4.0.0");
/* 173 */     ((Request)localObject1).d().d("/cashier/main");
/* 174 */     RequestWrapper localRequestWrapper = new RequestWrapper(new InteractionData());
/*     */     try
/*     */     {
/* 178 */       localObject1 = localRequestWrapper.a(this, (Request)localObject1, false)
/* 178 */         .c();
/*     */ 
/* 180 */       e();
/*     */ 
/* 182 */       a((JSONObject)localObject1);
/*     */     } catch (NetErrorException localNetErrorException) {
/* 184 */       runOnUiThread(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 188 */           AuthActivity.b(AuthActivity.this);
/*     */         }
/*     */       });
/*     */     }
/*     */     catch (Exception localException2) {
/* 193 */       runOnUiThread(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 197 */           AuthActivity.c(AuthActivity.this);
/*     */         } } );
/*     */     }
/*     */     finally {
/* 201 */       e();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void a(final JSONObject paramJSONObject)
/*     */     throws FailOperatingException
/*     */   {
/* 208 */     if ((
/* 208 */       paramJSONObject = ElementAction.a(paramJSONObject.optJSONObject("form"), "onload")) == null)
/*     */     {
/* 209 */       throw new FailOperatingException();
/*     */     }
/*     */ 
/* 213 */     int i = (paramJSONObject = ActionType.a(paramJSONObject)).length;
/*     */ 
/* 213 */     for (int j = 0; j < i; j++)
/*     */     {
/*     */       Object localObject;
/* 214 */       if ((
/* 214 */         localObject = paramJSONObject[j]) == 
/* 214 */         ActionType.a)
/*     */       {
/* 218 */         if (!Utils.a(paramJSONObject = com.alipay.sdk.util.ActionUtil.a(localObject.e())[
/* 216 */           0]))
/*     */         {
/* 219 */           finish(); return;
/*     */         }
/*     */ 
/* 222 */         runOnUiThread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 226 */             AuthActivity.d(AuthActivity.this).loadUrl(paramJSONObject);
/*     */           }
/*     */         });
/* 230 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean a(String paramString)
/*     */   {
/* 328 */     if (TextUtils.isEmpty(paramString)) {
/* 329 */       return false;
/*     */     }
/* 331 */     if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
/* 332 */       return false;
/*     */     }
/*     */ 
/* 335 */     if (!"SDKLite://h5quit".equalsIgnoreCase(paramString)) {
/* 336 */       if (TextUtils.equals(paramString, this.d)) {
/* 337 */         paramString = paramString + "?resultCode=150";
/*     */       }
/* 339 */       AuthHelper.a(this, paramString);
/*     */     }
/* 341 */     finish();
/* 342 */     return true;
/*     */   }
/*     */ 
/*     */   private void b()
/*     */   {
/*     */     AlertDialog.Builder localBuilder;
/* 346 */     (
/* 347 */       localBuilder = new AlertDialog.Builder(this))
/* 347 */       .setMessage("不能连接到服务器，是否重试？");
/* 348 */     localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 352 */         new Thread()
/*     */         {
/*     */           public void run() {
/* 355 */             AuthActivity.a(AuthActivity.this);
/*     */           }
/*     */         }
/* 352 */         .start();
/*     */       }
/*     */     });
/* 361 */     localBuilder.setNeutralButton("取消", new DialogInterface.OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 365 */         AuthActivity.this.finish();
/*     */       }
/*     */     });
/* 369 */     localBuilder.create().show();
/*     */   }
/*     */ 
/*     */   private void c()
/*     */   {
/*     */     AlertDialog.Builder localBuilder;
/* 373 */     (
/* 374 */       localBuilder = new AlertDialog.Builder(this))
/* 374 */       .setMessage("系统繁忙，请稍后再试");
/* 375 */     localBuilder.setNeutralButton("确定", new DialogInterface.OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 379 */         AuthActivity.this.finish();
/*     */       }
/*     */     });
/* 383 */     localBuilder.create().show();
/*     */   }
/*     */ 
/*     */   private void b(String paramString) {
/* 387 */     new JsBridge(this, new IJsCallback()
/*     */     {
/*     */       public final void a(CallInfo paramAnonymousCallInfo)
/*     */       {
/* 391 */         AuthActivity.a(AuthActivity.this, paramAnonymousCallInfo);
/*     */       }
/*     */     }).a(paramString);
/*     */   }
/*     */ 
/*     */   private void a(final CallInfo paramCallInfo)
/*     */   {
/* 400 */     if ((this.c == null) || (paramCallInfo == null)) {
/* 401 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 405 */       paramCallInfo = paramCallInfo.d();
/*     */ 
/* 408 */       paramCallInfo = String.format("AlipayJSBridge._invokeJS(%s)", new Object[] { paramCallInfo });
/*     */ 
/* 411 */       paramCallInfo = new Runnable()
/*     */       {
/*     */         public void run() {
/*     */           try { AuthActivity.d(AuthActivity.this).loadUrl("javascript:" + paramCallInfo);
/*     */             return;
/*     */           }
/*     */           catch (Exception localException) {
/* 419 */             localException.printStackTrace();
/*     */           }
/*     */         } } ;
/* 422 */       runOnUiThread(paramCallInfo);
/*     */       return;
/*     */     }
/*     */     catch (JSONException localJSONException) {
/* 426 */       localJSONException.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void d()
/*     */   {
/* 439 */     if (this.e == null)
/* 440 */       this.e = new Loading(this); try { this.e.b();
/*     */       return;
/*     */     } catch (Exception localException) {
/* 444 */       this.e = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void e() {
/* 449 */     if ((this.e != null) && (this.e.a()))
/* 450 */       this.e.c();
/* 451 */     this.e = null;
/*     */   }
/*     */ 
/*     */   public void onConfigurationChanged(Configuration paramConfiguration)
/*     */   {
/* 456 */     super.onConfigurationChanged(paramConfiguration);
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
/* 309 */       if (TextUtils.isEmpty(str1 = paramConsoleMessage.message()))
/*     */       {
/* 310 */         return super.onConsoleMessage(paramConsoleMessage);
/*     */       }
/*     */ 
/* 313 */       String str2 = null;
/* 314 */       if (str1.startsWith("h5container.message: ")) {
/* 315 */         str2 = str1.replaceFirst("h5container.message: ", "");
/*     */       }
/*     */ 
/* 318 */       if (TextUtils.isEmpty(str2)) {
/* 319 */         return super.onConsoleMessage(paramConsoleMessage);
/*     */       }
/* 321 */       AuthActivity.b(AuthActivity.this, str2);
/* 322 */       return super.onConsoleMessage(paramConsoleMessage);
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
/* 243 */       if (AuthActivity.e(AuthActivity.this)) {
/* 244 */         paramSslErrorHandler.proceed();
/* 245 */         AuthActivity.a(AuthActivity.this, false);
/* 246 */         return;
/*     */       }
/*     */ 
/* 249 */       AuthActivity.this.runOnUiThread(new Runnable() {
/*     */         public void run() {
/* 251 */           SystemDefaultDialog.a(AuthActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 259 */               AuthActivity.a(AuthActivity.this, true);
/* 260 */               AuthActivity.MyWebViewClient.1.this.a.proceed();
/* 261 */               paramAnonymous2DialogInterface.dismiss();
/*     */             }
/*     */           }
/*     */           , "退出", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 268 */               AuthActivity.MyWebViewClient.1.this.a.cancel();
/* 269 */               AuthActivity.a(AuthActivity.this, false);
/* 270 */               Result.a(Result.b());
/* 271 */               AuthActivity.this.finish();
/*     */             }
/*     */           });
/*     */         }
/*     */       });
/*     */     }
/*     */ 
/*     */     public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
/*     */     {
/* 280 */       if (AuthActivity.a(AuthActivity.this, paramString)) {
/* 281 */         paramWebView.stopLoading();
/* 282 */         return true;
/*     */       }
/* 284 */       return super.shouldOverrideUrlLoading(paramWebView, paramString);
/*     */     }
/*     */ 
/*     */     public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
/*     */     {
/* 289 */       AuthActivity.f(AuthActivity.this);
/* 290 */       AuthActivity.h(AuthActivity.this).postDelayed(AuthActivity.g(AuthActivity.this), 30000L);
/* 291 */       super.onPageStarted(paramWebView, paramString, paramBitmap);
/*     */     }
/*     */ 
/*     */     public void onPageFinished(WebView paramWebView, String paramString)
/*     */     {
/* 296 */       AuthActivity.i(AuthActivity.this);
/* 297 */       AuthActivity.h(AuthActivity.this).removeCallbacks(AuthActivity.g(AuthActivity.this));
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.auth.AuthActivity
 * JD-Core Version:    0.6.2
 */