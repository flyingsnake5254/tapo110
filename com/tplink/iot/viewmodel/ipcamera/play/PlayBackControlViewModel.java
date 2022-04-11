package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.Utils.s;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.libmediaapi.common.apicallback.VodStreamDisplayCallback;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.j;
import com.tplink.libtpnetwork.cameranetwork.business.model.k;
import com.tplink.libtpnetwork.cameranetwork.business.model.l;
import com.tplink.libtpnetwork.cameranetwork.business.model.m;
import com.tplink.libtpnetwork.cameranetwork.business.model.n;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.PlayBackRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class PlayBackControlViewModel
  extends AndroidViewModel
  implements VodStreamDisplayCallback
{
  private final MediatorLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Long>> H3 = new MediatorLiveData();
  private final MediatorLiveData<List<j>> I3 = new MediatorLiveData();
  private final MediatorLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> J3 = new MediatorLiveData();
  private final PlayBackRepository K3;
  private String L3;
  private PlaybackMainViewModel M3;
  private boolean N3 = false;
  public ObservableField<String> O3 = new ObservableField();
  public long P3;
  public ObservableField<String> Q3 = new ObservableField();
  public ObservableBoolean R3 = new ObservableBoolean(true);
  public ObservableBoolean S3 = new ObservableBoolean(true);
  public ObservableBoolean T3 = new ObservableBoolean(false);
  public ObservableBoolean U3 = new ObservableBoolean(false);
  public ObservableBoolean V3 = new ObservableBoolean(false);
  public ObservableBoolean W3 = new ObservableBoolean(true);
  public ObservableBoolean X3 = new ObservableBoolean(false);
  public final MutableLiveData<Boolean> Y3 = new MutableLiveData(Boolean.FALSE);
  public final ObservableBoolean Z3 = new ObservableBoolean(true);
  public ObservableBoolean a4 = new ObservableBoolean(false);
  public ObservableBoolean b4 = new ObservableBoolean(true);
  private final String c = "PlayBackControlViewModel";
  public ObservableBoolean c4 = new ObservableBoolean(true);
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> d = new MutableLiveData();
  public ObservableBoolean d4 = new ObservableBoolean(true);
  public ObservableField<d> e4 = new ObservableField();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f = new MutableLiveData();
  public ObservableField<List<d>> f4 = new ObservableField();
  public ObservableField<d> g4 = new ObservableField();
  public ObservableField<Calendar> h4 = new ObservableField();
  public ObservableField<d> i4 = new ObservableField();
  public ObservableFloat j4 = new ObservableFloat();
  public ObservableInt k4 = new ObservableInt();
  public ObservableField<Pair<ArrayList<int[]>, ArrayList<int[]>>> l4 = new ObservableField();
  public ObservableField<List<ArrayList<int[]>>> m4 = new ObservableField();
  public ObservableBoolean n4 = new ObservableBoolean(false);
  public ObservableInt o4 = new ObservableInt();
  private final Set<Integer> p0 = new HashSet();
  private final MediatorLiveData<List<Integer>> p1 = new MediatorLiveData();
  private final MediatorLiveData<m> p2 = new MediatorLiveData();
  private final MediatorLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<l>> p3 = new MediatorLiveData();
  public ObservableInt p4 = new ObservableInt();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> q = new MutableLiveData();
  public ObservableBoolean q4 = new ObservableBoolean(false);
  public ObservableField<VodPlayRate> r4;
  public ObservableField<String> s4;
  public VodPlayRate t4;
  private b u4 = new b();
  private CommonCameraRepository v4;
  private final MediatorLiveData<Boolean> x = new MediatorLiveData();
  private final MediatorLiveData<Boolean> y = new MediatorLiveData();
  private final MediatorLiveData<List<com.tplink.iot.j.c.a>> z = new MediatorLiveData();
  
  public PlayBackControlViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    J();
    this.K3 = ((PlayBackRepository)e.b(paramTPCameraDeviceContext, PlayBackRepository.class));
    j0();
  }
  
  private List<Integer> i()
  {
    return new ArrayList(this.p0);
  }
  
  private void j0()
  {
    this.p0.clear();
    this.x.removeSource(this.K3.Z());
    Object localObject1 = this.x;
    Object localObject2 = this.K3.Z();
    Object localObject3 = this.x;
    localObject3.getClass();
    ((MediatorLiveData)localObject1).addSource((LiveData)localObject2, new y2((MediatorLiveData)localObject3));
    this.y.removeSource(this.K3.f0());
    localObject3 = this.y;
    localObject2 = this.K3.f0();
    localObject1 = this.y;
    localObject1.getClass();
    ((MediatorLiveData)localObject3).addSource((LiveData)localObject2, new y2((MediatorLiveData)localObject1));
    this.p2.removeSource(this.K3.a0());
    localObject1 = this.p2;
    localObject3 = this.K3.a0();
    localObject2 = this.p2;
    localObject2.getClass();
    ((MediatorLiveData)localObject1).addSource((LiveData)localObject3, new u2((MediatorLiveData)localObject2));
    this.p3.removeSource(this.K3.c0());
    localObject3 = this.p3;
    localObject1 = this.K3.c0();
    localObject2 = this.p3;
    localObject2.getClass();
    ((MediatorLiveData)localObject3).addSource((LiveData)localObject1, new x2((MediatorLiveData)localObject2));
    this.H3.removeSource(this.K3.b0());
    localObject3 = this.H3;
    localObject1 = this.K3.b0();
    localObject2 = this.H3;
    localObject2.getClass();
    ((MediatorLiveData)localObject3).addSource((LiveData)localObject1, new x2((MediatorLiveData)localObject2));
    this.I3.removeSource(this.K3.e0());
    localObject2 = this.I3;
    localObject3 = this.K3.e0();
    localObject1 = this.I3;
    localObject1.getClass();
    ((MediatorLiveData)localObject2).addSource((LiveData)localObject3, new a1((MediatorLiveData)localObject1));
    this.J3.removeSource(this.K3.d0());
    localObject2 = this.J3;
    localObject1 = this.K3.d0();
    localObject3 = this.J3;
    localObject3.getClass();
    ((MediatorLiveData)localObject2).addSource((LiveData)localObject1, new x2((MediatorLiveData)localObject3));
    this.z.removeSource(this.K3.g0());
    this.z.addSource(this.K3.g0(), new g1(this));
  }
  
  private void k0(n paramn)
  {
    q.f0(paramn).L0(io.reactivex.l0.a.c()).E(new l1(this)).C(w2.c).F0();
  }
  
  private q<Boolean> p0(CameraComponent paramCameraComponent)
  {
    if (paramCameraComponent.isSupportSnapshot()) {
      return this.K3.b2();
    }
    this.X3.set(false);
    paramCameraComponent = this.Y3;
    Boolean localBoolean = Boolean.FALSE;
    paramCameraComponent.postValue(localBoolean);
    return q.f0(localBoolean);
  }
  
  public MutableLiveData<List<com.tplink.iot.j.c.a>> A()
  {
    return this.z;
  }
  
  public void A0(Calendar paramCalendar)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(o());
    E0((Calendar)localObject);
    boolean bool = q0.e(((Calendar)localObject).getTime(), paramCalendar.getTime());
    this.R3.set(bool);
    this.T3.set(bool ^ true);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    localObject = this.Q3;
    if (bool) {
      paramCalendar = getApplication().getString(2131953360);
    } else {
      paramCalendar = localSimpleDateFormat.format(paramCalendar.getTime());
    }
    ((ObservableField)localObject).set(paramCalendar);
  }
  
  public int B(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    E0(localCalendar);
    return localCalendar.get(11) * 3600 + localCalendar.get(12) * 60 + localCalendar.get(13);
  }
  
  public void B0(Calendar paramCalendar)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(o());
    E0((Calendar)localObject);
    boolean bool = q0.h(((Calendar)localObject).getTime(), paramCalendar.getTime());
    this.S3.set(bool);
    this.T3.set(bool ^ true);
    localObject = new SimpleDateFormat("yyyy-MM", Locale.US);
    this.Q3.set(((SimpleDateFormat)localObject).format(paramCalendar.getTime()));
  }
  
  public Calendar C()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      return localPlayBackRepository.j0();
    }
    return Calendar.getInstance();
  }
  
  public void C0(LifecycleOwner paramLifecycleOwner) {}
  
  public MutableLiveData<List<Integer>> D()
  {
    return this.p1;
  }
  
  public void D0()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      A0(localPlayBackRepository.K());
    }
  }
  
  public void E()
  {
    if (this.K3 != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(o());
      E0(localCalendar);
      u0(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5));
      if (this.K3.s(localCalendar.getTime())) {
        this.x.postValue(Boolean.TRUE);
      } else {
        this.x.postValue(Boolean.FALSE);
      }
      n0();
    }
  }
  
  public void E0(Calendar paramCalendar)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.O1(paramCalendar);
    }
  }
  
  public void F()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null)
    {
      localPlayBackRepository.K().add(5, 1);
      A0(this.K3.K());
      n0();
    }
  }
  
  public void G()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null)
    {
      localPlayBackRepository.j0().add(2, 1);
      this.i4.set(new d(this.K3.j0().get(1), this.K3.j0().get(2) + 1, 1));
      this.q.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.valueOf(q0.g(this.K3.j0(), this.K3.K()))));
      B0(this.K3.j0());
      o0(this.K3.j0().getTimeInMillis());
    }
  }
  
  public void H()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null)
    {
      localPlayBackRepository.K().add(5, -1);
      A0(this.K3.K());
      n0();
    }
  }
  
  public void I()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null)
    {
      localPlayBackRepository.j0().add(2, -1);
      this.i4.set(new d(this.K3.j0().get(1), this.K3.j0().get(2) + 1, 1));
      this.q.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.valueOf(q0.g(this.K3.j0(), this.K3.K()))));
      B0(this.K3.j0());
      o0(this.K3.j0().getTimeInMillis());
    }
  }
  
  public void J()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.q0();
    }
    this.Q3.set(getApplication().getString(2131953360));
    this.P3 = System.currentTimeMillis();
  }
  
  public void K(PlaybackMainViewModel paramPlaybackMainViewModel)
  {
    String str = paramPlaybackMainViewModel.e;
    this.L3 = str;
    this.v4 = ((CommonCameraRepository)e.c(str, CommonCameraRepository.class));
    this.M3 = paramPlaybackMainViewModel;
  }
  
  public void L()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.r0();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null)
    {
      localPlayBackRepository.j0().setTimeInMillis(this.K3.K().getTimeInMillis());
      if (paramBoolean)
      {
        B0(this.K3.j0());
      }
      else
      {
        A0(this.K3.j0());
        o0(this.K3.K().getTimeInMillis());
      }
      this.q.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.valueOf(q0.g(this.K3.j0(), this.K3.K()))));
    }
  }
  
  public void g(String paramString1, String paramString2, ObservableField<VodPlayRate> paramObservableField, ObservableField<String> paramObservableField1, VodPlayRate paramVodPlayRate)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentTimestamp ");
    localStringBuilder.append(this.P3);
    b.d.w.c.a.c("PlayBackControlViewModel", localStringBuilder.toString());
    this.r4 = paramObservableField;
    this.s4 = paramObservableField1;
    this.t4 = paramVodPlayRate;
    VodMediaAPI.changeVodPlayRate(paramString1, paramString2, this.P3 / 1000L);
  }
  
  public boolean h(long paramLong)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      return localPlayBackRepository.w(paramLong, this.a4.get(), this.c4.get());
    }
    return false;
  }
  
  public boolean h0(long paramLong)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      return localPlayBackRepository.N1(paramLong);
    }
    return false;
  }
  
  public int i0(long paramLong)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      return localPlayBackRepository.Q1(paramLong);
    }
    return 0;
  }
  
  public void j()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.F(this.a4.get(), this.c4.get());
    }
  }
  
  public long k()
  {
    long l = System.currentTimeMillis();
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      l = localPlayBackRepository.J();
    }
    return l;
  }
  
  public Calendar l()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      return localPlayBackRepository.K();
    }
    return Calendar.getInstance();
  }
  
  public void l0()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.R1();
    }
  }
  
  public int m(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    E0(localCalendar);
    return localCalendar.get(6) - l().get(6);
  }
  
  public void m0(long paramLong)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.S1(paramLong);
    }
  }
  
  public TimeZone n()
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      return localPlayBackRepository.R();
    }
    return null;
  }
  
  public void n0()
  {
    this.W3.set(true);
    this.V3.set(false);
    this.U3.set(false);
    if (this.K3 != null)
    {
      int i = l().get(1);
      int j = l().get(2);
      int k = l().get(5);
      this.g4.set(new d(i, j + 1, k));
    }
    if (this.K3 != null)
    {
      this.Z3.set(true);
      this.v4.K0().N(new j1(this)).F(new m1(this)).C(w2.c).y(new i1(this)).L0(io.reactivex.l0.a.c()).F0();
    }
    else
    {
      this.p3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new l(-1, -1L, null)));
    }
  }
  
  public long o()
  {
    long l = System.currentTimeMillis();
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      l = localPlayBackRepository.W();
    }
    return l;
  }
  
  public void o0(long paramLong)
  {
    c localc = this.K3.Y1(paramLong).C(new h1(this)).F0();
    this.u4.b(localc);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.u4.dispose();
  }
  
  public MutableLiveData<Boolean> p()
  {
    return this.x;
  }
  
  public void q0(long paramLong)
  {
    r0(paramLong, 0L);
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> r()
  {
    return this.q;
  }
  
  public void r0(long paramLong1, long paramLong2)
  {
    this.Z3.set(true);
    long l1 = paramLong2;
    if (paramLong2 > 0L)
    {
      l1 = paramLong2;
      if (paramLong1 >= paramLong2)
      {
        long l2 = paramLong1 / 1000L;
        l1 = paramLong2;
        if (l2 - paramLong2 > 252288000L) {
          l1 = l2 - 252288000L;
        }
      }
    }
    c localc = this.v4.K0().N(new e1(this, paramLong1, l1)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).N(new b1(this)).y(new f1(this)).F0();
    this.u4.b(localc);
  }
  
  public MutableLiveData<m> s()
  {
    return this.p2;
  }
  
  public void s0(int paramInt, boolean paramBoolean)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.f2(paramInt, paramBoolean, this.a4.get(), this.c4.get());
    }
  }
  
  public void showDisplayProgress(long paramLong)
  {
    if (this.N3) {
      return;
    }
    if (VodMediaAPI.isFlushing(this.L3)) {
      return;
    }
    v0(paramLong);
    int i = B(paramLong / 1000L);
    int j = i0(paramLong);
    this.d.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(i + j)));
    if (h(paramLong))
    {
      b.d.w.c.a.c("TTTT", "get last");
      this.f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.i2(paramLong);
    }
    if (this.n4.get()) {
      this.q4.set(h0(paramLong));
    } else {
      this.q4.set(false);
    }
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Long>> t()
  {
    return this.H3;
  }
  
  public void t0(long paramLong)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null) {
      localPlayBackRepository.g2(paramLong, this.a4.get(), this.c4.get());
    }
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<l>> u()
  {
    return this.p3;
  }
  
  public void u0(int paramInt1, int paramInt2, int paramInt3)
  {
    PlayBackRepository localPlayBackRepository = this.K3;
    if (localPlayBackRepository != null)
    {
      localPlayBackRepository.h2(paramInt1, paramInt2, paramInt3);
      A0(this.K3.K());
    }
  }
  
  public MediatorLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> v()
  {
    return this.J3;
  }
  
  public void v0(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    E0(localCalendar);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
    this.O3.set(localSimpleDateFormat.format(localCalendar.getTime()));
    this.P3 = paramLong;
  }
  
  public void vodPlayRate(boolean paramBoolean, float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play rate success ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" rate ");
    ((StringBuilder)localObject).append(paramFloat);
    b.d.w.c.a.c("PlayBackControlViewModel", ((StringBuilder)localObject).toString());
    if (!paramBoolean)
    {
      localObject = this.r4;
      if ((localObject != null) && (this.s4 != null))
      {
        VodPlayRate localVodPlayRate = this.t4;
        if (localVodPlayRate != null)
        {
          ((ObservableField)localObject).set(localVodPlayRate);
          this.s4.set(this.t4.getValue());
        }
      }
      localObject = this.M3;
      if (localObject != null) {
        ((PlaybackMainViewModel)localObject).y(getApplication().getString(2131952741));
      }
    }
    this.r4 = null;
    this.s4 = null;
    this.t4 = null;
  }
  
  public void vodSeekTime(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seek time success ");
    localStringBuilder.append(paramBoolean);
    b.d.w.c.a.c("PlayBackControlViewModel", localStringBuilder.toString());
    if (!paramBoolean) {
      this.M3.m.set(true);
    }
  }
  
  public MutableLiveData<List<j>> w()
  {
    return this.I3;
  }
  
  public void w0(List<Integer> paramList)
  {
    this.p0.clear();
    if (!s.b(paramList)) {
      this.p0.addAll(paramList);
    }
    this.p1.postValue(i());
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> x()
  {
    return this.f;
  }
  
  public void x0()
  {
    VodMediaAPI.setVodStreamDisplayCallback(this.L3, this);
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> y()
  {
    return this.d;
  }
  
  public void y0(int paramInt, boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.K3.K().get(1));
    localCalendar.set(2, this.K3.K().get(2));
    localCalendar.set(5, this.K3.K().get(5));
    localCalendar.set(11, paramInt / 3600);
    localCalendar.set(12, paramInt % 3600 / 60);
    localCalendar.set(13, paramInt % 60);
    if (this.K3.R() != null) {
      localCalendar.setTimeZone(this.K3.R());
    }
    if (paramBoolean) {
      localCalendar.add(11, -(this.K3.Y().k() / 3600000));
    }
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    paramInt = localCalendar.get(13);
    this.O3.set(String.format(Locale.US, "%02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) }));
    if (this.n4.get())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localCalendar.getTimeInMillis());
      localStringBuilder.append("");
      b.d.w.c.a.e("time:", localStringBuilder.toString());
      this.q4.set(h0(localCalendar.getTimeInMillis()));
    }
    else
    {
      this.q4.set(false);
    }
  }
  
  public MutableLiveData<Boolean> z()
  {
    return this.y;
  }
  
  public void z0(boolean paramBoolean)
  {
    this.N3 = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\PlayBackControlViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */