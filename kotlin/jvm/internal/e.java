package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collection<*>;
import java.util.Iterator;
import java.util.Objects;

public final class e
{
  private static final Object[] a = new Object[0];
  
  public static final Object[] a(Collection<?> paramCollection)
  {
    j.e(paramCollection, "collection");
    int i = paramCollection.size();
    if (i == 0) {}
    Iterator localIterator;
    do
    {
      paramCollection = a;
      break;
      localIterator = paramCollection.iterator();
    } while (!localIterator.hasNext());
    paramCollection = new Object[i];
    i = 0;
    for (;;)
    {
      int j = i + 1;
      paramCollection[i] = localIterator.next();
      Object localObject;
      if (j >= paramCollection.length)
      {
        if (localIterator.hasNext())
        {
          int k = j * 3 + 1 >>> 1;
          i = k;
          if (k <= j) {
            if (j < 2147483645) {
              i = 2147483645;
            } else {
              throw new OutOfMemoryError();
            }
          }
          localObject = Arrays.copyOf(paramCollection, i);
          j.d(localObject, "Arrays.copyOf(result, newSize)");
          break label162;
        }
      }
      else
      {
        localObject = paramCollection;
        if (localIterator.hasNext()) {
          break label162;
        }
        paramCollection = Arrays.copyOf(paramCollection, j);
        j.d(paramCollection, "Arrays.copyOf(result, size)");
      }
      return paramCollection;
      label162:
      i = j;
      paramCollection = (Collection<?>)localObject;
    }
  }
  
  public static final Object[] b(Collection<?> paramCollection, Object[] paramArrayOfObject)
  {
    j.e(paramCollection, "collection");
    Objects.requireNonNull(paramArrayOfObject);
    int i = paramCollection.size();
    int j = 0;
    Iterator localIterator;
    if (i == 0)
    {
      paramCollection = paramArrayOfObject;
      if (paramArrayOfObject.length > 0)
      {
        paramArrayOfObject[0] = null;
        paramCollection = paramArrayOfObject;
      }
    }
    else
    {
      localIterator = paramCollection.iterator();
      if (!localIterator.hasNext())
      {
        paramCollection = paramArrayOfObject;
        if (paramArrayOfObject.length > 0)
        {
          paramArrayOfObject[0] = null;
          paramCollection = paramArrayOfObject;
        }
      }
      else if (i <= paramArrayOfObject.length)
      {
        paramCollection = paramArrayOfObject;
      }
      else
      {
        paramCollection = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
        Objects.requireNonNull(paramCollection, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      }
    }
    Object localObject;
    for (paramCollection = (Object[])paramCollection;; paramCollection = (Collection<?>)localObject)
    {
      i = j + 1;
      paramCollection[j] = localIterator.next();
      if (i >= paramCollection.length)
      {
        if (localIterator.hasNext())
        {
          int k = i * 3 + 1 >>> 1;
          j = k;
          if (k <= i) {
            if (i < 2147483645) {
              j = 2147483645;
            } else {
              throw new OutOfMemoryError();
            }
          }
          localObject = Arrays.copyOf(paramCollection, j);
          j.d(localObject, "Arrays.copyOf(result, newSize)");
          break label238;
        }
      }
      else
      {
        localObject = paramCollection;
        if (localIterator.hasNext()) {
          break label238;
        }
        if (paramCollection == paramArrayOfObject)
        {
          paramArrayOfObject[i] = null;
          paramCollection = paramArrayOfObject;
        }
        else
        {
          paramCollection = Arrays.copyOf(paramCollection, i);
          j.d(paramCollection, "Arrays.copyOf(result, size)");
        }
      }
      return paramCollection;
      label238:
      j = i;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */