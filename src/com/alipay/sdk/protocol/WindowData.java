/*    */ package com.alipay.sdk.protocol;
/*    */ 
/*    */ import com.alipay.sdk.data.Request;
/*    */ import com.alipay.sdk.data.Response;
/*    */ 
/*    */ public abstract class WindowData extends FrameData
/*    */ {
/*    */   public static final int a = 4;
/*    */   public static final int b = 6;
/*    */   public static final int c = 7;
/*    */   public static final int d = 8;
/*    */   public static final int e = 9;
/*    */   public static final int f = 10;
/*    */   public static final int g = -10;
/* 32 */   boolean h = false;
/*    */ 
/*    */   protected WindowData(Request paramRequest, Response paramResponse) {
/* 35 */     super(paramRequest, paramResponse);
/*    */   }
/*    */ 
/*    */   private boolean g() {
/* 39 */     return this.h;
/*    */   }
/*    */ 
/*    */   private void a(boolean paramBoolean) {
/* 43 */     this.h = paramBoolean;
/*    */   }
/*    */ 
/*    */   public abstract boolean d();
/*    */ 
/*    */   public abstract int e();
/*    */ 
/*    */   public abstract String f();
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.WindowData
 * JD-Core Version:    0.6.2
 */