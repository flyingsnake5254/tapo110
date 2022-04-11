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
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType;
import io.reactivex.q;

public class AlarmSoundViewModel
  extends AndroidViewModel
{
  public final MutableLiveData<Boolean> a;
  public final MutableLiveData<Boolean> b;
  public final MutableLiveData<AlarmSoundType> c;
  private AlarmSettingRepository d;
  private String e;
  private int f;
  private io.reactivex.e0.b g;
  
  public AlarmSoundViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
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
  
  private void s()
  {
    AlarmSoundType localAlarmSoundType = AlarmSoundType.ALARM;
    com.tplink.libtpnetwork.cameranetwork.business.model.b localb = this.d.z();
    if (localb != null) {
      localAlarmSoundType = localb.c();
    }
    this.c.postValue(localAlarmSoundType);
  }
  
  private void t()
  {
    int i = this.f;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    l.g(this.e, bool, new w(this));
  }
  
  private void u(AlarmSoundType paramAlarmSoundType)
  {
    int i = this.f;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    l.s(this.e, bool, new v(paramAlarmSoundType));
  }
  
  public void f(int paramInt)
  {
    this.f = paramInt;
    if (paramInt == 3) {
      s();
    } else {
      t();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.g.dispose();
  }
  
  public void v(AlarmSoundType paramAlarmSoundType)
  {
    if (this.f == 3)
    {
      paramAlarmSoundType = this.d.v(paramAlarmSoundType).F(new t(this)).y(new r(this)).H0(new u(this), new s(this));
      this.g.b(paramAlarmSoundType);
    }
    else
    {
      u(paramAlarmSoundType);
      this.c.postValue(paramAlarmSoundType);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\AlarmSoundViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */