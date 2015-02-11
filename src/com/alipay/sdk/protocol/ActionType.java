/*     */ package com.alipay.sdk.protocol;
/*     */ 
/*     */ import android.text.TextUtils;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public enum ActionType
/*     */ {
/*     */   private String h;
/*     */   private String i;
/*     */   private String j;
/*     */   private JSONObject k;
/*     */   private String l;
/*     */   private String m;
/*     */   private String n;
/*     */   private boolean o;
/*     */   private boolean p;
/*     */   private boolean q;
/*     */   private String r;
/*     */   private String s;
/*     */   private String t;
/*     */   private JSONObject u;
/*     */ 
/*     */   private ActionType(String arg3)
/*     */   {
/*     */     Object localObject;
/*  43 */     this.h = localObject;
/*     */   }
/*     */ 
/*     */   public final JSONObject a() {
/*  47 */     return this.u;
/*     */   }
/*     */ 
/*     */   public final String b() {
/*  51 */     return this.t;
/*     */   }
/*     */ 
/*     */   public final String c() {
/*  55 */     return this.r;
/*     */   }
/*     */ 
/*     */   public final String d() {
/*  59 */     return this.s;
/*     */   }
/*     */ 
/*     */   public final String e() {
/*  63 */     return this.i;
/*     */   }
/*     */ 
/*     */   public final String f() {
/*  67 */     return this.j;
/*     */   }
/*     */ 
/*     */   private JSONObject m() {
/*  71 */     return this.k;
/*     */   }
/*     */ 
/*     */   public final String g() {
/*  75 */     return this.m;
/*     */   }
/*     */ 
/*     */   public final String h() {
/*  79 */     return this.n;
/*     */   }
/*     */ 
/*     */   public final boolean i() {
/*  83 */     return this.o;
/*     */   }
/*     */ 
/*     */   public final boolean j() {
/*  87 */     return this.p;
/*     */   }
/*     */ 
/*     */   public final boolean k() {
/*  91 */     return this.q;
/*     */   }
/*     */ 
/*     */   public final String l() {
/*  95 */     return this.l;
/*     */   }
/*     */ 
/*     */   private static String[] a(String paramString) {
/*  99 */     String[] arrayOfString = null;
/* 100 */     if (!TextUtils.isEmpty(paramString)) {
/* 101 */       arrayOfString = paramString.split(";");
/*     */     }
/* 103 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */   public static ActionType[] a(ElementAction paramElementAction)
/*     */   {
/*     */     Object localObject1;
/* 107 */     if (paramElementAction != null)
/*     */     {
/* 109 */       localObject1 = paramElementAction.e(); String[] arrayOfString = null; if (!TextUtils.isEmpty((CharSequence)localObject1)) arrayOfString = ((String)localObject1).split(";");
/* 110 */       if ((
/* 110 */         arrayOfString = arrayOfString) == null)
/*     */       {
/* 111 */         (
/* 112 */           localObject1 = new ActionType[1])[
/* 112 */           0] = c;
/* 113 */         return localObject1;
/*     */       }
/* 115 */       localObject1 = new ActionType[arrayOfString.length];
/* 116 */       int i1 = 0;
/* 117 */       for (String str : arrayOfString) {
/* 118 */         Object localObject2 = c;
/* 119 */         for (ActionType localActionType : values()) {
/* 120 */           if (str.startsWith(localActionType.h)) {
/* 121 */             localObject2 = localActionType;
/* 122 */             break;
/*     */           }
/*     */         }
/*     */ 
/* 126 */         ((ActionType)localObject2).i = str;
/* 127 */         ((ActionType)localObject2).j = paramElementAction.f();
/* 128 */         ((ActionType)localObject2).k = paramElementAction.h();
/* 129 */         ((ActionType)localObject2).l = paramElementAction.g();
/* 130 */         ((ActionType)localObject2).m = paramElementAction.i();
/* 131 */         ((ActionType)localObject2).n = paramElementAction.j();
/* 132 */         ((ActionType)localObject2).o = paramElementAction.k();
/* 133 */         ((ActionType)localObject2).p = paramElementAction.l();
/* 134 */         ((ActionType)localObject2).q = paramElementAction.m();
/* 135 */         ((ActionType)localObject2).r = paramElementAction.c();
/* 136 */         ((ActionType)localObject2).s = paramElementAction.d();
/* 137 */         ((ActionType)localObject2).t = paramElementAction.b();
/* 138 */         ((ActionType)localObject2).u = paramElementAction.a();
/* 139 */         localObject1[i1] = localObject2;
/* 140 */         i1++;
/*     */       }
/*     */     } else {
/* 143 */       (
/* 144 */         localObject1 = new ActionType[1])[
/* 144 */         0] = c;
/*     */     }
/* 146 */     return localObject1;
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.ActionType
 * JD-Core Version:    0.6.2
 */