package com.tplink.iot.devices.trv.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.EnumShutdownMode;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.RemoveScaleInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ShutdownInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.TRVEarlyStartBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.WindowOpenDetectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureOffsetParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureRangeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureUnitParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.ProgressCalibrationInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.RemoveScaleStatusResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<*>;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType.a;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public final class TRVSettingsViewModel
  extends IoTSettingsBaseViewModel
{
  private final boolean A;
  private final boolean B;
  private final boolean C;
  private final boolean D;
  private final boolean E;
  private final boolean F;
  private final boolean G;
  private final LiveData<FrostProtectionBean> H;
  private final LiveData<ChildProtectionBean> I;
  private final LiveData<WindowOpenDetectionBean> J;
  private final LiveData<RemoveScaleInfoBean> K;
  private final LiveData<RemoveScaleStatusResult> L;
  private final LiveData<ShutdownInfoBean> M;
  private final LiveData<ProgressCalibrationInfoResult> N;
  private final LiveData<TRVEarlyStartBean> O;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> P;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> Q;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> R;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> S;
  private io.reactivex.e0.c T;
  private io.reactivex.e0.c U;
  private final kotlin.t.c p;
  private final LiveData<IoTSubDevice> q;
  private final LiveData<Boolean> r;
  private final LiveData<String> s;
  private final LiveData<String> t;
  private final LiveData<String> u;
  private final LiveData<String> v;
  private final LiveData<String> w;
  private final LiveData<String> x;
  private final LiveData<String> y;
  private final boolean z;
  
  public TRVSettingsViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
    this.p = new a(paramThingContext);
    paramApplication = Transformations.map(j(), q.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…ce as? IoTSubDevice\n    }");
    this.q = paramApplication;
    LiveData localLiveData = Transformations.map(j(), h.a);
    kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(alIo…eTypeDevice ?: true\n    }");
    this.r = localLiveData;
    localLiveData = Transformations.map(O().w4(), g.a);
    kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(mTRV…emp, it.tempUnit) }\n    }");
    this.s = localLiveData;
    localLiveData = Transformations.map(O().s4(), new f(this));
    kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(mTRV…lse -> \"\"\n        }\n    }");
    this.t = localLiveData;
    localLiveData = Transformations.map(paramApplication, p.a);
    kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(trvD…getUnitText() ?: \"\"\n    }");
    this.u = localLiveData;
    localLiveData = Transformations.map(paramApplication, o.a);
    kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(trvD…)}\"\n        } ?: \"\"\n    }");
    this.v = localLiveData;
    paramApplication = Transformations.map(paramApplication, n.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(trvD…t }\n        } ?: \"\"\n    }");
    this.w = paramApplication;
    paramApplication = Transformations.map(O().H4(), new r(this));
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mTRV…lse -> \"\"\n        }\n    }");
    this.x = paramApplication;
    paramApplication = Transformations.map(O().D4(), new k(this));
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mTRV…lse -> \"\"\n        }\n    }");
    this.y = paramApplication;
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
    if (paramApplication != null) {
      paramApplication = paramApplication.getLocalIoTDevice();
    } else {
      paramApplication = null;
    }
    this.z = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.FROST_PROTECTION);
    this.A = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.CHILD_PROTECTION);
    this.B = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.TEMPERATURE);
    this.C = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.TEMP_CONTROL);
    this.D = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.WINDOW_OPEN_DETECT);
    this.E = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.REMOVE_SCALE);
    this.F = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.SHUTDOWN_MODE);
    this.G = com.tplink.iot.Utils.w0.b.a(paramApplication, EnumIoTComponent.PROGRESS_CALIBRATION);
    this.H = O().w4();
    this.I = O().s4();
    this.J = O().H4();
    this.K = O().z4();
    this.L = O().B4();
    this.M = O().D4();
    this.N = O().y4();
    this.O = O().u4();
    paramApplication = new MutableLiveData();
    this.P = paramApplication;
    this.Q = paramApplication;
    paramApplication = new MutableLiveData();
    this.R = paramApplication;
    this.S = paramApplication;
  }
  
  private final TRVRepository O()
  {
    return (TRVRepository)this.p.b(this, o[0]);
  }
  
  public final void C()
  {
    io.reactivex.e0.c localc = this.U;
    if ((localc != null) && (!localc.isDisposed()))
    {
      localc = this.U;
      if (localc != null) {
        localc.dispose();
      }
    }
  }
  
  public final void D()
  {
    io.reactivex.e0.c localc = this.T;
    if ((localc != null) && (!localc.isDisposed()))
    {
      localc = this.T;
      if (localc != null) {
        localc.dispose();
      }
    }
  }
  
  public final void E()
  {
    IoTDataWrapper localIoTDataWrapper = new IoTDataWrapper(Boolean.FALSE);
    this.U = O().x4().E(new b(localIoTDataWrapper)).o(3L, TimeUnit.SECONDS).s0(new c(localIoTDataWrapper)).F0();
  }
  
  public final void F()
  {
    IoTDataWrapper localIoTDataWrapper = new IoTDataWrapper(Boolean.FALSE);
    this.T = O().A4().E(new d(localIoTDataWrapper)).o(5L, TimeUnit.SECONDS).s0(new e(localIoTDataWrapper)).F0();
  }
  
  public final void G()
  {
    O().r4().F0();
  }
  
  public final LiveData<ChildProtectionBean> H()
  {
    return this.I;
  }
  
  public final LiveData<String> I()
  {
    return this.t;
  }
  
  public final void J()
  {
    O().t4().F0();
  }
  
  public final LiveData<TRVEarlyStartBean> K()
  {
    return this.O;
  }
  
  public final void L()
  {
    O().v4().F0();
  }
  
  public final LiveData<FrostProtectionBean> M()
  {
    return this.H;
  }
  
  public final LiveData<String> N()
  {
    return this.s;
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> P()
  {
    return this.S;
  }
  
  public final void Q()
  {
    O().x4().F0();
  }
  
  public final LiveData<ProgressCalibrationInfoResult> R()
  {
    return this.N;
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> S()
  {
    return this.Q;
  }
  
  public final LiveData<RemoveScaleInfoBean> T()
  {
    return this.K;
  }
  
  public final LiveData<RemoveScaleStatusResult> U()
  {
    return this.L;
  }
  
  public final void V()
  {
    O().C4().F0();
  }
  
  public final LiveData<ShutdownInfoBean> W()
  {
    return this.M;
  }
  
  public final LiveData<String> X()
  {
    return this.y;
  }
  
  public final LiveData<String> Y()
  {
    return this.w;
  }
  
  public final LiveData<String> Z()
  {
    return this.v;
  }
  
  public final LiveData<String> a0()
  {
    return this.u;
  }
  
  public final LiveData<IoTSubDevice> b0()
  {
    return this.q;
  }
  
  public final void c0()
  {
    O().G4().F0();
  }
  
  public final LiveData<WindowOpenDetectionBean> d0()
  {
    return this.J;
  }
  
  public final LiveData<String> e0()
  {
    return this.x;
  }
  
  public final boolean f0()
  {
    return this.A;
  }
  
  public final boolean g0()
  {
    return this.z;
  }
  
  public final boolean h0()
  {
    return this.G;
  }
  
  public final boolean i0()
  {
    return this.F;
  }
  
  public final boolean j0()
  {
    return this.D;
  }
  
  public final LiveData<Boolean> k0()
  {
    return this.r;
  }
  
  public int l(String paramString)
  {
    return com.tplink.iot.g.d.a.b.g(EnumTRVAvatarType.Companion.a(paramString));
  }
  
  public final void l0()
  {
    O().I4().i(new i(this)).j(new j(this)).y();
  }
  
  public void m()
  {
    O().Z0().F0();
  }
  
  public final void m0(boolean paramBoolean)
  {
    O().O4(new RemoveScaleInfoBean(paramBoolean)).y();
  }
  
  public final void n0(boolean paramBoolean)
  {
    O().K4(new ChildProtectionBean(paramBoolean)).y();
  }
  
  public void o()
  {
    O().g1().F0();
  }
  
  public final void o0(boolean paramBoolean)
  {
    O().M4(new TRVEarlyStartBean(paramBoolean)).y();
  }
  
  public LiveData<ThingFirmware> p()
  {
    MutableLiveData localMutableLiveData = O().h1();
    kotlin.jvm.internal.j.d(localMutableLiveData, "mTRVRepository.firmwareLatestInfoData");
    return localMutableLiveData;
  }
  
  public final io.reactivex.a p0(int paramInt, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    kotlin.jvm.internal.j.e(paramEnumTemperatureUnit, "tempUnit");
    return O().N4(new FrostProtectionBean(paramInt, paramEnumTemperatureUnit.getValue()));
  }
  
  public final io.reactivex.a q0(boolean paramBoolean, EnumShutdownMode paramEnumShutdownMode)
  {
    kotlin.jvm.internal.j.e(paramEnumShutdownMode, "enumMode");
    return O().P4(new ShutdownInfoBean(paramBoolean, paramEnumShutdownMode.getValue()));
  }
  
  public final io.reactivex.a r0(int paramInt, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    kotlin.jvm.internal.j.e(paramEnumTemperatureUnit, "tempUnit");
    return O().Q4(new TemperatureOffsetParams(paramInt, paramEnumTemperatureUnit.getValue()));
  }
  
  public final io.reactivex.a s0(int paramInt1, int paramInt2, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    kotlin.jvm.internal.j.e(paramEnumTemperatureUnit, "tempUnit");
    return O().R4(new TemperatureRangeParams(paramInt1, paramInt2, paramEnumTemperatureUnit.getValue()));
  }
  
  public final io.reactivex.a t0(EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    kotlin.jvm.internal.j.e(paramEnumTemperatureUnit, "tempUnit");
    return O().S4(new TemperatureUnitParams(paramEnumTemperatureUnit.getValue()));
  }
  
  public final io.reactivex.a u0(WindowOpenDetectionBean paramWindowOpenDetectionBean)
  {
    kotlin.jvm.internal.j.e(paramWindowOpenDetectionBean, "info");
    return O().T4(paramWindowOpenDetectionBean);
  }
  
  public final void v0()
  {
    O().U4().i(new l(this)).j(new m(this)).y();
  }
  
  public static final class a
    implements kotlin.t.c<Object, TRVRepository>
  {
    private final TRVRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, TRVRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public TRVRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class b<T>
    implements g<ProgressCalibrationInfoResult>
  {
    b(IoTDataWrapper paramIoTDataWrapper) {}
    
    public final void a(ProgressCalibrationInfoResult paramProgressCalibrationInfoResult)
    {
      IoTDataWrapper localIoTDataWrapper = this.c;
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (paramProgressCalibrationInfoResult != null) {
        if (paramProgressCalibrationInfoResult.getStatus() != 1) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      localIoTDataWrapper.setData(Boolean.valueOf(bool2));
    }
  }
  
  static final class c
    implements io.reactivex.g0.e
  {
    c(IoTDataWrapper paramIoTDataWrapper) {}
    
    public final boolean a()
    {
      Object localObject = this.a.getData();
      kotlin.jvm.internal.j.d(localObject, "stop.data");
      return ((Boolean)localObject).booleanValue();
    }
  }
  
  static final class d<T>
    implements g<RemoveScaleStatusResult>
  {
    d(IoTDataWrapper paramIoTDataWrapper) {}
    
    public final void a(RemoveScaleStatusResult paramRemoveScaleStatusResult)
    {
      IoTDataWrapper localIoTDataWrapper = this.c;
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (paramRemoveScaleStatusResult != null) {
        if (paramRemoveScaleStatusResult.getStatus() != 1) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      localIoTDataWrapper.setData(Boolean.valueOf(bool2));
    }
  }
  
  static final class e
    implements io.reactivex.g0.e
  {
    e(IoTDataWrapper paramIoTDataWrapper) {}
    
    public final boolean a()
    {
      Object localObject = this.a.getData();
      kotlin.jvm.internal.j.d(localObject, "stop.data");
      return ((Boolean)localObject).booleanValue();
    }
  }
  
  static final class f<I, O>
    implements Function<ChildProtectionBean, String>
  {
    f(TRVSettingsViewModel paramTRVSettingsViewModel) {}
    
    public final String a(ChildProtectionBean paramChildProtectionBean)
    {
      if (paramChildProtectionBean != null) {
        paramChildProtectionBean = Boolean.valueOf(paramChildProtectionBean.getEnable());
      } else {
        paramChildProtectionBean = null;
      }
      if (kotlin.jvm.internal.j.a(paramChildProtectionBean, Boolean.TRUE)) {
        paramChildProtectionBean = this.a.getApplication().getString(2131952442);
      } else if (kotlin.jvm.internal.j.a(paramChildProtectionBean, Boolean.FALSE)) {
        paramChildProtectionBean = this.a.getApplication().getString(2131952440);
      } else {
        paramChildProtectionBean = "";
      }
      return paramChildProtectionBean;
    }
  }
  
  static final class g<I, O>
    implements Function<FrostProtectionBean, String>
  {
    public static final g a = new g();
    
    public final String a(FrostProtectionBean paramFrostProtectionBean)
    {
      if (paramFrostProtectionBean != null) {
        paramFrostProtectionBean = com.tplink.iot.g.d.a.b.e(paramFrostProtectionBean.getMinTemp(), paramFrostProtectionBean.getTempUnit());
      } else {
        paramFrostProtectionBean = null;
      }
      return paramFrostProtectionBean;
    }
  }
  
  static final class h<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final h a = new h();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isUserRoleTypeDevice();
      } else {
        bool = true;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class i
    implements io.reactivex.g0.a
  {
    i(TRVSettingsViewModel paramTRVSettingsViewModel) {}
    
    public final void run()
    {
      this.a.F();
      TRVSettingsViewModel.B(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class j<T>
    implements g<Throwable>
  {
    j(TRVSettingsViewModel paramTRVSettingsViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      TRVSettingsViewModel.B(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  static final class k<I, O>
    implements Function<ShutdownInfoBean, String>
  {
    k(TRVSettingsViewModel paramTRVSettingsViewModel) {}
    
    public final String a(ShutdownInfoBean paramShutdownInfoBean)
    {
      if (paramShutdownInfoBean != null) {
        paramShutdownInfoBean = Boolean.valueOf(paramShutdownInfoBean.getEnable());
      } else {
        paramShutdownInfoBean = null;
      }
      if (kotlin.jvm.internal.j.a(paramShutdownInfoBean, Boolean.TRUE)) {
        paramShutdownInfoBean = this.a.getApplication().getString(2131952442);
      } else if (kotlin.jvm.internal.j.a(paramShutdownInfoBean, Boolean.FALSE)) {
        paramShutdownInfoBean = this.a.getApplication().getString(2131952440);
      } else {
        paramShutdownInfoBean = "";
      }
      return paramShutdownInfoBean;
    }
  }
  
  static final class l
    implements io.reactivex.g0.a
  {
    l(TRVSettingsViewModel paramTRVSettingsViewModel) {}
    
    public final void run()
    {
      b.d.w.c.a.n("TRV", "startProgressCalibration onComplete");
      io.reactivex.a.F(2L, TimeUnit.SECONDS).i(new a(this)).y();
      TRVSettingsViewModel.A(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
    
    static final class a
      implements io.reactivex.g0.a
    {
      a(TRVSettingsViewModel.l paraml) {}
      
      public final void run()
      {
        b.d.w.c.a.n("TRV", "checkProgressCalibrationStatus");
        this.a.a.E();
      }
    }
  }
  
  static final class m<T>
    implements g<Throwable>
  {
    m(TRVSettingsViewModel paramTRVSettingsViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      TRVSettingsViewModel.A(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  static final class n<I, O>
    implements Function<IoTSubDevice, String>
  {
    public static final n a = new n();
    
    public final String a(IoTSubDevice paramIoTSubDevice)
    {
      String str2;
      if (paramIoTSubDevice != null)
      {
        String str1 = com.tplink.iot.g.d.a.b.e(paramIoTSubDevice.getTempOffset(), paramIoTSubDevice.getTempUnit());
        str2 = str1;
        if (paramIoTSubDevice.getTempOffset() > 0)
        {
          paramIoTSubDevice = new StringBuilder();
          paramIoTSubDevice.append('+');
          paramIoTSubDevice.append(str1);
          str2 = paramIoTSubDevice.toString();
        }
        if (str2 != null) {}
      }
      else
      {
        str2 = "";
      }
      return str2;
    }
  }
  
  static final class o<I, O>
    implements Function<IoTSubDevice, String>
  {
    public static final o a = new o();
    
    public final String a(IoTSubDevice paramIoTSubDevice)
    {
      if (paramIoTSubDevice != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(com.tplink.iot.g.d.a.b.e(paramIoTSubDevice.getMinControlTemp(), paramIoTSubDevice.getTempUnit()));
        localStringBuilder.append(" - ");
        localStringBuilder.append(com.tplink.iot.g.d.a.b.e(paramIoTSubDevice.getMaxControlTemp(), paramIoTSubDevice.getTempUnit()));
        paramIoTSubDevice = localStringBuilder.toString();
        if (paramIoTSubDevice != null) {}
      }
      else
      {
        paramIoTSubDevice = "";
      }
      return paramIoTSubDevice;
    }
  }
  
  static final class p<I, O>
    implements Function<IoTSubDevice, String>
  {
    public static final p a = new p();
    
    public final String a(IoTSubDevice paramIoTSubDevice)
    {
      if (paramIoTSubDevice != null)
      {
        paramIoTSubDevice = paramIoTSubDevice.getEnumTempUnit();
        if (paramIoTSubDevice != null)
        {
          paramIoTSubDevice = paramIoTSubDevice.getUnitText();
          if (paramIoTSubDevice != null) {
            return paramIoTSubDevice;
          }
        }
      }
      paramIoTSubDevice = "";
      return paramIoTSubDevice;
    }
  }
  
  static final class q<I, O>
    implements Function<BaseALIoTDevice<?>, IoTSubDevice>
  {
    public static final q a = new q();
    
    public final IoTSubDevice a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      Object localObject = null;
      if (paramBaseALIoTDevice != null) {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getLocalIoTDevice();
      } else {
        paramBaseALIoTDevice = null;
      }
      if (!(paramBaseALIoTDevice instanceof IoTSubDevice)) {
        paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject;
      }
      return (IoTSubDevice)paramBaseALIoTDevice;
    }
  }
  
  static final class r<I, O>
    implements Function<WindowOpenDetectionBean, String>
  {
    r(TRVSettingsViewModel paramTRVSettingsViewModel) {}
    
    public final String a(WindowOpenDetectionBean paramWindowOpenDetectionBean)
    {
      if (paramWindowOpenDetectionBean != null) {
        paramWindowOpenDetectionBean = Boolean.valueOf(paramWindowOpenDetectionBean.getEnable());
      } else {
        paramWindowOpenDetectionBean = null;
      }
      if (kotlin.jvm.internal.j.a(paramWindowOpenDetectionBean, Boolean.TRUE)) {
        paramWindowOpenDetectionBean = this.a.getApplication().getString(2131952442);
      } else if (kotlin.jvm.internal.j.a(paramWindowOpenDetectionBean, Boolean.FALSE)) {
        paramWindowOpenDetectionBean = this.a.getApplication().getString(2131952440);
      } else {
        paramWindowOpenDetectionBean = "";
      }
      return paramWindowOpenDetectionBean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\viewmodel\TRVSettingsViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */