package com.tplink.iot.viewmodel.ipcamera.setting.privacymask;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.viewmodel.ipcamera.basic.RegionEditViewModel;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.repo.PrivacyMaskRepository;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class PrivacyMaskZonesViewModel
  extends RegionEditViewModel
{
  private final String e = PrivacyMaskZonesViewModel.class.getSimpleName();
  private final String f;
  private final PrivacyMaskRepository g;
  private MutableLiveData<List<d>> h;
  private final b i;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> j;
  
  public PrivacyMaskZonesViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.f = paramApplication;
    MutableLiveData localMutableLiveData = new MutableLiveData();
    localMutableLiveData.setValue(new LinkedList());
    paramTPCameraDeviceContext = p.a;
    this.h = localMutableLiveData;
    this.i = new b();
    this.j = new MutableLiveData();
    this.g = ((PrivacyMaskRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramApplication, PrivacyMaskRepository.class));
    n();
  }
  
  private final <T> void i(q<T> paramq)
  {
    paramq = paramq.F(new a(this)).y(new b(this)).H0(c.c, new d(this));
    this.i.b(paramq);
  }
  
  private final void l(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> paramMutableLiveData, int paramInt)
  {
    Application localApplication = getApplication();
    j.d(localApplication, "getApplication<Application>()");
    paramMutableLiveData.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localApplication.getResources().getString(paramInt)));
  }
  
  private final void n()
  {
    MutableLiveData localMutableLiveData = this.h;
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((PrivacyMaskRepository)localObject).d;
      if (localObject != null)
      {
        localObject = (com.tplink.libtpnetwork.cameranetwork.business.model.e)((LiveData)localObject).getValue();
        if (localObject != null)
        {
          localObject = ((com.tplink.libtpnetwork.cameranetwork.business.model.e)localObject).a();
          if (localObject != null) {
            break label55;
          }
        }
      }
    }
    localObject = new LinkedList();
    label55:
    localMutableLiveData.setValue(localObject);
    localObject = (List)this.h.getValue();
    if (localObject != null)
    {
      j.d(localObject, "this");
      h((List)localObject);
    }
  }
  
  public final void h(List<? extends d> paramList)
  {
    j.e(paramList, "list");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (d)localIterator.next();
      if ((paramList.c() == 0) && (paramList.d() == 0) && (paramList.a() == 10000) && (paramList.b() == 10000))
      {
        this.c.set(true);
        return;
      }
      this.c.set(false);
    }
  }
  
  public final MutableLiveData<List<d>> j()
  {
    return this.h;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> k()
  {
    return this.j;
  }
  
  public final void m(List<? extends d> paramList, kotlin.jvm.b.a<p> parama)
  {
    j.e(paramList, "regions");
    j.e(parama, "runIfSuccess");
    PrivacyMaskRepository localPrivacyMaskRepository = this.g;
    if (localPrivacyMaskRepository != null)
    {
      paramList = localPrivacyMaskRepository.H(paramList);
      if (paramList != null)
      {
        paramList = paramList.E(new e(parama));
        if (paramList != null) {
          i(paramList);
        }
      }
    }
  }
  
  public final void o(List<? extends d> paramList)
  {
    j.e(paramList, "regions");
    this.h.setValue(paramList);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.i.d();
  }
  
  static final class a<T>
    implements g<c>
  {
    a(PrivacyMaskZonesViewModel paramPrivacyMaskZonesViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.d.set(true);
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(PrivacyMaskZonesViewModel paramPrivacyMaskZonesViewModel) {}
    
    public final void run()
    {
      this.a.d.set(false);
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
    d(PrivacyMaskZonesViewModel paramPrivacyMaskZonesViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.e(PrivacyMaskZonesViewModel.f(this.c), Log.getStackTraceString(paramThrowable));
      paramThrowable = this.c;
      PrivacyMaskZonesViewModel.g(paramThrowable, paramThrowable.k(), 2131952741);
    }
  }
  
  static final class e<T>
    implements g<Boolean>
  {
    e(kotlin.jvm.b.a parama) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.invoke();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\privacymask\PrivacyMaskZonesViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */