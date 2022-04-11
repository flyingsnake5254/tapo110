package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import b.d.w.h.b;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;

public class s
{
  public static ThingFirmware a(BaseALIoTDevice paramBaseALIoTDevice, LatestFirmwareInfo paramLatestFirmwareInfo)
  {
    ThingFirmware localThingFirmware = new ThingFirmware();
    localThingFirmware.setType(b(paramLatestFirmwareInfo.getType()));
    localThingFirmware.setReleaseNote(paramLatestFirmwareInfo.getRelease_log());
    localThingFirmware.setReleaseDate(paramLatestFirmwareInfo.getRelease_date());
    localThingFirmware.setFwVer(paramLatestFirmwareInfo.getVersion());
    Object localObject = paramBaseALIoTDevice.getCloudIoTDevice();
    String str = "";
    if (localObject != null) {
      localObject = paramBaseALIoTDevice.getCloudIoTDevice().getHwId();
    } else {
      localObject = "";
    }
    localThingFirmware.setHwId((String)localObject);
    localObject = str;
    if (paramBaseALIoTDevice.getCloudIoTDevice() != null) {
      localObject = paramBaseALIoTDevice.getCloudIoTDevice().getOemId();
    }
    localThingFirmware.setOemId((String)localObject);
    boolean bool;
    if (paramLatestFirmwareInfo.getVersion() != null) {
      bool = true;
    } else {
      bool = false;
    }
    localThingFirmware.setNeedToUpgrade(bool);
    return localThingFirmware;
  }
  
  private static int b(String paramString)
  {
    if (b.d(paramString)) {
      return 1;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      if ((i >= 1) && (i <= 4)) {
        return i;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\firmware\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */