package androidx.collection;

import java.util.Iterator;
import kotlin.collections.a0;
import kotlin.jvm.internal.j;

public final class LongSparseArrayKt
{
  public static final <T> boolean contains(LongSparseArray<T> paramLongSparseArray, long paramLong)
  {
    j.f(paramLongSparseArray, "receiver$0");
    return paramLongSparseArray.containsKey(paramLong);
  }
  
  public static final <T> void forEach(LongSparseArray<T> paramLongSparseArray, kotlin.jvm.b.p<? super Long, ? super T, kotlin.p> paramp)
  {
    j.f(paramLongSparseArray, "receiver$0");
    j.f(paramp, "action");
    int i = paramLongSparseArray.size();
    for (int j = 0; j < i; j++) {
      paramp.invoke(Long.valueOf(paramLongSparseArray.keyAt(j)), paramLongSparseArray.valueAt(j));
    }
  }
  
  public static final <T> T getOrDefault(LongSparseArray<T> paramLongSparseArray, long paramLong, T paramT)
  {
    j.f(paramLongSparseArray, "receiver$0");
    return (T)paramLongSparseArray.get(paramLong, paramT);
  }
  
  public static final <T> T getOrElse(LongSparseArray<T> paramLongSparseArray, long paramLong, kotlin.jvm.b.a<? extends T> parama)
  {
    j.f(paramLongSparseArray, "receiver$0");
    j.f(parama, "defaultValue");
    paramLongSparseArray = paramLongSparseArray.get(paramLong);
    if (paramLongSparseArray == null) {
      paramLongSparseArray = parama.invoke();
    }
    return paramLongSparseArray;
  }
  
  public static final <T> int getSize(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "receiver$0");
    return paramLongSparseArray.size();
  }
  
  public static final <T> boolean isNotEmpty(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "receiver$0");
    return paramLongSparseArray.isEmpty() ^ true;
  }
  
  public static final <T> a0 keyIterator(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "receiver$0");
    new a0()
    {
      private int index;
      
      public final int getIndex()
      {
        return this.index;
      }
      
      public boolean hasNext()
      {
        boolean bool;
        if (this.index < this.$this_keyIterator.size()) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public long nextLong()
      {
        LongSparseArray localLongSparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = (i + 1);
        return localLongSparseArray.keyAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
  
  public static final <T> LongSparseArray<T> plus(LongSparseArray<T> paramLongSparseArray1, LongSparseArray<T> paramLongSparseArray2)
  {
    j.f(paramLongSparseArray1, "receiver$0");
    j.f(paramLongSparseArray2, "other");
    LongSparseArray localLongSparseArray = new LongSparseArray(paramLongSparseArray1.size() + paramLongSparseArray2.size());
    localLongSparseArray.putAll(paramLongSparseArray1);
    localLongSparseArray.putAll(paramLongSparseArray2);
    return localLongSparseArray;
  }
  
  public static final <T> boolean remove(LongSparseArray<T> paramLongSparseArray, long paramLong, T paramT)
  {
    j.f(paramLongSparseArray, "receiver$0");
    return paramLongSparseArray.remove(paramLong, paramT);
  }
  
  public static final <T> void set(LongSparseArray<T> paramLongSparseArray, long paramLong, T paramT)
  {
    j.f(paramLongSparseArray, "receiver$0");
    paramLongSparseArray.put(paramLong, paramT);
  }
  
  public static final <T> Iterator<T> valueIterator(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "receiver$0");
    new Iterator()
    {
      private int index;
      
      public final int getIndex()
      {
        return this.index;
      }
      
      public boolean hasNext()
      {
        boolean bool;
        if (this.index < this.$this_valueIterator.size()) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public T next()
      {
        LongSparseArray localLongSparseArray = this.$this_valueIterator;
        int i = this.index;
        this.index = (i + 1);
        return (T)localLongSparseArray.valueAt(i);
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\collection\LongSparseArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */