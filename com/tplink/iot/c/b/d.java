package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.params.DeviceTypeParams;
import com.tplink.iot.cloud.bean.cloudvideo.params.DeviceVideoParams;
import com.tplink.iot.cloud.bean.cloudvideo.params.UnbindDeviceParams;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoDevicesResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CountryCodeListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceIdListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceOrderListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceVideoDateResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DowngradeInfoResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.OrderPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.TapoCareUrlResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.h;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface d
{
  @f("{url}/v1/service/url/secondary")
  public abstract q<TapoCareUrlResult> A0(@s(encoded=true, value="url") String paramString1, @t("clientType") String paramString2);
  
  @h(hasBody=true, method="DELETE", path="{url}/v1/videos")
  public abstract io.reactivex.a F1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a DeviceVideoParams paramDeviceVideoParams);
  
  @f("{url}/v1/orders/app")
  public abstract q<OrderPageListResult<OrderInfo>> G0(@s(encoded=true, value="url") String paramString1, @t("accountId") String paramString2, @t("page") int paramInt1, @t("pageSize") int paramInt2);
  
  @f("{url}/v1/subscription/downgrade")
  public abstract q<DowngradeInfoResult> K0(@s(encoded=true, value="url") String paramString);
  
  @f("{url}/v1/videos/devices")
  public abstract q<CloudVideoDevicesResult> P(@s(encoded=true, value="url") String paramString, @t("page") int paramInt1, @t("pageSize") int paramInt2);
  
  @h(hasBody=true, method="DELETE", path="{url}/v1/device/packages")
  public abstract io.reactivex.a P1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a UnbindDeviceParams paramUnbindDeviceParams);
  
  @f("{url}/v1/device/packages")
  public abstract q<DeviceCloudProduct> V(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2);
  
  @f("{url}/v1/service/country")
  public abstract q<CountryCodeListResult> a1(@s(encoded=true, value="url") String paramString);
  
  @o("{url}/v1/service/tapocare")
  public abstract q<DeviceIdListResult> h1(@s(encoded=true, value="url") String paramString, @retrofit2.x.a DeviceTypeParams paramDeviceTypeParams);
  
  @f("{url}/v1/videos/timestamps")
  public abstract q<DeviceVideoDateResult<HasVideoTime>> n(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2, @t("startDate") String paramString3, @t("endDate") String paramString4);
  
  @f("{url}/v1/device/packages/byAccount")
  public abstract q<DeviceOrderListResult<DeviceCloudProduct>> o0(@s(encoded=true, value="url") String paramString1, @t("accountId") String paramString2, @t("page") int paramInt1, @t("pageSize") int paramInt2);
  
  @f("{url}/v1/videos")
  public abstract q<CloudVideoPageListResult<CloudVideo>> q1(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("order") String paramString3, @t("uuid") String paramString4, @t("startTime") String paramString5, @t("endTime") String paramString6);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */