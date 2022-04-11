package com.tplink.iot.viewmodel.familymanager;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoomViewModel
  extends AndroidViewModel
{
  private FamilyManagerRepository a;
  private GroupRepository b;
  private SingleLiveEvent<Boolean> c = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> d = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private SingleLiveEvent<RoomBean> f = new SingleLiveEvent();
  private SingleLiveEvent<Integer> g = new SingleLiveEvent();
  private MediatorLiveData<List<BaseALIoTDevice>> h = new MediatorLiveData();
  
  public RoomViewModel(Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((FamilyManagerRepository)b.a(paramApplication, FamilyManagerRepository.class));
    this.b = ((GroupRepository)b.a(paramApplication, GroupRepository.class));
    paramApplication = (TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class);
    this.h.addSource(paramApplication.C1(), new a(this));
  }
  
  private Map<String, com.tplink.iot.j.a.a> o(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = FamilyDataManager.INSTANCE;
    Object localObject2 = ((FamilyDataManager)localObject1).getCurRoombean();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((RoomBean)localObject2).getRoomId();
    if (localObject2 == null) {
      return null;
    }
    Map localMap = ((FamilyDataManager)localObject1).getFamilyDeviceMap();
    if (localMap == null) {
      return null;
    }
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      FamilyBean localFamilyBean = (FamilyBean)localIterator.next();
      localObject1 = (List)localMap.get(localFamilyBean);
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        ArrayList localArrayList = new ArrayList((Collection)localObject1);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DeviceBean localDeviceBean = (DeviceBean)((Iterator)localObject1).next();
          if (((String)localObject2).equals(localDeviceBean.getRoomId())) {
            localArrayList.remove(localDeviceBean);
          }
        }
        if (localArrayList.size() > 0)
        {
          if ((localFamilyBean.getDefault()) && (TextUtils.isEmpty(localFamilyBean.getFamilyName()))) {
            localObject1 = paramString;
          } else {
            localObject1 = localFamilyBean.getFamilyName();
          }
          localHashMap.put(localObject1, new com.tplink.iot.j.a.a(localArrayList, this.b.U(localFamilyBean.getFamilyId(), (String)localObject2)));
        }
      }
    }
    return localHashMap;
  }
  
  private Map<String, List<BaseALIoTDevice>> p(List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = FamilyDataManager.INSTANCE.getFamilyList().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FamilyBean)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((FamilyBean)localObject2).getFamilyId() != null)) {
          localArrayList.add(((FamilyBean)localObject2).getFamilyId());
        }
      }
      localObject1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (BaseALIoTDevice)paramList.next();
        if ((localObject2 != null) && (!((BaseALIoTDevice)localObject2).isUserRoleTypeDevice()) && ((TextUtils.isEmpty(((BaseALIoTDevice)localObject2).getFamilyId())) || (!localArrayList.contains(((BaseALIoTDevice)localObject2).getFamilyId())))) {
          ((List)localObject1).add(localObject2);
        }
      }
      if (((List)localObject1).isEmpty()) {
        return null;
      }
      paramList = new HashMap();
      paramList.put(getApplication().getString(2131953954), localObject1);
      return paramList;
    }
    return null;
  }
  
  @SuppressLint({"CheckResult"})
  public void A(String paramString1, String paramString2, List<String> paramList)
  {
    this.b.A0(paramList, paramString1, paramString2).r(io.reactivex.d0.b.a.a()).y();
  }
  
  @SuppressLint({"CheckResult"})
  public void B(String paramString1, String paramString2)
  {
    this.b.E0(paramString1, paramString2).A(new h(), new i());
  }
  
  public void C(String paramString1, String paramString2, String paramString3, final boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString3 == null)) {
      this.f.postValue(null);
    }
    this.a.n1(paramString1, paramString2, paramString3, paramBoolean).l0(io.reactivex.d0.b.a.a()).E(new c(paramBoolean)).C(new b()).F0();
  }
  
  public void k(List<BaseALIoTDevice> paramList, Map<String, com.tplink.iot.j.a.a> paramMap, Map<String, List<BaseALIoTDevice>> paramMap1)
  {
    if (paramMap != null) {
      paramMap.clear();
    } else {
      paramMap = new HashMap();
    }
    if (paramMap1 != null) {
      paramMap1.clear();
    } else {
      paramMap1 = new HashMap();
    }
    Map localMap = o(getApplication().getResources().getString(2131952817));
    if (localMap != null) {
      paramMap.putAll(localMap);
    }
    paramList = p(paramList);
    if (paramList != null) {
      paramMap1.putAll(paramList);
    }
  }
  
  public void l(String paramString1, final String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.a.R(paramString1, paramString2).r(io.reactivex.d0.b.a.a()).i(new e(paramString2)).j(new d()).y();
      return;
    }
    this.c.postValue(Boolean.FALSE);
  }
  
  public MutableLiveData<List<BaseALIoTDevice>> m()
  {
    return this.h;
  }
  
  public LiveData<Boolean> n()
  {
    return this.c;
  }
  
  public List<GroupInfo> r(String paramString)
  {
    return this.b.W(paramString);
  }
  
  public LiveData<Boolean> s()
  {
    return this.d;
  }
  
  public LiveData<Integer> t()
  {
    return this.g;
  }
  
  public SingleLiveEvent<Boolean> u()
  {
    return this.e;
  }
  
  public LiveData<RoomBean> v()
  {
    return this.f;
  }
  
  public void y(String paramString1, final String paramString2, final List<DeviceBean> paramList)
  {
    this.a.d1(paramString1, paramString2, paramList).r(io.reactivex.d0.b.a.a()).i(new g(paramString2, paramList)).j(new f()).y();
  }
  
  @SuppressLint({"CheckResult"})
  public void z(String paramString1, String paramString2, List<String> paramList)
  {
    this.b.A0(paramList, paramString1, paramString2).r(io.reactivex.d0.b.a.a()).A(new j(), new a());
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      RoomViewModel.i(RoomViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
    {
      if (((paramThrowable instanceof IoTCloudException)) && (((IoTCloudException)paramThrowable).getCode() == 15009)) {
        RoomViewModel.f(RoomViewModel.this).postValue(Integer.valueOf(15009));
      } else {
        RoomViewModel.g(RoomViewModel.this).postValue(null);
      }
    }
  }
  
  class c
    implements g<RoomBean>
  {
    c(boolean paramBoolean) {}
    
    public void a(RoomBean paramRoomBean)
      throws Exception
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = FamilyDataManager.INSTANCE;
        ((FamilyDataManager)localObject).addRoom(paramRoomBean);
        ((FamilyDataManager)localObject).updateCurRoomBean(paramRoomBean);
      }
      else
      {
        FamilyDataManager localFamilyDataManager = FamilyDataManager.INSTANCE;
        localObject = localFamilyDataManager.getCurRoombean();
        ((RoomBean)localObject).setRoomName(paramRoomBean.getRoomName());
        localFamilyDataManager.updateCurRoomBean((RoomBean)localObject);
      }
      RoomViewModel.g(RoomViewModel.this).postValue(paramRoomBean);
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
    {
      RoomViewModel.h(RoomViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e(String paramString) {}
    
    public void run()
    {
      FamilyDataManager.INSTANCE.deleteRoomById(paramString2);
      RoomViewModel.h(RoomViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class f
    implements g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
    {
      RoomViewModel.i(RoomViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class g
    implements io.reactivex.g0.a
  {
    g(String paramString, List paramList) {}
    
    public void run()
    {
      if ((paramString2.isEmpty()) && (paramList.size() == 1)) {
        FamilyDataManager.INSTANCE.deleteCurRoomBeanDevice(((DeviceBean)paramList.get(0)).getDeviceId());
      } else {
        FamilyDataManager.INSTANCE.moveDevicesToTargetRoom(paramList);
      }
      RoomViewModel.i(RoomViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class h
    implements io.reactivex.g0.a
  {
    h() {}
    
    public void run()
      throws Exception
    {
      RoomViewModel.j(RoomViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class i
    implements g<Throwable>
  {
    i() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      RoomViewModel.j(RoomViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class j
    implements io.reactivex.g0.a
  {
    j() {}
    
    public void run()
      throws Exception
    {
      RoomViewModel.i(RoomViewModel.this).postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\familymanager\RoomViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */