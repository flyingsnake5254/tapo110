package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
public abstract class e<K, V>
{
  @GuardedBy("instances")
  private final Map<K, V> zza = new HashMap();
  
  @KeepForSdk
  protected abstract V create(K paramK);
  
  @KeepForSdk
  public V get(K paramK)
  {
    synchronized (this.zza)
    {
      if (this.zza.containsKey(paramK))
      {
        paramK = this.zza.get(paramK);
        return paramK;
      }
      Object localObject = create(paramK);
      this.zza.put(paramK, localObject);
      return (V)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */