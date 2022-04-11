package com.tplink.iot.cloud.mqtt;

import b.d.b.c.j;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.webservice.params.AppServiceUrlParams;
import com.tplink.iot.cloud.bean.auth.params.AuthParams;
import com.tplink.iot.cloud.bean.auth.result.AuthResult;
import com.tplink.iot.cloud.bean.auth.result.ServerInfoResult;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;

public class MqttRepository
  extends AbstractIoTCloudRepository
{
  private com.tplink.iot.c.b.b h;
  private String i;
  private String j;
  private AuthResult k;
  private final ConcurrentHashMap<String, p0> l = new ConcurrentHashMap();
  private final Map<String, Semaphore> m = new HashMap();
  private final Semaphore n = new Semaphore(1);
  
  public MqttRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = ((com.tplink.iot.c.b.b)parama.k().R1(com.tplink.iot.c.b.b.class));
  }
  
  private io.reactivex.q<Boolean> A(p0 paramp0, String paramString)
  {
    return v0().N(new s(paramp0, paramString)).v0(1L, new k0(this)).F(new g0(this, paramString)).y(new a0(this, paramString));
  }
  
  private io.reactivex.a A0(p0 paramp0, String paramString, IMqttMessageListener paramIMqttMessageListener)
  {
    return paramp0.h0(paramString, paramIMqttMessageListener).w(new l0(this));
  }
  
  private p0 B(String paramString)
  {
    synchronized (this.l)
    {
      Object localObject1 = (p0)this.l.get(paramString);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new com/tplink/iot/cloud/mqtt/p0;
        ((p0)localObject2).<init>(paramString, this.e.k().S1(), null);
        this.l.put(paramString, localObject2);
        localObject1 = this.m;
        Semaphore localSemaphore = new java/util/concurrent/Semaphore;
        localSemaphore.<init>(1);
        ((Map)localObject1).put(paramString, localSemaphore);
      }
      return (p0)localObject2;
    }
  }
  
  private boolean C()
  {
    if (!this.e.n())
    {
      AuthResult localAuthResult = this.k;
      if ((localAuthResult != null) && (!localAuthResult.isExpired())) {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  private io.reactivex.q<ServerInfoResult> u0()
  {
    return this.g.l0(new CloudParams("getAppServiceUrl", new AppServiceUrlParams(Arrays.asList(new String[] { this.f.getIotAppServerId(), this.f.getIotGatewayId(), this.f.getIotSecurityId() })))).g0(new y(this));
  }
  
  private io.reactivex.q<String> v0()
  {
    return io.reactivex.q.f1(io.reactivex.q.X(new c0(this)), y0(), d0.c).N(new e0(this));
  }
  
  private io.reactivex.q<Boolean> w0()
  {
    return io.reactivex.q.Y(this.l.values()).N(new b0(this));
  }
  
  private io.reactivex.q<Boolean> x0(p0 paramp0)
  {
    return paramp0.b0().N(new h0(this, paramp0));
  }
  
  private io.reactivex.q<String> y0()
  {
    io.reactivex.q localq = io.reactivex.q.X(new w(this)).N(new n0(this)).F(new v(this));
    Semaphore localSemaphore = this.n;
    localSemaphore.getClass();
    return localq.y(new a(localSemaphore)).L0(io.reactivex.l0.a.c());
  }
  
  private io.reactivex.q<String> z()
  {
    return this.h.g1(this.j, new AuthParams(this.e.h(), this.e.m(), this.e.j())).g0(new q(this));
  }
  
  private io.reactivex.a z0(p0 paramp0, String paramString1, String paramString2, IMqttMessageListener paramIMqttMessageListener)
  {
    return A(paramp0, paramString1).R(new r(this, paramp0, paramString2, paramIMqttMessageListener));
  }
  
  public io.reactivex.a B0(String paramString1, String paramString2, IMqttMessageListener paramIMqttMessageListener)
  {
    return z0(B(paramString1), paramString1, paramString2, paramIMqttMessageListener);
  }
  
  public io.reactivex.a C0(String paramString1, String paramString2)
  {
    return B(paramString1).k0(paramString2).v(1L, o0.c);
  }
  
  public boolean D(String paramString1, String paramString2)
  {
    paramString1 = (p0)this.l.get(paramString1);
    boolean bool;
    if ((paramString1 != null) && (paramString1.s(paramString2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void b()
  {
    super.b();
    io.reactivex.q.Y(this.l.values()).R(b.c).y();
  }
  
  public io.reactivex.a w(q0 paramq0)
  {
    return y0().N(new f0(this, paramq0)).Z();
  }
  
  public io.reactivex.q<p0> x(String paramString, q0 paramq0)
  {
    return io.reactivex.q.X(new u(this, paramString, paramq0)).N(new j0(this, paramString));
  }
  
  public io.reactivex.a y(String paramString1, q0 paramq0, String paramString2, IMqttMessageListener paramIMqttMessageListener)
  {
    return x(paramString1, paramq0).E(new x(this, paramString2, paramIMqttMessageListener)).Z();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\mqtt\MqttRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */