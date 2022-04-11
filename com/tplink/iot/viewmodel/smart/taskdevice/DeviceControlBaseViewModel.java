package com.tplink.iot.viewmodel.smart.taskdevice;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.t.c;

public final class DeviceControlBaseViewModel
  extends AndroidViewModel
{
  private final c b;
  private final TPBaseDeviceContext<?> c;
  private final f d;
  
  public DeviceControlBaseViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    kotlin.jvm.internal.j.d(paramApplication, "TPAppCloudContext.getCurrentAccountContext()");
    this.b = new a(paramApplication);
    this.d = h.b(new c(this));
    this.c = paramThingContext;
  }
  
  public DeviceControlBaseViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    kotlin.jvm.internal.j.d(paramApplication, "TPAppCloudContext.getCurrentAccountContext()");
    this.b = new b(paramApplication);
    this.d = h.b(new c(this));
    this.c = paramTPCameraDeviceContext;
  }
  
  private final ThingModel g(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    ThingModel localThingModel = paramTPCameraDeviceContext.getThingModel();
    if (localThingModel != null) {
      paramTPCameraDeviceContext = localThingModel;
    } else {
      paramTPCameraDeviceContext = i().m0(paramTPCameraDeviceContext.getThingModelId());
    }
    return paramTPCameraDeviceContext;
  }
  
  private final ThingModel h(ThingContext paramThingContext)
  {
    ThingModel localThingModel = paramThingContext.getThingModel();
    if (localThingModel != null) {
      paramThingContext = localThingModel;
    } else {
      paramThingContext = i().m0(paramThingContext.getThingModelId());
    }
    return paramThingContext;
  }
  
  private final ThingCloudRepository i()
  {
    return (ThingCloudRepository)this.b.b(this, a[0]);
  }
  
  private final ThingModel j()
  {
    return (ThingModel)this.d.getValue();
  }
  
  private final ThingModel k()
  {
    Object localObject = this.c;
    if ((localObject instanceof ThingContext)) {
      localObject = h((ThingContext)localObject);
    } else if ((localObject instanceof TPCameraDeviceContext)) {
      localObject = g((TPCameraDeviceContext)localObject);
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThingModel is: ");
    localStringBuilder.append(l.h(localObject));
    b.d.w.c.a.n("Smart", localStringBuilder.toString());
    return (ThingModel)localObject;
  }
  
  public final boolean l(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      ThingModel localThingModel = j();
      if (localThingModel != null) {
        paramString = localThingModel.getThingProperty(paramString);
      } else {
        paramString = null;
      }
      bool2 = bool1;
      if (paramString != null) {
        bool2 = true;
      }
    }
    return bool2;
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
  
  public static final class b
    implements c<Object, ThingCloudRepository>
  {
    private final ThingCloudRepository a;
    
    public b(com.tplink.cloud.context.b paramb)
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
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<ThingModel>
  {
    c(DeviceControlBaseViewModel paramDeviceControlBaseViewModel)
    {
      super();
    }
    
    public final ThingModel a()
    {
      return DeviceControlBaseViewModel.f(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\taskdevice\DeviceControlBaseViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */