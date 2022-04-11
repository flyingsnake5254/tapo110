package com.tplink.iot.view.ipcamera.memories;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class GridSpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  private boolean c;
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    int j = this.a;
    int k = i % j;
    int m;
    if (this.c)
    {
      m = this.b;
      paramRect.left = (m - k * m / j);
      paramRect.right = ((k + 1) * m / j);
      if (i < j) {
        paramRect.top = m;
      }
      paramRect.bottom = m;
    }
    else
    {
      m = this.b;
      paramRect.left = (k * m / j);
      paramRect.right = (m - (k + 1) * m / j);
      if (i >= j) {
        paramRect.top = m;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\GridSpacingItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */