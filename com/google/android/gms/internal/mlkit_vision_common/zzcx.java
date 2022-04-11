package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.mlkit.common.sdkinternal.j;

public final class zzcx
{
  @WorkerThread
  public static void zza(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    zzcw localzzcw = new zzcw(paramInt1, paramInt2, paramInt5, paramInt3, paramInt4, SystemClock.elapsedRealtime() - paramLong);
    ((zzcq)j.c().a(zzcq.class)).zza(localzzcw, zzag.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */