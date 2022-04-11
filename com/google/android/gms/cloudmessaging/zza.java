package com.google.android.gms.cloudmessaging;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;

public class zza
  implements Parcelable
{
  public static final Parcelable.Creator<zza> CREATOR = new zzc();
  private Messenger zza;
  private IMessengerCompat zzb;
  
  public zza(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zza = new Messenger(paramIBinder);
      return;
    }
    this.zzb = new IMessengerCompat.Proxy(paramIBinder);
  }
  
  private final IBinder zza()
  {
    Messenger localMessenger = this.zza;
    if (localMessenger != null) {
      return localMessenger.getBinder();
    }
    return this.zzb.asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = zza().equals(((zza)paramObject).zza());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    return zza().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Messenger localMessenger = this.zza;
    if (localMessenger != null)
    {
      paramParcel.writeStrongBinder(localMessenger.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.zzb.asBinder());
  }
  
  public final void zza(Message paramMessage)
    throws RemoteException
  {
    Messenger localMessenger = this.zza;
    if (localMessenger != null)
    {
      localMessenger.send(paramMessage);
      return;
    }
    this.zzb.send(paramMessage);
  }
  
  public static final class zza
    extends ClassLoader
  {
    protected final Class<?> loadClass(String paramString, boolean paramBoolean)
      throws ClassNotFoundException
    {
      if ("com.google.android.gms.iid.MessengerCompat".equals(paramString))
      {
        int i;
        if ((!Log.isLoggable("CloudMessengerCompat", 3)) && ((Build.VERSION.SDK_INT != 23) || (!Log.isLoggable("CloudMessengerCompat", 3)))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
        }
        return zza.class;
      }
      return super.loadClass(paramString, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */