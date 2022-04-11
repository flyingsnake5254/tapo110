package com.google.common.collect;

import com.google.common.base.n;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class j2<K, V>
  extends ImmutableMap<K, V>
{
  static final ImmutableMap<Object, Object> c = new j2(null, new Object[0], 0);
  private final transient int[] d;
  final transient Object[] f;
  private final transient int q;
  
  private j2(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    this.d = paramArrayOfInt;
    this.f = paramArrayOfObject;
    this.q = paramInt;
  }
  
  static <K, V> j2<K, V> a(int paramInt, Object[] paramArrayOfObject)
  {
    if (paramInt == 0) {
      return (j2)c;
    }
    if (paramInt == 1)
    {
      v.a(paramArrayOfObject[0], paramArrayOfObject[1]);
      return new j2(null, paramArrayOfObject, 1);
    }
    n.r(paramInt, paramArrayOfObject.length >> 1);
    return new j2(b(paramArrayOfObject, paramInt, ImmutableSet.chooseTableSize(paramInt), 0), paramArrayOfObject, paramInt);
  }
  
  static int[] b(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 1)
    {
      v.a(paramArrayOfObject[paramInt3], paramArrayOfObject[(paramInt3 ^ 0x1)]);
      return null;
    }
    Object localObject1 = new int[paramInt2];
    Arrays.fill((int[])localObject1, -1);
    int i = 0;
    if (i < paramInt1)
    {
      int j = i * 2;
      int k = j + paramInt3;
      Object localObject2 = paramArrayOfObject[k];
      Object localObject3 = paramArrayOfObject[(j + (paramInt3 ^ 0x1))];
      v.a(localObject2, localObject3);
      int m;
      for (j = y0.c(localObject2.hashCode());; j = m + 1)
      {
        m = j & paramInt2 - 1;
        j = localObject1[m];
        if (j == -1)
        {
          localObject1[m] = k;
          i++;
          break;
        }
        if (paramArrayOfObject[j].equals(localObject2)) {
          break label138;
        }
      }
      label138:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Multiple entries with same key: ");
      ((StringBuilder)localObject1).append(localObject2);
      ((StringBuilder)localObject1).append("=");
      ((StringBuilder)localObject1).append(localObject3);
      ((StringBuilder)localObject1).append(" and ");
      ((StringBuilder)localObject1).append(paramArrayOfObject[j]);
      ((StringBuilder)localObject1).append("=");
      ((StringBuilder)localObject1).append(paramArrayOfObject[(j ^ 0x1)]);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    return (int[])localObject1;
  }
  
  static Object d(@NullableDecl int[] paramArrayOfInt, @NullableDecl Object[] paramArrayOfObject, int paramInt1, int paramInt2, @NullableDecl Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return null;
    }
    if (paramInt1 == 1)
    {
      paramArrayOfInt = (int[])localObject;
      if (paramArrayOfObject[paramInt2].equals(paramObject)) {
        paramArrayOfInt = paramArrayOfObject[(paramInt2 ^ 0x1)];
      }
      return paramArrayOfInt;
    }
    if (paramArrayOfInt == null) {
      return null;
    }
    paramInt2 = paramArrayOfInt.length;
    int i;
    for (paramInt1 = y0.c(paramObject.hashCode());; paramInt1 = i + 1)
    {
      i = paramInt1 & paramInt2 - 1;
      paramInt1 = paramArrayOfInt[i];
      if (paramInt1 == -1) {
        return null;
      }
      if (paramArrayOfObject[paramInt1].equals(paramObject)) {
        return paramArrayOfObject[(paramInt1 ^ 0x1)];
      }
    }
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    return new a(this, this.f, 0, this.q);
  }
  
  ImmutableSet<K> createKeySet()
  {
    return new b(this, new c(this.f, 0, this.q));
  }
  
  ImmutableCollection<V> createValues()
  {
    return new c(this.f, 1, this.q);
  }
  
  @NullableDecl
  public V get(@NullableDecl Object paramObject)
  {
    return (V)d(this.d, this.f, this.q, 0, paramObject);
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.q;
  }
  
  static class a<K, V>
    extends ImmutableSet<Map.Entry<K, V>>
  {
    private final transient ImmutableMap<K, V> c;
    private final transient Object[] d;
    private final transient int f;
    private final transient int q;
    
    a(ImmutableMap<K, V> paramImmutableMap, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
    {
      this.c = paramImmutableMap;
      this.d = paramArrayOfObject;
      this.f = paramInt1;
      this.q = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        Object localObject = (Map.Entry)paramObject;
        paramObject = ((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        bool3 = bool2;
        if (localObject != null)
        {
          bool3 = bool2;
          if (localObject.equals(this.c.get(paramObject))) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
    {
      return asList().copyIntoArray(paramArrayOfObject, paramInt);
    }
    
    ImmutableList<Map.Entry<K, V>> createAsList()
    {
      return new a();
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public j3<Map.Entry<K, V>> iterator()
    {
      return asList().iterator();
    }
    
    public int size()
    {
      return this.q;
    }
    
    class a
      extends ImmutableList<Map.Entry<K, V>>
    {
      a() {}
      
      public Map.Entry<K, V> a(int paramInt)
      {
        n.m(paramInt, j2.a.a(j2.a.this));
        Object[] arrayOfObject = j2.a.b(j2.a.this);
        paramInt *= 2;
        return new AbstractMap.SimpleImmutableEntry(arrayOfObject[(j2.a.d(j2.a.this) + paramInt)], j2.a.b(j2.a.this)[(paramInt + (j2.a.d(j2.a.this) ^ 0x1))]);
      }
      
      public boolean isPartialView()
      {
        return true;
      }
      
      public int size()
      {
        return j2.a.a(j2.a.this);
      }
    }
  }
  
  static final class b<K>
    extends ImmutableSet<K>
  {
    private final transient ImmutableMap<K, ?> c;
    private final transient ImmutableList<K> d;
    
    b(ImmutableMap<K, ?> paramImmutableMap, ImmutableList<K> paramImmutableList)
    {
      this.c = paramImmutableMap;
      this.d = paramImmutableList;
    }
    
    public ImmutableList<K> asList()
    {
      return this.d;
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      boolean bool;
      if (this.c.get(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
    {
      return asList().copyIntoArray(paramArrayOfObject, paramInt);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public j3<K> iterator()
    {
      return asList().iterator();
    }
    
    public int size()
    {
      return this.c.size();
    }
  }
  
  static final class c
    extends ImmutableList<Object>
  {
    private final transient Object[] c;
    private final transient int d;
    private final transient int f;
    
    c(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
    {
      this.c = paramArrayOfObject;
      this.d = paramInt1;
      this.f = paramInt2;
    }
    
    public Object get(int paramInt)
    {
      n.m(paramInt, this.f);
      return this.c[(paramInt * 2 + this.d)];
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return this.f;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\j2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */