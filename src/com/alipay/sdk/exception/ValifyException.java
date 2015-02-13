package com.alipay.sdk.exception;

import android.text.TextUtils;
import android.util.Log;

public final class ValifyException extends Exception
{
    private static final long serialVersionUID = 7405333891987087563L;

    public ValifyException() {
        this(null, null);
    }

    public ValifyException(String paramString) {
        this(paramString, null);
    }

    public ValifyException(Throwable paramThrowable) {
        this(null, paramThrowable);
    }

    public ValifyException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
        printException(paramString, paramThrowable);
    }

    public static void printException(String paramString, Throwable paramThrowable) {
     if (!TextUtils.isEmpty(paramString))
       Log.e("Validation", "Validation--" + paramString);
        try {
            if (paramThrowable != null) {
                Log.e("Validation", "Validation--" + paramThrowable.getMessage());
                paramThrowable.printStackTrace();
            }
            return;
        } catch (Exception localException) {

        }
    }
}
