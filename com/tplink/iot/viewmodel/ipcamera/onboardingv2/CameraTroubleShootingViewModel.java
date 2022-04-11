package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraTroubleShootingViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableField<String> a = new ObservableField();
  public final ObservableField<String> b = new ObservableField();
  public final ObservableField<Drawable> c = new ObservableField();
  public final ObservableField<String> d = new ObservableField();
  public final ObservableField<String> e = new ObservableField();
  public final ObservableField<Drawable> f = new ObservableField();
  
  public CameraTroubleShootingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public void f(DeviceModel paramDeviceModel)
  {
    this.a.set(getApplication().getString(2131953309));
    this.b.set(getApplication().getString(2131953310));
    this.c.set(getApplication().getResources().getDrawable(2131231008));
    this.d.set(getApplication().getString(2131953272));
    this.e.set(getApplication().getString(c.p(paramDeviceModel)));
    this.f.set(getApplication().getResources().getDrawable(c.q(paramDeviceModel)));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraTroubleShootingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */