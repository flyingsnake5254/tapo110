package com.tplink.libtpcontrols.expandable;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;

public class ExpandableLayoutItem
  extends RelativeLayout
{
  private Boolean c;
  private Boolean d;
  private Integer f;
  private FrameLayout q;
  private FrameLayout x;
  private Boolean y;
  
  public ExpandableLayoutItem(Context paramContext)
  {
    super(paramContext);
    paramContext = Boolean.FALSE;
    this.c = paramContext;
    this.d = paramContext;
    this.y = Boolean.TRUE;
  }
  
  public ExpandableLayoutItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Boolean localBoolean = Boolean.FALSE;
    this.c = localBoolean;
    this.d = localBoolean;
    this.y = Boolean.TRUE;
    g(paramContext, paramAttributeSet);
  }
  
  public ExpandableLayoutItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Boolean localBoolean = Boolean.FALSE;
    this.c = localBoolean;
    this.d = localBoolean;
    this.y = Boolean.TRUE;
    g(paramContext, paramAttributeSet);
  }
  
  private void c(final View paramView)
  {
    this.d = Boolean.FALSE;
    b localb = new b(paramView, paramView.getMeasuredHeight());
    localb.setInterpolator(new AccelerateDecelerateInterpolator());
    localb.setDuration(this.f.intValue());
    paramView.startAnimation(localb);
  }
  
  private void d(final View paramView)
  {
    this.d = Boolean.TRUE;
    paramView.measure(-1, -2);
    final int i = paramView.getMeasuredHeight();
    paramView.getLayoutParams().height = 0;
    paramView.setVisibility(0);
    a locala = new a(paramView, i);
    locala.setInterpolator(new AccelerateDecelerateInterpolator());
    locala.setDuration(this.f.intValue());
    paramView.startAnimation(locala);
  }
  
  private void g(Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = View.inflate(paramContext, t0.view_expandable, this);
    this.x = ((FrameLayout)localView.findViewById(s0.view_expandable_headerlayout));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.ExpandableLayout);
    int i = paramAttributeSet.getResourceId(x0.ExpandableLayout_el_headerLayout, -1);
    int j = paramAttributeSet.getResourceId(x0.ExpandableLayout_el_contentLayout, -1);
    this.q = ((FrameLayout)localView.findViewById(s0.view_expandable_contentLayout));
    if ((i != -1) && (j != -1))
    {
      if (isInEditMode()) {
        return;
      }
      this.f = Integer.valueOf(paramAttributeSet.getInt(x0.ExpandableLayout_el_duration, 300));
      localView = View.inflate(paramContext, i, null);
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      this.x.addView(localView);
      setTag(ExpandableLayoutItem.class.getName());
      paramContext = View.inflate(paramContext, j, null);
      paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      this.q.addView(paramContext);
      this.q.setVisibility(8);
      paramAttributeSet.recycle();
      return;
    }
    throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
  }
  
  public void e()
  {
    if (!this.c.booleanValue())
    {
      c(this.q);
      this.c = Boolean.TRUE;
      new Handler().postDelayed(new c(), this.f.intValue());
    }
    this.y = Boolean.FALSE;
  }
  
  public void f()
  {
    this.q.getLayoutParams().height = 0;
    this.q.invalidate();
    this.q.setVisibility(8);
    this.d = Boolean.FALSE;
  }
  
  public Boolean getCloseByUser()
  {
    return this.y;
  }
  
  public FrameLayout getContentLayout()
  {
    return this.q;
  }
  
  public FrameLayout getHeaderLayout()
  {
    return this.x;
  }
  
  public Boolean h()
  {
    return this.d;
  }
  
  public void k()
  {
    if (!this.c.booleanValue())
    {
      d(this.q);
      this.c = Boolean.TRUE;
      new Handler().postDelayed(new c(this), this.f.intValue());
    }
  }
  
  public void l()
  {
    if (!h().booleanValue())
    {
      this.q.setVisibility(0);
      this.d = Boolean.TRUE;
      this.q.getLayoutParams().height = -2;
      this.q.invalidate();
    }
  }
  
  class a
    extends Animation
  {
    a(View paramView, int paramInt) {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = paramView.getLayoutParams();
      int i;
      if (paramFloat == 1.0F) {
        i = -2;
      } else {
        i = (int)(i * paramFloat);
      }
      paramTransformation.height = i;
      paramView.requestLayout();
    }
    
    public boolean willChangeBounds()
    {
      return true;
    }
  }
  
  class b
    extends Animation
  {
    b(View paramView, int paramInt) {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      if (paramFloat == 1.0F)
      {
        paramView.setVisibility(8);
        ExpandableLayoutItem.a(ExpandableLayoutItem.this, Boolean.FALSE);
      }
      else
      {
        paramTransformation = paramView.getLayoutParams();
        int i = this.d;
        paramTransformation.height = (i - (int)(i * paramFloat));
        paramView.requestLayout();
      }
    }
    
    public boolean willChangeBounds()
    {
      return true;
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      ExpandableLayoutItem.b(ExpandableLayoutItem.this, Boolean.FALSE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\expandable\ExpandableLayoutItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */