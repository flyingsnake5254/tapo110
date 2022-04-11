package com.google.android.gms.internal.vision;

import java.util.Map.Entry;

final class zzdp<K, V>
  extends zzdo<Map.Entry<K, V>>
{
  private final transient int size;
  private final transient zzdl<K, V> zzmj;
  private final transient Object[] zzmk;
  private final transient int zzml;
  
  zzdp(zzdl<K, V> paramzzdl, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this.zzmj = paramzzdl;
    this.zzmk = paramArrayOfObject;
    this.zzml = 0;
    this.size = paramInt2;
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      Object localObject = (Map.Entry)paramObject;
      paramObject = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject != null) && (localObject.equals(this.zzmj.get(paramObject)))) {
        return true;
      }
    }
    return false;
  }
  
  public final int size()
  {
    return this.size;
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    return zzcd().zza(paramArrayOfObject, paramInt);
  }
  
  public final zzdw<Map.Entry<K, V>> zzbz()
  {
    return (zzdw)zzcd().iterator();
  }
  
  final zzdk<Map.Entry<K, V>> zzci()
  {
    return new zzds(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */