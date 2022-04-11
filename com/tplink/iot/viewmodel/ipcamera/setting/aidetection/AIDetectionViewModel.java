package com.tplink.iot.viewmodel.ipcamera.setting.aidetection;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.iot.Utils.v0.d;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.Utils.f;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AIDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import io.reactivex.e0.c;
import io.reactivex.q;
import kotlin.jvm.internal.j;

public final class AIDetectionViewModel
  extends AndroidViewModel
{
  private final String a = AIDetectionViewModel.class.getSimpleName();
  private String b;
  private AIDetectionRepository c;
  private MotionDetectionRepository d;
  private final int e;
  private final int f;
  private final int g;
  private final MutableLiveData<Boolean> h;
  private final MutableLiveData<String> i;
  private final MutableLiveData<Boolean> j;
  private final MutableLiveData<Boolean> k;
  private final MutableLiveData<Integer> l;
  private ObservableBoolean m;
  private ObservableBoolean n;
  private ObservableBoolean o;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> p;
  private final io.reactivex.e0.b q;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> r;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> s;
  private int t;
  private final MutableLiveData<Boolean> u;
  private boolean v;
  private boolean w;
  
  public AIDetectionViewModel(Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    j.d(paramApplication, "context.deviceIdMD5");
    this.b = paramApplication;
    this.c = ((AIDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramTPCameraDeviceContext.getDeviceIdMD5(), AIDetectionRepository.class));
    this.d = ((MotionDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramTPCameraDeviceContext.getDeviceIdMD5(), MotionDetectionRepository.class));
    this.f = 50;
    this.g = 100;
    paramApplication = Boolean.FALSE;
    this.h = new MutableLiveData(paramApplication);
    this.i = new MutableLiveData();
    this.j = new MutableLiveData(paramApplication);
    this.k = new MutableLiveData(paramApplication);
    this.l = new MutableLiveData(Integer.valueOf(0));
    this.m = new ObservableBoolean(false);
    this.n = new ObservableBoolean(false);
    this.o = new ObservableBoolean(false);
    this.p = new MutableLiveData();
    this.q = new io.reactivex.e0.b();
    this.r = new MutableLiveData();
    this.s = new MutableLiveData();
    this.t = 3;
    this.u = new MutableLiveData();
  }
  
  private final void B(CameraComponent paramCameraComponent)
  {
    this.j.setValue(Boolean.valueOf(paramCameraComponent.hasComponent(ComponentType.BABY_CRYING_DETECTION)));
    if (paramCameraComponent.isSupportPersonDetection())
    {
      this.v = true;
      this.i.setValue(getApplication().getString(2131954247));
    }
    else if (paramCameraComponent.isSupportPersonEnhanced())
    {
      this.w = true;
      this.i.setValue(getApplication().getString(2131954247));
    }
    else
    {
      this.i.setValue(null);
    }
    M();
  }
  
  private final void C(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IoTCloudException)) {
      this.r.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    } else {
      this.p.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(getApplication().getString(2131952444)));
    }
    b.d.w.c.a.e(this.a, Log.getStackTraceString(paramThrowable));
  }
  
  private final void D(int paramInt, MutableLiveData<Boolean> paramMutableLiveData)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          this.r.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
        }
        else
        {
          this.r.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
          w.c(this.b);
        }
      }
      else {
        O(paramMutableLiveData);
      }
    }
    else
    {
      this.s.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
      w.d(this.b);
    }
  }
  
  private final void M()
  {
    if (this.t == 3)
    {
      if (this.v)
      {
        this.h.setValue(this.c.v().getValue());
      }
      else if (this.w)
      {
        MutableLiveData localMutableLiveData = this.h;
        Object localObject = this.d;
        j.d(localObject, "motionRepository");
        localObject = ((MotionDetectionRepository)localObject).y();
        j.d(localObject, "motionRepository.setting");
        localMutableLiveData.setValue(((com.tplink.libtpnetwork.cameranetwork.business.model.g)localObject).b());
      }
      if (j.a((Boolean)this.j.getValue(), Boolean.TRUE))
      {
        this.k.setValue(this.c.t().getValue());
        this.l.setValue(this.c.u().getValue());
      }
    }
    else
    {
      N();
    }
  }
  
  private final void N()
  {
    int i1 = this.t;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.g(this.b, bool, new l(this));
  }
  
  private final void P(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> paramMutableLiveData, int paramInt)
  {
    Application localApplication = getApplication();
    j.d(localApplication, "getApplication<Application>()");
    paramMutableLiveData.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localApplication.getResources().getString(paramInt)));
  }
  
  private final q<Boolean> Q(boolean paramBoolean, int paramInt)
  {
    return this.c.x(paramBoolean, paramInt);
  }
  
  private final q<Boolean> R(boolean paramBoolean)
  {
    if (this.v) {
      return this.c.y(paramBoolean);
    }
    if (this.w)
    {
      localq = this.d.t(Boolean.valueOf(paramBoolean));
      j.d(localq, "motionRepository.changeH…g(enableHumanRecognition)");
      return localq;
    }
    q localq = q.f0(Boolean.TRUE);
    j.d(localq, "Observable.just(true)");
    return localq;
  }
  
  private final void S(MutableLiveData<Boolean> paramMutableLiveData)
  {
    final boolean bool = j.a((Boolean)paramMutableLiveData.getValue(), Boolean.TRUE) ^ true;
    if (j.a(paramMutableLiveData, this.h))
    {
      paramMutableLiveData = R(bool).E(new m(this, bool)).C(new n(this, bool));
      j.d(paramMutableLiveData, "setHumanRecognitionConfi…nEnabled.value = !enable}");
      m(paramMutableLiveData);
    }
    else if (j.a(paramMutableLiveData, this.k))
    {
      paramMutableLiveData = (Integer)this.l.getValue();
      int i1 = 50;
      if ((paramMutableLiveData != null) && (paramMutableLiveData.intValue() == 100))
      {
        i1 = 100;
      }
      else
      {
        paramMutableLiveData = (Integer)this.l.getValue();
        if ((paramMutableLiveData == null) || (paramMutableLiveData.intValue() != 50)) {
          i1 = 0;
        }
      }
      paramMutableLiveData = Q(bool, i1).E(new o(this, bool)).C(new p(this, bool));
      j.d(paramMutableLiveData, "setBabyCryingDetectionCo…nEnabled.value = !enable}");
      m(paramMutableLiveData);
    }
  }
  
  private final <T> void m(q<T> paramq)
  {
    paramq = paramq.F(new d(this)).y(new e(this)).H0(f.c, new g(this));
    this.q.b(paramq);
  }
  
  private final void r()
  {
    if (TextUtils.isEmpty(this.b)) {
      return;
    }
    if (!f.f(this.b)) {
      return;
    }
    c localc = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.b, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new h(this), i.c);
    this.q.b(localc);
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> A()
  {
    return this.s;
  }
  
  public final void E()
  {
    int i1 = this.t;
    boolean bool;
    if (i1 == 3)
    {
      Boolean localBoolean = (Boolean)this.k.getValue();
      if (localBoolean != null)
      {
        Integer localInteger = (Integer)this.l.getValue();
        if (localInteger != null)
        {
          Object localObject = this.c;
          j.d(localBoolean, "enable");
          bool = localBoolean.booleanValue();
          j.d(localInteger, "sensitivity");
          localObject = ((AIDetectionRepository)localObject).x(bool, localInteger.intValue()).C(new j(localBoolean, this));
          j.d(localObject, "mAIDetectionRepository.s…                        }");
          m((q)localObject);
        }
      }
    }
    else
    {
      bool = true;
      if (i1 != 1) {
        bool = false;
      }
      l.s(this.b, bool, new k(this));
    }
  }
  
  public final void F(int paramInt)
  {
    this.t = paramInt;
    this.m.set(d.c(this.b));
    ObservableBoolean localObservableBoolean = this.n;
    boolean bool;
    if ((!h.b(ComponentType.DETECTION, this.b)) && (!h.b(ComponentType.PERSON_DETECTION, this.b))) {
      bool = false;
    } else {
      bool = true;
    }
    localObservableBoolean.set(bool);
    this.o.set(h.b(ComponentType.BABY_CRYING_DETECTION, this.b));
    r();
  }
  
  public final ObservableBoolean G()
  {
    return this.o;
  }
  
  public final ObservableBoolean H()
  {
    return this.m;
  }
  
  public final boolean I()
  {
    return this.w;
  }
  
  public final ObservableBoolean J()
  {
    return this.n;
  }
  
  public final boolean K()
  {
    return this.v;
  }
  
  public final MutableLiveData<Boolean> L()
  {
    return this.u;
  }
  
  public final void O(MutableLiveData<Boolean> paramMutableLiveData)
  {
    j.e(paramMutableLiveData, "curSwitchDetectionEnable");
    if (this.t == 3)
    {
      S(paramMutableLiveData);
    }
    else
    {
      paramMutableLiveData.setValue(Boolean.valueOf(j.a((Boolean)paramMutableLiveData.getValue(), Boolean.TRUE) ^ true));
      T(paramMutableLiveData);
    }
  }
  
  public final void T(final MutableLiveData<Boolean> paramMutableLiveData)
  {
    j.e(paramMutableLiveData, "curSwitchDetectionEnable");
    int i1 = this.t;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.s(this.b, bool, new q(this, paramMutableLiveData));
  }
  
  public final void l(final MutableLiveData<Boolean> paramMutableLiveData)
  {
    j.e(paramMutableLiveData, "curSwitchDetectionEnable");
    boolean bool = j.a(paramMutableLiveData, this.h);
    ComponentType localComponentType = null;
    if (bool)
    {
      if (this.w) {
        localComponentType = ComponentType.DETECTION;
      } else if (this.v) {
        localComponentType = ComponentType.PERSON_DETECTION;
      }
    }
    else if (j.a(paramMutableLiveData, this.k)) {
      localComponentType = ComponentType.BABY_CRYING_DETECTION;
    }
    paramMutableLiveData = h.a(this.b, true, localComponentType, new a(this)).H0(new b(this, paramMutableLiveData), new c(this));
    this.q.b(paramMutableLiveData);
  }
  
  public final MutableLiveData<Boolean> n()
  {
    return this.j;
  }
  
  public final MutableLiveData<Boolean> o()
  {
    return this.k;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.q.d();
  }
  
  public final MutableLiveData<Integer> p()
  {
    return this.l;
  }
  
  public final String s()
  {
    return this.b;
  }
  
  public final MutableLiveData<Boolean> t()
  {
    return this.h;
  }
  
  public final MutableLiveData<String> u()
  {
    return this.i;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> v()
  {
    return this.p;
  }
  
  public final int w()
  {
    return this.g;
  }
  
  public final int x()
  {
    return this.e;
  }
  
  public final int y()
  {
    return this.f;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> z()
  {
    return this.r;
  }
  
  static final class a<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<Boolean>
  {
    a(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void b(Boolean paramBoolean)
    {
      this.a.L().setValue(paramBoolean);
    }
  }
  
  static final class b<T>
    implements io.reactivex.g0.g<Integer>
  {
    b(AIDetectionViewModel paramAIDetectionViewModel, MutableLiveData paramMutableLiveData) {}
    
    public final void a(Integer paramInteger)
    {
      AIDetectionViewModel localAIDetectionViewModel = this.c;
      j.d(paramInteger, "it");
      AIDetectionViewModel.j(localAIDetectionViewModel, paramInteger.intValue(), paramMutableLiveData);
    }
  }
  
  static final class c<T>
    implements io.reactivex.g0.g<Throwable>
  {
    c(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      AIDetectionViewModel localAIDetectionViewModel = this.c;
      j.d(paramThrowable, "it");
      AIDetectionViewModel.i(localAIDetectionViewModel, paramThrowable);
    }
  }
  
  static final class d<T>
    implements io.reactivex.g0.g<c>
  {
    d(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void a(c paramc)
    {
      this.c.L().postValue(Boolean.TRUE);
    }
  }
  
  static final class e
    implements io.reactivex.g0.a
  {
    e(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void run()
    {
      this.a.L().postValue(Boolean.FALSE);
    }
  }
  
  static final class f<T>
    implements io.reactivex.g0.g<T>
  {
    public static final f c = new f();
    
    public final void accept(T paramT) {}
  }
  
  static final class g<T>
    implements io.reactivex.g0.g<Throwable>
  {
    g(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.e(AIDetectionViewModel.g(this.c), Log.getStackTraceString(paramThrowable));
      paramThrowable = this.c;
      AIDetectionViewModel.k(paramThrowable, paramThrowable.v(), 2131952741);
    }
  }
  
  static final class h<T>
    implements io.reactivex.g0.g<CameraComponent>
  {
    h(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void a(CameraComponent paramCameraComponent)
    {
      j.e(paramCameraComponent, "cameraComponent");
      AIDetectionViewModel.h(this.c, paramCameraComponent);
    }
  }
  
  static final class i<T>
    implements io.reactivex.g0.g<Throwable>
  {
    public static final i c = new i();
    
    public final void a(Throwable paramThrowable)
    {
      j.e(paramThrowable, "obj");
      paramThrowable.printStackTrace();
    }
  }
  
  static final class j<T>
    implements io.reactivex.g0.g<Throwable>
  {
    j(Boolean paramBoolean, AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = (Integer)AIDetectionViewModel.f(jdField_this).u().getValue();
      if (paramThrowable != null) {
        jdField_this.p().setValue(paramThrowable);
      }
    }
  }
  
  static final class k<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e>
  {
    k(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.e parame)
    {
      j.e(parame, "info");
      Integer localInteger = (Integer)this.a.p().getValue();
      if (localInteger != null)
      {
        j.d(localInteger, "it");
        parame.d0(localInteger.intValue());
      }
    }
  }
  
  static final class l<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e>
  {
    l(AIDetectionViewModel paramAIDetectionViewModel) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.e parame)
    {
      j.e(parame, "info");
      this.a.o().setValue(Boolean.valueOf(parame.n()));
      this.a.p().setValue(Integer.valueOf(parame.o()));
      if (this.a.K()) {
        this.a.t().setValue(Boolean.valueOf(parame.s()));
      } else if (this.a.I()) {
        this.a.t().setValue(Boolean.valueOf(parame.r()));
      }
    }
  }
  
  static final class m<T>
    implements io.reactivex.g0.g<Boolean>
  {
    m(AIDetectionViewModel paramAIDetectionViewModel, boolean paramBoolean) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.t().setValue(Boolean.valueOf(bool));
    }
  }
  
  static final class n<T>
    implements io.reactivex.g0.g<Throwable>
  {
    n(AIDetectionViewModel paramAIDetectionViewModel, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.t().setValue(Boolean.valueOf(bool ^ true));
    }
  }
  
  static final class o<T>
    implements io.reactivex.g0.g<Boolean>
  {
    o(AIDetectionViewModel paramAIDetectionViewModel, boolean paramBoolean) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.o().setValue(Boolean.valueOf(bool));
    }
  }
  
  static final class p<T>
    implements io.reactivex.g0.g<Throwable>
  {
    p(AIDetectionViewModel paramAIDetectionViewModel, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.o().setValue(Boolean.valueOf(bool ^ true));
    }
  }
  
  static final class q<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.e>
  {
    q(AIDetectionViewModel paramAIDetectionViewModel, MutableLiveData paramMutableLiveData) {}
    
    public final void b(com.tplink.libtpmediaother.database.model.e parame)
    {
      j.e(parame, "info");
      if (j.a(paramMutableLiveData, this.a.t()))
      {
        Boolean localBoolean1 = (Boolean)paramMutableLiveData.getValue();
        Boolean localBoolean2 = Boolean.TRUE;
        parame.h0(j.a(localBoolean1, localBoolean2));
        parame.g0(j.a((Boolean)paramMutableLiveData.getValue(), localBoolean2));
      }
      else if (j.a(paramMutableLiveData, this.a.o()))
      {
        parame.c0(j.a((Boolean)paramMutableLiveData.getValue(), Boolean.TRUE));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\aidetection\AIDetectionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */