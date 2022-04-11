package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.AlertOption;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import io.reactivex.q;

public class AlarmTypeViewModel
  extends AndroidViewModel
{
  public final MutableLiveData<Boolean> a;
  public final MutableLiveData<Boolean> b;
  public final MutableLiveData<AlertOption> c;
  private AlarmSettingRepository d;
  private String e;
  private int f;
  private io.reactivex.e0.b g;
  
  public AlarmTypeViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = Boolean.FALSE;
    this.a = new MutableLiveData(paramApplication);
    this.b = new MutableLiveData(paramApplication);
    this.c = new MutableLiveData();
    this.g = new io.reactivex.e0.b();
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.e = paramApplication;
    this.d = ((AlarmSettingRepository)e.c(paramApplication, AlarmSettingRepository.class));
  }
  
  private AlertOption f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1)) {
      return AlertOption.BOTH;
    }
    if (paramBoolean2) {
      return AlertOption.LIGHT;
    }
    return AlertOption.SOUND;
  }
  
  private void t()
  {
    AlertOption localAlertOption = AlertOption.SOUND;
    com.tplink.libtpnetwork.cameranetwork.business.model.b localb = this.d.z();
    if (localb != null) {
      localAlertOption = f(localb.g(), localb.e());
    }
    this.c.postValue(localAlertOption);
  }
  
  private void u()
  {
    int i = this.f;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    l.g(this.e, bool, new b0(this));
  }
  
  private void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.f;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    l.s(this.e, bool, new z(paramBoolean1, paramBoolean2));
  }
  
  public void g(int paramInt)
  {
    this.f = paramInt;
    if (paramInt == 3) {
      t();
    } else {
      u();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.g.dispose();
  }
  
  public void w(AlertOption paramAlertOption)
  {
    AlertOption localAlertOption = AlertOption.LIGHT;
    boolean bool1 = true;
    boolean bool2;
    if (paramAlertOption != localAlertOption) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (paramAlertOption == AlertOption.SOUND) {
      bool1 = false;
    }
    if (this.f == 3)
    {
      paramAlertOption = this.d.t(bool2, bool1).F(new a0(this)).y(new y(this)).H0(new x(this), new c0(this));
      this.g.b(paramAlertOption);
    }
    else
    {
      v(bool2, bool1);
      this.c.postValue(paramAlertOption);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\AlarmTypeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */