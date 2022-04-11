package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public abstract class FragmentSubgPowerUpDeviceBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected g p0;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final TextView y;
  @Bindable
  protected SubGViewModel z;
  
  protected FragmentSubgPowerUpDeviceBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramRelativeLayout;
    this.x = paramLinearLayout;
    this.y = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubgPowerUpDeviceBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */