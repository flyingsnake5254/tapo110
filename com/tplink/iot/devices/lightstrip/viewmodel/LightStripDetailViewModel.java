package com.tplink.iot.devices.lightstrip.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.devicecommon.feature.NextEventFeature.b;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.iot.musicphonerhythm.repository.MusicNetworkRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.libtpnetwork.IoTNetwork.w;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.t.c;

public final class LightStripDetailViewModel
  extends IoTDetailBaseViewModel
{
  private final f A;
  private final NextEventFeature.b B;
  private final AbstractThingRepository C;
  private final c s;
  private final c t;
  private final c u;
  private final LiveData<IoTLightStripDevice> v;
  private final LiveData<ThingUsage> w;
  private final LiveData<List<LightStateBean>> x;
  private final f y;
  private final f z;
  
  public LightStripDetailViewModel(Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
    this.s = new b(paramThingContext);
    this.t = new a(paramThingContext);
    this.u = new c(paramThingContext);
    paramApplication = Transformations.map(W().j1(), d.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mLig…IoTLightStripDevice\n    }");
    this.v = paramApplication;
    paramApplication = W().t1();
    kotlin.jvm.internal.j.d(paramApplication, "mLightStripRepository.deviceUsageLiveData");
    this.w = paramApplication;
    this.x = W().u5();
    paramApplication = LazyThreadSafetyMode.NONE;
    this.y = h.a(paramApplication, new f(this));
    this.z = h.a(paramApplication, new g(this));
    this.A = h.a(paramApplication, new e(this));
    this.B = new h(this, paramThingContext);
    this.C = W();
  }
  
  private final void R()
  {
    W().k1().F0();
  }
  
  private final LightStripRepository W()
  {
    return (LightStripRepository)this.s.b(this, r[0]);
  }
  
  private final LightingEffectRepository X()
  {
    return (LightingEffectRepository)this.t.b(this, r[1]);
  }
  
  private final MusicNetworkRepository Z()
  {
    return (MusicNetworkRepository)this.u.b(this, r[2]);
  }
  
  private final void a0()
  {
    W().x1().F0();
  }
  
  private final q<TDPIoTDevice> o0(String paramString)
  {
    paramString = p().P3(AppContext.c, 6, paramString).g0(i.c);
    kotlin.jvm.internal.j.d(paramString, "mTPIoTClientManager.send…          }\n            }");
    return paramString;
  }
  
  private final q<TDPIoTDevice> p0(String paramString)
  {
    paramString = w.f(AppContext.c, null, 6, paramString, null).n(new TDPIoTDevice());
    kotlin.jvm.internal.j.d(paramString, "TDPScanHelper.sendTDPBro…ltIfEmpty(TDPIoTDevice())");
    return paramString;
  }
  
  public void E()
  {
    R();
    if (g0()) {
      U();
    }
  }
  
  public void F()
  {
    o().addSource(W().w1(), new m(this));
  }
  
  public final void O(EditPresetRule paramEditPresetRule)
  {
    kotlin.jvm.internal.j.e(paramEditPresetRule, "editPresetRule");
    W().o5(paramEditPresetRule).y();
  }
  
  public final void P()
  {
    if (W().D()) {
      W().p5().F0();
    }
  }
  
  public final LiveData<IoTLightStripDevice> Q()
  {
    return this.v;
  }
  
  public final void S()
  {
    W().s1().F0();
  }
  
  public final LiveData<ThingUsage> T()
  {
    return this.w;
  }
  
  public final void U()
  {
    W().v5().F0();
  }
  
  public final LiveData<List<LightStateBean>> V()
  {
    return this.x;
  }
  
  public AbstractThingRepository Y()
  {
    return this.C;
  }
  
  public final NextEventFeature.b b0()
  {
    return this.B;
  }
  
  public final void c0()
  {
    W().w5().F0();
  }
  
  public final boolean d0()
  {
    int i = com.tplink.iot.Utils.w0.a.a(n(), EnumIoTComponent.MUSIC_RHYTHM);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean e0()
  {
    return com.tplink.iot.Utils.w0.a.g(n(), EnumIoTComponent.AUTO_LIGHT);
  }
  
  public final boolean f0()
  {
    return ((Boolean)this.A.getValue()).booleanValue();
  }
  
  public final boolean g0()
  {
    return com.tplink.iot.Utils.w0.a.g(n(), EnumIoTComponent.LIGHT_STRIP_LIGHTING_EFFECT);
  }
  
  public final boolean h0()
  {
    return com.tplink.iot.Utils.w0.a.g(n(), EnumIoTComponent.MUSIC_RHYTHM);
  }
  
  public final boolean i0(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
    paramString = TPIoTClientManager.k2(paramString);
    kotlin.jvm.internal.j.d(paramString, "TPIoTClientManager.getThingContext(deviceIdMD5)");
    boolean bool;
    if (paramString.getThingModel().getThingProperty("music_rhythm_mode") != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public q<CloudConnectStateResult> j()
  {
    q localq = W().b1();
    kotlin.jvm.internal.j.d(localq, "mLightStripRepository.cloudConnectState");
    return localq;
  }
  
  public final boolean j0()
  {
    return ((Boolean)this.y.getValue()).booleanValue();
  }
  
  public final void k0()
  {
    X().W().F0();
  }
  
  public final void l0()
  {
    X().a0().F0();
  }
  
  public final void m0()
  {
    W().h1().F0();
  }
  
  public final q<TDPIoTDevice> n0(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice != null)
    {
      String str = paramBaseALIoTDevice.getDeviceIdMD5();
      if (str != null)
      {
        if (paramBaseALIoTDevice.isUserRoleTypeDevice()) {
          return p0(str);
        }
        return o0(str);
      }
    }
    paramBaseALIoTDevice = q.f0(new TDPIoTDevice());
    kotlin.jvm.internal.j.d(paramBaseALIoTDevice, "Observable.just(TDPIoTDevice())");
    return paramBaseALIoTDevice;
  }
  
  public final void q0(AutoLightBean paramAutoLightBean)
  {
    kotlin.jvm.internal.j.e(paramAutoLightBean, "autoLight");
    W().C5(paramAutoLightBean).i(new j(this)).y();
  }
  
  public final void r0(int paramInt, boolean paramBoolean)
  {
    W().D5(paramInt, paramBoolean).y();
  }
  
  public final void s0(boolean paramBoolean)
  {
    final long l = System.currentTimeMillis();
    W().i(paramBoolean).i(new k(this, l)).j(new l(this, l)).y();
  }
  
  public final void t0(LightStateBean paramLightStateBean)
  {
    kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
    W().G5(paramLightStateBean).y();
  }
  
  public final void u0(LightingEffectData paramLightingEffectData)
  {
    kotlin.jvm.internal.j.e(paramLightingEffectData, "effectData");
    paramLightingEffectData.enable = Integer.valueOf(1);
    W().I5(paramLightingEffectData).y();
  }
  
  public final void v0(int paramInt, boolean paramBoolean)
  {
    W().H5(paramInt, paramBoolean).y();
  }
  
  public final q<Boolean> w0()
  {
    return q.m(new n(this));
  }
  
  public static final class a
    implements c<Object, LightingEffectRepository>
  {
    private final LightingEffectRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = b.a(paramThingContext.getAccountContext(), LightingEffectRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "CloudRepositoryProviders…ontext, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public LightingEffectRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class b
    implements c<Object, LightStripRepository>
  {
    private final LightStripRepository a;
    
    public b(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, LightStripRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public LightStripRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class c
    implements c<Object, MusicNetworkRepository>
  {
    private final MusicNetworkRepository a;
    
    public c(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, MusicNetworkRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public MusicNetworkRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class d<I, O>
    implements Function<LocalIoTBaseDevice, IoTLightStripDevice>
  {
    public static final d a = new d();
    
    public final IoTLightStripDevice a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      LocalIoTBaseDevice localLocalIoTBaseDevice = paramLocalIoTBaseDevice;
      if (!(paramLocalIoTBaseDevice instanceof IoTLightStripDevice)) {
        localLocalIoTBaseDevice = null;
      }
      return (IoTLightStripDevice)localLocalIoTBaseDevice;
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<Boolean>
  {
    e(LightStripDetailViewModel paramLightStripDetailViewModel)
    {
      super();
    }
    
    public final boolean invoke()
    {
      return com.tplink.iot.Utils.w0.a.g(LightStripDetailViewModel.J(this.c), EnumIoTComponent.COLOR_TEMPERATURE);
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<Boolean>
  {
    f(LightStripDetailViewModel paramLightStripDetailViewModel)
    {
      super();
    }
    
    public final boolean invoke()
    {
      return com.tplink.iot.Utils.w0.a.g(LightStripDetailViewModel.J(this.c), EnumIoTComponent.PRESET);
    }
  }
  
  static final class g
    extends Lambda
    implements kotlin.jvm.b.a<Boolean>
  {
    g(LightStripDetailViewModel paramLightStripDetailViewModel)
    {
      super();
    }
    
    public final boolean invoke()
    {
      return com.tplink.iot.Utils.w0.a.g(LightStripDetailViewModel.J(this.c), EnumIoTComponent.SEGMENT);
    }
  }
  
  public static final class h
    implements NextEventFeature.b
  {
    h(ThingContext paramThingContext) {}
    
    public void a()
    {
      LightStripDetailViewModel.I(this.a);
    }
    
    public LiveData<NextEvent> b()
    {
      LiveData localLiveData = Transformations.map(LightStripDetailViewModel.K(this.a).y1(), a.a);
      kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(mLig…xtEvent(it)\n            }");
      return localLiveData;
    }
    
    public void c()
    {
      LightStripDetailViewModel.N(this.a);
    }
    
    public String d()
    {
      Object localObject = (ALIoTDevice)paramThingContext.getIoTDevice();
      if (localObject != null)
      {
        localObject = ((ALIoTDevice)localObject).getLocalIoTDevice();
        if (localObject != null) {
          return ((LocalIoTBaseDevice)localObject).getRegion();
        }
      }
      localObject = null;
      return (String)localObject;
    }
    
    static final class a<I, O>
      implements Function<NextEvent, NextEvent>
    {
      public static final a a = new a();
      
      public final NextEvent a(NextEvent paramNextEvent)
      {
        return new BulbNextEvent(paramNextEvent);
      }
    }
  }
  
  static final class i<T, R>
    implements io.reactivex.g0.j<u, TDPIoTDevice>
  {
    public static final i c = new i();
    
    public final TDPIoTDevice a(u paramu)
    {
      kotlin.jvm.internal.j.e(paramu, "tdpConnectResult");
      if (paramu.d())
      {
        paramu = paramu.c();
        if (paramu != null)
        {
          paramu = (ALIoTDevice)paramu.getIoTDevice();
          if (paramu != null)
          {
            paramu = paramu.getTDPIoTDevice();
            if (paramu != null) {
              break label54;
            }
          }
        }
        paramu = new TDPIoTDevice();
        label54:
        return paramu;
      }
      return new TDPIoTDevice();
    }
  }
  
  static final class j
    implements io.reactivex.g0.a
  {
    j(LightStripDetailViewModel paramLightStripDetailViewModel) {}
    
    public final void run()
    {
      if (LightStripDetailViewModel.K(this.a).D()) {
        LightStripDetailViewModel.I(this.a);
      }
    }
  }
  
  static final class k
    implements io.reactivex.g0.a
  {
    k(LightStripDetailViewModel paramLightStripDetailViewModel, long paramLong) {}
    
    public final void run()
    {
      com.tplink.iot.Utils.x0.j.c(LightStripDetailViewModel.J(this.a), System.currentTimeMillis() - l, true);
    }
  }
  
  static final class l<T>
    implements io.reactivex.g0.g<Throwable>
  {
    l(LightStripDetailViewModel paramLightStripDetailViewModel, long paramLong) {}
    
    public final void a(Throwable paramThrowable)
    {
      com.tplink.iot.Utils.x0.j.c(LightStripDetailViewModel.J(this.c), System.currentTimeMillis() - l, false);
    }
  }
  
  static final class m<T>
    implements Observer<ThingFirmware>
  {
    m(LightStripDetailViewModel paramLightStripDetailViewModel) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      MediatorLiveData localMediatorLiveData = LightStripDetailViewModel.L(this.a);
      boolean bool = true;
      if ((paramThingFirmware == null) || (paramThingFirmware.isNeedToUpgrade() != true)) {
        bool = false;
      }
      localMediatorLiveData.postValue(Boolean.valueOf(bool));
    }
  }
  
  static final class n<T>
    implements s<Boolean>
  {
    n(LightStripDetailViewModel paramLightStripDetailViewModel) {}
    
    public final void subscribe(final r<Boolean> paramr)
    {
      kotlin.jvm.internal.j.e(paramr, "emitter");
      final long l = System.currentTimeMillis();
      LightStripDetailViewModel.M(this.a).Q5().F0();
      LightStripDetailViewModel.K(this.a).i(false).i(new a(this, paramr, l)).j(new b(this, paramr, l)).y();
    }
    
    static final class a
      implements io.reactivex.g0.a
    {
      a(LightStripDetailViewModel.n paramn, r paramr, long paramLong) {}
      
      public final void run()
      {
        paramr.onNext(Boolean.TRUE);
        com.tplink.iot.Utils.x0.j.c(LightStripDetailViewModel.J(this.a.a), System.currentTimeMillis() - l, true);
      }
    }
    
    static final class b<T>
      implements io.reactivex.g0.g<Throwable>
    {
      b(LightStripDetailViewModel.n paramn, r paramr, long paramLong) {}
      
      public final void a(Throwable paramThrowable)
      {
        paramr.onNext(Boolean.FALSE);
        com.tplink.iot.Utils.x0.j.c(LightStripDetailViewModel.J(this.c.a), System.currentTimeMillis() - l, false);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\viewmodel\LightStripDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */