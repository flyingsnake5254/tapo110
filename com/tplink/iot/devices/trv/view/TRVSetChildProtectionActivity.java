package com.tplink.iot.devices.trv.view;

import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvSetChildProtectionBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class TRVSetChildProtectionActivity
  extends IoTMVVMBaseActivity<ActivityTrvSetChildProtectionBinding>
{
  private final f p0 = h.b(new a(this));
  
  private final TRVSettingsViewModel q1()
  {
    return (TRVSettingsViewModel)this.p0.getValue();
  }
  
  public int e1()
  {
    return 2131558694;
  }
  
  public void j1()
  {
    b1(2131954311);
  }
  
  public void l1()
  {
    ((ActivityTrvSetChildProtectionBinding)f1()).d.setOnSwitchCheckedChangeListener(new b(this));
  }
  
  public void m1()
  {
    q1().H().observe(this, new c(this));
  }
  
  static final class a
    extends Lambda
    implements a<TRVSettingsViewModel>
  {
    a(TRVSetChildProtectionActivity paramTRVSetChildProtectionActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVSetChildProtectionActivity.o1((TRVSetChildProtectionActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class b
    implements TPSwitchCompat.a
  {
    b(TRVSetChildProtectionActivity paramTRVSetChildProtectionActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        paramCompoundButton = TRVSetChildProtectionActivity.n1(this.a).d;
        j.d(paramCompoundButton, "mBinding.switchButton");
        i.b(paramCompoundButton, 0L, 1, null);
        TRVSetChildProtectionActivity.p1(this.a).n0(paramBoolean1);
      }
    }
  }
  
  static final class c<T>
    implements Observer<ChildProtectionBean>
  {
    c(TRVSetChildProtectionActivity paramTRVSetChildProtectionActivity) {}
    
    public final void a(ChildProtectionBean paramChildProtectionBean)
    {
      TPSwitchCompat localTPSwitchCompat = TRVSetChildProtectionActivity.n1(this.a).d;
      j.d(localTPSwitchCompat, "mBinding.switchButton");
      boolean bool;
      if (paramChildProtectionBean != null) {
        bool = paramChildProtectionBean.getEnable();
      } else {
        bool = false;
      }
      localTPSwitchCompat.setChecked(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSetChildProtectionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */