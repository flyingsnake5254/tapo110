package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.z;
import kotlin.jvm.internal.j;

public final class SparseArrayKt
{
  public static final <T> boolean contains(SparseArray<T> paramSparseArray, int paramInt)
  {
    j.f(paramSparseArray, "$this$contains");
    boolean bool;
    if (paramSparseArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final <T> boolean containsKey(SparseArray<T> paramSparseArray, int paramInt)
  {
    j.f(paramSparseArray, "$this$containsKey");
    boolean bool;
    if (paramSparseArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final <T> boolean containsValue(SparseArray<T> paramSparseArray, T paramT)
  {
    j.f(paramSparseArray, "$this$containsValue");
    boolean bool;
    if (paramSparseArray.indexOfValue(paramT) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final <T> void forEach(SparseArray<T> paramSparseArray, kotlin.jvm.b.p<? super Integer, ? super T, kotlin.p> paramp)
  {
    j.f(paramSparseArray, "$this$forEach");
    j.f(paramp, "action");
    int i = paramSparseArray.size();
    for (int j = 0; j < i; j++) {
      paramp.invoke(Integer.valueOf(paramSparseArray.keyAt(j)), paramSparseArray.valueAt(j));
    }
  }
  
  public static final <T> T getOrDefault(SparseArray<T> paramSparseArray, int paramInt, T paramT)
  {
    j.f(paramSparseArray, "$this$getOrDefault");
    paramSparseArray = paramSparseArray.get(paramInt);
    if (paramSparseArray != null) {
      paramT = paramSparseArray;
    }
    return paramT;
  }
  
  public static final <T> T getOrElse(SparseArray<T> paramSparseArray, int paramInt, kotlin.jvm.b.a<? extends T> parama)
  {
    j.f(paramSparseArray, "$this$getOrElse");
    j.f(parama, "defaultValue");
    paramSparseArray = paramSparseArray.get(paramInt);
    if (paramSparseArray == null) {
      paramSparseArray = parama.invoke();
    }
    return paramSparseArray;
  }
  
  public static final <T> int getSize(SparseArray<T> paramSparseArray)
  {
    j.f(paramSparseArray, "$this$size");
    return paramSparseArray.size();
  }
  
  public static final <T> boolean isEmpty(SparseArray<T> paramSparseArray)
  {
    j.f(paramSparseArray, "$this$isEmpty");
    boolean bool;
    if (paramSparseArray.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final <T> boolean isNotEmpty(SparseArray<T> paramSparseArray)
  {
    j.f(paramSparseArray, "$this$isNotEmpty");
    boolean bool;
    if (paramSparseArray.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final <T> z keyIterator(SparseArray<T> paramSparseArray)
  {
    j.f(paramSparseArray, "$this$keyIterator");
    new z()
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
      
      public int nextInt()
      {
        SparseArray localSparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseArray.keyAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
  
  public static final <T> SparseArray<T> plus(SparseArray<T> paramSparseArray1, SparseArray<T> paramSparseArray2)
  {
    j.f(paramSparseArray1, "$this$plus");
    j.f(paramSparseArray2, "other");
    SparseArray localSparseArray = new SparseArray(paramSparseArray1.size() + paramSparseArray2.size());
    putAll(localSparseArray, paramSparseArray1);
    putAll(localSparseArray, paramSparseArray2);
    return localSparseArray;
  }
  
  public static final <T> void putAll(SparseArray<T> paramSparseArray1, SparseArray<T> paramSparseArray2)
  {
    j.f(paramSparseArray1, "$this$putAll");
    j.f(paramSparseArray2, "other");
    int i = paramSparseArray2.size();
    for (int j = 0; j < i; j++) {
      paramSparseArray1.put(paramSparseArray2.keyAt(j), paramSparseArray2.valueAt(j));
    }
  }
  
  public static final <T> boolean remove(SparseArray<T> paramSparseArray, int paramInt, T paramT)
  {
    j.f(paramSparseArray, "$this$remove");
    paramInt = paramSparseArray.indexOfKey(paramInt);
    if ((paramInt >= 0) && (j.a(paramT, paramSparseArray.valueAt(paramInt))))
    {
      paramSparseArray.removeAt(paramInt);
      return true;
    }
    return false;
  }
  
  public static final <T> void set(SparseArray<T> paramSparseArray, int paramInt, T paramT)
  {
    j.f(paramSparseArray, "$this$set");
    paramSparseArray.put(paramInt, paramT);
  }
  
  public static final <T> Iterator<T> valueIterator(SparseArray<T> paramSparseArray)
  {
    j.f(paramSparseArray, "$this$valueIterator");
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
        SparseArray localSparseArray = this.$this_valueIterator;
        int i = this.index;
        this.index = (i + 1);
        return (T)localSparseArray.valueAt(i);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\SparseArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */