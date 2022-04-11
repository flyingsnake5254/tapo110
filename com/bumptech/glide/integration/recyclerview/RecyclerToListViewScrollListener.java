package com.bumptech.glide.integration.recyclerview;

import android.widget.AbsListView.OnScrollListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public final class RecyclerToListViewScrollListener
  extends RecyclerView.OnScrollListener
{
  private final AbsListView.OnScrollListener a;
  private int b;
  private int c;
  private int d;
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          i = Integer.MIN_VALUE;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    this.a.onScrollStateChanged(null, i);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    paramInt2 = localLinearLayoutManager.findFirstVisibleItemPosition();
    int i = Math.abs(paramInt2 - localLinearLayoutManager.findLastVisibleItemPosition());
    paramInt1 = paramRecyclerView.getAdapter().getItemCount();
    if ((paramInt2 != this.b) || (i != this.c) || (paramInt1 != this.d))
    {
      this.a.onScroll(null, paramInt2, i, paramInt1);
      this.b = paramInt2;
      this.c = i;
      this.d = paramInt1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\integration\recyclerview\RecyclerToListViewScrollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */