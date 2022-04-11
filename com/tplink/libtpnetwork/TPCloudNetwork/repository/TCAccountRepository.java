package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
import com.tplink.cloud.bean.webservice.params.WebServiceInfoParams;
import com.tplink.cloud.bean.webservice.result.AccountAvatarResult;
import com.tplink.cloud.bean.webservice.result.WebServiceInfoResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.cloud.define.EnumAccountStatus;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.o;
import io.reactivex.e;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.Collections;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

public class TCAccountRepository
  extends b.d.b.f.a
{
  private b.d.b.c.a c;
  private b.d.b.c.j d;
  private o e;
  private MutableLiveData<TCAccountBean> f;
  private SingleLiveEvent<TCAccountBean> g;
  
  public TCAccountRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.c = paramb.d();
    this.d = paramb.d();
    this.e = o.h0();
    this.f = new MutableLiveData();
    this.g = new SingleLiveEvent();
  }
  
  private boolean B()
  {
    TCAccountBean localTCAccountBean = u();
    boolean bool;
    if ((localTCAccountBean != null) && (localTCAccountBean.getCloudUserName() != null) && (localTCAccountBean.getToken() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private q<Boolean> D(TCAccountBean paramTCAccountBean, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    return E(paramTCAccountBean.getCloudUserName(), paramTCAccountBean.getPassword(), paramString1, paramString2, paramString3, paramString4, paramBoolean);
  }
  
  private q<Boolean> F(final TCAccountBean paramTCAccountBean)
  {
    return G(paramTCAccountBean.getCloudUserName()).E(new i(paramTCAccountBean));
  }
  
  private void I()
  {
    TCAccountBean localTCAccountBean = u();
    localTCAccountBean.setPassword(null);
    localTCAccountBean.setToken(null);
    this.b.g(localTCAccountBean);
  }
  
  private void Q(String paramString)
  {
    TCAccountBean localTCAccountBean = u();
    localTCAccountBean.setCountryCode(paramString);
    this.e.t0(localTCAccountBean);
  }
  
  private void S(AccountAvatarResult paramAccountAvatarResult)
  {
    TCAccountBean localTCAccountBean = u();
    if (paramAccountAvatarResult.getAvatarUrl() == null) {
      paramAccountAvatarResult = "";
    } else {
      paramAccountAvatarResult = paramAccountAvatarResult.getAvatarUrl();
    }
    localTCAccountBean.setAvatarUrl(paramAccountAvatarResult);
    this.f.postValue(localTCAccountBean);
  }
  
  private void T(EnumAccountStatus paramEnumAccountStatus)
  {
    TCAccountBean localTCAccountBean = u();
    localTCAccountBean.setAccountStatus(paramEnumAccountStatus);
    this.f.postValue(localTCAccountBean);
  }
  
  private void U(String paramString)
  {
    TCAccountBean localTCAccountBean = u();
    localTCAccountBean.setNickName(paramString);
    this.e.s0(localTCAccountBean.getCloudUserName(), localTCAccountBean.getNickName());
    this.e.t0(localTCAccountBean);
    this.f.postValue(localTCAccountBean);
  }
  
  private void V(String paramString, CloudUserResult paramCloudUserResult)
  {
    TCAccountBean localTCAccountBean = u();
    localTCAccountBean.setAccountId(paramCloudUserResult.getAccountId());
    localTCAccountBean.setEmail(paramCloudUserResult.getEmail());
    localTCAccountBean.setUserName(paramCloudUserResult.getUsername());
    localTCAccountBean.setNickName(paramCloudUserResult.getNickname());
    localTCAccountBean.setRegTime(paramCloudUserResult.getRegTime());
    String str;
    if (paramCloudUserResult.getAvatarUrl() == null) {
      str = "";
    } else {
      str = paramCloudUserResult.getAvatarUrl();
    }
    localTCAccountBean.setAvatarUrl(str);
    localTCAccountBean.setCountryCode(paramCloudUserResult.getCountryCode());
    if (paramString.equalsIgnoreCase(paramCloudUserResult.getEmail())) {
      localTCAccountBean.setCloudUserName(paramCloudUserResult.getEmail());
    } else {
      localTCAccountBean.setCloudUserName(paramString);
    }
    this.e.s0(localTCAccountBean.getCloudUserName(), localTCAccountBean.getNickName());
    this.e.t0(localTCAccountBean);
    this.f.postValue(localTCAccountBean);
    this.g.postValue(localTCAccountBean);
  }
  
  private void W(String paramString1, String paramString2, LoginV1Result paramLoginV1Result)
  {
    TCAccountBean localTCAccountBean = u();
    localTCAccountBean.setAccountId(paramLoginV1Result.getAccountId());
    localTCAccountBean.setEmail(paramLoginV1Result.getEmail());
    localTCAccountBean.setToken(paramLoginV1Result.getToken());
    localTCAccountBean.setUserName(paramLoginV1Result.getUsername());
    localTCAccountBean.setNickName(paramLoginV1Result.getNickname());
    localTCAccountBean.setRegTime(paramLoginV1Result.getRegTime());
    localTCAccountBean.setRefreshToken(paramLoginV1Result.getRefreshToken());
    localTCAccountBean.setCountryCode(paramLoginV1Result.getCountryCode());
    String str;
    if (paramLoginV1Result.getAvatarUrl() == null) {
      str = "";
    } else {
      str = paramLoginV1Result.getAvatarUrl();
    }
    localTCAccountBean.setAvatarUrl(str);
    if (paramString1.equalsIgnoreCase(paramLoginV1Result.getEmail())) {
      localTCAccountBean.setCloudUserName(paramLoginV1Result.getEmail());
    } else {
      localTCAccountBean.setCloudUserName(paramString1);
    }
    localTCAccountBean.setPassword(paramString2);
    localTCAccountBean.setAccountStatus(EnumAccountStatus.ACCOUNT_STATUS_NORMAL);
    this.b.g(localTCAccountBean);
    this.e.s0(localTCAccountBean.getCloudUserName(), localTCAccountBean.getNickName());
    this.e.t0(localTCAccountBean);
    this.f.postValue(localTCAccountBean);
    this.g.postValue(localTCAccountBean);
  }
  
  private void X(String paramString)
  {
    TCAccountBean localTCAccountBean = u();
    localTCAccountBean.setPassword(paramString);
    this.f.postValue(localTCAccountBean);
  }
  
  private void Y(String paramString, int paramInt)
  {
    EnumAccountStatus localEnumAccountStatus1 = EnumAccountStatus.ACCOUNT_STATUS_NORMAL;
    EnumAccountStatus localEnumAccountStatus2;
    if (paramInt != 0)
    {
      localEnumAccountStatus2 = localEnumAccountStatus1;
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            localEnumAccountStatus2 = localEnumAccountStatus1;
          } else {
            localEnumAccountStatus2 = EnumAccountStatus.ACCOUNT_STATUS_UNACTIVATED;
          }
        }
        else {
          localEnumAccountStatus2 = EnumAccountStatus.ACCOUNT_STATUS_LOCKED;
        }
      }
    }
    else
    {
      localEnumAccountStatus2 = EnumAccountStatus.ACCOUNT_STATUS_UNREGISTERED;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(u().getCloudUserName()))) {
      T(localEnumAccountStatus2);
    }
  }
  
  public boolean A()
  {
    TCAccountBean localTCAccountBean = u();
    boolean bool;
    if ((localTCAccountBean != null) && (localTCAccountBean.isAccountInfoValid())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public q<Boolean> C(final TCAccountBean paramTCAccountBean, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final boolean paramBoolean)
  {
    boolean bool;
    if ((paramTCAccountBean.getToken() != null) && (!paramTCAccountBean.getToken().isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return q.f0(Boolean.valueOf(bool)).N(new m(paramTCAccountBean)).o0(new l(paramTCAccountBean, paramString1, paramString2, paramString3, paramString4, paramBoolean));
  }
  
  public q<Boolean> E(final String paramString1, final String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    LoginParams localLoginParams = new LoginParams();
    localLoginParams.setCloudUserName(paramString1);
    localLoginParams.setCloudPassword(paramString2);
    localLoginParams.setAppType(paramString3);
    localLoginParams.setTerminalUUID(paramString4);
    localLoginParams.setPlatform(paramString5);
    localLoginParams.setAppVersion(paramString6);
    localLoginParams.setRefreshTokenNeeded(paramBoolean);
    return this.c.L1(new CloudParams("login", localLoginParams)).g0(new j(paramString1, paramString2));
  }
  
  public q<Boolean> G(String paramString)
  {
    return this.c.f(new CloudParams("login", new CloudUserParams(paramString))).g0(new k());
  }
  
  public io.reactivex.a H(String paramString)
  {
    return this.c.e1(new CloudParams("logout", new CloudUserParams(paramString))).R(new n());
  }
  
  public io.reactivex.a J()
  {
    return q.f0(Boolean.valueOf(B())).R(new o());
  }
  
  public io.reactivex.a K(String paramString1, String paramString2, final String paramString3)
  {
    return this.c.s1(new CloudParams("modifyCloudPassword", new ModifyCloudPasswordParams(paramString1, paramString2, paramString3))).R(new q(paramString3));
  }
  
  public void L()
  {
    TCAccountBean localTCAccountBean = u();
    if (localTCAccountBean != null)
    {
      this.b.g(localTCAccountBean);
      this.f.postValue(localTCAccountBean);
    }
  }
  
  public io.reactivex.a M(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<String, Boolean> paramMap)
  {
    return this.c.o1(new CloudParams("register", new RegisterParams(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramMap))).Z();
  }
  
  public io.reactivex.a N(String paramString1, String paramString2)
  {
    return this.c.U0(new CloudParams("resendRegEmail", new CloudUserEmailParams(paramString1, paramString2))).Z();
  }
  
  public void O(TCAccountBean paramTCAccountBean)
  {
    this.b.g(paramTCAccountBean);
  }
  
  public io.reactivex.a P(String paramString1, String paramString2, final String paramString3)
  {
    return this.c.N0(new CloudParams("updateAccountInfo", new UpdateAccountInfoParams(paramString1, paramString2, paramString3))).R(new b(paramString3));
  }
  
  public io.reactivex.a R(String paramString1, final String paramString2)
  {
    return this.c.N0(new CloudParams("updateAccountInfo", new UpdateAccountInfoParams(paramString1, paramString2))).R(new a(paramString2));
  }
  
  public void Z()
  {
    TCAccountBean localTCAccountBean = u();
    if (localTCAccountBean != null)
    {
      localTCAccountBean.setNickName(this.e.s(localTCAccountBean.getCloudUserName()));
      this.f.postValue(localTCAccountBean);
    }
  }
  
  public io.reactivex.a a0(String paramString1, String paramString2, Map<String, Boolean> paramMap)
  {
    return this.c.f0(new CloudParams("updateTopicSubscription", new UpdateTopicSubscriptionParams(paramString1, paramString2, paramMap))).R(new f());
  }
  
  public q<AccountAvatarResult> b0(final String paramString, final byte[] paramArrayOfByte)
  {
    return this.d.S0(new CloudParams("getWebServiceInfo", new WebServiceInfoParams(Collections.singletonList("account.avatar")))).N(new h(paramString, paramArrayOfByte)).g0(new g());
  }
  
  public q<CheckPasswordV1Result> p(String paramString1, String paramString2)
  {
    return this.c.J1(new CloudParams("checkPassword", new CheckPasswordParams(paramString1, paramString2))).g0(new d());
  }
  
  public void q()
  {
    TCAccountBean localTCAccountBean = u();
    if (localTCAccountBean != null)
    {
      localTCAccountBean.setToken(null);
      this.b.g(localTCAccountBean);
      this.f.postValue(localTCAccountBean);
    }
    this.e.p();
  }
  
  public LiveData<TCAccountBean> r()
  {
    return this.f;
  }
  
  public q<CloudUserResult> s(final String paramString)
  {
    return this.c.p(new CloudParams("getAccountInfo", new CloudUserParams(paramString))).g0(new c(paramString));
  }
  
  public q<Integer> t(final String paramString)
  {
    return this.c.x1(new CloudParams("getCloudAccountStatus", new CloudUserParams(paramString))).g0(new p(paramString));
  }
  
  public TCAccountBean u()
  {
    return this.b.c();
  }
  
  public io.reactivex.a v(String paramString1, String paramString2)
  {
    return this.c.T(new CloudParams("getResetPasswordEmail", new CloudUserEmailParams(paramString1, paramString2))).Z();
  }
  
  public SingleLiveEvent<TCAccountBean> w()
  {
    return this.g;
  }
  
  public q<TopicSubscriptionResult> x(String paramString1, String paramString2)
  {
    return this.c.C1(new CloudParams("getTopicSubscription", new TopicSubscriptionParams(paramString1, paramString2))).g0(new e());
  }
  
  public boolean y()
  {
    b.d.b.c.a locala = this.c;
    boolean bool;
    if (((locala instanceof b.d.b.b)) && (!((b.d.b.b)locala).S1())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean z()
  {
    TCAccountBean localTCAccountBean = u();
    boolean bool;
    if ((localTCAccountBean != null) && (localTCAccountBean.isAccountInfoFullValid())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements io.reactivex.g0.j<CloudResult<Void>, e>
  {
    a(String paramString) {}
    
    public e a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.n(TCAccountRepository.this, paramString2);
      return io.reactivex.a.e();
    }
  }
  
  class b
    implements io.reactivex.g0.j<CloudResult<Void>, e>
  {
    b(String paramString) {}
    
    public e a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.o(TCAccountRepository.this, paramString3);
      return io.reactivex.a.e();
    }
  }
  
  class c
    implements io.reactivex.g0.j<CloudResult<CloudUserResult>, CloudUserResult>
  {
    c(String paramString) {}
    
    public CloudUserResult a(CloudResult<CloudUserResult> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.f(TCAccountRepository.this, paramString, (CloudUserResult)paramCloudResult.getResult());
      return (CloudUserResult)paramCloudResult.getResult();
    }
  }
  
  class d
    implements io.reactivex.g0.j<CloudResult<CheckPasswordV1Result>, CheckPasswordV1Result>
  {
    d() {}
    
    public CheckPasswordV1Result a(CloudResult<CheckPasswordV1Result> paramCloudResult)
      throws Exception
    {
      b.d.w.c.a.e("login_checkPwd", i.h(paramCloudResult));
      return (CheckPasswordV1Result)paramCloudResult.getResult();
    }
  }
  
  class e
    implements io.reactivex.g0.j<CloudResult<TopicSubscriptionResult>, TopicSubscriptionResult>
  {
    e() {}
    
    public TopicSubscriptionResult a(CloudResult<TopicSubscriptionResult> paramCloudResult)
      throws Exception
    {
      return (TopicSubscriptionResult)paramCloudResult.getResult();
    }
  }
  
  class f
    implements io.reactivex.g0.j<CloudResult<Void>, e>
  {
    f() {}
    
    public e a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      return io.reactivex.a.e();
    }
  }
  
  class g
    implements io.reactivex.g0.j<CloudResult<AccountAvatarResult>, AccountAvatarResult>
  {
    g() {}
    
    public AccountAvatarResult a(CloudResult<AccountAvatarResult> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.g(TCAccountRepository.this, (AccountAvatarResult)paramCloudResult.getResult());
      return (AccountAvatarResult)paramCloudResult.getResult();
    }
  }
  
  class h
    implements io.reactivex.g0.j<CloudResult<WebServiceInfoResult>, t<CloudResult<AccountAvatarResult>>>
  {
    h(String paramString, byte[] paramArrayOfByte) {}
    
    public t<CloudResult<AccountAvatarResult>> a(CloudResult<WebServiceInfoResult> paramCloudResult)
      throws Exception
    {
      Object localObject = (String)((WebServiceInfoResult)paramCloudResult.getResult()).getServiceUrls().get("account.avatar");
      if (localObject == null) {
        return q.J(new CloudException(-1, null));
      }
      paramCloudResult = new StringBuilder();
      paramCloudResult.append((String)localObject);
      paramCloudResult.append("/res/uploadAccountAvatar");
      paramCloudResult = paramCloudResult.toString();
      localObject = MultipartBody.Part.createFormData("attachment", "avatar.png", RequestBody.create(MediaType.get(paramString), paramArrayOfByte));
      return TCAccountRepository.h(TCAccountRepository.this).Y(paramCloudResult, (MultipartBody.Part)localObject);
    }
  }
  
  class i
    implements g<Boolean>
  {
    i(TCAccountBean paramTCAccountBean) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      TCAccountRepository.this.s(paramTCAccountBean.getCloudUserName()).L0(io.reactivex.l0.a.c()).F0();
    }
  }
  
  class j
    implements io.reactivex.g0.j<CloudResult<LoginV1Result>, Boolean>
  {
    j(String paramString1, String paramString2) {}
    
    public Boolean a(CloudResult<LoginV1Result> paramCloudResult)
      throws Exception
    {
      b.d.w.c.a.e("login", i.h(paramCloudResult));
      if (paramCloudResult.getErrorCode() == 0)
      {
        paramCloudResult = (LoginV1Result)paramCloudResult.getResult();
        if ((paramCloudResult != null) && (paramCloudResult.getErrorCode() == 0))
        {
          TCAccountRepository.d(TCAccountRepository.this, paramString1, paramString2, paramCloudResult);
          return Boolean.TRUE;
        }
        throw new CloudAccountV1Exception(paramCloudResult);
      }
      throw new CloudException(paramCloudResult.getErrorCode(), paramCloudResult.getMsg());
    }
  }
  
  class k
    implements io.reactivex.g0.j<CloudResult<Void>, Boolean>
  {
    k() {}
    
    public Boolean a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.e(TCAccountRepository.this, EnumAccountStatus.ACCOUNT_STATUS_NORMAL);
      return Boolean.TRUE;
    }
  }
  
  class l
    implements io.reactivex.g0.j<Throwable, t<Boolean>>
  {
    l(TCAccountBean paramTCAccountBean, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {}
    
    public t<Boolean> a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        int i = ((CloudException)paramThrowable).getErrCode();
        if ((i == 44884) || (i == 44885)) {
          return TCAccountRepository.i(TCAccountRepository.this, paramTCAccountBean, paramString1, paramString2, paramString3, paramString4, paramBoolean);
        }
      }
      return q.J(paramThrowable);
    }
  }
  
  class m
    implements io.reactivex.g0.j<Boolean, t<Boolean>>
  {
    m(TCAccountBean paramTCAccountBean) {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue()) {
        return q.J(new CloudException(44885, ""));
      }
      return TCAccountRepository.j(TCAccountRepository.this, paramTCAccountBean);
    }
  }
  
  class n
    implements io.reactivex.g0.j<CloudResult<Void>, e>
  {
    n() {}
    
    public e a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.k(TCAccountRepository.this);
      return io.reactivex.a.e();
    }
  }
  
  class o
    implements io.reactivex.g0.j<Boolean, e>
  {
    o() {}
    
    public e a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue())
      {
        paramBoolean = TCAccountRepository.this;
        paramBoolean = paramBoolean.H(paramBoolean.u().getCloudUserName());
      }
      else
      {
        paramBoolean = io.reactivex.a.n(new a());
      }
      return paramBoolean;
    }
    
    class a
      implements io.reactivex.g0.a
    {
      a() {}
      
      public void run()
        throws Exception
      {
        TCAccountRepository.k(TCAccountRepository.this);
      }
    }
  }
  
  class p
    implements io.reactivex.g0.j<CloudResult<AccountStatusResult>, Integer>
  {
    p(String paramString) {}
    
    public Integer a(CloudResult<AccountStatusResult> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.l(TCAccountRepository.this, paramString, ((AccountStatusResult)paramCloudResult.getResult()).getStatus());
      return Integer.valueOf(((AccountStatusResult)paramCloudResult.getResult()).getStatus());
    }
  }
  
  class q
    implements io.reactivex.g0.j<CloudResult<Void>, e>
  {
    q(String paramString) {}
    
    public e a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      TCAccountRepository.m(TCAccountRepository.this, paramString3);
      return io.reactivex.a.e();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\TCAccountRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */