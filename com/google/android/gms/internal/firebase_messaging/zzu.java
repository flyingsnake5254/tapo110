package com.google.android.gms.internal.firebase_messaging;

import java.lang.annotation.Annotation;

final class zzu
  implements zzz
{
  private final int zza;
  private final zzy zzb;
  
  zzu(int paramInt, zzy paramzzy)
  {
    this.zza = paramInt;
    this.zzb = paramzzy;
  }
  
  public final Class<? extends Annotation> annotationType()
  {
    return zzz.class;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzz)) {
      return false;
    }
    paramObject = (zzz)paramObject;
    return (this.zza == ((zzz)paramObject).zza()) && (this.zzb.equals(((zzz)paramObject).zzb()));
  }
  
  public final int hashCode()
  {
    return (this.zza ^ 0xDE0D66) + (this.zzb.hashCode() ^ 0x79AD669E);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("@com.google.firebase.encoders.proto.Protobuf");
    localStringBuilder.append("(tag=");
    localStringBuilder.append(this.zza);
    localStringBuilder.append("intEncoding=");
    localStringBuilder.append(this.zzb);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public final int zza()
  {
    return this.zza;
  }
  
  public final zzy zzb()
  {
    return this.zzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */