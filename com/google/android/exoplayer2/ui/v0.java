package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class v0
{
  private boolean A;
  private boolean B;
  private boolean C;
  private final StyledPlayerControlView a;
  @Nullable
  private final View b;
  @Nullable
  private final ViewGroup c;
  @Nullable
  private final ViewGroup d;
  @Nullable
  private final ViewGroup e;
  @Nullable
  private final ViewGroup f;
  @Nullable
  private final ViewGroup g;
  @Nullable
  private final ViewGroup h;
  @Nullable
  private final ViewGroup i;
  @Nullable
  private final View j;
  @Nullable
  private final View k;
  private final AnimatorSet l;
  private final AnimatorSet m;
  private final AnimatorSet n;
  private final AnimatorSet o;
  private final AnimatorSet p;
  private final ValueAnimator q;
  private final ValueAnimator r;
  private final Runnable s;
  private final Runnable t;
  private final Runnable u;
  private final Runnable v;
  private final Runnable w;
  private final View.OnLayoutChangeListener x;
  private final List<View> y;
  private int z;
  
  public v0(final StyledPlayerControlView paramStyledPlayerControlView)
  {
    this.a = paramStyledPlayerControlView;
    this.s = new z(this);
    this.t = new r(this);
    this.u = new v(this);
    this.v = new y(this);
    this.w = new s(this);
    this.x = new t(this);
    this.C = true;
    this.z = 0;
    this.y = new ArrayList();
    this.b = paramStyledPlayerControlView.findViewById(n0.exo_controls_background);
    this.c = ((ViewGroup)paramStyledPlayerControlView.findViewById(n0.exo_center_controls));
    this.e = ((ViewGroup)paramStyledPlayerControlView.findViewById(n0.exo_minimal_controls));
    ViewGroup localViewGroup = (ViewGroup)paramStyledPlayerControlView.findViewById(n0.exo_bottom_bar);
    this.d = localViewGroup;
    this.i = ((ViewGroup)paramStyledPlayerControlView.findViewById(n0.exo_time));
    View localView = paramStyledPlayerControlView.findViewById(n0.exo_progress);
    this.j = localView;
    this.f = ((ViewGroup)paramStyledPlayerControlView.findViewById(n0.exo_basic_controls));
    this.g = ((ViewGroup)paramStyledPlayerControlView.findViewById(n0.exo_extra_controls));
    this.h = ((ViewGroup)paramStyledPlayerControlView.findViewById(n0.exo_extra_controls_scroll_view));
    Object localObject1 = paramStyledPlayerControlView.findViewById(n0.exo_overflow_show);
    this.k = ((View)localObject1);
    Object localObject2 = paramStyledPlayerControlView.findViewById(n0.exo_overflow_hide);
    if ((localObject1 != null) && (localObject2 != null))
    {
      ((View)localObject1).setOnClickListener(new x(this));
      ((View)localObject2).setOnClickListener(new x(this));
    }
    localObject1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject1).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject1).addUpdateListener(new u(this));
    ((ValueAnimator)localObject1).addListener(new a());
    localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject2).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject2).addUpdateListener(new q(this));
    ((ValueAnimator)localObject2).addListener(new b());
    Object localObject3 = paramStyledPlayerControlView.getResources();
    int i1 = k0.exo_styled_bottom_bar_height;
    float f1 = ((Resources)localObject3).getDimension(i1) - ((Resources)localObject3).getDimension(k0.exo_styled_progress_bar_height);
    float f2 = ((Resources)localObject3).getDimension(i1);
    localObject3 = new AnimatorSet();
    this.l = ((AnimatorSet)localObject3);
    ((AnimatorSet)localObject3).setDuration(250L);
    ((AnimatorSet)localObject3).addListener(new c(paramStyledPlayerControlView));
    ((AnimatorSet)localObject3).play((Animator)localObject1).with(N(0.0F, f1, localView)).with(N(0.0F, f1, localViewGroup));
    localObject3 = new AnimatorSet();
    this.m = ((AnimatorSet)localObject3);
    ((AnimatorSet)localObject3).setDuration(250L);
    ((AnimatorSet)localObject3).addListener(new d(paramStyledPlayerControlView));
    ((AnimatorSet)localObject3).play(N(f1, f2, localView)).with(N(f1, f2, localViewGroup));
    localObject3 = new AnimatorSet();
    this.n = ((AnimatorSet)localObject3);
    ((AnimatorSet)localObject3).setDuration(250L);
    ((AnimatorSet)localObject3).addListener(new e(paramStyledPlayerControlView));
    ((AnimatorSet)localObject3).play((Animator)localObject1).with(N(0.0F, f2, localView)).with(N(0.0F, f2, localViewGroup));
    paramStyledPlayerControlView = new AnimatorSet();
    this.o = paramStyledPlayerControlView;
    paramStyledPlayerControlView.setDuration(250L);
    paramStyledPlayerControlView.addListener(new f());
    paramStyledPlayerControlView.play((Animator)localObject2).with(N(f1, 0.0F, localView)).with(N(f1, 0.0F, localViewGroup));
    paramStyledPlayerControlView = new AnimatorSet();
    this.p = paramStyledPlayerControlView;
    paramStyledPlayerControlView.setDuration(250L);
    paramStyledPlayerControlView.addListener(new g());
    paramStyledPlayerControlView.play((Animator)localObject2).with(N(f2, 0.0F, localView)).with(N(f2, 0.0F, localViewGroup));
    paramStyledPlayerControlView = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.q = paramStyledPlayerControlView;
    paramStyledPlayerControlView.setDuration(250L);
    paramStyledPlayerControlView.addUpdateListener(new w(this));
    paramStyledPlayerControlView.addListener(new h());
    paramStyledPlayerControlView = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.r = paramStyledPlayerControlView;
    paramStyledPlayerControlView.setDuration(250L);
    paramStyledPlayerControlView.addUpdateListener(new a0(this));
    paramStyledPlayerControlView.addListener(new i());
  }
  
  private static ObjectAnimator N(float paramFloat1, float paramFloat2, View paramView)
  {
    return ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat1, paramFloat2 });
  }
  
  private void R(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    boolean bool = e0();
    if (this.A != bool)
    {
      this.A = bool;
      paramView.post(new o(this));
    }
    if (paramInt3 - paramInt1 != paramInt7 - paramInt5) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((!this.A) && (paramInt1 != 0)) {
      paramView.post(new p(this));
    }
  }
  
  private void S()
  {
    if ((this.f != null) && (this.g != null))
    {
      int i1 = this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight();
      int i3;
      for (;;)
      {
        i2 = this.g.getChildCount();
        i3 = 0;
        if (i2 <= 1) {
          break;
        }
        i2 = this.g.getChildCount() - 2;
        localObject = this.g.getChildAt(i2);
        this.g.removeViewAt(i2);
        this.f.addView((View)localObject, 0);
      }
      Object localObject = this.k;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      int i4 = o(this.i);
      int i5 = this.f.getChildCount() - 1;
      for (int i2 = 0; i2 < i5; i2++) {
        i4 += o(this.f.getChildAt(i2));
      }
      if (i4 > i1)
      {
        localObject = this.k;
        i2 = i4;
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          i2 = i4 + o(this.k);
        }
        ArrayList localArrayList = new ArrayList();
        for (i4 = 0; i4 < i5; i4++)
        {
          localObject = this.f.getChildAt(i4);
          i2 -= o((View)localObject);
          localArrayList.add(localObject);
          if (i2 <= i1) {
            break;
          }
        }
        if (!localArrayList.isEmpty())
        {
          this.f.removeViews(0, localArrayList.size());
          for (i2 = i3; i2 < localArrayList.size(); i2++)
          {
            i4 = this.g.getChildCount();
            this.g.addView((View)localArrayList.get(i2), i4 - 1);
          }
        }
      }
      else
      {
        localObject = this.h;
        if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0) && (!this.r.isStarted()))
        {
          this.q.cancel();
          this.r.start();
        }
      }
    }
  }
  
  private void T(View paramView)
  {
    W();
    if (paramView.getId() == n0.exo_overflow_show) {
      this.q.start();
    } else if (paramView.getId() == n0.exo_overflow_hide) {
      this.r.start();
    }
  }
  
  private void U(Runnable paramRunnable, long paramLong)
  {
    if (paramLong >= 0L) {
      this.a.postDelayed(paramRunnable, paramLong);
    }
  }
  
  private void Z(int paramInt)
  {
    int i1 = this.z;
    this.z = paramInt;
    if (paramInt == 2) {
      this.a.setVisibility(8);
    } else if (i1 == 2) {
      this.a.setVisibility(0);
    }
    if (i1 != paramInt) {
      this.a.k0();
    }
  }
  
  private boolean a0(View paramView)
  {
    int i1 = paramView.getId();
    boolean bool;
    if ((i1 != n0.exo_bottom_bar) && (i1 != n0.exo_prev) && (i1 != n0.exo_next) && (i1 != n0.exo_rew) && (i1 != n0.exo_rew_with_amount) && (i1 != n0.exo_ffwd) && (i1 != n0.exo_ffwd_with_amount)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void c0()
  {
    if (!this.C)
    {
      Z(0);
      W();
      return;
    }
    int i1 = this.z;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {}
        }
        else {
          this.B = true;
        }
      }
      else {
        this.p.start();
      }
    }
    else {
      this.o.start();
    }
    W();
  }
  
  private void d0()
  {
    Object localObject = this.e;
    int i1;
    if (localObject != null)
    {
      if (this.A) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      ((ViewGroup)localObject).setVisibility(i1);
    }
    localObject = this.j;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      i1 = this.a.getResources().getDimensionPixelSize(k0.exo_styled_progress_margin_bottom);
      if (this.A) {
        i1 = 0;
      }
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i1;
      this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.j;
      if ((localObject instanceof DefaultTimeBar))
      {
        localObject = (DefaultTimeBar)localObject;
        if (this.A)
        {
          ((DefaultTimeBar)localObject).g(true);
        }
        else
        {
          i1 = this.z;
          if (i1 == 1) {
            ((DefaultTimeBar)localObject).g(false);
          } else if (i1 != 3) {
            ((DefaultTimeBar)localObject).t();
          }
        }
      }
    }
    localObject = this.y.iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((Iterator)localObject).next();
      if ((this.A) && (a0(localView))) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      localView.setVisibility(i1);
    }
  }
  
  private boolean e0()
  {
    int i1 = this.a.getWidth();
    int i2 = this.a.getPaddingLeft();
    int i3 = this.a.getPaddingRight();
    int i4 = this.a.getHeight();
    int i5 = this.a.getPaddingBottom();
    int i6 = this.a.getPaddingTop();
    int i7 = o(this.c);
    ViewGroup localViewGroup = this.c;
    boolean bool = false;
    if (localViewGroup != null) {
      i8 = localViewGroup.getPaddingLeft() + this.c.getPaddingRight();
    } else {
      i8 = 0;
    }
    int i9 = m(this.c);
    localViewGroup = this.c;
    int i10;
    if (localViewGroup != null) {
      i10 = localViewGroup.getPaddingTop() + this.c.getPaddingBottom();
    } else {
      i10 = 0;
    }
    int i8 = Math.max(i7 - i8, o(this.i) + o(this.k));
    i7 = m(this.d);
    if ((i1 - i2 - i3 <= i8) || (i4 - i5 - i6 <= i9 - i10 + i7 * 2)) {
      bool = true;
    }
    return bool;
  }
  
  private void l(float paramFloat)
  {
    ViewGroup localViewGroup = this.h;
    if (localViewGroup != null)
    {
      int i1 = (int)(localViewGroup.getWidth() * (1.0F - paramFloat));
      this.h.setTranslationX(i1);
    }
    localViewGroup = this.i;
    if (localViewGroup != null) {
      localViewGroup.setAlpha(1.0F - paramFloat);
    }
    localViewGroup = this.f;
    if (localViewGroup != null) {
      localViewGroup.setAlpha(1.0F - paramFloat);
    }
  }
  
  private static int m(@Nullable View paramView)
  {
    if (paramView == null) {
      return 0;
    }
    int i1 = paramView.getHeight();
    paramView = paramView.getLayoutParams();
    int i2 = i1;
    if ((paramView instanceof ViewGroup.MarginLayoutParams))
    {
      paramView = (ViewGroup.MarginLayoutParams)paramView;
      i2 = i1 + (paramView.topMargin + paramView.bottomMargin);
    }
    return i2;
  }
  
  private static int o(@Nullable View paramView)
  {
    if (paramView == null) {
      return 0;
    }
    int i1 = paramView.getWidth();
    paramView = paramView.getLayoutParams();
    int i2 = i1;
    if ((paramView instanceof ViewGroup.MarginLayoutParams))
    {
      paramView = (ViewGroup.MarginLayoutParams)paramView;
      i2 = i1 + (paramView.leftMargin + paramView.rightMargin);
    }
    return i2;
  }
  
  private void q()
  {
    this.n.start();
  }
  
  private void r()
  {
    Z(2);
  }
  
  private void t()
  {
    this.l.start();
    U(this.u, 2000L);
  }
  
  private void u()
  {
    this.m.start();
  }
  
  public void O()
  {
    this.a.addOnLayoutChangeListener(this.x);
  }
  
  public void P()
  {
    this.a.removeOnLayoutChangeListener(this.x);
  }
  
  public void Q(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.b;
    if (localView != null) {
      localView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public void V()
  {
    this.a.removeCallbacks(this.w);
    this.a.removeCallbacks(this.t);
    this.a.removeCallbacks(this.v);
    this.a.removeCallbacks(this.u);
  }
  
  public void W()
  {
    if (this.z == 3) {
      return;
    }
    V();
    int i1 = this.a.getShowTimeoutMs();
    if (i1 > 0) {
      if (!this.C) {
        U(this.w, i1);
      } else if (this.z == 1) {
        U(this.u, 2000L);
      } else {
        U(this.v, i1);
      }
    }
  }
  
  public void X(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void Y(@Nullable View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(8);
      this.y.remove(paramView);
      return;
    }
    if ((this.A) && (a0(paramView))) {
      paramView.setVisibility(4);
    } else {
      paramView.setVisibility(0);
    }
    this.y.add(paramView);
  }
  
  public void b0()
  {
    if (!this.a.g0())
    {
      this.a.setVisibility(0);
      this.a.u0();
      this.a.p0();
    }
    c0();
  }
  
  public boolean n(@Nullable View paramView)
  {
    boolean bool;
    if ((paramView != null) && (this.y.contains(paramView))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void p()
  {
    int i1 = this.z;
    if ((i1 != 3) && (i1 != 2))
    {
      V();
      if (!this.C) {
        r();
      } else if (this.z == 1) {
        u();
      } else {
        q();
      }
    }
  }
  
  public void s()
  {
    int i1 = this.z;
    if ((i1 != 3) && (i1 != 2))
    {
      V();
      r();
    }
  }
  
  public boolean v()
  {
    boolean bool;
    if ((this.z == 0) && (this.a.g0())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (v0.c(v0.this) != null) {
        v0.c(v0.this).setVisibility(4);
      }
      if (v0.d(v0.this) != null) {
        v0.d(v0.this).setVisibility(4);
      }
      if (v0.e(v0.this) != null) {
        v0.e(v0.this).setVisibility(4);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (((v0.a(v0.this) instanceof DefaultTimeBar)) && (!v0.b(v0.this))) {
        ((DefaultTimeBar)v0.a(v0.this)).f(250L);
      }
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b() {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      paramAnimator = v0.c(v0.this);
      int i = 0;
      if (paramAnimator != null) {
        v0.c(v0.this).setVisibility(0);
      }
      if (v0.d(v0.this) != null) {
        v0.d(v0.this).setVisibility(0);
      }
      if (v0.e(v0.this) != null)
      {
        paramAnimator = v0.e(v0.this);
        if (!v0.b(v0.this)) {
          i = 4;
        }
        paramAnimator.setVisibility(i);
      }
      if (((v0.a(v0.this) instanceof DefaultTimeBar)) && (!v0.b(v0.this))) {
        ((DefaultTimeBar)v0.a(v0.this)).u(250L);
      }
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c(StyledPlayerControlView paramStyledPlayerControlView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      v0.f(v0.this, 1);
      if (v0.g(v0.this))
      {
        paramStyledPlayerControlView.post(v0.i(v0.this));
        v0.h(v0.this, false);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      v0.f(v0.this, 3);
    }
  }
  
  class d
    extends AnimatorListenerAdapter
  {
    d(StyledPlayerControlView paramStyledPlayerControlView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      v0.f(v0.this, 2);
      if (v0.g(v0.this))
      {
        paramStyledPlayerControlView.post(v0.i(v0.this));
        v0.h(v0.this, false);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      v0.f(v0.this, 3);
    }
  }
  
  class e
    extends AnimatorListenerAdapter
  {
    e(StyledPlayerControlView paramStyledPlayerControlView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      v0.f(v0.this, 2);
      if (v0.g(v0.this))
      {
        paramStyledPlayerControlView.post(v0.i(v0.this));
        v0.h(v0.this, false);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      v0.f(v0.this, 3);
    }
  }
  
  class f
    extends AnimatorListenerAdapter
  {
    f() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      v0.f(v0.this, 0);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      v0.f(v0.this, 4);
    }
  }
  
  class g
    extends AnimatorListenerAdapter
  {
    g() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      v0.f(v0.this, 0);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      v0.f(v0.this, 4);
    }
  }
  
  class h
    extends AnimatorListenerAdapter
  {
    h() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (v0.k(v0.this) != null) {
        v0.k(v0.this).setVisibility(4);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (v0.j(v0.this) != null)
      {
        v0.j(v0.this).setVisibility(0);
        v0.j(v0.this).setTranslationX(v0.j(v0.this).getWidth());
        v0.j(v0.this).scrollTo(v0.j(v0.this).getWidth(), 0);
      }
    }
  }
  
  class i
    extends AnimatorListenerAdapter
  {
    i() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (v0.j(v0.this) != null) {
        v0.j(v0.this).setVisibility(4);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (v0.k(v0.this) != null) {
        v0.k(v0.this).setVisibility(0);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\v0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */