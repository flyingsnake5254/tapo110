package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;

public abstract class ViewVideoSurfaceLayoutBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final View J3;
  @Bindable
  protected ObservableBoolean K3;
  @Bindable
  protected ObservableBoolean L3;
  @Bindable
  protected ObservableBoolean M3;
  @Bindable
  protected ObservableBoolean N3;
  @Bindable
  protected ObservableBoolean O3;
  @Bindable
  protected ObservableBoolean P3;
  @Bindable
  protected ObservableBoolean Q3;
  @Bindable
  protected ObservableField<String> R3;
  @Bindable
  protected ObservableBoolean S3;
  @Bindable
  protected ObservableBoolean T3;
  @Bindable
  protected Boolean U3;
  @Bindable
  protected ObservableBoolean V3;
  @NonNull
  public final View c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final View f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final ImageView p2;
  @NonNull
  public final ImageView p3;
  @NonNull
  public final FrameLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final LottieAnimationView y;
  @NonNull
  public final View z;
  
  protected ViewVideoSurfaceLayoutBinding(Object paramObject, View paramView1, int paramInt, View paramView2, ImageView paramImageView1, View paramView3, FrameLayout paramFrameLayout, LinearLayout paramLinearLayout, LottieAnimationView paramLottieAnimationView, View paramView4, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView2, ImageView paramImageView3, TextView paramTextView3, TextView paramTextView4, View paramView5)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramImageView1;
    this.f = paramView3;
    this.q = paramFrameLayout;
    this.x = paramLinearLayout;
    this.y = paramLottieAnimationView;
    this.z = paramView4;
    this.p0 = paramTextView1;
    this.p1 = paramTextView2;
    this.p2 = paramImageView2;
    this.p3 = paramImageView3;
    this.H3 = paramTextView3;
    this.I3 = paramTextView4;
    this.J3 = paramView5;
  }
  
  public abstract void h(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void i(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void l(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void m(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void n(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void o(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void p(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void q(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void r(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void s(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void t(@Nullable Boolean paramBoolean);
  
  public abstract void u(@Nullable ObservableField<String> paramObservableField);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewVideoSurfaceLayoutBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */