package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.internal.vision.zze;
import com.google.android.gms.internal.vision.zzef.zzo;
import com.google.android.gms.internal.vision.zzf;
import com.google.android.gms.internal.vision.zzi;
import com.google.android.gms.vision.L;
import java.util.concurrent.ExecutorService;

@Keep
public class DynamiteClearcutLogger
{
  private static final ExecutorService zzbv = zze.zza().zza(2, zzi.zzu);
  private zzb zzbw = new zzb(0.03333333333333333D);
  private VisionClearcutLogger zzbx;
  
  public DynamiteClearcutLogger(Context paramContext)
  {
    this.zzbx = new VisionClearcutLogger(paramContext);
  }
  
  public final void zza(int paramInt, zzef.zzo paramzzo)
  {
    if ((paramInt == 3) && (!this.zzbw.tryAcquire()))
    {
      L.v("Skipping image analysis log due to rate limiting", new Object[0]);
      return;
    }
    zzbv.execute(new zza(this, paramInt, paramzzo));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\clearcut\DynamiteClearcutLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */