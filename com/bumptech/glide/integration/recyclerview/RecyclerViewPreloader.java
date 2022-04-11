package com.bumptech.glide.integration.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public final class RecyclerViewPreloader<T>
  extends RecyclerView.OnScrollListener
{
  private final RecyclerToListViewScrollListener a;
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.a.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\integration\recyclerview\RecyclerViewPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */