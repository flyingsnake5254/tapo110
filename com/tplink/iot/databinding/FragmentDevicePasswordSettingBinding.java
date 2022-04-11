package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public abstract class FragmentDevicePasswordSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final CameraLoadingView c;
  @NonNull
  public final MaterialEditText d;
  @NonNull
  public final Button f;
  @Bindable
  protected View.OnClickListener p0;
  @NonNull
  public final TextView q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final MaterialEditText y;
  @Bindable
  protected PasswordSettingViewModel z;
  
  protected FragmentDevicePasswordSettingBinding(Object paramObject, View paramView, int paramInt, CameraLoadingView paramCameraLoadingView, MaterialEditText paramMaterialEditText1, Button paramButton, TextView paramTextView, Toolbar paramToolbar, MaterialEditText paramMaterialEditText2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCameraLoadingView;
    this.d = paramMaterialEditText1;
    this.f = paramButton;
    this.q = paramTextView;
    this.x = paramToolbar;
    this.y = paramMaterialEditText2;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable PasswordSettingViewModel paramPasswordSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentDevicePasswordSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */