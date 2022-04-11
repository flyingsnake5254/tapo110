package com.tplink.iot.viewmodel.ipcamera.setting.targettrack;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TargetTrackRepository;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import kotlin.jvm.internal.j;

public final class TargetTrackViewModel
  extends AndroidViewModel
{
  private final String a = TargetTrackViewModel.class.getSimpleName();
  private final String b;
  private final TargetTrackRepository c;
  private final MutableLiveData<Boolean> d;
  private final MutableLiveData<Boolean> e;
  private final io.reactivex.e0.b f;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> g;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> h;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> i;
  private int j;
  
  public TargetTrackViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    j.d(paramApplication, "context.deviceIdMD5");
    this.b = paramApplication;
    this.d = new MutableLiveData();
    this.e = new MutableLiveData();
    this.f = new io.reactivex.e0.b();
    this.g = new MutableLiveData();
    this.h = new MutableLiveData();
    this.i = new MutableLiveData();
    this.j = 3;
    paramApplication = com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramApplication, TargetTrackRepository.class);
    j.d(paramApplication, "IoTDeviceRepositoryProvi…ckRepository::class.java)");
    this.c = ((TargetTrackRepository)paramApplication);
  }
  
  private final void A(boolean paramBoolean)
  {
    this.d.setValue(Boolean.valueOf(paramBoolean));
    int k = this.j;
    boolean bool = true;
    if (k != 1) {
      bool = false;
    }
    l.s(this.b, bool, new j(paramBoolean));
  }
  
  private final void B(final boolean paramBoolean)
  {
    q localq = this.c.B(paramBoolean).E(new k(this, paramBoolean)).C(new l(this, paramBoolean));
    j.d(localq, "targetTrackRepository\n  …nabled.value = !enabled }");
    j(localq);
  }
  
  private final <T> void j(q<T> paramq)
  {
    paramq = paramq.F(new d(this)).y(new e(this)).H0(f.c, new g(this));
    this.f.b(paramq);
  }
  
  private final void l()
  {
    int k = this.j;
    boolean bool = true;
    if (k != 1) {
      bool = false;
    }
    l.g(this.b, bool, new h(this));
  }
  
  private final void m()
  {
    q localq = this.c.s();
    j.d(localq, "targetTrackRepository\n  …       .targetTrackConfig");
    j(localq);
  }
  
  private final void t(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IoTCloudException)) {
      this.h.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    } else {
      this.g.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(getApplication().getString(2131952444)));
    }
  }
  
  private final void u(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          this.h.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
        else
        {
          this.h.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
          w.f(this.b);
        }
      }
      else {
        z(true);
      }
    }
    else
    {
      this.i.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
      w.g(this.b);
    }
  }
  
  private final void x(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> paramMutableLiveData, int paramInt)
  {
    Application localApplication = getApplication();
    j.d(localApplication, "getApplication<Application>()");
    paramMutableLiveData.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localApplication.getResources().getString(paramInt)));
  }
  
  public final void i()
  {
    c localc = h.a(this.b, true, ComponentType.TARGET_TRACK, new a(this)).H0(new b(this), new c(this));
    this.f.b(localc);
  }
  
  public final void k()
  {
    if (this.j == 3) {
      m();
    } else {
      l();
    }
  }
  
  public final String n()
  {
    return this.a;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> o()
  {
    return this.h;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.f.d();
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> p()
  {
    return this.i;
  }
  
  public final MutableLiveData<Boolean> r()
  {
    return this.d;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> s()
  {
    return this.g;
  }
  
  public final void v(int paramInt)
  {
    this.j = paramInt;
    k();
  }
  
  public final MutableLiveData<Boolean> w()
  {
    return this.e;
  }
  
  public final void y(LifecycleOwner paramLifecycleOwner)
  {
    j.e(paramLifecycleOwner, "lifecycleOwner");
    if (this.j == 3) {
      this.c.d.observe(paramLifecycleOwner, new i(this));
    }
  }
  
  public final void z(boolean paramBoolean)
  {
    if (this.j == 3) {
      B(paramBoolean);
    } else {
      A(paramBoolean);
    }
  }
  
  static final class a<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<Boolean>
  {
    a(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void b(Boolean paramBoolean)
    {
      this.a.w().setValue(paramBoolean);
    }
  }
  
  static final class b<T>
    implements g<Integer>
  {
    b(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void a(Integer paramInteger)
    {
      TargetTrackViewModel localTargetTrackViewModel = this.c;
      j.d(paramInteger, "it");
      TargetTrackViewModel.g(localTargetTrackViewModel, paramInteger.intValue());
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      TargetTrackViewModel localTargetTrackViewModel = this.c;
      j.d(paramThrowable, "it");
      TargetTrackViewModel.f(localTargetTrackViewModel, paramThrowable);
    }
  }
  
  static final class d<T>
    implements g<c>
  {
    d(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.w().postValue(Boolean.TRUE);
    }
  }
  
  static final class e
    implements io.reactivex.g0.a
  {
    e(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void run()
    {
      this.a.w().postValue(Boolean.FALSE);
    }
  }
  
  static final class f<T>
    implements g<T>
  {
    public static final f c = new f();
    
    public final void accept(T paramT) {}
  }
  
  static final class g<T>
    implements g<Throwable>
  {
    g(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.e(this.c.n(), Log.getStackTraceString(paramThrowable));
      paramThrowable = this.c;
      TargetTrackViewModel.h(paramThrowable, paramThrowable.s(), 2131952741);
    }
  }
  
  static final class h<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e>
  {
    h(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.e parame)
    {
      MutableLiveData localMutableLiveData = this.a.r();
      j.d(parame, "info");
      localMutableLiveData.setValue(Boolean.valueOf(parame.M()));
    }
  }
  
  static final class i<T>
    implements Observer<Boolean>
  {
    i(TargetTrackViewModel paramTargetTrackViewModel) {}
    
    public final void a(Boolean paramBoolean)
    {
      MutableLiveData localMutableLiveData = this.a.r();
      boolean bool;
      if (paramBoolean != null) {
        bool = paramBoolean.booleanValue();
      } else {
        bool = false;
      }
      localMutableLiveData.setValue(Boolean.valueOf(bool));
    }
  }
  
  static final class j<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e>
  {
    j(boolean paramBoolean) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.e parame)
    {
      j.d(parame, "info");
      parame.A0(this.a);
    }
  }
  
  static final class k<T>
    implements g<Boolean>
  {
    k(TargetTrackViewModel paramTargetTrackViewModel, boolean paramBoolean) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.r().setValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  static final class l<T>
    implements g<Throwable>
  {
    l(TargetTrackViewModel paramTargetTrackViewModel, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.r().setValue(Boolean.valueOf(paramBoolean ^ true));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\targettrack\TargetTrackViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */