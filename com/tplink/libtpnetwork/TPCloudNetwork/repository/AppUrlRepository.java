package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import b.d.b.c.j;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.webservice.params.AppServiceUrlParams;
import com.tplink.iot.c.b.d;
import com.tplink.libtpnetwork.Utils.a0;
import io.reactivex.q;
import java.util.Collections;

public class AppUrlRepository
  extends b.d.b.f.a
{
  private static final String c = ;
  private j d;
  private d e;
  private String f;
  
  public AppUrlRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.d = paramb.d();
  }
  
  private q<Boolean> e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.e.A0(paramString, "app").N(new c(this)).L0(io.reactivex.l0.a.c());
    }
    return q.f0(Boolean.FALSE);
  }
  
  public q<Boolean> d()
  {
    AppServiceUrlParams localAppServiceUrlParams = new AppServiceUrlParams();
    localAppServiceUrlParams.setServiceIds(Collections.singletonList(c));
    return this.d.l0(new CloudParams("getAppServiceUrl", localAppServiceUrlParams)).N(new b(this, localAppServiceUrlParams)).L0(io.reactivex.l0.a.c());
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void k(d paramd)
  {
    this.e = paramd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\AppUrlRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */