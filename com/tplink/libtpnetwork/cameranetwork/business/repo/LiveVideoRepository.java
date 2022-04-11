package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.q;

public class LiveVideoRepository
  extends c
{
  private final MutableLiveData<NightMode> d = new MutableLiveData();
  private String e;
  
  public LiveVideoRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private void u(Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof CameraException;
  }
  
  private void v(NightMode paramNightMode)
  {
    this.d.postValue(paramNightMode);
  }
  
  public q<Boolean> E()
  {
    return l().X().i(m.a()).L0(io.reactivex.l0.a.c()).g0(g2.c).l0(io.reactivex.d0.b.a.a()).E(new b3(this)).g0(c3.c).C(new w2(this));
  }
  
  public q<Boolean> F()
  {
    return l().a0().i(m.a()).L0(io.reactivex.l0.a.c()).E(new a3(this)).l0(io.reactivex.d0.b.a.a()).g0(x2.c).C(new w2(this));
  }
  
  public q<Boolean> G(NightMode paramNightMode)
  {
    return l().N2(paramNightMode).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new w2(this)).E(y2.c).g0(z2.c);
  }
  
  public MutableLiveData<NightMode> s()
  {
    return this.d;
  }
  
  public String t()
  {
    return this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\LiveVideoRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */