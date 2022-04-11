package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoUploadParams;
import com.tplink.cloud.bean.webservice.params.AppServiceUrlParams;
import com.tplink.cloud.bean.webservice.params.DataCollectRequestParams;
import com.tplink.cloud.bean.webservice.params.ServiceStatusInfoParams;
import com.tplink.cloud.bean.webservice.params.WebServiceInfoParams;
import com.tplink.cloud.bean.webservice.result.AccountAvatarResult;
import com.tplink.cloud.bean.webservice.result.AppServiceUrlResult;
import com.tplink.cloud.bean.webservice.result.DeviceAvatarResult;
import com.tplink.cloud.bean.webservice.result.WebServiceInfoResult;
import okhttp3.MultipartBody.Part;
import retrofit2.x.a;
import retrofit2.x.i;
import retrofit2.x.k;
import retrofit2.x.l;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;
import retrofit2.x.y;

public abstract interface j
{
  @l
  @o
  public abstract io.reactivex.q<CloudResult<DeviceAvatarResult>> I1(@y String paramString1, @t("deviceId") String paramString2, @retrofit2.x.q MultipartBody.Part paramPart);
  
  @o("/")
  public abstract io.reactivex.q<CloudResult<WebServiceInfoResult>> S0(@a CloudParams<WebServiceInfoParams> paramCloudParams);
  
  @o("/")
  public abstract io.reactivex.q<CloudResult<Void>> X(@a CloudParams<ServiceStatusInfoParams> paramCloudParams);
  
  @l
  @o
  public abstract io.reactivex.q<CloudResult<AccountAvatarResult>> Y(@y String paramString, @retrofit2.x.q MultipartBody.Part paramPart);
  
  @k({"Content-Encoding:gzip"})
  @o("{url}/api/data/app/uploadBasicData")
  public abstract io.reactivex.q<CloudResult> d1(@s(encoded=true, value="url") String paramString1, @i("X-Authorization") String paramString2, @a DataCollectRequestParams paramDataCollectRequestParams);
  
  @o
  public abstract io.reactivex.q<CloudResult<Void>> i1(@y String paramString, @a DeviceConfigInfoUploadParams paramDeviceConfigInfoUploadParams);
  
  @o("/")
  public abstract io.reactivex.q<CloudResult<AppServiceUrlResult>> l0(@a CloudParams<AppServiceUrlParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */