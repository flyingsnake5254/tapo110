package com.tplink.iot.view.smart.actionsetup.taskdevice.camera;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.databinding.FragmentCameraControlBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment;
import com.tplink.iot.viewmodel.smart.taskdevice.DeviceControlBaseViewModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class CameraControlFragment
  extends DeviceControlBaseFragment<FragmentCameraControlBinding>
{
  public static final a H3 = new a(null);
  private HashMap I3;
  
  private final void Y0(int paramInt)
  {
    ((FragmentCameraControlBinding)J0()).f.check(paramInt);
  }
  
  private final void Z0()
  {
    boolean bool = U0().l("lensMask");
    RadioButton localRadioButton = ((FragmentCameraControlBinding)J0()).d;
    j.d(localRadioButton, "mBinding.rbEnablePrivacy");
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    localRadioButton.setVisibility(j);
    localRadioButton = ((FragmentCameraControlBinding)J0()).c;
    j.d(localRadioButton, "mBinding.rbDisablePrivacy");
    if (bool) {
      j = i;
    } else {
      j = 8;
    }
    localRadioButton.setVisibility(j);
  }
  
  public void H0()
  {
    HashMap localHashMap = this.I3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558864;
  }
  
  public void N0()
  {
    RadioButton localRadioButton = ((FragmentCameraControlBinding)J0()).d;
    j.d(localRadioButton, "mBinding.rbEnablePrivacy");
    localRadioButton.setChecked(true);
    Z0();
  }
  
  public void T0(SmartThingAction paramSmartThingAction)
  {
    j.e(paramSmartThingAction, "thingAction");
    HashMap localHashMap = new HashMap();
    RadioGroup localRadioGroup = ((FragmentCameraControlBinding)J0()).f;
    j.d(localRadioGroup, "mBinding.rgCameraAction");
    switch (localRadioGroup.getCheckedRadioButtonId())
    {
    default: 
      break;
    case 2131363756: 
      localHashMap.put("lensMask", "on");
      break;
    case 2131363755: 
      localHashMap.put("lensMask", "off");
    }
    paramSmartThingAction.setStateDesired(localHashMap);
  }
  
  protected void W0(SmartThingAction paramSmartThingAction)
  {
    if (paramSmartThingAction != null)
    {
      paramSmartThingAction = paramSmartThingAction.getStateDesired();
      if (paramSmartThingAction != null)
      {
        Object localObject = paramSmartThingAction.get("lensMask");
        paramSmartThingAction = (SmartThingAction)localObject;
        if (!(localObject instanceof String)) {
          paramSmartThingAction = null;
        }
        paramSmartThingAction = (String)paramSmartThingAction;
        if ((paramSmartThingAction != null) && (paramSmartThingAction.hashCode() == 3551) && (paramSmartThingAction.equals("on"))) {
          Y0(2131363756);
        } else {
          Y0(2131363755);
        }
      }
    }
  }
  
  public static final class a
  {
    public final CameraControlFragment a(String paramString)
    {
      j.e(paramString, "deviceIdMD5");
      CameraControlFragment localCameraControlFragment = new CameraControlFragment();
      localCameraControlFragment.P0(paramString);
      return localCameraControlFragment;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\camera\CameraControlFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */