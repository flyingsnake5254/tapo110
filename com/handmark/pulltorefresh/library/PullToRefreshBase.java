package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.handmark.pulltorefresh.library.internal.FlipLoadingLayout;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.RotateLoadingLayout;
import com.handmark.pulltorefresh.library.internal.c;
import com.tplink.libtpcontrols.x0;

public abstract class PullToRefreshBase<T extends View>
  extends LinearLayout
{
  T H3;
  private FrameLayout I3;
  private boolean J3 = true;
  private boolean K3 = false;
  private boolean L3 = false;
  private boolean M3 = true;
  private boolean N3 = true;
  private boolean O3 = true;
  private Interpolator P3;
  private AnimationStyle Q3 = AnimationStyle.getDefault();
  private LoadingLayout R3;
  private LoadingLayout S3;
  private e<T> T3;
  private d<T> U3;
  private c<T> V3;
  private PullToRefreshBase<T>.g W3;
  private int c;
  private float d;
  private float f;
  private boolean p0 = true;
  private State p1 = State.RESET;
  private Mode p2 = Mode.getDefault();
  private Mode p3;
  private float q;
  private float x;
  private boolean y = false;
  private boolean z = false;
  
  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    l(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    l(paramContext, paramAttributeSet);
  }
  
  private void A()
  {
    float f1;
    float f2;
    if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1)
    {
      f1 = this.x;
      f2 = this.f;
    }
    else
    {
      f1 = this.q;
      f2 = this.d;
    }
    Object localObject = a.c;
    int i;
    int j;
    if (localObject[this.p3.ordinal()] != 1)
    {
      i = Math.round(Math.min(f1 - f2, 0.0F) / 2.0F);
      j = getHeaderSize();
    }
    else
    {
      i = Math.round(Math.max(f1 - f2, 0.0F) / 2.0F);
      j = getFooterSize();
    }
    setHeaderScroll(i);
    if ((i != 0) && (!r()))
    {
      f1 = Math.abs(i) / j;
      if (localObject[this.p3.ordinal()] != 1) {
        this.R3.c(f1);
      } else {
        this.S3.c(f1);
      }
      localObject = this.p1;
      State localState = State.PULL_TO_REFRESH;
      if ((localObject != localState) && (j >= Math.abs(i))) {
        E(localState, new boolean[0]);
      } else if ((this.p1 == localState) && (j < Math.abs(i))) {
        E(State.RELEASE_TO_REFRESH, new boolean[0]);
      }
    }
  }
  
  private void G(int paramInt, long paramLong)
  {
    H(paramInt, paramLong, 0L, null);
  }
  
  private void H(int paramInt, long paramLong1, long paramLong2, f paramf)
  {
    g localg = this.W3;
    if (localg != null) {
      localg.a();
    }
    int i;
    if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      i = getScrollY();
    } else {
      i = getScrollX();
    }
    if (i != paramInt)
    {
      if (this.P3 == null) {
        this.P3 = new DecelerateInterpolator();
      }
      paramf = new g(i, paramInt, paramLong1, paramf);
      this.W3 = paramf;
      if (paramLong2 > 0L) {
        postDelayed(paramf, paramLong2);
      } else {
        post(paramf);
      }
    }
  }
  
  private void b(Context paramContext, T paramT)
  {
    paramContext = new FrameLayout(paramContext);
    this.I3 = paramContext;
    paramContext.addView(paramT, -1, -1);
    d(this.I3, new LinearLayout.LayoutParams(-1, -1));
  }
  
  private void e()
  {
    Object localObject = this.T3;
    if (localObject != null)
    {
      ((e)localObject).a(this);
    }
    else
    {
      d locald = this.U3;
      if (locald != null)
      {
        localObject = this.p3;
        if (localObject == Mode.PULL_FROM_START) {
          locald.b(this);
        } else if (localObject == Mode.PULL_FROM_END) {
          locald.a(this);
        }
      }
    }
  }
  
  private LinearLayout.LayoutParams getLoadingLayoutLayoutParams()
  {
    if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      return new LinearLayout.LayoutParams(-1, -2);
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  private int getMaximumPullScroll()
  {
    if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      return Math.round(getHeight() / 2.0F);
    }
    return Math.round(getWidth() / 2.0F);
  }
  
  private void l(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      setOrientation(1);
    } else {
      setOrientation(0);
    }
    setGravity(17);
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, x0.PullToRefresh);
    int i = x0.PullToRefresh_ptrMode;
    if (localTypedArray.hasValue(i)) {
      this.p2 = Mode.mapIntToValue(localTypedArray.getInteger(i, 0));
    }
    i = x0.PullToRefresh_ptrAnimationStyle;
    if (localTypedArray.hasValue(i)) {
      this.Q3 = AnimationStyle.mapIntToValue(localTypedArray.getInteger(i, 0));
    }
    paramAttributeSet = h(paramContext, paramAttributeSet);
    this.H3 = paramAttributeSet;
    b(paramContext, paramAttributeSet);
    this.R3 = f(paramContext, Mode.PULL_FROM_START, localTypedArray);
    this.S3 = f(paramContext, Mode.PULL_FROM_END, localTypedArray);
    i = x0.PullToRefresh_ptrRefreshableViewBackground;
    if (localTypedArray.hasValue(i))
    {
      paramContext = localTypedArray.getDrawable(i);
      if (paramContext != null) {
        this.H3.setBackgroundDrawable(paramContext);
      }
    }
    else
    {
      i = x0.PullToRefresh_ptrAdapterViewBackground;
      if (localTypedArray.hasValue(i))
      {
        com.handmark.pulltorefresh.library.internal.b.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
        paramContext = localTypedArray.getDrawable(i);
        if (paramContext != null) {
          this.H3.setBackgroundDrawable(paramContext);
        }
      }
    }
    i = x0.PullToRefresh_ptrOverScroll;
    if (localTypedArray.hasValue(i)) {
      this.N3 = localTypedArray.getBoolean(i, true);
    }
    i = x0.PullToRefresh_ptrScrollingWhileRefreshingEnabled;
    if (localTypedArray.hasValue(i)) {
      this.K3 = localTypedArray.getBoolean(i, false);
    }
    i = x0.PullToRefresh_ptrInitRefreshing;
    if (localTypedArray.hasValue(i)) {
      this.z = localTypedArray.getBoolean(i, false);
    }
    i = x0.PullToRefresh_ptrChildViewClickableWhileRefreshing;
    if (localTypedArray.hasValue(i)) {
      this.L3 = localTypedArray.getBoolean(i, false);
    }
    k(localTypedArray);
    localTypedArray.recycle();
    J();
  }
  
  private boolean o()
  {
    int i = a.c[this.p2.ordinal()];
    boolean bool1 = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          return false;
        }
        boolean bool2 = bool1;
        if (!p()) {
          if (q()) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
        return bool2;
      }
      return q();
    }
    return p();
  }
  
  protected final void B()
  {
    int i = (int)(getMaximumPullScroll() * 1.2F);
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = getPaddingRight();
    int n = getPaddingBottom();
    int i1 = a.a[getPullToRefreshScrollDirection().ordinal()];
    if (i1 != 1)
    {
      if (i1 == 2)
      {
        if (this.p2.showHeaderLoadingLayout())
        {
          this.R3.setHeight(i);
          i1 = -i;
        }
        else
        {
          i1 = 0;
        }
        if (this.p2.showFooterLoadingLayout())
        {
          this.S3.setHeight(i);
          n = -i;
          k = i1;
        }
        else
        {
          n = 0;
          k = i1;
        }
      }
    }
    else
    {
      if (this.p2.showHeaderLoadingLayout())
      {
        this.R3.setWidth(i);
        i1 = -i;
      }
      else
      {
        i1 = 0;
      }
      if (this.p2.showFooterLoadingLayout())
      {
        this.S3.setWidth(i);
        m = -i;
        j = i1;
      }
      else
      {
        m = 0;
        j = i1;
      }
    }
    setPadding(j, k, m, n);
  }
  
  protected final void C(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.I3.getLayoutParams();
    int i = a.a[getPullToRefreshScrollDirection().ordinal()];
    if (i != 1)
    {
      if ((i == 2) && (localLayoutParams.height != paramInt2))
      {
        localLayoutParams.height = paramInt2;
        this.I3.requestLayout();
      }
    }
    else if (localLayoutParams.width != paramInt1)
    {
      localLayoutParams.width = paramInt1;
      this.I3.requestLayout();
    }
  }
  
  public void D(CharSequence paramCharSequence, Mode paramMode)
  {
    j(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setReleaseLabel(paramCharSequence);
  }
  
  final void E(State paramState, boolean... paramVarArgs)
  {
    this.p1 = paramState;
    int i = a.b[paramState.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if ((i == 4) || (i == 5)) {
            x(paramVarArgs[0]);
          }
        }
        else {
          y();
        }
      }
      else {
        v();
      }
    }
    else {
      z();
    }
    paramState = this.V3;
    if (paramState != null) {
      paramState.a(this, this.p1, this.p3);
    }
  }
  
  protected final void F(int paramInt)
  {
    G(paramInt, getPullToRefreshScrollDuration());
  }
  
  protected final void I(int paramInt, f paramf)
  {
    H(paramInt, getPullToRefreshScrollDuration(), 0L, paramf);
  }
  
  protected void J()
  {
    Object localObject = getLoadingLayoutLayoutParams();
    if (this == this.R3.getParent()) {
      removeView(this.R3);
    }
    if (this.p2.showHeaderLoadingLayout()) {
      c(this.R3, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (this == this.S3.getParent()) {
      removeView(this.S3);
    }
    if (this.p2.showFooterLoadingLayout()) {
      d(this.S3, (ViewGroup.LayoutParams)localObject);
    }
    B();
    localObject = this.p2;
    if (localObject == Mode.BOTH) {
      localObject = Mode.PULL_FROM_START;
    }
    this.p3 = ((Mode)localObject);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    View localView = getRefreshableView();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }
  
  protected final void c(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected final void d(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, -1, paramLayoutParams);
  }
  
  protected LoadingLayout f(Context paramContext, Mode paramMode, TypedArray paramTypedArray)
  {
    paramContext = this.Q3.createLoadingLayout(paramContext, paramMode, getPullToRefreshScrollDirection(), paramTypedArray);
    paramContext.setVisibility(4);
    return paramContext;
  }
  
  protected e g(boolean paramBoolean1, boolean paramBoolean2)
  {
    e locale = new e();
    if ((paramBoolean1) && (this.p2.showHeaderLoadingLayout())) {
      locale.a(this.R3);
    }
    if ((paramBoolean2) && (this.p2.showFooterLoadingLayout())) {
      locale.a(this.S3);
    }
    return locale;
  }
  
  public final Mode getCurrentMode()
  {
    return this.p3;
  }
  
  public final boolean getFilterTouchEvents()
  {
    return this.M3;
  }
  
  protected final LoadingLayout getFooterLayout()
  {
    return this.S3;
  }
  
  protected final int getFooterSize()
  {
    return this.S3.getContentSize();
  }
  
  protected final LoadingLayout getHeaderLayout()
  {
    return this.R3;
  }
  
  protected final int getHeaderSize()
  {
    return this.R3.getContentSize();
  }
  
  public final d getLoadingLayoutProxy()
  {
    return j(true, true);
  }
  
  public final Mode getMode()
  {
    return this.p2;
  }
  
  public abstract Orientation getPullToRefreshScrollDirection();
  
  protected int getPullToRefreshScrollDuration()
  {
    return 200;
  }
  
  protected int getPullToRefreshScrollDurationLonger()
  {
    return 325;
  }
  
  public final T getRefreshableView()
  {
    return this.H3;
  }
  
  protected FrameLayout getRefreshableViewWrapper()
  {
    return this.I3;
  }
  
  public final boolean getShowViewWhileRefreshing()
  {
    return this.J3;
  }
  
  public final State getState()
  {
    return this.p1;
  }
  
  protected abstract T h(Context paramContext, AttributeSet paramAttributeSet);
  
  protected final void i()
  {
    this.O3 = false;
  }
  
  public final d j(boolean paramBoolean1, boolean paramBoolean2)
  {
    return g(paramBoolean1, paramBoolean2);
  }
  
  protected void k(TypedArray paramTypedArray) {}
  
  public final boolean m()
  {
    return this.p2.permitsPullToRefresh();
  }
  
  public final boolean n()
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 9) && (this.N3) && (f.a(this.H3))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!m()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i != 3) && (i != 1))
    {
      if ((this.L3) && (r())) {
        return false;
      }
      if ((i != 0) && (this.y)) {
        return true;
      }
      float f3;
      if (i != 0)
      {
        if (i == 2)
        {
          if ((!this.K3) && (r())) {
            return true;
          }
          if (o())
          {
            float f1 = paramMotionEvent.getY();
            float f2 = paramMotionEvent.getX();
            float f4;
            if (a.a[getPullToRefreshScrollDirection().ordinal()] != 1)
            {
              f3 = f1 - this.f;
              f4 = f2 - this.d;
            }
            else
            {
              f3 = f2 - this.d;
              f4 = f1 - this.f;
            }
            float f5 = Math.abs(f3);
            if ((f5 > this.c) && ((!this.M3) || (f5 > Math.abs(f4)))) {
              if ((this.p2.showHeaderLoadingLayout()) && (f3 >= 1.0F) && (q()))
              {
                this.f = f1;
                this.d = f2;
                this.y = true;
                if (this.p2 == Mode.BOTH) {
                  this.p3 = Mode.PULL_FROM_START;
                }
              }
              else if ((this.p2.showFooterLoadingLayout()) && (f3 <= -1.0F) && (p()))
              {
                this.f = f1;
                this.d = f2;
                this.y = true;
                if (this.p2 == Mode.BOTH) {
                  this.p3 = Mode.PULL_FROM_END;
                }
              }
            }
          }
        }
      }
      else if (o())
      {
        f3 = paramMotionEvent.getY();
        this.x = f3;
        this.f = f3;
        f3 = paramMotionEvent.getX();
        this.q = f3;
        this.d = f3;
        this.y = false;
      }
      return this.y;
    }
    this.y = false;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.p0) && (this.z) && ((getHeaderSize() > 0) || (getFooterSize() > 0)))
    {
      E(State.REFRESHING, new boolean[] { true });
      this.p0 = false;
    }
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      setMode(Mode.mapIntToValue(localBundle.getInt("ptr_mode", 0)));
      this.p3 = Mode.mapIntToValue(localBundle.getInt("ptr_current_mode", 0));
      this.K3 = localBundle.getBoolean("ptr_disable_scrolling", false);
      this.J3 = localBundle.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(localBundle.getParcelable("ptr_super"));
      paramParcelable = State.mapIntToValue(localBundle.getInt("ptr_state", 0));
      if ((paramParcelable == State.REFRESHING) || (paramParcelable == State.MANUAL_REFRESHING)) {
        E(paramParcelable, new boolean[] { true });
      }
      t(localBundle);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    u(localBundle);
    localBundle.putInt("ptr_state", this.p1.getIntValue());
    localBundle.putInt("ptr_mode", this.p2.getIntValue());
    localBundle.putInt("ptr_current_mode", this.p3.getIntValue());
    localBundle.putBoolean("ptr_disable_scrolling", this.K3);
    localBundle.putBoolean("ptr_show_refreshing_view", this.J3);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    B();
    C(paramInt1, paramInt2);
    post(new a(this));
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!m()) {
      return false;
    }
    if ((!this.K3) && (r())) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label214;
          }
        }
        else
        {
          if (!this.y) {
            break label214;
          }
          this.f = paramMotionEvent.getY();
          this.d = paramMotionEvent.getX();
          A();
          return true;
        }
      }
      if (this.y)
      {
        this.y = false;
        if ((this.p1 == State.RELEASE_TO_REFRESH) && ((this.T3 != null) || (this.U3 != null)))
        {
          E(State.REFRESHING, new boolean[] { true });
          return true;
        }
        if (r())
        {
          F(0);
          return true;
        }
        E(State.RESET, new boolean[0]);
        return true;
      }
    }
    else if (o())
    {
      float f1 = paramMotionEvent.getY();
      this.x = f1;
      this.f = f1;
      f1 = paramMotionEvent.getX();
      this.q = f1;
      this.d = f1;
      return true;
    }
    label214:
    return false;
  }
  
  protected abstract boolean p();
  
  protected abstract boolean q();
  
  public final boolean r()
  {
    State localState = this.p1;
    boolean bool;
    if ((localState != State.REFRESHING) && (localState != State.MANUAL_REFRESHING)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setChildClickableWhileRefreshing(boolean paramBoolean)
  {
    this.L3 = paramBoolean;
  }
  
  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    setScrollingWhileRefreshingEnabled(paramBoolean ^ true);
  }
  
  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.M3 = paramBoolean;
  }
  
  protected final void setHeaderScroll(int paramInt)
  {
    int i = getMaximumPullScroll();
    i = Math.min(i, Math.max(-i, paramInt));
    if (this.O3) {
      if (i < 0)
      {
        this.R3.setVisibility(0);
      }
      else if (i > 0)
      {
        this.S3.setVisibility(0);
      }
      else
      {
        this.R3.setVisibility(4);
        this.S3.setVisibility(4);
      }
    }
    paramInt = a.a[getPullToRefreshScrollDirection().ordinal()];
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        scrollTo(0, i);
      }
    }
    else {
      scrollTo(i, 0);
    }
  }
  
  public void setInitRefresing(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setLastUpdatedLabel(paramCharSequence);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    getLoadingLayoutProxy().setLoadingDrawable(paramDrawable);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    getRefreshableView().setLongClickable(paramBoolean);
  }
  
  public final void setMode(Mode paramMode)
  {
    if (paramMode != this.p2)
    {
      this.p2 = paramMode;
      J();
    }
  }
  
  public void setOnPullEventListener(c<T> paramc)
  {
    this.V3 = paramc;
  }
  
  public final void setOnRefreshListener(d<T> paramd)
  {
    this.U3 = paramd;
    this.T3 = null;
  }
  
  public final void setOnRefreshListener(e<T> parame)
  {
    this.T3 = parame;
    this.U3 = null;
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setPullLabel(paramCharSequence);
  }
  
  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    Mode localMode;
    if (paramBoolean) {
      localMode = Mode.getDefault();
    } else {
      localMode = Mode.DISABLED;
    }
    setMode(localMode);
  }
  
  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean)
  {
    this.N3 = paramBoolean;
  }
  
  public final void setRefreshing(boolean paramBoolean)
  {
    if (!r()) {
      E(State.MANUAL_REFRESHING, new boolean[] { paramBoolean });
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setRefreshingLabel(paramCharSequence);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    D(paramCharSequence, Mode.BOTH);
  }
  
  public void setScrollAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.P3 = paramInterpolator;
  }
  
  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.K3 = paramBoolean;
  }
  
  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.J3 = paramBoolean;
  }
  
  protected void t(Bundle paramBundle) {}
  
  protected void u(Bundle paramBundle) {}
  
  protected void v()
  {
    int i = a.c[this.p3.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        this.R3.e();
      }
    }
    else {
      this.S3.e();
    }
  }
  
  public final void w()
  {
    if (r()) {
      E(State.RESET, new boolean[0]);
    }
  }
  
  protected void x(boolean paramBoolean)
  {
    if (this.p2.showHeaderLoadingLayout()) {
      this.R3.g();
    }
    if (this.p2.showFooterLoadingLayout()) {
      this.S3.g();
    }
    if (paramBoolean)
    {
      if (this.J3)
      {
        b localb = new b(this);
        int i = a.c[this.p3.ordinal()];
        if ((i != 1) && (i != 3)) {
          I(-getHeaderSize(), localb);
        } else {
          I(getFooterSize(), localb);
        }
      }
      else
      {
        F(0);
      }
    }
    else {
      e();
    }
  }
  
  protected void y()
  {
    int i = a.c[this.p3.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        this.R3.i();
      }
    }
    else {
      this.S3.i();
    }
  }
  
  protected void z()
  {
    this.y = false;
    this.O3 = true;
    this.R3.k();
    this.S3.k();
    F(0);
  }
  
  public static enum AnimationStyle
  {
    static
    {
      AnimationStyle localAnimationStyle1 = new AnimationStyle("ROTATE", 0);
      ROTATE = localAnimationStyle1;
      AnimationStyle localAnimationStyle2 = new AnimationStyle("FLIP", 1);
      FLIP = localAnimationStyle2;
      $VALUES = new AnimationStyle[] { localAnimationStyle1, localAnimationStyle2 };
    }
    
    static AnimationStyle getDefault()
    {
      return ROTATE;
    }
    
    static AnimationStyle mapIntToValue(int paramInt)
    {
      if (paramInt != 1) {
        return ROTATE;
      }
      return FLIP;
    }
    
    LoadingLayout createLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
    {
      if (PullToRefreshBase.a.d[ordinal()] != 2) {
        return new RotateLoadingLayout(paramContext, paramMode, paramOrientation, paramTypedArray);
      }
      return new FlipLoadingLayout(paramContext, paramMode, paramOrientation, paramTypedArray);
    }
  }
  
  public static enum Mode
  {
    public static Mode PULL_DOWN_TO_REFRESH;
    public static Mode PULL_UP_TO_REFRESH;
    private int mIntValue;
    
    static
    {
      Mode localMode1 = new Mode("DISABLED", 0, 0);
      DISABLED = localMode1;
      Mode localMode2 = new Mode("PULL_FROM_START", 1, 1);
      PULL_FROM_START = localMode2;
      Mode localMode3 = new Mode("PULL_FROM_END", 2, 2);
      PULL_FROM_END = localMode3;
      Mode localMode4 = new Mode("BOTH", 3, 3);
      BOTH = localMode4;
      Mode localMode5 = new Mode("MANUAL_REFRESH_ONLY", 4, 4);
      MANUAL_REFRESH_ONLY = localMode5;
      $VALUES = new Mode[] { localMode1, localMode2, localMode3, localMode4, localMode5 };
      PULL_DOWN_TO_REFRESH = localMode2;
      PULL_UP_TO_REFRESH = localMode3;
    }
    
    private Mode(int paramInt)
    {
      this.mIntValue = paramInt;
    }
    
    static Mode getDefault()
    {
      return PULL_FROM_START;
    }
    
    static Mode mapIntToValue(int paramInt)
    {
      for (Mode localMode : ) {
        if (paramInt == localMode.getIntValue()) {
          return localMode;
        }
      }
      return getDefault();
    }
    
    int getIntValue()
    {
      return this.mIntValue;
    }
    
    boolean permitsPullToRefresh()
    {
      boolean bool;
      if ((this != DISABLED) && (this != MANUAL_REFRESH_ONLY)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean showFooterLoadingLayout()
    {
      boolean bool;
      if ((this != PULL_FROM_END) && (this != BOTH) && (this != MANUAL_REFRESH_ONLY)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean showHeaderLoadingLayout()
    {
      boolean bool;
      if ((this != PULL_FROM_START) && (this != BOTH)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public static enum Orientation
  {
    static
    {
      Orientation localOrientation1 = new Orientation("VERTICAL", 0);
      VERTICAL = localOrientation1;
      Orientation localOrientation2 = new Orientation("HORIZONTAL", 1);
      HORIZONTAL = localOrientation2;
      $VALUES = new Orientation[] { localOrientation1, localOrientation2 };
    }
  }
  
  public static enum State
  {
    private int mIntValue;
    
    static
    {
      State localState1 = new State("RESET", 0, 0);
      RESET = localState1;
      State localState2 = new State("PULL_TO_REFRESH", 1, 1);
      PULL_TO_REFRESH = localState2;
      State localState3 = new State("RELEASE_TO_REFRESH", 2, 2);
      RELEASE_TO_REFRESH = localState3;
      State localState4 = new State("REFRESHING", 3, 8);
      REFRESHING = localState4;
      State localState5 = new State("MANUAL_REFRESHING", 4, 9);
      MANUAL_REFRESHING = localState5;
      State localState6 = new State("OVERSCROLLING", 5, 16);
      OVERSCROLLING = localState6;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6 };
    }
    
    private State(int paramInt)
    {
      this.mIntValue = paramInt;
    }
    
    static State mapIntToValue(int paramInt)
    {
      for (State localState : ) {
        if (paramInt == localState.getIntValue()) {
          return localState;
        }
      }
      return RESET;
    }
    
    int getIntValue()
    {
      return this.mIntValue;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  public static abstract interface c<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode);
  }
  
  public static abstract interface d<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase);
    
    public abstract void b(PullToRefreshBase<V> paramPullToRefreshBase);
  }
  
  public static abstract interface e<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase);
  }
  
  static abstract interface f
  {
    public abstract void a();
  }
  
  final class g
    implements Runnable
  {
    private final Interpolator c;
    private final int d;
    private final int f;
    private int p0 = -1;
    private final long q;
    private PullToRefreshBase.f x;
    private boolean y = true;
    private long z = -1L;
    
    public g(int paramInt1, int paramInt2, long paramLong, PullToRefreshBase.f paramf)
    {
      this.f = paramInt1;
      this.d = paramInt2;
      this.c = PullToRefreshBase.a(PullToRefreshBase.this);
      this.q = paramLong;
      this.x = paramf;
    }
    
    public void a()
    {
      this.y = false;
      PullToRefreshBase.this.removeCallbacks(this);
    }
    
    public void run()
    {
      if (this.z == -1L)
      {
        this.z = System.currentTimeMillis();
      }
      else
      {
        long l = Math.max(Math.min((System.currentTimeMillis() - this.z) * 1000L / this.q, 1000L), 0L);
        int i = Math.round((this.f - this.d) * this.c.getInterpolation((float)l / 1000.0F));
        i = this.f - i;
        this.p0 = i;
        PullToRefreshBase.this.setHeaderScroll(i);
      }
      if ((this.y) && (this.d != this.p0))
      {
        c.a(PullToRefreshBase.this, this);
      }
      else
      {
        PullToRefreshBase.f localf = this.x;
        if (localf != null) {
          localf.a();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\PullToRefreshBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */