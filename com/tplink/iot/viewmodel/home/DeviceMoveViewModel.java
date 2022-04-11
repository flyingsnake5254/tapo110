package com.tplink.iot.viewmodel.home;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceMoveViewModel
  extends AndroidViewModel
{
  private FamilyManagerRepository a;
  private ThingCloudRepository b;
  private GroupRepository c;
  private MediatorLiveData<Boolean> d = new MediatorLiveData();
  private List<com.tplink.iot.model.home.b> e;
  
  public DeviceMoveViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((FamilyManagerRepository)b.d.b.f.b.a(paramApplication, FamilyManagerRepository.class));
    this.b = ((ThingCloudRepository)b.d.b.f.b.a(paramApplication, ThingCloudRepository.class));
    this.c = ((GroupRepository)b.d.b.f.b.a(paramApplication, GroupRepository.class));
    l();
  }
  
  private List<com.tplink.iot.model.home.b> g(List<FamilyInfo> paramList, List<ThingDevice> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FamilyInfo localFamilyInfo = (FamilyInfo)paramList.next();
      com.tplink.iot.model.home.b localb = new com.tplink.iot.model.home.b();
      localb.e(localFamilyInfo.getId());
      localb.f(localFamilyInfo.getName());
      localb.g(localFamilyInfo.isDefault());
      localb.h(i(localFamilyInfo, paramList1));
      localArrayList.add(localb);
    }
    return localArrayList;
  }
  
  private List<com.tplink.iot.model.home.c> i(FamilyInfo paramFamilyInfo, List<ThingDevice> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramFamilyInfo.getRooms().iterator();
    while (localIterator.hasNext())
    {
      RoomInfo localRoomInfo = (RoomInfo)localIterator.next();
      com.tplink.iot.model.home.c localc = new com.tplink.iot.model.home.c();
      localc.f(localRoomInfo.getId());
      localc.g(localRoomInfo.getName());
      localc.d(localRoomInfo.getAvatarUrl());
      localc.e(j(paramFamilyInfo, localRoomInfo, paramList));
      localArrayList.add(localc);
    }
    return localArrayList;
  }
  
  private int j(FamilyInfo paramFamilyInfo, RoomInfo paramRoomInfo, List<ThingDevice> paramList)
  {
    int i = 0;
    int j = 0;
    int k = i;
    if (paramList != null)
    {
      k = i;
      if (!TextUtils.isEmpty(paramFamilyInfo.getId()))
      {
        k = i;
        if (!TextUtils.isEmpty(paramRoomInfo.getId()))
        {
          Iterator localIterator = paramList.iterator();
          for (;;)
          {
            k = j;
            if (!localIterator.hasNext()) {
              break;
            }
            paramList = (ThingDevice)localIterator.next();
            if ((paramFamilyInfo.getId().equals(paramList.getFamilyId())) && (paramRoomInfo.getId().equals(paramList.getRoomId()))) {
              j++;
            }
          }
        }
      }
    }
    return k;
  }
  
  private void l()
  {
    this.e = g(this.a.T(), this.b.R());
  }
  
  public List<com.tplink.iot.model.home.b> f()
  {
    return this.e;
  }
  
  public com.tplink.iot.model.home.b h(String paramString)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      com.tplink.iot.model.home.b localb = (com.tplink.iot.model.home.b)localIterator.next();
      if (localb.b().equals(paramString)) {
        return localb;
      }
    }
    return new com.tplink.iot.model.home.b();
  }
  
  public MediatorLiveData<Boolean> k()
  {
    return this.d;
  }
  
  public boolean m()
  {
    return this.a.l0() ^ true;
  }
  
  public void w(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((paramList2 == null) || (paramList2.isEmpty())) {
      bool1 = false;
    }
    q.f0(Boolean.valueOf(bool2)).R(new a(this, paramString1, paramString2, paramList1)).c(q.f0(Boolean.valueOf(bool1)).R(new b(this, paramList2, paramString1, paramString2))).C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a()).i(new d(this)).j(new c(this)).y();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\DeviceMoveViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */