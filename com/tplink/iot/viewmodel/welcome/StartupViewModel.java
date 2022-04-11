package com.tplink.iot.viewmodel.welcome;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.core.FragmentStateReceiver;
import com.tplink.iot.core.n;
import com.tplink.iot.core.p;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCProtocolRepository;
import com.tplink.libtpnetwork.Utils.o;
import io.reactivex.g0.g;
import io.reactivex.q;

public class StartupViewModel
  extends AndroidViewModel
{
  private o a = o.h0();
  private TCProtocolRepository b;
  private TCAccountRepository c;
  private TPIoTClientManager d;
  private MutableLiveData<Boolean> e = new MutableLiveData();
  private MutableLiveData<Integer> f = new MutableLiveData();
  private long g;
  private boolean h = false;
  private boolean i = false;
  
  public StartupViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.b = ((TCProtocolRepository)b.d.b.f.b.a(paramApplication, TCProtocolRepository.class));
    this.c = ((TCAccountRepository)b.d.b.f.b.a(paramApplication, TCAccountRepository.class));
    this.d = ((TPIoTClientManager)b.d.b.f.b.a(paramApplication, TPIoTClientManager.class));
  }
  
  private void l()
  {
    this.c.q();
  }
  
  private boolean o()
  {
    return com.tplink.iot.model.about.c.e();
  }
  
  private boolean r()
  {
    TCAccountBean localTCAccountBean1 = this.c.u();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localTCAccountBean1 != null) {
      if (TextUtils.isEmpty(localTCAccountBean1.getCloudUserName()))
      {
        bool2 = bool1;
      }
      else
      {
        TCAccountBean localTCAccountBean2 = this.a.P();
        if ((TextUtils.isEmpty(localTCAccountBean1.getPassword())) || (localTCAccountBean2 == null) || (TextUtils.isEmpty(localTCAccountBean2.getPassword())))
        {
          bool2 = bool1;
          if (TextUtils.isEmpty(localTCAccountBean1.getToken())) {}
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private boolean s()
  {
    boolean bool;
    if ((b.d.w.f.b.j(getApplication())) && (b.d.w.f.b.i(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void u()
  {
    this.c.L();
  }
  
  private void w(Boolean paramBoolean)
  {
    this.g = (System.currentTimeMillis() - this.g);
  }
  
  public LiveData<Integer> m()
  {
    return this.f;
  }
  
  public LiveData<Boolean> n()
  {
    return this.e;
  }
  
  @SuppressLint({"CheckResult"})
  public void p()
  {
    this.b.e().F(new c()).E(new b()).L0(io.reactivex.l0.a.c()).G0(new a());
  }
  
  @SuppressLint({"CheckResult"})
  public void t(boolean paramBoolean)
  {
    this.i = true;
    this.h = true;
    boolean bool = o();
    if (paramBoolean) {
      paramBoolean = this.c.z();
    } else {
      paramBoolean = this.c.A();
    }
    if (!b.d.w.f.b.h(getApplication()))
    {
      u();
      this.h = false;
      this.f.setValue(Integer.valueOf(2));
      return;
    }
    if ((bool) && (paramBoolean))
    {
      this.d.l4(this.c.u(), n.a(), s()).L0(io.reactivex.l0.a.c()).F(new g()).y(new f()).H0(new d(), new e());
      return;
    }
    l();
    this.h = false;
    this.f.setValue(Integer.valueOf(1));
  }
  
  public void v()
  {
    if (this.h)
    {
      if (!this.i) {
        this.e.setValue(Boolean.FALSE);
      }
      return;
    }
    MutableLiveData localMutableLiveData = this.e;
    boolean bool;
    if ((r()) && (o())) {
      bool = true;
    } else {
      bool = false;
    }
    localMutableLiveData.setValue(Boolean.valueOf(bool));
  }
  
  class a
    implements g<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      p.i();
      FragmentStateReceiver.g();
    }
  }
  
  class b
    implements g<Boolean>
  {
    b() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      StartupViewModel.f(StartupViewModel.this, paramBoolean);
    }
  }
  
  class c
    implements g<io.reactivex.e0.c>
  {
    c() {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      StartupViewModel.g(StartupViewModel.this, System.currentTimeMillis());
    }
  }
  
  class d
    implements g<Boolean>
  {
    d() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue())
      {
        StartupViewModel.h(StartupViewModel.this).postValue(Integer.valueOf(0));
      }
      else
      {
        StartupViewModel.i(StartupViewModel.this);
        StartupViewModel.h(StartupViewModel.this).postValue(Integer.valueOf(1));
      }
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudAccountV1Exception))
      {
        StartupViewModel.i(StartupViewModel.this);
        StartupViewModel.h(StartupViewModel.this).postValue(Integer.valueOf(1));
        return;
      }
      StartupViewModel.j(StartupViewModel.this);
      StartupViewModel.h(StartupViewModel.this).setValue(Integer.valueOf(2));
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f() {}
    
    public void run()
      throws Exception
    {
      StartupViewModel.k(StartupViewModel.this, false);
    }
  }
  
  class g
    implements g<io.reactivex.e0.c>
  {
    g() {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      StartupViewModel.h(StartupViewModel.this).setValue(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\welcome\StartupViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */