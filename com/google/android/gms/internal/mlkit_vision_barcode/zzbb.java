package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract interface zzbb<K, V>
{
  public abstract boolean zza(@NullableDecl K paramK, @NullableDecl V paramV);
  
  public abstract Collection<V> zzb(@NullableDecl K paramK);
  
  public abstract Map<K, Collection<V>> zzg();
  
  public abstract Set<K> zzh();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */