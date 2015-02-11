/*    */ package com.alipay.sdk.exception;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ import android.util.Log;
/*    */ 
/*    */ public final class NetErrorException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 8374198311711795611L;
/*    */   public static final int NET_CONNECTION_ERROR = 0;
/*    */   public static final int SERVER_ERROR = 1;
/*    */   public static final int SSL_ERROR = 2;
/*    */   private int errorCode;
/*    */ 
/*    */   public NetErrorException()
/*    */   {
/* 31 */     this(null, null);
/*    */   }
/*    */ 
/*    */   public NetErrorException(String paramString) {
/* 35 */     this(paramString, null);
/*    */   }
/*    */ 
/*    */   public NetErrorException(Throwable paramThrowable) {
/* 39 */     this(null, paramThrowable);
/*    */   }
/*    */ 
/*    */   public NetErrorException(String paramString, Throwable paramThrowable) {
/* 43 */     super(paramString, paramThrowable);
/* 44 */     this.errorCode = 0;
/* 45 */     printException(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   public final int getErrorCode() {
/* 49 */     return this.errorCode;
/*    */   }
/*    */ 
/*    */   public final void setErrorCode(int paramInt) {
/* 53 */     this.errorCode = paramInt;
/*    */   }
/*    */ 
/*    */   public static void printException(String paramString, Throwable paramThrowable) {
/* 57 */     if (!TextUtils.isEmpty(paramString))
/* 58 */       Log.w("NetError", "NetError--" + paramString);
/*    */     try
/*    */     {
/* 61 */       if (paramThrowable != null) {
/* 62 */         Log.w("NetError", "NetError--" + paramThrowable.getMessage());
/*    */       }
/*    */ 
/* 65 */       return;
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.exception.NetErrorException
 * JD-Core Version:    0.6.2
 */