package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.LightStripDetailBgView;
import com.tplink.iot.devices.lightstrip.widget.RippleRevealFrameLayout;

public abstract class LayoutLightStripDetailBgBinding
  extends ViewDataBinding
{
  @NonNull
  public final RippleRevealFrameLayout c;
  @NonNull
  public final View d;
  @NonNull
  public final LightStripDetailBgView f;
  @NonNull
  public final View q;
  
  protected LayoutLightStripDetailBgBinding(Object paramObject, View paramView1, int paramInt, RippleRevealFrameLayout paramRippleRevealFrameLayout, View paramView2, LightStripDetailBgView paramLightStripDetailBgView, View paramView3)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramRippleRevealFrameLayout;
    this.d = paramView2;
    this.f = paramLightStripDetailBgView;
    this.q = paramView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripDetailBgBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */