package com.google.android.gms.internal.vision;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

final class zzec
  extends WeakReference<Throwable>
{
  private final int zzmv;
  
  public zzec(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    Objects.requireNonNull(paramThrowable, "The referent cannot be null");
    this.zzmv = System.identityHashCode(paramThrowable);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == zzec.class))
    {
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzec)paramObject;
      if ((this.zzmv == ((zzec)paramObject).zzmv) && (get() == ((WeakReference)paramObject).get())) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.zzmv;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */