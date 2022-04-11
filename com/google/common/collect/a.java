package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class a<K, V>
  extends p0<K, V>
  implements t<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  @MonotonicNonNullDecl
  private transient Map<K, V> delegate;
  @MonotonicNonNullDecl
  private transient Set<Map.Entry<K, V>> entrySet;
  @MonotonicNonNullDecl
  @RetainedWith
  transient a<V, K> inverse;
  @MonotonicNonNullDecl
  private transient Set<K> keySet;
  @MonotonicNonNullDecl
  private transient Set<V> valueSet;
  
  private a(Map<K, V> paramMap, a<V, K> parama)
  {
    this.delegate = paramMap;
    this.inverse = parama;
  }
  
  a(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    setDelegates(paramMap, paramMap1);
  }
  
  private V putInBothMaps(@NullableDecl K paramK, @NullableDecl V paramV, boolean paramBoolean)
  {
    checkKey(paramK);
    checkValue(paramV);
    boolean bool = containsKey(paramK);
    if ((bool) && (k.a(paramV, get(paramK)))) {
      return paramV;
    }
    if (paramBoolean) {
      inverse().remove(paramV);
    } else {
      n.j(containsValue(paramV) ^ true, "value already present: %s", paramV);
    }
    Object localObject = this.delegate.put(paramK, paramV);
    updateInverseMap(paramK, bool, localObject, paramV);
    return (V)localObject;
  }
  
  @CanIgnoreReturnValue
  private V removeFromBothMaps(Object paramObject)
  {
    paramObject = this.delegate.remove(paramObject);
    removeFromInverseMap(paramObject);
    return (V)paramObject;
  }
  
  private void removeFromInverseMap(V paramV)
  {
    this.inverse.delegate.remove(paramV);
  }
  
  private void updateInverseMap(K paramK, boolean paramBoolean, V paramV1, V paramV2)
  {
    if (paramBoolean) {
      removeFromInverseMap(paramV1);
    }
    this.inverse.delegate.put(paramV2, paramK);
  }
  
  @CanIgnoreReturnValue
  abstract K checkKey(@NullableDecl K paramK);
  
  @CanIgnoreReturnValue
  V checkValue(@NullableDecl V paramV)
  {
    return paramV;
  }
  
  public void clear()
  {
    this.delegate.clear();
    this.inverse.delegate.clear();
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return this.inverse.containsKey(paramObject);
  }
  
  protected Map<K, V> delegate()
  {
    return this.delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = this.entrySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new c(null);
      this.entrySet = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  Iterator<Map.Entry<K, V>> entrySetIterator()
  {
    return new a(this.delegate.entrySet().iterator());
  }
  
  @CanIgnoreReturnValue
  public V forcePut(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return (V)putInBothMaps(paramK, paramV, true);
  }
  
  public t<V, K> inverse()
  {
    return this.inverse;
  }
  
  public Set<K> keySet()
  {
    Set localSet = this.keySet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new e(null);
      this.keySet = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  a<V, K> makeInverse(Map<V, K> paramMap)
  {
    return new d(paramMap, this);
  }
  
  @CanIgnoreReturnValue
  public V put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    return (V)putInBothMaps(paramK, paramV, false);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  @CanIgnoreReturnValue
  public V remove(@NullableDecl Object paramObject)
  {
    if (containsKey(paramObject)) {
      paramObject = removeFromBothMaps(paramObject);
    } else {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  void setDelegates(Map<K, V> paramMap, Map<V, K> paramMap1)
  {
    Map localMap = this.delegate;
    boolean bool1 = true;
    boolean bool2;
    if (localMap == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.u(bool2);
    if (this.inverse == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.u(bool2);
    n.d(paramMap.isEmpty());
    n.d(paramMap1.isEmpty());
    if (paramMap != paramMap1) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    n.d(bool2);
    this.delegate = paramMap;
    this.inverse = makeInverse(paramMap1);
  }
  
  void setInverse(a<V, K> parama)
  {
    this.inverse = parama;
  }
  
  public Set<V> values()
  {
    Set localSet = this.valueSet;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new f(null);
      this.valueSet = ((Set)localObject);
    }
    return (Set<V>)localObject;
  }
  
  class a
    implements Iterator<Map.Entry<K, V>>
  {
    @NullableDecl
    Map.Entry<K, V> c;
    
    a(Iterator paramIterator) {}
    
    public Map.Entry<K, V> a()
    {
      Map.Entry localEntry = (Map.Entry)this.d.next();
      this.c = localEntry;
      return new a.b(a.this, localEntry);
    }
    
    public boolean hasNext()
    {
      return this.d.hasNext();
    }
    
    public void remove()
    {
      boolean bool;
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      Object localObject = this.c.getValue();
      this.d.remove();
      a.this.removeFromInverseMap(localObject);
      this.c = null;
    }
  }
  
  class b
    extends q0<K, V>
  {
    private final Map.Entry<K, V> c;
    
    b()
    {
      Map.Entry localEntry;
      this.c = localEntry;
    }
    
    protected Map.Entry<K, V> a()
    {
      return this.c;
    }
    
    public V setValue(V paramV)
    {
      a.this.checkValue(paramV);
      n.v(a.this.entrySet().contains(this), "entry no longer in map");
      if (k.a(paramV, getValue())) {
        return paramV;
      }
      n.j(a.this.containsValue(paramV) ^ true, "value already present: %s", paramV);
      Object localObject = this.c.setValue(paramV);
      n.v(k.a(paramV, a.this.get(getKey())), "entry no longer in map");
      a.this.updateInverseMap(getKey(), true, localObject, paramV);
      return (V)localObject;
    }
  }
  
  private class c
    extends u0<Map.Entry<K, V>>
  {
    final Set<Map.Entry<K, V>> c = a.this.delegate.entrySet();
    
    private c() {}
    
    public void clear()
    {
      a.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return q1.e(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Set<Map.Entry<K, V>> delegate()
    {
      return this.c;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return a.this.entrySetIterator();
    }
    
    public boolean remove(Object paramObject)
    {
      if (!this.c.contains(paramObject)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      a.this.inverse.delegate.remove(((Map.Entry)paramObject).getValue());
      this.c.remove(paramObject);
      return true;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  static class d<K, V>
    extends a<K, V>
  {
    d(Map<K, V> paramMap, a<V, K> parama)
    {
      super(parama, null);
    }
    
    K checkKey(K paramK)
    {
      return (K)this.inverse.checkValue(paramK);
    }
    
    V checkValue(V paramV)
    {
      return (V)this.inverse.checkKey(paramV);
    }
  }
  
  private class e
    extends u0<K>
  {
    private e() {}
    
    public void clear()
    {
      a.this.clear();
    }
    
    protected Set<K> delegate()
    {
      return a.this.delegate.keySet();
    }
    
    public Iterator<K> iterator()
    {
      return q1.l(a.this.entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      if (!contains(paramObject)) {
        return false;
      }
      a.this.removeFromBothMaps(paramObject);
      return true;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
  }
  
  private class f
    extends u0<V>
  {
    final Set<V> c = a.this.inverse.keySet();
    
    private f() {}
    
    protected Set<V> delegate()
    {
      return this.c;
    }
    
    public Iterator<V> iterator()
    {
      return q1.D(a.this.entrySet().iterator());
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */