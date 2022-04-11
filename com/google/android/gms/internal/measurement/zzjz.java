package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzjz<MessageType extends zzkd<MessageType, BuilderType>, BuilderType extends zzjz<MessageType, BuilderType>>
  extends zzin<MessageType, BuilderType>
{
  protected MessageType zza;
  protected boolean zzb;
  private final MessageType zzc;
  
  protected zzjz(MessageType paramMessageType)
  {
    this.zzc = paramMessageType;
    this.zza = ((zzkd)paramMessageType.zzl(4, null, null));
    this.zzb = false;
  }
  
  private static final void zza(MessageType paramMessageType1, MessageType paramMessageType2)
  {
    zzlq.zza().zzb(paramMessageType1.getClass()).zzd(paramMessageType1, paramMessageType2);
  }
  
  public final MessageType zzaA()
  {
    zzkd localzzkd1 = zzaz();
    boolean bool = true;
    int i = ((Byte)localzzkd1.zzl(1, null, null)).byteValue();
    if (i != 1) {
      if (i == 0)
      {
        bool = false;
      }
      else
      {
        bool = zzlq.zza().zzb(localzzkd1.getClass()).zzj(localzzkd1);
        zzkd localzzkd2;
        if (true != bool) {
          localzzkd2 = null;
        } else {
          localzzkd2 = localzzkd1;
        }
        localzzkd1.zzl(2, localzzkd2, null);
      }
    }
    if (bool) {
      return localzzkd1;
    }
    throw new zzmg(localzzkd1);
  }
  
  public final BuilderType zzaB(MessageType paramMessageType)
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    zza(this.zza, paramMessageType);
    return this;
  }
  
  public final BuilderType zzaC(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzjp paramzzjp)
    throws zzkn
  {
    if (this.zzb)
    {
      zzax();
      this.zzb = false;
    }
    try
    {
      zzlt localzzlt = zzlq.zza().zzb(this.zza.getClass());
      zzkd localzzkd = this.zza;
      zzir localzzir = new com/google/android/gms/internal/measurement/zzir;
      localzzir.<init>(paramzzjp);
      localzzlt.zzh(localzzkd, paramArrayOfByte, 0, paramInt2, localzzir);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Reading from byte array should not throw IOException.", paramArrayOfByte);
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      throw zzkn.zza();
    }
    catch (zzkn paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  protected void zzax()
  {
    zzkd localzzkd = (zzkd)this.zza.zzl(4, null, null);
    zza(localzzkd, this.zza);
    this.zza = localzzkd;
  }
  
  public final BuilderType zzay()
  {
    zzjz localzzjz = (zzjz)this.zzc.zzl(5, null, null);
    localzzjz.zzaB(zzaz());
    return localzzjz;
  }
  
  public MessageType zzaz()
  {
    if (this.zzb) {
      return this.zza;
    }
    zzkd localzzkd = this.zza;
    zzlq.zza().zzb(localzzkd.getClass()).zzi(localzzkd);
    this.zzb = true;
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */