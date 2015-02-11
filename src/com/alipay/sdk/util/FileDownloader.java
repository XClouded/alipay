/*     */ package com.alipay.sdk.util;
/*     */ 
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.lang.ref.WeakReference;
/*     */ import javax.net.ssl.SSLException;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.methods.HttpGet;
/*     */ import org.apache.http.impl.client.DefaultHttpClient;
/*     */ 
/*     */ public final class FileDownloader
/*     */ {
/*     */   private String b;
/*     */   private String c;
/*     */   private String d;
/*     */   private IDownloadProgress e;
/*     */   private FileFetch f;
/*     */   public boolean a;
/*     */ 
/*     */   public FileDownloader()
/*     */   {
/*  45 */     this.a = false;
/*     */   }
/*     */ 
/*     */   private FileDownloader(boolean paramBoolean) {
/*  49 */     this.a = paramBoolean;
/*     */   }
/*     */ 
/*     */   public final void a(String paramString)
/*     */   {
/*  57 */     this.b = paramString;
/*     */   }
/*     */ 
/*     */   private void a(boolean paramBoolean) {
/*  61 */     this.a = paramBoolean;
/*     */   }
/*     */ 
/*     */   protected final boolean a() {
/*  65 */     return this.a;
/*     */   }
/*     */ 
/*     */   public final void b(String paramString)
/*     */   {
/*  73 */     this.c = paramString;
/*  74 */     this.d = (paramString + ".tmp");
/*     */   }
/*     */ 
/*     */   public final void a(IDownloadProgress paramIDownloadProgress)
/*     */   {
/*  83 */     if (paramIDownloadProgress != null)
/*  84 */       this.e = paramIDownloadProgress;
/*     */   }
/*     */ 
/*     */   public final void b()
/*     */   {
/*  89 */     final ProgressOutput localProgressOutput = new ProgressOutput(Looper.getMainLooper(), this, (byte)0);
/*     */ 
/*  91 */     new Thread(new Runnable()
/*     */     {
/*     */       public void run() {
/*  94 */         FileDownloader.a(FileDownloader.this, new FileFetch(FileDownloader.a(FileDownloader.this), FileDownloader.b(FileDownloader.this), FileDownloader.this));
/*  95 */         long l = -1L;
/*  96 */         if (FileDownloader.this.a)
/*     */         {
/*  98 */           if ((
/*  98 */             l = FileDownloader.c(FileDownloader.this)) <= 
/*  98 */             0L) {
/*  99 */             localProgressOutput.sendEmptyMessage(0);
/*     */           }
/*     */         }
/*     */         else {
/* 103 */           FileDownloader.d(FileDownloader.this);
/*     */         }
/* 105 */         if (FileDownloader.this.a) {
/* 106 */           FileDownloader.e(FileDownloader.this);
/* 107 */           if (FileDownloader.f(FileDownloader.this).b() != l) {
/* 108 */             FileDownloader.d(FileDownloader.this);
/* 109 */             FileDownloader.f(FileDownloader.this).a(0L);
/* 110 */             FileDownloader.f(FileDownloader.this).b(l);
/*     */           }
/*     */         }
/* 113 */         new Thread(FileDownloader.f(FileDownloader.this)).start();
/* 114 */         FileDownloader.ProgressOutput.a(localProgressOutput);
/* 115 */         while (!FileDownloader.f(FileDownloader.this).c()) {
/*     */           try {
/* 117 */             Thread.sleep(1500L);
/*     */           }
/*     */           catch (InterruptedException localInterruptedException) {
/* 120 */             localInterruptedException.printStackTrace();
/*     */           }
/*     */ 
/* 121 */           localProgressOutput.sendEmptyMessage(0);
/*     */         }
/* 123 */         localProgressOutput.sendEmptyMessage(0);
/*     */       }
/*     */     }).start();
/*     */   }
/*     */ 
/*     */   public final void c()
/*     */   {
/* 130 */     this.f.d();
/*     */   }
/*     */ 
/*     */   private long e() {
/* 134 */     long l = -1L;
/*     */     try
/*     */     {
/* 137 */       l = c(this.b)
/* 137 */         .getContentLength();
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 142 */       localException.printStackTrace();
/*     */     }
/*     */ 
/* 143 */     return l;
/*     */   }
/*     */ 
/*     */   private void f()
/*     */   {
/*     */     File localFile;
/* 148 */     if ((
/* 148 */       localFile = new File(this.c))
/* 148 */       .exists()) {
/* 149 */       localFile.delete();
/*     */     }
/*     */ 
/* 152 */     if ((
/* 152 */       localFile = new File(this.d))
/* 152 */       .exists())
/* 153 */       localFile.delete();
/*     */   }
/*     */ 
/*     */   protected final void d()
/*     */   {
/* 158 */     FileOutputStream localFileOutputStream = null;
/* 159 */     ObjectOutputStream localObjectOutputStream = null;
/*     */     try {
/* 161 */       localFileOutputStream = new FileOutputStream(this.d);
/* 162 */       (
/* 163 */         localObjectOutputStream = new ObjectOutputStream(localFileOutputStream))
/* 163 */         .writeLong(this.f.a());
/* 164 */       localObjectOutputStream.writeLong(this.f.b());
/* 165 */       localObjectOutputStream.flush();
/*     */       try
/*     */       {
/* 170 */         localFileOutputStream.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 174 */         localObjectOutputStream.close();
/*     */       }
/*     */       catch (Exception localException2)
/*     */       {
/*     */       }
/*     */     }
/*     */     catch (Exception localException3)
/*     */     {
/*     */       try
/*     */       {
/* 170 */         localFileOutputStream.close();
/*     */       } catch (Exception localException4) {
/*     */       }
/*     */       try {
/* 174 */         localObjectOutputStream.close();
/*     */       }
/*     */       catch (Exception localException5)
/*     */       {
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 170 */         localFileOutputStream.close();
/*     */       } catch (Exception localException6) {
/*     */       }
/*     */       try {
/* 174 */         localObjectOutputStream.close();
/*     */       } catch (Exception localException7) {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void g() {
/* 181 */     FileInputStream localFileInputStream = null;
/* 182 */     ObjectInputStream localObjectInputStream = null;
/*     */     try {
/* 184 */       localFileInputStream = new FileInputStream(this.d);
/* 185 */       localObjectInputStream = new ObjectInputStream(localFileInputStream);
/* 186 */       this.f.a(localObjectInputStream.readLong());
/* 187 */       this.f.b(localObjectInputStream.readLong());
/*     */       try
/*     */       {
/* 192 */         localFileInputStream.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 196 */         localObjectInputStream.close();
/*     */       }
/*     */       catch (Exception localException2)
/*     */       {
/*     */       }
/*     */     }
/*     */     catch (Exception localException3)
/*     */     {
/*     */       try
/*     */       {
/* 192 */         localFileInputStream.close();
/*     */       } catch (Exception localException4) {
/*     */       }
/*     */       try {
/* 196 */         localObjectInputStream.close();
/*     */       }
/*     */       catch (Exception localException5)
/*     */       {
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 192 */         localFileInputStream.close();
/*     */       } catch (Exception localException6) {
/*     */       }
/*     */       try {
/* 196 */         localObjectInputStream.close();
/*     */       }
/*     */       catch (Exception localException7)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static HttpEntity c(String paramString) throws Exception {
/*     */     try {
/* 206 */       paramString = new HttpGet(paramString);
/*     */       int i;
/* 216 */       if ((
/* 216 */         i = (
/* 215 */         paramString = new DefaultHttpClient()
/* 209 */         .execute(paramString))
/* 215 */         .getStatusLine().getStatusCode()) == 
/* 216 */         200)
/*     */       {
/* 218 */         return paramString.getEntity();
/*     */       }
/*     */ 
/* 220 */       throw new Exception("net work exception,ErrorCode :" + i); } catch (SSLException localSSLException) { localSSLException
/* 222 */         .printStackTrace();
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 226 */       localException.printStackTrace();
/*     */     }
/*     */ 
/* 227 */     return null; } 
/*     */   public static abstract interface IDownloadProgress { public abstract void b();
/*     */ 
/*     */     public abstract void a();
/*     */ 
/*     */     public abstract void c(); } 
/*     */   private static class ProgressOutput extends Handler { private boolean b;
/*     */     WeakReference a;
/*     */ 
/* 236 */     private ProgressOutput(Looper paramLooper, FileDownloader paramFileDownloader) { super();
/* 237 */       this.b = false;
/* 238 */       this.a = new WeakReference(paramFileDownloader);
/*     */     }
/*     */ 
/*     */     public void handleMessage(Message paramMessage)
/*     */     {
/* 243 */       if (FileDownloader.g((FileDownloader)this.a.get()) == null)
/* 244 */         return;
/*     */       try
/*     */       {
/* 247 */         paramMessage = 50.0F;
/* 248 */         if (((FileDownloader)this.a.get()).a) {
/* 249 */           paramMessage = (float)(FileDownloader.f((FileDownloader)this.a.get()).a() * 100L / FileDownloader.f((FileDownloader)this.a.get()).b());
/*     */         }
/* 251 */         else if (FileDownloader.f((FileDownloader)this.a.get()).c()) {
/* 252 */           paramMessage = 100.0F;
/*     */         }
/*     */ 
/* 255 */         if (FileDownloader.f((FileDownloader)this.a.get()).c()) {
/* 256 */           if ((paramMessage == 100.0F) && (!this.b)) {
/* 257 */             FileDownloader.g((FileDownloader)this.a.get()).a();
/* 258 */             this.b = true; return;
/* 259 */           }if (paramMessage > 100.0F) {
/* 260 */             FileDownloader.d((FileDownloader)this.a.get());
/* 261 */             FileDownloader.g((FileDownloader)this.a.get()).c(); return;
/* 262 */           }if (!this.b)
/* 263 */             FileDownloader.g((FileDownloader)this.a.get()).c();
/*     */         }
/*     */         else {
/* 266 */           FileDownloader.g((FileDownloader)this.a.get()).b();
/*     */         }
/*     */         return;
/*     */       } catch (Exception localException) {
/* 270 */         FileDownloader.g((FileDownloader)this.a.get()).c();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.util.FileDownloader
 * JD-Core Version:    0.6.2
 */