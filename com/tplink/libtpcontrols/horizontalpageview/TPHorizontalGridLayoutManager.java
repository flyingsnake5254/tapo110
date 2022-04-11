package com.tplink.libtpcontrols.horizontalpageview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;

public class TPHorizontalGridLayoutManager
  extends GridLayoutManager
{
  private int a;
  private int b;
  private SparseArray<Rect> c = new SparseArray();
  
  public TPHorizontalGridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt1, paramInt2, paramBoolean);
  }
  
  public TPHorizontalGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private int a()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int b()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void c(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      return;
    }
    paramState = new Rect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingLeft() - getPaddingRight(), getHeight() - getPaddingTop() - getPaddingBottom());
    Object localObject1 = new Rect();
    int i = 0;
    int k;
    Object localObject2;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= getChildCount()) {
        break;
      }
      localObject2 = getChildAt(j);
      ((Rect)localObject1).left = getDecoratedLeft((View)localObject2);
      ((Rect)localObject1).top = getDecoratedTop((View)localObject2);
      ((Rect)localObject1).right = getDecoratedRight((View)localObject2);
      ((Rect)localObject1).bottom = getDecoratedBottom((View)localObject2);
      if (!Rect.intersects(paramState, (Rect)localObject1)) {
        removeAndRecycleView((View)localObject2, paramRecycler);
      }
    }
    while (k < getItemCount())
    {
      if (Rect.intersects(paramState, (Rect)this.c.get(k)))
      {
        localObject1 = paramRecycler.getViewForPosition(k);
        addView((View)localObject1);
        measureChildWithMargins((View)localObject1, this.a, this.b);
        localObject2 = (Rect)this.c.get(k);
        layoutDecorated((View)localObject1, ((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom);
      }
      k++;
    }
  }
  
  public boolean canScrollVertically()
  {
    return false;
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
    int i = b() / 4;
    int j = a() / 2;
    this.a = (i * 3);
    this.b = (j * 1);
    detachAndScrapAttachedViews(paramRecycler);
    int k = getItemCount();
    for (int m = 0; m < 2; m++) {
      for (int n = 0; n < 4; n++)
      {
        int i1 = m * 4 + n;
        if (i1 == k)
        {
          m = 2;
          break;
        }
        Object localObject = paramRecycler.getViewForPosition(i1);
        addView((View)localObject);
        measureChildWithMargins((View)localObject, this.a, this.b);
        int i2 = getDecoratedMeasuredWidth((View)localObject);
        int i3 = getDecoratedMeasuredHeight((View)localObject);
        Rect localRect = (Rect)this.c.get(i1);
        localObject = localRect;
        if (localRect == null) {
          localObject = new Rect();
        }
        int i4 = n * i;
        int i5 = m * j;
        ((Rect)localObject).set(i4, i5, i2 + i4, i3 + i5);
        this.c.put(i1, localObject);
      }
    }
    removeAndRecycleAllViews(paramRecycler);
    c(paramRecycler, paramState);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalpageview\TPHorizontalGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */