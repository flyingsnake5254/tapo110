package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordAudioRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.UpnpSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.c;
import io.reactivex.q;

public class AdvancedSettingViewModel
  extends AndroidViewModel
{
  public ObservableField<String> a = new ObservableField();
  public ObservableField<String> b = new ObservableField();
  public ObservableField<String> c = new ObservableField();
  public String d;
  public ObservableBoolean e = new ObservableBoolean(false);
  public ObservableBoolean f = new ObservableBoolean(true);
  public ObservableBoolean g = new ObservableBoolean(false);
  public ObservableBoolean h = new ObservableBoolean(true);
  public ObservableBoolean i = new ObservableBoolean(false);
  public ObservableBoolean j = new ObservableBoolean(true);
  public ObservableBoolean k = new ObservableBoolean(false);
  public ObservableBoolean l = new ObservableBoolean(false);
  public ObservableBoolean m = new ObservableBoolean(false);
  private io.reactivex.e0.b n = new io.reactivex.e0.b();
  private CameraSettingRepository o;
  private RecordAudioRepository p;
  private UpnpSettingRepository q;
  private CommonCameraRepository r;
  private MediatorLiveData<CameraComponent> s = new MediatorLiveData();
  public MutableLiveData<a<String>> t = new MutableLiveData();
  
  public AdvancedSettingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.d = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.o = ((CameraSettingRepository)e.b(paramTPCameraDeviceContext, CameraSettingRepository.class));
    this.r = ((CommonCameraRepository)e.b(paramTPCameraDeviceContext, CommonCameraRepository.class));
    this.p = ((RecordAudioRepository)e.b(paramTPCameraDeviceContext, RecordAudioRepository.class));
    this.q = ((UpnpSettingRepository)e.b(paramTPCameraDeviceContext, UpnpSettingRepository.class));
  }
  
  private void i()
  {
    this.e.set(false);
    this.t.postValue(new a(getApplication().getString(2131952741)));
  }
  
  private boolean k()
  {
    Object localObject = TPIoTClientManager.I1(this.d);
    if ((localObject instanceof ALCameraDevice))
    {
      localObject = ((ALCameraDevice)localObject).getDeviceModel();
      if (localObject != null) {
        return ((String)localObject).contains("C310");
      }
    }
    return false;
  }
  
  private boolean l(CameraComponent paramCameraComponent)
  {
    if (k()) {
      return false;
    }
    return paramCameraComponent.hasComponent(ComponentType.LDC);
  }
  
  public boolean f()
  {
    boolean bool;
    if (this.o.x().getAccountInfo() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean g()
  {
    boolean bool;
    if (this.o.x().getLightFrequencyMode() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean h()
  {
    return this.i.get();
  }
  
  public void j()
  {
    this.e.set(true);
    c localc = this.r.K0().N(new d(this)).y(new b(this)).F0();
    this.n.b(localc);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.n.d();
  }
  
  public void w()
  {
    this.r.K0().F0();
  }
  
  public void x()
  {
    Object localObject1 = this.o.x().getLightFrequencyMode();
    int i1 = 2131953846;
    int i2;
    if (localObject1 != null)
    {
      i2 = a.a[this.o.x().getLightFrequencyMode().ordinal()];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4) {
              this.a.set(getApplication().getString(2131953799));
            }
          }
          else {
            this.a.set(getApplication().getString(2131953798));
          }
        }
        else {
          this.a.set(getApplication().getString(2131953846));
        }
      }
      else {
        this.a.set(getApplication().getString(2131953804));
      }
    }
    boolean bool;
    Object localObject2;
    if (this.i.get())
    {
      localObject1 = this.q;
      if (localObject1 != null)
      {
        bool = j.h(((UpnpSettingRepository)localObject1).M1());
        localObject1 = this.b;
        localObject2 = getApplication();
        if (bool) {
          i2 = 2131953847;
        } else {
          i2 = 2131953846;
        }
        ((ObservableField)localObject1).set(((Application)localObject2).getString(i2));
      }
    }
    if (this.m.get())
    {
      localObject1 = this.p;
      if (localObject1 != null)
      {
        bool = j.h(((RecordAudioRepository)localObject1).L1());
        localObject2 = this.c;
        localObject1 = getApplication();
        i2 = i1;
        if (bool) {
          i2 = 2131953847;
        }
        ((ObservableField)localObject2).set(((Application)localObject1).getString(i2));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\AdvancedSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */