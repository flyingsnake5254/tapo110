package com.tplink.iot.adapter.databinding;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import kotlin.collections.e;
import kotlin.jvm.internal.j;

public final class BlankAndDividerDecoration
  extends RecyclerView.ItemDecoration
{
  private final Paint a;
  private final Paint b;
  private final Paint c;
  private final Paint d;
  private float e;
  private final float f;
  private float g;
  private int[] h;
  private float i;
  private float j;
  private boolean k;
  
  public BlankAndDividerDecoration()
  {
    this(0.0F, 0.0F, 0.0F, null, 0.0F, 0.0F, 0, 0, 0, 0, false, 2047, null);
  }
  
  public BlankAndDividerDecoration(float paramFloat1, float paramFloat2, float paramFloat3, int[] paramArrayOfInt, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramArrayOfInt;
    this.i = paramFloat4;
    this.j = paramFloat5;
    this.k = paramBoolean;
    Paint localPaint1 = new Paint();
    this.a = localPaint1;
    paramArrayOfInt = new Paint();
    this.b = paramArrayOfInt;
    Paint localPaint2 = new Paint();
    this.c = localPaint2;
    Paint localPaint3 = new Paint();
    this.d = localPaint3;
    localPaint1.setColor(paramInt1);
    paramArrayOfInt.setColor(paramInt2);
    localPaint2.setColor(paramInt3);
    localPaint3.setColor(paramInt4);
    e.t(this.h);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    j.e(paramRect, "outRect");
    j.e(paramView, "view");
    j.e(paramRecyclerView, "parent");
    j.e(paramState, "state");
    int m = (int)this.i;
    int n;
    if (paramRecyclerView.getChildAdapterPosition(paramView) == 0) {
      n = (int)this.e;
    }
    for (float f1 = this.i;; f1 = this.i)
    {
      i1 = n + (int)f1;
      n = m;
      break label222;
      if (this.k)
      {
        i1 = paramRecyclerView.getChildAdapterPosition(paramView);
        paramState = paramRecyclerView.getAdapter();
        if (paramState != null) {
          n = paramState.getItemCount();
        } else {
          n = -1;
        }
        if (i1 == n) {
          return;
        }
      }
      i1 = paramRecyclerView.getChildAdapterPosition(paramView);
      paramState = paramRecyclerView.getAdapter();
      if (paramState != null)
      {
        n = paramState.getItemCount();
      }
      else
      {
        if (this.k) {
          n = 2;
        } else {
          n = 1;
        }
        n = 0 - n;
      }
      if (i1 == n)
      {
        n = m + (int)this.g;
        break;
      }
      n = m;
      if (!e.i(this.h, paramRecyclerView.getChildAdapterPosition(paramView))) {
        break;
      }
      n = (int)this.f;
    }
    int i1 = 0;
    label222:
    paramRect.set(0, i1, 0, n);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    j.e(paramCanvas, "c");
    j.e(paramRecyclerView, "parent");
    j.e(paramState, "state");
    int m = this.h.length - 1;
    for (int n = paramRecyclerView.getChildCount() - 1; n >= 0; n--)
    {
      paramState = paramRecyclerView.getChildAt(n);
      int i1;
      Object localObject;
      int i2;
      if (this.k)
      {
        i1 = paramRecyclerView.getChildAdapterPosition(paramState);
        localObject = paramRecyclerView.getAdapter();
        if (localObject != null) {
          i2 = ((RecyclerView.Adapter)localObject).getItemCount();
        } else {
          i2 = -1;
        }
        if (i1 == i2) {}
      }
      else
      {
        i1 = paramRecyclerView.getChildAdapterPosition(paramState);
        localObject = paramRecyclerView.getAdapter();
        if (localObject != null)
        {
          i2 = ((RecyclerView.Adapter)localObject).getItemCount();
        }
        else
        {
          if (this.k) {
            i2 = 2;
          } else {
            i2 = 1;
          }
          i2 = 0 - i2;
        }
        if (i1 == i2)
        {
          j.d(paramState, "childView");
          paramCanvas.drawRect(paramState.getLeft(), paramState.getBottom() + this.i, paramState.getRight(), paramState.getBottom() + this.g + this.i, this.c);
          paramCanvas.drawRect(paramState.getLeft(), paramState.getBottom(), paramState.getRight(), paramState.getBottom() + this.i, this.b);
        }
        else if ((m >= 0) && (paramRecyclerView.getChildAdapterPosition(paramState) == this.h[m] - 1))
        {
          j.d(paramState, "childView");
          paramCanvas.drawRect(paramState.getLeft(), paramState.getBottom(), paramState.getRight(), paramState.getBottom() + this.i, this.b);
          m--;
        }
        else
        {
          j.d(paramState, "childView");
          localObject = paramState.getContext();
          j.d(localObject, "childView.context");
          if (b.a((Context)localObject))
          {
            paramCanvas.drawRect(paramState.getLeft(), paramState.getBottom(), paramState.getRight() - this.j, paramState.getBottom() + this.i, this.b);
            paramCanvas.drawRect(paramState.getRight() - this.j, paramState.getBottom(), paramState.getRight(), paramState.getBottom() + this.i, this.d);
          }
          else
          {
            paramCanvas.drawRect(paramState.getLeft() + this.j, paramState.getBottom(), paramState.getRight(), paramState.getBottom() + this.i, this.b);
            paramCanvas.drawRect(paramState.getLeft(), paramState.getBottom(), paramState.getLeft() + this.j, paramState.getBottom() + this.i, this.d);
          }
        }
      }
      if (paramRecyclerView.getChildAdapterPosition(paramState) == 0)
      {
        j.d(paramState, "childView");
        paramCanvas.drawRect(paramState.getLeft(), paramState.getTop() - this.i - this.e, paramState.getRight(), paramState.getTop() - this.i, this.c);
        paramCanvas.drawRect(paramState.getLeft(), paramState.getTop() - this.i, paramState.getRight(), paramState.getTop(), this.a);
      }
      else if ((m >= 0) && (paramRecyclerView.getChildAdapterPosition(paramState) == this.h[m]))
      {
        j.d(paramState, "childView");
        paramCanvas.drawRect(paramState.getLeft(), paramState.getTop() - this.i - this.f, paramState.getRight(), paramState.getTop() - this.i, this.c);
        paramCanvas.drawRect(paramState.getLeft(), paramState.getTop() - this.i, paramState.getRight(), paramState.getTop(), this.a);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\databinding\BlankAndDividerDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */