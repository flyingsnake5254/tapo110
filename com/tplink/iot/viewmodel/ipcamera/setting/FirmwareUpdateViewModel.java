package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import com.tplink.libtpnetwork.cameranetwork.g4.k;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.FirmwareUpgradeStatus;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import io.reactivex.q;

public class FirmwareUpdateViewModel
  extends AndroidViewModel
{
  public ObservableInt a = new ObservableInt(0);
  public ObservableBoolean b = new ObservableBoolean(false);
  public ObservableField<String> c = new ObservableField();
  public ObservableField<String> d = new ObservableField();
  public ObservableField<String> e = new ObservableField();
  public ObservableField<String> f = new ObservableField();
  public ObservableBoolean g = new ObservableBoolean(false);
  public ObservableField<String> h = new ObservableField();
  public ObservableField<FirmwareUpgradeStatus> i = new ObservableField(FirmwareUpgradeStatus.UPDATE_ENABLE);
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> j = new MutableLiveData();
  public io.reactivex.e0.b k = new io.reactivex.e0.b();
  private FirmwareRepository l;
  private CommonCameraRepository m;
  private FirmwareManager n;
  private String o;
  
  public FirmwareUpdateViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void E()
  {
    this.n.M(this.o);
    g.m(new String[] { this.o });
  }
  
  private void F(boolean paramBoolean)
  {
    this.b.set(false);
    this.j.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.valueOf(paramBoolean)));
  }
  
  private void J(u paramu)
  {
    this.e.set(paramu.d());
    ObservableField localObservableField = this.f;
    if (paramu.a() != null) {
      paramu = paramu.a().replace("\\n", "\n");
    } else {
      paramu = "";
    }
    localObservableField.set(paramu);
  }
  
  private void f()
  {
    new io.reactivex.e0.b().b(this.l.w().t0(c4.c).x0(new k(k.d)).H0(new t3(this), new x3(this)));
  }
  
  private void g()
  {
    Object localObject = (ALCameraDevice)TPIoTClientManager.K1(this.o).getCameraDevice();
    if (localObject != null)
    {
      localObject = ((ALCameraDevice)localObject).getCameraAvatarInfo();
      if ((localObject != null) && (!TextUtils.isEmpty(((CameraAvatarInfo)localObject).getAvatarName())))
      {
        this.d.set(z4.c(getApplication(), ((CameraAvatarInfo)localObject).getAvatarName(), ((CameraAvatarInfo)localObject).getAvatarDefault().booleanValue()));
        return;
      }
    }
    this.d.set(getApplication().getString(2131953286));
  }
  
  public void D()
  {
    g.l(this.o);
  }
  
  public void G()
  {
    u localu = this.n.g(this.o);
    if (localu != null) {
      localu.j(false);
    }
    this.k.b(this.l.V().H0(new w3(this), new b4(this)));
  }
  
  public void H()
  {
    Object localObject = (AutoUpdateInfo)this.l.e.getValue();
    if (localObject != null)
    {
      boolean bool = OptionSwitch.isOn(((AutoUpdateInfo)localObject).getEnabled());
      ObservableField localObservableField = this.h;
      localObject = AppContext.c;
      int i1;
      if (bool) {
        i1 = 2131952442;
      } else {
        i1 = 2131952440;
      }
      localObservableField.set(((Application)localObject).getString(i1));
    }
  }
  
  public q<Boolean> I()
  {
    return ((CameraSettingRepository)e.c(this.o, CameraSettingRepository.class)).y();
  }
  
  public void h(String paramString)
  {
    this.o = paramString;
    this.l = ((FirmwareRepository)e.c(paramString, FirmwareRepository.class));
    this.m = ((CommonCameraRepository)e.c(this.o, CommonCameraRepository.class));
    paramString = (FirmwareManager)b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareManager.class);
    this.n = paramString;
    paramString = paramString.g(this.o);
    if (paramString != null)
    {
      J(paramString);
      paramString = this.m.K0().H0(new z3(this), s3.c);
      this.k.b(paramString);
    }
    else
    {
      paramString = this.m.K0().E(new y3(this)).L(v3.c).N(new a4(this)).H0(d4.c, h9.c);
      this.k.b(paramString);
    }
    g();
    paramString = (ALCameraDevice)TPIoTClientManager.K1(this.o).getCameraDevice();
    if (paramString != null) {
      this.c.set(paramString.getDeviceAlias());
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.k.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\FirmwareUpdateViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */