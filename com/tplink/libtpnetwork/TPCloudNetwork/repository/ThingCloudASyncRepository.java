package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceSyncResult;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.mqtt.MqttRepository;
import com.tplink.iot.cloud.mqtt.q0;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.v;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThingCloudASyncRepository
  extends AbstractIoTCloudRepository
  implements q0
{
  private com.tplink.iot.c.b.j h;
  private com.tplink.iot.c.b.a i;
  private MqttRepository j;
  private Map<String, g<com.google.gson.i>> k = new ConcurrentHashMap();
  
  public ThingCloudASyncRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = parama.k();
    this.i = parama.k();
    this.j = ((MqttRepository)b.d.b.f.b.a(parama, MqttRepository.class));
  }
  
  public void a(AsyncResult paramAsyncResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Arrived=");
    ((StringBuilder)localObject).append(com.tplink.libtpnetwork.Utils.i.h(paramAsyncResult));
    b.d.w.c.a.e("Cloud Log", ((StringBuilder)localObject).toString());
    g localg = (g)this.k.remove(paramAsyncResult.getRequestId());
    localObject = localg;
    if (localg == null)
    {
      localObject = io.reactivex.m0.b.n1();
      this.k.put(paramAsyncResult.getRequestId(), localObject);
    }
    if (paramAsyncResult.getCode() == 0)
    {
      ((v)localObject).onNext(paramAsyncResult.getData());
      ((v)localObject).onComplete();
    }
    else
    {
      ((v)localObject).onError(new IoTCloudException(paramAsyncResult.getCode(), paramAsyncResult.getMessage(), paramAsyncResult.getData()));
    }
  }
  
  protected void b()
  {
    super.b();
    this.k.clear();
  }
  
  public q<com.google.gson.i> w(String paramString1, String paramString2, ThingServiceParams paramThingServiceParams)
  {
    return this.h.l(paramString1, paramString2, paramThingServiceParams).L0(io.reactivex.l0.a.c()).g0(new a()).L0(io.reactivex.l0.a.c());
  }
  
  class a
    implements io.reactivex.g0.j<ThingServiceSyncResult, com.google.gson.i>
  {
    a() {}
    
    public com.google.gson.i a(ThingServiceSyncResult paramThingServiceSyncResult)
      throws Exception
    {
      return paramThingServiceSyncResult.getOutputParams();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\ThingCloudASyncRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */