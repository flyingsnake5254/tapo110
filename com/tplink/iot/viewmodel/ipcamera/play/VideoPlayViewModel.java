package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.view.ipcamera.base.f;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.NightVisionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.Stack;

public class VideoPlayViewModel
  extends AndroidViewModel
{
  private CommonCameraRepository A;
  private NightVisionRepository B;
  @Deprecated
  public final ObservableBoolean C = new ObservableBoolean(false);
  public final ObservableBoolean D = new ObservableBoolean(false);
  public final ObservableBoolean E = new ObservableBoolean(false);
  public final ObservableField<VideoDisplayMode> F = new ObservableField(VideoDisplayMode.LIVE_STREAM);
  public final ObservableBoolean G = new ObservableBoolean(false);
  public final ObservableBoolean H = new ObservableBoolean(true);
  public final ObservableBoolean I = new ObservableBoolean(true);
  public final ObservableBoolean J = new ObservableBoolean(true);
  public final ObservableBoolean K = new ObservableBoolean(true);
  public final ObservableBoolean L = new ObservableBoolean(true);
  public final ObservableBoolean M = new ObservableBoolean(true);
  public final ObservableBoolean N = new ObservableBoolean(true);
  public final ObservableBoolean O = new ObservableBoolean(false);
  private io.reactivex.e0.b a = new io.reactivex.e0.b();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> b = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> c = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> d = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> e = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<CharSequence>> f = new MutableLiveData();
  public final ObservableBoolean g = new ObservableBoolean(false);
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<CharSequence>> h = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> i = new MutableLiveData();
  @Nullable
  public String j;
  public final MutableLiveData<String> k = new MutableLiveData();
  public final ObservableBoolean l = new ObservableBoolean(true);
  public final MutableLiveData<Boolean> m = new MutableLiveData();
  public final MutableLiveData<SdCardStatus> n = new MutableLiveData();
  private Stack<f> o = new Stack();
  @Nullable
  public String p;
  public ObservableBoolean q = new ObservableBoolean(false);
  public ObservableBoolean r = new ObservableBoolean(false);
  public ObservableBoolean s = new ObservableBoolean(false);
  @Nullable
  private FirmwareRepository t;
  public ObservableBoolean u = new ObservableBoolean(false);
  private FirmwareManager v = (FirmwareManager)b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class);
  private TPIoTClientManager w = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
  private c x;
  @Nullable
  private MotionDetectionRepository y;
  private CameraSettingRepository z;
  
  public VideoPlayViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private boolean p()
  {
    Object localObject = (com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a)this.h.getValue();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (CharSequence)((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a)localObject).c();
    }
    return localObject instanceof SpannableString;
  }
  
  public void A(boolean paramBoolean)
  {
    if (this.G.get() != paramBoolean)
    {
      this.G.set(paramBoolean);
      this.c.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.valueOf(paramBoolean)));
    }
  }
  
  public void B(String paramString)
  {
    this.d.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
  }
  
  public void C(LifecycleOwner paramLifecycleOwner)
  {
    this.k.observe(paramLifecycleOwner, new o2(this));
  }
  
  public void g()
  {
    Object localObject = this.j;
    boolean bool1 = false;
    if ((localObject != null) && (!this.G.get()))
    {
      localObject = (ALCameraDevice)TPIoTClientManager.K1(this.j).getCameraDevice();
      ObservableBoolean localObservableBoolean = this.g;
      boolean bool2 = bool1;
      if (localObject != null)
      {
        bool2 = bool1;
        if (((ALCameraDevice)localObject).isLocalOnly()) {
          bool2 = true;
        }
      }
      localObservableBoolean.set(bool2);
      return;
    }
    this.g.set(false);
  }
  
  public void h()
  {
    if (p()) {
      this.h.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(""));
    }
  }
  
  public q<Boolean> i()
  {
    MotionDetectionRepository localMotionDetectionRepository = this.y;
    if (localMotionDetectionRepository != null) {
      return localMotionDetectionRepository.v(true);
    }
    return q.f0(Boolean.FALSE);
  }
  
  public q<Boolean> j()
  {
    CameraSettingRepository localCameraSettingRepository = this.z;
    if ((localCameraSettingRepository != null) && (this.A != null) && (this.j != null))
    {
      if (localCameraSettingRepository.R()) {
        return q.f0(Boolean.TRUE);
      }
      return this.A.K0().N(new a());
    }
    return q.f0(Boolean.FALSE);
  }
  
  public DeviceModel k()
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)TPIoTClientManager.I1(this.j);
    if (localALCameraDevice != null) {
      return DeviceModel.fromValue(localALCameraDevice.getDeviceModel());
    }
    return null;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> l()
  {
    return this.b;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> m()
  {
    return this.c;
  }
  
  public Stack<f> n()
  {
    return this.o;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> o()
  {
    return this.d;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.a.dispose();
    c localc = this.x;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public boolean r()
  {
    boolean bool;
    if ((b.d.w.f.b.j(getApplication())) && (b.d.w.f.b.i(getApplication()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void u(String paramString)
  {
    this.d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
  }
  
  public void v()
  {
    c localc = this.x;
    if (localc != null) {
      localc.dispose();
    }
    this.x = this.w.k3(r()).F0();
  }
  
  public void w()
  {
    Object localObject = this.j;
    if ((localObject != null) && (this.t != null))
    {
      localObject = this.v.g((String)localObject);
      if (localObject != null) {
        this.u.set(((u)localObject).e());
      }
      return;
    }
    this.u.set(false);
  }
  
  public void x()
  {
    this.w.A3();
  }
  
  public void y(String paramString)
  {
    this.b.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
  }
  
  public void z(boolean paramBoolean)
  {
    if (this.G.get() != paramBoolean) {
      this.G.set(paramBoolean);
    }
  }
  
  class a
    implements j<CameraComponent, t<Boolean>>
  {
    a() {}
    
    public t<Boolean> a(@NonNull CameraComponent paramCameraComponent)
      throws Exception
    {
      return VideoPlayViewModel.f(VideoPlayViewModel.this).L(paramCameraComponent).g0(new a());
    }
    
    class a
      implements j<SettingCompositeV2, Boolean>
    {
      a() {}
      
      public Boolean a(@NonNull SettingCompositeV2 paramSettingCompositeV2)
        throws Exception
      {
        return Boolean.valueOf(VideoPlayViewModel.f(VideoPlayViewModel.this).R());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\VideoPlayViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */