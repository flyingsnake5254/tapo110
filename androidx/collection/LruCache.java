package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class LruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public LruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.maxSize = paramInt;
      this.map = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative size: ");
    localStringBuilder.append(paramK);
    localStringBuilder.append("=");
    localStringBuilder.append(paramV);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  @Nullable
  protected V create(@NonNull K paramK)
  {
    return null;
  }
  
  public final int createCount()
  {
    try
    {
      int i = this.createCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, @NonNull K paramK, @NonNull V paramV1, @Nullable V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    try
    {
      int i = this.evictionCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  @Nullable
  public final V get(@NonNull K paramK)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 89
    //   3: invokestatic 95	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 31	androidx/collection/LruCache:map	Ljava/util/LinkedHashMap;
    //   13: aload_1
    //   14: invokevirtual 97	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +17 -> 36
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 99	androidx/collection/LruCache:hitCount	I
    //   27: iconst_1
    //   28: iadd
    //   29: putfield 99	androidx/collection/LruCache:hitCount	I
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 101	androidx/collection/LruCache:missCount	I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield 101	androidx/collection/LruCache:missCount	I
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 103	androidx/collection/LruCache:create	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnonnull +5 -> 60
    //   58: aconst_null
    //   59: areturn
    //   60: aload_0
    //   61: monitorenter
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 77	androidx/collection/LruCache:createCount	I
    //   67: iconst_1
    //   68: iadd
    //   69: putfield 77	androidx/collection/LruCache:createCount	I
    //   72: aload_0
    //   73: getfield 31	androidx/collection/LruCache:map	Ljava/util/LinkedHashMap;
    //   76: aload_1
    //   77: aload_2
    //   78: invokevirtual 107	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +16 -> 99
    //   86: aload_0
    //   87: getfield 31	androidx/collection/LruCache:map	Ljava/util/LinkedHashMap;
    //   90: aload_1
    //   91: aload_3
    //   92: invokevirtual 107	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: goto +18 -> 114
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 109	androidx/collection/LruCache:size	I
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: invokespecial 111	androidx/collection/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   110: iadd
    //   111: putfield 109	androidx/collection/LruCache:size	I
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: ifnull +13 -> 130
    //   120: aload_0
    //   121: iconst_0
    //   122: aload_1
    //   123: aload_2
    //   124: aload_3
    //   125: invokevirtual 113	androidx/collection/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   128: aload_3
    //   129: areturn
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 23	androidx/collection/LruCache:maxSize	I
    //   135: invokevirtual 84	androidx/collection/LruCache:trimToSize	(I)V
    //   138: aload_2
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	LruCache
    //   0	150	1	paramK	K
    //   17	122	2	localObject1	Object
    //   81	48	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	82	140	finally
    //   86	96	140	finally
    //   99	114	140	finally
    //   114	116	140	finally
    //   141	143	140	finally
    //   9	18	145	finally
    //   22	34	145	finally
    //   36	48	145	finally
    //   146	148	145	finally
  }
  
  public final int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.maxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int missCount()
  {
    try
    {
      int i = this.missCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public final V put(@NonNull K paramK, @NonNull V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.putCount += 1;
        this.size += safeSizeOf(paramK, paramV);
        Object localObject = this.map.put(paramK, paramV);
        if (localObject != null) {
          this.size -= safeSizeOf(paramK, localObject);
        }
        if (localObject != null) {
          entryRemoved(false, paramK, localObject, paramV);
        }
        trimToSize(this.maxSize);
        return (V)localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final int putCount()
  {
    try
    {
      int i = this.putCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public final V remove(@NonNull K paramK)
  {
    Objects.requireNonNull(paramK, "key == null");
    try
    {
      Object localObject = this.map.remove(paramK);
      if (localObject != null) {
        this.size -= safeSizeOf(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, null);
      }
      return (V)localObject;
    }
    finally {}
  }
  
  public void resize(int paramInt)
  {
    if (paramInt > 0) {
      try
      {
        this.maxSize = paramInt;
        trimToSize(paramInt);
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public final int size()
  {
    try
    {
      int i = this.size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected int sizeOf(@NonNull K paramK, @NonNull V paramV)
  {
    return 1;
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.map);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String toString()
  {
    try
    {
      int i = this.hitCount;
      int j = this.missCount + i;
      if (j != 0) {
        i = i * 100 / j;
      } else {
        i = 0;
      }
      String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
  
  public void trimToSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.size >= 0) && ((!this.map.isEmpty()) || (this.size == 0)))
        {
          if ((this.size > paramInt) && (!this.map.isEmpty()))
          {
            localObject1 = (Map.Entry)this.map.entrySet().iterator().next();
            localObject2 = ((Map.Entry)localObject1).getKey();
            localObject1 = ((Map.Entry)localObject1).getValue();
            this.map.remove(localObject2);
            this.size -= safeSizeOf(localObject2, localObject1);
            this.evictionCount += 1;
            entryRemoved(true, localObject2, localObject1, null);
            continue;
          }
          return;
        }
        Object localObject1 = new java/lang/IllegalStateException;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append(getClass().getName());
        ((StringBuilder)localObject2).append(".sizeOf() is reporting inconsistent results!");
        ((IllegalStateException)localObject1).<init>(((StringBuilder)localObject2).toString());
        throw ((Throwable)localObject1);
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\collection\LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */