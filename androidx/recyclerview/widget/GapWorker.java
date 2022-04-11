package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker
  implements Runnable
{
  static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal();
  static Comparator<Task> sTaskComparator = new Comparator()
  {
    public int compare(GapWorker.Task paramAnonymousTask1, GapWorker.Task paramAnonymousTask2)
    {
      RecyclerView localRecyclerView = paramAnonymousTask1.view;
      int i = 1;
      int j = 1;
      if (localRecyclerView == null) {
        k = 1;
      } else {
        k = 0;
      }
      int m;
      if (paramAnonymousTask2.view == null) {
        m = 1;
      } else {
        m = 0;
      }
      if (k != m)
      {
        if (localRecyclerView == null) {
          k = j;
        } else {
          k = -1;
        }
        return k;
      }
      boolean bool = paramAnonymousTask1.immediate;
      if (bool != paramAnonymousTask2.immediate)
      {
        k = i;
        if (bool) {
          k = -1;
        }
        return k;
      }
      int k = paramAnonymousTask2.viewVelocity - paramAnonymousTask1.viewVelocity;
      if (k != 0) {
        return k;
      }
      k = paramAnonymousTask1.distanceToItem - paramAnonymousTask2.distanceToItem;
      if (k != 0) {
        return k;
      }
      return 0;
    }
  };
  long mFrameIntervalNs;
  long mPostTimeNs;
  ArrayList<RecyclerView> mRecyclerViews = new ArrayList();
  private ArrayList<Task> mTasks = new ArrayList();
  
  private void buildTaskList()
  {
    int i = this.mRecyclerViews.size();
    int j = 0;
    Object localObject;
    for (int k = 0; j < i; k = m)
    {
      localObject = (RecyclerView)this.mRecyclerViews.get(j);
      m = k;
      if (((ViewGroup)localObject).getWindowVisibility() == 0)
      {
        ((RecyclerView)localObject).mPrefetchRegistry.collectPrefetchPositionsFromView((RecyclerView)localObject, false);
        m = k + ((RecyclerView)localObject).mPrefetchRegistry.mCount;
      }
      j++;
    }
    this.mTasks.ensureCapacity(k);
    int m = 0;
    int n;
    for (k = 0; m < i; k = n)
    {
      RecyclerView localRecyclerView = (RecyclerView)this.mRecyclerViews.get(m);
      if (localRecyclerView.getWindowVisibility() != 0)
      {
        n = k;
      }
      else
      {
        LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = localRecyclerView.mPrefetchRegistry;
        int i1 = Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDy);
        for (j = 0;; j += 2)
        {
          n = k;
          if (j >= localLayoutPrefetchRegistryImpl.mCount * 2) {
            break;
          }
          if (k >= this.mTasks.size())
          {
            localObject = new Task();
            this.mTasks.add(localObject);
          }
          else
          {
            localObject = (Task)this.mTasks.get(k);
          }
          int[] arrayOfInt = localLayoutPrefetchRegistryImpl.mPrefetchArray;
          n = arrayOfInt[(j + 1)];
          boolean bool;
          if (n <= i1) {
            bool = true;
          } else {
            bool = false;
          }
          ((Task)localObject).immediate = bool;
          ((Task)localObject).viewVelocity = i1;
          ((Task)localObject).distanceToItem = n;
          ((Task)localObject).view = localRecyclerView;
          ((Task)localObject).position = arrayOfInt[j];
          k++;
        }
      }
      m++;
    }
    Collections.sort(this.mTasks, sTaskComparator);
  }
  
  private void flushTaskWithDeadline(Task paramTask, long paramLong)
  {
    long l;
    if (paramTask.immediate) {
      l = Long.MAX_VALUE;
    } else {
      l = paramLong;
    }
    paramTask = prefetchPositionWithDeadline(paramTask.view, paramTask.position, l);
    if ((paramTask != null) && (paramTask.mNestedRecyclerView != null) && (paramTask.isBound()) && (!paramTask.isInvalid())) {
      prefetchInnerRecyclerViewWithDeadline((RecyclerView)paramTask.mNestedRecyclerView.get(), paramLong);
    }
  }
  
  private void flushTasksWithDeadline(long paramLong)
  {
    for (int i = 0; i < this.mTasks.size(); i++)
    {
      Task localTask = (Task)this.mTasks.get(i);
      if (localTask.view == null) {
        break;
      }
      flushTaskWithDeadline(localTask, paramLong);
      localTask.clear();
    }
  }
  
  static boolean isPrefetchPositionAttached(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = paramRecyclerView.mChildHelper.getUnfilteredChildCount();
    for (int j = 0; j < i; j++)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramRecyclerView.mChildHelper.getUnfilteredChildAt(j));
      if ((localViewHolder.mPosition == paramInt) && (!localViewHolder.isInvalid())) {
        return true;
      }
    }
    return false;
  }
  
  private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {
      return;
    }
    if ((paramRecyclerView.mDataSetHasChangedAfterLayout) && (paramRecyclerView.mChildHelper.getUnfilteredChildCount() != 0)) {
      paramRecyclerView.removeAndRecycleViews();
    }
    LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = paramRecyclerView.mPrefetchRegistry;
    localLayoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(paramRecyclerView, true);
    if (localLayoutPrefetchRegistryImpl.mCount != 0) {
      try
      {
        TraceCompat.beginSection("RV Nested Prefetch");
        paramRecyclerView.mState.prepareForNestedPrefetch(paramRecyclerView.mAdapter);
        for (int i = 0; i < localLayoutPrefetchRegistryImpl.mCount * 2; i += 2) {
          prefetchPositionWithDeadline(paramRecyclerView, localLayoutPrefetchRegistryImpl.mPrefetchArray[i], paramLong);
        }
      }
      finally
      {
        TraceCompat.endSection();
      }
    }
  }
  
  private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    if (isPrefetchPositionAttached(paramRecyclerView, paramInt)) {
      return null;
    }
    RecyclerView.Recycler localRecycler = paramRecyclerView.mRecycler;
    try
    {
      paramRecyclerView.onEnterLayoutOrScroll();
      RecyclerView.ViewHolder localViewHolder = localRecycler.tryGetViewHolderForPositionByDeadline(paramInt, false, paramLong);
      if (localViewHolder != null) {
        if ((localViewHolder.isBound()) && (!localViewHolder.isInvalid())) {
          localRecycler.recycleView(localViewHolder.itemView);
        } else {
          localRecycler.addViewHolderToRecycledViewPool(localViewHolder, false);
        }
      }
      return localViewHolder;
    }
    finally
    {
      paramRecyclerView.onExitLayoutOrScroll(false);
    }
  }
  
  public void add(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.add(paramRecyclerView);
  }
  
  void postFromTraversal(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.mPostTimeNs == 0L))
    {
      this.mPostTimeNs = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView.mPrefetchRegistry.setPrefetchVector(paramInt1, paramInt2);
  }
  
  void prefetch(long paramLong)
  {
    buildTaskList();
    flushTasksWithDeadline(paramLong);
  }
  
  public void remove(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.remove(paramRecyclerView);
  }
  
  public void run()
  {
    try
    {
      TraceCompat.beginSection("RV Prefetch");
      boolean bool = this.mRecyclerViews.isEmpty();
      if (bool) {}
      long l1;
      do
      {
        return;
        int i = this.mRecyclerViews.size();
        int j = 0;
        long l2;
        for (l1 = 0L; j < i; l1 = l2)
        {
          RecyclerView localRecyclerView = (RecyclerView)this.mRecyclerViews.get(j);
          l2 = l1;
          if (localRecyclerView.getWindowVisibility() == 0) {
            l2 = Math.max(localRecyclerView.getDrawingTime(), l1);
          }
          j++;
        }
      } while (l1 == 0L);
      prefetch(TimeUnit.MILLISECONDS.toNanos(l1) + this.mFrameIntervalNs);
      return;
    }
    finally
    {
      this.mPostTimeNs = 0L;
      TraceCompat.endSection();
    }
  }
  
  @SuppressLint({"VisibleForTests"})
  static class LayoutPrefetchRegistryImpl
    implements RecyclerView.LayoutManager.LayoutPrefetchRegistry
  {
    int mCount;
    int[] mPrefetchArray;
    int mPrefetchDx;
    int mPrefetchDy;
    
    public void addPosition(int paramInt1, int paramInt2)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= 0)
        {
          int i = this.mCount * 2;
          int[] arrayOfInt1 = this.mPrefetchArray;
          if (arrayOfInt1 == null)
          {
            arrayOfInt1 = new int[4];
            this.mPrefetchArray = arrayOfInt1;
            Arrays.fill(arrayOfInt1, -1);
          }
          else if (i >= arrayOfInt1.length)
          {
            int[] arrayOfInt2 = new int[i * 2];
            this.mPrefetchArray = arrayOfInt2;
            System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
          }
          arrayOfInt1 = this.mPrefetchArray;
          arrayOfInt1[i] = paramInt1;
          arrayOfInt1[(i + 1)] = paramInt2;
          this.mCount += 1;
          return;
        }
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      throw new IllegalArgumentException("Layout positions must be non-negative");
    }
    
    void clearPrefetchPositions()
    {
      int[] arrayOfInt = this.mPrefetchArray;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
      this.mCount = 0;
    }
    
    void collectPrefetchPositionsFromView(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.mCount = 0;
      Object localObject = this.mPrefetchArray;
      if (localObject != null) {
        Arrays.fill((int[])localObject, -1);
      }
      localObject = paramRecyclerView.mLayout;
      if ((paramRecyclerView.mAdapter != null) && (localObject != null) && (((RecyclerView.LayoutManager)localObject).isItemPrefetchEnabled()))
      {
        if (paramBoolean)
        {
          if (!paramRecyclerView.mAdapterHelper.hasPendingUpdates()) {
            ((RecyclerView.LayoutManager)localObject).collectInitialPrefetchPositions(paramRecyclerView.mAdapter.getItemCount(), this);
          }
        }
        else if (!paramRecyclerView.hasPendingAdapterUpdates()) {
          ((RecyclerView.LayoutManager)localObject).collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, paramRecyclerView.mState, this);
        }
        int i = this.mCount;
        if (i > ((RecyclerView.LayoutManager)localObject).mPrefetchMaxCountObserved)
        {
          ((RecyclerView.LayoutManager)localObject).mPrefetchMaxCountObserved = i;
          ((RecyclerView.LayoutManager)localObject).mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
          paramRecyclerView.mRecycler.updateViewCacheSize();
        }
      }
    }
    
    boolean lastPrefetchIncludedPosition(int paramInt)
    {
      if (this.mPrefetchArray != null)
      {
        int i = this.mCount;
        for (int j = 0; j < i * 2; j += 2) {
          if (this.mPrefetchArray[j] == paramInt) {
            return true;
          }
        }
      }
      return false;
    }
    
    void setPrefetchVector(int paramInt1, int paramInt2)
    {
      this.mPrefetchDx = paramInt1;
      this.mPrefetchDy = paramInt2;
    }
  }
  
  static class Task
  {
    public int distanceToItem;
    public boolean immediate;
    public int position;
    public RecyclerView view;
    public int viewVelocity;
    
    public void clear()
    {
      this.immediate = false;
      this.viewVelocity = 0;
      this.distanceToItem = 0;
      this.view = null;
      this.position = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\GapWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */