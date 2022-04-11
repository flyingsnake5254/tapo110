package com.tplink.libtpcontrols.recycleviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tplink.libtpcontrols.x0;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewPager
  extends RecyclerView
{
  View H3;
  int I3 = Integer.MIN_VALUE;
  int J3 = Integer.MAX_VALUE;
  int K3 = Integer.MIN_VALUE;
  int L3 = Integer.MAX_VALUE;
  private int M3 = -1;
  private boolean N3 = true;
  private boolean O3 = false;
  private RecyclerViewPagerAdapter<?> c;
  private float d = 0.25F;
  private float f = 0.15F;
  private boolean p0;
  boolean p1;
  int p2;
  int p3;
  private float q;
  private List<c> x;
  private int y = -1;
  private int z = -1;
  
  public RecyclerViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i(paramContext, paramAttributeSet, paramInt);
    setNestedScrollingEnabled(false);
  }
  
  private int h(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i;
    if (paramInt1 > 0) {
      i = 1;
    } else {
      i = -1;
    }
    return (int)(i * Math.ceil(paramInt1 * i * this.f / paramInt2 - this.d));
  }
  
  private void i(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.RecyclerViewPager, paramInt, 0);
    this.f = paramContext.getFloat(x0.RecyclerViewPager_rvp_flingFactor, 0.15F);
    this.d = paramContext.getFloat(x0.RecyclerViewPager_rvp_triggerOffset, 0.25F);
    this.p0 = paramContext.getBoolean(x0.RecyclerViewPager_rvp_singlePageFling, this.p0);
    paramContext.recycle();
  }
  
  private int j(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return 0;
    }
    if (paramInt1 >= paramInt2) {
      return paramInt2 - 1;
    }
    return paramInt1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i;
      if (getLayoutManager().canScrollHorizontally()) {
        i = a.b(this);
      } else {
        i = a.d(this);
      }
      this.M3 = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPositionOnTouchDown:");
      localStringBuilder.append(this.M3);
      b.d.w.c.a.c("@", localStringBuilder.toString());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void e(int paramInt)
  {
    int i = paramInt;
    if (this.O3) {
      i = paramInt * -1;
    }
    if (getChildCount() > 0)
    {
      int j = a.b(this);
      i = h(i, getWidth() - getPaddingLeft() - getPaddingRight());
      paramInt = j + i;
      if (this.p0)
      {
        i = Math.max(-1, Math.min(1, i));
        if (i == 0) {
          paramInt = j;
        } else {
          paramInt = this.M3 + i;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("flingCount:");
        ((StringBuilder)localObject).append(i);
        b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("original targetPosition:");
        ((StringBuilder)localObject).append(paramInt);
        b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
      }
      i = Math.min(Math.max(paramInt, 0), this.c.getItemCount() - 1);
      paramInt = i;
      if (i == j) {
        if (this.p0)
        {
          paramInt = i;
          if (this.M3 != j) {}
        }
        else
        {
          localObject = a.a(this);
          paramInt = i;
          if (localObject != null)
          {
            float f1 = this.q;
            float f2 = ((View)localObject).getWidth();
            float f3 = this.d;
            if ((f1 > f2 * f3 * f3) && (i != 0)) {
              if (!this.O3)
              {
                paramInt = i - 1;
                break label311;
              }
            }
            for (;;)
            {
              paramInt = i + 1;
              break label311;
              paramInt = i;
              if (this.q >= ((View)localObject).getWidth() * -this.d) {
                break label311;
              }
              paramInt = i;
              if (i == this.c.getItemCount() - 1) {
                break label311;
              }
              if (this.O3) {
                break;
              }
            }
          }
        }
      }
      label311:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mTouchSpan:");
      ((StringBuilder)localObject).append(this.q);
      b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adjustPositionX:");
      ((StringBuilder)localObject).append(paramInt);
      b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
      smoothScrollToPosition(j(paramInt, this.c.getItemCount()));
    }
  }
  
  protected void f(int paramInt)
  {
    int i = paramInt;
    if (this.O3) {
      i = paramInt * -1;
    }
    if (getChildCount() > 0)
    {
      int j = a.d(this);
      i = h(i, getHeight() - getPaddingTop() - getPaddingBottom());
      paramInt = j + i;
      if (this.p0)
      {
        paramInt = Math.max(-1, Math.min(1, i));
        if (paramInt == 0) {
          paramInt = j;
        } else {
          paramInt = this.M3 + paramInt;
        }
      }
      i = Math.min(Math.max(paramInt, 0), this.c.getItemCount() - 1);
      paramInt = i;
      if (i == j) {
        if (this.p0)
        {
          paramInt = i;
          if (this.M3 != j) {}
        }
        else
        {
          localObject = a.c(this);
          paramInt = i;
          if (localObject != null)
          {
            if ((this.q > ((View)localObject).getHeight() * this.d) && (i != 0)) {
              if (!this.O3)
              {
                paramInt = i - 1;
                break label228;
              }
            }
            for (;;)
            {
              paramInt = i + 1;
              break label228;
              paramInt = i;
              if (this.q >= ((View)localObject).getHeight() * -this.d) {
                break label228;
              }
              paramInt = i;
              if (i == this.c.getItemCount() - 1) {
                break label228;
              }
              if (this.O3) {
                break;
              }
            }
          }
        }
      }
      label228:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mTouchSpan:");
      ((StringBuilder)localObject).append(this.q);
      b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adjustPositionY:");
      ((StringBuilder)localObject).append(paramInt);
      b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
      smoothScrollToPosition(j(paramInt, this.c.getItemCount()));
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1;
    float f2 = this.f;
    boolean bool = super.fling((int)(f1 * f2), (int)(paramInt2 * f2));
    if (bool) {
      if (getLayoutManager().canScrollHorizontally()) {
        e(paramInt1);
      } else {
        f(paramInt2);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("velocityX:");
    localStringBuilder.append(paramInt1);
    b.d.w.c.a.c("@", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("velocityY:");
    localStringBuilder.append(paramInt2);
    b.d.w.c.a.c("@", localStringBuilder.toString());
    return bool;
  }
  
  @NonNull
  protected RecyclerViewPagerAdapter g(RecyclerView.Adapter paramAdapter)
  {
    if ((paramAdapter instanceof RecyclerViewPagerAdapter)) {
      paramAdapter = (RecyclerViewPagerAdapter)paramAdapter;
    } else {
      paramAdapter = new RecyclerViewPagerAdapter(this, paramAdapter);
    }
    return paramAdapter;
  }
  
  public RecyclerView.Adapter getAdapter()
  {
    RecyclerViewPagerAdapter localRecyclerViewPagerAdapter = this.c;
    if (localRecyclerViewPagerAdapter != null) {
      return localRecyclerViewPagerAdapter.b;
    }
    return null;
  }
  
  public int getCurrentPosition()
  {
    int i;
    if (getLayoutManager().canScrollHorizontally()) {
      i = a.b(this);
    } else {
      i = a.d(this);
    }
    int j = i;
    if (i < 0) {
      j = this.y;
    }
    return j;
  }
  
  public float getFlingFactor()
  {
    return this.f;
  }
  
  public float getTriggerOffset()
  {
    return this.d;
  }
  
  public RecyclerViewPagerAdapter getWrapperAdapter()
  {
    return this.c;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    try
    {
      Object localObject1 = paramParcelable.getClass().getDeclaredField("mLayoutState");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(paramParcelable);
      Field localField1 = localObject1.getClass().getDeclaredField("mAnchorOffset");
      Field localField2 = localObject1.getClass().getDeclaredField("mAnchorPosition");
      localField2.setAccessible(true);
      localField1.setAccessible(true);
      if (localField1.getInt(localObject1) > 0) {
        localField2.set(localObject1, Integer.valueOf(localField2.getInt(localObject1) - 1));
      } else if (localField1.getInt(localObject1) < 0) {
        localField2.set(localObject1, Integer.valueOf(localField2.getInt(localObject1) + 1));
      }
      localField1.setInt(localObject1, 0);
    }
    finally
    {
      ((Throwable)localObject2).printStackTrace();
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    super.onScrollStateChanged(paramInt);
    Object localObject;
    if (paramInt == 1)
    {
      this.p1 = true;
      if (getLayoutManager().canScrollHorizontally()) {
        localObject = a.a(this);
      } else {
        localObject = a.c(this);
      }
      this.H3 = ((View)localObject);
      if (localObject != null)
      {
        if (this.N3)
        {
          this.z = getChildLayoutPosition((View)localObject);
          this.N3 = false;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mPositionBeforeScroll:");
        ((StringBuilder)localObject).append(this.z);
        b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
        this.p2 = this.H3.getLeft();
        this.p3 = this.H3.getTop();
      }
      else
      {
        this.z = -1;
      }
      this.q = 0.0F;
    }
    else if (paramInt == 2)
    {
      this.p1 = false;
      if (this.H3 != null)
      {
        if (getLayoutManager().canScrollHorizontally()) {
          this.q = (this.H3.getLeft() - this.p2);
        } else {
          this.q = (this.H3.getTop() - this.p3);
        }
      }
      else {
        this.q = 0.0F;
      }
      this.H3 = null;
    }
    else if (paramInt == 0)
    {
      if (this.p1)
      {
        if (getLayoutManager().canScrollHorizontally()) {
          paramInt = a.b(this);
        } else {
          paramInt = a.d(this);
        }
        localObject = this.H3;
        if (localObject != null)
        {
          int i = getChildAdapterPosition((View)localObject);
          float f1;
          if (getLayoutManager().canScrollHorizontally())
          {
            f1 = this.H3.getLeft() - this.p2;
            if ((f1 > this.H3.getWidth() * this.d) && (this.H3.getLeft() >= this.I3))
            {
              if (this.O3) {
                break label447;
              }
            }
            else
            {
              paramInt = i;
              if (f1 >= this.H3.getWidth() * -this.d) {
                break label502;
              }
              paramInt = i;
              if (this.H3.getLeft() > this.J3) {
                break label502;
              }
              if (!this.O3) {
                break label447;
              }
            }
          }
          else
          {
            f1 = this.H3.getTop() - this.p3;
            if ((f1 <= this.H3.getHeight() * this.d) || (this.H3.getTop() < this.K3)) {
              break label454;
            }
            if (this.O3) {
              break label447;
            }
          }
          paramInt = i - 1;
          break label502;
          for (;;)
          {
            label447:
            paramInt = i + 1;
            break label502;
            label454:
            paramInt = i;
            if (f1 >= this.H3.getHeight() * -this.d) {
              break label502;
            }
            paramInt = i;
            if (this.H3.getTop() > this.L3) {
              break label502;
            }
            if (this.O3) {
              break;
            }
          }
        }
        label502:
        smoothScrollToPosition(j(paramInt, this.c.getItemCount()));
        this.H3 = null;
      }
      else if (this.y != this.z)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPageChanged:");
        ((StringBuilder)localObject).append(this.y);
        b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
        localObject = this.x;
        if (localObject != null)
        {
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext())
          {
            localObject = (c)localIterator.next();
            if (localObject != null) {
              ((c)localObject).a(this.z, this.y);
            }
          }
        }
        this.N3 = true;
        this.z = this.y;
      }
      this.I3 = Integer.MIN_VALUE;
      this.J3 = Integer.MAX_VALUE;
      this.K3 = Integer.MIN_VALUE;
      this.L3 = Integer.MAX_VALUE;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 2)
    {
      View localView = this.H3;
      if (localView != null)
      {
        this.I3 = Math.max(localView.getLeft(), this.I3);
        this.K3 = Math.max(this.H3.getTop(), this.K3);
        this.J3 = Math.min(this.H3.getLeft(), this.J3);
        this.L3 = Math.min(this.H3.getTop(), this.L3);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void scrollToPosition(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scrollToPosition:");
    localStringBuilder.append(paramInt);
    b.d.w.c.a.c("@", localStringBuilder.toString());
    this.z = getCurrentPosition();
    this.y = paramInt;
    super.scrollToPosition(paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(new b());
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    paramAdapter = g(paramAdapter);
    this.c = paramAdapter;
    super.setAdapter(paramAdapter);
  }
  
  public void setFlingFactor(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    if ((paramLayoutManager instanceof LinearLayoutManager)) {
      this.O3 = ((LinearLayoutManager)paramLayoutManager).getReverseLayout();
    }
  }
  
  public void setSinglePageFling(boolean paramBoolean)
  {
    this.p0 = paramBoolean;
  }
  
  public void setTriggerOffset(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("smoothScrollToPosition:");
    ((StringBuilder)localObject).append(paramInt);
    b.d.w.c.a.c("@", ((StringBuilder)localObject).toString());
    this.y = paramInt;
    if ((getLayoutManager() != null) && ((getLayoutManager() instanceof LinearLayoutManager)))
    {
      localObject = new a(getContext());
      ((RecyclerView.SmoothScroller)localObject).setTargetPosition(paramInt);
      if (paramInt == -1) {
        return;
      }
      getLayoutManager().startSmoothScroll((RecyclerView.SmoothScroller)localObject);
    }
    else
    {
      super.smoothScrollToPosition(paramInt);
    }
  }
  
  public void swapAdapter(RecyclerView.Adapter paramAdapter, boolean paramBoolean)
  {
    paramAdapter = g(paramAdapter);
    this.c = paramAdapter;
    super.swapAdapter(paramAdapter, paramBoolean);
  }
  
  class a
    extends LinearSmoothScroller
  {
    a(Context paramContext)
    {
      super();
    }
    
    public PointF computeScrollVectorForPosition(int paramInt)
    {
      if (getLayoutManager() == null) {
        return null;
      }
      return ((LinearLayoutManager)getLayoutManager()).computeScrollVectorForPosition(paramInt);
    }
    
    protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
    {
      if (getLayoutManager() == null) {
        return;
      }
      int i = calculateDxToMakeVisible(paramView, getHorizontalSnapPreference());
      int j = calculateDyToMakeVisible(paramView, getVerticalSnapPreference());
      if (i > 0) {
        i -= getLayoutManager().getLeftDecorationWidth(paramView);
      } else {
        i += getLayoutManager().getRightDecorationWidth(paramView);
      }
      if (j > 0) {
        j -= getLayoutManager().getTopDecorationHeight(paramView);
      } else {
        j += getLayoutManager().getBottomDecorationHeight(paramView);
      }
      int k = calculateTimeForDeceleration((int)Math.sqrt(i * i + j * j));
      if (k > 0) {
        paramAction.update(-i, -j, k, this.mDecelerateInterpolator);
      }
    }
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public void onGlobalLayout()
    {
      if (Build.VERSION.SDK_INT < 16) {
        RecyclerViewPager.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      } else {
        RecyclerViewPager.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((RecyclerViewPager.a(RecyclerViewPager.this) >= 0) && (RecyclerViewPager.a(RecyclerViewPager.this) < RecyclerViewPager.b(RecyclerViewPager.this).getItemCount()) && (RecyclerViewPager.c(RecyclerViewPager.this) != null))
      {
        Iterator localIterator = RecyclerViewPager.c(RecyclerViewPager.this).iterator();
        while (localIterator.hasNext())
        {
          RecyclerViewPager.c localc = (RecyclerViewPager.c)localIterator.next();
          if (localc != null) {
            localc.a(RecyclerViewPager.d(RecyclerViewPager.this), RecyclerViewPager.this.getCurrentPosition());
          }
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\recycleviewpager\RecyclerViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */