/*    */ package com.alipay.sdk.auth;
/*    */ 
/*    */ public class APAuthInfo
/*    */ {
/*    */   private String a;
/*    */   private String b;
/*    */   private String c;
/*    */   private String d;
/*    */ 
/*    */   public APAuthInfo(String paramString1, String paramString2, String paramString3)
/*    */   {
/* 18 */     this(paramString1, paramString2, paramString3, null);
/*    */   }
/*    */ 
/*    */   public APAuthInfo(String paramString1, String paramString2, String paramString3, String paramString4)
/*    */   {
/* 23 */     this.a = paramString1;
/* 24 */     this.b = paramString2;
/* 25 */     this.d = paramString3;
/* 26 */     this.c = paramString4;
/*    */   }
/*    */ 
/*    */   public String getAppId() {
/* 30 */     return this.a;
/*    */   }
/*    */ 
/*    */   public String getProductId() {
/* 34 */     return this.b;
/*    */   }
/*    */ 
/*    */   public String getPid() {
/* 38 */     return this.c;
/*    */   }
/*    */ 
/*    */   public String getRedirectUri() {
/* 42 */     return this.d;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.auth.APAuthInfo
 * JD-Core Version:    0.6.2
 */