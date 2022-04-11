package com.tplink.iot.view.smart.a;

import android.app.Application;
import androidx.lifecycle.LiveData;
import b.d.w.c.a;
import com.tplink.iot.cloud.bean.smart.common.SmartThingStateReported;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerState;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTriggerStateValue;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.cloud.enumerate.StateOperator;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.q;
import com.tplink.libtpnetwork.enumerate.EnumRotateDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class f
{
  public static final f a = new f();
  
  public static final EnumRotateDirection a(SmartThingTrigger paramSmartThingTrigger)
  {
    Object localObject1 = null;
    if (paramSmartThingTrigger != null)
    {
      Object localObject2 = paramSmartThingTrigger.getEvent();
      if (localObject2 != null) {
        localObject2 = ((ThingEventParams)localObject2).getName();
      } else {
        localObject2 = null;
      }
      if (j.a(localObject2, "rotation"))
      {
        paramSmartThingTrigger = paramSmartThingTrigger.getEvent();
        j.d(paramSmartThingTrigger, "trigger.event");
        paramSmartThingTrigger = paramSmartThingTrigger.getParamList();
        if (paramSmartThingTrigger != null)
        {
          Object localObject3 = paramSmartThingTrigger.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            paramSmartThingTrigger = ((Iterator)localObject3).next();
            localObject2 = (SmartThingTriggerState)paramSmartThingTrigger;
            j.d(localObject2, "it");
            if (j.a(((SmartThingTriggerState)localObject2).getKey(), "rotate_deg")) {
              break label105;
            }
          }
          paramSmartThingTrigger = null;
          label105:
          localObject2 = (SmartThingTriggerState)paramSmartThingTrigger;
          if (localObject2 != null)
          {
            localObject3 = ((SmartThingTriggerState)localObject2).getValue();
            paramSmartThingTrigger = (SmartThingTrigger)localObject1;
            if (localObject3 != null) {
              paramSmartThingTrigger = ((SmartThingTriggerStateValue)localObject3).getData();
            }
            if ((j.a(paramSmartThingTrigger, "0")) && (((SmartThingTriggerState)localObject2).getOp() == StateOperator.LT)) {
              paramSmartThingTrigger = EnumRotateDirection.ANTICLOCKWISE;
            } else {
              paramSmartThingTrigger = EnumRotateDirection.CLOCKWISE;
            }
            return paramSmartThingTrigger;
          }
        }
      }
    }
    return null;
  }
  
  public static final String b(SmartThingStateReported paramSmartThingStateReported)
  {
    String str = "";
    Object localObject1 = str;
    if (paramSmartThingStateReported != null)
    {
      Object localObject2 = paramSmartThingStateReported.getStateList();
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((List)localObject2).size() == 2)
        {
          Object localObject3 = ((Iterable)localObject2).iterator();
          Object localObject4;
          do
          {
            boolean bool = ((Iterator)localObject3).hasNext();
            localObject4 = null;
            if (!bool) {
              break;
            }
            paramSmartThingStateReported = ((Iterator)localObject3).next();
            localObject1 = (SmartThingTriggerState)paramSmartThingStateReported;
            j.d(localObject1, "it");
          } while (!j.a(((SmartThingTriggerState)localObject1).getKey(), "current_temp"));
          break label93;
          paramSmartThingStateReported = null;
          label93:
          localObject3 = (SmartThingTriggerState)paramSmartThingStateReported;
          localObject1 = str;
          if (localObject3 != null)
          {
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              paramSmartThingStateReported = ((Iterator)localObject2).next();
              localObject1 = (SmartThingTriggerState)paramSmartThingStateReported;
              j.d(localObject1, "it");
              if (j.a(((SmartThingTriggerState)localObject1).getKey(), "temp_unit")) {
                break label157;
              }
            }
            paramSmartThingStateReported = null;
            label157:
            paramSmartThingStateReported = (SmartThingTriggerState)paramSmartThingStateReported;
            localObject1 = str;
            if (paramSmartThingStateReported != null)
            {
              localObject1 = ((SmartThingTriggerState)localObject3).getValue();
              if (localObject1 != null)
              {
                localObject1 = ((SmartThingTriggerStateValue)localObject1).getData();
                if (localObject1 != null)
                {
                  localObject1 = m.k((String)localObject1);
                  if (localObject1 != null)
                  {
                    i = ((Integer)localObject1).intValue();
                    break label208;
                  }
                }
              }
              int i = 0;
              label208:
              localObject1 = paramSmartThingStateReported.getValue();
              paramSmartThingStateReported = (SmartThingStateReported)localObject4;
              if (localObject1 != null) {
                paramSmartThingStateReported = ((SmartThingTriggerStateValue)localObject1).getData();
              }
              paramSmartThingStateReported = b.e(i, paramSmartThingStateReported);
              localObject1 = ((SmartThingTriggerState)localObject3).getOp();
              if (localObject1 == null)
              {
                localObject1 = str;
              }
              else
              {
                i = e.a[localObject1.ordinal()];
                if (i != 1)
                {
                  if (i != 2)
                  {
                    localObject1 = str;
                  }
                  else
                  {
                    localObject1 = AppContext.c.getString(2131954094, new Object[] { paramSmartThingStateReported });
                    j.d(localObject1, "AppContext.instance.getS…ure_below_desc, tempText)");
                  }
                }
                else
                {
                  localObject1 = AppContext.c.getString(2131954092, new Object[] { paramSmartThingStateReported });
                  j.d(localObject1, "AppContext.instance.getS…ure_above_desc, tempText)");
                }
              }
            }
          }
        }
      }
    }
    return (String)localObject1;
  }
  
  public static final boolean c(SmartThingTrigger paramSmartThingTrigger, BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramSmartThingTrigger != null)
    {
      bool2 = bool1;
      if (paramBaseALIoTDevice != null)
      {
        bool2 = bool1;
        if (paramBaseALIoTDevice.isSwitch())
        {
          paramSmartThingTrigger = paramSmartThingTrigger.getEvent();
          Object localObject = null;
          if (paramSmartThingTrigger != null) {
            paramSmartThingTrigger = paramSmartThingTrigger.getName();
          } else {
            paramSmartThingTrigger = null;
          }
          bool2 = bool1;
          if (j.a(paramSmartThingTrigger, "doubleClick"))
          {
            SwitchRepository localSwitchRepository = (SwitchRepository)e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class);
            paramBaseALIoTDevice = new StringBuilder();
            paramBaseALIoTDevice.append("isDoubleClickEventEnabled: ");
            DoubleClickInfoBean localDoubleClickInfoBean = (DoubleClickInfoBean)localSwitchRepository.n4().getValue();
            paramSmartThingTrigger = (SmartThingTrigger)localObject;
            if (localDoubleClickInfoBean != null) {
              paramSmartThingTrigger = Boolean.valueOf(localDoubleClickInfoBean.getEnable());
            }
            paramBaseALIoTDevice.append(paramSmartThingTrigger);
            a.n("Smart", paramBaseALIoTDevice.toString());
            paramSmartThingTrigger = (DoubleClickInfoBean)localSwitchRepository.n4().getValue();
            bool2 = bool1;
            if (paramSmartThingTrigger != null) {
              bool2 = paramSmartThingTrigger.getEnable();
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public static final boolean d(SmartThingTrigger paramSmartThingTrigger, BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if ((paramSmartThingTrigger != null) && (paramBaseALIoTDevice != null))
    {
      if (!paramBaseALIoTDevice.isCamera()) {
        return true;
      }
      paramSmartThingTrigger = paramSmartThingTrigger.getEvent();
      if (paramSmartThingTrigger != null)
      {
        paramSmartThingTrigger = paramSmartThingTrigger.getName();
        if (paramSmartThingTrigger != null)
        {
          paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceIdMD5();
          j.d(paramBaseALIoTDevice, "device.deviceIdMD5");
          return q.a(paramSmartThingTrigger, paramBaseALIoTDevice);
        }
      }
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */