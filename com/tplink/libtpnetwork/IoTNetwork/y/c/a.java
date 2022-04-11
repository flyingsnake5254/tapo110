package com.tplink.libtpnetwork.IoTNetwork.y.c;

import android.annotation.SuppressLint;
import b.d.d0.c2;
import b.d.d0.d2;
import b.d.d0.f2.d;
import b.d.d0.f2.e;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.tmp.enumerate.EnumTMPClientStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
  extends com.tplink.libtpnetwork.IoTNetwork.y.a
  implements d2
{
  private static final Map<Long, r<TPIoTResponse>> b = new ConcurrentHashMap();
  private c c;
  private c2 d;
  private b e;
  private final List<TPIoTRequest> f = Collections.synchronizedList(new ArrayList());
  private volatile boolean g;
  private ExecutorService h = Executors.newSingleThreadExecutor();
  
  public a(c paramc)
  {
    this.c = paramc;
  }
  
  @SuppressLint({"CheckResult"})
  private void m()
  {
    io.reactivex.a.e().C(io.reactivex.l0.a.b(this.h)).z(new e());
  }
  
  private void n()
  {
    synchronized (this.f)
    {
      if (this.f.isEmpty()) {
        return;
      }
      TPIoTRequest localTPIoTRequest = (TPIoTRequest)this.f.remove(0);
      if (localTPIoTRequest == null) {
        return;
      }
      r(localTPIoTRequest);
      return;
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void q(TPIoTRequest paramTPIoTRequest)
  {
    if ((this.d != null) && (d()))
    {
      this.f.add(paramTPIoTRequest);
      if (this.g) {
        return;
      }
      n();
      return;
    }
    r localr = (r)b.remove(Long.valueOf(paramTPIoTRequest.getRequestID()));
    if (localr != null)
    {
      paramTPIoTRequest = new TPIoTResponse();
      paramTPIoTRequest.setErrorCode(1);
      localr.onNext(paramTPIoTRequest);
      localr.onComplete();
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void r(final TPIoTRequest paramTPIoTRequest)
  {
    if (this.d == null)
    {
      this.g = false;
      return;
    }
    this.g = true;
    String str = i.g(paramTPIoTRequest, TPIoTRequest.class);
    this.d.V(new d((short)0, str.getBytes())).g0(new d()).H0(new b(paramTPIoTRequest), new c(paramTPIoTRequest));
  }
  
  public void a(b.d.d0.i2.b paramb, c2 paramc2)
  {
    paramc2 = this.e;
    if (paramc2 != null) {
      paramc2.a(paramb);
    }
    paramc2 = b.values().iterator();
    while (paramc2.hasNext()) {
      ((r)paramc2.next()).onError(new TPGeneralNetworkException(paramb.a(), paramb.b()));
    }
    b.clear();
    o();
  }
  
  public void b(c2 paramc2) {}
  
  public void c(c2 paramc2) {}
  
  public void e()
  {
    super.e();
    this.c = null;
    o();
  }
  
  public <P> q<TPIoTResponse> f(final TPIoTRequest<P> paramTPIoTRequest)
  {
    return q.m(new a(paramTPIoTRequest)).L0(io.reactivex.l0.a.b(this.h));
  }
  
  public void o()
  {
    c2 localc2 = this.d;
    if (localc2 != null)
    {
      localc2.k();
      this.d = null;
    }
  }
  
  public boolean p()
  {
    c2 localc2 = this.d;
    boolean bool;
    if ((localc2 != null) && (localc2.n() == EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTED)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void s(b paramb)
  {
    this.e = paramb;
  }
  
  public void t(c2 paramc2)
  {
    this.d = paramc2;
    if (paramc2 != null) {
      paramc2.X(this);
    }
  }
  
  public void u(c paramc)
  {
    this.c = paramc;
  }
  
  class a
    implements s<TPIoTResponse>
  {
    a(TPIoTRequest paramTPIoTRequest) {}
    
    public void subscribe(r<TPIoTResponse> paramr)
      throws Exception
    {
      a.h().put(Long.valueOf(paramTPIoTRequest.getRequestID()), paramr);
      a.i(a.this, paramTPIoTRequest);
    }
  }
  
  class b
    implements io.reactivex.g0.g<TPIoTResponse>
  {
    b(TPIoTRequest paramTPIoTRequest) {}
    
    public void a(TPIoTResponse paramTPIoTResponse)
      throws Exception
    {
      r localr = (r)a.h().remove(Long.valueOf(paramTPIoTRequest.getRequestID()));
      if (localr != null)
      {
        localr.onNext(paramTPIoTResponse);
        localr.onComplete();
      }
      a.j(a.this);
    }
  }
  
  class c
    implements io.reactivex.g0.g<Throwable>
  {
    c(TPIoTRequest paramTPIoTRequest) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      r localr = (r)a.h().remove(Long.valueOf(paramTPIoTRequest.getRequestID()));
      if (localr != null) {
        localr.onError(paramThrowable);
      }
      a.j(a.this);
    }
  }
  
  class d
    implements j<e, TPIoTResponse>
  {
    d() {}
    
    public TPIoTResponse a(e parame)
      throws Exception
    {
      TPIoTResponse localTPIoTResponse = new TPIoTResponse();
      localTPIoTResponse.setErrorCode(parame.a());
      localTPIoTResponse.setErrorMsg(parame.b());
      if (parame.c() != null) {
        localTPIoTResponse.setResult(new String(parame.c()));
      }
      return localTPIoTResponse;
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      a.k(a.this, false);
      a.l(a.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\y\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */