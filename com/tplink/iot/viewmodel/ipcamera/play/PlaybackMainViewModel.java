package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class PlaybackMainViewModel
  extends AndroidViewModel
{
  private static final String a = "PlaybackMainViewModel";
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> b = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> c = new MutableLiveData();
  @Nullable
  public ALCameraDevice d;
  public String e;
  public final MutableLiveData<String> f;
  private b g;
  public final ObservableBoolean h;
  private CameraSettingRepository i;
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<b>> j;
  private boolean k;
  public final ObservableBoolean l;
  public final ObservableBoolean m;
  public final ObservableBoolean n;
  public final ObservableBoolean o;
  public final ObservableField<VideoDisplayMode> p;
  public final ObservableBoolean q;
  public final ObservableBoolean r;
  public final ObservableBoolean s;
  public final ObservableBoolean t;
  public final ObservableBoolean u;
  public final ObservableBoolean v;
  private c w;
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> x;
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> y;
  public final MutableLiveData<Integer> z;
  
  public PlaybackMainViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = new MutableLiveData();
    this.f = paramApplication;
    this.g = new b();
    this.h = new ObservableBoolean(false);
    this.j = new MutableLiveData();
    this.l = new ObservableBoolean(false);
    this.m = new ObservableBoolean(false);
    this.n = new ObservableBoolean(false);
    this.o = new ObservableBoolean(false);
    this.p = new ObservableField(VideoDisplayMode.LIVE_STREAM);
    this.q = new ObservableBoolean(true);
    this.r = new ObservableBoolean(false);
    this.s = new ObservableBoolean(false);
    this.t = new ObservableBoolean(false);
    this.u = new ObservableBoolean(false);
    this.v = new ObservableBoolean(false);
    this.x = new MutableLiveData();
    this.y = new MutableLiveData();
    this.z = new MutableLiveData(null);
    String str = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.e = str;
    paramApplication.setValue(str);
    this.d = ((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice());
    this.i = ((CameraSettingRepository)e.c(this.e, CameraSettingRepository.class));
  }
  
  private String k(@StringRes int paramInt)
  {
    return getApplication().getResources().getString(paramInt);
  }
  
  private boolean v()
  {
    com.tplink.libtpnetwork.Utils.f0.a locala = new com.tplink.libtpnetwork.Utils.f0.a(Boolean.FALSE);
    l.r(this.e, new q1(locala));
    return ((Boolean)locala.a).booleanValue();
  }
  
  private void z(boolean paramBoolean, String paramString)
  {
    l.r(paramString, new n1(this, paramBoolean));
  }
  
  public void A(boolean paramBoolean, String paramString)
  {
    this.h.set(paramBoolean);
    VodMediaAPI.muteAudio(paramString, paramBoolean);
    z(paramBoolean, paramString);
  }
  
  public void B(VideoDisplayMode paramVideoDisplayMode)
  {
    this.p.set(paramVideoDisplayMode);
  }
  
  public void C(boolean paramBoolean)
  {
    if (this.r.get() != paramBoolean) {
      this.r.set(paramBoolean);
    }
  }
  
  public void D(boolean paramBoolean)
  {
    if (this.r.get() != paramBoolean)
    {
      this.r.set(paramBoolean);
      this.b.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.valueOf(paramBoolean)));
    }
  }
  
  public void E()
  {
    A(this.h.get() ^ true, this.e);
  }
  
  public void f()
  {
    c localc = this.w;
    if ((localc != null) && (!localc.isDisposed())) {
      this.w.dispose();
    }
  }
  
  void g()
  {
    if ((this.k) && (this.m.get()))
    {
      this.j.setValue(null);
      this.k = false;
    }
  }
  
  public void h()
  {
    c localc = this.i.H().H0(new z2(this), o1.c);
    this.g.b(localc);
  }
  
  public void i()
  {
    c localc = this.w;
    if ((localc != null) && (!localc.isDisposed())) {
      this.w.dispose();
    }
    this.w = q.W0(5L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new p1(this));
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> j()
  {
    return this.b;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> l()
  {
    return this.c;
  }
  
  void m(SdCardStatus paramSdCardStatus)
  {
    if (paramSdCardStatus != null)
    {
      this.k = true;
      switch (a.a[paramSdCardStatus.ordinal()])
      {
      default: 
        this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new b(k(2131953368), true)));
        b.d.w.c.a.c(a, "请重新插入SD卡或换一张SD卡");
        break;
      case 6: 
        this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new b(k(2131953363), false)));
        b.d.w.c.a.c(a, "格式化中");
        break;
      case 3: 
        if (!this.i.x().getSdCardInfoCache().getLoopEnable())
        {
          this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new b(k(2131953361), true)));
          b.d.w.c.a.c(a, "存储卡满了");
        }
      case 4: 
      case 5: 
        this.k = false;
        break;
      case 2: 
        this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new b(k(2131953362), true)));
        b.d.w.c.a.c(a, "需要格式化");
        break;
      }
      this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new b(k(2131953364), false)));
      b.d.w.c.a.c(a, "需要插入SD卡才可以播放");
    }
  }
  
  public void n()
  {
    A(v(), this.e);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.g.dispose();
    c localc = this.w;
    if ((localc != null) && (!localc.isDisposed())) {
      this.w.dispose();
    }
  }
  
  public void w()
  {
    c localc = this.w;
    if ((localc != null) && (!localc.isDisposed())) {
      this.w.dispose();
    }
    this.v.set(true);
  }
  
  public void x(boolean paramBoolean)
  {
    this.r.set(paramBoolean);
  }
  
  public void y(String paramString)
  {
    this.c.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
  }
  
  public class b
  {
    public String a;
    public boolean b;
    
    public b(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\PlaybackMainViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */