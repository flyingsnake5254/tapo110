package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzij
  extends zzig
{
  private final zzii zza = new zzii();
  
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (paramThrowable2 != paramThrowable1)
    {
      this.zza.zza(paramThrowable1, true).add(paramThrowable2);
      return;
    }
    throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */