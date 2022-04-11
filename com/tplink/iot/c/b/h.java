package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserListResult;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUsersParams;
import com.tplink.iot.cloud.bean.share.result.DeviceShareActionHandleListResult;
import com.tplink.iot.cloud.bean.share.result.DeviceShareLaunchResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceListResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.o;
import retrofit2.x.p;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface h
{
  @retrofit2.x.h(hasBody=true, method="DELETE", path="{url}/v1/things/{thingName}/users")
  public abstract io.reactivex.a B(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @retrofit2.x.a DeviceUsersParams paramDeviceUsersParams);
  
  @f("{url}/v1/things/{thingName}/owner")
  public abstract q<DeviceOwnerInfoResult> F0(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("isSubThing") boolean paramBoolean);
  
  @f("{url}/v1/things/share")
  public abstract q<ShareDeviceListResult> b0(@s(encoded=true, value="url") String paramString1, @t("page") int paramInt1, @t("pageSize") int paramInt2, @t("shareStatus") String paramString2, @t("shareRole") String paramString3, @t("deviceTypeList") String paramString4);
  
  @retrofit2.x.h(hasBody=true, method="DELETE", path="{url}/v1/things/user-role")
  public abstract io.reactivex.a d0(@s(encoded=true, value="url") String paramString, @retrofit2.x.a DeviceUserRoleListParams paramDeviceUserRoleListParams);
  
  @p("{url}/v1/things/share")
  public abstract q<DeviceShareLaunchResult> k(@s(encoded=true, value="url") String paramString, @retrofit2.x.a DeviceShareListParams paramDeviceShareListParams);
  
  @o("{url}/v1/things/share")
  public abstract q<DeviceShareActionHandleListResult> u(@s(encoded=true, value="url") String paramString, @retrofit2.x.a DeviceShareActionListParams paramDeviceShareActionListParams);
  
  @f("{url}/v1/things/{thingName}/users")
  public abstract q<DeviceUserListResult> z1(@s(encoded=true, value="url") String paramString1, @s("thingName") String paramString2, @t("isSubThing") boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */