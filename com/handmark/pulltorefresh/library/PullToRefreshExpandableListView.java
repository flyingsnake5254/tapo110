package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.internal.a;

public class PullToRefreshExpandableListView
  extends PullToRefreshAdapterViewBase<ExpandableListView>
{
  public PullToRefreshExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected ExpandableListView Q(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext = new b(paramContext, paramAttributeSet);
    } else {
      paramContext = new a(paramContext, paramAttributeSet);
    }
    paramContext.setId(16908298);
    return paramContext;
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  class a
    extends ExpandableListView
    implements a
  {
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public void setEmptyView(View paramView)
    {
      PullToRefreshExpandableListView.this.setEmptyView(paramView);
    }
    
    public void setEmptyViewInternal(View paramView)
    {
      super.setEmptyView(paramView);
    }
  }
  
  @TargetApi(9)
  final class b
    extends PullToRefreshExpandableListView.a
  {
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramContext, paramAttributeSet);
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      f.d(PullToRefreshExpandableListView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\PullToRefreshExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */