/*    */ package com.alipay.sdk.exception;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ import android.util.Log;
/*    */ 
/*    */ public final class FailOperatingException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 5908800852030168641L;
/*    */ 
/*    */   public FailOperatingException()
/*    */   {
/* 26 */     this(null, null);
/*    */   }
/*    */ 
/*    */   public FailOperatingException(String paramString) {
/* 30 */     this(paramString, null);
/*    */   }
/*    */ 
/*    */   public FailOperatingException(Throwable paramThrowable) {
/* 34 */     this(null, paramThrowable);
/*    */   }
/*    */ 
/*    */   public FailOperatingException(String paramString, Throwable paramThrowable) {
/* 38 */     super(paramString, paramThrowable);
/* 39 */     printException(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   public static void printException(String paramString, Throwable paramThrowable) {
/* 43 */     if (!TextUtils.isEmpty(paramString))
/* 44 */       Log.i("FailOperating", "FailOperating--" + paramString);
/*    */     try
/*    */     {
/* 47 */       if (paramThrowable != null) {
/* 48 */         Log.i("FailOperating", "FailOperating--" + paramThrowable.getMessage());
/*    */ 
/* 50 */         paramThrowable.printStackTrace();
/*    */       }
/*    */ 
/* 53 */       return;
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.exception.FailOperatingException
 * JD-Core Version:    0.6.2
 */