package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzp
{
  private final ConcurrentHashMap<zzo, List<Throwable>> zza = new ConcurrentHashMap(16, 0.75F, 10);
  private final ReferenceQueue<Throwable> zzb = new ReferenceQueue();
  
  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    for (Object localObject = this.zzb;; localObject = this.zzb)
    {
      localObject = ((ReferenceQueue)localObject).poll();
      if (localObject == null) {
        break;
      }
      this.zza.remove(localObject);
    }
    localObject = new zzo(paramThrowable, null);
    localObject = (List)this.zza.get(localObject);
    if (localObject != null) {
      return (List<Throwable>)localObject;
    }
    localObject = new Vector(2);
    paramThrowable = (List)this.zza.putIfAbsent(new zzo(paramThrowable, this.zzb), localObject);
    if (paramThrowable == null) {
      return (List<Throwable>)localObject;
    }
    return paramThrowable;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */