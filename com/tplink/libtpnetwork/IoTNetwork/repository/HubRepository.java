package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.google.gson.k;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportAlarm;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportCategory;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ThingServiceExecResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceIdListParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.GuardModeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.PlayAlarmParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.x;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HubRepository
  extends AbstractThingRepository
{
  private MutableLiveData<List<String>> C = new MutableLiveData();
  private MediatorLiveData<LoadInfoBean> D = new MediatorLiveData();
  private MutableLiveData<List<SubThingCategoryBean>> E = new MutableLiveData();
  @Nullable
  private String F = null;
  private final MutableLiveData<List<HubAlarmLog>> G = new MutableLiveData();
  private int H = 0;
  private boolean I = false;
  private final MutableLiveData<Boolean> J = new MutableLiveData(Boolean.FALSE);
  private MutableLiveData<List<GuardModeConfigBean>> K = new MutableLiveData();
  private Map<String, GuardModeConfigBean> L = new LinkedHashMap();
  
  public HubRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTHubDevice.class, HubDeviceRunningInfoResult.class);
    paramThingContext = (ALIoTDevice)paramThingContext.getIoTDevice();
    if ((paramThingContext != null) && ((paramThingContext.getLocalIoTDevice() instanceof IoTHubDevice)))
    {
      paramThingContext = (IoTHubDevice)paramThingContext.getLocalIoTDevice();
      this.n.postValue(paramThingContext);
    }
    else
    {
      this.n.postValue(new IoTHubDevice());
    }
    this.D.addSource(this.o, new x5(this));
  }
  
  private void B6(@Nullable List<HubAlarmLog> paramList, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    boolean bool = ((List)localObject).isEmpty();
    if (!paramBoolean)
    {
      paramList = J6();
      paramList.addAll((Collection)localObject);
      ((List)localObject).clear();
      ((List)localObject).addAll(paramList);
    }
    I6((List)localObject);
    L6((List)localObject);
    this.G.postValue(localObject);
    C6(bool ^ true);
    if (!((List)localObject).isEmpty()) {
      this.H = ((HubAlarmLog)((List)localObject).get(((List)localObject).size() - 1)).getId();
    }
  }
  
  private void C6(boolean paramBoolean)
  {
    this.I = paramBoolean;
    this.J.postValue(Boolean.valueOf(paramBoolean));
  }
  
  private q<List<HubAlarmLog>> E6()
  {
    return o5(null, null, 20, null, "DESC");
  }
  
  private io.reactivex.a F6()
  {
    return this.d.a1(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName());
  }
  
  private void I6(@Nullable List<HubAlarmLog> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        HubAlarmLog localHubAlarmLog = (HubAlarmLog)localIterator.next();
        if ((!TextUtils.isEmpty(localHubAlarmLog.getEventId())) && (!localHashSet.contains(localHubAlarmLog.getEventId())))
        {
          localArrayList.add(localHubAlarmLog);
          localHashSet.add(localHubAlarmLog.getEventId());
        }
      }
      localHashSet.clear();
      paramList.clear();
      paramList.addAll(localArrayList);
    }
  }
  
  @NonNull
  private List<HubAlarmLog> J6()
  {
    Object localObject = b.d.w.d.a.c(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), "hub_alarm_log_cache_list", ((ThingContext)this.a).getDeviceIdMD5(), HubAlarmLog.class);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      I6((List)localObject);
    }
    if (localObject == null) {
      localObject = new ArrayList();
    }
    return (List<HubAlarmLog>)localObject;
  }
  
  @NonNull
  private List<String> K6()
  {
    Object localObject = b.d.w.d.a.c(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), "hub_support_alarm_type_list", ((ThingContext)this.a).getDeviceIdMD5(), String.class);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    return (List<String>)localObject;
  }
  
  private void L6(@Nullable List<HubAlarmLog> paramList)
  {
    b.d.w.d.a.l(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), paramList, "hub_alarm_log_cache_list", ((ThingContext)this.a).getDeviceIdMD5());
  }
  
  private List<String> O6(@NonNull List<String> paramList)
  {
    b localb = new b();
    paramList = new ArrayList(paramList);
    Collections.sort(paramList, localb);
    return paramList;
  }
  
  private void R6(@NonNull List<String> paramList)
  {
    b.d.w.d.a.l(b.d.w.h.a.g(b.d.s.a.a.f().c().getCloudUserName()), paramList, "hub_support_alarm_type_list", ((ThingContext)this.a).getDeviceIdMD5());
  }
  
  @Nullable
  private String e5(List<HubAlarmLog> paramList, Long paramLong)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramLong != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = paramList.size() - 1; i >= 0; i--)
      {
        HubAlarmLog localHubAlarmLog = (HubAlarmLog)paramList.get(i);
        if (localHubAlarmLog.getTimestamp() != paramLong.longValue()) {
          break;
        }
        if (localHubAlarmLog.getEventId() != null)
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append(localHubAlarmLog.getEventId());
        }
      }
      paramList = new StringBuilder();
      paramList.append("filterIds: ");
      paramList.append(localStringBuilder.toString());
      b.d.w.c.a.n("AlarmLog", paramList.toString());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private q<List<HubAlarmLog>> o5(Long paramLong1, Long paramLong2, int paramInt, String paramString1, String paramString2)
  {
    return this.d.h0(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), paramLong1, paramLong2, paramInt, paramString1, paramString2).g0(n6.c);
  }
  
  private q<List<HubAlarmLog>> y6()
  {
    Object localObject = J6();
    Long localLong;
    if (!((List)localObject).isEmpty())
    {
      localLong = Long.valueOf(((HubAlarmLog)((List)localObject).get(((List)localObject).size() - 1)).getTimestamp());
      localObject = e5((List)localObject, localLong);
    }
    else
    {
      localLong = null;
      localObject = localLong;
    }
    return o5(null, localLong, 20, (String)localObject, "DESC");
  }
  
  private q<ThingServiceExecResult> z6(PlayAlarmParams paramPlayAlarmParams)
  {
    if (paramPlayAlarmParams == null) {
      return q.J(new Throwable("PlayAlarmParams is null"));
    }
    k localk = new k();
    localk.m("type", paramPlayAlarmParams.getAlarmType());
    localk.m("volume", paramPlayAlarmParams.getAlarmVolume());
    paramPlayAlarmParams = new ThingServiceParams("ring", localk);
    return this.d.P(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), ((ThingContext)this.a).getThingGatewayUrlV2(), paramPlayAlarmParams);
  }
  
  public io.reactivex.a A6(PlayAlarmParams paramPlayAlarmParams)
  {
    return y0("play_alarm", paramPlayAlarmParams, Boolean.class).o0(new u6(this, paramPlayAlarmParams)).Z();
  }
  
  public io.reactivex.a D6()
  {
    return E6().E(new u5(this)).Z();
  }
  
  public io.reactivex.a G6()
  {
    return F6().i(new z5(this));
  }
  
  public io.reactivex.a H6(DeviceIdListParams paramDeviceIdListParams)
  {
    return y0("remove_child_device_list", paramDeviceIdListParams, Boolean.class).Z();
  }
  
  public io.reactivex.a M6(GuardModeParams paramGuardModeParams)
  {
    if ((this.n.getValue() instanceof IoTHubDevice))
    {
      IoTHubDevice localIoTHubDevice = (IoTHubDevice)this.n.getValue();
      this.i = localIoTHubDevice.getDeviceInfoParams();
      localIoTHubDevice.setGuardOn(paramGuardModeParams.getEnable());
      localIoTHubDevice.setGuardMode(paramGuardModeParams.getGuardMode());
      this.n.postValue(localIoTHubDevice);
      this.b.L3();
    }
    return y0("set_guard_mode", paramGuardModeParams, Boolean.class).Z().u(new m6(this, paramGuardModeParams)).j(new cb(this));
  }
  
  public io.reactivex.a N6(ThingRuleGuardMode paramThingRuleGuardMode)
  {
    return y0("set_guard_mode_config", paramThingRuleGuardMode, Boolean.class).L0(io.reactivex.l0.a.c()).o0(new s6(this, paramThingRuleGuardMode)).z(new k6(this, paramThingRuleGuardMode)).C(new i6(this)).Z();
  }
  
  public io.reactivex.a P6()
  {
    return y0("stop_alarm", null, Boolean.class).Z().u(new l6(this)).i(new a6(this));
  }
  
  public io.reactivex.a Q6()
  {
    return y0("stop_alarm", null, Boolean.class).Z().u(new p6(this));
  }
  
  protected void e()
  {
    this.c.l();
    super.e();
  }
  
  public LiveData<List<HubAlarmLog>> f5()
  {
    return this.G;
  }
  
  public LiveData<Boolean> g5()
  {
    return this.J;
  }
  
  public LiveData<IoTHubDevice> h5()
  {
    return Transformations.map(super.j1(), new a());
  }
  
  public q<LoadInfoBean> i5()
  {
    return y0("get_device_load_info", null, LoadInfoBean.class).E(new o6(this));
  }
  
  public q<LoadInfoBean> j5()
  {
    return y0("get_device_load_info", null, LoadInfoBean.class).o0(new v5(this)).E(new j6(this));
  }
  
  @Nullable
  public String k5()
  {
    return this.F;
  }
  
  public LiveData<List<GuardModeConfigBean>> l5()
  {
    return this.K;
  }
  
  public q<GuardModeRuleResult> m5()
  {
    return x0("get_guard_mode_configs", GuardModeRuleResult.class).L0(io.reactivex.l0.a.c()).o0(new b6(this)).E(new h6(this)).C(new x6(this));
  }
  
  public LiveData<LoadInfoBean> n5()
  {
    return this.D;
  }
  
  public q<List<String>> p5()
  {
    if ((this.C.getValue() != null) && (!((List)this.C.getValue()).isEmpty())) {
      return q.f0(this.C.getValue()).g0(new t6(this)).E(new y5(this));
    }
    List localList = K6();
    if (!localList.isEmpty()) {
      return q.f0(localList).g0(new t6(this)).E(new g6(this));
    }
    return y0("get_support_alarm_type_list", null, ThingSupportAlarm.class).o0(new w6(this)).g0(c6.c).g0(new t6(this)).E(new d6(this)).C(new w5(this));
  }
  
  public MutableLiveData<List<String>> q5()
  {
    return this.C;
  }
  
  public q<ThingSupportCategory> r5()
  {
    return y0("get_support_child_device_category", null, ThingSupportCategory.class).o0(new v6(this)).E(new e6(this));
  }
  
  public LiveData<List<SubThingCategoryBean>> s5()
  {
    return this.E;
  }
  
  public void w6()
  {
    this.G.postValue(J6());
  }
  
  public io.reactivex.a x6()
  {
    if (!this.I)
    {
      C6(false);
      return io.reactivex.a.e();
    }
    return y6().E(new f6(this)).Z();
  }
  
  class a
    implements Function<LocalIoTBaseDevice, IoTHubDevice>
  {
    a() {}
    
    public IoTHubDevice a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      if ((paramLocalIoTBaseDevice instanceof IoTHubDevice)) {
        return (IoTHubDevice)paramLocalIoTBaseDevice;
      }
      return null;
    }
  }
  
  class b
    implements Comparator<String>
  {
    private final Pattern c = Pattern.compile("(.*) ([0-9]*)");
    
    b() {}
    
    public int a(String paramString1, String paramString2)
    {
      Matcher localMatcher1 = this.c.matcher(paramString1);
      Matcher localMatcher2 = this.c.matcher(paramString2);
      if ((localMatcher1.matches()) && (localMatcher2.matches()) && (localMatcher1.groupCount() == 2) && (localMatcher2.groupCount() == 2) && (TextUtils.equals(localMatcher1.group(1), localMatcher2.group(1)))) {
        try
        {
          int i = Integer.parseInt(localMatcher1.group(2));
          int j = Integer.parseInt(localMatcher2.group(2));
          return i - j;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
      return paramString1.compareTo(paramString2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\HubRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */