package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;

public abstract class DialogSelectDeviceBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final View x;
  @Bindable
  protected SelectDeviceViewModel y;
  
  protected DialogSelectDeviceBinding(Object paramObject, View paramView1, int paramInt, TextView paramTextView1, RecyclerView paramRecyclerView, TextView paramTextView2, TextView paramTextView3, View paramView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramTextView1;
    this.d = paramRecyclerView;
    this.f = paramTextView2;
    this.q = paramTextView3;
    this.x = paramView2;
  }
  
  public abstract void h(@Nullable SelectDeviceViewModel paramSelectDeviceViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogSelectDeviceBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */