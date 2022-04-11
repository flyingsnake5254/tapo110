package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.l;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ConnectStatus;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.model.WifiList;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class OnBoardingRepository
  extends c
{
  public OnBoardingRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    f4 localf4 = new f4();
    this.c = localf4;
    localf4.j3(paramTPCameraDeviceContext);
  }
  
  private void w(String paramString) {}
  
  public q<Boolean> G()
  {
    return l().j2().x0(new l(3, 3000)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(w3.c);
  }
  
  public q<WifiList> H()
  {
    return l().l2().x0(new l(3, 3000)).i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new z3(this));
  }
  
  public q<Boolean> I(AutoUpdateInfo paramAutoUpdateInfo)
  {
    return l().o2(paramAutoUpdateInfo).x0(new l(1, 3000)).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public q<String> J(String paramString)
  {
    return l().q2(paramString).x0(new l(1, 3000)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(j2.c).E(new x3(this));
  }
  
  public q<String> K(String paramString)
  {
    return l().C2(paramString).x0(new l(3, 3000)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(j2.c).E(new x3(this));
  }
  
  public q<Boolean> s()
  {
    return l().l().x0(new l(3, 3000)).i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new y3(this)).g0(v3.c);
  }
  
  public q<String> t(Wifi paramWifi, String paramString)
  {
    return l().q(paramWifi.connectWithPassword(paramString)).x0(new l(3, 3000)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(j2.c).E(new x3(this));
  }
  
  public q<CameraComponent> u()
  {
    return l().E().x0(new l(1, 3000)).i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a());
  }
  
  public q<ConnectStatus> v()
  {
    return l().F().T0(10L, TimeUnit.SECONDS).x0(new l(5, 1000)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new u3(this)).g0(e7.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\OnBoardingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */