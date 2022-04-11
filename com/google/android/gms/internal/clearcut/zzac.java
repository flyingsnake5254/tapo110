package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

final class zzac
  extends ContentObserver
{
  zzac(zzab paramzzab, Handler paramHandler)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    this.zzdm.zzh();
    zzab.zza(this.zzdm);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */