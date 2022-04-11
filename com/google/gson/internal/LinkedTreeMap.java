package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class LinkedTreeMap<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> NATURAL_ORDER = new a();
  Comparator<? super K> comparator;
  private LinkedTreeMap<K, V>.b entrySet;
  final e<K, V> header = new e();
  private LinkedTreeMap<K, V>.c keySet;
  int modCount = 0;
  e<K, V> root;
  int size = 0;
  
  public LinkedTreeMap()
  {
    this(NATURAL_ORDER);
  }
  
  public LinkedTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator == null) {
      paramComparator = NATURAL_ORDER;
    }
    this.comparator = paramComparator;
  }
  
  private boolean equal(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void rebalance(e<K, V> parame, boolean paramBoolean)
  {
    while (parame != null)
    {
      e locale1 = parame.d;
      e locale2 = parame.f;
      int i = 0;
      int j = 0;
      int k;
      if (locale1 != null) {
        k = locale1.p0;
      } else {
        k = 0;
      }
      int m;
      if (locale2 != null) {
        m = locale2.p0;
      } else {
        m = 0;
      }
      int n = k - m;
      e locale3;
      if (n == -2)
      {
        locale3 = locale2.d;
        locale1 = locale2.f;
        if (locale1 != null) {
          k = locale1.p0;
        } else {
          k = 0;
        }
        m = j;
        if (locale3 != null) {
          m = locale3.p0;
        }
        k = m - k;
        if ((k != -1) && ((k != 0) || (paramBoolean)))
        {
          rotateRight(locale2);
          rotateLeft(parame);
        }
        else
        {
          rotateLeft(parame);
        }
        if (paramBoolean) {
          break;
        }
      }
      else if (n == 2)
      {
        locale3 = locale1.d;
        locale2 = locale1.f;
        if (locale2 != null) {
          k = locale2.p0;
        } else {
          k = 0;
        }
        m = i;
        if (locale3 != null) {
          m = locale3.p0;
        }
        k = m - k;
        if ((k != 1) && ((k != 0) || (paramBoolean)))
        {
          rotateLeft(locale1);
          rotateRight(parame);
        }
        else
        {
          rotateRight(parame);
        }
        if (paramBoolean) {
          break;
        }
      }
      else if (n == 0)
      {
        parame.p0 = (k + 1);
        if (paramBoolean) {
          break;
        }
      }
      else
      {
        parame.p0 = (Math.max(k, m) + 1);
        if (!paramBoolean) {
          break;
        }
      }
      parame = parame.c;
    }
  }
  
  private void replaceInParent(e<K, V> parame1, e<K, V> parame2)
  {
    e locale = parame1.c;
    parame1.c = null;
    if (parame2 != null) {
      parame2.c = locale;
    }
    if (locale != null)
    {
      if (locale.d == parame1) {
        locale.d = parame2;
      } else {
        locale.f = parame2;
      }
    }
    else {
      this.root = parame2;
    }
  }
  
  private void rotateLeft(e<K, V> parame)
  {
    e locale1 = parame.d;
    e locale2 = parame.f;
    e locale3 = locale2.d;
    e locale4 = locale2.f;
    parame.f = locale3;
    if (locale3 != null) {
      locale3.c = parame;
    }
    replaceInParent(parame, locale2);
    locale2.d = parame;
    parame.c = locale2;
    int i = 0;
    if (locale1 != null) {
      j = locale1.p0;
    } else {
      j = 0;
    }
    if (locale3 != null) {
      k = locale3.p0;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    parame.p0 = k;
    int j = i;
    if (locale4 != null) {
      j = locale4.p0;
    }
    locale2.p0 = (Math.max(k, j) + 1);
  }
  
  private void rotateRight(e<K, V> parame)
  {
    e locale1 = parame.d;
    e locale2 = parame.f;
    e locale3 = locale1.d;
    e locale4 = locale1.f;
    parame.d = locale4;
    if (locale4 != null) {
      locale4.c = parame;
    }
    replaceInParent(parame, locale1);
    locale1.f = parame;
    parame.c = locale1;
    int i = 0;
    if (locale2 != null) {
      j = locale2.p0;
    } else {
      j = 0;
    }
    if (locale4 != null) {
      k = locale4.p0;
    } else {
      k = 0;
    }
    int k = Math.max(j, k) + 1;
    parame.p0 = k;
    int j = i;
    if (locale3 != null) {
      j = locale3.p0;
    }
    locale1.p0 = (Math.max(k, j) + 1);
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    return new LinkedHashMap(this);
  }
  
  public void clear()
  {
    this.root = null;
    this.size = 0;
    this.modCount += 1;
    e locale = this.header;
    locale.x = locale;
    locale.q = locale;
  }
  
  public boolean containsKey(Object paramObject)
  {
    boolean bool;
    if (findByObject(paramObject) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    b localb = this.entrySet;
    if (localb == null)
    {
      localb = new b();
      this.entrySet = localb;
    }
    return localb;
  }
  
  e<K, V> find(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.comparator;
    Object localObject = this.root;
    if (localObject != null)
    {
      Comparable localComparable;
      if (localComparator == NATURAL_ORDER) {
        localComparable = (Comparable)paramK;
      } else {
        localComparable = null;
      }
      for (;;)
      {
        if (localComparable != null) {
          i = localComparable.compareTo(((e)localObject).y);
        } else {
          i = localComparator.compare(paramK, ((e)localObject).y);
        }
        if (i == 0) {
          return (e<K, V>)localObject;
        }
        if (i < 0) {
          locale = ((e)localObject).d;
        } else {
          locale = ((e)localObject).f;
        }
        if (locale == null) {
          break;
        }
        localObject = locale;
      }
    }
    int i = 0;
    if (!paramBoolean) {
      return null;
    }
    e locale = this.header;
    if (localObject == null)
    {
      if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramK.getClass().getName());
        ((StringBuilder)localObject).append(" is not Comparable");
        throw new ClassCastException(((StringBuilder)localObject).toString());
      }
      paramK = new e((e)localObject, paramK, locale, locale.x);
      this.root = paramK;
    }
    else
    {
      paramK = new e((e)localObject, paramK, locale, locale.x);
      if (i < 0) {
        ((e)localObject).d = paramK;
      } else {
        ((e)localObject).f = paramK;
      }
      rebalance((e)localObject, true);
    }
    this.size += 1;
    this.modCount += 1;
    return paramK;
  }
  
  e<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    e locale = findByObject(paramEntry.getKey());
    int i;
    if ((locale != null) && (equal(locale.z, paramEntry.getValue()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramEntry = locale;
    } else {
      paramEntry = null;
    }
    return paramEntry;
  }
  
  e<K, V> findByObject(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramObject != null) {}
    try
    {
      localObject2 = find(paramObject, false);
      return (e<K, V>)localObject2;
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
  }
  
  public V get(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      paramObject = ((e)paramObject).z;
    } else {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  public Set<K> keySet()
  {
    c localc = this.keySet;
    if (localc == null)
    {
      localc = new c();
      this.keySet = localc;
    }
    return localc;
  }
  
  public V put(K paramK, V paramV)
  {
    Objects.requireNonNull(paramK, "key == null");
    paramK = find(paramK, true);
    Object localObject = paramK.z;
    paramK.z = paramV;
    return (V)localObject;
  }
  
  public V remove(Object paramObject)
  {
    paramObject = removeInternalByKey(paramObject);
    if (paramObject != null) {
      paramObject = ((e)paramObject).z;
    } else {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  void removeInternal(e<K, V> parame, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      locale1 = parame.x;
      locale1.q = parame.q;
      parame.q.x = locale1;
    }
    e locale2 = parame.d;
    e locale1 = parame.f;
    e locale3 = parame.c;
    int i = 0;
    if ((locale2 != null) && (locale1 != null))
    {
      if (locale2.p0 > locale1.p0) {
        locale1 = locale2.b();
      } else {
        locale1 = locale1.a();
      }
      removeInternal(locale1, false);
      locale3 = parame.d;
      int j;
      if (locale3 != null)
      {
        j = locale3.p0;
        locale1.d = locale3;
        locale3.c = locale1;
        parame.d = null;
      }
      else
      {
        j = 0;
      }
      locale3 = parame.f;
      if (locale3 != null)
      {
        i = locale3.p0;
        locale1.f = locale3;
        locale3.c = locale1;
        parame.f = null;
      }
      locale1.p0 = (Math.max(j, i) + 1);
      replaceInParent(parame, locale1);
      return;
    }
    if (locale2 != null)
    {
      replaceInParent(parame, locale2);
      parame.d = null;
    }
    else if (locale1 != null)
    {
      replaceInParent(parame, locale1);
      parame.f = null;
    }
    else
    {
      replaceInParent(parame, null);
    }
    rebalance(locale3, false);
    this.size -= 1;
    this.modCount += 1;
  }
  
  e<K, V> removeInternalByKey(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      removeInternal((e)paramObject, true);
    }
    return (e<K, V>)paramObject;
  }
  
  public int size()
  {
    return this.size;
  }
  
  class a
    implements Comparator<Comparable>
  {
    public int a(Comparable paramComparable1, Comparable paramComparable2)
    {
      return paramComparable1.compareTo(paramComparable2);
    }
  }
  
  class b
    extends AbstractSet<Map.Entry<K, V>>
  {
    b() {}
    
    public void clear()
    {
      LinkedTreeMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (((paramObject instanceof Map.Entry)) && (LinkedTreeMap.this.findByEntry((Map.Entry)paramObject) != null)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = LinkedTreeMap.this.findByEntry((Map.Entry)paramObject);
      if (paramObject == null) {
        return false;
      }
      LinkedTreeMap.this.removeInternal((LinkedTreeMap.e)paramObject, true);
      return true;
    }
    
    public int size()
    {
      return LinkedTreeMap.this.size;
    }
    
    class a
      extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>>
    {
      a()
      {
        super();
      }
      
      public Map.Entry<K, V> b()
      {
        return a();
      }
    }
  }
  
  final class c
    extends AbstractSet<K>
  {
    c() {}
    
    public void clear()
    {
      LinkedTreeMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return LinkedTreeMap.this.containsKey(paramObject);
    }
    
    public Iterator<K> iterator()
    {
      return new a();
    }
    
    public boolean remove(Object paramObject)
    {
      boolean bool;
      if (LinkedTreeMap.this.removeInternalByKey(paramObject) != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int size()
    {
      return LinkedTreeMap.this.size;
    }
    
    class a
      extends LinkedTreeMap<K, V>.d<K>
    {
      a()
      {
        super();
      }
      
      public K next()
      {
        return (K)a().y;
      }
    }
  }
  
  private abstract class d<T>
    implements Iterator<T>
  {
    LinkedTreeMap.e<K, V> c = LinkedTreeMap.this.header.q;
    LinkedTreeMap.e<K, V> d = null;
    int f = LinkedTreeMap.this.modCount;
    
    d() {}
    
    final LinkedTreeMap.e<K, V> a()
    {
      LinkedTreeMap.e locale = this.c;
      LinkedTreeMap localLinkedTreeMap = LinkedTreeMap.this;
      if (locale != localLinkedTreeMap.header)
      {
        if (localLinkedTreeMap.modCount == this.f)
        {
          this.c = locale.q;
          this.d = locale;
          return locale;
        }
        throw new ConcurrentModificationException();
      }
      throw new NoSuchElementException();
    }
    
    public final boolean hasNext()
    {
      boolean bool;
      if (this.c != LinkedTreeMap.this.header) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final void remove()
    {
      LinkedTreeMap.e locale = this.d;
      if (locale != null)
      {
        LinkedTreeMap.this.removeInternal(locale, true);
        this.d = null;
        this.f = LinkedTreeMap.this.modCount;
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  static final class e<K, V>
    implements Map.Entry<K, V>
  {
    e<K, V> c;
    e<K, V> d;
    e<K, V> f;
    int p0;
    e<K, V> q;
    e<K, V> x;
    final K y;
    V z;
    
    e()
    {
      this.y = null;
      this.x = this;
      this.q = this;
    }
    
    e(e<K, V> parame1, K paramK, e<K, V> parame2, e<K, V> parame3)
    {
      this.c = parame1;
      this.y = paramK;
      this.p0 = 1;
      this.q = parame2;
      this.x = parame3;
      parame3.q = this;
      parame2.x = this;
    }
    
    public e<K, V> a()
    {
      Object localObject1 = this.d;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        e locale = ((e)localObject1).d;
        localObject2 = localObject1;
        localObject1 = locale;
      }
      return (e<K, V>)localObject2;
    }
    
    public e<K, V> b()
    {
      Object localObject1 = this.f;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        e locale = ((e)localObject1).f;
        localObject2 = localObject1;
        localObject1 = locale;
      }
      return (e<K, V>)localObject2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (Map.Entry)paramObject;
        Object localObject = this.y;
        if (localObject == null)
        {
          bool3 = bool2;
          if (((Map.Entry)paramObject).getKey() != null) {
            break label108;
          }
        }
        else
        {
          bool3 = bool2;
          if (!localObject.equals(((Map.Entry)paramObject).getKey())) {
            break label108;
          }
        }
        localObject = this.z;
        if (localObject == null)
        {
          bool3 = bool2;
          if (((Map.Entry)paramObject).getValue() != null) {
            break label108;
          }
        }
        else
        {
          bool3 = bool2;
          if (!localObject.equals(((Map.Entry)paramObject).getValue())) {
            break label108;
          }
        }
        bool3 = true;
      }
      label108:
      return bool3;
    }
    
    public K getKey()
    {
      return (K)this.y;
    }
    
    public V getValue()
    {
      return (V)this.z;
    }
    
    public int hashCode()
    {
      Object localObject = this.y;
      int i = 0;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = localObject.hashCode();
      }
      localObject = this.z;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      return j ^ i;
    }
    
    public V setValue(V paramV)
    {
      Object localObject = this.z;
      this.z = paramV;
      return (V)localObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.y);
      localStringBuilder.append("=");
      localStringBuilder.append(this.z);
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\LinkedTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */