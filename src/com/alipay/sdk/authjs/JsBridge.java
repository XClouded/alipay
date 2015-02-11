/*     */ package com.alipay.sdk.authjs;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.text.TextUtils;
/*     */ import android.widget.Toast;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class JsBridge
/*     */ {
/*     */   private IJsCallback a;
/*     */   private Context b;
/*     */ 
/*     */   public JsBridge(Context paramContext, IJsCallback paramIJsCallback)
/*     */   {
/*  24 */     this.b = paramContext;
/*  25 */     this.a = paramIJsCallback;
/*     */   }
/*     */ 
/*     */   public final void a(String paramString) {
/*  29 */     Object localObject1 = null;
/*  30 */     String str = null;
/*     */     try
/*     */     {
/*  34 */       if (TextUtils.isEmpty(str = (
/*  33 */         localObject1 = new JSONObject(paramString))
/*  33 */         .getString("clientId")))
/*     */       {
/*  35 */         return;
/*     */       }
/*  37 */       paramString = null;
/*     */ 
/*  39 */       if (((
/*  39 */         localObject2 = ((JSONObject)localObject1).getJSONObject("param")) instanceof JSONObject))
/*     */       {
/*  40 */         paramString = (JSONObject)localObject2;
/*     */       }
/*     */ 
/*  54 */       Object localObject2 = ((JSONObject)localObject1).getString("func");
/*  55 */       localObject1 = ((JSONObject)localObject1).getString("bundleName");
/*     */       CallInfo localCallInfo;
/*  56 */       (
/*  57 */         localCallInfo = new CallInfo("call"))
/*  57 */         .b((String)localObject1);
/*  58 */       localCallInfo.c((String)localObject2);
/*  59 */       localCallInfo.a(paramString);
/*  60 */       localCallInfo.a(str);
/*  61 */       localObject1 = localCallInfo; paramString = this; if (TextUtils.isEmpty(((CallInfo)localObject1).b())) { paramString.a(((CallInfo)localObject1).a(), CallInfo.CallError.c); return; } localObject1 = new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/*     */           CallInfo.CallError localCallError;
/*  92 */           if ((
/*  92 */             localCallError = JsBridge.a(JsBridge.this, this.a)) != 
/*  92 */             CallInfo.CallError.a) try { JsBridge.a(JsBridge.this, this.a.a(), localCallError);
/*     */               return;
/*     */             }
/*     */             catch (JSONException localJSONException) {
/*  97 */               localJSONException.printStackTrace();
/*     */             }
/*     */         }
/*     */       };
/*  61 */       if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : 0) != 0) { ((Runnable)localObject1).run(); return;
/*     */       }
/*     */ 
/*  61 */       new Handler(Looper.getMainLooper()).post((Runnable)localObject1);
/*     */       return;
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*  73 */       localException.printStackTrace();
/*     */ 
/*  65 */       if (!TextUtils.isEmpty(str)) try { a(str, CallInfo.CallError.d);
/*     */           return;
/*     */         }
/*     */         catch (JSONException localJSONException) {
/*  70 */           localJSONException.printStackTrace();
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void a(CallInfo paramCallInfo)
/*     */     throws JSONException
/*     */   {
/*  77 */     if (paramCallInfo == null) {
/*  78 */       return;
/*     */     }
/*     */ 
/*  82 */     if (TextUtils.isEmpty(paramCallInfo.b()))
/*     */     {
/*  83 */       a(paramCallInfo.a(), CallInfo.CallError.c);
/*     */ 
/*  85 */       return;
/*     */     }
/*     */ 
/* 101 */     paramCallInfo = new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         CallInfo.CallError localCallError;
/*  92 */         if ((
/*  92 */           localCallError = JsBridge.a(JsBridge.this, this.a)) != 
/*  92 */           CallInfo.CallError.a) try { JsBridge.a(JsBridge.this, this.a.a(), localCallError);
/*     */             return;
/*     */           }
/*     */           catch (JSONException localJSONException) {
/*  97 */             localJSONException.printStackTrace();
/*     */           }
/*     */       }
/*     */     };
/* 101 */     if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : 0) != 0) { paramCallInfo.run(); return; } new Handler(Looper.getMainLooper()).post(paramCallInfo);
/*     */   }
/*     */ 
/*     */   private void a(String paramString, CallInfo.CallError paramCallError) throws JSONException
/*     */   {
/* 106 */     if (TextUtils.isEmpty(paramString))
/*     */       return;
/*     */     JSONObject localJSONObject;
/* 109 */     (
/* 110 */       localJSONObject = new JSONObject())
/* 110 */       .put("error", paramCallError.ordinal());
/* 111 */     (
/* 112 */       paramCallError = new CallInfo("callback"))
/* 112 */       .a(localJSONObject);
/* 113 */     paramCallError.a(paramString);
/* 114 */     this.a.a(paramCallError);
/*     */   }
/*     */ 
/*     */   private static void a(Runnable paramRunnable)
/*     */   {
/* 122 */     if (paramRunnable == null) {
/* 123 */       return;
/*     */     }
/*     */ 
/* 126 */     if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : 0) != 0)
/*     */     {
/* 127 */       paramRunnable.run(); return;
/*     */     }
/* 129 */     new Handler(Looper.getMainLooper())
/* 130 */       .post(paramRunnable);
/*     */   }
/*     */ 
/*     */   private CallInfo.CallError b(CallInfo paramCallInfo)
/*     */   {
/* 135 */     if ((paramCallInfo != null) && ("toast".equals(paramCallInfo.b()))) {
/* 136 */       final CallInfo localCallInfo = paramCallInfo; paramCallInfo = this;
/*     */       JSONObject localJSONObject;
/* 136 */       String str = (localJSONObject = localCallInfo.c()).optString("content"); int i = localJSONObject.optInt("duration"); int j = 1; if (i < 2500) j = 0; Toast.makeText(paramCallInfo.b, str, j).show(); new Timer().schedule(new TimerTask()
/*     */       {
/*     */         public void run()
/*     */         {
/* 159 */           JSONObject localJSONObject = new JSONObject();
/*     */           try {
/* 161 */             localJSONObject.put("toastCallBack", "true");
/*     */           }
/*     */           catch (JSONException localJSONException) {
/* 164 */             localJSONException.printStackTrace();
/*     */           }
/*     */           CallInfo localCallInfo;
/* 165 */           (
/* 166 */             localCallInfo = new CallInfo("callback"))
/* 166 */             .a(localCallInfo.a());
/* 167 */           localCallInfo.a(localJSONObject);
/* 168 */           JsBridge.a(JsBridge.this).a(localCallInfo);
/*     */         }
/*     */       }
/*     */       , j);
/*     */     }
/* 138 */     return CallInfo.CallError.a;
/*     */   }
/*     */ 
/*     */   private void c(CallInfo paramCallInfo)
/*     */   {
/*     */     JSONObject localJSONObject;
/* 143 */     String str = (
/* 143 */       localJSONObject = paramCallInfo.c())
/* 143 */       .optString("content");
/*     */ 
/* 145 */     int i = localJSONObject.optInt("duration");
/*     */ 
/* 149 */     int j = 1;
/* 150 */     if (i < 2500) {
/* 151 */       j = 0;
/*     */     }
/* 153 */     Toast.makeText(this.b, str, j).show();
/*     */ 
/* 155 */     new Timer()
/* 156 */       .schedule(new TimerTask()
/*     */     {
/*     */       public void run() {
/* 159 */         JSONObject localJSONObject = new JSONObject();
/*     */         try {
/* 161 */           localJSONObject.put("toastCallBack", "true");
/*     */         }
/*     */         catch (JSONException localJSONException) {
/* 164 */           localJSONException.printStackTrace();
/*     */         }
/*     */         CallInfo localCallInfo;
/* 165 */         (
/* 166 */           localCallInfo = new CallInfo("callback"))
/* 166 */           .a(localCallInfo.a());
/* 167 */         localCallInfo.a(localJSONObject);
/* 168 */         JsBridge.a(JsBridge.this).a(localCallInfo);
/*     */       }
/*     */     }
/*     */     , j);
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.authjs.JsBridge
 * JD-Core Version:    0.6.2
 */