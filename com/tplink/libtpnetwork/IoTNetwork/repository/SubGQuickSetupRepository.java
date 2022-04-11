package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubRequest;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.a;
import io.reactivex.q;

public class SubGQuickSetupRepository
  extends AbstractThingRepository
{
  public SubGQuickSetupRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, LocalIoTBaseDevice.class, DeviceRunningInfoResult.class);
  }
  
  public a e5(SubThingAddListParams paramSubThingAddListParams)
  {
    return y0("add_child_device_list", paramSubThingAddListParams, Boolean.class).Z().u(new t9(this, paramSubThingAddListParams));
  }
  
  public a f5(SubThingCategoryScanParams paramSubThingCategoryScanParams)
  {
    return y0("begin_scanning_child_device", paramSubThingCategoryScanParams, Boolean.class).Z().u(new u9(this, paramSubThingCategoryScanParams));
  }
  
  public SubThingQuickSetupInfoParams g5(String paramString1, String paramString2, String paramString3)
  {
    return new SubThingQuickSetupInfoParams(paramString1, i.i(new IoTSubRequest("set_device_info", new DeviceInfoParams(paramString2, paramString3))));
  }
  
  public q<SubThingScanListResult> h5(SubThingCategoryScanParams paramSubThingCategoryScanParams)
  {
    return y0("get_scan_child_device_list", paramSubThingCategoryScanParams, SubThingScanListResult.class).o0(new s9(this));
  }
  
  public a o5(SubThingQuickSetupInfoListParams paramSubThingQuickSetupInfoListParams)
  {
    return this.d.i1(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), paramSubThingQuickSetupInfoListParams);
  }
  
  public a p5(DeviceInfoParams paramDeviceInfoParams, String paramString)
  {
    return C4("set_device_info", paramDeviceInfoParams, Boolean.class, paramString).Z();
  }
  
  public a q5()
  {
    return x0("end_scan_child_device", Boolean.class).Z();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\SubGQuickSetupRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */