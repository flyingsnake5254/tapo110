package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public abstract class PlayBackTimeRulerBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TimeAxisLayout f;
  @Bindable
  protected PlayBackControlViewModel q;
  @Bindable
  protected g x;
  @Bindable
  protected TimeAxisLayout.b y;
  
  protected PlayBackTimeRulerBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, TextView paramTextView, TimeAxisLayout paramTimeAxisLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramTextView;
    this.f = paramTimeAxisLayout;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable TimeAxisLayout.b paramb);
  
  public abstract void l(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackTimeRulerBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */