package com.tplink.libtpnetwork.IoTNetwork.repository;

import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.InheritInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.UserNameParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessScanInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.x;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.e;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuickSetupRepository
  extends AbstractThingRepository
{
  public QuickSetupRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, LocalIoTBaseDevice.class, DeviceRunningInfoResult.class);
  }
  
  private b.d.d0.h2.a.c g5(b.d.d0.h2.a.b paramb)
  {
    paramb.i((byte)1);
    paramb.j((byte)1);
    paramb.g((byte)3);
    return paramb;
  }
  
  private q<List<WirelessScanInfoBean>> j5(final WirelessScanInfoParams paramWirelessScanInfoParams)
  {
    final ArrayList localArrayList = new ArrayList();
    return t5(paramWirelessScanInfoParams).g0(new h(localArrayList, paramWirelessScanInfoParams)).w0(new g());
  }
  
  private void l5(final r<FwDownloadStatus> paramr)
  {
    final FwDownloadStatus localFwDownloadStatus = new FwDownloadStatus(2);
    paramr.onNext(localFwDownloadStatus);
    u1().s0(new e(localFwDownloadStatus, paramr)).E(new d(localFwDownloadStatus, paramr)).C(new c(paramr)).L0(io.reactivex.l0.a.c()).F0();
  }
  
  private q<FwDownloadStatus> m5()
  {
    return q.W0(2L, TimeUnit.SECONDS).N(new a());
  }
  
  private q<FwDownloadStatus> n5()
  {
    return q.m(new b());
  }
  
  private q<WirelessScanInfoResult> t5(WirelessScanInfoParams paramWirelessScanInfoParams)
  {
    return y0("get_wireless_scan_info", paramWirelessScanInfoParams, WirelessScanInfoResult.class).l0(io.reactivex.d0.b.a.a());
  }
  
  public q<FwDownloadStatus> A5()
  {
    return d5().d(m5());
  }
  
  public boolean D()
  {
    x localx = this.c;
    boolean bool;
    if ((localx != null) && (localx.s())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void e()
  {
    this.c.l();
    super.e();
  }
  
  public void h5()
  {
    this.c.m();
  }
  
  public q<List<WirelessScanInfoBean>> i5()
  {
    return j5(new WirelessScanInfoParams(0));
  }
  
  public q<IoTDataWrapper<List<ComponentBean>>> k5()
  {
    return g1().L0(io.reactivex.l0.a.c()).g0(new m()).q0(new IoTDataWrapper());
  }
  
  public q<InheritInfoResult> o5()
  {
    return x0("get_inherit_info", InheritInfoResult.class);
  }
  
  public q<InheritInfoResult> p5(UserNameParams paramUserNameParams)
  {
    return y0("get_inherit_info", paramUserNameParams, InheritInfoResult.class);
  }
  
  public q<IoTDataWrapper<LocalIoTBaseDevice>> q5()
  {
    if (((ThingContext)this.a).getIoTDevice() != null)
    {
      if (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isBulb())
      {
        if (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isLightStrip()) {
          return i1(IoTLightStripDevice.class).g0(i8.c).q0(new IoTDataWrapper());
        }
        return i1(IoTBulbDevice.class).g0(new j()).q0(new IoTDataWrapper());
      }
      if (((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).isHub()) {
        return i1(IoTHubDevice.class).g0(new k()).q0(new IoTDataWrapper());
      }
      return i1(IoTPlugDevice.class).g0(new l()).q0(new IoTDataWrapper());
    }
    return q.f0(new IoTDataWrapper());
  }
  
  public q<IoTDataWrapper<ThingFirmware>> r5()
  {
    return v1().g0(new n()).q0(new IoTDataWrapper());
  }
  
  public q<QuickSetupComponentResult> s5()
  {
    return x0("qs_component_nego", QuickSetupComponentResult.class).l0(io.reactivex.d0.b.a.a());
  }
  
  public boolean u5()
  {
    x localx = this.c;
    boolean bool;
    if ((localx != null) && (localx.r())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public q<Boolean> w5(b.d.d0.h2.a.b paramb)
  {
    return this.c.v(g5(paramb)).g0(new f()).L0(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a x5(InheritInfoParams paramInheritInfoParams)
  {
    return y0("set_inherit_info", paramInheritInfoParams, Boolean.class).Z();
  }
  
  public io.reactivex.a y5(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, int paramInt)
  {
    return Q4(paramQuickSetupDeviceInfoBean, paramInt).r(io.reactivex.d0.b.a.a());
  }
  
  public q<QuickSetupInfoResult> z5(QuickSetupInfoParams paramQuickSetupInfoParams)
  {
    return this.c.x("", "set_qs_info", paramQuickSetupInfoParams, QuickSetupInfoResult.class, 70L).g0(new i()).l0(io.reactivex.d0.b.a.a());
  }
  
  class a
    implements j<Long, t<FwDownloadStatus>>
  {
    a() {}
    
    public t<FwDownloadStatus> a(Long paramLong)
      throws Exception
    {
      return QuickSetupRepository.e5(QuickSetupRepository.this);
    }
  }
  
  class b
    implements s<FwDownloadStatus>
  {
    b() {}
    
    public void subscribe(r<FwDownloadStatus> paramr)
      throws Exception
    {
      QuickSetupRepository.f5(QuickSetupRepository.this, paramr);
    }
  }
  
  class c
    implements io.reactivex.g0.g<Throwable>
  {
    c(r paramr) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramr.onError(paramThrowable);
    }
  }
  
  class d
    implements io.reactivex.g0.g<FirmwareDownloadState>
  {
    d(FwDownloadStatus paramFwDownloadStatus, r paramr) {}
    
    public void a(FirmwareDownloadState paramFirmwareDownloadState)
      throws Exception
    {
      if (paramFirmwareDownloadState == null)
      {
        localFwDownloadStatus.setErrorCode(3);
        paramr.onNext(localFwDownloadStatus);
        return;
      }
      int i = paramFirmwareDownloadState.getStatus();
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          localFwDownloadStatus.setErrorCode(3);
          paramr.onNext(localFwDownloadStatus);
        }
        else
        {
          int j = paramFirmwareDownloadState.getUpgradeTime();
          i = paramFirmwareDownloadState.getRebootTime();
          localFwDownloadStatus.setErrorCode(5);
          localFwDownloadStatus.setDownloadProgress(100);
          localFwDownloadStatus.setInstallTime(j + i);
          paramr.onNext(localFwDownloadStatus);
        }
      }
      else
      {
        i = paramFirmwareDownloadState.getDownloadProgress();
        localFwDownloadStatus.setErrorCode(4);
        localFwDownloadStatus.setDownloadProgress(i);
        paramr.onNext(localFwDownloadStatus);
      }
    }
  }
  
  class e
    implements e
  {
    e(FwDownloadStatus paramFwDownloadStatus, r paramr) {}
    
    public boolean a()
      throws Exception
    {
      boolean bool;
      if ((localFwDownloadStatus.getErrorCode() != 3) && (localFwDownloadStatus.getErrorCode() != 5)) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        paramr.onComplete();
      }
      return bool;
    }
  }
  
  class f
    implements j<b.d.d0.i2.b, Boolean>
  {
    f() {}
    
    public Boolean a(b.d.d0.i2.b paramb)
      throws Exception
    {
      boolean bool;
      if (paramb.a() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  class g
    implements l<Throwable>
  {
    g() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        paramThrowable = (CloudException)paramThrowable;
        if ((-2 == paramThrowable.getErrCode()) && ("retry_get_data".equals(paramThrowable.getMsg()))) {
          return true;
        }
      }
      boolean bool = false;
      return bool;
    }
  }
  
  class h
    implements j<WirelessScanInfoResult, List<WirelessScanInfoBean>>
  {
    h(List paramList, WirelessScanInfoParams paramWirelessScanInfoParams) {}
    
    public List<WirelessScanInfoBean> a(WirelessScanInfoResult paramWirelessScanInfoResult)
      throws Exception
    {
      if (paramWirelessScanInfoResult != null)
      {
        int i = paramWirelessScanInfoResult.getSum();
        if (i == 0) {
          return new ArrayList();
        }
        if (localArrayList.size() >= i) {
          return localArrayList;
        }
        paramWirelessScanInfoResult = paramWirelessScanInfoResult.getApList();
        if ((paramWirelessScanInfoResult != null) && (!paramWirelessScanInfoResult.isEmpty())) {
          localArrayList.addAll(paramWirelessScanInfoResult);
        }
        if (localArrayList.size() >= i) {
          return localArrayList;
        }
        paramWirelessScanInfoParams.setStartIndex(localArrayList.size());
        throw new CloudException(-2, "retry_get_data");
      }
      throw new CloudException(-1, "");
    }
  }
  
  class i
    implements j<IoTResult<QuickSetupInfoResult>, QuickSetupInfoResult>
  {
    i() {}
    
    public QuickSetupInfoResult a(IoTResult<QuickSetupInfoResult> paramIoTResult)
      throws Exception
    {
      return (QuickSetupInfoResult)paramIoTResult.getResult();
    }
  }
  
  class j
    implements j<IoTBulbDevice, IoTDataWrapper<LocalIoTBaseDevice>>
  {
    j() {}
    
    public IoTDataWrapper<LocalIoTBaseDevice> a(IoTBulbDevice paramIoTBulbDevice)
      throws Exception
    {
      return new IoTDataWrapper(paramIoTBulbDevice);
    }
  }
  
  class k
    implements j<IoTHubDevice, IoTDataWrapper<LocalIoTBaseDevice>>
  {
    k() {}
    
    public IoTDataWrapper<LocalIoTBaseDevice> a(IoTHubDevice paramIoTHubDevice)
      throws Exception
    {
      return new IoTDataWrapper(paramIoTHubDevice);
    }
  }
  
  class l
    implements j<IoTPlugDevice, IoTDataWrapper<LocalIoTBaseDevice>>
  {
    l() {}
    
    public IoTDataWrapper<LocalIoTBaseDevice> a(IoTPlugDevice paramIoTPlugDevice)
      throws Exception
    {
      return new IoTDataWrapper(paramIoTPlugDevice);
    }
  }
  
  class m
    implements j<List<ComponentBean>, IoTDataWrapper<List<ComponentBean>>>
  {
    m() {}
    
    public IoTDataWrapper<List<ComponentBean>> a(List<ComponentBean> paramList)
      throws Exception
    {
      return new IoTDataWrapper(paramList);
    }
  }
  
  class n
    implements j<ThingFirmware, IoTDataWrapper<ThingFirmware>>
  {
    n() {}
    
    public IoTDataWrapper<ThingFirmware> a(ThingFirmware paramThingFirmware)
      throws Exception
    {
      return new IoTDataWrapper(paramThingFirmware);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\QuickSetupRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */