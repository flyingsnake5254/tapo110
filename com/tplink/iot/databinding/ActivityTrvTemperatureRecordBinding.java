package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.devices.trv.view.chart.TemperatureRecordChart;

public abstract class ActivityTrvTemperatureRecordBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final CardView d;
  @NonNull
  public final TemperatureRecordChart f;
  @NonNull
  public final TabLayout q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ActivityTrvTemperatureRecordBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, CardView paramCardView, TemperatureRecordChart paramTemperatureRecordChart, TabLayout paramTabLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramCardView;
    this.f = paramTemperatureRecordChart;
    this.q = paramTabLayout;
    this.x = paramTextView1;
    this.y = paramTextView2;
    this.z = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvTemperatureRecordBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */