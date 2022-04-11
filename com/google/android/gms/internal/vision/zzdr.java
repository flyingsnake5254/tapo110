package com.google.android.gms.internal.vision;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdr<K>
  extends zzdo<K>
{
  private final transient zzdk<K> zzlz;
  private final transient zzdl<K, ?> zzmj;
  
  zzdr(zzdl<K, ?> paramzzdl, zzdk<K> paramzzdk)
  {
    this.zzmj = paramzzdl;
    this.zzlz = paramzzdk;
  }
  
  public final boolean contains(@NullableDecl Object paramObject)
  {
    return this.zzmj.get(paramObject) != null;
  }
  
  public final int size()
  {
    return this.zzmj.size();
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    return zzcd().zza(paramArrayOfObject, paramInt);
  }
  
  public final zzdw<K> zzbz()
  {
    return (zzdw)zzcd().iterator();
  }
  
  public final zzdk<K> zzcd()
  {
    return this.zzlz;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */