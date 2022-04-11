package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingComponent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDeviceFeatureCache;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.BatteryDetectInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.RealTimeBatteryInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AbstractSubThingRepository
  extends ThingBaseRepository
{
  private final MutableLiveData<BatteryDetectInfoResult> A = new MutableLiveData();
  private MutableLiveData<AutoUpdateBean> B = new MutableLiveData();
  private com.tplink.libtpnetwork.Utils.o p = com.tplink.libtpnetwork.Utils.o.h0();
  private boolean q = false;
  private boolean r = false;
  private io.reactivex.m0.g<IoTDataWrapper<LocalIoTBaseDevice>> s = io.reactivex.m0.d.n1();
  private io.reactivex.m0.g<IoTDataWrapper<DeviceRunningInfoResult>> t = io.reactivex.m0.d.n1();
  private Class<? extends LocalIoTBaseDevice> u;
  private Class<? extends DeviceRunningInfoResult> v;
  private final MutableLiveData<NextEvent> w = new MutableLiveData();
  private MutableLiveData<ThingFirmware> x = new MutableLiveData();
  private final MutableLiveData<ThingUsage> y = new MutableLiveData();
  private final MutableLiveData<TriggerLog> z = new MutableLiveData();
  
  public AbstractSubThingRepository(ThingContext paramThingContext, Class<? extends LocalIoTBaseDevice> paramClass, Class<? extends DeviceRunningInfoResult> paramClass1)
  {
    super(paramThingContext);
    this.u = paramClass;
    this.v = paramClass1;
  }
  
  private List<ComponentBean> N0(List<ThingComponent> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ComponentBean((ThingComponent)paramList.next()));
    }
    return localArrayList;
  }
  
  @SuppressLint({"CheckResult"})
  private void P0()
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(new n0(this)).N(new f0(this)).l0(io.reactivex.l0.a.d()).H0(new b1(this), new b0(this));
  }
  
  private q<LocalIoTBaseDevice> P3()
  {
    return this.s.Q0(1L).F(new z(this)).l0(io.reactivex.l0.a.c()).N(u0.c);
  }
  
  @SuppressLint({"CheckResult"})
  private void Q0()
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(new h(this)).N(new m1(this)).l0(io.reactivex.l0.a.d()).H0(new o0(this), new i0(this));
  }
  
  private q<DeviceRunningInfoResult> Q3()
  {
    return this.t.Q0(1L).F(new g1(this)).l0(io.reactivex.l0.a.c()).N(l1.c);
  }
  
  @SuppressLint({"CheckResult"})
  private void c4(DeviceRunningInfoResult paramDeviceRunningInfoResult)
  {
    if ((paramDeviceRunningInfoResult != null) && (!TextUtils.isEmpty(paramDeviceRunningInfoResult.getFwVer())))
    {
      String str = this.p.S(((ThingContext)this.a).getDeviceIdMD5());
      IoTDeviceFeatureCache localIoTDeviceFeatureCache = null;
      if (str != null) {
        localIoTDeviceFeatureCache = (IoTDeviceFeatureCache)com.tplink.libtpnetwork.Utils.i.b(str, IoTDeviceFeatureCache.class);
      }
      if ((localIoTDeviceFeatureCache == null) || (!paramDeviceRunningInfoResult.getFwVer().equals(localIoTDeviceFeatureCache.getFirmwareVersion()))) {
        W0().L0(io.reactivex.l0.a.c()).G0(new m(this));
      }
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void d4(DeviceRunningInfoResult paramDeviceRunningInfoResult)
  {
    if ((paramDeviceRunningInfoResult != null) && (!TextUtils.isEmpty(paramDeviceRunningInfoResult.getFwVer()))) {
      W0().L0(io.reactivex.l0.a.c()).G0(new z0(this));
    }
  }
  
  private void e4(String paramString, List<ComponentBean> paramList)
  {
    paramString = new IoTDeviceFeatureCache(paramString, paramList);
    this.p.X0(((ThingContext)this.a).getDeviceIdMD5(), com.tplink.libtpnetwork.Utils.i.h(paramString));
  }
  
  private q<FirmwareDownloadState> f1()
  {
    return this.d.W(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName());
  }
  
  private <T extends DeviceInfoParams> boolean p1(T paramT)
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
  
  public q<FirmwareDownloadState> O0()
  {
    return x0("get_fw_download_state", FirmwareDownloadState.class).o0(new w(this));
  }
  
  public void O3(boolean paramBoolean)
  {
    ThingFirmware localThingFirmware = (ThingFirmware)this.x.getValue();
    if (localThingFirmware != null) {
      localThingFirmware.setNeedToUpgrade(paramBoolean);
    }
    this.x.postValue(localThingFirmware);
    this.b.T0(((ThingContext)this.a).getDeviceIdMD5(), localThingFirmware);
  }
  
  public LiveData<AutoUpdateBean> R0()
  {
    return this.B;
  }
  
  protected <T extends DeviceInfoParams> void R3(T paramT)
  {
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() != null))
    {
      LocalIoTBaseDevice localLocalIoTBaseDevice = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice();
      this.i = localLocalIoTBaseDevice.getDeviceInfoParams();
      localLocalIoTBaseDevice.updateDeviceInfoParam(paramT);
      this.n.postValue(localLocalIoTBaseDevice);
      this.b.L3();
    }
  }
  
  public q<BatteryDetectInfoResult> S0()
  {
    return x0("get_battery_detect_info", BatteryDetectInfoResult.class).o0(new q0(this)).E(new e1(this));
  }
  
  protected void S3(Throwable paramThrowable)
  {
    if ((!IoTTransportException.isCancelException(paramThrowable)) && (((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() != null))
    {
      paramThrowable = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice();
      paramThrowable.updateDeviceInfoParam(this.i);
      this.n.postValue(paramThrowable);
      this.b.L3();
    }
  }
  
  public void T0()
  {
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() != null))
    {
      boolean bool1 = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice().isSupportComponent(EnumIoTComponent.BATTERY_DETECT);
      boolean bool2 = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getDeviceModel().startsWith("E100");
      if ((bool1) && (!bool2)) {
        S0().E(new g0(this)).F0();
      }
    }
  }
  
  public io.reactivex.a T3(String paramString)
  {
    this.l.set(true);
    if (((ThingContext)this.a).getThingDevice() != null) {
      return W3(new DeviceInfoParams(null, paramString)).h(new r0(this));
    }
    return U3(new DeviceInfoParams(null, paramString)).h(new s(this));
  }
  
  public LiveData<BatteryDetectInfoResult> U0()
  {
    return this.A;
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a U3(T paramT)
  {
    return V3(paramT).u(new j1(this, paramT)).l(new i(this, paramT)).j(new hb(this));
  }
  
  public q<CloudConnectStateResult> V0()
  {
    return x0("get_connect_cloud_state", CloudConnectStateResult.class);
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a V3(T paramT)
  {
    return y0("set_device_info", paramT, Boolean.class).Z();
  }
  
  public q<List<ComponentBean>> W0()
  {
    return this.d.e0(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName()).F(new c(this)).g0(new t0(this));
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a W3(T paramT)
  {
    return M0(paramT.toThingSetting()).l(new i1(this, paramT)).j(new hb(this));
  }
  
  protected <T extends LocalIoTBaseDevice> q<T> X0(Class<T> paramClass)
  {
    return v(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), paramClass).F(new l0(this)).E(new w0(this)).L0(io.reactivex.l0.a.c());
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a X3(T paramT)
  {
    return Y3(paramT, true);
  }
  
  public LiveData<LocalIoTBaseDevice> Y0()
  {
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() != null))
    {
      l.d(((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice());
      this.n.postValue(((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice());
    }
    return this.n;
  }
  
  protected <T extends DeviceInfoParams> io.reactivex.a Y3(T paramT, boolean paramBoolean)
  {
    return V3(paramT).u(new p1(this, paramT)).l(new e0(this, paramBoolean, paramT)).j(new k(this, paramBoolean));
  }
  
  public q<? extends DeviceRunningInfoResult> Z0()
  {
    if (this.l.get()) {
      return q.I();
    }
    return a1(this.v).E(new r(this));
  }
  
  public io.reactivex.a Z3(int paramInt1, int paramInt2)
  {
    return U3(new DeviceInfoParams(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2))).i(new v(this));
  }
  
  protected <T extends DeviceRunningInfoResult> q<T> a1(Class<T> paramClass)
  {
    return x0("get_device_running_info", paramClass).E(new k0(this)).o0(new s0(this, paramClass)).E(new n1(this)).C(new x(this));
  }
  
  public io.reactivex.a a4(String paramString)
  {
    this.l.set(true);
    if (((ThingContext)this.a).getThingDevice() != null) {
      return W3(new DeviceInfoParams(paramString, null)).h(new k1(this));
    }
    return U3(new DeviceInfoParams(paramString, null)).h(new e(this));
  }
  
  public q<? extends DeviceRunningInfoResult> b1()
  {
    if (this.l.get()) {
      return q.I();
    }
    return a1(this.v).E(new o1(this));
  }
  
  public io.reactivex.a b4(final AutoUpdateBean paramAutoUpdateBean)
  {
    return y0("set_auto_update_info", paramAutoUpdateBean, Boolean.class).Z().u(new a(paramAutoUpdateBean)).i(new p0(this, paramAutoUpdateBean));
  }
  
  public q<ThingUsage> c1()
  {
    return x0("get_device_usage", ThingUsage.class).o0(new c0(this)).E(new o(this));
  }
  
  public LiveData<ThingUsage> d1()
  {
    return this.y;
  }
  
  public q<FirmwareDownloadState> e1()
  {
    return x0("get_fw_download_state", FirmwareDownloadState.class).o0(new h1(this));
  }
  
  public q<Boolean> f()
  {
    ALIoTDevice localALIoTDevice = (ALIoTDevice)((ThingContext)this.a).getIoTDevice();
    if (localALIoTDevice != null)
    {
      BaseALIoTDevice localBaseALIoTDevice = null;
      if (localALIoTDevice.getParentDeviceIDMD5() != null) {
        localBaseALIoTDevice = this.b.Z1(localALIoTDevice.getParentDeviceIDMD5());
      }
      if ((localBaseALIoTDevice == null) || (!TextUtils.equals(localALIoTDevice.getFamilyId(), localBaseALIoTDevice.getFamilyId())))
      {
        boolean bool;
        if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isOnline())) {
          bool = true;
        } else {
          bool = false;
        }
        return q.f0(Boolean.valueOf(bool)).N(new f(this)).q0(Boolean.FALSE);
      }
    }
    return q.f0(Boolean.TRUE);
  }
  
  public io.reactivex.a f4()
  {
    return x0("fw_download", Boolean.class).Z().u(new g(this));
  }
  
  public q<Boolean> g()
  {
    boolean bool;
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isOnline())) {
      bool = true;
    } else {
      bool = false;
    }
    return q.f0(Boolean.valueOf(bool)).N(new d1(this)).q0(Boolean.FALSE);
  }
  
  public q<ThingFirmware> g1()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return q.f0(new ThingFirmware());
    }
    localObject = ((ThingContext)localObject).getIoTDevice();
    if ((localObject != null) && (!((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
      return x0("get_latest_fw", ThingFirmware.class).o0(new r1(this)).E(new p(this));
    }
    return q.f0(new ThingFirmware());
  }
  
  public MutableLiveData<ThingFirmware> h1()
  {
    return this.x;
  }
  
  public q<TriggerLog> i1()
  {
    return this.d.h0(((ThingContext)this.a).getThingUrl(), ((ThingContext)this.a).getThingName(), null, null, 1, null, "DESC").L(a0.c).g0(m0.c).E(new x0(this));
  }
  
  public q<Boolean> j()
  {
    return q.f1(P3().L0(io.reactivex.l0.a.c()), W0().L0(io.reactivex.l0.a.c()), new y(this)).v0(1L, n.c).E(new d(this)).C(new j(this)).q0(Boolean.FALSE);
  }
  
  public void j1()
  {
    if ((((ThingContext)this.a).getIoTDevice() != null) && (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() != null))
    {
      boolean bool1 = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice().isSupportComponent(EnumIoTComponent.TRIGGER_LOG);
      boolean bool2 = ((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isSwitch();
      if ((bool1) && (!bool2)) {
        i1().F0();
      }
    }
  }
  
  public MutableLiveData<TriggerLog> k1()
  {
    return this.z;
  }
  
  public q<NextEvent> l1()
  {
    return x0("get_next_event", NextEvent.class).o0(new a1(this)).E(new y0(this)).C(new c1(this));
  }
  
  public MutableLiveData<NextEvent> m1()
  {
    return this.w;
  }
  
  public q<RealTimeBatteryInfoResult> n1()
  {
    return x0("get_rt_battery_info", RealTimeBatteryInfoResult.class).o0(new b(this));
  }
  
  public q<AutoUpdateBean> o1()
  {
    return x0("get_auto_update_info", com.google.gson.i.class).o0(new f1(this)).g0(q1.c).E(new u(this));
  }
  
  class a
    implements io.reactivex.g0.j<Throwable, io.reactivex.e>
  {
    a(AutoUpdateBean paramAutoUpdateBean) {}
    
    public io.reactivex.e a(Throwable paramThrowable)
      throws Exception
    {
      return AbstractSubThingRepository.this.L0(EnumFeatureType.AUTO_UPDATE_MODE.getName(), paramAutoUpdateBean).Z();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\AbstractSubThingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */