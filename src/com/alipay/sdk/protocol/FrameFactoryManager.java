/*    */ package com.alipay.sdk.protocol;
/*    */ 
/*    */ import com.alipay.sdk.exception.AppErrorException;
/*    */ import com.alipay.sdk.exception.FailOperatingException;
/*    */ import com.alipay.sdk.exception.NetErrorException;
/*    */ 
/*    */ public class FrameFactoryManager
/*    */ {
/*    */   public static FrameData a(FrameData paramFrameData)
/*    */     throws NetErrorException, FailOperatingException, AppErrorException
/*    */   {
/* 20 */     if (paramFrameData == null) {
/* 21 */       throw new AppErrorException(FrameFactoryManager.class, "frame data is null");
/*    */     }
/*    */ 
/* 24 */     MiniFrameFactory localMiniFrameFactory = new MiniFrameFactory();
/*    */     Object localObject;
/* 26 */     if ((
/* 26 */       localObject = MiniFrameFactory.a(paramFrameData)) == null)
/*    */     {
/* 27 */       localObject = paramFrameData;
/*    */     }
/* 29 */     localMiniFrameFactory.b((FrameData)localObject);
/*    */ 
/* 31 */     return localObject;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.FrameFactoryManager
 * JD-Core Version:    0.6.2
 */