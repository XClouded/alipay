/*    */ package com.alipay.sdk.encrypt;
/*    */ 
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ public class TriDes
/*    */ {
/*  9 */   private static String a = "DESede/ECB/PKCS5Padding";
/*    */ 
/*    */   public static String a(String paramString1, String paramString2) {
/* 12 */     String str = null;
/*    */     try
/*    */     {
/* 15 */       paramString1 = new SecretKeySpec(paramString1.getBytes(), "DESede");
/*    */       Cipher localCipher;
/* 17 */       (
/* 18 */         localCipher = Cipher.getInstance(a))
/* 18 */         .init(1, paramString1);
/*    */ 
/* 20 */       str = Base64.a(localCipher.doFinal(paramString2.getBytes()));
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/* 23 */       localException.printStackTrace();
/*    */     }
/*    */ 
/* 25 */     return str;
/*    */   }
/*    */ 
/*    */   public static String b(String paramString1, String paramString2) {
/* 29 */     String str = null;
/*    */     try
/*    */     {
/* 32 */       paramString1 = new SecretKeySpec(paramString1.getBytes(), "DESede");
/*    */       Cipher localCipher;
/* 34 */       (
/* 35 */         localCipher = Cipher.getInstance(a))
/* 35 */         .init(2, paramString1);
/* 36 */       paramString1 = localCipher.doFinal(Base64.a(paramString2));
/* 37 */       str = new String(paramString1);
/*    */     }
/*    */     catch (Exception localException) {
/* 40 */       localException.printStackTrace();
/*    */     }
/*    */ 
/* 42 */     return str;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.encrypt.TriDes
 * JD-Core Version:    0.6.2
 */