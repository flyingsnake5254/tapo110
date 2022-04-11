package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.base.t;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class d3<R, C, V>
  extends e3<R, C, V>
{
  private static final long serialVersionUID = 0L;
  
  d3(SortedMap<R, Map<C, V>> paramSortedMap, t<? extends Map<C, V>> paramt)
  {
    super(paramSortedMap, paramt);
  }
  
  private SortedMap<R, Map<C, V>> sortedBackingMap()
  {
    return (SortedMap)this.backingMap;
  }
  
  SortedMap<R, Map<C, V>> createRowMap()
  {
    return new b(null);
  }
  
  public SortedSet<R> rowKeySet()
  {
    return (SortedSet)rowMap().keySet();
  }
  
  public SortedMap<R, Map<C, V>> rowMap()
  {
    return (SortedMap)super.rowMap();
  }
  
  private class b
    extends e3<R, C, V>.h
    implements SortedMap<R, Map<C, V>>
  {
    private b()
    {
      super();
    }
    
    public Comparator<? super R> comparator()
    {
      return d3.this.sortedBackingMap().comparator();
    }
    
    SortedSet<R> f()
    {
      return new q1.o(this);
    }
    
    public R firstKey()
    {
      return (R)d3.this.sortedBackingMap().firstKey();
    }
    
    public SortedSet<R> g()
    {
      return (SortedSet)super.keySet();
    }
    
    public SortedMap<R, Map<C, V>> headMap(R paramR)
    {
      n.o(paramR);
      return new d3(d3.this.sortedBackingMap().headMap(paramR), d3.this.factory).rowMap();
    }
    
    public R lastKey()
    {
      return (R)d3.this.sortedBackingMap().lastKey();
    }
    
    public SortedMap<R, Map<C, V>> subMap(R paramR1, R paramR2)
    {
      n.o(paramR1);
      n.o(paramR2);
      return new d3(d3.this.sortedBackingMap().subMap(paramR1, paramR2), d3.this.factory).rowMap();
    }
    
    public SortedMap<R, Map<C, V>> tailMap(R paramR)
    {
      n.o(paramR);
      return new d3(d3.this.sortedBackingMap().tailMap(paramR), d3.this.factory).rowMap();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\d3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */