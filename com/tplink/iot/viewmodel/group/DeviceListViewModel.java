package com.tplink.iot.viewmodel.group;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceListViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private GroupRepository b;
  private MediatorLiveData<List<GroupInfo>> c = new MediatorLiveData();
  private MediatorLiveData<Boolean> d = new MediatorLiveData();
  private MediatorLiveData<Integer> e = new MediatorLiveData();
  
  public DeviceListViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class));
    paramApplication = (GroupRepository)b.a(paramApplication, GroupRepository.class);
    this.b = paramApplication;
    this.c.addSource(paramApplication.T(), new a());
  }
  
  private BaseALIoTDevice l(String paramString)
  {
    return this.a.Z1(b.d.w.h.a.g(paramString));
  }
  
  @SuppressLint({"CheckResult"})
  public void i(String paramString, List<String> paramList)
  {
    this.b.E(paramString, paramList).A(new d(), new e());
  }
  
  public MediatorLiveData<Integer> j()
  {
    return this.e;
  }
  
  public List<BaseALIoTDevice> k()
  {
    return (List)this.a.C1().getValue();
  }
  
  public MediatorLiveData<Boolean> m()
  {
    return this.d;
  }
  
  public int n(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    paramGroupInfo = paramGroupInfo.getThingNames();
    if (paramGroupInfo != null)
    {
      paramGroupInfo = paramGroupInfo.iterator();
      while (paramGroupInfo.hasNext())
      {
        Object localObject = (String)paramGroupInfo.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = this.a.Z1(b.d.w.h.a.g((String)localObject));
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList.size();
  }
  
  public MediatorLiveData<List<GroupInfo>> o()
  {
    return this.c;
  }
  
  public List<BaseALIoTDevice> p(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = l((String)paramList.next());
        if (localBaseALIoTDevice != null) {
          localArrayList.add(localBaseALIoTDevice);
        }
      }
    }
    return localArrayList;
  }
  
  @SuppressLint({"CheckResult"})
  public void r(String paramString, List<String> paramList)
  {
    this.b.L(paramString, paramList).A(new b(), new c());
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(List<GroupInfo> paramList)
    {
      DeviceListViewModel.f(DeviceListViewModel.this).postValue(paramList);
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      DeviceListViewModel.g(DeviceListViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      DeviceListViewModel.g(DeviceListViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d() {}
    
    public void run()
      throws Exception
    {
      DeviceListViewModel.h(DeviceListViewModel.this).postValue(Integer.valueOf(0));
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (((paramThrowable instanceof IoTCloudException)) && (((IoTCloudException)paramThrowable).getCode() == 15017)) {
        DeviceListViewModel.h(DeviceListViewModel.this).postValue(Integer.valueOf(15017));
      } else {
        DeviceListViewModel.h(DeviceListViewModel.this).postValue(Integer.valueOf(1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\group\DeviceListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */