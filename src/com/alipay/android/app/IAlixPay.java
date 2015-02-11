/*     */ package com.alipay.android.app;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public abstract interface IAlixPay extends IInterface
/*     */ {
/*     */   public abstract String Pay(String paramString)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract String test()
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract String prePay(String paramString)
/*     */     throws RemoteException;
/*     */ 
/*     */   public static abstract class Stub extends Binder
/*     */     implements IAlixPay
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
/*     */     static final int TRANSACTION_Pay = 1;
/*     */     static final int TRANSACTION_test = 2;
/*     */     static final int TRANSACTION_registerCallback = 3;
/*     */     static final int TRANSACTION_unregisterCallback = 4;
/*     */     static final int TRANSACTION_prePay = 5;
/*     */ 
/*     */     public Stub()
/*     */     {
/*  20 */       attachInterface(this, "com.alipay.android.app.IAlixPay");
/*     */     }
/*     */ 
/*     */     public static IAlixPay asInterface(IBinder paramIBinder)
/*     */     {
/*  28 */       if (paramIBinder == null)
/*  29 */         return null;
/*     */       IInterface localIInterface;
/*  32 */       if (((
/*  32 */         localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IAlixPay")) != null) && 
/*  32 */         ((localIInterface instanceof IAlixPay))) {
/*  33 */         return (IAlixPay)localIInterface;
/*     */       }
/*  35 */       return new a(paramIBinder);
/*     */     }
/*     */ 
/*     */     public IBinder asBinder() {
/*  39 */       return this;
/*     */     }
/*     */ 
/*     */     public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
/*  43 */       switch (paramInt1)
/*     */       {
/*     */       case 1598968902:
/*  47 */         paramParcel2.writeString("com.alipay.android.app.IAlixPay");
/*  48 */         return true;
/*     */       case 1:
/*  52 */         paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
/*     */ 
/*  54 */         paramInt1 = paramParcel1.readString();
/*  55 */         paramInt1 = Pay(paramInt1);
/*  56 */         paramParcel2.writeNoException();
/*  57 */         paramParcel2.writeString(paramInt1);
/*  58 */         return true;
/*     */       case 2:
/*  62 */         paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
/*  63 */         paramInt1 = test();
/*  64 */         paramParcel2.writeNoException();
/*  65 */         paramParcel2.writeString(paramInt1);
/*  66 */         return true;
/*     */       case 3:
/*  70 */         paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
/*     */ 
/*  72 */         paramInt1 = IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder());
/*  73 */         registerCallback(paramInt1);
/*  74 */         paramParcel2.writeNoException();
/*  75 */         return true;
/*     */       case 4:
/*  79 */         paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
/*     */ 
/*  81 */         paramInt1 = IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder());
/*  82 */         unregisterCallback(paramInt1);
/*  83 */         paramParcel2.writeNoException();
/*  84 */         return true;
/*     */       case 5:
/*  88 */         paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
/*     */ 
/*  90 */         paramInt1 = paramParcel1.readString();
/*  91 */         paramInt1 = prePay(paramInt1);
/*  92 */         paramParcel2.writeNoException();
/*  93 */         paramParcel2.writeString(paramInt1);
/*  94 */         return true;
/*     */       }
/*     */ 
/*  97 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */ 
/*     */     private static class a implements IAlixPay {
/*     */       private IBinder a;
/*     */ 
/*     */       a(IBinder paramIBinder) {
/* 104 */         this.a = paramIBinder;
/*     */       }
/*     */ 
/*     */       public final IBinder asBinder() {
/* 108 */         return this.a;
/*     */       }
/*     */ 
/*     */       private static String a() {
/* 112 */         return "com.alipay.android.app.IAlixPay";
/*     */       }
/*     */ 
/*     */       public final String Pay(String paramString)
/*     */         throws RemoteException
/*     */       {
/* 127 */         Parcel localParcel1 = Parcel.obtain();
/* 128 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try
/*     */         {
/* 131 */           localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
/* 132 */           localParcel1.writeString(paramString);
/* 133 */           this.a.transact(1, localParcel1, localParcel2, 0);
/* 134 */           localParcel2.readException();
/* 135 */           paramString = localParcel2.readString();
/*     */ 
/* 138 */           localParcel2.recycle();
/* 139 */           localParcel1.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 138 */           localParcel2.recycle();
/* 139 */           localParcel1.recycle();
/*     */         }
/* 141 */         return paramString;
/*     */       }
/*     */ 
/*     */       public final String test()
/*     */         throws RemoteException
/*     */       {
/* 152 */         Parcel localParcel1 = Parcel.obtain();
/* 153 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try
/*     */         {
/* 156 */           localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
/* 157 */           this.a.transact(2, localParcel1, localParcel2, 0);
/* 158 */           localParcel2.readException();
/* 159 */           String str1 = localParcel2.readString();
/*     */ 
/* 162 */           localParcel2.recycle();
/* 163 */           localParcel1.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 162 */           localParcel2.recycle();
/* 163 */           localParcel1.recycle();
/*     */         }
/* 165 */         return str2;
/*     */       }
/*     */ 
/*     */       public final void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
/*     */         throws RemoteException
/*     */       {
/* 174 */         Parcel localParcel1 = Parcel.obtain();
/* 175 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try { localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
/* 178 */           localParcel1.writeStrongBinder(paramIRemoteServiceCallback != null ? paramIRemoteServiceCallback.asBinder() : null);
/* 179 */           this.a.transact(3, localParcel1, localParcel2, 0);
/* 180 */           localParcel2.readException();
/*     */           return; } finally { localParcel2.recycle();
/* 184 */           localParcel1.recycle(); } throw paramIRemoteServiceCallback;
/*     */       }
/*     */ 
/*     */       public final void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
/*     */         throws RemoteException
/*     */       {
/* 192 */         Parcel localParcel1 = Parcel.obtain();
/* 193 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try { localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
/* 196 */           localParcel1.writeStrongBinder(paramIRemoteServiceCallback != null ? paramIRemoteServiceCallback.asBinder() : null);
/* 197 */           this.a.transact(4, localParcel1, localParcel2, 0);
/* 198 */           localParcel2.readException();
/*     */           return; } finally { localParcel2.recycle();
/* 202 */           localParcel1.recycle(); } throw paramIRemoteServiceCallback;
/*     */       }
/*     */ 
/*     */       public final String prePay(String paramString)
/*     */         throws RemoteException
/*     */       {
/* 218 */         Parcel localParcel1 = Parcel.obtain();
/* 219 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try
/*     */         {
/* 222 */           localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
/* 223 */           localParcel1.writeString(paramString);
/* 224 */           this.a.transact(5, localParcel1, localParcel2, 0);
/* 225 */           localParcel2.readException();
/* 226 */           paramString = localParcel2.readString();
/*     */ 
/* 229 */           localParcel2.recycle();
/* 230 */           localParcel1.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 229 */           localParcel2.recycle();
/* 230 */           localParcel1.recycle();
/*     */         }
/* 232 */         return paramString;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.android.app.IAlixPay
 * JD-Core Version:    0.6.2
 */