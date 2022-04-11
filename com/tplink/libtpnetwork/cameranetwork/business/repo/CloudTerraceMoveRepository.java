package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.l0.a;
import io.reactivex.q;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.p;

public final class CloudTerraceMoveRepository
  extends c
{
  public CloudTerraceMoveRepository(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private final void w(Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof CameraException;
  }
  
  public final q<Boolean> t()
  {
    q localq = this.c.i2().i(m.g()).L0(a.c()).C(new h7(new a(this))).g0(b.c);
    kotlin.jvm.internal.j.d(localq, "cameraClient\n           …            .map { true }");
    return localq;
  }
  
  public final q<Boolean> u(boolean paramBoolean)
  {
    q localq = this.c.m(paramBoolean).i(m.g()).L0(a.c()).C(new h7(new c(this))).g0(d.c);
    kotlin.jvm.internal.j.d(localq, "cameraClient\n           …            .map { true }");
    return localq;
  }
  
  public final q<Boolean> v()
  {
    q localq = this.c.n().i(m.g()).L0(a.c()).C(new h7(new e(this))).g0(f.c);
    kotlin.jvm.internal.j.d(localq, "cameraClient\n           …            .map { true }");
    return localq;
  }
  
  public final q<Boolean> x(CloudTerraceMoveInfo paramCloudTerraceMoveInfo)
  {
    kotlin.jvm.internal.j.e(paramCloudTerraceMoveInfo, "info");
    paramCloudTerraceMoveInfo = this.c.o(paramCloudTerraceMoveInfo).i(m.g()).L0(a.c()).g0(g.c);
    kotlin.jvm.internal.j.d(paramCloudTerraceMoveInfo, "cameraClient\n           …            .map { true }");
    return paramCloudTerraceMoveInfo;
  }
  
  public final q<Boolean> y(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "direction");
    paramString = this.c.p(paramString).i(m.g()).L0(a.c()).g0(h.c);
    kotlin.jvm.internal.j.d(paramString, "cameraClient\n           …            .map { true }");
    return paramString;
  }
  
  public final q<Boolean> z()
  {
    q localq = this.c.f3().i(m.g()).L0(a.c()).C(new h7(new i(this))).g0(j.c);
    kotlin.jvm.internal.j.d(localq, "cameraClient\n           …            .map { true }");
    return localq;
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final b c = new b();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class d<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final d c = new d();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class f<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final f c = new f();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final g c = new g();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class h<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final h c = new h();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class j<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final j c = new j();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\CloudTerraceMoveRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */