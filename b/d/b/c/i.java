package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.share.params.ShareBlacklistParams;
import com.tplink.cloud.bean.share.params.ShareBlacklistUpdateParams;
import com.tplink.cloud.bean.share.result.ShareBlacklistResult;
import com.tplink.cloud.bean.share.result.ShareBlacklistUpdateResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.o;

public abstract interface i
{
  @o("/")
  public abstract q<CloudResult<ShareBlacklistUpdateResult>> Q0(@a CloudParams<ShareBlacklistUpdateParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<ShareBlacklistUpdateResult>> s(@a CloudParams<ShareBlacklistUpdateParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<ShareBlacklistResult>> t1(@a CloudParams<ShareBlacklistParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */