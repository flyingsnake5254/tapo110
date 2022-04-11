package com.tplink.iot.viewmodel.ipcamera.setting.privacymask;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.repo.PrivacyMaskRepository;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class PrivacyMaskViewModel
  extends AndroidViewModel
{
  private final String a = PrivacyMaskViewModel.class.getSimpleName();
  private final String b;
  private final PrivacyMaskRepository c;
  private final MutableLiveData<Boolean> d;
  private MutableLiveData<List<d>> e;
  private final MutableLiveData<Boolean> f;
  private final MutableLiveData<Boolean> g;
  private final b h;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> i;
  
  public PrivacyMaskViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = new MutableLiveData();
    paramApplication.setValue(Boolean.FALSE);
    p localp = p.a;
    this.d = paramApplication;
    paramApplication = new MutableLiveData();
    paramApplication.setValue(new LinkedList());
    this.e = paramApplication;
    this.f = new MutableLiveData();
    this.g = new MutableLiveData();
    this.h = new b();
    this.i = new MutableLiveData();
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    j.d(paramApplication, "context.deviceIdMD5");
    this.b = paramApplication;
    this.c = ((PrivacyMaskRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramApplication, PrivacyMaskRepository.class));
  }
  
  private final <T> void g(q<T> paramq)
  {
    paramq = paramq.F(new a(this)).y(new b(this)).H0(c.c, new d(this));
    this.h.b(paramq);
  }
  
  private final void p(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> paramMutableLiveData, int paramInt)
  {
    Application localApplication = getApplication();
    j.d(localApplication, "getApplication<Application>()");
    paramMutableLiveData.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localApplication.getResources().getString(paramInt)));
  }
  
  public final void h()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((PrivacyMaskRepository)localObject).t();
      if (localObject != null) {
        g((q)localObject);
      }
    }
  }
  
  public final MutableLiveData<Boolean> i()
  {
    return this.f;
  }
  
  public final MutableLiveData<Boolean> j()
  {
    return this.d;
  }
  
  public final MutableLiveData<List<d>> k()
  {
    return this.e;
  }
  
  public final String l()
  {
    return this.a;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> m()
  {
    return this.i;
  }
  
  public final MutableLiveData<Boolean> n()
  {
    return this.g;
  }
  
  public final boolean o()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((PrivacyMaskRepository)localObject).d;
      if (localObject != null)
      {
        localObject = (com.tplink.libtpnetwork.cameranetwork.business.model.e)((LiveData)localObject).getValue();
        break label31;
      }
    }
    localObject = null;
    label31:
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.h.d();
  }
  
  public final void r(LifecycleOwner paramLifecycleOwner)
  {
    j.e(paramLifecycleOwner, "lifecycleOwner");
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((PrivacyMaskRepository)localObject).d;
      if (localObject != null) {
        ((LiveData)localObject).observe(paramLifecycleOwner, new e(this));
      }
    }
  }
  
  public final void s(final boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((PrivacyMaskRepository)localObject).G(paramBoolean);
      if (localObject != null)
      {
        localObject = ((q)localObject).E(new f(this, paramBoolean));
        if (localObject != null)
        {
          localObject = ((q)localObject).C(new g(this, paramBoolean));
          if (localObject != null) {
            g((q)localObject);
          }
        }
      }
    }
  }
  
  static final class a<T>
    implements g<c>
  {
    a(PrivacyMaskViewModel paramPrivacyMaskViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.n().postValue(Boolean.TRUE);
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(PrivacyMaskViewModel paramPrivacyMaskViewModel) {}
    
    public final void run()
    {
      this.a.n().postValue(Boolean.FALSE);
    }
  }
  
  static final class c<T>
    implements g<T>
  {
    public static final c c = new c();
    
    public final void accept(T paramT) {}
  }
  
  static final class d<T>
    implements g<Throwable>
  {
    d(PrivacyMaskViewModel paramPrivacyMaskViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.e(this.c.l(), Log.getStackTraceString(paramThrowable));
      paramThrowable = this.c;
      PrivacyMaskViewModel.f(paramThrowable, paramThrowable.m(), 2131952741);
    }
  }
  
  static final class e<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.business.model.e>
  {
    e(PrivacyMaskViewModel paramPrivacyMaskViewModel) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.business.model.e parame)
    {
      MutableLiveData localMutableLiveData = this.a.j();
      boolean bool;
      if (parame != null) {
        bool = parame.b();
      } else {
        bool = false;
      }
      localMutableLiveData.setValue(Boolean.valueOf(bool));
      localMutableLiveData = this.a.k();
      if (parame != null)
      {
        parame = parame.a();
        if (parame != null) {}
      }
      else
      {
        parame = new LinkedList();
      }
      localMutableLiveData.setValue(parame);
    }
  }
  
  static final class f<T>
    implements g<Boolean>
  {
    f(PrivacyMaskViewModel paramPrivacyMaskViewModel, boolean paramBoolean) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.j().setValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  static final class g<T>
    implements g<Throwable>
  {
    g(PrivacyMaskViewModel paramPrivacyMaskViewModel, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.j().setValue(Boolean.valueOf(paramBoolean ^ true));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\privacymask\PrivacyMaskViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */