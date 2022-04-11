package com.tplink.libtpcontrols.expandable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;

public class ExpandableLayout
  extends RelativeLayout
{
  private Boolean c;
  private Boolean d;
  private Integer f;
  private FrameLayout q;
  private FrameLayout x;
  private Animation y;
  
  public ExpandableLayout(Context paramContext)
  {
    super(paramContext);
    paramContext = Boolean.FALSE;
    this.c = paramContext;
    this.d = paramContext;
  }
  
  public ExpandableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Boolean localBoolean = Boolean.FALSE;
    this.c = localBoolean;
    this.d = localBoolean;
    d(paramContext, paramAttributeSet);
  }
  
  public ExpandableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Boolean localBoolean = Boolean.FALSE;
    this.c = localBoolean;
    this.d = localBoolean;
    d(paramContext, paramAttributeSet);
  }
  
  private void b(final View paramView)
  {
    b localb = new b(paramView, paramView.getMeasuredHeight());
    this.y = localb;
    localb.setDuration(this.f.intValue());
    paramView.startAnimation(this.y);
  }
  
  private void c(final View paramView)
  {
    paramView.measure(-1, -2);
    final int i = paramView.getMeasuredHeight();
    paramView.getLayoutParams().height = 0;
    paramView.setVisibility(0);
    a locala = new a(paramView, i);
    this.y = locala;
    locala.setDuration(this.f.intValue());
    paramView.startAnimation(this.y);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
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
      this.f = Integer.valueOf(paramAttributeSet.getInt(x0.ExpandableLayout_el_duration, getContext().getResources().getInteger(17694720)));
      localView = View.inflate(paramContext, i, null);
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      this.x.addView(localView);
      paramContext = View.inflate(paramContext, j, null);
      paramContext.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      this.q.addView(paramContext);
      this.q.setVisibility(8);
      this.x.setOnClickListener(new b(this));
      paramAttributeSet.recycle();
      return;
    }
    throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
  }
  
  public FrameLayout getContentLayout()
  {
    return this.q;
  }
  
  public FrameLayout getHeaderLayout()
  {
    return this.x;
  }
  
  public void setLayoutAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.y.setAnimationListener(paramAnimationListener);
  }
  
  class a
    extends Animation
  {
    a(View paramView, int paramInt) {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      boolean bool = paramFloat < 1.0F;
      if (!bool) {
        ExpandableLayout.a(ExpandableLayout.this, Boolean.TRUE);
      }
      paramTransformation = paramView.getLayoutParams();
      int i;
      if (!bool) {
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
        ExpandableLayout.a(ExpandableLayout.this, Boolean.FALSE);
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\expandable\ExpandableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */