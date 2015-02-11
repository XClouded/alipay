/*    */ package com.alipay.sdk.app;
/*    */ 
/*    */ public enum ResultStatus
/*    */ {
/*    */   private int g;
/*    */   private String h;
/*    */ 
/*    */   private ResultStatus(int arg3, String arg4)
/*    */   {
/*    */     int j;
/* 13 */     this.g = j;
/*    */     Object localObject;
/* 14 */     this.h = localObject;
/*    */   }
/*    */ 
/*    */   private void b(int paramInt) {
/* 18 */     this.g = paramInt;
/*    */   }
/*    */ 
/*    */   public final int a() {
/* 22 */     return this.g;
/*    */   }
/*    */ 
/*    */   private void a(String paramString) {
/* 26 */     this.h = paramString;
/*    */   }
/*    */ 
/*    */   public final String b() {
/* 30 */     return this.h;
/*    */   }
/*    */ 
/*    */   public static ResultStatus a(int paramInt) {
/* 34 */     switch (paramInt) {
/*    */     case 9000:
/* 36 */       return a;
/*    */     case 6001:
/* 38 */       return c;
/*    */     case 6002:
/* 40 */       return d;
/*    */     case 4001:
/* 42 */       return e;
/*    */     case 8000:
/* 44 */       return f;
/*    */     }
/* 46 */     return b;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.app.ResultStatus
 * JD-Core Version:    0.6.2
 */