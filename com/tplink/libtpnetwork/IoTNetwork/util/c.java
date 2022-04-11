package com.tplink.libtpnetwork.IoTNetwork.util;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class c
{
  public static final c a = new c();
  
  public static final ThingBaseRepository a(@NonNull ThingContext paramThingContext)
  {
    j.e(paramThingContext, "thingContext");
    ALIoTDevice localALIoTDevice = (ALIoTDevice)paramThingContext.getIoTDevice();
    EnumDeviceType localEnumDeviceType;
    if (localALIoTDevice != null)
    {
      localEnumDeviceType = localALIoTDevice.getEnumDeviceType();
      if (localEnumDeviceType != null) {}
    }
    else
    {
      localEnumDeviceType = EnumDeviceType.UNKNOWN;
    }
    switch (b.a[localEnumDeviceType.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 7: 
    case 8: 
      paramThingContext = null;
      break;
    case 6: 
      paramThingContext = (ThingBaseRepository)e.a(paramThingContext, TRVRepository.class);
      break;
    case 5: 
      paramThingContext = (ThingBaseRepository)e.a(paramThingContext, SensorRepository.class);
      break;
    case 4: 
      paramThingContext = (ThingBaseRepository)e.a(paramThingContext, SwitchRepository.class);
      break;
    case 3: 
      paramThingContext = (ThingBaseRepository)e.a(paramThingContext, HubRepository.class);
      break;
    case 2: 
      if ((localALIoTDevice != null) && (localALIoTDevice.isLightStrip() == true)) {
        paramThingContext = (AbstractThingRepository)e.a(paramThingContext, LightStripRepository.class);
      } else {
        paramThingContext = (AbstractThingRepository)e.a(paramThingContext, BulbRepository.class);
      }
      break;
    case 1: 
      paramThingContext = (ThingBaseRepository)e.a(paramThingContext, PlugRepository.class);
    }
    return paramThingContext;
  }
  
  public static final ThingBaseRepository b(@NonNull String paramString)
  {
    j.e(paramString, "deviceIdMD5");
    paramString = TPIoTClientManager.k2(paramString);
    j.d(paramString, "TPIoTClientManager.getThingContext(deviceIdMD5)");
    return a(paramString);
  }
  
  public static final ThingBaseRepository c(@NonNull ThingContext paramThingContext)
  {
    j.e(paramThingContext, "thingContext");
    ThingBaseRepository localThingBaseRepository = a(paramThingContext);
    if (localThingBaseRepository != null)
    {
      paramThingContext = localThingBaseRepository;
    }
    else
    {
      paramThingContext = e.a(paramThingContext, PlugRepository.class);
      j.d(paramThingContext, "IoTDeviceRepositoryProvi…ugRepository::class.java)");
      paramThingContext = (ThingBaseRepository)paramThingContext;
    }
    return paramThingContext;
  }
  
  public static final ThingBaseRepository d(@NonNull String paramString)
  {
    j.e(paramString, "deviceIdMD5");
    ThingBaseRepository localThingBaseRepository = b(paramString);
    if (localThingBaseRepository != null)
    {
      paramString = localThingBaseRepository;
    }
    else
    {
      paramString = e.a(TPIoTClientManager.k2(paramString), PlugRepository.class);
      j.d(paramString, "IoTDeviceRepositoryProvi…ugRepository::class.java)");
      paramString = (ThingBaseRepository)paramString;
    }
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */