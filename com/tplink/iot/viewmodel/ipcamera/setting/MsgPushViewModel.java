package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.l;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.SubscribeItemBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.model.g;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AIDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MsgPushRepository;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import io.reactivex.e0.c;
import io.reactivex.q;

public class MsgPushViewModel
  extends AndroidViewModel
{
  private com.tplink.libtpmediaother.database.model.e A;
  private int B;
  private boolean C;
  public final MutableLiveData<Boolean> a;
  public final MutableLiveData<Boolean> b;
  public ObservableBoolean c;
  public ObservableBoolean d;
  public ObservableBoolean e;
  public ObservableBoolean f;
  public ObservableBoolean g;
  public ObservableInt h;
  public ObservableInt i;
  public ObservableInt j;
  public ObservableField<String> k;
  public ObservableField<String> l;
  public ObservableInt m;
  public ObservableBoolean n;
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> o;
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> p;
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> q;
  private String r;
  private String s;
  private MsgPushRepository t;
  private CommonCameraRepository u;
  private TCMessagePushRepository v;
  private MotionDetectionRepository w;
  private AIDetectionRepository x;
  private int y;
  private io.reactivex.e0.b z;
  
  public MsgPushViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = Boolean.FALSE;
    this.a = new MutableLiveData(paramApplication);
    this.b = new MutableLiveData(paramApplication);
    this.c = new ObservableBoolean(false);
    this.d = new ObservableBoolean(false);
    this.e = new ObservableBoolean(false);
    this.f = new ObservableBoolean(false);
    this.g = new ObservableBoolean(false);
    this.h = new ObservableInt(540);
    this.i = new ObservableInt(1020);
    this.j = new ObservableInt(127);
    this.k = new ObservableField("09:00");
    this.l = new ObservableField("17:00");
    this.m = new ObservableInt(127);
    this.n = new ObservableBoolean(false);
    this.o = new MutableLiveData();
    this.p = new MutableLiveData();
    this.q = new MutableLiveData();
    this.z = new io.reactivex.e0.b();
    this.B = 0;
    this.C = false;
    this.r = paramTPCameraDeviceContext.getDeviceIdMD5();
    if (paramTPCameraDeviceContext.getCameraDevice() != null) {
      this.s = ((ALCameraDevice)paramTPCameraDeviceContext.getCameraDevice()).getDeviceId();
    }
    if (paramTPCameraDeviceContext.getIoTDevice() != null) {
      this.s = ((ALCameraDevice)paramTPCameraDeviceContext.getIoTDevice()).getDeviceId();
    }
    this.t = ((MsgPushRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, MsgPushRepository.class));
    this.u = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, CommonCameraRepository.class));
    this.w = ((MotionDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, MotionDetectionRepository.class));
    this.x = ((AIDetectionRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, AIDetectionRepository.class));
    this.v = ((TCMessagePushRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCMessagePushRepository.class));
    this.c.set(com.tplink.iot.Utils.v0.d.c(this.r));
    this.d.set(com.tplink.iot.Utils.z0.h.b(ComponentType.MSG_PUSH, this.r));
  }
  
  private void c0()
  {
    Object localObject = this.t.v();
    this.e.set(((com.tplink.libtpnetwork.cameranetwork.business.model.h)localObject).c());
    this.f.set(((com.tplink.libtpnetwork.cameranetwork.business.model.h)localObject).d());
    this.g.set(((com.tplink.libtpnetwork.cameranetwork.business.model.h)localObject).b());
    if (((com.tplink.libtpnetwork.cameranetwork.business.model.h)localObject).a() != null) {
      localObject = ((com.tplink.libtpnetwork.cameranetwork.business.model.h)localObject).a();
    } else {
      localObject = new Schedule(9, 0, 17, 0, 127);
    }
    this.h.set(((Schedule)localObject).getStartHour() * 60 + ((Schedule)localObject).getStartMinute());
    this.i.set(((Schedule)localObject).getEndHour() * 60 + ((Schedule)localObject).getEndMinute());
    this.j.set(((Schedule)localObject).getType());
    this.m.set(this.j.get());
    localObject = this.n;
    boolean bool;
    if (this.h.get() > this.i.get()) {
      bool = true;
    } else {
      bool = false;
    }
    ((ObservableBoolean)localObject).set(bool);
    this.k.set(i(this.h.get()));
    this.l.set(i(this.i.get()));
  }
  
  private void d0()
  {
    int i1 = this.y;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.g(this.r, bool, new a6(this));
  }
  
  private void e0(boolean paramBoolean, Schedule paramSchedule)
  {
    int i1 = paramSchedule.getStartHour();
    int i2 = paramSchedule.getStartMinute();
    int i3 = paramSchedule.getEndHour();
    int i4 = paramSchedule.getEndMinute();
    String str = this.r;
    int i5 = paramSchedule.getType();
    boolean bool;
    if (this.y != 3) {
      bool = true;
    } else {
      bool = false;
    }
    com.tplink.iot.Utils.x0.d.o(str, paramBoolean, i1 * 60 + i2, i3 * 60 + i4, i5, bool);
  }
  
  private void f0(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tplink.iot.Utils.x0.d.m(this.r, paramBoolean1, paramBoolean2);
  }
  
  private void g(ObservableBoolean paramObservableBoolean)
  {
    String str = this.r;
    ComponentType localComponentType = ComponentType.MSG_PUSH;
    MutableLiveData localMutableLiveData = this.a;
    localMutableLiveData.getClass();
    com.tplink.iot.Utils.z0.h.a(str, true, localComponentType, new g9(localMutableLiveData)).F(new b6(this)).E(new h6(this, paramObservableBoolean)).C(new n6(this)).F0();
  }
  
  private void g0(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tplink.iot.Utils.x0.d.n(this.r, paramBoolean1, paramBoolean2);
  }
  
  private static String i(int paramInt)
  {
    return o0.a(AppContext.c, paramInt);
  }
  
  private void i0(boolean paramBoolean, Schedule paramSchedule)
  {
    int i1 = this.y;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.s(this.r, bool, new r6(paramBoolean, paramSchedule));
  }
  
  private void j(boolean paramBoolean1, boolean paramBoolean2)
  {
    c localc = this.u.K0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new z5(this, paramBoolean1, paramBoolean2), p6.c);
    this.z.b(localc);
  }
  
  private void j0(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = this.y;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    l.s(this.r, bool, new o6(this, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  private void k(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IoTCloudException)) {
      k0(this.p, Boolean.TRUE);
    } else {
      this.b.postValue(Boolean.TRUE);
    }
  }
  
  public static <T> void k0(MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<T>> paramMutableLiveData, @NonNull T paramT)
  {
    paramMutableLiveData.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramT));
  }
  
  private void l(int paramInt, ObservableBoolean paramObservableBoolean)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          k0(this.p, Boolean.TRUE);
        }
        else
        {
          k0(this.p, Boolean.TRUE);
          w.j(this.r);
        }
      }
      else if ((this.B != 0) && (!this.C))
      {
        k0(this.o, Boolean.TRUE);
      }
      else
      {
        paramObservableBoolean.set(true);
        q0(paramObservableBoolean.get());
      }
    }
    else
    {
      k0(this.q, Boolean.TRUE);
      w.k(this.r);
    }
  }
  
  private q<Boolean> l0(boolean paramBoolean)
  {
    int i1 = this.B;
    if (i1 == 1) {
      return this.x.y(paramBoolean);
    }
    if (i1 == 2) {
      return this.w.t(Boolean.valueOf(paramBoolean));
    }
    return q.f0(Boolean.TRUE);
  }
  
  private void n0(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.y == 3)
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        h0();
      }
      c localc = this.t.D(paramBoolean1, paramBoolean2).l0(io.reactivex.d0.b.a.a()).F(new k6(this)).N(new f6(this, paramBoolean3)).H0(new y5(this), new m6(this));
      this.z.b(localc);
    }
    else
    {
      j0(paramBoolean1, paramBoolean2, paramBoolean3);
      this.f.set(paramBoolean2);
    }
    if (this.y != 3) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    f0(paramBoolean1, paramBoolean2);
  }
  
  public Schedule f(int paramInt1, int paramInt2, int paramInt3)
  {
    return new Schedule(paramInt1 / 60 % 24, paramInt1 % 60, paramInt2 / 60 % 24, paramInt2 % 60, paramInt3);
  }
  
  public void h(ObservableBoolean paramObservableBoolean)
  {
    if (paramObservableBoolean.get())
    {
      paramObservableBoolean.set(false);
      q0(false);
    }
    else
    {
      g(paramObservableBoolean);
    }
  }
  
  public void h0()
  {
    if (TextUtils.isEmpty(this.s)) {
      return;
    }
    SubscribeItemBean localSubscribeItemBean1 = this.v.E(this.s);
    if ((localSubscribeItemBean1 != null) && (localSubscribeItemBean1.isSubscribeCameraMotion())) {
      return;
    }
    SubscribeItemBean localSubscribeItemBean2 = new SubscribeItemBean(this.s);
    if (localSubscribeItemBean1 != null) {
      localSubscribeItemBean2.setDeviceSubscribeOffBit(localSubscribeItemBean1.getDeviceSubscribeOffBit());
    }
    localSubscribeItemBean2.addSubscribeFunc(EnumMsgSubscribeType.CAMERA_MOTION);
    this.v.S(this.s, localSubscribeItemBean2).F0();
  }
  
  public void m(int paramInt)
  {
    this.y = paramInt;
    if (paramInt == 3)
    {
      j(j.h(this.x.v()), org.apache.commons.lang.b.b(this.w.y().b()));
      c localc = this.t.C().F(new g6(this)).y(new s6(this)).H0(new e6(this), new l6(this));
      this.z.b(localc);
    }
    else
    {
      d0();
    }
  }
  
  public void m0(boolean paramBoolean)
  {
    boolean bool1 = this.f.get();
    boolean bool2 = false;
    n0(paramBoolean, bool1, false);
    if (this.y != 3) {
      bool2 = true;
    }
    f0(paramBoolean, bool2);
  }
  
  public void o0(boolean paramBoolean)
  {
    p0(paramBoolean, f(this.h.get(), this.i.get(), this.j.get()));
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.z.dispose();
  }
  
  public void p0(boolean paramBoolean, Schedule paramSchedule)
  {
    this.g.set(paramBoolean);
    if (this.y == 3)
    {
      c localc = this.t.E(paramBoolean, paramSchedule).F(new c6(this)).y(new d6(this)).H0(new q6(this), new j6(this));
      this.z.b(localc);
    }
    else
    {
      i0(paramBoolean, paramSchedule);
    }
    e0(paramBoolean, paramSchedule);
  }
  
  public void q0(boolean paramBoolean)
  {
    boolean bool1 = this.e.get();
    boolean bool2 = false;
    n0(bool1, paramBoolean, false);
    if (this.y != 3) {
      bool2 = true;
    }
    g0(paramBoolean, bool2);
  }
  
  public void r0(boolean paramBoolean)
  {
    boolean bool1 = this.e.get();
    boolean bool2 = true;
    n0(bool1, paramBoolean, true);
    if (this.y == 3) {
      bool2 = false;
    }
    g0(paramBoolean, bool2);
  }
  
  public void s0(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h.set(paramInt1);
    this.i.set(paramInt2);
    this.j.set(paramInt3);
    this.m.set(this.j.get());
    ObservableBoolean localObservableBoolean = this.n;
    boolean bool;
    if (this.h.get() > this.i.get()) {
      bool = true;
    } else {
      bool = false;
    }
    localObservableBoolean.set(bool);
    this.k.set(i(this.h.get()));
    this.l.set(i(this.i.get()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\MsgPushViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */