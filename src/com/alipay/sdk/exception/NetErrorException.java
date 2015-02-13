package com.alipay.sdk.exception;

import android.text.TextUtils;
import android.util.Log;

public final class NetErrorException extends Exception
{
    private static final long serialVersionUID = 8374198311711795611L;
    public static final int NET_CONNECTION_ERROR = 0;
    public static final int SERVER_ERROR = 1;
    public static final int SSL_ERROR = 2;
    private int errorCode;

    public NetErrorException() {
        this(null, null);
    }

    public NetErrorException(String paramString) {
        this(paramString, null);
    }

    public NetErrorException(Throwable paramThrowable) {
        this(null, paramThrowable);
    }

    public NetErrorException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
        this.errorCode = 0;
        printException(paramString, paramThrowable);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int paramInt) {
        this.errorCode = paramInt;
    }

    public static void printException(String paramString, Throwable paramThrowable) {
        if (!TextUtils.isEmpty(paramString))
            Log.w("NetError", "NetError--" + paramString);
        try {
            if (paramThrowable != null) {
                Log.w("NetError", "NetError--" + paramThrowable.getMessage());
            }

            return;
        } catch (Exception localException) {

        }
    }

}
