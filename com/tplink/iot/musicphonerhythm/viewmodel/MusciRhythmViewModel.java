package com.tplink.iot.musicphonerhythm.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.k.c.b;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmCryptoResult;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmModeConfigParams;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmModeResult;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmSupportModeResult;
import com.tplink.iot.musicphonerhythm.repository.MusicNetworkRepository;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MusciRhythmViewModel
  extends AndroidViewModel
{
  private String a;
  private MusicNetworkRepository b;
  private MutableLiveData<MusicRhythmGlobalConfigBean> c = new MutableLiveData();
  private MutableLiveData<MusicRhythmCryptoResult> d = new MutableLiveData();
  private MutableLiveData<MusicRhythmSupportModeResult> e = new MutableLiveData();
  private MutableLiveData<MusicRhythmModeResult> f = new MutableLiveData();
  private MutableLiveData<Boolean> g = new MutableLiveData();
  private MediatorLiveData<IoTLightStripDevice> h = new MediatorLiveData();
  private c i = null;
  
  public MusciRhythmViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = paramThingContext.getDeviceIdMD5();
    paramApplication = (MusicNetworkRepository)e.a(paramThingContext, MusicNetworkRepository.class);
    this.b = paramApplication;
    this.h.addSource(paramApplication.n5(), new e());
  }
  
  public void B(MusicRhythmGlobalConfigBean paramMusicRhythmGlobalConfigBean)
  {
    this.b.M5(paramMusicRhythmGlobalConfigBean).F0();
  }
  
  public void C(MusicRhythmModeResult paramMusicRhythmModeResult)
  {
    this.b.N5(paramMusicRhythmModeResult).F0();
  }
  
  public void D(MusicRhythmModeConfigParams paramMusicRhythmModeConfigParams)
  {
    this.b.O5(paramMusicRhythmModeConfigParams).F0();
  }
  
  @SuppressLint({"CheckResult"})
  public void E()
  {
    this.b.P5().N(new a(this)).l0(io.reactivex.d0.b.a.a()).H0(new j(), new k());
  }
  
  public void F()
  {
    H();
    if (!this.b.D())
    {
      this.b.o5();
      return;
    }
    this.i = q.a0(0L, 5L, TimeUnit.SECONDS).G0(new d());
  }
  
  public q<Boolean> G()
  {
    final IoTLightStripDevice localIoTLightStripDevice = (IoTLightStripDevice)this.h.getValue();
    if (localIoTLightStripDevice != null) {
      localIoTLightStripDevice.setMusicRhythmEnable(Boolean.FALSE);
    }
    return this.b.Q5().E(new l(localIoTLightStripDevice));
  }
  
  public void H()
  {
    c localc = this.i;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public LiveData<IoTLightStripDevice> n()
  {
    return this.h;
  }
  
  public void o()
  {
    this.b.p5().l0(io.reactivex.d0.b.a.a()).E(new i()).C(new h()).F0();
  }
  
  public MusicRhythmCryptoResult p()
  {
    return (MusicRhythmCryptoResult)this.d.getValue();
  }
  
  public MutableLiveData<MusicRhythmCryptoResult> r()
  {
    return this.d;
  }
  
  public void s()
  {
    this.b.q5().l0(io.reactivex.d0.b.a.a()).E(new g()).C(new f()).F0();
  }
  
  public void t()
  {
    this.b.r5().l0(io.reactivex.d0.b.a.a()).E(new c()).C(new b()).F0();
  }
  
  public MutableLiveData<MusicRhythmModeResult> u()
  {
    return this.f;
  }
  
  public MutableLiveData<Boolean> v()
  {
    return this.g;
  }
  
  public MutableLiveData<MusicRhythmSupportModeResult> w()
  {
    return this.e;
  }
  
  public MutableLiveData<MusicRhythmGlobalConfigBean> x()
  {
    return this.c;
  }
  
  public void y()
  {
    this.b.s5().l0(io.reactivex.d0.b.a.a()).E(new a()).C(new m()).F0();
  }
  
  class a
    implements g<MusicRhythmSupportModeResult>
  {
    a() {}
    
    public void a(MusicRhythmSupportModeResult paramMusicRhythmSupportModeResult)
      throws Exception
    {
      MusciRhythmViewModel.j(MusciRhythmViewModel.this).postValue(paramMusicRhythmSupportModeResult);
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = new MusicRhythmModeResult(null);
      paramThrowable.setMode((String)b.d().get(0));
      MusciRhythmViewModel.k(MusciRhythmViewModel.this).postValue(paramThrowable);
    }
  }
  
  class c
    implements g<MusicRhythmModeResult>
  {
    c() {}
    
    public void a(MusicRhythmModeResult paramMusicRhythmModeResult)
      throws Exception
    {
      MusciRhythmViewModel.k(MusciRhythmViewModel.this).postValue(paramMusicRhythmModeResult);
    }
  }
  
  class d
    implements g<Long>
  {
    d() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (MusciRhythmViewModel.l(MusciRhythmViewModel.this).D()) {
        MusciRhythmViewModel.l(MusciRhythmViewModel.this).o5();
      } else if (MusciRhythmViewModel.m(MusciRhythmViewModel.this) != null) {
        MusciRhythmViewModel.m(MusciRhythmViewModel.this).dispose();
      }
    }
  }
  
  class e
    implements Observer<IoTLightStripDevice>
  {
    e() {}
    
    public void a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      MusciRhythmViewModel.f(MusciRhythmViewModel.this).postValue(paramIoTLightStripDevice);
    }
  }
  
  class f
    implements g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = b.b();
      MusciRhythmViewModel.g(MusciRhythmViewModel.this).postValue(paramThrowable);
    }
  }
  
  class g
    implements g<MusicRhythmGlobalConfigBean>
  {
    g() {}
    
    public void a(MusicRhythmGlobalConfigBean paramMusicRhythmGlobalConfigBean)
      throws Exception
    {
      MusciRhythmViewModel.g(MusciRhythmViewModel.this).postValue(paramMusicRhythmGlobalConfigBean);
    }
  }
  
  class h
    implements g<Throwable>
  {
    h() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = new MusicRhythmCryptoResult();
      MusciRhythmViewModel.h(MusciRhythmViewModel.this).postValue(paramThrowable);
    }
  }
  
  class i
    implements g<MusicRhythmCryptoResult>
  {
    i() {}
    
    public void a(MusicRhythmCryptoResult paramMusicRhythmCryptoResult)
      throws Exception
    {
      MusciRhythmViewModel.h(MusciRhythmViewModel.this).postValue(paramMusicRhythmCryptoResult);
    }
  }
  
  class j
    implements g<MusicRhythmCryptoResult>
  {
    j() {}
    
    public void a(MusicRhythmCryptoResult paramMusicRhythmCryptoResult)
      throws Exception
    {
      if ((paramMusicRhythmCryptoResult != null) && (paramMusicRhythmCryptoResult.getKey() != null))
      {
        MusciRhythmViewModel.h(MusciRhythmViewModel.this).postValue(paramMusicRhythmCryptoResult);
        MusciRhythmViewModel.i(MusciRhythmViewModel.this).postValue(Boolean.TRUE);
      }
      else
      {
        MusciRhythmViewModel.i(MusciRhythmViewModel.this).postValue(Boolean.FALSE);
      }
    }
  }
  
  class k
    implements g<Throwable>
  {
    k() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.f("user start", paramThrowable, paramThrowable.toString(), new Object[0]);
      MusciRhythmViewModel.i(MusciRhythmViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class l
    implements g<Boolean>
  {
    l(IoTLightStripDevice paramIoTLightStripDevice) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      MusciRhythmViewModel.f(MusciRhythmViewModel.this).postValue(localIoTLightStripDevice);
    }
  }
  
  class m
    implements g<Throwable>
  {
    m() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = new MusicRhythmSupportModeResult();
      paramThrowable.setMode(b.d());
      MusciRhythmViewModel.j(MusciRhythmViewModel.this).postValue(paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\viewmodel\MusciRhythmViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */