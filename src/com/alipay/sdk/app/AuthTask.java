/*    */ package com.alipay.sdk.app;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import com.alipay.sdk.data.MspConfig;
/*    */ import com.alipay.sdk.sys.GlobalContext;
/*    */ import com.alipay.sdk.util.AuthHelper;
/*    */ 
/*    */ public class AuthTask
/*    */ {
/*    */   private Activity a;
/*    */ 
/*    */   public AuthTask(Activity paramActivity)
/*    */   {
/* 21 */     this.a = paramActivity;
/*    */   }
/*    */ 
/*    */   public synchronized String auth(String paramString) {
/* 25 */     GlobalContext.a().a(this.a, MspConfig.a());
/* 26 */     return AuthHelper.a(this.a, paramString);
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.app.AuthTask
 * JD-Core Version:    0.6.2
 */