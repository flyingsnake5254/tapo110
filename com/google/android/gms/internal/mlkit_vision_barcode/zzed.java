package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.ClearcutLogger.LogEventBuilder;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;

public class zzed
  implements zzeg.zzc
{
  public static final Component<?> zza = Component.builder(zzed.class).add(Dependency.required(Context.class)).factory(zzef.zza).build();
  private static final GmsLogger zzb = new GmsLogger("ClearcutTransport", "");
  private final ClearcutLogger zzc;
  
  public zzed(Context paramContext)
  {
    this.zzc = ClearcutLogger.anonymousLogger(paramContext, "FIREBASE_ML_SDK");
  }
  
  public final void zza(zzbl.zzad paramzzad)
  {
    GmsLogger localGmsLogger = zzb;
    String str = String.valueOf(paramzzad);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 30);
    localStringBuilder.append("Logging FirebaseMlSdkLogEvent ");
    localStringBuilder.append(str);
    localGmsLogger.d("ClearcutTransport", localStringBuilder.toString());
    try
    {
      this.zzc.newEvent(paramzzad.zzf()).log();
      return;
    }
    catch (SecurityException paramzzad)
    {
      zzb.e("ClearcutTransport", "Exception thrown from the logging side", paramzzad);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */