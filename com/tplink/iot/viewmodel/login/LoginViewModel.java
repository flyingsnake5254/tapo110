package com.tplink.iot.viewmodel.login;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.core.n;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;

public class LoginViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a = (TCAccountRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);
  private TPIoTClientManager b = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
  private SingleLiveEvent<i<LoginV1Result>> c = new SingleLiveEvent();
  
  public LoginViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void h(TCAccountBean paramTCAccountBean)
  {
    com.tplink.cloud.context.b localb = b.d.s.a.a.f();
    if (localb.c() != null)
    {
      String str = localb.c().getCloudUserName();
      if ((paramTCAccountBean.getCloudUserName() != null) && (!paramTCAccountBean.getCloudUserName().equals(str)))
      {
        b.d.b.f.b.b(localb);
        b.d.s.a.a.j(str);
        localb.b();
        this.b = ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.c(paramTCAccountBean), TPIoTClientManager.class));
        this.a = ((TCAccountRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class));
      }
    }
  }
  
  private void i()
  {
    this.a.q();
  }
  
  private boolean l()
  {
    boolean bool;
    if ((b.d.w.f.b.j(getApplication())) && (b.d.w.f.b.i(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public LiveData<TCAccountBean> j()
  {
    return this.a.r();
  }
  
  public LiveData<i<LoginV1Result>> k()
  {
    return this.c;
  }
  
  @SuppressLint({"CheckResult"})
  public void m(String paramString1, String paramString2)
  {
    paramString1 = new TCAccountBean(paramString1, paramString2);
    h(paramString1);
    this.b.l4(paramString1, n.a(), l()).L0(io.reactivex.l0.a.c()).F(new c()).H0(new a(), new b());
  }
  
  class a
    implements g<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue())
      {
        LoginViewModel.f(LoginViewModel.this).postValue(new i(0, new LoginV1Result()));
      }
      else
      {
        LoginViewModel.g(LoginViewModel.this);
        LoginViewModel.f(LoginViewModel.this).postValue(new i(1, null));
      }
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      LoginViewModel.g(LoginViewModel.this);
      if ((paramThrowable instanceof CloudAccountV1Exception))
      {
        paramThrowable = (CloudAccountV1Exception)paramThrowable;
        LoginViewModel.f(LoginViewModel.this).postValue(new i(0, paramThrowable.getLoginV1Result()));
      }
      else if ((paramThrowable instanceof CloudException))
      {
        LoginViewModel.f(LoginViewModel.this).postValue(new i(1, null));
      }
      else
      {
        LoginViewModel.f(LoginViewModel.this).postValue(new i(1, null));
      }
    }
  }
  
  class c
    implements g<c>
  {
    c() {}
    
    public void a(c paramc)
      throws Exception
    {
      LoginViewModel.f(LoginViewModel.this).setValue(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\login\LoginViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */