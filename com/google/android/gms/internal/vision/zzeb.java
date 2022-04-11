package com.google.android.gms.internal.vision;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

final class zzeb
  extends zzea
{
  private final zzdz zzmu = new zzdz();
  
  public final void zza(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    paramThrowable = this.zzmu.zza(paramThrowable, false);
    if (paramThrowable == null) {
      return;
    }
    try
    {
      Iterator localIterator = paramThrowable.iterator();
      while (localIterator.hasNext())
      {
        Throwable localThrowable = (Throwable)localIterator.next();
        System.err.print("Suppressed: ");
        localThrowable.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (paramThrowable2 != paramThrowable1)
    {
      Objects.requireNonNull(paramThrowable2, "The suppressed exception cannot be null.");
      this.zzmu.zza(paramThrowable1, true).add(paramThrowable2);
      return;
    }
    throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */