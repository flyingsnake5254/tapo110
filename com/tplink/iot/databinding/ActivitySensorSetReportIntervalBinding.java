package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivitySensorSetReportIntervalBinding
  extends ViewDataBinding
{
  @NonNull
  public final ItemSettingLayout c;
  
  protected ActivitySensorSetReportIntervalBinding(Object paramObject, View paramView, int paramInt, ItemSettingLayout paramItemSettingLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramItemSettingLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorSetReportIntervalBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */