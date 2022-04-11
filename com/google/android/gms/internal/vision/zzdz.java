package com.google.android.gms.internal.vision;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzdz
{
  private final ConcurrentHashMap<zzec, List<Throwable>> zzmr = new ConcurrentHashMap(16, 0.75F, 10);
  private final ReferenceQueue<Throwable> zzms = new ReferenceQueue();
  
  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    for (Object localObject = this.zzms.poll(); localObject != null; localObject = this.zzms.poll()) {
      this.zzmr.remove(localObject);
    }
    localObject = new zzec(paramThrowable, null);
    localObject = (List)this.zzmr.get(localObject);
    if (!paramBoolean) {
      return (List<Throwable>)localObject;
    }
    if (localObject != null) {
      return (List<Throwable>)localObject;
    }
    localObject = new Vector(2);
    paramThrowable = (List)this.zzmr.putIfAbsent(new zzec(paramThrowable, this.zzms), localObject);
    if (paramThrowable == null) {
      return (List<Throwable>)localObject;
    }
    return paramThrowable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */