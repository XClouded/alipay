package com.alipay.sdk.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.cons.GlobalConstants;
import com.alipay.sdk.data.FrameUtils;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.data.MspConfig;
import com.alipay.sdk.data.Request;
import com.alipay.sdk.exception.AppErrorException;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.exception.UnZipException;
import com.alipay.sdk.net.RequestWrapper;
import com.alipay.sdk.protocol.ActionType;
import com.alipay.sdk.protocol.ElementAction;
import com.alipay.sdk.protocol.FrameData;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.util.ActionUtil;
import com.alipay.sdk.util.FileDownloader;
import com.alipay.sdk.util.FileDownloader.IDownloadProgress;
import com.alipay.sdk.util.PayHelper;
import com.alipay.sdk.util.Utils;
import com.alipay.sdk.widget.Loading;
import com.alipay.sdk.widget.SystemDefaultDialog;
import java.io.File;
import org.json.JSONObject;

public class PayTask
{
    private Activity b;
    private String c;
    private Dialog d;
    private FileDownloader e;
    static final Object a = PayHelper.class;
    private Handler f;
    private String g;
    private boolean h;
    private String i;
    private Runnable j = new Runnable() {
        public void run() {
            if (PayTask.b(PayTask.this) != null) {
                PayTask.b(PayTask.this).c();
            }
            SystemDefaultDialog.a(PayTask.a(PayTask.this), "提示", "下载安装包失败，是否重试？", "重试",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        PayTask.g(PayTask.this);
                    }
                },
                "取消",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg1, int paramAnonymous2Int) {
                        synchronized (PayTask.a) {
                            Result.a(Result.b());
                            try {
                                PayTask.a.notify();
                            } catch (Exception localException) {

                            }
                            return;
                        }
                    }
                }
            );
        }
    };

    private BroadcastReceiver k = new BroadcastReceiver() {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
            if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_ADDED")) {
                paramAnonymousContext = new Runnable() {
                    public void run() {
                    if (PayTask.h(PayTask.this) != null)
                        PayTask.h(PayTask.this).dismiss();
                        PayTask.a(PayTask.this, true);
                        PayTask.a(PayTask.this).unregisterReceiver(PayTask.c(PayTask.this));
                    }
                };
                PayTask.e(PayTask.this).post(paramAnonymousContext);
            }
        }
    };

    public PayTask(Activity paramActivity) {
        this.b = paramActivity;
    }

    public synchronized String pay(String paramString) {
        this.c = paramString;
        GlobalContext.a().a(this.b, MspConfig.a());
        if (this.c.contains("service=alipay.acquire.mr.ord.createandpay")) {
            GlobalConstants.n = true;
        }
        if (paramString.contains("paymethod=\"expressGateway\"")) {
            return b();
        }
        if (Utils.b(this.b))
        {
            if (TextUtils.equals(paramString = a(), "failed")) {
                return b();
            }
            if (TextUtils.isEmpty(paramString)) {
                return Result.b();
            }
            return paramString;
        }
        return b();
    }

    public String getVersion() {
        return "9.1.8";
    }

    public boolean checkAccountIfExist() {
        Request localRequest = FrameUtils.a();
        try {
            return new RequestWrapper().a(this.b, localRequest, true).c().optBoolean("hasAccount", false);
        } catch (Exception localException) {

        }
        return false;
    }

    private String a() {
        if (GlobalConstants.n) {
            if (this.c.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
            } else if (this.c.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
            } else if (this.c.startsWith("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?") + 59);
            } else if (this.c.startsWith("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?") + 65);
            }
        }
        PayHelper localPayHelper = new PayHelper(this.b);
        if (this.c.contains("bizcontext=")) {
            return localPayHelper.a(this.c);
        }
        if (this.c.contains("\"")) {
        return localPayHelper.a(this.c + "&bizcontext=\"{\"appkey\":\"2014052600006128\"}\"");
        }
        return localPayHelper.a(this.c + "&bizcontext={\"appkey\":\"2014052600006128\"}");
    }

    private String b() {
        Loading localLoading = null;
        try {
            if ((this.b != null) && (!this.b.isFinishing()))
                (localLoading = new Loading(this.b)).b();
        } catch (Exception localException) {
            localLoading = null;
        }
        if (GlobalConstants.n) {
            if (this.c.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
            } else if (this.c.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
            } else if (this.c.startsWith("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?") + 59);
                GlobalConstants.b = "https://mobiletestabc.alipaydev.com/mobileclientgw/stable/gateway.do";
            } else if (this.c.startsWith("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?")) {
                this.c = this.c.substring(this.c.indexOf("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?") + 65);
                GlobalConstants.b = "https://mobiletestabc.alipaydev.com/mobileclientgw/stable/gateway.do";
            }
        }
        Object localObject1 = FrameUtils.a(new InteractionData(), this.c, new JSONObject());
        Object localObject3 = new RequestWrapper(new InteractionData());
        ResultStatus localResultStatus = null;
        try {
            int m = (localObject3 = localObject1 = ActionType.a(ElementAction.a(((RequestWrapper)localObject3).a(this.b, (Request)localObject1, false).c().optJSONObject("form"), "onload"))).length;
            ActionType localActionType;
            for (int n = 0; n < m; n++) {
                if ((localActionType = localObject3[n]) == ActionType.f) {
                    ActionUtil.b(localActionType.e());
                }
            }
            if (localLoading != null) {
                localLoading.c();
            }
            m = (localObject3 = localObject1).length;
            for (n = 0; n < m; n++) {
                if ((localActionType = localObject3[n]) == ActionType.a) {
                    return a(localActionType);
                }
                if (localActionType == ActionType.d) {
                    this.f = new Handler(this.b.getMainLooper());
                    this.i = (this.b.getCacheDir().getAbsolutePath() + "/temp.apk");
                    return b(localActionType);
                }
            }
        } catch (NetErrorException localNetErrorException) {
            localResultStatus = ResultStatus.a(ResultStatus.d.a());
        } catch (FailOperatingException localFailOperatingException) {
        } catch (AppErrorException localAppErrorException) {
        } catch (UnZipException localUnZipException) {
        } finally {
            if (localLoading != null) {
                localLoading.c();
            }
        }
        if (localResultStatus == null) {
            localResultStatus = ResultStatus.a(ResultStatus.b.a());
        }
        return Result.a(localResultStatus.a(), localResultStatus.b(), "");
    }

    private String a(ActionType arg1) {
        ??? = ActionUtil.a(???.e());
        Intent localIntent = new Intent(this.b, H5PayActivity.class);
        Bundle localBundle = new Bundle();
        String str = ???[0];
        localBundle.putString("url", str);
        if (???.length == 2) {
            ??? = ???[1];
            localBundle.putString("cookie", ???);
        }
        localIntent.putExtras(localBundle);
        this.b.startActivity(localIntent);
        synchronized(a) {
            try {
                a.wait();
            } catch (InterruptedException localInterruptedException) {
            }
        }
        if (TextUtils.isEmpty( = Result.a())) {
            ??? = Result.b();
        }
        return ???;
    }

    private String b(ActionType arg1) {
        Object localObject1 = ActionUtil.a(???.e());
        final ActionType[] arrayOfActionType1 = null;
        final ActionType[] arrayOfActionType2 = null;
        if ((localObject1.length > 4) && (!TextUtils.isEmpty(localObject1[4]))) {
            arrayOfActionType1 = ActionType.a(ElementAction.a(localObject1[4], ???));
        }
        if ((localObject1.length > 5) && (!TextUtils.isEmpty(localObject1[5]))) {
            arrayOfActionType2 = ActionType.a(ElementAction.a(localObject1[5], ???));
        }
        final ActionType[] arrayOfActionType4 = arrayOfActionType2;
        final String str = localObject1[3];
        final ActionType[] arrayOfActionType3 = arrayOfActionType1;
        arrayOfActionType2 = localObject1[2];
        arrayOfActionType1 = localObject1[1];
        localObject1 = localObject1[0];
        ??? = this;
        this.b.runOnUiThread(new Runnable() {
            public void run() {
                DialogInterface.OnClickListener local1 = null;
                DialogInterface.OnClickListener local2 = null;
                if (arrayOfActionType3 != null) {
                    local1 = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            PayTask.a(PayTask.this, PayTask.1.this.a);
                        }
                    };
                }
                if (arrayOfActionType4 != null) {
                    local2 = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            PayTask.a(PayTask.this, PayTask.1.this.b);
                        }
                    };
                }
                SystemDefaultDialog.a(PayTask.a(PayTask.this), this.c, arrayOfActionType1, arrayOfActionType2, local1, str, local2);
            }
        });
        synchronized(a) {
            try {
                a.wait();
            } catch (InterruptedException localInterruptedException) {
                localInterruptedException.printStackTrace();
            }
        }
        if (this.h) {
            return a();
        }
        if (TextUtils.isEmpty( = Result.a())) {
            ??? = Result.b();
        }
        return ???;
    }

    private void a(String paramString1, String paramString2, String paramString3, ActionType[] paramArrayOfActionType1, String paramString4, ActionType[] paramArrayOfActionType2) {
        this.b.runOnUiThread(new Runnable() {
            public void run() {
                DialogInterface.OnClickListener local1 = null;
                DialogInterface.OnClickListener local2 = null;
                if (arrayOfActionType3 != null) {
                    local1 = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            PayTask.a(PayTask.this, PayTask.1.this.a);
                        }
                    };
                }
                if (arrayOfActionType4 != null) {
                    local2 = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            PayTask.a(PayTask.this, PayTask.1.this.b);
                        }
                    };
                }
                SystemDefaultDialog.a(PayTask.a(PayTask.this), this.c, arrayOfActionType1, arrayOfActionType2, local1, str, local2);
            }
        });
    }

    private void a(ActionType[] paramArrayOfActionType) {
        int m = (paramArrayOfActionType = paramArrayOfActionType).length;
        for (int n = 0; n < m; n++) {
            ActionType localActionType;
            if ( (localActionType = paramArrayOfActionType[n]) == ActionType.b) {
                String[] arrayOfString = ActionUtil.a(localActionType.e());
                this.g = arrayOfString[0];
                c();
            }
            if (localActionType == ActionType.g) {
                synchronized (a) {
                    Result.a(Result.b());
                    try {
                        a.notify();
                    } catch (Exception localException) {
                    }
                }
            }
        }
    }

    private void c() {
        Object localObject;
        (localObject = new Loading(this.b)).a("正在下载中", true, new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface arg1) {
                this.a.c();
                PayTask.b(PayTask.this).c();
                PayTask.a(PayTask.this).unregisterReceiver(PayTask.c(PayTask.this));
                PayTask.e(PayTask.this).removeCallbacks(PayTask.d(PayTask.this));
                synchronized (PayTask.a) {
                    Result.a(Result.b());
                    try {
                        PayTask.a.notify();
                    } catch (Exception localException) {
                    }
                    return;
                }
            }
        });
        this.e = new FileDownloader();
        this.e.a(this.g);
        this.e.b(this.i);
        this.e.a(new FileDownloader.IDownloadProgress() {
            public final void a() {
                this.a.c();
                PayTask.e(PayTask.this).removeCallbacks(PayTask.d(PayTask.this));
                PayTask.f(PayTask.this);
            }
            public final void b(){
            }
            public final void c() {
                this.a.c();
                PayTask.e(PayTask.this).post(PayTask.d(PayTask.this));
            }
        });
        this.e.b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.b.registerReceiver(this.k, intentFilter);
        this.f.postDelayed(this.j, 180000L);
    }

    private void d() {
        Runnable local6 = new Runnable() {
            public void run() {
                if (Utils.b(PayTask.a(PayTask.this), PayTask.i(PayTask.this))) {
                    Utils.a(PayTask.a(PayTask.this), PayTask.i(PayTask.this));
                    PayTask.a(PayTask.this, SystemDefaultDialog.a(PayTask.a(PayTask.this), "提示", "是否取消安装？", "重新安装",
                                 new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                        PayTask.f(PayTask.this);
                                    }
                                }
                    , "取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg1, int paramAnonymous2Int) {
                                PayTask.a(PayTask.this).unregisterReceiver(PayTask.c(PayTask.this));
                                PayTask.a(PayTask.this, false);
                                Result.a(Result.b());
                                synchronized (PayTask.a) {
                                    try {
                                        PayTask.a.notify();
                                    } catch (Exception localException) {
                                    }
                                    return;
                                }
                            }
                    }));
                    return;
                }
                synchronized (PayTask.a) {
                    Result.a(Result.c());
                    try {
                        PayTask.a.notify();
                    } catch (Exception localException) {
                    }
                    return;
                }
            }
        };
        this.f.post(local6);
    }
}
