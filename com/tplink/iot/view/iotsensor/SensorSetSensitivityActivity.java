package com.tplink.iot.view.iotsensor;

import android.app.Activity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySensorSetSensitivityBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorSetSensitivityViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import kotlin.jvm.internal.j;

public final class SensorSetSensitivityActivity
  extends SensorBaseActivity<SensorSetSensitivityViewModel>
{
  private ActivitySensorSetSensitivityBinding p0;
  
  public SensorSetSensitivityActivity()
  {
    super(SensorSetSensitivityViewModel.class);
  }
  
  private final void l1()
  {
    s0.l(this);
    ((SensorSetSensitivityViewModel)f1()).o();
  }
  
  public void h1()
  {
    Object localObject = DataBindingUtil.setContentView(this, 2131558653);
    j.d(localObject, "DataBindingUtil.setConte…y_sensor_set_sensitivity)");
    localObject = (ActivitySensorSetSensitivityBinding)localObject;
    this.p0 = ((ActivitySensorSetSensitivityBinding)localObject);
    if (localObject == null) {
      j.t("mBinding");
    }
    ((ActivitySensorSetSensitivityBinding)localObject).h((SensorSetSensitivityViewModel)f1());
    ((ViewDataBinding)localObject).setLifecycleOwner(this);
    b1(2131953755);
  }
  
  public void j1()
  {
    ((SensorSetSensitivityViewModel)f1()).j().observe(this, new a(this));
    ((SensorSetSensitivityViewModel)f1()).i().observe(this, new b(this));
    ((SensorSetSensitivityViewModel)f1()).l().observe(this, new c(this));
  }
  
  static final class a<T>
    implements Observer<String>
  {
    a(SensorSetSensitivityActivity paramSensorSetSensitivityActivity) {}
    
    public final void a(String paramString)
    {
      SensorSetSensitivityViewModel localSensorSetSensitivityViewModel = (SensorSetSensitivityViewModel)this.a.f1();
      j.d(paramString, "it");
      localSensorSetSensitivityViewModel.n(paramString);
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(SensorSetSensitivityActivity paramSensorSetSensitivityActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      SensorSetSensitivityActivity.k1(this.a);
    }
  }
  
  static final class c<T>
    implements Observer<Integer>
  {
    c(SensorSetSensitivityActivity paramSensorSetSensitivityActivity) {}
    
    public final void a(Integer paramInteger)
    {
      
      if ((paramInteger != null) && (paramInteger.intValue() == -1))
      {
        paramInteger = this.a;
        s0.p(paramInteger, paramInteger.getString(2131952444));
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 0))
      {
        s0.B(this.a, null);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\SensorSetSensitivityActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */