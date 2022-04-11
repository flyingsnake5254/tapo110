package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.scwang.smart.refresh.layout.c.g;
import com.scwang.smart.refresh.layout.c.h;
import com.scwang.smart.refresh.layout.c.i;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper;
import com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper;

@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout
  extends ViewGroup
  implements com.scwang.smart.refresh.layout.a.f, NestedScrollingParent
{
  protected static com.scwang.smart.refresh.layout.c.b c;
  protected static com.scwang.smart.refresh.layout.c.c d;
  protected static com.scwang.smart.refresh.layout.c.d f;
  protected static ViewGroup.MarginLayoutParams q = new ViewGroup.MarginLayoutParams(-1, -1);
  protected com.scwang.smart.refresh.layout.c.f A4;
  protected i B4;
  protected int C4;
  protected boolean D4;
  protected int[] E4 = new int[2];
  protected NestedScrollingChildHelper F4 = new NestedScrollingChildHelper(this);
  protected NestedScrollingParentHelper G4 = new NestedScrollingParentHelper(this);
  protected float H3;
  protected int H4;
  protected float I3;
  protected com.scwang.smart.refresh.layout.constant.a I4;
  protected float J3;
  protected int J4;
  protected float K3;
  protected com.scwang.smart.refresh.layout.constant.a K4;
  protected float L3 = 0.5F;
  protected int L4;
  protected char M3 = (char)110;
  protected int M4;
  protected boolean N3;
  protected float N4;
  protected boolean O3;
  protected float O4;
  protected boolean P3;
  protected float P4;
  protected int Q3 = -1;
  protected float Q4;
  protected int R3 = -1;
  protected float R4;
  protected int S3 = -1;
  protected com.scwang.smart.refresh.layout.a.a S4;
  protected int T3 = -1;
  protected com.scwang.smart.refresh.layout.a.a T4;
  protected int U3;
  protected com.scwang.smart.refresh.layout.a.b U4;
  protected int V3;
  protected Paint V4;
  protected int W3;
  protected Handler W4;
  protected Scroller X3;
  protected com.scwang.smart.refresh.layout.a.e X4;
  protected VelocityTracker Y3;
  protected RefreshState Y4;
  protected Interpolator Z3;
  protected RefreshState Z4;
  protected int[] a4;
  protected long a5;
  protected boolean b4 = true;
  protected int b5;
  protected boolean c4 = false;
  protected int c5;
  protected boolean d4 = true;
  protected boolean d5;
  protected boolean e4 = true;
  protected boolean e5;
  protected boolean f4 = true;
  protected boolean f5;
  protected boolean g4 = true;
  protected boolean g5;
  protected boolean h4 = false;
  protected boolean h5;
  protected boolean i4 = true;
  protected MotionEvent i5;
  protected boolean j4 = true;
  protected Runnable j5;
  protected boolean k4 = false;
  protected ValueAnimator k5;
  protected boolean l4 = true;
  protected boolean m4 = false;
  protected boolean n4 = true;
  protected boolean o4 = true;
  protected int p0;
  protected int p1 = 300;
  protected int p2 = 300;
  protected int p3;
  protected boolean p4 = true;
  protected boolean q4 = true;
  protected boolean r4 = false;
  protected boolean s4 = false;
  protected boolean t4 = false;
  protected boolean u4 = false;
  protected boolean v4 = false;
  protected boolean w4 = false;
  protected int x;
  protected boolean x4 = false;
  protected int y;
  protected g y4;
  protected int z;
  protected com.scwang.smart.refresh.layout.c.e z4;
  
  public SmartRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmartRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = com.scwang.smart.refresh.layout.constant.a.a;
    this.I4 = ((com.scwang.smart.refresh.layout.constant.a)localObject);
    this.K4 = ((com.scwang.smart.refresh.layout.constant.a)localObject);
    this.N4 = 2.5F;
    this.O4 = 2.5F;
    this.P4 = 1.0F;
    this.Q4 = 1.0F;
    this.R4 = 0.16666667F;
    this.X4 = new l();
    localObject = RefreshState.None;
    this.Y4 = ((RefreshState)localObject);
    this.Z4 = ((RefreshState)localObject);
    this.a5 = 0L;
    this.b5 = 0;
    this.c5 = 0;
    this.g5 = false;
    this.h5 = false;
    this.i5 = null;
    localObject = ViewConfiguration.get(paramContext);
    this.W4 = new Handler(Looper.getMainLooper());
    this.X3 = new Scroller(paramContext);
    this.Y3 = VelocityTracker.obtain();
    this.p3 = paramContext.getResources().getDisplayMetrics().heightPixels;
    this.Z3 = new com.scwang.smart.refresh.layout.d.b(com.scwang.smart.refresh.layout.d.b.a);
    this.x = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.U3 = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
    this.V3 = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
    this.J4 = com.scwang.smart.refresh.layout.d.b.c(60.0F);
    this.H4 = com.scwang.smart.refresh.layout.d.b.c(100.0F);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout);
    if (!paramAttributeSet.hasValue(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_android_clipToPadding)) {
      super.setClipToPadding(false);
    }
    if (!paramAttributeSet.hasValue(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_android_clipChildren)) {
      super.setClipChildren(false);
    }
    localObject = f;
    if (localObject != null) {
      ((com.scwang.smart.refresh.layout.c.d)localObject).a(paramContext, this);
    }
    this.L3 = paramAttributeSet.getFloat(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlDragRate, this.L3);
    this.N4 = paramAttributeSet.getFloat(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlHeaderMaxDragRate, this.N4);
    this.O4 = paramAttributeSet.getFloat(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlFooterMaxDragRate, this.O4);
    this.P4 = paramAttributeSet.getFloat(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlHeaderTriggerRate, this.P4);
    this.Q4 = paramAttributeSet.getFloat(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlFooterTriggerRate, this.Q4);
    this.b4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableRefresh, this.b4);
    this.p2 = paramAttributeSet.getInt(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlReboundDuration, this.p2);
    int i = com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableLoadMore;
    this.c4 = paramAttributeSet.getBoolean(i, this.c4);
    int j = com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlHeaderHeight;
    this.H4 = paramAttributeSet.getDimensionPixelOffset(j, this.H4);
    int k = com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlFooterHeight;
    this.J4 = paramAttributeSet.getDimensionPixelOffset(k, this.J4);
    this.L4 = paramAttributeSet.getDimensionPixelOffset(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlHeaderInsetStart, this.L4);
    this.M4 = paramAttributeSet.getDimensionPixelOffset(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlFooterInsetStart, this.M4);
    this.r4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlDisableContentWhenRefresh, this.r4);
    this.s4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlDisableContentWhenLoading, this.s4);
    int m = com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableHeaderTranslationContent;
    this.f4 = paramAttributeSet.getBoolean(m, this.f4);
    int n = com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableFooterTranslationContent;
    this.g4 = paramAttributeSet.getBoolean(n, this.g4);
    this.i4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnablePreviewInEditMode, this.i4);
    this.l4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableAutoLoadMore, this.l4);
    this.j4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableOverScrollBounce, this.j4);
    this.m4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnablePureScrollMode, this.m4);
    this.n4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.n4);
    this.o4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.o4);
    this.p4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.p4);
    boolean bool = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.h4);
    this.h4 = bool;
    this.h4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, bool);
    this.d4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.d4);
    this.e4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.e4);
    this.k4 = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableOverScrollDrag, this.k4);
    this.Q3 = paramAttributeSet.getResourceId(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlFixedHeaderViewId, this.Q3);
    this.R3 = paramAttributeSet.getResourceId(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlFixedFooterViewId, this.R3);
    this.S3 = paramAttributeSet.getResourceId(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlHeaderTranslationViewId, this.S3);
    this.T3 = paramAttributeSet.getResourceId(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlFooterTranslationViewId, this.T3);
    bool = paramAttributeSet.getBoolean(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlEnableNestedScrolling, this.q4);
    this.q4 = bool;
    this.F4.setNestedScrollingEnabled(bool);
    if ((!this.v4) && (!paramAttributeSet.hasValue(i))) {
      bool = false;
    } else {
      bool = true;
    }
    this.v4 = bool;
    if ((!this.w4) && (!paramAttributeSet.hasValue(m))) {
      bool = false;
    } else {
      bool = true;
    }
    this.w4 = bool;
    if ((!this.x4) && (!paramAttributeSet.hasValue(n))) {
      bool = false;
    } else {
      bool = true;
    }
    this.x4 = bool;
    if (paramAttributeSet.hasValue(j)) {
      paramContext = com.scwang.smart.refresh.layout.constant.a.g;
    } else {
      paramContext = this.I4;
    }
    this.I4 = paramContext;
    if (paramAttributeSet.hasValue(k)) {
      paramContext = com.scwang.smart.refresh.layout.constant.a.g;
    } else {
      paramContext = this.K4;
    }
    this.K4 = paramContext;
    m = paramAttributeSet.getColor(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlAccentColor, 0);
    i = paramAttributeSet.getColor(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_srlPrimaryColor, 0);
    if (i != 0)
    {
      if (m != 0) {
        this.a4 = new int[] { i, m };
      } else {
        this.a4 = new int[] { i };
      }
    }
    else if (m != 0) {
      this.a4 = new int[] { 0, m };
    }
    if ((this.m4) && (!this.v4) && (!this.c4)) {
      this.c4 = true;
    }
    paramAttributeSet.recycle();
  }
  
  public static void setDefaultRefreshFooterCreator(@NonNull com.scwang.smart.refresh.layout.c.b paramb)
  {
    c = paramb;
  }
  
  public static void setDefaultRefreshHeaderCreator(@NonNull com.scwang.smart.refresh.layout.c.c paramc)
  {
    d = paramc;
  }
  
  public static void setDefaultRefreshInitializer(@NonNull com.scwang.smart.refresh.layout.c.d paramd)
  {
    f = paramd;
  }
  
  protected void A(float paramFloat)
  {
    if ((this.D4) && (!this.p4) && (paramFloat < 0.0F) && (!this.U4.k())) {
      paramFloat = 0.0F;
    }
    int i;
    int j;
    if ((paramFloat > this.p3 * 5) && (getTag() == null))
    {
      i = com.scwang.smart.refresh.layout.b.a.srl_tag;
      if (getTag(i) == null)
      {
        float f1 = this.K3;
        j = this.p3;
        if ((f1 < j / 6.0F) && (this.J3 < j / 16.0F))
        {
          Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
          setTag(i, "你这么死拉，臣妾做不到啊！");
        }
      }
    }
    RefreshState localRefreshState = this.Y4;
    if ((localRefreshState == RefreshState.TwoLevel) && (paramFloat > 0.0F))
    {
      this.X4.c(Math.min((int)paramFloat, getMeasuredHeight()), true);
    }
    else
    {
      double d1;
      double d2;
      double d3;
      double d6;
      double d7;
      if ((localRefreshState == RefreshState.Refreshing) && (paramFloat >= 0.0F))
      {
        i = this.H4;
        if (paramFloat < i)
        {
          this.X4.c((int)paramFloat, true);
        }
        else
        {
          d1 = (this.N4 - 1.0F) * i;
          i = Math.max(this.p3 * 4 / 3, getHeight());
          j = this.H4;
          d2 = i - j;
          d3 = Math.max(0.0F, (paramFloat - j) * this.L3);
          d6 = -d3;
          d7 = d2;
          if (d2 == 0.0D) {
            d7 = 1.0D;
          }
          d7 = Math.min(d1 * (1.0D - Math.pow(100.0D, d6 / d7)), d3);
          this.X4.c((int)d7 + this.H4, true);
        }
      }
      else if ((paramFloat < 0.0F) && ((localRefreshState == RefreshState.Loading) || ((this.h4) && (this.t4) && (this.u4) && (w(this.c4))) || ((this.l4) && (!this.t4) && (w(this.c4)))))
      {
        i = this.J4;
        if (paramFloat > -i)
        {
          this.X4.c((int)paramFloat, true);
        }
        else
        {
          d6 = (this.O4 - 1.0F) * i;
          i = Math.max(this.p3 * 4 / 3, getHeight());
          j = this.J4;
          d2 = i - j;
          d1 = -Math.min(0.0F, (j + paramFloat) * this.L3);
          d3 = -d1;
          d7 = d2;
          if (d2 == 0.0D) {
            d7 = 1.0D;
          }
          d7 = -Math.min(d6 * (1.0D - Math.pow(100.0D, d3 / d7)), d1);
          this.X4.c((int)d7 - this.J4, true);
        }
      }
      else if (paramFloat >= 0.0F)
      {
        d3 = this.N4 * this.H4;
        d2 = Math.max(this.p3 / 2, getHeight());
        d6 = Math.max(0.0F, this.L3 * paramFloat);
        d1 = -d6;
        d7 = d2;
        if (d2 == 0.0D) {
          d7 = 1.0D;
        }
        d7 = Math.min(d3 * (1.0D - Math.pow(100.0D, d1 / d7)), d6);
        this.X4.c((int)d7, true);
      }
      else
      {
        d6 = this.O4 * this.J4;
        d2 = Math.max(this.p3 / 2, getHeight());
        d3 = -Math.min(0.0F, this.L3 * paramFloat);
        d1 = -d3;
        d7 = d2;
        if (d2 == 0.0D) {
          d7 = 1.0D;
        }
        d7 = -Math.min(d6 * (1.0D - Math.pow(100.0D, d1 / d7)), d3);
        this.X4.c((int)d7, true);
      }
    }
    if ((this.l4) && (!this.t4) && (w(this.c4)) && (paramFloat < 0.0F))
    {
      localRefreshState = this.Y4;
      if ((localRefreshState != RefreshState.Refreshing) && (localRefreshState != RefreshState.Loading) && (localRefreshState != RefreshState.LoadFinish))
      {
        if (this.s4)
        {
          this.j5 = null;
          this.X4.b(-this.J4);
        }
        setStateDirectLoading(false);
        this.W4.postDelayed(new f(), this.p2);
      }
    }
  }
  
  protected void B(RefreshState paramRefreshState)
  {
    RefreshState localRefreshState = this.Y4;
    if (localRefreshState != paramRefreshState)
    {
      this.Y4 = paramRefreshState;
      this.Z4 = paramRefreshState;
      com.scwang.smart.refresh.layout.a.a locala1 = this.S4;
      com.scwang.smart.refresh.layout.a.a locala2 = this.T4;
      com.scwang.smart.refresh.layout.c.f localf = this.A4;
      if (locala1 != null) {
        locala1.h(this, localRefreshState, paramRefreshState);
      }
      if (locala2 != null) {
        locala2.h(this, localRefreshState, paramRefreshState);
      }
      if (localf != null) {
        localf.h(this, localRefreshState, paramRefreshState);
      }
      if (paramRefreshState == RefreshState.LoadFinish) {
        this.g5 = false;
      }
    }
    else if (this.Z4 != localRefreshState)
    {
      this.Z4 = localRefreshState;
    }
  }
  
  protected void C()
  {
    RefreshState localRefreshState1 = this.Y4;
    Object localObject;
    if (localRefreshState1 == RefreshState.TwoLevel)
    {
      if ((this.W3 > 64536) && (this.y > getHeight() / 2))
      {
        localObject = this.X4.b(getHeight());
        if (localObject != null) {
          ((ValueAnimator)localObject).setDuration(this.p1);
        }
      }
      else if (this.N3)
      {
        this.X4.a();
      }
    }
    else
    {
      localObject = RefreshState.Loading;
      int i;
      int j;
      if ((localRefreshState1 != localObject) && ((!this.h4) || (!this.t4) || (!this.u4) || (this.y >= 0) || (!w(this.c4))))
      {
        RefreshState localRefreshState2 = this.Y4;
        localRefreshState1 = RefreshState.Refreshing;
        if (localRefreshState2 == localRefreshState1)
        {
          i = this.y;
          j = this.H4;
          if (i > j) {
            this.X4.b(j);
          } else if (i < 0) {
            this.X4.b(0);
          }
        }
        else if (localRefreshState2 == RefreshState.PullDownToRefresh)
        {
          this.X4.f(RefreshState.PullDownCanceled);
        }
        else if (localRefreshState2 == RefreshState.PullUpToLoad)
        {
          this.X4.f(RefreshState.PullUpCanceled);
        }
        else if (localRefreshState2 == RefreshState.ReleaseToRefresh)
        {
          this.X4.f(localRefreshState1);
        }
        else if (localRefreshState2 == RefreshState.ReleaseToLoad)
        {
          this.X4.f((RefreshState)localObject);
        }
        else if (localRefreshState2 == RefreshState.ReleaseToTwoLevel)
        {
          this.X4.f(RefreshState.TwoLevelReleased);
        }
        else if (localRefreshState2 == RefreshState.RefreshReleased)
        {
          if (this.k5 == null) {
            this.X4.b(this.H4);
          }
        }
        else if (localRefreshState2 == RefreshState.LoadReleased)
        {
          if (this.k5 == null) {
            this.X4.b(-this.J4);
          }
        }
        else if ((localRefreshState2 != RefreshState.LoadFinish) && (this.y != 0))
        {
          this.X4.b(0);
        }
      }
      else
      {
        j = this.y;
        i = this.J4;
        if (j < -i) {
          this.X4.b(-i);
        } else if (j > 0) {
          this.X4.b(0);
        }
      }
    }
  }
  
  public com.scwang.smart.refresh.layout.a.f D(float paramFloat)
  {
    this.L3 = paramFloat;
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f E(boolean paramBoolean)
  {
    this.v4 = true;
    this.c4 = paramBoolean;
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f F(boolean paramBoolean)
  {
    this.p4 = paramBoolean;
    com.scwang.smart.refresh.layout.a.b localb = this.U4;
    if (localb != null) {
      localb.f(paramBoolean);
    }
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f G(boolean paramBoolean)
  {
    this.b4 = paramBoolean;
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f H(float paramFloat)
  {
    this.O4 = paramFloat;
    com.scwang.smart.refresh.layout.a.a locala = this.T4;
    if ((locala != null) && (this.f5))
    {
      com.scwang.smart.refresh.layout.a.e locale = this.X4;
      int i = this.J4;
      locala.g(locale, i, (int)(i * paramFloat));
    }
    else
    {
      this.K4 = this.K4.c();
    }
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f I(float paramFloat)
  {
    this.N4 = paramFloat;
    com.scwang.smart.refresh.layout.a.a locala = this.S4;
    if ((locala != null) && (this.f5))
    {
      com.scwang.smart.refresh.layout.a.e locale = this.X4;
      int i = this.H4;
      locala.g(locale, i, (int)(paramFloat * i));
    }
    else
    {
      this.I4 = this.I4.c();
    }
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f J(float paramFloat)
  {
    this.P4 = paramFloat;
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f K(boolean paramBoolean)
  {
    Object localObject = this.Y4;
    if ((localObject == RefreshState.Refreshing) && (paramBoolean))
    {
      u();
    }
    else if ((localObject == RefreshState.Loading) && (paramBoolean))
    {
      p();
    }
    else if (this.t4 != paramBoolean)
    {
      this.t4 = paramBoolean;
      localObject = this.T4;
      if ((localObject instanceof com.scwang.smart.refresh.layout.a.c)) {
        if (((com.scwang.smart.refresh.layout.a.c)localObject).b(paramBoolean))
        {
          this.u4 = true;
          if ((this.t4) && (this.h4) && (this.y > 0) && (this.T4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a) && (w(this.c4)) && (x(this.b4, this.S4))) {
            this.T4.getView().setTranslationY(this.y);
          }
        }
        else
        {
          this.u4 = false;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Footer:");
          ((StringBuilder)localObject).append(this.T4);
          ((StringBuilder)localObject).append(" NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])");
          new RuntimeException(((StringBuilder)localObject).toString()).printStackTrace();
        }
      }
    }
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f L(com.scwang.smart.refresh.layout.c.e parame)
  {
    this.z4 = parame;
    boolean bool;
    if ((!this.c4) && ((this.v4) || (parame == null))) {
      bool = false;
    } else {
      bool = true;
    }
    this.c4 = bool;
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f M(com.scwang.smart.refresh.layout.c.f paramf)
  {
    this.A4 = paramf;
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f N(g paramg)
  {
    this.y4 = paramg;
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f O(@NonNull com.scwang.smart.refresh.layout.a.c paramc)
  {
    return P(paramc, 0, 0);
  }
  
  public com.scwang.smart.refresh.layout.a.f P(@NonNull com.scwang.smart.refresh.layout.a.c paramc, int paramInt1, int paramInt2)
  {
    Object localObject = this.T4;
    if (localObject != null) {
      super.removeView(((com.scwang.smart.refresh.layout.a.a)localObject).getView());
    }
    this.T4 = paramc;
    this.g5 = false;
    this.c5 = 0;
    this.u4 = false;
    this.e5 = false;
    this.K4 = com.scwang.smart.refresh.layout.constant.a.a;
    boolean bool;
    if ((this.v4) && (!this.c4)) {
      bool = false;
    } else {
      bool = true;
    }
    this.c4 = bool;
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = -1;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = -2;
    }
    localObject = new LayoutParams(i, paramInt1);
    ViewGroup.LayoutParams localLayoutParams = paramc.getView().getLayoutParams();
    paramc = (com.scwang.smart.refresh.layout.a.c)localObject;
    if ((localLayoutParams instanceof LayoutParams)) {
      paramc = (LayoutParams)localLayoutParams;
    }
    if (this.T4.getSpinnerStyle().h) {
      super.addView(this.T4.getView(), getChildCount(), paramc);
    } else {
      super.addView(this.T4.getView(), 0, paramc);
    }
    paramc = this.a4;
    if (paramc != null)
    {
      localObject = this.T4;
      if (localObject != null) {
        ((com.scwang.smart.refresh.layout.a.a)localObject).setPrimaryColors(paramc);
      }
    }
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f Q(@NonNull com.scwang.smart.refresh.layout.a.d paramd)
  {
    return R(paramd, 0, 0);
  }
  
  public com.scwang.smart.refresh.layout.a.f R(@NonNull com.scwang.smart.refresh.layout.a.d paramd, int paramInt1, int paramInt2)
  {
    Object localObject = this.S4;
    if (localObject != null) {
      super.removeView(((com.scwang.smart.refresh.layout.a.a)localObject).getView());
    }
    this.S4 = paramd;
    this.b5 = 0;
    this.d5 = false;
    this.I4 = com.scwang.smart.refresh.layout.constant.a.a;
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = -1;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = -2;
    }
    localObject = new LayoutParams(i, paramInt1);
    ViewGroup.LayoutParams localLayoutParams = paramd.getView().getLayoutParams();
    paramd = (com.scwang.smart.refresh.layout.a.d)localObject;
    if ((localLayoutParams instanceof LayoutParams)) {
      paramd = (LayoutParams)localLayoutParams;
    }
    if (this.S4.getSpinnerStyle().h) {
      super.addView(this.S4.getView(), getChildCount(), paramd);
    } else {
      super.addView(this.S4.getView(), 0, paramd);
    }
    paramd = this.a4;
    if (paramd != null)
    {
      localObject = this.S4;
      if (localObject != null) {
        ((com.scwang.smart.refresh.layout.a.a)localObject).setPrimaryColors(paramd);
      }
    }
    return this;
  }
  
  protected boolean S(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat == 0.0F) {
      f1 = this.W3;
    }
    paramFloat = f1;
    Object localObject;
    if (Build.VERSION.SDK_INT > 27)
    {
      paramFloat = f1;
      if (this.U4 != null)
      {
        getScaleY();
        localObject = this.U4.getView();
        paramFloat = f1;
        if (getScaleY() == -1.0F)
        {
          paramFloat = f1;
          if (((View)localObject).getScaleY() == -1.0F) {
            paramFloat = -f1;
          }
        }
      }
    }
    if (Math.abs(paramFloat) > this.U3)
    {
      int i = this.y;
      if (i * paramFloat < 0.0F)
      {
        localObject = this.Y4;
        if ((localObject != RefreshState.Refreshing) && (localObject != RefreshState.Loading) && ((i >= 0) || (!this.t4)))
        {
          if (((RefreshState)localObject).isReleaseToOpening) {
            return true;
          }
        }
        else
        {
          this.j5 = new k(paramFloat).a();
          return true;
        }
      }
      if (((paramFloat < 0.0F) && (((this.j4) && ((this.c4) || (this.k4))) || ((this.Y4 == RefreshState.Loading) && (i >= 0)) || ((this.l4) && (w(this.c4))))) || ((paramFloat > 0.0F) && (((this.j4) && (this.b4)) || (this.k4) || ((this.Y4 == RefreshState.Refreshing) && (this.y <= 0)))))
      {
        this.h5 = false;
        this.X3.fling(0, 0, 0, (int)-paramFloat, 0, 0, -2147483647, Integer.MAX_VALUE);
        this.X3.computeScrollOffset();
        invalidate();
      }
    }
    return false;
  }
  
  public com.scwang.smart.refresh.layout.a.f a(boolean paramBoolean)
  {
    setNestedScrollingEnabled(paramBoolean);
    return this;
  }
  
  public void computeScroll()
  {
    this.X3.getCurrY();
    if (this.X3.computeScrollOffset())
    {
      int i = this.X3.getFinalY();
      if (((i < 0) && ((this.b4) || (this.k4)) && (this.U4.i())) || ((i > 0) && ((this.c4) || (this.k4)) && (this.U4.k())))
      {
        if (this.h5)
        {
          float f1;
          if (i > 0) {
            f1 = -this.X3.getCurrVelocity();
          } else {
            f1 = this.X3.getCurrVelocity();
          }
          i(f1);
        }
        this.X3.forceFinished(true);
      }
      else
      {
        this.h5 = true;
        invalidate();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = 0;
    int k = 1;
    int m;
    if (i == 6) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      n = paramMotionEvent.getActionIndex();
    } else {
      n = -1;
    }
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    while (i2 < i1)
    {
      if (n != i2)
      {
        f1 += paramMotionEvent.getX(i2);
        f2 += paramMotionEvent.getY(i2);
      }
      i2++;
    }
    int n = i1;
    if (m != 0) {
      n = i1 - 1;
    }
    float f3 = n;
    f1 /= f3;
    f3 = f2 / f3;
    if (((i == 6) || (i == 5)) && (this.N3)) {
      this.I3 += f3 - this.K3;
    }
    this.J3 = f1;
    this.K3 = f3;
    if (this.D4)
    {
      m = this.C4;
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((i == 2) && (m == this.C4))
      {
        i2 = (int)this.J3;
        n = getWidth();
        f2 = this.J3;
        if (n == 0) {
          m = k;
        } else {
          m = n;
        }
        f2 /= m;
        if ((w(this.b4)) && (this.y > 0))
        {
          paramMotionEvent = this.S4;
          if ((paramMotionEvent != null) && (paramMotionEvent.n()))
          {
            this.S4.k(f2, i2, n);
            break label364;
          }
        }
        if ((w(this.c4)) && (this.y < 0))
        {
          paramMotionEvent = this.T4;
          if ((paramMotionEvent != null) && (paramMotionEvent.n())) {
            this.T4.k(f2, i2, n);
          }
        }
      }
      label364:
      return bool;
    }
    if ((isEnabled()) && ((this.b4) || (this.c4) || (this.k4)))
    {
      Object localObject1;
      if (this.d5)
      {
        localObject1 = this.Y4;
        if (((((RefreshState)localObject1).isOpening) || (((RefreshState)localObject1).isFinishing)) && (((RefreshState)localObject1).isHeader)) {}
      }
      else if (this.e5)
      {
        localObject1 = this.Y4;
        if (((((RefreshState)localObject1).isOpening) || (((RefreshState)localObject1).isFinishing)) && (((RefreshState)localObject1).isFooter)) {}
      }
      else
      {
        if (!v(i))
        {
          Object localObject2 = this.Y4;
          if (!((RefreshState)localObject2).isFinishing)
          {
            localObject1 = RefreshState.Loading;
            if (((localObject2 != localObject1) || (!this.s4)) && ((localObject2 != RefreshState.Refreshing) || (!this.r4)))
            {
              if (i != 0)
              {
                long l;
                if (i != 1)
                {
                  if (i != 2)
                  {
                    if (i != 3) {
                      break label1561;
                    }
                  }
                  else
                  {
                    float f6 = f1 - this.H3;
                    f1 = f3 - this.I3;
                    this.Y3.addMovement(paramMotionEvent);
                    f2 = f1;
                    if (!this.N3)
                    {
                      f2 = f1;
                      if (!this.P3)
                      {
                        m = this.M3;
                        f2 = f1;
                        if (m != 104)
                        {
                          f2 = f1;
                          if (this.U4 != null) {
                            if ((m != 118) && ((Math.abs(f1) < this.x) || (Math.abs(f6) >= Math.abs(f1))))
                            {
                              f2 = f1;
                              if (Math.abs(f6) >= this.x)
                              {
                                f2 = f1;
                                if (Math.abs(f6) > Math.abs(f1))
                                {
                                  f2 = f1;
                                  if (this.M3 != 'v')
                                  {
                                    this.M3 = ((char)104);
                                    f2 = f1;
                                  }
                                }
                              }
                            }
                            else
                            {
                              this.M3 = ((char)118);
                              if ((f1 > 0.0F) && ((this.y < 0) || (((this.k4) || (this.b4)) && (this.U4.i()))))
                              {
                                this.N3 = true;
                                this.I3 = (f3 - this.x);
                              }
                              else if ((f1 < 0.0F) && ((this.y > 0) || (((this.k4) || (this.c4)) && (((this.Y4 == localObject1) && (this.g5)) || (this.U4.k())))))
                              {
                                this.N3 = true;
                                this.I3 = (this.x + f3);
                              }
                              f2 = f1;
                              if (this.N3)
                              {
                                f1 = f3 - this.I3;
                                if (this.O3)
                                {
                                  paramMotionEvent.setAction(3);
                                  super.dispatchTouchEvent(paramMotionEvent);
                                }
                                localObject2 = this.X4;
                                m = this.y;
                                if ((m <= 0) && ((m != 0) || (f1 <= 0.0F))) {
                                  localObject1 = RefreshState.PullUpToLoad;
                                } else {
                                  localObject1 = RefreshState.PullDownToRefresh;
                                }
                                ((com.scwang.smart.refresh.layout.a.e)localObject2).f((RefreshState)localObject1);
                                localObject1 = getParent();
                                f2 = f1;
                                if ((localObject1 instanceof ViewGroup))
                                {
                                  ((ViewGroup)localObject1).requestDisallowInterceptTouchEvent(true);
                                  f2 = f1;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    if (this.N3)
                    {
                      n = (int)f2 + this.p0;
                      localObject1 = this.Z4;
                      if ((!((RefreshState)localObject1).isHeader) || ((n >= 0) && (this.z >= 0)))
                      {
                        m = n;
                        if (!((RefreshState)localObject1).isFooter) {
                          break label1390;
                        }
                        if (n <= 0)
                        {
                          m = n;
                          if (this.z <= 0) {
                            break label1390;
                          }
                        }
                      }
                      this.z = n;
                      l = paramMotionEvent.getEventTime();
                      if (this.i5 == null)
                      {
                        paramMotionEvent = MotionEvent.obtain(l, l, 0, this.H3 + f6, this.I3, 0);
                        this.i5 = paramMotionEvent;
                        super.dispatchTouchEvent(paramMotionEvent);
                      }
                      localObject1 = MotionEvent.obtain(l, l, 2, this.H3 + f6, this.I3 + n, 0);
                      super.dispatchTouchEvent((MotionEvent)localObject1);
                      if ((this.g5) && (f2 > this.x) && (this.y < 0)) {
                        this.g5 = false;
                      }
                      if ((n > 0) && ((this.k4) || (this.b4)) && (this.U4.i()))
                      {
                        this.K3 = f3;
                        this.I3 = f3;
                        this.p0 = 0;
                        this.X4.f(RefreshState.PullDownToRefresh);
                        m = j;
                      }
                      else if ((n < 0) && ((this.k4) || (this.c4)) && (this.U4.k()))
                      {
                        this.K3 = f3;
                        this.I3 = f3;
                        this.p0 = 0;
                        this.X4.f(RefreshState.PullUpToLoad);
                        m = j;
                      }
                      else
                      {
                        m = n;
                      }
                      paramMotionEvent = this.Z4;
                      if (((paramMotionEvent.isHeader) && (m < 0)) || ((paramMotionEvent.isFooter) && (m > 0)))
                      {
                        if (this.y != 0) {
                          A(0.0F);
                        }
                        return true;
                      }
                      if (this.i5 != null)
                      {
                        this.i5 = null;
                        ((MotionEvent)localObject1).setAction(3);
                        super.dispatchTouchEvent((MotionEvent)localObject1);
                      }
                      ((MotionEvent)localObject1).recycle();
                      label1390:
                      A(m);
                      return true;
                    }
                    if ((!this.g5) || (f2 <= this.x) || (this.y >= 0)) {
                      break label1561;
                    }
                    this.g5 = false;
                    break label1561;
                  }
                }
                else
                {
                  this.Y3.addMovement(paramMotionEvent);
                  this.Y3.computeCurrentVelocity(1000, this.V3);
                  this.W3 = ((int)this.Y3.getYVelocity());
                  S(0.0F);
                }
                this.Y3.clear();
                this.M3 = ((char)110);
                localObject1 = this.i5;
                if (localObject1 != null)
                {
                  ((MotionEvent)localObject1).recycle();
                  this.i5 = null;
                  l = paramMotionEvent.getEventTime();
                  localObject1 = MotionEvent.obtain(l, l, i, this.H3, f3, 0);
                  super.dispatchTouchEvent((MotionEvent)localObject1);
                  ((MotionEvent)localObject1).recycle();
                }
                C();
                if (this.N3)
                {
                  this.N3 = false;
                  return true;
                }
                label1561:
                return super.dispatchTouchEvent(paramMotionEvent);
              }
              this.W3 = 0;
              this.Y3.addMovement(paramMotionEvent);
              this.X3.forceFinished(true);
              this.H3 = f1;
              this.I3 = f3;
              this.z = 0;
              this.p0 = this.y;
              this.N3 = false;
              this.P3 = false;
              this.O3 = super.dispatchTouchEvent(paramMotionEvent);
              if ((this.Y4 == RefreshState.TwoLevel) && (this.I3 < getMeasuredHeight() * (1.0F - this.R4)))
              {
                this.M3 = ((char)104);
                return this.O3;
              }
              localObject1 = this.U4;
              if (localObject1 != null) {
                ((com.scwang.smart.refresh.layout.a.b)localObject1).c(paramMotionEvent);
              }
              return true;
            }
          }
        }
        return false;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Object localObject1 = this.U4;
    if (localObject1 != null) {
      localObject1 = ((com.scwang.smart.refresh.layout.a.b)localObject1).getView();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.S4;
    int i;
    int j;
    int k;
    boolean bool;
    if ((localObject2 != null) && (((com.scwang.smart.refresh.layout.a.a)localObject2).getView() == paramView)) {
      if ((w(this.b4)) && ((this.i4) || (!isInEditMode())))
      {
        if (localObject1 != null)
        {
          i = Math.max(((View)localObject1).getTop() + ((View)localObject1).getPaddingTop() + this.y, paramView.getTop());
          j = this.b5;
          k = i;
          if (j != 0)
          {
            localObject2 = this.V4;
            k = i;
            if (localObject2 != null)
            {
              ((Paint)localObject2).setColor(j);
              if (this.S4.getSpinnerStyle().i) {
                i = paramView.getBottom();
              } else if (this.S4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a) {
                i = paramView.getBottom() + this.y;
              }
              paramCanvas.drawRect(0.0F, paramView.getTop(), getWidth(), i, this.V4);
              k = i;
            }
          }
          if (((this.d4) && (this.S4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.c)) || (this.S4.getSpinnerStyle().i))
          {
            paramCanvas.save();
            paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), k);
            bool = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restore();
            return bool;
          }
        }
      }
      else {
        return true;
      }
    }
    localObject2 = this.T4;
    if ((localObject2 != null) && (((com.scwang.smart.refresh.layout.a.a)localObject2).getView() == paramView)) {
      if ((w(this.c4)) && ((this.i4) || (!isInEditMode())))
      {
        if (localObject1 != null)
        {
          k = Math.min(((View)localObject1).getBottom() - ((View)localObject1).getPaddingBottom() + this.y, paramView.getBottom());
          j = this.c5;
          i = k;
          if (j != 0)
          {
            localObject1 = this.V4;
            i = k;
            if (localObject1 != null)
            {
              ((Paint)localObject1).setColor(j);
              if (this.T4.getSpinnerStyle().i)
              {
                i = paramView.getTop();
              }
              else
              {
                i = k;
                if (this.T4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a) {
                  i = paramView.getTop() + this.y;
                }
              }
              paramCanvas.drawRect(0.0F, i, getWidth(), paramView.getBottom(), this.V4);
            }
          }
          if (((this.e4) && (this.T4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.c)) || (this.T4.getSpinnerStyle().i))
          {
            paramCanvas.save();
            paramCanvas.clipRect(paramView.getLeft(), i, paramView.getRight(), paramView.getBottom());
            bool = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restore();
            return bool;
          }
        }
      }
      else {
        return true;
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  @NonNull
  public ViewGroup getLayout()
  {
    return this;
  }
  
  public int getNestedScrollAxes()
  {
    return this.G4.getNestedScrollAxes();
  }
  
  @Nullable
  public com.scwang.smart.refresh.layout.a.c getRefreshFooter()
  {
    Object localObject = this.T4;
    if ((localObject instanceof com.scwang.smart.refresh.layout.a.c)) {
      localObject = (com.scwang.smart.refresh.layout.a.c)localObject;
    } else {
      localObject = null;
    }
    return (com.scwang.smart.refresh.layout.a.c)localObject;
  }
  
  @Nullable
  public com.scwang.smart.refresh.layout.a.d getRefreshHeader()
  {
    Object localObject = this.S4;
    if ((localObject instanceof com.scwang.smart.refresh.layout.a.d)) {
      localObject = (com.scwang.smart.refresh.layout.a.d)localObject;
    } else {
      localObject = null;
    }
    return (com.scwang.smart.refresh.layout.a.d)localObject;
  }
  
  @NonNull
  public RefreshState getState()
  {
    return this.Y4;
  }
  
  protected ValueAnimator h(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3)
  {
    if (this.y != paramInt1)
    {
      ValueAnimator localValueAnimator = this.k5;
      if (localValueAnimator != null)
      {
        localValueAnimator.setDuration(0L);
        this.k5.cancel();
        this.k5 = null;
      }
      this.j5 = null;
      localValueAnimator = ValueAnimator.ofInt(new int[] { this.y, paramInt1 });
      this.k5 = localValueAnimator;
      localValueAnimator.setDuration(paramInt3);
      this.k5.setInterpolator(paramInterpolator);
      this.k5.addListener(new d());
      this.k5.addUpdateListener(new e());
      this.k5.setStartDelay(paramInt2);
      this.k5.start();
      return this.k5;
    }
    return null;
  }
  
  protected void i(float paramFloat)
  {
    if (this.k5 == null)
    {
      if (paramFloat > 0.0F)
      {
        RefreshState localRefreshState = this.Y4;
        if ((localRefreshState == RefreshState.Refreshing) || (localRefreshState == RefreshState.TwoLevel))
        {
          this.j5 = new j(paramFloat, this.H4);
          return;
        }
      }
      if ((paramFloat < 0.0F) && ((this.Y4 == RefreshState.Loading) || ((this.h4) && (this.t4) && (this.u4) && (w(this.c4))) || ((this.l4) && (!this.t4) && (w(this.c4)) && (this.Y4 != RefreshState.Refreshing)))) {
        this.j5 = new j(paramFloat, -this.J4);
      } else if ((this.y == 0) && (this.j4)) {
        this.j5 = new j(paramFloat, 0);
      }
    }
  }
  
  public boolean isNestedScrollingEnabled()
  {
    boolean bool;
    if ((this.q4) && ((this.k4) || (this.b4) || (this.c4))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean j()
  {
    int i;
    if (this.f5) {
      i = 0;
    } else {
      i = 400;
    }
    int j = this.p2;
    float f1 = this.N4 / 2.0F;
    int k = this.H4;
    float f2 = k;
    int m = k;
    if (k == 0) {
      m = 1;
    }
    return k(i, j, (f1 + 0.5F) * f2 * 1.0F / m, false);
  }
  
  public boolean k(int paramInt1, final int paramInt2, final float paramFloat, final boolean paramBoolean)
  {
    if ((this.Y4 == RefreshState.None) && (w(this.b4)))
    {
      i locali = new i(paramFloat, paramInt2, paramBoolean);
      setViceState(RefreshState.Refreshing);
      if (paramInt1 > 0) {
        this.W4.postDelayed(locali, paramInt1);
      } else {
        locali.run();
      }
      return true;
    }
    return false;
  }
  
  public com.scwang.smart.refresh.layout.a.f l()
  {
    return o(true);
  }
  
  public com.scwang.smart.refresh.layout.a.f m(int paramInt)
  {
    return n(paramInt, true, false);
  }
  
  public com.scwang.smart.refresh.layout.a.f n(int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i = paramInt << 16 >> 16;
    h localh = new h(paramInt >> 16, paramBoolean2, paramBoolean1);
    if (i > 0) {
      this.W4.postDelayed(localh, i);
    } else {
      localh.run();
    }
    return this;
  }
  
  public com.scwang.smart.refresh.layout.a.f o(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a5;
    int i;
    if (paramBoolean) {
      i = Math.min(Math.max(0, 300 - (int)(l1 - l2)), 300) << 16;
    } else {
      i = 0;
    }
    return n(i, paramBoolean, false);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    boolean bool1 = true;
    this.f5 = true;
    Object localObject2;
    if (!isInEditMode())
    {
      if (this.S4 == null)
      {
        localObject1 = d;
        if (localObject1 != null)
        {
          localObject1 = ((com.scwang.smart.refresh.layout.c.c)localObject1).a(getContext(), this);
          if (localObject1 != null) {
            Q((com.scwang.smart.refresh.layout.a.d)localObject1);
          } else {
            throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
          }
        }
      }
      if (this.T4 == null)
      {
        localObject1 = c;
        if (localObject1 != null)
        {
          localObject1 = ((com.scwang.smart.refresh.layout.c.b)localObject1).a(getContext(), this);
          if (localObject1 != null) {
            O((com.scwang.smart.refresh.layout.a.c)localObject1);
          } else {
            throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
          }
        }
      }
      else
      {
        boolean bool2 = bool1;
        if (!this.c4) {
          if (!this.v4) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
        this.c4 = bool2;
      }
      int j;
      if (this.U4 == null)
      {
        int i = getChildCount();
        for (j = 0; j < i; j++)
        {
          localObject1 = getChildAt(j);
          localObject2 = this.S4;
          if ((localObject2 == null) || (localObject1 != ((com.scwang.smart.refresh.layout.a.a)localObject2).getView()))
          {
            localObject2 = this.T4;
            if ((localObject2 == null) || (localObject1 != ((com.scwang.smart.refresh.layout.a.a)localObject2).getView())) {
              this.U4 = new com.scwang.smart.refresh.layout.wrapper.a((View)localObject1);
            }
          }
        }
      }
      if (this.U4 == null)
      {
        j = com.scwang.smart.refresh.layout.d.b.c(20.0F);
        localObject1 = new TextView(getContext());
        ((TextView)localObject1).setTextColor(-39424);
        ((TextView)localObject1).setGravity(17);
        ((TextView)localObject1).setTextSize(20.0F);
        ((TextView)localObject1).setText(com.scwang.smart.refresh.layout.b.b.srl_content_empty);
        super.addView((View)localObject1, 0, new LayoutParams(-1, -1));
        localObject1 = new com.scwang.smart.refresh.layout.wrapper.a((View)localObject1);
        this.U4 = ((com.scwang.smart.refresh.layout.a.b)localObject1);
        ((com.scwang.smart.refresh.layout.a.b)localObject1).getView().setPadding(j, j, j, j);
      }
      localObject1 = findViewById(this.Q3);
      localObject2 = findViewById(this.R3);
      this.U4.d(this.B4);
      this.U4.f(this.p4);
      this.U4.e(this.X4, (View)localObject1, (View)localObject2);
      if (this.y != 0)
      {
        B(RefreshState.None);
        localObject1 = this.U4;
        this.y = 0;
        ((com.scwang.smart.refresh.layout.a.b)localObject1).j(0, this.S3, this.T3);
      }
    }
    Object localObject1 = this.a4;
    if (localObject1 != null)
    {
      localObject2 = this.S4;
      if (localObject2 != null) {
        ((com.scwang.smart.refresh.layout.a.a)localObject2).setPrimaryColors((int[])localObject1);
      }
      localObject1 = this.T4;
      if (localObject1 != null) {
        ((com.scwang.smart.refresh.layout.a.a)localObject1).setPrimaryColors(this.a4);
      }
    }
    localObject1 = this.U4;
    if (localObject1 != null) {
      super.bringChildToFront(((com.scwang.smart.refresh.layout.a.b)localObject1).getView());
    }
    localObject1 = this.S4;
    if ((localObject1 != null) && (((com.scwang.smart.refresh.layout.a.a)localObject1).getSpinnerStyle().h)) {
      super.bringChildToFront(this.S4.getView());
    }
    localObject1 = this.T4;
    if ((localObject1 != null) && (((com.scwang.smart.refresh.layout.a.a)localObject1).getSpinnerStyle().h)) {
      super.bringChildToFront(this.T4.getView());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f5 = false;
    this.v4 = true;
    this.j5 = null;
    Object localObject = this.k5;
    if (localObject != null)
    {
      ((Animator)localObject).removeAllListeners();
      this.k5.removeAllUpdateListeners();
      this.k5.setDuration(0L);
      this.k5.cancel();
      this.k5 = null;
    }
    localObject = this.S4;
    if ((localObject != null) && (this.Y4 == RefreshState.Refreshing)) {
      ((com.scwang.smart.refresh.layout.a.a)localObject).f(this, false);
    }
    localObject = this.T4;
    if ((localObject != null) && (this.Y4 == RefreshState.Loading)) {
      ((com.scwang.smart.refresh.layout.a.a)localObject).f(this, false);
    }
    if (this.y != 0) {
      this.X4.c(0, true);
    }
    RefreshState localRefreshState = this.Y4;
    localObject = RefreshState.None;
    if (localRefreshState != localObject) {
      B((RefreshState)localObject);
    }
    localObject = this.W4;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.g5 = false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = super.getChildCount();
    if (i <= 3)
    {
      int j = 0;
      int k = -1;
      Object localObject;
      for (int m = 0;; m = i1)
      {
        n = 2;
        if (j >= i) {
          break;
        }
        localObject = super.getChildAt(j);
        if ((com.scwang.smart.refresh.layout.d.b.e((View)localObject)) && ((m < 2) || (j == 1)))
        {
          n = j;
          i1 = 2;
        }
        else
        {
          n = k;
          i1 = m;
          if (!(localObject instanceof com.scwang.smart.refresh.layout.a.a))
          {
            n = k;
            i1 = m;
            if (m < 1)
            {
              if (j > 0) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              n = j;
            }
          }
        }
        j++;
        k = n;
      }
      if (k >= 0)
      {
        this.U4 = new com.scwang.smart.refresh.layout.wrapper.a(super.getChildAt(k));
        if (k == 1)
        {
          if (i == 3)
          {
            j = 0;
            break label179;
          }
          j = 0;
          break label176;
        }
        if (i == 2)
        {
          j = -1;
          n = 1;
          break label179;
        }
      }
      j = -1;
      label176:
      int n = -1;
      label179:
      for (int i1 = 0; i1 < i; i1++)
      {
        localObject = super.getChildAt(i1);
        if ((i1 != j) && ((i1 == n) || (j != -1) || (this.S4 != null) || (!(localObject instanceof com.scwang.smart.refresh.layout.a.d))))
        {
          if ((i1 == n) || ((n == -1) && ((localObject instanceof com.scwang.smart.refresh.layout.a.c))))
          {
            boolean bool;
            if ((!this.c4) && (this.v4)) {
              bool = false;
            } else {
              bool = true;
            }
            this.c4 = bool;
            if ((localObject instanceof com.scwang.smart.refresh.layout.a.c)) {
              localObject = (com.scwang.smart.refresh.layout.a.c)localObject;
            } else {
              localObject = new RefreshFooterWrapper((View)localObject);
            }
            this.T4 = ((com.scwang.smart.refresh.layout.a.a)localObject);
          }
        }
        else
        {
          if ((localObject instanceof com.scwang.smart.refresh.layout.a.d)) {
            localObject = (com.scwang.smart.refresh.layout.a.d)localObject;
          } else {
            localObject = new RefreshHeaderWrapper((View)localObject);
          }
          this.S4 = ((com.scwang.smart.refresh.layout.a.a)localObject);
        }
      }
      return;
    }
    throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    getPaddingBottom();
    int k = super.getChildCount();
    for (paramInt3 = 0; paramInt3 < k; paramInt3++)
    {
      View localView1 = super.getChildAt(paramInt3);
      if ((localView1.getVisibility() != 8) && (!"GONE".equals(localView1.getTag(com.scwang.smart.refresh.layout.b.a.srl_tag))))
      {
        Object localObject = this.U4;
        int m = 1;
        View localView2;
        int n;
        int i1;
        int i2;
        int i3;
        if ((localObject != null) && (((com.scwang.smart.refresh.layout.a.b)localObject).getView() == localView1))
        {
          if ((isInEditMode()) && (this.i4) && (w(this.b4)) && (this.S4 != null)) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          localView2 = this.U4.getView();
          localObject = localView2.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
            localObject = (ViewGroup.MarginLayoutParams)localObject;
          } else {
            localObject = q;
          }
          n = ((ViewGroup.MarginLayoutParams)localObject).leftMargin + i;
          i1 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + j;
          i2 = localView2.getMeasuredWidth();
          i3 = localView2.getMeasuredHeight() + i1;
          paramInt4 = i1;
          paramInt1 = i3;
          if (paramInt2 != 0)
          {
            paramInt4 = i1;
            paramInt1 = i3;
            if (x(this.f4, this.S4))
            {
              paramInt1 = this.H4;
              paramInt4 = i1 + paramInt1;
              paramInt1 = i3 + paramInt1;
            }
          }
          localView2.layout(n, paramInt4, i2 + n, paramInt1);
        }
        localObject = this.S4;
        if ((localObject != null) && (((com.scwang.smart.refresh.layout.a.a)localObject).getView() == localView1))
        {
          if ((isInEditMode()) && (this.i4) && (w(this.b4))) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          localView2 = this.S4.getView();
          localObject = localView2.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
            localObject = (ViewGroup.MarginLayoutParams)localObject;
          } else {
            localObject = q;
          }
          i2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          i1 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + this.L4;
          n = localView2.getMeasuredWidth();
          i3 = localView2.getMeasuredHeight() + i1;
          paramInt4 = i1;
          paramInt1 = i3;
          if (paramInt2 == 0)
          {
            paramInt4 = i1;
            paramInt1 = i3;
            if (this.S4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a)
            {
              paramInt1 = this.H4;
              paramInt4 = i1 - paramInt1;
              paramInt1 = i3 - paramInt1;
            }
          }
          localView2.layout(i2, paramInt4, n + i2, paramInt1);
        }
        localObject = this.T4;
        if ((localObject != null) && (((com.scwang.smart.refresh.layout.a.a)localObject).getView() == localView1))
        {
          if ((isInEditMode()) && (this.i4) && (w(this.c4))) {
            paramInt2 = m;
          } else {
            paramInt2 = 0;
          }
          localView1 = this.T4.getView();
          localObject = localView1.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
            localObject = (ViewGroup.MarginLayoutParams)localObject;
          } else {
            localObject = q;
          }
          com.scwang.smart.refresh.layout.constant.b localb = this.T4.getSpinnerStyle();
          m = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + getMeasuredHeight() - this.M4;
          paramInt1 = paramInt4;
          if (this.t4)
          {
            paramInt1 = paramInt4;
            if (this.u4)
            {
              paramInt1 = paramInt4;
              if (this.h4)
              {
                paramInt1 = paramInt4;
                if (this.U4 != null)
                {
                  paramInt1 = paramInt4;
                  if (this.T4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a)
                  {
                    paramInt1 = paramInt4;
                    if (w(this.c4))
                    {
                      localView2 = this.U4.getView();
                      ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
                      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        paramInt1 = ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin;
                      } else {
                        paramInt1 = 0;
                      }
                      paramInt1 = localView2.getMeasuredHeight() + (j + j + paramInt1);
                    }
                  }
                }
              }
            }
          }
          if (localb == com.scwang.smart.refresh.layout.constant.b.e)
          {
            paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).topMargin - this.M4;
          }
          else
          {
            if ((paramInt2 == 0) && (localb != com.scwang.smart.refresh.layout.constant.b.d) && (localb != com.scwang.smart.refresh.layout.constant.b.c))
            {
              paramInt2 = paramInt1;
              if (!localb.i) {
                break label836;
              }
              paramInt2 = paramInt1;
              if (this.y >= 0) {
                break label836;
              }
              if (w(this.c4)) {
                paramInt2 = -this.y;
              } else {
                paramInt2 = 0;
              }
              paramInt2 = Math.max(paramInt2, 0);
            }
            else
            {
              paramInt2 = this.J4;
            }
            paramInt2 = paramInt1 - paramInt2;
          }
          label836:
          localView1.layout(m, paramInt2, localView1.getMeasuredWidth() + m, localView1.getMeasuredHeight() + paramInt2);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    if ((isInEditMode()) && (this.i4)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = super.getChildCount();
    int k = 0;
    int n;
    for (int m = 0; k < j; m = n)
    {
      Object localObject1 = super.getChildAt(k);
      if ((((View)localObject1).getVisibility() != 8) && (!"GONE".equals(((View)localObject1).getTag(com.scwang.smart.refresh.layout.b.a.srl_tag))))
      {
        Object localObject2 = this.S4;
        n = m;
        View localView;
        Object localObject3;
        int i1;
        int i2;
        com.scwang.smart.refresh.layout.constant.a locala1;
        int i3;
        com.scwang.smart.refresh.layout.constant.a locala2;
        int i6;
        if (localObject2 != null)
        {
          n = m;
          if (((com.scwang.smart.refresh.layout.a.a)localObject2).getView() == localObject1)
          {
            localView = this.S4.getView();
            localObject3 = localView.getLayoutParams();
            if ((localObject3 instanceof ViewGroup.MarginLayoutParams)) {
              localObject2 = (ViewGroup.MarginLayoutParams)localObject3;
            } else {
              localObject2 = q;
            }
            i1 = ViewGroup.getChildMeasureSpec(paramInt1, ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin, ((ViewGroup.LayoutParams)localObject3).width);
            i2 = this.H4;
            locala1 = this.I4;
            n = i2;
            if (locala1.n < com.scwang.smart.refresh.layout.constant.a.g.n)
            {
              i3 = ((ViewGroup.LayoutParams)localObject3).height;
              if (i3 > 0)
              {
                n = ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
                i2 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
                locala2 = com.scwang.smart.refresh.layout.constant.a.e;
                if (locala1.a(locala2))
                {
                  this.H4 = (((ViewGroup.LayoutParams)localObject3).height + ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin + ((ViewGroup.MarginLayoutParams)localObject2).topMargin);
                  this.I4 = locala2;
                }
                n = i3 + n + i2;
              }
              else
              {
                n = i2;
                if (i3 == -2) {
                  if (this.S4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.e)
                  {
                    n = i2;
                    if (this.I4.o) {}
                  }
                  else
                  {
                    i6 = Math.max(View.MeasureSpec.getSize(paramInt2) - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject2).topMargin, 0);
                    localView.measure(i1, View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                    i3 = localView.getMeasuredHeight();
                    n = i2;
                    if (i3 > 0)
                    {
                      if (i3 != i6)
                      {
                        locala1 = this.I4;
                        localObject3 = com.scwang.smart.refresh.layout.constant.a.c;
                        if (locala1.a((com.scwang.smart.refresh.layout.constant.a)localObject3))
                        {
                          this.H4 = (i3 + ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin + ((ViewGroup.MarginLayoutParams)localObject2).topMargin);
                          this.I4 = ((com.scwang.smart.refresh.layout.constant.a)localObject3);
                        }
                      }
                      n = -1;
                    }
                  }
                }
              }
            }
            if (this.S4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.e)
            {
              n = View.MeasureSpec.getSize(paramInt2);
            }
            else if ((this.S4.getSpinnerStyle().i) && (i == 0))
            {
              if (w(this.b4)) {
                n = this.y;
              } else {
                n = 0;
              }
              n = Math.max(0, n);
            }
            if (n != -1) {
              localView.measure(i1, View.MeasureSpec.makeMeasureSpec(Math.max(n - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject2).topMargin, 0), 1073741824));
            }
            localObject2 = this.I4;
            if (!((com.scwang.smart.refresh.layout.constant.a)localObject2).o)
            {
              this.I4 = ((com.scwang.smart.refresh.layout.constant.a)localObject2).b();
              localObject3 = this.S4;
              localObject2 = this.X4;
              n = this.H4;
              ((com.scwang.smart.refresh.layout.a.a)localObject3).g((com.scwang.smart.refresh.layout.a.e)localObject2, n, (int)(this.N4 * n));
            }
            n = m;
            if (i != 0)
            {
              n = m;
              if (w(this.b4)) {
                n = m + localView.getMeasuredHeight();
              }
            }
          }
        }
        localObject2 = this.T4;
        if ((localObject2 != null) && (((com.scwang.smart.refresh.layout.a.a)localObject2).getView() == localObject1))
        {
          localView = this.T4.getView();
          localObject3 = localView.getLayoutParams();
          if ((localObject3 instanceof ViewGroup.MarginLayoutParams)) {
            localObject2 = (ViewGroup.MarginLayoutParams)localObject3;
          } else {
            localObject2 = q;
          }
          i1 = ViewGroup.getChildMeasureSpec(paramInt1, ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin, ((ViewGroup.LayoutParams)localObject3).width);
          i2 = this.J4;
          locala1 = this.K4;
          m = i2;
          if (locala1.n < com.scwang.smart.refresh.layout.constant.a.g.n)
          {
            i3 = ((ViewGroup.LayoutParams)localObject3).height;
            if (i3 > 0)
            {
              m = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
              i2 = ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin + (i3 + m);
              locala2 = com.scwang.smart.refresh.layout.constant.a.e;
              m = i2;
              if (locala1.a(locala2))
              {
                this.J4 = (((ViewGroup.LayoutParams)localObject3).height + ((ViewGroup.MarginLayoutParams)localObject2).topMargin + ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin);
                this.K4 = locala2;
                m = i2;
              }
            }
            else
            {
              m = i2;
              if (i3 == -2) {
                if (this.T4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.e)
                {
                  m = i2;
                  if (this.K4.o) {}
                }
                else
                {
                  i3 = Math.max(View.MeasureSpec.getSize(paramInt2) - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject2).topMargin, 0);
                  localView.measure(i1, View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
                  i6 = localView.getMeasuredHeight();
                  m = i2;
                  if (i6 > 0)
                  {
                    if (i6 != i3)
                    {
                      locala1 = this.K4;
                      localObject3 = com.scwang.smart.refresh.layout.constant.a.c;
                      if (locala1.a((com.scwang.smart.refresh.layout.constant.a)localObject3))
                      {
                        this.J4 = (i6 + ((ViewGroup.MarginLayoutParams)localObject2).topMargin + ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin);
                        this.K4 = ((com.scwang.smart.refresh.layout.constant.a)localObject3);
                      }
                    }
                    m = -1;
                  }
                }
              }
            }
          }
          if (this.T4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.e) {
            i2 = View.MeasureSpec.getSize(paramInt2);
          }
          for (;;)
          {
            break;
            i2 = m;
            if (this.T4.getSpinnerStyle().i)
            {
              i2 = m;
              if (i == 0)
              {
                if (w(this.c4)) {
                  m = -this.y;
                } else {
                  m = 0;
                }
                i2 = Math.max(0, m);
              }
            }
          }
          if (i2 != -1) {
            localView.measure(i1, View.MeasureSpec.makeMeasureSpec(Math.max(i2 - ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject2).topMargin, 0), 1073741824));
          }
          localObject2 = this.K4;
          if (!((com.scwang.smart.refresh.layout.constant.a)localObject2).o)
          {
            this.K4 = ((com.scwang.smart.refresh.layout.constant.a)localObject2).b();
            localObject3 = this.T4;
            localObject2 = this.X4;
            m = this.J4;
            ((com.scwang.smart.refresh.layout.a.a)localObject3).g((com.scwang.smart.refresh.layout.a.e)localObject2, m, (int)(this.O4 * m));
          }
          m = n;
          if (i != 0)
          {
            m = n;
            if (w(this.c4)) {
              m = n + localView.getMeasuredHeight();
            }
          }
        }
        else
        {
          m = n;
        }
        localObject2 = this.U4;
        n = m;
        if (localObject2 != null)
        {
          n = m;
          if (((com.scwang.smart.refresh.layout.a.b)localObject2).getView() == localObject1)
          {
            localView = this.U4.getView();
            localObject1 = localView.getLayoutParams();
            if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
              localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
            } else {
              localObject2 = q;
            }
            if ((this.S4 != null) && (w(this.b4)) && (x(this.f4, this.S4))) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if ((this.T4 != null) && (w(this.c4)) && (x(this.g4, this.T4))) {
              n = 1;
            } else {
              n = 0;
            }
            int i7 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin, ((ViewGroup.LayoutParams)localObject1).width);
            i3 = getPaddingTop();
            int i8 = getPaddingBottom();
            i1 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
            i6 = ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
            if ((i != 0) && (i2 != 0)) {
              i2 = this.H4;
            } else {
              i2 = 0;
            }
            if ((i != 0) && (n != 0)) {
              n = this.J4;
            } else {
              n = 0;
            }
            localView.measure(i7, ViewGroup.getChildMeasureSpec(paramInt2, i3 + i8 + i1 + i6 + i2 + n, ((ViewGroup.LayoutParams)localObject1).height));
            n = m + localView.getMeasuredHeight();
          }
        }
      }
      else
      {
        n = m;
      }
      k++;
    }
    super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), paramInt1), View.resolveSize(m, paramInt2));
    this.J3 = (getMeasuredWidth() / 2.0F);
  }
  
  public boolean onNestedFling(@NonNull View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.F4.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if (((!this.g5) || (paramFloat2 <= 0.0F)) && (!S(-paramFloat2)) && (!this.F4.dispatchNestedPreFling(paramFloat1, paramFloat2))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onNestedPreScroll(@NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt)
  {
    int i = this.C4;
    int j = 0;
    int k;
    if (paramInt2 * i > 0)
    {
      if (Math.abs(paramInt2) > Math.abs(this.C4))
      {
        k = this.C4;
        this.C4 = 0;
      }
      else
      {
        this.C4 -= paramInt2;
        k = paramInt2;
      }
      A(this.C4);
    }
    else
    {
      k = j;
      if (paramInt2 > 0)
      {
        k = j;
        if (this.g5)
        {
          k = i - paramInt2;
          this.C4 = k;
          A(k);
          k = paramInt2;
        }
      }
    }
    this.F4.dispatchNestedPreScroll(paramInt1, paramInt2 - k, paramArrayOfInt, null);
    paramArrayOfInt[1] += k;
  }
  
  public void onNestedScroll(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = this.F4.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.E4);
    paramInt1 = paramInt4 + this.E4[1];
    if ((paramInt1 < 0) && ((this.b4) || (this.k4)))
    {
      if (this.C4 == 0)
      {
        paramView = this.B4;
        if ((paramView == null) || (paramView.a(this.U4.getView()))) {}
      }
    }
    else
    {
      if ((paramInt1 <= 0) || ((!this.c4) && (!this.k4))) {
        break label221;
      }
      if (this.C4 == 0)
      {
        paramView = this.B4;
        if ((paramView != null) && (!paramView.b(this.U4.getView()))) {
          break label221;
        }
      }
    }
    paramView = this.Z4;
    if ((paramView == RefreshState.None) || (paramView.isOpening))
    {
      com.scwang.smart.refresh.layout.a.e locale = this.X4;
      if (paramInt1 > 0) {
        paramView = RefreshState.PullUpToLoad;
      } else {
        paramView = RefreshState.PullDownToRefresh;
      }
      locale.f(paramView);
      if (!bool)
      {
        paramView = getParent();
        if (paramView != null) {
          paramView.requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    paramInt1 = this.C4 - paramInt1;
    this.C4 = paramInt1;
    A(paramInt1);
    label221:
    if ((this.g5) && (paramInt2 < 0)) {
      this.g5 = false;
    }
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    this.G4.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.F4.startNestedScroll(paramInt & 0x2);
    this.C4 = this.y;
    this.D4 = true;
    v(0);
  }
  
  public boolean onStartNestedScroll(@NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    boolean bool1 = isEnabled();
    boolean bool2 = true;
    if ((bool1) && (isNestedScrollingEnabled()) && ((paramInt & 0x2) != 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (this.k4) {
        break label77;
      }
      bool1 = bool2;
      if (this.b4) {
        break label77;
      }
      if (this.c4)
      {
        bool1 = bool2;
        break label77;
      }
    }
    bool1 = false;
    label77:
    return bool1;
  }
  
  public void onStopNestedScroll(@NonNull View paramView)
  {
    this.G4.onStopNestedScroll(paramView);
    this.D4 = false;
    this.C4 = 0;
    C();
    this.F4.stopNestedScroll();
  }
  
  public com.scwang.smart.refresh.layout.a.f p()
  {
    return n(Math.min(Math.max(0, 300 - (int)(System.currentTimeMillis() - this.a5)), 300) << 16, true, true);
  }
  
  public com.scwang.smart.refresh.layout.a.f q()
  {
    return t(true);
  }
  
  public com.scwang.smart.refresh.layout.a.f r(int paramInt)
  {
    return s(paramInt, true, Boolean.FALSE);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    View localView = this.U4.h();
    if (((Build.VERSION.SDK_INT >= 21) || (!(localView instanceof AbsListView))) && (ViewCompat.isNestedScrollingEnabled(localView)))
    {
      this.P3 = paramBoolean;
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public com.scwang.smart.refresh.layout.a.f s(int paramInt, final boolean paramBoolean, final Boolean paramBoolean1)
  {
    int i = paramInt << 16 >> 16;
    paramBoolean1 = new g(paramInt >> 16, paramBoolean1, paramBoolean);
    if (i > 0) {
      this.W4.postDelayed(paramBoolean1, i);
    } else {
      paramBoolean1.run();
    }
    return this;
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.q4 = paramBoolean;
    this.F4.setNestedScrollingEnabled(paramBoolean);
  }
  
  protected void setStateDirectLoading(boolean paramBoolean)
  {
    Object localObject1 = this.Y4;
    Object localObject2 = RefreshState.Loading;
    if (localObject1 != localObject2)
    {
      this.a5 = System.currentTimeMillis();
      this.g5 = true;
      B((RefreshState)localObject2);
      localObject2 = this.z4;
      if (localObject2 != null)
      {
        if (paramBoolean) {
          ((com.scwang.smart.refresh.layout.c.e)localObject2).q(this);
        }
      }
      else if (this.A4 == null) {
        m(2000);
      }
      localObject2 = this.T4;
      int i;
      if (localObject2 != null)
      {
        i = this.J4;
        ((com.scwang.smart.refresh.layout.a.a)localObject2).i(this, i, (int)(this.O4 * i));
      }
      localObject2 = this.A4;
      if ((localObject2 != null) && ((this.T4 instanceof com.scwang.smart.refresh.layout.a.c)))
      {
        if (paramBoolean) {
          ((com.scwang.smart.refresh.layout.c.e)localObject2).q(this);
        }
        localObject1 = this.A4;
        localObject2 = (com.scwang.smart.refresh.layout.a.c)this.T4;
        i = this.J4;
        ((com.scwang.smart.refresh.layout.c.f)localObject1).r((com.scwang.smart.refresh.layout.a.c)localObject2, i, (int)(this.O4 * i));
      }
    }
  }
  
  protected void setStateLoading(final boolean paramBoolean)
  {
    b localb = new b(paramBoolean);
    B(RefreshState.LoadReleased);
    ValueAnimator localValueAnimator = this.X4.b(-this.J4);
    if (localValueAnimator != null) {
      localValueAnimator.addListener(localb);
    }
    Object localObject1 = this.T4;
    int i;
    if (localObject1 != null)
    {
      i = this.J4;
      ((com.scwang.smart.refresh.layout.a.a)localObject1).j(this, i, (int)(this.O4 * i));
    }
    localObject1 = this.A4;
    if (localObject1 != null)
    {
      Object localObject2 = this.T4;
      if ((localObject2 instanceof com.scwang.smart.refresh.layout.a.c))
      {
        localObject2 = (com.scwang.smart.refresh.layout.a.c)localObject2;
        i = this.J4;
        ((com.scwang.smart.refresh.layout.c.f)localObject1).e((com.scwang.smart.refresh.layout.a.c)localObject2, i, (int)(this.O4 * i));
      }
    }
    if (localValueAnimator == null) {
      localb.onAnimationEnd(null);
    }
  }
  
  protected void setStateRefreshing(final boolean paramBoolean)
  {
    c localc = new c(paramBoolean);
    B(RefreshState.RefreshReleased);
    ValueAnimator localValueAnimator = this.X4.b(this.H4);
    if (localValueAnimator != null) {
      localValueAnimator.addListener(localc);
    }
    Object localObject1 = this.S4;
    int i;
    if (localObject1 != null)
    {
      i = this.H4;
      ((com.scwang.smart.refresh.layout.a.a)localObject1).j(this, i, (int)(this.N4 * i));
    }
    localObject1 = this.A4;
    if (localObject1 != null)
    {
      Object localObject2 = this.S4;
      if ((localObject2 instanceof com.scwang.smart.refresh.layout.a.d))
      {
        localObject2 = (com.scwang.smart.refresh.layout.a.d)localObject2;
        i = this.H4;
        ((com.scwang.smart.refresh.layout.c.f)localObject1).d((com.scwang.smart.refresh.layout.a.d)localObject2, i, (int)(this.N4 * i));
      }
    }
    if (localValueAnimator == null) {
      localc.onAnimationEnd(null);
    }
  }
  
  protected void setViceState(RefreshState paramRefreshState)
  {
    RefreshState localRefreshState = this.Y4;
    if ((localRefreshState.isDragging) && (localRefreshState.isHeader != paramRefreshState.isHeader)) {
      B(RefreshState.None);
    }
    if (this.Z4 != paramRefreshState) {
      this.Z4 = paramRefreshState;
    }
  }
  
  public com.scwang.smart.refresh.layout.a.f t(boolean paramBoolean)
  {
    if (paramBoolean) {
      return s(Math.min(Math.max(0, 300 - (int)(System.currentTimeMillis() - this.a5)), 300) << 16, true, Boolean.FALSE);
    }
    return s(0, false, null);
  }
  
  public com.scwang.smart.refresh.layout.a.f u()
  {
    return s(Math.min(Math.max(0, 300 - (int)(System.currentTimeMillis() - this.a5)), 300) << 16, true, Boolean.TRUE);
  }
  
  protected boolean v(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0)
    {
      if (this.k5 != null)
      {
        RefreshState localRefreshState = this.Y4;
        if ((!localRefreshState.isFinishing) && (localRefreshState != RefreshState.TwoLevelReleased) && (localRefreshState != RefreshState.RefreshReleased) && (localRefreshState != RefreshState.LoadReleased))
        {
          if (localRefreshState == RefreshState.PullDownCanceled) {
            this.X4.f(RefreshState.PullDownToRefresh);
          } else if (localRefreshState == RefreshState.PullUpCanceled) {
            this.X4.f(RefreshState.PullUpToLoad);
          }
          this.k5.setDuration(0L);
          this.k5.cancel();
          this.k5 = null;
        }
        else
        {
          return true;
        }
      }
      this.j5 = null;
    }
    if (this.k5 == null) {
      bool = false;
    }
    return bool;
  }
  
  protected boolean w(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.m4)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  protected boolean x(boolean paramBoolean, @Nullable com.scwang.smart.refresh.layout.a.a parama)
  {
    if ((!paramBoolean) && (!this.m4) && (parama != null) && (parama.getSpinnerStyle() != com.scwang.smart.refresh.layout.constant.b.c)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean y()
  {
    boolean bool;
    if (this.Y4 == RefreshState.Loading) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean z()
  {
    boolean bool;
    if (this.Y4 == RefreshState.Refreshing) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 0;
    public com.scwang.smart.refresh.layout.constant.b b = null;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_Layout);
      this.a = paramContext.getColor(com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.a);
      int i = com.scwang.smart.refresh.layout.b.c.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
      if (paramContext.hasValue(i)) {
        this.b = com.scwang.smart.refresh.layout.constant.b.f[paramContext.getInt(i, com.scwang.smart.refresh.layout.constant.b.a.g)];
      }
      paramContext.recycle();
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b(boolean paramBoolean) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {
        return;
      }
      SmartRefreshLayout.this.setStateDirectLoading(paramBoolean);
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c(boolean paramBoolean) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {
        return;
      }
      SmartRefreshLayout.this.a5 = System.currentTimeMillis();
      SmartRefreshLayout.this.B(RefreshState.Refreshing);
      Object localObject = SmartRefreshLayout.this;
      paramAnimator = ((SmartRefreshLayout)localObject).y4;
      if (paramAnimator != null)
      {
        if (paramBoolean) {
          paramAnimator.m((com.scwang.smart.refresh.layout.a.f)localObject);
        }
      }
      else if (((SmartRefreshLayout)localObject).A4 == null) {
        ((SmartRefreshLayout)localObject).r(3000);
      }
      localObject = SmartRefreshLayout.this;
      paramAnimator = ((SmartRefreshLayout)localObject).S4;
      int i;
      if (paramAnimator != null)
      {
        i = ((SmartRefreshLayout)localObject).H4;
        paramAnimator.i((com.scwang.smart.refresh.layout.a.f)localObject, i, (int)(((SmartRefreshLayout)localObject).N4 * i));
      }
      paramAnimator = SmartRefreshLayout.this;
      localObject = paramAnimator.A4;
      if ((localObject != null) && ((paramAnimator.S4 instanceof com.scwang.smart.refresh.layout.a.d)))
      {
        if (paramBoolean) {
          ((g)localObject).m(paramAnimator);
        }
        SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
        localObject = localSmartRefreshLayout.A4;
        paramAnimator = (com.scwang.smart.refresh.layout.a.d)localSmartRefreshLayout.S4;
        i = localSmartRefreshLayout.H4;
        ((com.scwang.smart.refresh.layout.c.f)localObject).a(paramAnimator, i, (int)(localSmartRefreshLayout.N4 * i));
      }
    }
  }
  
  class d
    extends AnimatorListenerAdapter
  {
    d() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {
        return;
      }
      paramAnimator = SmartRefreshLayout.this;
      paramAnimator.k5 = null;
      if (paramAnimator.y == 0)
      {
        RefreshState localRefreshState1 = paramAnimator.Y4;
        localRefreshState2 = RefreshState.None;
        if ((localRefreshState1 != localRefreshState2) && (!localRefreshState1.isOpening) && (!localRefreshState1.isDragging))
        {
          paramAnimator.B(localRefreshState2);
          return;
        }
      }
      RefreshState localRefreshState2 = paramAnimator.Y4;
      if (localRefreshState2 != paramAnimator.Z4) {
        paramAnimator.setViceState(localRefreshState2);
      }
    }
  }
  
  class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      SmartRefreshLayout.this.X4.c(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), false);
    }
  }
  
  class f
    implements Runnable
  {
    f() {}
    
    public void run()
    {
      Object localObject1 = SmartRefreshLayout.this;
      Object localObject2 = ((SmartRefreshLayout)localObject1).z4;
      if (localObject2 != null) {
        ((com.scwang.smart.refresh.layout.c.e)localObject2).q((com.scwang.smart.refresh.layout.a.f)localObject1);
      } else if (((SmartRefreshLayout)localObject1).A4 == null) {
        ((SmartRefreshLayout)localObject1).m(2000);
      }
      localObject2 = SmartRefreshLayout.this;
      localObject1 = ((SmartRefreshLayout)localObject2).A4;
      if (localObject1 != null) {
        ((com.scwang.smart.refresh.layout.c.e)localObject1).q((com.scwang.smart.refresh.layout.a.f)localObject2);
      }
    }
  }
  
  class g
    implements Runnable
  {
    int c = 0;
    
    g(int paramInt, Boolean paramBoolean, boolean paramBoolean1) {}
    
    public void run()
    {
      int i = this.c;
      Object localObject1 = null;
      Object localObject2;
      Object localObject3;
      if (i == 0)
      {
        localObject2 = SmartRefreshLayout.this;
        RefreshState localRefreshState = ((SmartRefreshLayout)localObject2).Y4;
        localObject1 = RefreshState.None;
        if ((localRefreshState == localObject1) && (((SmartRefreshLayout)localObject2).Z4 == RefreshState.Refreshing))
        {
          ((SmartRefreshLayout)localObject2).Z4 = ((RefreshState)localObject1);
        }
        else
        {
          localObject3 = ((SmartRefreshLayout)localObject2).k5;
          if ((localObject3 != null) && (localRefreshState.isHeader) && ((localRefreshState.isDragging) || (localRefreshState == RefreshState.RefreshReleased)))
          {
            ((ValueAnimator)localObject3).setDuration(0L);
            SmartRefreshLayout.this.k5.cancel();
            localObject2 = SmartRefreshLayout.this;
            ((SmartRefreshLayout)localObject2).k5 = null;
            if (((SmartRefreshLayout)localObject2).X4.b(0) == null) {
              SmartRefreshLayout.this.B((RefreshState)localObject1);
            } else {
              SmartRefreshLayout.this.B(RefreshState.PullDownCanceled);
            }
          }
          else if ((localRefreshState == RefreshState.Refreshing) && (((SmartRefreshLayout)localObject2).S4 != null) && (((SmartRefreshLayout)localObject2).U4 != null))
          {
            this.c = (i + 1);
            ((SmartRefreshLayout)localObject2).W4.postDelayed(this, this.d);
            SmartRefreshLayout.this.B(RefreshState.RefreshFinish);
            if (paramBoolean1 == Boolean.FALSE) {
              SmartRefreshLayout.this.K(false);
            }
          }
        }
        if (paramBoolean1 == Boolean.TRUE) {
          SmartRefreshLayout.this.K(true);
        }
      }
      else
      {
        localObject2 = SmartRefreshLayout.this;
        i = ((SmartRefreshLayout)localObject2).S4.f((com.scwang.smart.refresh.layout.a.f)localObject2, paramBoolean);
        localObject3 = SmartRefreshLayout.this;
        localObject2 = ((SmartRefreshLayout)localObject3).A4;
        if (localObject2 != null)
        {
          localObject3 = ((SmartRefreshLayout)localObject3).S4;
          if ((localObject3 instanceof com.scwang.smart.refresh.layout.a.d)) {
            ((com.scwang.smart.refresh.layout.c.f)localObject2).o((com.scwang.smart.refresh.layout.a.d)localObject3, paramBoolean);
          }
        }
        if (i < Integer.MAX_VALUE)
        {
          localObject2 = SmartRefreshLayout.this;
          if ((((SmartRefreshLayout)localObject2).N3) || (((SmartRefreshLayout)localObject2).D4))
          {
            long l = System.currentTimeMillis();
            localObject2 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout)localObject2).N3)
            {
              float f1 = ((SmartRefreshLayout)localObject2).K3;
              ((SmartRefreshLayout)localObject2).I3 = f1;
              ((SmartRefreshLayout)localObject2).p0 = 0;
              ((SmartRefreshLayout)localObject2).N3 = false;
              SmartRefreshLayout.b((SmartRefreshLayout)localObject2, MotionEvent.obtain(l, l, 0, ((SmartRefreshLayout)localObject2).J3, f1 + ((SmartRefreshLayout)localObject2).y - ((SmartRefreshLayout)localObject2).x * 2, 0));
              localObject2 = SmartRefreshLayout.this;
              SmartRefreshLayout.c((SmartRefreshLayout)localObject2, MotionEvent.obtain(l, l, 2, ((SmartRefreshLayout)localObject2).J3, ((SmartRefreshLayout)localObject2).K3 + ((SmartRefreshLayout)localObject2).y, 0));
            }
            localObject2 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout)localObject2).D4)
            {
              ((SmartRefreshLayout)localObject2).C4 = 0;
              SmartRefreshLayout.d((SmartRefreshLayout)localObject2, MotionEvent.obtain(l, l, 1, ((SmartRefreshLayout)localObject2).J3, ((SmartRefreshLayout)localObject2).K3, 0));
              localObject2 = SmartRefreshLayout.this;
              ((SmartRefreshLayout)localObject2).D4 = false;
              ((SmartRefreshLayout)localObject2).p0 = 0;
            }
          }
          localObject2 = SmartRefreshLayout.this;
          int j = ((SmartRefreshLayout)localObject2).y;
          if (j > 0)
          {
            localObject2 = ((SmartRefreshLayout)localObject2).h(0, i, ((SmartRefreshLayout)localObject2).Z3, ((SmartRefreshLayout)localObject2).p2);
            localObject3 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout)localObject3).o4) {
              localObject1 = ((SmartRefreshLayout)localObject3).U4.g(((SmartRefreshLayout)localObject3).y);
            }
            if ((localObject2 != null) && (localObject1 != null)) {
              ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
            }
          }
          else if (j < 0)
          {
            ((SmartRefreshLayout)localObject2).h(0, i, ((SmartRefreshLayout)localObject2).Z3, ((SmartRefreshLayout)localObject2).p2);
          }
          else
          {
            ((SmartRefreshLayout)localObject2).X4.c(0, false);
            SmartRefreshLayout.this.X4.f(RefreshState.None);
          }
        }
      }
    }
  }
  
  class h
    implements Runnable
  {
    int c = 0;
    
    h(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public void run()
    {
      final int i = this.c;
      long l1 = 0L;
      int j = 1;
      Object localObject1;
      Object localObject2;
      if (i == 0)
      {
        SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
        RefreshState localRefreshState = localSmartRefreshLayout.Y4;
        localObject1 = RefreshState.None;
        if ((localRefreshState == localObject1) && (localSmartRefreshLayout.Z4 == RefreshState.Loading))
        {
          localSmartRefreshLayout.Z4 = ((RefreshState)localObject1);
        }
        else
        {
          localObject2 = localSmartRefreshLayout.k5;
          if ((localObject2 != null) && ((localRefreshState.isDragging) || (localRefreshState == RefreshState.LoadReleased)) && (localRefreshState.isFooter))
          {
            ((ValueAnimator)localObject2).setDuration(0L);
            SmartRefreshLayout.this.k5.cancel();
            localObject2 = SmartRefreshLayout.this;
            ((SmartRefreshLayout)localObject2).k5 = null;
            if (((SmartRefreshLayout)localObject2).X4.b(0) == null) {
              SmartRefreshLayout.this.B((RefreshState)localObject1);
            } else {
              SmartRefreshLayout.this.B(RefreshState.PullUpCanceled);
            }
          }
          else if ((localRefreshState == RefreshState.Loading) && (localSmartRefreshLayout.T4 != null) && (localSmartRefreshLayout.U4 != null))
          {
            this.c = (i + 1);
            localSmartRefreshLayout.W4.postDelayed(this, this.d);
            SmartRefreshLayout.this.B(RefreshState.LoadFinish);
            return;
          }
        }
        if (paramBoolean2) {
          SmartRefreshLayout.this.K(true);
        }
      }
      else
      {
        localObject1 = SmartRefreshLayout.this;
        int k = ((SmartRefreshLayout)localObject1).T4.f((com.scwang.smart.refresh.layout.a.f)localObject1, paramBoolean1);
        localObject2 = SmartRefreshLayout.this;
        localObject1 = ((SmartRefreshLayout)localObject2).A4;
        if (localObject1 != null)
        {
          localObject2 = ((SmartRefreshLayout)localObject2).T4;
          if ((localObject2 instanceof com.scwang.smart.refresh.layout.a.c)) {
            ((com.scwang.smart.refresh.layout.c.f)localObject1).c((com.scwang.smart.refresh.layout.a.c)localObject2, paramBoolean1);
          }
        }
        if (k < Integer.MAX_VALUE)
        {
          if (paramBoolean2)
          {
            localObject1 = SmartRefreshLayout.this;
            if ((((SmartRefreshLayout)localObject1).h4) && (((SmartRefreshLayout)localObject1).y < 0) && (((SmartRefreshLayout)localObject1).U4.k())) {}
          }
          else
          {
            j = 0;
          }
          localObject1 = SmartRefreshLayout.this;
          i = ((SmartRefreshLayout)localObject1).y;
          if (j != 0) {
            j = Math.max(i, -((SmartRefreshLayout)localObject1).J4);
          } else {
            j = 0;
          }
          i -= j;
          localObject1 = SmartRefreshLayout.this;
          if ((((SmartRefreshLayout)localObject1).N3) || (((SmartRefreshLayout)localObject1).D4))
          {
            long l2 = System.currentTimeMillis();
            localObject1 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout)localObject1).N3)
            {
              float f1 = ((SmartRefreshLayout)localObject1).K3;
              ((SmartRefreshLayout)localObject1).I3 = f1;
              ((SmartRefreshLayout)localObject1).p0 = (((SmartRefreshLayout)localObject1).y - i);
              ((SmartRefreshLayout)localObject1).N3 = false;
              if (((SmartRefreshLayout)localObject1).g4) {
                j = i;
              } else {
                j = 0;
              }
              float f2 = ((SmartRefreshLayout)localObject1).J3;
              float f3 = j;
              SmartRefreshLayout.e((SmartRefreshLayout)localObject1, MotionEvent.obtain(l2, l2, 0, f2, f1 + f3 + ((SmartRefreshLayout)localObject1).x * 2, 0));
              localObject1 = SmartRefreshLayout.this;
              SmartRefreshLayout.f((SmartRefreshLayout)localObject1, MotionEvent.obtain(l2, l2, 2, ((SmartRefreshLayout)localObject1).J3, ((SmartRefreshLayout)localObject1).K3 + f3, 0));
            }
            localObject1 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout)localObject1).D4)
            {
              ((SmartRefreshLayout)localObject1).C4 = 0;
              SmartRefreshLayout.g((SmartRefreshLayout)localObject1, MotionEvent.obtain(l2, l2, 1, ((SmartRefreshLayout)localObject1).J3, ((SmartRefreshLayout)localObject1).K3, 0));
              localObject1 = SmartRefreshLayout.this;
              ((SmartRefreshLayout)localObject1).D4 = false;
              ((SmartRefreshLayout)localObject1).p0 = 0;
            }
          }
          localObject2 = SmartRefreshLayout.this.W4;
          localObject1 = new a(i);
          if (SmartRefreshLayout.this.y < 0) {
            l1 = k;
          }
          ((Handler)localObject2).postDelayed((Runnable)localObject1, l1);
        }
      }
    }
    
    class a
      implements Runnable
    {
      a(int paramInt) {}
      
      public void run()
      {
        Object localObject1 = SmartRefreshLayout.this;
        if ((((SmartRefreshLayout)localObject1).n4) && (i < 0))
        {
          localObject2 = ((SmartRefreshLayout)localObject1).U4.g(((SmartRefreshLayout)localObject1).y);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            ((ValueAnimator.AnimatorUpdateListener)localObject2).onAnimationUpdate(ValueAnimator.ofInt(new int[] { 0, 0 }));
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = null;
        }
        Object localObject2 = new a();
        SmartRefreshLayout.h localh = SmartRefreshLayout.h.this;
        SmartRefreshLayout localSmartRefreshLayout = localh.x;
        int i = localSmartRefreshLayout.y;
        if (i > 0)
        {
          localObject1 = localSmartRefreshLayout.X4.b(0);
        }
        else
        {
          if ((localObject1 == null) && (i != 0))
          {
            if ((localh.f) && (localSmartRefreshLayout.h4))
            {
              int j = localSmartRefreshLayout.J4;
              if (i >= -j)
              {
                localSmartRefreshLayout.B(RefreshState.None);
              }
              else
              {
                localObject1 = localSmartRefreshLayout.X4.b(-j);
                break label280;
              }
            }
            else
            {
              localObject1 = localSmartRefreshLayout.X4.b(0);
              break label280;
            }
          }
          else
          {
            localObject1 = localSmartRefreshLayout.k5;
            if (localObject1 != null)
            {
              ((ValueAnimator)localObject1).setDuration(0L);
              SmartRefreshLayout.this.k5.cancel();
              SmartRefreshLayout.this.k5 = null;
            }
            SmartRefreshLayout.this.X4.c(0, false);
            SmartRefreshLayout.this.X4.f(RefreshState.None);
          }
          localObject1 = null;
        }
        label280:
        if (localObject1 != null) {
          ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)localObject2);
        } else {
          ((AnimatorListenerAdapter)localObject2).onAnimationEnd(null);
        }
      }
      
      class a
        extends AnimatorListenerAdapter
      {
        a() {}
        
        public void onAnimationEnd(Animator paramAnimator)
        {
          if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {
            return;
          }
          SmartRefreshLayout.h localh = SmartRefreshLayout.h.this;
          paramAnimator = localh.x;
          paramAnimator.g5 = false;
          if (localh.f) {
            paramAnimator.K(true);
          }
          paramAnimator = SmartRefreshLayout.this;
          if (paramAnimator.Y4 == RefreshState.LoadFinish) {
            paramAnimator.B(RefreshState.None);
          }
        }
      }
    }
  }
  
  class i
    implements Runnable
  {
    i(float paramFloat, int paramInt, boolean paramBoolean) {}
    
    public void run()
    {
      Object localObject = SmartRefreshLayout.this;
      if (((SmartRefreshLayout)localObject).Z4 != RefreshState.Refreshing) {
        return;
      }
      localObject = ((SmartRefreshLayout)localObject).k5;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).setDuration(0L);
        SmartRefreshLayout.this.k5.cancel();
        SmartRefreshLayout.this.k5 = null;
      }
      localObject = SmartRefreshLayout.this;
      ((SmartRefreshLayout)localObject).J3 = (((View)localObject).getMeasuredWidth() / 2.0F);
      SmartRefreshLayout.this.X4.f(RefreshState.PullDownToRefresh);
      localObject = SmartRefreshLayout.this;
      ((SmartRefreshLayout)localObject).k5 = ValueAnimator.ofInt(new int[] { ((SmartRefreshLayout)localObject).y, (int)(((SmartRefreshLayout)localObject).H4 * paramFloat) });
      SmartRefreshLayout.this.k5.setDuration(paramInt2);
      SmartRefreshLayout.this.k5.setInterpolator(new com.scwang.smart.refresh.layout.d.b(com.scwang.smart.refresh.layout.d.b.a));
      SmartRefreshLayout.this.k5.addUpdateListener(new a());
      SmartRefreshLayout.this.k5.addListener(new b());
      SmartRefreshLayout.this.k5.start();
    }
    
    class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a() {}
      
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
        if ((localSmartRefreshLayout.k5 != null) && (localSmartRefreshLayout.S4 != null)) {
          localSmartRefreshLayout.X4.c(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), true);
        }
      }
    }
    
    class b
      extends AnimatorListenerAdapter
    {
      b() {}
      
      public void onAnimationEnd(Animator paramAnimator)
      {
        if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {
          return;
        }
        SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
        localSmartRefreshLayout.k5 = null;
        if (localSmartRefreshLayout.S4 != null)
        {
          RefreshState localRefreshState = localSmartRefreshLayout.Y4;
          paramAnimator = RefreshState.ReleaseToRefresh;
          if (localRefreshState != paramAnimator) {
            localSmartRefreshLayout.X4.f(paramAnimator);
          }
          paramAnimator = SmartRefreshLayout.i.this;
          paramAnimator.q.setStateRefreshing(paramAnimator.f ^ true);
        }
        else
        {
          localSmartRefreshLayout.X4.f(RefreshState.None);
        }
      }
    }
  }
  
  protected class j
    implements Runnable
  {
    int c = 0;
    int d = 10;
    int f;
    long q;
    float x = 0.0F;
    float y;
    
    j(float paramFloat, int paramInt)
    {
      this.y = paramFloat;
      this.f = paramInt;
      this.q = AnimationUtils.currentAnimationTimeMillis();
      SmartRefreshLayout.this.W4.postDelayed(this, this.d);
      if (paramFloat > 0.0F) {
        SmartRefreshLayout.this.X4.f(RefreshState.PullDownToRefresh);
      } else {
        SmartRefreshLayout.this.X4.f(RefreshState.PullUpToLoad);
      }
    }
    
    public void run()
    {
      SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
      if ((localSmartRefreshLayout.j5 == this) && (!localSmartRefreshLayout.Y4.isFinishing))
      {
        double d1;
        int i;
        if (Math.abs(localSmartRefreshLayout.y) >= Math.abs(this.f))
        {
          if (this.f != 0)
          {
            d1 = this.y;
            i = this.c + 1;
            this.c = i;
            this.y = ((float)(d1 * Math.pow(0.44999998807907104D, i * 2)));
          }
          else
          {
            d1 = this.y;
            i = this.c + 1;
            this.c = i;
            this.y = ((float)(d1 * Math.pow(0.8500000238418579D, i * 2)));
          }
        }
        else
        {
          d1 = this.y;
          i = this.c + 1;
          this.c = i;
          this.y = ((float)(d1 * Math.pow(0.949999988079071D, i * 2)));
        }
        long l = AnimationUtils.currentAnimationTimeMillis();
        float f1 = (float)(l - this.q) * 1.0F / 1000.0F;
        f1 = this.y * f1;
        if (Math.abs(f1) >= 1.0F)
        {
          this.q = l;
          f1 = this.x + f1;
          this.x = f1;
          SmartRefreshLayout.this.A(f1);
          SmartRefreshLayout.this.W4.postDelayed(this, this.d);
        }
        else
        {
          localSmartRefreshLayout = SmartRefreshLayout.this;
          RefreshState localRefreshState = localSmartRefreshLayout.Z4;
          boolean bool = localRefreshState.isDragging;
          if ((bool) && (localRefreshState.isHeader)) {
            localSmartRefreshLayout.X4.f(RefreshState.PullDownCanceled);
          } else if ((bool) && (localRefreshState.isFooter)) {
            localSmartRefreshLayout.X4.f(RefreshState.PullUpCanceled);
          }
          localSmartRefreshLayout = SmartRefreshLayout.this;
          localSmartRefreshLayout.j5 = null;
          if (Math.abs(localSmartRefreshLayout.y) >= Math.abs(this.f))
          {
            i = Math.min(Math.max((int)com.scwang.smart.refresh.layout.d.b.i(Math.abs(SmartRefreshLayout.this.y - this.f)), 30), 100);
            localSmartRefreshLayout = SmartRefreshLayout.this;
            localSmartRefreshLayout.h(this.f, 0, localSmartRefreshLayout.Z3, i * 10);
          }
        }
      }
    }
  }
  
  protected class k
    implements Runnable
  {
    int c;
    int d = 0;
    int f = 10;
    float q;
    float x = 0.98F;
    long y = 0L;
    long z = AnimationUtils.currentAnimationTimeMillis();
    
    k(float paramFloat)
    {
      this.q = paramFloat;
      this.c = SmartRefreshLayout.this.y;
    }
    
    public Runnable a()
    {
      Object localObject1 = SmartRefreshLayout.this;
      Object localObject2 = ((SmartRefreshLayout)localObject1).Y4;
      if (((RefreshState)localObject2).isFinishing) {
        return null;
      }
      if (((SmartRefreshLayout)localObject1).y != 0)
      {
        if ((((RefreshState)localObject2).isOpening) || ((((SmartRefreshLayout)localObject1).t4) && (((SmartRefreshLayout)localObject1).h4) && (((SmartRefreshLayout)localObject1).u4) && (((SmartRefreshLayout)localObject1).w(((SmartRefreshLayout)localObject1).c4))))
        {
          localObject2 = SmartRefreshLayout.this;
          if ((((SmartRefreshLayout)localObject2).Y4 == RefreshState.Loading) || ((((SmartRefreshLayout)localObject2).t4) && (((SmartRefreshLayout)localObject2).h4) && (((SmartRefreshLayout)localObject2).u4) && (((SmartRefreshLayout)localObject2).w(((SmartRefreshLayout)localObject2).c4))))
          {
            localObject2 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout)localObject2).y < -((SmartRefreshLayout)localObject2).J4) {}
          }
          else
          {
            localObject2 = SmartRefreshLayout.this;
            if ((((SmartRefreshLayout)localObject2).Y4 != RefreshState.Refreshing) || (((SmartRefreshLayout)localObject2).y <= ((SmartRefreshLayout)localObject2).H4)) {
              break label314;
            }
          }
        }
        int i = 0;
        int j = SmartRefreshLayout.this.y;
        float f1 = this.q;
        float f2;
        for (int k = j; j * k > 0; k = (int)(k + f2))
        {
          double d1 = f1;
          double d2 = this.x;
          i++;
          f1 = (float)(d1 * Math.pow(d2, this.f * i / 10.0F));
          f2 = this.f * 1.0F / 1000.0F * f1;
          if (Math.abs(f2) < 1.0F)
          {
            localObject2 = SmartRefreshLayout.this;
            RefreshState localRefreshState = ((SmartRefreshLayout)localObject2).Y4;
            if (localRefreshState.isOpening)
            {
              localObject1 = RefreshState.Refreshing;
              if (((localRefreshState != localObject1) || (k <= ((SmartRefreshLayout)localObject2).H4)) && ((localRefreshState == localObject1) || (k >= -((SmartRefreshLayout)localObject2).J4))) {
                break;
              }
            }
            return null;
          }
        }
      }
      label314:
      this.y = AnimationUtils.currentAnimationTimeMillis();
      SmartRefreshLayout.this.W4.postDelayed(this, this.f);
      return this;
    }
    
    public void run()
    {
      SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
      if ((localSmartRefreshLayout.j5 == this) && (!localSmartRefreshLayout.Y4.isFinishing))
      {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        long l2 = this.z;
        float f1 = (float)(this.q * Math.pow(this.x, (float)(l1 - this.y) / (1000.0F / this.f)));
        this.q = f1;
        f1 *= (float)(l1 - l2) * 1.0F / 1000.0F;
        if (Math.abs(f1) > 1.0F)
        {
          this.z = l1;
          int i = (int)(this.c + f1);
          this.c = i;
          localSmartRefreshLayout = SmartRefreshLayout.this;
          if (localSmartRefreshLayout.y * i > 0)
          {
            localSmartRefreshLayout.X4.c(i, true);
            SmartRefreshLayout.this.W4.postDelayed(this, this.f);
          }
          else
          {
            localSmartRefreshLayout.j5 = null;
            localSmartRefreshLayout.X4.c(0, true);
            com.scwang.smart.refresh.layout.d.b.d(SmartRefreshLayout.this.U4.h(), (int)-this.q);
            localSmartRefreshLayout = SmartRefreshLayout.this;
            if ((localSmartRefreshLayout.g5) && (f1 > 0.0F)) {
              localSmartRefreshLayout.g5 = false;
            }
          }
        }
        else
        {
          SmartRefreshLayout.this.j5 = null;
        }
      }
    }
  }
  
  public class l
    implements com.scwang.smart.refresh.layout.a.e
  {
    public l() {}
    
    public com.scwang.smart.refresh.layout.a.e a()
    {
      SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
      if (localSmartRefreshLayout.Y4 == RefreshState.TwoLevel)
      {
        localSmartRefreshLayout.X4.f(RefreshState.TwoLevelFinish);
        if (SmartRefreshLayout.this.y == 0)
        {
          c(0, false);
          SmartRefreshLayout.this.B(RefreshState.None);
        }
        else
        {
          b(0).setDuration(SmartRefreshLayout.this.p1);
        }
      }
      return this;
    }
    
    public ValueAnimator b(int paramInt)
    {
      SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
      return localSmartRefreshLayout.h(paramInt, 0, localSmartRefreshLayout.Z3, localSmartRefreshLayout.p2);
    }
    
    public com.scwang.smart.refresh.layout.a.e c(int paramInt, boolean paramBoolean)
    {
      Object localObject1 = SmartRefreshLayout.this;
      if (((SmartRefreshLayout)localObject1).y == paramInt)
      {
        localObject1 = ((SmartRefreshLayout)localObject1).S4;
        if ((localObject1 == null) || (!((com.scwang.smart.refresh.layout.a.a)localObject1).n()))
        {
          localObject1 = SmartRefreshLayout.this.T4;
          if ((localObject1 == null) || (!((com.scwang.smart.refresh.layout.a.a)localObject1).n())) {
            return this;
          }
        }
      }
      Object localObject2 = SmartRefreshLayout.this;
      int i = ((SmartRefreshLayout)localObject2).y;
      ((SmartRefreshLayout)localObject2).y = paramInt;
      if (paramBoolean)
      {
        localObject1 = ((SmartRefreshLayout)localObject2).Z4;
        if ((((RefreshState)localObject1).isDragging) || (((RefreshState)localObject1).isOpening)) {
          if (paramInt > ((SmartRefreshLayout)localObject2).H4 * ((SmartRefreshLayout)localObject2).P4)
          {
            if (((SmartRefreshLayout)localObject2).Y4 != RefreshState.ReleaseToTwoLevel) {
              ((SmartRefreshLayout)localObject2).X4.f(RefreshState.ReleaseToRefresh);
            }
          }
          else if ((-paramInt > ((SmartRefreshLayout)localObject2).J4 * ((SmartRefreshLayout)localObject2).Q4) && (!((SmartRefreshLayout)localObject2).t4)) {
            ((SmartRefreshLayout)localObject2).X4.f(RefreshState.ReleaseToLoad);
          } else if ((paramInt < 0) && (!((SmartRefreshLayout)localObject2).t4)) {
            ((SmartRefreshLayout)localObject2).X4.f(RefreshState.PullUpToLoad);
          } else if (paramInt > 0) {
            ((SmartRefreshLayout)localObject2).X4.f(RefreshState.PullDownToRefresh);
          }
        }
      }
      Object localObject3 = SmartRefreshLayout.this;
      localObject1 = ((SmartRefreshLayout)localObject3).U4;
      int j = 1;
      int k;
      int m;
      label301:
      int n;
      int i1;
      if (localObject1 != null)
      {
        if (paramInt >= 0)
        {
          if (((SmartRefreshLayout)localObject3).x(((SmartRefreshLayout)localObject3).f4, ((SmartRefreshLayout)localObject3).S4)) {}
          for (k = paramInt;; k = 0)
          {
            m = 1;
            break label301;
            if (i >= 0) {
              break;
            }
          }
        }
        k = 0;
        m = 0;
        n = k;
        i1 = m;
        if (paramInt <= 0)
        {
          localObject1 = SmartRefreshLayout.this;
          if (((SmartRefreshLayout)localObject1).x(((SmartRefreshLayout)localObject1).g4, ((SmartRefreshLayout)localObject1).T4)) {}
          for (m = paramInt;; m = 0)
          {
            i1 = 1;
            n = m;
            break;
            n = k;
            i1 = m;
            if (i <= 0) {
              break;
            }
          }
        }
        if (i1 != 0)
        {
          localObject1 = SmartRefreshLayout.this;
          ((SmartRefreshLayout)localObject1).U4.j(n, ((SmartRefreshLayout)localObject1).S3, ((SmartRefreshLayout)localObject1).T3);
          localObject1 = SmartRefreshLayout.this;
          if ((((SmartRefreshLayout)localObject1).t4) && (((SmartRefreshLayout)localObject1).u4) && (((SmartRefreshLayout)localObject1).h4))
          {
            localObject1 = ((SmartRefreshLayout)localObject1).T4;
            if (((localObject1 instanceof com.scwang.smart.refresh.layout.a.c)) && (((com.scwang.smart.refresh.layout.a.a)localObject1).getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a))
            {
              localObject1 = SmartRefreshLayout.this;
              if (((SmartRefreshLayout)localObject1).w(((SmartRefreshLayout)localObject1).c4)) {
                SmartRefreshLayout.this.T4.getView().setTranslationY(Math.max(0, n));
              }
            }
          }
          localObject1 = SmartRefreshLayout.this;
          if (((SmartRefreshLayout)localObject1).d4)
          {
            localObject1 = ((SmartRefreshLayout)localObject1).S4;
            if ((localObject1 != null) && (((com.scwang.smart.refresh.layout.a.a)localObject1).getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.c))
            {
              m = 1;
              break label524;
            }
          }
          m = 0;
          label524:
          if ((m == 0) && (SmartRefreshLayout.this.b5 == 0)) {
            m = 0;
          } else {
            m = 1;
          }
          localObject1 = SmartRefreshLayout.this;
          if (((SmartRefreshLayout)localObject1).e4)
          {
            localObject1 = ((SmartRefreshLayout)localObject1).T4;
            if ((localObject1 != null) && (((com.scwang.smart.refresh.layout.a.a)localObject1).getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.c))
            {
              k = 1;
              break label593;
            }
          }
          k = 0;
          label593:
          if ((k == 0) && (SmartRefreshLayout.this.c5 == 0)) {
            k = 0;
          } else {
            k = 1;
          }
          if (((m != 0) && ((n >= 0) || (i > 0))) || ((k != 0) && ((n <= 0) || (i < 0)))) {
            ((View)localObject2).invalidate();
          }
        }
      }
      int i2;
      float f1;
      float f2;
      if (((paramInt >= 0) || (i > 0)) && (SmartRefreshLayout.this.S4 != null))
      {
        i2 = Math.max(paramInt, 0);
        localObject1 = SmartRefreshLayout.this;
        k = ((SmartRefreshLayout)localObject1).H4;
        i1 = (int)(k * ((SmartRefreshLayout)localObject1).N4);
        f1 = i2;
        if (k == 0) {
          m = 1;
        } else {
          m = k;
        }
        f1 = f1 * 1.0F / m;
        if ((!((SmartRefreshLayout)localObject1).w(((SmartRefreshLayout)localObject1).b4)) && ((SmartRefreshLayout.this.Y4 != RefreshState.RefreshFinish) || (paramBoolean))) {
          break label1113;
        }
        localObject1 = SmartRefreshLayout.this;
        if (i != ((SmartRefreshLayout)localObject1).y)
        {
          if (((SmartRefreshLayout)localObject1).S4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a)
          {
            SmartRefreshLayout.this.S4.getView().setTranslationY(SmartRefreshLayout.this.y);
            localObject1 = SmartRefreshLayout.this;
            if ((((SmartRefreshLayout)localObject1).b5 != 0) && (((SmartRefreshLayout)localObject1).V4 != null) && (!((SmartRefreshLayout)localObject1).x(((SmartRefreshLayout)localObject1).f4, ((SmartRefreshLayout)localObject1).S4))) {
              ((View)localObject2).invalidate();
            }
          }
          else if (SmartRefreshLayout.this.S4.getSpinnerStyle().i)
          {
            localObject3 = SmartRefreshLayout.this.S4.getView();
            localObject1 = ((View)localObject3).getLayoutParams();
            if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
              localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
            } else {
              localObject1 = SmartRefreshLayout.q;
            }
            ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject3).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(SmartRefreshLayout.this.y - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0), 1073741824));
            n = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
            m = ((ViewGroup.MarginLayoutParams)localObject1).topMargin + SmartRefreshLayout.this.L4;
            ((View)localObject3).layout(n, m, ((View)localObject3).getMeasuredWidth() + n, ((View)localObject3).getMeasuredHeight() + m);
          }
          SmartRefreshLayout.this.S4.s(paramBoolean, f1, i2, k, i1);
        }
        if ((paramBoolean) && (SmartRefreshLayout.this.S4.n()))
        {
          int i3 = (int)SmartRefreshLayout.this.J3;
          n = ((View)localObject2).getWidth();
          localObject1 = SmartRefreshLayout.this;
          f2 = ((SmartRefreshLayout)localObject1).J3;
          if (n == 0) {
            m = 1;
          } else {
            m = n;
          }
          f2 /= m;
          ((SmartRefreshLayout)localObject1).S4.k(f2, i3, n);
        }
        label1113:
        localObject3 = SmartRefreshLayout.this;
        if (i != ((SmartRefreshLayout)localObject3).y)
        {
          localObject1 = ((SmartRefreshLayout)localObject3).A4;
          if (localObject1 != null)
          {
            localObject3 = ((SmartRefreshLayout)localObject3).S4;
            if ((localObject3 instanceof com.scwang.smart.refresh.layout.a.d)) {
              ((com.scwang.smart.refresh.layout.c.f)localObject1).l((com.scwang.smart.refresh.layout.a.d)localObject3, paramBoolean, f1, i2, k, i1);
            }
          }
        }
      }
      if (((paramInt <= 0) || (i < 0)) && (SmartRefreshLayout.this.T4 != null))
      {
        n = -Math.min(paramInt, 0);
        localObject1 = SmartRefreshLayout.this;
        m = ((SmartRefreshLayout)localObject1).J4;
        i1 = (int)(m * ((SmartRefreshLayout)localObject1).O4);
        f1 = n;
        if (m == 0) {
          paramInt = 1;
        } else {
          paramInt = m;
        }
        f1 = f1 * 1.0F / paramInt;
        if ((((SmartRefreshLayout)localObject1).w(((SmartRefreshLayout)localObject1).c4)) || ((SmartRefreshLayout.this.Y4 == RefreshState.LoadFinish) && (!paramBoolean)))
        {
          localObject1 = SmartRefreshLayout.this;
          if (i != ((SmartRefreshLayout)localObject1).y)
          {
            if (((SmartRefreshLayout)localObject1).T4.getSpinnerStyle() == com.scwang.smart.refresh.layout.constant.b.a)
            {
              SmartRefreshLayout.this.T4.getView().setTranslationY(SmartRefreshLayout.this.y);
              localObject1 = SmartRefreshLayout.this;
              if ((((SmartRefreshLayout)localObject1).c5 != 0) && (((SmartRefreshLayout)localObject1).V4 != null) && (!((SmartRefreshLayout)localObject1).x(((SmartRefreshLayout)localObject1).g4, ((SmartRefreshLayout)localObject1).T4))) {
                ((View)localObject2).invalidate();
              }
            }
            else if (SmartRefreshLayout.this.T4.getSpinnerStyle().i)
            {
              localObject3 = SmartRefreshLayout.this.T4.getView();
              localObject1 = ((View)localObject3).getLayoutParams();
              if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
                localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
              } else {
                localObject1 = SmartRefreshLayout.q;
              }
              ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject3).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(-SmartRefreshLayout.this.y - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0), 1073741824));
              paramInt = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
              k = ((ViewGroup.MarginLayoutParams)localObject1).topMargin + ((View)localObject2).getMeasuredHeight() - SmartRefreshLayout.this.M4;
              ((View)localObject3).layout(paramInt, k - ((View)localObject3).getMeasuredHeight(), ((View)localObject3).getMeasuredWidth() + paramInt, k);
            }
            SmartRefreshLayout.this.T4.s(paramBoolean, f1, n, m, i1);
          }
          if ((paramBoolean) && (SmartRefreshLayout.this.T4.n()))
          {
            i2 = (int)SmartRefreshLayout.this.J3;
            k = ((View)localObject2).getWidth();
            localObject1 = SmartRefreshLayout.this;
            f2 = ((SmartRefreshLayout)localObject1).J3;
            if (k == 0) {
              paramInt = j;
            } else {
              paramInt = k;
            }
            f2 /= paramInt;
            ((SmartRefreshLayout)localObject1).T4.k(f2, i2, k);
          }
        }
        localObject2 = SmartRefreshLayout.this;
        if (i != ((SmartRefreshLayout)localObject2).y)
        {
          localObject1 = ((SmartRefreshLayout)localObject2).A4;
          if (localObject1 != null)
          {
            localObject2 = ((SmartRefreshLayout)localObject2).T4;
            if ((localObject2 instanceof com.scwang.smart.refresh.layout.a.c)) {
              ((com.scwang.smart.refresh.layout.c.f)localObject1).p((com.scwang.smart.refresh.layout.a.c)localObject2, paramBoolean, f1, n, m, i1);
            }
          }
        }
      }
      return this;
    }
    
    @NonNull
    public com.scwang.smart.refresh.layout.a.f d()
    {
      return SmartRefreshLayout.this;
    }
    
    public com.scwang.smart.refresh.layout.a.e e(@NonNull com.scwang.smart.refresh.layout.a.a parama, int paramInt)
    {
      SmartRefreshLayout localSmartRefreshLayout = SmartRefreshLayout.this;
      if ((localSmartRefreshLayout.V4 == null) && (paramInt != 0)) {
        localSmartRefreshLayout.V4 = new Paint();
      }
      if (parama.equals(SmartRefreshLayout.this.S4)) {
        SmartRefreshLayout.this.b5 = paramInt;
      } else if (parama.equals(SmartRefreshLayout.this.T4)) {
        SmartRefreshLayout.this.c5 = paramInt;
      }
      return this;
    }
    
    public com.scwang.smart.refresh.layout.a.e f(@NonNull RefreshState paramRefreshState)
    {
      RefreshState localRefreshState1;
      switch (SmartRefreshLayout.a.a[paramRefreshState.ordinal()])
      {
      default: 
        SmartRefreshLayout.this.B(paramRefreshState);
        break;
      case 12: 
        SmartRefreshLayout.this.setStateLoading(true);
        break;
      case 11: 
        SmartRefreshLayout.this.setStateRefreshing(true);
        break;
      case 10: 
        paramRefreshState = SmartRefreshLayout.this;
        if ((!paramRefreshState.Y4.isOpening) && (paramRefreshState.w(paramRefreshState.c4))) {
          SmartRefreshLayout.this.B(RefreshState.LoadReleased);
        } else {
          SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
        }
        break;
      case 9: 
        paramRefreshState = SmartRefreshLayout.this;
        if ((!paramRefreshState.Y4.isOpening) && (paramRefreshState.w(paramRefreshState.b4))) {
          SmartRefreshLayout.this.B(RefreshState.RefreshReleased);
        } else {
          SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
        }
        break;
      case 8: 
        paramRefreshState = SmartRefreshLayout.this;
        if ((!paramRefreshState.Y4.isOpening) && (paramRefreshState.w(paramRefreshState.b4))) {
          SmartRefreshLayout.this.B(RefreshState.ReleaseToTwoLevel);
        } else {
          SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
        }
        break;
      case 7: 
        paramRefreshState = SmartRefreshLayout.this;
        if (paramRefreshState.w(paramRefreshState.c4))
        {
          paramRefreshState = SmartRefreshLayout.this;
          localRefreshState1 = paramRefreshState.Y4;
          if ((!localRefreshState1.isOpening) && (!localRefreshState1.isFinishing) && ((!paramRefreshState.t4) || (!paramRefreshState.h4) || (!paramRefreshState.u4)))
          {
            paramRefreshState.B(RefreshState.ReleaseToLoad);
            break;
          }
        }
        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
        break;
      case 6: 
        paramRefreshState = SmartRefreshLayout.this;
        if ((!paramRefreshState.Y4.isOpening) && (paramRefreshState.w(paramRefreshState.b4))) {
          SmartRefreshLayout.this.B(RefreshState.ReleaseToRefresh);
        } else {
          SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
        }
        break;
      case 5: 
        paramRefreshState = SmartRefreshLayout.this;
        if (paramRefreshState.w(paramRefreshState.c4))
        {
          paramRefreshState = SmartRefreshLayout.this;
          if ((!paramRefreshState.Y4.isOpening) && ((!paramRefreshState.t4) || (!paramRefreshState.h4) || (!paramRefreshState.u4)))
          {
            paramRefreshState.B(RefreshState.PullUpCanceled);
            f(RefreshState.None);
            break;
          }
        }
        SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
        break;
      case 4: 
        paramRefreshState = SmartRefreshLayout.this;
        if ((!paramRefreshState.Y4.isOpening) && (paramRefreshState.w(paramRefreshState.b4)))
        {
          SmartRefreshLayout.this.B(RefreshState.PullDownCanceled);
          f(RefreshState.None);
        }
        else
        {
          SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
        }
        break;
      case 3: 
        paramRefreshState = SmartRefreshLayout.this;
        if (paramRefreshState.w(paramRefreshState.c4))
        {
          paramRefreshState = SmartRefreshLayout.this;
          localRefreshState1 = paramRefreshState.Y4;
          if ((!localRefreshState1.isOpening) && (!localRefreshState1.isFinishing) && ((!paramRefreshState.t4) || (!paramRefreshState.h4) || (!paramRefreshState.u4)))
          {
            paramRefreshState.B(RefreshState.PullUpToLoad);
            break;
          }
        }
        SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
        break;
      case 2: 
        paramRefreshState = SmartRefreshLayout.this;
        if ((!paramRefreshState.Y4.isOpening) && (paramRefreshState.w(paramRefreshState.b4))) {
          SmartRefreshLayout.this.B(RefreshState.PullDownToRefresh);
        } else {
          SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
        }
        break;
      case 1: 
        paramRefreshState = SmartRefreshLayout.this;
        RefreshState localRefreshState2 = paramRefreshState.Y4;
        localRefreshState1 = RefreshState.None;
        if ((localRefreshState2 != localRefreshState1) && (paramRefreshState.y == 0)) {
          paramRefreshState.B(localRefreshState1);
        } else if (paramRefreshState.y != 0) {
          b(0);
        }
        break;
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\SmartRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */