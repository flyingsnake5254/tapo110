package com.google.android.gms.internal.vision;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdo<E>
  extends zzdh<E>
  implements Set<E>
{
  @NullableDecl
  private transient zzdk<E> zzmi;
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return zzdt.zza(this, paramObject);
  }
  
  public int hashCode()
  {
    return zzdt.zza(this);
  }
  
  public zzdk<E> zzcd()
  {
    zzdk localzzdk1 = this.zzmi;
    zzdk localzzdk2 = localzzdk1;
    if (localzzdk1 == null)
    {
      localzzdk2 = zzci();
      this.zzmi = localzzdk2;
    }
    return localzzdk2;
  }
  
  zzdk<E> zzci()
  {
    return zzdk.zza(toArray());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */