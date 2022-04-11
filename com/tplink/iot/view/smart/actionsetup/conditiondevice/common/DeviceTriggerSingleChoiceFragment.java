package com.tplink.iot.view.smart.actionsetup.conditiondevice.common;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tplink.iot.adapter.smart.DeviceTriggerSingleChoiceAdapter;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerState;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerStateValue;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.cloud.enumerate.StateOperator;
import com.tplink.iot.cloud.enumerate.StateValueDataType;
import com.tplink.iot.databinding.FragmentDeviceTriggerSingleChoiceBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.view.smart.a.f;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerContainerFragment;
import com.tplink.iot.viewmodel.smart.conditiondevice.DeviceTriggerBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumRotateDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class DeviceTriggerSingleChoiceFragment
  extends DeviceTriggerBaseFragment<FragmentDeviceTriggerSingleChoiceBinding>
{
  public static final a H3 = new a(null);
  private DeviceTriggerSingleChoiceAdapter I3;
  private HashMap J3;
  
  private final void Y0(List<com.tplink.iot.model.smart.a> paramList, String paramString1, String paramString2, Object paramObject, boolean paramBoolean, String paramString3)
  {
    if (U0().n(paramString1)) {
      paramList.add(new com.tplink.iot.model.smart.a(paramString1, paramString2, paramObject, paramBoolean, paramString3));
    }
  }
  
  private final SmartThingTriggerState a1(boolean paramBoolean)
  {
    SmartThingTriggerState localSmartThingTriggerState = new SmartThingTriggerState();
    localSmartThingTriggerState.setValue(new SmartThingTriggerStateValue("0"));
    localSmartThingTriggerState.setDataType(StateValueDataType.INT);
    localSmartThingTriggerState.setKey("rotate_deg");
    StateOperator localStateOperator;
    if (paramBoolean) {
      localStateOperator = StateOperator.GT;
    } else {
      localStateOperator = StateOperator.LT;
    }
    localSmartThingTriggerState.setOp(localStateOperator);
    return localSmartThingTriggerState;
  }
  
  private final List<com.tplink.iot.model.smart.a> b1()
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = getString(2131954080);
    j.d(str1, "getString(R.string.smart_trigger_alarm_triggered)");
    Z0(this, localArrayList, "alarm", str1, null, false, null, 56, null);
    str1 = getString(2131954097);
    j.d(str1, "getString(R.string.smart_trigger_motion_detected)");
    Z0(this, localArrayList, "motion", str1, null, false, null, 56, null);
    str1 = getString(2131954098);
    j.d(str1, "getString(R.string.smart_trigger_open)");
    Z0(this, localArrayList, "open", str1, null, false, null, 56, null);
    str1 = getString(2131954086);
    j.d(str1, "getString(R.string.smart_trigger_close)");
    Z0(this, localArrayList, "close", str1, null, false, null, 56, null);
    str1 = getString(2131954096);
    j.d(str1, "getString(R.string.smart…_keep_open_one_minute_v2)");
    Z0(this, localArrayList, "keepOpen", str1, null, false, null, 56, null);
    str1 = getString(2131954105);
    j.d(str1, "getString(R.string.smart_trigger_single_tap)");
    Z0(this, localArrayList, "singleClick", str1, null, false, null, 56, null);
    boolean bool = c1();
    String str2 = getString(2131954089);
    j.d(str2, "getString(R.string.smart_trigger_double_tap)");
    if (!bool) {
      str1 = getString(2131953971);
    } else {
      str1 = null;
    }
    Z0(this, localArrayList, "doubleClick", str2, null, bool, str1, 8, null);
    str1 = getString(2131954103);
    j.d(str1, "getString(R.string.smart_trigger_rotate_clockwise)");
    Z0(this, localArrayList, "rotation", str1, EnumRotateDirection.CLOCKWISE, false, null, 48, null);
    str1 = getString(2131954102);
    j.d(str1, "getString(R.string.smart…ger_rotate_anticlockwise)");
    Z0(this, localArrayList, "rotation", str1, EnumRotateDirection.ANTICLOCKWISE, false, null, 48, null);
    return localArrayList;
  }
  
  private final boolean c1()
  {
    Object localObject1 = U0().h();
    Object localObject2 = EnumDeviceType.SWITCH;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (localObject1 == localObject2)
    {
      SwitchRepository localSwitchRepository = (SwitchRepository)e.d(K0(), SwitchRepository.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isDoubleClickEventEnabled: ");
      localObject1 = (DoubleClickInfoBean)localSwitchRepository.n4().getValue();
      if (localObject1 != null) {
        localObject1 = Boolean.valueOf(((DoubleClickInfoBean)localObject1).getEnable());
      } else {
        localObject1 = null;
      }
      ((StringBuilder)localObject2).append(localObject1);
      b.d.w.c.a.n("Smart", ((StringBuilder)localObject2).toString());
      localObject1 = (DoubleClickInfoBean)localSwitchRepository.n4().getValue();
      bool2 = bool1;
      if (localObject1 != null) {
        bool2 = ((DoubleClickInfoBean)localObject1).getEnable();
      }
    }
    return bool2;
  }
  
  public void H0()
  {
    HashMap localHashMap = this.J3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558920;
  }
  
  public void N0()
  {
    Object localObject1 = ((FragmentDeviceTriggerSingleChoiceBinding)J0()).c;
    j.d(localObject1, "mBinding.rvDeviceTrigger");
    Object localObject2 = requireContext();
    j.d(localObject2, "requireContext()");
    localObject2 = new DeviceTriggerSingleChoiceAdapter((Context)localObject2, b1());
    this.I3 = ((DeviceTriggerSingleChoiceAdapter)localObject2);
    Object localObject3 = V0();
    if (localObject3 != null)
    {
      boolean bool;
      if (((SingleCheckMarkAdapter)localObject2).getItemCount() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((DeviceTriggerContainerFragment)localObject3).c1(bool);
    }
    localObject3 = p.a;
    ((RecyclerView)localObject1).setAdapter((RecyclerView.Adapter)localObject2);
    localObject1 = ((FragmentDeviceTriggerSingleChoiceBinding)J0()).c;
    j.d(localObject1, "mBinding.rvDeviceTrigger");
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    localObject1 = localObject2;
    if (!(localObject2 instanceof SimpleItemAnimator)) {
      localObject1 = null;
    }
    localObject1 = (SimpleItemAnimator)localObject1;
    if (localObject1 != null) {
      ((SimpleItemAnimator)localObject1).setSupportsChangeAnimations(false);
    }
  }
  
  public void T0(SmartThingTrigger paramSmartThingTrigger)
  {
    j.e(paramSmartThingTrigger, "thingTrigger");
    Object localObject = this.I3;
    if (localObject != null)
    {
      com.tplink.iot.model.smart.a locala = (com.tplink.iot.model.smart.a)((SingleCheckMarkAdapter)localObject).u();
      if (locala != null)
      {
        ThingEventParams localThingEventParams = new ThingEventParams();
        localThingEventParams.setName(locala.d());
        localObject = locala.d();
        if ((((String)localObject).hashCode() == -40300674) && (((String)localObject).equals("rotation")))
        {
          boolean bool;
          if (locala.a() != EnumRotateDirection.ANTICLOCKWISE) {
            bool = true;
          } else {
            bool = false;
          }
          localThingEventParams.setParamList(l.b(a1(bool)));
        }
        paramSmartThingTrigger.setEvent(localThingEventParams);
      }
    }
  }
  
  protected void W0(SmartThingTrigger paramSmartThingTrigger)
  {
    if ((paramSmartThingTrigger != null) && (paramSmartThingTrigger.getEvent() != null))
    {
      Object localObject = paramSmartThingTrigger.getEvent();
      j.d(localObject, "thingTrigger.event");
      localObject = ((ThingEventParams)localObject).getName();
      if ((localObject != null) && (((String)localObject).hashCode() == -40300674) && (((String)localObject).equals("rotation"))) {
        localObject = f.a(paramSmartThingTrigger);
      } else {
        localObject = null;
      }
      DeviceTriggerSingleChoiceAdapter localDeviceTriggerSingleChoiceAdapter = this.I3;
      if (localDeviceTriggerSingleChoiceAdapter != null)
      {
        paramSmartThingTrigger = paramSmartThingTrigger.getEvent();
        j.d(paramSmartThingTrigger, "thingTrigger.event");
        paramSmartThingTrigger = paramSmartThingTrigger.getName();
        j.d(paramSmartThingTrigger, "thingTrigger.event.name");
        localDeviceTriggerSingleChoiceAdapter.B(paramSmartThingTrigger, localObject);
      }
    }
  }
  
  public static final class a
  {
    public final DeviceTriggerSingleChoiceFragment a(String paramString)
    {
      j.e(paramString, "deviceIdMD5");
      DeviceTriggerSingleChoiceFragment localDeviceTriggerSingleChoiceFragment = new DeviceTriggerSingleChoiceFragment();
      localDeviceTriggerSingleChoiceFragment.P0(paramString);
      return localDeviceTriggerSingleChoiceFragment;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\conditiondevice\common\DeviceTriggerSingleChoiceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */