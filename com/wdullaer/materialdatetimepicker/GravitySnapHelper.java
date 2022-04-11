package com.wdullaer.materialdatetimepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;

public class GravitySnapHelper
  extends LinearSnapHelper
{
  private OrientationHelper a;
  private OrientationHelper b;
  private int c;
  private boolean d;
  private b e;
  private boolean f;
  private RecyclerView.OnScrollListener g = new a();
  
  public GravitySnapHelper(int paramInt)
  {
    this(paramInt, null);
  }
  
  public GravitySnapHelper(int paramInt, b paramb)
  {
    if ((paramInt != 8388611) && (paramInt != 8388613) && (paramInt != 80) && (paramInt != 48)) {
      throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
    }
    this.c = paramInt;
    this.e = paramb;
  }
  
  private int e(View paramView, OrientationHelper paramOrientationHelper, boolean paramBoolean)
  {
    if ((this.d) && (!paramBoolean)) {
      return f(paramView, paramOrientationHelper, true);
    }
    return paramOrientationHelper.getDecoratedEnd(paramView) - paramOrientationHelper.getEndAfterPadding();
  }
  
  private int f(View paramView, OrientationHelper paramOrientationHelper, boolean paramBoolean)
  {
    if ((this.d) && (!paramBoolean)) {
      return e(paramView, paramOrientationHelper, true);
    }
    return paramOrientationHelper.getDecoratedStart(paramView) - paramOrientationHelper.getStartAfterPadding();
  }
  
  private View g(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      int i = ((LinearLayoutManager)paramLayoutManager).findLastVisibleItemPosition();
      if (i == -1) {
        return null;
      }
      View localView = paramLayoutManager.findViewByPosition(i);
      float f1;
      int j;
      if (this.d)
      {
        f1 = paramOrientationHelper.getDecoratedEnd(localView);
        j = paramOrientationHelper.getDecoratedMeasurement(localView);
      }
      else
      {
        f1 = paramOrientationHelper.getTotalSpace() - paramOrientationHelper.getDecoratedStart(localView);
        j = paramOrientationHelper.getDecoratedMeasurement(localView);
      }
      f1 /= j;
      if (((LinearLayoutManager)paramLayoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if ((f1 > 0.5F) && (j == 0)) {
        return localView;
      }
      if (j != 0) {
        return null;
      }
      return paramLayoutManager.findViewByPosition(i - 1);
    }
    return null;
  }
  
  private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.b == null) {
      this.b = OrientationHelper.createHorizontalHelper(paramLayoutManager);
    }
    return this.b;
  }
  
  private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.a == null) {
      this.a = OrientationHelper.createVerticalHelper(paramLayoutManager);
    }
    return this.a;
  }
  
  private View h(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      int i = ((LinearLayoutManager)paramLayoutManager).findFirstVisibleItemPosition();
      if (i == -1) {
        return null;
      }
      View localView = paramLayoutManager.findViewByPosition(i);
      float f1;
      int j;
      if (this.d)
      {
        f1 = paramOrientationHelper.getTotalSpace() - paramOrientationHelper.getDecoratedStart(localView);
        j = paramOrientationHelper.getDecoratedMeasurement(localView);
      }
      else
      {
        f1 = paramOrientationHelper.getDecoratedEnd(localView);
        j = paramOrientationHelper.getDecoratedMeasurement(localView);
      }
      f1 /= j;
      if (((LinearLayoutManager)paramLayoutManager).findLastCompletelyVisibleItemPosition() == paramLayoutManager.getItemCount() - 1) {
        j = 1;
      } else {
        j = 0;
      }
      if ((f1 > 0.5F) && (j == 0)) {
        return localView;
      }
      if (j != 0) {
        return null;
      }
      return paramLayoutManager.findViewByPosition(i + 1);
    }
    return null;
  }
  
  private int i(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      int i = this.c;
      if ((i != 8388611) && (i != 48))
      {
        if ((i == 8388613) || (i == 80)) {
          return ((LinearLayoutManager)paramRecyclerView).findLastCompletelyVisibleItemPosition();
        }
      }
      else {
        return ((LinearLayoutManager)paramRecyclerView).findFirstCompletelyVisibleItemPosition();
      }
    }
    return -1;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
    throws IllegalStateException
  {
    if (paramRecyclerView != null)
    {
      int i = this.c;
      if (((i == 8388611) || (i == 8388613)) && (Build.VERSION.SDK_INT >= 17))
      {
        i = paramRecyclerView.getContext().getResources().getConfiguration().getLayoutDirection();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        this.d = bool;
      }
      if (this.e != null) {
        paramRecyclerView.addOnScrollListener(this.g);
      }
    }
    super.attachToRecyclerView(paramRecyclerView);
  }
  
  public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
    {
      if (this.c == 8388611) {
        arrayOfInt[0] = f(paramView, getHorizontalHelper(paramLayoutManager), false);
      } else {
        arrayOfInt[0] = e(paramView, getHorizontalHelper(paramLayoutManager), false);
      }
    }
    else {
      arrayOfInt[0] = 0;
    }
    if (paramLayoutManager.canScrollVertically())
    {
      if (this.c == 48) {
        arrayOfInt[1] = f(paramView, getVerticalHelper(paramLayoutManager), false);
      } else {
        arrayOfInt[1] = e(paramView, getVerticalHelper(paramLayoutManager), false);
      }
    }
    else {
      arrayOfInt[1] = 0;
    }
    return arrayOfInt;
  }
  
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      int i = this.c;
      if (i != 48)
      {
        if (i != 80)
        {
          if (i != 8388611)
          {
            if (i == 8388613)
            {
              paramLayoutManager = g(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
              break label97;
            }
          }
          else
          {
            paramLayoutManager = h(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
            break label97;
          }
        }
        else
        {
          paramLayoutManager = g(paramLayoutManager, getVerticalHelper(paramLayoutManager));
          break label97;
        }
      }
      else
      {
        paramLayoutManager = h(paramLayoutManager, getVerticalHelper(paramLayoutManager));
        break label97;
      }
    }
    paramLayoutManager = null;
    label97:
    boolean bool;
    if (paramLayoutManager != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    return paramLayoutManager;
  }
  
  class a
    extends RecyclerView.OnScrollListener
  {
    a() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 2) {
        GravitySnapHelper.b(GravitySnapHelper.this, false);
      }
      if ((paramInt == 0) && (GravitySnapHelper.a(GravitySnapHelper.this)) && (GravitySnapHelper.c(GravitySnapHelper.this) != null))
      {
        paramInt = GravitySnapHelper.d(GravitySnapHelper.this, paramRecyclerView);
        if (paramInt != -1) {
          GravitySnapHelper.c(GravitySnapHelper.this).a(paramInt);
        }
        GravitySnapHelper.b(GravitySnapHelper.this, false);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\GravitySnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */