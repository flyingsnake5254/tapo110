package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.DrawableEditText;

public abstract class FragmentSubGSetupNameBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final DrawableEditText d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected g p0;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected SubGViewModel z;
  
  protected FragmentSubGSetupNameBinding(Object paramObject, View paramView, int paramInt, Button paramButton, DrawableEditText paramDrawableEditText, ImageView paramImageView, RelativeLayout paramRelativeLayout, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramDrawableEditText;
    this.f = paramImageView;
    this.q = paramRelativeLayout;
    this.x = paramTextView1;
    this.y = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGSetupNameBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */