package com.google.android.gms.internal.firebase_messaging;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public final class zzae
{
  private final Map<Class<?>, ObjectEncoder<?>> zza;
  private final Map<Class<?>, ValueEncoder<?>> zzb;
  private final ObjectEncoder<Object> zzc;
  
  zzae(Map<Class<?>, ObjectEncoder<?>> paramMap, Map<Class<?>, ValueEncoder<?>> paramMap1, ObjectEncoder<Object> paramObjectEncoder)
  {
    this.zza = paramMap;
    this.zzb = paramMap1;
    this.zzc = paramObjectEncoder;
  }
  
  public final void zza(@NonNull Object paramObject, @NonNull OutputStream paramOutputStream)
    throws IOException
  {
    new zzab(paramOutputStream, this.zza, this.zzb, this.zzc).zzf(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */