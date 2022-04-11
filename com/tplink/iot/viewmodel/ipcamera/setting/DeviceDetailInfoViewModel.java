package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import b.d.s.a.a;
import com.tplink.iot.Utils.z0.h;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.cameranetwork.g4.l;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.c;
import io.reactivex.q;

public class DeviceDetailInfoViewModel
  extends AndroidViewModel
{
  private FirmwareManager A;
  @Nullable
  private ALCameraDevice B;
  public ObservableField<String> a = new ObservableField("");
  public ObservableBoolean b;
  public ObservableField<Drawable> c;
  public ObservableField<String> d;
  public ObservableBoolean e;
  private String f;
  public ObservableField<String> g;
  public ObservableField<String> h;
  public ObservableField<String> i;
  public ObservableField<String> j;
  public ObservableField<String> k;
  public ObservableField<String> l;
  public ObservableBoolean m;
  public String n;
  public ObservableBoolean o;
  public ObservableBoolean p;
  public ObservableBoolean q;
  public ObservableBoolean r;
  public final ObservableBoolean s;
  public ObservableBoolean t;
  public ObservableBoolean u;
  private io.reactivex.e0.b v;
  private c w;
  private CameraSettingRepository x;
  private FirmwareRepository y;
  private CommonCameraRepository z;
  
  public DeviceDetailInfoViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    boolean bool1 = false;
    this.b = new ObservableBoolean(false);
    this.c = new ObservableField();
    this.d = new ObservableField();
    this.e = new ObservableBoolean(true);
    this.g = new ObservableField();
    this.h = new ObservableField();
    this.i = new ObservableField();
    this.j = new ObservableField();
    this.k = new ObservableField();
    this.l = new ObservableField();
    this.m = new ObservableBoolean();
    this.n = "";
    this.o = new ObservableBoolean();
    this.p = new ObservableBoolean(false);
    this.q = new ObservableBoolean(false);
    this.r = new ObservableBoolean(false);
    paramApplication = new ObservableBoolean(false);
    this.s = paramApplication;
    this.t = new ObservableBoolean(false);
    this.u = new ObservableBoolean(false);
    this.v = new io.reactivex.e0.b();
    this.f = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.B = ((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice());
    ObservableBoolean localObservableBoolean = this.p;
    if ((paramTPCameraDeviceContext.getCameraDevice() != null) && (((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice()).isFirmwareSupportIoTCloud())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localObservableBoolean.set(bool2);
    this.x = ((CameraSettingRepository)e.c(this.f, CameraSettingRepository.class));
    this.y = ((FirmwareRepository)e.c(this.f, FirmwareRepository.class));
    this.z = ((CommonCameraRepository)e.c(this.f, CommonCameraRepository.class));
    this.A = ((FirmwareManager)b.d.b.f.b.a(a.f(), FirmwareManager.class));
    paramTPCameraDeviceContext = (ALCameraDevice)TPIoTClientManager.K1(this.f).getCameraDevice();
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
  
  private void I()
  {
    u localu = this.A.g(this.f);
    if (localu != null) {
      this.b.set(localu.e());
    }
    this.w = this.y.v().x0(new l(1, 5000)).H0(new r1(this), h9.c);
  }
  
  private q<Boolean> g()
  {
    if (this.q.get()) {
      return this.y.t().g0(n1.c);
    }
    return q.f0(Boolean.TRUE);
  }
  
  private void k()
  {
    Object localObject = this.A.g(this.f);
    if (localObject != null) {
      this.b.set(((u)localObject).e());
    }
    this.u.set(false);
    q.e1(this.x.B(), this.x.z(), g(), o1.a).F(new q1(this)).y(new u1(this)).C(new m1(this)).E(new s1(this)).F0();
    localObject = this.x.x().getCameraInfo();
    if (localObject == null)
    {
      localObject = this.z.K0().N(new t1(this)).F0();
      this.v.b((c)localObject);
    }
    else
    {
      this.a.set(((CameraInfoCache)localObject).getName());
      this.g.set(h.l(((CameraInfoCache)localObject).getModel()));
      this.j.set(((CameraInfoCache)localObject).getMac());
      this.k.set(((CameraInfoCache)localObject).getHardwareVer());
      if (((CameraInfoCache)localObject).getSoftwareVer() != null)
      {
        this.n = ((CameraInfoCache)localObject).getSoftwareVer();
        this.l.set(localObject.getSoftwareVer().split(" ")[0]);
      }
    }
    if (this.r.get()) {
      I();
    }
  }
  
  private Drawable l(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i1 = Integer.parseInt(paramString);
    if (i1 != 1)
    {
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 != 4) {
          return null;
        }
        return getApplication().getResources().getDrawable(2131690454);
      }
      return getApplication().getResources().getDrawable(2131690453);
    }
    return getApplication().getResources().getDrawable(2131690452);
  }
  
  private String m(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("(RSSI)");
    return localStringBuilder.toString();
  }
  
  private void n()
  {
    ALCameraDevice localALCameraDevice = this.B;
    if (localALCameraDevice == null) {
      return;
    }
    this.a.set(localALCameraDevice.getDeviceAlias());
    this.g.set(h.l(this.B.getModel()));
    this.j.set(this.B.getMacAddress());
    this.l.set(this.B.getSoftwareVersion().split(" ")[0]);
    this.k.set(this.B.getHardwareVersion());
  }
  
  private boolean o(String paramString)
  {
    return "wifi".equals(paramString);
  }
  
  public void f()
  {
    if ((this.e.get()) && (!TextUtils.isEmpty((CharSequence)this.d.get()))) {
      this.e.set(false);
    } else {
      this.e.set(true);
    }
  }
  
  public ALCameraDevice h()
  {
    return this.B;
  }
  
  public void i()
  {
    this.v.b(this.z.K0().G0(new p1(this)));
  }
  
  public String j()
  {
    return this.f;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    Object localObject = this.w;
    if ((localObject != null) && (!((c)localObject).isDisposed())) {
      this.w.dispose();
    }
    localObject = this.v;
    if ((localObject != null) && (!((io.reactivex.e0.b)localObject).isDisposed())) {
      this.v.dispose();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\DeviceDetailInfoViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */