package com.tplink.iot.view.iotcommon;

import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceServerInfoTestParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.a;
import io.reactivex.g0.e;
import io.reactivex.q;
import io.reactivex.t;
import java.util.concurrent.TimeUnit;

public final class DebugFwUpdateRepository
  extends AbstractThingRepository
{
  public DebugFwUpdateRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, LocalIoTBaseDevice.class, DeviceRunningInfoResult.class);
  }
  
  private final q<FwDownloadStatus> f5()
  {
    Object localObject = new FwDownloadStatus(2);
    localObject = u1().o(1L, TimeUnit.SECONDS).s0(new a((FwDownloadStatus)localObject)).g0(new b((FwDownloadStatus)localObject));
    kotlin.jvm.internal.j.d(localObject, "firmwareDownloadState.de…p downloadState\n        }");
    return (q<FwDownloadStatus>)localObject;
  }
  
  public final ThingModel g5()
  {
    ThingCloudRepository localThingCloudRepository = this.d;
    TPBaseDeviceContext localTPBaseDeviceContext = this.a;
    kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
    return localThingCloudRepository.m0(((ThingContext)localTPBaseDeviceContext).getThingModelId());
  }
  
  public final a h5(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "url");
    paramString = y0("fw_download", new f(paramString), Boolean.class).Z();
    kotlin.jvm.internal.j.d(paramString, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramString;
  }
  
  public final a i5(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "serverType");
    paramString = y0("set_server_info", new DeviceServerInfoTestParams(paramString), Boolean.class).Z();
    kotlin.jvm.internal.j.d(paramString, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramString;
  }
  
  public final a j5(String paramString1, String paramString2, String paramString3)
  {
    kotlin.jvm.internal.j.e(paramString1, "name");
    kotlin.jvm.internal.j.e(paramString2, "psd");
    kotlin.jvm.internal.j.e(paramString3, "keyType");
    paramString1 = y0("set_wireless_info", new WirelessInfoParams(paramString1, paramString2, paramString3), Boolean.class).Z();
    kotlin.jvm.internal.j.d(paramString1, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramString1;
  }
  
  public final q<FwDownloadStatus> k5()
  {
    q localq = q.W0(2L, TimeUnit.SECONDS).N(new c(this));
    kotlin.jvm.internal.j.d(localq, "Observable.timer(2, Time…{ getFwDownloadStatus() }");
    return localq;
  }
  
  static final class a
    implements e
  {
    a(FwDownloadStatus paramFwDownloadStatus) {}
    
    public final boolean a()
    {
      boolean bool;
      if ((this.a.getErrorCode() != 3) && (this.a.getErrorCode() != 5) && (this.a.getErrorCode() != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<FirmwareDownloadState, FwDownloadStatus>
  {
    b(FwDownloadStatus paramFwDownloadStatus) {}
    
    public final FwDownloadStatus a(FirmwareDownloadState paramFirmwareDownloadState)
    {
      kotlin.jvm.internal.j.e(paramFirmwareDownloadState, "it");
      int i = paramFirmwareDownloadState.getStatus();
      if ((i != 64534) && (i != 64535))
      {
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            this.c.setErrorCode(0);
          }
          else
          {
            this.c.setErrorCode(5);
            this.c.setDownloadProgress(100);
            this.c.setInstallTime(paramFirmwareDownloadState.getUpgradeTime() + paramFirmwareDownloadState.getRebootTime());
          }
        }
        else
        {
          this.c.setErrorCode(4);
          this.c.setDownloadProgress(paramFirmwareDownloadState.getDownloadProgress());
        }
      }
      else {
        this.c.setErrorCode(3);
      }
      return this.c;
    }
  }
  
  static final class c<T, R>
    implements io.reactivex.g0.j<Long, t<? extends FwDownloadStatus>>
  {
    c(DebugFwUpdateRepository paramDebugFwUpdateRepository) {}
    
    public final t<? extends FwDownloadStatus> a(Long paramLong)
    {
      kotlin.jvm.internal.j.e(paramLong, "it");
      return DebugFwUpdateRepository.e5(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\DebugFwUpdateRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */