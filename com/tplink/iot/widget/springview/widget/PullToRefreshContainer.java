package com.tplink.iot.widget.springview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.b;
import com.tplink.iot.widget.springview.listener.AppBarStateChangeListener;
import com.tplink.iot.widget.springview.listener.AppBarStateChangeListener.State;

public class PullToRefreshContainer
  extends ViewGroup
{
  private boolean H3 = true;
  private boolean I3 = false;
  private int J3 = 400;
  private Give K3 = Give.BOTH;
  private Type L3 = Type.FOLLOW;
  private Type M3;
  private double N3 = 2.0D;
  private int O3 = 600;
  private int P3 = 600;
  private int Q3;
  private int R3;
  private int S3;
  private int T3;
  private int U3;
  private int V3;
  private float W3;
  private float X3;
  private float Y3;
  private float Z3;
  private boolean a4 = false;
  private View b4;
  private Context c;
  private View c4;
  private LayoutInflater d;
  private View d4;
  private View e4;
  private OverScroller f;
  private int f4;
  private int g4;
  private AppBarStateChangeListener.State h4 = AppBarStateChangeListener.State.EXPANDED;
  private boolean i4 = false;
  private int j4 = 0;
  private int k4;
  private boolean l4 = false;
  private boolean m4 = false;
  private boolean n4 = false;
  private float o4;
  private boolean p0 = false;
  private boolean p1 = false;
  private boolean p2 = false;
  private boolean p3 = true;
  private float p4;
  private Handler q = new Handler();
  private boolean q4;
  private int r4 = -1;
  private boolean s4 = true;
  private boolean t4 = false;
  private boolean u4 = false;
  private d v4;
  private d w4;
  private e x;
  private d x4;
  private int y;
  private d y4;
  private boolean z = true;
  
  public PullToRefreshContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PullToRefreshContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PullToRefreshContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.f = new OverScroller(paramContext);
    r(paramAttributeSet);
  }
  
  private void B()
  {
    this.k4 = 2;
    this.a4 = false;
    Object localObject;
    if (getScrollY() < 0)
    {
      localObject = this.x4;
      if (localObject != null) {
        ((d)localObject).e();
      }
      this.f.startScroll(0, getScrollY(), 0, -getScrollY() - this.U3, this.J3);
      invalidate();
    }
    else
    {
      localObject = this.y4;
      if (localObject != null) {
        ((d)localObject).e();
      }
      localObject = this.f;
      int i = getScrollY();
      int j = -getScrollY();
      ((OverScroller)localObject).startScroll(0, i, 0, this.V3 + j, this.J3);
      invalidate();
    }
  }
  
  private void C()
  {
    this.k4 = 0;
    this.a4 = false;
    this.f.startScroll(0, getScrollY(), 0, -getScrollY(), this.J3);
    invalidate();
  }
  
  private void D()
  {
    this.k4 = 1;
    this.a4 = false;
    if (getScrollY() < 0)
    {
      this.f.startScroll(0, getScrollY(), 0, -getScrollY() - this.S3, this.J3);
      invalidate();
    }
    else
    {
      this.f.startScroll(0, getScrollY(), 0, -getScrollY() + this.T3, this.J3);
      invalidate();
    }
  }
  
  private void E()
  {
    if (this.x == null)
    {
      C();
    }
    else
    {
      Give localGive;
      if (z())
      {
        n();
        localGive = this.K3;
        if ((localGive != Give.BOTH) && (localGive != Give.TOP)) {
          C();
        } else {
          D();
        }
      }
      else if (t())
      {
        n();
        localGive = this.K3;
        if ((localGive != Give.BOTH) && (localGive != Give.BOTTOM)) {
          C();
        } else {
          D();
        }
      }
      else
      {
        C();
      }
    }
  }
  
  private void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = this.b4;
    int i = 0;
    int j;
    if (localView != null)
    {
      if (paramBoolean1) {
        j = 0;
      } else {
        j = 4;
      }
      localView.setVisibility(j);
    }
    localView = this.c4;
    if (localView != null)
    {
      if (paramBoolean2) {
        j = i;
      } else {
        j = 4;
      }
      localView.setVisibility(j);
    }
  }
  
  private void a()
  {
    this.I3 = true;
    this.k4 = 1;
    this.p1 = true;
    this.m4 = false;
    this.j4 = 1;
    d locald = this.x4;
    if (locald != null) {
      locald.a();
    }
    F(true, false);
    this.f.startScroll(0, getScrollY(), 0, -getScrollY() - this.S3, this.J3);
    invalidate();
  }
  
  private void g()
  {
    final d locald;
    if (y()) {
      locald = this.x4;
    } else {
      locald = this.y4;
    }
    if (locald == null) {
      return;
    }
    new Handler().postDelayed(new b(locald), locald.b());
  }
  
  private void h()
  {
    int i = this.j4;
    Object localObject;
    if (i == 1)
    {
      localObject = this.x4;
      if (localObject != null) {
        ((d)localObject).d();
      }
      localObject = this.K3;
      if ((localObject == Give.BOTTOM) || ((localObject == Give.NONE) && (!this.I3))) {
        this.x.onRefresh();
      }
      this.I3 = false;
    }
    else if (i == 2)
    {
      localObject = this.y4;
      if (localObject != null) {
        ((d)localObject).d();
      }
      localObject = this.K3;
      if ((localObject == Give.TOP) || (localObject == Give.NONE)) {
        this.x.a();
      }
    }
    this.j4 = 0;
    if (this.t4)
    {
      this.t4 = false;
      setHeaderIn(this.v4);
    }
    if (this.u4)
    {
      this.u4 = false;
      setFooterIn(this.w4);
    }
    if (this.p0) {
      o(this.M3);
    }
  }
  
  private void i()
  {
    if (y()) {
      this.x.onRefresh();
    } else if (s()) {
      this.x.a();
    }
  }
  
  private void j()
  {
    Object localObject = this.L3;
    if (localObject == Type.OVERLAP)
    {
      localObject = this.b4;
      if (localObject != null) {
        ((View)localObject).setTranslationY(((View)localObject).getHeight() + getScrollY());
      }
      localObject = this.c4;
      if (localObject != null) {
        ((View)localObject).setTranslationY(-((View)localObject).getHeight() + getScrollY());
      }
    }
    else if (localObject == Type.DRAG)
    {
      localObject = this.d4;
      if (localObject != null) {
        ((View)localObject).setTranslationY(getScrollY());
      }
    }
  }
  
  private void k()
  {
    d locald;
    if (getScrollY() < 0)
    {
      locald = this.x4;
      if (locald != null) {
        locald.c(this.b4, -getScrollY());
      }
    }
    if (getScrollY() > 0)
    {
      locald = this.y4;
      if (locald != null) {
        locald.c(this.c4, -getScrollY());
      }
    }
  }
  
  private void l()
  {
    int i = getScrollY();
    d locald;
    if (i < 0)
    {
      if ((Math.abs(i) >= this.Q3) && (Math.abs(this.y) < this.Q3))
      {
        locald = this.x4;
        if (locald != null) {
          locald.k(this.b4, false);
        }
      }
      else if ((Math.abs(i) <= this.Q3) && (Math.abs(this.y) > this.Q3))
      {
        locald = this.x4;
        if (locald != null) {
          locald.k(this.b4, true);
        }
      }
    }
    else if ((Math.abs(i) >= this.Q3) && (Math.abs(this.y) < this.Q3))
    {
      locald = this.y4;
      if (locald != null) {
        locald.k(this.b4, true);
      }
    }
    else if ((Math.abs(i) <= this.Q3) && (Math.abs(this.y) > this.Q3))
    {
      locald = this.y4;
      if (locald != null) {
        locald.k(this.b4, false);
      }
    }
    this.y = i;
  }
  
  private void m()
  {
    if (this.s4)
    {
      d locald;
      if (y())
      {
        locald = this.x4;
        if (locald != null) {
          locald.g(this.b4);
        }
        this.s4 = false;
      }
      else if (s())
      {
        locald = this.y4;
        if (locald != null) {
          locald.g(this.c4);
        }
        this.s4 = false;
      }
    }
  }
  
  private void n()
  {
    d locald;
    if (y())
    {
      this.j4 = 1;
      locald = this.x4;
      if (locald != null) {
        locald.a();
      }
    }
    else if (s())
    {
      this.j4 = 2;
      locald = this.y4;
      if (locald != null) {
        locald.a();
      }
    }
  }
  
  private void o(Type paramType)
  {
    this.L3 = paramType;
    requestLayout();
    this.p0 = false;
    paramType = this.b4;
    if (paramType != null) {
      paramType.setTranslationY(0.0F);
    }
    paramType = this.c4;
    if (paramType != null) {
      paramType.setTranslationY(0.0F);
    }
  }
  
  private void q()
  {
    if (!this.f.isFinished()) {
      this.f.forceFinished(true);
    }
    double d1;
    double d2;
    if (this.o4 > 0.0F)
    {
      d1 = (this.O3 + getScrollY()) / this.O3 * this.o4;
      d2 = this.N3;
    }
    else
    {
      d1 = (this.P3 - getScrollY()) / this.P3 * this.o4;
      d2 = this.N3;
    }
    scrollBy(0, -(int)(d1 / d2));
    j();
  }
  
  private void r(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramAttributeSet = this.c.obtainStyledAttributes(paramAttributeSet, b.PullToRefreshContainer);
    int i;
    if (paramAttributeSet.hasValue(3))
    {
      i = paramAttributeSet.getInt(3, 0);
      this.L3 = Type.values()[i];
    }
    if (paramAttributeSet.hasValue(1))
    {
      i = paramAttributeSet.getInt(1, 0);
      this.K3 = Give.values()[i];
    }
    if (paramAttributeSet.hasValue(2)) {
      this.f4 = paramAttributeSet.getResourceId(2, 0);
    }
    if (paramAttributeSet.hasValue(0)) {
      this.g4 = paramAttributeSet.getResourceId(0, 0);
    }
    paramAttributeSet.recycle();
  }
  
  private boolean s()
  {
    boolean bool;
    if (getScrollY() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void setFooterIn(d paramd)
  {
    this.y4 = paramd;
    View localView = this.c4;
    if (localView != null) {
      removeView(localView);
    }
    paramd.m(this.d, this);
    this.c4 = getChildAt(getChildCount() - 1);
    requestLayout();
  }
  
  private void setHeaderIn(d paramd)
  {
    this.x4 = paramd;
    View localView = this.b4;
    if (localView != null) {
      removeView(localView);
    }
    paramd.m(this.d, this);
    this.b4 = getChildAt(getChildCount() - 1);
    requestLayout();
  }
  
  private boolean t()
  {
    boolean bool;
    if (getScrollY() > this.R3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean u()
  {
    return this.e4.canScrollVertically(1) ^ true;
  }
  
  private boolean v()
  {
    return this.e4.canScrollVertically(-1) ^ true;
  }
  
  private boolean w()
  {
    boolean bool;
    if ((getScrollY() > -30) && (getScrollY() < 30)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean x()
  {
    if (this.d4 == null) {
      return false;
    }
    if (Math.abs(this.o4) <= Math.abs(this.p4)) {
      return false;
    }
    boolean bool1 = v();
    boolean bool2 = u();
    if ((!this.p3) && (bool1) && (this.o4 > 0.0F)) {
      return false;
    }
    if ((!this.H3) && (bool2) && (this.o4 < 0.0F)) {
      return false;
    }
    if ((this.b4 != null) && (Math.abs(this.o4) > 3.0F) && (((bool1) && (this.o4 > 0.0F)) || (getScrollY() < -20))) {
      return true;
    }
    return (this.c4 != null) && (((bool2) && (this.o4 < 0.0F)) || (getScrollY() > 20));
  }
  
  private boolean y()
  {
    boolean bool;
    if (getScrollY() < 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean z()
  {
    boolean bool;
    if (-getScrollY() > this.Q3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void A()
  {
    if ((!this.p2) && (this.p1))
    {
      Object localObject;
      if (this.I3)
      {
        if (y())
        {
          localObject = this.x4;
          if ((localObject != null) && (((d)localObject).b() > 0)) {
            B();
          } else {
            C();
          }
        }
      }
      else
      {
        boolean bool = y();
        int i = 1;
        if (bool)
        {
          localObject = this.K3;
          if ((localObject == Give.TOP) || (localObject == Give.BOTH))
          {
            j = 1;
            break label99;
          }
        }
        int j = 0;
        label99:
        if (s())
        {
          localObject = this.K3;
          k = i;
          if (localObject == Give.BOTTOM) {
            break label137;
          }
          if (localObject == Give.BOTH)
          {
            k = i;
            break label137;
          }
        }
        int k = 0;
        label137:
        if ((j != 0) || (k != 0))
        {
          localObject = this.x4;
          if ((localObject != null) && (((d)localObject).b() > 0)) {
            B();
          } else {
            C();
          }
        }
      }
    }
  }
  
  public void computeScroll()
  {
    if (this.f.computeScrollOffset())
    {
      scrollTo(0, this.f.getCurrY());
      this.y = getScrollY();
      k();
      j();
      invalidate();
    }
    if ((!this.p2) && (this.f.isFinished()))
    {
      int i = this.k4;
      if (i == 0)
      {
        if (!this.l4)
        {
          this.l4 = true;
          h();
        }
      }
      else if (i == 1)
      {
        if (!this.m4)
        {
          this.m4 = true;
          i();
        }
      }
      else if ((i == 2) && (!this.n4))
      {
        this.n4 = true;
        g();
      }
    }
  }
  
  public void d()
  {
    a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    p(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.p2 = false;
          }
        }
        else
        {
          v();
          u();
          Object localObject;
          if (this.i4)
          {
            localObject = this.h4;
            if ((localObject != AppBarStateChangeListener.State.EXPANDED) && ((localObject != AppBarStateChangeListener.State.COLLAPSED) || (this.o4 >= 0.0F))) {}
          }
          else
          {
            this.Z3 += this.o4;
            this.p2 = true;
            boolean bool = x();
            this.q4 = bool;
            if ((bool) && (!this.a4))
            {
              this.a4 = true;
              paramMotionEvent.setAction(3);
              localObject = MotionEvent.obtain(paramMotionEvent);
              dispatchTouchEvent(paramMotionEvent);
              ((MotionEvent)localObject).setAction(0);
              return dispatchTouchEvent((MotionEvent)localObject);
            }
          }
        }
      }
      else {
        this.p2 = false;
      }
    }
    else
    {
      this.l4 = false;
      if (this.k4 != 1) {
        this.m4 = false;
      }
      this.n4 = false;
      this.Y3 = paramMotionEvent.getY();
      this.q4 = false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    f(100);
  }
  
  public void f(int paramInt)
  {
    this.q.postDelayed(new c(), paramInt);
  }
  
  public d getFooter()
  {
    return this.y4;
  }
  
  public View getFooterView()
  {
    return this.c4;
  }
  
  public d getHeader()
  {
    return this.x4;
  }
  
  public View getHeaderView()
  {
    return this.b4;
  }
  
  public Type getType()
  {
    return this.L3;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AppBarLayout localAppBarLayout = a.c(this);
    this.i4 = a.a(localAppBarLayout);
    if (localAppBarLayout != null) {
      localAppBarLayout.addOnOffsetChangedListener(new a());
    }
  }
  
  protected void onFinishInflate()
  {
    View localView1 = getChildAt(0);
    if (localView1 == null) {
      return;
    }
    setPadding(0, 0, 0, 0);
    int i = this.f4;
    if (i != 0)
    {
      this.d.inflate(i, this, true);
      this.b4 = getChildAt(getChildCount() - 1);
    }
    i = this.g4;
    if (i != 0)
    {
      this.d.inflate(i, this, true);
      this.c4 = getChildAt(getChildCount() - 1);
    }
    if (a.e(localView1))
    {
      this.d4 = localView1;
      this.e4 = localView1;
    }
    else
    {
      View localView2 = a.d(localView1);
      if (localView2 != null) {
        this.e4 = localView2;
      } else {
        this.e4 = localView1;
      }
      this.d4 = localView1;
    }
    super.onFinishInflate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.q4;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.d4 != null)
    {
      Object localObject = this.b4;
      if (localObject != null) {
        ((View)localObject).layout(0, -((View)localObject).getMeasuredHeight(), getWidth(), 0);
      }
      localObject = this.c4;
      if (localObject != null) {
        ((View)localObject).layout(0, getHeight(), getWidth(), getHeight() + this.c4.getMeasuredHeight());
      }
      localObject = this.d4;
      ((View)localObject).layout(0, 0, ((View)localObject).getMeasuredWidth(), this.d4.getMeasuredHeight());
      localObject = this.L3;
      if (localObject == Type.OVERLAP)
      {
        this.d4.bringToFront();
      }
      else if (localObject == Type.DRAG)
      {
        localObject = this.b4;
        if (localObject != null) {
          ((View)localObject).bringToFront();
        }
        localObject = this.c4;
        if (localObject != null) {
          ((View)localObject).bringToFront();
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    if (getChildCount() > 0) {
      for (i = 0; i < getChildCount(); i++) {
        measureChild(getChildAt(i), paramInt1, paramInt2);
      }
    }
    Object localObject = this.x4;
    if (localObject != null)
    {
      i = ((d)localObject).i(this.b4);
      if (i > 0) {
        this.O3 = i;
      }
      i = this.x4.j(this.b4);
      if (i <= 0) {
        i = this.b4.getMeasuredHeight();
      }
      this.Q3 = i;
      i = this.x4.h(this.b4);
      if (i <= 0) {
        i = this.Q3;
      }
      this.S3 = i;
      this.U3 = this.x4.f(this.b4);
    }
    else
    {
      localObject = this.b4;
      if (localObject != null) {
        this.Q3 = ((View)localObject).getMeasuredHeight();
      }
      this.S3 = this.Q3;
    }
    localObject = this.y4;
    if (localObject != null)
    {
      i = ((d)localObject).i(this.c4);
      if (i > 0) {
        this.P3 = i;
      }
      i = this.y4.j(this.c4);
      if (i <= 0) {
        i = this.c4.getMeasuredHeight();
      }
      this.R3 = i;
      i = this.y4.h(this.c4);
      if (i <= 0) {
        i = this.R3;
      }
      this.T3 = i;
      this.V3 = this.y4.f(this.c4);
    }
    else
    {
      localObject = this.c4;
      if (localObject != null) {
        this.R3 = ((View)localObject).getMeasuredHeight();
      }
      this.T3 = this.R3;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d4 == null) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          if (this.q4)
          {
            this.p1 = false;
            q();
            if (y()) {
              F(true, false);
            } else if (s()) {
              F(false, true);
            }
            k();
            m();
            l();
            this.z = false;
          }
          else if ((this.o4 != 0.0F) && (w()))
          {
            C();
            paramMotionEvent.setAction(0);
            dispatchTouchEvent(paramMotionEvent);
            this.a4 = false;
          }
        }
      }
      else
      {
        this.p1 = true;
        this.z = true;
        this.s4 = true;
        E();
        this.Z3 = 0.0F;
        this.o4 = 0.0F;
      }
    }
    else {
      this.z = true;
    }
    return false;
  }
  
  public void p(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = 0;
    float f1;
    float f2;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                return;
              }
              i = paramMotionEvent.getActionIndex();
              if (paramMotionEvent.getPointerId(i) != this.r4) {
                return;
              }
              if (i == 0) {
                j = 1;
              }
              this.X3 = paramMotionEvent.getX(j);
              this.W3 = paramMotionEvent.getY(j);
              this.r4 = paramMotionEvent.getPointerId(j);
              return;
            }
            j = paramMotionEvent.getActionIndex();
            if (paramMotionEvent.getPointerId(j) == this.r4) {
              return;
            }
            this.X3 = paramMotionEvent.getX(j);
            this.W3 = paramMotionEvent.getY(j);
            this.r4 = paramMotionEvent.getPointerId(j);
            return;
          }
        }
        else
        {
          j = paramMotionEvent.findPointerIndex(this.r4);
          f1 = paramMotionEvent.getX(j);
          f2 = paramMotionEvent.getY(j);
          this.p4 = (f1 - this.X3);
          this.o4 = (f2 - this.W3);
          this.W3 = f2;
          this.X3 = f1;
          return;
        }
      }
      this.r4 = -1;
    }
    else
    {
      j = paramMotionEvent.getActionIndex();
      f2 = paramMotionEvent.getX(j);
      f1 = paramMotionEvent.getY(j);
      this.X3 = f2;
      this.W3 = f1;
      this.r4 = paramMotionEvent.getPointerId(0);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
    this.H3 = paramBoolean;
  }
  
  public void setEnableFooter(boolean paramBoolean)
  {
    this.H3 = paramBoolean;
  }
  
  public void setEnableHeader(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
  }
  
  public void setFooter(d paramd)
  {
    if ((this.y4 != null) && (s()))
    {
      this.u4 = true;
      this.w4 = paramd;
      C();
    }
    else
    {
      setFooterIn(paramd);
    }
  }
  
  public void setGive(Give paramGive)
  {
    this.K3 = paramGive;
  }
  
  public void setHeader(d paramd)
  {
    if ((this.x4 != null) && (y()))
    {
      this.t4 = true;
      this.v4 = paramd;
      C();
    }
    else
    {
      setHeaderIn(paramd);
    }
  }
  
  public void setListener(e parame)
  {
    this.x = parame;
  }
  
  public void setMovePara(double paramDouble)
  {
    this.N3 = paramDouble;
  }
  
  public void setMoveTime(int paramInt)
  {
    this.J3 = paramInt;
  }
  
  public void setType(Type paramType)
  {
    if ((!y()) && (!s()))
    {
      o(paramType);
    }
    else
    {
      this.p0 = true;
      this.M3 = paramType;
    }
  }
  
  public static enum Give
  {
    static
    {
      Give localGive1 = new Give("BOTH", 0);
      BOTH = localGive1;
      Give localGive2 = new Give("TOP", 1);
      TOP = localGive2;
      Give localGive3 = new Give("BOTTOM", 2);
      BOTTOM = localGive3;
      Give localGive4 = new Give("NONE", 3);
      NONE = localGive4;
      $VALUES = new Give[] { localGive1, localGive2, localGive3, localGive4 };
    }
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("OVERLAP", 0);
      OVERLAP = localType1;
      Type localType2 = new Type("FOLLOW", 1);
      FOLLOW = localType2;
      Type localType3 = new Type("DRAG", 2);
      DRAG = localType3;
      $VALUES = new Type[] { localType1, localType2, localType3 };
    }
  }
  
  class a
    extends AppBarStateChangeListener
  {
    a() {}
    
    public void a(AppBarLayout paramAppBarLayout, AppBarStateChangeListener.State paramState)
    {
      PullToRefreshContainer.b(PullToRefreshContainer.this, paramState);
    }
  }
  
  class b
    implements Runnable
  {
    b(PullToRefreshContainer.d paramd) {}
    
    public void run()
    {
      locald.l();
      PullToRefreshContainer.c(PullToRefreshContainer.this);
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      PullToRefreshContainer.this.d();
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract int b();
    
    public abstract void c(View paramView, int paramInt);
    
    public abstract void d();
    
    public abstract void e();
    
    public abstract int f(View paramView);
    
    public abstract void g(View paramView);
    
    public abstract int h(View paramView);
    
    public abstract int i(View paramView);
    
    public abstract int j(View paramView);
    
    public abstract void k(View paramView, boolean paramBoolean);
    
    public abstract void l();
    
    public abstract View m(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  }
  
  public static abstract interface e
  {
    public abstract void a();
    
    public abstract void onRefresh();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\springview\widget\PullToRefreshContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */