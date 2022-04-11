package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.device.params.DeviceAliasParams;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoParams;
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
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.o;
import retrofit2.x.y;

public abstract interface c
{
  @o("/")
  public abstract q<CloudResult<DeviceConfigInfoListResult>> M(@a CloudParams<DeviceConfigInfoParams> paramCloudParams);
  
  @o
  public abstract q<CloudResult<Void>> Y0(@y String paramString, @a CloudParams<DeviceUnbindParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<DeviceUnbindFeatureResult>> a0(@a CloudParams<DeviceFeatureParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<DeviceListPageResult>> b1(@a CloudParams<DeviceListPageParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<DeviceInfoResult>> j1(@a CloudParams<DeviceInfoParams> paramCloudParams);
  
  @o
  public abstract q<CloudResult<DeviceInfoResult>> p1(@y String paramString, @a CloudParams<DeviceInfoParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<DeviceUserNumberLimitListResult>> y(@a CloudParams<DeviceUserNumberLimitParams> paramCloudParams);
  
  @o
  public abstract q<CloudResult<Void>> z0(@y String paramString, @a CloudParams<DeviceAliasParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */