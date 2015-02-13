package com.alipay.sdk.protocol;

import com.alipay.sdk.exception.AppErrorException;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;

public class FrameFactoryManager
{
    public static FrameData a(FrameData paramFrameData) throws NetErrorException, FailOperatingException, AppErrorException {
        if (paramFrameData == null) {
            throw new AppErrorException(FrameFactoryManager.class, "frame data is null");
        }

        MiniFrameFactory localMiniFrameFactory = new MiniFrameFactory();
        Object localObject;
        if ((localObject = MiniFrameFactory.a(paramFrameData)) == null) {
            localObject = paramFrameData;
        }
        localMiniFrameFactory.b((FrameData)localObject);

        return localObject;
    }
}
