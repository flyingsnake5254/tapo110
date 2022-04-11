package b.d.b;

import androidx.annotation.NonNull;
import b.d.b.c.c;
import b.d.b.c.d;
import b.d.b.c.e;
import b.d.b.c.f;
import b.d.b.c.g;
import b.d.b.c.h;
import b.d.b.c.i;
import b.d.b.c.j;
import b.d.b.e.j.b;
import b.d.b.e.o;
import com.tplink.cloud.bean.account.params.CheckPasswordParams;
import com.tplink.cloud.bean.account.params.CloudUserEmailParams;
import com.tplink.cloud.bean.account.params.CloudUserParams;
import com.tplink.cloud.bean.account.params.LoginParams;
import com.tplink.cloud.bean.account.params.ModifyCloudPasswordParams;
import com.tplink.cloud.bean.account.params.RegisterParams;
import com.tplink.cloud.bean.account.params.TopicSubscriptionParams;
import com.tplink.cloud.bean.account.params.UpdateAccountInfoParams;
import com.tplink.cloud.bean.account.params.UpdateTopicSubscriptionParams;
import com.tplink.cloud.bean.account.result.AccountStatusResult;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.cloud.bean.account.result.CloudUserResult;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.bean.account.result.TopicSubscriptionResult;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.device.params.DeviceAliasParams;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoParams;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoUploadParams;
import com.tplink.cloud.bean.device.params.DeviceFeatureParams;
import com.tplink.cloud.bean.device.params.DeviceInfoParams;
import com.tplink.cloud.bean.device.params.DeviceListPageParams;
import com.tplink.cloud.bean.device.params.DeviceUnbindParams;
import com.tplink.cloud.bean.device.params.DeviceUserNumberLimitParams;
import com.tplink.cloud.bean.device.result.DeviceConfigInfoListResult;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.cloud.bean.device.result.DeviceListPageResult;
import com.tplink.cloud.bean.device.result.DeviceUnbindFeatureResult;
import com.tplink.cloud.bean.device.result.DeviceUserNumberLimitListResult;
import com.tplink.cloud.bean.firmware.params.FirmwareInfoParams;
import com.tplink.cloud.bean.firmware.result.FirmwareListResult;
import com.tplink.cloud.bean.passthrough.params.PassThroughParams;
import com.tplink.cloud.bean.passthrough.result.PassThroughResult;
import com.tplink.cloud.bean.protocol.params.HelloCloudParams;
import com.tplink.cloud.bean.protocol.result.HelloCloudResult;
import com.tplink.cloud.bean.share.params.ShareBlacklistParams;
import com.tplink.cloud.bean.share.params.ShareBlacklistUpdateParams;
import com.tplink.cloud.bean.share.result.ShareBlacklistResult;
import com.tplink.cloud.bean.share.result.ShareBlacklistUpdateResult;
import com.tplink.cloud.bean.webservice.params.AppServiceUrlParams;
import com.tplink.cloud.bean.webservice.params.DataCollectRequestParams;
import com.tplink.cloud.bean.webservice.params.ServiceStatusInfoParams;
import com.tplink.cloud.bean.webservice.params.WebServiceInfoParams;
import com.tplink.cloud.bean.webservice.result.AccountAvatarResult;
import com.tplink.cloud.bean.webservice.result.AppServiceUrlResult;
import com.tplink.cloud.bean.webservice.result.DeviceAvatarResult;
import com.tplink.cloud.bean.webservice.result.WebServiceInfoResult;
import com.tplink.cloud.define.CloudException;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.MultipartBody.Part;
import retrofit2.r;

public class b
  extends b.d.b.d.a.b
  implements j.b, h, b.d.b.c.a, c, d, b.d.b.c.b, j, g, i, f
{
  @Deprecated
  private final b.d.b.c.a d;
  @Deprecated
  private final b.d.b.c.b e;
  @Deprecated
  private final c f;
  @Deprecated
  private final d g;
  @Deprecated
  private final e h;
  @Deprecated
  private final h i;
  @Deprecated
  private final j j;
  @Deprecated
  private final g k;
  @Deprecated
  private final i l;
  @Deprecated
  private final f m;
  private final com.tplink.cloud.define.a n;
  private volatile boolean o = false;
  private final AtomicBoolean p = new AtomicBoolean(false);
  
  public b(@NonNull com.tplink.cloud.define.a parama)
  {
    super(parama.j(), new o(parama));
    ((o)this.c).f(this);
    this.n = parama;
    this.d = ((b.d.b.c.a)R1(b.d.b.c.a.class));
    this.e = ((b.d.b.c.b)R1(b.d.b.c.b.class));
    this.f = ((c)R1(c.class));
    this.g = ((d)R1(d.class));
    this.h = ((e)R1(e.class));
    this.i = ((h)R1(h.class));
    this.j = ((j)R1(j.class));
    this.k = ((g)R1(g.class));
    this.l = ((i)R1(i.class));
    this.m = ((f)R1(f.class));
  }
  
  @Deprecated
  public q<CloudResult<TopicSubscriptionResult>> C1(CloudParams<TopicSubscriptionParams> paramCloudParams)
  {
    return this.d.C1(paramCloudParams);
  }
  
  public void D0()
  {
    if (!this.o) {
      this.o = true;
    }
  }
  
  @Deprecated
  public q<CloudResult<DeviceAvatarResult>> I1(String paramString1, String paramString2, MultipartBody.Part paramPart)
  {
    return this.j.I1(paramString1, paramString2, paramPart);
  }
  
  @Deprecated
  public q<CloudResult<CheckPasswordV1Result>> J1(CloudParams<CheckPasswordParams> paramCloudParams)
  {
    return this.d.J1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<LoginV1Result>> L1(CloudParams<LoginParams> paramCloudParams)
  {
    return this.d.L1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<DeviceConfigInfoListResult>> M(CloudParams<DeviceConfigInfoParams> paramCloudParams)
  {
    return this.f.M(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> N0(CloudParams<UpdateAccountInfoParams> paramCloudParams)
  {
    return this.d.N0(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<FirmwareListResult>> O0(CloudParams<FirmwareInfoParams> paramCloudParams)
  {
    return this.g.O0(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<ShareBlacklistUpdateResult>> Q0(CloudParams<ShareBlacklistUpdateParams> paramCloudParams)
  {
    return this.l.Q0(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<WebServiceInfoResult>> S0(CloudParams<WebServiceInfoParams> paramCloudParams)
  {
    return this.j.S0(paramCloudParams);
  }
  
  public boolean S1()
  {
    return this.o;
  }
  
  @Deprecated
  public q<CloudResult<Void>> T(CloudParams<CloudUserEmailParams> paramCloudParams)
  {
    return this.d.T(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> U0(CloudParams<CloudUserEmailParams> paramCloudParams)
  {
    return this.d.U0(paramCloudParams);
  }
  
  public void V1(String paramString)
  {
    this.n.E(paramString);
  }
  
  public q<CloudResult<Void>> X(CloudParams<ServiceStatusInfoParams> paramCloudParams)
  {
    return this.j.X(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<AccountAvatarResult>> Y(String paramString, MultipartBody.Part paramPart)
  {
    return this.j.Y(paramString, paramPart);
  }
  
  @Deprecated
  public q<CloudResult<Void>> Y0(String paramString, CloudParams<DeviceUnbindParams> paramCloudParams)
  {
    return this.f.Y0(paramString, paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<DeviceUnbindFeatureResult>> a0(CloudParams<DeviceFeatureParams> paramCloudParams)
  {
    return this.f.a0(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<DeviceListPageResult>> b1(CloudParams<DeviceListPageParams> paramCloudParams)
  {
    return this.f.b1(paramCloudParams);
  }
  
  public r c()
  {
    return super.c();
  }
  
  @Deprecated
  public q<CloudResult> d1(String paramString1, String paramString2, DataCollectRequestParams paramDataCollectRequestParams)
  {
    return this.j.d1(paramString1, paramString2, paramDataCollectRequestParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> e1(CloudParams<CloudUserParams> paramCloudParams)
  {
    return this.d.e1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> f(CloudParams<CloudUserParams> paramCloudParams)
  {
    return this.d.f(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> f0(CloudParams<UpdateTopicSubscriptionParams> paramCloudParams)
  {
    return this.d.f0(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> i1(String paramString, DeviceConfigInfoUploadParams paramDeviceConfigInfoUploadParams)
  {
    return this.j.i1(paramString, paramDeviceConfigInfoUploadParams);
  }
  
  @Deprecated
  public q<CloudResult<DeviceInfoResult>> j1(CloudParams<DeviceInfoParams> paramCloudParams)
  {
    return this.f.j1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<PassThroughResult>> k0(String paramString, CloudParams<PassThroughParams> paramCloudParams)
  {
    return this.k.k0(paramString, paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<AppServiceUrlResult>> l0(CloudParams<AppServiceUrlParams> paramCloudParams)
  {
    return this.j.l0(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> o1(CloudParams<RegisterParams> paramCloudParams)
  {
    return this.d.o1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<CloudUserResult>> p(CloudParams<CloudUserParams> paramCloudParams)
  {
    return this.d.p(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<DeviceInfoResult>> p1(String paramString, CloudParams<DeviceInfoParams> paramCloudParams)
  {
    return this.f.p1(paramString, paramCloudParams);
  }
  
  public void r(Throwable paramThrowable)
  {
    boolean bool = CloudException.isCloudStatusException(paramThrowable);
    if ((this.p.getAndSet(bool)) && (bool)) {
      this.o = false;
    } else if ((!this.o) && (!bool)) {
      this.o = true;
    }
  }
  
  @Deprecated
  public q<CloudResult<ShareBlacklistUpdateResult>> s(CloudParams<ShareBlacklistUpdateParams> paramCloudParams)
  {
    return this.l.s(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> s1(CloudParams<ModifyCloudPasswordParams> paramCloudParams)
  {
    return this.d.s1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<ShareBlacklistResult>> t1(CloudParams<ShareBlacklistParams> paramCloudParams)
  {
    return this.l.t1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<HelloCloudResult>> v(CloudParams<HelloCloudParams> paramCloudParams)
  {
    return this.i.v(paramCloudParams).E(new a(this));
  }
  
  @Deprecated
  public q<CloudResult<AccountStatusResult>> x1(CloudParams<CloudUserParams> paramCloudParams)
  {
    return this.d.x1(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<DeviceUserNumberLimitListResult>> y(CloudParams<DeviceUserNumberLimitParams> paramCloudParams)
  {
    return this.f.y(paramCloudParams);
  }
  
  @Deprecated
  public q<CloudResult<Void>> z0(String paramString, CloudParams<DeviceAliasParams> paramCloudParams)
  {
    return this.f.z0(paramString, paramCloudParams);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */