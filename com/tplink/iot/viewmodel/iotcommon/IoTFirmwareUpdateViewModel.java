package com.tplink.iot.viewmodel.iotcommon;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.RealTimeBatteryInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class IoTFirmwareUpdateViewModel
  extends AndroidViewModel
{
  private AbstractThingRepository a;
  private AbstractSubThingRepository b;
  private TPIoTClientManager c;
  private MediatorLiveData<FirmwareDownloadState> d = new MediatorLiveData();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private SingleLiveEvent<Integer> f = new SingleLiveEvent();
  public ObservableBoolean g;
  private MediatorLiveData<Boolean> h;
  public boolean i;
  public boolean j;
  private final MutableLiveData<i<RealTimeBatteryInfoResult>> k;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> l;
  private final BaseALIoTDevice m;
  
  public IoTFirmwareUpdateViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    boolean bool = false;
    this.g = new ObservableBoolean(false);
    this.h = new MediatorLiveData();
    this.i = false;
    this.j = false;
    this.k = new MutableLiveData();
    this.l = new MutableLiveData();
    this.m = paramThingContext.getIoTDevice();
    this.c = ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class));
    paramApplication = com.tplink.libtpnetwork.IoTNetwork.util.c.c(paramThingContext);
    if ((paramApplication instanceof AbstractThingRepository)) {
      this.a = ((AbstractThingRepository)paramApplication);
    } else if ((paramApplication instanceof AbstractSubThingRepository)) {
      this.b = ((AbstractSubThingRepository)paramApplication);
    } else {
      this.a = ((AbstractThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, PlugRepository.class));
    }
    if (paramThingContext.getIoTDevice() != null) {
      this.i = ((ALIoTDevice)paramThingContext.getIoTDevice()).isSubDevice();
    }
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null))
    {
      paramApplication = ((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice();
      int n = paramApplication.getComponentVersion(EnumIoTComponent.FIRMWARE);
      paramThingContext = this.g;
      if (n >= 2) {
        bool = true;
      }
      paramThingContext.set(bool);
      this.j = paramApplication.isSupportComponent(EnumIoTComponent.BATTERY_DETECT);
    }
    paramApplication = new MutableLiveData();
    paramThingContext = this.a;
    if (paramThingContext != null)
    {
      paramApplication = paramThingContext.Z0();
    }
    else
    {
      paramThingContext = this.b;
      if (paramThingContext != null) {
        paramApplication = paramThingContext.R0();
      }
    }
    this.h.addSource(paramApplication, new g(this));
  }
  
  private int A(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return paramBoolean2;
    }
    return 2;
  }
  
  private void U(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            switch (paramInt)
            {
            default: 
              break;
            case -1001: 
              this.f.postValue(Integer.valueOf(4));
              break;
            case -1002: 
              this.f.postValue(Integer.valueOf(6));
              break;
            case -1003: 
              this.f.postValue(Integer.valueOf(9));
              break;
            }
          } else {
            this.f.postValue(Integer.valueOf(8));
          }
        }
        else {
          this.f.postValue(Integer.valueOf(5));
        }
      }
      else {
        this.f.postValue(Integer.valueOf(3));
      }
    }
    else {
      this.f.postValue(Integer.valueOf(2));
    }
  }
  
  private io.reactivex.a V()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((AbstractThingRepository)localObject).d5();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((AbstractSubThingRepository)localObject).f4();
    }
    return io.reactivex.a.e();
  }
  
  private q<Boolean> n()
  {
    if (this.g.get())
    {
      AbstractThingRepository localAbstractThingRepository = this.a;
      if (localAbstractThingRepository != null) {
        return localAbstractThingRepository.E1().g0(e.c);
      }
    }
    return q.f0(Boolean.TRUE);
  }
  
  private q<FirmwareDownloadState> r()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((AbstractThingRepository)localObject).u1();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((AbstractSubThingRepository)localObject).e1();
    }
    return q.I();
  }
  
  private q<ThingFirmware> s()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((AbstractThingRepository)localObject).v1();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((AbstractSubThingRepository)localObject).g1();
    }
    return q.I();
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> B()
  {
    return this.l;
  }
  
  public String C(Context paramContext)
  {
    BaseALIoTDevice localBaseALIoTDevice = this.m;
    if (localBaseALIoTDevice != null) {
      return l.b(paramContext, localBaseALIoTDevice);
    }
    return "";
  }
  
  public MutableLiveData<i<RealTimeBatteryInfoResult>> D()
  {
    return this.k;
  }
  
  public SingleLiveEvent<Boolean> E()
  {
    return this.e;
  }
  
  public void S()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AbstractThingRepository)localObject).y4(false);
    }
    else
    {
      localObject = this.b;
      if (localObject != null) {
        ((AbstractSubThingRepository)localObject).O3(false);
      }
    }
  }
  
  @SuppressLint({"CheckResult"})
  public void T()
  {
    V().r(io.reactivex.d0.b.a.a()).A(new c(), new d());
  }
  
  public q<FirmwareDownloadState> j()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((AbstractThingRepository)localObject).u1();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((AbstractSubThingRepository)localObject).O0();
    }
    return q.I();
  }
  
  public void k()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((BaseALIoTDevice)localObject).isSubDevice()))
    {
      localObject = this.c.Z1(this.m.getParentDeviceIDMD5());
      if (localObject != null)
      {
        localObject = (HubRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(((BaseALIoTDevice)localObject).getDeviceIdMD5(), HubRepository.class);
        if (((AbstractThingRepository)localObject).w1().getValue() != null) {
          this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(A(true, ((ThingFirmware)((AbstractThingRepository)localObject).w1().getValue()).isNeedToUpgrade()))));
        } else {
          ((AbstractThingRepository)localObject).v1().E(new d(this)).C(new b(this)).F0();
        }
      }
      else
      {
        this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(A(false, false))));
      }
    }
    else
    {
      this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(A(false, false))));
    }
  }
  
  public void l()
  {
    b.d.w.c.a.n("FirmwareUpdate", "checkRealTimeBatteryInfo");
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((AbstractSubThingRepository)localObject).n1();
    } else {
      localObject = q.f0(new RealTimeBatteryInfoResult());
    }
    ((q)localObject).F(new f(this)).C(new a(this)).E(new c(this)).F0();
  }
  
  public void m()
  {
    q.f1(s(), j(), new b()).T0(30L, TimeUnit.SECONDS).C(new a()).F0();
    n().F0();
  }
  
  public LiveData<Boolean> o()
  {
    return this.h;
  }
  
  public BaseALIoTDevice p()
  {
    return this.m;
  }
  
  public String t(Context paramContext)
  {
    BaseALIoTDevice localBaseALIoTDevice = this.m;
    if (localBaseALIoTDevice != null) {
      return l.e(paramContext, localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceName(), localBaseALIoTDevice.getDeviceModel());
    }
    return "";
  }
  
  public void u()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AbstractThingRepository)localObject).m1().F0();
    }
    else
    {
      localObject = this.b;
      if (localObject != null) {
        ((AbstractSubThingRepository)localObject).b1().F0();
      }
    }
  }
  
  public LiveData<FirmwareDownloadState> v()
  {
    return this.d;
  }
  
  public void w()
  {
    r().l0(io.reactivex.d0.b.a.a()).E(new f()).C(new e()).F0();
  }
  
  public void x()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AbstractThingRepository)localObject).v1().F0();
    }
    else
    {
      localObject = this.b;
      if (localObject != null) {
        ((AbstractSubThingRepository)localObject).g1().F0();
      }
    }
  }
  
  public LiveData<ThingFirmware> y()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((AbstractThingRepository)localObject).w1();
    }
    localObject = this.b;
    if (localObject != null) {
      return ((AbstractSubThingRepository)localObject).h1();
    }
    return new MutableLiveData();
  }
  
  public SingleLiveEvent<Integer> z()
  {
    return this.f;
  }
  
  class a
    implements io.reactivex.g0.g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.n("FirmwareUpdate", "doInitCheck error");
      IoTFirmwareUpdateViewModel.f(IoTFirmwareUpdateViewModel.this).postValue(Integer.valueOf(7));
    }
  }
  
  class b
    implements io.reactivex.g0.c<ThingFirmware, FirmwareDownloadState, Boolean>
  {
    b() {}
    
    @NonNull
    public Boolean a(@NonNull ThingFirmware paramThingFirmware, @NonNull FirmwareDownloadState paramFirmwareDownloadState)
      throws Exception
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doInitCheck apply: ");
      localStringBuilder.append(paramThingFirmware.isNeedToUpgrade());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramFirmwareDownloadState.getUpgradeTime());
      localStringBuilder.append(" ");
      localStringBuilder.append(paramThingFirmware.getFwVer());
      b.d.w.c.a.n("FirmwareUpdate", localStringBuilder.toString());
      if (!paramThingFirmware.isNeedToUpgrade())
      {
        IoTFirmwareUpdateViewModel.f(IoTFirmwareUpdateViewModel.this).postValue(Integer.valueOf(7));
      }
      else
      {
        int i = paramFirmwareDownloadState.getStatus();
        if ((paramFirmwareDownloadState.getStatus() == 64535) || (paramFirmwareDownloadState.getStatus() == 64534)) {
          i = 0;
        }
        IoTFirmwareUpdateViewModel.g(IoTFirmwareUpdateViewModel.this, i);
        IoTFirmwareUpdateViewModel.h(IoTFirmwareUpdateViewModel.this).postValue(paramFirmwareDownloadState);
      }
      return Boolean.TRUE;
    }
  }
  
  class c
    implements io.reactivex.g0.a
  {
    c() {}
    
    public void run()
      throws Exception
    {
      IoTFirmwareUpdateViewModel.i(IoTFirmwareUpdateViewModel.this).postValue(Boolean.TRUE);
    }
  }
  
  class d
    implements io.reactivex.g0.g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        w.f();
      }
      IoTFirmwareUpdateViewModel.i(IoTFirmwareUpdateViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class e
    implements io.reactivex.g0.g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      IoTFirmwareUpdateViewModel.g(IoTFirmwareUpdateViewModel.this, 64535);
      paramThrowable = new FirmwareDownloadState();
      paramThrowable.setStatus(64535);
      IoTFirmwareUpdateViewModel.h(IoTFirmwareUpdateViewModel.this).postValue(paramThrowable);
    }
  }
  
  class f
    implements io.reactivex.g0.g<FirmwareDownloadState>
  {
    f() {}
    
    public void a(FirmwareDownloadState paramFirmwareDownloadState)
      throws Exception
    {
      IoTFirmwareUpdateViewModel.g(IoTFirmwareUpdateViewModel.this, paramFirmwareDownloadState.getStatus());
      IoTFirmwareUpdateViewModel.h(IoTFirmwareUpdateViewModel.this).postValue(paramFirmwareDownloadState);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\IoTFirmwareUpdateViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */