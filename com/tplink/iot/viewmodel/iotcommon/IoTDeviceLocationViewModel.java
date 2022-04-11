package com.tplink.iot.viewmodel.iotcommon;

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
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;

public class IoTDeviceLocationViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private FamilyManagerRepository b;
  private MediatorLiveData<BaseALIoTDevice> c = new MediatorLiveData();
  private SingleLiveEvent<Boolean> d = new SingleLiveEvent();
  private MediatorLiveData<i<RoomBean>> e = new MediatorLiveData();
  private TPBaseDeviceContext f;
  
  public IoTDeviceLocationViewModel(@NonNull Application paramApplication, final TPBaseDeviceContext paramTPBaseDeviceContext)
  {
    super(paramApplication);
    this.f = paramTPBaseDeviceContext;
    this.a = ((TPIoTClientManager)b.a(paramTPBaseDeviceContext.getAccountContext(), TPIoTClientManager.class));
    this.b = ((FamilyManagerRepository)b.a(paramTPBaseDeviceContext.getAccountContext(), FamilyManagerRepository.class));
    this.c.addSource(this.a.C1(), new a(paramTPBaseDeviceContext));
  }
  
  private BaseALIoTDevice k(String paramString, List<BaseALIoTDevice> paramList)
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
  
  public void j(String paramString)
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
    this.b.n1(str, null, paramString, true).E(new c()).C(new b()).F0();
  }
  
  public LiveData<i<RoomBean>> l()
  {
    return this.e;
  }
  
  public List<RoomInfo> m()
  {
    List localList;
    if (this.a.Q1() != null) {
      localList = this.a.Q1().getRooms();
    } else {
      localList = null;
    }
    return localList;
  }
  
  public String n()
  {
    String str;
    if (this.f.getIoTDevice() != null) {
      str = this.f.getIoTDevice().getRoomId();
    } else {
      str = null;
    }
    return str;
  }
  
  public String o(String paramString)
  {
    Object localObject = m();
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
  
  public LiveData<Boolean> p()
  {
    return this.d;
  }
  
  public void r(String paramString1, String paramString2)
  {
    String str1;
    if (this.a.Q1() != null) {
      str1 = this.a.Q1().getId();
    } else {
      str1 = null;
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      String str2 = o(paramString2);
      this.b.b1(paramString1, str1, str2, paramString2, TextUtils.isEmpty(str2), false).i(new e()).j(new d()).y();
      return;
    }
    this.d.postValue(Boolean.FALSE);
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a(TPBaseDeviceContext paramTPBaseDeviceContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      IoTDeviceLocationViewModel.g(IoTDeviceLocationViewModel.this).postValue(IoTDeviceLocationViewModel.f(IoTDeviceLocationViewModel.this, paramTPBaseDeviceContext.getDeviceIdMD5(), paramList));
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (((paramThrowable instanceof IoTCloudException)) && (((IoTCloudException)paramThrowable).getCode() == 15009)) {
        IoTDeviceLocationViewModel.h(IoTDeviceLocationViewModel.this).postValue(new i(15009, null));
      } else {
        IoTDeviceLocationViewModel.h(IoTDeviceLocationViewModel.this).postValue(new i(1, null));
      }
    }
  }
  
  class c
    implements g<RoomBean>
  {
    c() {}
    
    public void a(RoomBean paramRoomBean)
      throws Exception
    {
      IoTDeviceLocationViewModel.h(IoTDeviceLocationViewModel.this).postValue(new i(0, paramRoomBean));
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      IoTDeviceLocationViewModel.i(IoTDeviceLocationViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      IoTDeviceLocationViewModel.i(IoTDeviceLocationViewModel.this).postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\IoTDeviceLocationViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */