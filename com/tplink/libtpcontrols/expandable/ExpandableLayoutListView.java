package com.tplink.libtpcontrols.expandable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class ExpandableLayoutListView
  extends ListView
{
  private Integer c = Integer.valueOf(-1);
  
  public ExpandableLayoutListView(Context paramContext)
  {
    super(paramContext);
    setOnScrollListener(new a());
  }
  
  public ExpandableLayoutListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnScrollListener(new a());
  }
  
  public ExpandableLayoutListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnScrollListener(new a());
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    this.c = Integer.valueOf(paramInt);
    for (int i = 0; i < getChildCount(); i++) {
      if (i != paramInt - getFirstVisiblePosition()) {
        ((ExpandableLayoutItem)getChildAt(i).findViewWithTag(ExpandableLayoutItem.class.getName())).e();
      }
    }
    ExpandableLayoutItem localExpandableLayoutItem = (ExpandableLayoutItem)getChildAt(paramInt - getFirstVisiblePosition()).findViewWithTag(ExpandableLayoutItem.class.getName());
    if (localExpandableLayoutItem.h().booleanValue()) {
      localExpandableLayoutItem.e();
    } else {
      localExpandableLayoutItem.k();
    }
    return super.performItemClick(paramView, paramInt, paramLong);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if ((paramOnScrollListener instanceof a))
    {
      super.setOnScrollListener(paramOnScrollListener);
      return;
    }
    throw new IllegalArgumentException("OnScrollListner must be an OnExpandableLayoutScrollListener");
  }
  
  public class a
    implements AbsListView.OnScrollListener
  {
    private int c = 0;
    
    public a() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.c != 0) {
        for (paramInt1 = 0; paramInt1 < ExpandableLayoutListView.this.getChildCount(); paramInt1++)
        {
          paramAbsListView = (ExpandableLayoutItem)ExpandableLayoutListView.this.getChildAt(paramInt1).findViewWithTag(ExpandableLayoutItem.class.getName());
          if ((paramAbsListView.h().booleanValue()) && (paramInt1 != ExpandableLayoutListView.a(ExpandableLayoutListView.this).intValue() - ExpandableLayoutListView.this.getFirstVisiblePosition())) {
            paramAbsListView.f();
          } else if ((!paramAbsListView.getCloseByUser().booleanValue()) && (!paramAbsListView.h().booleanValue()) && (paramInt1 == ExpandableLayoutListView.a(ExpandableLayoutListView.this).intValue() - ExpandableLayoutListView.this.getFirstVisiblePosition())) {
            paramAbsListView.l();
          }
        }
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      this.c = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\expandable\ExpandableLayoutListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */