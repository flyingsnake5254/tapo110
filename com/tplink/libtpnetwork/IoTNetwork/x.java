package com.tplink.libtpnetwork.IoTNetwork;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.d.d0.c2;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.Utils.c0;
import com.tplink.libtpnetwork.Utils.n;
import com.tplink.libtpnetwork.Utils.r.b;
import com.tplink.libtpnetwork.Utils.z;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class x
  implements com.tplink.libtpnetwork.IoTNetwork.y.c.b
{
  private com.tplink.libtpnetwork.IoTNetwork.y.c.a a;
  private com.tplink.libtpnetwork.IoTNetwork.transport.http.b b;
  private com.tplink.libtpnetwork.IoTNetwork.y.d.a c;
  private final List<t> d = new ArrayList();
  private io.reactivex.m0.g<Boolean> e = io.reactivex.m0.b.n1().l1();
  private com.tplink.libtpnetwork.IoTNetwork.y.a f;
  private String g = c0.b();
  
  public x() {}
  
  public x(@NonNull ThingContext paramThingContext)
  {
    E(paramThingContext);
  }
  
  private void A(String paramString)
  {
    List localList = this.d;
    Object localObject1 = null;
    try
    {
      Iterator localIterator = this.d.iterator();
      Object localObject2;
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (t)localIterator.next();
      } while (!paramString.equals(((t)localObject2).a()));
      if (localObject2 != null)
      {
        this.d.remove(localObject2);
        ((t)localObject2).b().onComplete();
      }
      return;
    }
    finally {}
  }
  
  private void B(final String paramString)
  {
    io.reactivex.a.e().C(io.reactivex.l0.a.c()).z(new m(paramString));
  }
  
  private com.tplink.libtpnetwork.IoTNetwork.y.a C(EnumIoTTransportType paramEnumIoTTransportType)
  {
    if (paramEnumIoTTransportType == null)
    {
      paramEnumIoTTransportType = this.b;
      if ((paramEnumIoTTransportType != null) && (paramEnumIoTTransportType.d())) {
        return this.b;
      }
      paramEnumIoTTransportType = this.a;
      if ((paramEnumIoTTransportType != null) && (paramEnumIoTTransportType.d())) {
        return this.a;
      }
      paramEnumIoTTransportType = this.c;
      if ((paramEnumIoTTransportType != null) && (paramEnumIoTTransportType.d())) {
        return this.c;
      }
    }
    else if (paramEnumIoTTransportType == EnumIoTTransportType.HTTP)
    {
      paramEnumIoTTransportType = this.b;
      if ((paramEnumIoTTransportType != null) && (paramEnumIoTTransportType.d())) {
        return this.b;
      }
    }
    else if (paramEnumIoTTransportType == EnumIoTTransportType.PASS_THROUGH)
    {
      paramEnumIoTTransportType = this.c;
      if ((paramEnumIoTTransportType != null) && (paramEnumIoTTransportType.d())) {
        return this.c;
      }
    }
    else if (paramEnumIoTTransportType == EnumIoTTransportType.BLE)
    {
      paramEnumIoTTransportType = this.a;
      if ((paramEnumIoTTransportType != null) && (paramEnumIoTTransportType.d())) {
        return this.a;
      }
    }
    return null;
  }
  
  private void D()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((com.tplink.libtpnetwork.IoTNetwork.y.a)localObject).d()))
    {
      this.e.onNext(Boolean.TRUE);
      return;
    }
    localObject = this.a;
    if ((localObject != null) && (((com.tplink.libtpnetwork.IoTNetwork.y.a)localObject).d()))
    {
      this.e.onNext(Boolean.TRUE);
      return;
    }
    localObject = this.c;
    if ((localObject != null) && (((com.tplink.libtpnetwork.IoTNetwork.y.a)localObject).d()))
    {
      this.e.onNext(Boolean.TRUE);
      return;
    }
    this.e.onNext(Boolean.FALSE);
  }
  
  private void k(t paramt)
  {
    if ((paramt != null) && (paramt.b() != null)) {
      paramt.b().onError(new IoTTransportException(1001));
    }
  }
  
  private q<b.d.d0.i2.b> n(c2 paramc2)
  {
    return paramc2.l().E(new c()).p0(new b());
  }
  
  private boolean t(ALIoTDevice paramALIoTDevice)
  {
    TDPIoTDevice localTDPIoTDevice = paramALIoTDevice.getTDPIoTDevice();
    if (localTDPIoTDevice != null) {
      return localTDPIoTDevice.isSupportIoTCloud();
    }
    boolean bool;
    if (paramALIoTDevice.getThingDevice() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean u(EnumIoTTransportType paramEnumIoTTransportType, com.tplink.libtpnetwork.IoTNetwork.y.a parama, Throwable paramThrowable)
  {
    if ((paramEnumIoTTransportType == null) && ((parama instanceof com.tplink.libtpnetwork.IoTNetwork.transport.http.b)) && (!parama.d()))
    {
      paramEnumIoTTransportType = this.c;
      if (paramEnumIoTTransportType != null) {
        return paramEnumIoTTransportType.d();
      }
    }
    return false;
  }
  
  private void z(String paramString1, String paramString2, String paramString3, r<Boolean> paramr)
  {
    Object localObject1;
    Iterator localIterator;
    t localt;
    Object localObject3;
    if (b.d.s.b.a.b.containsKey(paramString3))
    {
      localObject1 = new ArrayList();
      int i = 1;
      synchronized (this.d)
      {
        localIterator = this.d.iterator();
        while (localIterator.hasNext())
        {
          localt = (t)localIterator.next();
          if (localt.c().equals(paramString3)) {
            ((List)localObject1).add(localt);
          }
          localObject2 = b.d.s.b.a.d;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((StringBuilder)localObject3).append(paramString3);
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(localt.c());
          if (((Map)localObject2).containsKey(((StringBuilder)localObject3).toString())) {
            i = 0;
          }
        }
        if (((List)localObject1).size() > 0)
        {
          this.d.removeAll((Collection)localObject1);
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext()) {
            k((t)((Iterator)localObject3).next());
          }
        }
        localObject3 = new com/tplink/libtpnetwork/IoTNetwork/t;
        ((t)localObject3).<init>(paramString3, paramString2, paramr, paramString1);
        if (i != 0)
        {
          this.d.add(localObject3);
          paramr.onNext(Boolean.TRUE);
        }
        else
        {
          k((t)localObject3);
        }
      }
    }
    Object localObject2 = new ArrayList();
    synchronized (this.d)
    {
      localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localt = (t)localIterator.next();
        localObject1 = b.d.s.b.a.d;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append(localt.c());
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramString3);
        if (((Map)localObject1).containsKey(((StringBuilder)localObject3).toString())) {
          ((List)localObject2).add(localt);
        } else if ((b.d.s.b.a.c.containsKey(paramString3)) && (localt.c().equals(paramString3)) && (((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(localt.d()))) || ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(localt.d()))))) {
          ((List)localObject2).add(localt);
        }
      }
      if (((List)localObject2).size() > 0)
      {
        this.d.removeAll((Collection)localObject2);
        localObject3 = ((List)localObject2).iterator();
        while (((Iterator)localObject3).hasNext()) {
          k((t)((Iterator)localObject3).next());
        }
      }
      localObject3 = new com/tplink/libtpnetwork/IoTNetwork/t;
      ((t)localObject3).<init>(paramString3, paramString2, paramr, paramString1);
      this.d.add(localObject3);
      paramr.onNext(Boolean.TRUE);
      return;
    }
  }
  
  public void E(@NonNull ThingContext paramThingContext)
  {
    ALIoTDevice localALIoTDevice = (ALIoTDevice)paramThingContext.getIoTDevice();
    paramThingContext = paramThingContext.getAccountContext();
    if (localALIoTDevice != null)
    {
      TDPIoTDevice localTDPIoTDevice = localALIoTDevice.getTDPIoTDevice();
      Object localObject = b.d.w.h.a.g(paramThingContext.c().getCloudUserName());
      if ((localTDPIoTDevice != null) && (!localTDPIoTDevice.isFactoryDefault()) && (((String)localObject).equalsIgnoreCase(localTDPIoTDevice.getOwner()))) {
        q(z.a(paramThingContext.c(), localTDPIoTDevice));
      } else {
        o(EnumIoTTransportType.HTTP);
      }
      localObject = localALIoTDevice.getCloudIoTDevice();
      if ((localObject != null) && (!t(localALIoTDevice))) {
        q(new com.tplink.libtpnetwork.IoTNetwork.y.d.b(((TCDeviceBean)localObject).getAppServerUrl(), ((TCDeviceBean)localObject).getDeviceId(), paramThingContext));
      } else {
        o(EnumIoTTransportType.PASS_THROUGH);
      }
    }
  }
  
  public void a(b.d.d0.i2.b paramb)
  {
    m();
  }
  
  public void l()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((com.tplink.libtpnetwork.IoTNetwork.y.c.a)localObject).e();
    }
    localObject = this.c;
    if (localObject != null) {
      ((com.tplink.libtpnetwork.IoTNetwork.y.d.a)localObject).e();
    }
    localObject = this.b;
    if (localObject != null) {
      ((com.tplink.libtpnetwork.IoTNetwork.transport.http.b)localObject).e();
    }
  }
  
  public void m()
  {
    com.tplink.libtpnetwork.IoTNetwork.y.c.a locala = this.a;
    if (locala != null)
    {
      locala.o();
      this.a = null;
    }
    D();
  }
  
  public void o(EnumIoTTransportType paramEnumIoTTransportType)
  {
    if (paramEnumIoTTransportType == null) {
      return;
    }
    int i = d.a[paramEnumIoTTransportType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          paramEnumIoTTransportType = this.a;
          if (paramEnumIoTTransportType != null) {
            paramEnumIoTTransportType.g(false);
          }
        }
      }
      else
      {
        paramEnumIoTTransportType = this.c;
        if (paramEnumIoTTransportType != null) {
          paramEnumIoTTransportType.g(false);
        }
      }
    }
    else
    {
      paramEnumIoTTransportType = this.b;
      if (paramEnumIoTTransportType != null) {
        paramEnumIoTTransportType.g(false);
      }
    }
    D();
  }
  
  public void p(EnumIoTTransportType paramEnumIoTTransportType, boolean paramBoolean)
  {
    int i = d.a[paramEnumIoTTransportType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          paramEnumIoTTransportType = this.a;
          if (paramEnumIoTTransportType != null) {
            paramEnumIoTTransportType.g(paramBoolean);
          }
        }
      }
      else
      {
        paramEnumIoTTransportType = this.c;
        if (paramEnumIoTTransportType != null) {
          paramEnumIoTTransportType.g(paramBoolean);
        }
      }
    }
    else
    {
      paramEnumIoTTransportType = this.b;
      if (paramEnumIoTTransportType != null) {
        paramEnumIoTTransportType.g(paramBoolean);
      }
    }
  }
  
  public void q(com.tplink.libtpnetwork.IoTNetwork.y.b paramb)
  {
    if (paramb == null) {
      return;
    }
    Object localObject;
    if ((paramb instanceof com.tplink.libtpnetwork.IoTNetwork.transport.http.c))
    {
      localObject = this.b;
      if (localObject == null) {
        this.b = new com.tplink.libtpnetwork.IoTNetwork.transport.http.b((com.tplink.libtpnetwork.IoTNetwork.transport.http.c)paramb);
      } else {
        ((com.tplink.libtpnetwork.IoTNetwork.transport.http.b)localObject).R((com.tplink.libtpnetwork.IoTNetwork.transport.http.c)paramb);
      }
      this.b.g(true);
    }
    else if ((paramb instanceof com.tplink.libtpnetwork.IoTNetwork.y.d.b))
    {
      localObject = this.c;
      if (localObject == null) {
        this.c = new com.tplink.libtpnetwork.IoTNetwork.y.d.a((com.tplink.libtpnetwork.IoTNetwork.y.d.b)paramb);
      } else {
        ((com.tplink.libtpnetwork.IoTNetwork.y.d.a)localObject).p((com.tplink.libtpnetwork.IoTNetwork.y.d.b)paramb);
      }
      this.c.g(true);
    }
    else if ((paramb instanceof com.tplink.libtpnetwork.IoTNetwork.y.c.c))
    {
      localObject = this.a;
      if (localObject == null) {
        this.a = new com.tplink.libtpnetwork.IoTNetwork.y.c.a((com.tplink.libtpnetwork.IoTNetwork.y.c.c)paramb);
      } else {
        ((com.tplink.libtpnetwork.IoTNetwork.y.c.a)localObject).u((com.tplink.libtpnetwork.IoTNetwork.y.c.c)paramb);
      }
      this.a.g(true);
    }
    D();
  }
  
  public boolean r()
  {
    com.tplink.libtpnetwork.IoTNetwork.y.c.a locala = this.a;
    boolean bool;
    if ((locala != null) && (locala.p())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean s()
  {
    com.tplink.libtpnetwork.IoTNetwork.transport.http.b localb = this.b;
    boolean bool;
    if ((localb != null) && (localb.d())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public q<b.d.d0.i2.b> v(final b.d.d0.h2.a.c paramc)
  {
    return q.f0(Boolean.FALSE).N(new a(paramc));
  }
  
  public <R, T> q<IoTResult<R>> w(String paramString, T paramT, Class<R> paramClass, EnumIoTTransportType paramEnumIoTTransportType)
  {
    return y("", paramString, paramT, paramClass, paramEnumIoTTransportType, 30L);
  }
  
  public <R, T> q<IoTResult<R>> x(String paramString1, String paramString2, T paramT, Class<R> paramClass, long paramLong)
  {
    return y(paramString1, paramString2, paramT, paramClass, null, paramLong);
  }
  
  public <R, T> q<IoTResult<R>> y(final String paramString1, String paramString2, T paramT, Class<R> paramClass, final EnumIoTTransportType paramEnumIoTTransportType, long paramLong)
  {
    final TPIoTRequest localTPIoTRequest = new TPIoTRequest();
    localTPIoTRequest.setRequestID(r.b.a());
    localTPIoTRequest.setMethod(paramString2);
    localTPIoTRequest.setParams(paramT);
    localTPIoTRequest.setTerminalUUID(this.g);
    localTPIoTRequest.setRequestTimeMils(System.currentTimeMillis());
    return this.e.Q0(1L).N(new l(localTPIoTRequest, paramString1)).l0(io.reactivex.l0.a.c()).g0(new k(paramEnumIoTTransportType)).N(new j(localTPIoTRequest)).i(n.a(paramClass)).T0(paramLong, TimeUnit.SECONDS).o0(new i()).E(new h(localTPIoTRequest)).C(new g(localTPIoTRequest)).v0(1L, new f(paramEnumIoTTransportType)).A(new e(localTPIoTRequest)).L0(io.reactivex.l0.a.c());
  }
  
  class a
    implements j<Boolean, io.reactivex.t<b.d.d0.i2.b>>
  {
    a(b.d.d0.h2.a.c paramc) {}
    
    public io.reactivex.t<b.d.d0.i2.b> a(Boolean paramBoolean)
      throws Exception
    {
      paramBoolean = new c2(paramc);
      x.i(x.this).t(paramBoolean);
      return x.j(x.this, paramBoolean);
    }
  }
  
  class b
    implements j<Throwable, b.d.d0.i2.b>
  {
    b() {}
    
    public b.d.d0.i2.b a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof TPGeneralNetworkException))
      {
        paramThrowable = (TPGeneralNetworkException)paramThrowable;
        return new b.d.d0.i2.b(paramThrowable.getErrCode(), paramThrowable.getErrMsg());
      }
      return new b.d.d0.i2.b(-1, paramThrowable.toString());
    }
  }
  
  class c
    implements io.reactivex.g0.g<b.d.d0.i2.b>
  {
    c() {}
    
    public void a(b.d.d0.i2.b paramb)
      throws Exception
    {
      if (paramb.a() == 0) {
        x.i(x.this).s(x.this);
      }
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e(TPIoTRequest paramTPIoTRequest) {}
    
    public void run()
      throws Exception
    {
      x.b(x.this, String.valueOf(localTPIoTRequest.getRequestID()));
    }
  }
  
  class f
    implements l<Throwable>
  {
    f(EnumIoTTransportType paramEnumIoTTransportType) {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      x localx = x.this;
      return x.e(localx, paramEnumIoTTransportType, x.c(localx), paramThrowable);
    }
  }
  
  class g
    implements io.reactivex.g0.g<Throwable>
  {
    g(TPIoTRequest paramTPIoTRequest) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      x.f(x.this, String.valueOf(localTPIoTRequest.getRequestID()));
    }
  }
  
  class h
    implements io.reactivex.g0.g<IoTResult<R>>
  {
    h(TPIoTRequest paramTPIoTRequest) {}
    
    public void a(IoTResult<R> paramIoTResult)
      throws Exception
    {
      x.f(x.this, String.valueOf(localTPIoTRequest.getRequestID()));
    }
  }
  
  class i
    implements j<Throwable, io.reactivex.t<IoTResult<R>>>
  {
    i() {}
    
    public io.reactivex.t<IoTResult<R>> a(Throwable paramThrowable)
      throws Exception
    {
      if (((x.c(x.this) instanceof com.tplink.libtpnetwork.IoTNetwork.transport.http.b)) && ((paramThrowable instanceof TimeoutException)))
      {
        ((com.tplink.libtpnetwork.IoTNetwork.transport.http.b)x.c(x.this)).B(paramThrowable);
        return q.J(new IoTTransportException(1112));
      }
      return q.J(paramThrowable);
    }
  }
  
  class j
    implements j<com.tplink.libtpnetwork.IoTNetwork.y.a, io.reactivex.t<TPIoTResponse>>
  {
    j(TPIoTRequest paramTPIoTRequest) {}
    
    public io.reactivex.t<TPIoTResponse> a(com.tplink.libtpnetwork.IoTNetwork.y.a parama)
      throws Exception
    {
      return parama.f(localTPIoTRequest);
    }
  }
  
  class k
    implements j<Boolean, com.tplink.libtpnetwork.IoTNetwork.y.a>
  {
    k(EnumIoTTransportType paramEnumIoTTransportType) {}
    
    public com.tplink.libtpnetwork.IoTNetwork.y.a a(Boolean paramBoolean)
      throws Exception
    {
      paramBoolean = x.g(x.this, paramEnumIoTTransportType);
      if (paramBoolean != null)
      {
        x.d(x.this, paramBoolean);
        return paramBoolean;
      }
      throw new IoTTransportException(1000);
    }
  }
  
  class l
    implements j<Boolean, io.reactivex.t<Boolean>>
  {
    l(TPIoTRequest paramTPIoTRequest, String paramString) {}
    
    public io.reactivex.t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return q.m(new a());
      }
      throw new TPGeneralNetworkException(64528);
    }
    
    class a
      implements s<Boolean>
    {
      a() {}
      
      public void subscribe(r<Boolean> paramr)
        throws Exception
      {
        x.l locall = x.l.this;
        x localx = locall.f;
        long l = locall.c.getRequestID();
        locall = x.l.this;
        x.h(localx, String.valueOf(l), locall.d, locall.c.getMethod(), paramr);
      }
    }
  }
  
  class m
    implements io.reactivex.g0.a
  {
    m(String paramString) {}
    
    public void run()
      throws Exception
    {
      x.f(x.this, paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */