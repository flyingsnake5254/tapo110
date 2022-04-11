package com.tplink.iot.viewmodel.quicksetup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.x0.u;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;

public class QuickSetupVerifyPwdViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a = (TCAccountRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);
  private TPIoTClientManager b = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
  private MutableLiveData<Boolean> c = new MutableLiveData();
  
  public QuickSetupVerifyPwdViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  @SuppressLint({"CheckResult"})
  private void h(final String paramString1, final String paramString2, final String paramString3)
  {
    this.a.p(paramString2, paramString3).L0(io.reactivex.l0.a.c()).H0(new a(paramString1, paramString2, paramString3), new b(paramString1, paramString2, paramString3));
  }
  
  private void j()
  {
    this.b.d3().C(io.reactivex.l0.a.c()).l(new d()).h(new c()).y();
  }
  
  public MutableLiveData<Boolean> i()
  {
    return this.c;
  }
  
  public void k()
  {
    b.d.w.c.a.a("verify cloud");
    Object localObject1 = b.d.s.a.a.f();
    String str = "";
    Object localObject2;
    if ((localObject1 != null) && (b.d.s.a.a.f().c() != null))
    {
      localObject1 = b.d.s.a.a.f().c();
      if ((localObject1 != null) && (((TCAccountBean)localObject1).getCloudUserName() != null))
      {
        localObject2 = ((TCAccountBean)localObject1).getCloudUserName();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("username=");
        ((StringBuilder)localObject3).append((String)localObject2);
        b.d.w.c.a.a(((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject2 = "";
      }
      if ((localObject1 != null) && (((TCAccountBean)localObject1).getEmail() != null))
      {
        localObject3 = ((TCAccountBean)localObject1).getEmail();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("email=");
        ((StringBuilder)localObject4).append((String)localObject3);
        b.d.w.c.a.a(((StringBuilder)localObject4).toString());
      }
      if ((localObject1 != null) && (((TCAccountBean)localObject1).getAccountId() != null))
      {
        localObject3 = ((TCAccountBean)localObject1).getAccountId();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("accountId=");
        ((StringBuilder)localObject4).append((String)localObject3);
        b.d.w.c.a.a(((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject3 = "";
      }
      if ((localObject1 != null) && (((TCAccountBean)localObject1).getPassword() != null))
      {
        localObject1 = ((TCAccountBean)localObject1).getPassword();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("password=");
        ((StringBuilder)localObject4).append((String)localObject1);
        b.d.w.c.a.a(((StringBuilder)localObject4).toString());
        localObject4 = localObject2;
        localObject2 = localObject3;
      }
      else
      {
        localObject1 = "";
        localObject4 = localObject2;
        localObject2 = localObject3;
      }
    }
    else
    {
      localObject1 = "";
      localObject4 = localObject1;
      localObject2 = localObject4;
    }
    b.d.w.c.a.a("verify cloud info");
    Object localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    Object localObject4 = localObject2;
    if (localObject2 == null) {
      localObject4 = "";
    }
    if (localObject1 == null) {
      localObject1 = str;
    }
    boolean bool = this.b.w2();
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (bool) {
        h((String)localObject4, (String)localObject3, (String)localObject1);
      }
    }
    else if (bool) {
      u.i(0, (String)localObject4, (String)localObject3, (String)localObject1);
    } else {
      u.h(0, (String)localObject4, (String)localObject3, (String)localObject1);
    }
  }
  
  class a
    implements g<CheckPasswordV1Result>
  {
    a(String paramString1, String paramString2, String paramString3) {}
    
    public void a(CheckPasswordV1Result paramCheckPasswordV1Result)
      throws Exception
    {
      if (paramCheckPasswordV1Result.getErrorCode() == 0)
      {
        b.d.w.c.a.a("checkAccountPassword success");
        u.j(0, paramString1, paramString2, paramString3);
        return;
      }
      throw new CloudException(paramCheckPasswordV1Result.getErrorCode(), paramCheckPasswordV1Result.getErrorMsg());
    }
  }
  
  class b
    implements g<Throwable>
  {
    b(String paramString1, String paramString2, String paramString3) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        int i = ((CloudException)paramThrowable).getErrCode();
        if (i == 44935)
        {
          b.d.w.c.a.a("checkAccountPassword cloud incorrect logout");
          QuickSetupVerifyPwdViewModel.f(QuickSetupVerifyPwdViewModel.this);
          u.e(i, paramString1, paramString2, paramString3);
        }
        else
        {
          b.d.w.c.a.a("checkAccountPassword cloud other error");
          u.f(i, paramString1, paramString2, paramString3);
        }
      }
      else
      {
        b.d.w.c.a.a("checkAccountPassword network other error");
        u.f(11, paramString1, paramString2, paramString3);
      }
    }
  }
  
  class c
    implements io.reactivex.g0.a
  {
    c() {}
    
    public void run()
      throws Exception
    {
      QuickSetupVerifyPwdViewModel.g(QuickSetupVerifyPwdViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class d
    implements g<c>
  {
    d() {}
    
    public void a(c paramc)
      throws Exception
    {
      QuickSetupVerifyPwdViewModel.g(QuickSetupVerifyPwdViewModel.this).postValue(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\QuickSetupVerifyPwdViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */