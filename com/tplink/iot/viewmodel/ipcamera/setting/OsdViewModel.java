package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.OsdInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;

public class OsdViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public ObservableBoolean b = new ObservableBoolean(false);
  public ObservableBoolean c = new ObservableBoolean(false);
  public ObservableField<String> d = new ObservableField();
  public ObservableBoolean e = new ObservableBoolean(false);
  public ObservableBoolean f = new ObservableBoolean(false);
  private OsdInfoCache g;
  private CameraSettingRepository h;
  private CommonCameraRepository i;
  public String j;
  private b k = new b();
  public final MutableLiveData<Boolean> l = new MutableLiveData();
  public final MutableLiveData<Boolean> m = new MutableLiveData();
  
  public OsdViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.j = paramApplication;
    this.i = ((CommonCameraRepository)e.c(paramApplication, CommonCameraRepository.class));
    this.h = ((CameraSettingRepository)e.c(this.j, CameraSettingRepository.class));
  }
  
  private void A()
  {
    Object localObject = this.h.x().getOsdConfig();
    this.g = ((OsdInfoCache)localObject);
    if (localObject != null)
    {
      ObservableBoolean localObservableBoolean = this.b;
      OptionSwitch localOptionSwitch = ((OsdInfoCache)localObject).getEnable();
      localObject = OptionSwitch.ON;
      boolean bool1 = true;
      boolean bool2;
      if (localOptionSwitch == localObject) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObservableBoolean.set(bool2);
      localObservableBoolean = this.c;
      if (this.g.getTextEnable() == localObject) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObservableBoolean.set(bool2);
      D();
      if (this.e.get())
      {
        localObservableBoolean = this.f;
        if (this.g.getLogoEnable() == localObject) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        localObservableBoolean.set(bool2);
      }
    }
  }
  
  private void g(CameraComponent paramCameraComponent)
  {
    this.e.set(paramCameraComponent.isSupportOsdLogo());
    paramCameraComponent = this.h.C(this.e.get()).F(new u6(this)).y(new c7(this)).H0(new v6(this), a7.c);
    this.k.b(paramCameraComponent);
  }
  
  public void B(boolean paramBoolean)
  {
    Object localObject1 = this.a;
    boolean bool1 = true;
    ((ObservableBoolean)localObject1).set(true);
    Object localObject2 = this.d.get();
    String str = " ";
    localObject1 = str;
    if (localObject2 != null) {
      if (((String)this.d.get()).length() == 0) {
        localObject1 = str;
      } else {
        localObject1 = (String)this.d.get();
      }
    }
    boolean bool2 = this.e.get();
    boolean bool3 = false;
    if (!bool2) {
      if ((!this.b.get()) && (this.c.get()))
      {
        this.c.set(false);
        bool3 = bool1;
      }
      else
      {
        bool3 = false;
      }
    }
    this.k.b(f().D1(this.b.get(), this.c.get(), (String)localObject1, this.e.get()).H0(new x6(this, (String)localObject1), new w6(this, paramBoolean, bool3)));
  }
  
  public void C()
  {
    this.a.set(true);
    this.k.b(f().E1(this.f.get()).H0(new y6(this), new b7(this)));
  }
  
  public void D()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      ObservableField localObservableField = this.d;
      if (" ".equals(((OsdInfoCache)localObject).getName())) {
        localObject = "";
      } else {
        localObject = this.g.getName();
      }
      localObservableField.set(localObject);
    }
  }
  
  public CameraSettingRepository f()
  {
    return this.h;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.k.dispose();
  }
  
  public void z()
  {
    c localc = this.i.K0().H0(new t6(this), z6.c);
    this.k.b(localc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\OsdViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */