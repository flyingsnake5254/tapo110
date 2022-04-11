package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzhk
  extends AbstractSet<Map.Entry<K, V>>
{
  private zzhk(zzgz paramzzgz) {}
  
  public void clear()
  {
    this.zza.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = this.zza.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    return (paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)));
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new zzhh(this.zza, null);
  }
  
  public boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      this.zza.remove(((Map.Entry)paramObject).getKey());
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return this.zza.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */