/*     */ package com.alipay.sdk.encrypt;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.security.KeyFactory;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.PublicKey;
/*     */ import java.security.Signature;
/*     */ import java.security.spec.KeySpec;
/*     */ import java.security.spec.PKCS8EncodedKeySpec;
/*     */ import java.security.spec.X509EncodedKeySpec;
/*     */ import javax.crypto.Cipher;
/*     */ 
/*     */ public class Rsa
/*     */ {
/*     */   private static final String b = "RSA";
/*     */   public static final String a = "SHA1WithRSA";
/*     */ 
/*     */   private static PublicKey b(String paramString1, String paramString2)
/*     */     throws NoSuchAlgorithmException, Exception
/*     */   {
/*  33 */     paramString2 = Base64.a(paramString2);
/*  34 */     paramString2 = new X509EncodedKeySpec(paramString2);
/*     */ 
/*  37 */     return KeyFactory.getInstance(paramString1)
/*  37 */       .generatePublic(paramString2);
/*     */   }
/*     */ 
/*     */   public static String a(String paramString1, String paramString2) {
/*  41 */     String str1 = null;
/*  42 */     ByteArrayOutputStream localByteArrayOutputStream = null;
/*     */     try
/*     */     {
/*  45 */       Object localObject = paramString2; paramString2 = "RSA"; localObject = Base64.a((String)localObject); localObject = new X509EncodedKeySpec((byte[])localObject); paramString2 = KeyFactory.getInstance(paramString2).generatePublic((KeySpec)localObject);
/*     */ 
/*  47 */       (
/*  48 */         localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding"))
/*  48 */         .init(1, paramString2);
/*     */ 
/*  50 */       paramString1 = paramString1.getBytes("UTF-8");
/*     */ 
/*  52 */       paramString2 = ((Cipher)localObject).getBlockSize();
/*  53 */       localByteArrayOutputStream = new ByteArrayOutputStream();
/*     */       int i;
/*  55 */       for (String str2 = 0; str2 < paramString1.length; str2 += paramString2) {
/*  56 */         localByteArrayOutputStream.write(((Cipher)localObject).doFinal(paramString1, str2, paramString1.length - str2 < paramString2 ? paramString1.length - str2 : paramString2));
/*     */       }
/*     */ 
/*  62 */       str1 = new String(Base64.a(localByteArrayOutputStream.toByteArray()));
/*     */       try
/*     */       {
/*  67 */         localByteArrayOutputStream.close();
/*     */       }
/*     */       catch (IOException localIOException1)
/*     */       {
/*  72 */         localIOException1.printStackTrace();
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */     finally
/*     */     {
/*  67 */       if (localByteArrayOutputStream != null) {
/*     */         try {
/*  69 */           localByteArrayOutputStream.close();
/*     */         }
/*     */         catch (IOException localIOException3) {
/*  72 */           localIOException3.printStackTrace();
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  77 */     return str1;
/*     */   }
/*     */ 
/*     */   private static String c(String paramString1, String paramString2) {
/*  81 */     ByteArrayOutputStream localByteArrayOutputStream = null;
/*  82 */     String str1 = null;
/*     */     try
/*     */     {
/*  85 */       paramString2 = new PKCS8EncodedKeySpec(Base64.a(paramString2));
/*     */ 
/*  88 */       paramString2 = KeyFactory.getInstance("RSA")
/*  88 */         .generatePrivate(paramString2);
/*     */       Cipher localCipher;
/*  90 */       (
/*  91 */         localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"))
/*  91 */         .init(2, paramString2);
/*     */ 
/*  93 */       paramString1 = Base64.a(paramString1);
/*     */ 
/*  96 */       paramString2 = localCipher.getBlockSize();
/*  97 */       localByteArrayOutputStream = new ByteArrayOutputStream();
/*     */       int i;
/*  99 */       for (String str2 = 0; str2 < paramString1.length; str2 += paramString2) {
/* 100 */         localByteArrayOutputStream.write(localCipher.doFinal(paramString1, str2, paramString1.length - str2 < paramString2 ? paramString1.length - str2 : paramString2));
/*     */       }
/*     */ 
/* 106 */       str1 = new String(localByteArrayOutputStream.toByteArray());
/*     */       try
/*     */       {
/* 110 */         localByteArrayOutputStream.close();
/*     */       }
/*     */       catch (IOException localIOException1)
/*     */       {
/* 115 */         localIOException1.printStackTrace();
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */     finally
/*     */     {
/* 110 */       if (localByteArrayOutputStream != null) {
/*     */         try {
/* 112 */           localByteArrayOutputStream.close();
/*     */         }
/*     */         catch (IOException localIOException3) {
/* 115 */           localIOException3.printStackTrace();
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 120 */     return str1;
/*     */   }
/*     */ 
/*     */   private static String d(String paramString1, String paramString2)
/*     */   {
/* 126 */     String str = "utf-8";
/*     */     try {
/* 128 */       paramString2 = new PKCS8EncodedKeySpec(Base64.a(paramString2));
/*     */ 
/* 131 */       paramString2 = KeyFactory.getInstance("RSA")
/* 131 */         .generatePrivate(paramString2);
/*     */       Signature localSignature;
/* 133 */       (
/* 136 */         localSignature = Signature.getInstance("SHA1WithRSA"))
/* 136 */         .initSign(paramString2);
/* 137 */       localSignature.update(paramString1.getBytes(str));
/*     */ 
/* 141 */       return Base64.a(localSignature.sign());
/*     */     } catch (Exception localException) {
/* 141 */       localException
/* 142 */         .printStackTrace();
/*     */     }
/*     */ 
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   private static boolean a(String paramString1, String paramString2, String paramString3) {
/*     */     try {
/* 151 */       Object localObject = KeyFactory.getInstance("RSA");
/* 152 */       paramString3 = Base64.a(paramString3);
/* 153 */       paramString3 = ((KeyFactory)localObject).generatePublic(new X509EncodedKeySpec(paramString3));
/*     */ 
/* 156 */       (
/* 159 */         localObject = Signature.getInstance("SHA1WithRSA"))
/* 159 */         .initVerify(paramString3);
/* 160 */       ((Signature)localObject).update(paramString1.getBytes("utf-8"));
/*     */ 
/* 163 */       return ((Signature)localObject).verify(Base64.a(paramString2)); } catch (Exception localException) {
/* 163 */       localException
/* 165 */         .printStackTrace();
/*     */     }
/*     */ 
/* 169 */     return false;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.encrypt.Rsa
 * JD-Core Version:    0.6.2
 */