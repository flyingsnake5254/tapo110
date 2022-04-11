package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza
  implements IInterface
{
  private final IBinder zza;
  private final String zzb;
  
  protected zza(IBinder paramIBinder, String paramString)
  {
    this.zza = paramIBinder;
    this.zzb = paramString;
  }
  
  public IBinder asBinder()
  {
    return this.zza;
  }
  
  protected final Parcel zza()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.zzb);
    return localParcel;
  }
  
  /* Error */
  protected final Parcel zza(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 17	com/google/android/gms/internal/common/zza:zza	Landroid/os/IBinder;
    //   8: iload_1
    //   9: aload_2
    //   10: aload_3
    //   11: iconst_0
    //   12: invokeinterface 43 5 0
    //   17: pop
    //   18: aload_3
    //   19: invokevirtual 46	android/os/Parcel:readException	()V
    //   22: aload_2
    //   23: invokevirtual 49	android/os/Parcel:recycle	()V
    //   26: aload_3
    //   27: areturn
    //   28: astore 4
    //   30: goto +12 -> 42
    //   33: astore 4
    //   35: aload_3
    //   36: invokevirtual 49	android/os/Parcel:recycle	()V
    //   39: aload 4
    //   41: athrow
    //   42: aload_2
    //   43: invokevirtual 49	android/os/Parcel:recycle	()V
    //   46: aload 4
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	zza
    //   0	49	1	paramInt	int
    //   0	49	2	paramParcel	Parcel
    //   3	33	3	localParcel	Parcel
    //   28	1	4	localObject	Object
    //   33	14	4	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   4	22	28	finally
    //   35	42	28	finally
    //   4	22	33	java/lang/RuntimeException
  }
  
  protected final void zzb(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.zza.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
    }
  }
  
  protected final void zzc(int paramInt, Parcel paramParcel)
    throws RemoteException
  {
    try
    {
      this.zza.transact(2, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\common\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */