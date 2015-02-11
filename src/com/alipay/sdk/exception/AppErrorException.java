/*    */ package com.alipay.sdk.exception;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ import android.util.Log;
/*    */ 
/*    */ public final class AppErrorException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 4918321648798599467L;
/*    */ 
/*    */   public AppErrorException(Class paramClass)
/*    */   {
/* 25 */     this(paramClass, null, null);
/*    */   }
/*    */ 
/*    */   public AppErrorException(Class paramClass, String paramString) {
/* 29 */     this(paramClass, paramString, null);
/*    */   }
/*    */ 
/*    */   public AppErrorException(Class paramClass, Throwable paramThrowable) {
/* 33 */     this(paramClass, null, paramThrowable);
/*    */   }
/*    */ 
/*    */   public AppErrorException(Class paramClass, String paramString, Throwable paramThrowable)
/*    */   {
/* 38 */     super(paramString, paramThrowable);
/* 39 */     printException(paramClass, paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   public static void printException(Class paramClass, String paramString, Throwable paramThrowable)
/*    */   {
/* 44 */     if (paramClass != null) {
/* 45 */       Log.e("AppError", "AppError--" + paramClass.getCanonicalName());
/*    */     }
/* 47 */     if (!TextUtils.isEmpty(paramString))
/* 48 */       Log.e("AppError", "AppError--" + paramString);
/*    */     try
/*    */     {
/* 51 */       if (paramThrowable != null) {
/* 52 */         Log.e("AppError", "AppError--" + paramThrowable.getMessage());
/* 53 */         paramThrowable.printStackTrace();
/*    */       }
/*    */ 
/* 56 */       return;
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.exception.AppErrorException
 * JD-Core Version:    0.6.2
 */