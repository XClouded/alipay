package com.alipay.sdk.auth;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.app.Result;
import com.alipay.sdk.authjs.CallInfo;
import com.alipay.sdk.authjs.IJsCallback;
import com.alipay.sdk.authjs.JsBridge;
import com.alipay.sdk.data.Envelope;
import com.alipay.sdk.data.FrameUtils;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.data.MspConfig;
import com.alipay.sdk.data.Request;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.net.RequestWrapper;
import com.alipay.sdk.protocol.ActionType;
import com.alipay.sdk.protocol.ElementAction;
import com.alipay.sdk.protocol.FrameData;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.util.Utils;
import com.alipay.sdk.widget.Loading;
import com.alipay.sdk.widget.SystemDefaultDialog;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthActivity extends Activity
{
    static final String a = "params";
    static final String b = "redirectUri";
    private WebView c;
    private String d;
    private Loading e;
    private Handler f = new Handler();
    private boolean g;
    private Runnable h = new Runnable() {
        public void run() {
            AuthActivity.i(AuthActivity.this);
            AuthActivity.b(AuthActivity.this);
        }
    };

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);

        if (getIntent().getExtras() == null) {
            finish();
            return;
        }

        super.requestWindowFeature(1);
        GlobalContext.a().a(this, MspConfig.a());

        paramBundle = new LinearLayout(this);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);

        paramBundle.setOrientation(1);
        setContentView(paramBundle, localLayoutParams);

        this.c = new WebView(this);
        localLayoutParams.weight = 1.0F;
        this.c.setVisibility(0);
        paramBundle.addView(this.c, localLayoutParams);

        (paramBundle = this.c.getSettings()).setUserAgentString(paramBundle.getUserAgentString() + Utils.c(this));

        paramBundle.setRenderPriority(WebSettings.RenderPriority.HIGH);
        paramBundle.setSupportMultipleWindows(true);
        paramBundle.setJavaScriptEnabled(true);
        paramBundle.setSavePassword(false);
        paramBundle.setJavaScriptCanOpenWindowsAutomatically(true);
        paramBundle.setMinimumFontSize(paramBundle.getMinimumFontSize() + 8);
        paramBundle.setAllowFileAccess(false);
        this.c.setVerticalScrollbarOverlay(true);
        this.c.setWebViewClient(new MyWebViewClient((byte)0));
        this.c.setWebChromeClient(new MyWebChromeClient((byte)0));
        this.c.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
                paramAnonymousString1 = Uri.parse(paramAnonymousString1);
                paramAnonymousString1 = new Intent("android.intent.action.VIEW", paramAnonymousString1);
                AuthActivity.this.startActivity(paramAnonymousString1);
            }
        });
        new Thread(new Runnable() {
            public void run() {
                AuthActivity.a(AuthActivity.this);
            }
        }).start();

        if (Build.VERSION.SDK_INT >= 7) {
            try {
                if ((paramBundle = this.c.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE })) != null) {
                    paramBundle.invoke(this.c.getSettings(), new Object[] { Boolean.valueOf(true) });
                }
            } catch (Exception localException1) {

            }
        }
        try {
            if ((paramBundle = this.c.getClass().getMethod("removeJavascriptInterface", new Class[0])) != null) {
                paramBundle.invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
            }
            return;
        } catch (Exception localException2) {

        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void a() {
        d();

        Object localObject1 = null;
        try {
            localObject1 = getIntent().getExtras().getString("params");
            this.d = getIntent().getExtras().getString("redirectUri");
        } catch (Exception localException1) {
            e();
            finish();
            return;
        }
        (localObject1 = FrameUtils.a(new InteractionData(), (String)localObject1, new JSONObject())).d().c("com.alipay.mobilecashier");
        ((Request)localObject1).d().a("com.alipay.mcpay");
        ((Request)localObject1).d().e("4.0.0");
        ((Request)localObject1).d().d("/cashier/main");
        RequestWrapper localRequestWrapper = new RequestWrapper(new InteractionData());
        try {
            localObject1 = localRequestWrapper.a(this, (Request)localObject1, false).c();
            e();
            a((JSONObject)localObject1);
        } catch (NetErrorException localNetErrorException) {
            runOnUiThread(new Runnable() {
                public void run() {
                    AuthActivity.b(AuthActivity.this);
                }
            });
        } catch (Exception localException2) {
            runOnUiThread(new Runnable() {
                public void run() {
                    AuthActivity.c(AuthActivity.this);
                } } );
        } finally {
            e();
        }
    }

    private void a(final JSONObject paramJSONObject) throws FailOperatingException {
        if ((paramJSONObject = ElementAction.a(paramJSONObject.optJSONObject("form"), "onload")) == null) {
            throw new FailOperatingException();
        }

        int i = (paramJSONObject = ActionType.a(paramJSONObject)).length;

        for (int j = 0; j < i; j++) {
            Object localObject;
            if ((localObject = paramJSONObject[j]) == ActionType.a) {
                if (!Utils.a(paramJSONObject = com.alipay.sdk.util.ActionUtil.a(localObject.e())[0])) {
                    finish(); return;
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        AuthActivity.d(AuthActivity.this).loadUrl(paramJSONObject);
                    }
                });
                return;
            }
        }
    }

    private boolean a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return false;
        }
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
            return false;
        }

        if (!"SDKLite://h5quit".equalsIgnoreCase(paramString)) {
            if (TextUtils.equals(paramString, this.d)) {
                paramString = paramString + "?resultCode=150";
            }
            AuthHelper.a(this, paramString);
        }
        finish();
        return true;
    }

    private void b() {
        AlertDialog.Builder localBuilder;
        (localBuilder = new AlertDialog.Builder(this)).setMessage("不能连接到服务器，是否重试？");
        localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                new Thread() {
                    public void run() {
                        AuthActivity.a(AuthActivity.this);
                    }
                }.start();
            }
        });
        localBuilder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                AuthActivity.this.finish();
            }
        });
        localBuilder.create().show();
    }

    private void c() {
        AlertDialog.Builder localBuilder;
        (localBuilder = new AlertDialog.Builder(this)).setMessage("系统繁忙，请稍后再试");
        localBuilder.setNeutralButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                AuthActivity.this.finish();
            }
        });
        localBuilder.create().show();
    }

    private void b(String paramString) {
        new JsBridge(this, new IJsCallback() {
            public final void a(CallInfo paramAnonymousCallInfo) {
                AuthActivity.a(AuthActivity.this, paramAnonymousCallInfo);
            }
        }).a(paramString);
    }

    private void a(final CallInfo paramCallInfo) {
        if ((this.c == null) || (paramCallInfo == null)) {
            return;
        }
        try {
            paramCallInfo = paramCallInfo.d();
            paramCallInfo = String.format("AlipayJSBridge._invokeJS(%s)", new Object[] { paramCallInfo });
            paramCallInfo = new Runnable() {
                public void run() {
                    try {
                        AuthActivity.d(AuthActivity.this).loadUrl("javascript:" + paramCallInfo);
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            } ;
            runOnUiThread(paramCallInfo);
            return;
        } catch (JSONException localJSONException) {
            localJSONException.printStackTrace();
        }
    }

    private void d() {
        if (this.e == null)
            this.e = new Loading(this);
        try {
            this.e.b();
            return;
        } catch (Exception localException) {
            this.e = null;
        }
    }

    private void e() {
        if ((this.e != null) && (this.e.a()))
            this.e.c();
        this.e = null;
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    private class MyWebChromeClient extends WebChromeClient {

        private MyWebChromeClient() {

        }

        public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage) {
            String str1;
            if (TextUtils.isEmpty(str1 = paramConsoleMessage.message())) {
                return super.onConsoleMessage(paramConsoleMessage);
            }

            String str2 = null;
            if (str1.startsWith("h5container.message: ")) {
                str2 = str1.replaceFirst("h5container.message: ", "");
            }

            if (TextUtils.isEmpty(str2)) {
                return super.onConsoleMessage(paramConsoleMessage);
            }
            AuthActivity.b(AuthActivity.this, str2);
            return super.onConsoleMessage(paramConsoleMessage);
        }

    }

    private class MyWebViewClient extends WebViewClient
    {
        private MyWebViewClient() {

        }

        public void onReceivedSslError(WebView paramWebView, final SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
            if (AuthActivity.e(AuthActivity.this)) {
                paramSslErrorHandler.proceed();
                AuthActivity.a(AuthActivity.this, false);
                return;
            }

            AuthActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    SystemDefaultDialog.a(AuthActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            AuthActivity.a(AuthActivity.this, true);
                            AuthActivity.MyWebViewClient.1.this.a.proceed();
                            paramAnonymous2DialogInterface.dismiss();
                        }
                    }, "退出", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            AuthActivity.MyWebViewClient.1.this.a.cancel();
                            AuthActivity.a(AuthActivity.this, false);
                            Result.a(Result.b());
                            AuthActivity.this.finish();
                        }
                    });
                }
            });
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            if (AuthActivity.a(AuthActivity.this, paramString)) {
                paramWebView.stopLoading();
                return true;
            }
            return super.shouldOverrideUrlLoading(paramWebView, paramString);
        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            AuthActivity.f(AuthActivity.this);
            AuthActivity.h(AuthActivity.this).postDelayed(AuthActivity.g(AuthActivity.this), 30000L);
            super.onPageStarted(paramWebView, paramString, paramBitmap);
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            AuthActivity.i(AuthActivity.this);
            AuthActivity.h(AuthActivity.this).removeCallbacks(AuthActivity.g(AuthActivity.this));
        }

    }

}
