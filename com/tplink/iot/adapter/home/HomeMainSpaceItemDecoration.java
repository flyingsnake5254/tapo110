package com.tplink.iot.adapter.home;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tplink.iot.Utils.j;

public class HomeMainSpaceItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public HomeMainSpaceItemDecoration(Context paramContext, int paramInt)
  {
    this.a = j.a(paramContext, paramInt);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = this.a;
    paramRect.left = i;
    paramRect.right = i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\HomeMainSpaceItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */