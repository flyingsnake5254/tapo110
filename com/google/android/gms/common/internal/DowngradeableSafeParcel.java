package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  private static final Object zzdc = new Object();
  private static ClassLoader zzdd;
  private static Integer zzde;
  private boolean zzdf = false;
  
  @KeepForSdk
  protected static boolean canUnparcelSafely(String paramString)
  {
    zzp();
    return true;
  }
  
  @KeepForSdk
  protected static Integer getUnparcelClientVersion()
  {
    synchronized (zzdc)
    {
      return null;
    }
  }
  
  private static ClassLoader zzp()
  {
    synchronized (zzdc)
    {
      return null;
    }
  }
  
  @KeepForSdk
  protected abstract boolean prepareForClientVersion(int paramInt);
  
  @KeepForSdk
  public void setShouldDowngrade(boolean paramBoolean)
  {
    this.zzdf = paramBoolean;
  }
  
  @KeepForSdk
  protected boolean shouldDowngrade()
  {
    return this.zzdf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\DowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */