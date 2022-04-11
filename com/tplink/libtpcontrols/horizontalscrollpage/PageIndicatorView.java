package com.tplink.libtpcontrols.horizontalscrollpage;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import b.d.w.f.a;
import java.util.List;

public class PageIndicatorView
  extends LinearLayout
{
  private Context c = null;
  private int d = 7;
  private int f = 3;
  private boolean p0 = true;
  private List<View> q = null;
  private int x = -1;
  private int y = 17301609;
  private int z = 17301611;
  
  public PageIndicatorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PageIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PageIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    setGravity(17);
    setOrientation(0);
    this.d = a.a(paramContext, this.d);
    this.f = a.a(paramContext, this.f);
  }
  
  public void setIndexOfIndicator(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setIndicatorMargin(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setIndicatorSize(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setIndicatorVisible(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public void setInvisibleResource(int paramInt)
  {
    if (this.c.getResources().getDrawable(paramInt) != null) {
      this.y = paramInt;
    }
  }
  
  public void setOnlineResource(int paramInt)
  {
    if (this.c.getResources().getDrawable(paramInt) != null) {
      this.z = paramInt;
    }
  }
  
  public void setSelectedPage(int paramInt)
  {
    if (this.q != null) {
      for (int i = 0; i < this.q.size(); i++)
      {
        this.x = paramInt;
        if (i == paramInt) {
          ((View)this.q.get(i)).setBackgroundResource(this.z);
        } else {
          ((View)this.q.get(i)).setBackgroundResource(this.y);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalscrollpage\PageIndicatorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */