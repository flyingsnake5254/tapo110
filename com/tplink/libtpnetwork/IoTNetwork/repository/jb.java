package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.iot.cloud.bean.thing.params.ThingShadowUpdateParams;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class jb
  implements IMqttMessageListener
{
  private ThingContext a;
  private c b;
  private ThingCloudRepository c;
  private ThingBaseRepository d;
  private BlockingQueue<ThingShadowUpdateParams> e;
  private final ConcurrentHashMap<ThingShadowUpdateParams, b> f;
  private b g;
  private ThingShadow h;
  
  public jb(ThingContext paramThingContext, ThingCloudRepository paramThingCloudRepository, ThingBaseRepository paramThingBaseRepository, c paramc)
  {
    this.a = paramThingContext;
    this.b = paramc;
    this.c = paramThingCloudRepository;
    this.d = paramThingBaseRepository;
    this.e = new LinkedBlockingQueue(16);
    this.f = new ConcurrentHashMap();
    this.g = new b();
  }
  
  private q<Long> C(b paramb)
  {
    return this.c.t1(this.a.getThingUrl(), this.a.getThingName(), this.a.getThingGatewayUrlV2(), paramb.c(), this).v0(1L, new va(this, paramb)).o0(new sa(this, paramb)).G(new ya(this, paramb)).F(new xa(this, paramb));
  }
  
  private void D(ThingShadow paramThingShadow)
  {
    if (paramThingShadow != null)
    {
      this.a.updateThingShadow(paramThingShadow.getVersion(), paramThingShadow.getState().getDesired(), paramThingShadow.getState().getReported());
      if (paramThingShadow.getState().getReported() != null) {
        this.b.a();
      }
    }
  }
  
  private void c(ThingShadowUpdateParams paramThingShadowUpdateParams, Throwable paramThrowable)
  {
    b localb = (b)this.f.remove(paramThingShadowUpdateParams);
    if (localb != null)
    {
      Object localObject = localb.b();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ThingShadowUpdateParams localThingShadowUpdateParams = (ThingShadowUpdateParams)((Iterator)localObject).next();
          if (localThingShadowUpdateParams != paramThingShadowUpdateParams) {
            c(localThingShadowUpdateParams, paramThrowable);
          }
        }
      }
      if (localb.a() != null) {
        localb.a().onError(paramThrowable);
      }
    }
  }
  
  private void d(ThingShadowUpdateParams paramThingShadowUpdateParams)
  {
    b localb = (b)this.f.remove(paramThingShadowUpdateParams);
    if (localb != null)
    {
      Object localObject = localb.b();
      if (localObject != null)
      {
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = (ThingShadowUpdateParams)localIterator.next();
          if (localObject != paramThingShadowUpdateParams) {
            d((ThingShadowUpdateParams)localObject);
          }
        }
      }
      if (localb.a() != null) {
        localb.a().onComplete();
      }
    }
  }
  
  private List<ThingShadowUpdateParams> e()
  {
    ArrayList localArrayList = new ArrayList();
    this.e.drainTo(localArrayList);
    return localArrayList;
  }
  
  private boolean g(Throwable paramThrowable)
  {
    boolean bool;
    if (((paramThrowable instanceof IoTCloudException)) && (((IoTCloudException)paramThrowable).getCode() == 11000)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void y(b arg1)
  {
    Object localObject1 = e();
    if (!((List)localObject1).isEmpty())
    {
      HashMap localHashMap = new HashMap(???.c().getState().getDesired());
      ThingShadowUpdateParams localThingShadowUpdateParams1 = new ThingShadowUpdateParams(???.c().getVersion(), new ThingShadowState(localHashMap));
      synchronized (this.f)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ThingShadowUpdateParams localThingShadowUpdateParams2 = (ThingShadowUpdateParams)((Iterator)localObject1).next();
          if (localThingShadowUpdateParams2.getVersion() > localThingShadowUpdateParams1.getVersion()) {
            localThingShadowUpdateParams1.setVersion(localThingShadowUpdateParams2.getVersion());
          }
          localHashMap.putAll(localThingShadowUpdateParams2.getState().getDesired());
          b localb = new com/tplink/libtpnetwork/IoTNetwork/repository/jb$b;
          localb.<init>(this, localThingShadowUpdateParams1);
          this.f.put(localThingShadowUpdateParams2, localb);
        }
      }
    }
  }
  
  private void z(ThingShadowUpdateParams paramThingShadowUpdateParams, r<b> paramr)
  {
    List localList = e();
    synchronized (this.f)
    {
      boolean bool = localList.isEmpty();
      ThingShadowUpdateParams localThingShadowUpdateParams1 = null;
      Object localObject1 = null;
      Object localObject2;
      if (bool)
      {
        paramThingShadowUpdateParams = (b)this.f.get(paramThingShadowUpdateParams);
        localObject2 = localThingShadowUpdateParams1;
        if (paramThingShadowUpdateParams != null)
        {
          paramThingShadowUpdateParams.e(paramr);
          localObject2 = localThingShadowUpdateParams1;
        }
      }
      else
      {
        HashMap localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        localThingShadowUpdateParams1 = new com/tplink/iot/cloud/bean/thing/params/ThingShadowUpdateParams;
        localObject2 = new com/tplink/iot/cloud/bean/thing/common/ThingShadowState;
        ((ThingShadowState)localObject2).<init>(localHashMap);
        localThingShadowUpdateParams1.<init>(0L, (ThingShadowState)localObject2);
        Iterator localIterator = localList.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          ThingShadowUpdateParams localThingShadowUpdateParams2 = (ThingShadowUpdateParams)localIterator.next();
          localThingShadowUpdateParams1.setVersion(localThingShadowUpdateParams2.getVersion());
          localHashMap.putAll(localThingShadowUpdateParams2.getState().getDesired());
          localObject2 = new com/tplink/libtpnetwork/IoTNetwork/repository/jb$b;
          ((b)localObject2).<init>(this, localThingShadowUpdateParams1);
          if (localThingShadowUpdateParams2 == paramThingShadowUpdateParams)
          {
            ((b)localObject2).e(paramr);
            ((b)localObject2).f(localList);
            localObject1 = localObject2;
          }
          this.f.put(localThingShadowUpdateParams2, localObject2);
        }
      }
      if (localObject2 != null) {
        paramr.onNext(localObject2);
      }
      return;
    }
  }
  
  public void A(ThingShadow paramThingShadow)
  {
    if (this.h == null) {
      this.h = new ThingShadow(0L, new ThingShadowState(new HashMap(), new HashMap()));
    }
    if (paramThingShadow.getVersion() >= this.h.getVersion())
    {
      this.h.setVersion(paramThingShadow.getVersion());
      if (paramThingShadow.getState() != null)
      {
        Map localMap = paramThingShadow.getState().getDesired();
        if (localMap != null) {
          this.h.getState().getDesired().putAll(localMap);
        }
        paramThingShadow = paramThingShadow.getState().getReported();
        if (paramThingShadow != null) {
          this.h.getState().getReported().putAll(paramThingShadow);
        }
      }
    }
  }
  
  public io.reactivex.a B(ThingShadowUpdateParams paramThingShadowUpdateParams)
  {
    return q.m(new wa(this, paramThingShadowUpdateParams)).N(new a()).N(new ua(this)).E(new ta(this, paramThingShadowUpdateParams)).C(new za(this, paramThingShadowUpdateParams)).F(new ra(this, paramThingShadowUpdateParams)).Z();
  }
  
  public boolean f()
  {
    boolean bool;
    if (this.g.f() <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void messageArrived(String paramString, MqttMessage paramMqttMessage)
    throws Exception
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramMqttMessage);
    b.d.w.c.a.m(localStringBuilder.toString());
    paramString = (ThingShadow)i.b(paramMqttMessage.toString(), ThingShadow.class);
    A(paramString);
    if (f()) {
      paramString = this.h;
    }
    D(paramString);
  }
  
  class a
    implements j<jb.b, t<jb.b>>
  {
    a() {}
    
    public t<jb.b> a(final jb.b paramb)
      throws Exception
    {
      if (jb.a(jb.this).getThingShadow() != null) {
        return q.f0(paramb);
      }
      return jb.b(jb.this).w0(jb.a(jb.this).getThingUrl(), jb.a(jb.this).getThingName()).g0(new a(paramb));
    }
    
    class a
      implements j<ThingShadowResult, jb.b>
    {
      a(jb.b paramb) {}
      
      public jb.b a(ThingShadowResult paramThingShadowResult)
        throws Exception
      {
        return paramb;
      }
    }
  }
  
  private class b
  {
    private ThingShadowUpdateParams a;
    private g<b> b;
    private List<ThingShadowUpdateParams> c;
    private c d;
    
    b(ThingShadowUpdateParams paramThingShadowUpdateParams)
    {
      this.a = paramThingShadowUpdateParams;
    }
    
    public g<b> a()
    {
      return this.b;
    }
    
    public List<ThingShadowUpdateParams> b()
    {
      return this.c;
    }
    
    public ThingShadowUpdateParams c()
    {
      return this.a;
    }
    
    public c d()
    {
      return this.d;
    }
    
    public void e(g<b> paramg)
    {
      this.b = paramg;
    }
    
    public void f(List<ThingShadowUpdateParams> paramList)
    {
      this.c = paramList;
    }
    
    public void g(c paramc)
    {
      this.d = paramc;
    }
  }
  
  static abstract interface c
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\jb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */