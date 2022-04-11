package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class zabf
{
  private final zabd zahu;
  
  protected zabf(zabd paramzabd)
  {
    this.zahu = paramzabd;
  }
  
  protected abstract void zaan();
  
  public final void zac(zabe paramzabe)
  {
    zabe.zaa(paramzabe).lock();
    try
    {
      zabd localzabd1 = zabe.zab(paramzabe);
      zabd localzabd2 = this.zahu;
      if (localzabd1 != localzabd2) {
        return;
      }
      zaan();
      return;
    }
    finally
    {
      zabe.zaa(paramzabe).unlock();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zabf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */