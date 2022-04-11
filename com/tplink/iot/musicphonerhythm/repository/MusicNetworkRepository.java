package com.tplink.iot.musicphonerhythm.repository;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingPropertySpec;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmCryptoResult;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmModeConfigParams;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmModeResult;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmSupportModeResult;
import com.tplink.libtpnetwork.IoTNetwork.EnumIoTTransportType;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.result.LightStripDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.x;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.t;
import java.util.ArrayList;

public class MusicNetworkRepository
  extends AbstractThingRepository
{
  public MusicNetworkRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTLightStripDevice.class, LightStripDeviceRunningInfoResult.class);
    paramThingContext = (ALIoTDevice)paramThingContext.getIoTDevice();
    if ((paramThingContext != null) && ((paramThingContext.getLocalIoTDevice() instanceof IoTLightStripDevice)))
    {
      paramThingContext = (IoTLightStripDevice)paramThingContext.getLocalIoTDevice();
      this.n.postValue(paramThingContext);
    }
    else
    {
      this.n.postValue(new IoTLightStripDevice());
    }
  }
  
  private <T, R> q<R> L5(String paramString, T paramT, Class<R> paramClass)
  {
    return y0(paramString, paramT, paramClass).v0(1L, new e());
  }
  
  public q<Boolean> M5(final MusicRhythmGlobalConfigBean paramMusicRhythmGlobalConfigBean)
  {
    return L5("set_music_rhythm_global_config", paramMusicRhythmGlobalConfigBean, Boolean.class).o0(new j(paramMusicRhythmGlobalConfigBean));
  }
  
  public q<Boolean> N5(MusicRhythmModeResult paramMusicRhythmModeResult)
  {
    return L5("set_music_rhythm_mode", paramMusicRhythmModeResult, Boolean.class).o0(new b(this, paramMusicRhythmModeResult));
  }
  
  public q<Boolean> O5(MusicRhythmModeConfigParams paramMusicRhythmModeConfigParams)
  {
    return L5("set_music_rhythm_mode_config", paramMusicRhythmModeConfigParams, Boolean.class).o0(f.c);
  }
  
  @SuppressLint({"CheckResult"})
  public q<Boolean> P5()
  {
    return L5("start_music_rhythm", null, Boolean.class).o0(new a(this));
  }
  
  public q<Boolean> Q5()
  {
    return L5("stop_music_rhythm", null, Boolean.class).o0(new k(this));
  }
  
  public LiveData<IoTLightStripDevice> n5()
  {
    return Transformations.map(super.j1(), new d());
  }
  
  public void o5()
  {
    k1().F0();
  }
  
  public q<MusicRhythmCryptoResult> p5()
  {
    return L5("get_music_rhythm_crypto", null, com.google.gson.i.class).g0(new g()).o0(new f());
  }
  
  public q<MusicRhythmGlobalConfigBean> q5()
  {
    return L5("get_music_rhythm_global_config", null, com.google.gson.i.class).g0(new c()).o0(new b());
  }
  
  public q<MusicRhythmModeResult> r5()
  {
    return L5("get_music_rhythm_mode", null, com.google.gson.i.class).g0(new m()).o0(new j(this));
  }
  
  public q<MusicRhythmSupportModeResult> s5()
  {
    return L5("get_support_music_rhythm_modes", null, com.google.gson.i.class).g0(new l()).o0(new k());
  }
  
  class a
    implements io.reactivex.g0.j<DeviceRunningInfoResult, MusicRhythmModeResult>
  {
    a() {}
    
    public MusicRhythmModeResult a(@NonNull DeviceRunningInfoResult paramDeviceRunningInfoResult)
      throws Exception
    {
      paramDeviceRunningInfoResult = (LightStripDeviceRunningInfoResult)paramDeviceRunningInfoResult;
      b.d.w.c.a.c("user", paramDeviceRunningInfoResult.getMusicRhythmMode());
      return new MusicRhythmModeResult(paramDeviceRunningInfoResult.getMusicRhythmMode());
    }
  }
  
  class b
    implements io.reactivex.g0.j<Throwable, q<MusicRhythmGlobalConfigBean>>
  {
    b() {}
    
    public q<MusicRhythmGlobalConfigBean> a(Throwable paramThrowable)
      throws Exception
    {
      if (MusicNetworkRepository.l5(MusicNetworkRepository.this, paramThrowable)) {
        return MusicNetworkRepository.m5(MusicNetworkRepository.this, EnumFeatureType.MUSIC_RHYTHM_GLOBAL_CONFIG.getName()).g0(new a());
      }
      return q.J(paramThrowable);
    }
    
    class a
      implements io.reactivex.g0.j<com.google.gson.i, MusicRhythmGlobalConfigBean>
    {
      a() {}
      
      public MusicRhythmGlobalConfigBean a(com.google.gson.i parami)
        throws Exception
      {
        b.d.w.c.a.c("Music Rhythm user", parami.toString());
        return (MusicRhythmGlobalConfigBean)com.tplink.libtpnetwork.Utils.i.a(parami, MusicRhythmGlobalConfigBean.class);
      }
    }
  }
  
  class c
    implements io.reactivex.g0.j<com.google.gson.i, MusicRhythmGlobalConfigBean>
  {
    c() {}
    
    public MusicRhythmGlobalConfigBean a(com.google.gson.i parami)
      throws Exception
    {
      return (MusicRhythmGlobalConfigBean)com.tplink.libtpnetwork.Utils.i.a(parami, MusicRhythmGlobalConfigBean.class);
    }
  }
  
  class d
    implements Function<LocalIoTBaseDevice, IoTLightStripDevice>
  {
    d() {}
    
    public IoTLightStripDevice a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      if ((paramLocalIoTBaseDevice instanceof IoTLightStripDevice)) {
        return (IoTLightStripDevice)paramLocalIoTBaseDevice;
      }
      return new IoTLightStripDevice();
    }
  }
  
  class e
    implements l<Throwable>
  {
    e() {}
    
    public boolean a(@NonNull Throwable paramThrowable)
      throws Exception
    {
      if (((paramThrowable instanceof IoTTransportException)) && (MusicNetworkRepository.e5(MusicNetworkRepository.this) != null))
      {
        MusicNetworkRepository.f5(MusicNetworkRepository.this).p(EnumIoTTransportType.HTTP, true);
        return true;
      }
      return false;
    }
  }
  
  class f
    implements io.reactivex.g0.j<Throwable, t<MusicRhythmCryptoResult>>
  {
    f() {}
    
    public t<MusicRhythmCryptoResult> a(Throwable paramThrowable)
      throws Exception
    {
      if (MusicNetworkRepository.g5(MusicNetworkRepository.this, paramThrowable)) {
        return MusicNetworkRepository.h5(MusicNetworkRepository.this, EnumFeatureType.MUSIC_RHYTHM_CRYPTO.getName()).g0(new b()).C(new a());
      }
      return q.J(paramThrowable);
    }
    
    class a
      implements io.reactivex.g0.g<Throwable>
    {
      a() {}
      
      public void a(Throwable paramThrowable)
        throws Exception
      {
        b.d.w.c.a.c("Music Rhythm user", paramThrowable.getLocalizedMessage());
      }
    }
    
    class b
      implements io.reactivex.g0.j<com.google.gson.i, MusicRhythmCryptoResult>
    {
      b() {}
      
      public MusicRhythmCryptoResult a(com.google.gson.i parami)
        throws Exception
      {
        b.d.w.c.a.c("Music Rhythm user", parami.toString());
        return (MusicRhythmCryptoResult)com.tplink.libtpnetwork.Utils.i.a(parami, MusicRhythmCryptoResult.class);
      }
    }
  }
  
  class g
    implements io.reactivex.g0.j<com.google.gson.i, MusicRhythmCryptoResult>
  {
    g() {}
    
    public MusicRhythmCryptoResult a(com.google.gson.i parami)
      throws Exception
    {
      return (MusicRhythmCryptoResult)com.tplink.libtpnetwork.Utils.i.a(parami, MusicRhythmCryptoResult.class);
    }
  }
  
  class h
    implements io.reactivex.g0.a
  {
    h(r paramr) {}
    
    public void run()
      throws Exception
    {
      this.a.onNext(Boolean.TRUE);
    }
  }
  
  class i
    implements io.reactivex.g0.a
  {
    i(r paramr) {}
    
    public void run()
      throws Exception
    {
      this.a.onNext(Boolean.TRUE);
    }
  }
  
  class j
    implements io.reactivex.g0.j<Throwable, t<Boolean>>
  {
    j(MusicRhythmGlobalConfigBean paramMusicRhythmGlobalConfigBean) {}
    
    public t<Boolean> a(Throwable paramThrowable)
      throws Exception
    {
      if (MusicNetworkRepository.i5(MusicNetworkRepository.this, paramThrowable)) {
        return MusicNetworkRepository.j5(MusicNetworkRepository.this, EnumFeatureType.MUSIC_RHYTHM_GLOBAL_CONFIG.getName(), paramMusicRhythmGlobalConfigBean).g0(new a()).q0(Boolean.FALSE);
      }
      return q.J(paramThrowable);
    }
    
    class a
      implements io.reactivex.g0.j<com.google.gson.i, Boolean>
    {
      a() {}
      
      public Boolean a(com.google.gson.i parami)
        throws Exception
      {
        b.d.w.c.a.b("Music Rhythm user", parami);
        return Boolean.TRUE;
      }
    }
  }
  
  class k
    implements io.reactivex.g0.j<Throwable, t<MusicRhythmSupportModeResult>>
  {
    k() {}
    
    public t<MusicRhythmSupportModeResult> a(@NonNull Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = ((ThingContext)MusicNetworkRepository.k5(MusicNetworkRepository.this)).getThingModel().getThingProperty("music_rhythm_mode");
      if (paramThrowable != null)
      {
        b.d.w.c.a.b("user", paramThrowable.getSpecs().getValues());
        return q.f0(new MusicRhythmSupportModeResult(new ArrayList(paramThrowable.getSpecs().getValues())));
      }
      return q.f0(new MusicRhythmSupportModeResult());
    }
  }
  
  class l
    implements io.reactivex.g0.j<com.google.gson.i, MusicRhythmSupportModeResult>
  {
    l() {}
    
    public MusicRhythmSupportModeResult a(com.google.gson.i parami)
      throws Exception
    {
      return (MusicRhythmSupportModeResult)com.tplink.libtpnetwork.Utils.i.a(parami, MusicRhythmSupportModeResult.class);
    }
  }
  
  class m
    implements io.reactivex.g0.j<com.google.gson.i, MusicRhythmModeResult>
  {
    m() {}
    
    public MusicRhythmModeResult a(com.google.gson.i parami)
      throws Exception
    {
      return (MusicRhythmModeResult)com.tplink.libtpnetwork.Utils.i.a(parami, MusicRhythmModeResult.class);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\repository\MusicNetworkRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */