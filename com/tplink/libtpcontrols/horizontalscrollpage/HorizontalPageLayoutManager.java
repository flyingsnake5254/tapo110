package com.tplink.libtpcontrols.horizontalscrollpage;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;

public class HorizontalPageLayoutManager
  extends RecyclerView.LayoutManager
{
  private boolean a = false;
  private int b = 0;
  private int c = 0;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private SparseArray<Rect> i = new SparseArray();
  
  public HorizontalPageLayoutManager(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = (paramInt1 * paramInt2);
  }
  
  private int a()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int b()
  {
    return getWidth() - getPaddingStart() - getPaddingEnd();
  }
  
  private void c(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      return;
    }
    paramState = new Rect(getPaddingStart() + this.c, getPaddingTop(), getWidth() - getPaddingStart() - getPaddingEnd() + this.c, getHeight() - getPaddingTop() - getPaddingBottom());
    Object localObject1 = new Rect();
    int j = 0;
    int m;
    Object localObject2;
    for (int k = 0;; k++)
    {
      m = j;
      if (k >= getChildCount()) {
        break;
      }
      localObject2 = getChildAt(k);
      ((Rect)localObject1).left = getDecoratedLeft((View)localObject2);
      ((Rect)localObject1).top = getDecoratedTop((View)localObject2);
      ((Rect)localObject1).right = getDecoratedRight((View)localObject2);
      ((Rect)localObject1).bottom = getDecoratedBottom((View)localObject2);
      if (!Rect.intersects(paramState, (Rect)localObject1)) {
        removeAndRecycleView((View)localObject2, paramRecycler);
      }
    }
    while (m < getItemCount())
    {
      if (Rect.intersects(paramState, (Rect)this.i.get(m)))
      {
        localObject1 = paramRecycler.getViewForPosition(m);
        addView((View)localObject1);
        measureChildWithMargins((View)localObject1, this.g, this.h);
        localObject2 = (Rect)this.i.get(m);
        j = ((Rect)localObject2).left;
        k = this.c;
        layoutDecorated((View)localObject1, j - k, ((Rect)localObject2).top, ((Rect)localObject2).right - k, ((Rect)localObject2).bottom);
      }
      m++;
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return true;
  }
  
  public void d(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return null;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    this.c = 0;
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getItemCount() == 0)
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    if (paramState.isPreLayout()) {
      return;
    }
    int j = b() / this.e;
    int k = a();
    int m = this.d;
    int n = k / m;
    k = this.e;
    int i1 = 1;
    this.g = ((k - 1) * j);
    this.h = ((m - 1) * n);
    k = getItemCount() / this.f;
    if (getItemCount() % this.f == 0) {
      m = 0;
    } else {
      m = 1;
    }
    int i2 = k + m;
    m = (i2 - 1) * getWidth();
    this.b = m;
    if (this.a) {
      this.b = (-m);
    }
    detachAndScrapAttachedViews(paramRecycler);
    int i3 = getItemCount();
    for (k = 0; k < i2; k++)
    {
      m = 0;
      while (m < this.d)
      {
        int i4 = 0;
        for (;;)
        {
          int i5 = this.e;
          if (i4 >= i5) {
            break;
          }
          int i6 = this.f * k + i5 * m + i4;
          if (i6 == i3)
          {
            m = this.d;
            k = i2;
            break;
          }
          Object localObject = paramRecycler.getViewForPosition(i6);
          addView((View)localObject);
          measureChildWithMargins((View)localObject, this.g, this.h);
          int i7 = getDecoratedMeasuredWidth((View)localObject);
          int i8 = getDecoratedMeasuredHeight((View)localObject);
          Rect localRect = (Rect)this.i.get(i6);
          localObject = localRect;
          if (localRect == null) {
            localObject = new Rect();
          }
          i5 = b() * k + i4 * j;
          int i9 = m * n;
          i1 = i5;
          if (this.a)
          {
            i1 = -i5;
            i1 = (this.e - 1) * j + i1;
          }
          ((Rect)localObject).set(i1, i9, i7 + i1, i8 + i9);
          this.i.put(i6, localObject);
          i4++;
          i1 = 1;
        }
        m += i1;
      }
      removeAndRecycleAllViews(paramRecycler);
    }
    c(paramRecycler, paramState);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int j = this.c;
    int k = j + paramInt;
    int m;
    if (this.a)
    {
      m = this.b;
      if (k < m) {
        paramInt = j - m;
      } else if (k > 0) {
        paramInt = j;
      }
    }
    else
    {
      m = this.b;
      if (k > m) {
        paramInt = m - j;
      } else if (k < 0) {
        paramInt = -j;
      }
    }
    this.c = (j + paramInt);
    offsetChildrenHorizontal(-paramInt);
    c(paramRecycler, paramState);
    return paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalscrollpage\HorizontalPageLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */