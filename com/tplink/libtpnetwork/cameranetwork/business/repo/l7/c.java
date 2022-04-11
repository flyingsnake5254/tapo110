package com.tplink.libtpnetwork.cameranetwork.business.repo.l7;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import io.reactivex.q;

public class c
  extends com.tplink.libtpnetwork.IoTNetwork.repository.kb.c<TPCameraDeviceContext>
{
  @NonNull
  protected f4 c;
  
  public c(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    paramTPCameraDeviceContext = this.b.J1(paramTPCameraDeviceContext.getDeviceIdMD5());
    this.c = paramTPCameraDeviceContext;
    if (paramTPCameraDeviceContext == null) {
      this.c = new f4();
    }
  }
  
  protected void c() {}
  
  public q<Boolean> d()
  {
    return q.f0(Boolean.FALSE);
  }
  
  protected void e() {}
  
  public q<Boolean> f()
  {
    return q.f0(Boolean.FALSE);
  }
  
  public q<Boolean> g()
  {
    return q.f0(Boolean.FALSE);
  }
  
  public q<Boolean> h()
  {
    return q.f0(Boolean.FALSE);
  }
  
  public io.reactivex.a i(boolean paramBoolean)
  {
    return io.reactivex.a.e();
  }
  
  public q<Boolean> j()
  {
    return q.f0(Boolean.FALSE);
  }
  
  public io.reactivex.a k()
  {
    return io.reactivex.a.e();
  }
  
  public f4 l()
  {
    return this.c;
  }
  
  public q<f4> m(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    f4 localf4 = new f4();
    this.c = localf4;
    localf4.j3(paramTPCameraDeviceContext);
    return this.c.d2(null).L0(io.reactivex.l0.a.c()).g0(new b(this));
  }
  
  public q<f4> n(TPCameraDeviceContext paramTPCameraDeviceContext, Account paramAccount)
  {
    f4 localf4 = new f4();
    this.c = localf4;
    localf4.j3(paramTPCameraDeviceContext);
    return this.c.d2(paramAccount).L0(io.reactivex.l0.a.c()).g0(new a(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\l7\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */