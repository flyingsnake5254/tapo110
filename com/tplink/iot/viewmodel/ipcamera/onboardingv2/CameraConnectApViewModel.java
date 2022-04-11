package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.business.repo.OnBoardingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import io.reactivex.q;
import java.util.Objects;

public class CameraConnectApViewModel
  extends OnBoardingFragmentViewModel
{
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> a = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> b = new MutableLiveData();
  private io.reactivex.e0.b c = new io.reactivex.e0.b();
  private CameraOnBoardingViewModel d;
  
  public CameraConnectApViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public void f()
  {
    io.reactivex.e0.c localc = this.d.N().v().H0(new b(this), new c(this));
    this.c.b(localc);
  }
  
  public void g()
  {
    Object localObject1 = this.d.z();
    String str = "";
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.d.a.get();
      Objects.requireNonNull(localObject2);
      localObject1 = (String)localObject2;
      if (this.d.b.get() != null) {
        localObject2 = (String)this.d.b.get();
      } else {
        localObject2 = "";
      }
      Objects.requireNonNull(localObject2);
      localObject2 = new Wifi((String)localObject1, "", 4, Integer.valueOf(3), 0, (String)localObject2);
    }
    localObject1 = this.d.N();
    if (localObject1 != null)
    {
      if (this.d.b.get() != null) {
        str = (String)this.d.b.get();
      }
      Objects.requireNonNull(str);
      localObject2 = ((OnBoardingRepository)localObject1).t((Wifi)localObject2, j.d((String)str)).H0(new d(this), new a(this));
      this.c.b((io.reactivex.e0.c)localObject2);
    }
    else
    {
      this.b.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> h()
  {
    return this.b;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> i()
  {
    return this.a;
  }
  
  public void s(CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.d = paramCameraOnBoardingViewModel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraConnectApViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */