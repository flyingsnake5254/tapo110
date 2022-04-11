package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;

class NestedAdapterWrapper
{
  public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
  private RecyclerView.AdapterDataObserver mAdapterObserver = new RecyclerView.AdapterDataObserver()
  {
    public void onChanged()
    {
      NestedAdapterWrapper localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCachedItemCount = localNestedAdapterWrapper.adapter.getItemCount();
      localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCallback.onChanged(localNestedAdapterWrapper);
    }
    
    public void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      NestedAdapterWrapper localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCallback.onItemRangeChanged(localNestedAdapterWrapper, paramAnonymousInt1, paramAnonymousInt2, null);
    }
    
    public void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, @Nullable Object paramAnonymousObject)
    {
      NestedAdapterWrapper localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCallback.onItemRangeChanged(localNestedAdapterWrapper, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
    }
    
    public void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      NestedAdapterWrapper localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCachedItemCount += paramAnonymousInt2;
      localNestedAdapterWrapper.mCallback.onItemRangeInserted(localNestedAdapterWrapper, paramAnonymousInt1, paramAnonymousInt2);
      localNestedAdapterWrapper = NestedAdapterWrapper.this;
      if ((localNestedAdapterWrapper.mCachedItemCount > 0) && (localNestedAdapterWrapper.adapter.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY))
      {
        localNestedAdapterWrapper = NestedAdapterWrapper.this;
        localNestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(localNestedAdapterWrapper);
      }
    }
    
    public void onItemRangeMoved(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      boolean bool = true;
      if (paramAnonymousInt3 != 1) {
        bool = false;
      }
      Preconditions.checkArgument(bool, "moving more than 1 item is not supported in RecyclerView");
      NestedAdapterWrapper localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCallback.onItemRangeMoved(localNestedAdapterWrapper, paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      NestedAdapterWrapper localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCachedItemCount -= paramAnonymousInt2;
      localNestedAdapterWrapper.mCallback.onItemRangeRemoved(localNestedAdapterWrapper, paramAnonymousInt1, paramAnonymousInt2);
      localNestedAdapterWrapper = NestedAdapterWrapper.this;
      if ((localNestedAdapterWrapper.mCachedItemCount < 1) && (localNestedAdapterWrapper.adapter.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY))
      {
        localNestedAdapterWrapper = NestedAdapterWrapper.this;
        localNestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(localNestedAdapterWrapper);
      }
    }
    
    public void onStateRestorationPolicyChanged()
    {
      NestedAdapterWrapper localNestedAdapterWrapper = NestedAdapterWrapper.this;
      localNestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(localNestedAdapterWrapper);
    }
  };
  int mCachedItemCount;
  final Callback mCallback;
  @NonNull
  private final StableIdStorage.StableIdLookup mStableIdLookup;
  @NonNull
  private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;
  
  NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter, Callback paramCallback, ViewTypeStorage paramViewTypeStorage, StableIdStorage.StableIdLookup paramStableIdLookup)
  {
    this.adapter = paramAdapter;
    this.mCallback = paramCallback;
    this.mViewTypeLookup = paramViewTypeStorage.createViewTypeWrapper(this);
    this.mStableIdLookup = paramStableIdLookup;
    this.mCachedItemCount = paramAdapter.getItemCount();
    paramAdapter.registerAdapterDataObserver(this.mAdapterObserver);
  }
  
  void dispose()
  {
    this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
    this.mViewTypeLookup.dispose();
  }
  
  int getCachedItemCount()
  {
    return this.mCachedItemCount;
  }
  
  public long getItemId(int paramInt)
  {
    long l = this.adapter.getItemId(paramInt);
    return this.mStableIdLookup.localToGlobal(l);
  }
  
  int getItemViewType(int paramInt)
  {
    return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(paramInt));
  }
  
  void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.adapter.bindViewHolder(paramViewHolder, paramInt);
  }
  
  RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramInt = this.mViewTypeLookup.globalToLocal(paramInt);
    return this.adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  static abstract interface Callback
  {
    public abstract void onChanged(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper);
    
    public abstract void onItemRangeChanged(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2);
    
    public abstract void onItemRangeChanged(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2, @Nullable Object paramObject);
    
    public abstract void onItemRangeInserted(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2);
    
    public abstract void onItemRangeMoved(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2);
    
    public abstract void onItemRangeRemoved(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper, int paramInt1, int paramInt2);
    
    public abstract void onStateRestorationPolicyChanged(NestedAdapterWrapper paramNestedAdapterWrapper);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\NestedAdapterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */