package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

public final class zzd
  implements Configurator
{
  public static final Configurator zza = new zzd();
  
  public final void configure(EncoderConfig<?> paramEncoderConfig)
  {
    paramEncoderConfig.registerEncoder(zze.class, zzc.zza);
    paramEncoderConfig.registerEncoder(MessagingClientEventExtension.class, zzb.zza);
    paramEncoderConfig.registerEncoder(MessagingClientEvent.class, zza.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */