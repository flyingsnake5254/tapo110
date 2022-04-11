package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareUpdateViewModel;

public abstract class FragmentFirmwareUpdateNewIpcBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final Button f;
  @NonNull
  public final ImageView p0;
  @NonNull
  public final RelativeLayout p1;
  @Bindable
  protected FirmwareUpdateViewModel p2;
  @Bindable
  protected View.OnClickListener p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final ImageView z;
  
  protected FragmentFirmwareUpdateNewIpcBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, Button paramButton, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramButton;
    this.q = paramTextView3;
    this.x = paramTextView4;
    this.y = paramTextView5;
    this.z = paramImageView1;
    this.p0 = paramImageView2;
    this.p1 = paramRelativeLayout;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable FirmwareUpdateViewModel paramFirmwareUpdateViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentFirmwareUpdateNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */