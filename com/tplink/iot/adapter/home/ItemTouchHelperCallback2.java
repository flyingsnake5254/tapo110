package com.tplink.iot.adapter.home;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ItemTouchHelperCallback2
  extends ItemTouchHelper.Callback
{
  private k a;
  
  public ItemTouchHelperCallback2(k paramk)
  {
    this.a = paramk;
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    paramViewHolder.itemView.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return false;
  }
  
  public boolean isLongPressDragEnabled()
  {
    k localk = this.a;
    if (localk != null) {
      return localk.e();
    }
    return false;
  }
  
  public void onChildDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    super.onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    this.a.f(paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
    return true;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onSelectedChanged(paramViewHolder, paramInt);
    if (paramInt == 2) {
      paramViewHolder.itemView.setBackgroundColor(Color.parseColor("#EFEFEF"));
    }
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\ItemTouchHelperCallback2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */