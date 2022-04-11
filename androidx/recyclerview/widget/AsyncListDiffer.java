package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T>
{
  private static final Executor sMainThreadExecutor = new MainThreadExecutor();
  final AsyncDifferConfig<T> mConfig;
  @Nullable
  private List<T> mList;
  private final List<ListListener<T>> mListeners = new CopyOnWriteArrayList();
  Executor mMainThreadExecutor;
  int mMaxScheduledGeneration;
  @NonNull
  private List<T> mReadOnlyList = Collections.emptyList();
  private final ListUpdateCallback mUpdateCallback;
  
  public AsyncListDiffer(@NonNull ListUpdateCallback paramListUpdateCallback, @NonNull AsyncDifferConfig<T> paramAsyncDifferConfig)
  {
    this.mUpdateCallback = paramListUpdateCallback;
    this.mConfig = paramAsyncDifferConfig;
    if (paramAsyncDifferConfig.getMainThreadExecutor() != null) {
      this.mMainThreadExecutor = paramAsyncDifferConfig.getMainThreadExecutor();
    } else {
      this.mMainThreadExecutor = sMainThreadExecutor;
    }
  }
  
  public AsyncListDiffer(@NonNull RecyclerView.Adapter paramAdapter, @NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this(new AdapterListUpdateCallback(paramAdapter), new AsyncDifferConfig.Builder(paramItemCallback).build());
  }
  
  private void onCurrentListChanged(@NonNull List<T> paramList, @Nullable Runnable paramRunnable)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((ListListener)localIterator.next()).onCurrentListChanged(paramList, this.mReadOnlyList);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public void addListListener(@NonNull ListListener<T> paramListListener)
  {
    this.mListeners.add(paramListListener);
  }
  
  @NonNull
  public List<T> getCurrentList()
  {
    return this.mReadOnlyList;
  }
  
  void latchList(@NonNull List<T> paramList, @NonNull DiffUtil.DiffResult paramDiffResult, @Nullable Runnable paramRunnable)
  {
    List localList = this.mReadOnlyList;
    this.mList = paramList;
    this.mReadOnlyList = Collections.unmodifiableList(paramList);
    paramDiffResult.dispatchUpdatesTo(this.mUpdateCallback);
    onCurrentListChanged(localList, paramRunnable);
  }
  
  public void removeListListener(@NonNull ListListener<T> paramListListener)
  {
    this.mListeners.remove(paramListListener);
  }
  
  public void submitList(@Nullable List<T> paramList)
  {
    submitList(paramList, null);
  }
  
  public void submitList(@Nullable final List<T> paramList, @Nullable final Runnable paramRunnable)
  {
    final int i = this.mMaxScheduledGeneration + 1;
    this.mMaxScheduledGeneration = i;
    final List localList1 = this.mList;
    if (paramList == localList1)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
    }
    List localList2 = this.mReadOnlyList;
    if (paramList == null)
    {
      i = localList1.size();
      this.mList = null;
      this.mReadOnlyList = Collections.emptyList();
      this.mUpdateCallback.onRemoved(0, i);
      onCurrentListChanged(localList2, paramRunnable);
      return;
    }
    if (localList1 == null)
    {
      this.mList = paramList;
      this.mReadOnlyList = Collections.unmodifiableList(paramList);
      this.mUpdateCallback.onInserted(0, paramList.size());
      onCurrentListChanged(localList2, paramRunnable);
      return;
    }
    this.mConfig.getBackgroundThreadExecutor().execute(new Runnable()
    {
      public void run()
      {
        final DiffUtil.DiffResult localDiffResult = DiffUtil.calculateDiff(new DiffUtil.Callback()
        {
          public boolean areContentsTheSame(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = AsyncListDiffer.1.this.val$oldList.get(paramAnonymous2Int1);
            Object localObject2 = AsyncListDiffer.1.this.val$newList.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null)) {
              return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(localObject1, localObject2);
            }
            if ((localObject1 == null) && (localObject2 == null)) {
              return true;
            }
            throw new AssertionError();
          }
          
          public boolean areItemsTheSame(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = AsyncListDiffer.1.this.val$oldList.get(paramAnonymous2Int1);
            Object localObject2 = AsyncListDiffer.1.this.val$newList.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null)) {
              return AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(localObject1, localObject2);
            }
            boolean bool;
            if ((localObject1 == null) && (localObject2 == null)) {
              bool = true;
            } else {
              bool = false;
            }
            return bool;
          }
          
          @Nullable
          public Object getChangePayload(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = AsyncListDiffer.1.this.val$oldList.get(paramAnonymous2Int1);
            Object localObject2 = AsyncListDiffer.1.this.val$newList.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null)) {
              return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(localObject1, localObject2);
            }
            throw new AssertionError();
          }
          
          public int getNewListSize()
          {
            return AsyncListDiffer.1.this.val$newList.size();
          }
          
          public int getOldListSize()
          {
            return AsyncListDiffer.1.this.val$oldList.size();
          }
        });
        AsyncListDiffer.this.mMainThreadExecutor.execute(new Runnable()
        {
          public void run()
          {
            AsyncListDiffer.1 local1 = AsyncListDiffer.1.this;
            AsyncListDiffer localAsyncListDiffer = local1.this$0;
            if (localAsyncListDiffer.mMaxScheduledGeneration == local1.val$runGeneration) {
              localAsyncListDiffer.latchList(local1.val$newList, localDiffResult, local1.val$commitCallback);
            }
          }
        });
      }
    });
  }
  
  public static abstract interface ListListener<T>
  {
    public abstract void onCurrentListChanged(@NonNull List<T> paramList1, @NonNull List<T> paramList2);
  }
  
  private static class MainThreadExecutor
    implements Executor
  {
    final Handler mHandler = new Handler(Looper.getMainLooper());
    
    public void execute(@NonNull Runnable paramRunnable)
    {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\AsyncListDiffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */