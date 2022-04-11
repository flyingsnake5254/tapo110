package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;

public class LightFrequencyViewModel
  extends AndroidViewModel
{
  public String a;
  public ObservableBoolean b = new ObservableBoolean(false);
  public CameraSettingRepository c;
  
  public LightFrequencyViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.a = paramApplication;
    this.c = ((CameraSettingRepository)e.c(paramApplication, CameraSettingRepository.class));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\LightFrequencyViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */