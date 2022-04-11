package com.google.common.collect;

import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class h2<K, V>
  extends ImmutableBiMap<K, V>
{
  static final h2<Object, Object> c = new h2();
  private final transient int[] d;
  final transient Object[] f;
  private final transient int q;
  private final transient int x;
  private final transient h2<V, K> y;
  
  private h2()
  {
    this.d = null;
    this.f = new Object[0];
    this.q = 0;
    this.x = 0;
    this.y = this;
  }
  
  private h2(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt, h2<V, K> paramh2)
  {
    this.d = paramArrayOfInt;
    this.f = paramArrayOfObject;
    this.q = 1;
    this.x = paramInt;
    this.y = paramh2;
  }
  
  h2(Object[] paramArrayOfObject, int paramInt)
  {
    this.f = paramArrayOfObject;
    this.x = paramInt;
    this.q = 0;
    int i;
    if (paramInt >= 2) {
      i = ImmutableSet.chooseTableSize(paramInt);
    } else {
      i = 0;
    }
    this.d = j2.b(paramArrayOfObject, paramInt, i, 0);
    this.y = new h2(j2.b(paramArrayOfObject, paramInt, i, 1), paramArrayOfObject, paramInt, this);
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    return new j2.a(this, this.f, this.q, this.x);
  }
  
  ImmutableSet<K> createKeySet()
  {
    return new j2.b(this, new j2.c(this.f, this.q, this.x));
  }
  
  public V get(@NullableDecl Object paramObject)
  {
    return (V)j2.d(this.d, this.f, this.x, this.q, paramObject);
  }
  
  public ImmutableBiMap<V, K> inverse()
  {
    return this.y;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.x;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\h2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */