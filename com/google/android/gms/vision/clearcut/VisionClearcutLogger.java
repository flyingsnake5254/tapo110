package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.ClearcutLogger.LogEventBuilder;
import com.google.android.gms.internal.vision.zzdx;
import com.google.android.gms.internal.vision.zzef.zzo;
import com.google.android.gms.internal.vision.zzef.zzo.zza;
import com.google.android.gms.internal.vision.zzey;
import com.google.android.gms.internal.vision.zzfb;
import com.google.android.gms.internal.vision.zzgi;
import com.google.android.gms.vision.L;

@Keep
public class VisionClearcutLogger
{
  private final ClearcutLogger zzcd;
  private boolean zzce = true;
  
  public VisionClearcutLogger(Context paramContext)
  {
    this.zzcd = new ClearcutLogger(paramContext, "VISION", null);
  }
  
  public final void zzb(int paramInt, zzef.zzo paramzzo)
  {
    paramzzo = paramzzo.toByteArray();
    if ((paramInt >= 0) && (paramInt <= 3)) {
      try
      {
        if (this.zzce)
        {
          this.zzcd.newEvent(paramzzo).setEventCode(paramInt).log();
          return;
        }
        zzef.zzo.zza localzza = zzef.zzo.zzdj();
        try
        {
          zzgi localzzgi = zzgi.zzfn();
          localzza.zza(paramzzo, 0, paramzzo.length, localzzgi);
          L.e("Would have logged:\n%s", new Object[] { localzza.toString() });
          return;
        }
        catch (Exception paramzzo)
        {
          L.e(paramzzo, "Parsing error", new Object[0]);
          return;
        }
      }
      catch (Exception paramzzo)
      {
        zzdx.zza(paramzzo);
        L.e(paramzzo, "Failed to log", new Object[0]);
        return;
      }
    }
    tmp114_111[0] = Integer.valueOf(paramInt);
    L.i("Illegal event code: %d", tmp114_111);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\clearcut\VisionClearcutLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */