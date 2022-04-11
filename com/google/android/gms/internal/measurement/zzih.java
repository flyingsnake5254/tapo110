package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzih
  extends WeakReference<Throwable>
{
  private final int zza;
  
  public zzih(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    this.zza = System.identityHashCode(paramThrowable);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == zzih.class))
    {
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzih)paramObject;
      if ((this.zza == ((zzih)paramObject).zza) && (get() == ((WeakReference)paramObject).get())) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */