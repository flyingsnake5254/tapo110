package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.widget.NumberPickerView;

public abstract class FragmentGuardModeSetAlarmTimeBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final NumberPickerView d;
  @NonNull
  public final NumberPickerView f;
  @NonNull
  public final RecyclerView q;
  
  protected FragmentGuardModeSetAlarmTimeBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, NumberPickerView paramNumberPickerView1, NumberPickerView paramNumberPickerView2, RecyclerView paramRecyclerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramNumberPickerView1;
    this.f = paramNumberPickerView2;
    this.q = paramRecyclerView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentGuardModeSetAlarmTimeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */