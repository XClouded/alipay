package com.alipay.sdk.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.cons.GlobalConstants;
import com.alipay.sdk.util.Utils;
import com.alipay.sdk.widget.Loading;
import com.alipay.sdk.widget.SystemDefaultDialog;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class H5PayActivity extends Activity
{
    private WebView a;
    private Loading b;
    private Handler c = new Handler();
    private boolean d;
    private boolean e;
    private Runnable f = new Runnable() {
        public void run() {
            H5PayActivity.f(H5PayActivity.this);
        }
    };

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);

        paramBundle = getIntent().getExtras();
        if (paramBundle == null) {
            finish();
            return;
        }
        try {
            String str = paramBundle.getString("url");
        } catch (Exception localException1) {
            finish();
            return;
        }

        if (!Utils.a(str)) {
            finish();
            return;
        }

        super.requestWindowFeature(1);

        if (!TextUtils.isEmpty(paramBundle = paramBundle.getString("cookie"))) {
            CookieSyncManager.createInstance(this).sync();
            CookieManager.getInstance().setCookie(str, paramBundle);
            CookieSyncManager.getInstance().sync();
        }

        paramBundle = new LinearLayout(this);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);

        paramBundle.setOrientation(1);
        setContentView(paramBundle, localLayoutParams);

        this.a = new WebView(this);
        localLayoutParams.weight = 1.0F;
        this.a.setVisibility(0);
        paramBundle.addView(this.a, localLayoutParams);

        (paramBundle = this.a.getSettings()).setUserAgentString(paramBundle.getUserAgentString() + Utils.c(this));

        paramBundle.setRenderPriority(WebSettings.RenderPriority.HIGH);
        paramBundle.setSupportMultipleWindows(true);
        paramBundle.setJavaScriptEnabled(true);
        paramBundle.setSavePassword(false);
        paramBundle.setJavaScriptCanOpenWindowsAutomatically(true);
        paramBundle.setMinimumFontSize(paramBundle.getMinimumFontSize() + 8);
        paramBundle.setAllowFileAccess(false);
        this.a.setVerticalScrollbarOverlay(true);
        this.a.setWebViewClient(new MyWebViewClient((byte)0));
        this.a.setWebChromeClient(new MyWebChromeClient((byte)0));

        this.a.loadUrl(str);

        if (Build.VERSION.SDK_INT >= 7) {
            try {
                if ((paramBundle = this.a.getSettings().getClass().
                            getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE })) != null) {
                    paramBundle.invoke(this.a.getSettings(), new Object[] { Boolean.valueOf(true) });
                }
            } catch (Exception localException2) {
            }
        }
        try {
            if ((paramBundle = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0])) != null) {
                paramBundle.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
            }
            return;
        } catch (Exception localException3) {
        }
    }

    public void onBackPressed() {
        if (this.a.canGoBack()) {
            if (this.d) {
                ResultStatus localResultStatus;
                Result.a(Result.a((
                localResultStatus = ResultStatus.a(ResultStatus.d.a())).a(), localResultStatus.b(), ""));
                finish();
                return;
            }
            return;
        }
        Result.a(Result.b());
        finish();
    }

    public void finish() {
        synchronized (localObject1 = PayTask.a) {
            try {
                Object localObject1;
                localObject1.notify();
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
        super.finish();
    }

    private static void a() {
        synchronized (localObject1 = PayTask.a) {
            try {
                Object localObject1;
                localObject1.notify();
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            return;
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    private void b() {
        if (this.b == null)
            this.b = new Loading(this);
        this.b.b();
    }

    private void c() {
        if ((this.b != null) && (this.b.a()))
            this.b.c();
        this.b = null;
    }

    private class MyWebChromeClient extends WebChromeClient {

        private MyWebChromeClient() {

        }

        public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult) {
            new AlertDialog.Builder(H5PayActivity.this)
                .setTitle("提示")
                .setMessage(paramString2)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramJsResult.confirm();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramJsResult.cancel();
                    }
                }).show();

                return true;
        }

        public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, final JsResult paramJsResult) {
            new AlertDialog.Builder(H5PayActivity.this)
                .setTitle("提示")
                .setMessage(paramString2)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramJsResult.confirm();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramJsResult.cancel();
                    }
                }).show();

            return true;
        }

        public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, final JsPromptResult paramJsPromptResult) {
            new AlertDialog.Builder(H5PayActivity.this)
                .setTitle("提示")
                .setMessage(paramString2)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramJsPromptResult.confirm();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramJsPromptResult.cancel();
                }
            }).show();

            return true;
        }
    }

    private class MyWebViewClient extends WebViewClient
    {

        private MyWebViewClient() {

        }

        public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
            H5PayActivity.a(H5PayActivity.this);
            super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
        }

        public void onReceivedSslError(WebView paramWebView, final SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
            if (H5PayActivity.b(H5PayActivity.this)) {
                paramSslErrorHandler.proceed();
                H5PayActivity.a(H5PayActivity.this, false);
                return;
            }

            H5PayActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    SystemDefaultDialog.a(H5PayActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            H5PayActivity.a(H5PayActivity.this, true);
                            H5PayActivity.MyWebViewClient.1.this.a.proceed();
                            paramAnonymous2DialogInterface.dismiss();
                        }
                    }
                    , "退出", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                        {
                            H5PayActivity.MyWebViewClient.1.this.a.cancel();
                            H5PayActivity.a(H5PayActivity.this, false);
                            Result.a(Result.b());
                            H5PayActivity.this.finish();
                        }
                    });
                }
            });
        }

        public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2) {

        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            if (paramString.startsWith("alipays://platformapi/startApp?")) {
                return false;
            }
            if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit"))) {
                Result.a(Result.b());
                H5PayActivity.this.finish();
                return true;
            }

            if (paramString.startsWith("sdklite://h5quit?result=")) {
                try {
                    String tmp66_63 = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
                    Object localObject;
                    if ((Integer.parseInt(tmp66_63.substring(tmp66_63.lastIndexOf("&end_code=") + 10)) == ResultStatus.a.a()) || (paramWebView == ResultStatus.f.a())) {
                        localObject = new StringBuilder();
                        String str1;
                        String str2;
                        if (GlobalConstants.n) {
                            String tmp126_123 = URLDecoder.decode(str1 = URLDecoder.decode(paramString));
                            str2 = tmp126_123.substring((str2 = tmp126_123).indexOf("sdklite://h5quit?result=") + 24, str2.lastIndexOf("&end_code=")).split("&return_url=")[0];
                            paramString = str1.indexOf("&return_url=") + 12;
                            ((StringBuilder)localObject).append(str2).append("&return_url=").append(str1.substring(paramString, str1.indexOf("&", paramString))).append(str1.substring(str1.indexOf("&", paramString)));
                            paramString = ((StringBuilder)localObject).toString();
                        } else {
                            String tmp225_222 = URLDecoder.decode(paramString);
                            paramString = tmp225_222.substring(tmp225_222.indexOf("sdklite://h5quit?result=") + 24, str1.lastIndexOf("&end_code="));
                            if (paramString.contains("&return_url=\"")) {
                                str2 = paramString.split("&return_url=\"")[0];
                                int i = paramString.indexOf("&return_url=\"") + 13;

                                ((StringBuilder)localObject).append(str2).append("&return_url=\"").append(paramString.substring(i, paramString.indexOf("\"&", i))).append(paramString.substring(paramString.indexOf("\"&", i)));

                                paramString = ((StringBuilder)localObject).toString();
                            }
                        }
                        ResultStatus localResultStatus;
                        Result.a(Result.a((localResultStatus = ResultStatus.a(paramWebView)).a(), localResultStatus.b(), paramString));
                    } else {
                        Result.a(Result.a((localObject = ResultStatus.a(ResultStatus.b.a())).a(), ((ResultStatus)localObject).b(), ""));
                    }
                } catch (Exception localException) {
                    Result.a(Result.c());
                }

                paramWebView = new Runnable() {
                    public void run() {
                        H5PayActivity.this.finish();
                    }
                };
                H5PayActivity.this.runOnUiThread(paramWebView);
                return true;
            }
            paramWebView.loadUrl(paramString);
            return true;
        }

        public void onLoadResource(WebView paramWebView, String paramString) {

        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            H5PayActivity.c(H5PayActivity.this);
            H5PayActivity.e(H5PayActivity.this).postDelayed(H5PayActivity.d(H5PayActivity.this), 30000L);
            super.onPageStarted(paramWebView, paramString, paramBitmap);
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            H5PayActivity.f(H5PayActivity.this);
            H5PayActivity.e(H5PayActivity.this).removeCallbacks(H5PayActivity.d(H5PayActivity.this));
        }

    }
}
