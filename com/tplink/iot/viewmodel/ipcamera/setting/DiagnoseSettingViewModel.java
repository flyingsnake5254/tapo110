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

public class DiagnoseSettingViewModel
  extends AndroidViewModel
{
  public final MutableLiveData<Boolean> a = new MutableLiveData();
  public final ObservableBoolean b = new ObservableBoolean(false);
  private String c;
  private TPCameraDeviceContext d;
  private LdcDianoseSettingRepository e;
  private b f = new b();
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> g = new MutableLiveData();
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> h = new MutableLiveData();
  private MediatorLiveData<Boolean> i = new MediatorLiveData();
  private MediatorLiveData<Boolean> j = new MediatorLiveData();
  
  public DiagnoseSettingViewModel(@NonNull Application paramApplication)
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
  
  private void p(boolean paramBoolean)
  {
    g.j(this.c, paramBoolean);
  }
  
  public void f(boolean paramBoolean)
  {
    this.b.set(true);
    c localc = this.e.U(paramBoolean).l0(io.reactivex.d0.b.a.a()).H0(new o3(this), new p3(this));
    this.f.b(localc);
    p(paramBoolean);
  }
  
  public void r(String paramString)
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
        this.i.removeSource(paramString.x());
      }
      Object localObject1 = (LdcDianoseSettingRepository)e.b(this.d, LdcDianoseSettingRepository.class);
      this.e = ((LdcDianoseSettingRepository)localObject1);
      paramString = this.i;
      Object localObject2 = ((LdcDianoseSettingRepository)localObject1).x();
      localObject1 = this.i;
      localObject1.getClass();
      paramString.addSource((LiveData)localObject2, new i9((MediatorLiveData)localObject1));
      this.e.z().postValue(Boolean.FALSE);
      paramString = this.j;
      localObject1 = this.e.z();
      localObject2 = this.j;
      localObject2.getClass();
      paramString.addSource((LiveData)localObject1, new i9((MediatorLiveData)localObject2));
      paramString = this.e.S(false).l0(io.reactivex.d0.b.a.a()).H0(new m3(this), new p3(this));
      this.f.b(paramString);
    }
  }
  
  public void s(LifecycleOwner paramLifecycleOwner)
  {
    MediatorLiveData localMediatorLiveData = this.i;
    MutableLiveData localMutableLiveData = this.a;
    localMutableLiveData.getClass();
    localMediatorLiveData.observe(paramLifecycleOwner, new f9(localMutableLiveData));
    this.j.observe(paramLifecycleOwner, new n3(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\DiagnoseSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */