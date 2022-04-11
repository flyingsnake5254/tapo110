package com.tplink.iot.viewmodel.group;

import android.annotation.SuppressLint;
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
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupPresetBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;

public class GroupSettingViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private GroupRepository b;
  private MediatorLiveData<List<GroupInfo>> c = new MediatorLiveData();
  private MutableLiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> d = new MutableLiveData();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private MediatorLiveData<com.tplink.iot.viewmodel.quicksetup.i<RoomBean>> f = new MediatorLiveData();
  private MutableLiveData<Boolean> g = new MutableLiveData();
  private MutableLiveData<Boolean> h = new MutableLiveData();
  private MutableLiveData<Boolean> i = new MutableLiveData();
  
  public GroupSettingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((TPIoTClientManager)b.a(paramApplication, TPIoTClientManager.class));
    paramApplication = (GroupRepository)b.a(paramApplication, GroupRepository.class);
    this.b = paramApplication;
    this.c.addSource(paramApplication.T(), new a());
  }
  
  @SuppressLint({"CheckResult"})
  public void j(String paramString)
  {
    this.b.J(paramString).A(new f(), new g());
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
      paramString = localGroupInfo.getAvatarUrl();
    }
    if (paramString == null) {
      paramString = str;
    }
    return paramString;
  }
  
  public MutableLiveData<Boolean> l()
  {
    return this.g;
  }
  
  public void m(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.b.S(paramString).F0();
    }
  }
  
  public GroupInfo n(List<GroupInfo> paramList, String paramString)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (GroupInfo)localIterator.next();
      if ((paramString != null) && (paramString.equals(paramList.getId()))) {
        return paramList;
      }
    }
    return null;
  }
  
  public MediatorLiveData<List<GroupInfo>> o()
  {
    return this.c;
  }
  
  public String p(String paramString)
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
      paramString = localGroupInfo.getName();
    }
    if (paramString == null) {
      paramString = str;
    }
    return paramString;
  }
  
  public LiveData<com.tplink.iot.viewmodel.quicksetup.i<Void>> r()
  {
    return this.d;
  }
  
  public MutableLiveData<Boolean> s()
  {
    return this.i;
  }
  
  public MutableLiveData<Boolean> t()
  {
    return this.h;
  }
  
  @SuppressLint({"CheckResult"})
  public void u(String paramString1, String paramString2)
  {
    this.b.B0(paramString1, paramString2).A(new b(), new c());
  }
  
  @SuppressLint({"CheckResult"})
  public void v(String paramString1, String paramString2)
  {
    this.b.C0(paramString1, paramString2).A(new d(), new e());
  }
  
  public void w(String paramString, List<Integer> paramList)
  {
    GroupPresetBean localGroupPresetBean = new GroupPresetBean();
    localGroupPresetBean.setBrightness(paramList);
    paramList = com.tplink.libtpnetwork.Utils.i.i(localGroupPresetBean);
    this.b.D0(paramString, paramList).y();
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(@Nullable List<GroupInfo> paramList)
    {
      GroupSettingViewModel.f(GroupSettingViewModel.this).postValue(paramList);
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      GroupSettingViewModel.g(GroupSettingViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      GroupSettingViewModel.g(GroupSettingViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d() {}
    
    public void run()
      throws Exception
    {
      GroupSettingViewModel.h(GroupSettingViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      GroupSettingViewModel.h(GroupSettingViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f() {}
    
    public void run()
      throws Exception
    {
      GroupSettingViewModel.i(GroupSettingViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class g
    implements g<Throwable>
  {
    g() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      GroupSettingViewModel.i(GroupSettingViewModel.this).postValue(Boolean.FALSE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\group\GroupSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */