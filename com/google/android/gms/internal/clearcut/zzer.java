package com.google.android.gms.internal.clearcut;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzer
  extends AbstractSet<Map.Entry<K, V>>
{
  private zzer(zzei paramzzei) {}
  
  public void clear()
  {
    this.zzos.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = this.zzos.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    return (paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)));
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new zzeq(this.zzos, null);
  }
  
  public boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      this.zzos.remove(((Map.Entry)paramObject).getKey());
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return this.zzos.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */