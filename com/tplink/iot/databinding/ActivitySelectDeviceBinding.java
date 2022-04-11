package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;

public abstract class ActivitySelectDeviceBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final RecyclerView d;
  @Bindable
  protected SelectDeviceViewModel f;
  
  protected ActivitySelectDeviceBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView, RecyclerView paramRecyclerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
    this.d = paramRecyclerView;
  }
  
  public abstract void h(@Nullable SelectDeviceViewModel paramSelectDeviceViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySelectDeviceBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */