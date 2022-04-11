package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableSet<E>
  extends ImmutableCollection<E>
  implements Set<E>
{
  private static final int CUTOFF = 751619276;
  private static final double DESIRED_LOAD_FACTOR = 0.7D;
  static final int MAX_TABLE_SIZE = 1073741824;
  @LazyInit
  @NullableDecl
  @RetainedWith
  private transient ImmutableList<E> asList;
  
  public static <E> a<E> builder()
  {
    return new a();
  }
  
  public static <E> a<E> builderWithExpectedSize(int paramInt)
  {
    v.b(paramInt, "expectedSize");
    return new a(paramInt);
  }
  
  static int chooseTableSize(int paramInt)
  {
    int i = Math.max(paramInt, 2);
    boolean bool = true;
    if (i < 751619276)
    {
      paramInt = Integer.highestOneBit(i - 1) << 1;
      while (paramInt * 0.7D < i) {
        paramInt <<= 1;
      }
      return paramInt;
    }
    if (i >= 1073741824) {
      bool = false;
    }
    n.e(bool, "collection too large");
    return 1073741824;
  }
  
  private static <E> ImmutableSet<E> construct(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        int i = chooseTableSize(paramInt);
        Object[] arrayOfObject = new Object[i];
        int j = i - 1;
        int k = 0;
        int m = 0;
        int n = 0;
        if (k < paramInt)
        {
          Object localObject1 = x1.a(paramVarArgs[k], k);
          int i1 = localObject1.hashCode();
          for (int i2 = y0.c(i1);; i2++)
          {
            int i3 = i2 & j;
            localObject2 = arrayOfObject[i3];
            if (localObject2 == null)
            {
              paramVarArgs[n] = localObject1;
              arrayOfObject[i3] = localObject1;
              m += i1;
              n++;
            }
            else
            {
              if (!localObject2.equals(localObject1)) {
                continue;
              }
            }
            k++;
            break;
          }
        }
        Arrays.fill(paramVarArgs, n, paramInt, null);
        if (n == 1) {
          return new v2(paramVarArgs[0], m);
        }
        if (chooseTableSize(n) < i / 2) {
          return construct(n, paramVarArgs);
        }
        Object localObject2 = paramVarArgs;
        if (shouldTrim(n, paramVarArgs.length)) {
          localObject2 = Arrays.copyOf(paramVarArgs, n);
        }
        return new l2((Object[])localObject2, m, arrayOfObject, j, n);
      }
      return of(paramVarArgs[0]);
    }
    return of();
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      paramIterable = copyOf((Collection)paramIterable);
    } else {
      paramIterable = copyOf(paramIterable.iterator());
    }
    return paramIterable;
  }
  
  public static <E> ImmutableSet<E> copyOf(Collection<? extends E> paramCollection)
  {
    if (((paramCollection instanceof ImmutableSet)) && (!(paramCollection instanceof SortedSet)))
    {
      ImmutableSet localImmutableSet = (ImmutableSet)paramCollection;
      if (!localImmutableSet.isPartialView()) {
        return localImmutableSet;
      }
    }
    paramCollection = paramCollection.toArray();
    return construct(paramCollection.length, paramCollection);
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> paramIterator)
  {
    if (!paramIterator.hasNext()) {
      return of();
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return of(localObject);
    }
    return new a().h(localObject).i(paramIterator).k();
  }
  
  public static <E> ImmutableSet<E> copyOf(E[] paramArrayOfE)
  {
    int i = paramArrayOfE.length;
    if (i != 0)
    {
      if (i != 1) {
        return construct(paramArrayOfE.length, (Object[])paramArrayOfE.clone());
      }
      return of(paramArrayOfE[0]);
    }
    return of();
  }
  
  public static <E> ImmutableSet<E> of()
  {
    return l2.c;
  }
  
  public static <E> ImmutableSet<E> of(E paramE)
  {
    return new v2(paramE);
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2)
  {
    return construct(2, new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3)
  {
    return construct(3, new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return construct(4, new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return construct(5, new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  @SafeVarargs
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length <= 2147483641) {
      bool = true;
    } else {
      bool = false;
    }
    n.e(bool, "the total number of elements must fit in an int");
    int i = paramVarArgs.length + 6;
    Object[] arrayOfObject = new Object[i];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 6, paramVarArgs.length);
    return construct(i, arrayOfObject);
  }
  
  private static boolean shouldTrim(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 < (paramInt2 >> 1) + (paramInt2 >> 2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ImmutableList<E> asList()
  {
    ImmutableList localImmutableList1 = this.asList;
    ImmutableList localImmutableList2 = localImmutableList1;
    if (localImmutableList1 == null)
    {
      localImmutableList2 = createAsList();
      this.asList = localImmutableList2;
    }
    return localImmutableList2;
  }
  
  ImmutableList<E> createAsList()
  {
    return ImmutableList.asImmutableList(toArray());
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof ImmutableSet)) && (isHashCodeFast()) && (((ImmutableSet)paramObject).isHashCodeFast()) && (hashCode() != paramObject.hashCode())) {
      return false;
    }
    return u2.a(this, paramObject);
  }
  
  public int hashCode()
  {
    return u2.b(this);
  }
  
  boolean isHashCodeFast()
  {
    return false;
  }
  
  public abstract j3<E> iterator();
  
  Object writeReplace()
  {
    return new b(toArray());
  }
  
  public static class a<E>
    extends ImmutableCollection.a<E>
  {
    @NullableDecl
    Object[] d;
    private int e;
    
    public a()
    {
      super();
    }
    
    a(int paramInt)
    {
      super();
      this.d = new Object[ImmutableSet.chooseTableSize(paramInt)];
    }
    
    private void j(E paramE)
    {
      int i = this.d.length;
      int j = paramE.hashCode();
      for (int k = y0.c(j);; k++)
      {
        k &= i - 1;
        Object[] arrayOfObject = this.d;
        Object localObject = arrayOfObject[k];
        if (localObject == null)
        {
          arrayOfObject[k] = paramE;
          this.e += j;
          super.f(paramE);
          return;
        }
        if (localObject.equals(paramE)) {
          return;
        }
      }
    }
    
    @CanIgnoreReturnValue
    public a<E> h(E paramE)
    {
      n.o(paramE);
      if ((this.d != null) && (ImmutableSet.chooseTableSize(this.b) <= this.d.length))
      {
        j(paramE);
        return this;
      }
      this.d = null;
      super.f(paramE);
      return this;
    }
    
    @CanIgnoreReturnValue
    public a<E> i(Iterator<? extends E> paramIterator)
    {
      n.o(paramIterator);
      while (paramIterator.hasNext()) {
        h(paramIterator.next());
      }
      return this;
    }
    
    public ImmutableSet<E> k()
    {
      int i = this.b;
      if (i != 0)
      {
        if (i != 1)
        {
          Object localObject;
          if ((this.d != null) && (ImmutableSet.chooseTableSize(i) == this.d.length))
          {
            if (ImmutableSet.shouldTrim(this.b, this.a.length)) {
              localObject = Arrays.copyOf(this.a, this.b);
            } else {
              localObject = this.a;
            }
            i = this.e;
            Object[] arrayOfObject = this.d;
            localObject = new l2((Object[])localObject, i, arrayOfObject, arrayOfObject.length - 1, this.b);
          }
          else
          {
            localObject = ImmutableSet.construct(this.b, this.a);
            this.b = ((AbstractCollection)localObject).size();
          }
          this.c = true;
          this.d = null;
          return (ImmutableSet<E>)localObject;
        }
        return ImmutableSet.of(this.a[0]);
      }
      return ImmutableSet.of();
    }
  }
  
  private static class b
    implements Serializable
  {
    final Object[] c;
    
    b(Object[] paramArrayOfObject)
    {
      this.c = paramArrayOfObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */