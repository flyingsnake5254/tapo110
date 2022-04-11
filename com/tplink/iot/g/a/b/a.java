package com.tplink.iot.g.a.b;

import androidx.lifecycle.LiveData;
import com.google.gson.k;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmVolume;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class a
{
  public static final a a = new a();
  
  public final ThingServiceParams a(BaseALIoTDevice<?> paramBaseALIoTDevice, EnumGuardModeAlarmVolume paramEnumGuardModeAlarmVolume, int paramInt, String paramString)
  {
    j.e(paramEnumGuardModeAlarmVolume, "alarmVolume");
    String str1 = "";
    String str2 = str1;
    if (paramBaseALIoTDevice != null)
    {
      boolean bool = paramBaseALIoTDevice.isHub();
      int i = 1;
      str2 = str1;
      if (bool == true)
      {
        paramBaseALIoTDevice = e.d(paramBaseALIoTDevice.getDeviceIdMD5(), HubRepository.class);
        j.d(paramBaseALIoTDevice, "IoTDeviceRepositoryProvi…ubRepository::class.java)");
        paramBaseALIoTDevice = ((HubRepository)paramBaseALIoTDevice).q5();
        j.d(paramBaseALIoTDevice, "IoTDeviceRepositoryProvi…portAlarmTypeListLiveData");
        paramBaseALIoTDevice = (List)paramBaseALIoTDevice.getValue();
        if (paramBaseALIoTDevice == null) {
          paramBaseALIoTDevice = l.d();
        }
        int j = i;
        if (paramString != null) {
          if (paramString.length() == 0) {
            j = i;
          } else {
            j = 0;
          }
        }
        if ((j != 0) || (!paramBaseALIoTDevice.contains(paramString)))
        {
          paramString = (String)l.y(paramBaseALIoTDevice);
          if (paramString == null) {
            paramString = "";
          }
        }
        str2 = paramString;
      }
    }
    paramBaseALIoTDevice = new k();
    paramBaseALIoTDevice.m("type", str2);
    paramBaseALIoTDevice.m("volume", paramEnumGuardModeAlarmVolume.getValue());
    paramBaseALIoTDevice.l("duration", Integer.valueOf(paramInt));
    return new ThingServiceParams("ring", paramBaseALIoTDevice);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */