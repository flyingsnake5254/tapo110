package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import b.d.s.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.q;

public class DeviceNameEditorViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public ObservableField<String> b = new ObservableField("");
  public String c;
  private io.reactivex.e0.b d = new io.reactivex.e0.b();
  private CameraSettingRepository e;
  private TPIoTClientManager f;
  
  public DeviceNameEditorViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.c = paramApplication;
    this.e = ((CameraSettingRepository)e.c(paramApplication, CameraSettingRepository.class));
    this.f = ((TPIoTClientManager)b.d.b.f.b.a(a.f(), TPIoTClientManager.class));
  }
  
  public boolean f(String paramString)
  {
    boolean bool1 = false;
    int i;
    try
    {
      i = paramString.getBytes("UTF-8").length;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      i = 0;
    }
    boolean bool2 = bool1;
    if (i > 0)
    {
      bool2 = bool1;
      if (i <= 32) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void g()
  {
    Object localObject = this.e.x().getCameraInfo();
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((CameraInfoCache)localObject).getName();
    }
    this.b.set(localObject);
  }
  
  public q<Boolean> h(String paramString)
  {
    if (f(paramString)) {
      return this.f.R3(this.c, paramString);
    }
    return q.f0(Boolean.FALSE);
  }
  
  public void i(String paramString)
  {
    this.e.x().getCameraInfo().setName(paramString);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.d.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\DeviceNameEditorViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */