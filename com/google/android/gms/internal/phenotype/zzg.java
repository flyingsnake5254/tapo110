package com.google.android.gms.internal.phenotype;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzg
  extends ContentObserver
{
  zzg(Handler paramHandler)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    zzf.zzi().set(true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\phenotype\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */