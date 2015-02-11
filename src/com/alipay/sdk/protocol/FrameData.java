/*    */ package com.alipay.sdk.protocol;
/*    */ 
/*    */ import com.alipay.sdk.data.Request;
/*    */ import com.alipay.sdk.data.Response;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ public class FrameData
/*    */ {
/*    */   private Request a;
/*    */   private Response b;
/*    */   private JSONObject c;
/*    */ 
/*    */   public FrameData(Request paramRequest, Response paramResponse)
/*    */   {
/* 22 */     this.a = paramRequest;
/* 23 */     this.b = paramResponse;
/*    */   }
/*    */ 
/*    */   public final Request a() {
/* 27 */     return this.a;
/*    */   }
/*    */ 
/*    */   public final Response b() {
/* 31 */     return this.b;
/*    */   }
/*    */ 
/*    */   public final JSONObject c()
/*    */   {
/* 38 */     return this.c;
/*    */   }
/*    */ 
/*    */   public void a(JSONObject paramJSONObject) {
/* 42 */     this.c = paramJSONObject;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.protocol.FrameData
 * JD-Core Version:    0.6.2
 */