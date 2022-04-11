package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

class ConcatAdapterController
  implements NestedAdapterWrapper.Callback
{
  private List<WeakReference<RecyclerView>> mAttachedRecyclerViews = new ArrayList();
  private final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> mBinderLookup = new IdentityHashMap();
  private final ConcatAdapter mConcatAdapter;
  private WrapperAndLocalPosition mReusableHolder = new WrapperAndLocalPosition();
  @NonNull
  private final ConcatAdapter.Config.StableIdMode mStableIdMode;
  private final StableIdStorage mStableIdStorage;
  private final ViewTypeStorage mViewTypeStorage;
  private List<NestedAdapterWrapper> mWrappers = new ArrayList();
  
  ConcatAdapterController(ConcatAdapter paramConcatAdapter, ConcatAdapter.Config paramConfig)
  {
    this.mConcatAdapter = paramConcatAdapter;
    if (paramConfig.isolateViewTypes) {
      this.mViewTypeStorage = new ViewTypeStorage.IsolatedViewTypeStorage();
    } else {
      this.mViewTypeStorage = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
    }
    paramConcatAdapter = paramConfig.stableIdMode;
    this.mStableIdMode = paramConcatAdapter;
    if (paramConcatAdapter == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS)
    {
      this.mStableIdStorage = new StableIdStorage.NoStableIdStorage();
    }
    else if (paramConcatAdapter == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS)
    {
      this.mStableIdStorage = new StableIdStorage.IsolatedStableIdStorage();
    }
    else
    {
      if (paramConcatAdapter != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
        break label156;
      }
      this.mStableIdStorage = new StableIdStorage.SharedPoolStableIdStorage();
    }
    return;
    label156:
    throw new IllegalArgumentException("unknown stable id mode");
  }
  
  private void calculateAndUpdateStateRestorationPolicy()
  {
    RecyclerView.Adapter.StateRestorationPolicy localStateRestorationPolicy = computeStateRestorationPolicy();
    if (localStateRestorationPolicy != this.mConcatAdapter.getStateRestorationPolicy()) {
      this.mConcatAdapter.internalSetStateRestorationPolicy(localStateRestorationPolicy);
    }
  }
  
  private RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy()
  {
    Iterator localIterator = this.mWrappers.iterator();
    while (localIterator.hasNext())
    {
      NestedAdapterWrapper localNestedAdapterWrapper = (NestedAdapterWrapper)localIterator.next();
      RecyclerView.Adapter.StateRestorationPolicy localStateRestorationPolicy1 = localNestedAdapterWrapper.adapter.getStateRestorationPolicy();
      RecyclerView.Adapter.StateRestorationPolicy localStateRestorationPolicy2 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
      if (localStateRestorationPolicy1 == localStateRestorationPolicy2) {
        return localStateRestorationPolicy2;
      }
      if ((localStateRestorationPolicy1 == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) && (localNestedAdapterWrapper.getCachedItemCount() == 0)) {
        return localStateRestorationPolicy2;
      }
    }
    return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
  }
  
  private int countItemsBefore(NestedAdapterWrapper paramNestedAdapterWrapper)
  {
    Iterator localIterator = this.mWrappers.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      NestedAdapterWrapper localNestedAdapterWrapper = (NestedAdapterWrapper)localIterator.next();
      if (localNestedAdapterWrapper == paramNestedAdapterWrapper) {
        break;
      }
      i += localNestedAdapterWrapper.getCachedItemCount();
    }
    return i;
  }
  
  @NonNull
  private WrapperAndLocalPosition findWrapperAndLocalPosition(int paramInt)
  {
    Object localObject = this.mReusableHolder;
    if (((WrapperAndLocalPosition)localObject).mInUse) {
      localObject = new WrapperAndLocalPosition();
    } else {
      ((WrapperAndLocalPosition)localObject).mInUse = true;
    }
    Iterator localIterator = this.mWrappers.iterator();
    int i = paramInt;
    while (localIterator.hasNext())
    {
      NestedAdapterWrapper localNestedAdapterWrapper = (NestedAdapterWrapper)localIterator.next();
      if (localNestedAdapterWrapper.getCachedItemCount() > i)
      {
        ((WrapperAndLocalPosition)localObject).mWrapper = localNestedAdapterWrapper;
        ((WrapperAndLocalPosition)localObject).mLocalPosition = i;
        break;
      }
      i -= localNestedAdapterWrapper.getCachedItemCount();
    }
    if (((WrapperAndLocalPosition)localObject).mWrapper != null) {
      return (WrapperAndLocalPosition)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  @Nullable
  private NestedAdapterWrapper findWrapperFor(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter)
  {
    int i = indexOfWrapper(paramAdapter);
    if (i == -1) {
      return null;
    }
    return (NestedAdapterWrapper)this.mWrappers.get(i);
  }
  
  @NonNull
  private NestedAdapterWrapper getWrapper(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = (NestedAdapterWrapper)this.mBinderLookup.get(paramViewHolder);
    if (localObject != null) {
      return (NestedAdapterWrapper)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramViewHolder);
    ((StringBuilder)localObject).append(", seems like it is not bound by this adapter: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private int indexOfWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter)
  {
    int i = this.mWrappers.size();
    for (int j = 0; j < i; j++) {
      if (((NestedAdapterWrapper)this.mWrappers.get(j)).adapter == paramAdapter) {
        return j;
      }
    }
    return -1;
  }
  
  private boolean isAttachedTo(RecyclerView paramRecyclerView)
  {
    Iterator localIterator = this.mAttachedRecyclerViews.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramRecyclerView) {
        return true;
      }
    }
    return false;
  }
  
  private void releaseWrapperAndLocalPosition(WrapperAndLocalPosition paramWrapperAndLocalPosition)
  {
    paramWrapperAndLocalPosition.mInUse = false;
    paramWrapperAndLocalPosition.mWrapper = null;
    paramWrapperAndLocalPosition.mLocalPosition = -1;
    this.mReusableHolder = paramWrapperAndLocalPosition;
  }
  
  boolean addAdapter(int paramInt, RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter)
  {
    if ((paramInt >= 0) && (paramInt <= this.mWrappers.size()))
    {
      if (hasStableIds()) {
        Preconditions.checkArgument(paramAdapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
      } else if (paramAdapter.hasStableIds()) {
        Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
      }
      if (findWrapperFor(paramAdapter) != null) {
        return false;
      }
      NestedAdapterWrapper localNestedAdapterWrapper = new NestedAdapterWrapper(paramAdapter, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
      this.mWrappers.add(paramInt, localNestedAdapterWrapper);
      Iterator localIterator = this.mAttachedRecyclerViews.iterator();
      while (localIterator.hasNext())
      {
        RecyclerView localRecyclerView = (RecyclerView)((WeakReference)localIterator.next()).get();
        if (localRecyclerView != null) {
          paramAdapter.onAttachedToRecyclerView(localRecyclerView);
        }
      }
      if (localNestedAdapterWrapper.getCachedItemCount() > 0) {
        this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(localNestedAdapterWrapper), localNestedAdapterWrapper.getCachedItemCount());
      }
      calculateAndUpdateStateRestorationPolicy();
      return true;
    }
    paramAdapter = new StringBuilder();
    paramAdapter.append("Index must be between 0 and ");
    paramAdapter.append(this.mWrappers.size());
    paramAdapter.append(". Given:");
    paramAdapter.append(paramInt);
    throw new IndexOutOfBoundsException(paramAdapter.toString());
  }
  
  boolean addAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter)
  {
    return addAdapter(this.mWrappers.size(), paramAdapter);
  }
  
  public boolean canRestoreState()
  {
    Iterator localIterator = this.mWrappers.iterator();
    while (localIterator.hasNext()) {
      if (!((NestedAdapterWrapper)localIterator.next()).adapter.canRestoreState()) {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getBoundAdapter(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (NestedAdapterWrapper)this.mBinderLookup.get(paramViewHolder);
    if (paramViewHolder == null) {
      return null;
    }
    return paramViewHolder.adapter;
  }
  
  public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getCopyOfAdapters()
  {
    if (this.mWrappers.isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(this.mWrappers.size());
    Iterator localIterator = this.mWrappers.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((NestedAdapterWrapper)localIterator.next()).adapter);
    }
    return localArrayList;
  }
  
  public long getItemId(int paramInt)
  {
    WrapperAndLocalPosition localWrapperAndLocalPosition = findWrapperAndLocalPosition(paramInt);
    long l = localWrapperAndLocalPosition.mWrapper.getItemId(localWrapperAndLocalPosition.mLocalPosition);
    releaseWrapperAndLocalPosition(localWrapperAndLocalPosition);
    return l;
  }
  
  public int getItemViewType(int paramInt)
  {
    WrapperAndLocalPosition localWrapperAndLocalPosition = findWrapperAndLocalPosition(paramInt);
    paramInt = localWrapperAndLocalPosition.mWrapper.getItemViewType(localWrapperAndLocalPosition.mLocalPosition);
    releaseWrapperAndLocalPosition(localWrapperAndLocalPosition);
    return paramInt;
  }
  
  public int getLocalAdapterPosition(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> paramAdapter, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = (NestedAdapterWrapper)this.mBinderLookup.get(paramViewHolder);
    if (localObject == null) {
      return -1;
    }
    paramInt -= countItemsBefore((NestedAdapterWrapper)localObject);
    int i = ((NestedAdapterWrapper)localObject).adapter.getItemCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      return ((NestedAdapterWrapper)localObject).adapter.findRelativeAdapterPositionIn(paramAdapter, paramViewHolder, paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Detected inconsistent adapter updates. The local position of the view holder maps to ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" which is out of bounds for the adapter with size ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
    ((StringBuilder)localObject).append(paramViewHolder);
    ((StringBuilder)localObject).append("adapter:");
    ((StringBuilder)localObject).append(paramAdapter);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public int getTotalCount()
  {
    Iterator localIterator = this.mWrappers.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((NestedAdapterWrapper)localIterator.next()).getCachedItemCount();
    }
    return i;
  }
  
  public boolean hasStableIds()
  {
    boolean bool;
    if (this.mStableIdMode != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    if (isAttachedTo(paramRecyclerView)) {
      return;
    }
    this.mAttachedRecyclerViews.add(new WeakReference(paramRecyclerView));
    Iterator localIterator = this.mWrappers.iterator();
    while (localIterator.hasNext()) {
      ((NestedAdapterWrapper)localIterator.next()).adapter.onAttachedToRecyclerView(paramRecyclerView);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    WrapperAndLocalPosition localWrapperAndLocalPosition = findWrapperAndLocalPosition(paramInt);
    this.mBinderLookup.put(paramViewHolder, localWrapperAndLocalPosition.mWrapper);
    localWrapperAndLocalPosition.mWrapper.onBindViewHolder(paramViewHolder, localWrapperAndLocalPosition.mLocalPosition);
    releaseWrapperAndLocalPosition(localWrapperAndLocalPosition);
  }
  
  public void onChanged(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper)
  {
    this.mConcatAdapter.notifyDataSetChanged();
    calculateAndUpdateStateRestorationPolicy();
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return this.mViewTypeStorage.getWrapperForGlobalType(paramInt).onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    for (int i = this.mAttachedRecyclerViews.size() - 1; i >= 0; i--)
    {
      localObject = (WeakReference)this.mAttachedRecyclerViews.get(i);
      if (((WeakReference)localObject).get() == null)
      {
        this.mAttachedRecyclerViews.remove(i);
      }
      else if (((WeakReference)localObject).get() == paramRecyclerView)
      {
        this.mAttachedRecyclerViews.remove(i);
        break;
      }
    }
    Object localObject = this.mWrappers.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((NestedAdapterWrapper)((Iterator)localObject).next()).adapter.onDetachedFromRecyclerView(paramRecyclerView);
    }
  }
  
  public boolean onFailedToRecycleView(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = (NestedAdapterWrapper)this.mBinderLookup.get(paramViewHolder);
    if (localObject != null)
    {
      boolean bool = ((NestedAdapterWrapper)localObject).adapter.onFailedToRecycleView(paramViewHolder);
      this.mBinderLookup.remove(paramViewHolder);
      return bool;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramViewHolder);
    ((StringBuilder)localObject).append(", seems like it is not bound by this adapter: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void onItemRangeChanged(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2)
  {
    int i = countItemsBefore(paramNestedAdapterWrapper);
    this.mConcatAdapter.notifyItemRangeChanged(paramInt1 + i, paramInt2);
  }
  
  public void onItemRangeChanged(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    int i = countItemsBefore(paramNestedAdapterWrapper);
    this.mConcatAdapter.notifyItemRangeChanged(paramInt1 + i, paramInt2, paramObject);
  }
  
  public void onItemRangeInserted(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2)
  {
    int i = countItemsBefore(paramNestedAdapterWrapper);
    this.mConcatAdapter.notifyItemRangeInserted(paramInt1 + i, paramInt2);
  }
  
  public void onItemRangeMoved(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2)
  {
    int i = countItemsBefore(paramNestedAdapterWrapper);
    this.mConcatAdapter.notifyItemMoved(paramInt1 + i, paramInt2 + i);
  }
  
  public void onItemRangeRemoved(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2)
  {
    int i = countItemsBefore(paramNestedAdapterWrapper);
    this.mConcatAdapter.notifyItemRangeRemoved(paramInt1 + i, paramInt2);
  }
  
  public void onStateRestorationPolicyChanged(NestedAdapterWrapper paramNestedAdapterWrapper)
  {
    calculateAndUpdateStateRestorationPolicy();
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    getWrapper(paramViewHolder).adapter.onViewAttachedToWindow(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    getWrapper(paramViewHolder).adapter.onViewDetachedFromWindow(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = (NestedAdapterWrapper)this.mBinderLookup.get(paramViewHolder);
    if (localObject != null)
    {
      ((NestedAdapterWrapper)localObject).adapter.onViewRecycled(paramViewHolder);
      this.mBinderLookup.remove(paramViewHolder);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find wrapper for ");
    ((StringBuilder)localObject).append(paramViewHolder);
    ((StringBuilder)localObject).append(", seems like it is not bound by this adapter: ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  boolean removeAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter)
  {
    int i = indexOfWrapper(paramAdapter);
    if (i == -1) {
      return false;
    }
    NestedAdapterWrapper localNestedAdapterWrapper = (NestedAdapterWrapper)this.mWrappers.get(i);
    int j = countItemsBefore(localNestedAdapterWrapper);
    this.mWrappers.remove(i);
    this.mConcatAdapter.notifyItemRangeRemoved(j, localNestedAdapterWrapper.getCachedItemCount());
    Iterator localIterator = this.mAttachedRecyclerViews.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView localRecyclerView = (RecyclerView)((WeakReference)localIterator.next()).get();
      if (localRecyclerView != null) {
        paramAdapter.onDetachedFromRecyclerView(localRecyclerView);
      }
    }
    localNestedAdapterWrapper.dispose();
    calculateAndUpdateStateRestorationPolicy();
    return true;
  }
  
  static class WrapperAndLocalPosition
  {
    boolean mInUse;
    int mLocalPosition;
    NestedAdapterWrapper mWrapper;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ConcatAdapterController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */