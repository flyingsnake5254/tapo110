package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.iot.widget.trv.MarqueeTextView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

public abstract class ItemHubSubDeviceCardBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final MarqueeTextView J3;
  @NonNull
  public final MarqueeTextView K3;
  @NonNull
  public final RippleCardView c;
  @NonNull
  public final TPCheckboxCompat d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final RelativeLayout p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final RelativeLayout z;
  
  protected ItemHubSubDeviceCardBinding(Object paramObject, View paramView, int paramInt, RippleCardView paramRippleCardView, TPCheckboxCompat paramTPCheckboxCompat, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, RelativeLayout paramRelativeLayout3, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, MarqueeTextView paramMarqueeTextView1, MarqueeTextView paramMarqueeTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRippleCardView;
    this.d = paramTPCheckboxCompat;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramImageView3;
    this.y = paramRelativeLayout1;
    this.z = paramRelativeLayout2;
    this.p0 = paramRelativeLayout3;
    this.p1 = paramTextView1;
    this.p2 = paramTextView2;
    this.p3 = paramTextView3;
    this.H3 = paramTextView4;
    this.I3 = paramTextView5;
    this.J3 = paramMarqueeTextView1;
    this.K3 = paramMarqueeTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemHubSubDeviceCardBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */