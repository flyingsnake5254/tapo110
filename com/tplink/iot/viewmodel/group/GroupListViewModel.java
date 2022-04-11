package com.tplink.iot.viewmodel.group;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupListViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private GroupRepository b;
  private MediatorLiveData<List<GroupInfo>> c = new MediatorLiveData();
  private MediatorLiveData<Boolean> d = new MediatorLiveData();
  
  public GroupListViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class));
    paramApplication = (GroupRepository)b.a(paramApplication, GroupRepository.class);
    this.b = paramApplication;
    this.c.addSource(paramApplication.T(), new a());
  }
  
  @SuppressLint({"CheckResult"})
  public void h(String paramString, List<String> paramList)
  {
    this.b.F(paramList, paramString).A(new b(), new c());
  }
  
  public MediatorLiveData<Boolean> i()
  {
    return this.d;
  }
  
  public List<GroupInfo> j(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Object localObject = this.a.Z1(b.d.w.h.a.g(paramString));
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((BaseALIoTDevice)localObject).getFamilyId();
    if (localObject != null)
    {
      List localList = this.b.O();
      if ((localList != null) && (!localList.isEmpty()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          GroupInfo localGroupInfo = (GroupInfo)localIterator.next();
          localList = localGroupInfo.getThingNames();
          if ((((String)localObject).equals(localGroupInfo.getFamilyId())) && ((localList == null) || (localList.isEmpty()) || (!localList.contains(paramString)))) {
            localArrayList.add(localGroupInfo);
          }
        }
      }
    }
    t.d(localArrayList);
    return localArrayList;
  }
  
  public MediatorLiveData<List<GroupInfo>> k()
  {
    return this.c;
  }
  
  public List<GroupInfo> l(List<GroupInfo> paramList, String paramString)
  {
    if ((paramList != null) && (!TextUtils.isEmpty(paramString)))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)localIterator.next();
        if (localGroupInfo != null)
        {
          paramList = localGroupInfo.getThingNames();
          if ((paramList != null) && (paramList.contains(paramString))) {
            localArrayList.add(localGroupInfo);
          }
        }
      }
      t.d(localArrayList);
      return localArrayList;
    }
    return null;
  }
  
  public boolean m(String paramString)
  {
    return j(paramString).isEmpty() ^ true;
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(List<GroupInfo> paramList)
    {
      GroupListViewModel.f(GroupListViewModel.this).postValue(paramList);
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      GroupListViewModel.g(GroupListViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      GroupListViewModel.g(GroupListViewModel.this).postValue(Boolean.FALSE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\group\GroupListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */