package com.tplink.iot.Utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public class z
{
  public static void a(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramRecyclerView.getChildAt(0));
    int j = paramRecyclerView.getChildLayoutPosition(paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1));
    if (paramInt < i)
    {
      paramRecyclerView.smoothScrollToPosition(paramInt);
    }
    else if (paramInt <= j)
    {
      paramInt -= i;
      if ((paramInt >= 0) && (paramInt < paramRecyclerView.getChildCount())) {
        paramRecyclerView.smoothScrollBy(0, paramRecyclerView.getChildAt(paramInt).getTop());
      }
    }
    else
    {
      paramRecyclerView.smoothScrollToPosition(paramInt);
      paramRecyclerView.addOnScrollListener(new a(paramInt));
    }
  }
  
  static final class a
    extends RecyclerView.OnScrollListener
  {
    a(int paramInt) {}
    
    public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.removeOnScrollListener(this);
      }
    }
    
    public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if (paramRecyclerView.getLayoutManager().findViewByPosition(this.a) != null)
      {
        z.a(paramRecyclerView, this.a);
        paramRecyclerView.removeOnScrollListener(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */