package com.tplink.iot.view.iotsensor;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.extension.b;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySensorSetReportIntervalBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorSetReportIntervalViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import kotlin.jvm.internal.j;

public final class SensorSetReportIntervalActivity
  extends SensorBaseActivity<SensorSetReportIntervalViewModel>
{
  private ActivitySensorSetReportIntervalBinding p0;
  
  public SensorSetReportIntervalActivity()
  {
    super(SensorSetReportIntervalViewModel.class);
  }
  
  private final void m1()
  {
    SelectReportIntervalFragment.c.a(e1()).show(getSupportFragmentManager(), null);
  }
  
  public void h1()
  {
    Object localObject = DataBindingUtil.setContentView(this, 2131558652);
    j.d(localObject, "DataBindingUtil.setConte…nsor_set_report_interval)");
    this.p0 = ((ActivitySensorSetReportIntervalBinding)localObject);
    b1(2131953759);
    localObject = this.p0;
    if (localObject == null) {
      j.t("mBinding");
    }
    ((ActivitySensorSetReportIntervalBinding)localObject).c.setOnClickListener(new a(this));
  }
  
  public void j1()
  {
    ((SensorSetReportIntervalViewModel)f1()).f().observe(this, new b(this));
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(SensorSetReportIntervalActivity paramSensorSetReportIntervalActivity) {}
    
    public final void onClick(View paramView)
    {
      SensorSetReportIntervalActivity.l1(this.c);
    }
  }
  
  static final class b<T>
    implements Observer<Integer>
  {
    b(SensorSetReportIntervalActivity paramSensorSetReportIntervalActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if (paramInteger != null)
      {
        int i = paramInteger.intValue();
        SensorSetReportIntervalActivity.k1(this.a).c.setItemInfo(this.a.getString(b.a(Integer.valueOf(i)), new Object[] { Integer.valueOf(i) }));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\SensorSetReportIntervalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */