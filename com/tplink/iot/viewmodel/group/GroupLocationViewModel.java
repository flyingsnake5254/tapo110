package com.tplink.iot.viewmodel.group;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;

public class GroupLocationViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private GroupRepository b;
  private FamilyManagerRepository c;
  private SingleLiveEvent<Boolean> d = new SingleLiveEvent();
  private MediatorLiveData<i<RoomBean>> e = new MediatorLiveData();
  
  public GroupLocationViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class));
    this.b = ((GroupRepository)b.a(paramApplication, GroupRepository.class));
    this.c = ((FamilyManagerRepository)b.a(paramApplication, FamilyManagerRepository.class));
  }
  
  public void h(String paramString)
  {
    String str;
    if (this.a.Q1() != null) {
      str = this.a.Q1().getId();
    } else {
      str = null;
    }
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {
      this.e.postValue(new i(1, null));
    }
    this.c.n1(str, null, paramString, true).E(new b()).C(new a()).F0();
  }
  
  public LiveData<i<RoomBean>> i()
  {
    return this.e;
  }
  
  public List<RoomInfo> j()
  {
    List localList;
    if (this.a.Q1() != null) {
      localList = this.a.Q1().getRooms();
    } else {
      localList = null;
    }
    return localList;
  }
  
  public String k(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    Object localObject = null;
    GroupInfo localGroupInfo = this.b.R(paramString);
    paramString = (String)localObject;
    if (localGroupInfo != null) {
      paramString = localGroupInfo.getRoomId();
    }
    if (paramString == null) {
      paramString = str;
    }
    return paramString;
  }
  
  public String l(String paramString)
  {
    Object localObject = j();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RoomInfo localRoomInfo = (RoomInfo)((Iterator)localObject).next();
        if (TextUtils.equals(localRoomInfo.getName(), paramString)) {
          return localRoomInfo.getId();
        }
      }
    }
    return null;
  }
  
  public LiveData<Boolean> m()
  {
    return this.d;
  }
  
  public void n(String paramString1, String paramString2)
  {
    String str;
    if (this.a.Q1() != null) {
      str = this.a.Q1().getId();
    } else {
      str = null;
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = l(paramString2);
      this.b.E0(paramString1, paramString2).i(new d()).j(new c()).y();
      return;
    }
    this.d.postValue(Boolean.FALSE);
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (((paramThrowable instanceof IoTCloudException)) && (((IoTCloudException)paramThrowable).getCode() == 15009)) {
        GroupLocationViewModel.f(GroupLocationViewModel.this).postValue(new i(15009, null));
      } else {
        GroupLocationViewModel.f(GroupLocationViewModel.this).postValue(new i(1, null));
      }
    }
  }
  
  class b
    implements g<RoomBean>
  {
    b() {}
    
    public void a(RoomBean paramRoomBean)
      throws Exception
    {
      GroupLocationViewModel.f(GroupLocationViewModel.this).postValue(new i(0, paramRoomBean));
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      GroupLocationViewModel.g(GroupLocationViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d() {}
    
    public void run()
      throws Exception
    {
      GroupLocationViewModel.g(GroupLocationViewModel.this).postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\group\GroupLocationViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */