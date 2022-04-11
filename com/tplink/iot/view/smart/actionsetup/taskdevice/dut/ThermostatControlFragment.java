package com.tplink.iot.view.smart.actionsetup.taskdevice.dut;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.d.w.f.a;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.databinding.FragmentThermostatControlBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlBaseFragment;
import com.tplink.iot.view.smart.actionsetup.taskdevice.DeviceControlContainerFragment;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import kotlin.text.m;
import kotlin.v.d;

public final class ThermostatControlFragment
  extends DeviceControlBaseFragment<FragmentThermostatControlBinding>
{
  private static final d H3 = new d(5, 30);
  private static final d I3 = new d(41, 86);
  public static final a J3 = new a(null);
  private EnumTemperatureUnit K3 = EnumTemperatureUnit.CELSIUS;
  private d L3 = H3;
  private HashMap M3;
  
  private final void b1()
  {
    Object localObject = ((FragmentThermostatControlBinding)J0()).d;
    j.d(localObject, "mBinding.radioGroup");
    int i = ((RadioGroup)localObject).getCheckedRadioButtonId();
    if (i != 2131363760)
    {
      if (i != 2131363765) {
        e1(false);
      } else {
        e1(true);
      }
    }
    else
    {
      localObject = ((FragmentThermostatControlBinding)J0()).c;
      j.d(localObject, "mBinding.metTemp");
      e1(d1(((MaterialEditText)localObject).getText()));
    }
  }
  
  private final void c1()
  {
    MaterialEditText localMaterialEditText = ((FragmentThermostatControlBinding)J0()).c;
    j.d(localMaterialEditText, "metTemp");
    localMaterialEditText.setVisibility(8);
  }
  
  private final boolean d1(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (paramCharSequence != null)
      {
        paramCharSequence = m.k(paramCharSequence);
        break label23;
      }
    }
    paramCharSequence = null;
    label23:
    boolean bool;
    if ((paramCharSequence != null) && (this.L3.f(paramCharSequence.intValue()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void e1(boolean paramBoolean)
  {
    DeviceControlContainerFragment localDeviceControlContainerFragment = V0();
    if (localDeviceControlContainerFragment != null) {
      localDeviceControlContainerFragment.d1(paramBoolean);
    }
  }
  
  private final void f1(int paramInt)
  {
    c1();
    Object localObject;
    if (paramInt != 2131363760)
    {
      if (paramInt == 2131363765)
      {
        localObject = getActivity();
        if (localObject != null)
        {
          MaterialEditText localMaterialEditText = ((FragmentThermostatControlBinding)J0()).c;
          j.d(localMaterialEditText, "mBinding.metTemp");
          i.f((Activity)localObject, localMaterialEditText, 0, 2, null);
        }
        ((FragmentThermostatControlBinding)J0()).c.clearFocus();
      }
    }
    else
    {
      localObject = ((FragmentThermostatControlBinding)J0()).c;
      j.d(localObject, "mBinding.metTemp");
      ((View)localObject).setVisibility(0);
      ((FragmentThermostatControlBinding)J0()).c.requestFocus();
      localObject = getActivity();
      if (localObject != null) {
        i.i((Activity)localObject);
      }
    }
    b1();
  }
  
  private final void g1(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    this.K3 = paramEnumTemperatureUnit;
    int i = a.a[paramEnumTemperatureUnit.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        localObject = I3;
      } else {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      localObject = H3;
    }
    this.L3 = ((d)localObject);
    Object localObject = ((FragmentThermostatControlBinding)J0()).c;
    j.d(localObject, "mBinding.metTemp");
    ((MaterialEditText)localObject).setPostfixText(paramEnumTemperatureUnit.getUnitText());
  }
  
  public void H0()
  {
    HashMap localHashMap = this.M3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558984;
  }
  
  public void N0()
  {
    final Object localObject = V0();
    MaterialEditText localMaterialEditText = null;
    if (localObject != null)
    {
      localObject = ((DeviceControlContainerFragment)localObject).W0();
      if (localObject != null)
      {
        localObject = ((BaseALIoTDevice)localObject).getLocalIoTDevice();
        break label30;
      }
    }
    localObject = null;
    label30:
    if (!(localObject instanceof IoTSubDevice)) {
      localObject = localMaterialEditText;
    }
    localObject = (IoTSubDevice)localObject;
    if (localObject != null)
    {
      localObject = ((IoTSubDevice)localObject).getEnumTempUnit();
      j.d(localObject, "subDevice.enumTempUnit");
      g1((EnumTemperatureUnit)localObject);
    }
    ((FragmentThermostatControlBinding)J0()).d.setOnCheckedChangeListener(new b(this));
    localObject = getString(2131954090, new Object[] { Integer.valueOf(this.L3.a()), Integer.valueOf(this.L3.b()) });
    j.d(localObject, "getString(R.string.smart… mTRVInputTempRange.last)");
    localMaterialEditText = ((FragmentThermostatControlBinding)J0()).c;
    j.d(localMaterialEditText, "mBinding.metTemp");
    localMaterialEditText.setHint((CharSequence)localObject);
    ((FragmentThermostatControlBinding)J0()).c.o(new c(this, (String)localObject, (String)localObject));
  }
  
  public void T0(SmartThingAction paramSmartThingAction)
  {
    j.e(paramSmartThingAction, "thingAction");
    HashMap localHashMap = new HashMap();
    Object localObject = ((FragmentThermostatControlBinding)J0()).d;
    j.d(localObject, "mBinding.radioGroup");
    int i = ((RadioGroup)localObject).getCheckedRadioButtonId();
    if (i != 2131363760)
    {
      if (i == 2131363765) {
        localHashMap.put("frost_protection_on", Boolean.TRUE);
      }
    }
    else
    {
      localHashMap.put("temp_unit", this.K3.getValue());
      localObject = ((FragmentThermostatControlBinding)J0()).c;
      j.d(localObject, "mBinding.metTemp");
      localObject = ((MaterialEditText)localObject).getText();
      if (localObject != null)
      {
        localObject = localObject.toString();
        if (localObject != null)
        {
          localObject = m.k((String)localObject);
          if (localObject != null) {
            localHashMap.put("target_temp", Integer.valueOf(((Number)localObject).intValue()));
          }
        }
      }
      localHashMap.put("frost_protection_on", Boolean.FALSE);
    }
    paramSmartThingAction.setStateDesired(localHashMap);
    paramSmartThingAction.setService(null);
  }
  
  protected void W0(SmartThingAction paramSmartThingAction)
  {
    Object localObject1 = null;
    if (paramSmartThingAction != null) {
      paramSmartThingAction = paramSmartThingAction.getStateDesired();
    } else {
      paramSmartThingAction = null;
    }
    if (paramSmartThingAction == null)
    {
      ((FragmentThermostatControlBinding)J0()).d.check(2131363760);
      return;
    }
    Object localObject2 = paramSmartThingAction.get("frost_protection_on");
    Object localObject3 = localObject2;
    if (!(localObject2 instanceof Boolean)) {
      localObject3 = null;
    }
    localObject3 = (Boolean)localObject3;
    if (localObject3 != null) {
      if (((Boolean)localObject3).booleanValue())
      {
        ((FragmentThermostatControlBinding)J0()).d.check(2131363765);
      }
      else
      {
        ((FragmentThermostatControlBinding)J0()).d.check(2131363760);
        localObject2 = paramSmartThingAction.get("temp_unit");
        localObject3 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject3 = null;
        }
        localObject3 = (String)localObject3;
        g1(EnumTemperatureUnit.Companion.a((String)localObject3));
        localObject3 = paramSmartThingAction.get("target_temp");
        paramSmartThingAction = (SmartThingAction)localObject3;
        if (!(localObject3 instanceof Number)) {
          paramSmartThingAction = null;
        }
        localObject3 = (Number)paramSmartThingAction;
        paramSmartThingAction = (SmartThingAction)localObject1;
        if (localObject3 != null) {
          paramSmartThingAction = Integer.valueOf(((Number)localObject3).intValue());
        }
        if (paramSmartThingAction != null) {
          ((FragmentThermostatControlBinding)J0()).c.setText(String.valueOf(paramSmartThingAction.intValue()));
        }
      }
    }
    b1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      a.g(localFragmentActivity);
    }
  }
  
  public static final class a
  {
    public final ThermostatControlFragment a(String paramString)
    {
      j.e(paramString, "deviceIdMD5");
      ThermostatControlFragment localThermostatControlFragment = new ThermostatControlFragment();
      localThermostatControlFragment.P0(paramString);
      return localThermostatControlFragment;
    }
  }
  
  static final class b
    implements RadioGroup.OnCheckedChangeListener
  {
    b(ThermostatControlFragment paramThermostatControlFragment) {}
    
    public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      ThermostatControlFragment.a1(this.c, paramInt);
    }
  }
  
  public static final class c
    extends com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b
  {
    c(String paramString1, String paramString2)
    {
      super();
    }
    
    public boolean b(CharSequence paramCharSequence, boolean paramBoolean)
    {
      j.e(paramCharSequence, "text");
      boolean bool = ThermostatControlFragment.Y0(this.b, paramCharSequence);
      ThermostatControlFragment.Z0(this.b, bool);
      if ((!paramBoolean) && (bool)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\taskdevice\dut\ThermostatControlFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */