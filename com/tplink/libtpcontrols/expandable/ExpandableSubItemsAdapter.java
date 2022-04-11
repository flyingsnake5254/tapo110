package com.tplink.libtpcontrols.expandable;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.w.c.a;

public class ExpandableSubItemsAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private static final String a = "ExpandableSubItemsAdapter";
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  private int f;
  private ViewGroup g;
  private RecyclerView.Adapter h;
  
  ExpandableSubItemsAdapter(RecyclerView.Adapter paramAdapter)
  {
    this.h = paramAdapter;
  }
  
  private void o(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.b) || (this.c))
    {
      paramViewHolder.itemView.measure(-1, -2);
      a.d("targetHeight = 280");
      if (this.e)
      {
        ValueAnimator localValueAnimator;
        if (this.b) {
          localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 280 });
        } else {
          localValueAnimator = ValueAnimator.ofInt(new int[] { 280, 0 });
        }
        localValueAnimator.setInterpolator(new LinearInterpolator());
        localValueAnimator.setDuration(this.f);
        localValueAnimator.addUpdateListener(new d(this, paramInt, paramViewHolder));
        localValueAnimator.start();
      }
      else if (this.b)
      {
        paramViewHolder.itemView.getLayoutParams().height = 280;
        this.g.requestLayout();
        if (paramInt == getItemCount() - 1) {
          this.b = false;
        }
      }
      else if (this.c)
      {
        paramViewHolder.itemView.getLayoutParams().height = 0;
        this.g.requestLayout();
        if (paramInt == getItemCount() - 1)
        {
          this.c = false;
          this.d = false;
        }
      }
    }
  }
  
  public int getItemCount()
  {
    return this.h.getItemCount();
  }
  
  public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Log.i(a, "onBindViewHolder");
    if ((!this.d) && (!p())) {
      paramViewHolder.itemView.getViewTreeObserver().addOnPreDrawListener(new a(paramViewHolder));
    }
    o(paramViewHolder, paramInt);
    this.h.onBindViewHolder(paramViewHolder, paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.g == null) {
      this.g = paramViewGroup;
    }
    return this.h.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  boolean p()
  {
    boolean bool;
    if ((!this.c) && (!this.b)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(RecyclerView.ViewHolder paramViewHolder) {}
    
    public boolean onPreDraw()
    {
      if ((!ExpandableSubItemsAdapter.m(ExpandableSubItemsAdapter.this)) && (!ExpandableSubItemsAdapter.this.p()))
      {
        paramViewHolder.itemView.getLayoutParams().height = 1;
        ExpandableSubItemsAdapter.n(ExpandableSubItemsAdapter.this).setVisibility(8);
        paramViewHolder.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\expandable\ExpandableSubItemsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */