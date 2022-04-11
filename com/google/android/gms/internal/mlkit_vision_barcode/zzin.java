package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzin
  extends AbstractSet<Map.Entry<K, V>>
{
  private zzin(zzic paramzzic) {}
  
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
    return new zzik(this.zza, null);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */