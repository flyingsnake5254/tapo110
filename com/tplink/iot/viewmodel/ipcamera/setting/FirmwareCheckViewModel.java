package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.b;
import io.reactivex.q;

public class FirmwareCheckViewModel
  extends AndroidViewModel
{
  public ObservableField<String> a = new ObservableField();
  public ObservableField<String> b = new ObservableField();
  public ObservableField<String> c = new ObservableField();
  public ObservableInt d = new ObservableInt(0);
  public ObservableBoolean e = new ObservableBoolean(false);
  public ObservableField<String> f = new ObservableField();
  public String g;
  private CameraSettingRepository h;
  private FirmwareRepository i;
  private CommonCameraRepository j;
  private b k = new b();
  
  public FirmwareCheckViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public q<LatestFirmwareInfo> f()
  {
    return this.i.u();
  }
  
  @SuppressLint({"CheckResult"})
  public void g(String paramString)
  {
    this.g = paramString;
    this.h = ((CameraSettingRepository)e.c(paramString, CameraSettingRepository.class));
    this.i = ((FirmwareRepository)e.c(paramString, FirmwareRepository.class));
    this.j = ((CommonCameraRepository)e.c(paramString, CommonCameraRepository.class));
    String str = getApplication().getString(2131952720);
    if (this.h.x().getCameraInfo() != null)
    {
      paramString = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.h.x().getCameraInfo().getSoftwareVer());
      paramString.set(localStringBuilder.toString());
    }
    this.j.K0().H0(new r3(this), q3.c);
  }
  
  public void k()
  {
    Object localObject = (AutoUpdateInfo)this.i.e.getValue();
    if (localObject != null)
    {
      boolean bool = OptionSwitch.isOn(((AutoUpdateInfo)localObject).getEnabled());
      ObservableField localObservableField = this.f;
      localObject = AppContext.c;
      int m;
      if (bool) {
        m = 2131952442;
      } else {
        m = 2131952440;
      }
      localObservableField.set(((Application)localObject).getString(m));
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.k.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\FirmwareCheckViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */