package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IAlixPay extends IInterface
{
    public abstract String Pay(String paramStrin  throws RemoteException;

    public abstract String test() throws RemoteException;

    public abstract void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException;

    public abstract void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException;

    public abstract String prePay(String paramString) throws RemoteException;

    public static abstract class Stub extends Binder implements IAlixPay
    {
        private static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
        static final int TRANSACTION_Pay = 1;
        static final int TRANSACTION_test = 2;
        static final int TRANSACTION_registerCallback = 3;
        static final int TRANSACTION_unregisterCallback = 4;
        static final int TRANSACTION_prePay = 5;

        public Stub() {
            attachInterface(this, "com.alipay.android.app.IAlixPay");
        }

        public static IAlixPay asInterface(IBinder paramIBinder) {
            if (paramIBinder == null)
                return null;
            IInterface localIInterface;
            if (((localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IAlixPay")) != null) && ((localIInterface instanceof IAlixPay))) {
                return (IAlixPay)localIInterface;
            }
            return new a(paramIBinder);
        }

        public IBinder asBinder() {
        return this;
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
            switch (paramInt1)
            {
            case 1598968902:
                paramParcel2.writeString("com.alipay.android.app.IAlixPay");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
                paramInt1 = paramParcel1.readString();
                paramInt1 = Pay(paramInt1);
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramInt1);
                return true;
            case 2:
                paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
                paramInt1 = test();
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramInt1);
                return true;
            case 3:
                paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");

                paramInt1 = IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder());
                registerCallback(paramInt1);
                paramParcel2.writeNoException();
                return true;
            case 4:
                paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");

                paramInt1 = IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder());
                unregisterCallback(paramInt1);
                paramParcel2.writeNoException();
                return true;
            case 5:
                paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");

                paramInt1 = paramParcel1.readString();
                paramInt1 = prePay(paramInt1);
                paramParcel2.writeNoException();
                paramParcel2.writeString(paramInt1);
                return true;
            }

            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }

        private static class a implements IAlixPay {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            private static String a() {
                return "com.alipay.android.app.IAlixPay";
            }

            public final String Pay(String paramString) throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    localParcel1.writeString(paramString);
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    paramString = localParcel2.readString();

                    localParcel2.recycle();
                    localParcel1.recycle();
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                return paramString;
            }

            public final String test() throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    this.a.transact(2, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    String str1 = localParcel2.readString();

                    localParcel2.recycle();
                    localParcel1.recycle();
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                return str2;
            }

            public final void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    localParcel1.writeStrongBinder(paramIRemoteServiceCallback != null ? paramIRemoteServiceCallback.asBinder() : null);
                    this.a.transact(3, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                throw paramIRemoteServiceCallback;
            }

            public final void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback) throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    localParcel1.writeStrongBinder(paramIRemoteServiceCallback != null ? paramIRemoteServiceCallback.asBinder() : null);
                    this.a.transact(4, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                throw paramIRemoteServiceCallback;
            }

            public final String prePay(String paramString) throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IAlixPay");
                    localParcel1.writeString(paramString);
                    this.a.transact(5, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    paramString = localParcel2.readString();

                    localParcel2.recycle();
                    localParcel1.recycle();
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                return paramString;
            }
        }
    }
}
