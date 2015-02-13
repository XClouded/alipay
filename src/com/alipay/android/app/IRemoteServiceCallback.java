package com.alipay.android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IRemoteServiceCallback extends IInterface
{
    public abstract void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException;

    public abstract void payEnd(boolean paramBoolean, String paramString) throws RemoteException;

    public abstract boolean isHideLoadingScreen() throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteServiceCallback
    {
        private static final String DESCRIPTOR = "com.alipay.android.app.IRemoteServiceCallback";
        static final int TRANSACTION_startActivity = 1;
        static final int TRANSACTION_payEnd = 2;
        static final int TRANSACTION_isHideLoadingScreen = 3;

        public Stub() {
            attachInterface(this, "com.alipay.android.app.IRemoteServiceCallback");
        }

        public static IRemoteServiceCallback asInterface(IBinder paramIBinder) {
            if (paramIBinder == null)
                return null;
            IInterface localIInterface;
            if (((localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IRemoteServiceCallback")) != null) &&  ((localIInterface instanceof IRemoteServiceCallback))) {
                return (IRemoteServiceCallback)localIInterface;
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
                paramParcel2.writeString("com.alipay.android.app.IRemoteServiceCallback");
                return true;
            case 1:
                paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
                paramInt1 = paramParcel1.readString();
                paramInt2 = paramParcel1.readString();
                int i = paramParcel1.readInt();
                if (0 != paramParcel1.readInt()) {
                    paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                } else {
                    paramParcel1 = null;
                }
                startActivity(paramInt1, paramInt2, i, paramParcel1);
                paramParcel2.writeNoException();
                return true;
            case 2:
                paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
                paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
                paramInt2 = paramParcel1.readString();
                payEnd(paramInt1, paramInt2);
                paramParcel2.writeNoException();
                return true;
            case 3:
                paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
                paramInt1 = isHideLoadingScreen();
                paramParcel2.writeNoException();
                paramParcel2.writeInt(paramInt1 != 0 ? 1 : 0);
                return true;
            }

            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }

        private static class a implements IRemoteServiceCallback {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            private static String a() {
                return "com.alipay.android.app.IRemoteServiceCallback";
            }

            public final void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
                    localParcel1.writeString(paramString1);
                    localParcel1.writeString(paramString2);
                    localParcel1.writeInt(paramInt);
                    if (paramBundle != null) {
                        localParcel1.writeInt(1);
                        paramBundle.writeToParcel(localParcel1, 0);
                    } else {
                        localParcel1.writeInt(0);
                    }
                    this.a.transact(1, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                throw paramString1;
            }

            public final void payEnd(boolean paramBoolean, String paramString) throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
                    localParcel1.writeInt(paramBoolean ? 1 : 0);
                    localParcel1.writeString(paramString);
                    this.a.transact(2, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                throw paramBoolean;
            }

            public final boolean isHideLoadingScreen() throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
                    this.a.transact(3, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    int i = 0 != localParcel2.readInt() ? 1 : 0;

                    localParcel2.recycle();
                    localParcel1.recycle();
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
                return localObject;
            }
        }
    }
}
