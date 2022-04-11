package com.tplink.iot.viewmodel.ipcamera.setting.detection;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.model.p;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AIDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.DetectionSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LineCrossingDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MsgPushRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TamperDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TargetTrackRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionSetting;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.q;

public class DetectionSettingsViewModel
  extends AndroidViewModel
{
  private static final String a = "DetectionSettingsViewModel";
  public MutableLiveData<Boolean> A;
  public ObservableBoolean B;
  public ObservableBoolean C;
  public MutableLiveData<Boolean> D;
  protected io.reactivex.e0.b E;
  protected MotionDetectionRepository F;
  private MotionDetectionRepository G;
  private AIDetectionRepository H;
  private AlarmSettingRepository I;
  private CameraSettingRepository J;
  protected CommonCameraRepository K;
  private TargetTrackRepository L;
  private TamperDetectionRepository M;
  private AreaIntrusionRepository N;
  private LineCrossingDetectionRepository O;
  private MsgPushRepository P;
  private DetectionSettingRepository Q;
  public ObservableField<DeviceModel> R;
  public ObservableField<Drawable> S;
  private String T;
  private boolean U;
  private boolean V;
  private Observable.OnPropertyChangedCallback W;
  private Boolean X;
  private Boolean Y;
  private Boolean Z;
  private Boolean a0;
  public ObservableBoolean b;
  private Boolean b0;
  public ObservableBoolean c;
  private Boolean c0;
  public ObservableBoolean d;
  private Boolean d0;
  public ObservableBoolean e;
  private Boolean e0;
  public ObservableBoolean f;
  private boolean f0;
  public ObservableBoolean g;
  public ObservableBoolean h;
  public ObservableBoolean i;
  public ObservableBoolean j;
  public ObservableBoolean k;
  public ObservableBoolean l;
  public ObservableBoolean m;
  public ObservableBoolean n;
  public ObservableBoolean o;
  public ObservableBoolean p;
  public ObservableBoolean q;
  public ObservableField<String> r;
  public ObservableField<String> s;
  public ObservableField<String> t;
  public ObservableField<String> u;
  public ObservableField<String> v;
  public ObservableField<String> w;
  public ObservableField<String> x;
  public String y;
  public MutableLiveData<String> z;
  
  public DetectionSettingsViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    boolean bool = false;
    this.b = new ObservableBoolean(false);
    this.c = new ObservableBoolean(false);
    this.d = new ObservableBoolean(false);
    this.e = new ObservableBoolean(false);
    this.f = new ObservableBoolean(false);
    this.g = new ObservableBoolean(false);
    this.h = new ObservableBoolean(false);
    this.i = new ObservableBoolean(false);
    this.j = new ObservableBoolean(false);
    this.k = new ObservableBoolean(false);
    this.l = new ObservableBoolean(false);
    this.m = new ObservableBoolean(false);
    this.n = new ObservableBoolean(false);
    this.o = new ObservableBoolean(false);
    this.p = new ObservableBoolean(false);
    this.q = new ObservableBoolean(false);
    this.r = new ObservableField();
    this.s = new ObservableField();
    this.t = new ObservableField();
    this.u = new ObservableField();
    this.v = new ObservableField();
    this.w = new ObservableField();
    this.x = new ObservableField();
    this.z = new MutableLiveData();
    this.A = new MutableLiveData();
    this.B = new ObservableBoolean(false);
    this.C = new ObservableBoolean(false);
    this.D = new MutableLiveData();
    this.E = new io.reactivex.e0.b();
    this.R = new ObservableField();
    this.S = new ObservableField();
    this.T = "";
    this.U = false;
    this.V = false;
    this.W = new a();
    this.f0 = false;
    this.y = paramTPCameraDeviceContext.getDeviceIdMD5();
    ObservableField localObservableField = this.R;
    if (paramTPCameraDeviceContext.getCameraDevice() == null) {
      paramApplication = DeviceModel.CAMERA_C200;
    } else {
      paramApplication = DeviceModel.fromValue(((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice()).getModel());
    }
    localObservableField.set(paramApplication);
    this.Q = ((DetectionSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, DetectionSettingRepository.class));
    this.F = ((MotionDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, MotionDetectionRepository.class));
    this.G = ((MotionDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, MotionDetectionRepository.class));
    this.I = ((AlarmSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, AlarmSettingRepository.class));
    this.J = ((CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, CameraSettingRepository.class));
    this.K = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, CommonCameraRepository.class));
    this.L = ((TargetTrackRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, TargetTrackRepository.class));
    this.B.set(com.tplink.iot.Utils.v0.d.c(this.y));
    paramApplication = this.j;
    if ((com.tplink.iot.Utils.z0.h.b(ComponentType.DETECTION, this.y)) || (com.tplink.iot.Utils.z0.h.b(ComponentType.PERSON_DETECTION, this.y))) {
      bool = true;
    }
    paramApplication.set(bool);
    this.k.set(com.tplink.iot.Utils.z0.h.b(ComponentType.BABY_CRYING_DETECTION, this.y));
    this.C.set(com.tplink.iot.Utils.z0.h.b(ComponentType.TARGET_TRACK, this.y));
    this.M = ((TamperDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, TamperDetectionRepository.class));
    this.N = ((AreaIntrusionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, AreaIntrusionRepository.class));
    this.O = ((LineCrossingDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, LineCrossingDetectionRepository.class));
    this.P = ((MsgPushRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, MsgPushRepository.class));
    this.H = ((AIDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.y, AIDetectionRepository.class));
    s();
  }
  
  private void U(boolean paramBoolean)
  {
    com.tplink.iot.Utils.x0.d.f(this.y, paramBoolean, false);
  }
  
  private void Y()
  {
    Boolean localBoolean = (Boolean)this.H.t().getValue();
    Object localObject = Boolean.FALSE;
    if (this.U) {
      localObject = (Boolean)this.H.v().getValue();
    } else if (this.V) {
      localObject = this.G.y().b();
    }
    ObservableField localObservableField = this.s;
    int i1;
    if ((!org.apache.commons.lang.b.b(localBoolean)) && (!org.apache.commons.lang.b.b((Boolean)localObject)))
    {
      localObject = getApplication();
      i1 = 2131953846;
    }
    else
    {
      localObject = getApplication();
      i1 = 2131953847;
    }
    localObservableField.set(((Application)localObject).getString(i1));
  }
  
  private void p()
  {
    this.o.addOnPropertyChangedCallback(this.W);
  }
  
  private void t(final CameraComponent paramCameraComponent)
  {
    this.m.set(paramCameraComponent.hasComponent(ComponentType.TARGET_TRACK));
    this.h.set(paramCameraComponent.hasComponent(ComponentType.BABY_CRYING_DETECTION));
    ObservableBoolean localObservableBoolean = this.g;
    ComponentType localComponentType = ComponentType.PERSON_DETECTION;
    boolean bool;
    if ((!paramCameraComponent.hasComponent(localComponentType)) && (!paramCameraComponent.isSupportPersonEnhanced())) {
      bool = false;
    } else {
      bool = true;
    }
    localObservableBoolean.set(bool);
    this.i.set(paramCameraComponent.isSupportPersonEnhanced());
    this.U = paramCameraComponent.hasComponent(localComponentType);
    this.V = paramCameraComponent.isSupportPersonEnhanced();
    this.n.set(paramCameraComponent.isSupportMsgPush());
    this.c.set(paramCameraComponent.isSupportTamperDetection());
    this.d.set(paramCameraComponent.isSupportIntrusionDetection());
    this.e.set(paramCameraComponent.isSupportLineCrossingDetection());
    paramCameraComponent = this.Q.L1(paramCameraComponent).F(new h(this)).y(new j(this)).H0(new b(paramCameraComponent), new g(this));
    this.E.b(paramCameraComponent);
    p();
    r();
  }
  
  private void v()
  {
    boolean bool;
    if (this.n.get()) {
      bool = this.P.v().c();
    } else {
      bool = this.f0;
    }
    this.b0 = Boolean.valueOf(bool);
    this.X = Boolean.valueOf(this.G.y().e());
    this.Y = Boolean.valueOf(this.N.z().c());
    this.Z = Boolean.valueOf(this.O.A().c());
    this.a0 = Boolean.valueOf(this.M.t().c());
    this.c0 = this.G.y().b();
    this.d0 = Boolean.valueOf(com.tplink.libtpnetwork.Utils.j.h(this.H.v()));
    this.e0 = Boolean.valueOf(com.tplink.libtpnetwork.Utils.j.h(this.H.t()));
  }
  
  public void T()
  {
    this.q.set(this.F.A());
    this.p.set(this.F.z());
    boolean bool = this.F.B();
    this.f0 = bool;
    this.o.set(bool);
    io.reactivex.e0.c localc = this.K.K0().H0(new b(this), a.c);
    this.E.b(localc);
  }
  
  public void V()
  {
    if (this.n.get())
    {
      Object localObject = this.P;
      localObject = ((MsgPushRepository)localObject).D(true, ((MsgPushRepository)localObject).v().d()).F(new c(this)).y(new i(this)).H0(new k(this), new e(this));
      this.E.b((io.reactivex.e0.c)localObject);
    }
    else if (this.p.get())
    {
      this.o.set(true);
      this.A.postValue(Boolean.TRUE);
    }
    else
    {
      this.A.postValue(Boolean.TRUE);
    }
  }
  
  public void W()
  {
    io.reactivex.e0.c localc = this.F.c0(this.o.get()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).F0();
    this.E.b(localc);
  }
  
  public void X(LifecycleOwner paramLifecycleOwner)
  {
    this.L.d.observe(paramLifecycleOwner, new f(this));
  }
  
  public void Z()
  {
    ObservableField localObservableField = this.r;
    String str;
    if (this.G.y().e()) {
      str = getApplication().getString(2131953847);
    } else {
      str = getApplication().getString(2131953846);
    }
    localObservableField.set(str);
    localObservableField = this.t;
    if (this.I.y()) {
      str = getApplication().getString(2131953847);
    } else {
      str = getApplication().getString(2131953846);
    }
    localObservableField.set(str);
    Y();
    if (this.c.get())
    {
      localObservableField = this.v;
      if (this.M.t().c()) {
        str = getApplication().getString(2131953847);
      } else {
        str = getApplication().getString(2131953846);
      }
      localObservableField.set(str);
    }
    if (this.e.get())
    {
      localObservableField = this.x;
      if (this.O.A().c()) {
        str = getApplication().getString(2131953847);
      } else {
        str = getApplication().getString(2131953846);
      }
      localObservableField.set(str);
    }
    if (this.d.get())
    {
      localObservableField = this.w;
      if (this.N.z().c()) {
        str = getApplication().getString(2131953847);
      } else {
        str = getApplication().getString(2131953846);
      }
      localObservableField.set(str);
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.E.dispose();
  }
  
  public void r()
  {
    Object localObject = this.J.x();
    if (localObject != null)
    {
      localObject = ((SettingsData)localObject).getCameraInfo();
      if (localObject != null)
      {
        this.T = ((CameraInfoCache)localObject).getName();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("localName");
        ((StringBuilder)localObject).append(this.T);
        b.d.w.c.a.e("DetectionViewModel", ((StringBuilder)localObject).toString());
        return;
      }
    }
    localObject = this.K.K0().g0(new l(this)).G0(new d(this));
    this.E.b((io.reactivex.e0.c)localObject);
  }
  
  public void s()
  {
    Object localObject = (ALCameraDevice)TPIoTClientManager.K1(this.y).getCameraDevice();
    if (localObject != null) {
      localObject = ((ALCameraDevice)localObject).getCameraAvatarInfo();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!TextUtils.isEmpty(((CameraAvatarInfo)localObject).getAvatarName())))
    {
      this.u.set(z4.c(getApplication(), ((CameraAvatarInfo)localObject).getAvatarName(), ((CameraAvatarInfo)localObject).getAvatarDefault().booleanValue()));
    }
    else
    {
      localObject = getApplication().getString(2131953286);
      this.u.set(localObject);
    }
  }
  
  protected void u()
  {
    Object localObject = this.G.y();
    if (localObject != null)
    {
      this.f.set(((com.tplink.libtpnetwork.cameranetwork.business.model.g)localObject).e());
      ObservableField localObservableField = this.r;
      if (((com.tplink.libtpnetwork.cameranetwork.business.model.g)localObject).e()) {
        localObject = getApplication().getString(2131953847);
      } else {
        localObject = getApplication().getString(2131953846);
      }
      localObservableField.set(localObject);
      localObservableField = this.t;
      if (this.I.y()) {
        localObject = getApplication().getString(2131953847);
      } else {
        localObject = getApplication().getString(2131953846);
      }
      localObservableField.set(localObject);
    }
  }
  
  public boolean w()
  {
    Boolean localBoolean = this.X;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localBoolean != null)
    {
      bool2 = bool1;
      if (this.p.get())
      {
        if (this.n.get()) {
          bool2 = this.P.v().c();
        } else {
          bool2 = this.o.get();
        }
        if (bool2) {
          return false;
        }
        boolean bool3 = this.G.y().e();
        boolean bool4 = this.N.z().c();
        boolean bool5 = this.O.A().c();
        boolean bool6 = this.M.t().c();
        boolean bool7 = org.apache.commons.lang.b.b(this.G.y().b());
        boolean bool8 = com.tplink.libtpnetwork.Utils.j.h(this.H.v());
        boolean bool9 = com.tplink.libtpnetwork.Utils.j.h(this.H.t());
        int i1;
        if ((org.apache.commons.lang.b.b(this.X) == bool3) && (org.apache.commons.lang.b.b(this.Y) == bool4) && (org.apache.commons.lang.b.b(this.Z) == bool5) && (org.apache.commons.lang.b.b(this.a0) == bool6) && (org.apache.commons.lang.b.b(this.c0) == bool7) && (org.apache.commons.lang.b.b(this.d0) == bool8) && (org.apache.commons.lang.b.b(this.e0) == bool9) && (org.apache.commons.lang.b.b(this.b0) == bool2)) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        int i2;
        if ((!bool3) && (!bool4) && (!bool5) && (!bool6) && (!bool7) && (!bool8) && (!bool9)) {
          i2 = 0;
        } else {
          i2 = 1;
        }
        bool2 = bool1;
        if (i1 != 0)
        {
          bool2 = bool1;
          if (i2 != 0) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  class a
    extends Observable.OnPropertyChangedCallback
  {
    a() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      paramObservable = DetectionSettingsViewModel.this;
      DetectionSettingsViewModel.f(paramObservable, paramObservable.o.get());
      DetectionSettingsViewModel.this.W();
    }
  }
  
  class b
    implements io.reactivex.g0.g<DetectionSetting>
  {
    b(CameraComponent paramCameraComponent) {}
    
    public void a(DetectionSetting paramDetectionSetting)
      throws Exception
    {
      if (paramDetectionSetting.getAlarmInfo() != null) {
        DetectionSettingsViewModel.g(DetectionSettingsViewModel.this).Q(paramDetectionSetting.getAlarmInfo());
      }
      if ((paramCameraComponent.isSupportMsgPush()) && (paramDetectionSetting.getMsgPushInfo() != null)) {
        DetectionSettingsViewModel.h(DetectionSettingsViewModel.this).F(paramDetectionSetting.getMsgPushInfo());
      }
      if ((paramCameraComponent.isSupportPersonDetection()) && (paramDetectionSetting.getHumanRecognitionInfo() != null)) {
        DetectionSettingsViewModel.i(DetectionSettingsViewModel.this).A(paramDetectionSetting.getHumanRecognitionInfo());
      }
      if ((paramCameraComponent.isSupportBabyCry()) && (paramDetectionSetting.getBabyCryDetectionInfo() != null)) {
        DetectionSettingsViewModel.i(DetectionSettingsViewModel.this).z(paramDetectionSetting.getBabyCryDetectionInfo());
      }
      if ((DetectionSettingsViewModel.this.m.get()) && (paramDetectionSetting.getTargetTrackInfo() != null)) {
        DetectionSettingsViewModel.j(DetectionSettingsViewModel.this).C(paramDetectionSetting.getTargetTrackInfo());
      }
      DetectionSettingsViewModel.this.u();
      paramDetectionSetting = DetectionSettingsViewModel.k(DetectionSettingsViewModel.this).t();
      Object localObject = DetectionSettingsViewModel.this.v;
      if (paramDetectionSetting.c()) {
        paramDetectionSetting = DetectionSettingsViewModel.this.getApplication().getString(2131953847);
      } else {
        paramDetectionSetting = DetectionSettingsViewModel.this.getApplication().getString(2131953846);
      }
      ((ObservableField)localObject).set(paramDetectionSetting);
      paramDetectionSetting = DetectionSettingsViewModel.l(DetectionSettingsViewModel.this).z();
      localObject = DetectionSettingsViewModel.this.w;
      if (paramDetectionSetting.c()) {
        paramDetectionSetting = DetectionSettingsViewModel.this.getApplication().getString(2131953847);
      } else {
        paramDetectionSetting = DetectionSettingsViewModel.this.getApplication().getString(2131953846);
      }
      ((ObservableField)localObject).set(paramDetectionSetting);
      paramDetectionSetting = DetectionSettingsViewModel.m(DetectionSettingsViewModel.this).A();
      localObject = DetectionSettingsViewModel.this.x;
      if (paramDetectionSetting.c()) {
        paramDetectionSetting = DetectionSettingsViewModel.this.getApplication().getString(2131953847);
      } else {
        paramDetectionSetting = DetectionSettingsViewModel.this.getApplication().getString(2131953846);
      }
      ((ObservableField)localObject).set(paramDetectionSetting);
      DetectionSettingsViewModel.n(DetectionSettingsViewModel.this);
      DetectionSettingsViewModel.o(DetectionSettingsViewModel.this);
      paramDetectionSetting = DetectionSettingsViewModel.this;
      localObject = paramDetectionSetting.D;
      boolean bool;
      if ((!paramDetectionSetting.n.get()) && (DetectionSettingsViewModel.this.o.get())) {
        bool = true;
      } else {
        bool = false;
      }
      ((MutableLiveData)localObject).postValue(Boolean.valueOf(bool));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\detection\DetectionSettingsViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */