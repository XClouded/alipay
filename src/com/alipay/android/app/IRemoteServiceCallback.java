/*     */ package com.alipay.android.app;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.Bundle;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable.Creator;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public abstract interface IRemoteServiceCallback extends IInterface
/*     */ {
/*     */   public abstract void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void payEnd(boolean paramBoolean, String paramString)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract boolean isHideLoadingScreen()
/*     */     throws RemoteException;
/*     */ 
/*     */   public static abstract class Stub extends Binder
/*     */     implements IRemoteServiceCallback
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.alipay.android.app.IRemoteServiceCallback";
/*     */     static final int TRANSACTION_startActivity = 1;
/*     */     static final int TRANSACTION_payEnd = 2;
/*     */     static final int TRANSACTION_isHideLoadingScreen = 3;
/*     */ 
/*     */     public Stub()
/*     */     {
/*  20 */       attachInterface(this, "com.alipay.android.app.IRemoteServiceCallback");
/*     */     }
/*     */ 
/*     */     public static IRemoteServiceCallback asInterface(IBinder paramIBinder)
/*     */     {
/*  28 */       if (paramIBinder == null)
/*  29 */         return null;
/*     */       IInterface localIInterface;
/*  32 */       if (((
/*  32 */         localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IRemoteServiceCallback")) != null) && 
/*  32 */         ((localIInterface instanceof IRemoteServiceCallback))) {
/*  33 */         return (IRemoteServiceCallback)localIInterface;
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
/*  47 */         paramParcel2.writeString("com.alipay.android.app.IRemoteServiceCallback");
/*  48 */         return true;
/*     */       case 1:
/*  52 */         paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
/*     */ 
/*  54 */         paramInt1 = paramParcel1.readString();
/*     */ 
/*  56 */         paramInt2 = paramParcel1.readString();
/*     */ 
/*  58 */         int i = paramParcel1.readInt();
/*     */ 
/*  60 */         if (0 != paramParcel1.readInt()) {
/*  61 */           paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
/*     */         }
/*     */         else {
/*  64 */           paramParcel1 = null;
/*     */         }
/*  66 */         startActivity(paramInt1, paramInt2, i, paramParcel1);
/*  67 */         paramParcel2.writeNoException();
/*  68 */         return true;
/*     */       case 2:
/*  72 */         paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
/*     */ 
/*  74 */         paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
/*     */ 
/*  76 */         paramInt2 = paramParcel1.readString();
/*  77 */         payEnd(paramInt1, paramInt2);
/*  78 */         paramParcel2.writeNoException();
/*  79 */         return true;
/*     */       case 3:
/*  83 */         paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
/*  84 */         paramInt1 = isHideLoadingScreen();
/*  85 */         paramParcel2.writeNoException();
/*  86 */         paramParcel2.writeInt(paramInt1 != 0 ? 1 : 0);
/*  87 */         return true;
/*     */       }
/*     */ 
/*  90 */       return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
/*     */     }
/*     */ 
/*     */     private static class a implements IRemoteServiceCallback {
/*     */       private IBinder a;
/*     */ 
/*     */       a(IBinder paramIBinder) {
/*  97 */         this.a = paramIBinder;
/*     */       }
/*     */ 
/*     */       public final IBinder asBinder() {
/* 101 */         return this.a;
/*     */       }
/*     */ 
/*     */       private static String a() {
/* 105 */         return "com.alipay.android.app.IRemoteServiceCallback";
/*     */       }
/*     */ 
/*     */       public final void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException {
/* 109 */         Parcel localParcel1 = Parcel.obtain();
/* 110 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try {
/* 112 */           localParcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
/* 113 */           localParcel1.writeString(paramString1);
/* 114 */           localParcel1.writeString(paramString2);
/* 115 */           localParcel1.writeInt(paramInt);
/* 116 */           if (paramBundle != null) {
/* 117 */             localParcel1.writeInt(1);
/* 118 */             paramBundle.writeToParcel(localParcel1, 0);
/*     */           }
/*     */           else {
/* 121 */             localParcel1.writeInt(0);
/* 123 */           }this.a.transact(1, localParcel1, localParcel2, 0);
/* 124 */           localParcel2.readException();
/*     */           return; } finally {
/* 127 */           localParcel2.recycle();
/* 128 */           localParcel1.recycle(); } throw paramString1;
/*     */       }
/*     */ 
/*     */       public final void payEnd(boolean paramBoolean, String paramString) throws RemoteException
/*     */       {
/* 133 */         Parcel localParcel1 = Parcel.obtain();
/* 134 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try { localParcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
/* 137 */           localParcel1.writeInt(paramBoolean ? 1 : 0);
/* 138 */           localParcel1.writeString(paramString);
/* 139 */           this.a.transact(2, localParcel1, localParcel2, 0);
/* 140 */           localParcel2.readException();
/*     */           return; } finally { localParcel2.recycle();
/* 144 */           localParcel1.recycle(); } throw paramBoolean;
/*     */       }
/*     */ 
/*     */       public final boolean isHideLoadingScreen() throws RemoteException
/*     */       {
/* 149 */         Parcel localParcel1 = Parcel.obtain();
/* 150 */         Parcel localParcel2 = Parcel.obtain();
/*     */         try
/*     */         {
/* 153 */           localParcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
/* 154 */           this.a.transact(3, localParcel1, localParcel2, 0);
/* 155 */           localParcel2.readException();
/* 156 */           int i = 0 != localParcel2.readInt() ? 1 : 0;
/*     */ 
/* 159 */           localParcel2.recycle();
/* 160 */           localParcel1.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 159 */           localParcel2.recycle();
/* 160 */           localParcel1.recycle();
/*     */         }
/* 162 */         return localObject;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.android.app.IRemoteServiceCallback
 * JD-Core Version:    0.6.2
 */