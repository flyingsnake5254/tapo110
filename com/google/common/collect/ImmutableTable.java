package com.google.common.collect;

import com.google.common.base.j;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableTable<R, C, V>
  extends q<R, C, V>
  implements Serializable
{
  public static <R, C, V> a<R, C, V> builder()
  {
    return new a();
  }
  
  static <R, C, V> f3.a<R, C, V> cellOf(R paramR, C paramC, V paramV)
  {
    return g3.b(n.p(paramR, "rowKey"), n.p(paramC, "columnKey"), n.p(paramV, "value"));
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> copyOf(f3<? extends R, ? extends C, ? extends V> paramf3)
  {
    if ((paramf3 instanceof ImmutableTable)) {
      return (ImmutableTable)paramf3;
    }
    return copyOf(paramf3.cellSet());
  }
  
  private static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends f3.a<? extends R, ? extends C, ? extends V>> paramIterable)
  {
    a locala = builder();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      locala.b((f3.a)paramIterable.next());
    }
    return locala.a();
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> of()
  {
    return c3.c;
  }
  
  public static <R, C, V> ImmutableTable<R, C, V> of(R paramR, C paramC, V paramV)
  {
    return new w2(paramR, paramC, paramV);
  }
  
  final j3<f3.a<R, C, V>> cellIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSet<f3.a<R, C, V>> cellSet()
  {
    return (ImmutableSet)super.cellSet();
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<R, V> column(C paramC)
  {
    n.p(paramC, "columnKey");
    return (ImmutableMap)j.a((ImmutableMap)columnMap().get(paramC), ImmutableMap.of());
  }
  
  public ImmutableSet<C> columnKeySet()
  {
    return columnMap().keySet();
  }
  
  public abstract ImmutableMap<C, Map<R, V>> columnMap();
  
  public boolean contains(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    boolean bool;
    if (get(paramObject1, paramObject2) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  abstract ImmutableSet<f3.a<R, C, V>> createCellSet();
  
  abstract b createSerializedForm();
  
  abstract ImmutableCollection<V> createValues();
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V put(R paramR, C paramC, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(f3<? extends R, ? extends C, ? extends V> paramf3)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final V remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<C, V> row(R paramR)
  {
    n.p(paramR, "rowKey");
    return (ImmutableMap)j.a((ImmutableMap)rowMap().get(paramR), ImmutableMap.of());
  }
  
  public ImmutableSet<R> rowKeySet()
  {
    return rowMap().keySet();
  }
  
  public abstract ImmutableMap<R, Map<C, V>> rowMap();
  
  public ImmutableCollection<V> values()
  {
    return (ImmutableCollection)super.values();
  }
  
  final Iterator<V> valuesIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  final Object writeReplace()
  {
    return createSerializedForm();
  }
  
  public static final class a<R, C, V>
  {
    private final List<f3.a<R, C, V>> a = n1.h();
    @MonotonicNonNullDecl
    private Comparator<? super R> b;
    @MonotonicNonNullDecl
    private Comparator<? super C> c;
    
    public ImmutableTable<R, C, V> a()
    {
      int i = this.a.size();
      if (i != 0)
      {
        if (i != 1) {
          return o2.b(this.a, this.b, this.c);
        }
        return new w2((f3.a)j1.i(this.a));
      }
      return ImmutableTable.of();
    }
    
    @CanIgnoreReturnValue
    public a<R, C, V> b(f3.a<? extends R, ? extends C, ? extends V> parama)
    {
      if ((parama instanceof g3.c))
      {
        n.p(parama.a(), "row");
        n.p(parama.b(), "column");
        n.p(parama.getValue(), "value");
        this.a.add(parama);
      }
      else
      {
        c(parama.a(), parama.b(), parama.getValue());
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<R, C, V> c(R paramR, C paramC, V paramV)
    {
      this.a.add(ImmutableTable.cellOf(paramR, paramC, paramV));
      return this;
    }
  }
  
  static final class b
    implements Serializable
  {
    private final Object[] c;
    private final Object[] d;
    private final Object[] f;
    private final int[] q;
    private final int[] x;
    
    private b(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Object[] paramArrayOfObject3, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.c = paramArrayOfObject1;
      this.d = paramArrayOfObject2;
      this.f = paramArrayOfObject3;
      this.q = paramArrayOfInt1;
      this.x = paramArrayOfInt2;
    }
    
    static b a(ImmutableTable<?, ?, ?> paramImmutableTable, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      return new b(paramImmutableTable.rowKeySet().toArray(), paramImmutableTable.columnKeySet().toArray(), paramImmutableTable.values().toArray(), paramArrayOfInt1, paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */