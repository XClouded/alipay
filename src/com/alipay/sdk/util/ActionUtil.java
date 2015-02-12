package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.tid.TidInfo;

public class ActionUtil
{

    public static String[] a(String paramString) {
        int i = paramString.indexOf('(') + 1;
        int j = paramString.lastIndexOf(')');
        if ((i == 0) || (j == -1)) {
            return null;
        }

        if ((paramString = paramString.substring(i, j).split(",")) != null) {
            for (i = 0; i < paramString.length; i++) {
                if (!TextUtils.isEmpty(paramString[i])) {
                    paramString[i] = paramString[i].trim();
                    paramString[i] = paramString[i].replaceAll("'", "").replaceAll("\"", "");
                }
            }
        }

        return paramString;
    }

    public static void b(String paramString) {
        if ((paramString = a(paramString)).length != 3) {
            return;
        }
        if (TextUtils.equals("tid", paramString[0])) {
            Context localContext = GlobalContext.a().b();
            TidInfo localTidInfo = TidInfo.c();
            if ((TextUtils.isEmpty(paramString[1])) || (TextUtils.isEmpty(paramString[2]))) {
                return;
            }
            localTidInfo.a(paramString[1]);
            localTidInfo.b(paramString[2]);
            localTidInfo.a(localContext);
        }
    }

}
