package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;

final class zzo
{
  @Nullable
  private final Messenger zza;
  @Nullable
  private final zza zzb;
  
  zzo(IBinder paramIBinder)
    throws RemoteException
  {
    String str = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str))
    {
      this.zza = new Messenger(paramIBinder);
      this.zzb = null;
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str))
    {
      this.zzb = new zza(paramIBinder);
      this.zza = null;
      return;
    }
    paramIBinder = String.valueOf(str);
    if (paramIBinder.length() != 0) {
      paramIBinder = "Invalid interface descriptor: ".concat(paramIBinder);
    } else {
      paramIBinder = new String("Invalid interface descriptor: ");
    }
    Log.w("MessengerIpcClient", paramIBinder);
    throw new RemoteException();
  }
  
  final void zza(Message paramMessage)
    throws RemoteException
  {
    Object localObject = this.zza;
    if (localObject != null)
    {
      ((Messenger)localObject).send(paramMessage);
      return;
    }
    localObject = this.zzb;
    if (localObject != null)
    {
      ((zza)localObject).zza(paramMessage);
      return;
    }
    throw new IllegalStateException("Both messengers are null");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */