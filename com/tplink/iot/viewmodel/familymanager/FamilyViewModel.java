package com.tplink.iot.viewmodel.familymanager;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FamilyViewModel
  extends AndroidViewModel
{
  private FamilyManagerRepository a;
  private ThingCloudRepository b;
  private SingleLiveEvent<List<FamilyBean>> c = new SingleLiveEvent();
  private SingleLiveEvent<FamilyBean> d = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private SingleLiveEvent<Integer> f = new SingleLiveEvent();
  
  public FamilyViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((FamilyManagerRepository)b.a(paramApplication, FamilyManagerRepository.class));
    this.b = ((ThingCloudRepository)b.a(paramApplication, ThingCloudRepository.class));
  }
  
  private String m(ThingInfo paramThingInfo)
  {
    if (!TextUtils.isEmpty(paramThingInfo.getThingName()))
    {
      BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1(b.d.w.h.a.g(paramThingInfo.getThingName()));
      if (localBaseALIoTDevice != null) {
        return localBaseALIoTDevice.getDeviceName();
      }
    }
    return paramThingInfo.getNickname();
  }
  
  private List<DeviceBean> s(List<ThingInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ThingInfo localThingInfo = (ThingInfo)paramList.next();
        if ((localThingInfo != null) && (localThingInfo.getRole() == 0))
        {
          DeviceBean localDeviceBean = new DeviceBean();
          localDeviceBean.setDeviceId(localThingInfo.getThingName());
          localDeviceBean.setFamilyId(localThingInfo.getFamilyId());
          localDeviceBean.setRoomId(localThingInfo.getRoomId());
          localDeviceBean.setDeviceName(m(localThingInfo));
          localDeviceBean.setDeviceType(localThingInfo.getDeviceType());
          localDeviceBean.setDeviceModel(localThingInfo.getModel());
          localDeviceBean.setAvatarUrl(localThingInfo.getAvatarUrl());
          localArrayList.add(localDeviceBean);
        }
      }
    }
    return localArrayList;
  }
  
  public void k(String paramString)
  {
    this.a.P(paramString).r(io.reactivex.d0.b.a.a()).i(new f()).j(new e()).y();
  }
  
  public LiveData<Boolean> l()
  {
    return this.e;
  }
  
  public void n()
  {
    q.f1(this.a.U(), this.b.S(), new b()).C(new a()).l0(io.reactivex.d0.b.a.a()).F0();
  }
  
  public LiveData<List<FamilyBean>> o()
  {
    return this.c;
  }
  
  public LiveData<Integer> p()
  {
    return this.f;
  }
  
  public LiveData<FamilyBean> r()
  {
    return this.d;
  }
  
  public void t(String paramString1, String paramString2, final boolean paramBoolean)
  {
    this.a.h1(paramString1, paramString2, paramBoolean).l0(io.reactivex.d0.b.a.a()).E(new d(paramBoolean)).C(new c()).F0();
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      FamilyViewModel.f(FamilyViewModel.this).postValue(null);
    }
  }
  
  class b
    implements c<List<FamilyInfo>, List<ThingInfo>, List<FamilyBean>>
  {
    b() {}
    
    public List<FamilyBean> a(List<FamilyInfo> paramList, List<ThingInfo> paramList1)
      throws Exception
    {
      ArrayList localArrayList1 = new ArrayList(FamilyViewModel.g(FamilyViewModel.this, paramList1));
      paramList1 = new ArrayList();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (FamilyInfo)localIterator.next();
        paramList = new FamilyBean();
        paramList.setFamilyId(((FamilyInfo)localObject1).getId());
        paramList.setFamilyName(((FamilyInfo)localObject1).getName());
        paramList.setIsDefault(((FamilyInfo)localObject1).isDefault());
        ArrayList localArrayList2 = new ArrayList();
        Object localObject2 = new ArrayList();
        Object localObject3 = localArrayList1.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (DeviceBean)((Iterator)localObject3).next();
          if (((DeviceBean)localObject4).getFamilyId().equals(((FamilyInfo)localObject1).getId())) {
            ((List)localObject2).add(localObject4);
          }
        }
        localArrayList2.addAll((Collection)localObject2);
        Object localObject4 = ((FamilyInfo)localObject1).getRooms();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject4).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RoomInfo localRoomInfo = (RoomInfo)((Iterator)localObject2).next();
          RoomBean localRoomBean = new RoomBean();
          localRoomBean.setRoomId(localRoomInfo.getId());
          localRoomBean.setRoomName(localRoomInfo.getName());
          localRoomBean.setAvatarUrl(localRoomInfo.getAvatarUrl());
          ArrayList localArrayList3 = new ArrayList();
          localObject4 = localArrayList1.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject3 = (DeviceBean)((Iterator)localObject4).next();
            if (((DeviceBean)localObject3).getRoomId().equals(localRoomInfo.getId()))
            {
              ((DeviceBean)localObject3).setRoomName(localRoomInfo.getName());
              localArrayList3.add(localObject3);
            }
          }
          localRoomBean.setDeviceList(localArrayList3);
          ((List)localObject1).add(localRoomBean);
        }
        paramList.setRoomList((List)localObject1);
        paramList.setDeviceCount(localArrayList2.size());
        paramList1.add(paramList);
        localHashMap.put(paramList, localArrayList2);
      }
      paramList = FamilyDataManager.INSTANCE;
      paramList.setFamilyDeviceMap(localHashMap);
      paramList.setFamilyList(paramList1);
      if (((paramList1.size() == 1) || (paramList.getCurFamily() == null)) && (paramList1.size() != 0)) {
        paramList.updateCurFamilybean((FamilyBean)paramList1.get(0));
      }
      FamilyViewModel.f(FamilyViewModel.this).postValue(paramList1);
      return paramList1;
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
    {
      if (((paramThrowable instanceof IoTCloudException)) && (((IoTCloudException)paramThrowable).getCode() == 15008)) {
        FamilyViewModel.h(FamilyViewModel.this).postValue(Integer.valueOf(15008));
      } else {
        FamilyViewModel.i(FamilyViewModel.this).postValue(null);
      }
    }
  }
  
  class d
    implements g<FamilyBean>
  {
    d(boolean paramBoolean) {}
    
    public void a(FamilyBean paramFamilyBean)
      throws Exception
    {
      FamilyDataManager localFamilyDataManager;
      if (paramBoolean)
      {
        localFamilyDataManager = FamilyDataManager.INSTANCE;
        localFamilyDataManager.addFamilyBean(paramFamilyBean);
        localFamilyDataManager.updateCurFamilybean(paramFamilyBean);
      }
      else
      {
        localFamilyDataManager = FamilyDataManager.INSTANCE;
        FamilyBean localFamilyBean = localFamilyDataManager.getCurFamily();
        localFamilyBean.setFamilyName(paramFamilyBean.getFamilyName());
        localFamilyDataManager.updateCurFamilybean(localFamilyBean);
      }
      FamilyViewModel.i(FamilyViewModel.this).postValue(paramFamilyBean);
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
    {
      FamilyViewModel.j(FamilyViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f() {}
    
    public void run()
    {
      FamilyViewModel.j(FamilyViewModel.this).postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\familymanager\FamilyViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */