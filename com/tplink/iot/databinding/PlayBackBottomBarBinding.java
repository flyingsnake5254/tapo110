package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public abstract class PlayBackBottomBarBinding
  extends ViewDataBinding
{
  @NonNull
  public final CheckBox c;
  @NonNull
  public final CheckBox d;
  @NonNull
  public final View f;
  @Bindable
  protected g q;
  @Bindable
  protected PlayBackControlViewModel x;
  
  protected PlayBackBottomBarBinding(Object paramObject, View paramView1, int paramInt, CheckBox paramCheckBox1, CheckBox paramCheckBox2, View paramView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramCheckBox1;
    this.d = paramCheckBox2;
    this.f = paramView2;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackBottomBarBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */