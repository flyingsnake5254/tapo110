package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.android.datatransport.c;
import com.google.android.datatransport.e;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

public class zzck
  implements zzcq.zza
{
  public static final Component<?> zza = Component.builder(zzck.class).add(Dependency.required(Context.class)).factory(zzcp.zza).build();
  private static final GmsLogger zzb = new GmsLogger("FirelogLoggingTransport", "");
  private final Provider<e<zzr.zzad>> zzc;
  
  public zzck(Context paramContext)
  {
    this.zzc = new Lazy(new zzcn(paramContext));
  }
  
  public final void zza(zzr.zzad paramzzad)
  {
    GmsLogger localGmsLogger = zzb;
    String str = String.valueOf(paramzzad);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 30);
    localStringBuilder.append("Logging FirebaseMlSdkLogEvent ");
    localStringBuilder.append(str);
    localGmsLogger.d("FirelogLoggingTransport", localStringBuilder.toString());
    ((e)this.zzc.get()).b(c.d(paramzzad));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */