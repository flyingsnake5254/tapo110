package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.z;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

public final class SparseIntArrayKt
{
  public static final boolean contains(SparseIntArray paramSparseIntArray, int paramInt)
  {
    j.f(paramSparseIntArray, "$this$contains");
    boolean bool;
    if (paramSparseIntArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean containsKey(SparseIntArray paramSparseIntArray, int paramInt)
  {
    j.f(paramSparseIntArray, "$this$containsKey");
    boolean bool;
    if (paramSparseIntArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean containsValue(SparseIntArray paramSparseIntArray, int paramInt)
  {
    j.f(paramSparseIntArray, "$this$containsValue");
    boolean bool;
    if (paramSparseIntArray.indexOfValue(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final void forEach(SparseIntArray paramSparseIntArray, kotlin.jvm.b.p<? super Integer, ? super Integer, kotlin.p> paramp)
  {
    j.f(paramSparseIntArray, "$this$forEach");
    j.f(paramp, "action");
    int i = paramSparseIntArray.size();
    for (int j = 0; j < i; j++) {
      paramp.invoke(Integer.valueOf(paramSparseIntArray.keyAt(j)), Integer.valueOf(paramSparseIntArray.valueAt(j)));
    }
  }
  
  public static final int getOrDefault(SparseIntArray paramSparseIntArray, int paramInt1, int paramInt2)
  {
    j.f(paramSparseIntArray, "$this$getOrDefault");
    return paramSparseIntArray.get(paramInt1, paramInt2);
  }
  
  public static final int getOrElse(SparseIntArray paramSparseIntArray, int paramInt, a<Integer> parama)
  {
    j.f(paramSparseIntArray, "$this$getOrElse");
    j.f(parama, "defaultValue");
    paramInt = paramSparseIntArray.indexOfKey(paramInt);
    if (paramInt >= 0) {
      paramInt = paramSparseIntArray.valueAt(paramInt);
    } else {
      paramInt = ((Number)parama.invoke()).intValue();
    }
    return paramInt;
  }
  
  public static final int getSize(SparseIntArray paramSparseIntArray)
  {
    j.f(paramSparseIntArray, "$this$size");
    return paramSparseIntArray.size();
  }
  
  public static final boolean isEmpty(SparseIntArray paramSparseIntArray)
  {
    j.f(paramSparseIntArray, "$this$isEmpty");
    boolean bool;
    if (paramSparseIntArray.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isNotEmpty(SparseIntArray paramSparseIntArray)
  {
    j.f(paramSparseIntArray, "$this$isNotEmpty");
    boolean bool;
    if (paramSparseIntArray.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final z keyIterator(SparseIntArray paramSparseIntArray)
  {
    j.f(paramSparseIntArray, "$this$keyIterator");
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
        SparseIntArray localSparseIntArray = this.$this_keyIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseIntArray.keyAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
  
  public static final SparseIntArray plus(SparseIntArray paramSparseIntArray1, SparseIntArray paramSparseIntArray2)
  {
    j.f(paramSparseIntArray1, "$this$plus");
    j.f(paramSparseIntArray2, "other");
    SparseIntArray localSparseIntArray = new SparseIntArray(paramSparseIntArray1.size() + paramSparseIntArray2.size());
    putAll(localSparseIntArray, paramSparseIntArray1);
    putAll(localSparseIntArray, paramSparseIntArray2);
    return localSparseIntArray;
  }
  
  public static final void putAll(SparseIntArray paramSparseIntArray1, SparseIntArray paramSparseIntArray2)
  {
    j.f(paramSparseIntArray1, "$this$putAll");
    j.f(paramSparseIntArray2, "other");
    int i = paramSparseIntArray2.size();
    for (int j = 0; j < i; j++) {
      paramSparseIntArray1.put(paramSparseIntArray2.keyAt(j), paramSparseIntArray2.valueAt(j));
    }
  }
  
  public static final boolean remove(SparseIntArray paramSparseIntArray, int paramInt1, int paramInt2)
  {
    j.f(paramSparseIntArray, "$this$remove");
    paramInt1 = paramSparseIntArray.indexOfKey(paramInt1);
    if ((paramInt1 >= 0) && (paramInt2 == paramSparseIntArray.valueAt(paramInt1)))
    {
      paramSparseIntArray.removeAt(paramInt1);
      return true;
    }
    return false;
  }
  
  public static final void set(SparseIntArray paramSparseIntArray, int paramInt1, int paramInt2)
  {
    j.f(paramSparseIntArray, "$this$set");
    paramSparseIntArray.put(paramInt1, paramInt2);
  }
  
  public static final z valueIterator(SparseIntArray paramSparseIntArray)
  {
    j.f(paramSparseIntArray, "$this$valueIterator");
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
        if (this.index < this.$this_valueIterator.size()) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public int nextInt()
      {
        SparseIntArray localSparseIntArray = this.$this_valueIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseIntArray.valueAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\SparseIntArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */