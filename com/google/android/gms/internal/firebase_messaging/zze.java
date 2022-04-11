package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Encodable
public abstract class zze
{
  private static final zzae zza;
  
  static
  {
    zzad localzzad = new zzad();
    zzd.zza.configure(localzzad);
    zza = localzzad.zza();
  }
  
  public static byte[] zza(Object paramObject)
  {
    zzae localzzae = zza;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      localzzae.zza(paramObject, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramObject)
    {
      for (;;) {}
    }
  }
  
  public static void zzb(Object paramObject, OutputStream paramOutputStream)
    throws IOException
  {
    zza.zza(paramObject, paramOutputStream);
  }
  
  public abstract MessagingClientEventExtension zzc();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */