package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;

public class AuthHelper
{
    private static final String a = "com.eg.android.AlipayGphone";
    private static final int b = 65;

    private static boolean a(Context paramContext) {
        try {
            if ((paramContext = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128)) == null) {
                return false;
            }
            if (paramContext.versionCode < 65)
                return false;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            return false;
        }
        return true;
    }

    public static void a(Activity paramActivity, APAuthInfo paramAPAuthInfo) {
        StringBuilder localStringBuilder;
        if (a(paramActivity)) {
            (localStringBuilder = new StringBuilder()).append("alipayauth://platformapi/startapp");
            localStringBuilder.append("?appId=20000122");
            localStringBuilder.append("&approveType=005");
            localStringBuilder.append("&scope=kuaijie");
            localStringBuilder.append("&productId=");
            localStringBuilder.append(paramAPAuthInfo.getProductId());
            localStringBuilder.append("&thirdpartyId=");
            localStringBuilder.append(paramAPAuthInfo.getAppId());
            localStringBuilder.append("&redirectUri=");
            localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
            a(paramActivity, localStringBuilder.toString());
            return;
        }
        (localStringBuilder = new StringBuilder()).append("app_id=");
        localStringBuilder.append(paramAPAuthInfo.getAppId());
        localStringBuilder.append("&partner=");
        localStringBuilder.append(paramAPAuthInfo.getPid());
        localStringBuilder.append("&scope=kuaijie");
        localStringBuilder.append("&login_goal=auth");
        localStringBuilder.append("&redirect_url=");
        localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
        localStringBuilder.append("&view=wap");
        localStringBuilder.append("&prod_code=");
        localStringBuilder.append(paramAPAuthInfo.getProductId());
        Intent localIntent;
        (localIntent = new Intent(paramActivity, AuthActivity.class)).putExtra("params", localStringBuilder.toString());
        localIntent.putExtra("redirectUri", paramAPAuthInfo.getRedirectUri()); paramActivity.startActivity(localIntent);
    }

    private static void b(Activity paramActivity, APAuthInfo paramAPAuthInfo) {
        StringBuilder localStringBuilder;
        (localStringBuilder = new StringBuilder()).append("alipayauth://platformapi/startapp");
        localStringBuilder.append("?appId=20000122");
        localStringBuilder.append("&approveType=005");
        localStringBuilder.append("&scope=kuaijie");
        localStringBuilder.append("&productId=");
        localStringBuilder.append(paramAPAuthInfo.getProductId());
        localStringBuilder.append("&thirdpartyId=");
        localStringBuilder.append(paramAPAuthInfo.getAppId());
        localStringBuilder.append("&redirectUri=");
        localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
        a(paramActivity, localStringBuilder.toString());
    }

    private static void c(Activity paramActivity, APAuthInfo paramAPAuthInfo) {
        StringBuilder localStringBuilder;
        (localStringBuilder = new StringBuilder()).append("app_id=");
        localStringBuilder.append(paramAPAuthInfo.getAppId());
        localStringBuilder.append("&partner=");
        localStringBuilder.append(paramAPAuthInfo.getPid());
        localStringBuilder.append("&scope=kuaijie");
        localStringBuilder.append("&login_goal=auth");
        localStringBuilder.append("&redirect_url=");
        localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
        localStringBuilder.append("&view=wap");

        localStringBuilder.append("&prod_code=");
        localStringBuilder.append(paramAPAuthInfo.getProductId());
        Intent localIntent;
        (localIntent = new Intent(paramActivity, AuthActivity.class)).putExtra("params", localStringBuilder.toString());
        localIntent.putExtra("redirectUri", paramAPAuthInfo.getRedirectUri());
        paramActivity.startActivity(localIntent);
    }

    public static void a(Activity paramActivity, String paramString) {
        try {
            Intent localIntent = new Intent("android.intent.action.VIEW");
            paramString = Uri.parse(paramString);
            localIntent.setData(paramString);
            paramActivity.startActivity(localIntent);
            return;
        } catch (ActivityNotFoundException localActivityNotFoundException) {

        }
    }

}

