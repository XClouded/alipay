package com.alipay.sdk.tid;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.util.DeviceInfo;

public class TidInfo
{
    private static TidInfo a;
    private String b;
    private String c;

    public final String a() {
        return this.b;
    }

    public final void a(String paramString) {
        this.b = paramString;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String paramString) {
        this.c = paramString;
    }

    public final void a(Context paramContext) {
        TidDbHelper localTidDbHelper = new TidDbHelper(paramContext);
        try {
            String str = DeviceInfo.a(paramContext).a();
            paramContext = DeviceInfo.a(paramContext).b();
            localTidDbHelper.a(str, paramContext, this.b, this.c);
            return;
        } catch (Exception localException) {
            return;
        } finally {
            localTidDbHelper.close();
        } throw paramContext;
    }

    private boolean e() {
        return TextUtils.isEmpty(this.b);
    }

    public static synchronized TidInfo c() {
        if (a == null) {
            a = new TidInfo();
            Object localObject = GlobalContext.a().b();
            TidDbHelper localTidDbHelper = new TidDbHelper((Context)localObject);

            String str1 = DeviceInfo.a((Context)localObject).a();
            localObject = DeviceInfo.a((Context)localObject).b();
            a.b = localTidDbHelper.b(str1, (String)localObject);
            a.c = localTidDbHelper.c(str1, (String)localObject);
            if (TextUtils.isEmpty(a.c)) {
                String str2;
                if ((str2 = Long.toHexString(System.currentTimeMillis())).length() > 10)
                    str2 = str2.substring(str2.length() - 10);
                a.c = str2;
            }
            localTidDbHelper.a(str1, (String)localObject, a.b, a.c);
        }
        return a;
    }

    public static void d() {
        Object localObject;
        String str1 = DeviceInfo.a(localObject = GlobalContext.a().b()).a();
        String str2 = DeviceInfo.a((Context)localObject).b();

        (localObject = new TidDbHelper((Context)localObject)).a(str1, str2);
        ((TidDbHelper)localObject).close();
    }

    private static String f() {
        String str;
        if ((str = Long.toHexString(System.currentTimeMillis())).length() > 10) {
            str = str.substring(str.length() - 10);
        }
        return str;
    }

}
