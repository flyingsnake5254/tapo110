package com.google.common.collect;

import com.google.common.base.n;
import java.util.Map;

class w2<R, C, V>
  extends ImmutableTable<R, C, V>
{
  final R c;
  final C d;
  final V f;
  
  w2(f3.a<R, C, V> parama)
  {
    this(parama.a(), parama.b(), parama.getValue());
  }
  
  w2(R paramR, C paramC, V paramV)
  {
    this.c = n.o(paramR);
    this.d = n.o(paramC);
    this.f = n.o(paramV);
  }
  
  public ImmutableMap<R, V> column(C paramC)
  {
    n.o(paramC);
    if (containsColumn(paramC)) {
      paramC = ImmutableMap.of(this.c, this.f);
    } else {
      paramC = ImmutableMap.of();
    }
    return paramC;
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return ImmutableMap.of(this.d, ImmutableMap.of(this.c, this.f));
  }
  
  ImmutableSet<f3.a<R, C, V>> createCellSet()
  {
    return ImmutableSet.of(ImmutableTable.cellOf(this.c, this.d, this.f));
  }
  
  ImmutableTable.b createSerializedForm()
  {
    return ImmutableTable.b.a(this, new int[] { 0 }, new int[] { 0 });
  }
  
  ImmutableCollection<V> createValues()
  {
    return ImmutableSet.of(this.f);
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return ImmutableMap.of(this.c, ImmutableMap.of(this.d, this.f));
  }
  
  public int size()
  {
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\w2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */