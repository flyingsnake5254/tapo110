package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ArrayTable<R, C, V>
  extends q<R, C, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final V[][] array;
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  private final ImmutableList<C> columnList;
  @MonotonicNonNullDecl
  private transient ArrayTable<R, C, V>.f columnMap;
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  private final ImmutableList<R> rowList;
  @MonotonicNonNullDecl
  private transient ArrayTable<R, C, V>.h rowMap;
  
  private ArrayTable(ArrayTable<R, C, V> paramArrayTable)
  {
    Object localObject1 = paramArrayTable.rowList;
    this.rowList = ((ImmutableList)localObject1);
    Object localObject2 = paramArrayTable.columnList;
    this.columnList = ((ImmutableList)localObject2);
    this.rowKeyToIndex = paramArrayTable.rowKeyToIndex;
    this.columnKeyToIndex = paramArrayTable.columnKeyToIndex;
    localObject1 = new Object[((AbstractCollection)localObject1).size()][((AbstractCollection)localObject2).size()];
    this.array = ((Object[][])localObject1);
    for (int i = 0; i < this.rowList.size(); i++)
    {
      localObject2 = paramArrayTable.array;
      System.arraycopy(localObject2[i], 0, localObject1[i], 0, localObject2[i].length);
    }
  }
  
  private ArrayTable(f3<R, C, V> paramf3)
  {
    this(paramf3.rowKeySet(), paramf3.columnKeySet());
    putAll(paramf3);
  }
  
  private ArrayTable(Iterable<? extends R> paramIterable, Iterable<? extends C> paramIterable1)
  {
    paramIterable = ImmutableList.copyOf(paramIterable);
    this.rowList = paramIterable;
    paramIterable1 = ImmutableList.copyOf(paramIterable1);
    this.columnList = paramIterable1;
    boolean bool;
    if (paramIterable.isEmpty() == paramIterable1.isEmpty()) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    this.rowKeyToIndex = q1.j(paramIterable);
    this.columnKeyToIndex = q1.j(paramIterable1);
    this.array = new Object[paramIterable.size()][paramIterable1.size()];
    eraseAll();
  }
  
  public static <R, C, V> ArrayTable<R, C, V> create(f3<R, C, V> paramf3)
  {
    if ((paramf3 instanceof ArrayTable)) {
      paramf3 = new ArrayTable((ArrayTable)paramf3);
    } else {
      paramf3 = new ArrayTable(paramf3);
    }
    return paramf3;
  }
  
  public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> paramIterable, Iterable<? extends C> paramIterable1)
  {
    return new ArrayTable(paramIterable, paramIterable1);
  }
  
  private f3.a<R, C, V> getCell(final int paramInt)
  {
    return new b(paramInt);
  }
  
  private V getValue(int paramInt)
  {
    return (V)at(paramInt / this.columnList.size(), paramInt % this.columnList.size());
  }
  
  public V at(int paramInt1, int paramInt2)
  {
    n.m(paramInt1, this.rowList.size());
    n.m(paramInt2, this.columnList.size());
    return (V)this.array[paramInt1][paramInt2];
  }
  
  Iterator<f3.a<R, C, V>> cellIterator()
  {
    return new a(size());
  }
  
  public Set<f3.a<R, C, V>> cellSet()
  {
    return super.cellSet();
  }
  
  @Deprecated
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<R, V> column(C paramC)
  {
    n.o(paramC);
    paramC = (Integer)this.columnKeyToIndex.get(paramC);
    if (paramC == null) {
      paramC = ImmutableMap.of();
    } else {
      paramC = new e(paramC.intValue());
    }
    return paramC;
  }
  
  public ImmutableList<C> columnKeyList()
  {
    return this.columnList;
  }
  
  public ImmutableSet<C> columnKeySet()
  {
    return this.columnKeyToIndex.keySet();
  }
  
  public Map<C, Map<R, V>> columnMap()
  {
    f localf1 = this.columnMap;
    f localf2 = localf1;
    if (localf1 == null)
    {
      localf2 = new f(null);
      this.columnMap = localf2;
    }
    return localf2;
  }
  
  public boolean contains(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    boolean bool;
    if ((containsRow(paramObject1)) && (containsColumn(paramObject2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsColumn(@NullableDecl Object paramObject)
  {
    return this.columnKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsRow(@NullableDecl Object paramObject)
  {
    return this.rowKeyToIndex.containsKey(paramObject);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    for (Object[] arrayOfObject1 : this.array)
    {
      int k = arrayOfObject1.length;
      for (int m = 0; m < k; m++) {
        if (k.a(paramObject, arrayOfObject1[m])) {
          return true;
        }
      }
    }
    return false;
  }
  
  @CanIgnoreReturnValue
  public V erase(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    paramObject1 = (Integer)this.rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)this.columnKeyToIndex.get(paramObject2);
    if ((paramObject1 != null) && (paramObject2 != null)) {
      return (V)set(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), null);
    }
    return null;
  }
  
  public void eraseAll()
  {
    Object[][] arrayOfObject = this.array;
    int i = arrayOfObject.length;
    for (int j = 0; j < i; j++) {
      Arrays.fill(arrayOfObject[j], null);
    }
  }
  
  public V get(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    paramObject1 = (Integer)this.rowKeyToIndex.get(paramObject1);
    paramObject2 = (Integer)this.columnKeyToIndex.get(paramObject2);
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = at(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue());
    } else {
      paramObject1 = null;
    }
    return (V)paramObject1;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if ((!this.rowList.isEmpty()) && (!this.columnList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public V put(R paramR, C paramC, @NullableDecl V paramV)
  {
    n.o(paramR);
    n.o(paramC);
    Integer localInteger = (Integer)this.rowKeyToIndex.get(paramR);
    boolean bool1 = true;
    boolean bool2;
    if (localInteger != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.k(bool2, "Row %s not in %s", paramR, this.rowList);
    paramR = (Integer)this.columnKeyToIndex.get(paramC);
    if (paramR != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    n.k(bool2, "Column %s not in %s", paramC, this.columnList);
    return (V)set(localInteger.intValue(), paramR.intValue(), paramV);
  }
  
  public void putAll(f3<? extends R, ? extends C, ? extends V> paramf3)
  {
    super.putAll(paramf3);
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public V remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<C, V> row(R paramR)
  {
    n.o(paramR);
    paramR = (Integer)this.rowKeyToIndex.get(paramR);
    if (paramR == null) {
      paramR = ImmutableMap.of();
    } else {
      paramR = new g(paramR.intValue());
    }
    return paramR;
  }
  
  public ImmutableList<R> rowKeyList()
  {
    return this.rowList;
  }
  
  public ImmutableSet<R> rowKeySet()
  {
    return this.rowKeyToIndex.keySet();
  }
  
  public Map<R, Map<C, V>> rowMap()
  {
    h localh1 = this.rowMap;
    h localh2 = localh1;
    if (localh1 == null)
    {
      localh2 = new h(null);
      this.rowMap = localh2;
    }
    return localh2;
  }
  
  @CanIgnoreReturnValue
  public V set(int paramInt1, int paramInt2, @NullableDecl V paramV)
  {
    n.m(paramInt1, this.rowList.size());
    n.m(paramInt2, this.columnList.size());
    Object[][] arrayOfObject = this.array;
    Object localObject = arrayOfObject[paramInt1][paramInt2];
    arrayOfObject[paramInt1][paramInt2] = paramV;
    return (V)localObject;
  }
  
  public int size()
  {
    return this.rowList.size() * this.columnList.size();
  }
  
  public V[][] toArray(Class<V> paramClass)
  {
    paramClass = (Object[][])Array.newInstance(paramClass, new int[] { this.rowList.size(), this.columnList.size() });
    for (int i = 0; i < this.rowList.size(); i++)
    {
      Object[][] arrayOfObject = this.array;
      System.arraycopy(arrayOfObject[i], 0, paramClass[i], 0, arrayOfObject[i].length);
    }
    return paramClass;
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  Iterator<V> valuesIterator()
  {
    return new c(size());
  }
  
  class a
    extends b<f3.a<R, C, V>>
  {
    a(int paramInt)
    {
      super();
    }
    
    protected f3.a<R, C, V> b(int paramInt)
    {
      return ArrayTable.this.getCell(paramInt);
    }
  }
  
  class b
    extends g3.b<R, C, V>
  {
    final int c;
    final int d;
    
    b(int paramInt)
    {
      this.c = (paramInt / ArrayTable.this.columnList.size());
      this.d = (paramInt % ArrayTable.this.columnList.size());
    }
    
    public R a()
    {
      return (R)ArrayTable.this.rowList.get(this.c);
    }
    
    public C b()
    {
      return (C)ArrayTable.this.columnList.get(this.d);
    }
    
    public V getValue()
    {
      return (V)ArrayTable.this.at(this.c, this.d);
    }
  }
  
  class c
    extends b<V>
  {
    c(int paramInt)
    {
      super();
    }
    
    protected V a(int paramInt)
    {
      return (V)ArrayTable.this.getValue(paramInt);
    }
  }
  
  private static abstract class d<K, V>
    extends q1.l<K, V>
  {
    private final ImmutableMap<K, Integer> c;
    
    private d(ImmutableMap<K, Integer> paramImmutableMap)
    {
      this.c = paramImmutableMap;
    }
    
    Iterator<Map.Entry<K, V>> a()
    {
      return new b(size());
    }
    
    Map.Entry<K, V> b(final int paramInt)
    {
      n.m(paramInt, size());
      return new a(paramInt);
    }
    
    K c(int paramInt)
    {
      return (K)this.c.keySet().asList().get(paramInt);
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean containsKey(@NullableDecl Object paramObject)
    {
      return this.c.containsKey(paramObject);
    }
    
    abstract String d();
    
    @NullableDecl
    abstract V e(int paramInt);
    
    @NullableDecl
    abstract V f(int paramInt, V paramV);
    
    public V get(@NullableDecl Object paramObject)
    {
      paramObject = (Integer)this.c.get(paramObject);
      if (paramObject == null) {
        return null;
      }
      return (V)e(((Integer)paramObject).intValue());
    }
    
    public boolean isEmpty()
    {
      return this.c.isEmpty();
    }
    
    public Set<K> keySet()
    {
      return this.c.keySet();
    }
    
    public V put(K paramK, V paramV)
    {
      Integer localInteger = (Integer)this.c.get(paramK);
      if (localInteger != null) {
        return (V)f(localInteger.intValue(), paramV);
      }
      paramV = new StringBuilder();
      paramV.append(d());
      paramV.append(" ");
      paramV.append(paramK);
      paramV.append(" not in ");
      paramV.append(this.c.keySet());
      throw new IllegalArgumentException(paramV.toString());
    }
    
    public V remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return this.c.size();
    }
    
    class a
      extends g<K, V>
    {
      a(int paramInt) {}
      
      public K getKey()
      {
        return (K)ArrayTable.d.this.c(paramInt);
      }
      
      public V getValue()
      {
        return (V)ArrayTable.d.this.e(paramInt);
      }
      
      public V setValue(V paramV)
      {
        return (V)ArrayTable.d.this.f(paramInt, paramV);
      }
    }
    
    class b
      extends b<Map.Entry<K, V>>
    {
      b(int paramInt)
      {
        super();
      }
      
      protected Map.Entry<K, V> b(int paramInt)
      {
        return ArrayTable.d.this.b(paramInt);
      }
    }
  }
  
  private class e
    extends ArrayTable.d<R, V>
  {
    final int d;
    
    e(int paramInt)
    {
      super(null);
      this.d = paramInt;
    }
    
    String d()
    {
      return "Row";
    }
    
    V e(int paramInt)
    {
      return (V)ArrayTable.this.at(paramInt, this.d);
    }
    
    V f(int paramInt, V paramV)
    {
      return (V)ArrayTable.this.set(paramInt, this.d, paramV);
    }
  }
  
  private class f
    extends ArrayTable.d<C, Map<R, V>>
  {
    private f()
    {
      super(null);
    }
    
    String d()
    {
      return "Column";
    }
    
    Map<R, V> g(int paramInt)
    {
      return new ArrayTable.e(ArrayTable.this, paramInt);
    }
    
    public Map<R, V> h(C paramC, Map<R, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    Map<R, V> i(int paramInt, Map<R, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private class g
    extends ArrayTable.d<C, V>
  {
    final int d;
    
    g(int paramInt)
    {
      super(null);
      this.d = paramInt;
    }
    
    String d()
    {
      return "Column";
    }
    
    V e(int paramInt)
    {
      return (V)ArrayTable.this.at(this.d, paramInt);
    }
    
    V f(int paramInt, V paramV)
    {
      return (V)ArrayTable.this.set(this.d, paramInt, paramV);
    }
  }
  
  private class h
    extends ArrayTable.d<R, Map<C, V>>
  {
    private h()
    {
      super(null);
    }
    
    String d()
    {
      return "Row";
    }
    
    Map<C, V> g(int paramInt)
    {
      return new ArrayTable.g(ArrayTable.this, paramInt);
    }
    
    public Map<C, V> h(R paramR, Map<C, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
    
    Map<C, V> i(int paramInt, Map<C, V> paramMap)
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ArrayTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */