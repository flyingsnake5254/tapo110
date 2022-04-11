package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.f;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LensMaskRepository;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.e0.b;
import io.reactivex.q;
import java.util.Objects;

public class LensMaskViewModel
  extends AndroidViewModel
  implements LifecycleObserver
{
  public final MutableLiveData<Boolean> c = new MutableLiveData();
  public final MutableLiveData<Boolean> d = new MutableLiveData(Boolean.FALSE);
  private final MutableLiveData<Boolean> f = new MutableLiveData();
  private CommonCameraRepository p0;
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> p1 = new MutableLiveData();
  private boolean q;
  private b x = new b();
  private LensMaskRepository y;
  private MediatorLiveData<Boolean> z = new MediatorLiveData();
  
  public LensMaskViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void B(String paramString)
  {
    if (paramString == null) {
      return;
    }
    TPCameraDeviceContext localTPCameraDeviceContext = TPIoTClientManager.K1(paramString);
    if (localTPCameraDeviceContext != null)
    {
      Object localObject1 = this.y;
      if (localObject1 != null) {
        this.z.removeSource(((LensMaskRepository)localObject1).x());
      }
      Object localObject2 = (LensMaskRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(localTPCameraDeviceContext, LensMaskRepository.class);
      this.y = ((LensMaskRepository)localObject2);
      localObject1 = this.z;
      localObject2 = ((LensMaskRepository)localObject2).x();
      MediatorLiveData localMediatorLiveData = this.z;
      localMediatorLiveData.getClass();
      ((MediatorLiveData)localObject1).addSource((LiveData)localObject2, new y2(localMediatorLiveData));
      this.p0 = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(localTPCameraDeviceContext, CommonCameraRepository.class));
    }
    if ((f.f(paramString)) && (this.y != null))
    {
      F();
      this.q = false;
      paramString = this.y.y();
      Objects.requireNonNull(paramString);
      paramString = ((q)paramString).l0(io.reactivex.d0.b.a.a()).H0(new y(this), new w(this));
      this.x.b(paramString);
    }
  }
  
  private void F()
  {
    this.d.postValue(Boolean.TRUE);
  }
  
  private void h()
  {
    this.d.postValue(Boolean.FALSE);
  }
  
  private String j(@StringRes int paramInt)
  {
    return getApplication().getString(paramInt);
  }
  
  private void k(Throwable paramThrowable)
  {
    this.f.setValue(Boolean.FALSE);
    MutableLiveData localMutableLiveData = this.c;
    localMutableLiveData.setValue(Boolean.valueOf(j.h(localMutableLiveData)));
    m(paramThrowable);
  }
  
  private void l(Runnable paramRunnable)
  {
    h();
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    this.f.setValue(Boolean.FALSE);
  }
  
  private void m(Throwable paramThrowable)
  {
    n(paramThrowable, j(2131952741));
  }
  
  private void n(Throwable paramThrowable, String paramString)
  {
    b.d.w.c.a.e("LensMaskViewModel", Log.getStackTraceString(paramThrowable));
    h();
    if ((paramThrowable instanceof CameraException)) {
      switch (((CameraException)paramThrowable).getErrorCode())
      {
      default: 
        break;
      case -64304: 
        this.p1.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(j(2131954405)));
        return;
      case -64305: 
      case -64303: 
        this.p1.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(j(2131952364)));
        return;
      }
    }
    if (paramString != null) {
      this.p1.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
    }
  }
  
  private void o(Throwable paramThrowable)
  {
    if (this.q)
    {
      b.d.w.c.a.e("LensMaskViewModel", Log.getStackTraceString(paramThrowable));
    }
    else
    {
      this.q = true;
      n(paramThrowable, null);
    }
  }
  
  private void p()
  {
    this.q = true;
    h();
  }
  
  public void C(String paramString)
  {
    B(paramString);
  }
  
  public void D(LifecycleOwner paramLifecycleOwner)
  {
    this.z.observe(paramLifecycleOwner, new a0(this));
    paramLifecycleOwner.getLifecycle().addObserver(this);
  }
  
  public void E(MultiLiveVideoViewModel paramMultiLiveVideoViewModel)
  {
    paramMultiLiveVideoViewModel.v(this.f);
    paramMultiLiveVideoViewModel.v0(this.f);
  }
  
  public void f()
  {
    g(null, null);
  }
  
  public void g(Boolean paramBoolean, Runnable paramRunnable)
  {
    F();
    this.f.setValue(Boolean.TRUE);
    paramBoolean = this.p0.K0().N(new z(this, paramBoolean)).l0(io.reactivex.d0.b.a.a()).H0(new x(this, paramRunnable), new v(this));
    this.x.b(paramBoolean);
    if (j.g(this.c)) {
      com.tplink.iot.Utils.x0.e.j(this.y.v().getDeviceIdMD5());
    }
  }
  
  public LensMaskRepository i()
  {
    return this.y;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  protected void onCleared()
  {
    super.onCleared();
    this.x.d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\LensMaskViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */