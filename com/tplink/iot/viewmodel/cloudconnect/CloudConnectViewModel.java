package com.tplink.iot.viewmodel.cloudconnect;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStatus;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;

public class CloudConnectViewModel
  extends AndroidViewModel
{
  private AbstractThingRepository a;
  @Nullable
  private BaseALIoTDevice b;
  private MutableLiveData<i<CloudConnectStateResult>> c = new MutableLiveData();
  private MutableLiveData<CloudConnectStatus> d = new MutableLiveData();
  private MutableLiveData<CloudConnectStatus> e = new MutableLiveData();
  private c f;
  private c g;
  
  public CloudConnectViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = paramThingContext.getIoTDevice();
    this.b = paramApplication;
    if ((paramApplication != null) && (paramApplication.isBulb()))
    {
      if (this.b.isLightStrip()) {
        this.a = ((AbstractThingRepository)e.a(paramThingContext, LightStripRepository.class));
      } else {
        this.a = ((AbstractThingRepository)e.a(paramThingContext, BulbRepository.class));
      }
    }
    else {
      this.a = ((AbstractThingRepository)e.a(paramThingContext, PlugRepository.class));
    }
  }
  
  @Nullable
  public BaseALIoTDevice i()
  {
    return this.b;
  }
  
  public LiveData<i<CloudConnectStateResult>> j()
  {
    return this.c;
  }
  
  public void k()
  {
    this.a.b1().E(new d()).C(new c()).F0();
  }
  
  public void l()
  {
    this.g = this.a.e1().E(new f()).C(new e()).F0();
  }
  
  public LiveData<CloudConnectStatus> m()
  {
    return this.e;
  }
  
  public LiveData<CloudConnectStatus> n()
  {
    return this.d;
  }
  
  public void o()
  {
    this.f = this.a.T4().E(new b()).C(new a()).F0();
  }
  
  public void p()
  {
    c localc = this.g;
    if (localc != null)
    {
      localc.dispose();
      this.g = null;
    }
  }
  
  public void r()
  {
    c localc = this.f;
    if (localc != null)
    {
      localc.dispose();
      this.f = null;
    }
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      CloudConnectViewModel.f(CloudConnectViewModel.this).postValue(new CloudConnectStatus(1, null));
    }
  }
  
  class b
    implements g<CloudConnectStatus>
  {
    b() {}
    
    public void a(CloudConnectStatus paramCloudConnectStatus)
      throws Exception
    {
      CloudConnectViewModel.f(CloudConnectViewModel.this).postValue(paramCloudConnectStatus);
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      CloudConnectViewModel.g(CloudConnectViewModel.this).postValue(new i(1, null));
    }
  }
  
  class d
    implements g<CloudConnectStateResult>
  {
    d() {}
    
    public void a(CloudConnectStateResult paramCloudConnectStateResult)
      throws Exception
    {
      CloudConnectViewModel.g(CloudConnectViewModel.this).postValue(new i(0, paramCloudConnectStateResult));
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      CloudConnectViewModel.h(CloudConnectViewModel.this).postValue(new CloudConnectStatus(1, null));
    }
  }
  
  class f
    implements g<CloudConnectStatus>
  {
    f() {}
    
    public void a(CloudConnectStatus paramCloudConnectStatus)
      throws Exception
    {
      CloudConnectViewModel.h(CloudConnectViewModel.this).postValue(paramCloudConnectStatus);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\cloudconnect\CloudConnectViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */