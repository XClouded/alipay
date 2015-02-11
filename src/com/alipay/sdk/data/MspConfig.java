/*     */ package com.alipay.sdk.data;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.net.wifi.WifiInfo;
/*     */ import android.net.wifi.WifiManager;
/*     */ import android.os.Build;
/*     */ import android.preference.PreferenceManager;
/*     */ import android.text.TextUtils;
/*     */ import android.widget.TextView;
/*     */ import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
/*     */ import com.alipay.sdk.sys.GlobalContext;
/*     */ import com.alipay.sdk.sys.UserLocation;
/*     */ import com.alipay.sdk.tid.TidInfo;
/*     */ import com.alipay.sdk.util.DeviceInfo;
/*     */ import com.alipay.sdk.util.NetConnectionType;
/*     */ import com.alipay.sdk.util.Utils;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class MspConfig
/*     */ {
/*     */   private static final String a = "virtualImeiAndImsi";
/*     */   private static final String b = "virtual_imei";
/*     */   private static final String c = "virtual_imsi";
/*     */   private static MspConfig d;
/*     */   private String e;
/*     */   private String f;
/*     */   private String g;
/*     */ 
/*     */   private String b()
/*     */   {
/*  39 */     return this.g;
/*     */   }
/*     */ 
/*     */   private MspConfig() {
/*  43 */     this.f = "sdk-and-lite";
/*     */   }
/*     */ 
/*     */   public static synchronized MspConfig a() {
/*  47 */     if (d == null) {
/*  48 */       d = new MspConfig();
/*     */     }
/*  50 */     return d;
/*     */   }
/*     */ 
/*     */   public final synchronized void a(String paramString) {
/*  54 */     if (TextUtils.isEmpty(paramString)) {
/*  55 */       return;
/*     */     }
/*     */ 
/*  58 */     PreferenceManager.getDefaultSharedPreferences(GlobalContext.a().b())
/*  60 */       .edit().putString("trideskey", paramString).commit();
/*  61 */     com.alipay.sdk.cons.GlobalConstants.d = paramString;
/*     */   }
/*     */ 
/*     */   private static String c() {
/*  65 */     return "1";
/*     */   }
/*     */ 
/*     */   private static String a(Context paramContext)
/*     */   {
/*  70 */     return Float.toString(new TextView(paramContext).getTextSize());
/*     */   }
/*     */ 
/*     */   public final String a(TidInfo paramTidInfo)
/*     */   {
/*     */     Context localContext;
/*  75 */     Object localObject1 = DeviceInfo.a(localContext = GlobalContext.a().b());
/*     */ 
/*  78 */     if (TextUtils.isEmpty(this.e)) {
/*  79 */       str1 = "Msp/9.1.8";
/*     */ 
/*  82 */       str2 = Utils.a();
/*     */ 
/*  85 */       str3 = Utils.b();
/*     */ 
/*  88 */       str4 = Utils.d(localContext);
/*     */ 
/*  91 */       str5 = Utils.c();
/*     */ 
/*  94 */       localObject2 = Utils.e(localContext);
/*     */ 
/*  97 */       localObject5 = localContext; localObject3 = Float.toString(new TextView((Context)localObject5).getTextSize());
/*     */ 
/* 102 */       localObject4 = new StringBuilder();
/* 103 */       this.e = (str1 + " (" + str2 + ";" + str3 + ";" + str4 + ";" + str5 + ";" + (String)localObject2 + ";" + (String)localObject3);
/*     */     }
/*     */ 
/* 110 */     String str1 = DeviceInfo.b(localContext).a();
/*     */ 
/* 113 */     String str2 = Utils.f(localContext);
/*     */ 
/* 116 */     String str3 = "1";
/*     */ 
/* 119 */     String str4 = ((DeviceInfo)localObject1).a();
/*     */ 
/* 122 */     String str5 = ((DeviceInfo)localObject1).b();
/*     */     Object localObject6;
/* 124 */     if (TextUtils.isEmpty(localObject6 = (localObject5 = (localObject3 = GlobalContext.a().b()).getSharedPreferences("virtualImeiAndImsi", 0)).getString("virtual_imsi", null))) { if (TextUtils.isEmpty(TidInfo.c().a())) { if (TextUtils.isEmpty(localObject2 = GlobalContext.a().g())) localObject6 = f(); else localObject6 = ((String)localObject2).substring(3, 18);  } else localObject6 = DeviceInfo.a((Context)localObject3).a(); ((SharedPreferences)localObject5).edit().putString("virtual_imsi", (String)localObject6).commit(); } Object localObject2 = localObject6;
/*     */ 
/* 126 */     if (TextUtils.isEmpty(localObject6 = (localObject5 = (localObject3 = GlobalContext.a().b()).getSharedPreferences("virtualImeiAndImsi", 0)).getString("virtual_imei", null))) { if (TextUtils.isEmpty(TidInfo.c().a())) localObject6 = f(); else localObject6 = DeviceInfo.a((Context)localObject3).b(); ((SharedPreferences)localObject5).edit().putString("virtual_imei", (String)localObject6).commit(); } Object localObject3 = localObject6;
/*     */ 
/* 129 */     if (paramTidInfo != null) {
/* 130 */       this.g = paramTidInfo.b();
/*     */     }
/*     */ 
/* 136 */     Object localObject4 = Build.MANUFACTURER.replace(";", " ");
/*     */ 
/* 139 */     String str6 = Build.MODEL.replace(";", " ");
/*     */ 
/* 142 */     boolean bool = GlobalContext.e();
/*     */ 
/* 144 */     localObject1 = ((DeviceInfo)localObject1).c();
/*     */ 
/* 146 */     String str7 = (localObject6 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo()) != null ? ((WifiInfo)localObject6).getSSID() : "-1";
/* 147 */     Object localObject5 = (localObject6 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo()) != null ? ((WifiInfo)localObject6).getBSSID() : "00";
/*     */ 
/* 149 */     (
/* 151 */       localObject6 = new StringBuilder())
/* 151 */       .append(this.e).append(";").append(str1).append(";").append(str2).append(";").append(str3).append(";").append(str4).append(";").append(str5).append(";").append(this.g).append(";").append((String)localObject4).append(";").append(str6).append(";").append(bool).append(";").append((String)localObject1).append(";").append(UserLocation.a()).append(";").append(this.f).append(";").append((String)localObject2).append(";").append((String)localObject3).append(";").append(str7).append(";").append((String)localObject5);
/*     */ 
/* 162 */     if (paramTidInfo != null) {
/* 163 */       (
/* 164 */         localObject1 = new HashMap())
/* 164 */         .put("tid", paramTidInfo.a());
/* 165 */       ((HashMap)localObject1).put("utdid", GlobalContext.a().g());
/*     */ 
/* 167 */       if (!TextUtils.isEmpty(paramTidInfo = SecurityClientMobile.GetApdid(localContext, (Map)localObject1)))
/*     */       {
/* 168 */         ((StringBuilder)localObject6).append(";").append(paramTidInfo);
/*     */       }
/*     */     }
/* 171 */     ((StringBuilder)localObject6).append(")");
/*     */ 
/* 173 */     return ((StringBuilder)localObject6).toString();
/*     */   }
/*     */ 
/*     */   private static String d()
/*     */   {
/*     */     Context localContext;
/*     */     SharedPreferences localSharedPreferences;
/*     */     String str;
/* 182 */     if (TextUtils.isEmpty(str = (
/* 180 */       localSharedPreferences = (
/* 178 */       localContext = GlobalContext.a().b())
/* 178 */       .getSharedPreferences("virtualImeiAndImsi", 0))
/* 180 */       .getString("virtual_imei", null)))
/*     */     {
/* 183 */       if (TextUtils.isEmpty(TidInfo.c().a()))
/* 184 */         str = f();
/*     */       else {
/* 186 */         str = DeviceInfo.a(localContext).b();
/*     */       }
/* 188 */       localSharedPreferences.edit().putString("virtual_imei", str).commit();
/*     */     }
/*     */ 
/* 191 */     return str;
/*     */   }
/*     */ 
/*     */   private static String e()
/*     */   {
/*     */     Object localObject;
/*     */     SharedPreferences localSharedPreferences;
/*     */     String str;
/* 200 */     if (TextUtils.isEmpty(str = (
/* 198 */       localSharedPreferences = (
/* 196 */       localObject = GlobalContext.a().b())
/* 196 */       .getSharedPreferences("virtualImeiAndImsi", 0))
/* 198 */       .getString("virtual_imsi", null)))
/*     */     {
/* 201 */       if (TextUtils.isEmpty(TidInfo.c().a()))
/*     */       {
/* 203 */         if (TextUtils.isEmpty(localObject = GlobalContext.a().g()))
/*     */         {
/* 204 */           str = f();
/*     */         }
/* 206 */         else str = ((String)localObject).substring(3, 18);
/*     */       }
/*     */       else {
/* 209 */         str = DeviceInfo.a((Context)localObject).a();
/*     */       }
/* 211 */       localSharedPreferences.edit().putString("virtual_imsi", str).commit();
/*     */     }
/*     */ 
/* 215 */     return str;
/*     */   }
/*     */ 
/*     */   private static String f()
/*     */   {
/* 220 */     String str = Long.toHexString(System.currentTimeMillis());
/*     */ 
/* 221 */     Random localRandom = new Random();
/*     */ 
/* 223 */     return str + (1000 + localRandom.nextInt(9000));
/*     */   }
/*     */ 
/*     */   private static String b(Context paramContext)
/*     */   {
/* 230 */     if ((
/* 230 */       paramContext = ((WifiManager)paramContext.getSystemService("wifi"))
/* 229 */       .getConnectionInfo()) != null)
/*     */     {
/* 231 */       return paramContext.getSSID();
/* 232 */     }return "-1";
/*     */   }
/*     */ 
/*     */   private static String c(Context paramContext)
/*     */   {
/* 239 */     if ((
/* 239 */       paramContext = ((WifiManager)paramContext.getSystemService("wifi"))
/* 238 */       .getConnectionInfo()) != null)
/*     */     {
/* 240 */       return paramContext.getBSSID();
/* 241 */     }return "00";
/*     */   }
/*     */ 
/*     */   private static String a(Context paramContext, HashMap paramHashMap)
/*     */   {
/* 246 */     return SecurityClientMobile.GetApdid(paramContext, paramHashMap);
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.data.MspConfig
 * JD-Core Version:    0.6.2
 */