package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout;

public abstract class LayoutLightStripDetailContentExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final LightStripControllerLayout c;
  @NonNull
  public final LightingEffectPresetLayout d;
  @NonNull
  public final LottieAnimationView f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected View.OnClickListener p1;
  @Bindable
  protected LightStripDetailViewModel p2;
  @NonNull
  public final ImageView q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final TextView z;
  
  protected LayoutLightStripDetailContentExtBinding(Object paramObject, View paramView, int paramInt, LightStripControllerLayout paramLightStripControllerLayout, LightingEffectPresetLayout paramLightingEffectPresetLayout, LottieAnimationView paramLottieAnimationView, ImageView paramImageView, LinearLayout paramLinearLayout, RelativeLayout paramRelativeLayout, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLightStripControllerLayout;
    this.d = paramLightingEffectPresetLayout;
    this.f = paramLottieAnimationView;
    this.q = paramImageView;
    this.x = paramLinearLayout;
    this.y = paramRelativeLayout;
    this.z = paramTextView1;
    this.p0 = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripDetailContentExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */