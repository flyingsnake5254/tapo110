package com.google.android.gms.cloudmessaging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

abstract interface IMessengerCompat
  extends IInterface
{
  public static final String DESCRIPTOR = "com.google.android.gms.iid.IMessengerCompat";
  public static final int TRANSACTION_SEND = 1;
  
  public abstract void send(@NonNull Message paramMessage)
    throws RemoteException;
  
  public static class Impl
    extends Binder
    implements IMessengerCompat
  {
    @NonNull
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, @NonNull Parcel paramParcel1, @Nullable Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
      if (paramInt1 == 1)
      {
        if (paramParcel1.readInt() != 0) {
          paramParcel1 = (Message)Message.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramParcel1 = null;
        }
        send(paramParcel1);
        return true;
      }
      return false;
    }
    
    public void send(@NonNull Message paramMessage)
      throws RemoteException
    {
      paramMessage.arg2 = Binder.getCallingUid();
      throw null;
    }
  }
  
  public static class Proxy
    implements IMessengerCompat
  {
    private final IBinder zza;
    
    Proxy(@NonNull IBinder paramIBinder)
    {
      this.zza = paramIBinder;
    }
    
    @NonNull
    public IBinder asBinder()
    {
      return this.zza;
    }
    
    public void send(@NonNull Message paramMessage)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
      localParcel.writeInt(1);
      paramMessage.writeToParcel(localParcel, 0);
      try
      {
        this.zza.transact(1, localParcel, null, 1);
        return;
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\IMessengerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */