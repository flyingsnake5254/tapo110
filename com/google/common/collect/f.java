package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class f<E>
  extends i<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  transient y1<E> backingMap;
  transient long size;
  
  f(int paramInt)
  {
    init(paramInt);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = r2.h(paramObjectInputStream);
    init(3);
    r2.g(this, paramObjectInputStream, i);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    r2.k(this, paramObjectOutputStream);
  }
  
  @CanIgnoreReturnValue
  public final int add(@NullableDecl E paramE, int paramInt)
  {
    if (paramInt == 0) {
      return count(paramE);
    }
    boolean bool1 = true;
    boolean bool2;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    n.f(bool2, "occurrences cannot be negative: %s", paramInt);
    int i = this.backingMap.m(paramE);
    if (i == -1)
    {
      this.backingMap.u(paramE, paramInt);
      this.size += paramInt;
      return 0;
    }
    int j = this.backingMap.k(i);
    long l1 = j;
    long l2 = paramInt;
    l1 += l2;
    if (l1 <= 2147483647L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    n.h(bool2, "too many occurrences: %s", l1);
    this.backingMap.B(i, (int)l1);
    this.size += l2;
    return j;
  }
  
  void addTo(u1<? super E> paramu1)
  {
    n.o(paramu1);
    for (int i = this.backingMap.e(); i >= 0; i = this.backingMap.s(i)) {
      paramu1.add(this.backingMap.i(i), this.backingMap.k(i));
    }
  }
  
  public final void clear()
  {
    this.backingMap.a();
    this.size = 0L;
  }
  
  public final int count(@NullableDecl Object paramObject)
  {
    return this.backingMap.f(paramObject);
  }
  
  final int distinctElements()
  {
    return this.backingMap.C();
  }
  
  final Iterator<E> elementIterator()
  {
    return new a();
  }
  
  final Iterator<u1.a<E>> entryIterator()
  {
    return new b();
  }
  
  abstract void init(int paramInt);
  
  public final Iterator<E> iterator()
  {
    return v1.i(this);
  }
  
  @CanIgnoreReturnValue
  public final int remove(@NullableDecl Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      return count(paramObject);
    }
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.f(bool, "occurrences cannot be negative: %s", paramInt);
    int i = this.backingMap.m(paramObject);
    if (i == -1) {
      return 0;
    }
    int j = this.backingMap.k(i);
    if (j > paramInt)
    {
      this.backingMap.B(i, j - paramInt);
    }
    else
    {
      this.backingMap.x(i);
      paramInt = j;
    }
    this.size -= paramInt;
    return j;
  }
  
  @CanIgnoreReturnValue
  public final int setCount(@NullableDecl E paramE, int paramInt)
  {
    v.b(paramInt, "count");
    y1 localy1 = this.backingMap;
    int i;
    if (paramInt == 0) {
      i = localy1.v(paramE);
    } else {
      i = localy1.u(paramE, paramInt);
    }
    this.size += paramInt - i;
    return i;
  }
  
  public final boolean setCount(@NullableDecl E paramE, int paramInt1, int paramInt2)
  {
    v.b(paramInt1, "oldCount");
    v.b(paramInt2, "newCount");
    int i = this.backingMap.m(paramE);
    if (i == -1)
    {
      if (paramInt1 != 0) {
        return false;
      }
      if (paramInt2 > 0)
      {
        this.backingMap.u(paramE, paramInt2);
        this.size += paramInt2;
      }
      return true;
    }
    if (this.backingMap.k(i) != paramInt1) {
      return false;
    }
    if (paramInt2 == 0)
    {
      this.backingMap.x(i);
      this.size -= paramInt1;
    }
    else
    {
      this.backingMap.B(i, paramInt2);
      this.size += paramInt2 - paramInt1;
    }
    return true;
  }
  
  public final int size()
  {
    return d.i(this.size);
  }
  
  class a
    extends f<E>.c<E>
  {
    a()
    {
      super();
    }
    
    E b(int paramInt)
    {
      return (E)f.this.backingMap.i(paramInt);
    }
  }
  
  class b
    extends f<E>.c<u1.a<E>>
  {
    b()
    {
      super();
    }
    
    u1.a<E> c(int paramInt)
    {
      return f.this.backingMap.g(paramInt);
    }
  }
  
  abstract class c<T>
    implements Iterator<T>
  {
    int c = f.this.backingMap.e();
    int d = -1;
    int f = f.this.backingMap.d;
    
    c() {}
    
    private void a()
    {
      if (f.this.backingMap.d == this.f) {
        return;
      }
      throw new ConcurrentModificationException();
    }
    
    abstract T b(int paramInt);
    
    public boolean hasNext()
    {
      a();
      boolean bool;
      if (this.c >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public T next()
    {
      if (hasNext())
      {
        Object localObject = b(this.c);
        int i = this.c;
        this.d = i;
        this.c = f.this.backingMap.s(i);
        return (T)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      a();
      boolean bool;
      if (this.d != -1) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      f localf = f.this;
      localf.size -= localf.backingMap.x(this.d);
      this.c = f.this.backingMap.t(this.c, this.d);
      this.d = -1;
      this.f = f.this.backingMap.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */