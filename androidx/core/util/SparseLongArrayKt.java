package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.collections.a0;
import kotlin.collections.z;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

public final class SparseLongArrayKt
{
  @RequiresApi(18)
  public static final boolean contains(SparseLongArray paramSparseLongArray, int paramInt)
  {
    j.f(paramSparseLongArray, "$this$contains");
    boolean bool;
    if (paramSparseLongArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(18)
  public static final boolean containsKey(SparseLongArray paramSparseLongArray, int paramInt)
  {
    j.f(paramSparseLongArray, "$this$containsKey");
    boolean bool;
    if (paramSparseLongArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(18)
  public static final boolean containsValue(SparseLongArray paramSparseLongArray, long paramLong)
  {
    j.f(paramSparseLongArray, "$this$containsValue");
    boolean bool;
    if (paramSparseLongArray.indexOfValue(paramLong) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(18)
  public static final void forEach(SparseLongArray paramSparseLongArray, kotlin.jvm.b.p<? super Integer, ? super Long, kotlin.p> paramp)
  {
    j.f(paramSparseLongArray, "$this$forEach");
    j.f(paramp, "action");
    int i = paramSparseLongArray.size();
    for (int j = 0; j < i; j++) {
      paramp.invoke(Integer.valueOf(paramSparseLongArray.keyAt(j)), Long.valueOf(paramSparseLongArray.valueAt(j)));
    }
  }
  
  @RequiresApi(18)
  public static final long getOrDefault(SparseLongArray paramSparseLongArray, int paramInt, long paramLong)
  {
    j.f(paramSparseLongArray, "$this$getOrDefault");
    return paramSparseLongArray.get(paramInt, paramLong);
  }
  
  @RequiresApi(18)
  public static final long getOrElse(SparseLongArray paramSparseLongArray, int paramInt, a<Long> parama)
  {
    j.f(paramSparseLongArray, "$this$getOrElse");
    j.f(parama, "defaultValue");
    paramInt = paramSparseLongArray.indexOfKey(paramInt);
    long l;
    if (paramInt >= 0) {
      l = paramSparseLongArray.valueAt(paramInt);
    } else {
      l = ((Number)parama.invoke()).longValue();
    }
    return l;
  }
  
  @RequiresApi(18)
  public static final int getSize(SparseLongArray paramSparseLongArray)
  {
    j.f(paramSparseLongArray, "$this$size");
    return paramSparseLongArray.size();
  }
  
  @RequiresApi(18)
  public static final boolean isEmpty(SparseLongArray paramSparseLongArray)
  {
    j.f(paramSparseLongArray, "$this$isEmpty");
    boolean bool;
    if (paramSparseLongArray.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(18)
  public static final boolean isNotEmpty(SparseLongArray paramSparseLongArray)
  {
    j.f(paramSparseLongArray, "$this$isNotEmpty");
    boolean bool;
    if (paramSparseLongArray.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(18)
  public static final z keyIterator(SparseLongArray paramSparseLongArray)
  {
    j.f(paramSparseLongArray, "$this$keyIterator");
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
        SparseLongArray localSparseLongArray = this.$this_keyIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseLongArray.keyAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
  
  @RequiresApi(18)
  public static final SparseLongArray plus(SparseLongArray paramSparseLongArray1, SparseLongArray paramSparseLongArray2)
  {
    j.f(paramSparseLongArray1, "$this$plus");
    j.f(paramSparseLongArray2, "other");
    SparseLongArray localSparseLongArray = new SparseLongArray(paramSparseLongArray1.size() + paramSparseLongArray2.size());
    putAll(localSparseLongArray, paramSparseLongArray1);
    putAll(localSparseLongArray, paramSparseLongArray2);
    return localSparseLongArray;
  }
  
  @RequiresApi(18)
  public static final void putAll(SparseLongArray paramSparseLongArray1, SparseLongArray paramSparseLongArray2)
  {
    j.f(paramSparseLongArray1, "$this$putAll");
    j.f(paramSparseLongArray2, "other");
    int i = paramSparseLongArray2.size();
    for (int j = 0; j < i; j++) {
      paramSparseLongArray1.put(paramSparseLongArray2.keyAt(j), paramSparseLongArray2.valueAt(j));
    }
  }
  
  @RequiresApi(18)
  public static final boolean remove(SparseLongArray paramSparseLongArray, int paramInt, long paramLong)
  {
    j.f(paramSparseLongArray, "$this$remove");
    paramInt = paramSparseLongArray.indexOfKey(paramInt);
    if ((paramInt >= 0) && (paramLong == paramSparseLongArray.valueAt(paramInt)))
    {
      paramSparseLongArray.removeAt(paramInt);
      return true;
    }
    return false;
  }
  
  @RequiresApi(18)
  public static final void set(SparseLongArray paramSparseLongArray, int paramInt, long paramLong)
  {
    j.f(paramSparseLongArray, "$this$set");
    paramSparseLongArray.put(paramInt, paramLong);
  }
  
  @RequiresApi(18)
  public static final a0 valueIterator(SparseLongArray paramSparseLongArray)
  {
    j.f(paramSparseLongArray, "$this$valueIterator");
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
        if (this.index < this.$this_valueIterator.size()) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public long nextLong()
      {
        SparseLongArray localSparseLongArray = this.$this_valueIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseLongArray.valueAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\SparseLongArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */