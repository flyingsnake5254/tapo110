package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingComponent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.result.ThingComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.EnumIoTTransportType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean.PresetBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.DeviceTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDeviceFeatureCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceAccountBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceAccountParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.RulePageParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.SyncEnvParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStatus;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.PresetRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.ChildComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.ChildComponentListBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.ChildDeviceListBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.DeviceTimeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.ChildRequestData;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubRequest;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubResponse;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.SubMultipleRequest;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.n;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.e;
import io.reactivex.g0.j;
import io.reactivex.m0.d;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractThingRepository
  extends ThingBaseRepository
{
  private Class<? extends LocalIoTBaseDevice> A;
  private Class<? extends DeviceRunningInfoResult> B;
  private MutableLiveData<NextEvent> p = new MutableLiveData();
  private SingleLiveEvent<Boolean> q = new SingleLiveEvent();
  private MutableLiveData<ThingUsage> r = new MutableLiveData();
  private MutableLiveData<ThingFirmware> s = new MutableLiveData();
  private MutableLiveData<DeviceTimeInfo> t = new MutableLiveData();
  private MutableLiveData<AutoUpdateBean> u = new MutableLiveData();
  private o v = o.h0();
  private boolean w = false;
  private boolean x = false;
  private io.reactivex.m0.g<IoTDataWrapper<LocalIoTBaseDevice>> y = d.n1();
  private io.reactivex.m0.g<IoTDataWrapper<DeviceRunningInfoResult>> z = d.n1();
  
  public AbstractThingRepository(ThingContext paramThingContext, Class<? extends LocalIoTBaseDevice> paramClass, Class<? extends DeviceRunningInfoResult> paramClass1)
  {
    super(paramThingContext);
    this.A = paramClass;
    this.B = paramClass1;
  }
  
  private q<DeviceRunningInfoResult> A4()
  {
    return this.z.Q0(1L).F(new n4(this)).l0(io.reactivex.l0.a.c()).N(v3.c);
  }
  
  private q<List<com.google.gson.i>> B1(RulePageParams paramRulePageParams)
  {
    ArrayList localArrayList = new ArrayList();
    return y0("get_preset_rules", paramRulePageParams, PresetRuleResult.class).g0(new t1(localArrayList, paramRulePageParams)).w0(c2.c);
  }
  
  private q<com.google.gson.i> C1()
  {
    return x0("get_preset_rules", com.google.gson.i.class).g0(new c()).o0(new t4(this));
  }
  
  private q<com.google.gson.i> D1()
  {
    return B1(new RulePageParams(0)).g0(d2.c).o0(new j4(this));
  }
  
  private boolean G1()
  {
    String str1 = ((ThingContext)this.a).getLang();
    String str2 = com.tplink.libtpnetwork.Utils.x.d(Locale.getDefault());
    boolean bool;
    if ((str1 != null) && (str1.equals(str2))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private <T extends DeviceInfoParams> boolean H1(T paramT)
  {
    ThingModel localThingModel = ((ThingContext)this.a).getThingModel();
    boolean bool;
    if ((localThingModel != null) && (!paramT.isMatchThingModel(localThingModel))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean I1()
  {
    BaseALIoTDevice localBaseALIoTDevice = ((ThingContext)this.a).getIoTDevice();
    boolean bool = true;
    int i;
    if ((localBaseALIoTDevice != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() != null)) {
      i = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice().getComponentVersion(EnumIoTComponent.PRESET);
    } else {
      i = 1;
    }
    if (i != 3) {
      bool = false;
    }
    return bool;
  }
  
  private io.reactivex.a M4()
  {
    long l = System.currentTimeMillis() / 1000L;
    final Object localObject = TimeZone.getDefault();
    localObject = new DeviceTimeParams(l, ((TimeZone)localObject).getRawOffset() / 1000 / 60, ((TimeZone)localObject).getID());
    return y0("set_device_time", localObject, Boolean.class).Z().u(new q3(this, (DeviceTimeParams)localObject)).i(new h((DeviceTimeParams)localObject)).j(new g());
  }
  
  private List<ComponentBean> R0(List<ThingComponent> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ComponentBean((ThingComponent)paramList.next()));
    }
    return localArrayList;
  }
  
  private io.reactivex.a R4(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean)
  {
    return y0("set_qs_extra_info", paramQuickSetupDeviceInfoBean, Boolean.class).Z();
  }
  
  private List<BaseALIoTDevice> T0(List<IoTSubDevice> paramList, List<ChildComponentBean> paramList1)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (IoTSubDevice)((Iterator)localObject).next();
        localHashMap.put(paramList.getDeviceId(), new ALIoTDevice(paramList));
      }
      if (paramList1 != null)
      {
        paramList = paramList1.iterator();
        while (paramList.hasNext())
        {
          localObject = (ChildComponentBean)paramList.next();
          paramList1 = (BaseALIoTDevice)localHashMap.get(((ChildComponentBean)localObject).getDeviceId());
          if (((paramList1 instanceof ALIoTDevice)) && (paramList1.getLocalIoTDevice() != null)) {
            ((ALIoTDevice)paramList1).getLocalIoTDevice().setComponents(((ChildComponentBean)localObject).getComponentList());
          }
        }
      }
      return new ArrayList(localHashMap.values());
    }
    return new ArrayList();
  }
  
  @SuppressLint({"CheckResult"})
  private void U4()
  {
    if (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isHub()) {
      if ((((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isOnline()) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getTDPIoTDevice() != null)) {
        q.f1(Y0().L0(io.reactivex.l0.a.c()), X0().L0(io.reactivex.l0.a.c()), new c4(this)).E(new x3(this)).C(new w2(this)).F0();
      } else {
        this.b.p4(((ThingContext)this.a).getDeviceIdMD5(), null, false);
      }
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void V0()
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(new z2(this)).N(new u1(this)).l0(io.reactivex.l0.a.d()).H0(new u2(this), new e3(this));
  }
  
  @SuppressLint({"CheckResult"})
  private void W0()
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(new v2(this)).N(new i3(this)).l0(io.reactivex.l0.a.d()).H0(new u4(this), new n3(this));
  }
  
  private q<List<ChildComponentBean>> X0()
  {
    RulePageParams localRulePageParams = new RulePageParams(0);
    ArrayList localArrayList = new ArrayList();
    return y0("get_child_device_component_list", localRulePageParams, ChildComponentListBean.class).g0(new h2(localArrayList, localRulePageParams)).w0(l3.c);
  }
  
  private void X4(TCAccountBean paramTCAccountBean)
  {
    ArrayList localArrayList = new ArrayList();
    if (G1()) {
      localArrayList.add(W4());
    }
    if (!F()) {
      localArrayList.add(V4(paramTCAccountBean.getCloudUserName(), paramTCAccountBean.getPassword()));
    }
    io.reactivex.a.q((e[])localArrayList.toArray(new e[0])).C(io.reactivex.l0.a.c()).y();
  }
  
  @SuppressLint({"CheckResult"})
  private void Y4(DeviceRunningInfoResult paramDeviceRunningInfoResult)
  {
    if ((paramDeviceRunningInfoResult != null) && (!TextUtils.isEmpty(paramDeviceRunningInfoResult.getFwVer())))
    {
      String str = this.v.S(((ThingContext)this.a).getDeviceIdMD5());
      IoTDeviceFeatureCache localIoTDeviceFeatureCache = null;
      if (str != null) {
        localIoTDeviceFeatureCache = (IoTDeviceFeatureCache)com.tplink.libtpnetwork.Utils.i.b(str, IoTDeviceFeatureCache.class);
      }
      if ((localIoTDeviceFeatureCache == null) || (!paramDeviceRunningInfoResult.getFwVer().equals(localIoTDeviceFeatureCache.getFirmwareVersion()))) {
        g1().L0(io.reactivex.l0.a.c()).G0(new d4(this));
      }
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void Z4(DeviceRunningInfoResult paramDeviceRunningInfoResult)
  {
    if ((paramDeviceRunningInfoResult != null) && (!TextUtils.isEmpty(paramDeviceRunningInfoResult.getFwVer()))) {
      g1().L0(io.reactivex.l0.a.c()).G0(new m2(this));
    }
  }
  
  private void a5(String paramString, List<ComponentBean> paramList)
  {
    paramString = new IoTDeviceFeatureCache(paramString, paramList);
    this.v.X0(((ThingContext)this.a).getDeviceIdMD5(), com.tplink.libtpnetwork.Utils.i.h(paramString));
  }
  
  private void c1(r<CloudConnectStatus> paramr)
  {
    Object localObject = new CloudConnectStatus(2, null);
    localObject = f1().s0(new b3((CloudConnectStatus)localObject, paramr)).E(new l4(this, (CloudConnectStatus)localObject, paramr));
    paramr.getClass();
    ((q)localObject).C(new db(paramr)).L0(io.reactivex.l0.a.c()).F0();
  }
  
  private q<CloudConnectStateResult> f1()
  {
    return q.W0(2L, TimeUnit.SECONDS).N(new y1(this));
  }
  
  private q<? extends DeviceRunningInfoResult> o1()
  {
    return l1(this.B, false, true);
  }
  
  private q<LocalIoTBaseDevice> z4()
  {
    return this.y.Q0(1L).F(new k4(this)).l0(io.reactivex.l0.a.c()).N(q2.c);
  }
  
  protected q<com.google.gson.i> A1()
  {
    if (I1()) {
      return D1();
    }
    return C1();
  }
  
  protected <T extends DeviceInfoParams> void B4(T paramT)
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)this.n.getValue();
    if (localLocalIoTBaseDevice != null)
    {
      this.i = localLocalIoTBaseDevice.getDeviceInfoParams();
      localLocalIoTBaseDevice.updateDeviceInfoParam(paramT);
      this.n.postValue(localLocalIoTBaseDevice);
      this.b.L3();
    }
  }
  
  public <T, R> q<R> C4(String paramString1, T paramT, final Class<R> paramClass, String paramString2)
  {
    return z0("control_child", new ChildRequestData(new IoTSubRequest("multipleRequest", new SubMultipleRequest(Arrays.asList(new IoTSubRequest[] { new IoTSubRequest(paramString1, paramT) }))), paramString2), com.google.gson.i.class, null).i(n.b(paramString1, paramClass)).g0(new a(paramClass));
  }
  
  public q<Boolean> D4()
  {
    String str1 = ((ThingContext)this.a).getThingUrl();
    String str2 = ((ThingContext)this.a).getThingName();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return this.d.j1(str1, str2).J();
    }
    return q.f0(Boolean.FALSE);
  }
  
  public q<AutoUpdateBean> E1()
  {
    return x0("get_auto_update_info", com.google.gson.i.class).o0(new b2(this)).g0(h4.c).E(new r2(this));
  }
  
  protected void E4(Throwable paramThrowable)
  {
    if (!IoTTransportException.isCancelException(paramThrowable))
    {
      paramThrowable = (LocalIoTBaseDevice)this.n.getValue();
      if (paramThrowable != null)
      {
        paramThrowable.updateDeviceInfoParam(this.i);
        this.n.postValue(paramThrowable);
        this.b.L3();
      }
    }
  }
  
  public io.reactivex.a F1()
  {
    return x0("heart_beat", Boolean.class).Z();
  }
  
  public io.reactivex.a F4(String paramString)
  {
    this.l.set(true);
    if (((ThingContext)this.a).getThingDevice() != null) {
      return I4(new DeviceInfoParams(null, paramString)).h(new z1(this));
    }
    return G4(new DeviceInfoParams(null, paramString)).h(new k2(this));
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a G4(T paramT)
  {
    return H4(paramT).u(new g3(this, paramT)).l(new x2(this, paramT)).j(new gb(this));
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a H4(T paramT)
  {
    return y0("set_device_info", paramT, Boolean.class).Z();
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a I4(T paramT)
  {
    return M0(paramT.toThingSetting()).l(new q4(this, paramT)).j(new gb(this));
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a J4(T paramT)
  {
    return K4(paramT, true);
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a K4(T paramT, boolean paramBoolean)
  {
    return H4(paramT).u(new n2(this, paramT)).l(new a3(this, paramBoolean, paramT)).j(new o3(this, paramBoolean));
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a L4(T paramT, boolean paramBoolean)
  {
    return this.h.B(o(paramT)).l(new y3(this, paramBoolean, paramT)).j(new w3(this, paramBoolean));
  }
  
  public io.reactivex.a N4(int paramInt1, int paramInt2)
  {
    return G4(new DeviceInfoParams(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2))).i(new e4(this));
  }
  
  public io.reactivex.a O4(String paramString)
  {
    this.l.set(true);
    if (((ThingContext)this.a).getThingDevice() != null) {
      return I4(new DeviceInfoParams(paramString, null)).h(new r4(this));
    }
    return G4(new DeviceInfoParams(paramString, null)).h(new a2(this));
  }
  
  protected <T> q<Boolean> P4(final T paramT)
  {
    return y0("set_on_off_gradually_info", paramT, Boolean.class).o0(new d(paramT));
  }
  
  protected io.reactivex.a Q4(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, int paramInt)
  {
    Object localObject;
    if (paramInt >= 2)
    {
      localObject = R4(paramQuickSetupDeviceInfoBean);
    }
    else
    {
      localObject = new DeviceInfoParams();
      ((DeviceInfoParams)localObject).setNickname(paramQuickSetupDeviceInfoBean.getNickname());
      ((DeviceInfoParams)localObject).setAvatar(paramQuickSetupDeviceInfoBean.getAvatar());
      localObject = H4((DeviceInfoParams)localObject);
    }
    return ((io.reactivex.a)localObject).u(new o4(this, paramQuickSetupDeviceInfoBean));
  }
  
  public io.reactivex.a S0()
  {
    return x0("close_device_ble", Boolean.class).Z();
  }
  
  public io.reactivex.a S4(final AutoUpdateBean paramAutoUpdateBean)
  {
    return y0("set_auto_update_info", paramAutoUpdateBean, Boolean.class).Z().u(new j(paramAutoUpdateBean)).i(new j3(this, paramAutoUpdateBean));
  }
  
  public q<CloudConnectStatus> T4()
  {
    return U0().d(q.f0(Boolean.TRUE)).q0(Boolean.FALSE).N(new t2(this));
  }
  
  protected io.reactivex.a U0()
  {
    return x0("connect_cloud", Boolean.class).Z();
  }
  
  protected io.reactivex.a V4(String paramString1, String paramString2)
  {
    return z0("account_sync", new DeviceAccountParams(new DeviceAccountBean(paramString1, paramString2)), Boolean.class, EnumIoTTransportType.PASS_THROUGH).Z();
  }
  
  protected io.reactivex.a W4()
  {
    return y0("sync_env", new SyncEnvParams(Locale.getDefault()), Boolean.class).Z().u(new a4(this)).i(new b());
  }
  
  public q<List<IoTSubDevice>> Y0()
  {
    RulePageParams localRulePageParams = new RulePageParams(0);
    ArrayList localArrayList = new ArrayList();
    return y0("get_child_device_list", localRulePageParams, ChildDeviceListBean.class).g0(new c3(localArrayList, localRulePageParams)).w0(k3.c);
  }
  
  public LiveData<AutoUpdateBean> Z0()
  {
    return this.u;
  }
  
  public q<ChildDeviceListBean> a1(RulePageParams paramRulePageParams)
  {
    return y0("get_child_device_list", paramRulePageParams, ChildDeviceListBean.class);
  }
  
  public q<CloudConnectStateResult> b1()
  {
    return x0("get_connect_cloud_state", CloudConnectStateResult.class);
  }
  
  protected <T> io.reactivex.a b5(Integer paramInteger, T paramT)
  {
    return this.d.r1(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), paramInteger, com.tplink.libtpnetwork.Utils.i.i(paramT));
  }
  
  protected <T> io.reactivex.a c5(T paramT)
  {
    return this.d.q1(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), com.tplink.libtpnetwork.Utils.i.i(paramT));
  }
  
  public q<Boolean> d()
  {
    return this.c.w("login_device_test", null, Object.class, EnumIoTTransportType.HTTP).g0(d3.c);
  }
  
  public LiveData<Boolean> d1()
  {
    return this.q;
  }
  
  public io.reactivex.a d5()
  {
    return x0("fw_download", Boolean.class).Z().u(new m3(this));
  }
  
  protected void e()
  {
    super.e();
  }
  
  public q<CloudConnectStatus> e1()
  {
    return q.m(new o2(this));
  }
  
  public q<Boolean> f()
  {
    ALIoTDevice localALIoTDevice = (ALIoTDevice)((ThingContext)this.a).getIoTDevice();
    if ((localALIoTDevice != null) && (localALIoTDevice.getTDPIoTDevice() == null))
    {
      Object localObject = localALIoTDevice.getThingDevice();
      if (localObject != null)
      {
        localObject = ((ThingDevice)localObject).getThingInfo();
        if ((localObject != null) && (((ThingInfo)localObject).getStatus() == 0))
        {
          localALIoTDevice.setDeviceState(EnumIoTDeviceState.OFFLINE);
          if (localALIoTDevice.isHub())
          {
            this.b.f4(localALIoTDevice.getDeviceIdMD5());
            this.b.L3();
          }
          return q.f0(Boolean.FALSE);
        }
      }
    }
    boolean bool;
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isOnline())) {
      bool = true;
    } else {
      bool = false;
    }
    return q.f0(Boolean.valueOf(bool)).N(new h3(this)).q0(Boolean.FALSE);
  }
  
  public q<Boolean> g()
  {
    boolean bool;
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isOnline())) {
      bool = true;
    } else {
      bool = false;
    }
    return q.f0(Boolean.valueOf(bool)).N(new i2(this)).q0(Boolean.FALSE);
  }
  
  public q<List<ComponentBean>> g1()
  {
    return x0("component_nego", ThingComponentResult.class).o0(new g2(this)).g0(new f4(this));
  }
  
  public q<? extends LocalIoTBaseDevice> h1()
  {
    return i1(this.A);
  }
  
  protected <T extends LocalIoTBaseDevice> q<T> i1(Class<T> paramClass)
  {
    return x0("get_device_info", paramClass).E(new g4(this)).o0(new l2(this, paramClass)).E(new s4(this)).L0(io.reactivex.l0.a.c());
  }
  
  public q<Boolean> j()
  {
    return q.f1(z4().L0(io.reactivex.l0.a.c()), g1().L0(io.reactivex.l0.a.c()), new e2(this)).v0(1L, f3.c).E(new s2(this)).C(new y2(this)).q0(Boolean.FALSE).E(new f());
  }
  
  public LiveData<LocalIoTBaseDevice> j1()
  {
    return this.n;
  }
  
  public io.reactivex.a k()
  {
    if (!((ThingContext)this.a).isOwner()) {
      return io.reactivex.a.e();
    }
    TCAccountBean localTCAccountBean = ((ThingContext)this.a).getAccountContext().c();
    return V4(localTCAccountBean.getCloudUserName(), localTCAccountBean.getPassword());
  }
  
  public q<? extends DeviceRunningInfoResult> k1()
  {
    if (this.l.get()) {
      return q.I();
    }
    return l1(this.B, false, false).E(new x1(this));
  }
  
  @SuppressLint({"CheckResult"})
  protected <T extends DeviceRunningInfoResult> q<T> l1(Class<T> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    return x0("get_device_running_info", paramClass).E(new w1(this)).o0(new p3(this, paramClass, paramBoolean1)).E(new v1(this, paramBoolean2)).C(new i4(this));
  }
  
  public q<? extends DeviceRunningInfoResult> m1()
  {
    if (this.l.get()) {
      return q.I();
    }
    return l1(this.B, false, false).E(new s3(this));
  }
  
  public q<DeviceRunningInfoResult> n1()
  {
    return A4();
  }
  
  public q<? extends DeviceRunningInfoResult> p1()
  {
    if (this.l.get()) {
      return q.I();
    }
    return l1(this.B, true, false).E(new x1(this));
  }
  
  public q<DeviceTimeInfo> q1()
  {
    return x0("get_device_time", DeviceTimeInfo.class).E(new i());
  }
  
  public LiveData<DeviceTimeInfo> r1()
  {
    return this.t;
  }
  
  public q<ThingUsage> s1()
  {
    return x0("get_device_usage", ThingUsage.class).o0(new u3(this)).E(new j2(this));
  }
  
  public LiveData<ThingUsage> t1()
  {
    return this.r;
  }
  
  public q<FirmwareDownloadState> u1()
  {
    return x0("get_fw_download_state", FirmwareDownloadState.class).o0(new p4(this));
  }
  
  public q<ThingFirmware> v1()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return q.f0(new ThingFirmware());
    }
    localObject = ((ThingContext)localObject).getIoTDevice();
    if ((localObject != null) && (!((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
      return x0("get_latest_fw", ThingFirmware.class).o0(new p2(this)).E(new t3(this));
    }
    return q.f0(new ThingFirmware());
  }
  
  public LiveData<ThingFirmware> w1()
  {
    return this.s;
  }
  
  public q<NextEvent> x1()
  {
    return x0("get_next_event", NextEvent.class).o0(new r3(this)).E(new b4(this)).C(new z3(this));
  }
  
  public LiveData<NextEvent> y1()
  {
    return this.p;
  }
  
  public void y4(boolean paramBoolean)
  {
    ThingFirmware localThingFirmware = (ThingFirmware)this.s.getValue();
    if (localThingFirmware != null) {
      localThingFirmware.setNeedToUpgrade(paramBoolean);
    }
    this.s.postValue(localThingFirmware);
    this.b.T0(((ThingContext)this.a).getDeviceIdMD5(), localThingFirmware);
  }
  
  protected q<OnOffGraduallyBean> z1()
  {
    return y0("get_on_off_gradually_info", null, OnOffGraduallyBean.class).o0(new e());
  }
  
  class a
    implements j<IoTSubResponse<R>, R>
  {
    a(Class paramClass) {}
    
    public R a(IoTSubResponse<R> paramIoTSubResponse)
      throws Exception
    {
      if ((paramIoTSubResponse.getResult() == null) && (paramClass == Boolean.class)) {
        return Boolean.TRUE;
      }
      if (paramIoTSubResponse.getResult() == null) {
        return (R)paramClass.newInstance();
      }
      return (R)paramIoTSubResponse.getResult();
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      String str = com.tplink.libtpnetwork.Utils.x.d(Locale.getDefault());
      if (!TextUtils.isEmpty(str))
      {
        LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)AbstractThingRepository.this.n.getValue();
        if (localLocalIoTBaseDevice != null)
        {
          localLocalIoTBaseDevice.setLang(str);
          AbstractThingRepository.this.n.postValue(localLocalIoTBaseDevice);
          AbstractThingRepository.N0(AbstractThingRepository.this).L3();
        }
      }
    }
  }
  
  class c
    implements j<com.google.gson.i, com.google.gson.i>
  {
    c() {}
    
    public com.google.gson.i a(com.google.gson.i parami)
      throws Exception
    {
      BrightnessPresetsBean.PresetBean localPresetBean = (BrightnessPresetsBean.PresetBean)com.tplink.libtpnetwork.Utils.i.a(parami, BrightnessPresetsBean.PresetBean.class);
      parami = new BrightnessPresetsBean();
      parami.setSet(true);
      parami.setPresets(localPresetBean);
      return com.tplink.libtpnetwork.Utils.i.i(parami);
    }
  }
  
  class d
    implements j<Throwable, q<Boolean>>
  {
    d(Object paramObject) {}
    
    public q<Boolean> a(Throwable paramThrowable)
      throws Exception
    {
      if (AbstractThingRepository.this.F0(paramThrowable)) {
        return AbstractThingRepository.this.L0(EnumFeatureType.ON_OFF_GRADUALLY.getName(), paramT).g0(new a());
      }
      return q.J(paramThrowable);
    }
    
    class a
      implements j<com.google.gson.i, Boolean>
    {
      a() {}
      
      public Boolean a(com.google.gson.i parami)
        throws Exception
      {
        return Boolean.TRUE;
      }
    }
  }
  
  class e
    implements j<Throwable, t<OnOffGraduallyBean>>
  {
    e() {}
    
    public t<OnOffGraduallyBean> a(Throwable paramThrowable)
      throws Exception
    {
      if (AbstractThingRepository.this.F0(paramThrowable)) {
        return AbstractThingRepository.this.t(EnumFeatureType.ON_OFF_GRADUALLY.getName()).g0(new a());
      }
      return q.J(paramThrowable);
    }
    
    class a
      implements j<com.google.gson.i, OnOffGraduallyBean>
    {
      a() {}
      
      public OnOffGraduallyBean a(com.google.gson.i parami)
        throws Exception
      {
        return (OnOffGraduallyBean)com.tplink.libtpnetwork.Utils.i.a(parami, OnOffGraduallyBean.class);
      }
    }
  }
  
  class f
    implements io.reactivex.g0.g<Boolean>
  {
    f() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if (org.apache.commons.lang.b.b(paramBoolean)) {
        AbstractThingRepository.O0(AbstractThingRepository.this);
      }
    }
  }
  
  class g
    implements io.reactivex.g0.g<Throwable>
  {
    g() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.e("FFS", "set time fail");
    }
  }
  
  class h
    implements io.reactivex.g0.a
  {
    h(DeviceTimeParams paramDeviceTimeParams) {}
    
    public void run()
      throws Exception
    {
      b.d.w.c.a.e("FFS", "set time success");
      Object localObject = ((ThingContext)AbstractThingRepository.P0(AbstractThingRepository.this)).getIoTDevice();
      if ((localObject instanceof ALIoTDevice))
      {
        localObject = ((ALIoTDevice)localObject).getLocalIoTDevice();
        if (localObject != null)
        {
          ((LocalIoTBaseDevice)localObject).setRegion(localObject.getRegion());
          ((LocalIoTBaseDevice)localObject).setTimeDiff(localObject.getTimeDiff());
        }
      }
    }
  }
  
  class i
    implements io.reactivex.g0.g<DeviceTimeInfo>
  {
    i() {}
    
    public void a(DeviceTimeInfo paramDeviceTimeInfo)
      throws Exception
    {
      AbstractThingRepository.Q0(AbstractThingRepository.this).postValue(paramDeviceTimeInfo);
    }
  }
  
  class j
    implements j<Throwable, e>
  {
    j(AutoUpdateBean paramAutoUpdateBean) {}
    
    public e a(Throwable paramThrowable)
      throws Exception
    {
      return AbstractThingRepository.this.L0(EnumFeatureType.AUTO_UPDATE_MODE.getName(), paramAutoUpdateBean).Z();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\AbstractThingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */