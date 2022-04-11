package com.google.android.gms.vision.clearcut;

import javax.annotation.concurrent.GuardedBy;

public final class zzb
{
  private final Object lock = new Object();
  private final long zzcb = Math.round(30000.0D);
  @GuardedBy("lock")
  private long zzcc = Long.MIN_VALUE;
  
  public zzb(double paramDouble) {}
  
  public final boolean tryAcquire()
  {
    synchronized (this.lock)
    {
      long l = System.currentTimeMillis();
      if (this.zzcc + this.zzcb > l) {
        return false;
      }
      this.zzcc = l;
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\clearcut\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */