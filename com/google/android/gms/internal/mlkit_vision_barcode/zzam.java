package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzam<K, V>
  extends zzu<K, V>
  implements Serializable
{
  @NullableDecl
  private final K zza;
  @NullableDecl
  private final V zzb;
  
  zzam(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    this.zza = paramK;
    this.zzb = paramV;
  }
  
  @NullableDecl
  public final K getKey()
  {
    return (K)this.zza;
  }
  
  @NullableDecl
  public final V getValue()
  {
    return (V)this.zzb;
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */