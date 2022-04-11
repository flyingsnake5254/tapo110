package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.dailysummary.viewmodel.SummaryPlayViewModel;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout.b;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;

public abstract class ActivitySummaryPlayBinding
  extends ViewDataBinding
{
  @Nullable
  public final ImageView H3;
  @Nullable
  public final ImageView I3;
  @Nullable
  public final ImageView J3;
  @NonNull
  public final ImageView K3;
  @Nullable
  public final ImageView L3;
  @NonNull
  public final ImageView M3;
  @NonNull
  public final ImageView N3;
  @NonNull
  public final ImageView O3;
  @NonNull
  public final ConstraintLayout P3;
  @NonNull
  public final TextView Q3;
  @NonNull
  public final ImageView R3;
  @Nullable
  public final ImageView S3;
  @NonNull
  public final ImageView T3;
  @Nullable
  public final ConstraintLayout U3;
  @Nullable
  public final ConstraintLayout V3;
  @NonNull
  public final ConstraintLayout W3;
  @NonNull
  public final ScrollCalendar X3;
  @Nullable
  public final ConstraintLayout Y3;
  @Nullable
  public final LinearLayout Z3;
  @Nullable
  public final ConstraintLayout a4;
  @Nullable
  public final ConstraintLayout b4;
  @NonNull
  public final LottieAnimationView c;
  @Nullable
  public final ConstraintLayout c4;
  @NonNull
  public final TextView d;
  @NonNull
  public final SummaryTimeAxisLayout d4;
  @NonNull
  public final PlayerView e4;
  @Nullable
  public final TextView f;
  @NonNull
  public final TextView f4;
  @NonNull
  public final TextView g4;
  @Nullable
  public final TextView h4;
  @NonNull
  public final TextView i4;
  @NonNull
  public final TextView j4;
  @NonNull
  public final WeekdayView k4;
  @Bindable
  protected SummaryPlayViewModel l4;
  @Bindable
  protected SummaryTimeAxisLayout.b m4;
  @NonNull
  public final TextView p0;
  @Nullable
  public final CardView p1;
  @Nullable
  public final ImageView p2;
  @Nullable
  public final ImageView p3;
  @Nullable
  public final ImageView q;
  @NonNull
  public final ImageView x;
  @Nullable
  public final ImageView y;
  @NonNull
  public final ImageView z;
  
  protected ActivitySummaryPlayBinding(Object paramObject, View paramView, int paramInt, LottieAnimationView paramLottieAnimationView, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, TextView paramTextView3, CardView paramCardView, ImageView paramImageView5, ImageView paramImageView6, ImageView paramImageView7, ImageView paramImageView8, ImageView paramImageView9, ImageView paramImageView10, ImageView paramImageView11, ImageView paramImageView12, ImageView paramImageView13, ImageView paramImageView14, ConstraintLayout paramConstraintLayout1, TextView paramTextView4, ImageView paramImageView15, ImageView paramImageView16, ImageView paramImageView17, ConstraintLayout paramConstraintLayout2, ConstraintLayout paramConstraintLayout3, ConstraintLayout paramConstraintLayout4, ScrollCalendar paramScrollCalendar, ConstraintLayout paramConstraintLayout5, LinearLayout paramLinearLayout, ConstraintLayout paramConstraintLayout6, ConstraintLayout paramConstraintLayout7, ConstraintLayout paramConstraintLayout8, SummaryTimeAxisLayout paramSummaryTimeAxisLayout, PlayerView paramPlayerView, TextView paramTextView5, TextView paramTextView6, TextView paramTextView7, TextView paramTextView8, TextView paramTextView9, WeekdayView paramWeekdayView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLottieAnimationView;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramImageView1;
    this.x = paramImageView2;
    this.y = paramImageView3;
    this.z = paramImageView4;
    this.p0 = paramTextView3;
    this.p1 = paramCardView;
    this.p2 = paramImageView5;
    this.p3 = paramImageView6;
    this.H3 = paramImageView7;
    this.I3 = paramImageView8;
    this.J3 = paramImageView9;
    this.K3 = paramImageView10;
    this.L3 = paramImageView11;
    this.M3 = paramImageView12;
    this.N3 = paramImageView13;
    this.O3 = paramImageView14;
    this.P3 = paramConstraintLayout1;
    this.Q3 = paramTextView4;
    this.R3 = paramImageView15;
    this.S3 = paramImageView16;
    this.T3 = paramImageView17;
    this.U3 = paramConstraintLayout2;
    this.V3 = paramConstraintLayout3;
    this.W3 = paramConstraintLayout4;
    this.X3 = paramScrollCalendar;
    this.Y3 = paramConstraintLayout5;
    this.Z3 = paramLinearLayout;
    this.a4 = paramConstraintLayout6;
    this.b4 = paramConstraintLayout7;
    this.c4 = paramConstraintLayout8;
    this.d4 = paramSummaryTimeAxisLayout;
    this.e4 = paramPlayerView;
    this.f4 = paramTextView5;
    this.g4 = paramTextView6;
    this.h4 = paramTextView7;
    this.i4 = paramTextView8;
    this.j4 = paramTextView9;
    this.k4 = paramWeekdayView;
  }
  
  public abstract void h(@Nullable SummaryTimeAxisLayout.b paramb);
  
  public abstract void i(@Nullable SummaryPlayViewModel paramSummaryPlayViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySummaryPlayBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */