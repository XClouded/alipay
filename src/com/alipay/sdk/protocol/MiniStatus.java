package com.alipay.sdk.protocol;

public enum MiniStatus
{
    private String e;

    private MiniStatus(String arg3) {
        Object localObject;
        this.e = localObject;
    }

    private String a() {
        return this.e;
    }

    public static MiniStatus a(String paramString) {
        Object localObject = null;
        for (MiniStatus localMiniStatus : values()) {
            if (paramString.startsWith(localMiniStatus.e)) {
                localObject = localMiniStatus;
            }
        }
        return localObject;
    }
}
