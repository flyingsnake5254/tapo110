package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Immutable(containerOf={"R", "C", "V"})
final class c3<R, C, V>
  extends o2<R, C, V>
{
  static final ImmutableTable<Object, Object, Object> c = new c3(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
  private final ImmutableMap<R, ImmutableMap<C, V>> d;
  private final ImmutableMap<C, ImmutableMap<R, V>> f;
  private final int[] q;
  private final int[] x;
  
  c3(ImmutableList<f3.a<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1)
  {
    ImmutableMap localImmutableMap = q1.j(paramImmutableSet);
    Object localObject1 = q1.r();
    paramImmutableSet = paramImmutableSet.iterator();
    while (paramImmutableSet.hasNext()) {
      ((Map)localObject1).put(paramImmutableSet.next(), new LinkedHashMap());
    }
    paramImmutableSet = q1.r();
    paramImmutableSet1 = paramImmutableSet1.iterator();
    while (paramImmutableSet1.hasNext()) {
      paramImmutableSet.put(paramImmutableSet1.next(), new LinkedHashMap());
    }
    paramImmutableSet1 = new int[paramImmutableList.size()];
    int[] arrayOfInt = new int[paramImmutableList.size()];
    for (int i = 0; i < paramImmutableList.size(); i++)
    {
      Object localObject2 = (f3.a)paramImmutableList.get(i);
      Object localObject3 = ((f3.a)localObject2).a();
      Object localObject4 = ((f3.a)localObject2).b();
      Object localObject5 = ((f3.a)localObject2).getValue();
      paramImmutableSet1[i] = ((Integer)localImmutableMap.get(localObject3)).intValue();
      localObject2 = (Map)((Map)localObject1).get(localObject3);
      arrayOfInt[i] = ((Map)localObject2).size();
      a(localObject3, localObject4, ((Map)localObject2).put(localObject4, localObject5), localObject5);
      ((Map)paramImmutableSet.get(localObject4)).put(localObject3, localObject5);
    }
    this.q = paramImmutableSet1;
    this.x = arrayOfInt;
    paramImmutableList = new ImmutableMap.b(((Map)localObject1).size());
    paramImmutableSet1 = ((Map)localObject1).entrySet().iterator();
    while (paramImmutableSet1.hasNext())
    {
      localObject1 = (Map.Entry)paramImmutableSet1.next();
      paramImmutableList.c(((Map.Entry)localObject1).getKey(), ImmutableMap.copyOf((Map)((Map.Entry)localObject1).getValue()));
    }
    this.d = paramImmutableList.a();
    paramImmutableList = new ImmutableMap.b(paramImmutableSet.size());
    paramImmutableSet = paramImmutableSet.entrySet().iterator();
    while (paramImmutableSet.hasNext())
    {
      paramImmutableSet1 = (Map.Entry)paramImmutableSet.next();
      paramImmutableList.c(paramImmutableSet1.getKey(), ImmutableMap.copyOf((Map)paramImmutableSet1.getValue()));
    }
    this.f = paramImmutableList.a();
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return ImmutableMap.copyOf(this.f);
  }
  
  ImmutableTable.b createSerializedForm()
  {
    ImmutableMap localImmutableMap = q1.j(columnKeySet());
    int[] arrayOfInt = new int[cellSet().size()];
    j3 localj3 = cellSet().iterator();
    for (int i = 0; localj3.hasNext(); i++) {
      arrayOfInt[i] = ((Integer)localImmutableMap.get(((f3.a)localj3.next()).b())).intValue();
    }
    return ImmutableTable.b.a(this, this.q, arrayOfInt);
  }
  
  f3.a<R, C, V> getCell(int paramInt)
  {
    int i = this.q[paramInt];
    Map.Entry localEntry = (Map.Entry)this.d.entrySet().asList().get(i);
    Object localObject = (ImmutableMap)localEntry.getValue();
    paramInt = this.x[paramInt];
    localObject = (Map.Entry)((ImmutableMap)localObject).entrySet().asList().get(paramInt);
    return ImmutableTable.cellOf(localEntry.getKey(), ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
  }
  
  V getValue(int paramInt)
  {
    int i = this.q[paramInt];
    ImmutableMap localImmutableMap = (ImmutableMap)this.d.values().asList().get(i);
    paramInt = this.x[paramInt];
    return (V)localImmutableMap.values().asList().get(paramInt);
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return ImmutableMap.copyOf(this.d);
  }
  
  public int size()
  {
    return this.q.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\c3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */