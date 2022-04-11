package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
  private static final boolean DEBUG = false;
  private static final String TAG = "ArrayMap";
  @Nullable
  static Object[] mBaseCache;
  static int mBaseCacheSize;
  @Nullable
  static Object[] mTwiceBaseCache;
  static int mTwiceBaseCacheSize;
  Object[] mArray;
  int[] mHashes;
  int mSize;
  
  public SimpleArrayMap()
  {
    this.mHashes = ContainerHelpers.EMPTY_INTS;
    this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    this.mSize = 0;
  }
  
  public SimpleArrayMap(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    }
    else
    {
      allocArrays(paramInt);
    }
    this.mSize = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap<K, V> paramSimpleArrayMap)
  {
    this();
    if (paramSimpleArrayMap != null) {
      putAll(paramSimpleArrayMap);
    }
  }
  
  private void allocArrays(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        Object[] arrayOfObject1 = mTwiceBaseCache;
        if (arrayOfObject1 != null)
        {
          this.mArray = arrayOfObject1;
          mTwiceBaseCache = (Object[])arrayOfObject1[0];
          this.mHashes = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          mTwiceBaseCacheSize -= 1;
          return;
        }
      }
      finally {}
    }
    if (paramInt == 4) {
      try
      {
        Object[] arrayOfObject2 = mBaseCache;
        if (arrayOfObject2 != null)
        {
          this.mArray = arrayOfObject2;
          mBaseCache = (Object[])arrayOfObject2[0];
          this.mHashes = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          mBaseCacheSize -= 1;
          return;
        }
      }
      finally {}
    }
    this.mHashes = new int[paramInt];
    this.mArray = new Object[paramInt << 1];
  }
  
  private static int binarySearchHashes(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = ContainerHelpers.binarySearch(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      throw new ConcurrentModificationException();
    }
  }
  
  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (mTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (paramInt = (paramInt << 1) - 1; paramInt >= 2; paramInt--) {
            paramArrayOfObject[paramInt] = null;
          }
          mTwiceBaseCache = paramArrayOfObject;
          mTwiceBaseCacheSize += 1;
        }
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {
      try
      {
        if (mBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (paramInt = (paramInt << 1) - 1; paramInt >= 2; paramInt--) {
            paramArrayOfObject[paramInt] = null;
          }
          mBaseCache = paramArrayOfObject;
          mBaseCacheSize += 1;
        }
      }
      finally {}
    }
  }
  
  public void clear()
  {
    int i = this.mSize;
    if (i > 0)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
      freeArrays(arrayOfInt, arrayOfObject, i);
    }
    if (this.mSize <= 0) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    boolean bool;
    if (indexOfKey(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsValue(Object paramObject)
  {
    boolean bool;
    if (indexOfValue(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void ensureCapacity(int paramInt)
  {
    int i = this.mSize;
    int[] arrayOfInt = this.mHashes;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, i);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, i << 1);
      }
      freeArrays(arrayOfInt, arrayOfObject, i);
    }
    if (this.mSize == i) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if ((paramObject instanceof SimpleArrayMap))
    {
      localObject1 = (SimpleArrayMap)paramObject;
      if (size() != ((SimpleArrayMap)localObject1).size()) {
        return false;
      }
      i = 0;
      try
      {
        while (i < this.mSize)
        {
          localObject2 = keyAt(i);
          localObject3 = valueAt(i);
          paramObject = ((SimpleArrayMap)localObject1).get(localObject2);
          if (localObject3 == null)
          {
            if ((paramObject != null) || (!((SimpleArrayMap)localObject1).containsKey(localObject2))) {
              return false;
            }
          }
          else
          {
            bool = localObject3.equals(paramObject);
            if (!bool) {
              return false;
            }
          }
          i++;
        }
        return true;
      }
      catch (NullPointerException|ClassCastException paramObject)
      {
        return false;
      }
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (size() != ((Map)paramObject).size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.mSize)
      {
        localObject2 = keyAt(i);
        localObject3 = valueAt(i);
        localObject1 = ((Map)paramObject).get(localObject2);
        if (localObject3 == null)
        {
          if ((localObject1 != null) || (!((Map)paramObject).containsKey(localObject2))) {
            return false;
          }
        }
        else
        {
          bool = localObject3.equals(localObject1);
          if (!bool) {
            return false;
          }
        }
        i++;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      for (;;) {}
    }
    return false;
  }
  
  @Nullable
  public V get(Object paramObject)
  {
    return (V)getOrDefault(paramObject, null);
  }
  
  public V getOrDefault(Object paramObject, V paramV)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      paramV = this.mArray[((i << 1) + 1)];
    }
    return paramV;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int i = this.mSize;
    int j = 1;
    int k = 0;
    int m = 0;
    while (k < i)
    {
      Object localObject = arrayOfObject[j];
      int n = arrayOfInt[k];
      int i1;
      if (localObject == null) {
        i1 = 0;
      } else {
        i1 = localObject.hashCode();
      }
      m += (i1 ^ n);
      k++;
      j += 2;
    }
    return m;
  }
  
  int indexOf(Object paramObject, int paramInt)
  {
    int i = this.mSize;
    if (i == 0) {
      return -1;
    }
    int j = binarySearchHashes(this.mHashes, i, paramInt);
    if (j < 0) {
      return j;
    }
    if (paramObject.equals(this.mArray[(j << 1)])) {
      return j;
    }
    for (int k = j + 1; (k < i) && (this.mHashes[k] == paramInt); k++) {
      if (paramObject.equals(this.mArray[(k << 1)])) {
        return k;
      }
    }
    for (i = j - 1; (i >= 0) && (this.mHashes[i] == paramInt); i--) {
      if (paramObject.equals(this.mArray[(i << 1)])) {
        return i;
      }
    }
    return k ^ 0xFFFFFFFF;
  }
  
  public int indexOfKey(@Nullable Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = indexOfNull();
    } else {
      i = indexOf(paramObject, paramObject.hashCode());
    }
    return i;
  }
  
  int indexOfNull()
  {
    int i = this.mSize;
    if (i == 0) {
      return -1;
    }
    int j = binarySearchHashes(this.mHashes, i, 0);
    if (j < 0) {
      return j;
    }
    if (this.mArray[(j << 1)] == null) {
      return j;
    }
    for (int k = j + 1; (k < i) && (this.mHashes[k] == 0); k++) {
      if (this.mArray[(k << 1)] == null) {
        return k;
      }
    }
    j--;
    while ((j >= 0) && (this.mHashes[j] == 0))
    {
      if (this.mArray[(j << 1)] == null) {
        return j;
      }
      j--;
    }
    return k ^ 0xFFFFFFFF;
  }
  
  int indexOfValue(Object paramObject)
  {
    int i = this.mSize * 2;
    Object[] arrayOfObject = this.mArray;
    if (paramObject == null) {
      for (j = 1; j < i; j += 2) {
        if (arrayOfObject[j] == null) {
          return j >> 1;
        }
      }
    }
    for (int j = 1; j < i; j += 2) {
      if (paramObject.equals(arrayOfObject[j])) {
        return j >> 1;
      }
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.mSize <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public K keyAt(int paramInt)
  {
    return (K)this.mArray[(paramInt << 1)];
  }
  
  @Nullable
  public V put(K paramK, V paramV)
  {
    int i = this.mSize;
    int k;
    if (paramK == null)
    {
      j = indexOfNull();
      k = 0;
    }
    else
    {
      k = paramK.hashCode();
      j = indexOf(paramK, k);
    }
    if (j >= 0)
    {
      j = (j << 1) + 1;
      paramK = this.mArray;
      localObject = paramK[j];
      paramK[j] = paramV;
      return (V)localObject;
    }
    int m = j ^ 0xFFFFFFFF;
    Object localObject = this.mHashes;
    if (i >= localObject.length)
    {
      j = 4;
      if (i >= 8) {
        j = (i >> 1) + i;
      } else if (i >= 4) {
        j = 8;
      }
      Object[] arrayOfObject = this.mArray;
      allocArrays(j);
      if (i == this.mSize)
      {
        int[] arrayOfInt = this.mHashes;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
        }
        freeArrays((int[])localObject, arrayOfObject, i);
      }
      else
      {
        throw new ConcurrentModificationException();
      }
    }
    if (m < i)
    {
      localObject = this.mHashes;
      j = m + 1;
      System.arraycopy(localObject, m, localObject, j, i - m);
      localObject = this.mArray;
      System.arraycopy(localObject, m << 1, localObject, j << 1, this.mSize - m << 1);
    }
    int j = this.mSize;
    if (i == j)
    {
      localObject = this.mHashes;
      if (m < localObject.length)
      {
        localObject[m] = k;
        localObject = this.mArray;
        k = m << 1;
        localObject[k] = paramK;
        localObject[(k + 1)] = paramV;
        this.mSize = (j + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    int i = paramSimpleArrayMap.mSize;
    ensureCapacity(this.mSize + i);
    int j = this.mSize;
    int k = 0;
    if (j == 0)
    {
      if (i > 0)
      {
        System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, i);
        System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, i << 1);
        this.mSize = i;
      }
    }
    else {
      while (k < i)
      {
        put(paramSimpleArrayMap.keyAt(k), paramSimpleArrayMap.valueAt(k));
        k++;
      }
    }
  }
  
  @Nullable
  public V putIfAbsent(K paramK, V paramV)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = put(paramK, paramV);
    }
    return (V)localObject2;
  }
  
  @Nullable
  public V remove(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return (V)removeAt(i);
    }
    return null;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    int i = indexOfKey(paramObject1);
    if (i >= 0)
    {
      paramObject1 = valueAt(i);
      if ((paramObject2 == paramObject1) || ((paramObject2 != null) && (paramObject2.equals(paramObject1))))
      {
        removeAt(i);
        return true;
      }
    }
    return false;
  }
  
  public V removeAt(int paramInt)
  {
    Object[] arrayOfObject = this.mArray;
    int i = paramInt << 1;
    Object localObject1 = arrayOfObject[(i + 1)];
    int j = this.mSize;
    int k = 0;
    if (j <= 1)
    {
      freeArrays(this.mHashes, arrayOfObject, j);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      paramInt = k;
    }
    else
    {
      int m = j - 1;
      Object localObject2 = this.mHashes;
      int n = localObject2.length;
      k = 8;
      if ((n > 8) && (j < localObject2.length / 3))
      {
        if (j > 8) {
          k = j + (j >> 1);
        }
        allocArrays(k);
        if (j == this.mSize)
        {
          if (paramInt > 0)
          {
            System.arraycopy(localObject2, 0, this.mHashes, 0, paramInt);
            System.arraycopy(arrayOfObject, 0, this.mArray, 0, i);
          }
          if (paramInt < m)
          {
            n = paramInt + 1;
            int[] arrayOfInt = this.mHashes;
            k = m - paramInt;
            System.arraycopy(localObject2, n, arrayOfInt, paramInt, k);
            System.arraycopy(arrayOfObject, n << 1, this.mArray, i, k << 1);
          }
        }
        else
        {
          throw new ConcurrentModificationException();
        }
      }
      else
      {
        if (paramInt < m)
        {
          n = paramInt + 1;
          k = m - paramInt;
          System.arraycopy(localObject2, n, localObject2, paramInt, k);
          localObject2 = this.mArray;
          System.arraycopy(localObject2, n << 1, localObject2, i, k << 1);
        }
        localObject2 = this.mArray;
        paramInt = m << 1;
        localObject2[paramInt] = null;
        localObject2[(paramInt + 1)] = null;
      }
      paramInt = m;
    }
    if (j == this.mSize)
    {
      this.mSize = paramInt;
      return (V)localObject1;
    }
    throw new ConcurrentModificationException();
  }
  
  @Nullable
  public V replace(K paramK, V paramV)
  {
    int i = indexOfKey(paramK);
    if (i >= 0) {
      return (V)setValueAt(i, paramV);
    }
    return null;
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    int i = indexOfKey(paramK);
    if (i >= 0)
    {
      paramK = valueAt(i);
      if ((paramK == paramV1) || ((paramV1 != null) && (paramV1.equals(paramK))))
      {
        setValueAt(i, paramV2);
        return true;
      }
    }
    return false;
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object[] arrayOfObject = this.mArray;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramV;
    return (V)localObject;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 28);
    localStringBuilder.append('{');
    for (int i = 0; i < this.mSize; i++)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = keyAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public V valueAt(int paramInt)
  {
    return (V)this.mArray[((paramInt << 1) + 1)];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\collection\SimpleArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */