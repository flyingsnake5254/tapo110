package com.tplink.iot.devices.featuredactions.view;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionFragment;
import com.tplink.iot.devices.featuredactions.viewmodel.ButtonFeaturedActionViewModel;
import com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class ButtonFAAdjustBrightnessFragment
  extends AbstractFeaturedActionFragment<ButtonFeaturedActionViewModel>
{
  private HashMap K3;
  
  public void H0()
  {
    HashMap localHashMap = this.K3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public boolean W0(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "device");
    ThingModel localThingModel = ((ButtonFeaturedActionViewModel)b1()).x(paramBaseALIoTDevice);
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localThingModel != null)
    {
      bool2 = bool1;
      if (paramBaseALIoTDevice.isSupportIoTCloud())
      {
        bool2 = bool1;
        if (u1(localThingModel, "increaseBrightness"))
        {
          bool2 = bool1;
          if (u1(localThingModel, "decreaseBrightness")) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public String a1()
  {
    String str = getString(2131953694);
    j.d(str, "getString(R.string.scene…ol_light_brightness_desc)");
    return str;
  }
  
  public int c1()
  {
    return 2131690354;
  }
  
  public List<EnumIoTCategory> d1()
  {
    return l.g(new EnumIoTCategory[] { EnumIoTCategory.LIGHT, EnumIoTCategory.LIGHT_STRIP });
  }
  
  public String f1()
  {
    String str = getString(2131953695);
    j.d(str, "getString(R.string.scene…l_light_brightness_title)");
    return str;
  }
  
  public SmartInfo[] n1(List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramList, "selectedDevices");
    return ((ButtonFeaturedActionViewModel)b1()).J(f1(), paramList);
  }
  
  public ButtonFeaturedActionViewModel w1()
  {
    Object localObject = K0();
    localObject = new ViewModelProvider(requireActivity(), new IoTViewModelFactory(requireActivity(), (String)localObject)).get(ButtonFeaturedActionViewModel.class);
    j.d(localObject, "ViewModelProvider(requir…).get<VM>(VM::class.java)");
    return (ButtonFeaturedActionViewModel)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\ButtonFAAdjustBrightnessFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */