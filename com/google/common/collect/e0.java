package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.util.AbstractCollection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf={"R", "C", "V"})
final class e0<R, C, V>
  extends o2<R, C, V>
{
  private final ImmutableMap<R, Integer> c;
  private final ImmutableMap<C, Integer> d;
  private final ImmutableMap<R, ImmutableMap<C, V>> f;
  private final int[] p0;
  private final int[] p1;
  private final ImmutableMap<C, ImmutableMap<R, V>> q;
  private final int[] x;
  private final int[] y;
  private final V[][] z;
  
  e0(ImmutableList<f3.a<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1)
  {
    int i = paramImmutableSet.size();
    int j = paramImmutableSet1.size();
    int k = 0;
    this.z = new Object[i][j];
    paramImmutableSet = q1.j(paramImmutableSet);
    this.c = paramImmutableSet;
    paramImmutableSet1 = q1.j(paramImmutableSet1);
    this.d = paramImmutableSet1;
    this.x = new int[paramImmutableSet.size()];
    this.y = new int[paramImmutableSet1.size()];
    paramImmutableSet = new int[paramImmutableList.size()];
    paramImmutableSet1 = new int[paramImmutableList.size()];
    while (k < paramImmutableList.size())
    {
      f3.a locala = (f3.a)paramImmutableList.get(k);
      Object localObject1 = locala.a();
      Object localObject2 = locala.b();
      i = ((Integer)this.c.get(localObject1)).intValue();
      j = ((Integer)this.d.get(localObject2)).intValue();
      a(localObject1, localObject2, this.z[i][j], locala.getValue());
      this.z[i][j] = locala.getValue();
      localObject2 = this.x;
      localObject2[i] += 1;
      localObject2 = this.y;
      localObject2[j] += 1;
      paramImmutableSet[k] = i;
      paramImmutableSet1[k] = j;
      k++;
    }
    this.p0 = paramImmutableSet;
    this.p1 = paramImmutableSet1;
    this.f = new f(null);
    this.q = new c(null);
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return ImmutableMap.copyOf(this.q);
  }
  
  ImmutableTable.b createSerializedForm()
  {
    return ImmutableTable.b.a(this, this.p0, this.p1);
  }
  
  public V get(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    paramObject1 = (Integer)this.c.get(paramObject1);
    paramObject2 = (Integer)this.d.get(paramObject2);
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = this.z[paramObject1.intValue()][paramObject2.intValue()];
    } else {
      paramObject1 = null;
    }
    return (V)paramObject1;
  }
  
  f3.a<R, C, V> getCell(int paramInt)
  {
    int i = this.p0[paramInt];
    paramInt = this.p1[paramInt];
    return ImmutableTable.cellOf(rowKeySet().asList().get(i), columnKeySet().asList().get(paramInt), this.z[i][paramInt]);
  }
  
  V getValue(int paramInt)
  {
    return (V)this.z[this.p0[paramInt]][this.p1[paramInt]];
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return ImmutableMap.copyOf(this.f);
  }
  
  public int size()
  {
    return this.p0.length;
  }
  
  private final class b
    extends e0.d<R, V>
  {
    private final int d;
    
    b(int paramInt)
    {
      super();
      this.d = paramInt;
    }
    
    V d(int paramInt)
    {
      return (V)e0.i(e0.this)[paramInt][this.d];
    }
    
    ImmutableMap<R, Integer> g()
    {
      return e0.k(e0.this);
    }
    
    boolean isPartialView()
    {
      return true;
    }
  }
  
  private final class c
    extends e0.d<C, ImmutableMap<R, V>>
  {
    private c()
    {
      super();
    }
    
    ImmutableMap<C, Integer> g()
    {
      return e0.h(e0.this);
    }
    
    ImmutableMap<R, V> h(int paramInt)
    {
      return new e0.b(e0.this, paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
  }
  
  private static abstract class d<K, V>
    extends ImmutableMap.c<K, V>
  {
    private final int c;
    
    d(int paramInt)
    {
      this.c = paramInt;
    }
    
    private boolean f()
    {
      boolean bool;
      if (this.c == g().size()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    j3<Map.Entry<K, V>> a()
    {
      return new a();
    }
    
    K b(int paramInt)
    {
      return (K)g().keySet().asList().get(paramInt);
    }
    
    ImmutableSet<K> createKeySet()
    {
      ImmutableSet localImmutableSet;
      if (f()) {
        localImmutableSet = g().keySet();
      } else {
        localImmutableSet = super.createKeySet();
      }
      return localImmutableSet;
    }
    
    @NullableDecl
    abstract V d(int paramInt);
    
    abstract ImmutableMap<K, Integer> g();
    
    public V get(@NullableDecl Object paramObject)
    {
      paramObject = (Integer)g().get(paramObject);
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = d(((Integer)paramObject).intValue());
      }
      return (V)paramObject;
    }
    
    public int size()
    {
      return this.c;
    }
    
    class a
      extends c<Map.Entry<K, V>>
    {
      private int f = -1;
      private final int q = e0.d.this.g().size();
      
      a() {}
      
      protected Map.Entry<K, V> d()
      {
        for (int i = this.f;; i = this.f)
        {
          this.f = (i + 1);
          i = this.f;
          if (i >= this.q) {
            break;
          }
          Object localObject = e0.d.this.d(i);
          if (localObject != null) {
            return q1.i(e0.d.this.b(this.f), localObject);
          }
        }
        return (Map.Entry)b();
      }
    }
  }
  
  private final class e
    extends e0.d<C, V>
  {
    private final int d;
    
    e(int paramInt)
    {
      super();
      this.d = paramInt;
    }
    
    V d(int paramInt)
    {
      return (V)e0.i(e0.this)[this.d][paramInt];
    }
    
    ImmutableMap<C, Integer> g()
    {
      return e0.h(e0.this);
    }
    
    boolean isPartialView()
    {
      return true;
    }
  }
  
  private final class f
    extends e0.d<R, ImmutableMap<C, V>>
  {
    private f()
    {
      super();
    }
    
    ImmutableMap<R, Integer> g()
    {
      return e0.k(e0.this);
    }
    
    ImmutableMap<C, V> h(int paramInt)
    {
      return new e0.e(e0.this, paramInt);
    }
    
    boolean isPartialView()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */