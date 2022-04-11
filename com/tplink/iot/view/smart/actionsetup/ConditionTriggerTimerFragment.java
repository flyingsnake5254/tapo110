package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartScheduleSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.view.iotplug.c.a;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.widget.InnerTimePicker;
import com.tplink.iot.widget.InnerTimePicker.a;
import com.tplink.iot.widget.TimeOffsetPickerDialog;
import com.tplink.iot.widget.TimeOffsetPickerDialog.a;
import com.tplink.iot.widget.WeekdayPickerView;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;

public class ConditionTriggerTimerFragment
  extends BaseFragment
  implements View.OnClickListener, InnerTimePicker.a, TimeOffsetPickerDialog.a, Toolbar.OnMenuItemClickListener
{
  private int H3 = 0;
  private int I3 = 0;
  private int J3;
  private int K3 = 0;
  private int L3 = 0;
  private ActionDetailActivity M3;
  private ActionSetupViewModel N3;
  private b O3;
  private WeekdayPickerView p0;
  private InnerTimePicker p1;
  private TextView p2;
  private TextView p3;
  private View q;
  private RadioButton x;
  private RadioButton y;
  private RadioButton z;
  
  private void N0()
  {
    int i = this.H3;
    if (i == 2)
    {
      this.y.setChecked(true);
      this.x.setChecked(false);
      this.z.setChecked(false);
    }
    else if (i == 1)
    {
      this.y.setChecked(false);
      this.x.setChecked(true);
      this.z.setChecked(false);
    }
    else
    {
      this.y.setChecked(false);
      this.x.setChecked(false);
      this.z.setChecked(true);
    }
  }
  
  private void O0()
  {
    InnerTimePicker localInnerTimePicker = this.p1;
    int i;
    if (this.H3 == 0) {
      i = 0;
    } else {
      i = 8;
    }
    localInnerTimePicker.setVisibility(i);
    N0();
    T0();
  }
  
  private void P0()
  {
    ((TextView)this.q.findViewById(2131364290)).setText(2131954012);
    Object localObject = (Toolbar)this.q.findViewById(2131364275);
    ((Toolbar)localObject).inflateMenu(2131623954);
    ((Toolbar)localObject).setOnMenuItemClickListener(this);
    ((Toolbar)localObject).setNavigationOnClickListener(new t(this));
    localObject = (WeekdayPickerView)this.q.findViewById(2131364834);
    this.p0 = ((WeekdayPickerView)localObject);
    ((WeekdayPickerView)localObject).setDescriptionVisibility(true);
    this.p0.setWeekDay(127);
    localObject = (InnerTimePicker)this.q.findViewById(2131362862);
    this.p1 = ((InnerTimePicker)localObject);
    ((InnerTimePicker)localObject).setOnTimePickerChangeListener(this);
    int i = a.a() + 2;
    this.p1.setMinuteOfDay(i);
    this.J3 = i;
    this.x = ((RadioButton)this.q.findViewById(2131363772));
    this.y = ((RadioButton)this.q.findViewById(2131363773));
    this.z = ((RadioButton)this.q.findViewById(2131363752));
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.p2 = ((TextView)this.q.findViewById(2131364623));
    this.p3 = ((TextView)this.q.findViewById(2131364624));
    this.p2.setOnClickListener(this);
    this.p3.setOnClickListener(this);
    localObject = this.p1;
    if (this.H3 == 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((LinearLayout)localObject).setVisibility(i);
  }
  
  private void T0()
  {
    int i = this.H3;
    if (i == 2)
    {
      this.p3.setVisibility(0);
      this.p2.setVisibility(8);
      this.p3.setText(o0.n(getContext(), this.L3));
    }
    else if (i == 1)
    {
      this.p2.setVisibility(0);
      this.p3.setVisibility(8);
      this.p2.setText(o0.n(getContext(), this.K3));
    }
    else
    {
      this.p2.setVisibility(8);
      this.p3.setVisibility(8);
    }
  }
  
  private void U0()
  {
    this.N3.C().observe(this, new a());
  }
  
  public void F0(TimeOffsetPickerDialog paramTimeOffsetPickerDialog, int paramInt)
  {
    if (TextUtils.equals(paramTimeOffsetPickerDialog.getTag(), "tag_sunrise_offset"))
    {
      this.K3 = paramInt;
      this.H3 = 1;
      this.p2.setText(o0.n(getContext(), paramInt));
    }
    else if (TextUtils.equals(paramTimeOffsetPickerDialog.getTag(), "tag_sunset_offset"))
    {
      this.L3 = paramInt;
      this.H3 = 2;
      this.p3.setText(o0.n(getContext(), paramInt));
    }
  }
  
  public void L0()
  {
    s0.l(getActivity());
    SmartInfo localSmartInfo = this.N3.v();
    this.N3.j0(localSmartInfo, true);
  }
  
  public void S0(b paramb)
  {
    this.O3 = paramb;
  }
  
  public boolean d()
  {
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStackImmediate();
    }
    return true;
  }
  
  public void m()
  {
    this.J3 = this.p1.getMinutesOfDay();
  }
  
  public void onClick(View paramView)
  {
    if (this.O3 == null) {
      return;
    }
    O0();
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364624: 
      n0.c(getFragmentManager(), this.L3, this, "tag_sunset_offset");
      break;
    case 2131364623: 
      n0.c(getFragmentManager(), this.K3, this, "tag_sunrise_offset");
      break;
    case 2131363773: 
      this.I3 = 2;
      this.O3.b();
      break;
    case 2131363772: 
      this.I3 = 1;
      this.O3.b();
      break;
    case 2131363752: 
      this.H3 = 0;
      O0();
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558962, paramViewGroup, false);
    paramLayoutInflater = (ActionDetailActivity)getActivity();
    this.M3 = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      B0();
    }
    d.J(this.M3, this.q.findViewById(2131364275));
    setHasOptionsMenu(true);
    this.N3 = ((ActionSetupViewModel)ViewModelProviders.of(this.M3).get(ActionSetupViewModel.class));
    P0();
    U0();
    return this.q;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 2131361892) && (this.O3 != null))
    {
      SmartInfo localSmartInfo = this.N3.v();
      Object localObject1 = localSmartInfo.getTriggerSetting();
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null) {
        paramMenuItem = new SmartTrigger();
      }
      Object localObject2 = paramMenuItem.getSchedules();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = new SmartScheduleSetting(this.H3, (byte)this.p0.getWeekDay());
      int i = this.H3;
      if (i == 0)
      {
        ((SmartScheduleSetting)localObject2).setTime(Integer.valueOf(this.J3));
      }
      else
      {
        if (i == 1) {
          i = this.K3;
        } else {
          i = this.L3;
        }
        ((SmartScheduleSetting)localObject2).setOffsetMins(Integer.valueOf(i));
      }
      ((List)localObject1).add(0, localObject2);
      paramMenuItem.setSchedules((List)localObject1);
      paramMenuItem.setManual(false);
      localSmartInfo.setTriggerSetting(paramMenuItem);
      this.N3.p0(localSmartInfo);
      this.O3.a();
    }
    return false;
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue() != true))
      {
        paramBoolean = ConditionTriggerTimerFragment.this;
        ConditionTriggerTimerFragment.I0(paramBoolean, ConditionTriggerTimerFragment.J0(paramBoolean));
      }
      else
      {
        s0.n(ConditionTriggerTimerFragment.H0(ConditionTriggerTimerFragment.this), 2131954271);
        ConditionTriggerTimerFragment.I0(ConditionTriggerTimerFragment.this, 0);
      }
      ConditionTriggerTimerFragment.K0(ConditionTriggerTimerFragment.this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\ConditionTriggerTimerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */