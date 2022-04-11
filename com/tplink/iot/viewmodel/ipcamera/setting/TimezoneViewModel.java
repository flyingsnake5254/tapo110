package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import com.tplink.libtpnetwork.cameranetwork.util.i;
import com.tplink.libtpnetwork.cameranetwork.util.i.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimezoneViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public List<i.b> b = new ArrayList();
  public String c;
  private i.b d;
  private CameraSettingRepository e;
  private String f;
  
  public TimezoneViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.c = paramApplication;
    this.e = ((CameraSettingRepository)e.c(paramApplication, CameraSettingRepository.class));
    if (paramTPCameraDeviceContext.getIoTDevice() != null) {
      this.f = ((ALCameraDevice)paramTPCameraDeviceContext.getIoTDevice()).getDeviceId();
    }
  }
  
  public CameraSettingRepository f()
  {
    return this.e;
  }
  
  public i.b g()
  {
    return this.d;
  }
  
  public void h()
  {
    String str = this.e.x().getZoneId();
    this.b.addAll(i.e());
    i(str);
  }
  
  public void i(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      i.b localb = (i.b)localIterator.next();
      if (TextUtils.equals(paramString, localb.d())) {
        this.d = localb;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\TimezoneViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */