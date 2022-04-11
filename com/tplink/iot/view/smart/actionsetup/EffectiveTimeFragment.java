package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartPeriodSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartTimeSetting;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.widget.TimeScrollPickerDialog;
import com.tplink.iot.widget.TimeScrollPickerDialog.a;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.iot.widget.WeekdayPickerView;

public class EffectiveTimeFragment
  extends BaseFragment
  implements View.OnClickListener, TimeScrollPickerDialog.a
{
  private int H3 = 127;
  private TextView I3;
  private TextView J3;
  private TextView K3;
  private TextView L3;
  private TextView M3;
  private TextView N3;
  private TextView O3;
  private WeekdayPickerView P3;
  private LinearLayout Q3;
  private ActionSetupViewModel R3;
  private String S3 = "ALL_DAY";
  private String T3 = "ALL_DAY";
  private ActionDetailActivity U3;
  private int p0 = 1439;
  private int p1 = 127;
  private int p2 = 0;
  private int p3 = 1439;
  private final String q = "tag_start_time";
  private final String x = "tag_end_time";
  private View y;
  private int z = 0;
  
  private void H0()
  {
    if (this.p2 == this.p3)
    {
      TSnackbar.B(this, 2131951619, -1).N();
    }
    else if (this.P3.getWeekDay() == 0)
    {
      TSnackbar.B(this, 2131954043, -1).N();
    }
    else
    {
      SmartPeriodSetting localSmartPeriodSetting = new SmartPeriodSetting();
      SmartTimeSetting localSmartTimeSetting = new SmartTimeSetting();
      if (this.T3.equals("CUSTOM"))
      {
        localSmartTimeSetting.setStartTime(this.p2);
        localSmartTimeSetting.setEndTime(this.p3);
        localSmartPeriodSetting.setCustomTime(localSmartTimeSetting);
        localSmartPeriodSetting.setDaysOfWeek((byte)this.P3.getWeekDay());
      }
      else
      {
        localSmartTimeSetting.setStartTime(0);
        localSmartTimeSetting.setEndTime(1439);
        localSmartPeriodSetting.setCustomTime(localSmartTimeSetting);
        localSmartPeriodSetting.setDaysOfWeek((byte)Byte.MAX_VALUE);
      }
      localSmartPeriodSetting.setPeriodType(this.T3);
      this.R3.v().setEffectivePeriod(localSmartPeriodSetting);
      B0();
    }
  }
  
  private void I0()
  {
    if (J0()) {
      new UniversalDialog.a().q(getString(2131951857)).u(getString(2131951865)).s(getString(2131951856)).r(new a(this)).l().show(getChildFragmentManager(), "");
    } else {
      B0();
    }
  }
  
  private boolean J0()
  {
    boolean bool;
    if ((this.z == this.p2) && (this.p0 == this.p3) && (this.p1 == this.P3.getWeekDay()) && (this.S3.equals(this.T3))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void K0()
  {
    ActionDetailActivity localActionDetailActivity = (ActionDetailActivity)getActivity();
    this.U3 = localActionDetailActivity;
    if (localActionDetailActivity == null) {
      B0();
    }
    this.R3 = ((ActionSetupViewModel)ViewModelProviders.of(this.U3).get(ActionSetupViewModel.class));
  }
  
  private void L0()
  {
    this.R3.D().observe(this, new u(this));
  }
  
  private void N0()
  {
    d.J(this.U3, this.y.findViewById(2131364260));
    setHasOptionsMenu(true);
    this.I3 = ((TextView)this.y.findViewById(2131364107));
    this.J3 = ((TextView)this.y.findViewById(2131362541));
    this.K3 = ((TextView)this.y.findViewById(2131362953));
    this.P3 = ((WeekdayPickerView)this.y.findViewById(2131364834));
    this.L3 = ((TextView)this.y.findViewById(2131364339));
    this.M3 = ((TextView)this.y.findViewById(2131364390));
    this.Q3 = ((LinearLayout)this.y.findViewById(2131363280));
    this.N3 = ((TextView)this.y.findViewById(2131364352));
    this.O3 = ((TextView)this.y.findViewById(2131364613));
    this.I3.setOnClickListener(this);
    this.J3.setOnClickListener(this);
    this.K3.setOnClickListener(this);
    this.L3.setOnClickListener(this);
    this.M3.setOnClickListener(this);
    this.N3.setOnClickListener(this);
    this.O3.setOnClickListener(this);
    this.P3.setWeekDay(this.H3);
    Q0();
  }
  
  private void Q0()
  {
    boolean bool = this.T3.equals("ALL_DAY");
    int i = 0;
    if (bool)
    {
      this.M3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
      this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 2131689723, 0);
      this.Q3.setVisibility(8);
    }
    else
    {
      this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
      this.M3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 2131689723, 0);
      this.Q3.setVisibility(0);
      this.I3.setText(o0.a(getActivity(), this.p2));
      this.J3.setText(o0.a(getActivity(), this.p3));
      TextView localTextView = this.K3;
      if (this.p2 <= this.p3) {
        i = 4;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public boolean d()
  {
    I0();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364613: 
      H0();
      break;
    case 2131364390: 
      this.T3 = "CUSTOM";
      Q0();
      break;
    case 2131364352: 
      I0();
      break;
    case 2131364339: 
      this.T3 = "ALL_DAY";
      Q0();
      break;
    case 2131364107: 
      n0.b(getChildFragmentManager(), this.p2, true, false, this.p3, this, "tag_start_time");
      break;
    case 2131362541: 
    case 2131362953: 
      n0.b(getChildFragmentManager(), this.p3, true, true, this.p2, this, "tag_end_time");
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.y = paramLayoutInflater.inflate(2131558957, paramViewGroup, false);
    K0();
    N0();
    L0();
    return this.y;
  }
  
  public void z0(TimeScrollPickerDialog paramTimeScrollPickerDialog, int paramInt)
  {
    if ("tag_start_time".equals(paramTimeScrollPickerDialog.getTag()))
    {
      this.p2 = paramInt;
      this.I3.setText(o0.a(getActivity(), this.p2));
    }
    else if ("tag_end_time".equals(paramTimeScrollPickerDialog.getTag()))
    {
      this.p3 = paramInt;
      this.J3.setText(o0.a(getActivity(), this.p3));
    }
    paramTimeScrollPickerDialog = this.K3;
    if (this.p2 > this.p3) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    paramTimeScrollPickerDialog.setVisibility(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\EffectiveTimeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */