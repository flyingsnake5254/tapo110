package com.tplink.libtpcontrols.snaprecycleview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public class SnappingRecyclerView
  extends RecyclerView
{
  private boolean H3 = true;
  private boolean I3;
  private boolean c = false;
  private boolean d = false;
  private int f = 0;
  private c p0;
  private d p1;
  private int p2;
  private boolean p3 = false;
  private long q = 0L;
  private Handler x = new Handler();
  private boolean y = false;
  private Orientation z = Orientation.HORIZONTAL;
  
  public SnappingRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnappingRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnappingRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    o();
  }
  
  private int getCenterLocation()
  {
    if (this.z == Orientation.VERTICAL) {
      return getMeasuredHeight() / 2;
    }
    return getMeasuredWidth() / 2;
  }
  
  private View getCenterView()
  {
    return l(getCenterLocation());
  }
  
  private void k()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(new a());
    addOnScrollListener(new b());
  }
  
  private View l(int paramInt)
  {
    int i = getChildCount();
    Object localObject = null;
    if (i <= 0) {
      return null;
    }
    int j = 9999;
    i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      int k = (int)this.p0.a(localView) - paramInt;
      int m = j;
      if (Math.abs(k) < Math.abs(j))
      {
        localObject = localView;
        m = k;
      }
      i++;
      j = m;
    }
    return (View)localObject;
  }
  
  private float m(View paramView)
  {
    float f1 = getCenterLocation();
    float f2 = this.p0.a(paramView);
    return (Math.max(f1, f2) - Math.min(f1, f2)) / (f1 + this.p0.c(paramView));
  }
  
  private int n(View paramView)
  {
    return (int)this.p0.a(paramView) - getCenterLocation();
  }
  
  private void o()
  {
    setHasFixedSize(true);
    setOrientation(this.z);
    k();
  }
  
  private void q()
  {
    View localView = getCenterView();
    int i = getChildAdapterPosition(localView);
    d locald = this.p1;
    if ((locald != null) && (i != this.p2)) {
      locald.a(localView, i);
    }
    this.p2 = i;
  }
  
  private void r(View paramView)
  {
    if (paramView == null) {
      return;
    }
    stopScroll();
    int i = n(paramView);
    if (i != 0) {
      s(i);
    }
  }
  
  private void setMarginsForChild(View paramView)
  {
    int i = getLayoutManager().getItemCount() - 1;
    int j = getChildAdapterPosition(paramView);
    Orientation localOrientation1 = this.z;
    Orientation localOrientation2 = Orientation.VERTICAL;
    int k = 0;
    int m;
    int n;
    if (localOrientation1 == localOrientation2)
    {
      if (j == 0) {
        m = getCenterLocation();
      } else {
        m = 0;
      }
      if (j == i) {
        n = getCenterLocation();
      } else {
        n = 0;
      }
      j = n;
      n = 0;
      i = m;
    }
    else
    {
      if (j == 0) {
        n = getCenterLocation();
      } else {
        n = 0;
      }
      if (j == i) {
        m = getCenterLocation();
      } else {
        m = 0;
      }
      j = 0;
      i = 0;
      k = n;
      n = m;
    }
    if ((this.z == Orientation.HORIZONTAL) && (Build.VERSION.SDK_INT >= 17))
    {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).setMarginStart(k);
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).setMarginEnd(n);
    }
    if (ViewCompat.getLayoutDirection(paramView) == 1) {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).setMargins(n, i, k, j);
    } else {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).setMargins(k, i, n, j);
    }
    if ((Build.VERSION.SDK_INT >= 18) && (!paramView.isInLayout())) {
      paramView.requestLayout();
    }
  }
  
  private void t()
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      Object localObject1 = getChildAt(i);
      setMarginsForChild((View)localObject1);
      float f1;
      if (this.y)
      {
        f1 = 1.0F - m((View)localObject1) * 0.6F;
        ((View)localObject1).setScaleX(f1);
        ((View)localObject1).setScaleY(f1);
      }
      if (this.p3)
      {
        f1 = m((View)localObject1);
        if (this.H3)
        {
          ((View)localObject1).setAlpha(1.0F - f1);
          localObject1 = getChildViewHolder((View)localObject1);
          Object localObject2;
          try
          {
            localObject1 = (SnapViewHolder)localObject1;
          }
          catch (ClassCastException localClassCastException)
          {
            localObject2 = null;
          }
          if (f1 < 0.3F)
          {
            if (localObject2 != null) {
              ((SnapViewHolder)localObject2).a.setVisibility(0);
            }
          }
          else if (localObject2 != null) {
            ((SnapViewHolder)localObject2).a.setVisibility(4);
          }
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    long l = System.currentTimeMillis();
    if ((this.d) && (this.f == 1) && (l - this.q < 20L)) {
      this.c = true;
    }
    this.q = l;
    float f1;
    if (this.z == Orientation.VERTICAL) {
      f1 = paramMotionEvent.getY();
    } else {
      f1 = paramMotionEvent.getX();
    }
    View localView = l((int)f1);
    if ((!this.c) && (paramMotionEvent.getAction() == 1) && (localView != getCenterView()))
    {
      r(localView);
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getScrollOffset()
  {
    if (this.z == Orientation.VERTICAL) {
      return computeVerticalScrollOffset();
    }
    return computeHorizontalScrollOffset();
  }
  
  public void onChildAttachedToWindow(@NonNull View paramView)
  {
    super.onChildAttachedToWindow(paramView);
    if ((!this.I3) && (this.f == 0))
    {
      this.I3 = true;
      r(getCenterView());
      t();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.x.removeCallbacksAndMessages(null);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1;
    if (this.z == Orientation.VERTICAL) {
      f1 = paramMotionEvent.getY();
    } else {
      f1 = paramMotionEvent.getX();
    }
    if (l((int)f1) != getCenterView()) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected boolean p()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 17) {
      return false;
    }
    if (TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void s(int paramInt)
  {
    if (this.z == Orientation.VERTICAL)
    {
      super.smoothScrollBy(0, paramInt);
      return;
    }
    super.smoothScrollBy(paramInt, 0);
  }
  
  public void scrollToPosition(int paramInt)
  {
    int i = paramInt;
    if (p()) {
      i = -paramInt;
    }
    this.p0.c(getChildAt(0));
    s(this.p0.c(getChildAt(0)) * i);
  }
  
  public void setOnViewSelectedListener(d paramd)
  {
    this.p1 = paramd;
  }
  
  public void setOrientation(Orientation paramOrientation)
  {
    this.z = paramOrientation;
    this.p0 = new c(paramOrientation);
    setLayoutManager(new LinearLayoutManager(getContext(), this.z.intValue(), false));
  }
  
  public static enum Orientation
  {
    int value;
    
    static
    {
      Orientation localOrientation1 = new Orientation("HORIZONTAL", 0, 0);
      HORIZONTAL = localOrientation1;
      Orientation localOrientation2 = new Orientation("VERTICAL", 1, 1);
      VERTICAL = localOrientation2;
      $VALUES = new Orientation[] { localOrientation1, localOrientation2 };
    }
    
    private Orientation(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int intValue()
    {
      return this.value;
    }
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      SnappingRecyclerView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
  
  class b
    extends RecyclerView.OnScrollListener
  {
    b() {}
    
    public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 1)
      {
        if (!SnappingRecyclerView.b(SnappingRecyclerView.this)) {
          SnappingRecyclerView.e(SnappingRecyclerView.this, true);
        }
      }
      else if (paramInt == 0)
      {
        if (SnappingRecyclerView.d(SnappingRecyclerView.this))
        {
          paramRecyclerView = SnappingRecyclerView.this;
          SnappingRecyclerView.g(paramRecyclerView, SnappingRecyclerView.f(paramRecyclerView));
        }
        SnappingRecyclerView.e(SnappingRecyclerView.this, false);
        SnappingRecyclerView.c(SnappingRecyclerView.this, false);
        if (SnappingRecyclerView.f(SnappingRecyclerView.this) != null)
        {
          paramRecyclerView = SnappingRecyclerView.this;
          if (SnappingRecyclerView.h(paramRecyclerView, SnappingRecyclerView.f(paramRecyclerView)) > 0.0F)
          {
            paramRecyclerView = SnappingRecyclerView.this;
            SnappingRecyclerView.g(paramRecyclerView, SnappingRecyclerView.f(paramRecyclerView));
          }
        }
        SnappingRecyclerView.i(SnappingRecyclerView.this);
      }
      else if (paramInt == 2)
      {
        SnappingRecyclerView.c(SnappingRecyclerView.this, true);
      }
      SnappingRecyclerView.j(SnappingRecyclerView.this, paramInt);
    }
    
    public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      SnappingRecyclerView.a(SnappingRecyclerView.this);
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    }
  }
  
  private static class c
  {
    private SnappingRecyclerView.Orientation a;
    
    public c(SnappingRecyclerView.Orientation paramOrientation)
    {
      this.a = paramOrientation;
    }
    
    public float a(View paramView)
    {
      return b(paramView) + c(paramView) / 2;
    }
    
    public float b(View paramView)
    {
      if (this.a == SnappingRecyclerView.Orientation.VERTICAL) {
        return paramView.getY();
      }
      return paramView.getX();
    }
    
    public int c(View paramView)
    {
      if (this.a == SnappingRecyclerView.Orientation.VERTICAL) {
        return paramView.getHeight();
      }
      return paramView.getWidth();
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\snaprecycleview\SnappingRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */