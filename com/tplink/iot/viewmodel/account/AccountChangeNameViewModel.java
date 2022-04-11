package com.tplink.iot.viewmodel.account;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import io.reactivex.e0.c;
import io.reactivex.g0.g;

public class AccountChangeNameViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a;
  private String b = null;
  private MediatorLiveData<String> c = new MediatorLiveData();
  private MutableLiveData<Integer> d = new MutableLiveData();
  
  public AccountChangeNameViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (TCAccountRepository)b.a(b.d.s.a.a.f(), TCAccountRepository.class);
    this.a = paramApplication;
    this.c.addSource(paramApplication.r(), new a());
  }
  
  public void i(String paramString)
  {
    if (TextUtils.isEmpty(this.b))
    {
      this.d.setValue(Integer.valueOf(1));
      return;
    }
    this.a.R(this.b, paramString).C(io.reactivex.l0.a.c()).l(new d()).A(new b(), new c());
  }
  
  public LiveData<String> j()
  {
    return this.c;
  }
  
  public LiveData<Integer> k()
  {
    return this.d;
  }
  
  class a
    implements Observer<TCAccountBean>
  {
    a() {}
    
    public void a(@Nullable TCAccountBean paramTCAccountBean)
    {
      if (paramTCAccountBean != null)
      {
        AccountChangeNameViewModel.f(AccountChangeNameViewModel.this, paramTCAccountBean.getCloudUserName());
        AccountChangeNameViewModel.g(AccountChangeNameViewModel.this).setValue(paramTCAccountBean.getNickName());
      }
      else
      {
        AccountChangeNameViewModel.g(AccountChangeNameViewModel.this).setValue("");
      }
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      AccountChangeNameViewModel.h(AccountChangeNameViewModel.this).postValue(Integer.valueOf(0));
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      AccountChangeNameViewModel.h(AccountChangeNameViewModel.this).postValue(Integer.valueOf(1));
    }
  }
  
  class d
    implements g<c>
  {
    d() {}
    
    public void a(c paramc)
      throws Exception
    {
      AccountChangeNameViewModel.h(AccountChangeNameViewModel.this).setValue(Integer.valueOf(-1));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\account\AccountChangeNameViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */