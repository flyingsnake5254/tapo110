package com.tplink.libtpcontrols.horizontalpageview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.DrawableRes;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tplink.libtpcontrols.m0;
import com.tplink.libtpcontrols.r0;
import com.tplink.libtpcontrols.x0;
import java.util.Objects;

public class TPCircleIndicator
  extends LinearLayout
{
  private Animator H3;
  private int I3;
  private final ViewPager.OnPageChangeListener J3;
  private DataSetObserver K3;
  private ViewPager c;
  private int d = -1;
  private int f = -1;
  private int p0;
  private Animator p1;
  private Animator p2;
  private Animator p3;
  private int q = -1;
  private int x = m0.scale_with_alpha;
  private int y = 0;
  private int z;
  
  public TPCircleIndicator(Context paramContext)
  {
    super(paramContext);
    int i = r0.white_radius;
    this.z = i;
    this.p0 = i;
    this.I3 = -1;
    this.J3 = new a();
    this.K3 = new b();
    p(paramContext, null);
  }
  
  public TPCircleIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = r0.white_radius;
    this.z = i;
    this.p0 = i;
    this.I3 = -1;
    this.J3 = new a();
    this.K3 = new b();
    p(paramContext, paramAttributeSet);
  }
  
  public TPCircleIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = r0.white_radius;
    this.z = paramInt;
    this.p0 = paramInt;
    this.I3 = -1;
    this.J3 = new a();
    this.K3 = new b();
    p(paramContext, paramAttributeSet);
  }
  
  private void i(int paramInt1, @DrawableRes int paramInt2, Animator paramAnimator)
  {
    if ((paramAnimator != null) && (paramAnimator.isRunning()))
    {
      paramAnimator.end();
      paramAnimator.cancel();
    }
    View localView = new View(getContext());
    localView.setBackgroundResource(paramInt2);
    addView(localView, this.f, this.q);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    if (paramInt1 == 0)
    {
      paramInt1 = this.d;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.rightMargin = paramInt1;
    }
    else
    {
      paramInt1 = this.d;
      localLayoutParams.topMargin = paramInt1;
      localLayoutParams.bottomMargin = paramInt1;
    }
    localView.setLayoutParams(localLayoutParams);
    if (paramAnimator != null)
    {
      paramAnimator.setTarget(localView);
      paramAnimator.start();
    }
  }
  
  private void j(Context paramContext)
  {
    int i = this.f;
    int j = i;
    if (i < 0) {
      j = n(5.0F);
    }
    this.f = j;
    i = this.q;
    j = i;
    if (i < 0) {
      j = n(5.0F);
    }
    this.q = j;
    i = this.d;
    j = i;
    if (i < 0) {
      j = n(5.0F);
    }
    this.d = j;
    i = this.x;
    j = i;
    if (i == 0) {
      j = m0.scale_with_alpha;
    }
    this.x = j;
    this.p1 = l(paramContext);
    Animator localAnimator = l(paramContext);
    this.p3 = localAnimator;
    localAnimator.setDuration(0L);
    this.p2 = k(paramContext);
    paramContext = k(paramContext);
    this.H3 = paramContext;
    paramContext.setDuration(0L);
    i = this.z;
    j = i;
    if (i == 0) {
      j = r0.white_radius;
    }
    this.z = j;
    i = this.p0;
    if (i != 0) {
      j = i;
    }
    this.p0 = j;
  }
  
  private Animator k(Context paramContext)
  {
    int i = this.y;
    if (i == 0)
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, this.x);
      paramContext.setInterpolator(new c(null));
    }
    else
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, i);
    }
    return paramContext;
  }
  
  private Animator l(Context paramContext)
  {
    return AnimatorInflater.loadAnimator(paramContext, this.x);
  }
  
  private void m()
  {
    removeAllViews();
    PagerAdapter localPagerAdapter = this.c.getAdapter();
    int i = 0;
    int j;
    if (localPagerAdapter != null) {
      j = this.c.getAdapter().getCount();
    } else {
      j = 0;
    }
    if (j <= 0) {
      return;
    }
    int k = this.c.getCurrentItem();
    int m = getOrientation();
    while (i < j)
    {
      if (k == i) {
        i(m, this.z, this.p3);
      } else {
        i(m, this.p0, this.H3);
      }
      i++;
    }
  }
  
  private void o(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.CircleIndicator);
    this.f = paramContext.getDimensionPixelSize(x0.CircleIndicator_ci_width, -1);
    this.q = paramContext.getDimensionPixelSize(x0.CircleIndicator_ci_height, -1);
    this.d = paramContext.getDimensionPixelSize(x0.CircleIndicator_ci_margin, -1);
    this.x = paramContext.getResourceId(x0.CircleIndicator_ci_animator, m0.scale_with_alpha);
    this.y = paramContext.getResourceId(x0.CircleIndicator_ci_animator_reverse, 0);
    int i = paramContext.getResourceId(x0.CircleIndicator_ci_drawable, r0.white_radius);
    this.z = i;
    this.p0 = paramContext.getResourceId(x0.CircleIndicator_ci_drawable_unselected, i);
    setOrientation(0);
    setGravity(17);
    paramContext.recycle();
  }
  
  private void p(Context paramContext, AttributeSet paramAttributeSet)
  {
    o(paramContext, paramAttributeSet);
    j(paramContext);
  }
  
  public DataSetObserver getDataSetObserver()
  {
    return this.K3;
  }
  
  public int n(float paramFloat)
  {
    return (int)(paramFloat * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  @Deprecated
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager localViewPager = this.c;
    Objects.requireNonNull(localViewPager, "can not find Viewpager , setViewPager first");
    localViewPager.removeOnPageChangeListener(paramOnPageChangeListener);
    this.c.addOnPageChangeListener(paramOnPageChangeListener);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.c = paramViewPager;
    if ((paramViewPager != null) && (paramViewPager.getAdapter() != null))
    {
      m();
      this.c.removeOnPageChangeListener(this.J3);
      this.c.addOnPageChangeListener(this.J3);
      if (this.I3 != this.c.getCurrentItem())
      {
        this.I3 = -1;
        this.J3.onPageSelected(this.c.getCurrentItem());
      }
    }
  }
  
  class a
    implements ViewPager.OnPageChangeListener
  {
    a() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      if ((TPCircleIndicator.a(TPCircleIndicator.this).getAdapter() != null) && (TPCircleIndicator.a(TPCircleIndicator.this).getAdapter().getCount() > 0))
      {
        if (TPCircleIndicator.b(TPCircleIndicator.this).isRunning())
        {
          TPCircleIndicator.b(TPCircleIndicator.this).end();
          TPCircleIndicator.b(TPCircleIndicator.this).cancel();
        }
        if (TPCircleIndicator.c(TPCircleIndicator.this).isRunning())
        {
          TPCircleIndicator.c(TPCircleIndicator.this).end();
          TPCircleIndicator.c(TPCircleIndicator.this).cancel();
        }
        if (TPCircleIndicator.d(TPCircleIndicator.this) >= 0)
        {
          localObject = TPCircleIndicator.this;
          localObject = ((LinearLayout)localObject).getChildAt(TPCircleIndicator.d((TPCircleIndicator)localObject));
          if (localObject != null)
          {
            ((View)localObject).setBackgroundResource(TPCircleIndicator.f(TPCircleIndicator.this));
            TPCircleIndicator.b(TPCircleIndicator.this).setTarget(localObject);
            TPCircleIndicator.b(TPCircleIndicator.this).start();
          }
        }
        Object localObject = TPCircleIndicator.this.getChildAt(paramInt);
        if (localObject != null)
        {
          ((View)localObject).setBackgroundResource(TPCircleIndicator.g(TPCircleIndicator.this));
          TPCircleIndicator.c(TPCircleIndicator.this).setTarget(localObject);
          TPCircleIndicator.c(TPCircleIndicator.this).start();
        }
        TPCircleIndicator.e(TPCircleIndicator.this, paramInt);
      }
    }
  }
  
  class b
    extends DataSetObserver
  {
    b() {}
    
    public void onChanged()
    {
      super.onChanged();
      if (TPCircleIndicator.a(TPCircleIndicator.this) == null) {
        return;
      }
      int i = 0;
      if (TPCircleIndicator.a(TPCircleIndicator.this).getAdapter() != null) {
        i = TPCircleIndicator.a(TPCircleIndicator.this).getAdapter().getCount();
      }
      if (i == TPCircleIndicator.this.getChildCount()) {
        return;
      }
      if (TPCircleIndicator.d(TPCircleIndicator.this) < i)
      {
        TPCircleIndicator localTPCircleIndicator = TPCircleIndicator.this;
        TPCircleIndicator.e(localTPCircleIndicator, TPCircleIndicator.a(localTPCircleIndicator).getCurrentItem());
      }
      else
      {
        TPCircleIndicator.e(TPCircleIndicator.this, -1);
      }
      TPCircleIndicator.h(TPCircleIndicator.this);
    }
  }
  
  private static class c
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return Math.abs(1.0F - paramFloat);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalpageview\TPCircleIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */