package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class SmartListItemDecoration
  extends RecyclerView.ItemDecoration
{
  private Paint a;
  private int b;
  
  public SmartListItemDecoration(Context paramContext)
  {
    Paint localPaint = new Paint();
    this.a = localPaint;
    localPaint.setColor(paramContext.getResources().getColor(2131099922));
    this.b = paramContext.getResources().getDimensionPixelSize(2131165852);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    paramRect.set(0, 0, 0, 1);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = paramRecyclerView.getChildAt(j);
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(localView);
      Object localObject = null;
      if (j < i - 1) {
        paramState = paramRecyclerView.getChildAt(j + 1);
      } else {
        paramState = null;
      }
      if (paramState == null) {
        paramState = (RecyclerView.State)localObject;
      } else {
        paramState = paramRecyclerView.getChildViewHolder(paramState);
      }
      int k = localView.getLeft();
      int m = localView.getRight();
      int n = localView.getBottom();
      int i1 = k;
      if ((localViewHolder instanceof SmartActionAdapter.ActionHolder))
      {
        i1 = k;
        if ((paramState instanceof SmartActionAdapter.ActionHolder)) {
          i1 = k + this.b;
        }
      }
      paramCanvas.drawRect(i1, n, m, n + 1, this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartListItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */