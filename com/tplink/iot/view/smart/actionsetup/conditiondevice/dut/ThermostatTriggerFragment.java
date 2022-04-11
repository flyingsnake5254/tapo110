package com.tplink.iot.view.smart.actionsetup.conditiondevice.dut;

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
import com.tplink.iot.cloud.bean.smart.common.SmartThingStateReported;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerState;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerStateValue;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.cloud.enumerate.StateOperator;
import com.tplink.iot.cloud.enumerate.StateValueDataType;
import com.tplink.iot.databinding.FragmentThermostatTriggerBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.smart.a.g;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerContainerFragment;
import com.tplink.iot.viewmodel.smart.conditiondevice.DeviceTriggerBaseViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit.b;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.text.m;
import kotlin.v.d;

public final class ThermostatTriggerFragment
  extends DeviceTriggerBaseFragment<FragmentThermostatTriggerBinding>
{
  private static final d H3 = new d(-9, 60);
  private static final d I3 = new d(16, 140);
  public static final a J3 = new a(null);
  private final boolean K3 = true;
  private EnumTemperatureUnit L3 = EnumTemperatureUnit.CELSIUS;
  private d M3 = H3;
  private HashMap N3;
  
  private final SmartThingStateReported b1(MaterialEditText paramMaterialEditText, StateOperator paramStateOperator)
  {
    SmartThingStateReported localSmartThingStateReported = new SmartThingStateReported();
    SmartThingTriggerState localSmartThingTriggerState = new SmartThingTriggerState();
    paramMaterialEditText = paramMaterialEditText.getText();
    Object localObject = null;
    if (paramMaterialEditText != null) {
      paramMaterialEditText = paramMaterialEditText.toString();
    } else {
      paramMaterialEditText = null;
    }
    localSmartThingTriggerState.setValue(new SmartThingTriggerStateValue(paramMaterialEditText));
    ThingProperty localThingProperty = U0().m("current_temp");
    paramMaterialEditText = (MaterialEditText)localObject;
    if (localThingProperty != null) {
      paramMaterialEditText = localThingProperty.getDataType();
    }
    localSmartThingTriggerState.setDataType(g.f(paramMaterialEditText));
    localSmartThingTriggerState.setOp(paramStateOperator);
    localSmartThingTriggerState.setKey("current_temp");
    paramMaterialEditText = new SmartThingTriggerState();
    paramMaterialEditText.setValue(new SmartThingTriggerStateValue(this.L3.getValue()));
    paramMaterialEditText.setDataType(StateValueDataType.STRING);
    paramMaterialEditText.setOp(StateOperator.EQ);
    paramMaterialEditText.setKey("temp_unit");
    localSmartThingStateReported.setStateList(l.g(new SmartThingTriggerState[] { localSmartThingTriggerState, paramMaterialEditText }));
    return localSmartThingStateReported;
  }
  
  private final void c1()
  {
    FragmentThermostatTriggerBinding localFragmentThermostatTriggerBinding = (FragmentThermostatTriggerBinding)J0();
    MaterialEditText localMaterialEditText = localFragmentThermostatTriggerBinding.c;
    j.d(localMaterialEditText, "metTempAbove");
    localMaterialEditText.setVisibility(8);
    localMaterialEditText = localFragmentThermostatTriggerBinding.d;
    j.d(localMaterialEditText, "metTempBelow");
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
    if ((paramCharSequence != null) && (this.M3.f(paramCharSequence.intValue()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void e1(boolean paramBoolean)
  {
    DeviceTriggerContainerFragment localDeviceTriggerContainerFragment = V0();
    if (localDeviceTriggerContainerFragment != null) {
      localDeviceTriggerContainerFragment.c1(paramBoolean);
    }
  }
  
  private final void f1(int paramInt)
  {
    c1();
    Object localObject;
    switch (paramInt)
    {
    case 2131363776: 
    default: 
      break;
    case 2131363777: 
      localObject = getActivity();
      if (localObject != null) {
        i.d((Activity)localObject, 0, 1, null);
      }
      ((FragmentThermostatTriggerBinding)J0()).c.clearFocus();
      ((FragmentThermostatTriggerBinding)J0()).d.clearFocus();
      e1(true);
      break;
    case 2131363775: 
      localObject = ((FragmentThermostatTriggerBinding)J0()).d;
      j.d(localObject, "mBinding.metTempBelow");
      ((View)localObject).setVisibility(0);
      ((FragmentThermostatTriggerBinding)J0()).d.requestFocus();
      localObject = getActivity();
      if (localObject != null) {
        i.i((Activity)localObject);
      }
      localObject = ((FragmentThermostatTriggerBinding)J0()).d;
      j.d(localObject, "mBinding.metTempBelow");
      e1(d1(((MaterialEditText)localObject).getText()));
      break;
    case 2131363774: 
      localObject = ((FragmentThermostatTriggerBinding)J0()).c;
      j.d(localObject, "mBinding.metTempAbove");
      ((View)localObject).setVisibility(0);
      ((FragmentThermostatTriggerBinding)J0()).c.requestFocus();
      localObject = getActivity();
      if (localObject != null) {
        i.i((Activity)localObject);
      }
      localObject = ((FragmentThermostatTriggerBinding)J0()).c;
      j.d(localObject, "mBinding.metTempAbove");
      e1(d1(((MaterialEditText)localObject).getText()));
    }
  }
  
  private final void g1(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    this.L3 = paramEnumTemperatureUnit;
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
    this.M3 = ((d)localObject);
    Object localObject = ((FragmentThermostatTriggerBinding)J0()).d;
    j.d(localObject, "mBinding.metTempBelow");
    ((MaterialEditText)localObject).setPostfixText(paramEnumTemperatureUnit.getUnitText());
    localObject = ((FragmentThermostatTriggerBinding)J0()).c;
    j.d(localObject, "mBinding.metTempAbove");
    ((MaterialEditText)localObject).setPostfixText(paramEnumTemperatureUnit.getUnitText());
  }
  
  public void H0()
  {
    HashMap localHashMap = this.N3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558985;
  }
  
  public void N0()
  {
    final Object localObject = V0();
    MaterialEditText localMaterialEditText = null;
    if (localObject != null)
    {
      localObject = ((DeviceTriggerContainerFragment)localObject).V0();
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
    ((FragmentThermostatTriggerBinding)J0()).f.setOnCheckedChangeListener(new d(this));
    localObject = getString(2131954090, new Object[] { Integer.valueOf(this.M3.a()), Integer.valueOf(this.M3.b()) });
    j.d(localObject, "getString(R.string.smart… mTRVInputTempRange.last)");
    localMaterialEditText = ((FragmentThermostatTriggerBinding)J0()).d;
    localMaterialEditText.setHint((CharSequence)localObject);
    localMaterialEditText.o(new b((String)localObject, this, (String)localObject));
    localMaterialEditText = ((FragmentThermostatTriggerBinding)J0()).c;
    localMaterialEditText.setHint((CharSequence)localObject);
    localMaterialEditText.o(new c((String)localObject, this, (String)localObject));
    ((FragmentThermostatTriggerBinding)J0()).f.check(2131363777);
  }
  
  public void T0(SmartThingTrigger paramSmartThingTrigger)
  {
    j.e(paramSmartThingTrigger, "thingTrigger");
    Object localObject = ((FragmentThermostatTriggerBinding)J0()).f;
    j.d(localObject, "mBinding.radioGroup");
    int i = ((RadioGroup)localObject).getCheckedRadioButtonId();
    ThingEventParams localThingEventParams = null;
    switch (i)
    {
    case 2131363776: 
    default: 
      localObject = null;
      break;
    case 2131363777: 
      localThingEventParams = new ThingEventParams("windowOpen", null);
      localObject = null;
      break;
    case 2131363775: 
      localObject = ((FragmentThermostatTriggerBinding)J0()).d;
      j.d(localObject, "mBinding.metTempBelow");
      localObject = b1((MaterialEditText)localObject, StateOperator.LT);
      break;
    case 2131363774: 
      localObject = ((FragmentThermostatTriggerBinding)J0()).c;
      j.d(localObject, "mBinding.metTempAbove");
      localObject = b1((MaterialEditText)localObject, StateOperator.GT);
    }
    paramSmartThingTrigger.setEvent(localThingEventParams);
    paramSmartThingTrigger.setStateReported((SmartThingStateReported)localObject);
  }
  
  protected void W0(SmartThingTrigger paramSmartThingTrigger)
  {
    if (paramSmartThingTrigger != null) {
      if (paramSmartThingTrigger.getEvent() != null)
      {
        paramSmartThingTrigger = paramSmartThingTrigger.getEvent();
        j.d(paramSmartThingTrigger, "trigger.event");
        paramSmartThingTrigger = paramSmartThingTrigger.getName();
        if ((paramSmartThingTrigger != null) && (paramSmartThingTrigger.hashCode() == 1862401626) && (paramSmartThingTrigger.equals("windowOpen"))) {
          ((FragmentThermostatTriggerBinding)J0()).f.check(2131363777);
        }
      }
      else if (paramSmartThingTrigger.getStateReported() != null)
      {
        paramSmartThingTrigger = paramSmartThingTrigger.getStateReported();
        j.d(paramSmartThingTrigger, "trigger.stateReported");
        Object localObject1 = paramSmartThingTrigger.getStateList();
        Object localObject2 = null;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            paramSmartThingTrigger = ((Iterator)localObject3).next();
            if (j.a(((SmartThingTriggerState)paramSmartThingTrigger).getKey(), "current_temp")) {
              break label153;
            }
          }
          paramSmartThingTrigger = null;
          label153:
          localObject3 = (SmartThingTriggerState)paramSmartThingTrigger;
          if (localObject3 != null)
          {
            paramSmartThingTrigger = ((SmartThingTriggerState)localObject3).getValue();
            if (paramSmartThingTrigger != null)
            {
              paramSmartThingTrigger = paramSmartThingTrigger.getData();
              if (paramSmartThingTrigger != null)
              {
                paramSmartThingTrigger = m.k(paramSmartThingTrigger);
                break label193;
              }
            }
            paramSmartThingTrigger = null;
            label193:
            localObject3 = ((SmartThingTriggerState)localObject3).getOp();
            if ((paramSmartThingTrigger != null) && (localObject3 == StateOperator.GT))
            {
              ((FragmentThermostatTriggerBinding)J0()).c.setText(String.valueOf(paramSmartThingTrigger.intValue()));
              ((FragmentThermostatTriggerBinding)J0()).f.check(2131363774);
            }
            else if ((paramSmartThingTrigger != null) && (localObject3 == StateOperator.LT))
            {
              ((FragmentThermostatTriggerBinding)J0()).d.setText(String.valueOf(paramSmartThingTrigger.intValue()));
              ((FragmentThermostatTriggerBinding)J0()).f.check(2131363775);
            }
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramSmartThingTrigger = ((Iterator)localObject1).next();
            if (j.a(((SmartThingTriggerState)paramSmartThingTrigger).getKey(), "temp_unit")) {
              break label346;
            }
          }
          paramSmartThingTrigger = null;
          label346:
          paramSmartThingTrigger = (SmartThingTriggerState)paramSmartThingTrigger;
          if (paramSmartThingTrigger != null)
          {
            localObject1 = EnumTemperatureUnit.Companion;
            localObject3 = paramSmartThingTrigger.getValue();
            paramSmartThingTrigger = (SmartThingTrigger)localObject2;
            if (localObject3 != null) {
              paramSmartThingTrigger = ((SmartThingTriggerStateValue)localObject3).getData();
            }
            g1(((EnumTemperatureUnit.b)localObject1).a(paramSmartThingTrigger));
          }
        }
      }
    }
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
    public final ThermostatTriggerFragment a(String paramString)
    {
      j.e(paramString, "deviceIdMD5");
      ThermostatTriggerFragment localThermostatTriggerFragment = new ThermostatTriggerFragment(null);
      localThermostatTriggerFragment.P0(paramString);
      return localThermostatTriggerFragment;
    }
  }
  
  public static final class b
    extends com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b
  {
    b(String paramString1, ThermostatTriggerFragment paramThermostatTriggerFragment, String paramString2)
    {
      super();
    }
    
    public boolean b(CharSequence paramCharSequence, boolean paramBoolean)
    {
      j.e(paramCharSequence, "text");
      boolean bool = ThermostatTriggerFragment.Y0(jdField_this, paramCharSequence);
      ThermostatTriggerFragment.Z0(jdField_this, bool);
      if ((!paramBoolean) && (bool)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
  }
  
  public static final class c
    extends com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b
  {
    c(String paramString1, ThermostatTriggerFragment paramThermostatTriggerFragment, String paramString2)
    {
      super();
    }
    
    public boolean b(CharSequence paramCharSequence, boolean paramBoolean)
    {
      j.e(paramCharSequence, "text");
      boolean bool = ThermostatTriggerFragment.Y0(jdField_this, paramCharSequence);
      ThermostatTriggerFragment.Z0(jdField_this, bool);
      if ((!paramBoolean) && (bool)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
  }
  
  static final class d
    implements RadioGroup.OnCheckedChangeListener
  {
    d(ThermostatTriggerFragment paramThermostatTriggerFragment) {}
    
    public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      ThermostatTriggerFragment.a1(this.c, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\conditiondevice\dut\ThermostatTriggerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */