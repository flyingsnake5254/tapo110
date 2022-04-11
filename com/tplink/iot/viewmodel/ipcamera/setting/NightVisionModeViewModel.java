package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.NightVisionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.a;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class NightVisionModeViewModel
  extends AndroidViewModel
{
  private final String a;
  private final MutableLiveData<Boolean> b;
  private final String c;
  private final NightVisionRepository d;
  private final b e;
  private final MutableLiveData<NightVisionModeType> f;
  private final MutableLiveData<Integer> g;
  private final MutableLiveData<List<NightVisionModeType>> h;
  private final MutableLiveData<Boolean> i;
  private final TPCameraDeviceContext j;
  
  public NightVisionModeViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.j = paramTPCameraDeviceContext;
    paramApplication = NightVisionModeViewModel.class.getSimpleName();
    j.d(paramApplication, "NightVisionModeViewModel::class.java.simpleName");
    this.a = paramApplication;
    this.b = new MutableLiveData();
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.c = paramApplication;
    this.d = ((NightVisionRepository)e.c(paramApplication, NightVisionRepository.class));
    this.e = new b();
    this.f = new MutableLiveData();
    this.g = new MutableLiveData();
    this.h = new MutableLiveData();
    this.i = new MutableLiveData();
  }
  
  private final void o()
  {
    Object localObject = this.d.v();
    if (localObject != null) {
      localObject = m.k((String)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((Number)localObject).intValue();
      this.g.postValue(localObject);
    }
  }
  
  public final MutableLiveData<Boolean> h()
  {
    return this.i;
  }
  
  public final MutableLiveData<List<NightVisionModeType>> i()
  {
    return this.h;
  }
  
  public final MutableLiveData<NightVisionModeType> j()
  {
    return this.f;
  }
  
  public final void k()
  {
    this.d.w().F(new a(this)).y(new b(this)).E(new c(this)).F0();
  }
  
  public final MutableLiveData<Integer> l()
  {
    return this.g;
  }
  
  public final void m()
  {
    this.f.postValue(this.d.t());
    this.h.postValue(this.d.u());
    MutableLiveData localMutableLiveData = this.g;
    Object localObject = this.d.v();
    if (localObject != null) {
      localObject = Integer.valueOf(Integer.parseInt((String)localObject));
    } else {
      localObject = null;
    }
    localMutableLiveData.postValue(localObject);
  }
  
  public final MutableLiveData<Boolean> n()
  {
    return this.b;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.e.d();
  }
  
  public final void p(NightVisionModeType paramNightVisionModeType)
  {
    j.e(paramNightVisionModeType, "mode");
    this.d.A(paramNightVisionModeType).F(new d(this)).E(new e(this)).C(new f(this)).y(new g(this)).F0();
  }
  
  public final void r(final int paramInt)
  {
    this.d.C(paramInt).F(new h(this)).y(new i(this)).E(new j(this, paramInt)).C(new k(this)).F0();
  }
  
  static final class a<T>
    implements g<c>
  {
    a(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.n().postValue(Boolean.TRUE);
    }
  }
  
  static final class b
    implements a
  {
    b(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void run()
    {
      this.a.n().postValue(Boolean.FALSE);
    }
  }
  
  static final class c<T>
    implements g<Boolean>
  {
    c(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void a(Boolean paramBoolean)
    {
      NightVisionModeViewModel.g(this.c);
    }
  }
  
  static final class d<T>
    implements g<c>
  {
    d(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.n().postValue(Boolean.TRUE);
    }
  }
  
  static final class e<T>
    implements g<Boolean>
  {
    e(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.j().postValue(NightVisionModeViewModel.f(this.c).t());
    }
  }
  
  static final class f<T>
    implements g<Throwable>
  {
    f(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.h().postValue(Boolean.TRUE);
    }
  }
  
  static final class g
    implements a
  {
    g(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void run()
    {
      this.a.n().postValue(Boolean.FALSE);
    }
  }
  
  static final class h<T>
    implements g<c>
  {
    h(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.n().postValue(Boolean.TRUE);
    }
  }
  
  static final class i
    implements a
  {
    i(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void run()
    {
      this.a.n().postValue(Boolean.FALSE);
    }
  }
  
  static final class j<T>
    implements g<Boolean>
  {
    j(NightVisionModeViewModel paramNightVisionModeViewModel, int paramInt) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.l().postValue(Integer.valueOf(paramInt));
    }
  }
  
  static final class k<T>
    implements g<Throwable>
  {
    k(NightVisionModeViewModel paramNightVisionModeViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      NightVisionModeViewModel.g(this.c);
      this.c.h().postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\NightVisionModeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */