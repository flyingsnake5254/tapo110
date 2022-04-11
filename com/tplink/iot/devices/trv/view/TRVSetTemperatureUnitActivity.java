package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetTemperatureUnitBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class TRVSetTemperatureUnitActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetTemperatureUnitBinding>
  implements TPRadioButton.a
{
  private final f p0 = h.b(new a(this));
  
  private final TRVSettingsViewModel p1()
  {
    return (TRVSettingsViewModel)this.p0.getValue();
  }
  
  private final void q1(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    p1().t0(paramEnumTemperatureUnit).r(io.reactivex.d0.b.a.a()).l(new b(this)).i(new c(this)).j(new d(this)).y();
  }
  
  public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramCompoundButton != null) && (paramCompoundButton.getId() == 2131363751) && (paramBoolean1) && (paramBoolean2)) {
      q1(EnumTemperatureUnit.CELSIUS);
    } else if ((paramCompoundButton != null) && (paramCompoundButton.getId() == 2131363757) && (paramBoolean1) && (paramBoolean2)) {
      q1(EnumTemperatureUnit.FAHRENHEIT);
    }
  }
  
  public int e1()
  {
    return 2131558700;
  }
  
  public void j1()
  {
    b1(2131954279);
    ((ActivityTrvSetTemperatureUnitBinding)f1()).c.setOnCheckedChangeListener(this);
    ((ActivityTrvSetTemperatureUnitBinding)f1()).d.setOnCheckedChangeListener(this);
  }
  
  public void l1() {}
  
  public void m1()
  {
    p1().b0().observe(this, new e(this));
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.a<TRVSettingsViewModel>
  {
    a(TRVSetTemperatureUnitActivity paramTRVSetTemperatureUnitActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetTemperatureUnitActivity.o1((TRVSetTemperatureUnitActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class b<T>
    implements g<c>
  {
    b(TRVSetTemperatureUnitActivity paramTRVSetTemperatureUnitActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class c
    implements io.reactivex.g0.a
  {
    c(TRVSetTemperatureUnitActivity paramTRVSetTemperatureUnitActivity) {}
    
    public final void run()
    {
      e.a();
      this.a.finish();
    }
  }
  
  static final class d<T>
    implements g<Throwable>
  {
    d(TRVSetTemperatureUnitActivity paramTRVSetTemperatureUnitActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class e<T>
    implements Observer<IoTSubDevice>
  {
    e(TRVSetTemperatureUnitActivity paramTRVSetTemperatureUnitActivity) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      if (paramIoTSubDevice != null) {
        paramIoTSubDevice = paramIoTSubDevice.getEnumTempUnit();
      } else {
        paramIoTSubDevice = null;
      }
      if (paramIoTSubDevice != null)
      {
        int i = d.a[paramIoTSubDevice.ordinal()];
        if (i != 1)
        {
          if (i == 2) {
            TRVSetTemperatureUnitActivity.n1(this.a).f.check(2131363757);
          }
        }
        else {
          TRVSetTemperatureUnitActivity.n1(this.a).f.check(2131363751);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetTemperatureUnitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */