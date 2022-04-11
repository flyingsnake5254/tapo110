package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zah
  extends zaa
  implements ISignInButtonCreator
{
  zah(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
  }
  
  public final IObjectWrapper newSignInButton(IObjectWrapper paramIObjectWrapper, int paramInt1, int paramInt2)
    throws RemoteException
  {
    Parcel localParcel = zaa();
    zac.zaa(localParcel, paramIObjectWrapper);
    localParcel.writeInt(paramInt1);
    localParcel.writeInt(paramInt2);
    localParcel = zaa(1, localParcel);
    paramIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
    localParcel.recycle();
    return paramIObjectWrapper;
  }
  
  public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper paramIObjectWrapper, SignInButtonConfig paramSignInButtonConfig)
    throws RemoteException
  {
    Parcel localParcel = zaa();
    zac.zaa(localParcel, paramIObjectWrapper);
    zac.zaa(localParcel, paramSignInButtonConfig);
    paramIObjectWrapper = zaa(2, localParcel);
    paramSignInButtonConfig = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramSignInButtonConfig;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\zah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */