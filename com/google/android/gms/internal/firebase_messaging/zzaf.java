package com.google.android.gms.internal.firebase_messaging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

final class zzaf
  implements ValueEncoderContext
{
  private boolean zza = false;
  private boolean zzb = false;
  private FieldDescriptor zzc;
  private final zzab zzd;
  
  zzaf(zzab paramzzab)
  {
    this.zzd = paramzzab;
  }
  
  private final void zzb()
  {
    if (!this.zza)
    {
      this.zza = true;
      return;
    }
    throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
  }
  
  @NonNull
  public final ValueEncoderContext add(double paramDouble)
    throws IOException
  {
    zzb();
    this.zzd.zzb(this.zzc, paramDouble, this.zzb);
    return this;
  }
  
  @NonNull
  public final ValueEncoderContext add(float paramFloat)
    throws IOException
  {
    zzb();
    this.zzd.zzc(this.zzc, paramFloat, this.zzb);
    return this;
  }
  
  @NonNull
  public final ValueEncoderContext add(int paramInt)
    throws IOException
  {
    zzb();
    this.zzd.zzd(this.zzc, paramInt, this.zzb);
    return this;
  }
  
  @NonNull
  public final ValueEncoderContext add(long paramLong)
    throws IOException
  {
    zzb();
    this.zzd.zze(this.zzc, paramLong, this.zzb);
    return this;
  }
  
  @NonNull
  public final ValueEncoderContext add(@Nullable String paramString)
    throws IOException
  {
    zzb();
    this.zzd.zza(this.zzc, paramString, this.zzb);
    return this;
  }
  
  @NonNull
  public final ValueEncoderContext add(boolean paramBoolean)
    throws IOException
  {
    zzb();
    this.zzd.zzd(this.zzc, paramBoolean, this.zzb);
    return this;
  }
  
  @NonNull
  public final ValueEncoderContext add(@NonNull byte[] paramArrayOfByte)
    throws IOException
  {
    zzb();
    this.zzd.zza(this.zzc, paramArrayOfByte, this.zzb);
    return this;
  }
  
  final void zza(FieldDescriptor paramFieldDescriptor, boolean paramBoolean)
  {
    this.zza = false;
    this.zzc = paramFieldDescriptor;
    this.zzb = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */