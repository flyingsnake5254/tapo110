package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class LinkedListMultimap<K, V>
  extends h<K, V>
  implements m1<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  @NullableDecl
  private transient g<K, V> head;
  private transient Map<K, f<K, V>> keyToKeyList;
  private transient int modCount;
  private transient int size;
  @NullableDecl
  private transient g<K, V> tail;
  
  LinkedListMultimap()
  {
    this(12);
  }
  
  private LinkedListMultimap(int paramInt)
  {
    this.keyToKeyList = c2.c(paramInt);
  }
  
  private LinkedListMultimap(r1<? extends K, ? extends V> paramr1)
  {
    this(paramr1.keySet().size());
    putAll(paramr1);
  }
  
  @CanIgnoreReturnValue
  private g<K, V> addNode(@NullableDecl K paramK, @NullableDecl V paramV, @NullableDecl g<K, V> paramg)
  {
    paramV = new g(paramK, paramV);
    if (this.head == null)
    {
      this.tail = paramV;
      this.head = paramV;
      this.keyToKeyList.put(paramK, new f(paramV));
      this.modCount += 1;
    }
    else if (paramg == null)
    {
      paramg = this.tail;
      paramg.f = paramV;
      paramV.q = paramg;
      this.tail = paramV;
      paramg = (f)this.keyToKeyList.get(paramK);
      if (paramg == null)
      {
        this.keyToKeyList.put(paramK, new f(paramV));
        this.modCount += 1;
      }
      else
      {
        paramg.c += 1;
        paramK = paramg.b;
        paramK.x = paramV;
        paramV.y = paramK;
        paramg.b = paramV;
      }
    }
    else
    {
      Object localObject = (f)this.keyToKeyList.get(paramK);
      ((f)localObject).c += 1;
      paramV.q = paramg.q;
      paramV.y = paramg.y;
      paramV.f = paramg;
      paramV.x = paramg;
      localObject = paramg.y;
      if (localObject == null) {
        ((f)this.keyToKeyList.get(paramK)).a = paramV;
      } else {
        ((g)localObject).x = paramV;
      }
      paramK = paramg.q;
      if (paramK == null) {
        this.head = paramV;
      } else {
        paramK.f = paramV;
      }
      paramg.q = paramV;
      paramg.y = paramV;
    }
    this.size += 1;
    return paramV;
  }
  
  private static void checkElement(@NullableDecl Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new NoSuchElementException();
  }
  
  public static <K, V> LinkedListMultimap<K, V> create()
  {
    return new LinkedListMultimap();
  }
  
  public static <K, V> LinkedListMultimap<K, V> create(int paramInt)
  {
    return new LinkedListMultimap(paramInt);
  }
  
  public static <K, V> LinkedListMultimap<K, V> create(r1<? extends K, ? extends V> paramr1)
  {
    return new LinkedListMultimap(paramr1);
  }
  
  private List<V> getCopy(@NullableDecl Object paramObject)
  {
    return Collections.unmodifiableList(n1.j(new i(paramObject)));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.keyToKeyList = z.G();
    int i = paramObjectInputStream.readInt();
    for (int j = 0; j < i; j++) {
      put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
    }
  }
  
  private void removeAllNodes(@NullableDecl Object paramObject)
  {
    k1.d(new i(paramObject));
  }
  
  private void removeNode(g<K, V> paramg)
  {
    g localg = paramg.q;
    if (localg != null) {
      localg.f = paramg.f;
    } else {
      this.head = paramg.f;
    }
    Object localObject = paramg.f;
    if (localObject != null) {
      ((g)localObject).q = localg;
    } else {
      this.tail = localg;
    }
    if ((paramg.y == null) && (paramg.x == null))
    {
      ((f)this.keyToKeyList.remove(paramg.c)).c = 0;
      this.modCount += 1;
    }
    else
    {
      localObject = (f)this.keyToKeyList.get(paramg.c);
      ((f)localObject).c -= 1;
      localg = paramg.y;
      if (localg == null) {
        ((f)localObject).a = paramg.x;
      } else {
        localg.x = paramg.x;
      }
      paramg = paramg.x;
      if (paramg == null) {
        ((f)localObject).b = localg;
      } else {
        paramg.y = localg;
      }
    }
    this.size -= 1;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    Iterator localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public void clear()
  {
    this.head = null;
    this.tail = null;
    this.keyToKeyList.clear();
    this.size = 0;
    this.modCount += 1;
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    return this.keyToKeyList.containsKey(paramObject);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    return new t1.a(this);
  }
  
  List<Map.Entry<K, V>> createEntries()
  {
    return new b();
  }
  
  Set<K> createKeySet()
  {
    return new c();
  }
  
  u1<K> createKeys()
  {
    return new t1.d(this);
  }
  
  List<V> createValues()
  {
    return new d();
  }
  
  public List<Map.Entry<K, V>> entries()
  {
    return (List)super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  public List<V> get(@NullableDecl final K paramK)
  {
    return new a(paramK);
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.head == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public boolean put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    addNode(paramK, paramV, null);
    return true;
  }
  
  @CanIgnoreReturnValue
  public List<V> removeAll(@NullableDecl Object paramObject)
  {
    List localList = getCopy(paramObject);
    removeAllNodes(paramObject);
    return localList;
  }
  
  @CanIgnoreReturnValue
  public List<V> replaceValues(@NullableDecl K paramK, Iterable<? extends V> paramIterable)
  {
    List localList = getCopy(paramK);
    paramK = new i(paramK);
    paramIterable = paramIterable.iterator();
    while ((paramK.hasNext()) && (paramIterable.hasNext()))
    {
      paramK.next();
      paramK.set(paramIterable.next());
    }
    while (paramK.hasNext())
    {
      paramK.next();
      paramK.remove();
    }
    while (paramIterable.hasNext()) {
      paramK.add(paramIterable.next());
    }
    return localList;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public List<V> values()
  {
    return (List)super.values();
  }
  
  class a
    extends AbstractSequentialList<V>
  {
    a(Object paramObject) {}
    
    public ListIterator<V> listIterator(int paramInt)
    {
      return new LinkedListMultimap.i(LinkedListMultimap.this, paramK, paramInt);
    }
    
    public int size()
    {
      LinkedListMultimap.f localf = (LinkedListMultimap.f)LinkedListMultimap.this.keyToKeyList.get(paramK);
      int i;
      if (localf == null) {
        i = 0;
      } else {
        i = localf.c;
      }
      return i;
    }
  }
  
  class b
    extends AbstractSequentialList<Map.Entry<K, V>>
  {
    b() {}
    
    public ListIterator<Map.Entry<K, V>> listIterator(int paramInt)
    {
      return new LinkedListMultimap.h(LinkedListMultimap.this, paramInt);
    }
    
    public int size()
    {
      return LinkedListMultimap.this.size;
    }
  }
  
  class c
    extends u2.b<K>
  {
    c() {}
    
    public boolean contains(Object paramObject)
    {
      return LinkedListMultimap.this.containsKey(paramObject);
    }
    
    public Iterator<K> iterator()
    {
      return new LinkedListMultimap.e(LinkedListMultimap.this, null);
    }
    
    public boolean remove(Object paramObject)
    {
      return LinkedListMultimap.this.removeAll(paramObject).isEmpty() ^ true;
    }
    
    public int size()
    {
      return LinkedListMultimap.this.keyToKeyList.size();
    }
  }
  
  class d
    extends AbstractSequentialList<V>
  {
    d() {}
    
    public ListIterator<V> listIterator(int paramInt)
    {
      final LinkedListMultimap.h localh = new LinkedListMultimap.h(LinkedListMultimap.this, paramInt);
      return new a(localh, localh);
    }
    
    public int size()
    {
      return LinkedListMultimap.this.size;
    }
    
    class a
      extends i3<Map.Entry<K, V>, V>
    {
      a(ListIterator paramListIterator, LinkedListMultimap.h paramh)
      {
        super();
      }
      
      V c(Map.Entry<K, V> paramEntry)
      {
        return (V)paramEntry.getValue();
      }
      
      public void set(V paramV)
      {
        localh.f(paramV);
      }
    }
  }
  
  private class e
    implements Iterator<K>
  {
    final Set<K> c = u2.e(LinkedListMultimap.this.keySet().size());
    LinkedListMultimap.g<K, V> d = LinkedListMultimap.this.head;
    @NullableDecl
    LinkedListMultimap.g<K, V> f;
    int q = LinkedListMultimap.this.modCount;
    
    private e() {}
    
    private void a()
    {
      if (LinkedListMultimap.this.modCount == this.q) {
        return;
      }
      throw new ConcurrentModificationException();
    }
    
    public boolean hasNext()
    {
      a();
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public K next()
    {
      a();
      LinkedListMultimap.checkElement(this.d);
      LinkedListMultimap.g localg = this.d;
      this.f = localg;
      this.c.add(localg.c);
      do
      {
        localg = this.d.f;
        this.d = localg;
      } while ((localg != null) && (!this.c.add(localg.c)));
      return (K)this.f.c;
    }
    
    public void remove()
    {
      a();
      boolean bool;
      if (this.f != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      LinkedListMultimap.this.removeAllNodes(this.f.c);
      this.f = null;
      this.q = LinkedListMultimap.this.modCount;
    }
  }
  
  private static class f<K, V>
  {
    LinkedListMultimap.g<K, V> a;
    LinkedListMultimap.g<K, V> b;
    int c;
    
    f(LinkedListMultimap.g<K, V> paramg)
    {
      this.a = paramg;
      this.b = paramg;
      paramg.y = null;
      paramg.x = null;
      this.c = 1;
    }
  }
  
  private static final class g<K, V>
    extends g<K, V>
  {
    @NullableDecl
    final K c;
    @NullableDecl
    V d;
    @NullableDecl
    g<K, V> f;
    @NullableDecl
    g<K, V> q;
    @NullableDecl
    g<K, V> x;
    @NullableDecl
    g<K, V> y;
    
    g(@NullableDecl K paramK, @NullableDecl V paramV)
    {
      this.c = paramK;
      this.d = paramV;
    }
    
    public K getKey()
    {
      return (K)this.c;
    }
    
    public V getValue()
    {
      return (V)this.d;
    }
    
    public V setValue(@NullableDecl V paramV)
    {
      Object localObject = this.d;
      this.d = paramV;
      return (V)localObject;
    }
  }
  
  private class h
    implements ListIterator<Map.Entry<K, V>>
  {
    int c;
    @NullableDecl
    LinkedListMultimap.g<K, V> d;
    @NullableDecl
    LinkedListMultimap.g<K, V> f;
    @NullableDecl
    LinkedListMultimap.g<K, V> q;
    int x = LinkedListMultimap.this.modCount;
    
    h(int paramInt)
    {
      int i = LinkedListMultimap.this.size();
      n.r(paramInt, i);
      if (paramInt >= i / 2)
      {
        this.q = LinkedListMultimap.this.tail;
        this.c = i;
        while (paramInt < i)
        {
          d();
          paramInt++;
        }
      }
      this.d = LinkedListMultimap.this.head;
      while (paramInt > 0)
      {
        c();
        paramInt--;
      }
      this.f = null;
    }
    
    private void b()
    {
      if (LinkedListMultimap.this.modCount == this.x) {
        return;
      }
      throw new ConcurrentModificationException();
    }
    
    public void a(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    @CanIgnoreReturnValue
    public LinkedListMultimap.g<K, V> c()
    {
      b();
      LinkedListMultimap.checkElement(this.d);
      LinkedListMultimap.g localg = this.d;
      this.f = localg;
      this.q = localg;
      this.d = localg.f;
      this.c += 1;
      return localg;
    }
    
    @CanIgnoreReturnValue
    public LinkedListMultimap.g<K, V> d()
    {
      b();
      LinkedListMultimap.checkElement(this.q);
      LinkedListMultimap.g localg = this.q;
      this.f = localg;
      this.d = localg;
      this.q = localg.q;
      this.c -= 1;
      return localg;
    }
    
    public void e(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    void f(V paramV)
    {
      boolean bool;
      if (this.f != null) {
        bool = true;
      } else {
        bool = false;
      }
      n.u(bool);
      this.f.d = paramV;
    }
    
    public boolean hasNext()
    {
      b();
      boolean bool;
      if (this.d != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean hasPrevious()
    {
      b();
      boolean bool;
      if (this.q != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int nextIndex()
    {
      return this.c;
    }
    
    public int previousIndex()
    {
      return this.c - 1;
    }
    
    public void remove()
    {
      b();
      boolean bool;
      if (this.f != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      LinkedListMultimap.g localg = this.f;
      if (localg != this.d)
      {
        this.q = localg.q;
        this.c -= 1;
      }
      else
      {
        this.d = localg.f;
      }
      LinkedListMultimap.this.removeNode(localg);
      this.f = null;
      this.x = LinkedListMultimap.this.modCount;
    }
  }
  
  private class i
    implements ListIterator<V>
  {
    @NullableDecl
    final Object c;
    int d;
    @NullableDecl
    LinkedListMultimap.g<K, V> f;
    @NullableDecl
    LinkedListMultimap.g<K, V> q;
    @NullableDecl
    LinkedListMultimap.g<K, V> x;
    
    i(Object paramObject)
    {
      this.c = paramObject;
      this$1 = (LinkedListMultimap.f)LinkedListMultimap.this.keyToKeyList.get(paramObject);
      if (LinkedListMultimap.this == null) {
        this$1 = null;
      } else {
        this$1 = LinkedListMultimap.this.a;
      }
      this.f = LinkedListMultimap.this;
    }
    
    public i(Object paramObject, int paramInt)
    {
      this$1 = (LinkedListMultimap.f)LinkedListMultimap.this.keyToKeyList.get(paramObject);
      int i;
      if (LinkedListMultimap.this == null) {
        i = 0;
      } else {
        i = LinkedListMultimap.this.c;
      }
      n.r(paramInt, i);
      if (paramInt >= i / 2)
      {
        if (LinkedListMultimap.this == null) {
          this$1 = null;
        } else {
          this$1 = LinkedListMultimap.this.b;
        }
        this.x = LinkedListMultimap.this;
        this.d = i;
        while (paramInt < i)
        {
          previous();
          paramInt++;
        }
      }
      if (LinkedListMultimap.this == null) {
        this$1 = null;
      } else {
        this$1 = LinkedListMultimap.this.a;
      }
      this.f = LinkedListMultimap.this;
      while (paramInt > 0)
      {
        next();
        paramInt--;
      }
      this.c = paramObject;
      this.q = null;
    }
    
    public void add(V paramV)
    {
      this.x = LinkedListMultimap.this.addNode(this.c, paramV, this.f);
      this.d += 1;
      this.q = null;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.f != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean hasPrevious()
    {
      boolean bool;
      if (this.x != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @CanIgnoreReturnValue
    public V next()
    {
      LinkedListMultimap.checkElement(this.f);
      LinkedListMultimap.g localg = this.f;
      this.q = localg;
      this.x = localg;
      this.f = localg.x;
      this.d += 1;
      return (V)localg.d;
    }
    
    public int nextIndex()
    {
      return this.d;
    }
    
    @CanIgnoreReturnValue
    public V previous()
    {
      LinkedListMultimap.checkElement(this.x);
      LinkedListMultimap.g localg = this.x;
      this.q = localg;
      this.f = localg;
      this.x = localg.y;
      this.d -= 1;
      return (V)localg.d;
    }
    
    public int previousIndex()
    {
      return this.d - 1;
    }
    
    public void remove()
    {
      boolean bool;
      if (this.q != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      LinkedListMultimap.g localg = this.q;
      if (localg != this.f)
      {
        this.x = localg.y;
        this.d -= 1;
      }
      else
      {
        this.f = localg.x;
      }
      LinkedListMultimap.this.removeNode(localg);
      this.q = null;
    }
    
    public void set(V paramV)
    {
      boolean bool;
      if (this.q != null) {
        bool = true;
      } else {
        bool = false;
      }
      n.u(bool);
      this.q.d = paramV;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\LinkedListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */