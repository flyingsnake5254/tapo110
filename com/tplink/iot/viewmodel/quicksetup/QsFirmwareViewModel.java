package com.tplink.iot.viewmodel.quicksetup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.cloud.bean.firmware.params.FirmwareInfoParams;
import com.tplink.cloud.bean.firmware.result.FirmwareListResult;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class QsFirmwareViewModel
  extends AndroidViewModel
{
  private QuickSetupRepository a;
  private TPIoTClientManager b;
  private MutableLiveData<i<ThingFirmware>> c = new MutableLiveData();
  private MutableLiveData<FwDownloadStatus> d = new MutableLiveData();
  
  public QsFirmwareViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((QuickSetupRepository)e.a(paramThingContext, QuickSetupRepository.class));
    this.b = ((TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class));
  }
  
  private q<IoTDataWrapper<ThingFirmware>> m(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    FirmwareInfoParams localFirmwareInfoParams = new FirmwareInfoParams();
    localFirmwareInfoParams.setDeviceId(paramLocalIoTBaseDevice.getDeviceId());
    localFirmwareInfoParams.setFwId(paramLocalIoTBaseDevice.getFwId());
    localFirmwareInfoParams.setHwId(paramLocalIoTBaseDevice.getHwId());
    localFirmwareInfoParams.setOemId(paramLocalIoTBaseDevice.getOemId());
    localFirmwareInfoParams.setDevFwCurrentVer(v(paramLocalIoTBaseDevice.getFwVer()));
    localFirmwareInfoParams.setLocale(x.d(Locale.getDefault()));
    return this.b.P1(localFirmwareInfoParams).T0(10L, TimeUnit.SECONDS).q0(new FirmwareListResult()).N(new c());
  }
  
  private q<IoTDataWrapper<LocalIoTBaseDevice>> n()
  {
    return q.f1(this.a.q5(), this.a.k5(), new g());
  }
  
  private String v(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.indexOf(" ");
    if (i <= 0) {
      return paramString;
    }
    try
    {
      String str = paramString.substring(0, i);
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return paramString;
  }
  
  @SuppressLint({"CheckResult"})
  private void w(final FwDownloadStatus paramFwDownloadStatus)
  {
    this.d.postValue(paramFwDownloadStatus);
    if ((paramFwDownloadStatus != null) && (paramFwDownloadStatus.getErrorCode() == 5))
    {
      int i = paramFwDownloadStatus.getInstallTime();
      if (i > 0)
      {
        q.W0(i, TimeUnit.SECONDS).G0(new f(paramFwDownloadStatus));
      }
      else
      {
        paramFwDownloadStatus.setErrorCode(6);
        this.d.postValue(paramFwDownloadStatus);
      }
    }
  }
  
  private void y(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, int paramInt)
  {
    this.a.y5(paramQuickSetupDeviceInfoBean, paramInt).y();
  }
  
  public String o(String paramString)
  {
    return this.b.S1(paramString);
  }
  
  public String p(String paramString)
  {
    return this.b.U1(paramString);
  }
  
  public String r(String paramString)
  {
    return this.b.V1(paramString);
  }
  
  @SuppressLint({"CheckResult"})
  public void s(final QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, final int paramInt)
  {
    if (this.a == null)
    {
      b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo");
      this.c.postValue(new i(1, null));
      return;
    }
    n().N(new b(paramQuickSetupDeviceInfoBean, paramInt)).G0(new a());
  }
  
  public MutableLiveData<FwDownloadStatus> t()
  {
    return this.d;
  }
  
  public LiveData<i<ThingFirmware>> u()
  {
    return this.c;
  }
  
  public void x(int paramInt)
  {
    QuickSetupRepository localQuickSetupRepository = this.a;
    if (localQuickSetupRepository == null) {
      return;
    }
    localQuickSetupRepository.S4(new AutoUpdateBean(true, paramInt, 120)).y();
  }
  
  public void z()
  {
    QuickSetupRepository localQuickSetupRepository = this.a;
    if (localQuickSetupRepository == null)
    {
      this.d.postValue(new FwDownloadStatus(1));
      return;
    }
    localQuickSetupRepository.A5().E(new e()).C(new d()).F0();
  }
  
  class a
    implements g<IoTDataWrapper<ThingFirmware>>
  {
    a() {}
    
    public void a(IoTDataWrapper<ThingFirmware> paramIoTDataWrapper)
      throws Exception
    {
      if ((paramIoTDataWrapper != null) && (paramIoTDataWrapper.getData() != null))
      {
        b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get fw成功");
        QsFirmwareViewModel.f(QsFirmwareViewModel.this).postValue(new i(0, paramIoTDataWrapper.getData()));
      }
      else
      {
        b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get fw失败或没有新固件");
        QsFirmwareViewModel.f(QsFirmwareViewModel.this).postValue(new i(1, null));
      }
    }
  }
  
  class b
    implements j<IoTDataWrapper<LocalIoTBaseDevice>, t<IoTDataWrapper<ThingFirmware>>>
  {
    b(QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, int paramInt) {}
    
    public t<IoTDataWrapper<ThingFirmware>> a(IoTDataWrapper<LocalIoTBaseDevice> paramIoTDataWrapper)
      throws Exception
    {
      if ((paramIoTDataWrapper != null) && (paramIoTDataWrapper.getData() != null))
      {
        b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get Device Info成功");
        LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)paramIoTDataWrapper.getData();
        paramIoTDataWrapper = paramQuickSetupDeviceInfoBean;
        if (paramIoTDataWrapper != null) {
          QsFirmwareViewModel.g(QsFirmwareViewModel.this, paramIoTDataWrapper, paramInt);
        }
        return QsFirmwareViewModel.h(QsFirmwareViewModel.this, localLocalIoTBaseDevice);
      }
      b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get Device Info失败");
      return q.f0(new IoTDataWrapper());
    }
  }
  
  class c
    implements j<FirmwareListResult, t<IoTDataWrapper<ThingFirmware>>>
  {
    c() {}
    
    public t<IoTDataWrapper<ThingFirmware>> a(FirmwareListResult paramFirmwareListResult)
      throws Exception
    {
      if ((paramFirmwareListResult != null) && (paramFirmwareListResult.getFwList() != null) && (!paramFirmwareListResult.getFwList().isEmpty())) {
        return QsFirmwareViewModel.i(QsFirmwareViewModel.this).r5();
      }
      return q.f0(new IoTDataWrapper());
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      QsFirmwareViewModel.j(QsFirmwareViewModel.this).postValue(new FwDownloadStatus(3));
    }
  }
  
  class e
    implements g<FwDownloadStatus>
  {
    e() {}
    
    public void a(FwDownloadStatus paramFwDownloadStatus)
      throws Exception
    {
      QsFirmwareViewModel.k(QsFirmwareViewModel.this, paramFwDownloadStatus);
    }
  }
  
  class f
    implements g<Long>
  {
    f(FwDownloadStatus paramFwDownloadStatus) {}
    
    public void a(Long paramLong)
      throws Exception
    {
      paramFwDownloadStatus.setErrorCode(6);
      QsFirmwareViewModel.j(QsFirmwareViewModel.this).postValue(paramFwDownloadStatus);
    }
  }
  
  class g
    implements io.reactivex.g0.c<IoTDataWrapper<LocalIoTBaseDevice>, IoTDataWrapper<List<ComponentBean>>, IoTDataWrapper<LocalIoTBaseDevice>>
  {
    g() {}
    
    public IoTDataWrapper<LocalIoTBaseDevice> a(IoTDataWrapper<LocalIoTBaseDevice> paramIoTDataWrapper, IoTDataWrapper<List<ComponentBean>> paramIoTDataWrapper1)
      throws Exception
    {
      if ((paramIoTDataWrapper != null) && (paramIoTDataWrapper.getData() != null) && (paramIoTDataWrapper1 != null) && (paramIoTDataWrapper1.getData() != null))
      {
        LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)paramIoTDataWrapper.getData();
        if (localLocalIoTBaseDevice != null) {
          localLocalIoTBaseDevice.setComponents((List)paramIoTDataWrapper1.getData());
        }
        if ((QsFirmwareViewModel.i(QsFirmwareViewModel.this).b() != null) && (((ThingContext)QsFirmwareViewModel.i(QsFirmwareViewModel.this).b()).getIoTDevice() != null))
        {
          ((ALIoTDevice)((ThingContext)QsFirmwareViewModel.i(QsFirmwareViewModel.this).b()).getIoTDevice()).updateLocalIoTDevice(localLocalIoTBaseDevice);
          QsFirmwareViewModel.l(QsFirmwareViewModel.this).L3();
        }
      }
      else
      {
        paramIoTDataWrapper1 = null;
        if (paramIoTDataWrapper != null) {
          paramIoTDataWrapper1 = (LocalIoTBaseDevice)paramIoTDataWrapper.getData();
        }
        if ((QsFirmwareViewModel.i(QsFirmwareViewModel.this).b() != null) && (((ThingContext)QsFirmwareViewModel.i(QsFirmwareViewModel.this).b()).getIoTDevice() != null))
        {
          ((ALIoTDevice)((ThingContext)QsFirmwareViewModel.i(QsFirmwareViewModel.this).b()).getIoTDevice()).setLocalIoTDevice(paramIoTDataWrapper1);
          ((ALIoTDevice)((ThingContext)QsFirmwareViewModel.i(QsFirmwareViewModel.this).b()).getIoTDevice()).setDeviceState(EnumIoTDeviceState.OFFLINE);
          QsFirmwareViewModel.l(QsFirmwareViewModel.this).L3();
        }
      }
      return paramIoTDataWrapper;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\QsFirmwareViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */