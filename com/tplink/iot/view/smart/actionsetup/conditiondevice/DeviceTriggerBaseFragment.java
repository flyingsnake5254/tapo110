package com.tplink.iot.view.smart.actionsetup.conditiondevice;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.smart.conditiondevice.DeviceTriggerBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.HashMap;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract class DeviceTriggerBaseFragment<VDB extends ViewDataBinding>
  extends IoTMVVMBaseFragment<VDB>
{
  private final f p1 = h.b(new a(this));
  private SmartThingTrigger p2;
  private HashMap p3;
  
  public void H0()
  {
    HashMap localHashMap = this.p3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public abstract void T0(SmartThingTrigger paramSmartThingTrigger);
  
  protected final DeviceTriggerBaseViewModel U0()
  {
    return (DeviceTriggerBaseViewModel)this.p1.getValue();
  }
  
  protected final DeviceTriggerContainerFragment V0()
  {
    Fragment localFragment1 = getParentFragment();
    Fragment localFragment2 = localFragment1;
    if (!(localFragment1 instanceof DeviceTriggerContainerFragment)) {
      localFragment2 = null;
    }
    return (DeviceTriggerContainerFragment)localFragment2;
  }
  
  protected abstract void W0(SmartThingTrigger paramSmartThingTrigger);
  
  public final void X0(SmartThingTrigger paramSmartThingTrigger)
  {
    this.p2 = paramSmartThingTrigger;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    W0(this.p2);
  }
  
  static final class a
    extends Lambda
    implements a<DeviceTriggerBaseViewModel>
  {
    a(DeviceTriggerBaseFragment paramDeviceTriggerBaseFragment)
    {
      super();
    }
    
    public final DeviceTriggerBaseViewModel a()
    {
      Object localObject = this.c.V0();
      if (localObject != null)
      {
        localObject = ((DeviceTriggerContainerFragment)localObject).V0();
        if ((localObject != null) && (((BaseALIoTDevice)localObject).isCamera() == true))
        {
          localObject = this.c;
          localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new CameraViewModelFactory((Fragment)localObject, DeviceTriggerBaseFragment.S0((DeviceTriggerBaseFragment)localObject))).get(DeviceTriggerBaseViewModel.class);
          j.d(localObject, "ViewModelProvider(this, …MD5)).get(VM::class.java)");
          return (DeviceTriggerBaseViewModel)localObject;
        }
      }
      localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((Fragment)localObject, DeviceTriggerBaseFragment.S0((DeviceTriggerBaseFragment)localObject))).get(DeviceTriggerBaseViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      localObject = (DeviceTriggerBaseViewModel)localObject;
      return (DeviceTriggerBaseViewModel)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\conditiondevice\DeviceTriggerBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */