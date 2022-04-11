package com.tplink.libtpcontrols.tppulltorefresh;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpcontrols.u0;
import com.tplink.libtpcontrols.x0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class TPPullToRefreshLayout
  extends RelativeLayout
{
  private Timer H3 = null;
  private com.tplink.libtpcontrols.z0.d I3 = null;
  private float J3 = 0.0F;
  private float K3 = 0.0F;
  private float L3 = 0.0F;
  private boolean M3 = false;
  private boolean N3 = false;
  private int O3 = 0;
  private int P3 = 0;
  private ValueAnimator Q3 = null;
  private int c;
  private boolean d = false;
  private float f;
  private ImageView p0 = null;
  private float p1 = 0.5F;
  private d p2 = null;
  private boolean p3 = true;
  private float q;
  private float x;
  private float y;
  private TPCircleProgressBar z = null;
  
  public TPPullToRefreshLayout(@NonNull Context paramContext)
  {
    this(paramContext, null, -1);
  }
  
  public TPPullToRefreshLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public TPPullToRefreshLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    p(paramContext, paramAttributeSet);
  }
  
  private boolean j(View paramView)
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      boolean bool1 = paramView instanceof AbsListView;
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        paramView = (AbsListView)paramView;
        if (paramView.getChildCount() > 0)
        {
          bool2 = bool3;
          if (paramView.getFirstVisiblePosition() > 0) {
            break label67;
          }
          if (paramView.getChildAt(0).getTop() < paramView.getPaddingTop())
          {
            bool2 = bool3;
            break label67;
          }
        }
        bool2 = false;
        label67:
        return bool2;
      }
      if (paramView.getScrollY() <= 0) {
        bool2 = false;
      }
      return bool2;
    }
    return paramView.canScrollVertically(-1);
  }
  
  private boolean k(ViewGroup paramViewGroup)
  {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++)
    {
      View localView = paramViewGroup.getChildAt(i);
      if (j(localView)) {
        return true;
      }
      if (((localView instanceof ViewGroup)) && (k((ViewGroup)localView))) {
        return true;
      }
    }
    return false;
  }
  
  private int l(float paramFloat)
  {
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void m(Map<Integer, Integer> paramMap, ViewGroup paramViewGroup)
  {
    paramMap.put(Integer.valueOf(paramViewGroup.getId()), Integer.valueOf(paramViewGroup.getScrollY()));
    for (int i = 0; i < paramViewGroup.getChildCount(); i++)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView != null) && (localView.getId() == -1)) {
        localView.setId(View.generateViewId());
      }
      if ((localView instanceof ViewGroup)) {
        m(paramMap, (ViewGroup)localView);
      }
    }
  }
  
  private void n()
  {
    if (this.L3 >= this.K3)
    {
      this.M3 = true;
      Object localObject = this.p2;
      if (localObject != null) {
        ((d)localObject).onRefresh();
      }
      localObject = ValueAnimator.ofFloat(new float[] { this.L3, this.J3 });
      ((ValueAnimator)localObject).setDuration(((this.L3 - this.J3) * 0.6D));
      ((ValueAnimator)localObject).addUpdateListener(new a(this));
      ((ValueAnimator)localObject).start();
      ((ValueAnimator)localObject).addListener(new a());
    }
    else
    {
      o();
    }
  }
  
  private void o()
  {
    ValueAnimator localValueAnimator = this.Q3;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofFloat(new float[] { this.L3, -this.O3 });
    this.Q3 = localValueAnimator;
    localValueAnimator.setDuration(300L);
    this.Q3.addUpdateListener(new b(this));
    this.Q3.addListener(new c());
    this.Q3.start();
  }
  
  private void p(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.O3 = l(54.0F);
    this.P3 = l(24.0F);
    this.z = new TPCircleProgressBar(getContext());
    ImageView localImageView = new ImageView(paramContext);
    this.p0 = localImageView;
    localImageView.setImageResource(u0.loading_bg);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPPullToRefreshLayout);
      float f1 = paramAttributeSet.getDimension(x0.TPPullToRefreshLayout_progress_bar_elevation, 0.0F);
      this.z.setElevation(f1);
      this.p0.setElevation(f1);
      paramAttributeSet.recycle();
    }
    post(new c(this));
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.L3 = (-this.O3);
    this.J3 = l(20.0F);
    this.K3 = l(24.0F);
  }
  
  private boolean q()
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (!(localView instanceof TPCircleProgressBar))
      {
        if (j(localView)) {
          return false;
        }
        if (((localView instanceof ViewGroup)) && (k((ViewGroup)localView))) {
          return false;
        }
      }
    }
    return true;
  }
  
  private void x(int paramInt)
  {
    Object localObject = this.p0;
    if (localObject != null) {
      ((ImageView)localObject).layout((getWidth() - this.p0.getWidth()) / 2, paramInt, (getWidth() + this.p0.getWidth()) / 2, this.O3 + paramInt);
    }
    localObject = this.z;
    if (localObject != null) {
      ((View)localObject).layout((getWidth() - this.z.getWidth()) / 2, (this.O3 - this.z.getHeight()) / 2 + paramInt, (getWidth() + this.z.getWidth()) / 2, this.z.getHeight() + paramInt + (this.O3 - this.z.getHeight()) / 2);
    }
  }
  
  private void y()
  {
    Timer localTimer = this.H3;
    if (localTimer != null) {
      localTimer.cancel();
    }
    localTimer = new Timer();
    this.H3 = localTimer;
    localTimer.schedule(new b(), 0L, 100L);
  }
  
  private void z()
  {
    Timer localTimer = this.H3;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.H3 = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (this.I3 != null)) {
        y();
      }
    }
    else
    {
      com.tplink.libtpcontrols.z0.d locald = this.I3;
      if (locald != null)
      {
        locald.b();
        z();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.M3) && (this.p3))
    {
      int i = paramMotionEvent.getAction();
      if ((i != 3) && (i != 1))
      {
        if ((i != 0) && (this.d)) {
          return true;
        }
        float f2;
        if (i != 0)
        {
          if ((i == 2) && (q()))
          {
            float f1 = paramMotionEvent.getY();
            f2 = paramMotionEvent.getX();
            float f3 = f1 - this.q;
            float f4 = this.f;
            f1 = Math.abs(f3);
            if ((f1 > this.c) && (f3 > 1.0F) && (f1 > Math.abs(f2 - f4))) {
              this.d = true;
            }
          }
        }
        else if (q())
        {
          f2 = paramMotionEvent.getY();
          this.y = f2;
          this.q = f2;
          f2 = paramMotionEvent.getX();
          this.x = f2;
          this.f = f2;
          this.d = false;
        }
        return this.d;
      }
      this.d = false;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.d)
    {
      float f1 = this.q;
      float f2 = this.y;
      float f3 = this.p1;
      paramInt1 = this.O3;
      f1 = (f1 - f2) * f3 - paramInt1;
      this.L3 = f1;
      f1 = (f1 + paramInt1) / (this.K3 + paramInt1);
      this.z.setProgress(f1);
    }
    x((int)this.L3);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) || (!this.p3)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    float f2;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label254;
          }
        }
        else
        {
          if ((!this.N3) && (q()))
          {
            float f1 = paramMotionEvent.getY();
            f2 = paramMotionEvent.getX();
            f1 -= this.q;
            float f3 = this.f;
            float f4 = Math.abs(f1);
            if ((f4 > this.c) && (f1 > 1.0F) && (f4 > Math.abs(f2 - f3)))
            {
              this.d = true;
              this.N3 = true;
            }
            if ((f4 > this.c) && (f1 < 1.0F)) {
              this.N3 = true;
            }
          }
          if (!this.d) {
            break label254;
          }
          this.q = paramMotionEvent.getY();
          this.f = paramMotionEvent.getX();
          requestLayout();
          return true;
        }
      }
      this.N3 = false;
      if (this.d)
      {
        this.d = false;
        n();
        return true;
      }
    }
    else if (q())
    {
      f2 = paramMotionEvent.getY();
      this.y = f2;
      this.q = f2;
      f2 = paramMotionEvent.getX();
      this.x = f2;
      this.f = f2;
      return true;
    }
    label254:
    return false;
  }
  
  public void setOnRefreshListener(d paramd)
  {
    this.p2 = paramd;
  }
  
  public void setOnScrollListener(com.tplink.libtpcontrols.z0.d paramd)
  {
    this.I3 = paramd;
  }
  
  public void setRefreshable(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      TPPullToRefreshLayout.a(TPPullToRefreshLayout.this).g();
      paramAnimator = TPPullToRefreshLayout.this;
      TPPullToRefreshLayout.b(paramAnimator, TPPullToRefreshLayout.c(paramAnimator));
      TPPullToRefreshLayout.this.requestLayout();
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPPullToRefreshLayout.a(TPPullToRefreshLayout.this).g();
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class b
    extends TimerTask
  {
    Map<Integer, Integer> c = null;
    
    b() {}
    
    public void run()
    {
      Object localObject2;
      if (this.c == null)
      {
        localObject1 = new HashMap();
        this.c = ((Map)localObject1);
        localObject2 = TPPullToRefreshLayout.this;
        TPPullToRefreshLayout.d((TPPullToRefreshLayout)localObject2, (Map)localObject1, (ViewGroup)localObject2);
        return;
      }
      HashMap localHashMap = new HashMap();
      Object localObject1 = localHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!((Integer)((Map.Entry)localObject2).getValue()).equals(this.c.get(((Map.Entry)localObject2).getKey())))
        {
          this.c = localHashMap;
          return;
        }
      }
      if (TPPullToRefreshLayout.e(TPPullToRefreshLayout.this) != null) {
        TPPullToRefreshLayout.e(TPPullToRefreshLayout.this).a();
      }
      if (TPPullToRefreshLayout.f(TPPullToRefreshLayout.this) != null)
      {
        TPPullToRefreshLayout.f(TPPullToRefreshLayout.this).cancel();
        TPPullToRefreshLayout.g(TPPullToRefreshLayout.this, null);
      }
    }
  }
  
  class c
    implements Animator.AnimatorListener
  {
    c() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      TPPullToRefreshLayout.a(TPPullToRefreshLayout.this).i();
      paramAnimator = TPPullToRefreshLayout.this;
      TPPullToRefreshLayout.b(paramAnimator, -TPPullToRefreshLayout.i(paramAnimator));
      TPPullToRefreshLayout.this.requestLayout();
      TPPullToRefreshLayout.h(TPPullToRefreshLayout.this, false);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPPullToRefreshLayout.a(TPPullToRefreshLayout.this).i();
      TPPullToRefreshLayout.h(TPPullToRefreshLayout.this, false);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tppulltorefresh\TPPullToRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */