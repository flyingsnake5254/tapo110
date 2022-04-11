package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import b.d.b.c.h;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.protocol.params.HelloCloudParams;
import com.tplink.cloud.bean.protocol.result.HelloCloudResult;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;

public class TCProtocolRepository
  extends b.d.b.f.a
{
  private h c;
  private final HelloCloudParams d;
  private io.reactivex.m0.b<Boolean> e = io.reactivex.m0.b.n1();
  
  public TCProtocolRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.c = paramb.d();
    com.tplink.cloud.context.a locala = paramb.e();
    paramb = new HelloCloudParams();
    this.d = paramb;
    paramb.setTcspVer("1.1");
    paramb.setAppType(locala.b());
    paramb.setAppPackageName(locala.c());
    paramb.setTerminalUUID(locala.q());
  }
  
  public q<Boolean> e()
  {
    return this.c.v(new CloudParams("helloCloud", this.d)).g0(new b()).q0(Boolean.FALSE).E(new a());
  }
  
  public boolean f()
  {
    h localh = this.c;
    boolean bool;
    if (((localh instanceof b.d.b.b)) && (!((b.d.b.b)localh).S1())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  class a
    implements g<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      TCProtocolRepository.d(TCProtocolRepository.this).onNext(paramBoolean);
    }
  }
  
  class b
    implements j<CloudResult<HelloCloudResult>, Boolean>
  {
    b() {}
    
    public Boolean a(CloudResult<HelloCloudResult> paramCloudResult)
      throws Exception
    {
      boolean bool;
      if (((HelloCloudResult)paramCloudResult.getResult()).getTcspStatus() != 2) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\TCProtocolRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */