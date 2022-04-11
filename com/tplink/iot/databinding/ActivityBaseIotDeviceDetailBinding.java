package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

public abstract class ActivityBaseIotDeviceDetailBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView H3;
  @NonNull
  public final ImageView I3;
  @NonNull
  public final LinearLayout J3;
  @NonNull
  public final ScrollLayout K3;
  @NonNull
  public final TextView L3;
  @NonNull
  public final TextView M3;
  @NonNull
  public final TextView N3;
  @Bindable
  protected IoTDetailBaseViewModel O3;
  @Bindable
  protected View.OnClickListener P3;
  @NonNull
  public final CardView c;
  @NonNull
  public final CardView d;
  @NonNull
  public final ScrollView f;
  @NonNull
  public final FrameLayout p0;
  @NonNull
  public final ImageView p1;
  @NonNull
  public final ImageView p2;
  @NonNull
  public final ImageView p3;
  @NonNull
  public final ActivityBaseIotDeviceDetailBottomBinding q;
  @NonNull
  public final FrameLayout x;
  @NonNull
  public final FrameLayout y;
  @NonNull
  public final FrameLayout z;
  
  protected ActivityBaseIotDeviceDetailBinding(Object paramObject, View paramView, int paramInt, CardView paramCardView1, CardView paramCardView2, ScrollView paramScrollView, ActivityBaseIotDeviceDetailBottomBinding paramActivityBaseIotDeviceDetailBottomBinding, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2, FrameLayout paramFrameLayout3, FrameLayout paramFrameLayout4, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5, LinearLayout paramLinearLayout, ScrollLayout paramScrollLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCardView1;
    this.d = paramCardView2;
    this.f = paramScrollView;
    this.q = paramActivityBaseIotDeviceDetailBottomBinding;
    this.x = paramFrameLayout1;
    this.y = paramFrameLayout2;
    this.z = paramFrameLayout3;
    this.p0 = paramFrameLayout4;
    this.p1 = paramImageView1;
    this.p2 = paramImageView2;
    this.p3 = paramImageView3;
    this.H3 = paramImageView4;
    this.I3 = paramImageView5;
    this.J3 = paramLinearLayout;
    this.K3 = paramScrollLayout;
    this.L3 = paramTextView1;
    this.M3 = paramTextView2;
    this.N3 = paramTextView3;
  }
  
  public abstract void h(@Nullable IoTDetailBaseViewModel paramIoTDetailBaseViewModel);
  
  public abstract void i(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceDetailBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */