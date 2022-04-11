package com.google.android.gms.internal.mlkit_common;

import java.util.List;
import java.util.Objects;

final class zzz
  extends zzv
{
  private final zzy zza = new zzy();
  
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (paramThrowable2 != paramThrowable1)
    {
      Objects.requireNonNull(paramThrowable2, "The suppressed exception cannot be null.");
      this.zza.zza(paramThrowable1, true).add(paramThrowable2);
      return;
    }
    throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */