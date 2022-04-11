package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.passthrough.params.PassThroughParams;
import com.tplink.cloud.bean.passthrough.result.PassThroughResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.o;
import retrofit2.x.y;

public abstract interface g
{
  @o
  public abstract q<CloudResult<PassThroughResult>> k0(@y String paramString, @a CloudParams<PassThroughParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */