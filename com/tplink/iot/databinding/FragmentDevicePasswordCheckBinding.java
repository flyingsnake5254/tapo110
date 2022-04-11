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

public abstract class FragmentDevicePasswordCheckBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final CameraLoadingView d;
  @NonNull
  public final MaterialEditText f;
  @Bindable
  protected View.OnClickListener p0;
  @NonNull
  public final Button q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @Bindable
  protected PasswordSettingViewModel z;
  
  protected FragmentDevicePasswordCheckBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, CameraLoadingView paramCameraLoadingView, MaterialEditText paramMaterialEditText, Button paramButton, Toolbar paramToolbar, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramCameraLoadingView;
    this.f = paramMaterialEditText;
    this.q = paramButton;
    this.x = paramToolbar;
    this.y = paramTextView2;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable PasswordSettingViewModel paramPasswordSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentDevicePasswordCheckBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */