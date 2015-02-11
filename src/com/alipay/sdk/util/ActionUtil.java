/*    */ package com.alipay.sdk.util;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.text.TextUtils;
/*    */ import com.alipay.sdk.sys.GlobalContext;
/*    */ import com.alipay.sdk.tid.TidInfo;
/*    */ 
/*    */ public class ActionUtil
/*    */ {
/*    */   public static String[] a(String paramString)
/*    */   {
/* 20 */     int i = paramString.indexOf('(') + 1;
/* 21 */     int j = paramString.lastIndexOf(')');
/* 22 */     if ((i == 0) || (j == -1)) {
/* 23 */       return null;
/*    */     }
/*    */ 
/* 27 */     if ((
/* 27 */       paramString = paramString.substring(i, j)
/* 26 */       .split(",")) != null)
/*    */     {
/* 28 */       for (i = 0; i < paramString.length; i++) {
/* 29 */         if (!TextUtils.isEmpty(paramString[i])) {
/* 30 */           paramString[i] = paramString[i].trim();
/* 31 */           paramString[i] = paramString[i].replaceAll("'", "").replaceAll("\"", "");
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 36 */     return paramString;
/*    */   }
/*    */ 
/*    */   public static void b(String paramString)
/*    */   {
/* 43 */     if ((
/* 43 */       paramString = a(paramString)).length != 
/* 43 */       3) {
/* 44 */       return;
/*    */     }
/* 46 */     if (TextUtils.equals("tid", paramString[0])) {
/* 47 */       Context localContext = GlobalContext.a().b();
/* 48 */       TidInfo localTidInfo = TidInfo.c();
/* 49 */       if ((TextUtils.isEmpty(paramString[1])) || (TextUtils.isEmpty(paramString[2]))) {
/* 50 */         return;
/*    */       }
/* 52 */       localTidInfo.a(paramString[1]);
/* 53 */       localTidInfo.b(paramString[2]);
/* 54 */       localTidInfo.a(localContext);
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.ActionUtil
 * JD-Core Version:    0.6.2
 */