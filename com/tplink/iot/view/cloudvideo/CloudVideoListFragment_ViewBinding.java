package com.tplink.iot.view.cloudvideo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public class CloudVideoListFragment_ViewBinding
  implements Unbinder
{
  private CloudVideoListFragment b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  
  @UiThread
  public CloudVideoListFragment_ViewBinding(final CloudVideoListFragment paramCloudVideoListFragment, View paramView)
  {
    this.b = paramCloudVideoListFragment;
    paramCloudVideoListFragment.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
    paramCloudVideoListFragment.mCloudVideoRv = ((RecyclerView)c.d(paramView, 2131363801, "field 'mCloudVideoRv'", RecyclerView.class));
    paramCloudVideoListFragment.mCloudVideoListEmptyView = c.c(paramView, 2131363170, "field 'mCloudVideoListEmptyView'");
    paramCloudVideoListFragment.mCloudVideoPlayView = c.c(paramView, 2131362275, "field 'mCloudVideoPlayView'");
    paramCloudVideoListFragment.mDateSelectWidget = ((LinearLayout)c.d(paramView, 2131363281, "field 'mDateSelectWidget'", LinearLayout.class));
    View localView = c.c(paramView, 2131364035, "field 'mShadowView' and method 'hideDateSelector'");
    paramCloudVideoListFragment.mShadowView = localView;
    this.c = localView;
    localView.setOnClickListener(new a(paramCloudVideoListFragment));
    localView = c.c(paramView, 2131362364, "field 'mNextMonthIv' and method 'dateMoveForward'");
    paramCloudVideoListFragment.mNextMonthIv = ((ImageView)c.b(localView, 2131362364, "field 'mNextMonthIv'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new b(paramCloudVideoListFragment));
    paramCloudVideoListFragment.mScrollCalendar = ((ScrollCalendar)c.d(paramView, 2131363971, "field 'mScrollCalendar'", ScrollCalendar.class));
    localView = c.c(paramView, 2131362362, "field 'mDataIndexBackIv' and method 'hideDateSelector'");
    paramCloudVideoListFragment.mDataIndexBackIv = ((ImageView)c.b(localView, 2131362362, "field 'mDataIndexBackIv'", ImageView.class));
    this.e = localView;
    localView.setOnClickListener(new c(paramCloudVideoListFragment));
    localView = c.c(paramView, 2131362361, "field 'mDataCurDateTv' and method 'dateCurDate'");
    paramCloudVideoListFragment.mDataCurDateTv = ((TextView)c.b(localView, 2131362361, "field 'mDataCurDateTv'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new d(paramCloudVideoListFragment));
    localView = c.c(paramView, 2131362367, "field 'mDateToday' and method 'dateToday'");
    paramCloudVideoListFragment.mDateToday = ((TextView)c.b(localView, 2131362367, "field 'mDateToday'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new e(paramCloudVideoListFragment));
    paramCloudVideoListFragment.mDateSelectorView = c.c(paramView, 2131362271, "field 'mDateSelectorView'");
    localView = c.c(paramView, 2131363042, "field 'mEditBtn' and method 'enterSelectMode'");
    paramCloudVideoListFragment.mEditBtn = ((ImageView)c.b(localView, 2131363042, "field 'mEditBtn'", ImageView.class));
    this.h = localView;
    localView.setOnClickListener(new f(paramCloudVideoListFragment));
    paramCloudVideoListFragment.mSelectDateTopBar = c.c(paramView, 2131364011, "field 'mSelectDateTopBar'");
    paramCloudVideoListFragment.mRefreshLayout = ((TPSmartRefreshLayout)c.d(paramView, 2131362273, "field 'mRefreshLayout'", TPSmartRefreshLayout.class));
    localView = c.c(paramView, 2131362075, "field 'mBtnIntoDailySummary' and method 'gotoDailySummary'");
    paramCloudVideoListFragment.mBtnIntoDailySummary = localView;
    this.i = localView;
    localView.setOnClickListener(new g(paramCloudVideoListFragment));
    paramCloudVideoListFragment.mDailySummaryIntoInfo = ((TextView)c.d(paramView, 2131364393, "field 'mDailySummaryIntoInfo'", TextView.class));
    paramCloudVideoListFragment.mNewDailySummaryPoint = ((ImageView)c.d(paramView, 2131363085, "field 'mNewDailySummaryPoint'", ImageView.class));
    paramView = c.c(paramView, 2131362363, "method 'dateMoveBackward'");
    this.j = paramView;
    paramView.setOnClickListener(new h(paramCloudVideoListFragment));
  }
  
  @CallSuper
  public void a()
  {
    CloudVideoListFragment localCloudVideoListFragment = this.b;
    if (localCloudVideoListFragment != null)
    {
      this.b = null;
      localCloudVideoListFragment.mToolbar = null;
      localCloudVideoListFragment.mCloudVideoRv = null;
      localCloudVideoListFragment.mCloudVideoListEmptyView = null;
      localCloudVideoListFragment.mCloudVideoPlayView = null;
      localCloudVideoListFragment.mDateSelectWidget = null;
      localCloudVideoListFragment.mShadowView = null;
      localCloudVideoListFragment.mNextMonthIv = null;
      localCloudVideoListFragment.mScrollCalendar = null;
      localCloudVideoListFragment.mDataIndexBackIv = null;
      localCloudVideoListFragment.mDataCurDateTv = null;
      localCloudVideoListFragment.mDateToday = null;
      localCloudVideoListFragment.mDateSelectorView = null;
      localCloudVideoListFragment.mEditBtn = null;
      localCloudVideoListFragment.mSelectDateTopBar = null;
      localCloudVideoListFragment.mRefreshLayout = null;
      localCloudVideoListFragment.mBtnIntoDailySummary = null;
      localCloudVideoListFragment.mDailySummaryIntoInfo = null;
      localCloudVideoListFragment.mNewDailySummaryPoint = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      this.g.setOnClickListener(null);
      this.g = null;
      this.h.setOnClickListener(null);
      this.h = null;
      this.i.setOnClickListener(null);
      this.i = null;
      this.j.setOnClickListener(null);
      this.j = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.hideDateSelector();
    }
  }
  
  class b
    extends b
  {
    b(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.dateMoveForward();
    }
  }
  
  class c
    extends b
  {
    c(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.hideDateSelector();
    }
  }
  
  class d
    extends b
  {
    d(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.dateCurDate();
    }
  }
  
  class e
    extends b
  {
    e(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.dateToday();
    }
  }
  
  class f
    extends b
  {
    f(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.enterSelectMode();
    }
  }
  
  class g
    extends b
  {
    g(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.gotoDailySummary();
    }
  }
  
  class h
    extends b
  {
    h(CloudVideoListFragment paramCloudVideoListFragment) {}
    
    public void a(View paramView)
    {
      paramCloudVideoListFragment.dateMoveBackward();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\CloudVideoListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */