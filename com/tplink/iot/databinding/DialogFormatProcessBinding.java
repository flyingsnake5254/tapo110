package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.StoreManageViewModel;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

public abstract class DialogFormatProcessBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPCircleProgressBar c;
  @Bindable
  protected StoreManageViewModel d;
  
  protected DialogFormatProcessBinding(Object paramObject, View paramView, int paramInt, TPCircleProgressBar paramTPCircleProgressBar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPCircleProgressBar;
  }
  
  public abstract void h(@Nullable StoreManageViewModel paramStoreManageViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogFormatProcessBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */