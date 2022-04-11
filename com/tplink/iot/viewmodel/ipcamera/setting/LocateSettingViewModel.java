package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.Utils.f;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceAvatarFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceFeatureInfo;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import io.reactivex.q;

public class LocateSettingViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  private String b;
  @Nullable
  private ALCameraDevice c;
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<j9>> d = new MutableLiveData();
  private TCDeviceRepository e;
  private CameraSettingRepository f;
  private TPCameraDeviceContext g;
  private TPIoTClientManager h;
  private io.reactivex.e0.b i = new io.reactivex.e0.b();
  
  public LocateSettingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.b = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.c = ((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice());
    this.g = paramTPCameraDeviceContext;
    this.e = ((TCDeviceRepository)b.d.b.f.b.c(paramTPCameraDeviceContext.getTcAccountContext()).a(TCDeviceRepository.class));
    this.h = ((TPIoTClientManager)b.d.b.f.b.a(paramTPCameraDeviceContext.getTcAccountContext(), TPIoTClientManager.class));
    this.f = ((CameraSettingRepository)e.c(this.b, CameraSettingRepository.class));
  }
  
  private void s(String paramString)
  {
    paramString = this.f.x1(paramString).y(new e5(this, paramString)).H0(g5.c, h9.c);
    this.i.b(paramString);
  }
  
  private void t(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)TPIoTClientManager.K1(paramString1).getCameraDevice();
    if (localALCameraDevice == null) {
      return;
    }
    CameraAvatarInfo localCameraAvatarInfo = localALCameraDevice.getCameraAvatarInfo();
    paramString1 = localCameraAvatarInfo;
    if (localCameraAvatarInfo == null)
    {
      paramString1 = new CameraAvatarInfo();
      localALCameraDevice.setCameraAvatarInfo(paramString1);
    }
    paramString1.setAvatarName(paramString2);
    paramString1.setAvatarDefault(Boolean.valueOf(paramBoolean2));
    paramString1.setAvatarNameModified(Boolean.TRUE);
    if (!paramBoolean2) {
      paramString1.setAvatarRemoteUrl(paramString3);
    }
  }
  
  private void w(ALCameraDevice paramALCameraDevice, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1 = paramALCameraDevice.getDeviceId();
    String str2 = this.g.getTcAccountContext().c().getCloudUserName();
    String str3 = this.g.getTcAccountContext().c().getToken();
    Object localObject = new DeviceFeatureInfo();
    ((DeviceFeatureInfo)localObject).setLastUpdateTimestamp(Long.valueOf(System.currentTimeMillis()));
    ((DeviceFeatureInfo)localObject).setDeviceAvatarFeatureInfo(new DeviceAvatarFeatureInfo(Boolean.valueOf(paramBoolean), paramString1));
    localObject = JsonUtils.g(localObject);
    paramALCameraDevice = this.e.X(str2, str1, (String)localObject, str3).C(io.reactivex.l0.a.c()).h(new f5(this, paramString1)).A(new d5(paramALCameraDevice, paramBoolean, paramString2, paramString1), h9.c);
    this.i.b(paramALCameraDevice);
  }
  
  public String f()
  {
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((ALCameraDevice)localObject).getDeviceLocation();
    } else {
      localObject = "";
    }
    return (String)localObject;
  }
  
  public boolean g()
  {
    ALCameraDevice localALCameraDevice = this.c;
    boolean bool;
    if ((localALCameraDevice != null) && (localALCameraDevice.isDefaultLocation())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.i.dispose();
  }
  
  public void p()
  {
    this.h.H3(this.b).y();
  }
  
  public void r(String paramString1, String paramString2, String paramString3)
  {
    ALCameraDevice localALCameraDevice = this.c;
    if ((localALCameraDevice != null) && (localALCameraDevice.isFirmwareSupportIoTCloud())) {
      s(paramString2);
    } else {
      v(paramString1, paramString2, paramString3);
    }
  }
  
  public void u(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString3 = String.valueOf(System.currentTimeMillis());
    b.d.q.b.p.b.i(paramContext, paramString1, paramString2, paramString3, null);
    new Handler().postDelayed(new c5(this, paramString1, paramString3, paramString2), 600L);
  }
  
  public void v(String paramString1, String paramString2, String paramString3)
  {
    t(paramString1, true, true, paramString2, null);
    paramString1 = (ALCameraDevice)TPIoTClientManager.K1(paramString1).getCameraDevice();
    if ((paramString1 != null) && (f.j(paramString1.getDeviceIdMD5()))) {
      w(paramString1, paramString2, null, true);
    } else {
      this.d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new j9(paramString2, null, true)));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\LocateSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */