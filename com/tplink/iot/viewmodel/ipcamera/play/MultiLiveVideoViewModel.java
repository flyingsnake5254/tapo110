package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import b.d.q.b.m;
import com.tplink.iot.Utils.e0;
import com.tplink.iot.Utils.e0.f;
import com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LiveVideoRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.NightVisionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MultiLiveVideoViewModel
  extends AndroidViewModel
  implements LifecycleObserver
{
  private static final String c = "MultiLiveVideoViewModel";
  private int H3 = 0;
  public final ObservableBoolean I3 = new ObservableBoolean(false);
  public final ObservableBoolean J3 = new ObservableBoolean(false);
  private c K3;
  private boolean L3 = o.h0().c("multi_live_debut", true);
  private MutableLiveData<Boolean> M3;
  public final ObservableBoolean N3 = new ObservableBoolean(true);
  public final ObservableBoolean O3 = new ObservableBoolean(false);
  public final ObservableBoolean P3 = new ObservableBoolean(false);
  public ObservableBoolean Q3 = new ObservableBoolean(false);
  private MediatorLiveData<NightMode> R3 = new MediatorLiveData();
  private c S3;
  private NightMode T3 = NightMode.AUTO;
  public final ObservableBoolean U3 = new ObservableBoolean(false);
  private c V3;
  private NightVisionRepository W3;
  public final ObservableBoolean X3 = new ObservableBoolean(false);
  public final ObservableBoolean Y3 = new ObservableBoolean(false);
  public final MutableLiveData<String> Z3 = new MutableLiveData();
  public final ObservableBoolean a4 = new ObservableBoolean(false);
  private BitStreamType b4 = BitStreamType.MINOR_VGA;
  private Map<String, Integer> c4 = new HashMap();
  private final String d = "multi_live_debut";
  private boolean d4 = o.h0().c("VideoQualityTip", false);
  public final ObservableBoolean e4 = new ObservableBoolean(false);
  private boolean f = false;
  public final ObservableField<String> f4 = new ObservableField();
  private Observable.OnPropertyChangedCallback g4 = new a();
  private long h4 = 0L;
  private long i4 = 0L;
  public final ObservableBoolean j4 = new ObservableBoolean(true);
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> k4 = new MutableLiveData();
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Bitmap>> l4 = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> m4 = new MutableLiveData();
  private io.reactivex.e0.b n4 = new io.reactivex.e0.b();
  private c o4;
  public final ObservableBoolean p0 = new ObservableBoolean(false);
  public final MutableLiveData<Boolean> p1 = new MutableLiveData();
  private final MediatorLiveData<Boolean> p2 = new MediatorLiveData();
  public int p3 = 0;
  private Observer<Boolean> p4 = i0.a;
  @Nullable
  private String q;
  private VideoPlayViewModel q4;
  private LiveVideoRepository r4;
  private SimpleStreamDisplayCallback s4 = new b();
  public int x = 1;
  public MutableLiveData<Integer> y = new MutableLiveData();
  public final ArrayList<String> z = new ArrayList(32);
  
  public MultiLiveVideoViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void A0()
  {
    if (LiveMediaAPI.isPlayingProperly(this.q))
    {
      LiveMediaAPI.startRecord(this.q);
      this.e4.set(true);
      D0();
      this.f4.set(m.a(0L));
    }
  }
  
  private void B0()
  {
    LiveMediaAPI.stopRecord(this.q);
    q0(this.q);
  }
  
  private void D0()
  {
    Object localObject = this.q;
    int i;
    if ((localObject != null) && (LiveMediaAPI.isRecording((String)localObject))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      this.f4.set(null);
      return;
    }
    localObject = LiveMediaAPI.getRecordDuration(this.q);
    if (localObject != null) {
      ((BaseObservable)localObject).addOnPropertyChangedCallback(this.g4);
    }
  }
  
  private void F0(NightMode paramNightMode)
  {
    this.T3 = paramNightMode;
    if (NightMode.DAY == paramNightMode)
    {
      this.N3.set(false);
      this.P3.set(true);
      this.O3.set(false);
    }
    else if (NightMode.NIGHT == paramNightMode)
    {
      this.N3.set(false);
      this.P3.set(false);
      this.O3.set(true);
    }
    else
    {
      this.N3.set(true);
      this.P3.set(false);
      this.O3.set(false);
    }
  }
  
  private void G()
  {
    String str = this.q;
    if (str == null) {
      return;
    }
    b.d.d.e.a.a(str, new y0(this));
  }
  
  private void G0(BitStreamType paramBitStreamType)
  {
    this.b4 = paramBitStreamType;
    if (BitStreamType.MAIN_HD.equals(paramBitStreamType))
    {
      this.X3.set(true);
      this.Y3.set(false);
    }
    else
    {
      this.Y3.set(true);
      this.X3.set(false);
    }
  }
  
  private void H()
  {
    Object localObject = this.e4;
    String str = this.q;
    boolean bool;
    if ((str != null) && (LiveMediaAPI.isRecording(str))) {
      bool = true;
    } else {
      bool = false;
    }
    ((ObservableBoolean)localObject).set(bool);
    localObject = this.f4;
    str = this.q;
    if (str == null) {
      str = "";
    } else {
      str = m.a(LiveMediaAPI.getRecordDuration(str).get());
    }
    ((ObservableField)localObject).set(str);
    D0();
  }
  
  private void I0()
  {
    if (this.q != null)
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceIdMD5: ");
      localStringBuilder.append(this.q);
      localStringBuilder.append(" unRegisterStreamDisplayCallback");
      b.d.w.c.a.c(str, localStringBuilder.toString());
      LiveMediaAPI.removeSteamDisplayCommonCallback(this.q, this.s4);
    }
  }
  
  private boolean h0()
  {
    com.tplink.libtpnetwork.Utils.f0.a locala = new com.tplink.libtpnetwork.Utils.f0.a(Boolean.FALSE);
    l.e(this.q, new w0(locala));
    return ((Boolean)locala.a).booleanValue();
  }
  
  private void i0()
  {
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    localObject = (LiveVideoRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c((String)localObject, LiveVideoRepository.class);
    this.r4 = ((LiveVideoRepository)localObject);
    localObject = ((LiveVideoRepository)localObject).s();
    this.R3.removeSource((LiveData)localObject);
    MediatorLiveData localMediatorLiveData = this.R3;
    localMediatorLiveData.getClass();
    localMediatorLiveData.addSource((LiveData)localObject, new r1(localMediatorLiveData));
  }
  
  private void l0(@StringRes int paramInt)
  {
    this.q4.u(getApplication().getString(paramInt));
  }
  
  private void m0()
  {
    Object localObject = this.S3;
    if ((localObject != null) && (!((c)localObject).isDisposed())) {
      this.S3.dispose();
    }
    localObject = this.q;
    if (localObject == null) {
      return;
    }
    localObject = TPIoTClientManager.K1((String)localObject);
    if ((localObject != null) && (((TPBaseDeviceContext)localObject).getCameraDevice() != null))
    {
      i0();
      localObject = this.r4.E().l0(io.reactivex.d0.b.a.a()).G0(v0.c);
      this.S3 = ((c)localObject);
      this.n4.b((c)localObject);
      if (TextUtils.isEmpty(this.r4.t())) {
        this.n4.b(this.r4.F().E(new p0(this)).F0());
      } else {
        this.Z3.setValue(this.r4.t());
      }
    }
  }
  
  private void n0()
  {
    Object localObject = this.V3;
    if ((localObject != null) && (!((c)localObject).isDisposed())) {
      this.V3.dispose();
    }
    localObject = this.q;
    if (localObject == null) {
      return;
    }
    localObject = TPIoTClientManager.K1((String)localObject);
    if ((localObject != null) && (((TPBaseDeviceContext)localObject).getCameraDevice() != null)) {
      this.V3 = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.q, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).N(new z0(this)).E(new s0(this)).l0(io.reactivex.d0.b.a.a()).F0();
    }
  }
  
  private void q0(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = LiveMediaAPI.getRecordDuration(paramString);
    if (paramString != null) {
      paramString.removeOnPropertyChangedCallback(this.g4);
    }
  }
  
  private void r0(BitStreamType paramBitStreamType)
  {
    b.d.d.e.a.c(this.q, paramBitStreamType);
  }
  
  private void u0(String paramString)
  {
    if (!d0.a(this.q, paramString))
    {
      boolean bool1 = false;
      if (paramString == null) {
        this.I3.set(false);
      }
      if (this.q != null)
      {
        I0();
        q0(this.q);
      }
      this.q = paramString;
      ObservableBoolean localObservableBoolean = this.q4.D;
      if ((paramString != null) && (LiveMediaAPI.isPlayingProperly(paramString))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObservableBoolean.set(bool2);
      localObservableBoolean = this.q4.E;
      boolean bool2 = bool1;
      if (paramString != null)
      {
        bool2 = bool1;
        if (LiveMediaAPI.isPlayingProperly(paramString)) {
          bool2 = true;
        }
      }
      localObservableBoolean.set(bool2);
      o0();
      this.q4.k.setValue(this.q);
      G();
      H();
      m0();
      n0();
    }
  }
  
  private void w0(NightMode paramNightMode)
  {
    this.k4.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    paramNightMode = this.r4.G(paramNightMode).H0(new r0(this, paramNightMode), new q0(this));
    this.n4.b(paramNightMode);
  }
  
  private void x(boolean paramBoolean)
  {
    if (!this.q4.G.get()) {
      return;
    }
    this.J3.set(paramBoolean);
    c localc = this.K3;
    if ((localc != null) && (!localc.isDisposed())) {
      this.K3.dispose();
    }
    if (paramBoolean)
    {
      B();
    }
    else
    {
      this.Q3.set(false);
      this.a4.set(false);
    }
  }
  
  public void A()
  {
    Object localObject = this.q4;
    if ((localObject != null) && (((VideoPlayViewModel)localObject).G.get()))
    {
      localObject = this.K3;
      if ((localObject != null) && (!((c)localObject).isDisposed()))
      {
        this.K3.dispose();
        b.d.w.c.a.c(c, "Disable latent func timer");
      }
    }
  }
  
  public void B()
  {
    Object localObject = this.q4;
    if ((localObject != null) && (((VideoPlayViewModel)localObject).G.get()) && (this.J3.get()))
    {
      localObject = this.K3;
      if ((localObject == null) || (((c)localObject).isDisposed()))
      {
        b.d.w.c.a.c(c, "Enable latent func timer");
        localObject = q.f0(Boolean.FALSE).o(5L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new t0(this));
        this.K3 = ((c)localObject);
        this.n4.b((c)localObject);
      }
    }
  }
  
  @Nullable
  public String C()
  {
    return this.q;
  }
  
  public void C0(LifecycleOwner paramLifecycleOwner)
  {
    paramLifecycleOwner.getLifecycle().addObserver(this);
    this.R3.observe(paramLifecycleOwner, new u0(this));
    this.y.observe(paramLifecycleOwner, new h0(this));
    this.J3.addOnPropertyChangedCallback(new c());
    this.p2.removeObserver(this.p4);
    this.p2.observe(paramLifecycleOwner, this.p4);
    this.q4.G.addOnPropertyChangedCallback(new d());
  }
  
  public Rect D(int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    int i = paramInt & 0x3;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i == 3) && (TextUtils.isEmpty((CharSequence)this.z.get(paramInt))))
          {
            if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt - 1))) {
              localRect.left = 1;
            }
            if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt - 2))) {
              localRect.top = 1;
            }
            if ((paramBoolean) && (paramInt != 31)) {
              localRect.right = 1;
            }
          }
        }
        else if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt)))
        {
          if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt - 2))) {
            localRect.left = 1;
          }
          if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt + 1))) {
            localRect.bottom = 1;
          }
          if ((paramBoolean) && (paramInt != 30)) {
            localRect.right = 1;
          }
        }
      }
      else if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt)))
      {
        if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt - 1))) {
          localRect.top = 1;
        }
        if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt + 2))) {
          localRect.right = 1;
        }
        if ((paramBoolean) && (paramInt != 1)) {
          localRect.left = 1;
        }
      }
    }
    else if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt)))
    {
      if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt + 1))) {
        localRect.right = 1;
      }
      if (TextUtils.isEmpty((CharSequence)this.z.get(paramInt + 2))) {
        localRect.bottom = 1;
      }
      if ((paramBoolean) && (paramInt != 0)) {
        localRect.left = 1;
      }
    }
    return localRect;
  }
  
  public int E(int paramInt)
  {
    int i = this.x;
    if (i == 1) {
      return paramInt;
    }
    return paramInt / i * i;
  }
  
  public void E0()
  {
    int i = ((Integer)j.e(this.y, Integer.valueOf(0))).intValue();
    int j = i & 0x3;
    if ((j > 0) && (j < 3)) {
      this.y.setValue(Integer.valueOf(i + 3 - (j << 1)));
    }
  }
  
  public void F(Rect[] paramArrayOfRect, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 %= 4;
    Rect localRect;
    if (paramInt3 != 1)
    {
      if ((paramInt3 == 2) || (paramInt3 == 3))
      {
        localRect = paramArrayOfRect[0];
        localRect.left -= paramInt1;
        localRect = paramArrayOfRect[0];
        localRect.right -= paramInt1;
        if (paramInt3 != 3) {}
      }
    }
    else
    {
      localRect = paramArrayOfRect[0];
      localRect.top -= paramInt2;
      localRect = paramArrayOfRect[0];
      localRect.bottom -= paramInt2;
    }
    paramArrayOfRect[1] = new Rect(paramArrayOfRect[0]);
    paramArrayOfRect[1].top += paramInt2;
    paramArrayOfRect[1].bottom += paramInt2;
    paramArrayOfRect[2] = new Rect(paramArrayOfRect[0]);
    paramArrayOfRect[2].left += paramInt1;
    paramArrayOfRect[2].right += paramInt1;
    paramArrayOfRect[3] = new Rect(paramArrayOfRect[1]);
    paramArrayOfRect[3].left += paramInt1;
    paramArrayOfRect[3].right += paramInt1;
  }
  
  public void H0()
  {
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    localObject = TPIoTClientManager.K1((String)localObject);
    if ((localObject != null) && (((TPBaseDeviceContext)localObject).getCameraDevice() != null))
    {
      localObject = (NightVisionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.q, NightVisionRepository.class);
      this.W3 = ((NightVisionRepository)localObject);
      ((NightVisionRepository)localObject).y(this.U3.get() ^ true).C(o0.c).E(new x0(this)).L0(io.reactivex.l0.a.c()).F0();
    }
  }
  
  public boolean I()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.q)) && (LiveMediaAPI.isPlayingProperly(this.q))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void J0(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt)
  {
    Iterator localIterator = paramArrayList2.iterator();
    int i;
    while (localIterator.hasNext())
    {
      paramArrayList2 = (String)localIterator.next();
      i = this.z.indexOf(paramArrayList2);
      if (i >= 0) {
        this.z.set(i, null);
      }
    }
    paramArrayList2 = paramArrayList1.iterator();
    while (paramArrayList2.hasNext())
    {
      paramArrayList1 = (String)paramArrayList2.next();
      if (!this.z.contains(paramArrayList1))
      {
        while (!TextUtils.isEmpty((CharSequence)this.z.get(paramInt)))
        {
          i = paramInt + 1;
          paramInt = i;
          if (i >= 32) {
            paramInt = 0;
          }
        }
        this.z.set(paramInt, paramArrayList1);
        i = paramInt + 1;
        paramInt = i;
        if (i >= 32) {
          paramInt = 0;
        }
      }
    }
  }
  
  public void K0()
  {
    long l;
    if (!this.e4.get())
    {
      if (!b.d.q.b.p.b.r()) {
        l0(2131953000);
      }
      l = System.currentTimeMillis();
      this.i4 = l;
      if (l - this.h4 < 1500L) {
        return;
      }
      A0();
    }
    else
    {
      l = System.currentTimeMillis();
      this.h4 = l;
      if (l - this.i4 < 1500L) {
        return;
      }
      B0();
    }
  }
  
  public void j0(boolean paramBoolean)
  {
    this.Q3.set(paramBoolean);
    this.a4.set(false);
  }
  
  public void k0(boolean paramBoolean)
  {
    this.a4.set(paramBoolean);
    this.Q3.set(false);
  }
  
  public void o0()
  {
    if (this.q != null)
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceIdMD5: ");
      localStringBuilder.append(this.q);
      localStringBuilder.append(" registerStreamDisplayCallback");
      b.d.w.c.a.c(str, localStringBuilder.toString());
      LiveMediaAPI.addSteamDisplayCommonCallback(this.q, this.s4);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onActivityStart()
  {
    o0();
    if (this.f)
    {
      m0();
      n0();
    }
    this.f = true;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onActivityStop()
  {
    c localc = this.S3;
    if (localc != null) {
      localc.dispose();
    }
    localc = this.V3;
    if (localc != null) {
      localc.dispose();
    }
    I0();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.n4.d();
  }
  
  public void p0(MutableLiveData<Boolean> paramMutableLiveData)
  {
    this.p2.removeSource(paramMutableLiveData);
  }
  
  public void s0()
  {
    LiveMediaAPI.snapshot(this.q);
  }
  
  public void t0(ArrayList<String> paramArrayList)
  {
    this.z.clear();
    this.z.addAll(paramArrayList);
  }
  
  public void v(MutableLiveData<Boolean> paramMutableLiveData)
  {
    this.p2.removeSource(paramMutableLiveData);
    MediatorLiveData localMediatorLiveData = this.p2;
    MutableLiveData localMutableLiveData = this.p1;
    localMutableLiveData.getClass();
    localMediatorLiveData.addSource(paramMutableLiveData, new v2(localMutableLiveData));
  }
  
  void v0(MutableLiveData<Boolean> paramMutableLiveData)
  {
    this.M3 = paramMutableLiveData;
  }
  
  public void w()
  {
    x(this.J3.get() ^ true);
  }
  
  public void x0(VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.q4 = paramVideoPlayViewModel;
    u0(paramVideoPlayViewModel.j);
  }
  
  public boolean y()
  {
    if (this.L3)
    {
      o.h0().h("multi_live_debut", false);
      this.L3 = false;
      return true;
    }
    return false;
  }
  
  public void y0(NightMode paramNightMode)
  {
    if (!paramNightMode.equals(this.T3)) {
      w0(paramNightMode);
    }
  }
  
  public void z()
  {
    this.Q3.set(false);
    this.a4.set(false);
  }
  
  public void z0(BitStreamType paramBitStreamType)
  {
    if ((!this.b4.equals(paramBitStreamType)) && (this.q != null))
    {
      if (this.e4.get()) {
        B0();
      }
      G0(paramBitStreamType);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupVideoQuality(),change device ");
      localStringBuilder.append(this.q);
      localStringBuilder.append(" resolution to ");
      localStringBuilder.append(paramBitStreamType);
      b.d.w.c.a.c("viewModel", localStringBuilder.toString());
      LiveMediaAPI.changePreviewResolutions(this.q, paramBitStreamType, null);
      r0(paramBitStreamType);
      this.c4.put(this.q, Integer.valueOf(-1));
      this.q4.h();
    }
  }
  
  class a
    extends Observable.OnPropertyChangedCallback
  {
    a() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      MultiLiveVideoViewModel.this.f4.set(m.a(((ObservableLong)paramObservable).get()));
    }
  }
  
  class b
    extends SimpleStreamDisplayCallback
  {
    b() {}
    
    private void a(boolean paramBoolean)
    {
      MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).D.set(paramBoolean);
      if (!paramBoolean)
      {
        MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).y("VideoPlay.VideoControlPanelFragment");
        MultiLiveVideoViewModel.this.a4.set(false);
        MultiLiveVideoViewModel.this.Q3.set(false);
        MultiLiveVideoViewModel.this.m4.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
      }
    }
    
    public void changeVideoBitStreamType(String paramString, BitStreamType paramBitStreamType, boolean paramBoolean, int paramInt)
    {
      String str = MultiLiveVideoViewModel.h();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeVideoBitStreamType ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" result ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" errorCode ");
      localStringBuilder.append(paramInt);
      b.d.w.c.a.c(str, localStringBuilder.toString());
      if ((paramBoolean) && (paramString.equals(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this))))
      {
        if (BitStreamType.MAIN_HD.equals(paramBitStreamType))
        {
          MultiLiveVideoViewModel.j(MultiLiveVideoViewModel.this).put(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this), Integer.valueOf(0));
          MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).i.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
        else if (BitStreamType.MINOR_VGA.equals(paramBitStreamType))
        {
          paramString = q.W0(5L, TimeUnit.SECONDS).E(new n0(this)).F0();
          MultiLiveVideoViewModel.n(MultiLiveVideoViewModel.this).b(paramString);
        }
      }
      else if (!paramBoolean)
      {
        MultiLiveVideoViewModel.o(MultiLiveVideoViewModel.this, 2131952741);
        b.d.d.e.a.a(paramString, new j0(this));
      }
    }
    
    public void framePerSecond(String paramString, int paramInt)
    {
      if (!LiveMediaAPI.isPlayingProperly(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this))) {
        return;
      }
      if (j.h(MultiLiveVideoViewModel.u(MultiLiveVideoViewModel.this)))
      {
        b.d.w.c.a.c(MultiLiveVideoViewModel.h(), "lens mask altering");
        return;
      }
      if ((paramInt < 5) && (paramString.equals(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this))))
      {
        Integer localInteger = (Integer)MultiLiveVideoViewModel.j(MultiLiveVideoViewModel.this).get(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this));
        paramString = localInteger;
        if (localInteger == null) {
          paramString = Integer.valueOf(-1);
        }
        if (paramString.intValue() == 0)
        {
          paramString = e0.d().a(MultiLiveVideoViewModel.this.getApplication(), 2131952999, MultiLiveVideoViewModel.this.getApplication().getString(2131953268), "sans-serif-medium", true, ContextCompat.getColor(MultiLiveVideoViewModel.this.getApplication(), 2131099731), ContextCompat.getColor(MultiLiveVideoViewModel.this.getApplication(), 2131099945), new a());
          MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).h.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
        }
        else if (paramString.intValue() == 1)
        {
          if (!LiveMediaAPI.isPlayingProperly(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this))) {
            return;
          }
          paramString = new SpannableString(MultiLiveVideoViewModel.this.getApplication().getString(2131952998));
          MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).h.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramString));
          MultiLiveVideoViewModel.j(MultiLiveVideoViewModel.this).put(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this), Integer.valueOf(2));
        }
      }
    }
    
    public void hideLoadingView()
    {
      if (!MultiLiveVideoViewModel.g(MultiLiveVideoViewModel.this))
      {
        MultiLiveVideoViewModel.i(MultiLiveVideoViewModel.this, true);
        o.h0().h("VideoQualityTip", true);
        String str = MultiLiveVideoViewModel.this.getApplication().getString(2131952997);
        MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(str));
      }
      a(true);
      MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).E.set(true);
    }
    
    public void onSnapshotComplete(String paramString)
    {
      super.onSnapshotComplete(paramString);
      MultiLiveVideoViewModel.n(MultiLiveVideoViewModel.this).b(com.tplink.iot.Utils.y0.e.a(MultiLiveVideoViewModel.this.getApplication(), paramString).l0(io.reactivex.d0.b.a.a()).G0(new m0(this)));
    }
    
    public void playFatalException(Exception paramException)
    {
      if (MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).p != null) {
        MultiLiveVideoViewModel.this.p1.setValue(Boolean.FALSE);
      }
      a(false);
      MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).E.set(false);
      if (((paramException instanceof CameraException)) && (((CameraException)paramException).getErrorCode() == -52405) && (MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this) != null))
      {
        paramException = MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this);
        BitStreamType localBitStreamType = BitStreamType.MINOR_VGA;
        b.d.d.e.a.c(paramException, localBitStreamType);
        MultiLiveVideoViewModel.m(MultiLiveVideoViewModel.this, localBitStreamType);
      }
    }
    
    public void recordFailed(int paramInt)
    {
      MultiLiveVideoViewModel.this.e4.set(false);
      MultiLiveVideoViewModel.this.f4.set("");
      switch (paramInt)
      {
      default: 
        MultiLiveVideoViewModel.o(MultiLiveVideoViewModel.this, 2131953647);
        break;
      case -3200001: 
        MultiLiveVideoViewModel.o(MultiLiveVideoViewModel.this, 2131953002);
        break;
      case -3200002: 
        MultiLiveVideoViewModel.o(MultiLiveVideoViewModel.this, 2131953000);
        break;
      case -3200004: 
      case -3200003: 
        MultiLiveVideoViewModel.o(MultiLiveVideoViewModel.this, 2131953001);
      }
    }
    
    public void recordStop()
    {
      MultiLiveVideoViewModel localMultiLiveVideoViewModel = MultiLiveVideoViewModel.this;
      MultiLiveVideoViewModel.p(localMultiLiveVideoViewModel, MultiLiveVideoViewModel.l(localMultiLiveVideoViewModel));
      MultiLiveVideoViewModel.this.e4.set(false);
      MultiLiveVideoViewModel.this.f4.set("");
    }
    
    public void recordSuccess(int paramInt, String paramString)
    {
      MultiLiveVideoViewModel.this.e4.set(false);
      MultiLiveVideoViewModel.this.f4.set("");
      paramString = com.tplink.iot.Utils.y0.e.a(MultiLiveVideoViewModel.this.getApplication(), paramString).g0(new k0(this)).F0();
      MultiLiveVideoViewModel.n(MultiLiveVideoViewModel.this).b(paramString);
    }
    
    public void relayPreviewTimeLimit(int paramInt)
    {
      a(false);
      MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).E.set(false);
    }
    
    public void retryResolutions(BitStreamType paramBitStreamType)
    {
      MultiLiveVideoViewModel.m(MultiLiveVideoViewModel.this, paramBitStreamType);
    }
    
    public void showLoadingView()
    {
      MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).D.set(false);
      MultiLiveVideoViewModel.f(MultiLiveVideoViewModel.this).E.set(false);
    }
    
    public void startHoldToTalk()
    {
      if (MultiLiveVideoViewModel.r(MultiLiveVideoViewModel.this) != null) {
        MultiLiveVideoViewModel.r(MultiLiveVideoViewModel.this).dispose();
      }
      LiveMediaAPI.muteVolume(MultiLiveVideoViewModel.l(MultiLiveVideoViewModel.this), true);
    }
    
    public void stopHoldToTalk()
    {
      if (!MultiLiveVideoViewModel.t(MultiLiveVideoViewModel.this))
      {
        if (MultiLiveVideoViewModel.r(MultiLiveVideoViewModel.this) != null) {
          MultiLiveVideoViewModel.r(MultiLiveVideoViewModel.this).dispose();
        }
        MultiLiveVideoViewModel.s(MultiLiveVideoViewModel.this, q.W0(1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new l0(this)));
        MultiLiveVideoViewModel.n(MultiLiveVideoViewModel.this).b(MultiLiveVideoViewModel.r(MultiLiveVideoViewModel.this));
      }
    }
    
    class a
      implements e0.f
    {
      a() {}
      
      public void a(View paramView) {}
      
      public void b(View paramView)
      {
        MultiLiveVideoViewModel.this.z0(BitStreamType.MINOR_VGA);
      }
    }
  }
  
  class c
    extends Observable.OnPropertyChangedCallback
  {
    c() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      if (!MultiLiveVideoViewModel.this.J3.get()) {
        MultiLiveVideoViewModel.this.j0(false);
      }
    }
  }
  
  class d
    extends Observable.OnPropertyChangedCallback
  {
    d() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      MultiLiveVideoViewModel.k(MultiLiveVideoViewModel.this, ((ObservableBoolean)paramObservable).get());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\MultiLiveVideoViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */