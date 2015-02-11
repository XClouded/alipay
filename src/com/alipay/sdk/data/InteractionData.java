/*    */ package com.alipay.sdk.data;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.message.BasicHeader;
/*    */ 
/*    */ public class InteractionData
/*    */ {
/*    */   public static final String a = "application/octet-stream;binary/octet-stream";
/* 20 */   private Header[] b = null;
/*    */ 
/* 22 */   private String c = null;
/*    */ 
/* 24 */   private String d = null;
/*    */ 
/*    */   public final void a(Header[] paramArrayOfHeader)
/*    */   {
/* 32 */     this.b = paramArrayOfHeader;
/*    */   }
/*    */ 
/*    */   private Header[] d()
/*    */   {
/* 42 */     return this.b;
/*    */   }
/*    */ 
/*    */   public final ArrayList a() {
/* 46 */     if ((this.b == null) || (this.b.length == 0)) {
/* 47 */       return null;
/*    */     }
/*    */ 
/* 50 */     ArrayList localArrayList = new ArrayList();
/* 51 */     for (Header localHeader : this.b) {
/* 52 */       localArrayList.add(new BasicHeader(localHeader.getName(), localHeader.getValue()));
/*    */     }
/*    */ 
/* 56 */     return localArrayList;
/*    */   }
/*    */ 
/*    */   public final String b() {
/* 60 */     return this.c;
/*    */   }
/*    */ 
/*    */   private void a(String paramString) {
/* 64 */     this.c = paramString;
/*    */   }
/*    */ 
/*    */   public final String c() {
/* 68 */     return this.d;
/*    */   }
/*    */ 
/*    */   private void b(String paramString) {
/* 72 */     this.d = paramString;
/*    */   }
/*    */ 
/*    */   private void e()
/*    */   {
/* 77 */     this.d = null;
/* 78 */     this.c = null;
/*    */   }
/*    */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.data.InteractionData
 * JD-Core Version:    0.6.2
 */