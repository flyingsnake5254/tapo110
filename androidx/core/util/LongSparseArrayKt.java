package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.collections.a0;
import kotlin.jvm.internal.j;

public final class LongSparseArrayKt
{
  @RequiresApi(16)
  public static final <T> boolean contains(LongSparseArray<T> paramLongSparseArray, long paramLong)
  {
    j.f(paramLongSparseArray, "$this$contains");
    boolean bool;
    if (paramLongSparseArray.indexOfKey(paramLong) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(16)
  public static final <T> boolean containsKey(LongSparseArray<T> paramLongSparseArray, long paramLong)
  {
    j.f(paramLongSparseArray, "$this$containsKey");
    boolean bool;
    if (paramLongSparseArray.indexOfKey(paramLong) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(16)
  public static final <T> boolean containsValue(LongSparseArray<T> paramLongSparseArray, T paramT)
  {
    j.f(paramLongSparseArray, "$this$containsValue");
    boolean bool;
    if (paramLongSparseArray.indexOfValue(paramT) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(16)
  public static final <T> void forEach(LongSparseArray<T> paramLongSparseArray, kotlin.jvm.b.p<? super Long, ? super T, kotlin.p> paramp)
  {
    j.f(paramLongSparseArray, "$this$forEach");
    j.f(paramp, "action");
    int i = paramLongSparseArray.size();
    for (int j = 0; j < i; j++) {
      paramp.invoke(Long.valueOf(paramLongSparseArray.keyAt(j)), paramLongSparseArray.valueAt(j));
    }
  }
  
  @RequiresApi(16)
  public static final <T> T getOrDefault(LongSparseArray<T> paramLongSparseArray, long paramLong, T paramT)
  {
    j.f(paramLongSparseArray, "$this$getOrDefault");
    paramLongSparseArray = paramLongSparseArray.get(paramLong);
    if (paramLongSparseArray != null) {
      paramT = paramLongSparseArray;
    }
    return paramT;
  }
  
  @RequiresApi(16)
  public static final <T> T getOrElse(LongSparseArray<T> paramLongSparseArray, long paramLong, kotlin.jvm.b.a<? extends T> parama)
  {
    j.f(paramLongSparseArray, "$this$getOrElse");
    j.f(parama, "defaultValue");
    paramLongSparseArray = paramLongSparseArray.get(paramLong);
    if (paramLongSparseArray == null) {
      paramLongSparseArray = parama.invoke();
    }
    return paramLongSparseArray;
  }
  
  @RequiresApi(16)
  public static final <T> int getSize(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "$this$size");
    return paramLongSparseArray.size();
  }
  
  @RequiresApi(16)
  public static final <T> boolean isEmpty(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "$this$isEmpty");
    boolean bool;
    if (paramLongSparseArray.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(16)
  public static final <T> boolean isNotEmpty(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "$this$isNotEmpty");
    boolean bool;
    if (paramLongSparseArray.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(16)
  public static final <T> a0 keyIterator(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "$this$keyIterator");
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
  
  @RequiresApi(16)
  public static final <T> LongSparseArray<T> plus(LongSparseArray<T> paramLongSparseArray1, LongSparseArray<T> paramLongSparseArray2)
  {
    j.f(paramLongSparseArray1, "$this$plus");
    j.f(paramLongSparseArray2, "other");
    LongSparseArray localLongSparseArray = new LongSparseArray(paramLongSparseArray1.size() + paramLongSparseArray2.size());
    putAll(localLongSparseArray, paramLongSparseArray1);
    putAll(localLongSparseArray, paramLongSparseArray2);
    return localLongSparseArray;
  }
  
  @RequiresApi(16)
  public static final <T> void putAll(LongSparseArray<T> paramLongSparseArray1, LongSparseArray<T> paramLongSparseArray2)
  {
    j.f(paramLongSparseArray1, "$this$putAll");
    j.f(paramLongSparseArray2, "other");
    int i = paramLongSparseArray2.size();
    for (int j = 0; j < i; j++) {
      paramLongSparseArray1.put(paramLongSparseArray2.keyAt(j), paramLongSparseArray2.valueAt(j));
    }
  }
  
  @RequiresApi(16)
  public static final <T> boolean remove(LongSparseArray<T> paramLongSparseArray, long paramLong, T paramT)
  {
    j.f(paramLongSparseArray, "$this$remove");
    int i = paramLongSparseArray.indexOfKey(paramLong);
    if ((i >= 0) && (j.a(paramT, paramLongSparseArray.valueAt(i))))
    {
      paramLongSparseArray.removeAt(i);
      return true;
    }
    return false;
  }
  
  @RequiresApi(16)
  public static final <T> void set(LongSparseArray<T> paramLongSparseArray, long paramLong, T paramT)
  {
    j.f(paramLongSparseArray, "$this$set");
    paramLongSparseArray.put(paramLong, paramT);
  }
  
  @RequiresApi(16)
  public static final <T> Iterator<T> valueIterator(LongSparseArray<T> paramLongSparseArray)
  {
    j.f(paramLongSparseArray, "$this$valueIterator");
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\LongSparseArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */