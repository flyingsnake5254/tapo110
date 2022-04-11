package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.x0.g;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LdcDianoseSettingRepository;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;

public class LdcSettingViewModel
  extends AndroidViewModel
{
  public final MutableLiveData<Boolean> a = new MutableLiveData();
  public final ObservableBoolean b = new ObservableBoolean(false);
  private String c;
  private TPCameraDeviceContext d;
  private LdcDianoseSettingRepository e;
  private b f = new b();
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> g = new MutableLiveData();
  private MediatorLiveData<Boolean> h = new MediatorLiveData();
  
  public LdcSettingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void g(Throwable paramThrowable)
  {
    this.b.set(false);
    this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(getApplication().getString(2131952741)));
  }
  
  private void h()
  {
    this.b.set(false);
  }
  
  private void n(boolean paramBoolean)
  {
    g.k(this.c, paramBoolean);
  }
  
  public void f(boolean paramBoolean)
  {
    this.b.set(true);
    c localc = this.e.W(paramBoolean).l0(io.reactivex.d0.b.a.a()).H0(new f4(this), new g4(this));
    this.f.b(localc);
    n(paramBoolean);
  }
  
  public void o(String paramString)
  {
    if (d0.a(this.c, paramString)) {
      return;
    }
    this.c = paramString;
    this.d = null;
    if (paramString != null)
    {
      this.d = TPIoTClientManager.K1(paramString);
      paramString = this.e;
      if (paramString != null) {
        this.h.removeSource(paramString.y());
      }
      Object localObject = (LdcDianoseSettingRepository)e.b(this.d, LdcDianoseSettingRepository.class);
      this.e = ((LdcDianoseSettingRepository)localObject);
      paramString = this.h;
      MutableLiveData localMutableLiveData = ((LdcDianoseSettingRepository)localObject).y();
      localObject = this.h;
      localObject.getClass();
      paramString.addSource(localMutableLiveData, new i9((MediatorLiveData)localObject));
      paramString = this.e.T().l0(io.reactivex.d0.b.a.a()).H0(new h4(this), new g4(this));
      this.f.b(paramString);
    }
  }
  
  public void p(LifecycleOwner paramLifecycleOwner)
  {
    MediatorLiveData localMediatorLiveData = this.h;
    MutableLiveData localMutableLiveData = this.a;
    localMutableLiveData.getClass();
    localMediatorLiveData.observe(paramLifecycleOwner, new f9(localMutableLiveData));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\LdcSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */