package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.Utils.v0.d;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.f;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;

public class VideoControlPanelViewModel
  extends AndroidViewModel
{
  public final MutableLiveData<Boolean> a = new MutableLiveData(Boolean.FALSE);
  private c b;
  public ObservableBoolean c = new ObservableBoolean(false);
  private VideoPlayViewModel d;
  private b e = new b();
  private AlarmSettingRepository f;
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> g = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> h = new MutableLiveData();
  
  public VideoControlPanelViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public void A()
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((c)localObject).isDisposed())) {
      this.b.dispose();
    }
    localObject = (String)j.e(this.d.k, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (!f.f((String)localObject)) {
      return;
    }
    localObject = (AlarmSettingRepository)e.b(TPIoTClientManager.K1((String)localObject), AlarmSettingRepository.class);
    this.f = ((AlarmSettingRepository)localObject);
    this.d.l.set(((AlarmSettingRepository)localObject).y());
    localObject = this.f.L().L0(io.reactivex.l0.a.c()).H0(new m2(this), g2.c);
    this.b = ((c)localObject);
    this.e.b((c)localObject);
  }
  
  public void B(boolean paramBoolean)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      this.a.postValue(Boolean.TRUE);
      new Handler().postDelayed(new j2(this), 1000L);
      return;
    }
    localObject = ((AlarmSettingRepository)localObject).s(paramBoolean).F(new h2(this)).y(new n2(this)).H0(new l2(this, paramBoolean), new k2(this));
    this.e.b((c)localObject);
  }
  
  public void C(VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.d = paramVideoPlayViewModel;
  }
  
  public void f()
  {
    Object localObject = (String)j.e(this.d.k, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (!f.f((String)localObject)) {
      return;
    }
    localObject = ((CommonCameraRepository)e.c((String)localObject, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new f2(this), new i2(this));
    this.e.b((c)localObject);
  }
  
  public VideoPlayViewModel g()
  {
    return this.d;
  }
  
  public void h()
  {
    String str = (String)j.e(this.d.k, "");
    this.c.set(d.c(str));
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.e.d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\VideoControlPanelViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */