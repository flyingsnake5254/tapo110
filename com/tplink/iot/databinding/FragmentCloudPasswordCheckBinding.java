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
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public abstract class FragmentCloudPasswordCheckBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final MaterialEditText d;
  @NonNull
  public final Button f;
  @NonNull
  public final Toolbar q;
  @NonNull
  public final TextView x;
  @Bindable
  protected PasswordSettingViewModel y;
  @Bindable
  protected View.OnClickListener z;
  
  protected FragmentCloudPasswordCheckBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, MaterialEditText paramMaterialEditText, Button paramButton, Toolbar paramToolbar, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramMaterialEditText;
    this.f = paramButton;
    this.q = paramToolbar;
    this.x = paramTextView2;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable PasswordSettingViewModel paramPasswordSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCloudPasswordCheckBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */