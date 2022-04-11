package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.p;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;

public final class TamperDetectionRepository
  extends c
{
  public static final a d = new a(null);
  private p e = new p();
  
  public TamperDetectionRepository(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private final void v(TamperDetectConfig paramTamperDetectConfig)
  {
    this.e.e(kotlin.jvm.internal.j.a("on", paramTamperDetectConfig.getEnabled()));
    this.e.d(paramTamperDetectConfig.getDigitalSensitivity());
    this.e.f(paramTamperDetectConfig.getSensitivity());
  }
  
  public final p t()
  {
    return this.e;
  }
  
  public final q<TamperDetectConfig> u()
  {
    Object localObject = this.c;
    kotlin.jvm.internal.j.d(localObject, "cameraClient");
    localObject = ((f4)localObject).r0().i(m.a()).L0(a.c()).E(new b(this));
    kotlin.jvm.internal.j.d(localObject, "cameraClient.tamperDetec…nal(it)\n                }");
    return (q<TamperDetectConfig>)localObject;
  }
  
  public final q<Boolean> w(final TamperDetectConfig paramTamperDetectConfig)
  {
    kotlin.jvm.internal.j.e(paramTamperDetectConfig, "tamperDetectConfig");
    paramTamperDetectConfig = this.c.W2(paramTamperDetectConfig).i(m.a()).L0(a.c()).g0(new c(this, paramTamperDetectConfig));
    kotlin.jvm.internal.j.d(paramTamperDetectConfig, "cameraClient.setTamperDe…   true\n                }");
    return paramTamperDetectConfig;
  }
  
  public final void x(TamperDetectConfig paramTamperDetectConfig)
  {
    kotlin.jvm.internal.j.e(paramTamperDetectConfig, "tamperDetectConfig");
    v(paramTamperDetectConfig);
  }
  
  public static final class a {}
  
  static final class b<T>
    implements g<TamperDetectConfig>
  {
    b(TamperDetectionRepository paramTamperDetectionRepository) {}
    
    public final void a(TamperDetectConfig paramTamperDetectConfig)
    {
      TamperDetectionRepository localTamperDetectionRepository = this.c;
      kotlin.jvm.internal.j.d(paramTamperDetectConfig, "it");
      TamperDetectionRepository.s(localTamperDetectionRepository, paramTamperDetectConfig);
    }
  }
  
  static final class c<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    c(TamperDetectionRepository paramTamperDetectionRepository, TamperDetectConfig paramTamperDetectConfig) {}
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      TamperDetectionRepository.s(this.c, paramTamperDetectConfig);
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\TamperDetectionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */