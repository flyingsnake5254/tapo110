package com.yinglan.scrolllayout.content;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContentListView
  extends ListView
{
  private final c c;
  private boolean d;
  private View f;
  
  public ContentListView(Context paramContext)
  {
    super(paramContext);
    paramContext = new c(null);
    this.c = paramContext;
    this.d = false;
    super.setOnScrollListener(paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new a());
  }
  
  public ContentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new c(null);
    this.c = paramContext;
    this.d = false;
    super.setOnScrollListener(paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new a());
  }
  
  public ContentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new c(null);
    this.c = paramContext;
    this.d = false;
    super.setOnScrollListener(paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new a());
  }
  
  private void e()
  {
    View localView = this.f;
    if ((localView != null) && (localView.getVisibility() != 0)) {
      this.f.setVisibility(0);
    }
  }
  
  private void f()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException("Must be invoked from the main thread.");
  }
  
  public void d(AbsListView.OnScrollListener paramOnScrollListener)
  {
    f();
    this.c.a(paramOnScrollListener);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof ScrollLayout))
      {
        ((ScrollLayout)localViewParent).setAssociatedListView(this);
        break;
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    d(paramOnScrollListener);
  }
  
  public void setTopShadowView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.f = paramView;
    d(new b());
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      ViewGroup.LayoutParams localLayoutParams = ContentListView.this.getLayoutParams();
      for (Object localObject = ContentListView.this.getParent(); localObject != null; localObject = ((ViewParent)localObject).getParent()) {
        if ((localObject instanceof ScrollLayout))
        {
          localObject = (ScrollLayout)localObject;
          int i = ((FrameLayout)localObject).getMeasuredHeight() - ((ScrollLayout)localObject).O3;
          if (localLayoutParams.height == i) {
            return;
          }
          localLayoutParams.height = i;
          break;
        }
      }
      ContentListView.this.setLayoutParams(localLayoutParams);
    }
  }
  
  class b
    implements AbsListView.OnScrollListener
  {
    b() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramAbsListView = paramAbsListView.getChildAt(0);
      if (paramAbsListView != null) {
        if ((paramInt1 == 0) && (paramAbsListView.getTop() == 0))
        {
          ContentListView.b(ContentListView.this, false);
          ContentListView.c(ContentListView.this);
        }
        else if (!ContentListView.a(ContentListView.this))
        {
          ContentListView.b(ContentListView.this, true);
          ContentListView.c(ContentListView.this);
        }
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  }
  
  private class c
    implements AbsListView.OnScrollListener
  {
    private final List<AbsListView.OnScrollListener> c = new ArrayList();
    
    private c() {}
    
    public void a(AbsListView.OnScrollListener paramOnScrollListener)
    {
      if (paramOnScrollListener == null) {
        return;
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        if (paramOnScrollListener == (AbsListView.OnScrollListener)localIterator.next()) {
          return;
        }
      }
      this.c.add(paramOnScrollListener);
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      Iterator localIterator = new ArrayList(this.c).iterator();
      while (localIterator.hasNext()) {
        ((AbsListView.OnScrollListener)localIterator.next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      Iterator localIterator = new ArrayList(this.c).iterator();
      while (localIterator.hasNext()) {
        ((AbsListView.OnScrollListener)localIterator.next()).onScrollStateChanged(paramAbsListView, paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\yinglan\scrolllayout\content\ContentListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */