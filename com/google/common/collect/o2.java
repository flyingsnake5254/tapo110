package com.google.common.collect;

import com.google.common.base.n;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class o2<R, C, V>
  extends ImmutableTable<R, C, V>
{
  static <R, C, V> o2<R, C, V> b(List<f3.a<R, C, V>> paramList, @NullableDecl Comparator<? super R> paramComparator, @NullableDecl final Comparator<? super C> paramComparator1)
  {
    n.o(paramList);
    if ((paramComparator != null) || (paramComparator1 != null)) {
      Collections.sort(paramList, new a(paramComparator, paramComparator1));
    }
    return d(paramList, paramComparator, paramComparator1);
  }
  
  private static <R, C, V> o2<R, C, V> d(Iterable<f3.a<R, C, V>> paramIterable, @NullableDecl Comparator<? super R> paramComparator, @NullableDecl Comparator<? super C> paramComparator1)
  {
    LinkedHashSet localLinkedHashSet1 = new LinkedHashSet();
    LinkedHashSet localLinkedHashSet2 = new LinkedHashSet();
    ImmutableList localImmutableList = ImmutableList.copyOf(paramIterable);
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (f3.a)localIterator.next();
      localLinkedHashSet1.add(paramIterable.a());
      localLinkedHashSet2.add(paramIterable.b());
    }
    if (paramComparator == null) {
      paramIterable = ImmutableSet.copyOf(localLinkedHashSet1);
    } else {
      paramIterable = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(paramComparator, localLinkedHashSet1));
    }
    if (paramComparator1 == null) {
      paramComparator = ImmutableSet.copyOf(localLinkedHashSet2);
    } else {
      paramComparator = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(paramComparator1, localLinkedHashSet2));
    }
    return f(localImmutableList, paramIterable, paramComparator);
  }
  
  static <R, C, V> o2<R, C, V> f(ImmutableList<f3.a<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1)
  {
    if (paramImmutableList.size() > paramImmutableSet.size() * paramImmutableSet1.size() / 2L) {
      paramImmutableList = new e0(paramImmutableList, paramImmutableSet, paramImmutableSet1);
    } else {
      paramImmutableList = new c3(paramImmutableList, paramImmutableSet, paramImmutableSet1);
    }
    return paramImmutableList;
  }
  
  final void a(R paramR, C paramC, V paramV1, V paramV2)
  {
    boolean bool;
    if (paramV1 == null) {
      bool = true;
    } else {
      bool = false;
    }
    n.l(bool, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", paramR, paramC, paramV2, paramV1);
  }
  
  final ImmutableSet<f3.a<R, C, V>> createCellSet()
  {
    Object localObject;
    if (isEmpty()) {
      localObject = ImmutableSet.of();
    } else {
      localObject = new b(null);
    }
    return (ImmutableSet<f3.a<R, C, V>>)localObject;
  }
  
  final ImmutableCollection<V> createValues()
  {
    Object localObject;
    if (isEmpty()) {
      localObject = ImmutableList.of();
    } else {
      localObject = new c(null);
    }
    return (ImmutableCollection<V>)localObject;
  }
  
  abstract f3.a<R, C, V> getCell(int paramInt);
  
  abstract V getValue(int paramInt);
  
  static final class a
    implements Comparator<f3.a<R, C, V>>
  {
    a(Comparator paramComparator1, Comparator paramComparator2) {}
    
    public int a(f3.a<R, C, V> parama1, f3.a<R, C, V> parama2)
    {
      Comparator localComparator = this.c;
      int i = 0;
      int j;
      if (localComparator == null) {
        j = 0;
      } else {
        j = localComparator.compare(parama1.a(), parama2.a());
      }
      if (j != 0) {
        return j;
      }
      localComparator = paramComparator1;
      if (localComparator == null) {
        j = i;
      } else {
        j = localComparator.compare(parama1.b(), parama2.b());
      }
      return j;
    }
  }
  
  private final class b
    extends i1<f3.a<R, C, V>>
  {
    private b() {}
    
    f3.a<R, C, V> a(int paramInt)
    {
      return o2.this.getCell(paramInt);
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof f3.a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        f3.a locala = (f3.a)paramObject;
        paramObject = o2.this.get(locala.a(), locala.b());
        bool3 = bool2;
        if (paramObject != null)
        {
          bool3 = bool2;
          if (paramObject.equals(locala.getValue())) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public int size()
    {
      return o2.this.size();
    }
  }
  
  private final class c
    extends ImmutableList<V>
  {
    private c() {}
    
    public V get(int paramInt)
    {
      return (V)o2.this.getValue(paramInt);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return o2.this.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\o2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */