package com.tplink.iot.viewmodel.cloudvideo;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideoDevice;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoDevicesResult;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;

public final class CloudVideoDeviceListViewModel
  extends ViewModel
{
  private CloudVideoRepository a;
  private int b;
  private int c;
  private int d;
  private final MutableLiveData<List<CloudVideoDevice>> e = new MutableLiveData();
  private final MutableLiveData<Boolean> f = new MutableLiveData();
  private final MutableLiveData<Boolean> g = new MutableLiveData();
  private final MediatorLiveData<Boolean> h;
  private volatile boolean i;
  
  public CloudVideoDeviceListViewModel()
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    this.h = localMediatorLiveData;
    Object localObject = b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
    kotlin.jvm.internal.j.d(localObject, "CloudRepositoryProviders…eoRepository::class.java)");
    localObject = (CloudVideoRepository)localObject;
    this.a = ((CloudVideoRepository)localObject);
    localMediatorLiveData.addSource(((CloudVideoRepository)localObject).c0(), new a(this));
  }
  
  public final MutableLiveData<List<CloudVideoDevice>> n()
  {
    return this.e;
  }
  
  public final void o()
  {
    this.a.T(this.c, 20).g0(new b(this)).E(new c(this)).z(new d(this)).F(new e(this)).y(new f(this)).C(new g(this)).F0();
  }
  
  public final MutableLiveData<Boolean> p()
  {
    return this.f;
  }
  
  public final MutableLiveData<Boolean> r()
  {
    return this.g;
  }
  
  public final MediatorLiveData<Boolean> s()
  {
    return this.h;
  }
  
  public final void t()
  {
    this.a.d0().l0(io.reactivex.d0.b.a.a()).F0();
  }
  
  static final class a<T>
    implements Observer<List<OrderInfo>>
  {
    a(CloudVideoDeviceListViewModel paramCloudVideoDeviceListViewModel) {}
    
    public final void a(List<OrderInfo> paramList)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = bool1;
      if (paramList != null)
      {
        bool3 = bool1;
        if (paramList.size() > 0)
        {
          Iterator localIterator = paramList.iterator();
          for (;;)
          {
            bool3 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            paramList = (OrderInfo)localIterator.next();
            if ((paramList != null) && (paramList.getTrial() == 0) && (kotlin.jvm.internal.j.a("active", paramList.getStatus()))) {
              bool2 = true;
            }
          }
        }
      }
      this.a.s().postValue(Boolean.valueOf(bool3));
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<CloudVideoDevicesResult, List<CloudVideoDevice>>
  {
    b(CloudVideoDeviceListViewModel paramCloudVideoDeviceListViewModel) {}
    
    public final List<CloudVideoDevice> a(CloudVideoDevicesResult paramCloudVideoDevicesResult)
    {
      kotlin.jvm.internal.j.e(paramCloudVideoDevicesResult, "it");
      CloudVideoDeviceListViewModel localCloudVideoDeviceListViewModel = this.c;
      CloudVideoDeviceListViewModel.j(localCloudVideoDeviceListViewModel, CloudVideoDeviceListViewModel.f(localCloudVideoDeviceListViewModel) + paramCloudVideoDevicesResult.getDeviceList().size());
      CloudVideoDeviceListViewModel.k(this.c, paramCloudVideoDevicesResult.getTotal());
      return paramCloudVideoDevicesResult.getDeviceList();
    }
  }
  
  static final class c<T>
    implements g<List<CloudVideoDevice>>
  {
    c(CloudVideoDeviceListViewModel paramCloudVideoDeviceListViewModel) {}
    
    public final void a(List<CloudVideoDevice> paramList)
    {
      CloudVideoDeviceListViewModel localCloudVideoDeviceListViewModel = this.c;
      CloudVideoDeviceListViewModel.l(localCloudVideoDeviceListViewModel, CloudVideoDeviceListViewModel.h(localCloudVideoDeviceListViewModel) + 1);
      this.c.n().postValue(paramList);
    }
  }
  
  static final class d
    implements io.reactivex.g0.a
  {
    d(CloudVideoDeviceListViewModel paramCloudVideoDeviceListViewModel) {}
    
    public final void run()
    {
      if (CloudVideoDeviceListViewModel.f(this.a) < CloudVideoDeviceListViewModel.g(this.a)) {
        this.a.o();
      }
    }
  }
  
  static final class e<T>
    implements g<c>
  {
    e(CloudVideoDeviceListViewModel paramCloudVideoDeviceListViewModel) {}
    
    public final void a(c paramc)
    {
      if (!CloudVideoDeviceListViewModel.i(this.c))
      {
        this.c.r().postValue(Boolean.TRUE);
        CloudVideoDeviceListViewModel.m(this.c, true);
      }
    }
  }
  
  static final class f
    implements io.reactivex.g0.a
  {
    f(CloudVideoDeviceListViewModel paramCloudVideoDeviceListViewModel) {}
    
    public final void run()
    {
      this.a.r().postValue(Boolean.FALSE);
    }
  }
  
  static final class g<T>
    implements g<Throwable>
  {
    g(CloudVideoDeviceListViewModel paramCloudVideoDeviceListViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.p().postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\cloudvideo\CloudVideoDeviceListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */