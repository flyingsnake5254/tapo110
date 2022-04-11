package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;

public class AsyncListUtil<T>
{
  static final boolean DEBUG = false;
  static final String TAG = "AsyncListUtil";
  boolean mAllowScrollHints;
  private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
  final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
  final DataCallback<T> mDataCallback;
  int mDisplayedGeneration = 0;
  int mItemCount = 0;
  private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
  final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
  final SparseIntArray mMissingPositions = new SparseIntArray();
  final int[] mPrevRange = new int[2];
  int mRequestedGeneration = 0;
  private int mScrollHint = 0;
  final Class<T> mTClass;
  final TileList<T> mTileList;
  final int mTileSize;
  final int[] mTmpRange = new int[2];
  final int[] mTmpRangeExtended = new int[2];
  final ViewCallback mViewCallback;
  
  public AsyncListUtil(@NonNull Class<T> paramClass, int paramInt, @NonNull DataCallback<T> paramDataCallback, @NonNull ViewCallback paramViewCallback)
  {
    ThreadUtil.MainThreadCallback local1 = new ThreadUtil.MainThreadCallback()
    {
      private boolean isRequestedGeneration(int paramAnonymousInt)
      {
        boolean bool;
        if (paramAnonymousInt == AsyncListUtil.this.mRequestedGeneration) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      private void recycleAllTiles()
      {
        for (int i = 0; i < AsyncListUtil.this.mTileList.size(); i++)
        {
          AsyncListUtil localAsyncListUtil = AsyncListUtil.this;
          localAsyncListUtil.mBackgroundProxy.recycleTile(localAsyncListUtil.mTileList.getAtIndex(i));
        }
        AsyncListUtil.this.mTileList.clear();
      }
      
      public void addTile(int paramAnonymousInt, TileList.Tile<T> paramAnonymousTile)
      {
        if (!isRequestedGeneration(paramAnonymousInt))
        {
          AsyncListUtil.this.mBackgroundProxy.recycleTile(paramAnonymousTile);
          return;
        }
        TileList.Tile localTile = AsyncListUtil.this.mTileList.addOrReplace(paramAnonymousTile);
        if (localTile != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("duplicate tile @");
          localStringBuilder.append(localTile.mStartPosition);
          Log.e("AsyncListUtil", localStringBuilder.toString());
          AsyncListUtil.this.mBackgroundProxy.recycleTile(localTile);
        }
        int i = paramAnonymousTile.mStartPosition;
        int j = paramAnonymousTile.mItemCount;
        paramAnonymousInt = 0;
        while (paramAnonymousInt < AsyncListUtil.this.mMissingPositions.size())
        {
          int k = AsyncListUtil.this.mMissingPositions.keyAt(paramAnonymousInt);
          if ((paramAnonymousTile.mStartPosition <= k) && (k < i + j))
          {
            AsyncListUtil.this.mMissingPositions.removeAt(paramAnonymousInt);
            AsyncListUtil.this.mViewCallback.onItemLoaded(k);
          }
          else
          {
            paramAnonymousInt++;
          }
        }
      }
      
      public void removeTile(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (!isRequestedGeneration(paramAnonymousInt1)) {
          return;
        }
        Object localObject = AsyncListUtil.this.mTileList.removeAtPos(paramAnonymousInt2);
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tile not found @");
          ((StringBuilder)localObject).append(paramAnonymousInt2);
          Log.e("AsyncListUtil", ((StringBuilder)localObject).toString());
          return;
        }
        AsyncListUtil.this.mBackgroundProxy.recycleTile((TileList.Tile)localObject);
      }
      
      public void updateItemCount(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (!isRequestedGeneration(paramAnonymousInt1)) {
          return;
        }
        AsyncListUtil localAsyncListUtil = AsyncListUtil.this;
        localAsyncListUtil.mItemCount = paramAnonymousInt2;
        localAsyncListUtil.mViewCallback.onDataRefresh();
        localAsyncListUtil = AsyncListUtil.this;
        localAsyncListUtil.mDisplayedGeneration = localAsyncListUtil.mRequestedGeneration;
        recycleAllTiles();
        localAsyncListUtil = AsyncListUtil.this;
        localAsyncListUtil.mAllowScrollHints = false;
        localAsyncListUtil.updateRange();
      }
    };
    this.mMainThreadCallback = local1;
    ThreadUtil.BackgroundCallback local2 = new ThreadUtil.BackgroundCallback()
    {
      private int mFirstRequiredTileStart;
      private int mGeneration;
      private int mItemCount;
      private int mLastRequiredTileStart;
      final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
      private TileList.Tile<T> mRecycledRoot;
      
      private TileList.Tile<T> acquireTile()
      {
        Object localObject = this.mRecycledRoot;
        if (localObject != null)
        {
          this.mRecycledRoot = ((TileList.Tile)localObject).mNext;
          return (TileList.Tile<T>)localObject;
        }
        localObject = AsyncListUtil.this;
        return new TileList.Tile(((AsyncListUtil)localObject).mTClass, ((AsyncListUtil)localObject).mTileSize);
      }
      
      private void addTile(TileList.Tile<T> paramAnonymousTile)
      {
        this.mLoadedTiles.put(paramAnonymousTile.mStartPosition, true);
        AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, paramAnonymousTile);
      }
      
      private void flushTileCache(int paramAnonymousInt)
      {
        int i = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
        while (this.mLoadedTiles.size() >= i)
        {
          int j = this.mLoadedTiles.keyAt(0);
          SparseBooleanArray localSparseBooleanArray = this.mLoadedTiles;
          int k = localSparseBooleanArray.keyAt(localSparseBooleanArray.size() - 1);
          int m = this.mFirstRequiredTileStart - j;
          int n = k - this.mLastRequiredTileStart;
          if ((m > 0) && ((m >= n) || (paramAnonymousInt == 2)))
          {
            removeTile(j);
          }
          else
          {
            if ((n <= 0) || ((m >= n) && (paramAnonymousInt != 1))) {
              break;
            }
            removeTile(k);
          }
        }
      }
      
      private int getTileStart(int paramAnonymousInt)
      {
        return paramAnonymousInt - paramAnonymousInt % AsyncListUtil.this.mTileSize;
      }
      
      private boolean isTileLoaded(int paramAnonymousInt)
      {
        return this.mLoadedTiles.get(paramAnonymousInt);
      }
      
      private void log(String paramAnonymousString, Object... paramAnonymousVarArgs)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[BKGR] ");
        localStringBuilder.append(String.format(paramAnonymousString, paramAnonymousVarArgs));
        Log.d("AsyncListUtil", localStringBuilder.toString());
      }
      
      private void removeTile(int paramAnonymousInt)
      {
        this.mLoadedTiles.delete(paramAnonymousInt);
        AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, paramAnonymousInt);
      }
      
      private void requestTiles(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, boolean paramAnonymousBoolean)
      {
        int i = paramAnonymousInt1;
        while (i <= paramAnonymousInt2)
        {
          int j;
          if (paramAnonymousBoolean) {
            j = paramAnonymousInt2 + paramAnonymousInt1 - i;
          } else {
            j = i;
          }
          AsyncListUtil.this.mBackgroundProxy.loadTile(j, paramAnonymousInt3);
          i += AsyncListUtil.this.mTileSize;
        }
      }
      
      public void loadTile(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (isTileLoaded(paramAnonymousInt1)) {
          return;
        }
        TileList.Tile localTile = acquireTile();
        localTile.mStartPosition = paramAnonymousInt1;
        paramAnonymousInt1 = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - paramAnonymousInt1);
        localTile.mItemCount = paramAnonymousInt1;
        AsyncListUtil.this.mDataCallback.fillData(localTile.mItems, localTile.mStartPosition, paramAnonymousInt1);
        flushTileCache(paramAnonymousInt2);
        addTile(localTile);
      }
      
      public void recycleTile(TileList.Tile<T> paramAnonymousTile)
      {
        AsyncListUtil.this.mDataCallback.recycleData(paramAnonymousTile.mItems, paramAnonymousTile.mItemCount);
        paramAnonymousTile.mNext = this.mRecycledRoot;
        this.mRecycledRoot = paramAnonymousTile;
      }
      
      public void refresh(int paramAnonymousInt)
      {
        this.mGeneration = paramAnonymousInt;
        this.mLoadedTiles.clear();
        paramAnonymousInt = AsyncListUtil.this.mDataCallback.refreshData();
        this.mItemCount = paramAnonymousInt;
        AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, paramAnonymousInt);
      }
      
      public void updateRange(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5)
      {
        if (paramAnonymousInt1 > paramAnonymousInt2) {
          return;
        }
        paramAnonymousInt1 = getTileStart(paramAnonymousInt1);
        paramAnonymousInt2 = getTileStart(paramAnonymousInt2);
        this.mFirstRequiredTileStart = getTileStart(paramAnonymousInt3);
        paramAnonymousInt3 = getTileStart(paramAnonymousInt4);
        this.mLastRequiredTileStart = paramAnonymousInt3;
        if (paramAnonymousInt5 == 1)
        {
          requestTiles(this.mFirstRequiredTileStart, paramAnonymousInt2, paramAnonymousInt5, true);
          requestTiles(paramAnonymousInt2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, paramAnonymousInt5, false);
        }
        else
        {
          requestTiles(paramAnonymousInt1, paramAnonymousInt3, paramAnonymousInt5, false);
          requestTiles(this.mFirstRequiredTileStart, paramAnonymousInt1 - AsyncListUtil.this.mTileSize, paramAnonymousInt5, true);
        }
      }
    };
    this.mBackgroundCallback = local2;
    this.mTClass = paramClass;
    this.mTileSize = paramInt;
    this.mDataCallback = paramDataCallback;
    this.mViewCallback = paramViewCallback;
    this.mTileList = new TileList(paramInt);
    paramClass = new MessageThreadUtil();
    this.mMainThreadProxy = paramClass.getMainThreadProxy(local1);
    this.mBackgroundProxy = paramClass.getBackgroundProxy(local2);
    refresh();
  }
  
  private boolean isRefreshPending()
  {
    boolean bool;
    if (this.mRequestedGeneration != this.mDisplayedGeneration) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  public T getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mItemCount))
    {
      localObject = this.mTileList.getItemAt(paramInt);
      if ((localObject == null) && (!isRefreshPending())) {
        this.mMissingPositions.put(paramInt, 0);
      }
      return (T)localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" is not within 0 and ");
    ((StringBuilder)localObject).append(this.mItemCount);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int getItemCount()
  {
    return this.mItemCount;
  }
  
  void log(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MAIN] ");
    localStringBuilder.append(String.format(paramString, paramVarArgs));
    Log.d("AsyncListUtil", localStringBuilder.toString());
  }
  
  public void onRangeChanged()
  {
    if (isRefreshPending()) {
      return;
    }
    updateRange();
    this.mAllowScrollHints = true;
  }
  
  public void refresh()
  {
    this.mMissingPositions.clear();
    ThreadUtil.BackgroundCallback localBackgroundCallback = this.mBackgroundProxy;
    int i = this.mRequestedGeneration + 1;
    this.mRequestedGeneration = i;
    localBackgroundCallback.refresh(i);
  }
  
  void updateRange()
  {
    this.mViewCallback.getItemRangeInto(this.mTmpRange);
    Object localObject = this.mTmpRange;
    if ((localObject[0] <= localObject[1]) && (localObject[0] >= 0))
    {
      if (localObject[1] >= this.mItemCount) {
        return;
      }
      if (!this.mAllowScrollHints)
      {
        this.mScrollHint = 0;
      }
      else
      {
        i = localObject[0];
        arrayOfInt = this.mPrevRange;
        if ((i <= arrayOfInt[1]) && (arrayOfInt[0] <= localObject[1]))
        {
          if (localObject[0] < arrayOfInt[0]) {
            this.mScrollHint = 1;
          } else if (localObject[0] > arrayOfInt[0]) {
            this.mScrollHint = 2;
          }
        }
        else {
          this.mScrollHint = 0;
        }
      }
      int[] arrayOfInt = this.mPrevRange;
      arrayOfInt[0] = localObject[0];
      arrayOfInt[1] = localObject[1];
      this.mViewCallback.extendRangeInto((int[])localObject, this.mTmpRangeExtended, this.mScrollHint);
      localObject = this.mTmpRangeExtended;
      localObject[0] = Math.min(this.mTmpRange[0], Math.max(localObject[0], 0));
      localObject = this.mTmpRangeExtended;
      localObject[1] = Math.max(this.mTmpRange[1], Math.min(localObject[1], this.mItemCount - 1));
      localObject = this.mBackgroundProxy;
      arrayOfInt = this.mTmpRange;
      int j = arrayOfInt[0];
      int i = arrayOfInt[1];
      arrayOfInt = this.mTmpRangeExtended;
      ((ThreadUtil.BackgroundCallback)localObject).updateRange(j, i, arrayOfInt[0], arrayOfInt[1], this.mScrollHint);
    }
  }
  
  public static abstract class DataCallback<T>
  {
    @WorkerThread
    public abstract void fillData(@NonNull T[] paramArrayOfT, int paramInt1, int paramInt2);
    
    @WorkerThread
    public int getMaxCachedTiles()
    {
      return 10;
    }
    
    @WorkerThread
    public void recycleData(@NonNull T[] paramArrayOfT, int paramInt) {}
    
    @WorkerThread
    public abstract int refreshData();
  }
  
  public static abstract class ViewCallback
  {
    public static final int HINT_SCROLL_ASC = 2;
    public static final int HINT_SCROLL_DESC = 1;
    public static final int HINT_SCROLL_NONE = 0;
    
    @UiThread
    public void extendRangeInto(@NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, int paramInt)
    {
      int i = paramArrayOfInt1[1] - paramArrayOfInt1[0] + 1;
      int j = i / 2;
      int k = paramArrayOfInt1[0];
      if (paramInt == 1) {
        m = i;
      } else {
        m = j;
      }
      paramArrayOfInt2[0] = (k - m);
      int m = paramArrayOfInt1[1];
      if (paramInt == 2) {
        j = i;
      }
      paramArrayOfInt2[1] = (m + j);
    }
    
    @UiThread
    public abstract void getItemRangeInto(@NonNull int[] paramArrayOfInt);
    
    @UiThread
    public abstract void onDataRefresh();
    
    @UiThread
    public abstract void onItemLoaded(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\AsyncListUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */