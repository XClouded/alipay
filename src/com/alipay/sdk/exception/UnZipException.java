/*    */ package com.alipay.sdk.exception;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ import android.util.Log;
/*    */ 
/*    */ public final class UnZipException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 7405333891987087563L;
/*    */ 
/*    */   public UnZipException()
/*    */   {
/* 25 */     this(null, null);
/*    */   }
/*    */ 
/*    */   public UnZipException(String paramString) {
/* 29 */     this(paramString, null);
/*    */   }
/*    */ 
/*    */   public UnZipException(Throwable paramThrowable) {
/* 33 */     this(null, paramThrowable);
/*    */   }
/*    */ 
/*    */   public UnZipException(String paramString, Throwable paramThrowable) {
/* 37 */     super(paramString, paramThrowable);
/* 38 */     printException(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   public static void printException(String paramString, Throwable paramThrowable) {
/* 42 */     if (!TextUtils.isEmpty(paramString))
/* 43 */       Log.e("Validation", "Validation--" + paramString);
/*    */     try
/*    */     {
/* 46 */       if (paramThrowable != null) {
/* 47 */         Log.e("Validation", "Validation--" + paramThrowable.getMessage());
/* 48 */         paramThrowable.printStackTrace();
/*    */       }
/*    */ 
/* 51 */       return;
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.exception.UnZipException
 * JD-Core Version:    0.6.2
 */