package com.tplink.iot.viewmodel.group;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import io.reactivex.g0.g;
import java.util.List;

public class AllDeviceListViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private GroupRepository b;
  private MediatorLiveData<List<BaseALIoTDevice>> c = new MediatorLiveData();
  private MutableLiveData<Integer> d = new MutableLiveData();
  
  public AllDeviceListViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class));
    this.b = ((GroupRepository)b.a(paramApplication, GroupRepository.class));
    this.c.addSource(this.a.C1(), new a());
  }
  
  public void h(GroupInfo paramGroupInfo)
  {
    this.b.I(paramGroupInfo).i(new c()).j(new b()).y();
  }
  
  public MediatorLiveData<List<BaseALIoTDevice>> i()
  {
    return this.c;
  }
  
  public BaseALIoTDevice j(String paramString)
  {
    return this.a.Z1(b.d.w.h.a.g(paramString));
  }
  
  public MutableLiveData<Integer> k()
  {
    return this.d;
  }
  
  public String l()
  {
    String str1;
    if (this.a.Q1() != null) {
      str1 = this.a.Q1().getId();
    } else {
      str1 = null;
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "default";
    }
    return str2;
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      AllDeviceListViewModel.f(AllDeviceListViewModel.this).postValue(paramList);
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (((paramThrowable instanceof IoTCloudException)) && (((IoTCloudException)paramThrowable).getCode() == 15016)) {
        AllDeviceListViewModel.g(AllDeviceListViewModel.this).postValue(Integer.valueOf(15016));
      } else {
        AllDeviceListViewModel.g(AllDeviceListViewModel.this).postValue(Integer.valueOf(1));
      }
    }
  }
  
  class c
    implements io.reactivex.g0.a
  {
    c() {}
    
    public void run()
      throws Exception
    {
      AllDeviceListViewModel.g(AllDeviceListViewModel.this).postValue(Integer.valueOf(0));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\group\AllDeviceListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */