package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.libtpmediaother.database.model.e.c;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.g;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MotionDetectionViewModel
  extends AndroidViewModel
{
  public final MutableLiveData<Boolean> a;
  public final MutableLiveData<List<com.tplink.libtpnetwork.cameranetwork.business.model.d>> b;
  public ObservableInt c;
  public final MutableLiveData<Boolean> d;
  public final MutableLiveData<Boolean> e;
  public final MutableLiveData<Boolean> f;
  public ObservableBoolean g;
  public ObservableBoolean h;
  public ObservableBoolean i;
  private final b j;
  private String k;
  private com.tplink.libtpmediaother.database.model.e l;
  private int m;
  private MotionDetectionRepository n;
  
  public MotionDetectionViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = Boolean.FALSE;
    this.a = new MutableLiveData(paramApplication);
    this.b = new MutableLiveData();
    this.c = new ObservableInt(30);
    this.d = new MutableLiveData(paramApplication);
    this.e = new MutableLiveData(paramApplication);
    this.f = new MutableLiveData(paramApplication);
    this.g = new ObservableBoolean(false);
    this.h = new ObservableBoolean(false);
    this.i = new ObservableBoolean(false);
    this.j = new b();
    this.k = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.n = ((MotionDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, MotionDetectionRepository.class));
  }
  
  private void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tplink.iot.Utils.x0.d.l(this.k, paramBoolean1, paramBoolean2);
  }
  
  private void U(List<com.tplink.libtpnetwork.cameranetwork.business.model.d> paramList)
  {
    String str = this.k;
    boolean bool = false;
    int i1;
    if (paramList == null) {
      i1 = 0;
    } else {
      i1 = paramList.size();
    }
    if (this.m != 3) {
      bool = true;
    }
    com.tplink.iot.Utils.x0.d.j(str, i1, bool);
  }
  
  private void V(String paramString)
  {
    String str = this.k;
    boolean bool;
    if (this.m != 3) {
      bool = true;
    } else {
      bool = false;
    }
    com.tplink.iot.Utils.x0.d.k(str, paramString, bool);
  }
  
  private void W(List<com.tplink.libtpnetwork.cameranetwork.business.model.d> paramList)
  {
    int i1 = this.m;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.s(this.k, bool, new r5(this, paramList));
  }
  
  private void X(boolean paramBoolean)
  {
    int i1 = this.m;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.s(this.k, bool, new t5(paramBoolean));
  }
  
  private void Y(int paramInt)
  {
    int i1 = this.m;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.s(this.k, bool, new q5(paramInt));
  }
  
  private void a0(boolean paramBoolean, int paramInt)
  {
    c localc = this.n.s(paramBoolean, paramInt).F(new x5(this)).y(new j5(this)).H0(new o5(this), new s5(this));
    this.j.b(localc);
  }
  
  private List<e.c> g(List<com.tplink.libtpnetwork.cameranetwork.business.model.d> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tplink.libtpnetwork.cameranetwork.business.model.d locald = (com.tplink.libtpnetwork.cameranetwork.business.model.d)paramList.next();
      e.c localc = new e.c();
      localc.g(locald.a());
      localc.h(locald.b());
      localc.i(locald.c());
      localc.j(locald.d());
      localArrayList.add(localc);
    }
    return localArrayList;
  }
  
  public void R()
  {
    this.a.postValue(Boolean.valueOf(this.n.y().e()));
    this.b.postValue(this.n.y().c());
    this.c.set(this.n.y().d() - 20);
  }
  
  public void S()
  {
    int i1 = this.m;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.g(this.k, bool, new m5(this));
  }
  
  public void Z(List<com.tplink.libtpnetwork.cameranetwork.business.model.d> paramList)
  {
    U(paramList);
    if (this.m == 3)
    {
      paramList = this.n.a0(paramList).F(new l5(this)).C(new h5(this)).z(new i5(this)).y(new u5(this)).F0();
      this.j.b(paramList);
    }
    else
    {
      W(paramList);
      this.f.postValue(Boolean.TRUE);
    }
  }
  
  public void b0(boolean paramBoolean)
  {
    if (this.m == 3)
    {
      a0(paramBoolean, this.n.y().d());
    }
    else
    {
      X(paramBoolean);
      this.a.postValue(Boolean.valueOf(paramBoolean));
    }
    boolean bool;
    if (this.m != 3) {
      bool = true;
    } else {
      bool = false;
    }
    T(paramBoolean, bool);
  }
  
  public void c0(int paramInt)
  {
    if (this.m == 3) {
      a0(this.n.y().e(), paramInt);
    } else {
      Y(paramInt);
    }
  }
  
  public void d0(int paramInt)
  {
    int i1 = this.c.get();
    this.c.set(paramInt);
    int i2;
    if (paramInt > i1)
    {
      if (paramInt > 38)
      {
        i2 = 60;
        V("High");
      }
      else
      {
        i2 = i1;
        if (paramInt > 8) {
          V("Normal");
        }
      }
    }
    else {
      for (;;)
      {
        i2 = 30;
        break;
        i2 = i1;
        if (paramInt >= i1) {
          break;
        }
        if (paramInt < 22)
        {
          i2 = 0;
          V("Low");
          break;
        }
        i2 = i1;
        if (paramInt >= 52) {
          break;
        }
        V("Normal");
      }
    }
    this.c.set(i2);
    c0(i2 + 20);
  }
  
  public void f(List<com.tplink.libtpnetwork.cameranetwork.business.model.d> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (com.tplink.libtpnetwork.cameranetwork.business.model.d)localIterator.next();
      if ((paramList.c() == 0) && (paramList.d() == 0) && (paramList.a() == 10000) && (paramList.b() == 10000))
      {
        this.i.set(true);
        return;
      }
      this.i.set(false);
    }
  }
  
  public void h()
  {
    int i1 = this.m;
    if (i1 == 3)
    {
      g localg = this.n.y();
      this.b.postValue(localg.c());
      f(localg.c());
    }
    else
    {
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      l.g(this.k, bool, new n5(this));
    }
  }
  
  public String i()
  {
    return this.k;
  }
  
  public void j(int paramInt)
  {
    this.m = paramInt;
    if (paramInt == 3)
    {
      c localc = this.n.X().C(new k5(this)).F(new p5(this)).y(new w5(this)).G0(new v5(this));
      this.j.b(localc);
    }
    else
    {
      S();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.j.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\MotionDetectionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */