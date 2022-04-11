package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;

public abstract interface IObjectWrapper
  extends IInterface
{
  public static class Stub
    extends zzb
    implements IObjectWrapper
  {
    public Stub()
    {
      super();
    }
    
    public static IObjectWrapper asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
      if ((localIInterface instanceof IObjectWrapper)) {
        return (IObjectWrapper)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public static final class zza
      extends zza
      implements IObjectWrapper
    {
      zza(IBinder paramIBinder)
      {
        super("com.google.android.gms.dynamic.IObjectWrapper");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamic\IObjectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */