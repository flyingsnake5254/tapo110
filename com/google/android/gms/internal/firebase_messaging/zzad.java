package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.HashMap;
import java.util.Map;

public final class zzad
  implements EncoderConfig<zzad>
{
  private static final ObjectEncoder<Object> zzb = zzac.zza;
  private final Map<Class<?>, ObjectEncoder<?>> zzc = new HashMap();
  private final Map<Class<?>, ValueEncoder<?>> zzd = new HashMap();
  private final ObjectEncoder<Object> zze = zzb;
  
  public final zzae zza()
  {
    return new zzae(new HashMap(this.zzc), new HashMap(this.zzd), this.zze);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */