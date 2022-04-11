package com.tplink.iot.viewmodel.ipcamera.play;

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
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.f;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import io.reactivex.e0.c;
import io.reactivex.q;

public class ModeDetectionSettingsViewModel
  extends AndroidViewModel
{
  public final ObservableBoolean A = new ObservableBoolean(false);
  public final ObservableField<String> B = new ObservableField();
  public final ObservableField<String> C = new ObservableField();
  public ObservableField<String> D = new ObservableField();
  public ObservableField<String> E = new ObservableField();
  public ObservableField<String> F = new ObservableField();
  public ObservableField<DeviceModel> G = new ObservableField();
  public ObservableField<Drawable> H = new ObservableField();
  public ObservableBoolean I = new ObservableBoolean(false);
  public ObservableBoolean J = new ObservableBoolean(false);
  public ObservableBoolean K = new ObservableBoolean(false);
  public ObservableBoolean L = new ObservableBoolean(false);
  private boolean M = false;
  private boolean N = false;
  private Observable.OnPropertyChangedCallback O = new a();
  private Boolean P;
  private Boolean Q;
  private Boolean R;
  private Boolean S;
  private Boolean T;
  private Boolean U;
  private Boolean V;
  private boolean W = true;
  private CameraSettingRepository X;
  private final String a = ModeDetectionSettingsViewModel.class.getSimpleName();
  public ObservableBoolean b = new ObservableBoolean(false);
  private String c;
  private io.reactivex.e0.b d = new io.reactivex.e0.b();
  private com.tplink.libtpmediaother.database.model.e e;
  private boolean f;
  private boolean g = false;
  private boolean h;
  public boolean i;
  public int j;
  public ObservableBoolean k = new ObservableBoolean(false);
  public ObservableBoolean l = new ObservableBoolean(false);
  public ObservableBoolean m = new ObservableBoolean(false);
  public ObservableBoolean n = new ObservableBoolean(false);
  public ObservableBoolean o = new ObservableBoolean(false);
  public ObservableBoolean p = new ObservableBoolean(false);
  public final ObservableBoolean q = new ObservableBoolean(false);
  public ObservableBoolean r = new ObservableBoolean(false);
  public ObservableBoolean s = new ObservableBoolean(false);
  private Boolean t;
  public final ObservableBoolean u = new ObservableBoolean(false);
  public ObservableBoolean v = new ObservableBoolean(false);
  public final ObservableBoolean w = new ObservableBoolean(false);
  public ObservableField<String> x = new ObservableField();
  public ObservableField<String> y = new ObservableField();
  public final ObservableBoolean z = new ObservableBoolean(false);
  
  public ModeDetectionSettingsViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void A(boolean paramBoolean)
  {
    com.tplink.iot.Utils.x0.d.f(this.c, paramBoolean, true);
  }
  
  private void D()
  {
    boolean bool1 = this.e.n();
    boolean bool2;
    if (this.M) {
      bool2 = this.e.s();
    } else if (this.N) {
      bool2 = this.e.r();
    } else {
      bool2 = false;
    }
    ObservableField localObservableField = this.y;
    Application localApplication;
    int i1;
    if ((!bool1) && (!bool2))
    {
      localApplication = getApplication();
      i1 = 2131953846;
    }
    else
    {
      localApplication = getApplication();
      i1 = 2131953847;
    }
    localObservableField.set(localApplication.getString(i1));
  }
  
  private void E()
  {
    c localc = h.o(this.c, false, null).F0();
    this.d.b(localc);
  }
  
  private void g()
  {
    this.w.addOnPropertyChangedCallback(this.O);
  }
  
  private void h()
  {
    Object localObject = (ALCameraDevice)TPIoTClientManager.K1(this.c).getCameraDevice();
    if (localObject != null) {
      localObject = ((ALCameraDevice)localObject).getCameraAvatarInfo();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!TextUtils.isEmpty(((CameraAvatarInfo)localObject).getAvatarName()))) {
      localObject = z4.c(getApplication(), ((CameraAvatarInfo)localObject).getAvatarName(), ((CameraAvatarInfo)localObject).getAvatarDefault().booleanValue());
    } else {
      localObject = getApplication().getString(2131953286);
    }
    this.C.set(localObject);
  }
  
  private void j(CameraComponent paramCameraComponent)
  {
    this.s.set(paramCameraComponent.hasComponent(ComponentType.TARGET_TRACK));
    this.v.set(paramCameraComponent.isSupportMsgPush());
    this.m.set(paramCameraComponent.isSupportPersonEnhanced());
    this.l.set(paramCameraComponent.hasComponent(ComponentType.BABY_CRYING_DETECTION));
    ObservableBoolean localObservableBoolean = this.k;
    ComponentType localComponentType = ComponentType.PERSON_DETECTION;
    localObservableBoolean.set(paramCameraComponent.hasComponent(localComponentType));
    this.n.set(paramCameraComponent.isSupportTamperDetection());
    this.o.set(paramCameraComponent.isSupportIntrusionDetection());
    this.p.set(paramCameraComponent.isSupportLineCrossingDetection());
    this.M = paramCameraComponent.hasComponent(localComponentType);
    this.N = paramCameraComponent.isSupportPersonEnhanced();
  }
  
  private void l()
  {
    c localc = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.c, CommonCameraRepository.class)).K0().H0(new b0(this), new f0(this));
    this.d.b(localc);
  }
  
  private void z()
  {
    this.X.H().F0();
  }
  
  public void B()
  {
    if (this.v.get()) {
      l.s(this.c, this.f, e0.a);
    } else if (this.z.get()) {
      l.s(this.c, this.f, new g0(this));
    }
  }
  
  public void C()
  {
    l.s(this.c, this.f, new c0(this));
  }
  
  public void i()
  {
    if (h.n(this.c) == null) {
      h.m(this.c);
    }
  }
  
  public void k(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    this.f = paramBoolean;
    this.I.set(com.tplink.iot.Utils.v0.d.c(paramString));
    ObservableBoolean localObservableBoolean = this.J;
    if ((!h.b(ComponentType.DETECTION, paramString)) && (!h.b(ComponentType.PERSON_DETECTION, paramString))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    localObservableBoolean.set(paramBoolean);
    this.K.set(h.b(ComponentType.BABY_CRYING_DETECTION, paramString));
    this.L.set(h.b(ComponentType.TARGET_TRACK, paramString));
    this.z.set(f.h(paramString));
    this.X = ((CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, CameraSettingRepository.class));
    l();
    h();
    z();
    E();
    g();
  }
  
  public boolean m()
  {
    Boolean localBoolean = this.P;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localBoolean != null)
    {
      bool2 = bool1;
      if (this.z.get())
      {
        bool2 = bool1;
        if (this.e != null)
        {
          if (this.v.get())
          {
            bool2 = this.e.B();
          }
          else
          {
            this.V = Boolean.valueOf(this.g);
            bool2 = this.w.get();
          }
          if (bool2) {
            return false;
          }
          boolean bool3 = this.e.p();
          boolean bool4 = this.e.l();
          boolean bool5 = this.e.v();
          boolean bool6 = this.e.K();
          boolean bool7 = this.e.s();
          boolean bool8 = this.e.n();
          int i1;
          if ((org.apache.commons.lang.b.b(this.P) == bool3) && ((!this.o.get()) || (org.apache.commons.lang.b.b(this.Q) == bool4)) && ((!this.p.get()) || (org.apache.commons.lang.b.b(this.R) == bool5)) && ((!this.n.get()) || (org.apache.commons.lang.b.b(this.S) == bool6)) && (((!this.M) && (!this.N)) || ((this.T.booleanValue() == bool7) && ((!this.l.get()) || (org.apache.commons.lang.b.b(this.U) == bool8)) && (org.apache.commons.lang.b.b(this.V) == bool2)))) {
            i1 = 0;
          } else {
            i1 = 1;
          }
          int i2;
          if ((!bool3) && ((!this.o.get()) || (!bool4)) && ((!this.p.get()) || (!bool5)) && ((!this.n.get()) || (!bool6)) && (((!this.M) && (!this.N)) || ((!bool7) && ((!this.l.get()) || (!bool8))))) {
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
    }
    return bool2;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.d.dispose();
  }
  
  public void y()
  {
    l.g(this.c, this.f, new d0(this));
  }
  
  class a
    extends Observable.OnPropertyChangedCallback
  {
    a() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      paramObservable = ModeDetectionSettingsViewModel.this;
      ModeDetectionSettingsViewModel.f(paramObservable, paramObservable.w.get());
      ModeDetectionSettingsViewModel.this.C();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\ModeDetectionSettingsViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */