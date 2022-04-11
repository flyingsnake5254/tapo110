package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.iot.Utils.x0.d;
import com.tplink.libtpmediaother.database.model.e.c;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.c.a;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import io.reactivex.e0.b;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaIntrusionViewModel
  extends AndroidViewModel
{
  private String a;
  private AreaIntrusionRepository b;
  private int c = 3;
  private com.tplink.libtpmediaother.database.model.e d;
  private final MutableLiveData<Boolean> e;
  private final MutableLiveData<Boolean> f;
  private final MutableLiveData<Boolean> g;
  private final MutableLiveData<List<c.a>> h;
  public final ObservableBoolean i;
  public final ObservableBoolean j;
  public final ObservableBoolean k;
  private final b l;
  private final MutableLiveData<Boolean> m;
  
  public AreaIntrusionViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = Boolean.FALSE;
    this.e = new MutableLiveData(paramApplication);
    this.f = new MutableLiveData(paramApplication);
    this.g = new MutableLiveData(paramApplication);
    this.h = new MutableLiveData();
    this.i = new ObservableBoolean(false);
    this.j = new ObservableBoolean(false);
    this.k = new ObservableBoolean(false);
    this.l = new b();
    this.m = new MutableLiveData(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.a = paramApplication;
    this.b = ((AreaIntrusionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramApplication, AreaIntrusionRepository.class));
  }
  
  private void X(boolean paramBoolean)
  {
    int n = this.c;
    boolean bool = true;
    if (n != 1) {
      bool = false;
    }
    l.s(this.a, bool, new w0(paramBoolean));
  }
  
  private void Y(List<c.a> paramList)
  {
    int n = this.c;
    boolean bool = true;
    if (n != 1) {
      bool = false;
    }
    l.s(this.a, bool, new i0(this, paramList));
  }
  
  private void Z(DetectionInfo paramDetectionInfo)
  {
    paramDetectionInfo = this.b.D(paramDetectionInfo).F(new t0(this)).y(new l0(this)).H0(new x0(this), new p0(this));
    this.l.b(paramDetectionInfo);
  }
  
  private List<e.c> g(List<c.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      paramList = new e.c();
      paramList.g(locala.a());
      paramList.h(locala.b());
      paramList.i(locala.c());
      paramList.j(locala.d());
      localArrayList.add(paramList);
    }
    return localArrayList;
  }
  
  public void V()
  {
    this.e.postValue(Boolean.valueOf(this.b.z().c()));
    this.h.postValue(this.b.z().a());
  }
  
  public void W()
  {
    int n = this.c;
    boolean bool = true;
    if (n != 1) {
      bool = false;
    }
    l.g(this.a, bool, new k0(this));
  }
  
  public void a0(boolean paramBoolean)
  {
    if (this.c == 3)
    {
      if (paramBoolean) {
        str = "on";
      } else {
        str = "off";
      }
      Z(new DetectionInfo(str));
    }
    else
    {
      X(paramBoolean);
      this.e.postValue(Boolean.valueOf(paramBoolean));
    }
    String str = this.a;
    boolean bool;
    if (this.c != 3) {
      bool = true;
    } else {
      bool = false;
    }
    d.c(str, paramBoolean, bool);
  }
  
  public void b0(List<c.a> paramList)
  {
    if (this.c == 3)
    {
      localObject = this.b.w(paramList).F(new u0(this)).y(new r0(this)).C(new m0(this)).G0(new q0(this));
      this.l.b((io.reactivex.e0.c)localObject);
    }
    else
    {
      Y(paramList);
      this.m.postValue(Boolean.TRUE);
    }
    Object localObject = this.a;
    int n = paramList.size();
    boolean bool;
    if (this.c != 3) {
      bool = true;
    } else {
      bool = false;
    }
    d.b((String)localObject, n, bool);
  }
  
  public void f(List<c.a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c.a locala = (c.a)paramList.next();
      if ((locala.c() == 0) && (locala.d() == 0) && (locala.a() == 10000) && (locala.b() == 10000))
      {
        this.k.set(true);
        return;
      }
      this.k.set(false);
    }
  }
  
  public void h()
  {
    int n = this.c;
    if (n == 3)
    {
      com.tplink.libtpnetwork.cameranetwork.business.model.c localc = this.b.z();
      this.h.postValue(localc.a());
      f(localc.a());
    }
    else
    {
      boolean bool = true;
      if (n != 1) {
        bool = false;
      }
      l.g(this.a, bool, new n0(this));
    }
  }
  
  public String i()
  {
    return this.a;
  }
  
  public MutableLiveData<Boolean> j()
  {
    return this.g;
  }
  
  public MutableLiveData<Boolean> k()
  {
    return this.m;
  }
  
  public MutableLiveData<Boolean> l()
  {
    return this.e;
  }
  
  public MutableLiveData<Boolean> m()
  {
    return this.f;
  }
  
  public MutableLiveData<List<c.a>> n()
  {
    return this.h;
  }
  
  @SuppressLint({"CheckResult"})
  public void o(int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 3)
    {
      io.reactivex.e0.c localc = this.b.A().C(new j0(this)).F(new s0(this)).y(new v0(this)).G0(new o0(this));
      this.l.b(localc);
    }
    else
    {
      W();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.l.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\AreaIntrusionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */