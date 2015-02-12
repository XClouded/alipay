package com.alipay.sdk.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IAlixPay.Stub;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.android.app.IRemoteServiceCallback.Stub;
import com.alipay.sdk.app.Result;

public class PayHelper
{
    private Activity b;
    private IAlixPay c;
    private Object d = IAlixPay.class;

    private boolean e = false;
    public static final String a = "failed";
    private ServiceConnection f = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {
        PayHelper.a(PayHelper.this, null);
        }

        public void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder) {
            synchronized (PayHelper.a(PayHelper.this)) {
                PayHelper.a(PayHelper.this, IAlixPay.Stub.asInterface(paramAnonymousIBinder));
                PayHelper.a(PayHelper.this).notify();
                return;
            }
        }
    };

    private IRemoteServiceCallback g = new IRemoteServiceCallback.Stub() {
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        public void payEnd(boolean paramAnonymousBoolean, String paramAnonymousString) throws RemoteException {

        }

        public void startActivity(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, Bundle paramAnonymousBundle) throws RemoteException {
            Intent localIntent = new Intent("android.intent.action.MAIN", null);
            if (paramAnonymousBundle == null)
                paramAnonymousBundle = new Bundle();
            try {
                paramAnonymousBundle.putInt("CallingPid", paramAnonymousInt);
                localIntent.putExtras(paramAnonymousBundle);
            } catch (Exception localException) {
                localException.printStackTrace();
            }

            localIntent.setClassName(paramAnonymousString1, paramAnonymousString2);
            PayHelper.b(PayHelper.this).startActivity(localIntent);
        }
    };

    public PayHelper(Activity paramActivity) {
        this.b = paramActivity;
    }

    public final String a(String paramString) {
            Object localObject;
            if (((localObject = Utils.a(Utils.a(this.b, "com.eg.android.AlipayGphone"))) != null) && (!TextUtils.equals((CharSequence)localObject, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649"))) {
                return Result.c();
            }

            (localObject = new Intent()).setClassName("com.eg.android.AlipayGphone", "com.alipay.android.app.MspService");
            ((Intent)localObject).setAction("com.eg.android.AlipayGphone.IAlixPay");
            return a(paramString, (Intent)localObject);
    }

    private String a(String paramString, Intent arg2) {
        String str = null;

        if (this.e) {
        return "";
        }
        this.e = true;

        if (this.c == null) {
            this.b.getApplicationContext().bindService(???, this.f, 1);
        }

        try {
            synchronized (this.d) {
                if (this.c == null) {
                    this.d.wait(3000L);
                }
            }
            if (this.c == null) {
                return "failed";
            }
            this.c.registerCallback(this.g);
            str = this.c.Pay(paramString);

            this.c.unregisterCallback(this.g);

            this.c = null;
        } catch (Exception localException3) {
        } finally {
            try {
                this.b.unbindService(this.f);
            } catch (Exception localException5) {
                this.c = null;
            }
            this.e = false;
        }
        return str;
    }
}
