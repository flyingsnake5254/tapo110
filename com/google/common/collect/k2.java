package com.google.common.collect;

import com.google.common.primitives.d;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class k2<E>
  extends ImmutableMultiset<E>
{
  static final k2<Object> c = new k2(y1.b());
  final transient y1<E> d;
  private final transient int f;
  @LazyInit
  private transient ImmutableSet<E> q;
  
  k2(y1<E> paramy1)
  {
    this.d = paramy1;
    long l = 0L;
    for (int i = 0; i < paramy1.C(); i++) {
      l += paramy1.k(i);
    }
    this.f = d.i(l);
  }
  
  public int count(@NullableDecl Object paramObject)
  {
    return this.d.f(paramObject);
  }
  
  public ImmutableSet<E> elementSet()
  {
    ImmutableSet localImmutableSet = this.q;
    Object localObject = localImmutableSet;
    if (localImmutableSet == null)
    {
      localObject = new b(null);
      this.q = ((ImmutableSet)localObject);
    }
    return (ImmutableSet<E>)localObject;
  }
  
  u1.a<E> getEntry(int paramInt)
  {
    return this.d.g(paramInt);
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.f;
  }
  
  Object writeReplace()
  {
    return new c(this);
  }
  
  private final class b
    extends i1<E>
  {
    private b() {}
    
    public boolean contains(@NullableDecl Object paramObject)
    {
      return k2.this.contains(paramObject);
    }
    
    E get(int paramInt)
    {
      return (E)k2.this.d.i(paramInt);
    }
    
    boolean isPartialView()
    {
      return true;
    }
    
    public int size()
    {
      return k2.this.d.C();
    }
  }
  
  private static class c
    implements Serializable
  {
    final Object[] c;
    final int[] d;
    
    c(u1<?> paramu1)
    {
      int i = paramu1.entrySet().size();
      this.c = new Object[i];
      this.d = new int[i];
      paramu1 = paramu1.entrySet().iterator();
      for (i = 0; paramu1.hasNext(); i++)
      {
        u1.a locala = (u1.a)paramu1.next();
        this.c[i] = locala.a();
        this.d[i] = locala.getCount();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\k2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */