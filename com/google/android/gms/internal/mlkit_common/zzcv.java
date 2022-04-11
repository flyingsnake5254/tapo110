package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.datatransport.c;
import com.google.android.datatransport.e;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

public class zzcv
  implements zzdb.zza
{
  public static final Component<?> zza = Component.builder(zzcv.class).add(Dependency.required(Context.class)).factory(zzcw.zza).build();
  private static final GmsLogger zzb = new GmsLogger("FirelogLoggingTransport", "");
  private final Provider<e<zzaa.zzad>> zzc;
  
  public zzcv(Context paramContext)
  {
    this.zzc = new Lazy(new zzcu(paramContext));
  }
  
  public final void zza(zzaa.zzad paramzzad)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */