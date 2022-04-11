package com.tplink.iot.devices.trv.view;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTrvEarlyStartBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.TRVEarlyStartBean;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class TRVEarlyStartActivity
  extends IoTMVVMBaseActivity<ActivityTrvEarlyStartBinding>
{
  private final f p0 = h.b(new b(this));
  
  private final TRVSettingsViewModel r1()
  {
    return (TRVSettingsViewModel)this.p0.getValue();
  }
  
  private final void s1(boolean paramBoolean)
  {
    r1().o0(paramBoolean);
  }
  
  private final void t1(boolean paramBoolean)
  {
    ImageView localImageView = ((ActivityTrvEarlyStartBinding)f1()).c;
    int i;
    if (paramBoolean) {
      i = 2131689657;
    } else {
      i = 2131689656;
    }
    localImageView.setImageResource(i);
  }
  
  public int e1()
  {
    return 2131558693;
  }
  
  public void j1()
  {
    b1(2131954318);
    ((ActivityTrvEarlyStartBinding)f1()).d.setOnSwitchCheckedChangeListener(new a(this));
    TPSwitchCompat localTPSwitchCompat = ((ActivityTrvEarlyStartBinding)f1()).d;
    j.d(localTPSwitchCompat, "mBinding.switchButton");
    t1(localTPSwitchCompat.isChecked());
  }
  
  public void l1() {}
  
  public void m1()
  {
    r1().K().observe(this, new c(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    r1().J();
  }
  
  static final class a
    implements TPSwitchCompat.a
  {
    a(TRVEarlyStartActivity paramTRVEarlyStartActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        paramCompoundButton = TRVEarlyStartActivity.n1(this.a).d;
        j.d(paramCompoundButton, "mBinding.switchButton");
        i.b(paramCompoundButton, 0L, 1, null);
        TRVEarlyStartActivity.p1(this.a, paramBoolean1);
      }
      TRVEarlyStartActivity.q1(this.a, paramBoolean1);
    }
  }
  
  static final class b
    extends Lambda
    implements a<TRVSettingsViewModel>
  {
    b(TRVEarlyStartActivity paramTRVEarlyStartActivity)
    {
      super();
    }
    
    public final TRVSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, TRVEarlyStartActivity.o1((TRVEarlyStartActivity)localObject))).get(TRVSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (TRVSettingsViewModel)localObject;
    }
  }
  
  static final class c<T>
    implements Observer<TRVEarlyStartBean>
  {
    c(TRVEarlyStartActivity paramTRVEarlyStartActivity) {}
    
    public final void a(TRVEarlyStartBean paramTRVEarlyStartBean)
    {
      TPSwitchCompat localTPSwitchCompat = TRVEarlyStartActivity.n1(this.a).d;
      j.d(localTPSwitchCompat, "mBinding.switchButton");
      boolean bool;
      if (paramTRVEarlyStartBean != null) {
        bool = paramTRVEarlyStartBean.getEnable();
      } else {
        bool = false;
      }
      localTPSwitchCompat.setChecked(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVEarlyStartActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */