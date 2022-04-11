package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.Utils.v0.d;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AIDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LineCrossingDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.NightVisionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TamperDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeviceSettingNewViewModel
  extends AndroidViewModel
{
  public final ObservableField<String> A;
  private io.reactivex.e0.b B;
  private MediatorLiveData<com.tplink.libtpnetwork.cameranetwork.business.model.b> C;
  private MediatorLiveData<o> D;
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> E;
  public MutableLiveData<Boolean> F;
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> G;
  public MutableLiveData<Boolean> H;
  public ObservableBoolean I;
  public ObservableBoolean J;
  public ObservableBoolean K;
  public ObservableBoolean L;
  public ObservableBoolean M;
  public ObservableBoolean N;
  public ObservableBoolean O;
  public ObservableBoolean P;
  public ObservableBoolean Q;
  public ObservableBoolean R;
  public ObservableBoolean S;
  public ObservableBoolean T;
  public ObservableBoolean U;
  public ObservableBoolean V;
  public ObservableBoolean W;
  public ObservableBoolean X;
  public ObservableBoolean Y;
  public ObservableBoolean Z;
  private final String a = DeviceSettingNewViewModel.class.getSimpleName();
  public ObservableBoolean a0;
  public ObservableBoolean b;
  public ObservableBoolean b0;
  public ObservableBoolean c;
  public ObservableBoolean c0;
  public ObservableField<String> d;
  public c d0;
  public ObservableField<String> e;
  public ObservableBoolean e0;
  public ObservableField<String> f;
  private TCDeviceRepository f0;
  public ObservableField<String> g;
  private String g0;
  public ObservableField<String> h;
  @Nullable
  public ALCameraDevice h0;
  public ObservableBoolean i;
  public boolean i0;
  public ObservableBoolean j;
  private CameraSettingRepository j0;
  public ObservableBoolean k;
  private FirmwareRepository k0;
  public ObservableBoolean l;
  private CommonCameraRepository l0;
  public ObservableField<String> m;
  private CloudVideoRepository m0;
  public ObservableBoolean n;
  private LineCrossingDetectionRepository n0;
  public ObservableBoolean o;
  private AreaIntrusionRepository o0;
  public ObservableBoolean p;
  private TamperDetectionRepository p0;
  public ObservableBoolean q;
  private MotionDetectionRepository q0;
  public ObservableBoolean r;
  private AlarmSettingRepository r0;
  public ObservableBoolean s;
  private NightVisionRepository s0;
  public ObservableBoolean t;
  private AIDetectionRepository t0;
  public ObservableBoolean u;
  private FirmwareManager u0;
  public ObservableField<String> v;
  private TPIoTClientManager v0;
  public ObservableField<String> w;
  private boolean w0;
  public ObservableField<String> x;
  private boolean x0;
  public ObservableBoolean y;
  private String y0;
  public final ObservableBoolean z;
  private long z0;
  
  public DeviceSettingNewViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    boolean bool1 = false;
    this.b = new ObservableBoolean(false);
    this.c = new ObservableBoolean(false);
    this.d = new ObservableField();
    this.e = new ObservableField();
    this.f = new ObservableField();
    this.g = new ObservableField();
    this.h = new ObservableField();
    this.i = new ObservableBoolean(false);
    this.j = new ObservableBoolean(false);
    this.k = new ObservableBoolean(false);
    this.l = new ObservableBoolean(false);
    this.m = new ObservableField();
    this.n = new ObservableBoolean(false);
    this.o = new ObservableBoolean(false);
    this.p = new ObservableBoolean(false);
    this.q = new ObservableBoolean(false);
    this.r = new ObservableBoolean(false);
    this.s = new ObservableBoolean(false);
    this.t = new ObservableBoolean(false);
    this.u = new ObservableBoolean(false);
    this.v = new ObservableField();
    this.w = new ObservableField();
    this.x = new ObservableField();
    this.y = new ObservableBoolean(true);
    paramApplication = new ObservableBoolean(false);
    this.z = paramApplication;
    this.A = new ObservableField();
    this.B = new io.reactivex.e0.b();
    this.C = new MediatorLiveData();
    this.D = new MediatorLiveData();
    this.E = new MutableLiveData();
    this.F = new MutableLiveData();
    this.G = new MutableLiveData();
    this.H = new MutableLiveData();
    this.I = new ObservableBoolean(false);
    this.J = new ObservableBoolean();
    this.K = new ObservableBoolean(false);
    this.L = new ObservableBoolean(false);
    this.M = new ObservableBoolean(false);
    this.N = new ObservableBoolean(false);
    this.O = new ObservableBoolean(false);
    this.P = new ObservableBoolean(false);
    this.Q = new ObservableBoolean(false);
    this.R = new ObservableBoolean(false);
    this.S = new ObservableBoolean(false);
    this.T = new ObservableBoolean(false);
    this.U = new ObservableBoolean(false);
    this.V = new ObservableBoolean(false);
    this.W = new ObservableBoolean(false);
    this.X = new ObservableBoolean(false);
    this.Y = new ObservableBoolean(false);
    this.Z = new ObservableBoolean(false);
    this.a0 = new ObservableBoolean(false);
    this.b0 = new ObservableBoolean(false);
    this.c0 = new ObservableBoolean(false);
    this.e0 = new ObservableBoolean(false);
    this.w0 = true;
    this.x0 = true;
    this.z0 = 0L;
    paramTPCameraDeviceContext = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.g0 = paramTPCameraDeviceContext;
    this.y0 = j(paramTPCameraDeviceContext);
    paramTPCameraDeviceContext = (ALCameraDevice)TPIoTClientManager.K1(this.g0).getCameraDevice();
    this.h0 = paramTPCameraDeviceContext;
    if ((paramTPCameraDeviceContext != null) && (paramTPCameraDeviceContext.getCloudIoTDevice() == null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.i0 = bool2;
    Object localObject = this.c;
    paramTPCameraDeviceContext = this.h0;
    if ((paramTPCameraDeviceContext != null) && (paramTPCameraDeviceContext.isSupportIoTCloud())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((ObservableBoolean)localObject).set(bool2);
    paramTPCameraDeviceContext = this.b;
    localObject = this.h0;
    if ((localObject != null) && (((ALCameraDevice)localObject).isFirmwareSupportIoTCloud())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramTPCameraDeviceContext.set(bool2);
    this.j0 = ((CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, CameraSettingRepository.class));
    this.k0 = ((FirmwareRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, FirmwareRepository.class));
    this.l0 = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, CommonCameraRepository.class));
    this.n0 = ((LineCrossingDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, LineCrossingDetectionRepository.class));
    this.o0 = ((AreaIntrusionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, AreaIntrusionRepository.class));
    this.p0 = ((TamperDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, TamperDetectionRepository.class));
    this.q0 = ((MotionDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, MotionDetectionRepository.class));
    this.r0 = ((AlarmSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, AlarmSettingRepository.class));
    this.s0 = ((NightVisionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, NightVisionRepository.class));
    this.t0 = ((AIDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.g0, AIDetectionRepository.class));
    paramTPCameraDeviceContext = b.d.s.a.a.f();
    this.f0 = ((TCDeviceRepository)b.d.b.f.b.c(paramTPCameraDeviceContext).a(TCDeviceRepository.class));
    this.v0 = ((TPIoTClientManager)b.d.b.f.b.a(paramTPCameraDeviceContext, TPIoTClientManager.class));
    this.u0 = ((FirmwareManager)b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class));
    this.X.set(d.c(this.g0));
    this.m0 = ((CloudVideoRepository)b.d.b.f.b.c(paramTPCameraDeviceContext).a(CloudVideoRepository.class));
    paramTPCameraDeviceContext = (ALCameraDevice)TPIoTClientManager.K1(this.g0).getCameraDevice();
    boolean bool2 = bool1;
    if (paramTPCameraDeviceContext != null)
    {
      bool2 = bool1;
      if (paramTPCameraDeviceContext.isUserRoleTypeDevice()) {
        bool2 = true;
      }
    }
    paramApplication.set(bool2);
  }
  
  private void W0(boolean paramBoolean)
  {
    g.e(this.g0, paramBoolean);
  }
  
  private void X0(boolean paramBoolean)
  {
    g.g(this.g0, paramBoolean);
  }
  
  private void Y0(boolean paramBoolean)
  {
    g.f(this.g0, paramBoolean);
  }
  
  private void Z0(ALCameraDevice paramALCameraDevice)
  {
    g.t(new String[] { paramALCameraDevice.getDeviceIdMD5() });
  }
  
  private void d1()
  {
    u localu = this.u0.g(this.g0);
    if (localu != null) {
      this.t.set(localu.e());
    }
    this.d0 = this.k0.u().x0(new com.tplink.libtpnetwork.cameranetwork.g4.l(1, 5000)).H0(new g3(this), h9.c);
  }
  
  private void e1(@StringRes int paramInt)
  {
    f1(getApplication().getResources().getString(paramInt));
  }
  
  private void f1(String paramString)
  {
    this.E.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
  }
  
  private void g1()
  {
    c localc = q.W0(3L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).y(new z1(this)).F0();
    this.B.b(localc);
  }
  
  private void h()
  {
    this.v0.e3(this.g0).y();
  }
  
  private String j(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = TPIoTClientManager.K1(paramString);
    if (paramString != null)
    {
      paramString = (ALCameraDevice)paramString.getCameraDevice();
      if ((paramString != null) && (paramString.getDeviceId() != null)) {
        return paramString.getDeviceId();
      }
    }
    return null;
  }
  
  private void k1()
  {
    this.c0.set(true);
    c localc = this.v0.z3(this.g0).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new w2(this), new c3(this));
    this.B.b(localc);
  }
  
  private q<Boolean> m(CameraComponent paramCameraComponent)
  {
    return this.j0.L(paramCameraComponent).E(new b3(this, paramCameraComponent)).g0(t2.c);
  }
  
  private void m1()
  {
    if (this.M.get())
    {
      ObservableBoolean localObservableBoolean = this.l;
      boolean bool;
      if ((this.j0.T()) && (this.u.get())) {
        bool = true;
      } else {
        bool = false;
      }
      localObservableBoolean.set(bool);
    }
  }
  
  private int n(ResolutionType paramResolutionType)
  {
    ResolutionType localResolutionType = ResolutionType.HD_4M;
    int i1 = 2131954419;
    if (paramResolutionType == localResolutionType) {
      i1 = 2131954418;
    } else if (paramResolutionType == ResolutionType.HD_3M) {
      i1 = 2131954417;
    } else if (paramResolutionType == ResolutionType.HD_1080P) {
      i1 = 2131954414;
    } else if ((paramResolutionType != ResolutionType.HD_720P) && (paramResolutionType == ResolutionType.VGA_360P)) {
      i1 = 2131954415;
    }
    return i1;
  }
  
  private void n1(SettingsData paramSettingsData)
  {
    paramSettingsData = paramSettingsData.getResolutionType();
    this.A.set(getApplication().getString(n(paramSettingsData)));
  }
  
  private void p1()
  {
    boolean bool1 = this.j0.R();
    boolean bool2 = this.r0.y();
    String str;
    if ((bool1) && (bool2)) {
      str = getApplication().getString(2131953847);
    } else if ((!bool2) && (bool1)) {
      str = getApplication().getString(2131953815);
    } else {
      str = getApplication().getString(2131953846);
    }
    this.v.set(str);
  }
  
  private void q1(SettingsData paramSettingsData)
  {
    if (this.Q.get())
    {
      this.s0.F(paramSettingsData.getImageFlip());
      if ((paramSettingsData.getImageFlip() != null) && (paramSettingsData.getImageFlip().getNightVisionModeType() != null))
      {
        int i1 = a.a[paramSettingsData.getImageFlip().getNightVisionModeType().ordinal()];
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3) {
              this.w.set(getApplication().getString(2131952042));
            }
          }
          else {
            this.w.set(getApplication().getString(2131952044));
          }
        }
        else {
          this.w.set(getApplication().getString(2131952047));
        }
      }
    }
  }
  
  private void r()
  {
    if (this.L.get())
    {
      SdCardInfoCache localSdCardInfoCache = this.j0.x().getSdCardInfoCache();
      if (localSdCardInfoCache == null) {
        return;
      }
      SdCardStatus localSdCardStatus1 = localSdCardInfoCache.getStatus();
      ObservableBoolean localObservableBoolean = this.y;
      SdCardStatus localSdCardStatus2 = SdCardStatus.OFFLINE;
      boolean bool1 = false;
      if (localSdCardStatus1 != localSdCardStatus2) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObservableBoolean.set(bool2);
      if (localSdCardStatus1 == null) {
        return;
      }
      switch (a.b[localSdCardStatus1.ordinal()])
      {
      default: 
        break;
      case 7: 
        this.x.set(getApplication().getString(2131953877));
        break;
      case 6: 
        this.x.set(getApplication().getString(2131953875));
        break;
      case 5: 
        this.x.set(getApplication().getString(2131952557));
        break;
      case 4: 
        this.x.set(getApplication().getString(2131953845));
        break;
      case 3: 
        this.x.set(getApplication().getString(2131952558));
        break;
      case 1: 
      case 2: 
        this.x.set(getApplication().getString(2131953873));
      }
      localObservableBoolean = this.u;
      boolean bool2 = bool1;
      if (localSdCardStatus1 == SdCardStatus.NORMAL) {
        bool2 = true;
      }
      localObservableBoolean.set(bool2);
      if ((localSdCardStatus1 == SdCardStatus.FULL) && (localSdCardInfoCache.getLoopEnable()))
      {
        this.x.set(getApplication().getString(2131952558));
        this.u.set(true);
      }
    }
  }
  
  private void u(CameraComponent paramCameraComponent)
  {
    paramCameraComponent = q.f1(this.j0.K(paramCameraComponent), m(paramCameraComponent), j2.c).y(new l2(this)).H0(new k2(this), new i2(this));
    this.B.b(paramCameraComponent);
    k();
  }
  
  public void a1()
  {
    if (this.n.get())
    {
      X0(this.j.get());
      c localc = this.j0.z1(this.j.get()).F(new a3(this)).y(new p2(this)).H0(k3.c, new s2(this));
      this.B.b(localc);
    }
  }
  
  public void b1()
  {
    if (this.o.get())
    {
      W0(this.k.get());
      c localc = this.j0.A1(this.k.get()).F(new d3(this)).y(new f2(this)).H0(w1.c, new n2(this));
      this.B.b(localc);
    }
  }
  
  public void c1()
  {
    if (this.p.get())
    {
      c localc = this.j0.w1(this.l.get()).F(new f3(this)).y(new e3(this)).H0(new b2(this), new o2(this));
      this.B.b(localc);
      if (this.l.get()) {
        if ((this.j0.Q()) && (this.j0.S())) {
          this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a("both"));
        } else if (this.j0.Q()) {
          this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a("detect"));
        } else if (this.j0.S()) {
          this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a("record"));
        } else {
          this.G.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a("empty"));
        }
      }
    }
  }
  
  public void f(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).w(localArrayList).l(new e2(this)).h(new g2(this)).i(new y2(this)).j(new h2(this)).y();
    this.B.b(paramString);
  }
  
  public q<Boolean> g()
  {
    return this.j0.w1(false).F(new x1(this)).y(new q2(this)).C(h9.c);
  }
  
  public void h1()
  {
    Object localObject = this.j0;
    if (localObject != null)
    {
      localObject = ((CameraSettingRepository)localObject).u1().F(new h3(this)).H0(new y1(this), new d2(this));
      this.B.b((c)localObject);
    }
    else
    {
      e1(2131952741);
    }
  }
  
  public String i()
  {
    return this.y0;
  }
  
  public void i1()
  {
    if (this.I.get())
    {
      CameraSettingRepository localCameraSettingRepository = this.j0;
      if ((localCameraSettingRepository != null) && (localCameraSettingRepository.x() != null) && (this.j0.x().getCameraInfo() != null))
      {
        this.d.set(this.j0.x().getCameraInfo().getName());
        if (this.S.get()) {
          this.g.set(this.j0.x().getTimezone());
        }
        if (this.L.get()) {
          r();
        }
        int i1;
        if (this.j0.x().isRebootEnable()) {
          i1 = 2131952442;
        } else {
          i1 = 2131952440;
        }
        this.m.set(getApplication().getString(i1));
      }
    }
  }
  
  public void j1()
  {
    ALCameraDevice localALCameraDevice = this.h0;
    if (localALCameraDevice != null) {
      Z0(localALCameraDevice);
    }
    k1();
  }
  
  public void k()
  {
    if (this.h0 != null)
    {
      this.f.set(com.tplink.iot.Utils.z0.l.b(getApplication(), this.h0));
      return;
    }
    String str = getApplication().getString(2131953286);
    this.f.set(str);
  }
  
  public long l()
  {
    return this.z0;
  }
  
  public void l1()
  {
    int i1;
    if (s()) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    Object localObject = this.j0;
    localObject = ((CameraSettingRepository)localObject).v1(((CameraSettingRepository)localObject).I(i1)).F(new v2(this)).y(new z2(this)).H0(x2.c, new m2(this));
    this.B.b((c)localObject);
  }
  
  public void o(Activity paramActivity, String paramString)
  {
    TrialDialogActivity.f1(paramActivity, com.tplink.iot.Utils.v0.e.k(h.j(paramString)));
  }
  
  public void o1(LifecycleOwner paramLifecycleOwner)
  {
    this.C.observe(paramLifecycleOwner, a2.a);
    this.D.observe(paramLifecycleOwner, j3.a);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.B.dispose();
    c localc = this.d0;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void p(Activity paramActivity, String paramString)
  {
    TPIoTClientManager localTPIoTClientManager = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
    TrialDialogActivity.e1(paramActivity, com.tplink.iot.Utils.v0.e.l(h.j(paramString), localTPIoTClientManager.V1(paramString)));
  }
  
  public boolean s()
  {
    return this.j0.R();
  }
  
  public void t()
  {
    c localc = this.l0.K0().H0(new c2(this), h9.c);
    this.B.b(localc);
  }
  
  public void v()
  {
    ALCameraDevice localALCameraDevice = this.h0;
    if (localALCameraDevice != null)
    {
      this.d.set(localALCameraDevice.getDeviceAlias());
      this.e.set(h.l(this.h0.getModel()));
      k();
    }
  }
  
  public void w()
  {
    if (d.c(this.g0))
    {
      c localc = h.i(this.g0, true).E(new u2(this)).C(r2.c).F0();
      this.B.b(localc);
    }
  }
  
  public boolean x()
  {
    CameraSettingRepository localCameraSettingRepository = this.j0;
    boolean bool;
    if ((localCameraSettingRepository != null) && (localCameraSettingRepository.x() != null) && (this.j0.x().getTimezone() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void y()
  {
    if (d.c(this.g0))
    {
      c localc = h.i(this.g0, true).E(new l3(this)).C(i3.c).F0();
      this.B.b(localc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\DeviceSettingNewViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */