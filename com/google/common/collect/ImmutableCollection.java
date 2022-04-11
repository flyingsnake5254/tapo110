package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableCollection<E>
  extends AbstractCollection<E>
  implements Serializable
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> asList()
  {
    ImmutableList localImmutableList;
    if (isEmpty()) {
      localImmutableList = ImmutableList.of();
    } else {
      localImmutableList = ImmutableList.asImmutableList(toArray());
    }
    return localImmutableList;
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@NullableDecl Object paramObject);
  
  @CanIgnoreReturnValue
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    j3 localj3 = iterator();
    while (localj3.hasNext())
    {
      paramArrayOfObject[paramInt] = localj3.next();
      paramInt++;
    }
    return paramInt;
  }
  
  Object[] internalArray()
  {
    return null;
  }
  
  int internalArrayEnd()
  {
    throw new UnsupportedOperationException();
  }
  
  int internalArrayStart()
  {
    throw new UnsupportedOperationException();
  }
  
  abstract boolean isPartialView();
  
  public abstract j3<E> iterator();
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray()
  {
    return toArray(EMPTY_ARRAY);
  }
  
  @CanIgnoreReturnValue
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    n.o(paramArrayOfT);
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i)
    {
      localObject = internalArray();
      if (localObject != null) {
        return c2.a((Object[])localObject, internalArrayStart(), internalArrayEnd(), paramArrayOfT);
      }
      localObject = x1.e(paramArrayOfT, i);
    }
    else
    {
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
    copyIntoArray((Object[])localObject, 0);
    return (T[])localObject;
  }
  
  Object writeReplace()
  {
    return new ImmutableList.d(toArray());
  }
  
  static abstract class a<E>
    extends ImmutableCollection.b<E>
  {
    Object[] a;
    int b;
    boolean c;
    
    a(int paramInt)
    {
      v.b(paramInt, "initialCapacity");
      this.a = new Object[paramInt];
      this.b = 0;
    }
    
    private void g(int paramInt)
    {
      Object[] arrayOfObject = this.a;
      if (arrayOfObject.length < paramInt)
      {
        this.a = Arrays.copyOf(arrayOfObject, ImmutableCollection.b.e(arrayOfObject.length, paramInt));
        this.c = false;
      }
      else if (this.c)
      {
        this.a = ((Object[])arrayOfObject.clone());
        this.c = false;
      }
    }
    
    @CanIgnoreReturnValue
    public a<E> f(E paramE)
    {
      n.o(paramE);
      g(this.b + 1);
      Object[] arrayOfObject = this.a;
      int i = this.b;
      this.b = (i + 1);
      arrayOfObject[i] = paramE;
      return this;
    }
  }
  
  public static abstract class b<E>
  {
    static int e(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= 0)
      {
        int i = paramInt1 + (paramInt1 >> 1) + 1;
        paramInt1 = i;
        if (i < paramInt2) {
          paramInt1 = Integer.highestOneBit(paramInt2 - 1) << 1;
        }
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
          paramInt2 = Integer.MAX_VALUE;
        }
        return paramInt2;
      }
      throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
    
    @CanIgnoreReturnValue
    public abstract b<E> a(E paramE);
    
    @CanIgnoreReturnValue
    public b<E> b(E... paramVarArgs)
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        a(paramVarArgs[j]);
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public b<E> c(Iterable<? extends E> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a(paramIterable.next());
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public b<E> d(Iterator<? extends E> paramIterator)
    {
      while (paramIterator.hasNext()) {
        a(paramIterator.next());
      }
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */