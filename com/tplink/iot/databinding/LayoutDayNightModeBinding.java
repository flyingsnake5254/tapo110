package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public abstract class LayoutDayNightModeBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @Bindable
  protected VideoPlayViewModel x;
  @Bindable
  protected g y;
  @Bindable
  protected MultiLiveVideoViewModel z;
  
  protected LayoutDayNightModeBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramTextView3;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel);
  
  public abstract void l(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutDayNightModeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */