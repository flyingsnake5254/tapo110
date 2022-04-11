package com.tplink.iot.viewmodel.iotbulb;

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
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.x0.o;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BulbSettingViewModel
  extends AndroidViewModel
{
  private BulbRepository a;
  private TPIoTClientManager b;
  private GroupRepository c;
  private FamilyManagerRepository d;
  private MediatorLiveData<BaseALIoTDevice> e = new MediatorLiveData();
  private MediatorLiveData<IoTBulbDevice> f = new MediatorLiveData();
  private MutableLiveData<i<CloudResult<Void>>> g = new MutableLiveData();
  private MutableLiveData<i<Void>> h = new MutableLiveData();
  private SingleLiveEvent<Boolean> i = new SingleLiveEvent();
  private MediatorLiveData<i<RoomBean>> j = new MediatorLiveData();
  private MediatorLiveData<List<GroupInfo>> k = new MediatorLiveData();
  
  public BulbSettingViewModel(@NonNull Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((BulbRepository)e.a(paramThingContext, BulbRepository.class));
    this.b = ((TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class));
    this.d = ((FamilyManagerRepository)b.a(paramThingContext.getAccountContext(), FamilyManagerRepository.class));
    this.c = ((GroupRepository)b.a(paramThingContext.getAccountContext(), GroupRepository.class));
    this.e.addSource(this.b.C1(), new a(paramThingContext));
    this.f.addSource(this.a.r5(), new b());
    this.k.addSource(this.c.T(), new c());
  }
  
  private BaseALIoTDevice m(String paramString, List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
        if (localBaseALIoTDevice.getDeviceIdMD5().equals(paramString)) {
          return localBaseALIoTDevice;
        }
      }
    }
    return null;
  }
  
  public void A()
  {
    this.a.p5().F0();
  }
  
  public LiveData<i<Void>> B()
  {
    return this.h;
  }
  
  public void C(List<Integer> paramList)
  {
    this.a.Y5(paramList).y();
  }
  
  public void D(DefaultStatesBean paramDefaultStatesBean)
  {
    this.a.Z5(paramDefaultStatesBean).y();
  }
  
  public void E(boolean paramBoolean)
  {
    this.a.c6(new OnOffGraduallyBean(paramBoolean)).F0();
  }
  
  public void F(String paramString)
  {
    o.u((BaseALIoTDevice)this.e.getValue());
    this.b.n1(paramString).L0(io.reactivex.l0.a.c()).E(new e()).C(new d()).F0();
  }
  
  public void f(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    this.b.w(localArrayList).i(new g()).j(new f()).y();
  }
  
  public LiveData<i<CloudResult<Void>>> n()
  {
    return this.g;
  }
  
  public LiveData<BaseALIoTDevice> o()
  {
    return this.e;
  }
  
  public LiveData<List<Integer>> p()
  {
    return this.a.o5();
  }
  
  public LiveData<IoTBulbDevice> r()
  {
    return this.f;
  }
  
  public int s(List<GroupInfo> paramList, String paramString)
  {
    boolean bool = paramList.isEmpty();
    int m = 0;
    int n = 0;
    int i1 = m;
    if (!bool) {
      if (TextUtils.isEmpty(paramString))
      {
        i1 = m;
      }
      else
      {
        paramString = this.b.Z1(paramString);
        if (paramString == null) {
          return 0;
        }
        paramString = paramString.getDeviceId();
        if (TextUtils.isEmpty(paramString)) {
          return 0;
        }
        paramList = paramList.iterator();
        for (;;)
        {
          i1 = n;
          if (!paramList.hasNext()) {
            break;
          }
          List localList = ((GroupInfo)paramList.next()).getThingNames();
          if ((localList != null) && (!localList.isEmpty()) && (localList.contains(paramString))) {
            n++;
          }
        }
      }
    }
    return i1;
  }
  
  public String t()
  {
    if ((this.a.b() != null) && (((ThingContext)this.a.b()).getIoTDevice() != null)) {
      return ((ALIoTDevice)((ThingContext)this.a.b()).getIoTDevice()).getDeviceName();
    }
    return "";
  }
  
  public void u()
  {
    this.a.p1().F0();
  }
  
  public void v()
  {
    this.a.v1().F0();
  }
  
  public LiveData<ThingFirmware> w()
  {
    return this.a.w1();
  }
  
  public MediatorLiveData<List<GroupInfo>> x()
  {
    return this.k;
  }
  
  public void y()
  {
    this.a.x5().F0();
  }
  
  public LiveData<OnOffGraduallyBean> z()
  {
    return this.a.y5();
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a(ThingContext paramThingContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      BulbSettingViewModel.h(BulbSettingViewModel.this).postValue(BulbSettingViewModel.g(BulbSettingViewModel.this, paramThingContext.getDeviceIdMD5(), paramList));
    }
  }
  
  class b
    implements Observer<IoTBulbDevice>
  {
    b() {}
    
    public void a(@Nullable IoTBulbDevice paramIoTBulbDevice)
    {
      BulbSettingViewModel.i(BulbSettingViewModel.this).postValue(paramIoTBulbDevice);
    }
  }
  
  class c
    implements Observer<List<GroupInfo>>
  {
    c() {}
    
    public void a(@Nullable List<GroupInfo> paramList)
    {
      BulbSettingViewModel.j(BulbSettingViewModel.this).postValue(paramList);
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        BulbSettingViewModel.k(BulbSettingViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      BulbSettingViewModel.k(BulbSettingViewModel.this).postValue(new i(1, null));
    }
  }
  
  class e
    implements g<Boolean>
  {
    e() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      BulbSettingViewModel.k(BulbSettingViewModel.this).postValue(new i(0, null));
    }
  }
  
  class f
    implements g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        BulbSettingViewModel.l(BulbSettingViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      BulbSettingViewModel.l(BulbSettingViewModel.this).postValue(new i(1, null));
    }
  }
  
  class g
    implements io.reactivex.g0.a
  {
    g() {}
    
    public void run()
      throws Exception
    {
      BulbSettingViewModel.l(BulbSettingViewModel.this).postValue(new i(0, null));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotbulb\BulbSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */