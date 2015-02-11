/*     */ package com.alipay.sdk.auth;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.ActivityNotFoundException;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.pm.PackageInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.content.pm.PackageManager.NameNotFoundException;
/*     */ import android.net.Uri;
/*     */ 
/*     */ public class AuthHelper
/*     */ {
/*     */   private static final String a = "com.eg.android.AlipayGphone";
/*     */   private static final int b = 65;
/*     */ 
/*     */   private static boolean a(Context paramContext)
/*     */   {
/*     */     try
/*     */     {
/*  29 */       if ((
/*  29 */         paramContext = paramContext.getPackageManager()
/*  27 */         .getPackageInfo("com.eg.android.AlipayGphone", 128)) == null)
/*     */       {
/*  30 */         return false;
/*     */       }
/*  32 */       if (paramContext.versionCode < 
/*  32 */         65)
/*  33 */         return false;
/*     */     } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
/*  35 */       return false;
/*     */     }
/*  37 */     return true;
/*     */   }
/*     */ 
/*     */   public static void a(Activity paramActivity, APAuthInfo paramAPAuthInfo)
/*     */   {
/*     */     StringBuilder localStringBuilder;
/*  71 */     if (a(paramActivity)) {
/*  72 */       (localStringBuilder = new StringBuilder()).append("alipayauth://platformapi/startapp"); localStringBuilder.append("?appId=20000122"); localStringBuilder.append("&approveType=005"); localStringBuilder.append("&scope=kuaijie"); localStringBuilder.append("&productId="); localStringBuilder.append(paramAPAuthInfo.getProductId()); localStringBuilder.append("&thirdpartyId="); localStringBuilder.append(paramAPAuthInfo.getAppId()); localStringBuilder.append("&redirectUri="); localStringBuilder.append(paramAPAuthInfo.getRedirectUri()); a(paramActivity, localStringBuilder.toString()); return;
/*     */     }
/*  74 */     (localStringBuilder = new StringBuilder()).append("app_id="); localStringBuilder.append(paramAPAuthInfo.getAppId()); localStringBuilder.append("&partner="); localStringBuilder.append(paramAPAuthInfo.getPid()); localStringBuilder.append("&scope=kuaijie"); localStringBuilder.append("&login_goal=auth"); localStringBuilder.append("&redirect_url="); localStringBuilder.append(paramAPAuthInfo.getRedirectUri()); localStringBuilder.append("&view=wap"); localStringBuilder.append("&prod_code="); localStringBuilder.append(paramAPAuthInfo.getProductId());
/*     */     Intent localIntent;
/*  74 */     (localIntent = new Intent(paramActivity, AuthActivity.class)).putExtra("params", localStringBuilder.toString()); localIntent.putExtra("redirectUri", paramAPAuthInfo.getRedirectUri()); paramActivity.startActivity(localIntent);
/*     */   }
/*     */ 
/*     */   private static void b(Activity paramActivity, APAuthInfo paramAPAuthInfo)
/*     */   {
/*     */     StringBuilder localStringBuilder;
/*  80 */     (
/*  81 */       localStringBuilder = new StringBuilder())
/*  81 */       .append("alipayauth://platformapi/startapp");
/*  82 */     localStringBuilder.append("?appId=20000122");
/*  83 */     localStringBuilder.append("&approveType=005");
/*  84 */     localStringBuilder.append("&scope=kuaijie");
/*  85 */     localStringBuilder.append("&productId=");
/*  86 */     localStringBuilder.append(paramAPAuthInfo.getProductId());
/*  87 */     localStringBuilder.append("&thirdpartyId=");
/*  88 */     localStringBuilder.append(paramAPAuthInfo.getAppId());
/*  89 */     localStringBuilder.append("&redirectUri=");
/*  90 */     localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
/*     */ 
/*  92 */     a(paramActivity, localStringBuilder.toString());
/*     */   }
/*     */ 
/*     */   private static void c(Activity paramActivity, APAuthInfo paramAPAuthInfo)
/*     */   {
/*     */     StringBuilder localStringBuilder;
/*  96 */     (
/*  97 */       localStringBuilder = new StringBuilder())
/*  97 */       .append("app_id=");
/*  98 */     localStringBuilder.append(paramAPAuthInfo.getAppId());
/*  99 */     localStringBuilder.append("&partner=");
/* 100 */     localStringBuilder.append(paramAPAuthInfo.getPid());
/* 101 */     localStringBuilder.append("&scope=kuaijie");
/* 102 */     localStringBuilder.append("&login_goal=auth");
/* 103 */     localStringBuilder.append("&redirect_url=");
/* 104 */     localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
/* 105 */     localStringBuilder.append("&view=wap");
/*     */ 
/* 108 */     localStringBuilder.append("&prod_code=");
/* 109 */     localStringBuilder.append(paramAPAuthInfo.getProductId());
/*     */     Intent localIntent;
/* 111 */     (
/* 112 */       localIntent = new Intent(paramActivity, AuthActivity.class))
/* 112 */       .putExtra("params", localStringBuilder.toString());
/* 113 */     localIntent.putExtra("redirectUri", paramAPAuthInfo.getRedirectUri());
/* 114 */     paramActivity.startActivity(localIntent);
/*     */   }
/*     */ 
/*     */   public static void a(Activity paramActivity, String paramString) {
/*     */     try {
/* 119 */       Intent localIntent = new Intent("android.intent.action.VIEW");
/* 120 */       paramString = Uri.parse(paramString);
/* 121 */       localIntent.setData(paramString);
/* 122 */       paramActivity.startActivity(localIntent);
/*     */ 
/* 124 */       return;
/*     */     }
/*     */     catch (ActivityNotFoundException localActivityNotFoundException)
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.auth.AuthHelper
 * JD-Core Version:    0.6.2
 */