package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public abstract class ActivitySummaryHistoryBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final TextView I3;
  @Bindable
  protected SummaryHistoryViewModel J3;
  @NonNull
  public final CardView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TPSmartRefreshLayout p0;
  @NonNull
  public final ConstraintLayout p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final ConstraintLayout p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final RecyclerView z;
  
  protected ActivitySummaryHistoryBinding(Object paramObject, View paramView, int paramInt, CardView paramCardView, TextView paramTextView1, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, RecyclerView paramRecyclerView, TPSmartRefreshLayout paramTPSmartRefreshLayout, ConstraintLayout paramConstraintLayout1, TextView paramTextView2, ConstraintLayout paramConstraintLayout2, TextView paramTextView3, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCardView;
    this.d = paramTextView1;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramImageView3;
    this.y = paramImageView4;
    this.z = paramRecyclerView;
    this.p0 = paramTPSmartRefreshLayout;
    this.p1 = paramConstraintLayout1;
    this.p2 = paramTextView2;
    this.p3 = paramConstraintLayout2;
    this.H3 = paramTextView3;
    this.I3 = paramTextView4;
  }
  
  public abstract void h(@Nullable SummaryHistoryViewModel paramSummaryHistoryViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySummaryHistoryBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */