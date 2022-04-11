package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;
import com.handmark.pulltorefresh.library.internal.a;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.x0;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView>
  extends PullToRefreshBase<T>
  implements AbsListView.OnScrollListener
{
  private boolean X3;
  private AbsListView.OnScrollListener Y3;
  private PullToRefreshBase.b Z3;
  private View a4;
  private IndicatorLayout b4;
  private IndicatorLayout c4;
  private boolean d4;
  private boolean e4 = true;
  
  public PullToRefreshAdapterViewBase(Context paramContext)
  {
    super(paramContext);
    ((AbsListView)this.H3).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.H3).setOnScrollListener(this);
  }
  
  private void K()
  {
    Object localObject1 = getMode();
    FrameLayout localFrameLayout = getRefreshableViewWrapper();
    Object localObject2;
    if ((((PullToRefreshBase.Mode)localObject1).showHeaderLoadingLayout()) && (this.b4 == null))
    {
      this.b4 = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).rightMargin = getResources().getDimensionPixelSize(q0.indicator_right_padding);
      ((FrameLayout.LayoutParams)localObject2).gravity = 53;
      localFrameLayout.addView(this.b4, (ViewGroup.LayoutParams)localObject2);
    }
    else if (!((PullToRefreshBase.Mode)localObject1).showHeaderLoadingLayout())
    {
      localObject2 = this.b4;
      if (localObject2 != null)
      {
        localFrameLayout.removeView((View)localObject2);
        this.b4 = null;
      }
    }
    if ((((PullToRefreshBase.Mode)localObject1).showFooterLoadingLayout()) && (this.c4 == null))
    {
      this.c4 = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
      localObject1 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject1).rightMargin = getResources().getDimensionPixelSize(q0.indicator_right_padding);
      ((FrameLayout.LayoutParams)localObject1).gravity = 85;
      localFrameLayout.addView(this.c4, (ViewGroup.LayoutParams)localObject1);
    }
    else if (!((PullToRefreshBase.Mode)localObject1).showFooterLoadingLayout())
    {
      localObject1 = this.c4;
      if (localObject1 != null)
      {
        localFrameLayout.removeView((View)localObject1);
        this.c4 = null;
      }
    }
  }
  
  private static FrameLayout.LayoutParams L(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
      {
        localLayoutParams.gravity = ((LinearLayout.LayoutParams)paramLayoutParams).gravity;
        paramLayoutParams = localLayoutParams;
      }
      else
      {
        localLayoutParams.gravity = 17;
        paramLayoutParams = localLayoutParams;
      }
    }
    else
    {
      paramLayoutParams = null;
    }
    return paramLayoutParams;
  }
  
  private boolean M()
  {
    Object localObject = ((AbsListView)this.H3).getAdapter();
    boolean bool = true;
    if ((localObject != null) && (!((Adapter)localObject).isEmpty()))
    {
      if (((AbsListView)this.H3).getFirstVisiblePosition() <= 1)
      {
        localObject = ((AbsListView)this.H3).getChildAt(0);
        if (localObject != null)
        {
          if (((View)localObject).getTop() < ((AbsListView)this.H3).getTop()) {
            bool = false;
          }
          return bool;
        }
      }
      return false;
    }
    return true;
  }
  
  private boolean N()
  {
    Object localObject = ((AbsListView)this.H3).getAdapter();
    boolean bool = true;
    if ((localObject != null) && (!((Adapter)localObject).isEmpty()))
    {
      int i = ((AbsListView)this.H3).getCount();
      int j = ((AbsListView)this.H3).getLastVisiblePosition();
      if (j >= i - 1 - 1)
      {
        i = ((AbsListView)this.H3).getFirstVisiblePosition();
        localObject = ((AbsListView)this.H3).getChildAt(j - i);
        if (localObject != null)
        {
          if (((View)localObject).getBottom() > ((AbsListView)this.H3).getBottom()) {
            bool = false;
          }
          return bool;
        }
      }
      return false;
    }
    return true;
  }
  
  private void O()
  {
    if (this.b4 != null)
    {
      getRefreshableViewWrapper().removeView(this.b4);
      this.b4 = null;
    }
    if (this.c4 != null)
    {
      getRefreshableViewWrapper().removeView(this.c4);
      this.c4 = null;
    }
  }
  
  private void P()
  {
    if (this.b4 != null) {
      if ((!r()) && (q()))
      {
        if (!this.b4.b()) {
          this.b4.e();
        }
      }
      else if (this.b4.b()) {
        this.b4.a();
      }
    }
    if (this.c4 != null) {
      if ((!r()) && (p()))
      {
        if (!this.c4.b()) {
          this.c4.e();
        }
      }
      else if (this.c4.b()) {
        this.c4.a();
      }
    }
  }
  
  private boolean getShowIndicatorInternal()
  {
    boolean bool;
    if ((this.d4) && (m())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void J()
  {
    super.J();
    if (getShowIndicatorInternal()) {
      K();
    } else {
      O();
    }
  }
  
  public boolean getShowIndicator()
  {
    return this.d4;
  }
  
  protected void k(TypedArray paramTypedArray)
  {
    this.d4 = paramTypedArray.getBoolean(x0.PullToRefresh_ptrShowIndicator, n() ^ true);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.Z3 != null)
    {
      boolean bool;
      if ((paramInt3 > 0) && (paramInt1 + paramInt2 >= paramInt3 - 1)) {
        bool = true;
      } else {
        bool = false;
      }
      this.X3 = bool;
    }
    if (getShowIndicatorInternal()) {
      P();
    }
    AbsListView.OnScrollListener localOnScrollListener = this.Y3;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.a4;
    if ((localView != null) && (!this.e4)) {
      localView.scrollTo(-paramInt1, -paramInt2);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = this.Z3;
      if ((localObject != null) && (this.X3)) {
        ((PullToRefreshBase.b)localObject).a();
      }
    }
    Object localObject = this.Y3;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected boolean p()
  {
    return N();
  }
  
  protected boolean q()
  {
    return M();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ((AdapterView)this.H3).setAdapter(paramListAdapter);
  }
  
  public final void setEmptyView(View paramView)
  {
    Object localObject1 = getRefreshableViewWrapper();
    if (paramView != null)
    {
      paramView.setClickable(true);
      Object localObject2 = paramView.getParent();
      if ((localObject2 instanceof ViewGroup)) {
        ((ViewGroup)localObject2).removeView(paramView);
      }
      localObject2 = L(paramView.getLayoutParams());
      if (localObject2 != null) {
        ((FrameLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject2);
      } else {
        ((FrameLayout)localObject1).addView(paramView);
      }
    }
    localObject1 = this.H3;
    if ((localObject1 instanceof a)) {
      ((a)localObject1).setEmptyViewInternal(paramView);
    } else {
      ((AbsListView)localObject1).setEmptyView(paramView);
    }
    this.a4 = paramView;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ((AbsListView)this.H3).setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setOnLastItemVisibleListener(PullToRefreshBase.b paramb)
  {
    this.Z3 = paramb;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.Y3 = paramOnScrollListener;
  }
  
  public final void setScrollEmptyView(boolean paramBoolean)
  {
    this.e4 = paramBoolean;
  }
  
  public void setShowIndicator(boolean paramBoolean)
  {
    this.d4 = paramBoolean;
    if (getShowIndicatorInternal()) {
      K();
    } else {
      O();
    }
  }
  
  protected void v()
  {
    super.v();
    if (getShowIndicatorInternal())
    {
      int i = a.a[getCurrentMode().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          this.b4.c();
        }
      }
      else {
        this.c4.c();
      }
    }
  }
  
  protected void x(boolean paramBoolean)
  {
    super.x(paramBoolean);
    if (getShowIndicatorInternal()) {
      P();
    }
  }
  
  protected void y()
  {
    super.y();
    if (getShowIndicatorInternal())
    {
      int i = a.a[getCurrentMode().ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          this.b4.d();
        }
      }
      else {
        this.c4.d();
      }
    }
  }
  
  protected void z()
  {
    super.z();
    if (getShowIndicatorInternal()) {
      P();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\PullToRefreshAdapterViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */