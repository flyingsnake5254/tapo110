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
import com.tplink.iot.Utils.w;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.model.home.k;
import com.tplink.iot.viewmodel.home.r;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupPresetBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupDetailViewModel
  extends AndroidViewModel
{
  private String a = GroupDetailViewModel.class.getSimpleName();
  private GroupRepository b;
  private TPIoTClientManager c;
  private MediatorLiveData<List<GroupInfo>> d = new MediatorLiveData();
  private MediatorLiveData<List<BaseALIoTDevice>> e = new MediatorLiveData();
  private MediatorLiveData<Integer> f = new MediatorLiveData();
  
  public GroupDetailViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.c = ((TPIoTClientManager)b.d.b.f.b.a(paramApplication, TPIoTClientManager.class));
    paramApplication = (GroupRepository)b.d.b.f.b.a(paramApplication, GroupRepository.class);
    this.b = paramApplication;
    this.d.addSource(paramApplication.T(), new a());
    this.e.addSource(this.c.C1(), new b());
  }
  
  private void A(List<String> paramList, AutoLightBean paramAutoLightBean, int paramInt1, int paramInt2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      B(b.d.w.h.a.g((String)paramList.next()), paramAutoLightBean, paramInt1, paramInt2);
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void B(final String paramString, final AutoLightBean paramAutoLightBean, int paramInt1, int paramInt2)
  {
    paramString = (BulbRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, BulbRepository.class);
    paramString.N4(paramInt1, paramInt2).r(io.reactivex.d0.b.a.a()).z(new d(paramString, paramAutoLightBean));
  }
  
  private boolean i(GroupInfo paramGroupInfo)
  {
    boolean bool;
    if ((paramGroupInfo != null) && (!TextUtils.isEmpty(paramGroupInfo.getId()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean j(String paramString)
  {
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  private LocalIoTBaseDevice l(String paramString)
  {
    return (LocalIoTBaseDevice)((BulbRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramString, BulbRepository.class)).j1().getValue();
  }
  
  public void C(List<String> paramList, AutoLightBean paramAutoLightBean)
  {
    com.tplink.iot.view.quicksetup.base.f.c.h().g(15000L).E(new b(this, paramList, paramAutoLightBean)).C(new a(this)).F0();
  }
  
  public void D(boolean paramBoolean, String paramString)
  {
    r.g().l(paramBoolean, paramString);
  }
  
  public void E(String paramString, boolean paramBoolean)
  {
    if (j(paramString)) {
      this.b.u0(paramString, paramBoolean);
    }
  }
  
  public void F(String paramString, boolean paramBoolean)
  {
    D(false, paramString);
    this.c.h2(paramString).i(paramBoolean).r(io.reactivex.d0.b.a.a()).j(new c()).y();
  }
  
  public void G(String paramString, LightStateBean paramLightStateBean)
  {
    if (j(paramString)) {
      this.b.v0(paramString, paramLightStateBean);
    }
  }
  
  public void h(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    this.b.w0(localArrayList, paramBoolean).y();
  }
  
  public void k(GroupInfo paramGroupInfo, EditPresetRule paramEditPresetRule)
  {
    if (i(paramGroupInfo))
    {
      List localList = com.tplink.libtpnetwork.Utils.g.f(paramGroupInfo);
      if (paramEditPresetRule.getIndex() < localList.size()) {
        localList.set(paramEditPresetRule.getIndex(), paramEditPresetRule.getState());
      }
      paramEditPresetRule = new GroupPresetBean();
      paramEditPresetRule.setStates(localList);
      paramEditPresetRule = i.i(paramEditPresetRule);
      paramGroupInfo.setPresets(paramEditPresetRule);
      this.b.D0(paramGroupInfo.getId(), paramEditPresetRule).y();
    }
  }
  
  public int m(GroupInfo paramGroupInfo)
  {
    int i;
    if (paramGroupInfo != null) {
      i = r(paramGroupInfo).size();
    } else {
      i = 0;
    }
    return i;
  }
  
  public void n(String paramString)
  {
    if (j(paramString)) {
      this.b.S(paramString).F0();
    }
  }
  
  public GroupInfo o(List<GroupInfo> paramList, String paramString)
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
  
  public MediatorLiveData<List<GroupInfo>> p()
  {
    return this.d;
  }
  
  public List<com.tplink.iot.model.home.e> r(GroupInfo paramGroupInfo)
  {
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
          localObject = this.c.Z1(b.d.w.h.a.g((String)localObject));
          if (localObject != null) {
            localArrayList.add(new k((BaseALIoTDevice)localObject));
          }
        }
      }
    }
    t.j(localArrayList, new ArrayList());
    return new ArrayList(localArrayList);
  }
  
  public List<String> s(GroupInfo paramGroupInfo)
  {
    ArrayList localArrayList = new ArrayList();
    paramGroupInfo = paramGroupInfo.getThingNames();
    if (paramGroupInfo != null)
    {
      paramGroupInfo = paramGroupInfo.iterator();
      while (paramGroupInfo.hasNext())
      {
        String str1 = (String)paramGroupInfo.next();
        if (!TextUtils.isEmpty(str1))
        {
          String str2 = b.d.w.h.a.g(str1);
          Object localObject = this.c.Z1(str2);
          if ((localObject != null) && (((BaseALIoTDevice)localObject).isOnline()))
          {
            localObject = l(str2);
            if ((localObject != null) && (!((LocalIoTBaseDevice)localObject).isHasSetLocationInfo())) {
              localArrayList.add(str1);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public LiveData<Integer> t()
  {
    return this.f;
  }
  
  public void y(String paramString, AutoLightBean paramAutoLightBean)
  {
    if (j(paramString)) {
      this.b.o0(paramString, paramAutoLightBean);
    }
  }
  
  public void z(String paramString, int paramInt)
  {
    if (j(paramString)) {
      this.b.p0(paramString, paramInt);
    }
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(@Nullable List<GroupInfo> paramList)
    {
      GroupDetailViewModel.f(GroupDetailViewModel.this).postValue(paramList);
    }
  }
  
  class b
    implements Observer<List<BaseALIoTDevice>>
  {
    b() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      GroupDetailViewModel.g(GroupDetailViewModel.this).postValue(paramList);
    }
  }
  
  class c
    implements io.reactivex.g0.g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        w.f();
      }
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d(BulbRepository paramBulbRepository, AutoLightBean paramAutoLightBean) {}
    
    public void run()
      throws Exception
    {
      paramString.W5(paramAutoLightBean).y();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\group\GroupDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */