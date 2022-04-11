package androidx.collection;

import java.util.Iterator;
import kotlin.collections.z;
import kotlin.jvm.internal.j;

public final class SparseArrayKt
{
  public static final <T> boolean contains(SparseArrayCompat<T> paramSparseArrayCompat, int paramInt)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    return paramSparseArrayCompat.containsKey(paramInt);
  }
  
  public static final <T> void forEach(SparseArrayCompat<T> paramSparseArrayCompat, kotlin.jvm.b.p<? super Integer, ? super T, kotlin.p> paramp)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    j.f(paramp, "action");
    int i = paramSparseArrayCompat.size();
    for (int j = 0; j < i; j++) {
      paramp.invoke(Integer.valueOf(paramSparseArrayCompat.keyAt(j)), paramSparseArrayCompat.valueAt(j));
    }
  }
  
  public static final <T> T getOrDefault(SparseArrayCompat<T> paramSparseArrayCompat, int paramInt, T paramT)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    return (T)paramSparseArrayCompat.get(paramInt, paramT);
  }
  
  public static final <T> T getOrElse(SparseArrayCompat<T> paramSparseArrayCompat, int paramInt, kotlin.jvm.b.a<? extends T> parama)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    j.f(parama, "defaultValue");
    paramSparseArrayCompat = paramSparseArrayCompat.get(paramInt);
    if (paramSparseArrayCompat == null) {
      paramSparseArrayCompat = parama.invoke();
    }
    return paramSparseArrayCompat;
  }
  
  public static final <T> int getSize(SparseArrayCompat<T> paramSparseArrayCompat)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    return paramSparseArrayCompat.size();
  }
  
  public static final <T> boolean isNotEmpty(SparseArrayCompat<T> paramSparseArrayCompat)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    return paramSparseArrayCompat.isEmpty() ^ true;
  }
  
  public static final <T> z keyIterator(SparseArrayCompat<T> paramSparseArrayCompat)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
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
        SparseArrayCompat localSparseArrayCompat = this.$this_keyIterator;
        int i = this.index;
        this.index = (i + 1);
        return localSparseArrayCompat.keyAt(i);
      }
      
      public final void setIndex(int paramAnonymousInt)
      {
        this.index = paramAnonymousInt;
      }
    };
  }
  
  public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> paramSparseArrayCompat1, SparseArrayCompat<T> paramSparseArrayCompat2)
  {
    j.f(paramSparseArrayCompat1, "receiver$0");
    j.f(paramSparseArrayCompat2, "other");
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat(paramSparseArrayCompat1.size() + paramSparseArrayCompat2.size());
    localSparseArrayCompat.putAll(paramSparseArrayCompat1);
    localSparseArrayCompat.putAll(paramSparseArrayCompat2);
    return localSparseArrayCompat;
  }
  
  public static final <T> boolean remove(SparseArrayCompat<T> paramSparseArrayCompat, int paramInt, T paramT)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    return paramSparseArrayCompat.remove(paramInt, paramT);
  }
  
  public static final <T> void set(SparseArrayCompat<T> paramSparseArrayCompat, int paramInt, T paramT)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
    paramSparseArrayCompat.put(paramInt, paramT);
  }
  
  public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> paramSparseArrayCompat)
  {
    j.f(paramSparseArrayCompat, "receiver$0");
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
        SparseArrayCompat localSparseArrayCompat = this.$this_valueIterator;
        int i = this.index;
        this.index = (i + 1);
        return (T)localSparseArrayCompat.valueAt(i);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\collection\SparseArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */