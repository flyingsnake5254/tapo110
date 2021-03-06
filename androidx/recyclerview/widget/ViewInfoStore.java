package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;

class ViewInfoStore
{
  private static final boolean DEBUG = false;
  @VisibleForTesting
  final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new SimpleArrayMap();
  @VisibleForTesting
  final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();
  
  private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = this.mLayoutHolderMap.indexOfKey(paramViewHolder);
    if (i < 0) {
      return null;
    }
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.valueAt(i);
    if (localInfoRecord != null)
    {
      int j = localInfoRecord.flags;
      if ((j & paramInt) != 0)
      {
        j = (paramInt ^ 0xFFFFFFFF) & j;
        localInfoRecord.flags = j;
        if (paramInt == 4)
        {
          paramViewHolder = localInfoRecord.preInfo;
        }
        else
        {
          if (paramInt != 8) {
            break label112;
          }
          paramViewHolder = localInfoRecord.postInfo;
        }
        if ((j & 0xC) == 0)
        {
          this.mLayoutHolderMap.removeAt(i);
          InfoRecord.recycle(localInfoRecord);
        }
        return paramViewHolder;
        label112:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
      }
    }
    return null;
  }
  
  void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord1 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord2 = localInfoRecord1;
    if (localInfoRecord1 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    localInfoRecord2.flags |= 0x2;
    localInfoRecord2.preInfo = paramItemHolderInfo;
  }
  
  void addToDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord1 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord2 = localInfoRecord1;
    if (localInfoRecord1 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    localInfoRecord2.flags |= 0x1;
  }
  
  void addToOldChangeHolders(long paramLong, RecyclerView.ViewHolder paramViewHolder)
  {
    this.mOldChangedHolders.put(paramLong, paramViewHolder);
  }
  
  void addToPostLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord1 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord2 = localInfoRecord1;
    if (localInfoRecord1 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    localInfoRecord2.postInfo = paramItemHolderInfo;
    localInfoRecord2.flags |= 0x8;
  }
  
  void addToPreLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord1 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord2 = localInfoRecord1;
    if (localInfoRecord1 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    localInfoRecord2.preInfo = paramItemHolderInfo;
    localInfoRecord2.flags |= 0x4;
  }
  
  void clear()
  {
    this.mLayoutHolderMap.clear();
    this.mOldChangedHolders.clear();
  }
  
  RecyclerView.ViewHolder getFromOldChangeHolders(long paramLong)
  {
    return (RecyclerView.ViewHolder)this.mOldChangedHolders.get(paramLong);
  }
  
  boolean isDisappearing(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    boolean bool = true;
    if ((paramViewHolder == null) || ((paramViewHolder.flags & 0x1) == 0)) {
      bool = false;
    }
    return bool;
  }
  
  boolean isInPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    boolean bool;
    if ((paramViewHolder != null) && ((paramViewHolder.flags & 0x4) != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void onDetach() {}
  
  public void onViewDetached(RecyclerView.ViewHolder paramViewHolder)
  {
    removeFromDisappearedInLayout(paramViewHolder);
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 8);
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 4);
  }
  
  void process(ProcessCallback paramProcessCallback)
  {
    for (int i = this.mLayoutHolderMap.size() - 1; i >= 0; i--)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mLayoutHolderMap.keyAt(i);
      InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.removeAt(i);
      int j = localInfoRecord.flags;
      if ((j & 0x3) == 3)
      {
        paramProcessCallback.unused(localViewHolder);
      }
      else if ((j & 0x1) != 0)
      {
        RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo = localInfoRecord.preInfo;
        if (localItemHolderInfo == null) {
          paramProcessCallback.unused(localViewHolder);
        } else {
          paramProcessCallback.processDisappeared(localViewHolder, localItemHolderInfo, localInfoRecord.postInfo);
        }
      }
      else if ((j & 0xE) == 14)
      {
        paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      }
      else if ((j & 0xC) == 12)
      {
        paramProcessCallback.processPersistent(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      }
      else if ((j & 0x4) != 0)
      {
        paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, null);
      }
      else if ((j & 0x8) != 0)
      {
        paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      }
      InfoRecord.recycle(localInfoRecord);
    }
  }
  
  void removeFromDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (paramViewHolder == null) {
      return;
    }
    paramViewHolder.flags &= 0xFFFFFFFE;
  }
  
  void removeViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    for (int i = this.mOldChangedHolders.size() - 1; i >= 0; i--) {
      if (paramViewHolder == this.mOldChangedHolders.valueAt(i))
      {
        this.mOldChangedHolders.removeAt(i);
        break;
      }
    }
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.remove(paramViewHolder);
    if (paramViewHolder != null) {
      InfoRecord.recycle(paramViewHolder);
    }
  }
  
  static class InfoRecord
  {
    static final int FLAG_APPEAR = 2;
    static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    static final int FLAG_APPEAR_PRE_AND_POST = 14;
    static final int FLAG_DISAPPEARED = 1;
    static final int FLAG_POST = 8;
    static final int FLAG_PRE = 4;
    static final int FLAG_PRE_AND_POST = 12;
    static Pools.Pool<InfoRecord> sPool = new Pools.SimplePool(20);
    int flags;
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo preInfo;
    
    static void drainCache()
    {
      while (sPool.acquire() != null) {}
    }
    
    static InfoRecord obtain()
    {
      InfoRecord localInfoRecord1 = (InfoRecord)sPool.acquire();
      InfoRecord localInfoRecord2 = localInfoRecord1;
      if (localInfoRecord1 == null) {
        localInfoRecord2 = new InfoRecord();
      }
      return localInfoRecord2;
    }
    
    static void recycle(InfoRecord paramInfoRecord)
    {
      paramInfoRecord.flags = 0;
      paramInfoRecord.preInfo = null;
      paramInfoRecord.postInfo = null;
      sPool.release(paramInfoRecord);
    }
  }
  
  static abstract interface ProcessCallback
  {
    public abstract void processAppeared(RecyclerView.ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processDisappeared(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processPersistent(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void unused(RecyclerView.ViewHolder paramViewHolder);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ViewInfoStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */