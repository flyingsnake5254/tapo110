package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzgu
  extends ContentObserver
{
  zzgu(Handler paramHandler)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    zzgv.zzb().set(true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */