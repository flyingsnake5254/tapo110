package com.tplink.iot.view.smart.actionsetup.taskdevice;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.smart.taskdevice.DeviceControlBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.HashMap;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract class DeviceControlBaseFragment<VDB extends ViewDataBinding>
  extends IoTMVVMBaseFragment<VDB>
{
  private final f p1 = h.b(new a(this));
  private SmartThingAction p2;
  private HashMap p3;
  
  public void H0()
  {
    HashMap localHashMap = this.p3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public abstract void T0(SmartThingAction paramSmartThingAction);
  
  protected final DeviceControlBaseViewModel U0()
  {
    return (DeviceControlBaseViewModel)this.p1.getValue();
  }
  
  protected final DeviceControlContainerFragment V0()
  {
    Fragment localFragment1 = getParentFragment();
    Fragment localFragment2 = localFragment1;
    if (!(localFragment1 instanceof DeviceControlContainerFragment)) {
      localFragment2 = null;
    }
    return (DeviceControlContainerFragment)localFragment2;
  }
  
  protected abstract void W0(SmartThingAction paramSmartThingAction);
  
  public final void X0(SmartThingAction paramSmartThingAction)
  {
    this.p2 = paramSmartThingAction;
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
    implements a<DeviceControlBaseViewModel>
  {
    a(DeviceControlBaseFragment paramDeviceControlBaseFragment)
    {
      super();
    }
    
    public final DeviceControlBaseViewModel a()
    {
      Object localObject = this.c.V0();
      if (localObject != null)
      {
        localObject = ((DeviceControlContainerFragment)localObject).W0();
        if ((localObject != null) && (((BaseALIoTDevice)localObject).isCamera() == true))
        {
          localObject = this.c;
          localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new CameraViewModelFactory((Fragment)localObject, DeviceControlBaseFragment.S0((DeviceControlBaseFragment)localObject))).get(DeviceControlBaseViewModel.class);
          j.d(localObject, "ViewModelProvider(this, …MD5)).get(VM::class.java)");
          return (DeviceControlBaseViewModel)localObject;
        }
      }
      localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((Fragment)localObject, DeviceControlBaseFragment.S0((DeviceControlBaseFragment)localObject))).get(DeviceControlBaseViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      localObject = (DeviceControlBaseViewModel)localObject;
      return (DeviceControlBaseViewModel)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\DeviceControlBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */