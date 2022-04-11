package com.yinglan.scrolllayout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.yinglan.scrolllayout.content.ContentScrollView;
import com.yinglan.scrolllayout.content.ContentScrollView.a;

public class ScrollLayout
  extends FrameLayout
{
  private boolean H3;
  private boolean I3;
  private boolean J3;
  private boolean K3;
  private boolean L3;
  private f M3;
  private int N3;
  public int O3;
  private int P3;
  private g Q3;
  private ContentScrollView R3;
  private ContentScrollView.a S3;
  private final GestureDetector.OnGestureListener c;
  private final AbsListView.OnScrollListener d;
  private final RecyclerView.OnScrollListener f;
  private Status p0;
  private Scroller p1;
  private GestureDetector p2;
  private boolean p3;
  private float q;
  private float x;
  private float y;
  private float z;
  
  public ScrollLayout(Context paramContext)
  {
    super(paramContext);
    paramContext = new a();
    this.c = paramContext;
    this.d = new b();
    this.f = new c();
    this.p0 = Status.CLOSED;
    this.p3 = true;
    this.H3 = false;
    this.I3 = true;
    this.J3 = true;
    this.K3 = true;
    this.L3 = false;
    this.M3 = f.d;
    this.N3 = 0;
    this.O3 = 0;
    this.P3 = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      this.p1 = new Scroller(getContext(), null, true);
    } else {
      this.p1 = new Scroller(getContext());
    }
    this.p2 = new GestureDetector(getContext(), paramContext);
    this.S3 = new d();
  }
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a locala = new a();
    this.c = locala;
    this.d = new b();
    this.f = new c();
    this.p0 = Status.CLOSED;
    this.p3 = true;
    this.H3 = false;
    this.I3 = true;
    this.J3 = true;
    this.K3 = true;
    this.L3 = false;
    this.M3 = f.d;
    this.N3 = 0;
    this.O3 = 0;
    this.P3 = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      this.p1 = new Scroller(getContext(), null, true);
    } else {
      this.p1 = new Scroller(getContext());
    }
    this.p2 = new GestureDetector(getContext(), locala);
    this.S3 = new d();
    j(paramContext, paramAttributeSet);
  }
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a locala = new a();
    this.c = locala;
    this.d = new b();
    this.f = new c();
    this.p0 = Status.CLOSED;
    this.p3 = true;
    this.H3 = false;
    this.I3 = true;
    this.J3 = true;
    this.K3 = true;
    this.L3 = false;
    this.M3 = f.d;
    this.N3 = 0;
    this.O3 = 0;
    this.P3 = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      this.p1 = new Scroller(getContext(), null, true);
    } else {
      this.p1 = new Scroller(getContext());
    }
    this.p2 = new GestureDetector(getContext(), locala);
    this.S3 = new d();
    j(paramContext, paramAttributeSet);
  }
  
  private void h()
  {
    float f1 = -((this.N3 - this.O3) * 0.5F);
    if (getScrollY() > f1)
    {
      m();
    }
    else if (this.H3)
    {
      int i = this.P3;
      int j = this.N3;
      float f2 = -((i - j) * 0.8F + j);
      if ((getScrollY() <= f1) && (getScrollY() > f2)) {
        o();
      } else {
        n();
      }
    }
    else
    {
      o();
    }
  }
  
  private boolean i(int paramInt)
  {
    if (this.H3)
    {
      if ((paramInt <= 0) && (getScrollY() >= -this.O3)) {
        return true;
      }
      if ((paramInt >= 0) && (getScrollY() <= -this.P3)) {
        return true;
      }
    }
    else
    {
      if ((paramInt <= 0) && (getScrollY() >= -this.O3)) {
        return true;
      }
      if ((paramInt >= 0) && (getScrollY() <= -this.N3)) {
        return true;
      }
    }
    return false;
  }
  
  private void j(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.ScrollLayout);
    int i = a.ScrollLayout_maxOffset;
    if (paramContext.hasValue(i))
    {
      i = paramContext.getDimensionPixelOffset(i, this.N3);
      if (i != getScreenHeight()) {
        this.N3 = (getScreenHeight() - i);
      }
    }
    i = a.ScrollLayout_minOffset;
    if (paramContext.hasValue(i)) {
      this.O3 = paramContext.getDimensionPixelOffset(i, this.O3);
    }
    i = a.ScrollLayout_exitOffset;
    if (paramContext.hasValue(i))
    {
      i = paramContext.getDimensionPixelOffset(i, getScreenHeight());
      if (i != getScreenHeight()) {
        this.P3 = (getScreenHeight() - i);
      }
    }
    i = a.ScrollLayout_allowHorizontalScroll;
    if (paramContext.hasValue(i)) {
      this.I3 = paramContext.getBoolean(i, true);
    }
    i = a.ScrollLayout_isSupportExit;
    if (paramContext.hasValue(i)) {
      this.H3 = paramContext.getBoolean(i, true);
    }
    i = a.ScrollLayout_mode;
    if (paramContext.hasValue(i))
    {
      i = paramContext.getInteger(i, 0);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            p();
          } else {
            q();
          }
        }
        else {
          p();
        }
      }
      else {
        r();
      }
    }
    paramContext.recycle();
  }
  
  private void k(Status paramStatus)
  {
    g localg = this.Q3;
    if (localg != null) {
      localg.a(paramStatus);
    }
  }
  
  private void l(float paramFloat)
  {
    g localg = this.Q3;
    if (localg != null) {
      localg.b(paramFloat);
    }
  }
  
  private void s(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getChildCount() == 0)
    {
      setDraggable(true);
    }
    else
    {
      if ((paramAbsListView.getFirstVisiblePosition() == 0) && (paramAbsListView.getChildAt(0).getTop() == paramAbsListView.getPaddingTop()))
      {
        setDraggable(true);
        return;
      }
      setDraggable(false);
    }
  }
  
  private void t(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView.getChildCount() == 0)
    {
      setDraggable(true);
    }
    else
    {
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      int[] arrayOfInt = new int[1];
      if ((!(localLayoutManager instanceof LinearLayoutManager)) && (!(localLayoutManager instanceof GridLayoutManager)))
      {
        if ((localLayoutManager instanceof StaggeredGridLayoutManager)) {
          arrayOfInt = ((StaggeredGridLayoutManager)localLayoutManager).findFirstVisibleItemPositions(null);
        }
      }
      else {
        arrayOfInt[0] = ((LinearLayoutManager)localLayoutManager).findFirstVisibleItemPosition();
      }
      if ((arrayOfInt[0] == 0) && (paramRecyclerView.getChildAt(0).getTop() == paramRecyclerView.getPaddingTop()))
      {
        setDraggable(true);
        return;
      }
      setDraggable(false);
    }
  }
  
  public void computeScroll()
  {
    if ((!this.p1.isFinished()) && (this.p1.computeScrollOffset()))
    {
      int i = this.p1.getCurrY();
      scrollTo(0, i);
      if ((i != -this.O3) && (i != -this.N3) && ((!this.H3) || (i != -this.P3))) {
        invalidate();
      } else {
        this.p1.abortAnimation();
      }
    }
  }
  
  public Status getCurrentStatus()
  {
    int i = e.a[this.M3.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return Status.OPENED;
        }
        return Status.EXIT;
      }
      return Status.OPENED;
    }
    return Status.CLOSED;
  }
  
  public int getScreenHeight()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      i = getContext().getResources().getDimensionPixelSize(i);
    } else {
      i = 0;
    }
    return localDisplayMetrics.heightPixels - i;
  }
  
  public void m()
  {
    if (this.M3 == f.f) {
      return;
    }
    if (this.N3 == this.O3) {
      return;
    }
    int i = -getScrollY();
    int j = this.O3;
    i -= j;
    if (i == 0) {
      return;
    }
    this.M3 = f.x;
    j = Math.abs(i * 300 / (this.N3 - j));
    this.p1.startScroll(0, getScrollY(), 0, i, j + 100);
    invalidate();
  }
  
  public void n()
  {
    if (!this.H3) {
      return;
    }
    if (this.M3 == f.c) {
      return;
    }
    if (this.P3 == this.N3) {
      return;
    }
    int i = -getScrollY();
    int j = this.P3;
    i -= j;
    if (i == 0) {
      return;
    }
    this.M3 = f.x;
    j = Math.abs(i * 300 / (j - this.N3));
    this.p1.startScroll(0, getScrollY(), 0, i, j + 100);
    invalidate();
  }
  
  public void o()
  {
    if (this.M3 == f.d) {
      return;
    }
    if (this.N3 == this.O3) {
      return;
    }
    int i = -getScrollY();
    int j = this.N3;
    i -= j;
    if (i == 0) {
      return;
    }
    this.M3 = f.x;
    j = Math.abs(i * 300 / (j - this.O3));
    this.p1.startScroll(0, getScrollY(), 0, i, j + 100);
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.p3) {
      return false;
    }
    if ((!this.J3) && (this.M3 == f.f)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          if (!this.K3) {
            return false;
          }
          if (this.L3) {
            return true;
          }
          i = (int)(paramMotionEvent.getY() - this.z);
          int j = (int)(paramMotionEvent.getX() - this.y);
          if (Math.abs(i) < 10) {
            return false;
          }
          if ((Math.abs(i) < Math.abs(j)) && (this.I3))
          {
            this.K3 = false;
            this.L3 = false;
            return false;
          }
          paramMotionEvent = this.M3;
          if (paramMotionEvent == f.f)
          {
            if (i < 0) {
              return false;
            }
          }
          else if ((paramMotionEvent == f.d) && (!this.H3) && (i > 0)) {
            return false;
          }
          this.L3 = true;
          return true;
        }
      }
      this.K3 = true;
      this.L3 = false;
      if (this.M3 == f.q) {
        return true;
      }
    }
    else
    {
      this.q = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      this.x = f1;
      this.y = this.q;
      this.z = f1;
      this.K3 = true;
      this.L3 = false;
      if (!this.p1.isFinished())
      {
        this.p1.forceFinished(true);
        this.M3 = f.q;
        this.L3 = true;
        return true;
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.L3) {
      return false;
    }
    this.p2.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          i = (int)((paramMotionEvent.getY() - this.x) * 1.2F);
          i = (int)Math.signum(i) * Math.min(Math.abs(i), 30);
          if (i(i)) {
            return true;
          }
          this.M3 = f.q;
          i = getScrollY() - i;
          int j = this.O3;
          if (i >= -j)
          {
            scrollTo(0, -j);
          }
          else
          {
            j = this.N3;
            if ((i <= -j) && (!this.H3)) {
              scrollTo(0, -j);
            } else {
              scrollTo(0, i);
            }
          }
          this.x = paramMotionEvent.getY();
          return true;
        }
      }
      if (this.M3 == f.q)
      {
        h();
        return true;
      }
      return false;
    }
    this.x = paramMotionEvent.getY();
    return true;
  }
  
  public void p()
  {
    scrollTo(0, -this.O3);
    this.M3 = f.f;
    this.p0 = Status.CLOSED;
  }
  
  public void q()
  {
    if (!this.H3) {
      return;
    }
    scrollTo(0, -this.P3);
    this.M3 = f.c;
  }
  
  public void r()
  {
    scrollTo(0, -this.N3);
    this.M3 = f.d;
    this.p0 = Status.OPENED;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
    int i = this.N3;
    paramInt1 = this.O3;
    if (i == paramInt1) {
      return;
    }
    int j = -paramInt2;
    if (j <= i) {
      l((j - paramInt1) / (i - paramInt1));
    } else {
      l((j - i) / (i - this.P3));
    }
    f localf1;
    f localf2;
    if (paramInt2 == -this.O3)
    {
      localf1 = this.M3;
      localf2 = f.f;
      if (localf1 != localf2)
      {
        this.M3 = localf2;
        k(Status.CLOSED);
      }
    }
    else if (paramInt2 == -this.N3)
    {
      localf1 = this.M3;
      localf2 = f.d;
      if (localf1 != localf2)
      {
        this.M3 = localf2;
        k(Status.OPENED);
      }
    }
    else if ((this.H3) && (paramInt2 == -this.P3))
    {
      localf2 = this.M3;
      localf1 = f.c;
      if (localf2 != localf1)
      {
        this.M3 = localf1;
        k(Status.EXIT);
      }
    }
  }
  
  public void setAllowHorizontalScroll(boolean paramBoolean)
  {
    this.I3 = paramBoolean;
  }
  
  public void setAssociatedListView(AbsListView paramAbsListView)
  {
    paramAbsListView.setOnScrollListener(this.d);
    s(paramAbsListView);
  }
  
  public void setAssociatedRecyclerView(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.addOnScrollListener(this.f);
    t(paramRecyclerView);
  }
  
  public void setAssociatedScrollView(ContentScrollView paramContentScrollView)
  {
    this.R3 = paramContentScrollView;
    paramContentScrollView.setScrollbarFadingEnabled(false);
    this.R3.setOnScrollChangeListener(this.S3);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    this.J3 = paramBoolean;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
  }
  
  public void setExitOffset(int paramInt)
  {
    this.P3 = (getScreenHeight() - paramInt);
  }
  
  public void setIsSupportExit(boolean paramBoolean)
  {
    this.H3 = paramBoolean;
  }
  
  public void setMaxOffset(int paramInt)
  {
    this.N3 = (getScreenHeight() - paramInt);
  }
  
  public void setMinOffset(int paramInt)
  {
    this.O3 = paramInt;
  }
  
  public void setOnScrollChangedListener(g paramg)
  {
    this.Q3 = paramg;
  }
  
  public static enum Status
  {
    static
    {
      Status localStatus1 = new Status("EXIT", 0);
      EXIT = localStatus1;
      Status localStatus2 = new Status("OPENED", 1);
      OPENED = localStatus2;
      Status localStatus3 = new Status("CLOSED", 2);
      CLOSED = localStatus3;
      $VALUES = new Status[] { localStatus1, localStatus2, localStatus3 };
    }
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    a() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (paramFloat2 > 80.0F)
      {
        paramMotionEvent1 = ScrollLayout.a(ScrollLayout.this);
        paramMotionEvent2 = ScrollLayout.Status.OPENED;
        if ((paramMotionEvent1.equals(paramMotionEvent2)) && (-ScrollLayout.this.getScrollY() > ScrollLayout.c(ScrollLayout.this)))
        {
          ScrollLayout.b(ScrollLayout.this, ScrollLayout.Status.EXIT);
          ScrollLayout.this.n();
        }
        else
        {
          ScrollLayout.this.o();
          ScrollLayout.b(ScrollLayout.this, paramMotionEvent2);
        }
        return true;
      }
      boolean bool = paramFloat2 < 80.0F;
      if ((bool) && (ScrollLayout.this.getScrollY() <= -ScrollLayout.c(ScrollLayout.this)))
      {
        ScrollLayout.this.o();
        ScrollLayout.b(ScrollLayout.this, ScrollLayout.Status.OPENED);
        return true;
      }
      if ((bool) && (ScrollLayout.this.getScrollY() > -ScrollLayout.c(ScrollLayout.this)))
      {
        ScrollLayout.this.m();
        ScrollLayout.b(ScrollLayout.this, ScrollLayout.Status.CLOSED);
        return true;
      }
      return false;
    }
  }
  
  class b
    implements AbsListView.OnScrollListener
  {
    b() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      ScrollLayout.d(ScrollLayout.this, paramAbsListView);
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      ScrollLayout.d(ScrollLayout.this, paramAbsListView);
    }
  }
  
  class c
    extends RecyclerView.OnScrollListener
  {
    c() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      ScrollLayout.e(ScrollLayout.this, paramRecyclerView);
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ScrollLayout.e(ScrollLayout.this, paramRecyclerView);
    }
  }
  
  class d
    implements ContentScrollView.a
  {
    d() {}
    
    public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (ScrollLayout.f(ScrollLayout.this) == null) {
        return;
      }
      if (ScrollLayout.g(ScrollLayout.this) != null) {
        ScrollLayout.g(ScrollLayout.this).c(paramInt4);
      }
      if (ScrollLayout.f(ScrollLayout.this).getScrollY() == 0) {
        ScrollLayout.this.setDraggable(true);
      } else {
        ScrollLayout.this.setDraggable(false);
      }
    }
  }
  
  private static enum f
  {
    static
    {
      f localf1 = new f("EXIT", 0);
      c = localf1;
      f localf2 = new f("OPENED", 1);
      d = localf2;
      f localf3 = new f("CLOSED", 2);
      f = localf3;
      f localf4 = new f("MOVING", 3);
      q = localf4;
      f localf5 = new f("SCROLLING", 4);
      x = localf5;
      y = new f[] { localf1, localf2, localf3, localf4, localf5 };
    }
  }
  
  public static abstract interface g
  {
    public abstract void a(ScrollLayout.Status paramStatus);
    
    public abstract void b(float paramFloat);
    
    public abstract void c(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\yinglan\scrolllayout\ScrollLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */