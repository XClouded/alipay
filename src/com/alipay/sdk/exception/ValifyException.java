/*    */ package com.alipay.sdk.exception;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ import android.util.Log;
/*    */ 
/*    */ public final class ValifyException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 7405333891987087563L;
/*    */ 
/*    */   public ValifyException()
/*    */   {
/* 26 */     this(null, null);
/*    */   }
/*    */ 
/*    */   public ValifyException(String paramString) {
/* 30 */     this(paramString, null);
/*    */   }
/*    */ 
/*    */   public ValifyException(Throwable paramThrowable) {
/* 34 */     this(null, paramThrowable);
/*    */   }
/*    */ 
/*    */   public ValifyException(String paramString, Throwable paramThrowable) {
/* 38 */     super(paramString, paramThrowable);
/* 39 */     printException(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   public static void printException(String paramString, Throwable paramThrowable) {
/* 43 */     if (!TextUtils.isEmpty(paramString))
/* 44 */       Log.e("Validation", "Validation--" + paramString);
/*    */     try
/*    */     {
/* 47 */       if (paramThrowable != null) {
/* 48 */         Log.e("Validation", "Validation--" + paramThrowable.getMessage());
/* 49 */         paramThrowable.printStackTrace();
/*    */       }
/*    */ 
/* 52 */       return;
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.exception.ValifyException
 * JD-Core Version:    0.6.2
 */