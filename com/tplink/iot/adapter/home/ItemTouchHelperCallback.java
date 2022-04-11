package com.tplink.iot.adapter.home;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ItemTouchHelperCallback
  extends ItemTouchHelper.Callback
{
  private final HomeMainAdapter a;
  private boolean b = true;
  
  public ItemTouchHelperCallback(HomeMainAdapter paramHomeMainAdapter)
  {
    this.a = paramHomeMainAdapter;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    paramViewHolder.itemView.setAlpha(1.0F);
    if ((paramViewHolder instanceof i)) {
      ((i)paramViewHolder).a();
    }
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramRecyclerView.getLayoutManager() instanceof GridLayoutManager))
    {
      int i;
      if (!this.a.a()) {
        i = 0;
      } else {
        i = 15;
      }
      return ItemTouchHelper.Callback.makeMovementFlags(i, 0);
    }
    return ItemTouchHelper.Callback.makeMovementFlags(3, 48);
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return true;
  }
  
  public boolean isLongPressDragEnabled()
  {
    return this.b;
  }
  
  public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      paramFloat2 = Math.abs(paramFloat1) / paramViewHolder.itemView.getWidth();
      paramViewHolder.itemView.setAlpha(1.0F - paramFloat2);
      paramViewHolder.itemView.setTranslationX(paramFloat1);
    }
    else
    {
      super.onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if ((paramViewHolder1.getItemViewType() != paramViewHolder2.getItemViewType()) && (paramViewHolder2.getAdapterPosition() == 0)) {
      return false;
    }
    this.a.r(paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
    return true;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt != 0) && ((paramViewHolder instanceof i))) {
      ((i)paramViewHolder).b();
    }
    super.onSelectedChanged(paramViewHolder, paramInt);
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    this.a.q(paramViewHolder.getAdapterPosition());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\ItemTouchHelperCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */