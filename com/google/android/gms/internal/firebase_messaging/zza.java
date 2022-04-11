package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEvent;

final class zza
  implements ObjectEncoder<MessagingClientEvent>
{
  static final zza zza = new zza();
  private static final FieldDescriptor zzb;
  private static final FieldDescriptor zzc;
  private static final FieldDescriptor zzd;
  private static final FieldDescriptor zze;
  private static final FieldDescriptor zzf;
  private static final FieldDescriptor zzg;
  private static final FieldDescriptor zzh;
  private static final FieldDescriptor zzi;
  private static final FieldDescriptor zzj;
  private static final FieldDescriptor zzk;
  private static final FieldDescriptor zzl;
  private static final FieldDescriptor zzm;
  private static final FieldDescriptor zzn;
  private static final FieldDescriptor zzo;
  private static final FieldDescriptor zzp;
  
  static
  {
    Object localObject1 = FieldDescriptor.builder("projectNumber");
    Object localObject2 = new zzv();
    ((zzv)localObject2).zza(1);
    zzb = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject1 = FieldDescriptor.builder("messageId");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(2);
    zzc = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject1 = FieldDescriptor.builder("instanceId");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(3);
    zzd = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject1 = FieldDescriptor.builder("messageType");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(4);
    zze = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject2 = FieldDescriptor.builder("sdkPlatform");
    localObject1 = new zzv();
    ((zzv)localObject1).zza(5);
    zzf = ((FieldDescriptor.Builder)localObject2).withProperty(((zzv)localObject1).zzb()).build();
    localObject1 = FieldDescriptor.builder("packageName");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(6);
    zzg = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject2 = FieldDescriptor.builder("collapseKey");
    localObject1 = new zzv();
    ((zzv)localObject1).zza(7);
    zzh = ((FieldDescriptor.Builder)localObject2).withProperty(((zzv)localObject1).zzb()).build();
    localObject2 = FieldDescriptor.builder("priority");
    localObject1 = new zzv();
    ((zzv)localObject1).zza(8);
    zzi = ((FieldDescriptor.Builder)localObject2).withProperty(((zzv)localObject1).zzb()).build();
    localObject1 = FieldDescriptor.builder("ttl");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(9);
    zzj = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject1 = FieldDescriptor.builder("topic");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(10);
    zzk = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject1 = FieldDescriptor.builder("bulkId");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(11);
    zzl = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject1 = FieldDescriptor.builder("event");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(12);
    zzm = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject1 = FieldDescriptor.builder("analyticsLabel");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(13);
    zzn = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
    localObject2 = FieldDescriptor.builder("campaignId");
    localObject1 = new zzv();
    ((zzv)localObject1).zza(14);
    zzo = ((FieldDescriptor.Builder)localObject2).withProperty(((zzv)localObject1).zzb()).build();
    localObject1 = FieldDescriptor.builder("composerLabel");
    localObject2 = new zzv();
    ((zzv)localObject2).zza(15);
    zzp = ((FieldDescriptor.Builder)localObject1).withProperty(((zzv)localObject2).zzb()).build();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */