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
import com.tplink.libtpmediaother.database.model.e.b;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.f;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LineCrossingDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineCrossingViewModel
  extends AndroidViewModel
{
  private String a;
  private LineCrossingDetectionRepository b;
  private int c = 3;
  private com.tplink.libtpmediaother.database.model.e d;
  private final MutableLiveData<Boolean> e;
  private final MutableLiveData<Boolean> f;
  private final MutableLiveData<Boolean> g;
  private final MutableLiveData<List<LineCrossingDetectionRegion>> h;
  public final ObservableBoolean i;
  public final ObservableBoolean j;
  private final b k;
  private final MutableLiveData<Boolean> l;
  
  public LineCrossingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = Boolean.FALSE;
    this.e = new MutableLiveData(paramApplication);
    this.f = new MutableLiveData(paramApplication);
    this.g = new MutableLiveData(paramApplication);
    this.h = new MutableLiveData();
    this.i = new ObservableBoolean(false);
    this.j = new ObservableBoolean(false);
    this.k = new b();
    this.l = new MutableLiveData(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.a = paramApplication;
    this.b = ((LineCrossingDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramApplication, LineCrossingDetectionRepository.class));
  }
  
  private void T(boolean paramBoolean)
  {
    int m = this.c;
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    l.s(this.a, bool, new z4(paramBoolean));
  }
  
  private void U(List<LineCrossingDetectionRegion> paramList)
  {
    int m = this.c;
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new e.b((LineCrossingDetectionRegion)paramList.next()));
    }
    l.s(this.a, bool, new u4(localArrayList));
  }
  
  private void V(DetectionInfo paramDetectionInfo)
  {
    paramDetectionInfo = this.b.E(paramDetectionInfo).F(new t4(this)).y(new b5(this)).H0(new y4(this), new q4(this));
    this.k.b(paramDetectionInfo);
  }
  
  public void R()
  {
    int m = this.c;
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    l.g(this.a, bool, new n4(this));
  }
  
  public void S()
  {
    this.e.postValue(Boolean.valueOf(this.b.A().c()));
    this.h.postValue(new ArrayList(this.b.A().a()));
  }
  
  public void W(boolean paramBoolean)
  {
    if (this.c == 3)
    {
      if (paramBoolean) {
        str = "on";
      } else {
        str = "off";
      }
      V(new DetectionInfo(str));
    }
    else
    {
      T(paramBoolean);
      this.e.postValue(Boolean.valueOf(paramBoolean));
    }
    String str = this.a;
    boolean bool;
    if (this.c != 3) {
      bool = true;
    } else {
      bool = false;
    }
    d.i(str, paramBoolean, bool);
  }
  
  public void X(List<LineCrossingDetectionRegion> paramList)
  {
    if (this.c == 3)
    {
      localObject = this.b.w(paramList).F(new r4(this)).y(new x4(this)).C(new o4(this)).G0(new a5(this));
      this.k.b((c)localObject);
    }
    else
    {
      U(paramList);
      this.l.postValue(Boolean.TRUE);
    }
    Object localObject = this.a;
    int m = paramList.size();
    boolean bool;
    if (this.c != 3) {
      bool = true;
    } else {
      bool = false;
    }
    d.h((String)localObject, m, bool);
  }
  
  public String f()
  {
    return this.a;
  }
  
  public int g(LineCrossingDetectionRegion paramLineCrossingDetectionRegion)
  {
    paramLineCrossingDetectionRegion = paramLineCrossingDetectionRegion.getDirection();
    paramLineCrossingDetectionRegion.hashCode();
    int m = paramLineCrossingDetectionRegion.hashCode();
    int n = 1;
    int i1 = -1;
    switch (m)
    {
    default: 
      break;
    case 3029889: 
      if (paramLineCrossingDetectionRegion.equals("both")) {
        i1 = 2;
      }
      break;
    case 2081188: 
      if (paramLineCrossingDetectionRegion.equals("BtoA")) {
        i1 = 1;
      }
      break;
    case 2051398: 
      if (paramLineCrossingDetectionRegion.equals("AtoB")) {
        i1 = 0;
      }
      break;
    }
    switch (i1)
    {
    case 2: 
    default: 
      n = 2;
      break;
    case 0: 
      n = 0;
    }
    return n;
  }
  
  public String h(int paramInt)
  {
    String str = "both";
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        str = "BtoA";
      }
    }
    else {
      str = "AtoB";
    }
    return str;
  }
  
  public MutableLiveData<Boolean> i()
  {
    return this.g;
  }
  
  public MutableLiveData<Boolean> j()
  {
    return this.l;
  }
  
  public MutableLiveData<Boolean> k()
  {
    return this.e;
  }
  
  public MutableLiveData<Boolean> l()
  {
    return this.f;
  }
  
  public MutableLiveData<List<LineCrossingDetectionRegion>> m()
  {
    return this.h;
  }
  
  @SuppressLint({"CheckResult"})
  public void n(int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 3)
    {
      c localc = this.b.B().C(new w4(this)).F(new s4(this)).y(new v4(this)).G0(new p4(this));
      this.k.b(localc);
    }
    else
    {
      R();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.k.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\LineCrossingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */