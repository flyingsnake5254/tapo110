package com.tplink.iot.adapter.home;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tplink.iot.Utils.j;

public class HomeShortcutItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public HomeShortcutItemDecoration(Context paramContext)
  {
    this.a = j.a(paramContext, 16.0F);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView.getChildAdapterPosition(paramView) == 0) {
      paramRect.left = this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\HomeShortcutItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */