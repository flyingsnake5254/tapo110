package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import b.d.w.e.b;
import com.tplink.iot.Utils.x0.f;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;

public class CameraManualInputPwdViewModel
  extends OnBoardingFragmentViewModel
{
  private CameraOnBoardingViewModel a;
  public final ObservableBoolean b = new ObservableBoolean(false);
  
  public CameraManualInputPwdViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public void f()
  {
    Object localObject1 = (String)this.a.a.get();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    String str = "";
    if (bool) {
      localObject1 = "";
    }
    Object localObject2 = (String)this.a.b.get();
    Object localObject3 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject3 = "";
    }
    localObject2 = new Wifi((String)localObject1, "", 4, Integer.valueOf(3), 0, (String)localObject3);
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = new Wifi((String)localObject1, "", 0, Integer.valueOf(0), 0, "");
    }
    this.a.c2((Wifi)localObject2);
    localObject3 = this.a.a;
    if (!TextUtils.isEmpty(((Wifi)localObject2).getSsid())) {
      localObject1 = ((Wifi)localObject2).getSsid();
    } else {
      localObject1 = "";
    }
    ((ObservableField)localObject3).set(localObject1);
    localObject3 = this.a.b;
    localObject1 = str;
    if (!TextUtils.isEmpty(((Wifi)localObject2).getPassword())) {
      localObject1 = ((Wifi)localObject2).getPassword();
    }
    ((ObservableField)localObject3).set(localObject1);
    f.B(this.a.B(), (Wifi)localObject2);
  }
  
  public boolean g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return b.b(paramString) ^ true;
  }
  
  public void h(CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.a = paramCameraOnBoardingViewModel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraManualInputPwdViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */