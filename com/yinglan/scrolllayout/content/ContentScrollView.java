package com.yinglan.scrolllayout.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;

public class ContentScrollView
  extends ScrollView
{
  private a c;
  
  public ContentScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContentScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof ScrollLayout))
      {
        ((ScrollLayout)localViewParent).setAssociatedScrollView(this);
        break;
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent = getParent();
    if (((localViewParent instanceof ScrollLayout)) && (((ScrollLayout)localViewParent).getCurrentStatus() == ScrollLayout.Status.OPENED)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnScrollChangeListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\yinglan\scrolllayout\content\ContentScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */