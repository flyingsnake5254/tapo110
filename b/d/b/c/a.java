package b.d.b.c;

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
import io.reactivex.q;
import retrofit2.x.k;
import retrofit2.x.o;

public abstract interface a
{
  @o("/")
  public abstract q<CloudResult<TopicSubscriptionResult>> C1(@retrofit2.x.a CloudParams<TopicSubscriptionParams> paramCloudParams);
  
  @k({"token-required:false"})
  @o("/api/v1/account")
  public abstract q<CloudResult<CheckPasswordV1Result>> J1(@retrofit2.x.a CloudParams<CheckPasswordParams> paramCloudParams);
  
  @k({"token-required:false"})
  @o("/api/v1/account")
  public abstract q<CloudResult<LoginV1Result>> L1(@retrofit2.x.a CloudParams<LoginParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> N0(@retrofit2.x.a CloudParams<UpdateAccountInfoParams> paramCloudParams);
  
  @k({"token-required:false"})
  @o("/")
  public abstract q<CloudResult<Void>> T(@retrofit2.x.a CloudParams<CloudUserEmailParams> paramCloudParams);
  
  @k({"token-required:false"})
  @o("/")
  public abstract q<CloudResult<Void>> U0(@retrofit2.x.a CloudParams<CloudUserEmailParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> e1(@retrofit2.x.a CloudParams<CloudUserParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> f(@retrofit2.x.a CloudParams<CloudUserParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> f0(@retrofit2.x.a CloudParams<UpdateTopicSubscriptionParams> paramCloudParams);
  
  @k({"token-required:false"})
  @o("/")
  public abstract q<CloudResult<Void>> o1(@retrofit2.x.a CloudParams<RegisterParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<CloudUserResult>> p(@retrofit2.x.a CloudParams<CloudUserParams> paramCloudParams);
  
  @o("/")
  public abstract q<CloudResult<Void>> s1(@retrofit2.x.a CloudParams<ModifyCloudPasswordParams> paramCloudParams);
  
  @k({"token-required:false"})
  @o("/")
  public abstract q<CloudResult<AccountStatusResult>> x1(@retrofit2.x.a CloudParams<CloudUserParams> paramCloudParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */