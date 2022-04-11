package com.tplink.iot.viewmodel.login;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.cloud.define.CloudException;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.x;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import java.util.Locale;

public class RetrieveAccountViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a = (TCAccountRepository)b.a(b.d.s.a.a.f(), TCAccountRepository.class);
  private MutableLiveData<Integer> b = new MutableLiveData();
  
  public RetrieveAccountViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public LiveData<Integer> g()
  {
    return this.b;
  }
  
  public void h(String paramString)
  {
    this.a.v(paramString, x.d(Locale.getDefault())).C(io.reactivex.l0.a.c()).l(new c()).A(new a(), new b());
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      RetrieveAccountViewModel.f(RetrieveAccountViewModel.this).postValue(Integer.valueOf(0));
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException)) {
        RetrieveAccountViewModel.f(RetrieveAccountViewModel.this).postValue(Integer.valueOf(((CloudException)paramThrowable).getErrCode()));
      } else {
        RetrieveAccountViewModel.f(RetrieveAccountViewModel.this).postValue(Integer.valueOf(-1));
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
      RetrieveAccountViewModel.f(RetrieveAccountViewModel.this).setValue(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\login\RetrieveAccountViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */