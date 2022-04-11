package com.google.android.gms.vision;

import android.util.SparseIntArray;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public final class zzc
{
  private static final Object lock = new Object();
  @GuardedBy("lock")
  private static int zzba;
  @GuardedBy("lock")
  private final SparseIntArray zzbb = new SparseIntArray();
  @GuardedBy("lock")
  private final SparseIntArray zzbc = new SparseIntArray();
  
  public final int zzb(int paramInt)
  {
    synchronized (lock)
    {
      int i = this.zzbb.get(paramInt, -1);
      if (i != -1) {
        return i;
      }
      i = zzba;
      zzba = i + 1;
      this.zzbb.append(paramInt, i);
      this.zzbc.append(i, paramInt);
      return i;
    }
  }
  
  public final int zzc(int paramInt)
  {
    synchronized (lock)
    {
      paramInt = this.zzbc.get(paramInt);
      return paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */