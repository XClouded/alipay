/*    */ package com.alipay.sdk.util;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.content.pm.PackageInfo;
/*    */ import android.content.pm.PackageManager;
/*    */ import android.content.pm.PackageManager.NameNotFoundException;
/*    */ import android.text.TextUtils;
/*    */ import com.alipay.sdk.app.AuthTask;
/*    */ import com.alipay.sdk.app.H5AuthActivity;
/*    */ import com.alipay.sdk.app.Result;
/*    */ 
/*    */ public class AuthHelper
/*    */ {
/*    */   private static final String b = "com.eg.android.AlipayGphone";
/*    */   private static final int c = 73;
/* 28 */   public static final Object a = AuthTask.class;
/*    */ 
/*    */   public static String a(Activity paramActivity, String paramString) {
/* 31 */     if (a(paramActivity)) {
/* 32 */       Object localObject = new PayHelper(paramActivity);
/*    */       String str;
/* 35 */       if ((
/* 35 */         str = paramString)
/* 35 */         .contains("\""))
/* 36 */         str = str + "&bizcontext=\"{\"appkey\":\"2014052600006128\"}\"";
/*    */       else {
/* 38 */         str = str + "&bizcontext={\"appkey\":\"2014052600006128\"}";
/*    */       }
/*    */ 
/* 41 */       if (TextUtils.isEmpty(localObject = ((PayHelper)localObject).a(str)))
/*    */       {
/* 42 */         return b(paramActivity, paramString);
/*    */       }
/* 44 */       return localObject;
/*    */     }
/* 46 */     return b(paramActivity, paramString);
/*    */   }
/*    */ 
/*    */   private static String b(Activity arg0, String paramString)
/*    */   {
/*    */     Intent localIntent;
/* 51 */     (
/* 52 */       localIntent = new Intent(???, H5AuthActivity.class))
/* 52 */       .putExtra("params", paramString);
/* 53 */     ???.startActivity(localIntent);
/*    */ 
/* 55 */     synchronized (a) {
/*    */       try {
/* 57 */         a.wait();
/*    */       }
/*    */       catch (InterruptedException localInterruptedException)
/*    */       {
/*    */       }
/*    */     }
/*    */ 
/* 64 */     if (TextUtils.isEmpty( = Result.a()))
/*    */     {
/* 65 */       ??? = Result.b();
/*    */     }
/*    */ 
/* 68 */     return ???;
/*    */   }
/*    */ 
/*    */   private static boolean a(Context paramContext)
/*    */   {
/*    */     try
/*    */     {
/* 76 */       if ((
/* 76 */         paramContext = paramContext.getPackageManager()
/* 74 */         .getPackageInfo("com.eg.android.AlipayGphone", 128)) == null)
/*    */       {
/* 77 */         return false;
/*    */       }
/* 79 */       if (paramContext.versionCode < 
/* 79 */         73)
/* 80 */         return false;
/*    */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/* 82 */       return false;
/*    */     }
/* 84 */     return true;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.AuthHelper
 * JD-Core Version:    0.6.2
 */