package com.tplink.iot.viewmodel.home;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.core.n;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.f;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.enumerate.EnumHomeState;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomeRoomDeviceViewModel
  extends HomeBaseViewModel
{
  private MediatorLiveData<List<e>> H3 = new MediatorLiveData();
  private MediatorLiveData<List<e>> I3 = new MediatorLiveData();
  private MediatorLiveData<Boolean> J3 = new MediatorLiveData();
  private List<k> p0 = new ArrayList();
  private Map<String, com.tplink.iot.model.home.g> p1 = new LinkedHashMap();
  private List<com.tplink.iot.model.home.g> p2 = new ArrayList();
  private c p3 = null;
  private Map<String, k> z = new HashMap();
  
  public HomeRoomDeviceViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    this.I3.addSource(this.x.d(), new a());
    this.H3.addSource(this.c.C1(), new b());
    this.H3.addSource(this.q.T(), new c());
    this.x.f();
  }
  
  private List<e> E()
  {
    ArrayList localArrayList1 = new ArrayList(this.p0);
    t.e(localArrayList1);
    ArrayList localArrayList2 = new ArrayList(this.p2);
    t.f(localArrayList2);
    localArrayList2 = new ArrayList(localArrayList2);
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  private void F()
  {
    this.p0.clear();
    this.p2.clear();
    Iterator localIterator = this.z.values().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (k)localIterator.next();
      if ((localObject != null) && (((k)localObject).g() != null) && (h((k)localObject))) {
        this.p0.add(localObject);
      }
    }
    localIterator = this.p1.values().iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tplink.iot.model.home.g)localIterator.next();
      if ((localObject != null) && (((com.tplink.iot.model.home.g)localObject).h() != null) && (i((com.tplink.iot.model.home.g)localObject))) {
        this.p2.add(localObject);
      }
    }
  }
  
  private void G()
  {
    this.q.P().F0();
  }
  
  private void H()
  {
    J();
    this.p3 = this.c.p3(n.a(), j()).C(new d()).F0();
  }
  
  private void J()
  {
    c localc = this.p3;
    if ((localc != null) && (!localc.isDisposed())) {
      this.p3.dispose();
    }
  }
  
  private void K(f paramf)
  {
    if (paramf == null) {
      return;
    }
    s.c(this.z, paramf.a());
    F();
    if (paramf.b()) {
      this.I3.postValue(E());
    }
  }
  
  private void L(List<BaseALIoTDevice> paramList)
  {
    EnumHomeState localEnumHomeState = (EnumHomeState)this.c.X1().getValue();
    if ((this.z.isEmpty()) && (localEnumHomeState == EnumHomeState.ONLINE)) {
      this.x.h();
    }
    s.a(this.z, paramList);
    N();
    if (localEnumHomeState == EnumHomeState.ONLINE) {
      this.x.n(new ArrayList(this.z.values()));
    }
    k();
  }
  
  private void M(List<GroupInfo> paramList)
  {
    s.b(this.p1, paramList);
    N();
    k();
  }
  
  private void N()
  {
    Iterator localIterator = this.p1.values().iterator();
    while (localIterator.hasNext())
    {
      GroupBean localGroupBean = ((com.tplink.iot.model.home.g)localIterator.next()).h();
      if (localGroupBean != null) {
        localGroupBean.setGroupState(com.tplink.libtpnetwork.Utils.g.j(localGroupBean));
      }
    }
  }
  
  public LiveData<Boolean> A()
  {
    return this.J3;
  }
  
  public LiveData<a<BaseALIoTDevice>> B()
  {
    return this.c.T1();
  }
  
  public MediatorLiveData<List<e>> C()
  {
    return this.I3;
  }
  
  public LiveData<List<e>> D()
  {
    return this.H3;
  }
  
  public void I()
  {
    H();
    G();
    this.y.I();
  }
  
  public void k()
  {
    F();
    this.H3.postValue(E());
  }
  
  protected void l(String paramString)
  {
    this.z.remove(paramString);
  }
  
  protected void n(String paramString)
  {
    this.p1.remove(paramString);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    J();
  }
  
  protected void v()
  {
    this.x.o(new ArrayList(this.z.values()), true);
  }
  
  class a
    implements Observer<f>
  {
    a() {}
    
    public void a(@Nullable f paramf)
    {
      HomeRoomDeviceViewModel.w(HomeRoomDeviceViewModel.this, paramf);
    }
  }
  
  class b
    implements Observer<List<BaseALIoTDevice>>
  {
    b() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      HomeRoomDeviceViewModel.x(HomeRoomDeviceViewModel.this, paramList);
    }
  }
  
  class c
    implements Observer<List<GroupInfo>>
  {
    c() {}
    
    public void a(List<GroupInfo> paramList)
    {
      HomeRoomDeviceViewModel.y(HomeRoomDeviceViewModel.this, paramList);
    }
  }
  
  class d
    implements io.reactivex.g0.g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      HomeRoomDeviceViewModel.z(HomeRoomDeviceViewModel.this).postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\HomeRoomDeviceViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */