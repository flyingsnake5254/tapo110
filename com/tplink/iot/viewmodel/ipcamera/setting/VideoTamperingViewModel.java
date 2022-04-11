package com.tplink.iot.viewmodel.ipcamera.setting;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.iot.Utils.x0.d;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.p;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TamperDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;

public class VideoTamperingViewModel
  extends AndroidViewModel
{
  private String a;
  private TamperDetectionRepository b;
  private int c = 3;
  private com.tplink.libtpmediaother.database.model.e d;
  private final MutableLiveData<Boolean> e;
  private final MutableLiveData<String> f;
  private final MutableLiveData<Boolean> g;
  private final MutableLiveData<Boolean> h;
  private final b i;
  
  public VideoTamperingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = Boolean.FALSE;
    this.e = new MutableLiveData(paramApplication);
    this.f = new MutableLiveData();
    this.g = new MutableLiveData(paramApplication);
    this.h = new MutableLiveData(paramApplication);
    this.i = new b();
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.a = paramApplication;
    this.b = ((TamperDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramApplication, TamperDetectionRepository.class));
  }
  
  private void H()
  {
    c localc = this.b.u().F(new d9(this)).C(h9.c).y(new a9(this)).G0(new b9(this));
    this.i.b(localc);
  }
  
  private void I(boolean paramBoolean)
  {
    int j = this.c;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    l.s(this.a, bool, new v8(this, paramBoolean));
  }
  
  private void J(String paramString)
  {
    int j = this.c;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    l.s(this.a, bool, new w8(this, paramString));
  }
  
  private void K(TamperDetectConfig paramTamperDetectConfig)
  {
    paramTamperDetectConfig = this.b.w(paramTamperDetectConfig).F(new y8(this)).y(new z8(this)).H0(new x8(this), new u8(this));
    this.i.b(paramTamperDetectConfig);
  }
  
  private void M(boolean paramBoolean)
  {
    p localp = this.b.t().a();
    localp.e(paramBoolean);
    K(localp.g());
  }
  
  private void O(String paramString)
  {
    p localp = this.b.t().a();
    localp.f(paramString);
    K(localp.g());
  }
  
  public void F()
  {
    p localp = this.b.t().a();
    this.e.postValue(Boolean.valueOf(localp.c()));
    this.f.postValue(localp.b());
  }
  
  public void G()
  {
    int j = this.c;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    l.g(this.a, bool, new c9(this));
  }
  
  public void L(boolean paramBoolean)
  {
    if (this.c == 3) {
      M(paramBoolean);
    } else {
      I(paramBoolean);
    }
    String str = this.a;
    boolean bool;
    if (this.c != 3) {
      bool = true;
    } else {
      bool = false;
    }
    d.p(str, paramBoolean, bool);
  }
  
  public void N(String paramString)
  {
    if (this.c == 3) {
      O(paramString);
    } else {
      J(paramString);
    }
  }
  
  public MutableLiveData<Boolean> f()
  {
    return this.h;
  }
  
  public MutableLiveData<Boolean> g()
  {
    return this.g;
  }
  
  public MutableLiveData<String> h()
  {
    return this.f;
  }
  
  public MutableLiveData<Boolean> i()
  {
    return this.e;
  }
  
  @SuppressLint({"CheckResult"})
  public void j(int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 3) {
      H();
    } else {
      G();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.i.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\VideoTamperingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */