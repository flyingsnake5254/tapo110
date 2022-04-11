package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzji
  extends AbstractSet<Map.Entry<K, V>>
{
  private zzji(zzjb paramzzjb) {}
  
  public void clear()
  {
    this.zzaaq.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = this.zzaaq.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    return (paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)));
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new zzjj(this.zzaaq, null);
  }
  
  public boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      this.zzaaq.remove(((Map.Entry)paramObject).getKey());
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return this.zzaaq.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */