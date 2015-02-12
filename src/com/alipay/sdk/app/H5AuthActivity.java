package com.alipay.sdk.app;

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
import com.alipay.sdk.util.AuthHelper;
import com.alipay.sdk.util.Utils;
import com.alipay.sdk.widget.Loading;
import com.alipay.sdk.widget.SystemDefaultDialog;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class H5AuthActivity extends Activity
{
    private WebView a;
    private Loading b;
    private Handler c = new Handler();
    private boolean d;
    private Runnable e = new Runnable() {
        public void run() {
            H5AuthActivity.i(H5AuthActivity.this);
            H5AuthActivity.b(H5AuthActivity.this);
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
        this.a = new WebView(this);
        localLayoutParams.weight = 1.0F;
        this.a.setVisibility(0);
        paramBundle.addView(this.a, localLayoutParams);
        paramBundle = this.a.getSettings()
        paramBundle.setUserAgentString(paramBundle.getUserAgentString() + Utils.c(this));
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
        this.a.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
                paramAnonymousString1 = Uri.parse(paramAnonymousString1);
                paramAnonymousString1 = new Intent("android.intent.action.VIEW", paramAnonymousString1);
                H5AuthActivity.this.startActivity(paramAnonymousString1);
            }
        });
        new Thread(new Runnable() {
            public void run() {
                H5AuthActivity.a(H5AuthActivity.this);
            }
        }).start();
        if (Build.VERSION.SDK_INT >= 7) {
            try {
                paramBundle = this.a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE });
                if (paramBundle != null) {
                    paramBundle.invoke(this.a.getSettings(), new Object[] { Boolean.valueOf(true) });
                }
            } catch (Exception localException1) {
            }
        }
        try {
            paramBundle = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (paramBundle != null) {
                paramBundle.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
            }
            return;
        } catch (Exception localException2) {
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void finish() {
        synchronized (localObject1 = AuthHelper.a) {
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
        synchronized (localObject1 = AuthHelper.a) {
            try {
                Object localObject1;
                localObject1.notify();
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            return;
        }
    }

    private void b() {
        e();
        Object localObject1 = getIntent().getExtras().getString("params");
        (localObject1 = FrameUtils.a(new InteractionData(), (String)localObject1, new JSONObject())).d().c("com.alipay.mobilecashier");
        ((Request)localObject1).d().a("com.alipay.mcpay");
        ((Request)localObject1).d().e("4.0.3");
        ((Request)localObject1).d().d("/cashier/main");
        RequestWrapper localRequestWrapper = new RequestWrapper(new InteractionData());
        try {
            localObject1 = localRequestWrapper.a(this, (Request)localObject1, false).c();
            f();
            a((JSONObject)localObject1);
        } catch (NetErrorException localNetErrorException) {
            runOnUiThread(new Runnable() {
                public void run() {
                H5AuthActivity.b(H5AuthActivity.this);
                }
            });
        } catch (Exception localException) {
            runOnUiThread(new Runnable() {
                public void run() {
                    H5AuthActivity.c(H5AuthActivity.this);
                }
            });
        } finally {
            f();
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
                    finish();
                    return;
                }
                runOnUiThread(new Runnable() {
                    public void run() {
                        H5AuthActivity.d(H5AuthActivity.this).loadUrl(paramJSONObject);
                    }
                });
                return;
            }
        }
    }

    private void c() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setMessage("不能连接到服务器，是否重试？");
        localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                new Thread() {
                    public void run() {
                        H5AuthActivity.a(H5AuthActivity.this);
                    }
                }.start();
            }
        });
        localBuilder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                H5AuthActivity.this.finish();
            }
        });
        localBuilder.create().show();
    }

    private void d() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setMessage("系统繁忙，请稍后再试");
        localBuilder.setNeutralButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                H5AuthActivity.this.finish();
            }
        });
        localBuilder.create().show();
    }

    private void a(String paramString) {
        new JsBridge(this, new IJsCallback() {
            public final void a(CallInfo paramAnonymousCallInfo) {
                H5AuthActivity.a(H5AuthActivity.this, paramAnonymousCallInfo);
            }
        }).a(paramString);
    }

    private void a(final CallInfo paramCallInfo) {
        if ((this.a == null) || (paramCallInfo == null)) {
            return;
        } try {
            paramCallInfo = paramCallInfo.d();
            paramCallInfo = String.format("AlipayJSBridge._invokeJS(%s)", new Object[] { paramCallInfo });
            paramCallInfo = new Runnable() {
                public void run() {
                    try { H5AuthActivity.d(H5AuthActivity.this).loadUrl("javascript:" + paramCallInfo);
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                } } ;
            runOnUiThread(paramCallInfo);
            return;
        } catch (JSONException localJSONException) {
            localJSONException.printStackTrace();
        }
    }

    private void e() {
        if (this.b == null) {
            this.b = new Loading(this);
        }
        try {
            this.b.b();
            return;
        } catch (Exception localException) {
            this.b = null;
        }
    }

    private void f() {
        if ((this.b != null) && (this.b.a()))
            this.b.c();
            this.b = null;
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    private class MyWebChromeClient extends WebChromeClient
    {

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
        H5AuthActivity.a(H5AuthActivity.this, str2);
        return super.onConsoleMessage(paramConsoleMessage);
    }
}

    private class MyWebViewClient extends WebViewClient
    {

        private MyWebViewClient() {

        }

        public void onReceivedSslError(WebView paramWebView, final SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
            if (H5AuthActivity.e(H5AuthActivity.this)) {
                paramSslErrorHandler.proceed();
                H5AuthActivity.a(H5AuthActivity.this, false);
                return;
            }
            H5AuthActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    SystemDefaultDialog.a(H5AuthActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            H5AuthActivity.a(H5AuthActivity.this, true);
                            H5AuthActivity.MyWebViewClient.1.this.a.proceed();
                            paramAnonymous2DialogInterface.dismiss();
                        }
                }, "退出", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            H5AuthActivity.MyWebViewClient.1.this.a.cancel();
                            H5AuthActivity.a(H5AuthActivity.this, false);
                            Result.a(Result.b());
                            H5AuthActivity.this.finish();
                        }
                    });
                }
            });
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            if ((TextUtils.equals(paramString, "sdklite://h5quit")) || (TextUtils.equals(paramString, "http://m.alipay.com/?action=h5quit"))) {
                Result.a(Result.b());
                H5AuthActivity.this.finish();
                return true;
            }
            if (paramString.startsWith("sdklite://h5quit?result=")) {
                try {
                    String tmp55_52 = paramString.substring(paramString.indexOf("sdklite://h5quit?result=") + 24);
                    if (Integer.parseInt(tmp55_52.substring(tmp55_52.lastIndexOf("&end_code=") + 10)) == ResultStatus.a.a()) {
                        String tmp85_82 = URLDecoder.decode(paramString);
                        paramString = tmp85_82.substring((paramString = tmp85_82).indexOf("sdklite://h5quit?result=") + 24, paramString.lastIndexOf("&end_code="));
                        Result.a(Result.a((paramWebView = ResultStatus.a(paramWebView)).a(), paramWebView.b(), paramString));
                    } else {
                        Result.a(Result.a((paramString = ResultStatus.a(ResultStatus.b.a())).a(), paramString.b(), ""));
                    }
                } catch (Exception localException) {
                    Result.a(Result.c());
                }
                paramWebView = new Runnable() {
                    public void run() {
                        H5AuthActivity.this.finish();
                    }
                };
                H5AuthActivity.this.runOnUiThread(paramWebView);
                return true;
            }
            paramWebView.loadUrl(paramString);
            return true;
        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            H5AuthActivity.f(H5AuthActivity.this);
            H5AuthActivity.h(H5AuthActivity.this).postDelayed(H5AuthActivity.g(H5AuthActivity.this), 30000L);
            super.onPageStarted(paramWebView, paramString, paramBitmap);
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            H5AuthActivity.i(H5AuthActivity.this);
            H5AuthActivity.h(H5AuthActivity.this).removeCallbacks(H5AuthActivity.g(H5AuthActivity.this));
        }

    }
}
