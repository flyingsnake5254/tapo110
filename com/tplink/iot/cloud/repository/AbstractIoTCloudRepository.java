package com.tplink.iot.cloud.repository;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import b.d.b.c.j;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.webservice.params.AppServiceUrlParams;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import io.reactivex.q;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractIoTCloudRepository
  extends b.d.b.f.a
{
  private static final AtomicBoolean c = new AtomicBoolean(false);
  private static final io.reactivex.m0.g<String> d = io.reactivex.m0.d.n1();
  protected com.tplink.iot.c.c.a e;
  protected IoTWebServiceIdParams f;
  protected j g;
  
  public AbstractIoTCloudRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.e = parama;
    this.f = parama.l();
    this.g = ((j)parama.d().R1(j.class));
  }
  
  @SuppressLint({"CheckResult"})
  private void e()
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(e.c).N(new i(this)).l0(io.reactivex.l0.a.d()).H0(g.c, b.c);
  }
  
  private q<String> f()
  {
    return q.X(new c(this)).N(new h(this)).L0(io.reactivex.l0.a.c());
  }
  
  private q<String> u()
  {
    return d.Q0(1L).F(new d(this)).l0(io.reactivex.l0.a.c()).N(a.c);
  }
  
  private q<String> v()
  {
    return this.g.l0(new CloudParams("getAppServiceUrl", new AppServiceUrlParams(Collections.singletonList(this.f.getIotAppServerId())))).g0(new f(this)).L0(io.reactivex.l0.a.c());
  }
  
  protected q<String> d()
  {
    if (!TextUtils.isEmpty(this.e.i())) {
      return q.f0(this.e.i());
    }
    return u();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\repository\AbstractIoTCloudRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */