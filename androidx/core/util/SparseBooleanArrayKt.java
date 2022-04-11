package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.k;
import kotlin.collections.z;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;

public final class SparseBooleanArrayKt
{
  public static final boolean contains(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    j.f(paramSparseBooleanArray, "$this$contains");
    boolean bool;
    if (paramSparseBooleanArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean containsKey(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    j.f(paramSparseBooleanArray, "$this$containsKey");
    boolean bool;
    if (paramSparseBooleanArray.indexOfKey(paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean containsValue(SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean)
  {
    j.f(paramSparseBooleanArray, "$this$containsValue");
    if (paramSparseBooleanArray.indexOfValue(paramBoolean) >= 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public static final void forEach(SparseBooleanArray paramSparseBooleanArray, kotlin.jvm.b.p<? super Integer, ? super Boolean, kotlin.p> paramp)
  {
    j.f(paramSparseBooleanArray, "$this$forEach");
    j.f(paramp, "action");
    int i = paramSparseBooleanArray.size();
    for (int j = 0; j < i; j++) {
      paramp.invoke(Integer.valueOf(paramSparseBooleanArray.keyAt(j)), Boolean.valueOf(paramSparseBooleanArray.valueAt(j)));
    }
  }
  
  public static final boolean getOrDefault(SparseBooleanArray paramSparseBooleanArray, int paramInt, boolean paramBoolean)
  {
    j.f(paramSparseBooleanArray, "$this$getOrDefault");
    return paramSparseBooleanArray.get(paramInt, paramBoolean);
  }
  
  public static final boolean getOrElse(SparseBooleanArray paramSparseBooleanArray, int paramInt, a<Boolean> parama)
  {
    j.f(paramSparseBooleanArray, "$this$getOrElse");
    j.f(parama, "defaultValue");
    paramInt = paramSparseBooleanArray.indexOfKey(paramInt);
    boolean bool;
    if (paramInt >= 0) {
      bool = paramSparseBooleanArray.valueAt(paramInt);
    } else {
      bool = ((Boolean)parama.invoke()).booleanValue();
    }
    return bool;
  }
  
  public static final int getSize(SparseBooleanArray paramSparseBooleanArray)
  {
    j.f(paramSparseBooleanArray, "$this$size");
    return paramSparseBooleanArray.size();
  }
  
  public static final boolean isEmpty(SparseBooleanArray paramSparseBooleanArray)
  {
    j.f(paramSparseBooleanArray, "$this$isEmpty");
    boolean bool;
    if (paramSparseBooleanArray.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isNotEmpty(SparseBooleanArray paramSparseBooleanArray)
  {
    j.f(paramSparseBooleanArray, "$this$isNotEmpty");
    boolean bool;
    if (paramSparseBooleanArray.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final z keyIterator(SparseBooleanArray paramSparseBooleanArray)
  {
    j.f(paramSparseBooleanArray, "$this$keyIterator");
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
        SparseBooleanArray localSparseBooleanArray = this.$this_keyIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseBooleanArray.keyAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
  
  public static final SparseBooleanArray plus(SparseBooleanArray paramSparseBooleanArray1, SparseBooleanArray paramSparseBooleanArray2)
  {
    j.f(paramSparseBooleanArray1, "$this$plus");
    j.f(paramSparseBooleanArray2, "other");
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray(paramSparseBooleanArray1.size() + paramSparseBooleanArray2.size());
    putAll(localSparseBooleanArray, paramSparseBooleanArray1);
    putAll(localSparseBooleanArray, paramSparseBooleanArray2);
    return localSparseBooleanArray;
  }
  
  public static final void putAll(SparseBooleanArray paramSparseBooleanArray1, SparseBooleanArray paramSparseBooleanArray2)
  {
    j.f(paramSparseBooleanArray1, "$this$putAll");
    j.f(paramSparseBooleanArray2, "other");
    int i = paramSparseBooleanArray2.size();
    for (int j = 0; j < i; j++) {
      paramSparseBooleanArray1.put(paramSparseBooleanArray2.keyAt(j), paramSparseBooleanArray2.valueAt(j));
    }
  }
  
  public static final boolean remove(SparseBooleanArray paramSparseBooleanArray, int paramInt, boolean paramBoolean)
  {
    j.f(paramSparseBooleanArray, "$this$remove");
    int i = paramSparseBooleanArray.indexOfKey(paramInt);
    if ((i >= 0) && (paramBoolean == paramSparseBooleanArray.valueAt(i)))
    {
      paramSparseBooleanArray.delete(paramInt);
      return true;
    }
    return false;
  }
  
  public static final void set(SparseBooleanArray paramSparseBooleanArray, int paramInt, boolean paramBoolean)
  {
    j.f(paramSparseBooleanArray, "$this$set");
    paramSparseBooleanArray.put(paramInt, paramBoolean);
  }
  
  public static final k valueIterator(SparseBooleanArray paramSparseBooleanArray)
  {
    j.f(paramSparseBooleanArray, "$this$valueIterator");
    new k()
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
      
      public boolean nextBoolean()
      {
        SparseBooleanArray localSparseBooleanArray = this.$this_valueIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseBooleanArray.valueAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\SparseBooleanArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */