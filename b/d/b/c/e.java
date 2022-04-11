package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.push.params.NotificationMsgIdListParams;
import com.tplink.cloud.bean.push.params.NotificationMsgTypeListParams;
import com.tplink.cloud.bean.push.params.NotificationParams;
import com.tplink.cloud.bean.push.params.PushInfoParams;
import com.tplink.cloud.bean.push.params.UnsubscribeMsgParams;
import com.tplink.cloud.bean.push.result.NotificationMsgListResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.o;

public abstract interface e
{
  @o("/")
  public abstract q<CloudResult<Void>> a(@a CloudParams<PushInfoParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<NotificationMsgListResult>> b(@a CloudParams<NotificationParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> c(@a CloudParams<NotificationMsgTypeListParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> d(@a CloudParams<NotificationMsgIdListParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> e(@a CloudParams<UnsubscribeMsgParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */