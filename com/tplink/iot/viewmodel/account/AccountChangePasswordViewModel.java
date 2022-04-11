package com.tplink.iot.viewmodel.account;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import b.d.b.f.b;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.core.n;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;

public class AccountChangePasswordViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a;
  private String b = null;
  private String c = null;
  private MediatorLiveData<Integer> d = new MediatorLiveData();
  private c e = null;
  
  public AccountChangePasswordViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (TCAccountRepository)b.a(b.d.s.a.a.f(), TCAccountRepository.class);
    this.a = paramApplication;
    this.d.addSource(paramApplication.r(), new a());
  }
  
  private void n()
  {
    ((TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).e4();
  }
  
  public LiveData<Integer> l()
  {
    return this.d;
  }
  
  public void m(final String paramString)
  {
    this.e = this.a.K(this.b, this.c, paramString).C(io.reactivex.l0.a.c()).l(new d()).A(new b(paramString), new c());
  }
  
  protected void onCleared()
  {
    c localc = this.e;
    if (localc != null) {
      localc.dispose();
    }
    super.onCleared();
  }
  
  class a
    implements Observer<TCAccountBean>
  {
    a() {}
    
    public void a(@Nullable TCAccountBean paramTCAccountBean)
    {
      if (paramTCAccountBean != null)
      {
        AccountChangePasswordViewModel.g(AccountChangePasswordViewModel.this, paramTCAccountBean.getCloudUserName());
        AccountChangePasswordViewModel.h(AccountChangePasswordViewModel.this, paramTCAccountBean.getPassword());
      }
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b(String paramString) {}
    
    public void run()
      throws Exception
    {
      AccountChangePasswordViewModel.i(AccountChangePasswordViewModel.this).postValue(Integer.valueOf(0));
      String str1 = n.a;
      String str2 = n.b;
      String str3 = n.c;
      AccountChangePasswordViewModel.k(AccountChangePasswordViewModel.this).E(AccountChangePasswordViewModel.f(AccountChangePasswordViewModel.this), paramString, "TP-Link_Tapo_Android", str1, str2, str3, false).L0(io.reactivex.l0.a.c()).z(new a()).F0();
    }
    
    class a
      implements io.reactivex.g0.a
    {
      a() {}
      
      public void run()
        throws Exception
      {
        AccountChangePasswordViewModel.j(AccountChangePasswordViewModel.this);
      }
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      AccountChangePasswordViewModel.i(AccountChangePasswordViewModel.this).postValue(Integer.valueOf(-1));
    }
  }
  
  class d
    implements g<c>
  {
    d() {}
    
    public void a(c paramc)
      throws Exception
    {
      AccountChangePasswordViewModel.i(AccountChangePasswordViewModel.this).setValue(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\account\AccountChangePasswordViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */