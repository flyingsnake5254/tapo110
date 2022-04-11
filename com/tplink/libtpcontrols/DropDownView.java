package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class DropDownView
  extends RelativeLayout
{
  private int H3;
  private int I3;
  private final View.OnClickListener J3 = new c();
  private final View.OnClickListener K3 = new a(this);
  @Nullable
  private View c;
  @Nullable
  private View d;
  private ViewGroup f;
  private TransitionSet p0;
  private ObjectAnimator p1;
  private boolean p2;
  private d p3;
  private LinearLayout q;
  private boolean x;
  private View y;
  private TransitionSet z;
  
  public DropDownView(Context paramContext)
  {
    super(paramContext);
    k(paramContext, null);
  }
  
  public DropDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    k(paramContext, paramAttributeSet);
  }
  
  public DropDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k(paramContext, paramAttributeSet);
  }
  
  @TargetApi(19)
  private void d()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.p1.start();
      TransitionManager.beginDelayedTransition(this.q, this.p0);
    }
    else
    {
      this.y.setVisibility(8);
    }
  }
  
  @TargetApi(19)
  private void e()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      TransitionManager.beginDelayedTransition(this, this.z);
    }
  }
  
  private void f()
  {
    this.q = ((LinearLayout)findViewById(s0.drop_down_container));
    this.y = findViewById(s0.empty_drop_down_space);
    this.f = ((ViewGroup)findViewById(s0.drop_down_header));
  }
  
  @TargetApi(19)
  private TransitionSet h()
  {
    ChangeBounds localChangeBounds = new ChangeBounds();
    localChangeBounds.addTarget(this.q);
    Fade localFade = new Fade();
    localFade.addTarget(this.y);
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition(localChangeBounds);
    localTransitionSet.addTransition(localFade);
    localTransitionSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localTransitionSet.addListener(new b());
    return localTransitionSet;
  }
  
  private void j(Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((paramContext != null) && (paramAttributeSet != null)) {
      paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, x0.DropDownView, 0, 0);
    }
    try
    {
      this.H3 = paramAttributeSet.getColor(x0.DropDownView_containerBackgroundColor, ContextCompat.getColor(paramContext, p0.dDVColorPrimary));
      this.I3 = paramAttributeSet.getColor(x0.DropDownView_overlayColor, ContextCompat.getColor(paramContext, p0.dDVTransparentGray));
      paramAttributeSet.recycle();
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    this.H3 = ContextCompat.getColor(paramContext, p0.dDVColorPrimary);
    if (this.I3 == 0) {
      this.I3 = ContextCompat.getColor(paramContext, p0.dDVTransparentGray);
    }
  }
  
  private void k(Context paramContext, AttributeSet paramAttributeSet)
  {
    j(paramContext, paramAttributeSet);
    RelativeLayout.inflate(getContext(), t0.view_ddv_drop_down, this);
    f();
    p();
    o();
  }
  
  private void o()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      Object localObject = ObjectAnimator.ofFloat(this.y, View.ALPHA, new float[] { 0.0F });
      this.p1 = ((ObjectAnimator)localObject);
      ((ObjectAnimator)localObject).setDuration(250L);
      this.p1.setInterpolator(new AccelerateInterpolator());
      this.p1.addListener(new a());
      this.z = h();
      localObject = h();
      this.p0 = ((TransitionSet)localObject);
      ((TransitionSet)localObject).setDuration(250L);
    }
  }
  
  private void p()
  {
    this.y.setOnClickListener(this.K3);
    this.f.setOnClickListener(this.J3);
    this.q.setBackgroundColor(this.H3);
    this.f.setBackgroundColor(this.H3);
    this.y.setBackgroundColor(this.I3);
  }
  
  public void g()
  {
    if ((this.x) && (!this.p2) && (this.c != null))
    {
      d();
      this.c.setVisibility(8);
      d locald = this.p3;
      if (locald != null) {
        locald.b();
      }
      this.x = false;
    }
  }
  
  @Nullable
  public d getDropDownListener()
  {
    return this.p3;
  }
  
  public void i()
  {
    if ((!this.x) && (!this.p2) && (this.c != null))
    {
      e();
      d locald = this.p3;
      if (locald != null) {
        locald.a();
      }
      this.y.setVisibility(0);
      this.c.setVisibility(0);
      this.x = true;
    }
  }
  
  public boolean l()
  {
    return this.x;
  }
  
  public void setDropDownListener(d paramd)
  {
    this.p3 = paramd;
  }
  
  public void setExpandedView(@NonNull View paramView)
  {
    this.c = paramView;
    int i = this.q.getChildCount();
    int j = 1;
    if (i > 1) {
      while (j < this.q.getChildCount())
      {
        this.q.removeViewAt(j);
        j++;
      }
    }
    this.q.addView(paramView);
    if (this.x) {
      j = 0;
    } else {
      j = 8;
    }
    paramView.setVisibility(j);
  }
  
  public void setHeaderView(@NonNull View paramView)
  {
    this.d = paramView;
    if (this.f.getChildCount() > 0) {
      for (int i = 0; i < this.f.getChildCount(); i++) {
        this.f.removeViewAt(i);
      }
    }
    this.f.addView(paramView);
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      super.onAnimationEnd(paramAnimator);
      DropDownView.a(DropDownView.this).setVisibility(8);
      DropDownView.a(DropDownView.this).setAlpha(1.0F);
    }
  }
  
  class b
    extends DropDownView.e
  {
    b() {}
    
    public void onTransitionEnd(Transition paramTransition)
    {
      super.onTransitionEnd(paramTransition);
      DropDownView.b(DropDownView.this, false);
    }
    
    public void onTransitionStart(Transition paramTransition)
    {
      super.onTransitionStart(paramTransition);
      DropDownView.b(DropDownView.this, true);
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (DropDownView.c(DropDownView.this)) {
        DropDownView.this.g();
      } else {
        DropDownView.this.i();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  @TargetApi(19)
  static class e
    implements Transition.TransitionListener
  {
    public void onTransitionCancel(Transition paramTransition) {}
    
    public void onTransitionEnd(Transition paramTransition) {}
    
    public void onTransitionPause(Transition paramTransition) {}
    
    public void onTransitionResume(Transition paramTransition) {}
    
    public void onTransitionStart(Transition paramTransition) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\DropDownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */