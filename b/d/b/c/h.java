package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.protocol.params.HelloCloudParams;
import com.tplink.cloud.bean.protocol.result.HelloCloudResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.k;
import retrofit2.x.o;

public abstract interface h
{
  @k({"token-required:false"})
  @o("/")
  public abstract q<CloudResult<HelloCloudResult>> v(@a CloudParams<HelloCloudParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */