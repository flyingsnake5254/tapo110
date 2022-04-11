package com.tplink.iot.viewmodel.account;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;

public class AccountPasswordVerifyViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a = (TCAccountRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);
  private MutableLiveData<i<CheckPasswordV1Result>> b = new MutableLiveData();
  
  public AccountPasswordVerifyViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  @SuppressLint({"CheckResult"})
  public void g(String paramString)
  {
    TCAccountRepository localTCAccountRepository = this.a;
    localTCAccountRepository.p(localTCAccountRepository.u().getCloudUserName(), paramString).L0(io.reactivex.l0.a.c()).F(new c()).H0(new a(), new b());
  }
  
  public String h()
  {
    Object localObject = b.d.s.a.a.f();
    if ((localObject != null) && (((com.tplink.cloud.context.b)localObject).c() != null)) {
      localObject = ((com.tplink.cloud.context.b)localObject).c().getEmail();
    } else {
      localObject = "";
    }
    if (b.d.w.h.b.c((String)localObject)) {
      return (String)localObject;
    }
    return "";
  }
  
  public LiveData<i<CheckPasswordV1Result>> i()
  {
    return this.b;
  }
  
  class a
    implements g<CheckPasswordV1Result>
  {
    a() {}
    
    public void a(CheckPasswordV1Result paramCheckPasswordV1Result)
      throws Exception
    {
      AccountPasswordVerifyViewModel.f(AccountPasswordVerifyViewModel.this).postValue(new i(0, paramCheckPasswordV1Result));
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      AccountPasswordVerifyViewModel.f(AccountPasswordVerifyViewModel.this).postValue(new i(1, null));
    }
  }
  
  class c
    implements g<c>
  {
    c() {}
    
    public void a(c paramc)
      throws Exception
    {
      AccountPasswordVerifyViewModel.f(AccountPasswordVerifyViewModel.this).setValue(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\account\AccountPasswordVerifyViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */