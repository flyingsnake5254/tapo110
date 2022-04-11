package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.LensMaskInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.p;

public final class LensMaskRepository
  extends c
{
  public static final a d = new a(null);
  private final MutableLiveData<Boolean> e;
  private final TPCameraDeviceContext f;
  
  public LensMaskRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    this.f = paramTPCameraDeviceContext;
    this.e = new MutableLiveData();
  }
  
  private final void w(Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof CameraException;
  }
  
  public final q<Boolean> t(Boolean paramBoolean)
  {
    Boolean localBoolean = Boolean.TRUE;
    boolean bool = kotlin.jvm.internal.j.a(paramBoolean, localBoolean);
    final Object localObject = "off";
    if (bool) {}
    do
    {
      paramBoolean = "on";
      break;
      if (kotlin.jvm.internal.j.a(paramBoolean, Boolean.FALSE))
      {
        paramBoolean = (Boolean)localObject;
        break;
      }
      if (paramBoolean != null) {
        break label149;
      }
    } while (!kotlin.jvm.internal.j.a((Boolean)this.e.getValue(), localBoolean));
    paramBoolean = (Boolean)localObject;
    localObject = (Boolean)this.e.getValue();
    paramBoolean = this.c.E2(new LensMaskInfo(paramBoolean)).i(m.g()).L0(a.c()).g0(b.c).E(new c(this, (Boolean)localObject)).C(new i7(new d(this)));
    kotlin.jvm.internal.j.d(paramBoolean, "cameraClient\n           …nError(this::handleError)");
    return paramBoolean;
    label149:
    throw new NoWhenBranchMatchedException();
  }
  
  public final q<Boolean> u(Boolean paramBoolean)
  {
    Boolean localBoolean = Boolean.TRUE;
    boolean bool = kotlin.jvm.internal.j.a(paramBoolean, localBoolean);
    final Object localObject = "off";
    if (bool) {}
    do
    {
      paramBoolean = "on";
      break;
      if (kotlin.jvm.internal.j.a(paramBoolean, Boolean.FALSE))
      {
        paramBoolean = (Boolean)localObject;
        break;
      }
      if (paramBoolean != null) {
        break label149;
      }
    } while (!kotlin.jvm.internal.j.a((Boolean)this.e.getValue(), localBoolean));
    paramBoolean = (Boolean)localObject;
    localObject = (Boolean)this.e.getValue();
    paramBoolean = this.c.F2(new LensMaskInfo(paramBoolean)).i(m.g()).L0(a.c()).g0(e.c).E(new f(this, (Boolean)localObject)).C(new i7(new g(this)));
    kotlin.jvm.internal.j.d(paramBoolean, "cameraClient\n           …nError(this::handleError)");
    return paramBoolean;
    label149:
    throw new NoWhenBranchMatchedException();
  }
  
  public final TPCameraDeviceContext v()
  {
    return this.f;
  }
  
  public final MutableLiveData<Boolean> x()
  {
    return this.e;
  }
  
  public final q<Boolean> y()
  {
    return A(this, false, 1, null);
  }
  
  public final q<Boolean> z(boolean paramBoolean)
  {
    Object localObject;
    if ((!paramBoolean) && (this.e.getValue() != null))
    {
      localObject = q.f0(this.e.getValue());
      kotlin.jvm.internal.j.d(localObject, "Observable.just(isMaskedLiveData.value)");
    }
    else
    {
      localObject = this.c;
      kotlin.jvm.internal.j.d(localObject, "cameraClient");
      localObject = ((f4)localObject).W().i(m.a()).L0(a.c()).g0(h.c).E(new i(this)).C(new i7(new j(this)));
      kotlin.jvm.internal.j.d(localObject, "cameraClient\n           …nError(this::handleError)");
    }
    return (q<Boolean>)localObject;
  }
  
  public static final class a {}
  
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
  
  static final class c<T>
    implements g<Boolean>
  {
    c(LensMaskRepository paramLensMaskRepository, Boolean paramBoolean) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.x().postValue(Boolean.valueOf(kotlin.jvm.internal.j.a(localObject, Boolean.valueOf(paramBoolean.booleanValue() ^ true))));
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<Boolean, Boolean>
  {
    public static final e c = new e();
    
    public final Boolean a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class f<T>
    implements g<Boolean>
  {
    f(LensMaskRepository paramLensMaskRepository, Boolean paramBoolean) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.x().postValue(Boolean.valueOf(kotlin.jvm.internal.j.a(localObject, Boolean.valueOf(paramBoolean.booleanValue() ^ true))));
    }
  }
  
  static final class h<T, R>
    implements io.reactivex.g0.j<LensMaskInfo, Boolean>
  {
    public static final h c = new h();
    
    public final Boolean a(LensMaskInfo paramLensMaskInfo)
    {
      kotlin.jvm.internal.j.e(paramLensMaskInfo, "it");
      return Boolean.valueOf(kotlin.jvm.internal.j.a(paramLensMaskInfo.getEnabled(), "on"));
    }
  }
  
  static final class i<T>
    implements g<Boolean>
  {
    i(LensMaskRepository paramLensMaskRepository) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.c.x().postValue(paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\LensMaskRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */