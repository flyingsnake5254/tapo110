package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public abstract interface Clock
{
  @KeepForSdk
  public abstract long currentThreadTimeMillis();
  
  @KeepForSdk
  public abstract long currentTimeMillis();
  
  @KeepForSdk
  public abstract long elapsedRealtime();
  
  @KeepForSdk
  public abstract long nanoTime();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */