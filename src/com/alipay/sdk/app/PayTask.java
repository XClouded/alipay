/*     */ package com.alipay.sdk.app;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.Dialog;
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnCancelListener;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.text.TextUtils;
/*     */ import com.alipay.sdk.cons.GlobalConstants;
/*     */ import com.alipay.sdk.data.FrameUtils;
/*     */ import com.alipay.sdk.data.InteractionData;
/*     */ import com.alipay.sdk.data.MspConfig;
/*     */ import com.alipay.sdk.data.Request;
/*     */ import com.alipay.sdk.exception.AppErrorException;
/*     */ import com.alipay.sdk.exception.FailOperatingException;
/*     */ import com.alipay.sdk.exception.NetErrorException;
/*     */ import com.alipay.sdk.exception.UnZipException;
/*     */ import com.alipay.sdk.net.RequestWrapper;
/*     */ import com.alipay.sdk.protocol.ActionType;
/*     */ import com.alipay.sdk.protocol.ElementAction;
/*     */ import com.alipay.sdk.protocol.FrameData;
/*     */ import com.alipay.sdk.sys.GlobalContext;
/*     */ import com.alipay.sdk.util.ActionUtil;
/*     */ import com.alipay.sdk.util.FileDownloader;
/*     */ import com.alipay.sdk.util.FileDownloader.IDownloadProgress;
/*     */ import com.alipay.sdk.util.PayHelper;
/*     */ import com.alipay.sdk.util.Utils;
/*     */ import com.alipay.sdk.widget.Loading;
/*     */ import com.alipay.sdk.widget.SystemDefaultDialog;
/*     */ import java.io.File;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class PayTask
/*     */ {
/*     */   private Activity b;
/*     */   private String c;
/*     */   private Dialog d;
/*     */   private FileDownloader e;
/*  56 */   static final Object a = PayHelper.class;
/*     */   private Handler f;
/*     */   private String g;
/*     */   private boolean h;
/*     */   private String i;
/* 418 */   private Runnable j = new Runnable()
/*     */   {
/*     */     public void run()
/*     */     {
/* 422 */       if (PayTask.b(PayTask.this) != null) {
/* 423 */         PayTask.b(PayTask.this).c();
/*     */       }
/* 425 */       SystemDefaultDialog.a(PayTask.a(PayTask.this), "提示", "下载安装包失败，是否重试？", "重试", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */         {
/* 430 */           PayTask.g(PayTask.this);
/*     */         }
/*     */       }
/*     */       , "取消", new DialogInterface.OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface arg1, int paramAnonymous2Int)
/*     */         {
/* 436 */           synchronized (PayTask.a) {
/* 437 */             Result.a(Result.b());
/*     */             try {
/* 439 */               PayTask.a.notify(); } catch (Exception localException) {
/*     */             }
/* 441 */             return;
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 418 */   };
/*     */ 
/* 451 */   private BroadcastReceiver k = new BroadcastReceiver()
/*     */   {
/*     */     public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
/*     */     {
/* 455 */       if (paramAnonymousIntent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_ADDED"))
/*     */       {
/* 458 */         paramAnonymousContext = new Runnable()
/*     */         {
/*     */           public void run() {
/* 461 */             if (PayTask.h(PayTask.this) != null)
/* 462 */               PayTask.h(PayTask.this).dismiss();
/* 463 */             PayTask.a(PayTask.this, true);
/* 464 */             PayTask.a(PayTask.this).unregisterReceiver(PayTask.c(PayTask.this));
/*     */           }
/*     */         };
/* 467 */         PayTask.e(PayTask.this).post(paramAnonymousContext);
/*     */       }
/*     */     }
/* 451 */   };
/*     */ 
/*     */   public PayTask(Activity paramActivity)
/*     */   {
/*  67 */     this.b = paramActivity;
/*     */   }
/*     */ 
/*     */   public synchronized String pay(String paramString) {
/*  71 */     this.c = paramString;
/*  72 */     GlobalContext.a().a(this.b, MspConfig.a());
/*     */ 
/*  74 */     if (this.c.contains("service=alipay.acquire.mr.ord.createandpay")) {
/*  75 */       GlobalConstants.n = true;
/*     */     }
/*  77 */     if (paramString.contains("paymethod=\"expressGateway\"")) {
/*  78 */       return b();
/*     */     }
/*     */ 
/*  81 */     if (Utils.b(this.b))
/*     */     {
/*  83 */       if (TextUtils.equals(paramString = a(), 
/*  83 */         "failed"))
/*  84 */         return b();
/*  85 */       if (TextUtils.isEmpty(paramString)) {
/*  86 */         return Result.b();
/*     */       }
/*  88 */       return paramString;
/*     */     }
/*  90 */     return b();
/*     */   }
/*     */ 
/*     */   public String getVersion()
/*     */   {
/*  96 */     return "9.1.8";
/*     */   }
/*     */ 
/*     */   public boolean checkAccountIfExist() {
/* 100 */     Request localRequest = FrameUtils.a();
/*     */     try
/*     */     {
/* 104 */       return new RequestWrapper().a(this.b, localRequest, true)
/* 104 */         .c().optBoolean("hasAccount", false);
/*     */     } catch (Exception localException) {
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   private String a()
/*     */   {
/* 114 */     if (GlobalConstants.n) {
/* 115 */       if (this.c.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
/* 116 */         this.c = this.c.substring(this.c.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
/*     */       }
/* 119 */       else if (this.c.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?"))
/*     */       {
/* 121 */         this.c = this.c.substring(this.c.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
/*     */       }
/* 124 */       else if (this.c.startsWith("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?"))
/*     */       {
/* 126 */         this.c = this.c.substring(this.c.indexOf("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?") + 59);
/*     */       }
/* 129 */       else if (this.c.startsWith("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?"))
/*     */       {
/* 131 */         this.c = this.c.substring(this.c.indexOf("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?") + 65);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 137 */     PayHelper localPayHelper = new PayHelper(this.b);
/*     */ 
/* 139 */     if (this.c.contains("bizcontext=")) {
/* 140 */       return localPayHelper.a(this.c);
/*     */     }
/* 142 */     if (this.c.contains("\"")) {
/* 143 */       return localPayHelper.a(this.c + "&bizcontext=\"{\"appkey\":\"2014052600006128\"}\"");
/*     */     }
/*     */ 
/* 146 */     return localPayHelper.a(this.c + "&bizcontext={\"appkey\":\"2014052600006128\"}");
/*     */   }
/*     */ 
/*     */   private String b()
/*     */   {
/* 151 */     Loading localLoading = null;
/*     */     try {
/* 153 */       if ((this.b != null) && (!this.b.isFinishing()))
/* 154 */         (
/* 155 */           localLoading = new Loading(this.b))
/* 155 */           .b();
/*     */     }
/*     */     catch (Exception localException) {
/* 158 */       localLoading = null;
/*     */     }
/*     */ 
/* 161 */     if (GlobalConstants.n) {
/* 162 */       if (this.c.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
/* 163 */         this.c = this.c.substring(this.c.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
/*     */       }
/* 166 */       else if (this.c.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?"))
/*     */       {
/* 168 */         this.c = this.c.substring(this.c.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
/*     */       }
/* 171 */       else if (this.c.startsWith("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?"))
/*     */       {
/* 173 */         this.c = this.c.substring(this.c.indexOf("http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?") + 59);
/*     */ 
/* 176 */         GlobalConstants.b = "https://mobiletestabc.alipaydev.com/mobileclientgw/stable/gateway.do";
/* 177 */       } else if (this.c.startsWith("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?"))
/*     */       {
/* 179 */         this.c = this.c.substring(this.c.indexOf("http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?") + 65);
/*     */ 
/* 182 */         GlobalConstants.b = "https://mobiletestabc.alipaydev.com/mobileclientgw/stable/gateway.do";
/*     */       }
/*     */     }
/*     */ 
/* 186 */     Object localObject1 = FrameUtils.a(new InteractionData(), this.c, new JSONObject());
/*     */ 
/* 188 */     Object localObject3 = new RequestWrapper(new InteractionData());
/*     */ 
/* 190 */     ResultStatus localResultStatus = null;
/*     */     try
/*     */     {
/* 197 */       int m = (localObject3 = localObject1 = ActionType.a(ElementAction.a(((RequestWrapper)localObject3).a(this.b, (Request)localObject1, false)
/* 193 */         .c()
/* 194 */         .optJSONObject("form"), "onload"))).length;
/*     */       ActionType localActionType;
/* 197 */       for (int n = 0; n < m; n++) {
/* 198 */         if ((
/* 198 */           localActionType = localObject3[n]) == 
/* 198 */           ActionType.f) {
/* 199 */           ActionUtil.b(localActionType.e());
/*     */         }
/*     */       }
/*     */ 
/* 203 */       if (localLoading != null) {
/* 204 */         localLoading.c();
/*     */       }
/* 206 */       m = (localObject3 = localObject1).length; for (n = 0; n < m; n++) {
/* 207 */         if ((
/* 207 */           localActionType = localObject3[n]) == 
/* 207 */           ActionType.a) {
/* 208 */           return a(localActionType);
/*     */         }
/*     */ 
/* 213 */         if (localActionType == ActionType.d) {
/* 214 */           this.f = new Handler(this.b.getMainLooper());
/* 215 */           this.i = (this.b.getCacheDir().getAbsolutePath() + "/temp.apk");
/*     */ 
/* 217 */           return b(localActionType);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (NetErrorException localNetErrorException) {
/* 222 */       localResultStatus = ResultStatus.a(ResultStatus.d.a());
/*     */     } catch (FailOperatingException localFailOperatingException) {
/*     */     } catch (AppErrorException localAppErrorException) {
/*     */     } catch (UnZipException localUnZipException) {
/*     */     }
/*     */     finally {
/* 228 */       if (localLoading != null) {
/* 229 */         localLoading.c();
/*     */       }
/*     */     }
/* 232 */     if (localResultStatus == null) {
/* 233 */       localResultStatus = ResultStatus.a(ResultStatus.b.a());
/*     */     }
/*     */ 
/* 238 */     return Result.a(localResultStatus.a(), localResultStatus.b(), "");
/*     */   }
/*     */ 
/*     */   private String a(ActionType arg1)
/*     */   {
/* 242 */     ??? = ActionUtil.a(???.e());
/*     */ 
/* 244 */     Intent localIntent = new Intent(this.b, H5PayActivity.class);
/* 245 */     Bundle localBundle = new Bundle();
/* 246 */     String str = ???[0];
/* 247 */     localBundle.putString("url", str);
/*     */ 
/* 249 */     if (???.length == 2) {
/* 250 */       ??? = ???[1];
/* 251 */       localBundle.putString("cookie", ???);
/*     */     }
/*     */ 
/* 254 */     localIntent.putExtras(localBundle);
/* 255 */     this.b.startActivity(localIntent);
/*     */ 
/* 257 */     synchronized (a) {
/*     */       try {
/* 259 */         a.wait();
/*     */       }
/*     */       catch (InterruptedException localInterruptedException)
/*     */       {
/*     */       }
/*     */     }
/*     */ 
/* 266 */     if (TextUtils.isEmpty( = Result.a()))
/*     */     {
/* 267 */       ??? = Result.b();
/*     */     }
/*     */ 
/* 270 */     return ???;
/*     */   }
/*     */ 
/*     */   private String b(ActionType arg1) {
/* 274 */     Object localObject1 = ActionUtil.a(???.e());
/*     */ 
/* 276 */     final ActionType[] arrayOfActionType1 = null;
/* 277 */     final ActionType[] arrayOfActionType2 = null;
/*     */ 
/* 279 */     if ((localObject1.length > 4) && (!TextUtils.isEmpty(localObject1[4]))) {
/* 280 */       arrayOfActionType1 = ActionType.a(ElementAction.a(localObject1[4], ???));
/*     */     }
/*     */ 
/* 284 */     if ((localObject1.length > 5) && (!TextUtils.isEmpty(localObject1[5]))) {
/* 285 */       arrayOfActionType2 = ActionType.a(ElementAction.a(localObject1[5], ???));
/*     */     }
/*     */ 
/* 288 */     final ActionType[] arrayOfActionType4 = arrayOfActionType2; final String str = localObject1[3]; final ActionType[] arrayOfActionType3 = arrayOfActionType1; arrayOfActionType2 = localObject1[2]; arrayOfActionType1 = localObject1[1]; localObject1 = localObject1[0]; ??? = this; this.b.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 316 */         DialogInterface.OnClickListener local1 = null;
/* 317 */         DialogInterface.OnClickListener local2 = null;
/* 318 */         if (arrayOfActionType3 != null) {
/* 319 */           local1 = new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 323 */               PayTask.a(PayTask.this, PayTask.1.this.a);
/*     */             }
/*     */           };
/*     */         }
/* 327 */         if (arrayOfActionType4 != null) {
/* 328 */           local2 = new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 332 */               PayTask.a(PayTask.this, PayTask.1.this.b);
/*     */             }
/*     */           };
/*     */         }
/*     */ 
/* 337 */         SystemDefaultDialog.a(PayTask.a(PayTask.this), this.c, arrayOfActionType1, arrayOfActionType2, local1, str, local2);
/*     */       }
/*     */     });
/* 291 */     synchronized (a) {
/*     */       try {
/* 293 */         a.wait();
/*     */       }
/*     */       catch (InterruptedException localInterruptedException) {
/* 296 */         localInterruptedException.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 299 */     if (this.h) {
/* 300 */       return a();
/*     */     }
/*     */ 
/* 303 */     if (TextUtils.isEmpty( = Result.a()))
/*     */     {
/* 304 */       ??? = Result.b();
/*     */     }
/* 306 */     return ???;
/*     */   }
/*     */ 
/*     */   private void a(String paramString1, String paramString2, String paramString3, ActionType[] paramArrayOfActionType1, String paramString4, ActionType[] paramArrayOfActionType2)
/*     */   {
/* 312 */     this.b.runOnUiThread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 316 */         DialogInterface.OnClickListener local1 = null;
/* 317 */         DialogInterface.OnClickListener local2 = null;
/* 318 */         if (arrayOfActionType3 != null) {
/* 319 */           local1 = new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 323 */               PayTask.a(PayTask.this, PayTask.1.this.a);
/*     */             }
/*     */           };
/*     */         }
/* 327 */         if (arrayOfActionType4 != null) {
/* 328 */           local2 = new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 332 */               PayTask.a(PayTask.this, PayTask.1.this.b);
/*     */             }
/*     */           };
/*     */         }
/*     */ 
/* 337 */         SystemDefaultDialog.a(PayTask.a(PayTask.this), this.c, arrayOfActionType1, arrayOfActionType2, local1, str, local2);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private void a(ActionType[] paramArrayOfActionType)
/*     */   {
/* 345 */     int m = (paramArrayOfActionType = paramArrayOfActionType).length; for (int n = 0; n < m; n++)
/*     */     {
/*     */       ActionType localActionType;
/* 346 */       if ((
/* 346 */         localActionType = paramArrayOfActionType[n]) == 
/* 346 */         ActionType.b) {
/* 347 */         String[] arrayOfString = ActionUtil.a(localActionType.e());
/* 348 */         this.g = arrayOfString[0];
/* 349 */         c();
/*     */       }
/* 351 */       if (localActionType == ActionType.g)
/* 352 */         synchronized (a) {
/* 353 */           Result.a(Result.b());
/*     */           try {
/* 355 */             a.notify();
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void c()
/*     */   {
/*     */     Object localObject;
/* 365 */     (
/* 366 */       localObject = new Loading(this.b))
/* 366 */       .a("正在下载中", true, new DialogInterface.OnCancelListener()
/*     */     {
/*     */       public void onCancel(DialogInterface arg1)
/*     */       {
/* 370 */         this.a.c();
/* 371 */         PayTask.b(PayTask.this).c();
/* 372 */         PayTask.a(PayTask.this).unregisterReceiver(PayTask.c(PayTask.this));
/* 373 */         PayTask.e(PayTask.this).removeCallbacks(PayTask.d(PayTask.this));
/* 374 */         synchronized (PayTask.a) {
/* 375 */           Result.a(Result.b());
/*     */           try {
/* 377 */             PayTask.a.notify();
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */           return;
/*     */         }
/*     */       }
/*     */     });
/* 386 */     this.e = new FileDownloader();
/* 387 */     this.e.a(this.g);
/* 388 */     this.e.b(this.i);
/* 389 */     this.e.a(new FileDownloader.IDownloadProgress()
/*     */     {
/*     */       public final void a() {
/* 392 */         this.a.c();
/* 393 */         PayTask.e(PayTask.this).removeCallbacks(PayTask.d(PayTask.this));
/* 394 */         PayTask.f(PayTask.this);
/*     */       }
/*     */ 
/*     */       public final void b()
/*     */       {
/*     */       }
/*     */ 
/*     */       public final void c()
/*     */       {
/* 403 */         this.a.c();
/* 404 */         PayTask.e(PayTask.this).post(PayTask.d(PayTask.this));
/*     */       }
/*     */     });
/* 408 */     this.e.b();
/*     */ 
/* 410 */     (
/* 411 */       localObject = new IntentFilter())
/* 411 */       .addAction("android.intent.action.PACKAGE_ADDED");
/* 412 */     ((IntentFilter)localObject).addDataScheme("package");
/* 413 */     this.b.registerReceiver(this.k, (IntentFilter)localObject);
/*     */ 
/* 415 */     this.f.postDelayed(this.j, 180000L);
/*     */   }
/*     */ 
/*     */   private void d()
/*     */   {
/* 473 */     Runnable local6 = new Runnable()
/*     */     {
/*     */       public void run() {
/* 476 */         if (Utils.b(PayTask.a(PayTask.this), PayTask.i(PayTask.this))) {
/* 477 */           Utils.a(PayTask.a(PayTask.this), PayTask.i(PayTask.this));
/*     */ 
/* 479 */           PayTask.a(PayTask.this, SystemDefaultDialog.a(PayTask.a(PayTask.this), "提示", "是否取消安装？", "重新安装", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
/*     */             {
/* 486 */               PayTask.f(PayTask.this);
/*     */             }
/*     */           }
/*     */           , "取消", new DialogInterface.OnClickListener()
/*     */           {
/*     */             public void onClick(DialogInterface arg1, int paramAnonymous2Int)
/*     */             {
/* 493 */               PayTask.a(PayTask.this).unregisterReceiver(PayTask.c(PayTask.this));
/* 494 */               PayTask.a(PayTask.this, false);
/* 495 */               Result.a(Result.b());
/*     */ 
/* 497 */               synchronized (PayTask.a) {
/*     */                 try {
/* 499 */                   PayTask.a.notify();
/*     */                 }
/*     */                 catch (Exception localException)
/*     */                 {
/*     */                 }
/*     */                 return;
/*     */               }
/*     */             }
/*     */           }));
/* 479 */           return;
/*     */         }
/*     */ 
/* 508 */         synchronized (PayTask.a) {
/* 509 */           Result.a(Result.c());
/*     */           try {
/* 511 */             PayTask.a.notify();
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */           return;
/*     */         }
/*     */       }
/*     */     };
/* 519 */     this.f.post(local6);
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.app.PayTask
 * JD-Core Version:    0.6.2
 */