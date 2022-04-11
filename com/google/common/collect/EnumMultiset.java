package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class EnumMultiset<E extends Enum<E>>
  extends i<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private transient int[] counts;
  private transient int distinctElements;
  private transient E[] enumConstants;
  private transient long size;
  private transient Class<E> type;
  
  private EnumMultiset(Class<E> paramClass)
  {
    this.type = paramClass;
    n.d(paramClass.isEnum());
    paramClass = (Enum[])paramClass.getEnumConstants();
    this.enumConstants = paramClass;
    this.counts = new int[paramClass.length];
  }
  
  public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> paramClass)
  {
    return new EnumMultiset(paramClass);
  }
  
  public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> paramIterable)
  {
    Object localObject = paramIterable.iterator();
    n.e(((Iterator)localObject).hasNext(), "EnumMultiset constructor passed empty Iterable");
    localObject = new EnumMultiset(((Enum)((Iterator)localObject).next()).getDeclaringClass());
    j1.a((Collection)localObject, paramIterable);
    return (EnumMultiset<E>)localObject;
  }
  
  public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> paramIterable, Class<E> paramClass)
  {
    paramClass = create(paramClass);
    j1.a(paramClass, paramIterable);
    return paramClass;
  }
  
  private boolean isActuallyE(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof Enum;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (Enum)paramObject;
      int i = ((Enum)paramObject).ordinal();
      Enum[] arrayOfEnum = this.enumConstants;
      bool3 = bool2;
      if (i < arrayOfEnum.length)
      {
        bool3 = bool2;
        if (arrayOfEnum[i] == paramObject) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    Object localObject = (Class)paramObjectInputStream.readObject();
    this.type = ((Class)localObject);
    localObject = (Enum[])((Class)localObject).getEnumConstants();
    this.enumConstants = ((Enum[])localObject);
    this.counts = new int[localObject.length];
    r2.f(this, paramObjectInputStream);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.type);
    r2.k(this, paramObjectOutputStream);
  }
  
  @CanIgnoreReturnValue
  public int add(E paramE, int paramInt)
  {
    checkIsE(paramE);
    v.b(paramInt, "occurrences");
    if (paramInt == 0) {
      return count(paramE);
    }
    int i = paramE.ordinal();
    int j = this.counts[i];
    long l1 = j;
    long l2 = paramInt;
    l1 += l2;
    boolean bool;
    if (l1 <= 2147483647L) {
      bool = true;
    } else {
      bool = false;
    }
    n.h(bool, "too many occurrences: %s", l1);
    this.counts[i] = ((int)l1);
    if (j == 0) {
      this.distinctElements += 1;
    }
    this.size += l2;
    return j;
  }
  
  void checkIsE(@NullableDecl Object paramObject)
  {
    n.o(paramObject);
    if (isActuallyE(paramObject)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected an ");
    localStringBuilder.append(this.type);
    localStringBuilder.append(" but got ");
    localStringBuilder.append(paramObject);
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public void clear()
  {
    Arrays.fill(this.counts, 0);
    this.size = 0L;
    this.distinctElements = 0;
  }
  
  public int count(@NullableDecl Object paramObject)
  {
    if ((paramObject != null) && (isActuallyE(paramObject)))
    {
      paramObject = (Enum)paramObject;
      return this.counts[paramObject.ordinal()];
    }
    return 0;
  }
  
  int distinctElements()
  {
    return this.distinctElements;
  }
  
  Iterator<E> elementIterator()
  {
    return new a();
  }
  
  Iterator<u1.a<E>> entryIterator()
  {
    return new b();
  }
  
  public Iterator<E> iterator()
  {
    return v1.i(this);
  }
  
  @CanIgnoreReturnValue
  public int remove(@NullableDecl Object paramObject, int paramInt)
  {
    if ((paramObject != null) && (isActuallyE(paramObject)))
    {
      Enum localEnum = (Enum)paramObject;
      v.b(paramInt, "occurrences");
      if (paramInt == 0) {
        return count(paramObject);
      }
      int i = localEnum.ordinal();
      paramObject = this.counts;
      int j = paramObject[i];
      if (j == 0) {
        return 0;
      }
      if (j <= paramInt)
      {
        paramObject[i] = 0;
        this.distinctElements -= 1;
        this.size -= j;
      }
      else
      {
        paramObject[i] = (j - paramInt);
        this.size -= paramInt;
      }
      return j;
    }
    return 0;
  }
  
  @CanIgnoreReturnValue
  public int setCount(E paramE, int paramInt)
  {
    checkIsE(paramE);
    v.b(paramInt, "count");
    int i = paramE.ordinal();
    paramE = this.counts;
    int j = paramE[i];
    paramE[i] = paramInt;
    this.size += paramInt - j;
    if ((j == 0) && (paramInt > 0)) {
      this.distinctElements += 1;
    } else if ((j > 0) && (paramInt == 0)) {
      this.distinctElements -= 1;
    }
    return j;
  }
  
  public int size()
  {
    return d.i(this.size);
  }
  
  class a
    extends EnumMultiset<E>.c<E>
  {
    a()
    {
      super();
    }
    
    E b(int paramInt)
    {
      return EnumMultiset.this.enumConstants[paramInt];
    }
  }
  
  class b
    extends EnumMultiset<E>.c<u1.a<E>>
  {
    b()
    {
      super();
    }
    
    u1.a<E> b(final int paramInt)
    {
      return new a(paramInt);
    }
    
    class a
      extends v1.b<E>
    {
      a(int paramInt) {}
      
      public E b()
      {
        return EnumMultiset.this.enumConstants[paramInt];
      }
      
      public int getCount()
      {
        return EnumMultiset.this.counts[paramInt];
      }
    }
  }
  
  abstract class c<T>
    implements Iterator<T>
  {
    int c = 0;
    int d = -1;
    
    c() {}
    
    abstract T a(int paramInt);
    
    public boolean hasNext()
    {
      while (this.c < EnumMultiset.this.enumConstants.length)
      {
        int[] arrayOfInt = EnumMultiset.this.counts;
        int i = this.c;
        if (arrayOfInt[i] > 0) {
          return true;
        }
        this.c = (i + 1);
      }
      return false;
    }
    
    public T next()
    {
      if (hasNext())
      {
        Object localObject = a(this.c);
        int i = this.c;
        this.d = i;
        this.c = (i + 1);
        return (T)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      boolean bool;
      if (this.d >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      v.e(bool);
      if (EnumMultiset.this.counts[this.d] > 0)
      {
        EnumMultiset.access$210(EnumMultiset.this);
        EnumMultiset localEnumMultiset = EnumMultiset.this;
        EnumMultiset.access$302(localEnumMultiset, localEnumMultiset.size - EnumMultiset.this.counts[this.d]);
        EnumMultiset.this.counts[this.d] = 0;
      }
      this.d = -1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\EnumMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */