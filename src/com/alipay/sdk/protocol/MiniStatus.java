/*    */ package com.alipay.sdk.protocol;
/*    */ 
/*    */ public enum MiniStatus
/*    */ {
/*    */   private String e;
/*    */ 
/*    */   private MiniStatus(String arg3)
/*    */   {
/*    */     Object localObject;
/* 27 */     this.e = localObject;
/*    */   }
/*    */ 
/*    */   private String a()
/*    */   {
/* 33 */     return this.e;
/*    */   }
/*    */ 
/*    */   public static MiniStatus a(String paramString) {
/* 37 */     Object localObject = null;
/* 38 */     for (MiniStatus localMiniStatus : values()) {
/* 39 */       if (paramString.startsWith(localMiniStatus.e)) {
/* 40 */         localObject = localMiniStatus;
/*    */       }
/*    */     }
/*    */ 
/* 44 */     return localObject;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.MiniStatus
 * JD-Core Version:    0.6.2
 */