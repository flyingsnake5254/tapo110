package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.firmware.params.FirmwareInfoParams;
import com.tplink.cloud.bean.firmware.result.FirmwareListResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.o;

public abstract interface d
{
  @o("/")
  public abstract q<CloudResult<FirmwareListResult>> O0(@a CloudParams<FirmwareInfoParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */