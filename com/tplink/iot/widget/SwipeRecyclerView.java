package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

public class SwipeRecyclerView
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener
{
  private boolean H3;
  private int I3 = 0;
  private View c;
  private RecyclerView d;
  private SwipeRefreshLayout f;
  private d p0;
  private boolean p1;
  private boolean p2;
  private boolean p3;
  private RecyclerView.LayoutManager q;
  private c x;
  private GridLayoutManager.SpanSizeLookup y;
  private b z;
  
  public SwipeRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    q();
  }
  
  private int o(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt[0];
    int k = paramArrayOfInt.length;
    while (i < k)
    {
      int m = paramArrayOfInt[i];
      int n = j;
      if (m > j) {
        n = m;
      }
      i++;
      j = n;
    }
    return j;
  }
  
  private void q()
  {
    this.p1 = false;
    this.H3 = true;
    this.p2 = false;
    this.p3 = true;
    Object localObject = LayoutInflater.from(getContext()).inflate(2131559234, this);
    this.f = ((SwipeRefreshLayout)((View)localObject).findViewById(2131361811));
    localObject = (RecyclerView)((View)localObject).findViewById(2131361803);
    this.d = ((RecyclerView)localObject);
    this.q = ((RecyclerView)localObject).getLayoutManager();
    this.f.setOnRefreshListener(this);
    this.d.setOnScrollListener(new a());
  }
  
  public boolean getLoadMoreEnable()
  {
    return this.p3;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.d;
  }
  
  public boolean getRefreshEnable()
  {
    return this.H3;
  }
  
  public SwipeRefreshLayout getSwipeRefreshLayout()
  {
    return this.f;
  }
  
  public void onRefresh()
  {
    c localc = this.x;
    if (localc != null) {
      localc.onRefresh();
    }
  }
  
  public boolean p()
  {
    return this.f.isRefreshing();
  }
  
  public void r()
  {
    this.p2 = false;
    d locald = this.p0;
    if (locald != null) {
      locald.notifyItemRemoved(locald.getItemCount());
    }
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if (paramAdapter != null)
    {
      if (this.z == null) {
        this.z = new b();
      }
      d locald = new d(paramAdapter);
      this.p0 = locald;
      this.d.setAdapter(locald);
      paramAdapter.registerAdapterDataObserver(this.z);
      this.z.onChanged();
    }
  }
  
  public void setEmptyView(View paramView)
  {
    View localView = this.c;
    if (localView != null) {
      removeView(localView);
    }
    this.c = paramView;
    paramView = this.z;
    if (paramView != null) {
      paramView.onChanged();
    }
  }
  
  public void setLoadMoreEnable(boolean paramBoolean)
  {
    if (!paramBoolean) {
      r();
    }
    this.p3 = paramBoolean;
  }
  
  public void setOnLoadListener(c paramc)
  {
    this.x = paramc;
  }
  
  public void setRefreshEnable(boolean paramBoolean)
  {
    this.H3 = paramBoolean;
    this.f.setEnabled(paramBoolean);
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    this.f.setRefreshing(paramBoolean);
    if ((paramBoolean) && (!this.p2))
    {
      c localc = this.x;
      if (localc != null) {
        localc.onRefresh();
      }
    }
  }
  
  public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.y = paramSpanSizeLookup;
  }
  
  class a
    extends RecyclerView.OnScrollListener
  {
    a() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if ((SwipeRecyclerView.a(SwipeRecyclerView.this)) && (!SwipeRecyclerView.this.p()) && (!SwipeRecyclerView.b(SwipeRecyclerView.this)))
      {
        SwipeRecyclerView.f(SwipeRecyclerView.this, paramRecyclerView.getLayoutManager());
        if ((SwipeRecyclerView.e(SwipeRecyclerView.this) instanceof LinearLayoutManager))
        {
          paramRecyclerView = SwipeRecyclerView.this;
          SwipeRecyclerView.h(paramRecyclerView, ((LinearLayoutManager)SwipeRecyclerView.e(paramRecyclerView)).findLastVisibleItemPosition());
        }
        else if ((SwipeRecyclerView.e(SwipeRecyclerView.this) instanceof GridLayoutManager))
        {
          paramRecyclerView = SwipeRecyclerView.this;
          SwipeRecyclerView.h(paramRecyclerView, ((GridLayoutManager)SwipeRecyclerView.e(paramRecyclerView)).findLastCompletelyVisibleItemPosition());
        }
        else if ((SwipeRecyclerView.e(SwipeRecyclerView.this) instanceof StaggeredGridLayoutManager))
        {
          paramRecyclerView = new int[((StaggeredGridLayoutManager)SwipeRecyclerView.e(SwipeRecyclerView.this)).getSpanCount()];
          ((StaggeredGridLayoutManager)SwipeRecyclerView.e(SwipeRecyclerView.this)).findLastVisibleItemPositions(paramRecyclerView);
          SwipeRecyclerView localSwipeRecyclerView = SwipeRecyclerView.this;
          SwipeRecyclerView.h(localSwipeRecyclerView, SwipeRecyclerView.i(localSwipeRecyclerView, paramRecyclerView));
        }
        if (SwipeRecyclerView.j(SwipeRecyclerView.this) == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = SwipeRecyclerView.j(SwipeRecyclerView.this).getItemCount();
        }
        if ((paramInt1 > 1) && (SwipeRecyclerView.g(SwipeRecyclerView.this) == paramInt1 - 1) && (SwipeRecyclerView.k(SwipeRecyclerView.this) != null))
        {
          SwipeRecyclerView.d(SwipeRecyclerView.this, true);
          SwipeRecyclerView.k(SwipeRecyclerView.this).a();
        }
      }
    }
  }
  
  class b
    extends RecyclerView.AdapterDataObserver
  {
    b() {}
    
    public void onChanged()
    {
      super.onChanged();
      Object localObject = SwipeRecyclerView.m(SwipeRecyclerView.this).getAdapter();
      if ((localObject != null) && (SwipeRecyclerView.n(SwipeRecyclerView.this) != null)) {
        if (((RecyclerView.Adapter)localObject).getItemCount() == 0)
        {
          SwipeRecyclerView.c(SwipeRecyclerView.this, true);
          if (SwipeRecyclerView.n(SwipeRecyclerView.this).getParent() == null)
          {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            localLayoutParams.gravity = 17;
            localObject = SwipeRecyclerView.this;
            ((FrameLayout)localObject).addView(SwipeRecyclerView.n((SwipeRecyclerView)localObject), localLayoutParams);
          }
          SwipeRecyclerView.m(SwipeRecyclerView.this).setVisibility(8);
          SwipeRecyclerView.n(SwipeRecyclerView.this).setVisibility(0);
        }
        else
        {
          SwipeRecyclerView.c(SwipeRecyclerView.this, false);
          SwipeRecyclerView.n(SwipeRecyclerView.this).setVisibility(8);
          SwipeRecyclerView.m(SwipeRecyclerView.this).setVisibility(0);
        }
      }
      SwipeRecyclerView.j(SwipeRecyclerView.this).notifyDataSetChanged();
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      super.onItemRangeChanged(paramInt1, paramInt2);
      SwipeRecyclerView.j(SwipeRecyclerView.this).notifyItemRangeChanged(paramInt1, paramInt2);
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      SwipeRecyclerView.j(SwipeRecyclerView.this).notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      super.onItemRangeInserted(paramInt1, paramInt2);
      SwipeRecyclerView.j(SwipeRecyclerView.this).notifyItemRangeInserted(paramInt1, paramInt2);
    }
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
      SwipeRecyclerView.j(SwipeRecyclerView.this).notifyItemRangeRemoved(paramInt1, paramInt3);
    }
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      super.onItemRangeRemoved(paramInt1, paramInt2);
      SwipeRecyclerView.j(SwipeRecyclerView.this).notifyItemRangeRemoved(paramInt1, paramInt2);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void onRefresh();
  }
  
  private class d
    extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  {
    RecyclerView.Adapter<RecyclerView.ViewHolder> a;
    
    public d()
    {
      RecyclerView.Adapter localAdapter;
      this.a = localAdapter;
    }
    
    public int getItemCount()
    {
      RecyclerView.Adapter localAdapter = this.a;
      int i;
      if (localAdapter == null) {
        i = 0;
      } else {
        i = localAdapter.getItemCount();
      }
      return i;
    }
    
    public long getItemId(int paramInt)
    {
      return this.a.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      if (m(paramInt)) {
        return 256;
      }
      return this.a.getItemViewType(paramInt);
    }
    
    public boolean m(int paramInt)
    {
      return false;
    }
    
    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
    {
      final Object localObject = paramRecyclerView.getLayoutManager();
      if ((localObject instanceof GridLayoutManager))
      {
        localObject = (GridLayoutManager)localObject;
        ((GridLayoutManager)localObject).setSpanSizeLookup(new a((GridLayoutManager)localObject));
      }
      this.a.onAttachedToRecyclerView(paramRecyclerView);
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (m(paramInt)) {
        return;
      }
      this.a.onBindViewHolder(paramViewHolder, paramInt);
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return this.a.onCreateViewHolder(paramViewGroup, paramInt);
    }
    
    public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
    {
      this.a.onDetachedFromRecyclerView(paramRecyclerView);
    }
    
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder paramViewHolder)
    {
      return this.a.onFailedToRecycleView(paramViewHolder);
    }
    
    public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
    {
      ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
      if ((localLayoutParams != null) && ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) && (m(paramViewHolder.getLayoutPosition()))) {
        ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
      }
      this.a.onViewAttachedToWindow(paramViewHolder);
    }
    
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
    {
      this.a.onViewDetachedFromWindow(paramViewHolder);
    }
    
    public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
    {
      this.a.onViewRecycled(paramViewHolder);
    }
    
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.a.registerAdapterDataObserver(paramAdapterDataObserver);
    }
    
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.a.unregisterAdapterDataObserver(paramAdapterDataObserver);
    }
    
    class a
      extends GridLayoutManager.SpanSizeLookup
    {
      a(GridLayoutManager paramGridLayoutManager) {}
      
      public int getSpanSize(int paramInt)
      {
        boolean bool = SwipeRecyclerView.d.this.m(paramInt);
        if ((SwipeRecyclerView.l(SwipeRecyclerView.this) != null) && (!bool)) {
          return SwipeRecyclerView.l(SwipeRecyclerView.this).getSpanSize(paramInt);
        }
        if (bool) {
          paramInt = localObject.getSpanCount();
        } else {
          paramInt = 1;
        }
        return paramInt;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\SwipeRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */