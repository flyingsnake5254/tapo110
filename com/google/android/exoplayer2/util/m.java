package com.google.android.exoplayer2.util;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m<E>
  implements Iterable<E>
{
  private final Object c = new Object();
  @GuardedBy("lock")
  private final Map<E, Integer> d = new HashMap();
  @GuardedBy("lock")
  private Set<E> f = Collections.emptySet();
  @GuardedBy("lock")
  private List<E> q = Collections.emptyList();
  
  public void a(E paramE)
  {
    synchronized (this.c)
    {
      Object localObject2 = new java/util/ArrayList;
      ((ArrayList)localObject2).<init>(this.q);
      ((List)localObject2).add(paramE);
      this.q = Collections.unmodifiableList((List)localObject2);
      localObject2 = (Integer)this.d.get(paramE);
      if (localObject2 == null)
      {
        localObject3 = new java/util/HashSet;
        ((HashSet)localObject3).<init>(this.f);
        ((Set)localObject3).add(paramE);
        this.f = Collections.unmodifiableSet((Set)localObject3);
      }
      Object localObject3 = this.d;
      int i = 1;
      if (localObject2 != null) {
        i = 1 + ((Integer)localObject2).intValue();
      }
      ((Map)localObject3).put(paramE, Integer.valueOf(i));
      return;
    }
  }
  
  public void b(E paramE)
  {
    synchronized (this.c)
    {
      Object localObject2 = (Integer)this.d.get(paramE);
      if (localObject2 == null) {
        return;
      }
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(this.q);
      localArrayList.remove(paramE);
      this.q = Collections.unmodifiableList(localArrayList);
      if (((Integer)localObject2).intValue() == 1)
      {
        this.d.remove(paramE);
        localObject2 = new java/util/HashSet;
        ((HashSet)localObject2).<init>(this.f);
        ((Set)localObject2).remove(paramE);
        this.f = Collections.unmodifiableSet((Set)localObject2);
      }
      else
      {
        this.d.put(paramE, Integer.valueOf(((Integer)localObject2).intValue() - 1));
      }
      return;
    }
  }
  
  public int count(E paramE)
  {
    synchronized (this.c)
    {
      int i;
      if (this.d.containsKey(paramE)) {
        i = ((Integer)this.d.get(paramE)).intValue();
      } else {
        i = 0;
      }
      return i;
    }
  }
  
  public Set<E> elementSet()
  {
    synchronized (this.c)
    {
      Set localSet = this.f;
      return localSet;
    }
  }
  
  public Iterator<E> iterator()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.q.iterator();
      return localIterator;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */