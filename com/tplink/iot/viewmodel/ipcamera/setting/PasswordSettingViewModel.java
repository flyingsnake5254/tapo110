package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.Utils.b0;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordSettingViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public ObservableField<String> b = new ObservableField();
  private String c;
  public ObservableField<String> d = new ObservableField();
  public ObservableField<String> e = new ObservableField();
  private String f;
  private CameraSettingRepository g;
  private String h;
  
  public PasswordSettingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.f = paramApplication;
    this.g = ((CameraSettingRepository)e.c(paramApplication, CameraSettingRepository.class));
    this.h = TPIoTClientManager.K1(this.f).getTcAccountContext().c().getPassword();
    this.d.set(TPIoTClientManager.K1(this.f).getTcAccountContext().c().getCloudUserName());
  }
  
  public q<Boolean> f(String paramString1, String paramString2)
  {
    return this.g.u(paramString1, paramString2);
  }
  
  public String g(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= 6) && (paramString.length() <= 32))
    {
      if (!Pattern.compile("^[\\x21-\\x7E]{6,32}$").matcher(paramString).matches()) {
        return b0.a(2131951712);
      }
      return null;
    }
    return b0.a(2131952572);
  }
  
  public boolean h(String paramString)
  {
    String str = this.h;
    if (str != null) {
      return str.equals(paramString);
    }
    return false;
  }
  
  public DeviceModel i()
  {
    if (this.g.x().getCameraInfo() != null) {
      return DeviceModel.fromValue(this.g.x().getCameraInfo().getModel());
    }
    return null;
  }
  
  public String j()
  {
    return this.c;
  }
  
  public void k()
  {
    AccountInfoCache localAccountInfoCache = this.g.x().getAccountInfo();
    if (localAccountInfoCache != null) {
      this.b.set(localAccountInfoCache.getUsername());
    }
  }
  
  public boolean l()
  {
    AccountInfoCache localAccountInfoCache = this.g.x().getAccountInfo();
    if (localAccountInfoCache != null) {
      return "---".equals(localAccountInfoCache.getUsername()) ^ true;
    }
    return false;
  }
  
  public q<Boolean> m(String paramString1, String paramString2)
  {
    return this.g.K1(paramString1, paramString2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\PasswordSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */