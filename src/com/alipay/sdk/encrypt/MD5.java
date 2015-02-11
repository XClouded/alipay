/*    */ package com.alipay.sdk.encrypt;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ public class MD5
/*    */ {
/*    */   private static String a(String paramString)
/*    */   {
/*    */     try
/*    */     {
/* 12 */       MessageDigest localMessageDigest;
/* 10 */       (
/* 11 */         localMessageDigest = MessageDigest.getInstance("MD5"))
/* 11 */         .update(paramString.getBytes());
/* 12 */       return b(localMessageDigest.digest()); } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) { localNoSuchAlgorithmException
/* 13 */         .printStackTrace();
/*    */     }
/*    */ 
/* 16 */     return "";
/*    */   }
/*    */ 
/*    */   public static String a(byte[] paramArrayOfByte)
/*    */   {
/*    */     try
/*    */     {
/* 24 */       MessageDigest localMessageDigest;
/* 22 */       (
/* 23 */         localMessageDigest = MessageDigest.getInstance("MD5"))
/* 23 */         .update(paramArrayOfByte);
/* 24 */       return b(localMessageDigest.digest()); } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) { localNoSuchAlgorithmException
/* 25 */         .printStackTrace();
/*    */     }
/*    */ 
/* 28 */     return "";
/*    */   }
/*    */ 
/*    */   private static String b(byte[] paramArrayOfByte)
/*    */   {
/* 38 */     StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
/* 39 */     for (int i = 0; i < paramArrayOfByte.length; i++) {
/* 40 */       localStringBuffer.append(Character.forDigit((paramArrayOfByte[i] & 0xF0) >> 4, 16));
/* 41 */       localStringBuffer.append(Character.forDigit(paramArrayOfByte[i] & 0xF, 16));
/*    */     }
/*    */ 
/* 44 */     return localStringBuffer.toString();
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.encrypt.MD5
 * JD-Core Version:    0.6.2
 */