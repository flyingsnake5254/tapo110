package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.params.ThingBatchUnbindParams;
import com.tplink.iot.cloud.bean.thing.params.ThingCommonDeviceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingRuleDeleteParams;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingShadowUpdateParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingBatchUnbindResult;
import com.tplink.iot.cloud.bean.thing.result.ThingCommonDeviceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingComponentResult;
import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingSupportInfoResult;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.cloud.mqtt.MqttRepository;
import com.tplink.iot.cloud.mqtt.q0;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ThingServiceExecResult;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingModelCache;
import io.reactivex.e0.c;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;

public class ThingCloudRepository
  extends AbstractIoTCloudRepository
  implements q0
{
  private com.tplink.iot.c.b.j h;
  private com.tplink.iot.c.b.a i;
  private MqttRepository j;
  private Map<String, ThingDevice> k = new ConcurrentHashMap();
  private MutableLiveData<List<ThingDevice>> l = new MutableLiveData();
  private MutableLiveData<List<ThingInfo>> m = new MutableLiveData();
  private Map<String, io.reactivex.m0.g<Long>> n = new ConcurrentHashMap();
  private final Map<String, io.reactivex.m0.g<ThingServiceExecResult>> o = new ConcurrentHashMap();
  private Map<String, ThingModel> p = new ConcurrentHashMap();
  private q0 q;
  
  public ThingCloudRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = ((com.tplink.iot.c.b.j)parama.k().R1(com.tplink.iot.c.b.j.class));
    this.i = ((com.tplink.iot.c.b.a)parama.k().R1(com.tplink.iot.c.b.a.class));
    this.j = ((MqttRepository)b.d.b.f.b.a(parama, MqttRepository.class));
  }
  
  private q0 O()
  {
    if (this.q == null) {
      this.q = new v1(this);
    }
    return this.q;
  }
  
  private q<List<ThingDevice>> Q(ThingListPageParams paramThingListPageParams, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    return l0(paramThingListPageParams, paramString).g0(new r1(this, localArrayList2, localArrayList1, paramThingListPageParams)).w0(i1.c).C(new o1(this));
  }
  
  private q<List<ThingInfo>> T(ThingListPageParams paramThingListPageParams, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    return l0(paramThingListPageParams, paramString).L0(io.reactivex.l0.a.c()).g0(new j1(this, localArrayList2, localArrayList1, paramThingListPageParams)).w0(u1.c);
  }
  
  private void V0(AsyncResult paramAsyncResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onThingServiceExecAsyncResultArrived:");
    ((StringBuilder)localObject).append(com.tplink.libtpnetwork.Utils.i.j(paramAsyncResult));
    b.d.w.c.a.n("ThingService", ((StringBuilder)localObject).toString());
    io.reactivex.m0.g localg = (io.reactivex.m0.g)this.o.remove(paramAsyncResult.getRequestId());
    localObject = localg;
    if (localg == null)
    {
      localObject = io.reactivex.m0.b.n1();
      this.o.put(paramAsyncResult.getRequestId(), localObject);
    }
    if (paramAsyncResult.getCode() == 0)
    {
      ((v)localObject).onNext(new ThingServiceExecResult(paramAsyncResult.getRequestId(), paramAsyncResult.getData()));
      ((v)localObject).onComplete();
    }
    else
    {
      ((v)localObject).onError(new IoTCloudException(paramAsyncResult.getCode(), paramAsyncResult.getMessage(), paramAsyncResult.getData()));
    }
  }
  
  private q<AsyncResult> W0(final String paramString)
  {
    return d().N(new f(paramString));
  }
  
  private q<ThingModel> X0(String paramString1, final String paramString2)
  {
    return this.h.v1(paramString1, paramString2).L0(io.reactivex.l0.a.c()).E(new h(paramString2));
  }
  
  private q<AsyncResult> Y0(String paramString)
  {
    return d().N(new n1(this, paramString));
  }
  
  private void Z0(List<ThingInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = new ConcurrentHashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ThingInfo localThingInfo = (ThingInfo)paramList.next();
        String str = localThingInfo.getThingModelId();
        if ((!TextUtils.isEmpty(str)) && (!this.p.containsKey(str)) && (!((Map)localObject).containsKey(str))) {
          ((Map)localObject).put(str, localThingInfo);
        }
      }
      if (((Map)localObject).isEmpty()) {
        return;
      }
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (ThingInfo)((Iterator)localObject).next();
        X0(paramList.getAppServerUrl(), paramList.getThingModelId()).L0(io.reactivex.l0.a.c()).F0();
      }
    }
  }
  
  private void b1(String paramString)
  {
    this.k.remove(paramString);
    f1();
  }
  
  private void c1(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.k.remove(str);
    }
    f1();
  }
  
  private void e1()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.p.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new ThingModelCache((String)localEntry.getKey(), (ThingModel)localEntry.getValue()));
    }
    b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), localArrayList, "thing_model_list_key_v2", "thing_model_list_key_v2");
  }
  
  private void f1()
  {
    this.l.postValue(new ArrayList(this.k.values()));
  }
  
  private void g1(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = (ThingDevice)this.k.get(paramString);
    if (paramString != null) {
      paramString.setCommonDevice(paramBoolean);
    }
  }
  
  private q<ThingCommonDeviceResult> l1(String paramString, ThingCommonDeviceParams paramThingCommonDeviceParams)
  {
    return this.h.A1(paramString, paramThingCommonDeviceParams).L0(io.reactivex.l0.a.c());
  }
  
  private List<ThingDevice> r0(List<ThingInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(x0((ThingInfo)paramList.next()));
      }
    }
    return localArrayList;
  }
  
  private q<Long> s0(final ThingShadowUpdateResult paramThingShadowUpdateResult)
  {
    return q.f0(paramThingShadowUpdateResult).N(new x1(this)).T0(10L, TimeUnit.SECONDS).o0(new e(paramThingShadowUpdateResult)).y(new d(paramThingShadowUpdateResult));
  }
  
  private q<ThingServiceExecResult> w1(ThingServiceResult paramThingServiceResult)
  {
    return q.f0(paramThingServiceResult).N(new p1(this)).T0(10L, TimeUnit.SECONDS).o0(new s1(this, paramThingServiceResult)).y(new w1(this, paramThingServiceResult));
  }
  
  private ThingDevice x0(ThingInfo paramThingInfo)
  {
    ThingDevice localThingDevice = (ThingDevice)this.k.get(paramThingInfo.getThingName());
    if (localThingDevice != null)
    {
      localThingDevice.setThingInfo(paramThingInfo);
      paramThingInfo = localThingDevice;
    }
    else
    {
      paramThingInfo = new ThingDevice(paramThingInfo);
    }
    return paramThingInfo;
  }
  
  public q<ThingRuleUpdateResult> H(String paramString1, String paramString2, ThingRuleAwayMode paramThingRuleAwayMode)
  {
    return this.h.V0(paramString1, paramString2, paramThingRuleAwayMode).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleUpdateResult> I(String paramString1, String paramString2, ThingRuleSchedule paramThingRuleSchedule)
  {
    return this.h.L(paramString1, paramString2, paramThingRuleSchedule).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleUpdateResult> J(String paramString1, String paramString2, ThingRuleTimer paramThingRuleTimer)
  {
    return this.h.w0(paramString1, paramString2, paramThingRuleTimer).L0(io.reactivex.l0.a.c());
  }
  
  public q<Boolean> K(String paramString, final List<String> paramList)
  {
    return this.h.D1(paramString, new ThingBatchUnbindParams(paramList)).L0(io.reactivex.l0.a.c()).F(new k(paramList)).g0(new j());
  }
  
  public io.reactivex.a L(String paramString1, String paramString2, SubThingCategoryScanParams paramSubThingCategoryScanParams)
  {
    return this.h.y0(paramString1, paramString2, paramSubThingCategoryScanParams).C(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a M(String paramString1, String paramString2, SubThingAddListParams paramSubThingAddListParams)
  {
    return this.h.h(paramString1, paramString2, paramSubThingAddListParams).C(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a N(String paramString1, String paramString2, ThingRuleDeleteParams paramThingRuleDeleteParams)
  {
    return this.h.H1(paramString1, paramString2, paramThingRuleDeleteParams).C(io.reactivex.l0.a.c());
  }
  
  public q<ThingServiceExecResult> P(String paramString1, String paramString2, String paramString3, ThingServiceParams paramThingServiceParams)
  {
    this.j.x(paramString3, O()).L0(io.reactivex.l0.a.c()).F0();
    return this.h.A(paramString1, paramString2, paramThingServiceParams).N(new y1(this)).L0(io.reactivex.l0.a.c());
  }
  
  public List<ThingDevice> R()
  {
    return new ArrayList(this.k.values());
  }
  
  public q<List<ThingInfo>> S()
  {
    return T(new ThingListPageParams(0, 100), b.d.s.c.a.b());
  }
  
  public q<List<ThingDevice>> U()
  {
    return Q(new ThingListPageParams(0, 20), b.d.s.c.a.b());
  }
  
  public io.reactivex.a U0(String paramString1, String paramString2, String... paramVarArgs)
  {
    paramVarArgs = TextUtils.join(",", paramVarArgs);
    return this.h.J0(paramString1, paramString2, paramVarArgs).C(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleListResult<ThingRuleAwayMode>> V(String paramString1, String paramString2, int paramInt)
  {
    return this.h.w(paramString1, paramString2, paramInt).L0(io.reactivex.l0.a.c());
  }
  
  public q<FirmwareDownloadState> W(String paramString1, String paramString2)
  {
    return this.h.E0(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleListResult<ThingRuleGuardMode>> X(String paramString1, String paramString2, int paramInt)
  {
    return this.h.z(paramString1, paramString2, paramInt).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingNextEvent> Y(final String paramString)
  {
    return d().N(new a(paramString));
  }
  
  public q<ThingRuleListResult<ThingRuleLightEffect>> Z(String paramString1, String paramString2, int paramInt)
  {
    return this.h.I(paramString1, paramString2, paramInt).L0(io.reactivex.l0.a.c());
  }
  
  public void a(AsyncResult paramAsyncResult)
  {
    io.reactivex.m0.g localg = (io.reactivex.m0.g)this.n.remove(paramAsyncResult.getRequestId());
    Object localObject = localg;
    if (localg == null)
    {
      localObject = io.reactivex.m0.b.n1();
      this.n.put(paramAsyncResult.getRequestId(), localObject);
    }
    if (paramAsyncResult.getCode() == 0) {
      ((v)localObject).onComplete();
    } else {
      ((v)localObject).onError(new IoTCloudException(paramAsyncResult.getCode(), paramAsyncResult.getMessage(), paramAsyncResult.getData()));
    }
  }
  
  public q<NextEvent> a0(String paramString1, String paramString2)
  {
    return this.h.l1(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a a1(String paramString1, String paramString2)
  {
    return this.h.f1(paramString1, paramString2).C(io.reactivex.l0.a.c());
  }
  
  protected void b()
  {
    super.b();
    this.n.clear();
  }
  
  public q<List<ThingNextEvent>> b0(final String paramString)
  {
    return d().N(new b(paramString));
  }
  
  public q<SubThingScanListResult> c0(String paramString1, String paramString2)
  {
    return this.h.K(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleListResult<ThingRuleSchedule>> d0(String paramString1, String paramString2, int paramInt)
  {
    return this.h.g0(paramString1, paramString2, paramInt).L0(io.reactivex.l0.a.c());
  }
  
  public void d1()
  {
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Object localObject2;
    try
    {
      localObject1 = b.d.w.d.a.c((String)localObject1, "thing_model_list_key_v2", "thing_model_list_key_v2", ThingModelCache.class);
    }
    catch (Exception localException)
    {
      localObject2 = new ArrayList();
    }
    this.p.clear();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (ThingModelCache)localIterator.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ThingModelCache)localObject2).getThingModelId()))) {
          this.p.put(((ThingModelCache)localObject2).getThingModelId(), ((ThingModelCache)localObject2).getThingModel());
        }
      }
    }
  }
  
  public q<ThingComponentResult> e0(String paramString1, String paramString2)
  {
    return this.h.t0(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingDetail> f0(String paramString1, String paramString2)
  {
    return this.h.M1(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public MutableLiveData<List<ThingDevice>> g0()
  {
    return this.l;
  }
  
  public q<ThingEventLogResult> h0(String paramString1, String paramString2, Long paramLong1, Long paramLong2, int paramInt, String paramString3, String paramString4)
  {
    return this.h.j(paramString1, paramString2, paramLong1, paramLong2, paramInt, paramString3, paramString4).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleUpdateResult> h1(String paramString1, String paramString2, String paramString3, ThingRuleGuardMode paramThingRuleGuardMode)
  {
    return this.h.p0(paramString1, paramString2, paramString3, paramThingRuleGuardMode).L0(io.reactivex.l0.a.c());
  }
  
  public q<com.google.gson.i> i0(String paramString1, String paramString2, String paramString3)
  {
    return this.h.G(paramString1, paramString2, paramString3).L0(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a i1(String paramString1, String paramString2, SubThingQuickSetupInfoListParams paramSubThingQuickSetupInfoListParams)
  {
    return this.h.W(paramString1, paramString2, paramSubThingQuickSetupInfoListParams).C(io.reactivex.l0.a.c());
  }
  
  public q<ThingFirmware> j0(String paramString1, String paramString2)
  {
    return this.h.R0(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a j1(String paramString1, final String paramString2)
  {
    return this.h.E1(paramString1, paramString2).C(io.reactivex.l0.a.c()).l(new i(paramString2));
  }
  
  public MutableLiveData<List<ThingInfo>> k0()
  {
    return this.m;
  }
  
  public q<ThingRuleUpdateResult> k1(String paramString1, String paramString2, String paramString3, ThingRuleAwayMode paramThingRuleAwayMode)
  {
    return this.h.D(paramString1, paramString2, paramString3, paramThingRuleAwayMode).L0(io.reactivex.l0.a.c());
  }
  
  public q<PageListResult<ThingInfo>> l0(final ThingListPageParams paramThingListPageParams, final String paramString)
  {
    return d().N(new g(paramThingListPageParams, paramString));
  }
  
  public ThingModel m0(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (ThingModel)this.p.get(paramString);
  }
  
  public q<Boolean> m1(final List<String> paramList, final boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return d().N(new c(paramBoolean, paramList));
    }
    return q.f0(Boolean.FALSE);
  }
  
  public q<ThingModel> n0(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      ThingModel localThingModel = (ThingModel)this.p.get(paramString2);
      if (localThingModel != null) {
        return q.f0(localThingModel);
      }
    }
    return X0(paramString1, paramString2);
  }
  
  public q<ThingRuleUpdateResult> n1(String paramString1, String paramString2, String paramString3, ThingRuleLightEffect paramThingRuleLightEffect)
  {
    return this.h.S(paramString1, paramString2, paramString3, paramThingRuleLightEffect).L0(io.reactivex.l0.a.c());
  }
  
  public q<com.google.gson.i> o0(String paramString1, String paramString2)
  {
    return this.h.X0(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleUpdateResult> o1(String paramString1, String paramString2, String paramString3, ThingRuleSchedule paramThingRuleSchedule)
  {
    return this.h.m(paramString1, paramString2, paramString3, paramThingRuleSchedule).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRealTimeInfo> p0(String paramString1, String paramString2)
  {
    return this.h.x(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public q<com.google.gson.i> p1(String paramString1, String paramString2, String paramString3, com.google.gson.i parami)
  {
    return this.h.i0(paramString1, paramString2, paramString3, parami).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingSetting> q0(String paramString1, String paramString2)
  {
    return this.h.M0(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a q1(String paramString1, String paramString2, com.google.gson.i parami)
  {
    return this.h.T0(paramString1, paramString2, parami).C(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a r1(String paramString1, String paramString2, Integer paramInteger, com.google.gson.i parami)
  {
    return this.h.O(paramString1, paramString2, paramInteger, parami).C(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a s1(String paramString1, String paramString2, ThingSetting paramThingSetting)
  {
    return this.h.s0(paramString1, paramString2, paramThingSetting).C(io.reactivex.l0.a.c());
  }
  
  public q<ThingShadowListResult> t0(String paramString, String... paramVarArgs)
  {
    return this.h.H0(paramString, paramVarArgs).L0(io.reactivex.l0.a.c());
  }
  
  public q<Long> t1(String paramString1, String paramString2, String paramString3, ThingShadowUpdateParams paramThingShadowUpdateParams, IMqttMessageListener paramIMqttMessageListener)
  {
    this.j.y(paramString3, this, paramString2, paramIMqttMessageListener).C(io.reactivex.l0.a.c()).y();
    return this.h.O1(paramString1, paramString2, paramThingShadowUpdateParams).N(new q1(this)).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingSupportInfoResult> u0(String paramString1, String paramString2, String paramString3)
  {
    return this.h.Z(paramString1, paramString2, paramString3).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleUpdateResult> u1(String paramString1, String paramString2, String paramString3, ThingRuleTimer paramThingRuleTimer)
  {
    return this.h.u1(paramString1, paramString2, paramString3, paramThingRuleTimer).L0(io.reactivex.l0.a.c());
  }
  
  public q<ThingUsage> v0(String paramString1, String paramString2)
  {
    return this.h.x0(paramString1, paramString2).L0(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a v1(String paramString1, String paramString2)
  {
    return this.h.q0(paramString1, paramString2).C(io.reactivex.l0.a.c());
  }
  
  public q<ThingRuleListResult<ThingRuleTimer>> w0(String paramString1, String paramString2, int paramInt)
  {
    return this.h.F(paramString1, paramString2, paramInt).L0(io.reactivex.l0.a.c());
  }
  
  class a
    implements io.reactivex.g0.j<String, t<ThingNextEvent>>
  {
    a(String paramString) {}
    
    public t<ThingNextEvent> a(String paramString)
      throws Exception
    {
      return ThingCloudRepository.A(ThingCloudRepository.this).P0(paramString, paramString).L0(io.reactivex.l0.a.c());
    }
  }
  
  class b
    implements io.reactivex.g0.j<String, t<List<ThingNextEvent>>>
  {
    b(String paramString) {}
    
    public t<List<ThingNextEvent>> a(String paramString)
      throws Exception
    {
      return ThingCloudRepository.A(ThingCloudRepository.this).Z0(paramString, paramString).L0(io.reactivex.l0.a.c());
    }
  }
  
  class c
    implements io.reactivex.g0.j<String, t<Boolean>>
  {
    c(boolean paramBoolean, List paramList) {}
    
    public t<Boolean> a(String paramString)
      throws Exception
    {
      return ThingCloudRepository.y(ThingCloudRepository.this, paramString, new ThingCommonDeviceParams(paramBoolean, paramList)).F(new a()).E(new l1(this, paramBoolean)).g0(m1.c).C(new k1(this, paramList, paramBoolean));
    }
    
    class a
      implements io.reactivex.g0.g<c>
    {
      a() {}
      
      public void a(c paramc)
        throws Exception
      {
        Iterator localIterator = ThingCloudRepository.c.this.d.iterator();
        while (localIterator.hasNext())
        {
          paramc = (String)localIterator.next();
          ThingCloudRepository.c localc = ThingCloudRepository.c.this;
          ThingCloudRepository.F(localc.f, paramc, localc.c);
        }
        ThingCloudRepository.G(ThingCloudRepository.this);
      }
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d(ThingShadowUpdateResult paramThingShadowUpdateResult) {}
    
    public void run()
      throws Exception
    {
      ThingCloudRepository.w(ThingCloudRepository.this).remove(paramThingShadowUpdateResult.getRequestId());
    }
  }
  
  class e
    implements io.reactivex.g0.j<Throwable, t<Long>>
  {
    e(ThingShadowUpdateResult paramThingShadowUpdateResult) {}
    
    public t<Long> a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof IoTCloudException)) {
        return q.J(paramThrowable);
      }
      return ThingCloudRepository.x(ThingCloudRepository.this, paramThingShadowUpdateResult.getRequestId()).N(new a());
    }
    
    class a
      implements io.reactivex.g0.j<AsyncResult, t<Long>>
    {
      a() {}
      
      public t<Long> a(AsyncResult paramAsyncResult)
        throws Exception
      {
        if (paramAsyncResult.getCode() == 0) {
          return q.I();
        }
        return q.J(new IoTCloudException(paramAsyncResult.getCode(), paramAsyncResult.getMessage(), paramAsyncResult.getData()));
      }
    }
  }
  
  class f
    implements io.reactivex.g0.j<String, t<AsyncResult>>
  {
    f(String paramString) {}
    
    public t<AsyncResult> a(final String paramString)
      throws Exception
    {
      return q.f0(paramString).N(new a(paramString));
    }
    
    class a
      implements io.reactivex.g0.j<String, t<AsyncResult>>
    {
      a(String paramString) {}
      
      public t<AsyncResult> a(String paramString)
        throws Exception
      {
        return ThingCloudRepository.z(ThingCloudRepository.this).G1(paramString, paramString).L0(io.reactivex.l0.a.c());
      }
    }
  }
  
  class g
    implements io.reactivex.g0.j<String, t<PageListResult<ThingInfo>>>
  {
    g(ThingListPageParams paramThingListPageParams, String paramString) {}
    
    public t<PageListResult<ThingInfo>> a(final String paramString)
      throws Exception
    {
      return q.f0(paramThingListPageParams).N(new a(paramString));
    }
    
    class a
      implements io.reactivex.g0.j<ThingListPageParams, t<PageListResult<ThingInfo>>>
    {
      a(String paramString) {}
      
      public t<PageListResult<ThingInfo>> a(ThingListPageParams paramThingListPageParams)
        throws Exception
      {
        return ThingCloudRepository.A(ThingCloudRepository.this).t(paramString, ThingCloudRepository.g.this.c.getPage(), ThingCloudRepository.g.this.c.getPageSize(), ThingCloudRepository.g.this.d).L0(io.reactivex.l0.a.c());
      }
    }
  }
  
  class h
    implements io.reactivex.g0.g<ThingModel>
  {
    h(String paramString) {}
    
    public void a(ThingModel paramThingModel)
      throws Exception
    {
      if (paramString2 != null)
      {
        ThingCloudRepository.B(ThingCloudRepository.this).put(paramString2, paramThingModel);
        ThingCloudRepository.C(ThingCloudRepository.this);
      }
    }
  }
  
  class i
    implements io.reactivex.g0.g<c>
  {
    i(String paramString) {}
    
    public void a(c paramc)
      throws Exception
    {
      ThingCloudRepository.D(ThingCloudRepository.this, paramString2);
    }
  }
  
  class j
    implements io.reactivex.g0.j<List<ThingBatchUnbindResult>, Boolean>
  {
    j() {}
    
    public Boolean a(List<ThingBatchUnbindResult> paramList)
      throws Exception
    {
      return Boolean.TRUE;
    }
  }
  
  class k
    implements io.reactivex.g0.g<c>
  {
    k(List paramList) {}
    
    public void a(c paramc)
      throws Exception
    {
      ThingCloudRepository.E(ThingCloudRepository.this, paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\ThingCloudRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */