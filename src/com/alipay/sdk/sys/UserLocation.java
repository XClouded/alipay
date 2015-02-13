package com.alipay.sdk.sys;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public class UserLocation
{

    private static double a = -1.0D;
    private static double b = -1.0D;

    private static void a(Context paramContext) {
        try {
            if ((paramContext = (LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps")) {
                if ((paramContext = paramContext.getLastKnownLocation("gps")) != null) {
                    a = paramContext.getLatitude();
                    b = paramContext.getLongitude();
                }
            }

            return;
        } catch (Exception localException) {

        }
    }

    private static double b() {
        return a;
    }

    private static double c() {
        return b;
    }

    public static String a() {
        return b + ";" + a;
    }

}
