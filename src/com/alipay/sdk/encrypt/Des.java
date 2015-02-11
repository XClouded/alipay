/*    */ package com.alipay.sdk.encrypt;
/*    */ 
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ public class Des
/*    */ {
/*    */   public static String a(String paramString1, String paramString2)
/*    */   {
/* 12 */     return a(1, paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   public static String b(String paramString1, String paramString2) {
/* 16 */     return a(2, paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   private static String a(int paramInt, String paramString1, String paramString2) {
/*    */     try {
/* 21 */       paramString2 = new SecretKeySpec(paramString2.getBytes(), "DES");
/*    */       Cipher localCipher;
/* 22 */       (
/* 23 */         localCipher = Cipher.getInstance("DES"))
/* 23 */         .init(paramInt, paramString2);
/*    */ 
/* 27 */       if (paramInt == 2)
/*    */       {
/* 29 */         paramString1 = Base64.a(paramString1);
/*    */       }
/* 31 */       else paramString1 = paramString1.getBytes("UTF-8");
/*    */ 
/* 33 */       paramString1 = localCipher.doFinal(paramString1);
/*    */ 
/* 37 */       if (paramInt == 2)
/*    */       {
/* 39 */         paramInt = new String(paramString1);
/*    */       }
/* 41 */       return Base64.a(paramString1);
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/* 46 */     return null;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.encrypt.Des
 * JD-Core Version:    0.6.2
 */