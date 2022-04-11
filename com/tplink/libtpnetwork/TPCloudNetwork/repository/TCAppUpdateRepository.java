package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.update.result.AppVersionResult;
import com.tplink.cloud.bean.webservice.params.ServiceStatusInfoParams;
import io.reactivex.q;
import java.util.Comparator;

public class TCAppUpdateRepository
  extends b.d.b.f.a
{
  private static final Comparator<AppVersionResult> c = new a();
  private b.d.b.c.b d;
  private b.d.b.c.j e;
  private MutableLiveData<AppVersionResult> f = new MutableLiveData();
  
  public TCAppUpdateRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.d = paramb.d();
    this.e = paramb.d();
  }
  
  public io.reactivex.a d(ServiceStatusInfoParams paramServiceStatusInfoParams)
  {
    return this.e.X(new CloudParams("uploadServiceStatusInfo", paramServiceStatusInfoParams)).L0(io.reactivex.l0.a.c()).g0(new b()).Z();
  }
  
  static final class a
    implements Comparator<AppVersionResult>
  {
    public int a(AppVersionResult paramAppVersionResult1, AppVersionResult paramAppVersionResult2)
    {
      return paramAppVersionResult2.getVersionCode() - paramAppVersionResult1.getVersionCode();
    }
  }
  
  class b
    implements io.reactivex.g0.j<CloudResult<Void>, Boolean>
  {
    b() {}
    
    public Boolean a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      boolean bool;
      if ((paramCloudResult != null) && (paramCloudResult.getErrorCode() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\TCAppUpdateRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */