package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LiveVideoRepository;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.g0.j;
import io.reactivex.q;

public class CameraInstallPreviewViewModel
  extends OnBoardingFragmentViewModel
{
  CameraSettingRepository a;
  CommonCameraRepository b;
  LiveVideoRepository c;
  String d;
  
  public CameraInstallPreviewViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = paramThingContext.getDeviceIdMD5();
    this.d = paramApplication;
    this.a = ((CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramApplication, CameraSettingRepository.class));
    this.c = ((LiveVideoRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.d, LiveVideoRepository.class));
  }
  
  public q<String> f()
  {
    if (TextUtils.isEmpty(this.c.t()))
    {
      b.d.w.c.a.c("CameraInstallPreview", "getVideoResolution---111");
      return this.c.F().g0(new a());
    }
    b.d.w.c.a.c("CameraInstallPreview", "getVideoResolution---222");
    return q.f0(this.c.t());
  }
  
  @SuppressLint({"CheckResult"})
  public q<Boolean> m()
  {
    if (this.a.x() != null)
    {
      CameraSettingRepository localCameraSettingRepository = this.a;
      return localCameraSettingRepository.z1(localCameraSettingRepository.x().getImageFlipEnable() ^ true).E(i.c).C(h.c);
    }
    return this.b.K0().N(new f(this)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(g.c).C(e.c);
  }
  
  class a
    implements j<Boolean, String>
  {
    a() {}
    
    public String a(@NonNull Boolean paramBoolean)
      throws Exception
    {
      return CameraInstallPreviewViewModel.this.c.t();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraInstallPreviewViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */