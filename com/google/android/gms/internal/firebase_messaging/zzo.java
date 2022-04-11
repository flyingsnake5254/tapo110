package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzo
  extends WeakReference<Throwable>
{
  private final int zza;
  
  public zzo(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    this.zza = System.identityHashCode(paramThrowable);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == zzo.class))
    {
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzo)paramObject;
      if ((this.zza == ((zzo)paramObject).zza) && (get() == ((WeakReference)paramObject).get())) {
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */