package com.alipay.sdk.app;

import android.app.Activity;
import com.alipay.sdk.data.MspConfig;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.util.AuthHelper;

public class AuthTask
{
    private Activity a;

    public AuthTask(Activity paramActivity) {
        this.a = paramActivity;
    }

    public synchronized String auth(String paramString) {
        GlobalContext.a().a(this.a, MspConfig.a());
        return AuthHelper.a(this.a, paramString);
    }

}
