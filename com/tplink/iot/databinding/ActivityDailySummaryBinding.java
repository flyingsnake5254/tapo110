package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public abstract class ActivityDailySummaryBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView H3;
  @NonNull
  public final ConstraintLayout I3;
  @NonNull
  public final RecyclerView J3;
  @NonNull
  public final TPSmartRefreshLayout K3;
  @NonNull
  public final ConstraintLayout L3;
  @NonNull
  public final TextView M3;
  @NonNull
  public final TextView N3;
  @NonNull
  public final TextView O3;
  @NonNull
  public final TextView P3;
  @NonNull
  public final TextView Q3;
  @Bindable
  protected DailySummaryViewModel R3;
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final Guideline p0;
  @NonNull
  public final LayoutDailySummarySettingsBinding p1;
  @NonNull
  public final ImageView p2;
  @NonNull
  public final ImageView p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final CardView z;
  
  protected ActivityDailySummaryBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView3, ImageView paramImageView3, CardView paramCardView, Guideline paramGuideline, LayoutDailySummarySettingsBinding paramLayoutDailySummarySettingsBinding, ImageView paramImageView4, ImageView paramImageView5, ImageView paramImageView6, ConstraintLayout paramConstraintLayout1, RecyclerView paramRecyclerView, TPSmartRefreshLayout paramTPSmartRefreshLayout, ConstraintLayout paramConstraintLayout2, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6, TextView paramTextView7, TextView paramTextView8)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramTextView3;
    this.y = paramImageView3;
    this.z = paramCardView;
    this.p0 = paramGuideline;
    this.p1 = paramLayoutDailySummarySettingsBinding;
    this.p2 = paramImageView4;
    this.p3 = paramImageView5;
    this.H3 = paramImageView6;
    this.I3 = paramConstraintLayout1;
    this.J3 = paramRecyclerView;
    this.K3 = paramTPSmartRefreshLayout;
    this.L3 = paramConstraintLayout2;
    this.M3 = paramTextView4;
    this.N3 = paramTextView5;
    this.O3 = paramTextView6;
    this.P3 = paramTextView7;
    this.Q3 = paramTextView8;
  }
  
  public abstract void h(@Nullable DailySummaryViewModel paramDailySummaryViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDailySummaryBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */