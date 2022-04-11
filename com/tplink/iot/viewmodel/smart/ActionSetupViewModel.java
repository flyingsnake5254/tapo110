package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLocation;
import com.tplink.iot.cloud.bean.smart.common.SmartPeriodSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.cloud.bean.smart.common.SmartScheduleSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.view.smart.a.g;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.o;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class ActionSetupViewModel
  extends AndroidViewModel
{
  private SmartRepository a;
  private TPIoTClientManager b;
  private CloudVideoRepository c;
  private int d = 0;
  private int e = 1;
  private int f = 0;
  private boolean g = false;
  private boolean h = false;
  private byte i = (byte)0;
  private BaseALIoTDevice j;
  private String k;
  private Integer l;
  private Integer m;
  private boolean n = true;
  private String o = SmartRepository.i[0];
  private Boolean p;
  private SmartInfo q;
  private SmartInfo r = new SmartInfo();
  private MutableLiveData<SmartInfo> s = new MutableLiveData();
  private SingleLiveEvent<Boolean> t = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> u = new SingleLiveEvent();
  private MediatorLiveData<List<BaseALIoTDevice>> v = new MediatorLiveData();
  
  public ActionSetupViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((SmartRepository)b.d.b.f.b.a(paramApplication, SmartRepository.class));
    this.b = ((TPIoTClientManager)b.d.b.f.b.a(paramApplication, TPIoTClientManager.class));
    this.c = ((CloudVideoRepository)b.d.b.f.b.a(paramApplication, CloudVideoRepository.class));
    this.v.addSource(this.b.C1(), new c(this));
  }
  
  private SmartInfo E(SmartTemplate paramSmartTemplate)
  {
    Object localObject1 = paramSmartTemplate.getName();
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() > 64) {
        localObject2 = ((String)localObject1).substring(0, 64);
      }
    }
    localObject1 = new SmartInfo(this.a.O(), (String)localObject2, paramSmartTemplate.getAvatarUrl(), true, paramSmartTemplate.getTriggerSetting(), null);
    if ((((SmartInfo)localObject1).getTriggerSetting() != null) && (!((SmartInfo)localObject1).getTriggerSetting().isManual()))
    {
      localObject2 = new SmartPeriodSetting();
      ((SmartPeriodSetting)localObject2).setPeriodType("ALL_DAY");
      ((SmartPeriodSetting)localObject2).setDaysOfWeek((byte)Byte.MAX_VALUE);
      if (((SmartInfo)localObject1).getEffectivePeriod() == null) {
        ((SmartInfo)localObject1).setEffectivePeriod((SmartPeriodSetting)localObject2);
      }
    }
    ArrayList localArrayList = new ArrayList();
    if (paramSmartTemplate.getActionSetting() != null) {
      localObject2 = paramSmartTemplate.getActionSetting().getThings();
    } else {
      localObject2 = new ArrayList();
    }
    List localList = (List)w().getValue();
    if ((localList != null) && (!localList.isEmpty()) && (localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      Iterator localIterator1 = ((List)localObject2).iterator();
      int i1 = 0;
      if (localIterator1.hasNext())
      {
        localObject2 = (SmartThingAction)localIterator1.next();
        Iterator localIterator2 = localList.iterator();
        int i2 = i1;
        for (;;)
        {
          i1 = i2;
          if (!localIterator2.hasNext()) {
            break;
          }
          ThingInfo localThingInfo = (ThingInfo)localIterator2.next();
          if ((i2 <= 64) && (com.tplink.iot.view.smart.a.b.d(((SmartThingAction)localObject2).getCategory(), localThingInfo)) && (Q(localThingInfo.getThingModelId(), (SmartThingAction)localObject2, localThingInfo.getThingName()))) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0)
          {
            SmartThingAction localSmartThingAction = new SmartThingAction(localThingInfo.getThingName(), ((SmartThingAction)localObject2).getStateDesired(), ((SmartThingAction)localObject2).getDelaySeconds());
            localSmartThingAction.setService(((SmartThingAction)localObject2).getService());
            localSmartThingAction.setFutureAction(((SmartThingAction)localObject2).getFutureAction());
            localSmartThingAction.setCategory(localThingInfo.getCategory());
            localSmartThingAction.setNickname(localThingInfo.getNickname());
            localSmartThingAction.setAvatarUrl(localThingInfo.getAvatarUrl());
            localSmartThingAction.setSubThing(localThingInfo.isSubThing());
            localArrayList.add(localSmartThingAction);
            i2++;
          }
        }
      }
    }
    localObject2 = new SmartAction();
    if (paramSmartTemplate.getActionSetting() != null) {
      ((SmartAction)localObject2).setSmarts(paramSmartTemplate.getActionSetting().getSmarts());
    }
    ((SmartAction)localObject2).setThings(localArrayList);
    ((SmartInfo)localObject1).setActionSetting((SmartAction)localObject2);
    return (SmartInfo)localObject1;
  }
  
  private void K(boolean paramBoolean1, SmartLocation paramSmartLocation, boolean paramBoolean2)
  {
    SmartLocation localSmartLocation = paramSmartLocation;
    if (paramSmartLocation == null) {
      localSmartLocation = new SmartLocation();
    }
    paramSmartLocation = TimeZone.getDefault();
    localSmartLocation.setRegion(paramSmartLocation.getID());
    localSmartLocation.setTimeDiff(Integer.valueOf(paramSmartLocation.getRawOffset() / 1000 / 60));
    if ((paramBoolean1) && (!this.n))
    {
      localSmartLocation.setLatitude(this.l);
      localSmartLocation.setLongitude(this.m);
      paramSmartLocation = new StringBuilder();
      paramSmartLocation.append("initAppLocationInfo has appLocationInfo, mLatitude = ");
      paramSmartLocation.append(this.l);
      paramSmartLocation.append("   mLongitude = ");
      paramSmartLocation.append(this.m);
      b.d.w.c.a.c("ActionSetupViewModel", paramSmartLocation.toString());
      if (paramBoolean2) {
        this.u.postValue(Boolean.FALSE);
      } else {
        this.t.postValue(Boolean.FALSE);
      }
    }
    else if (paramBoolean1)
    {
      b.d.w.c.a.c("ActionSetupViewModel", "initAppLocationInfo needLatitudeInfo no appLocationInfo...");
      if (paramBoolean2) {
        M(paramBoolean2);
      } else {
        this.t.postValue(Boolean.TRUE);
      }
    }
    else
    {
      b.d.w.c.a.c("ActionSetupViewModel", "initAppLocationInfo no needLatitudeInfo");
      if (paramBoolean2) {
        this.u.postValue(Boolean.FALSE);
      } else {
        this.t.postValue(Boolean.FALSE);
      }
    }
  }
  
  private void L(int paramInt)
  {
    Object localObject1 = new SmartPeriodSetting();
    ((SmartPeriodSetting)localObject1).setPeriodType("ALL_DAY");
    ((SmartPeriodSetting)localObject1).setDaysOfWeek((byte)Byte.MAX_VALUE);
    Object localObject2;
    if (this.r.getId() == null)
    {
      localObject2 = new SmartInfo(this.a.O(), "", "avatarUrl", true, null, null);
      this.r = ((SmartInfo)localObject2);
      ((SmartInfo)localObject2).setEffectivePeriod((SmartPeriodSetting)localObject1);
    }
    int i1 = this.e;
    if ((i1 != 1) && (paramInt >= 0))
    {
      if (i1 == 2)
      {
        localObject2 = (List)this.a.P().getValue();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()) && (paramInt < ((List)localObject2).size()))
        {
          localObject2 = (SmartInfo)((List)localObject2).get(paramInt);
          this.r = new SmartInfo(((SmartInfo)localObject2).getId(), ((SmartInfo)localObject2).getName(), ((SmartInfo)localObject2).getAvatarUrl(), ((SmartInfo)localObject2).isEnabled(), ((SmartInfo)localObject2).getAppLocationInfo(), ((SmartInfo)localObject2).getTriggerSetting(), ((SmartInfo)localObject2).getActionSetting());
          localObject2 = ((SmartInfo)localObject2).getEffectivePeriod();
          if (localObject2 != null)
          {
            if ("ALL_DAY".equals(((SmartPeriodSetting)localObject2).getPeriodType())) {
              ((SmartPeriodSetting)localObject2).setDaysOfWeek((byte)Byte.MAX_VALUE);
            }
            this.r.setEffectivePeriod((SmartPeriodSetting)localObject2);
          }
          else
          {
            this.r.setEffectivePeriod((SmartPeriodSetting)localObject1);
          }
        }
      }
      else
      {
        localObject1 = (List)this.a.m0().getValue();
        if ((localObject1 == null) || (((List)localObject1).isEmpty()) || (paramInt >= ((List)localObject1).size())) {
          break label298;
        }
        this.r = E((SmartTemplate)((List)localObject1).get(paramInt));
      }
      this.k = this.r.getName();
      label298:
      return;
    }
    this.k = this.r.getName();
  }
  
  private void e0(SmartInfo paramSmartInfo)
  {
    if ((paramSmartInfo != null) && (paramSmartInfo.getTriggerSetting() != null)) {
      if (paramSmartInfo.getTriggerSetting().isManual())
      {
        this.o = paramSmartInfo.getAvatarUrl();
        String[] arrayOfString = SmartRepository.i;
        int i1 = arrayOfString.length;
        for (int i2 = 0; i2 < i1; i2++) {
          if (arrayOfString[i2].equals(this.o))
          {
            paramSmartInfo.setAvatarUrl(this.o);
            return;
          }
        }
        paramSmartInfo.setAvatarUrl(arrayOfString[0]);
      }
      else
      {
        paramSmartInfo.setAvatarUrl(g.a(paramSmartInfo));
      }
    }
  }
  
  private boolean h(SmartInfo paramSmartInfo)
  {
    paramSmartInfo = paramSmartInfo.getTriggerSetting();
    boolean bool = true;
    if (paramSmartInfo == null) {
      return true;
    }
    if (paramSmartInfo.isManual()) {
      return false;
    }
    paramSmartInfo = paramSmartInfo.getSchedules();
    if (paramSmartInfo != null)
    {
      paramSmartInfo = paramSmartInfo.iterator();
      while (paramSmartInfo.hasNext()) {
        if (((SmartScheduleSetting)paramSmartInfo.next()).getMode() != 0) {
          return bool;
        }
      }
    }
    bool = false;
    return bool;
  }
  
  private SmartInfo m(String paramString)
  {
    return this.a.M(paramString);
  }
  
  public SingleLiveEvent<Boolean> A()
  {
    return this.a.b0();
  }
  
  public SingleLiveEvent<Boolean> B()
  {
    return this.t;
  }
  
  public SingleLiveEvent<Boolean> C()
  {
    return this.u;
  }
  
  public MutableLiveData<SmartInfo> D()
  {
    return this.s;
  }
  
  public int F()
  {
    return this.f;
  }
  
  public int G(SmartInfo paramSmartInfo)
  {
    if (paramSmartInfo.getActionSetting() == null) {
      return this.f;
    }
    List localList = paramSmartInfo.getActionSetting().getSmarts();
    if ((localList != null) && (!localList.isEmpty())) {
      return ((SmartReferAction)localList.get(0)).getDelaySeconds();
    }
    paramSmartInfo = paramSmartInfo.getActionSetting().getThings();
    if ((paramSmartInfo != null) && (!paramSmartInfo.isEmpty())) {
      return ((SmartThingAction)paramSmartInfo.get(0)).getDelaySeconds();
    }
    return this.f;
  }
  
  public byte H()
  {
    return this.i;
  }
  
  public boolean I()
  {
    Object localObject = (List)this.a.P().getValue();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SmartInfo localSmartInfo = (SmartInfo)((Iterator)localObject).next();
        if ((localSmartInfo.getTriggerSetting() != null) && (!localSmartInfo.getTriggerSetting().isManual())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean J()
  {
    Object localObject = (List)this.a.P().getValue();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (SmartInfo)localIterator.next();
        if ((((SmartInfo)localObject).getTriggerSetting() != null) && (((SmartInfo)localObject).getTriggerSetting().isManual())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void M(boolean paramBoolean)
  {
    com.tplink.iot.view.quicksetup.base.f.c.h().g(15000L).E(new a(this, paramBoolean)).C(new b(this)).F0();
  }
  
  public boolean N()
  {
    return this.g;
  }
  
  public boolean O()
  {
    return com.tplink.iot.Utils.v0.d.b((List)this.c.c0().getValue(), b.d.s.a.a.f().c().getAccountId());
  }
  
  public boolean P()
  {
    return this.h;
  }
  
  public boolean Q(@Nullable String paramString1, @Nullable SmartThingAction paramSmartThingAction, @Nullable String paramString2)
  {
    return this.a.t0(paramString1, paramSmartThingAction, paramString2);
  }
  
  public void b0(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void c0(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void d0(String paramString)
  {
    this.k = paramString;
  }
  
  public SmartInfo f(SmartTemplate paramSmartTemplate)
  {
    paramSmartTemplate = E(paramSmartTemplate);
    j0(paramSmartTemplate, false);
    e0(paramSmartTemplate);
    return paramSmartTemplate;
  }
  
  public void f0(BaseALIoTDevice paramBaseALIoTDevice)
  {
    this.j = paramBaseALIoTDevice;
  }
  
  public boolean g()
  {
    if ((this.r.getActionSetting() != null) && (this.r.getActionSetting().getSmarts() != null))
    {
      Iterator localIterator = this.r.getActionSetting().getSmarts().iterator();
      while (localIterator.hasNext())
      {
        SmartInfo localSmartInfo = m(((SmartReferAction)localIterator.next()).getId());
        if ((localSmartInfo != null) && (localSmartInfo.getTriggerSetting() != null) && (localSmartInfo.getTriggerSetting().isManual())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void g0(SmartInfo paramSmartInfo)
  {
    this.p = null;
    this.q = paramSmartInfo;
  }
  
  public void h0(SmartInfo paramSmartInfo, boolean paramBoolean)
  {
    this.p = Boolean.valueOf(paramBoolean);
    this.q = paramSmartInfo;
  }
  
  public void i(SmartInfo paramSmartInfo)
  {
    e0(paramSmartInfo);
    o.h0().k("new_smart_info", paramSmartInfo.getId());
    this.a.F(paramSmartInfo).y();
  }
  
  public void i0(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void j(SmartInfo paramSmartInfo)
  {
    this.a.H(paramSmartInfo.getId()).y();
  }
  
  public void j0(SmartInfo paramSmartInfo, boolean paramBoolean)
  {
    Object localObject1 = paramSmartInfo.getTriggerSetting();
    SmartLocation localSmartLocation = null;
    if ((localObject1 != null) && (((SmartTrigger)localObject1).isManual()))
    {
      paramSmartInfo.setEffectivePeriod(null);
      b.d.w.c.a.c("ActionSetupViewModel", "setLocationInfoIfNeed trigger isManual");
      if (paramBoolean) {
        this.u.postValue(Boolean.FALSE);
      } else {
        this.t.postValue(Boolean.FALSE);
      }
      return;
    }
    localObject1 = paramSmartInfo.getAppLocationInfo();
    if ((localObject1 != null) && (((SmartLocation)localObject1).getRegion() != null) && (((SmartLocation)localObject1).getLatitude() != null) && (((SmartLocation)localObject1).getLongitude() != null))
    {
      b.d.w.c.a.c("ActionSetupViewModel", "setLocationInfoIfNeed smartLocation has Latitude and Longitude");
      if (paramBoolean) {
        this.u.postValue(Boolean.FALSE);
      } else {
        this.t.postValue(Boolean.FALSE);
      }
      return;
    }
    localObject1 = localSmartLocation;
    if (paramSmartInfo.getActionSetting() != null) {
      if ((paramSmartInfo.getActionSetting().getThings() != null) && (!paramSmartInfo.getActionSetting().getThings().isEmpty()))
      {
        localObject1 = (SmartThingAction)paramSmartInfo.getActionSetting().getThings().get(0);
      }
      else
      {
        Object localObject2 = paramSmartInfo.getActionSetting().getSmarts();
        localObject1 = localSmartLocation;
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          do
          {
            localObject1 = localSmartLocation;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = m(((SmartReferAction)((Iterator)localObject2).next()).getId());
          } while ((localObject1 == null) || (((SmartInfo)localObject1).getActionSetting().getThings() == null) || (((SmartInfo)localObject1).getActionSetting().getThings().isEmpty()));
          localObject1 = (SmartThingAction)((SmartInfo)localObject1).getActionSetting().getThings().get(0);
        }
      }
    }
    boolean bool;
    if (paramBoolean) {
      bool = true;
    } else {
      bool = h(paramSmartInfo);
    }
    localSmartLocation = new SmartLocation();
    if ((localObject1 != null) && (!TextUtils.isEmpty(((SmartThingAction)localObject1).getThingName()))) {
      this.a.p0(((SmartThingAction)localObject1).getThingName()).E(new d(this, localSmartLocation, paramBoolean, bool)).C(new e(this, bool, localSmartLocation, paramBoolean)).F0();
    } else {
      K(bool, localSmartLocation, paramBoolean);
    }
    paramSmartInfo.setAppLocationInfo(localSmartLocation);
  }
  
  public void k(SmartInfo paramSmartInfo)
  {
    e0(paramSmartInfo);
    this.a.I(paramSmartInfo).y();
  }
  
  public void k0(int paramInt)
  {
    this.f = paramInt;
  }
  
  @Nullable
  public BaseALIoTDevice l(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = (List)this.b.C1().getValue();
    Object localObject3 = localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      do
      {
        localObject3 = localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (BaseALIoTDevice)((Iterator)localObject2).next();
      } while (!paramString.equals(((BaseALIoTDevice)localObject3).getDeviceId()));
    }
    return (BaseALIoTDevice)localObject3;
  }
  
  public void l0(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void m0(byte paramByte)
  {
    this.i = ((byte)paramByte);
  }
  
  public ThingInfo n(String paramString)
  {
    return this.a.N(paramString);
  }
  
  public boolean n0(SmartInfo paramSmartInfo)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramSmartInfo != null) {
      if (paramSmartInfo.getActionSetting() == null)
      {
        bool2 = bool1;
      }
      else
      {
        List localList = paramSmartInfo.getActionSetting().getThings();
        paramSmartInfo = paramSmartInfo.getActionSetting().getSmarts();
        int i1;
        if (localList != null) {
          i1 = localList.size() + 0;
        } else {
          i1 = 0;
        }
        int i2 = i1;
        if (paramSmartInfo != null) {
          i2 = i1 + paramSmartInfo.size();
        }
        bool2 = bool1;
        if (i2 > 64) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public int o()
  {
    return this.e;
  }
  
  public boolean o0()
  {
    List localList = (List)this.a.P().getValue();
    boolean bool;
    if ((localList != null) && (localList.size() >= 64)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String p()
  {
    return this.k;
  }
  
  public void p0(SmartInfo paramSmartInfo)
  {
    this.r = paramSmartInfo;
    this.s.postValue(paramSmartInfo);
  }
  
  public void q0(int paramInt)
  {
    k0(paramInt);
    SmartInfo localSmartInfo = this.r;
    if (localSmartInfo.getActionSetting() == null) {
      return;
    }
    Object localObject1 = localSmartInfo.getActionSetting().getSmarts();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((SmartReferAction)((Iterator)localObject2).next()).setDelaySeconds(paramInt);
      }
      localSmartInfo.getActionSetting().setSmarts((List)localObject1);
    }
    Object localObject2 = localSmartInfo.getActionSetting().getThings();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SmartThingAction)((Iterator)localObject1).next()).setDelaySeconds(paramInt);
      }
      localSmartInfo.getActionSetting().setThings((List)localObject2);
    }
    p0(localSmartInfo);
  }
  
  public MutableLiveData<List<BaseALIoTDevice>> r()
  {
    return this.v;
  }
  
  public Boolean s()
  {
    return this.p;
  }
  
  public BaseALIoTDevice t()
  {
    return this.j;
  }
  
  public SmartInfo u()
  {
    return this.q;
  }
  
  public SmartInfo v()
  {
    return this.r;
  }
  
  public MutableLiveData<List<ThingInfo>> w()
  {
    return this.a.W();
  }
  
  public SingleLiveEvent<Boolean> x()
  {
    return this.a.X();
  }
  
  public void y()
  {
    L(this.d);
    p0(this.r);
  }
  
  public SingleLiveEvent<Boolean> z()
  {
    return this.a.Z();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\ActionSetupViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */