package com.tplink.libtpnetwork.IoTNetwork.y.d;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.passthrough.params.PassThroughParams;
import com.tplink.cloud.bean.passthrough.result.PassThroughResult;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.m0.d;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends com.tplink.libtpnetwork.IoTNetwork.y.a
{
  private com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest.a b = new com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest.a();
  private b c;
  private io.reactivex.m0.g<TPIoTRequest> d = d.n1().l1();
  private c e;
  
  public a(b paramb)
  {
    this.c = paramb;
    m();
  }
  
  private void m()
  {
    this.e = this.d.l0(io.reactivex.l0.a.c()).L(new e()).g0(new d()).N(new c()).G0(new b());
  }
  
  private void n(CloudResult<PassThroughResult> paramCloudResult)
  {
    if (paramCloudResult == null)
    {
      this.b.m(new IoTTransportException(1200));
      return;
    }
    if (paramCloudResult.getErrorCode() != 0)
    {
      this.b.m(new IoTTransportException(paramCloudResult.getErrorCode()));
      return;
    }
    if (paramCloudResult.getResult() == null)
    {
      this.b.m(new IoTTransportException(1200));
      return;
    }
    if (((PassThroughResult)paramCloudResult.getResult()).getResponseData() == null)
    {
      this.b.m(new IoTTransportException(1200));
      return;
    }
    TPIoTResponse localTPIoTResponse = new TPIoTResponse();
    localTPIoTResponse.setResult(((PassThroughResult)paramCloudResult.getResult()).getResponseData().toString());
    this.b.n(localTPIoTResponse);
  }
  
  private void o(CloudResult<PassThroughResult> paramCloudResult)
  {
    if (paramCloudResult == null)
    {
      this.b.m(new IoTTransportException(1200));
      return;
    }
    if (paramCloudResult.getErrorCode() != 0)
    {
      this.b.m(new IoTTransportException(paramCloudResult.getErrorCode()));
      return;
    }
    if (paramCloudResult.getResult() == null)
    {
      this.b.m(new IoTTransportException(1200));
      return;
    }
    paramCloudResult = ((PassThroughResult)paramCloudResult.getResult()).getResponseData();
    if (paramCloudResult == null)
    {
      this.b.m(new IoTTransportException(1200));
      return;
    }
    if (paramCloudResult.c().n("error_code").a() != 0)
    {
      this.b.m(new IoTTransportException(1200));
      return;
    }
    Iterator localIterator = paramCloudResult.c().n("result").c().n("responses").b().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      TPIoTResponse localTPIoTResponse = new TPIoTResponse();
      int i;
      if (locali.c().n("error_code") == null) {
        i = -1;
      } else {
        i = locali.c().n("error_code").a();
      }
      localTPIoTResponse.setErrorCode(i);
      if (locali.c().n("msg") == null) {
        paramCloudResult = "";
      } else {
        paramCloudResult = locali.c().n("msg").e();
      }
      localTPIoTResponse.setErrorMsg(paramCloudResult);
      localTPIoTResponse.setResult(locali.c().toString());
      this.b.n(localTPIoTResponse);
    }
  }
  
  public void e()
  {
    c localc = this.e;
    if (localc != null)
    {
      localc.dispose();
      this.e = null;
    }
    super.e();
  }
  
  public <T> q<TPIoTResponse> f(final TPIoTRequest<T> paramTPIoTRequest)
  {
    return q.f0(Boolean.valueOf(d())).N(new a(paramTPIoTRequest));
  }
  
  public void p(b paramb)
  {
    this.c = paramb;
  }
  
  class a
    implements j<Boolean, t<TPIoTResponse>>
  {
    a(TPIoTRequest paramTPIoTRequest) {}
    
    public t<TPIoTResponse> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return q.m(new a());
      }
      return q.J(new IoTTransportException(1002));
    }
    
    class a
      implements s<TPIoTResponse>
    {
      a() {}
      
      public void subscribe(r<TPIoTResponse> paramr)
        throws Exception
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramr);
        a.h(a.this).b(a.a.this.c, localArrayList);
        a.h(a.this).a(a.a.this.c);
        a.i(a.this).onNext(a.a.this.c);
      }
    }
  }
  
  class b
    implements io.reactivex.g0.g<CloudResult<PassThroughResult>>
  {
    b() {}
    
    public void a(CloudResult<PassThroughResult> paramCloudResult)
      throws Exception
    {
      if (a.h(a.this).l()) {
        a.j(a.this, paramCloudResult);
      } else {
        a.k(a.this, paramCloudResult);
      }
    }
  }
  
  class c
    implements j<CloudParams<PassThroughParams>, t<CloudResult<PassThroughResult>>>
  {
    c() {}
    
    public t<CloudResult<PassThroughResult>> a(CloudParams<PassThroughParams> paramCloudParams)
      throws Exception
    {
      return a.l(a.this).a().d().k0(a.l(a.this).c(), paramCloudParams).o0(new a());
    }
    
    class a
      implements j<Throwable, t<CloudResult<PassThroughResult>>>
    {
      a() {}
      
      public t<CloudResult<PassThroughResult>> a(Throwable paramThrowable)
        throws Exception
      {
        a.h(a.this).m(paramThrowable);
        return q.f0(new CloudResult());
      }
    }
  }
  
  class d
    implements j<TPIoTRequest, CloudParams<PassThroughParams>>
  {
    d() {}
    
    public CloudParams<PassThroughParams> a(TPIoTRequest paramTPIoTRequest)
      throws Exception
    {
      paramTPIoTRequest = a.h(a.this).h();
      return new CloudParams("passthrough", new PassThroughParams(a.l(a.this).b(), paramTPIoTRequest));
    }
  }
  
  class e
    implements l<TPIoTRequest>
  {
    e() {}
    
    public boolean a(TPIoTRequest paramTPIoTRequest)
      throws Exception
    {
      return a.h(a.this).i() ^ true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\y\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */