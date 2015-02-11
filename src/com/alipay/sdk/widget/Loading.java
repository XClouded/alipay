/*    */ package com.alipay.sdk.widget;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.app.ProgressDialog;
/*    */ import android.content.DialogInterface.OnCancelListener;
/*    */ 
/*    */ public class Loading
/*    */ {
/*    */   private Activity a;
/*    */   private ProgressDialog b;
/*    */ 
/*    */   public Loading(Activity paramActivity)
/*    */   {
/* 21 */     this.a = paramActivity;
/*    */   }
/*    */ 
/*    */   public final boolean a() {
/* 25 */     return (this.b != null) && (this.b.isShowing());
/*    */   }
/*    */ 
/*    */   public final void b() {
/* 29 */     a("正在加载", false, null);
/*    */   }
/*    */ 
/*    */   private void a(String paramString) {
/* 33 */     a(paramString, false, null);
/*    */   }
/*    */ 
/*    */   public final void a(final CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
/*    */   {
/* 38 */     paramCharSequence = new Runnable()
/*    */     {
/*    */       public void run() {
/* 41 */         if (Loading.a(Loading.this) == null) {
/* 42 */           Loading.a(Loading.this, new ProgressDialog(Loading.b(Loading.this)));
/*    */         }
/* 44 */         Loading.a(Loading.this).setCancelable(paramBoolean);
/* 45 */         Loading.a(Loading.this).setOnCancelListener(paramOnCancelListener);
/* 46 */         Loading.a(Loading.this).setMessage(paramCharSequence);
/*    */         try { Loading.a(Loading.this).show();
/*    */           return; } catch (Exception localException) {
/* 50 */           Loading.a(Loading.this, null);
/*    */         }
/*    */       }
/*    */     };
/* 55 */     this.a.runOnUiThread(paramCharSequence);
/*    */   }
/*    */ 
/*    */   public final void c() {
/* 59 */     Runnable local2 = new Runnable()
/*    */     {
/*    */       // ERROR //
/*    */       public void run()
/*    */       {
/*    */         // Byte code:
/*    */         //   0: aload_0
/*    */         //   1: getfield 8	com/alipay/sdk/widget/Loading$2:a	Lcom/alipay/sdk/widget/Loading;
/*    */         //   4: invokestatic 11	com/alipay/sdk/widget/Loading:a	(Lcom/alipay/sdk/widget/Loading;)Landroid/app/ProgressDialog;
/*    */         //   7: ifnull +23 -> 30
/*    */         //   10: aload_0
/*    */         //   11: getfield 8	com/alipay/sdk/widget/Loading$2:a	Lcom/alipay/sdk/widget/Loading;
/*    */         //   14: invokevirtual 10	com/alipay/sdk/widget/Loading:a	()Z
/*    */         //   17: ifeq +13 -> 30
/*    */         //   20: aload_0
/*    */         //   21: getfield 8	com/alipay/sdk/widget/Loading$2:a	Lcom/alipay/sdk/widget/Loading;
/*    */         //   24: invokestatic 11	com/alipay/sdk/widget/Loading:a	(Lcom/alipay/sdk/widget/Loading;)Landroid/app/ProgressDialog;
/*    */         //   27: invokevirtual 9	android/app/ProgressDialog:dismiss	()V
/*    */         //   30: aload_0
/*    */         //   31: getfield 8	com/alipay/sdk/widget/Loading$2:a	Lcom/alipay/sdk/widget/Loading;
/*    */         //   34: aconst_null
/*    */         //   35: invokestatic 12	com/alipay/sdk/widget/Loading:a	(Lcom/alipay/sdk/widget/Loading;Landroid/app/ProgressDialog;)Landroid/app/ProgressDialog;
/*    */         //   38: pop
/*    */         //   39: return
/*    */         //   40: pop
/*    */         //   41: aload_0
/*    */         //   42: getfield 8	com/alipay/sdk/widget/Loading$2:a	Lcom/alipay/sdk/widget/Loading;
/*    */         //   45: aconst_null
/*    */         //   46: invokestatic 12	com/alipay/sdk/widget/Loading:a	(Lcom/alipay/sdk/widget/Loading;Landroid/app/ProgressDialog;)Landroid/app/ProgressDialog;
/*    */         //   49: pop
/*    */         //   50: return
/*    */         //   51: astore_1
/*    */         //   52: aload_0
/*    */         //   53: getfield 8	com/alipay/sdk/widget/Loading$2:a	Lcom/alipay/sdk/widget/Loading;
/*    */         //   56: aconst_null
/*    */         //   57: invokestatic 12	com/alipay/sdk/widget/Loading:a	(Lcom/alipay/sdk/widget/Loading;Landroid/app/ProgressDialog;)Landroid/app/ProgressDialog;
/*    */         //   60: pop
/*    */         //   61: aload_1
/*    */         //   62: athrow
/*    */         //
/*    */         // Exception table:
/*    */         //   from	to	target	type
/*    */         //   0	30	40	java/lang/Exception
/*    */         //   0	30	51	finally
/*    */       }
/*    */     };
/* 72 */     this.a.runOnUiThread(local2);
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.widget.Loading
 * JD-Core Version:    0.6.2
 */