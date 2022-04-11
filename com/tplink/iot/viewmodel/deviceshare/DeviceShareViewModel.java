package com.tplink.iot.viewmodel.deviceshare;

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
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.share.params.ShareBlacklistUpdateParams;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.share.EnumDeviceShareRole;
import com.tplink.iot.cloud.bean.share.EnumDeviceShareStatus;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUsersParams;
import com.tplink.iot.cloud.bean.share.params.UserAccountBean;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.core.n;
import com.tplink.iot.model.deviceshare.DeviceShareManager;
import com.tplink.iot.viewmodel.home.r;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.DeviceShareRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ShareBlacklistCacheBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DeviceShareViewModel
  extends AndroidViewModel
{
  private com.tplink.cloud.context.b a;
  private DeviceShareRepository b;
  private TCDeviceRepository c;
  private TPIoTClientManager d;
  private DeviceShareManager e;
  private MediatorLiveData<List<BaseALIoTDevice>> f = new MediatorLiveData();
  private MutableLiveData<i<Void>> g = new MutableLiveData();
  private MutableLiveData<List<ShareDeviceResult>> h = new MutableLiveData();
  private MutableLiveData<i<String>> i = new MutableLiveData();
  private MutableLiveData<i<String>> j = new MutableLiveData();
  private MutableLiveData<i<CloudResult<Void>>> k = new MutableLiveData();
  private MutableLiveData<i<Void>> l = new MutableLiveData();
  private MediatorLiveData<List<ShareBlacklistItemResult>> m = new MediatorLiveData();
  private MutableLiveData<i<Void>> n = new MutableLiveData();
  private MutableLiveData<i<Void>> o = new MutableLiveData();
  private MutableLiveData<i<CloudResult<Void>>> p = new MutableLiveData();
  
  public DeviceShareViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = paramApplication;
    paramApplication = b.d.b.f.b.c(paramApplication);
    this.d = ((TPIoTClientManager)paramApplication.a(TPIoTClientManager.class));
    this.b = ((DeviceShareRepository)paramApplication.a(DeviceShareRepository.class));
    this.e = ((DeviceShareManager)paramApplication.a(DeviceShareManager.class));
    this.c = ((TCDeviceRepository)paramApplication.a(TCDeviceRepository.class));
    this.f.addSource(this.d.C1(), new j());
    this.m.addSource(this.c.J(), new k());
  }
  
  @SuppressLint({"CheckResult"})
  private void R()
  {
    boolean bool;
    if ((b.d.w.f.b.j(getApplication())) && (b.d.w.f.b.i(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    this.d.p3(n.a(), bool).y(new a(this)).F0();
  }
  
  private void T(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    List localList = (List)this.h.getValue();
    if ((localList != null) && (!localList.isEmpty()))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        if (TextUtils.equals(((ShareDeviceResult)localIterator.next()).getShareId(), paramString)) {
          localIterator.remove();
        }
      }
      this.h.postValue(localList);
    }
  }
  
  private void V(List<ShareDeviceResult> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      HashMap localHashMap = new HashMap();
      Object localObject = paramList.iterator();
      ShareBlacklistCacheBean localShareBlacklistCacheBean;
      while (((Iterator)localObject).hasNext())
      {
        paramList = (ShareDeviceResult)((Iterator)localObject).next();
        if (localHashMap.get(paramList.getOwnerUsername()) == null)
        {
          localShareBlacklistCacheBean = new ShareBlacklistCacheBean();
          if (!TextUtils.isEmpty(paramList.getShareCreatedTime())) {
            localShareBlacklistCacheBean.setTimeStamp(Long.parseLong(paramList.getShareCreatedTime()));
          }
          localShareBlacklistCacheBean.setEmail(paramList.getOwnerUsername());
          localShareBlacklistCacheBean.setNickname(paramList.getOwnerNickname());
          localHashMap.put(localShareBlacklistCacheBean.getEmail(), localShareBlacklistCacheBean);
        }
      }
      paramList = this.e.e();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localShareBlacklistCacheBean = (ShareBlacklistCacheBean)paramList.next();
          localObject = (ShareBlacklistCacheBean)localHashMap.get(localShareBlacklistCacheBean.getEmail());
          if ((localObject == null) || (((ShareBlacklistCacheBean)localObject).getTimeStamp() < localShareBlacklistCacheBean.getTimeStamp())) {
            localHashMap.put(localShareBlacklistCacheBean.getEmail(), localShareBlacklistCacheBean);
          }
        }
      }
      paramList = new ArrayList(localHashMap.values());
      Collections.sort(paramList);
      localHashMap.clear();
      this.e.i(paramList);
    }
  }
  
  private void X(List<ShareBlacklistItemResult> paramList)
  {
    this.e.j(paramList);
  }
  
  public void A(String paramString, boolean paramBoolean)
  {
    this.b.H(paramString, paramBoolean).F0();
  }
  
  public void B()
  {
    Object localObject = (List)this.d.C1().getValue();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject).next();
        if (localBaseALIoTDevice.isHasThingOrCloudDevice()) {
          localArrayList.add(localBaseALIoTDevice);
        }
      }
    }
    this.b.I(localArrayList).F0();
  }
  
  public void C(List<BaseALIoTDevice> paramList)
  {
    this.b.I(paramList).C(new m()).z(new l()).F0();
  }
  
  public MutableLiveData<i<Void>> D()
  {
    return this.l;
  }
  
  public MutableLiveData<i<String>> E()
  {
    return this.i;
  }
  
  public MediatorLiveData<List<BaseALIoTDevice>> F()
  {
    return this.f;
  }
  
  public MutableLiveData<i<Void>> G()
  {
    return this.g;
  }
  
  public MutableLiveData<i<Void>> H()
  {
    return this.o;
  }
  
  public MutableLiveData<i<CloudResult<Void>>> I()
  {
    return this.p;
  }
  
  public MutableLiveData<List<ShareBlacklistItemResult>> J()
  {
    return this.m;
  }
  
  public MutableLiveData<List<ShareDeviceResult>> K()
  {
    return this.h;
  }
  
  public void L(DeviceShareActionListParams paramDeviceShareActionListParams, final String paramString)
  {
    this.b.K(paramDeviceShareActionListParams).g0(new b(this, paramDeviceShareActionListParams)).E(new d(paramString)).C(new c(paramString)).F0();
  }
  
  public void Q(final DeviceShareListParams paramDeviceShareListParams)
  {
    this.b.T(paramDeviceShareListParams).E(new r(paramDeviceShareListParams)).F0();
  }
  
  public void S(String paramString, List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        UserAccountBean localUserAccountBean = new UserAccountBean();
        localUserAccountBean.setUserAccount(paramList);
        localArrayList.add(localUserAccountBean);
      }
    }
    paramList = new DeviceUsersParams(this.a.c().getCloudUserName(), localArrayList, paramBoolean);
    this.b.A(paramString, paramList).i(new o()).j(new n()).y();
  }
  
  public void U(String paramString)
  {
    ShareBlacklistUpdateParams localShareBlacklistUpdateParams = new ShareBlacklistUpdateParams();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localShareBlacklistUpdateParams.setBlackList(localArrayList);
    this.c.N(localShareBlacklistUpdateParams).E(new i()).C(new h()).F0();
  }
  
  public void W(TCDeviceUserInfoBean paramTCDeviceUserInfoBean)
  {
    this.e.h(paramTCDeviceUserInfoBean);
  }
  
  public void Y(List<TCDeviceUserInfoBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (TCDeviceUserInfoBean)localIterator.next();
        ShareBlacklistItemResult localShareBlacklistItemResult = new ShareBlacklistItemResult();
        localShareBlacklistItemResult.setNickname(paramList.getNickname());
        localShareBlacklistItemResult.setAvatarUrl(paramList.getAvatarUrl());
        localArrayList.add(localShareBlacklistItemResult);
      }
      X(localArrayList);
    }
  }
  
  public void Z(List<TCDeviceUserInfoBean> paramList)
  {
    this.e.k(paramList);
  }
  
  public void f(final String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    this.d.x(localArrayList).i(new q(paramString)).j(new p()).y();
  }
  
  public void t(String paramString)
  {
    ShareBlacklistUpdateParams localShareBlacklistUpdateParams = new ShareBlacklistUpdateParams();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localShareBlacklistUpdateParams.setBlackList(localArrayList);
    this.c.q(localShareBlacklistUpdateParams).E(new g()).C(new f()).F0();
  }
  
  public MutableLiveData<i<String>> u()
  {
    return this.j;
  }
  
  public MutableLiveData<i<Void>> v()
  {
    return this.n;
  }
  
  public void w()
  {
    this.c.w().E(new e()).F0();
  }
  
  public void x()
  {
    this.b.D(EnumDeviceShareStatus.READY.name(), EnumDeviceShareRole.SHARER.getName(), null).E(new b()).C(new a()).F0();
  }
  
  public List<ShareBlacklistCacheBean> y()
  {
    Object localObject = this.e.e();
    List localList = this.c.I();
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (localList != null) && (!localList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = ((List)localObject).iterator();
      while (localIterator1.hasNext())
      {
        ShareBlacklistCacheBean localShareBlacklistCacheBean = (ShareBlacklistCacheBean)localIterator1.next();
        int i1 = 0;
        Iterator localIterator2 = localList.iterator();
        do
        {
          i2 = i1;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject = (ShareBlacklistItemResult)localIterator2.next();
        } while (!TextUtils.equals(localShareBlacklistCacheBean.getEmail(), ((ShareBlacklistItemResult)localObject).getEmail()));
        int i2 = 1;
        if (i2 == 0) {
          localArrayList.add(localShareBlacklistCacheBean);
        }
      }
      return localArrayList;
    }
    return (List<ShareBlacklistCacheBean>)localObject;
  }
  
  public List<TCDeviceUserInfoBean> z()
  {
    return this.e.d();
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      r.g().p(null);
    }
  }
  
  class b
    implements g<List<ShareDeviceResult>>
  {
    b() {}
    
    public void a(List<ShareDeviceResult> paramList)
      throws Exception
    {
      DeviceShareViewModel.o(DeviceShareViewModel.this, paramList);
      DeviceShareViewModel.p(DeviceShareViewModel.this).postValue(paramList);
      r.g().p(paramList);
    }
  }
  
  class c
    implements g<Throwable>
  {
    c(String paramString) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      DeviceShareViewModel.r(DeviceShareViewModel.this).postValue(new i(1, paramString));
    }
  }
  
  class d
    implements g<Integer>
  {
    d(String paramString) {}
    
    public void a(Integer paramInteger)
      throws Exception
    {
      if (paramInteger.intValue() == 0) {
        DeviceShareViewModel.r(DeviceShareViewModel.this).postValue(new i(0, paramString));
      } else {
        DeviceShareViewModel.r(DeviceShareViewModel.this).postValue(new i(paramInteger.intValue(), paramString));
      }
    }
  }
  
  class e
    implements g<List<ShareBlacklistItemResult>>
  {
    e() {}
    
    public void a(List<ShareBlacklistItemResult> paramList)
      throws Exception
    {
      DeviceShareViewModel.s(DeviceShareViewModel.this, paramList);
    }
  }
  
  class f
    implements g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      int i;
      if ((paramThrowable instanceof CloudException)) {
        i = ((CloudException)paramThrowable).getErrCode();
      } else {
        i = 1;
      }
      DeviceShareViewModel.i(DeviceShareViewModel.this).postValue(new i(i, null));
    }
  }
  
  class g
    implements g<Boolean>
  {
    g() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      DeviceShareViewModel.i(DeviceShareViewModel.this).postValue(new i(0, null));
      DeviceShareViewModel.this.w();
    }
  }
  
  class h
    implements g<Throwable>
  {
    h() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      DeviceShareViewModel.j(DeviceShareViewModel.this).postValue(new i(1, null));
    }
  }
  
  class i
    implements g<Boolean>
  {
    i() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      DeviceShareViewModel.j(DeviceShareViewModel.this).postValue(new i(0, null));
    }
  }
  
  class j
    implements Observer<List<BaseALIoTDevice>>
  {
    j() {}
    
    public void a(List<BaseALIoTDevice> paramList)
    {
      DeviceShareViewModel.g(DeviceShareViewModel.this).postValue(paramList);
    }
  }
  
  class k
    implements Observer<List<ShareBlacklistItemResult>>
  {
    k() {}
    
    public void a(@Nullable List<ShareBlacklistItemResult> paramList)
    {
      DeviceShareViewModel.h(DeviceShareViewModel.this).postValue(paramList);
    }
  }
  
  class l
    implements io.reactivex.g0.a
  {
    l() {}
    
    public void run()
      throws Exception
    {
      DeviceShareViewModel.k(DeviceShareViewModel.this).postValue(new i(0, null));
    }
  }
  
  class m
    implements g<Throwable>
  {
    m() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        DeviceShareViewModel.k(DeviceShareViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      DeviceShareViewModel.k(DeviceShareViewModel.this).postValue(new i(1, null));
    }
  }
  
  class n
    implements g<Throwable>
  {
    n() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        DeviceShareViewModel.l(DeviceShareViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      DeviceShareViewModel.l(DeviceShareViewModel.this).postValue(new i(1, null));
    }
  }
  
  class o
    implements io.reactivex.g0.a
  {
    o() {}
    
    public void run()
      throws Exception
    {
      DeviceShareViewModel.l(DeviceShareViewModel.this).postValue(new i(0, null));
    }
  }
  
  class p
    implements g<Throwable>
  {
    p() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        DeviceShareViewModel.m(DeviceShareViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      DeviceShareViewModel.m(DeviceShareViewModel.this).postValue(new i(1, null));
    }
  }
  
  class q
    implements io.reactivex.g0.a
  {
    q(String paramString) {}
    
    public void run()
      throws Exception
    {
      DeviceShareViewModel.m(DeviceShareViewModel.this).postValue(new i(0, paramString));
    }
  }
  
  class r
    implements g<Integer>
  {
    r(DeviceShareListParams paramDeviceShareListParams) {}
    
    public void a(Integer paramInteger)
      throws Exception
    {
      Object localObject;
      if ((paramInteger != null) && (paramInteger.intValue() == 0))
      {
        paramInteger = paramDeviceShareListParams.getShareList();
        if ((paramInteger != null) && (!paramInteger.isEmpty()))
        {
          localObject = (DeviceShareParams)paramInteger.get(0);
          paramInteger = new TCDeviceUserInfoBean();
          paramInteger.setCloudUserName(((DeviceShareParams)localObject).getSharerUserName());
          DeviceShareViewModel.this.W(paramInteger);
        }
        DeviceShareViewModel.n(DeviceShareViewModel.this).postValue(new i(0, null));
      }
      else
      {
        localObject = DeviceShareViewModel.n(DeviceShareViewModel.this);
        int i;
        if (paramInteger != null) {
          i = paramInteger.intValue();
        } else {
          i = 1;
        }
        ((MutableLiveData)localObject).postValue(new i(i, null));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\deviceshare\DeviceShareViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */