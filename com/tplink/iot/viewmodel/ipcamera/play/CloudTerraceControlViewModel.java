package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.view.ipcamera.play.CloudTerraceSensitivityDialogFragment.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CloudTerraceMoveRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;

public class CloudTerraceControlViewModel
  extends AndroidViewModel
  implements LifecycleObserver, CloudTerraceSensitivityDialogFragment.a
{
  private int H3 = 0;
  private io.reactivex.e0.b I3 = new io.reactivex.e0.b();
  private CloudTerraceMoveRepository J3;
  public final MutableLiveData<Boolean> K3 = new MutableLiveData();
  public final MutableLiveData<Integer> L3 = new MutableLiveData();
  public final MutableLiveData<Boolean> M3 = new MutableLiveData();
  public final MutableLiveData<Boolean> N3 = new MutableLiveData();
  public final MutableLiveData<Boolean> O3 = new MutableLiveData();
  public final MutableLiveData<Boolean> P3 = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> Q3 = new MutableLiveData();
  private boolean R3 = true;
  private Handler S3 = new a(Looper.getMainLooper());
  private Runnable T3 = new m(this);
  private final String c = CloudTerraceControlViewModel.class.getSimpleName();
  private String d;
  private o f = o.h0();
  private final int p0 = 0;
  private final int p1 = 50;
  private final int p2 = 100;
  private int[] p3 = new int[4];
  private String q;
  private final int x = 5;
  private final int y = 10;
  private final int z = 15;
  
  public CloudTerraceControlViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private void h(int paramInt)
  {
    this.H3 = paramInt;
  }
  
  private void i()
  {
    b.d.q.b.l.e(this.d, new u(this));
  }
  
  private void i0(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(b.d.s.a.a.f().c().getEmail());
    localStringBuilder.append("_cloud_terrace_sensitivity");
    paramString = localStringBuilder.toString();
    this.q = paramString;
    int i = this.f.d(paramString, 10);
    if (i != 10)
    {
      if (i != 15) {
        this.L3.setValue(Integer.valueOf(0));
      } else {
        this.L3.setValue(Integer.valueOf(100));
      }
    }
    else {
      this.L3.setValue(Integer.valueOf(50));
    }
  }
  
  private void j()
  {
    if (j.h(this.P3)) {
      this.P3.postValue(Boolean.FALSE);
    }
  }
  
  private void k0(int paramInt, boolean paramBoolean)
  {
    if ((!s()) && (!v()))
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = this.p3;
        localObject[paramInt] += 1;
        if (this.S3.hasMessages(3))
        {
          b.d.w.c.a.c(this.c, "Already has CLOUD_TERRACE_CLICK_MERGE_MSG, record click and return.");
          return;
        }
        this.S3.sendEmptyMessageDelayed(3, 500L);
        b.d.w.c.a.c(this.c, "Send CLOUD_TERRACE_CLICK_MERGE_MSG after 500 MILLISECOND");
      }
      if (w())
      {
        localObject = this.J3.x(p()).H0(q.c, new d(this));
        this.I3.b((io.reactivex.e0.c)localObject);
        com.tplink.iot.Utils.x0.e.l(this.d);
      }
      else
      {
        b.d.w.c.a.c(this.c, "Has unavailable move info()");
      }
    }
  }
  
  private String o(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "0";
        }
        return "90";
      }
      return "180";
    }
    return "270";
  }
  
  private CloudTerraceMoveInfo p()
  {
    Object localObject = this.p3;
    localObject[3] -= localObject[1];
    localObject[0] -= localObject[2];
    int i = localObject[3];
    int j = this.H3;
    int k = localObject[0];
    localObject[3] = 0;
    localObject[2] = 0;
    localObject[1] = 0;
    localObject[0] = 0;
    localObject = new CloudTerraceMoveInfo(String.valueOf(k * j), String.valueOf(i * j));
    b.d.w.c.a.c(this.c, ((CloudTerraceMoveInfo)localObject).toString());
    return (CloudTerraceMoveInfo)localObject;
  }
  
  private void p0()
  {
    if (j.g(this.P3)) {
      this.P3.postValue(Boolean.TRUE);
    }
  }
  
  private String r(@StringRes int paramInt)
  {
    return getApplication().getString(paramInt);
  }
  
  private boolean s()
  {
    if (y())
    {
      this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(r(2131952356)));
      return true;
    }
    return false;
  }
  
  private void t(Throwable paramThrowable)
  {
    u(paramThrowable, Integer.valueOf(2131952741));
  }
  
  private void u(Throwable paramThrowable, @StringRes Integer paramInteger)
  {
    b.d.w.c.a.e(this.c, Log.getStackTraceString(paramThrowable));
    if ((paramThrowable instanceof CameraException)) {
      switch (((CameraException)paramThrowable).getErrorCode())
      {
      default: 
        break;
      case -64304: 
        this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(r(2131954405)));
        return;
      case -64305: 
      case -64303: 
        this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(r(2131952364)));
        return;
      }
    }
    if (paramInteger != null) {
      this.Q3.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(r(paramInteger.intValue())));
    }
  }
  
  private boolean v()
  {
    if (this.J3 == null)
    {
      t(new RuntimeException("cloudTerraceMoveRepository is null"));
      return true;
    }
    return false;
  }
  
  private boolean w()
  {
    int[] arrayOfInt = this.p3;
    int i = arrayOfInt[3];
    boolean bool = true;
    if (i - arrayOfInt[1] + arrayOfInt[0] - arrayOfInt[2] == 0) {
      bool = false;
    }
    return bool;
  }
  
  private void x(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    this.J3 = ((CloudTerraceMoveRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(paramTPCameraDeviceContext, CloudTerraceMoveRepository.class));
  }
  
  public int c()
  {
    int i;
    if (this.L3.getValue() == null) {
      i = 50;
    } else {
      i = ((Integer)this.L3.getValue()).intValue();
    }
    return i;
  }
  
  public void d(int paramInt)
  {
    this.L3.setValue(Integer.valueOf(paramInt));
  }
  
  public void j0(int paramInt)
  {
    k0(paramInt, true);
  }
  
  public void k()
  {
    if (v()) {
      return;
    }
    io.reactivex.e0.c localc = this.J3.t().F(new r(this)).y(new a(this)).H0(new n(this), new h(this));
    this.I3.b(localc);
  }
  
  public void l(boolean paramBoolean)
  {
    if ((!s()) && (!v()))
    {
      io.reactivex.e0.c localc = this.J3.u(paramBoolean).F(new p(this)).y(new a(this)).H0(new k(this, paramBoolean), new f(this));
      this.I3.b(localc);
    }
  }
  
  public void l0(int paramInt)
  {
    if ((!s()) && (!v()))
    {
      io.reactivex.e0.c localc = this.J3.y(o(paramInt)).H0(e.c, new s(this));
      this.I3.b(localc);
    }
  }
  
  public void m()
  {
    n(true, null);
  }
  
  public void m0(String paramString)
  {
    if (d0.a(this.d, paramString)) {
      return;
    }
    this.d = paramString;
    this.J3 = null;
    if (paramString != null)
    {
      x(TPIoTClientManager.K1(paramString));
      i0(paramString);
      i();
    }
  }
  
  public void n(boolean paramBoolean, Runnable paramRunnable)
  {
    if ((!s()) && (!v())) {
      if ((!j.h(this.N3)) && (!j.h(this.O3)))
      {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      else
      {
        paramRunnable = this.J3.v().l0(io.reactivex.d0.b.a.a()).F(new l(this, paramBoolean)).y(new a(this)).H0(new i(this, paramRunnable), new g(this, paramRunnable));
        this.I3.b(paramRunnable);
      }
    }
  }
  
  public void n0(LifecycleOwner paramLifecycleOwner)
  {
    paramLifecycleOwner.getLifecycle().addObserver(this);
    this.L3.observe(paramLifecycleOwner, new c(this));
  }
  
  public void o0(boolean paramBoolean)
  {
    this.R3 = paramBoolean;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroyed()
  {
    this.S3.removeCallbacks(this.T3);
    this.I3.d();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onActivityStarted()
  {
    i();
  }
  
  public void q0()
  {
    if ((!j.h(this.M3)) && (!v()))
    {
      io.reactivex.e0.c localc = this.J3.z().H0(b.c, new f(this));
      this.I3.b(localc);
    }
  }
  
  public boolean y()
  {
    return j.h(this.M3);
  }
  
  public boolean z()
  {
    boolean bool;
    if ((!j.h(this.O3)) && (!j.h(this.N3))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (paramMessage.what == 3)
      {
        b.d.w.c.a.c(CloudTerraceControlViewModel.f(CloudTerraceControlViewModel.this), "Handler handle CLOUD_TERRACE_CLICK_MERGE_MSG");
        CloudTerraceControlViewModel.g(CloudTerraceControlViewModel.this, -1, false);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\CloudTerraceControlViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */