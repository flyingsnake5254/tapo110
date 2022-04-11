package com.tplink.iot.viewmodel.home;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomNavigationViewModel
  extends AndroidViewModel
{
  private FamilyManagerRepository a;
  private List<ThingDevice> b = new ArrayList();
  private FamilyInfo c;
  private MediatorLiveData<Boolean> d = new MediatorLiveData();
  private MediatorLiveData<List<com.tplink.iot.model.home.a>> e = new MediatorLiveData();
  
  public RoomNavigationViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.b.f.b.c(b.d.s.a.a.f());
    this.a = ((FamilyManagerRepository)paramApplication.a(FamilyManagerRepository.class));
    paramApplication = (ThingCloudRepository)paramApplication.a(ThingCloudRepository.class);
    this.c = this.a.X();
    this.e.addSource(paramApplication.g0(), new a());
  }
  
  private void k()
  {
    Object localObject1 = this.c;
    if ((localObject1 != null) && (((FamilyInfo)localObject1).getId() != null) && (this.c.getRooms() != null) && (!this.c.getRooms().isEmpty()))
    {
      Object localObject2 = this.c.getId();
      localObject1 = new ArrayList();
      Iterator localIterator = this.b.iterator();
      Object localObject3;
      while (localIterator.hasNext())
      {
        localObject3 = (ThingDevice)localIterator.next();
        if (((String)localObject2).equals(((ThingDevice)localObject3).getFamilyId())) {
          ((List)localObject1).add(localObject3);
        }
      }
      ArrayList localArrayList = new ArrayList();
      localIterator = this.c.getRooms().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (RoomInfo)localIterator.next();
        String str = ((RoomInfo)localObject2).getId();
        int i = 0;
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ThingDevice localThingDevice = (ThingDevice)((Iterator)localObject3).next();
          if ((str != null) && (str.equals(localThingDevice.getRoomId()))) {
            i++;
          }
        }
        localArrayList.add(new com.tplink.iot.model.home.a(((RoomInfo)localObject2).getId(), ((RoomInfo)localObject2).getName(), i));
      }
      this.e.postValue(localArrayList);
      return;
    }
    this.e.postValue(new ArrayList());
  }
  
  public MediatorLiveData<List<com.tplink.iot.model.home.a>> i()
  {
    return this.e;
  }
  
  public MediatorLiveData<Boolean> j()
  {
    return this.d;
  }
  
  @SuppressLint({"CheckResult"})
  public void l(List<String> paramList)
  {
    Object localObject = this.c;
    if ((localObject != null) && (!TextUtils.isEmpty(((FamilyInfo)localObject).getId())))
    {
      localObject = this.c.getId();
      this.a.p1((String)localObject, paramList).A(new b(), new c());
      return;
    }
    this.d.postValue(Boolean.FALSE);
  }
  
  protected void onCleared()
  {
    super.onCleared();
  }
  
  class a
    implements Observer<List<ThingDevice>>
  {
    a() {}
    
    public void a(@Nullable List<ThingDevice> paramList)
    {
      RoomNavigationViewModel.f(RoomNavigationViewModel.this).clear();
      if ((paramList != null) && (!paramList.isEmpty())) {
        RoomNavigationViewModel.f(RoomNavigationViewModel.this).addAll(paramList);
      }
      RoomNavigationViewModel.g(RoomNavigationViewModel.this);
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      RoomNavigationViewModel.h(RoomNavigationViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      RoomNavigationViewModel.h(RoomNavigationViewModel.this).postValue(Boolean.FALSE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\RoomNavigationViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */