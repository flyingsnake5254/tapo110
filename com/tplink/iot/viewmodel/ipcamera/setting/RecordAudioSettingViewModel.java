package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.x0.g;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordAudioRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.q;

public class RecordAudioSettingViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public final ObservableBoolean b = new ObservableBoolean(false);
  private RecordAudioRepository c;
  public MutableLiveData<a<String>> d = new MutableLiveData();
  private String e;
  
  public RecordAudioSettingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.e = paramTPCameraDeviceContext.getDeviceIdMD5();
    paramApplication = (RecordAudioRepository)e.b(paramTPCameraDeviceContext, RecordAudioRepository.class);
    this.c = paramApplication;
    this.a.set(j.h(paramApplication.L1()));
  }
  
  private void f(Throwable paramThrowable)
  {
    this.b.set(false);
    this.d.postValue(new a(getApplication().getString(2131952444)));
  }
  
  private void n(boolean paramBoolean)
  {
    g.r(this.e, paramBoolean);
  }
  
  @SuppressLint({"CheckResult"})
  public void o(boolean paramBoolean)
  {
    this.a.set(paramBoolean);
    this.c.V1(paramBoolean).F(new d7(this)).y(new f7(this)).H0(e7.c, new g7(this, paramBoolean));
    n(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\RecordAudioSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */