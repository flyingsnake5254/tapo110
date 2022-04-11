package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil
{
  private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator()
  {
    public int compare(DiffUtil.Diagonal paramAnonymousDiagonal1, DiffUtil.Diagonal paramAnonymousDiagonal2)
    {
      return paramAnonymousDiagonal1.x - paramAnonymousDiagonal2.x;
    }
  };
  
  @Nullable
  private static Snake backward(Range paramRange, Callback paramCallback, CenteredArray paramCenteredArray1, CenteredArray paramCenteredArray2, int paramInt)
  {
    int i;
    if ((paramRange.oldSize() - paramRange.newSize()) % 2 == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramRange.oldSize();
    int k = paramRange.newSize();
    int m = -paramInt;
    for (int n = m; n <= paramInt; n += 2)
    {
      int i1;
      int i2;
      if ((n != m) && ((n == paramInt) || (paramCenteredArray2.get(n + 1) >= paramCenteredArray2.get(n - 1))))
      {
        i1 = paramCenteredArray2.get(n - 1);
        i2 = i1 - 1;
      }
      else
      {
        i1 = paramCenteredArray2.get(n + 1);
        i2 = i1;
      }
      int i3 = paramRange.newListEnd - (paramRange.oldListEnd - i2 - n);
      int i4;
      if ((paramInt != 0) && (i2 == i1)) {
        i4 = i3 + 1;
      } else {
        i4 = i3;
      }
      while ((i2 > paramRange.oldListStart) && (i3 > paramRange.newListStart) && (paramCallback.areItemsTheSame(i2 - 1, i3 - 1)))
      {
        i2--;
        i3--;
      }
      paramCenteredArray2.set(n, i2);
      if (i != 0)
      {
        int i5 = j - k - n;
        if ((i5 >= m) && (i5 <= paramInt) && (paramCenteredArray1.get(i5) >= i2))
        {
          paramRange = new Snake();
          paramRange.startX = i2;
          paramRange.startY = i3;
          paramRange.endX = i1;
          paramRange.endY = i4;
          paramRange.reverse = true;
          return paramRange;
        }
      }
    }
    return null;
  }
  
  @NonNull
  public static DiffResult calculateDiff(@NonNull Callback paramCallback)
  {
    return calculateDiff(paramCallback, true);
  }
  
  @NonNull
  public static DiffResult calculateDiff(@NonNull Callback paramCallback, boolean paramBoolean)
  {
    int i = paramCallback.getOldListSize();
    int j = paramCallback.getNewListSize();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new Range(0, i, 0, j));
    i = (i + j + 1) / 2 * 2 + 1;
    CenteredArray localCenteredArray1 = new CenteredArray(i);
    CenteredArray localCenteredArray2 = new CenteredArray(i);
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      Range localRange1 = (Range)localArrayList2.remove(localArrayList2.size() - 1);
      Snake localSnake = midPoint(localRange1, paramCallback, localCenteredArray1, localCenteredArray2);
      if (localSnake != null)
      {
        if (localSnake.diagonalSize() > 0) {
          localArrayList1.add(localSnake.toDiagonal());
        }
        Range localRange2;
        if (localArrayList3.isEmpty()) {
          localRange2 = new Range();
        } else {
          localRange2 = (Range)localArrayList3.remove(localArrayList3.size() - 1);
        }
        localRange2.oldListStart = localRange1.oldListStart;
        localRange2.newListStart = localRange1.newListStart;
        localRange2.oldListEnd = localSnake.startX;
        localRange2.newListEnd = localSnake.startY;
        localArrayList2.add(localRange2);
        localRange1.oldListEnd = localRange1.oldListEnd;
        localRange1.newListEnd = localRange1.newListEnd;
        localRange1.oldListStart = localSnake.endX;
        localRange1.newListStart = localSnake.endY;
        localArrayList2.add(localRange1);
      }
      else
      {
        localArrayList3.add(localRange1);
      }
    }
    Collections.sort(localArrayList1, DIAGONAL_COMPARATOR);
    return new DiffResult(paramCallback, localArrayList1, localCenteredArray1.backingData(), localCenteredArray2.backingData(), paramBoolean);
  }
  
  @Nullable
  private static Snake forward(Range paramRange, Callback paramCallback, CenteredArray paramCenteredArray1, CenteredArray paramCenteredArray2, int paramInt)
  {
    int i = Math.abs(paramRange.oldSize() - paramRange.newSize());
    int j = 1;
    if (i % 2 != 1) {
      j = 0;
    }
    int k = paramRange.oldSize();
    int m = paramRange.newSize();
    int n = -paramInt;
    for (int i1 = n; i1 <= paramInt; i1 += 2)
    {
      int i2;
      if ((i1 != n) && ((i1 == paramInt) || (paramCenteredArray1.get(i1 + 1) <= paramCenteredArray1.get(i1 - 1))))
      {
        i2 = paramCenteredArray1.get(i1 - 1);
        i = i2 + 1;
      }
      else
      {
        i2 = paramCenteredArray1.get(i1 + 1);
        i = i2;
      }
      int i3 = paramRange.newListStart + (i - paramRange.oldListStart) - i1;
      int i4;
      if ((paramInt != 0) && (i == i2)) {
        i4 = i3 - 1;
      } else {
        i4 = i3;
      }
      while ((i < paramRange.oldListEnd) && (i3 < paramRange.newListEnd) && (paramCallback.areItemsTheSame(i, i3)))
      {
        i++;
        i3++;
      }
      paramCenteredArray1.set(i1, i);
      if (j != 0)
      {
        int i5 = k - m - i1;
        if ((i5 >= n + 1) && (i5 <= paramInt - 1) && (paramCenteredArray2.get(i5) <= i))
        {
          paramRange = new Snake();
          paramRange.startX = i2;
          paramRange.startY = i4;
          paramRange.endX = i;
          paramRange.endY = i3;
          paramRange.reverse = false;
          return paramRange;
        }
      }
    }
    return null;
  }
  
  @Nullable
  private static Snake midPoint(Range paramRange, Callback paramCallback, CenteredArray paramCenteredArray1, CenteredArray paramCenteredArray2)
  {
    if ((paramRange.oldSize() >= 1) && (paramRange.newSize() >= 1))
    {
      int i = (paramRange.oldSize() + paramRange.newSize() + 1) / 2;
      paramCenteredArray1.set(1, paramRange.oldListStart);
      paramCenteredArray2.set(1, paramRange.oldListEnd);
      for (int j = 0; j < i; j++)
      {
        Snake localSnake = forward(paramRange, paramCallback, paramCenteredArray1, paramCenteredArray2, j);
        if (localSnake != null) {
          return localSnake;
        }
        localSnake = backward(paramRange, paramCallback, paramCenteredArray1, paramCenteredArray2, j);
        if (localSnake != null) {
          return localSnake;
        }
      }
    }
    return null;
  }
  
  public static abstract class Callback
  {
    public abstract boolean areContentsTheSame(int paramInt1, int paramInt2);
    
    public abstract boolean areItemsTheSame(int paramInt1, int paramInt2);
    
    @Nullable
    public Object getChangePayload(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract int getNewListSize();
    
    public abstract int getOldListSize();
  }
  
  static class CenteredArray
  {
    private final int[] mData;
    private final int mMid;
    
    CenteredArray(int paramInt)
    {
      int[] arrayOfInt = new int[paramInt];
      this.mData = arrayOfInt;
      this.mMid = (arrayOfInt.length / 2);
    }
    
    int[] backingData()
    {
      return this.mData;
    }
    
    public void fill(int paramInt)
    {
      Arrays.fill(this.mData, paramInt);
    }
    
    int get(int paramInt)
    {
      return this.mData[(paramInt + this.mMid)];
    }
    
    void set(int paramInt1, int paramInt2)
    {
      this.mData[(paramInt1 + this.mMid)] = paramInt2;
    }
  }
  
  static class Diagonal
  {
    public final int size;
    public final int x;
    public final int y;
    
    Diagonal(int paramInt1, int paramInt2, int paramInt3)
    {
      this.x = paramInt1;
      this.y = paramInt2;
      this.size = paramInt3;
    }
    
    int endX()
    {
      return this.x + this.size;
    }
    
    int endY()
    {
      return this.y + this.size;
    }
  }
  
  public static class DiffResult
  {
    private static final int FLAG_CHANGED = 2;
    private static final int FLAG_MASK = 15;
    private static final int FLAG_MOVED = 12;
    private static final int FLAG_MOVED_CHANGED = 4;
    private static final int FLAG_MOVED_NOT_CHANGED = 8;
    private static final int FLAG_NOT_CHANGED = 1;
    private static final int FLAG_OFFSET = 4;
    public static final int NO_POSITION = -1;
    private final DiffUtil.Callback mCallback;
    private final boolean mDetectMoves;
    private final List<DiffUtil.Diagonal> mDiagonals;
    private final int[] mNewItemStatuses;
    private final int mNewListSize;
    private final int[] mOldItemStatuses;
    private final int mOldListSize;
    
    DiffResult(DiffUtil.Callback paramCallback, List<DiffUtil.Diagonal> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      this.mDiagonals = paramList;
      this.mOldItemStatuses = paramArrayOfInt1;
      this.mNewItemStatuses = paramArrayOfInt2;
      Arrays.fill(paramArrayOfInt1, 0);
      Arrays.fill(paramArrayOfInt2, 0);
      this.mCallback = paramCallback;
      this.mOldListSize = paramCallback.getOldListSize();
      this.mNewListSize = paramCallback.getNewListSize();
      this.mDetectMoves = paramBoolean;
      addEdgeDiagonals();
      findMatchingItems();
    }
    
    private void addEdgeDiagonals()
    {
      DiffUtil.Diagonal localDiagonal;
      if (this.mDiagonals.isEmpty()) {
        localDiagonal = null;
      } else {
        localDiagonal = (DiffUtil.Diagonal)this.mDiagonals.get(0);
      }
      if ((localDiagonal == null) || (localDiagonal.x != 0) || (localDiagonal.y != 0)) {
        this.mDiagonals.add(0, new DiffUtil.Diagonal(0, 0, 0));
      }
      this.mDiagonals.add(new DiffUtil.Diagonal(this.mOldListSize, this.mNewListSize, 0));
    }
    
    private void findMatchingAddition(int paramInt)
    {
      int i = this.mDiagonals.size();
      int j = 0;
      int k = 0;
      while (j < i)
      {
        DiffUtil.Diagonal localDiagonal = (DiffUtil.Diagonal)this.mDiagonals.get(j);
        while (k < localDiagonal.y)
        {
          if ((this.mNewItemStatuses[k] == 0) && (this.mCallback.areItemsTheSame(paramInt, k)))
          {
            if (this.mCallback.areContentsTheSame(paramInt, k)) {
              j = 8;
            } else {
              j = 4;
            }
            this.mOldItemStatuses[paramInt] = (k << 4 | j);
            this.mNewItemStatuses[k] = (paramInt << 4 | j);
            return;
          }
          k++;
        }
        k = localDiagonal.endY();
        j++;
      }
    }
    
    private void findMatchingItems()
    {
      Iterator localIterator = this.mDiagonals.iterator();
      while (localIterator.hasNext())
      {
        DiffUtil.Diagonal localDiagonal = (DiffUtil.Diagonal)localIterator.next();
        for (int i = 0; i < localDiagonal.size; i++)
        {
          int j = localDiagonal.x + i;
          int k = localDiagonal.y + i;
          int m;
          if (this.mCallback.areContentsTheSame(j, k)) {
            m = 1;
          } else {
            m = 2;
          }
          this.mOldItemStatuses[j] = (k << 4 | m);
          this.mNewItemStatuses[k] = (j << 4 | m);
        }
      }
      if (this.mDetectMoves) {
        findMoveMatches();
      }
    }
    
    private void findMoveMatches()
    {
      Iterator localIterator = this.mDiagonals.iterator();
      DiffUtil.Diagonal localDiagonal;
      for (int i = 0; localIterator.hasNext(); i = localDiagonal.endX())
      {
        localDiagonal = (DiffUtil.Diagonal)localIterator.next();
        while (i < localDiagonal.x)
        {
          if (this.mOldItemStatuses[i] == 0) {
            findMatchingAddition(i);
          }
          i++;
        }
      }
    }
    
    @Nullable
    private static DiffUtil.PostponedUpdate getPostponedUpdate(Collection<DiffUtil.PostponedUpdate> paramCollection, int paramInt, boolean paramBoolean)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        paramCollection = (DiffUtil.PostponedUpdate)localIterator.next();
        if ((paramCollection.posInOwnerList == paramInt) && (paramCollection.removal == paramBoolean))
        {
          localIterator.remove();
          break label53;
        }
      }
      paramCollection = null;
      label53:
      while (localIterator.hasNext())
      {
        DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)localIterator.next();
        if (paramBoolean) {
          localPostponedUpdate.currentPos -= 1;
        } else {
          localPostponedUpdate.currentPos += 1;
        }
      }
      return paramCollection;
    }
    
    public int convertNewPositionToOld(@IntRange(from=0L) int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mNewListSize))
      {
        paramInt = this.mNewItemStatuses[paramInt];
        if ((paramInt & 0xF) == 0) {
          return -1;
        }
        return paramInt >> 4;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index out of bounds - passed position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", new list size = ");
      localStringBuilder.append(this.mNewListSize);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public int convertOldPositionToNew(@IntRange(from=0L) int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mOldListSize))
      {
        paramInt = this.mOldItemStatuses[paramInt];
        if ((paramInt & 0xF) == 0) {
          return -1;
        }
        return paramInt >> 4;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index out of bounds - passed position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", old list size = ");
      localStringBuilder.append(this.mOldListSize);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public void dispatchUpdatesTo(@NonNull ListUpdateCallback paramListUpdateCallback)
    {
      if ((paramListUpdateCallback instanceof BatchingListUpdateCallback)) {
        paramListUpdateCallback = (BatchingListUpdateCallback)paramListUpdateCallback;
      } else {
        paramListUpdateCallback = new BatchingListUpdateCallback(paramListUpdateCallback);
      }
      int i = this.mOldListSize;
      ArrayDeque localArrayDeque = new ArrayDeque();
      int j = this.mOldListSize;
      int k = this.mNewListSize;
      for (int m = this.mDiagonals.size() - 1; m >= 0; m--)
      {
        DiffUtil.Diagonal localDiagonal = (DiffUtil.Diagonal)this.mDiagonals.get(m);
        int n = localDiagonal.endX();
        int i1 = localDiagonal.endY();
        int i2 = j;
        j = i;
        int i3;
        int i4;
        DiffUtil.PostponedUpdate localPostponedUpdate;
        for (;;)
        {
          i3 = 0;
          i = j;
          i4 = k;
          if (i2 <= n) {
            break;
          }
          i = i2 - 1;
          i4 = this.mOldItemStatuses[i];
          if ((i4 & 0xC) != 0)
          {
            i3 = i4 >> 4;
            localPostponedUpdate = getPostponedUpdate(localArrayDeque, i3, false);
            if (localPostponedUpdate != null)
            {
              int i5 = j - localPostponedUpdate.currentPos - 1;
              paramListUpdateCallback.onMoved(i, i5);
              i2 = i;
              if ((i4 & 0x4) != 0)
              {
                paramListUpdateCallback.onChanged(i5, 1, this.mCallback.getChangePayload(i, i3));
                i2 = i;
              }
            }
            else
            {
              localArrayDeque.add(new DiffUtil.PostponedUpdate(i, j - i - 1, true));
              i2 = i;
            }
          }
          else
          {
            paramListUpdateCallback.onRemoved(i, 1);
            j--;
            i2 = i;
          }
        }
        while (i4 > i1)
        {
          k = i4 - 1;
          n = this.mNewItemStatuses[k];
          if ((n & 0xC) != 0)
          {
            j = n >> 4;
            localPostponedUpdate = getPostponedUpdate(localArrayDeque, j, true);
            if (localPostponedUpdate == null)
            {
              localArrayDeque.add(new DiffUtil.PostponedUpdate(k, i - i2, false));
              i4 = k;
            }
            else
            {
              paramListUpdateCallback.onMoved(i - localPostponedUpdate.currentPos - 1, i2);
              i4 = k;
              if ((n & 0x4) != 0)
              {
                paramListUpdateCallback.onChanged(i2, 1, this.mCallback.getChangePayload(j, k));
                i4 = k;
              }
            }
          }
          else
          {
            paramListUpdateCallback.onInserted(i2, 1);
            i++;
            i4 = k;
          }
        }
        i2 = localDiagonal.x;
        j = localDiagonal.y;
        for (k = i3; k < localDiagonal.size; k++)
        {
          if ((this.mOldItemStatuses[i2] & 0xF) == 2) {
            paramListUpdateCallback.onChanged(i2, 1, this.mCallback.getChangePayload(i2, j));
          }
          i2++;
          j++;
        }
        j = localDiagonal.x;
        k = localDiagonal.y;
      }
      paramListUpdateCallback.dispatchLastEvent();
    }
    
    public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter paramAdapter)
    {
      dispatchUpdatesTo(new AdapterListUpdateCallback(paramAdapter));
    }
  }
  
  public static abstract class ItemCallback<T>
  {
    public abstract boolean areContentsTheSame(@NonNull T paramT1, @NonNull T paramT2);
    
    public abstract boolean areItemsTheSame(@NonNull T paramT1, @NonNull T paramT2);
    
    @Nullable
    public Object getChangePayload(@NonNull T paramT1, @NonNull T paramT2)
    {
      return null;
    }
  }
  
  private static class PostponedUpdate
  {
    int currentPos;
    int posInOwnerList;
    boolean removal;
    
    PostponedUpdate(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.posInOwnerList = paramInt1;
      this.currentPos = paramInt2;
      this.removal = paramBoolean;
    }
  }
  
  static class Range
  {
    int newListEnd;
    int newListStart;
    int oldListEnd;
    int oldListStart;
    
    public Range() {}
    
    public Range(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.oldListStart = paramInt1;
      this.oldListEnd = paramInt2;
      this.newListStart = paramInt3;
      this.newListEnd = paramInt4;
    }
    
    int newSize()
    {
      return this.newListEnd - this.newListStart;
    }
    
    int oldSize()
    {
      return this.oldListEnd - this.oldListStart;
    }
  }
  
  static class Snake
  {
    public int endX;
    public int endY;
    public boolean reverse;
    public int startX;
    public int startY;
    
    int diagonalSize()
    {
      return Math.min(this.endX - this.startX, this.endY - this.startY);
    }
    
    boolean hasAdditionOrRemoval()
    {
      boolean bool;
      if (this.endY - this.startY != this.endX - this.startX) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isAddition()
    {
      boolean bool;
      if (this.endY - this.startY > this.endX - this.startX) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @NonNull
    DiffUtil.Diagonal toDiagonal()
    {
      if (hasAdditionOrRemoval())
      {
        if (this.reverse) {
          return new DiffUtil.Diagonal(this.startX, this.startY, diagonalSize());
        }
        if (isAddition()) {
          return new DiffUtil.Diagonal(this.startX, this.startY + 1, diagonalSize());
        }
        return new DiffUtil.Diagonal(this.startX + 1, this.startY, diagonalSize());
      }
      int i = this.startX;
      return new DiffUtil.Diagonal(i, this.startY, this.endX - i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\DiffUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */