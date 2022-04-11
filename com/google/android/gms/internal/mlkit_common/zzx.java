package com.google.android.gms.internal.mlkit_common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

final class zzx
  extends WeakReference<Throwable>
{
  private final int zza;
  
  public zzx(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    Objects.requireNonNull(paramThrowable, "The referent cannot be null");
    this.zza = System.identityHashCode(paramThrowable);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == zzx.class))
    {
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzx)paramObject;
      if ((this.zza == ((zzx)paramObject).zza) && (get() == ((WeakReference)paramObject).get())) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */