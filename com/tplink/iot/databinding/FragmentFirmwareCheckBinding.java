package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareCheckViewModel;

public abstract class FragmentFirmwareCheckBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final Button f;
  @Bindable
  protected View.OnClickListener p0;
  @Bindable
  protected FirmwareCheckViewModel p1;
  @NonNull
  public final ImageView q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final Toolbar z;
  
  protected FragmentFirmwareCheckBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, Button paramButton, ImageView paramImageView1, RelativeLayout paramRelativeLayout, ImageView paramImageView2, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramButton;
    this.q = paramImageView1;
    this.x = paramRelativeLayout;
    this.y = paramImageView2;
    this.z = paramToolbar;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable FirmwareCheckViewModel paramFirmwareCheckViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentFirmwareCheckBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */