package com.tplink.libtpcontrols.recycleviewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class a
{
  public static View a(RecyclerView paramRecyclerView)
  {
    int i = paramRecyclerView.getChildCount();
    if (i > 0) {
      for (int j = 0; j < i; j++)
      {
        View localView = paramRecyclerView.getChildAt(j);
        if (e(paramRecyclerView, localView)) {
          return localView;
        }
      }
    }
    return null;
  }
  
  public static int b(RecyclerView paramRecyclerView)
  {
    int i = paramRecyclerView.getChildCount();
    if (i > 0) {
      for (int j = 0; j < i; j++)
      {
        View localView = paramRecyclerView.getChildAt(j);
        if (e(paramRecyclerView, localView)) {
          return paramRecyclerView.getChildAdapterPosition(localView);
        }
      }
    }
    return i;
  }
  
  public static View c(RecyclerView paramRecyclerView)
  {
    int i = paramRecyclerView.getChildCount();
    if (i > 0) {
      for (int j = 0; j < i; j++)
      {
        View localView = paramRecyclerView.getChildAt(j);
        if (f(paramRecyclerView, localView)) {
          return localView;
        }
      }
    }
    return null;
  }
  
  public static int d(RecyclerView paramRecyclerView)
  {
    int i = paramRecyclerView.getChildCount();
    if (i > 0) {
      for (int j = 0; j < i; j++)
      {
        View localView = paramRecyclerView.getChildAt(j);
        if (f(paramRecyclerView, localView)) {
          return paramRecyclerView.getChildAdapterPosition(localView);
        }
      }
    }
    return i;
  }
  
  public static boolean e(RecyclerView paramRecyclerView, View paramView)
  {
    int i = paramRecyclerView.getChildCount();
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramRecyclerView.getLocationOnScreen(arrayOfInt1);
    boolean bool1 = false;
    int j = arrayOfInt1[0] + paramRecyclerView.getWidth() / 2;
    boolean bool2 = bool1;
    if (i > 0)
    {
      paramView.getLocationOnScreen(arrayOfInt2);
      bool2 = bool1;
      if (arrayOfInt2[0] <= j)
      {
        bool2 = bool1;
        if (arrayOfInt2[0] + paramView.getWidth() >= j) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static boolean f(RecyclerView paramRecyclerView, View paramView)
  {
    int i = paramRecyclerView.getChildCount();
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramRecyclerView.getLocationOnScreen(arrayOfInt1);
    boolean bool = true;
    int j = arrayOfInt1[1] + paramRecyclerView.getHeight() / 2;
    if (i > 0)
    {
      paramView.getLocationOnScreen(arrayOfInt2);
      if ((arrayOfInt2[1] > j) || (arrayOfInt2[1] + paramView.getHeight() < j)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\recycleviewpager\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */