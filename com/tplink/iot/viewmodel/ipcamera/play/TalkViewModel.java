package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.cameranetwork.business.repo.VolumeRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AudioInfo;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TalkViewModel
  extends AndroidViewModel
{
  private String a = TalkViewModel.class.getSimpleName();
  private String b;
  private VolumeRepository c;
  private MediatorLiveData<AudioInfo> d = new MediatorLiveData();
  public final ObservableInt e = new ObservableInt(50);
  public final ObservableInt f = new ObservableInt(50);
  public final ObservableField<String> g = new ObservableField("00:00");
  public final ObservableBoolean h = new ObservableBoolean(false);
  public final ObservableBoolean i = new ObservableBoolean(false);
  public final ObservableBoolean j = new ObservableBoolean(false);
  public final ObservableBoolean k = new ObservableBoolean(false);
  public final ObservableBoolean l = new ObservableBoolean(false);
  public final ObservableBoolean m = new ObservableBoolean(false);
  public final ObservableField<String> n = new ObservableField();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> o = new MutableLiveData();
  private Timer p;
  private long q;
  private long r;
  private String s;
  public final ObservableBoolean t = new ObservableBoolean(false);
  private c u;
  private c v;
  private final b w = new b();
  private DoubleTalkStreamCallback x = new b();
  
  public TalkViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void G(int paramInt)
  {
    com.tplink.iot.Utils.x0.e.e(this.b, paramInt);
  }
  
  private void H(boolean paramBoolean)
  {
    com.tplink.iot.Utils.x0.e.E(this.b, paramBoolean);
  }
  
  private void I(int paramInt)
  {
    com.tplink.iot.Utils.x0.e.g(this.b, paramInt);
  }
  
  private void J(boolean paramBoolean)
  {
    if (this.m.get()) {
      com.tplink.iot.Utils.x0.e.F(this.b, paramBoolean);
    } else {
      com.tplink.iot.Utils.x0.e.z(this.b, paramBoolean);
    }
  }
  
  private void K()
  {
    if (this.r == 0L) {
      return;
    }
    double d1 = (System.currentTimeMillis() - this.r) / 1000.0D;
    com.tplink.iot.Utils.x0.e.A(this.b, d1);
    this.r = 0L;
  }
  
  private void M(String paramString)
  {
    if (paramString != null) {
      paramString = (VolumeRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString, VolumeRepository.class);
    } else {
      paramString = null;
    }
    this.c = paramString;
    if (paramString != null)
    {
      paramString = paramString.t();
      if (this.c.s() != null)
      {
        this.e.set(this.c.u());
        this.e.set(this.c.v());
      }
      this.d.removeSource(paramString);
      MediatorLiveData localMediatorLiveData = this.d;
      localMediatorLiveData.getClass();
      localMediatorLiveData.addSource(paramString, new a3(localMediatorLiveData));
    }
  }
  
  private void T()
  {
    LiveMediaAPI.startSendAudio(this.b);
  }
  
  private void U()
  {
    c localc = this.v;
    if ((localc != null) && (!localc.isDisposed())) {
      this.v.dispose();
    }
    if (!this.m.get()) {
      this.v = q.W0(60L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new e2(this));
    }
  }
  
  private void W()
  {
    if (this.p == null) {
      this.p = new Timer();
    }
    this.p.schedule(new c(), 0L, 1000L);
  }
  
  private void Y()
  {
    c localc = this.v;
    if ((localc != null) && (!localc.isDisposed())) {
      this.v.dispose();
    }
  }
  
  private void n(@StringRes int paramInt)
  {
    this.j.set(false);
    this.k.set(false);
    this.n.set(getApplication().getString(paramInt));
    l(this.b);
    this.o.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
  }
  
  public void L()
  {
    if ((this.b != null) && (!this.t.get()) && (this.c != null))
    {
      c localc = this.u;
      if ((localc != null) && (!localc.isDisposed())) {
        this.u.dispose();
      }
      localc = this.c.J().H0(a2.c, new b2(this));
      this.u = localc;
      this.w.b(localc);
    }
  }
  
  public void N()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((VolumeRepository)localObject).s() != null))
    {
      if (this.c.A(this.e.get()))
      {
        localObject = this.c.K(this.e.get()).H0(new d2(this), new x1(this));
        this.w.b((c)localObject);
        G(this.e.get());
      }
      if (this.c.B(this.f.get()))
      {
        localObject = this.c.L(this.f.get()).H0(new c2(this), new y1(this));
        this.w.b((c)localObject);
        I(this.f.get());
      }
    }
  }
  
  public void O(String paramString)
  {
    this.k.set(false);
    this.b = paramString;
    M(paramString);
    L();
  }
  
  public void P(boolean paramBoolean, String paramString)
  {
    this.i.set(paramBoolean);
    LiveMediaAPI.muteVolume(paramString, paramBoolean);
  }
  
  public void Q(String paramString)
  {
    this.s = paramString;
  }
  
  public void R(long paramLong)
  {
    this.q = paramLong;
  }
  
  public void S(int paramInt1, int paramInt2)
  {
    LiveMediaAPI.setMaxVolume(this.b, paramInt1);
    LiveMediaAPI.setVolume(this.b, paramInt2);
  }
  
  public void V()
  {
    Y();
    if (this.b != null)
    {
      this.r = System.currentTimeMillis();
      LiveMediaAPI.startHoldToTalk(this.b);
      LiveMediaAPI.startSendAudio(this.b);
    }
  }
  
  public void X()
  {
    U();
    if (this.b != null)
    {
      K();
      LiveMediaAPI.stopHoldToTalk(this.b);
      LiveMediaAPI.pauseSendAudio(this.b);
    }
  }
  
  public void Z()
  {
    Timer localTimer = this.p;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.p = null;
    }
  }
  
  public void a0(LifecycleOwner paramLifecycleOwner)
  {
    this.d.observe(paramLifecycleOwner, new z1(this));
    this.e.addOnPropertyChangedCallback(new a());
  }
  
  public void b0()
  {
    boolean bool = this.i.get() ^ true;
    P(bool, this.b);
    J(bool);
  }
  
  public void c0()
  {
    boolean bool = this.h.get();
    LiveMediaAPI.muteRecordAudio(this.b, bool ^ true);
    this.h.set(bool ^ true);
    H(bool ^ true);
  }
  
  public void k(String paramString)
  {
    this.h.set(false);
    this.n.set(null);
    U();
    LiveMediaAPI.addDoubleTalkStreamCallback(this.b, this.x);
    LiveMediaAPI.openDoubleTalkClient(this.b, paramString);
  }
  
  public void l(String paramString)
  {
    if ((this.n.get() == null) && (this.m.get()))
    {
      ObservableField localObservableField = this.n;
      Application localApplication = getApplication();
      int i1;
      if (this.j.get()) {
        i1 = 2131954435;
      } else {
        i1 = 2131954434;
      }
      localObservableField.set(localApplication.getString(i1));
    }
    this.j.set(false);
    LiveMediaAPI.destroyDoubleTalkClient(paramString);
  }
  
  public void m()
  {
    if (this.e.get() == 0)
    {
      this.e.set(60);
      N();
    }
  }
  
  public String o()
  {
    return this.s;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.w.d();
    c localc = this.v;
    if ((localc != null) && (!localc.isDisposed())) {
      this.v.dispose();
    }
  }
  
  public long p()
  {
    return this.q;
  }
  
  class a
    extends Observable.OnPropertyChangedCallback
  {
    a() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      if (TalkViewModel.f(TalkViewModel.this) != null) {
        if (TalkViewModel.this.e.get() == 0)
        {
          if (LiveMediaAPI.lockLiveStreamAudio()) {
            LiveMediaAPI.muteAudio(TalkViewModel.f(TalkViewModel.this), true);
          }
        }
        else if ((LiveMediaAPI.unlockLiveStreamAudio()) && (!TalkViewModel.this.i.get())) {
          LiveMediaAPI.muteAudio(TalkViewModel.f(TalkViewModel.this), false);
        }
      }
    }
  }
  
  class b
    implements DoubleTalkStreamCallback
  {
    b() {}
    
    public void onDoubleTalkClose(String paramString)
    {
      TalkViewModel.g(TalkViewModel.this, 2131954436);
    }
    
    public void onDoubleTalkCreateFailure(String paramString, int paramInt)
    {
      paramString = TalkViewModel.this;
      if (1 == paramInt) {
        paramInt = 2131954444;
      } else {
        paramInt = 2131954436;
      }
      TalkViewModel.g(paramString, paramInt);
    }
    
    public void onDoubleTalkCreateSuccess(String paramString)
    {
      TalkViewModel.this.j.set(true);
      TalkViewModel.this.R(System.currentTimeMillis());
      if (TalkViewModel.this.m.get())
      {
        TalkViewModel.h(TalkViewModel.this);
        TalkViewModel.i(TalkViewModel.this);
        if (TalkViewModel.this.i.get())
        {
          LiveMediaAPI.muteVolume(paramString, false);
          TalkViewModel.this.i.set(false);
        }
      }
    }
    
    public void onDoubleTalkSendDataFailure(String paramString, int paramInt, Exception paramException)
    {
      TalkViewModel.g(TalkViewModel.this, 2131954436);
    }
  }
  
  class c
    extends TimerTask
  {
    c() {}
    
    public void run()
    {
      long l = (System.currentTimeMillis() - TalkViewModel.j(TalkViewModel.this)) / 1000L;
      TalkViewModel.this.g.set(String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Long.valueOf(l / 60L % 60L), Long.valueOf(l % 60L) }));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\TalkViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */