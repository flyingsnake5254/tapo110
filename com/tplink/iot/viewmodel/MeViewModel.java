package com.tplink.iot.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.s.a.a;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.s;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.viewmodel.home.r;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.List;

public class MeViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a;
  private TPIoTClientManager b;
  private MediatorLiveData<Boolean> c = new MediatorLiveData();
  private MediatorLiveData<Boolean> d = new MediatorLiveData();
  private MediatorLiveData<Boolean> e = new MediatorLiveData();
  
  public MeViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    com.tplink.cloud.context.b localb = a.f();
    paramApplication = (TPIoTClientManager)b.d.b.f.b.a(localb, TPIoTClientManager.class);
    this.a = ((TCAccountRepository)b.d.b.f.b.a(localb, TCAccountRepository.class));
    this.b = ((TPIoTClientManager)b.d.b.f.b.a(localb, TPIoTClientManager.class));
    this.c.addSource(paramApplication.o2(), new a());
    this.d.addSource(r.g().e(), new b());
    this.e.addSource(this.b.M1(), new c());
  }
  
  public void i()
  {
    this.b.D1();
  }
  
  public MediatorLiveData<Boolean> j()
  {
    return this.d;
  }
  
  public MediatorLiveData<Boolean> k()
  {
    return this.e;
  }
  
  public LiveData<TCAccountBean> l()
  {
    return this.a.r();
  }
  
  public MediatorLiveData<Boolean> m()
  {
    return this.c;
  }
  
  public boolean n()
  {
    return s.b((List)this.b.C1().getValue());
  }
  
  public void o(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = a.f();
      if ((localObject != null) && (((com.tplink.cloud.context.b)localObject).c() != null))
      {
        localObject = ((com.tplink.cloud.context.b)localObject).c().getAccountId();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!o.h0().o0((String)localObject)))
        {
          o.h0().l1((String)localObject);
          w.G();
        }
      }
    }
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      MeViewModel.f(MeViewModel.this).postValue(paramBoolean);
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      MeViewModel.g(MeViewModel.this).postValue(paramBoolean);
    }
  }
  
  class c
    implements Observer<List<ALCameraDevice>>
  {
    c() {}
    
    public void a(@Nullable List<ALCameraDevice> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        MeViewModel.h(MeViewModel.this).postValue(Boolean.TRUE);
      } else {
        MeViewModel.h(MeViewModel.this).postValue(Boolean.FALSE);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\MeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */