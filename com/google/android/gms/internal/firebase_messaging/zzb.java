package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

final class zzb
  implements ObjectEncoder<MessagingClientEventExtension>
{
  static final zzb zza = new zzb();
  private static final FieldDescriptor zzb;
  
  static
  {
    FieldDescriptor.Builder localBuilder = FieldDescriptor.builder("messagingClientEvent");
    zzv localzzv = new zzv();
    localzzv.zza(1);
    zzb = localBuilder.withProperty(localzzv.zzb()).build();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */