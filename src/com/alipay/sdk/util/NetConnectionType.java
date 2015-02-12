package com.alipay.sdk.util;

public enum NetConnectionType
{
    private int p;
    private String q;

    private NetConnectionType(int arg3, String arg4) {
        int i1;
        this.p = i1;
        Object localObject;
        this.q = localObject;
    }

    private int b() {
        return this.p;
    }

    public final String a() {
        return this.q;
    }

    private void a(String paramString) {
        this.q = paramString;
    }

    public static NetConnectionType a(int paramInt) {
        NetConnectionType[] arrayOfNetConnectionType;
        int i1 = (arrayOfNetConnectionType = values()).length;
        for (int i2 = 0; i2 < i1; i2++) {
            NetConnectionType localNetConnectionType;
            if ((localNetConnectionType = arrayOfNetConnectionType[i2]).p == paramInt) {
                return localNetConnectionType;
            }
        }
        return o;
    }

}
