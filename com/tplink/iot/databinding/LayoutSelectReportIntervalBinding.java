package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.NumberPickerView;

public abstract class LayoutSelectReportIntervalBinding
  extends ViewDataBinding
{
  @NonNull
  public final NumberPickerView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  
  protected LayoutSelectReportIntervalBinding(Object paramObject, View paramView, int paramInt, NumberPickerView paramNumberPickerView, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramNumberPickerView;
    this.d = paramTextView1;
    this.f = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutSelectReportIntervalBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */