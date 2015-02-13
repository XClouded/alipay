package com.alipay.sdk.widget;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.KeyEvent;

public class SystemDefaultDialog
{
    private static boolean a = Build.VERSION.SDK_INT >= 11;

    public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2) {
        paramContext = new AlertDialog.Builder(paramContext);
        if (a) {
            if ((!TextUtils.isEmpty(paramString4)) && (paramOnClickListener2 != null))
                paramContext.setPositiveButton(paramString4, paramOnClickListener2);
            if ((!TextUtils.isEmpty(paramString3)) && (paramOnClickListener1 != null))
                paramContext.setNegativeButton(paramString3, paramOnClickListener1);
        } else {
            if ((!TextUtils.isEmpty(paramString3)) && (paramOnClickListener1 != null))
                paramContext.setPositiveButton(paramString3, paramOnClickListener1);
            if ((!TextUtils.isEmpty(paramString4)) && (paramOnClickListener2 != null))
                paramContext.setNegativeButton(paramString4, paramOnClickListener2);
        }

        paramContext = paramContext;
        paramContext.setTitle(paramString1);
        paramContext.setMessage(paramString2);
        (paramContext = paramContext.create()).setCanceledOnTouchOutside(false);
        paramContext.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
                if (paramAnonymousInt == 4) {
                    return true;
                }
                return false;
            }
        });
        paramContext.show();
        return paramContext;
    }

    private static AlertDialog.Builder a(Context paramContext, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, String paramString2, DialogInterface.OnClickListener paramOnClickListener2) {
        paramContext = new AlertDialog.Builder(paramContext);

        if (a) {
            if ((!TextUtils.isEmpty(paramString2)) && (paramOnClickListener2 != null)) {
                paramContext.setPositiveButton(paramString2, paramOnClickListener2);
            }

            if ((!TextUtils.isEmpty(paramString1)) && (paramOnClickListener1 != null)) {
                paramContext.setNegativeButton(paramString1, paramOnClickListener1);
            }
        } else {
            if ((!TextUtils.isEmpty(paramString1)) && (paramOnClickListener1 != null)) {
                paramContext.setPositiveButton(paramString1, paramOnClickListener1);
            }

            if ((!TextUtils.isEmpty(paramString2)) && (paramOnClickListener2 != null)) {
                paramContext.setNegativeButton(paramString2, paramOnClickListener2);
            }
        }
        return paramContext;
    }

}
