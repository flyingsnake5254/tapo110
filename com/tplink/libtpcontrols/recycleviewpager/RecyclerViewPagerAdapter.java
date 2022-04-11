package com.tplink.libtpcontrols.recycleviewpager;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class RecyclerViewPagerAdapter<VH extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<VH>
{
  private final RecyclerViewPager a;
  RecyclerView.Adapter<VH> b;
  
  public RecyclerViewPagerAdapter(RecyclerViewPager paramRecyclerViewPager, RecyclerView.Adapter<VH> paramAdapter)
  {
    this.b = paramAdapter;
    this.a = paramRecyclerViewPager;
    setHasStableIds(paramAdapter.hasStableIds());
  }
  
  public int getItemCount()
  {
    return this.b.getItemCount();
  }
  
  public long getItemId(int paramInt)
  {
    return this.b.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.b.getItemViewType(paramInt);
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.b.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public void onBindViewHolder(@NonNull VH paramVH, int paramInt)
  {
    this.b.onBindViewHolder(paramVH, paramInt);
    View localView = paramVH.itemView;
    if (localView.getLayoutParams() == null)
    {
      paramVH = new ViewGroup.LayoutParams(-1, -1);
    }
    else
    {
      paramVH = localView.getLayoutParams();
      if (this.a.getLayoutManager().canScrollHorizontally()) {
        paramVH.width = -1;
      } else {
        paramVH.height = -1;
      }
    }
    localView.setLayoutParams(paramVH);
  }
  
  @NonNull
  public VH onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return this.b.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.b.onDetachedFromRecyclerView(paramRecyclerView);
  }
  
  public boolean onFailedToRecycleView(@NonNull VH paramVH)
  {
    return this.b.onFailedToRecycleView(paramVH);
  }
  
  public void onViewAttachedToWindow(@NonNull VH paramVH)
  {
    super.onViewAttachedToWindow(paramVH);
    this.b.onViewAttachedToWindow(paramVH);
  }
  
  public void onViewDetachedFromWindow(@NonNull VH paramVH)
  {
    super.onViewDetachedFromWindow(paramVH);
    this.b.onViewDetachedFromWindow(paramVH);
  }
  
  public void onViewRecycled(@NonNull VH paramVH)
  {
    super.onViewRecycled(paramVH);
    this.b.onViewRecycled(paramVH);
  }
  
  public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    super.registerAdapterDataObserver(paramAdapterDataObserver);
    this.b.registerAdapterDataObserver(paramAdapterDataObserver);
  }
  
  public void setHasStableIds(boolean paramBoolean)
  {
    super.setHasStableIds(paramBoolean);
    this.b.setHasStableIds(paramBoolean);
  }
  
  public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    super.unregisterAdapterDataObserver(paramAdapterDataObserver);
    this.b.unregisterAdapterDataObserver(paramAdapterDataObserver);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\recycleviewpager\RecyclerViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */