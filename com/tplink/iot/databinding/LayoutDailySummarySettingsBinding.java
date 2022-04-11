package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;

public abstract class LayoutDailySummarySettingsBinding
  extends ViewDataBinding
{
  @NonNull
  public final View H3;
  @NonNull
  public final Guideline I3;
  @NonNull
  public final Guideline J3;
  @NonNull
  public final ConstraintLayout K3;
  @NonNull
  public final ConstraintLayout L3;
  @NonNull
  public final SwitchCompat M3;
  @NonNull
  public final SwitchCompat N3;
  @NonNull
  public final TextView O3;
  @NonNull
  public final TextView P3;
  @NonNull
  public final TextView Q3;
  @NonNull
  public final TextView R3;
  @NonNull
  public final TextView S3;
  @NonNull
  public final TextView T3;
  @NonNull
  public final TextView U3;
  @NonNull
  public final TextView V3;
  @NonNull
  public final TextView W3;
  @Bindable
  protected DailySummaryViewModel X3;
  @NonNull
  public final TextView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final View f;
  @NonNull
  public final View p0;
  @NonNull
  public final View p1;
  @NonNull
  public final View p2;
  @NonNull
  public final View p3;
  @NonNull
  public final View q;
  @NonNull
  public final View x;
  @NonNull
  public final View y;
  @NonNull
  public final View z;
  
  protected LayoutDailySummarySettingsBinding(Object paramObject, View paramView1, int paramInt, TextView paramTextView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8, View paramView9, View paramView10, View paramView11, Guideline paramGuideline1, Guideline paramGuideline2, ConstraintLayout paramConstraintLayout1, ConstraintLayout paramConstraintLayout2, SwitchCompat paramSwitchCompat1, SwitchCompat paramSwitchCompat2, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6, TextView paramTextView7, TextView paramTextView8, TextView paramTextView9, TextView paramTextView10)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramTextView1;
    this.d = paramImageView;
    this.f = paramView2;
    this.q = paramView3;
    this.x = paramView4;
    this.y = paramView5;
    this.z = paramView6;
    this.p0 = paramView7;
    this.p1 = paramView8;
    this.p2 = paramView9;
    this.p3 = paramView10;
    this.H3 = paramView11;
    this.I3 = paramGuideline1;
    this.J3 = paramGuideline2;
    this.K3 = paramConstraintLayout1;
    this.L3 = paramConstraintLayout2;
    this.M3 = paramSwitchCompat1;
    this.N3 = paramSwitchCompat2;
    this.O3 = paramTextView2;
    this.P3 = paramTextView3;
    this.Q3 = paramTextView4;
    this.R3 = paramTextView5;
    this.S3 = paramTextView6;
    this.T3 = paramTextView7;
    this.U3 = paramTextView8;
    this.V3 = paramTextView9;
    this.W3 = paramTextView10;
  }
  
  public abstract void h(@Nullable DailySummaryViewModel paramDailySummaryViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutDailySummarySettingsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */