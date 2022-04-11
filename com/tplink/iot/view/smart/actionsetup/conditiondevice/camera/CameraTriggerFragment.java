package com.tplink.iot.view.smart.actionsetup.conditiondevice.camera;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.adapter.smart.DeviceTriggerSingleChoiceAdapter;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.databinding.FragmentCameraTriggerBinding;
import com.tplink.iot.devicecommon.adapter.SingleCheckMarkAdapter;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.model.smart.a;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerBaseFragment;
import com.tplink.iot.view.smart.actionsetup.conditiondevice.DeviceTriggerContainerFragment;
import com.tplink.iot.viewmodel.smart.conditiondevice.DeviceTriggerBaseViewModel;
import com.tplink.libtpnetwork.Utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class CameraTriggerFragment
  extends DeviceTriggerBaseFragment<FragmentCameraTriggerBinding>
{
  public static final a H3 = new a(null);
  private DeviceTriggerSingleChoiceAdapter I3;
  private HashMap J3;
  
  private final void Y0(List<a> paramList, String paramString1, String paramString2, Object paramObject, boolean paramBoolean, String paramString3)
  {
    if (U0().n(paramString1)) {
      if (q.c(paramString1))
      {
        if ((paramBoolean) && (q.a(paramString1, K0()))) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        if (paramBoolean) {
          paramString3 = null;
        } else {
          paramString3 = getString(2131954002);
        }
        paramList.add(new a(paramString1, paramString2, paramObject, paramBoolean, paramString3));
      }
      else
      {
        paramList.add(new a(paramString1, paramString2, paramObject, paramBoolean, paramString3));
      }
    }
  }
  
  private final List<a> a1()
  {
    ArrayList localArrayList = new ArrayList();
    String str = getString(2131951944);
    j.d(str, "getString(R.string.camera_motion_title)");
    Z0(this, localArrayList, "Motion", str, null, false, null, 56, null);
    str = getString(2131954083);
    j.d(str, "getString(R.string.smart…era_baby_crying_detected)");
    Z0(this, localArrayList, "Babycry", str, null, false, null, 56, null);
    str = getString(2131952029);
    j.d(str, "getString(R.string.camera_person_detection)");
    Z0(this, localArrayList, "PersonDetected", str, null, false, null, 56, null);
    str = getString(2131954082);
    j.d(str, "getString(R.string.smart…_area_intrusion_detected)");
    Z0(this, localArrayList, "tapoCameraAreaIntrusionDetection", str, null, false, null, 56, null);
    str = getString(2131954085);
    j.d(str, "getString(R.string.smart…a_line_crossing_detected)");
    Z0(this, localArrayList, "tapoCameraLinecrossingDetection", str, null, false, null, 56, null);
    str = getString(2131954084);
    j.d(str, "getString(R.string.smart…amera_tampering_detected)");
    Z0(this, localArrayList, "tapoCameraCameraTampering", str, null, false, null, 56, null);
    return localArrayList;
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
    return 2131558865;
  }
  
  public void N0()
  {
    Object localObject1 = requireContext();
    j.d(localObject1, "requireContext()");
    localObject1 = new DeviceTriggerSingleChoiceAdapter((Context)localObject1, a1());
    Object localObject2 = V0();
    if (localObject2 != null)
    {
      boolean bool;
      if (((SingleCheckMarkAdapter)localObject1).getItemCount() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((DeviceTriggerContainerFragment)localObject2).c1(bool);
    }
    localObject2 = p.a;
    this.I3 = ((DeviceTriggerSingleChoiceAdapter)localObject1);
    localObject1 = ((FragmentCameraTriggerBinding)J0()).c;
    ((RecyclerView)localObject1).setAdapter(this.I3);
    i.g((RecyclerView)localObject1);
  }
  
  public void T0(SmartThingTrigger paramSmartThingTrigger)
  {
    j.e(paramSmartThingTrigger, "thingTrigger");
    Object localObject = this.I3;
    if (localObject != null)
    {
      localObject = (a)((SingleCheckMarkAdapter)localObject).u();
      if (localObject != null) {
        paramSmartThingTrigger.setEvent(new ThingEventParams(((a)localObject).d()));
      }
    }
  }
  
  protected void W0(SmartThingTrigger paramSmartThingTrigger)
  {
    if (paramSmartThingTrigger != null)
    {
      Object localObject = paramSmartThingTrigger.getEvent();
      if (localObject != null)
      {
        paramSmartThingTrigger = this.I3;
        if (paramSmartThingTrigger != null)
        {
          localObject = ((ThingEventParams)localObject).getName();
          j.d(localObject, "eventParams.name");
          paramSmartThingTrigger.B((String)localObject, null);
        }
      }
    }
  }
  
  public static final class a
  {
    public final CameraTriggerFragment a(String paramString)
    {
      j.e(paramString, "deviceIdMD5");
      CameraTriggerFragment localCameraTriggerFragment = new CameraTriggerFragment();
      localCameraTriggerFragment.P0(paramString);
      return localCameraTriggerFragment;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\conditiondevice\camera\CameraTriggerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */