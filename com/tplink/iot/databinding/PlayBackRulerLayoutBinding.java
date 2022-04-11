package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public abstract class PlayBackRulerLayoutBinding
  extends ViewDataBinding
{
  @NonNull
  public final PlayBackTimeRulerBinding c;
  @NonNull
  public final PlayBackBottomBarBinding d;
  @Bindable
  protected PlayBackControlViewModel f;
  @Bindable
  protected g q;
  @Bindable
  protected TimeAxisLayout.b x;
  
  protected PlayBackRulerLayoutBinding(Object paramObject, View paramView, int paramInt, PlayBackTimeRulerBinding paramPlayBackTimeRulerBinding, PlayBackBottomBarBinding paramPlayBackBottomBarBinding)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramPlayBackTimeRulerBinding;
    this.d = paramPlayBackBottomBarBinding;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable TimeAxisLayout.b paramb);
  
  public abstract void l(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackRulerLayoutBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */