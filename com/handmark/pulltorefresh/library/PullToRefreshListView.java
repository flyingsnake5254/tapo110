package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.a;
import com.tplink.libtpcontrols.x0;

public class PullToRefreshListView
  extends PullToRefreshAdapterViewBase<ListView>
{
  private LoadingLayout f4;
  private LoadingLayout g4;
  private FrameLayout h4;
  private boolean i4;
  
  public PullToRefreshListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected ListView R(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext = new b(paramContext, paramAttributeSet);
    } else {
      paramContext = new InternalListView(paramContext, paramAttributeSet);
    }
    return paramContext;
  }
  
  protected ListView S(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = R(paramContext, paramAttributeSet);
    paramContext.setId(16908298);
    return paramContext;
  }
  
  protected e g(boolean paramBoolean1, boolean paramBoolean2)
  {
    e locale = super.g(paramBoolean1, paramBoolean2);
    if (this.i4)
    {
      PullToRefreshBase.Mode localMode = getMode();
      if ((paramBoolean1) && (localMode.showHeaderLoadingLayout())) {
        locale.a(this.f4);
      }
      if ((paramBoolean2) && (localMode.showFooterLoadingLayout())) {
        locale.a(this.g4);
      }
    }
    return locale;
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected void k(TypedArray paramTypedArray)
  {
    super.k(paramTypedArray);
    boolean bool = paramTypedArray.getBoolean(x0.PullToRefresh_ptrListViewExtrasEnabled, true);
    this.i4 = bool;
    if (bool)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
      Object localObject = new FrameLayout(getContext());
      LoadingLayout localLoadingLayout = f(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, paramTypedArray);
      this.f4 = localLoadingLayout;
      localLoadingLayout.setVisibility(8);
      ((FrameLayout)localObject).addView(this.f4, localLayoutParams);
      ((ListView)this.H3).addHeaderView((View)localObject, null, false);
      this.h4 = new FrameLayout(getContext());
      localObject = f(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, paramTypedArray);
      this.g4 = ((LoadingLayout)localObject);
      ((FrameLayout)localObject).setVisibility(8);
      this.h4.addView(this.g4, localLayoutParams);
      if (!paramTypedArray.hasValue(x0.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
        setScrollingWhileRefreshingEnabled(true);
      }
    }
  }
  
  protected void x(boolean paramBoolean)
  {
    Object localObject1 = ((ListView)this.H3).getAdapter();
    if ((this.i4) && (getShowViewWhileRefreshing()) && (localObject1 != null) && (!((ListAdapter)localObject1).isEmpty()))
    {
      super.x(false);
      int i = a.a[getCurrentMode().ordinal()];
      Object localObject2;
      LoadingLayout localLoadingLayout1;
      int j;
      if ((i != 1) && (i != 2))
      {
        localObject1 = getHeaderLayout();
        localObject2 = this.f4;
        localLoadingLayout1 = this.g4;
        i = getScrollY() + getHeaderSize();
        j = 0;
      }
      else
      {
        LoadingLayout localLoadingLayout2 = getFooterLayout();
        localObject1 = this.g4;
        localLoadingLayout1 = this.f4;
        j = ((ListView)this.H3).getCount() - 1;
        i = getScrollY() - getFooterSize();
        localObject2 = localObject1;
        localObject1 = localLoadingLayout2;
      }
      ((LoadingLayout)localObject1).k();
      ((LoadingLayout)localObject1).a();
      localLoadingLayout1.setVisibility(8);
      ((FrameLayout)localObject2).setVisibility(0);
      ((LoadingLayout)localObject2).g();
      if (paramBoolean)
      {
        i();
        setHeaderScroll(i);
        ((ListView)this.H3).setSelection(j);
        F(0);
      }
      return;
    }
    super.x(paramBoolean);
  }
  
  protected void z()
  {
    if (!this.i4)
    {
      super.z();
      return;
    }
    int i = a.a[getCurrentMode().ordinal()];
    int j = 0;
    int k = 0;
    int m = 1;
    LoadingLayout localLoadingLayout1;
    LoadingLayout localLoadingLayout2;
    if ((i != 1) && (i != 2))
    {
      localLoadingLayout1 = getHeaderLayout();
      localLoadingLayout2 = this.f4;
      i = -getHeaderSize();
      if (Math.abs(((ListView)this.H3).getFirstVisiblePosition() - 0) > 1) {
        m = 0;
      }
    }
    else
    {
      localLoadingLayout1 = getFooterLayout();
      localLoadingLayout2 = this.g4;
      j = ((ListView)this.H3).getCount() - 1;
      i = getFooterSize();
      m = k;
      if (Math.abs(((ListView)this.H3).getLastVisiblePosition() - j) <= 1) {
        m = 1;
      }
    }
    if (localLoadingLayout2.getVisibility() == 0)
    {
      localLoadingLayout1.m();
      localLoadingLayout2.setVisibility(8);
      if ((m != 0) && (getState() != PullToRefreshBase.State.MANUAL_REFRESHING))
      {
        ((ListView)this.H3).setSelection(j);
        setHeaderScroll(i);
      }
    }
    super.z();
  }
  
  protected class InternalListView
    extends ListView
    implements a
  {
    private boolean c = false;
    
    public InternalListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
      }
      catch (IndexOutOfBoundsException paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      try
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IndexOutOfBoundsException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      if ((PullToRefreshListView.Q(PullToRefreshListView.this) != null) && (!this.c))
      {
        addFooterView(PullToRefreshListView.Q(PullToRefreshListView.this), null, false);
        this.c = true;
      }
      super.setAdapter(paramListAdapter);
    }
    
    public void setEmptyView(View paramView)
    {
      PullToRefreshListView.this.setEmptyView(paramView);
    }
    
    public void setEmptyViewInternal(View paramView)
    {
      super.setEmptyView(paramView);
    }
  }
  
  @TargetApi(9)
  final class b
    extends PullToRefreshListView.InternalListView
  {
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramContext, paramAttributeSet);
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      f.d(PullToRefreshListView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\PullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */