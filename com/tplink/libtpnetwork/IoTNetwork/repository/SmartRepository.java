package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.c.b.i;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.smart.result.SmartExecResult;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.mqtt.MqttRepository;
import com.tplink.iot.cloud.mqtt.q0;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.d;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.j;
import io.reactivex.m0.g;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SmartRepository
  extends AbstractIoTCloudRepository
  implements q0
{
  public static final String[] h = { "SmartTimeTrigger", "SmartDeviceTrigger", "SmartMultiTrigger" };
  public static final String[] i = { "SmartOneClick", "SmartLeaveHome", "SmartBackToHome", "SmartSleepMode", "SmartRead", "SmartVedio", "SmartGame", "SmartMusic", "SmartWake", "SmartScanning", "SmartMission", "SmartAuto" };
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> A = new MutableLiveData();
  private String[] B = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  private i j;
  private com.tplink.iot.c.b.a k;
  private com.tplink.iot.c.c.a l;
  private ThingCloudRepository m;
  private MqttRepository n;
  private Map<String, g<AsyncResult>> o = new HashMap();
  private MutableLiveData<List<SmartTemplate>> p = new MutableLiveData();
  private Map<String, SmartInfo> q = new LinkedHashMap();
  private MutableLiveData<List<SmartInfo>> r = new MutableLiveData();
  private SingleLiveEvent<Boolean> s = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> t = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> u = new SingleLiveEvent();
  private MutableLiveData<List<SmartLog>> v = new MutableLiveData();
  private MutableLiveData<List<SmartLog>> w = new MutableLiveData();
  private SingleLiveEvent<Boolean> x = new SingleLiveEvent();
  private MutableLiveData<List<ThingInfo>> y = new MutableLiveData();
  private MediatorLiveData<Boolean> z = new MediatorLiveData();
  
  public SmartRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.l = parama;
    this.j = ((i)parama.k().R1(i.class));
    this.k = ((com.tplink.iot.c.b.a)parama.k().R1(com.tplink.iot.c.b.a.class));
    this.n = ((MqttRepository)b.d.b.f.b.a(parama, MqttRepository.class));
    this.m = ((ThingCloudRepository)b.d.b.f.b.a(parama, ThingCloudRepository.class));
    B1();
    this.z.addSource(this.m.k0(), new a());
  }
  
  private void A1()
  {
    if (this.q != null) {
      this.r.postValue(d0());
    } else {
      this.r.postValue(null);
    }
  }
  
  private void B1()
  {
    if ((this.l.c() != null) && (!TextUtils.isEmpty(this.l.c().getCloudUserName())))
    {
      Object localObject1 = b.d.w.h.a.g(this.l.c().getCloudUserName());
      Object localObject2;
      try
      {
        localObject1 = b.d.w.d.a.c((String)localObject1, "shortcut_list_cache_key", "shortcut_list_cache_key", SmartInfo.class);
      }
      catch (Exception localException)
      {
        localObject2 = new ArrayList();
      }
      Object localObject3 = this.q;
      if (localObject3 != null)
      {
        ((Map)localObject3).clear();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SmartInfo)((Iterator)localObject2).next();
          this.q.put(((SmartInfo)localObject3).getId(), localObject3);
        }
        A1();
      }
    }
  }
  
  private void C1()
  {
    if ((this.l.c() != null) && (!TextUtils.isEmpty(this.l.c().getCloudUserName()))) {
      b.d.w.d.a.l(b.d.w.h.a.g(this.l.c().getCloudUserName()), d0(), "shortcut_list_cache_key", "shortcut_list_cache_key");
    }
  }
  
  private boolean E(@Nullable String paramString, @Nullable Object paramObject)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if ((!bool1) && (paramObject != null))
    {
      paramString = L(paramString);
      if ((paramString instanceof ALIoTDevice))
      {
        paramString = (ALIoTDevice)paramString;
        if (paramString.getLocalIoTDevice() == null) {
          return false;
        }
        paramObject = LightingEffectData.resolveObject(paramObject);
        if (paramObject == null) {
          return false;
        }
        if ((Type.PULSE.name().equalsIgnoreCase(((LightingEffectData)paramObject).type)) && ("Sunrise".equalsIgnoreCase(((LightingEffectData)paramObject).name)))
        {
          if (paramString.getLocalIoTDevice().getComponentVersion(EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT) >= 2) {
            bool2 = true;
          }
          return bool2;
        }
        return true;
      }
    }
    return false;
  }
  
  private void E1(List<SmartInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        SmartInfo localSmartInfo = (SmartInfo)localIterator.next();
        if (localSmartInfo.getTriggerSetting() != null) {
          if (localSmartInfo.getTriggerSetting().isManual()) {
            localArrayList1.add(localSmartInfo);
          } else {
            localArrayList2.add(localSmartInfo);
          }
        }
      }
      z1(localArrayList1);
      paramList.clear();
      paramList.addAll(localArrayList1);
      paramList.addAll(localArrayList2);
    }
  }
  
  private void F1(List<SmartTemplate> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        SmartTemplate localSmartTemplate = (SmartTemplate)localIterator.next();
        if (localSmartTemplate.getTriggerSetting() != null) {
          if (localSmartTemplate.getTriggerSetting().isManual()) {
            localArrayList1.add(localSmartTemplate);
          } else {
            localArrayList2.add(localSmartTemplate);
          }
        }
      }
      paramList.clear();
      paramList.addAll(localArrayList1);
      paramList.addAll(localArrayList2);
    }
  }
  
  private t<AsyncResult> G1(final SmartExecResult paramSmartExecResult, String paramString)
  {
    return io.reactivex.q.f0(paramSmartExecResult).N(new p8(this)).T0(15L, TimeUnit.SECONDS).o0(new f(paramSmartExecResult)).y(new e(paramSmartExecResult));
  }
  
  private void K(List<ThingInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ThingInfo)paramList.next();
        if (EnumDeviceType.SWITCH.getDeviceType().equals(((ThingInfo)localObject).getDeviceType()))
        {
          localArrayList.add(((SwitchRepository)e.d(b.d.w.h.a.g(((ThingInfo)localObject).getThingName()), SwitchRepository.class)).m4());
        }
        else if (EnumDeviceType.CAMERA.getDeviceType().equals(((ThingInfo)localObject).getDeviceType()))
        {
          localObject = b.d.w.h.a.g(((ThingInfo)localObject).getThingName());
          int i1;
          if ((d.d((String)localObject)) && (d.c((String)localObject) == null)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0) {
            localArrayList.add(d.b((String)localObject));
          }
        }
      }
      io.reactivex.q.k0(localArrayList, 10).z(new e9(this)).F0();
    }
  }
  
  @Nullable
  private BaseALIoTDevice L(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = (List)((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).C1().getValue();
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
  
  private io.reactivex.q<List<SmartInfo>> T(ThingListPageParams paramThingListPageParams)
  {
    ArrayList localArrayList = new ArrayList();
    return c0(paramThingListPageParams).g0(new p9(this, localArrayList, paramThingListPageParams)).w0(d9.c).E(new g9(this)).C(new u8(this)).y(new l9(this));
  }
  
  private io.reactivex.q<List<SmartTemplate>> V(String paramString, ThingListPageParams paramThingListPageParams)
  {
    ArrayList localArrayList = new ArrayList();
    return l0(paramString, paramThingListPageParams).g0(new k9(this, localArrayList, paramThingListPageParams)).w0(z8.c).E(new w8(this)).C(new j9(this));
  }
  
  private io.reactivex.q<PageListResult<SmartInfo>> c0(final ThingListPageParams paramThingListPageParams)
  {
    return d().N(new c(paramThingListPageParams));
  }
  
  private List<SmartInfo> d0()
  {
    Object localObject1;
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(this.q.values());
    }
    catch (Exception localException)
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    return (List<SmartInfo>)localObject2;
  }
  
  private io.reactivex.q<PageListResult<SmartLog>> f0(final ThingListPageParams paramThingListPageParams, final Integer paramInteger1, final Integer paramInteger2)
  {
    return d().N(new h(paramThingListPageParams, paramInteger1, paramInteger2));
  }
  
  private io.reactivex.q<List<SmartLog>> j0(ThingListPageParams paramThingListPageParams, Integer paramInteger1, Integer paramInteger2)
  {
    return f0(paramThingListPageParams, paramInteger1, paramInteger2).g0(j8.c);
  }
  
  private List<String> k0()
  {
    return b.d.w.d.a.c(b.d.w.h.a.g(this.l.c().getCloudUserName()), "smart_shortcut_list", "smart_shortcut_list", String.class);
  }
  
  private io.reactivex.q<PageListResult<SmartTemplate>> l0(final String paramString, final ThingListPageParams paramThingListPageParams)
  {
    return d().N(new b(paramThingListPageParams, paramString));
  }
  
  private boolean r0(SmartThingTrigger paramSmartThingTrigger, ThingInfo paramThingInfo)
  {
    if ((paramSmartThingTrigger != null) && (paramThingInfo != null))
    {
      if (paramSmartThingTrigger.getEvent() != null)
      {
        paramSmartThingTrigger = paramSmartThingTrigger.getEvent().getName();
        if (com.tplink.libtpnetwork.Utils.q.c(paramSmartThingTrigger)) {
          return com.tplink.libtpnetwork.Utils.q.a(paramSmartThingTrigger, b.d.w.h.a.g(paramThingInfo.getThingName()));
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean s0(SmartThingTrigger paramSmartThingTrigger, ThingInfo paramThingInfo)
  {
    if ((paramSmartThingTrigger != null) && (paramThingInfo != null))
    {
      if ((paramSmartThingTrigger.getEvent() != null) && ("doubleClick".equals(paramSmartThingTrigger.getEvent().getName())))
      {
        paramThingInfo = (DoubleClickInfoBean)((SwitchRepository)e.d(b.d.w.h.a.g(paramThingInfo.getThingName()), SwitchRepository.class)).n4().getValue();
        if (paramThingInfo != null)
        {
          paramSmartThingTrigger = new StringBuilder();
          paramSmartThingTrigger.append("isSmartSwitchTriggerAvailable: ");
          paramSmartThingTrigger.append(paramThingInfo.getEnable());
          b.d.w.c.a.n("Smart", paramSmartThingTrigger.toString());
          return paramThingInfo.getEnable();
        }
      }
      return true;
    }
    return false;
  }
  
  private io.reactivex.q<AsyncResult> y1(final String paramString)
  {
    return d().N(new g(paramString));
  }
  
  private void z1(List<SmartInfo> paramList)
  {
    Object localObject = k0();
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(paramList);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = localArrayList2.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SmartInfo localSmartInfo = (SmartInfo)((Iterator)localObject).next();
          if (str.equals(localSmartInfo.getId()))
          {
            localArrayList1.add(localSmartInfo);
            paramList.remove(localSmartInfo);
          }
        }
      }
      paramList.addAll(localArrayList1);
    }
  }
  
  public void D1(List<SmartInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((SmartInfo)paramList.next()).getId());
      }
    }
    b.d.w.d.a.l(b.d.w.h.a.g(this.l.c().getCloudUserName()), localArrayList, "smart_shortcut_list", "smart_shortcut_list");
  }
  
  public io.reactivex.a F(SmartInfo paramSmartInfo)
  {
    return d().R(new m9(this, paramSmartInfo));
  }
  
  public io.reactivex.a G()
  {
    return d().R(new q9(this));
  }
  
  public io.reactivex.a H(String paramString)
  {
    return d().R(new t8(this, paramString));
  }
  
  public io.reactivex.a I(SmartInfo paramSmartInfo)
  {
    return d().R(new n9(this, paramSmartInfo));
  }
  
  public io.reactivex.q<AsyncResult> J(final String paramString)
  {
    this.n.w(this).C(io.reactivex.l0.a.c()).y();
    return d().N(new d(paramString));
  }
  
  public SmartInfo M(String paramString)
  {
    if ((this.q != null) && (!TextUtils.isEmpty(paramString))) {
      return (SmartInfo)this.q.get(paramString);
    }
    return null;
  }
  
  public ThingInfo N(String paramString)
  {
    Object localObject = (List)this.y.getValue();
    if ((localObject != null) && (paramString != null))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ThingInfo localThingInfo = (ThingInfo)((Iterator)localObject).next();
        if (paramString.equals(localThingInfo.getThingName())) {
          return localThingInfo;
        }
      }
    }
    return null;
  }
  
  public String O()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = UUID.randomUUID().toString().replace("-", "");
    for (int i1 = 0; i1 < 8; i1++)
    {
      int i2 = i1 * 4;
      i2 = Integer.parseInt(str.substring(i2, i2 + 4), 16);
      localStringBuilder.append(this.B[(i2 % 62)]);
    }
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<SmartInfo>> P()
  {
    return this.r;
  }
  
  public io.reactivex.q<List<ThingInfo>> Q()
  {
    return R(false);
  }
  
  public io.reactivex.q<List<ThingInfo>> R(boolean paramBoolean)
  {
    return this.m.S().E(new h9(this, paramBoolean)).C(new l8(this));
  }
  
  public io.reactivex.q<List<SmartInfo>> S()
  {
    return T(new ThingListPageParams(0, 20));
  }
  
  public io.reactivex.q<List<SmartTemplate>> U(String paramString)
  {
    return V(paramString, new ThingListPageParams(0, 20));
  }
  
  public MutableLiveData<List<ThingInfo>> W()
  {
    return this.y;
  }
  
  public SingleLiveEvent<Boolean> X()
  {
    return this.t;
  }
  
  public SingleLiveEvent<Boolean> Y()
  {
    return this.x;
  }
  
  public SingleLiveEvent<Boolean> Z()
  {
    return this.u;
  }
  
  public void a(AsyncResult paramAsyncResult)
  {
    g localg = (g)this.o.remove(paramAsyncResult.getRequestId());
    Object localObject = localg;
    if (localg == null)
    {
      localObject = io.reactivex.m0.b.n1();
      this.o.put(paramAsyncResult.getRequestId(), localObject);
    }
    if (paramAsyncResult.getCode() == 0)
    {
      ((v)localObject).onNext(paramAsyncResult);
      ((v)localObject).onComplete();
    }
    else
    {
      ((v)localObject).onError(new IoTCloudException(paramAsyncResult.getCode(), paramAsyncResult.getMessage(), paramAsyncResult.getData()));
    }
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> a0()
  {
    return this.A;
  }
  
  protected void b()
  {
    super.b();
    this.o.clear();
  }
  
  public SingleLiveEvent<Boolean> b0()
  {
    return this.s;
  }
  
  public MutableLiveData<List<SmartLog>> e0()
  {
    return this.w;
  }
  
  public io.reactivex.q<List<SmartLog>> g0(Integer paramInteger1, Integer paramInteger2)
  {
    return j0(new ThingListPageParams(0, 100), paramInteger1, paramInteger2).E(new v8(this)).C(new i9(this));
  }
  
  public io.reactivex.q<List<SmartLog>> h0(Integer paramInteger1, Integer paramInteger2)
  {
    return j0(new ThingListPageParams(0, 100), paramInteger1, paramInteger2).E(new y8(this, paramInteger1)).C(new r8(this));
  }
  
  public MutableLiveData<List<SmartLog>> i0()
  {
    return this.v;
  }
  
  public MutableLiveData<List<SmartTemplate>> m0()
  {
    return this.p;
  }
  
  public MutableLiveData<Boolean> n0()
  {
    return this.z;
  }
  
  public ThingModel o0(@Nullable String paramString)
  {
    return this.m.m0(paramString);
  }
  
  public io.reactivex.q<ThingSetting> p0(String paramString)
  {
    ThingContext localThingContext = TPIoTClientManager.k2(b.d.w.h.a.g(paramString));
    return this.m.q0(localThingContext.getThingUrl(), paramString).L0(io.reactivex.l0.a.c());
  }
  
  public boolean q0(String paramString)
  {
    paramString = M(paramString);
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      bool2 = bool1;
      if (paramString.getActionSetting() != null) {
        if (paramString.getTriggerSetting() == null)
        {
          bool2 = bool1;
        }
        else
        {
          boolean bool3 = paramString.getTriggerSetting().isManual();
          Object localObject2;
          Object localObject3;
          if (!bool3)
          {
            localObject1 = paramString.getTriggerSetting().getSchedules();
            if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            localObject1 = paramString.getTriggerSetting().getThings();
            if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
            {
              localObject2 = ((List)localObject1).iterator();
              boolean bool4 = false;
              do
              {
                bool2 = bool4;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localObject1 = (SmartThingTrigger)((Iterator)localObject2).next();
                localObject3 = L(((SmartThingTrigger)localObject1).getThingName());
                if ((localObject3 != null) && (((BaseALIoTDevice)localObject3).isOnline())) {
                  i2 = 1;
                } else {
                  i2 = 0;
                }
                localObject3 = N(((SmartThingTrigger)localObject1).getThingName());
                bool2 = bool4;
                if (i2 != 0)
                {
                  bool2 = bool4;
                  if (localObject3 != null) {
                    if (EnumDeviceType.SWITCH.getDeviceType().equals(((ThingInfo)localObject3).getDeviceType())) {
                      bool2 = s0((SmartThingTrigger)localObject1, (ThingInfo)localObject3);
                    } else if (EnumDeviceType.CAMERA.getDeviceType().equals(((ThingInfo)localObject3).getDeviceType())) {
                      bool2 = r0((SmartThingTrigger)localObject1, (ThingInfo)localObject3);
                    } else {
                      bool2 = true;
                    }
                  }
                }
                bool4 = bool2;
              } while (!bool2);
            }
            else
            {
              bool2 = false;
            }
            if ((i1 != 0) || (bool2))
            {
              i1 = 1;
              break label293;
            }
          }
          int i1 = 0;
          label293:
          Object localObject1 = paramString.getActionSetting().getThings();
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (SmartThingAction)((Iterator)localObject1).next();
              localObject2 = L(((SmartThingAction)localObject3).getThingName());
              if ((localObject2 != null) && (((BaseALIoTDevice)localObject2).isOnline())) {
                i2 = 1;
              } else {
                i2 = 0;
              }
              if ((i2 != 0) && (N(((SmartThingAction)localObject3).getThingName()) != null))
              {
                i2 = 1;
                break label407;
              }
            }
          }
          int i2 = 0;
          label407:
          paramString = paramString.getActionSetting().getSmarts();
          if ((paramString != null) && (!paramString.isEmpty()))
          {
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
              if (M(((SmartReferAction)paramString.next()).getId()) != null)
              {
                i3 = 1;
                break label472;
              }
            }
          }
          int i3 = 0;
          label472:
          if (!bool3)
          {
            bool2 = bool1;
            if (i1 == 0) {}
          }
          else if (i2 == 0)
          {
            bool2 = bool1;
            if (i3 == 0) {}
          }
          else
          {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean t0(@Nullable String paramString1, @Nullable SmartThingAction paramSmartThingAction, @Nullable String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = bool2;
    if (!bool1)
    {
      bool4 = bool2;
      if (paramSmartThingAction != null) {
        if (TextUtils.isEmpty(paramString2))
        {
          bool4 = bool2;
        }
        else
        {
          paramString1 = o0(paramString1);
          if (paramString1 == null) {
            return false;
          }
          if (paramSmartThingAction.getStateDesired() != null)
          {
            paramSmartThingAction = paramSmartThingAction.getStateDesired();
            Iterator localIterator = paramSmartThingAction.keySet().iterator();
            while (localIterator.hasNext()) {
              if (paramString1.getThingProperty((String)localIterator.next()) == null)
              {
                bool4 = bool3;
                break label117;
              }
            }
            bool4 = true;
            label117:
            if ((bool4) && (paramSmartThingAction.containsKey("lighting_effect"))) {
              return E(paramString2, paramSmartThingAction.get("lighting_effect"));
            }
            return bool4;
          }
          bool4 = bool2;
          if (paramSmartThingAction.getService() != null)
          {
            bool4 = bool2;
            if (paramString1.getThingService(paramSmartThingAction.getService().getServiceId()) != null) {
              bool4 = true;
            }
          }
        }
      }
    }
    return bool4;
  }
  
  class a
    implements Observer<List<ThingInfo>>
  {
    a() {}
    
    public void a(@Nullable List<ThingInfo> paramList)
    {
      SmartRepository.w(SmartRepository.this).postValue(paramList);
      SmartRepository.y(SmartRepository.this).postValue(SmartRepository.x(SmartRepository.this));
    }
  }
  
  class b
    implements j<String, t<PageListResult<SmartTemplate>>>
  {
    b(ThingListPageParams paramThingListPageParams, String paramString) {}
    
    public t<PageListResult<SmartTemplate>> a(String paramString)
      throws Exception
    {
      return io.reactivex.q.f0(paramThingListPageParams).N(new m8(this, paramString, paramString, paramThingListPageParams));
    }
  }
  
  class c
    implements j<String, t<PageListResult<SmartInfo>>>
  {
    c(ThingListPageParams paramThingListPageParams) {}
    
    public t<PageListResult<SmartInfo>> a(String paramString)
      throws Exception
    {
      return io.reactivex.q.f0(paramThingListPageParams).N(new n8(this, paramString, paramThingListPageParams)).L0(io.reactivex.l0.a.c());
    }
  }
  
  class d
    implements j<String, t<AsyncResult>>
  {
    d(String paramString) {}
    
    public t<AsyncResult> a(String paramString)
      throws Exception
    {
      return SmartRepository.z(SmartRepository.this).U(paramString, paramString).N(new o8(this, paramString)).L0(io.reactivex.l0.a.c());
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e(SmartExecResult paramSmartExecResult) {}
    
    public void run()
      throws Exception
    {
      SmartRepository.B(SmartRepository.this).remove(paramSmartExecResult.getRequestId());
    }
  }
  
  class f
    implements j<Throwable, t<AsyncResult>>
  {
    f(SmartExecResult paramSmartExecResult) {}
    
    public t<AsyncResult> a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof IoTCloudException)) {
        return io.reactivex.q.J(paramThrowable);
      }
      return SmartRepository.C(SmartRepository.this, paramSmartExecResult.getRequestId()).N(new a());
    }
    
    class a
      implements j<AsyncResult, t<AsyncResult>>
    {
      a() {}
      
      public t<AsyncResult> a(AsyncResult paramAsyncResult)
        throws Exception
      {
        if (paramAsyncResult.getCode() == 0) {
          return io.reactivex.q.f0(paramAsyncResult);
        }
        return io.reactivex.q.J(new IoTCloudException(paramAsyncResult.getCode(), paramAsyncResult.getMessage(), paramAsyncResult.getData()));
      }
    }
  }
  
  class g
    implements j<String, t<AsyncResult>>
  {
    g(String paramString) {}
    
    public t<AsyncResult> a(final String paramString)
      throws Exception
    {
      return io.reactivex.q.f0(paramString).N(new a(paramString));
    }
    
    class a
      implements j<String, t<AsyncResult>>
    {
      a(String paramString) {}
      
      public t<AsyncResult> a(String paramString)
        throws Exception
      {
        return SmartRepository.D(SmartRepository.this).G1(paramString, paramString).L0(io.reactivex.l0.a.c());
      }
    }
  }
  
  class h
    implements j<String, t<PageListResult<SmartLog>>>
  {
    h(ThingListPageParams paramThingListPageParams, Integer paramInteger1, Integer paramInteger2) {}
    
    public t<PageListResult<SmartLog>> a(String paramString)
      throws Exception
    {
      return io.reactivex.q.f0(paramThingListPageParams).N(new s8(this, paramString, paramThingListPageParams, paramInteger1, paramInteger2));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\SmartRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */