package com.tplink.iot.viewmodel.signup;

import android.annotation.SuppressLint;
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
import io.reactivex.q;
import java.util.Locale;

public class SignUpCheckViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a = (TCAccountRepository)b.a(b.d.s.a.a.f(), TCAccountRepository.class);
  private MutableLiveData<Integer> b = new MutableLiveData();
  private MutableLiveData<Integer> c = new MutableLiveData();
  
  public SignUpCheckViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  @SuppressLint({"CheckResult"})
  public void h(String paramString)
  {
    if (!this.a.y()) {
      this.c.setValue(Integer.valueOf(-99));
    } else {
      this.a.t(paramString).L0(io.reactivex.l0.a.c()).F(new g()).H0(new e(), new f());
    }
  }
  
  public LiveData<Integer> i()
  {
    return this.c;
  }
  
  public LiveData<Integer> j()
  {
    return this.b;
  }
  
  public void k(String paramString)
  {
    this.a.N(paramString, x.d(Locale.getDefault())).C(io.reactivex.l0.a.c()).A(new a(), new b());
  }
  
  public void l(String paramString)
  {
    this.a.v(paramString, x.d(Locale.getDefault())).C(io.reactivex.l0.a.c()).A(new c(), new d());
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      SignUpCheckViewModel.f(SignUpCheckViewModel.this).postValue(Integer.valueOf(0));
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
        SignUpCheckViewModel.f(SignUpCheckViewModel.this).postValue(Integer.valueOf(((CloudException)paramThrowable).getErrCode()));
      } else {
        SignUpCheckViewModel.f(SignUpCheckViewModel.this).postValue(Integer.valueOf(-1));
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
      SignUpCheckViewModel.f(SignUpCheckViewModel.this).postValue(Integer.valueOf(0));
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException)) {
        SignUpCheckViewModel.f(SignUpCheckViewModel.this).postValue(Integer.valueOf(((CloudException)paramThrowable).getErrCode()));
      } else {
        SignUpCheckViewModel.f(SignUpCheckViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
  
  class e
    implements g<Integer>
  {
    e() {}
    
    public void a(Integer paramInteger)
      throws Exception
    {
      int i = paramInteger.intValue();
      int j = 16;
      int k;
      if (i != 0)
      {
        k = j;
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              k = j;
            } else {
              k = 19;
            }
          }
          else {
            k = 17;
          }
        }
      }
      else
      {
        k = 18;
      }
      SignUpCheckViewModel.g(SignUpCheckViewModel.this).postValue(Integer.valueOf(k));
    }
  }
  
  class f
    implements g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException)) {
        SignUpCheckViewModel.g(SignUpCheckViewModel.this).postValue(Integer.valueOf(((CloudException)paramThrowable).getErrCode()));
      } else {
        SignUpCheckViewModel.g(SignUpCheckViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
  
  class g
    implements g<c>
  {
    g() {}
    
    public void a(c paramc)
      throws Exception
    {
      SignUpCheckViewModel.g(SignUpCheckViewModel.this).setValue(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\signup\SignUpCheckViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */