package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class a1<K, V>
  extends g<K, V>
  implements Serializable
{
  @NullableDecl
  final K c;
  @NullableDecl
  final V d;
  
  a1(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    this.c = paramK;
    this.d = paramV;
  }
  
  @NullableDecl
  public final K getKey()
  {
    return (K)this.c;
  }
  
  @NullableDecl
  public final V getValue()
  {
    return (V)this.d;
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\a1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */