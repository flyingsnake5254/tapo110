package com.yinglan.scrolllayout.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContentRecyclerView
  extends RecyclerView
{
  private final b c;
  
  public ContentRecyclerView(Context paramContext)
  {
    super(paramContext);
    paramContext = new b(null);
    this.c = paramContext;
    super.addOnScrollListener(paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new a());
  }
  
  public ContentRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new b(null);
    this.c = paramContext;
    super.addOnScrollListener(paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new a());
  }
  
  public ContentRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new b(null);
    this.c = paramContext;
    super.addOnScrollListener(paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new a());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof ScrollLayout))
      {
        ((ScrollLayout)localViewParent).setAssociatedRecyclerView(this);
        break;
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      ViewGroup.LayoutParams localLayoutParams = ContentRecyclerView.this.getLayoutParams();
      for (Object localObject = ContentRecyclerView.this.getParent(); localObject != null; localObject = ((ViewParent)localObject).getParent()) {
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
      ContentRecyclerView.this.setLayoutParams(localLayoutParams);
    }
  }
  
  private class b
    extends RecyclerView.OnScrollListener
  {
    private final List<RecyclerView.OnScrollListener> a = new ArrayList();
    
    private b() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.OnScrollListener)localIterator.next()).onScrollStateChanged(paramRecyclerView, paramInt);
      }
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((RecyclerView.OnScrollListener)localIterator.next()).onScrolled(paramRecyclerView, paramInt1, paramInt2);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\yinglan\scrolllayout\content\ContentRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */