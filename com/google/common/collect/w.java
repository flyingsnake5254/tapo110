package com.google.common.collect;

import com.google.common.base.n;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class w
{
  static <T> Collection<T> a(Iterable<T> paramIterable)
  {
    return (Collection)paramIterable;
  }
  
  static boolean b(Collection<?> paramCollection1, Collection<?> paramCollection2)
  {
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext()) {
      if (!paramCollection1.contains(paramCollection2.next())) {
        return false;
      }
    }
    return true;
  }
  
  static StringBuilder c(int paramInt)
  {
    v.b(paramInt, "size");
    return new StringBuilder((int)Math.min(paramInt * 8L, 1073741824L));
  }
  
  static boolean d(Collection<?> paramCollection, @NullableDecl Object paramObject)
  {
    n.o(paramCollection);
    try
    {
      boolean bool = paramCollection.contains(paramObject);
      return bool;
    }
    catch (ClassCastException|NullPointerException paramCollection) {}
    return false;
  }
  
  static boolean e(Collection<?> paramCollection, @NullableDecl Object paramObject)
  {
    n.o(paramCollection);
    try
    {
      boolean bool = paramCollection.remove(paramObject);
      return bool;
    }
    catch (ClassCastException|NullPointerException paramCollection) {}
    return false;
  }
  
  static String f(Collection<?> paramCollection)
  {
    StringBuilder localStringBuilder = c(paramCollection.size());
    localStringBuilder.append('[');
    Iterator localIterator = paramCollection.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i == 0) {
        localStringBuilder.append(", ");
      }
      i = 0;
      if (localObject == paramCollection) {
        localStringBuilder.append("(this Collection)");
      } else {
        localStringBuilder.append(localObject);
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */