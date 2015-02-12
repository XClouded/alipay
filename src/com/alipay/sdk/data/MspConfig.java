package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.sys.UserLocation;
import com.alipay.sdk.tid.TidInfo;
import com.alipay.sdk.util.DeviceInfo;
import com.alipay.sdk.util.NetConnectionType;
import com.alipay.sdk.util.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MspConfig
{
    private static final String a = "virtualImeiAndImsi";
    private static final String b = "virtual_imei";
    private static final String c = "virtual_imsi";
    private static MspConfig d;
    private String e;
    private String f;
    private String g;

    private String b() {
        return this.g;
    }

    private MspConfig() {
        this.f = "sdk-and-lite";
    }

    public static synchronized MspConfig a() {
        if (d == null) {
            d = new MspConfig();
        }
        return d;
    }

    public final synchronized void a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }

        PreferenceManager.getDefaultSharedPreferences(GlobalContext.a().b()).edit().putString("trideskey", paramString).commit();
        com.alipay.sdk.cons.GlobalConstants.d = paramString;
    }

    private static String c() {
        return "1";
    }

    private static String a(Context paramContext) {
        return Float.toString(new TextView(paramContext).getTextSize());
    }

    public final String a(TidInfo paramTidInfo) {
        Context localContext;
        Object localObject1 = DeviceInfo.a(localContext = GlobalContext.a().b());

        if (TextUtils.isEmpty(this.e)) {
            str1 = "Msp/9.1.8";
            str2 = Utils.a();
            str3 = Utils.b();
            str4 = Utils.d(localContext);
            str5 = Utils.c();

            localObject2 = Utils.e(localContext);
            localObject5 = localContext; localObject3 = Float.toString(new TextView((Context)localObject5).getTextSize());
            localObject4 = new StringBuilder();
            this.e = (str1 + " (" + str2 + ";" + str3 + ";" + str4 + ";" + str5 + ";" + (String)localObject2 + ";" + (String)localObject3);
        }

        String str1 = DeviceInfo.b(localContext).a();
        String str2 = Utils.f(localContext);
        String str3 = "1";
        String str4 = ((DeviceInfo)localObject1).a();
        String str5 = ((DeviceInfo)localObject1).b();

        Object localObject6;
        if (TextUtils.isEmpty(localObject6 = (localObject5 = (localObject3 = GlobalContext.a().b()).getSharedPreferences("virtualImeiAndImsi", 0)).getString("virtual_imsi", null))) {
            if (TextUtils.isEmpty(TidInfo.c().a())) {
                if (TextUtils.isEmpty(localObject2 = GlobalContext.a().g()))
                    localObject6 = f();
                else
                    localObject6 = ((String)localObject2).substring(3, 18);
            } else {
                localObject6 = DeviceInfo.a((Context)localObject3).a();
            }
            ((SharedPreferences)localObject5).edit().putString("virtual_imsi", (String)localObject6).commit();
        }
        Object localObject2 = localObject6;

        if (TextUtils.isEmpty(localObject6 = (localObject5 = (localObject3 = GlobalContext.a().b()).getSharedPreferences("virtualImeiAndImsi", 0)).getString("virtual_imei", null))) {
            if (TextUtils.isEmpty(TidInfo.c().a()))
                localObject6 = f();
            else
                localObject6 = DeviceInfo.a((Context)localObject3).b();
            ((SharedPreferences)localObject5).edit().putString("virtual_imei", (String)localObject6).commit();
        }
        Object localObject3 = localObject6;

        if (paramTidInfo != null) {
            this.g = paramTidInfo.b();
        }

        Object localObject4 = Build.MANUFACTURER.replace(";", " ");
        String str6 = Build.MODEL.replace(";", " ");
        boolean bool = GlobalContext.e();
        localObject1 = ((DeviceInfo)localObject1).c();

        String str7 = (localObject6 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo()) != null ? ((WifiInfo)localObject6).getSSID() : "-1";
        Object localObject5 = (localObject6 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo()) != null ? ((WifiInfo)localObject6).getBSSID() : "00";

        (localObject6 = new StringBuilder()).append(this.e).append(";").append(str1).append(";").append(str2).append(";").append(str3).append(";").append(str4).append(";").append(str5).append(";").append(this.g).append(";").append((String)localObject4).append(";").append(str6).append(";").append(bool).append(";").append((String)localObject1).append(";").append(UserLocation.a()).append(";").append(this.f).append(";").append((String)localObject2).append(";").append((String)localObject3).append(";").append(str7).append(";").append((String)localObject5);

        if (paramTidInfo != null) {
            (localObject1 = new HashMap()).put("tid", paramTidInfo.a());
            ((HashMap)localObject1).put("utdid", GlobalContext.a().g());
            if (!TextUtils.isEmpty(paramTidInfo = SecurityClientMobile.GetApdid(localContext, (Map)localObject1))) {
                ((StringBuilder)localObject6).append(";").append(paramTidInfo);
            }
        }
        ((StringBuilder)localObject6).append(")");

        return ((StringBuilder)localObject6).toString();
    }

    private static String d() {
        Context localContext;
        SharedPreferences localSharedPreferences;
        String str;
        if (TextUtils.isEmpty(str = (localSharedPreferences = (localContext = GlobalContext.a().b()).getSharedPreferences("virtualImeiAndImsi", 0)).getString("virtual_imei", null))) {
            if (TextUtils.isEmpty(TidInfo.c().a())) {
                str = f();
            } else {
                str = DeviceInfo.a(localContext).b();
            }
            localSharedPreferences.edit().putString("virtual_imei", str).commit();
        }

        return str;
    }

    private static String e() {
        Object localObject;
        SharedPreferences localSharedPreferences;
        String str;
        if (TextUtils.isEmpty(str = (localSharedPreferences = (localObject = GlobalContext.a().b()).getSharedPreferences("virtualImeiAndImsi", 0)).getString("virtual_imsi", null))) {
            if (TextUtils.isEmpty(TidInfo.c().a())) {
                if (TextUtils.isEmpty(localObject = GlobalContext.a().g())) {
                    str = f();
                } else {
                    str = ((String)localObject).substring(3, 18);
                }
            } else {
                str = DeviceInfo.a((Context)localObject).a();
            }
            localSharedPreferences.edit().putString("virtual_imsi", str).commit();
        }

        return str;
    }

    private static String f() {
        String str = Long.toHexString(System.currentTimeMillis());
        Random localRandom = new Random();
        return str + (1000 + localRandom.nextInt(9000));
    }

    private static String b(Context paramContext) {
        if ((paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo()) != null) {
            return paramContext.getSSID();
        }
        return "-1";
    }

    private static String c(Context paramContext) {
        if ((paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo()) != null) {
            return paramContext.getBSSID();
        }
        return "00";
    }

    private static String a(Context paramContext, HashMap paramHashMap) {
        return SecurityClientMobile.GetApdid(paramContext, paramHashMap);
    }

}
