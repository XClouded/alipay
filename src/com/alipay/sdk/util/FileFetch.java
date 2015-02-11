/*     */ package com.alipay.sdk.util;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.SocketTimeoutException;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.methods.HttpGet;
/*     */ import org.apache.http.impl.client.DefaultHttpClient;
/*     */ 
/*     */ final class FileFetch
/*     */   implements Runnable
/*     */ {
/*     */   private String a;
/*     */   private String b;
/*     */   private FileDownloader c;
/*  30 */   private boolean d = false;
/*     */   private long e;
/*     */   private long f;
/*     */ 
/*     */   public FileFetch(String paramString1, String paramString2, FileDownloader paramFileDownloader)
/*     */   {
/*  35 */     this.a = paramString1;
/*  36 */     this.b = paramString2;
/*  37 */     this.c = paramFileDownloader;
/*     */   }
/*     */ 
/*     */   public final void run() {
/*  41 */     if ((this.c.a()) && (
/*  42 */       (this.f <= 0L) || (this.e >= this.f))) {
/*  43 */       this.d = true;
/*  44 */       return;
/*     */     }
/*     */ 
/*  47 */     FileAccess localFileAccess = new FileAccess();
/*     */ 
/*  49 */     while (!this.d) {
/*  50 */       InputStream localInputStream = null;
/*  51 */       int j = 0;
/*     */       try {
/*     */         Object localObject3;
/*     */         try { localHttpGet = new HttpGet(this.a);
/*     */ 
/*  56 */           localObject3 = new DefaultHttpClient();
/*     */           Object localObject1;
/*  57 */           if (this.c.a()) {
/*  58 */             localObject1 = "bytes=" + this.e + "-" + this.f;
/*     */ 
/*  60 */             localHttpGet.addHeader("Range", (String)localObject1);
/*     */           }
/*     */ 
/*  65 */           switch (
/*  66 */             j = (
/*  65 */             localObject1 = ((HttpClient)localObject3).execute(localHttpGet))
/*  65 */             .getStatusLine().getStatusCode())
/*     */           {
/*     */           case 200:
/*     */           case 201:
/*     */           case 202:
/*     */           case 203:
/*     */           case 204:
/*     */           case 205:
/*     */           case 206:
/*     */           case 207:
/*  75 */             localInputStream = ((HttpResponse)localObject1).getEntity().getContent();
/*  76 */             break;
/*     */           default:
/*  78 */             this.d = true;
/*     */           }
/*     */ 
/*  81 */           if (!this.d);
/*     */         } catch (IOException localIOException1)
/*     */         {
/*  84 */           HttpGet localHttpGet = null;
/*     */ 
/*  87 */           localIOException1.printStackTrace();
/*     */ 
/*  86 */           this.d = true;
/*     */         }
/*  88 */         if (localInputStream == null)
/*     */         {
/* 113 */           if (localInputStream != null)
/*     */             try {
/* 115 */               localInputStream.close();
/*     */             }
/*     */             catch (Exception localException2)
/*     */             {
/*     */             }
/*     */         }
/*     */         else
/*     */         {
/*  92 */           localObject3 = new byte[1024];
/*     */           int k;
/*     */           int i;
/*     */           do
/*     */           {
/*  95 */             if ((
/*  95 */               k = localInputStream.read((byte[])localObject3, 0, localObject3.length)) != 
/*  95 */               -1) {
/*  96 */               this.e += localFileAccess.a((byte[])localObject3, k);
/*  97 */               this.c.d();
/*     */             }
/*  99 */             i = (this.c.a()) && (this.e >= this.f) ? 0 : 1;
/*     */ 
/* 101 */             i = (!this.d) && (i != 0) ? 1 : 0;
/* 102 */           }while ((k >= 0) && (i != 0));
/* 103 */           this.d = true;
/*     */ 
/* 113 */           if (localInputStream != null)
/*     */             try {
/* 115 */               localInputStream.close();
/*     */             }
/*     */             catch (Exception localException3)
/*     */             {
/*     */             }
/*     */         }
/*     */       }
/*     */       catch (SocketTimeoutException localSocketTimeoutException)
/*     */       {
/* 105 */         if (j == 0) {
/* 106 */           this.d = true;
/*     */         }
/*     */ 
/* 113 */         if (localInputStream != null)
/*     */           try {
/* 115 */             localInputStream.close();
/*     */           }
/*     */           catch (Exception localException4)
/*     */           {
/*     */           }
/*     */       }
/*     */       catch (IOException localIOException2)
/*     */       {
/* 109 */         this.d = true;
/*     */ 
/* 113 */         if (localInputStream != null)
/*     */           try {
/* 115 */             localInputStream.close();
/*     */           }
/*     */           catch (Exception localException5)
/*     */           {
/*     */           }
/*     */       }
/*     */       catch (Exception localException6)
/*     */       {
/* 111 */         this.d = true;
/*     */ 
/* 113 */         if (localInputStream != null)
/*     */           try {
/* 115 */             localInputStream.close();
/*     */           }
/*     */           catch (Exception localException7)
/*     */           {
/*     */           }
/*     */       }
/*     */       finally
/*     */       {
/* 113 */         if (localInputStream != null)
/*     */           try {
/* 115 */             localInputStream.close();
/*     */           } catch (Exception localException8) {
/*     */           }
/*     */       }
/*     */     }
/* 120 */     localFileAccess.a();
/*     */   }
/*     */ 
/*     */   public final long a() {
/* 124 */     return this.e;
/*     */   }
/*     */ 
/*     */   public final void a(long paramLong) {
/* 128 */     this.e = paramLong;
/*     */   }
/*     */ 
/*     */   public final long b() {
/* 132 */     return this.f;
/*     */   }
/*     */ 
/*     */   public final void b(long paramLong) {
/* 136 */     this.f = paramLong;
/*     */   }
/*     */ 
/*     */   public final boolean c() {
/* 140 */     return this.d;
/*     */   }
/*     */ 
/*     */   public final void d() {
/* 144 */     this.d = true;
/*     */   }
/*     */ 
/*     */   final class FileAccess
/*     */   {
/*     */     private FileOutputStream b;
/*     */ 
/*     */     public FileAccess()
/*     */     {
/*     */       try
/*     */       {
/* 159 */         this.b = new FileOutputStream(FileFetch.a(FileFetch.this), true);
/*     */         return;
/*     */       }
/*     */       catch (FileNotFoundException localFileNotFoundException)
/*     */       {
/* 163 */         localFileNotFoundException.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/*     */     public final synchronized int a(byte[] paramArrayOfByte, int paramInt)
/*     */       throws IOException
/*     */     {
/* 168 */       this.b.write(paramArrayOfByte, 0, paramInt);
/* 169 */       return paramInt;
/*     */     }
/*     */ 
/*     */     public final void a() {
/*     */       try {
/* 174 */         this.b.close();
/*     */ 
/* 176 */         return;
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.FileFetch
 * JD-Core Version:    0.6.2
 */