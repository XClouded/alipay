/*     */ package com.alipay.sdk.util;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Bundle;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.android.app.IAlixPay;
/*     */ import com.alipay.android.app.IAlixPay.Stub;
/*     */ import com.alipay.android.app.IRemoteServiceCallback;
/*     */ import com.alipay.android.app.IRemoteServiceCallback.Stub;
/*     */ import com.alipay.sdk.app.Result;
/*     */ 
/*     */ public class PayHelper
/*     */ {
/*     */   private Activity b;
/*     */   private IAlixPay c;
/*  28 */   private Object d = IAlixPay.class;
/*     */ 
/*  30 */   private boolean e = false;
/*     */   public static final String a = "failed";
/*  38 */   private ServiceConnection f = new ServiceConnection()
/*     */   {
/*     */     public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
/*     */     {
/*  42 */       PayHelper.a(PayHelper.this, null);
/*     */     }
/*     */ 
/*     */     public void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
/*     */     {
/*  47 */       synchronized (PayHelper.a(PayHelper.this)) {
/*  48 */         PayHelper.a(PayHelper.this, IAlixPay.Stub.asInterface(paramAnonymousIBinder));
/*  49 */         PayHelper.a(PayHelper.this).notify();
/*  50 */         return;
/*     */       }
/*     */     }
/*  38 */   };
/*     */ 
/* 140 */   private IRemoteServiceCallback g = new IRemoteServiceCallback.Stub()
/*     */   {
/*     */     public boolean isHideLoadingScreen() throws RemoteException
/*     */     {
/* 144 */       return false;
/*     */     }
/*     */ 
/*     */     public void payEnd(boolean paramAnonymousBoolean, String paramAnonymousString)
/*     */       throws RemoteException
/*     */     {
/*     */     }
/*     */ 
/*     */     public void startActivity(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, Bundle paramAnonymousBundle)
/*     */       throws RemoteException
/*     */     {
/* 155 */       Intent localIntent = new Intent("android.intent.action.MAIN", null);
/*     */ 
/* 157 */       if (paramAnonymousBundle == null)
/* 158 */         paramAnonymousBundle = new Bundle();
/*     */       try
/*     */       {
/* 161 */         paramAnonymousBundle.putInt("CallingPid", paramAnonymousInt);
/* 162 */         localIntent.putExtras(paramAnonymousBundle);
/*     */       }
/*     */       catch (Exception localException) {
/* 165 */         localException.printStackTrace();
/*     */       }
/*     */ 
/* 166 */       localIntent.setClassName(paramAnonymousString1, paramAnonymousString2);
/* 167 */       PayHelper.b(PayHelper.this).startActivity(localIntent);
/*     */     }
/* 140 */   };
/*     */ 
/*     */   public PayHelper(Activity paramActivity)
/*     */   {
/*  35 */     this.b = paramActivity;
/*     */   }
/*     */ 
/*     */   public final String a(String paramString)
/*     */   {
/*     */     Object localObject;
/*  83 */     if (((
/*  83 */       localObject = Utils.a(Utils.a(this.b, "com.eg.android.AlipayGphone"))) != null) && 
/*  83 */       (!TextUtils.equals((CharSequence)localObject, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")))
/*     */     {
/*  86 */       return Result.c();
/*     */     }
/*     */ 
/*  89 */     (
/*  90 */       localObject = new Intent())
/*  90 */       .setClassName("com.eg.android.AlipayGphone", "com.alipay.android.app.MspService");
/*     */ 
/*  92 */     ((Intent)localObject).setAction("com.eg.android.AlipayGphone.IAlixPay");
/*  93 */     return a(paramString, (Intent)localObject);
/*     */   }
/*     */ 
/*     */   private String a(String paramString, Intent arg2) {
/*  97 */     String str = null;
/*     */ 
/*  99 */     if (this.e) {
/* 100 */       return "";
/*     */     }
/* 102 */     this.e = true;
/*     */ 
/* 104 */     if (this.c == null) {
/* 105 */       this.b.getApplicationContext().bindService(???, this.f, 1);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 110 */       synchronized (this.d) {
/* 111 */         if (this.c == null) {
/* 112 */           this.d.wait(3000L);
/*     */         }
/*     */       }
/* 115 */       if (this.c == null) {
/* 116 */         return "failed";
/*     */       }
/* 118 */       this.c.registerCallback(this.g);
/* 119 */       str = this.c.Pay(paramString);
/*     */ 
/* 121 */       this.c.unregisterCallback(this.g);
/*     */ 
/* 123 */       this.c = null;
/*     */     } catch (Exception localException3) {
/*     */     }
/*     */     finally {
/*     */       try {
/* 128 */         this.b.unbindService(this.f);
/*     */       } catch (Exception localException5) {
/* 130 */         this.c = null;
/*     */       }
/*     */ 
/* 133 */       this.e = false;
/*     */     }
/*     */ 
/* 137 */     return str;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.PayHelper
 * JD-Core Version:    0.6.2
 */