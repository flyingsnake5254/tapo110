package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.widget.WaveView;

public abstract class LayoutLightStripGuidePageBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final CircleEffectImageView d;
  @NonNull
  public final ColorEffectPlateView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final WaveView p1;
  @NonNull
  public final ColorPaintingRingView q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final SelectableColorPointView z;
  
  protected LayoutLightStripGuidePageBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, CircleEffectImageView paramCircleEffectImageView, ColorEffectPlateView paramColorEffectPlateView, ColorPaintingRingView paramColorPaintingRingView, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, SelectableColorPointView paramSelectableColorPointView, TextView paramTextView2, WaveView paramWaveView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramCircleEffectImageView;
    this.f = paramColorEffectPlateView;
    this.q = paramColorPaintingRingView;
    this.x = paramRelativeLayout1;
    this.y = paramRelativeLayout2;
    this.z = paramSelectableColorPointView;
    this.p0 = paramTextView2;
    this.p1 = paramWaveView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripGuidePageBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */