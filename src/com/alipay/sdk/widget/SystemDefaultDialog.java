/*    */ package com.alipay.sdk.widget;
/*    */ 
/*    */ import android.app.AlertDialog.Builder;
/*    */ import android.app.Dialog;
/*    */ import android.content.Context;
/*    */ import android.content.DialogInterface;
/*    */ import android.content.DialogInterface.OnClickListener;
/*    */ import android.content.DialogInterface.OnKeyListener;
/*    */ import android.os.Build.VERSION;
/*    */ import android.text.TextUtils;
/*    */ import android.view.KeyEvent;
/*    */ 
/*    */ public class SystemDefaultDialog
/*    */ {
/* 17 */   private static boolean a = Build.VERSION.SDK_INT >= 11;
/*    */ 
/*    */   public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
/*    */   {
/* 23 */     paramContext = new AlertDialog.Builder(paramContext); if (a) { if ((!TextUtils.isEmpty(paramString4)) && (paramOnClickListener2 != null)) paramContext.setPositiveButton(paramString4, paramOnClickListener2); if ((!TextUtils.isEmpty(paramString3)) && (paramOnClickListener1 != null)) paramContext.setNegativeButton(paramString3, paramOnClickListener1);  } else { if ((!TextUtils.isEmpty(paramString3)) && (paramOnClickListener1 != null)) paramContext.setPositiveButton(paramString3, paramOnClickListener1); if ((!TextUtils.isEmpty(paramString4)) && (paramOnClickListener2 != null)) paramContext.setNegativeButton(paramString4, paramOnClickListener2);
/*    */     }
/*    */ 
/* 26 */     paramContext = paramContext; paramContext
/* 26 */       .setTitle(paramString1);
/* 27 */     paramContext.setMessage(paramString2);
/* 28 */     (
/* 29 */       paramContext = paramContext.create())
/* 29 */       .setCanceledOnTouchOutside(false);
/* 30 */     paramContext.setOnKeyListener(new DialogInterface.OnKeyListener()
/*    */     {
/*    */       public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
/*    */       {
/* 34 */         if (paramAnonymousInt == 4) {
/* 35 */           return true;
/*    */         }
/* 37 */         return false;
/*    */       }
/*    */     });
/* 40 */     paramContext.show();
/* 41 */     return paramContext;
/*    */   }
/*    */ 
/*    */   private static AlertDialog.Builder a(Context paramContext, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, String paramString2, DialogInterface.OnClickListener paramOnClickListener2)
/*    */   {
/* 47 */     paramContext = new AlertDialog.Builder(paramContext);
/*    */ 
/* 49 */     if (a) {
/* 50 */       if ((!TextUtils.isEmpty(paramString2)) && (paramOnClickListener2 != null))
/*    */       {
/* 52 */         paramContext.setPositiveButton(paramString2, paramOnClickListener2);
/*    */       }
/*    */ 
/* 55 */       if ((!TextUtils.isEmpty(paramString1)) && (paramOnClickListener1 != null))
/*    */       {
/* 57 */         paramContext.setNegativeButton(paramString1, paramOnClickListener1);
/*    */       }
/*    */     } else {
/* 60 */       if ((!TextUtils.isEmpty(paramString1)) && (paramOnClickListener1 != null))
/*    */       {
/* 62 */         paramContext.setPositiveButton(paramString1, paramOnClickListener1);
/*    */       }
/*    */ 
/* 65 */       if ((!TextUtils.isEmpty(paramString2)) && (paramOnClickListener2 != null))
/*    */       {
/* 67 */         paramContext.setNegativeButton(paramString2, paramOnClickListener2);
/*    */       }
/*    */     }
/*    */ 
/* 71 */     return paramContext;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.widget.SystemDefaultDialog
 * JD-Core Version:    0.6.2
 */