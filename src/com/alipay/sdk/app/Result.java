/*    */ package com.alipay.sdk.app;
/*    */ 
/*    */ public class Result
/*    */ {
/*    */   private static String a;
/*    */ 
/*    */   public static void a(String paramString)
/*    */   {
/* 15 */     a = paramString;
/*    */   }
/*    */ 
/*    */   public static String a() {
/* 19 */     return a;
/*    */   }
/*    */ 
/*    */   public static String b()
/*    */   {
/*    */     ResultStatus localResultStatus;
/* 25 */     return a((
/* 25 */       localResultStatus = ResultStatus.a(ResultStatus.c.a()))
/* 25 */       .a(), localResultStatus.b(), "");
/*    */   }
/*    */ 
/*    */   public static String c()
/*    */   {
/*    */     ResultStatus localResultStatus;
/* 31 */     return a((
/* 31 */       localResultStatus = ResultStatus.a(ResultStatus.e.a()))
/* 31 */       .a(), localResultStatus.b(), "");
/*    */   }
/*    */ 
/*    */   public static String a(int paramInt, String paramString1, String paramString2)
/*    */   {
/*    */     StringBuilder localStringBuilder;
/* 36 */     (
/* 37 */       localStringBuilder = new StringBuilder())
/* 37 */       .append("resultStatus={").append(paramInt).append("};memo={").append(paramString1).append("};result={").append(paramString2).append("}");
/*    */ 
/* 39 */     return localStringBuilder.toString();
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.app.Result
 * JD-Core Version:    0.6.2
 */