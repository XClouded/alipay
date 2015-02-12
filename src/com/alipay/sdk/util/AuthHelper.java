package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.H5AuthActivity;
import com.alipay.sdk.app.Result;

public class AuthHelper
{
    private static final String b = "com.eg.android.AlipayGphone";
    private static final int c = 73;
    public static final Object a = AuthTask.class;

    public static String a(Activity paramActivity, String paramString) {
        if (a(paramActivity)) {
            Object localObject = new PayHelper(paramActivity);
            String str;
            if (paramString.contains("\""))
                str = str + "&bizcontext=\"{\"appkey\":\"2014052600006128\"}\"";
            else {
                str = str + "&bizcontext={\"appkey\":\"2014052600006128\"}";
            }

            if (TextUtils.isEmpty(localObject = ((PayHelper)localObject).a(str))) {
                return b(paramActivity, paramString);
            }
            return localObject;
        }
        return b(paramActivity, paramString);
    }

    private static String b(Activity arg0, String paramString) {
        Intent localIntent  = new Intent(???, H5AuthActivity.class)).putExtra("params", paramString);
        ???.startActivity(localIntent);

        synchronized (a) {
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

    private static boolean a(Context paramContext) {
        try {
            if ((paramContext = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128)) == null) {
                return false;
            }
            if (paramContext.versionCode < 73)
                return false;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            return false;
        }
        return true;
    }

}
