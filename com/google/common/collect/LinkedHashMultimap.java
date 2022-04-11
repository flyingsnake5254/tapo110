package com.google.common.collect;

import com.google.common.base.k;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class LinkedHashMultimap<K, V>
  extends l1<K, V>
{
  private static final int DEFAULT_KEY_CAPACITY = 16;
  private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
  static final double VALUE_SET_LOAD_FACTOR = 1.0D;
  private static final long serialVersionUID = 1L;
  private transient b<K, V> multimapHeaderEntry;
  transient int valueSetCapacity = 2;
  
  private LinkedHashMultimap(int paramInt1, int paramInt2)
  {
    super(c2.e(paramInt1));
    v.b(paramInt2, "expectedValuesPerKey");
    this.valueSetCapacity = paramInt2;
    b localb = new b(null, null, 0, null);
    this.multimapHeaderEntry = localb;
    succeedsInMultimap(localb, localb);
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create()
  {
    return new LinkedHashMultimap(16, 2);
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(int paramInt1, int paramInt2)
  {
    return new LinkedHashMultimap(q1.d(paramInt1), q1.d(paramInt2));
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(r1<? extends K, ? extends V> paramr1)
  {
    LinkedHashMultimap localLinkedHashMultimap = create(paramr1.keySet().size(), 2);
    localLinkedHashMultimap.putAll(paramr1);
    return localLinkedHashMultimap;
  }
  
  private static <K, V> void deleteFromMultimap(b<K, V> paramb)
  {
    succeedsInMultimap(paramb.g(), paramb.h());
  }
  
  private static <K, V> void deleteFromValueSet(d<K, V> paramd)
  {
    succeedsInValueSet(paramd.a(), paramd.b());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = 0;
    Object localObject1 = new b(null, null, 0, null);
    this.multimapHeaderEntry = ((b)localObject1);
    succeedsInMultimap((b)localObject1, (b)localObject1);
    this.valueSetCapacity = 2;
    int j = paramObjectInputStream.readInt();
    localObject1 = c2.e(12);
    Object localObject2;
    for (int k = 0; k < j; k++)
    {
      localObject2 = paramObjectInputStream.readObject();
      ((Map)localObject1).put(localObject2, createCollection(localObject2));
    }
    j = paramObjectInputStream.readInt();
    for (k = i; k < j; k++)
    {
      localObject2 = paramObjectInputStream.readObject();
      Object localObject3 = paramObjectInputStream.readObject();
      ((Collection)((Map)localObject1).get(localObject2)).add(localObject3);
    }
    setMap((Map)localObject1);
  }
  
  private static <K, V> void succeedsInMultimap(b<K, V> paramb1, b<K, V> paramb2)
  {
    paramb1.k(paramb2);
    paramb2.j(paramb1);
  }
  
  private static <K, V> void succeedsInValueSet(d<K, V> paramd1, d<K, V> paramd2)
  {
    paramd1.d(paramd2);
    paramd2.f(paramd1);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(keySet().size());
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext()) {
      paramObjectOutputStream.writeObject(localIterator.next());
    }
    paramObjectOutputStream.writeInt(size());
    localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public void clear()
  {
    super.clear();
    b localb = this.multimapHeaderEntry;
    succeedsInMultimap(localb, localb);
  }
  
  Collection<V> createCollection(K paramK)
  {
    return new c(paramK, this.valueSetCapacity);
  }
  
  Set<V> createCollection()
  {
    return c2.f(this.valueSetCapacity);
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return new a();
  }
  
  public Set<K> keySet()
  {
    return super.keySet();
  }
  
  @CanIgnoreReturnValue
  public Set<V> replaceValues(@NullableDecl K paramK, Iterable<? extends V> paramIterable)
  {
    return super.replaceValues(paramK, paramIterable);
  }
  
  Iterator<V> valueIterator()
  {
    return q1.D(entryIterator());
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  class a
    implements Iterator<Map.Entry<K, V>>
  {
    LinkedHashMultimap.b<K, V> c = LinkedHashMultimap.this.multimapHeaderEntry.p0;
    @NullableDecl
    LinkedHashMultimap.b<K, V> d;
    
    a() {}
    
    public Map.Entry<K, V> a()
    {
      if (hasNext())
      {
        LinkedHashMultimap.b localb = this.c;
        this.d = localb;
        this.c = localb.p0;
        return localb;
      }
      throw new NoSuchElementException();
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.c != LinkedHashMultimap.this.multimapHeaderEntry) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void remove()
    {
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      LinkedHashMultimap.this.remove(this.d.getKey(), this.d.getValue());
      this.d = null;
    }
  }
  
  static final class b<K, V>
    extends a1<K, V>
    implements LinkedHashMultimap.d<K, V>
  {
    final int f;
    @NullableDecl
    b<K, V> p0;
    @NullableDecl
    b<K, V> q;
    @NullableDecl
    LinkedHashMultimap.d<K, V> x;
    @NullableDecl
    LinkedHashMultimap.d<K, V> y;
    @NullableDecl
    b<K, V> z;
    
    b(@NullableDecl K paramK, @NullableDecl V paramV, int paramInt, @NullableDecl b<K, V> paramb)
    {
      super(paramV);
      this.f = paramInt;
      this.q = paramb;
    }
    
    public LinkedHashMultimap.d<K, V> a()
    {
      return this.x;
    }
    
    public LinkedHashMultimap.d<K, V> b()
    {
      return this.y;
    }
    
    public void d(LinkedHashMultimap.d<K, V> paramd)
    {
      this.y = paramd;
    }
    
    public void f(LinkedHashMultimap.d<K, V> paramd)
    {
      this.x = paramd;
    }
    
    public b<K, V> g()
    {
      return this.z;
    }
    
    public b<K, V> h()
    {
      return this.p0;
    }
    
    boolean i(@NullableDecl Object paramObject, int paramInt)
    {
      boolean bool;
      if ((this.f == paramInt) && (k.a(getValue(), paramObject))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void j(b<K, V> paramb)
    {
      this.z = paramb;
    }
    
    public void k(b<K, V> paramb)
    {
      this.p0 = paramb;
    }
  }
  
  final class c
    extends u2.b<V>
    implements LinkedHashMultimap.d<K, V>
  {
    private final K c;
    LinkedHashMultimap.b<K, V>[] d;
    private int f = 0;
    private int q = 0;
    private LinkedHashMultimap.d<K, V> x;
    private LinkedHashMultimap.d<K, V> y;
    
    c(int paramInt)
    {
      this.c = paramInt;
      this.x = this;
      this.y = this;
      int i;
      this.d = new LinkedHashMultimap.b[y0.a(i, 1.0D)];
    }
    
    private int g()
    {
      return this.d.length - 1;
    }
    
    private void h()
    {
      if (y0.b(this.f, this.d.length, 1.0D))
      {
        int i = this.d.length * 2;
        LinkedHashMultimap.b[] arrayOfb = new LinkedHashMultimap.b[i];
        this.d = arrayOfb;
        for (LinkedHashMultimap.d locald = this.x; locald != this; locald = locald.b())
        {
          LinkedHashMultimap.b localb = (LinkedHashMultimap.b)locald;
          int j = localb.f & i - 1;
          localb.q = arrayOfb[j];
          arrayOfb[j] = localb;
        }
      }
    }
    
    public LinkedHashMultimap.d<K, V> a()
    {
      return this.y;
    }
    
    public boolean add(@NullableDecl V paramV)
    {
      int i = y0.d(paramV);
      int j = g() & i;
      LinkedHashMultimap.b localb1 = this.d[j];
      for (LinkedHashMultimap.b localb2 = localb1; localb2 != null; localb2 = localb2.q) {
        if (localb2.i(paramV, i)) {
          return false;
        }
      }
      paramV = new LinkedHashMultimap.b(this.c, paramV, i, localb1);
      LinkedHashMultimap.succeedsInValueSet(this.y, paramV);
      LinkedHashMultimap.succeedsInValueSet(paramV, this);
      LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.g(), paramV);
      LinkedHashMultimap.succeedsInMultimap(paramV, LinkedHashMultimap.this.multimapHeaderEntry);
      this.d[j] = paramV;
      this.f += 1;
      this.q += 1;
      h();
      return true;
    }
    
    public LinkedHashMultimap.d<K, V> b()
    {
      return this.x;
    }
    
    public void clear()
    {
      Arrays.fill(this.d, null);
      this.f = 0;
      for (LinkedHashMultimap.d locald = this.x; locald != this; locald = locald.b()) {
        LinkedHashMultimap.deleteFromMultimap((LinkedHashMultimap.b)locald);
      }
      LinkedHashMultimap.succeedsInValueSet(this, this);
      this.q += 1;
    }
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      int i = y0.d(paramObject);
      for (LinkedHashMultimap.b localb = this.d[(g() & i)]; localb != null; localb = localb.q) {
        if (localb.i(paramObject, i)) {
          return true;
        }
      }
      return false;
    }
    
    public void d(LinkedHashMultimap.d<K, V> paramd)
    {
      this.x = paramd;
    }
    
    public void f(LinkedHashMultimap.d<K, V> paramd)
    {
      this.y = paramd;
    }
    
    public Iterator<V> iterator()
    {
      return new a();
    }
    
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object paramObject)
    {
      int i = y0.d(paramObject);
      int j = g() & i;
      Object localObject1 = this.d[j];
      Object localObject2 = null;
      while (localObject1 != null)
      {
        if (((LinkedHashMultimap.b)localObject1).i(paramObject, i))
        {
          if (localObject2 == null) {
            this.d[j] = ((LinkedHashMultimap.b)localObject1).q;
          } else {
            ((LinkedHashMultimap.b)localObject2).q = ((LinkedHashMultimap.b)localObject1).q;
          }
          LinkedHashMultimap.deleteFromValueSet((LinkedHashMultimap.d)localObject1);
          LinkedHashMultimap.deleteFromMultimap((LinkedHashMultimap.b)localObject1);
          this.f -= 1;
          this.q += 1;
          return true;
        }
        LinkedHashMultimap.b localb = ((LinkedHashMultimap.b)localObject1).q;
        localObject2 = localObject1;
        localObject1 = localb;
      }
      return false;
    }
    
    public int size()
    {
      return this.f;
    }
    
    class a
      implements Iterator<V>
    {
      LinkedHashMultimap.d<K, V> c = LinkedHashMultimap.c.c(LinkedHashMultimap.c.this);
      @NullableDecl
      LinkedHashMultimap.b<K, V> d;
      int f = LinkedHashMultimap.c.e(LinkedHashMultimap.c.this);
      
      a() {}
      
      private void a()
      {
        if (LinkedHashMultimap.c.e(LinkedHashMultimap.c.this) == this.f) {
          return;
        }
        throw new ConcurrentModificationException();
      }
      
      public boolean hasNext()
      {
        a();
        boolean bool;
        if (this.c != LinkedHashMultimap.c.this) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public V next()
      {
        if (hasNext())
        {
          LinkedHashMultimap.b localb = (LinkedHashMultimap.b)this.c;
          Object localObject = localb.getValue();
          this.d = localb;
          this.c = localb.b();
          return (V)localObject;
        }
        throw new NoSuchElementException();
      }
      
      public void remove()
      {
        a();
        boolean bool;
        if (this.d != null) {
          bool = true;
        } else {
          bool = false;
        }
        v.e(bool);
        LinkedHashMultimap.c.this.remove(this.d.getValue());
        this.f = LinkedHashMultimap.c.e(LinkedHashMultimap.c.this);
        this.d = null;
      }
    }
  }
  
  private static abstract interface d<K, V>
  {
    public abstract d<K, V> a();
    
    public abstract d<K, V> b();
    
    public abstract void d(d<K, V> paramd);
    
    public abstract void f(d<K, V> paramd);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\LinkedHashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */