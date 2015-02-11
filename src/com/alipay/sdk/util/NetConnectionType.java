/*    */ package com.alipay.sdk.util;
/*    */ 
/*    */ public enum NetConnectionType
/*    */ {
/*    */   private int p;
/*    */   private String q;
/*    */ 
/*    */   private NetConnectionType(int arg3, String arg4)
/*    */   {
/*    */     int i1;
/* 51 */     this.p = i1;
/*    */     Object localObject;
/* 52 */     this.q = localObject;
/*    */   }
/*    */ 
/*    */   private int b() {
/* 56 */     return this.p;
/*    */   }
/*    */ 
/*    */   public final String a() {
/* 60 */     return this.q;
/*    */   }
/*    */ 
/*    */   private void a(String paramString) {
/* 64 */     this.q = paramString;
/*    */   }
/*    */ 
/*    */   public static NetConnectionType a(int paramInt)
/*    */   {
/*    */     NetConnectionType[] arrayOfNetConnectionType;
/* 69 */     int i1 = (arrayOfNetConnectionType = values()).length;
/* 69 */     for (int i2 = 0; i2 < i1; i2++)
/*    */     {
/*    */       NetConnectionType localNetConnectionType;
/* 70 */       if ((
/* 70 */         localNetConnectionType = arrayOfNetConnectionType[i2]).p == 
/* 70 */         paramInt) {
/* 71 */         return localNetConnectionType;
/*    */       }
/*    */     }
/* 74 */     return o;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.NetConnectionType
 * JD-Core Version:    0.6.2
 */