package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import b.d.s.a.a;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import kotlin.t.c;

public final class DeviceChooseViewModel
  extends AndroidViewModel
{
  private final c b;
  
  public DeviceChooseViewModel(Application paramApplication)
  {
    super(paramApplication);
    paramApplication = a.f();
    kotlin.jvm.internal.j.d(paramApplication, "TPAppCloudContext.getCurrentAccountContext()");
    this.b = new a(paramApplication);
  }
  
  private final ThingModel f(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    if (paramTPCameraDeviceContext != null)
    {
      localObject = paramTPCameraDeviceContext.getThingModel();
      if (localObject != null) {
        return (TPCameraDeviceContext)localObject;
      }
    }
    Object localObject = h();
    if (paramTPCameraDeviceContext != null) {
      paramTPCameraDeviceContext = paramTPCameraDeviceContext.getThingModelId();
    } else {
      paramTPCameraDeviceContext = null;
    }
    paramTPCameraDeviceContext = ((ThingCloudRepository)localObject).m0(paramTPCameraDeviceContext);
    return paramTPCameraDeviceContext;
  }
  
  private final ThingModel g(ThingContext paramThingContext)
  {
    if (paramThingContext != null)
    {
      localObject = paramThingContext.getThingModel();
      if (localObject != null) {
        return (ThingContext)localObject;
      }
    }
    Object localObject = h();
    if (paramThingContext != null)
    {
      paramThingContext = paramThingContext.getThingDevice();
      if (paramThingContext != null)
      {
        paramThingContext = paramThingContext.getThingModelId();
        break label46;
      }
    }
    paramThingContext = null;
    label46:
    paramThingContext = ((ThingCloudRepository)localObject).m0(paramThingContext);
    return paramThingContext;
  }
  
  private final ThingCloudRepository h()
  {
    return (ThingCloudRepository)this.b.b(this, a[0]);
  }
  
  public final ThingModel i(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return null;
    }
    if (paramBaseALIoTDevice.isCamera()) {
      paramBaseALIoTDevice = f(TPIoTClientManager.K1(paramBaseALIoTDevice.getDeviceIdMD5()));
    } else {
      paramBaseALIoTDevice = g(TPIoTClientManager.k2(paramBaseALIoTDevice.getDeviceIdMD5()));
    }
    return paramBaseALIoTDevice;
  }
  
  public static final class a
    implements c<Object, ThingCloudRepository>
  {
    private final ThingCloudRepository a;
    
    public a(com.tplink.cloud.context.b paramb)
    {
      paramb = b.d.b.f.b.a(paramb, ThingCloudRepository.class);
      kotlin.jvm.internal.j.d(paramb, "CloudRepositoryProviders…sitory, REPO::class.java)");
      this.a = paramb;
    }
    
    public ThingCloudRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\DeviceChooseViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */