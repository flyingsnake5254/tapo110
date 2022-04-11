package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ConcatAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  static final String TAG = "ConcatAdapter";
  private final ConcatAdapterController mController;
  
  public ConcatAdapter(@NonNull Config paramConfig, @NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> paramList)
  {
    this.mController = new ConcatAdapterController(this, paramConfig);
    paramConfig = paramList.iterator();
    while (paramConfig.hasNext()) {
      addAdapter((RecyclerView.Adapter)paramConfig.next());
    }
    super.setHasStableIds(this.mController.hasStableIds());
  }
  
  @SafeVarargs
  public ConcatAdapter(@NonNull Config paramConfig, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... paramVarArgs)
  {
    this(paramConfig, Arrays.asList(paramVarArgs));
  }
  
  public ConcatAdapter(@NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> paramList)
  {
    this(Config.DEFAULT, paramList);
  }
  
  @SafeVarargs
  public ConcatAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... paramVarArgs)
  {
    this(Config.DEFAULT, paramVarArgs);
  }
  
  public boolean addAdapter(int paramInt, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> paramAdapter)
  {
    return this.mController.addAdapter(paramInt, paramAdapter);
  }
  
  public boolean addAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> paramAdapter)
  {
    return this.mController.addAdapter(paramAdapter);
  }
  
  public int findRelativeAdapterPositionIn(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> paramAdapter, @NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return this.mController.getLocalAdapterPosition(paramAdapter, paramViewHolder, paramInt);
  }
  
  @NonNull
  public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters()
  {
    return Collections.unmodifiableList(this.mController.getCopyOfAdapters());
  }
  
  public int getItemCount()
  {
    return this.mController.getTotalCount();
  }
  
  public long getItemId(int paramInt)
  {
    return this.mController.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.mController.getItemViewType(paramInt);
  }
  
  void internalSetStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy paramStateRestorationPolicy)
  {
    super.setStateRestorationPolicy(paramStateRestorationPolicy);
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    this.mController.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.mController.onBindViewHolder(paramViewHolder, paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return this.mController.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    this.mController.onDetachedFromRecyclerView(paramRecyclerView);
  }
  
  public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    return this.mController.onFailedToRecycleView(paramViewHolder);
  }
  
  public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    this.mController.onViewAttachedToWindow(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    this.mController.onViewDetachedFromWindow(paramViewHolder);
  }
  
  public void onViewRecycled(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    this.mController.onViewRecycled(paramViewHolder);
  }
  
  public boolean removeAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> paramAdapter)
  {
    return this.mController.removeAdapter(paramAdapter);
  }
  
  public void setHasStableIds(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
  }
  
  public void setStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy paramStateRestorationPolicy)
  {
    throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
  }
  
  public static final class Config
  {
    @NonNull
    public static final Config DEFAULT = new Config(true, StableIdMode.NO_STABLE_IDS);
    public final boolean isolateViewTypes;
    @NonNull
    public final StableIdMode stableIdMode;
    
    Config(boolean paramBoolean, @NonNull StableIdMode paramStableIdMode)
    {
      this.isolateViewTypes = paramBoolean;
      this.stableIdMode = paramStableIdMode;
    }
    
    public static final class Builder
    {
      private boolean mIsolateViewTypes;
      private ConcatAdapter.Config.StableIdMode mStableIdMode;
      
      public Builder()
      {
        ConcatAdapter.Config localConfig = ConcatAdapter.Config.DEFAULT;
        this.mIsolateViewTypes = localConfig.isolateViewTypes;
        this.mStableIdMode = localConfig.stableIdMode;
      }
      
      @NonNull
      public ConcatAdapter.Config build()
      {
        return new ConcatAdapter.Config(this.mIsolateViewTypes, this.mStableIdMode);
      }
      
      @NonNull
      public Builder setIsolateViewTypes(boolean paramBoolean)
      {
        this.mIsolateViewTypes = paramBoolean;
        return this;
      }
      
      @NonNull
      public Builder setStableIdMode(@NonNull ConcatAdapter.Config.StableIdMode paramStableIdMode)
      {
        this.mStableIdMode = paramStableIdMode;
        return this;
      }
    }
    
    public static enum StableIdMode
    {
      static
      {
        StableIdMode localStableIdMode1 = new StableIdMode("NO_STABLE_IDS", 0);
        NO_STABLE_IDS = localStableIdMode1;
        StableIdMode localStableIdMode2 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
        ISOLATED_STABLE_IDS = localStableIdMode2;
        StableIdMode localStableIdMode3 = new StableIdMode("SHARED_STABLE_IDS", 2);
        SHARED_STABLE_IDS = localStableIdMode3;
        $VALUES = new StableIdMode[] { localStableIdMode1, localStableIdMode2, localStableIdMode3 };
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ConcatAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */