package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T>
{
  private static final int CAPACITY_GROWTH = 10;
  private static final int DELETION = 2;
  private static final int INSERTION = 1;
  public static final int INVALID_POSITION = -1;
  private static final int LOOKUP = 4;
  private static final int MIN_CAPACITY = 10;
  private BatchedCallback mBatchedCallback;
  private Callback mCallback;
  T[] mData;
  private int mNewDataStart;
  private T[] mOldData;
  private int mOldDataSize;
  private int mOldDataStart;
  private int mSize;
  private final Class<T> mTClass;
  
  public SortedList(@NonNull Class<T> paramClass, @NonNull Callback<T> paramCallback)
  {
    this(paramClass, paramCallback, 10);
  }
  
  public SortedList(@NonNull Class<T> paramClass, @NonNull Callback<T> paramCallback, int paramInt)
  {
    this.mTClass = paramClass;
    this.mData = ((Object[])Array.newInstance(paramClass, paramInt));
    this.mCallback = paramCallback;
    this.mSize = 0;
  }
  
  private int add(T paramT, boolean paramBoolean)
  {
    int i = findIndexOf(paramT, this.mData, 0, this.mSize, 1);
    int j;
    if (i == -1)
    {
      j = 0;
    }
    else
    {
      j = i;
      if (i < this.mSize)
      {
        Object localObject = this.mData[i];
        j = i;
        if (this.mCallback.areItemsTheSame(localObject, paramT))
        {
          if (this.mCallback.areContentsTheSame(localObject, paramT))
          {
            this.mData[i] = paramT;
            return i;
          }
          this.mData[i] = paramT;
          Callback localCallback = this.mCallback;
          localCallback.onChanged(i, 1, localCallback.getChangePayload(localObject, paramT));
          return i;
        }
      }
    }
    addToData(j, paramT);
    if (paramBoolean) {
      this.mCallback.onInserted(j, 1);
    }
    return j;
  }
  
  private void addAllInternal(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < 1) {
      return;
    }
    int i = sortAndDedup(paramArrayOfT);
    if (this.mSize == 0)
    {
      this.mData = paramArrayOfT;
      this.mSize = i;
      this.mCallback.onInserted(0, i);
    }
    else
    {
      merge(paramArrayOfT, i);
    }
  }
  
  private void addToData(int paramInt, T paramT)
  {
    int i = this.mSize;
    if (paramInt <= i)
    {
      Object[] arrayOfObject = this.mData;
      if (i == arrayOfObject.length)
      {
        arrayOfObject = (Object[])Array.newInstance(this.mTClass, arrayOfObject.length + 10);
        System.arraycopy(this.mData, 0, arrayOfObject, 0, paramInt);
        arrayOfObject[paramInt] = paramT;
        System.arraycopy(this.mData, paramInt, arrayOfObject, paramInt + 1, this.mSize - paramInt);
        this.mData = arrayOfObject;
      }
      else
      {
        System.arraycopy(arrayOfObject, paramInt, arrayOfObject, paramInt + 1, i - paramInt);
        this.mData[paramInt] = paramT;
      }
      this.mSize += 1;
      return;
    }
    paramT = new StringBuilder();
    paramT.append("cannot add item to ");
    paramT.append(paramInt);
    paramT.append(" because size is ");
    paramT.append(this.mSize);
    throw new IndexOutOfBoundsException(paramT.toString());
  }
  
  private T[] copyArray(T[] paramArrayOfT)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(this.mTClass, paramArrayOfT.length);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramArrayOfT.length);
    return arrayOfObject;
  }
  
  private int findIndexOf(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt1 < paramInt2)
    {
      int i = (paramInt1 + paramInt2) / 2;
      T ? = paramArrayOfT[i];
      int j = this.mCallback.compare(?, paramT);
      if (j < 0)
      {
        paramInt1 = i + 1;
      }
      else
      {
        if (j == 0)
        {
          if (this.mCallback.areItemsTheSame(?, paramT)) {
            return i;
          }
          paramInt1 = linearEqualitySearch(paramT, i, paramInt1, paramInt2);
          if (paramInt3 == 1)
          {
            if (paramInt1 != -1) {
              i = paramInt1;
            }
            return i;
          }
          return paramInt1;
        }
        paramInt2 = i;
      }
    }
    if (paramInt3 != 1) {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  private int findSameItem(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (this.mCallback.areItemsTheSame(paramArrayOfT[paramInt1], paramT)) {
        return paramInt1;
      }
      paramInt1++;
    }
    return -1;
  }
  
  private int linearEqualitySearch(T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    Object localObject;
    for (int i = paramInt1 - 1;; i--)
    {
      j = paramInt1;
      if (i < paramInt2) {
        break;
      }
      localObject = this.mData[i];
      if (this.mCallback.compare(localObject, paramT) != 0)
      {
        j = paramInt1;
        break;
      }
      if (this.mCallback.areItemsTheSame(localObject, paramT)) {
        return i;
      }
    }
    do
    {
      paramInt1 = j + 1;
      if (paramInt1 >= paramInt3) {
        break;
      }
      localObject = this.mData[paramInt1];
      if (this.mCallback.compare(localObject, paramT) != 0) {
        break;
      }
      j = paramInt1;
    } while (!this.mCallback.areItemsTheSame(localObject, paramT));
    return paramInt1;
    return -1;
  }
  
  private void merge(T[] paramArrayOfT, int paramInt)
  {
    boolean bool = this.mCallback instanceof BatchedCallback ^ true;
    if (bool) {
      beginBatchedUpdates();
    }
    this.mOldData = this.mData;
    int i = 0;
    this.mOldDataStart = 0;
    int j = this.mSize;
    this.mOldDataSize = j;
    this.mData = ((Object[])Array.newInstance(this.mTClass, j + paramInt + 10));
    this.mNewDataStart = 0;
    for (;;)
    {
      j = this.mOldDataStart;
      int k = this.mOldDataSize;
      if ((j < k) || (i < paramInt)) {
        if (j == k)
        {
          paramInt -= i;
          System.arraycopy(paramArrayOfT, i, this.mData, this.mNewDataStart, paramInt);
          i = this.mNewDataStart + paramInt;
          this.mNewDataStart = i;
          this.mSize += paramInt;
          this.mCallback.onInserted(i - paramInt, paramInt);
        }
        else
        {
          if (i != paramInt) {
            break label219;
          }
          paramInt = k - j;
          System.arraycopy(this.mOldData, j, this.mData, this.mNewDataStart, paramInt);
          this.mNewDataStart += paramInt;
        }
      }
      this.mOldData = null;
      if (bool) {
        endBatchedUpdates();
      }
      return;
      label219:
      Object localObject1 = this.mOldData[j];
      Object localObject2 = paramArrayOfT[i];
      j = this.mCallback.compare(localObject1, localObject2);
      if (j > 0)
      {
        localObject1 = this.mData;
        k = this.mNewDataStart;
        j = k + 1;
        this.mNewDataStart = j;
        localObject1[k] = localObject2;
        this.mSize += 1;
        i++;
        this.mCallback.onInserted(j - 1, 1);
      }
      else if ((j == 0) && (this.mCallback.areItemsTheSame(localObject1, localObject2)))
      {
        Object localObject3 = this.mData;
        j = this.mNewDataStart;
        this.mNewDataStart = (j + 1);
        localObject3[j] = localObject2;
        j = i + 1;
        this.mOldDataStart += 1;
        i = j;
        if (!this.mCallback.areContentsTheSame(localObject1, localObject2))
        {
          localObject3 = this.mCallback;
          ((Callback)localObject3).onChanged(this.mNewDataStart - 1, 1, ((Callback)localObject3).getChangePayload(localObject1, localObject2));
          i = j;
        }
      }
      else
      {
        localObject2 = this.mData;
        j = this.mNewDataStart;
        this.mNewDataStart = (j + 1);
        localObject2[j] = localObject1;
        this.mOldDataStart += 1;
      }
    }
  }
  
  private boolean remove(T paramT, boolean paramBoolean)
  {
    int i = findIndexOf(paramT, this.mData, 0, this.mSize, 2);
    if (i == -1) {
      return false;
    }
    removeItemAtIndex(i, paramBoolean);
    return true;
  }
  
  private void removeItemAtIndex(int paramInt, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.mData;
    System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, this.mSize - paramInt - 1);
    int i = this.mSize - 1;
    this.mSize = i;
    this.mData[i] = null;
    if (paramBoolean) {
      this.mCallback.onRemoved(paramInt, 1);
    }
  }
  
  private void replaceAllInsert(T paramT)
  {
    Object[] arrayOfObject = this.mData;
    int i = this.mNewDataStart;
    arrayOfObject[i] = paramT;
    i++;
    this.mNewDataStart = i;
    this.mSize += 1;
    this.mCallback.onInserted(i - 1, 1);
  }
  
  private void replaceAllInternal(@NonNull T[] paramArrayOfT)
  {
    boolean bool = this.mCallback instanceof BatchedCallback ^ true;
    if (bool) {
      beginBatchedUpdates();
    }
    this.mOldDataStart = 0;
    this.mOldDataSize = this.mSize;
    this.mOldData = this.mData;
    this.mNewDataStart = 0;
    int i = sortAndDedup(paramArrayOfT);
    this.mData = ((Object[])Array.newInstance(this.mTClass, i));
    for (;;)
    {
      int j = this.mNewDataStart;
      int k;
      if ((j < i) || (this.mOldDataStart < this.mOldDataSize))
      {
        k = this.mOldDataStart;
        int m = this.mOldDataSize;
        if (k >= m)
        {
          i -= j;
          System.arraycopy(paramArrayOfT, j, this.mData, j, i);
          this.mNewDataStart += i;
          this.mSize += i;
          this.mCallback.onInserted(j, i);
        }
        else
        {
          if (j < i) {
            break label208;
          }
          i = m - k;
          this.mSize -= i;
          this.mCallback.onRemoved(j, i);
        }
      }
      this.mOldData = null;
      if (bool) {
        endBatchedUpdates();
      }
      return;
      label208:
      Object localObject1 = this.mOldData[k];
      T ? = paramArrayOfT[j];
      j = this.mCallback.compare(localObject1, ?);
      if (j < 0)
      {
        replaceAllRemove();
      }
      else if (j > 0)
      {
        replaceAllInsert(?);
      }
      else if (!this.mCallback.areItemsTheSame(localObject1, ?))
      {
        replaceAllRemove();
        replaceAllInsert(?);
      }
      else
      {
        Object localObject2 = this.mData;
        j = this.mNewDataStart;
        localObject2[j] = ?;
        this.mOldDataStart += 1;
        this.mNewDataStart = (j + 1);
        if (!this.mCallback.areContentsTheSame(localObject1, ?))
        {
          localObject2 = this.mCallback;
          ((Callback)localObject2).onChanged(this.mNewDataStart - 1, 1, ((Callback)localObject2).getChangePayload(localObject1, ?));
        }
      }
    }
  }
  
  private void replaceAllRemove()
  {
    this.mSize -= 1;
    this.mOldDataStart += 1;
    this.mCallback.onRemoved(this.mNewDataStart, 1);
  }
  
  private int sortAndDedup(@NonNull T[] paramArrayOfT)
  {
    if (paramArrayOfT.length == 0) {
      return 0;
    }
    Arrays.sort(paramArrayOfT, this.mCallback);
    int i = 1;
    int j = 1;
    int k = 0;
    while (i < paramArrayOfT.length)
    {
      T ? = paramArrayOfT[i];
      if (this.mCallback.compare(paramArrayOfT[k], ?) == 0)
      {
        int m = findSameItem(?, paramArrayOfT, k, j);
        if (m != -1)
        {
          paramArrayOfT[m] = ?;
        }
        else
        {
          if (j != i) {
            paramArrayOfT[j] = ?;
          }
          j++;
        }
      }
      else
      {
        if (j != i) {
          paramArrayOfT[j] = ?;
        }
        k = j;
        j++;
      }
      i++;
    }
    return j;
  }
  
  private void throwIfInMutationOperation()
  {
    if (this.mOldData == null) {
      return;
    }
    throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
  }
  
  public int add(T paramT)
  {
    throwIfInMutationOperation();
    return add(paramT, true);
  }
  
  public void addAll(@NonNull Collection<T> paramCollection)
  {
    addAll(paramCollection.toArray((Object[])Array.newInstance(this.mTClass, paramCollection.size())), true);
  }
  
  public void addAll(@NonNull T... paramVarArgs)
  {
    addAll(paramVarArgs, false);
  }
  
  public void addAll(@NonNull T[] paramArrayOfT, boolean paramBoolean)
  {
    throwIfInMutationOperation();
    if (paramArrayOfT.length == 0) {
      return;
    }
    if (paramBoolean) {
      addAllInternal(paramArrayOfT);
    } else {
      addAllInternal(copyArray(paramArrayOfT));
    }
  }
  
  public void beginBatchedUpdates()
  {
    throwIfInMutationOperation();
    Callback localCallback = this.mCallback;
    if ((localCallback instanceof BatchedCallback)) {
      return;
    }
    if (this.mBatchedCallback == null) {
      this.mBatchedCallback = new BatchedCallback(localCallback);
    }
    this.mCallback = this.mBatchedCallback;
  }
  
  public void clear()
  {
    throwIfInMutationOperation();
    int i = this.mSize;
    if (i == 0) {
      return;
    }
    Arrays.fill(this.mData, 0, i, null);
    this.mSize = 0;
    this.mCallback.onRemoved(0, i);
  }
  
  public void endBatchedUpdates()
  {
    throwIfInMutationOperation();
    Object localObject = this.mCallback;
    if ((localObject instanceof BatchedCallback)) {
      ((BatchedCallback)localObject).dispatchLastEvent();
    }
    Callback localCallback = this.mCallback;
    localObject = this.mBatchedCallback;
    if (localCallback == localObject) {
      this.mCallback = ((BatchedCallback)localObject).mWrappedCallback;
    }
  }
  
  public T get(int paramInt)
    throws IndexOutOfBoundsException
  {
    if ((paramInt < this.mSize) && (paramInt >= 0))
    {
      localObject = this.mOldData;
      if (localObject != null)
      {
        int i = this.mNewDataStart;
        if (paramInt >= i) {
          return localObject[(paramInt - i + this.mOldDataStart)];
        }
      }
      return (T)this.mData[paramInt];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Asked to get item at ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" but size is ");
    ((StringBuilder)localObject).append(this.mSize);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int indexOf(T paramT)
  {
    if (this.mOldData != null)
    {
      int i = findIndexOf(paramT, this.mData, 0, this.mNewDataStart, 4);
      if (i != -1) {
        return i;
      }
      i = findIndexOf(paramT, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
      if (i != -1) {
        return i - this.mOldDataStart + this.mNewDataStart;
      }
      return -1;
    }
    return findIndexOf(paramT, this.mData, 0, this.mSize, 4);
  }
  
  public void recalculatePositionOfItemAt(int paramInt)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, false);
    int i = add(localObject, false);
    if (paramInt != i) {
      this.mCallback.onMoved(paramInt, i);
    }
  }
  
  public boolean remove(T paramT)
  {
    throwIfInMutationOperation();
    return remove(paramT, true);
  }
  
  public T removeItemAt(int paramInt)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, true);
    return (T)localObject;
  }
  
  public void replaceAll(@NonNull Collection<T> paramCollection)
  {
    replaceAll(paramCollection.toArray((Object[])Array.newInstance(this.mTClass, paramCollection.size())), true);
  }
  
  public void replaceAll(@NonNull T... paramVarArgs)
  {
    replaceAll(paramVarArgs, false);
  }
  
  public void replaceAll(@NonNull T[] paramArrayOfT, boolean paramBoolean)
  {
    throwIfInMutationOperation();
    if (paramBoolean) {
      replaceAllInternal(paramArrayOfT);
    } else {
      replaceAllInternal(copyArray(paramArrayOfT));
    }
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public void updateItemAt(int paramInt, T paramT)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    if ((localObject != paramT) && (this.mCallback.areContentsTheSame(localObject, paramT))) {
      i = 0;
    } else {
      i = 1;
    }
    Callback localCallback;
    if ((localObject != paramT) && (this.mCallback.compare(localObject, paramT) == 0))
    {
      this.mData[paramInt] = paramT;
      if (i != 0)
      {
        localCallback = this.mCallback;
        localCallback.onChanged(paramInt, 1, localCallback.getChangePayload(localObject, paramT));
      }
      return;
    }
    if (i != 0)
    {
      localCallback = this.mCallback;
      localCallback.onChanged(paramInt, 1, localCallback.getChangePayload(localObject, paramT));
    }
    removeItemAtIndex(paramInt, false);
    int i = add(paramT, false);
    if (paramInt != i) {
      this.mCallback.onMoved(paramInt, i);
    }
  }
  
  public static class BatchedCallback<T2>
    extends SortedList.Callback<T2>
  {
    private final BatchingListUpdateCallback mBatchingListUpdateCallback;
    final SortedList.Callback<T2> mWrappedCallback;
    
    public BatchedCallback(SortedList.Callback<T2> paramCallback)
    {
      this.mWrappedCallback = paramCallback;
      this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(paramCallback);
    }
    
    public boolean areContentsTheSame(T2 paramT21, T2 paramT22)
    {
      return this.mWrappedCallback.areContentsTheSame(paramT21, paramT22);
    }
    
    public boolean areItemsTheSame(T2 paramT21, T2 paramT22)
    {
      return this.mWrappedCallback.areItemsTheSame(paramT21, paramT22);
    }
    
    public int compare(T2 paramT21, T2 paramT22)
    {
      return this.mWrappedCallback.compare(paramT21, paramT22);
    }
    
    public void dispatchLastEvent()
    {
      this.mBatchingListUpdateCallback.dispatchLastEvent();
    }
    
    @Nullable
    public Object getChangePayload(T2 paramT21, T2 paramT22)
    {
      return this.mWrappedCallback.getChangePayload(paramT21, paramT22);
    }
    
    public void onChanged(int paramInt1, int paramInt2)
    {
      this.mBatchingListUpdateCallback.onChanged(paramInt1, paramInt2, null);
    }
    
    public void onChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      this.mBatchingListUpdateCallback.onChanged(paramInt1, paramInt2, paramObject);
    }
    
    public void onInserted(int paramInt1, int paramInt2)
    {
      this.mBatchingListUpdateCallback.onInserted(paramInt1, paramInt2);
    }
    
    public void onMoved(int paramInt1, int paramInt2)
    {
      this.mBatchingListUpdateCallback.onMoved(paramInt1, paramInt2);
    }
    
    public void onRemoved(int paramInt1, int paramInt2)
    {
      this.mBatchingListUpdateCallback.onRemoved(paramInt1, paramInt2);
    }
  }
  
  public static abstract class Callback<T2>
    implements Comparator<T2>, ListUpdateCallback
  {
    public abstract boolean areContentsTheSame(T2 paramT21, T2 paramT22);
    
    public abstract boolean areItemsTheSame(T2 paramT21, T2 paramT22);
    
    public abstract int compare(T2 paramT21, T2 paramT22);
    
    @Nullable
    public Object getChangePayload(T2 paramT21, T2 paramT22)
    {
      return null;
    }
    
    public abstract void onChanged(int paramInt1, int paramInt2);
    
    public void onChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onChanged(paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\SortedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */