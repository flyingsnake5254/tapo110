package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.thing.common.ThingEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.l;
import kotlin.n;
import kotlin.t.c;
import kotlin.v.e;

public final class DeviceTriggerViewModel
  extends AndroidViewModel
{
  private final ThingContext b;
  private final c c;
  private final Map<String, Boolean> d;
  
  public DeviceTriggerViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = paramThingContext;
    this.c = new a(paramThingContext);
    paramApplication = g();
    if (paramApplication != null)
    {
      paramApplication = paramApplication.getEvents();
      if (paramApplication != null)
      {
        paramThingContext = new LinkedHashMap(e.b(b0.a(l.l(paramApplication, 10)), 16));
        Iterator localIterator = paramApplication.iterator();
        for (;;)
        {
          paramApplication = paramThingContext;
          if (!localIterator.hasNext()) {
            break;
          }
          paramApplication = (ThingEvent)localIterator.next();
          kotlin.jvm.internal.j.d(paramApplication, "it");
          paramApplication = n.a(paramApplication.getId(), Boolean.TRUE);
          paramThingContext.put(paramApplication.getFirst(), paramApplication.getSecond());
        }
      }
    }
    paramApplication = b0.d();
    this.d = paramApplication;
  }
  
  private final ThingCloudRepository f()
  {
    return (ThingCloudRepository)this.c.b(this, a[0]);
  }
  
  private final ThingModel g()
  {
    Object localObject = this.b.getThingModel();
    if (localObject == null)
    {
      localObject = this.b.getThingDevice();
      if (localObject != null)
      {
        localObject = ((ThingDevice)localObject).getThingModelId();
        if (localObject != null) {
          return f().m0((String)localObject);
        }
      }
      localObject = null;
    }
    return (ThingModel)localObject;
  }
  
  public static final class a
    implements c<Object, ThingCloudRepository>
  {
    private final ThingCloudRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = b.a(paramThingContext.getAccountContext(), ThingCloudRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "CloudRepositoryProviders…ontext, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public ThingCloudRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\DeviceTriggerViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */