package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.view.iotplug.energymonitor.chart.PowerLineChart;

public abstract class ActivityPlugPowerStatisticBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final PowerLineChart d;
  @NonNull
  public final CardView f;
  @NonNull
  public final TabLayout q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  
  protected ActivityPlugPowerStatisticBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, PowerLineChart paramPowerLineChart, CardView paramCardView, TabLayout paramTabLayout, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramPowerLineChart;
    this.f = paramCardView;
    this.q = paramTabLayout;
    this.x = paramTextView1;
    this.y = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPlugPowerStatisticBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */