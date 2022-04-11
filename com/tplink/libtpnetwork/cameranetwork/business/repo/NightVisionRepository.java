package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionCapability;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;
import com.tplink.libtpnetwork.cameranetwork.model.WhiteLampConfig;
import com.tplink.libtpnetwork.cameranetwork.model.WhitelampState;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import java.util.ArrayList;

public final class NightVisionRepository
  extends c
{
  private boolean d;
  private NightVisionModeType e;
  private final ArrayList<NightVisionModeType> f = new ArrayList();
  private String g;
  
  public NightVisionRepository(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  public final q<Boolean> A(final NightVisionModeType paramNightVisionModeType)
  {
    kotlin.jvm.internal.j.e(paramNightVisionModeType, "mode");
    NightVisionMode localNightVisionMode = new NightVisionMode(paramNightVisionModeType);
    paramNightVisionModeType = this.c.O2(localNightVisionMode).i(m.a()).E(new i(this, paramNightVisionModeType)).g0(j.c).C(k.c).L0(a.c());
    kotlin.jvm.internal.j.d(paramNightVisionModeType, "cameraClient.setNightVis…scribeOn(Schedulers.io())");
    return paramNightVisionModeType;
  }
  
  public final void B(String paramString)
  {
    this.g = paramString;
  }
  
  public final q<Boolean> C(final int paramInt)
  {
    Object localObject = new WhiteLampConfig(paramInt);
    localObject = this.c.b3((WhiteLampConfig)localObject).i(m.a()).E(new l(this, paramInt)).g0(m.c).L0(a.c());
    kotlin.jvm.internal.j.d(localObject, "cameraClient.setWhiteLam…scribeOn(Schedulers.io())");
    return (q<Boolean>)localObject;
  }
  
  public final void D(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void E(NightVisionCapability paramNightVisionCapability)
  {
    kotlin.jvm.internal.j.e(paramNightVisionCapability, "nightVisionCapability");
    this.f.clear();
    this.f.addAll(paramNightVisionCapability.getNightVisionModeTypes());
  }
  
  public final void F(ImageFlip paramImageFlip)
  {
    boolean bool;
    if (paramImageFlip != null) {
      bool = paramImageFlip.isWhiteLampOn();
    } else {
      bool = false;
    }
    this.d = bool;
    if (paramImageFlip != null) {
      paramImageFlip = paramImageFlip.getNightVisionModeType();
    } else {
      paramImageFlip = null;
    }
    this.e = paramImageFlip;
  }
  
  public final q<Boolean> s()
  {
    Object localObject = this.c;
    kotlin.jvm.internal.j.d(localObject, "cameraClient");
    localObject = ((f4)localObject).P().i(m.a()).E(new a(this)).g0(b.c).C(c.c).L0(a.c());
    kotlin.jvm.internal.j.d(localObject, "cameraClient.forceWhitel…scribeOn(Schedulers.io())");
    return (q<Boolean>)localObject;
  }
  
  public final NightVisionModeType t()
  {
    return this.e;
  }
  
  public final ArrayList<NightVisionModeType> u()
  {
    return this.f;
  }
  
  public final String v()
  {
    return this.g;
  }
  
  public final q<Boolean> w()
  {
    Object localObject = this.c;
    kotlin.jvm.internal.j.d(localObject, "cameraClient");
    localObject = ((f4)localObject).A0().i(m.a()).E(new d(this)).g0(e.c).L0(a.c());
    kotlin.jvm.internal.j.d(localObject, "cameraClient.whiteLampCo…scribeOn(Schedulers.io())");
    return (q<Boolean>)localObject;
  }
  
  public final boolean x()
  {
    return this.d;
  }
  
  public final q<Boolean> y(final boolean paramBoolean)
  {
    Object localObject = new WhitelampState(paramBoolean);
    localObject = this.c.w2((WhitelampState)localObject).i(m.a()).E(new f(this, paramBoolean)).g0(g.c).C(h.c).L0(a.c());
    kotlin.jvm.internal.j.d(localObject, "cameraClient.setForceWhi…scribeOn(Schedulers.io())");
    return (q<Boolean>)localObject;
  }
  
  public final void z(NightVisionModeType paramNightVisionModeType)
  {
    this.e = paramNightVisionModeType;
  }
  
  static final class a<T>
    implements g<ImageFlip>
  {
    a(NightVisionRepository paramNightVisionRepository) {}
    
    public final void a(ImageFlip paramImageFlip)
    {
      NightVisionRepository localNightVisionRepository = this.c;
      boolean bool;
      if (paramImageFlip != null) {
        bool = paramImageFlip.isWhiteLampOn();
      } else {
        bool = false;
      }
      localNightVisionRepository.D(bool);
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<ImageFlip, Boolean>
  {
    public static final b c = new b();
    
    public final Boolean a(ImageFlip paramImageFlip)
    {
      kotlin.jvm.internal.j.e(paramImageFlip, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    public static final c c = new c();
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
  
  static final class d<T>
    implements g<ImageFlip>
  {
    d(NightVisionRepository paramNightVisionRepository) {}
    
    public final void a(ImageFlip paramImageFlip)
    {
      if (paramImageFlip != null) {
        this.c.B(paramImageFlip.getWtlIntensityLevel());
      }
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<ImageFlip, Boolean>
  {
    public static final e c = new e();
    
    public final Boolean a(ImageFlip paramImageFlip)
    {
      kotlin.jvm.internal.j.e(paramImageFlip, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class f<T>
    implements g<Object>
  {
    f(NightVisionRepository paramNightVisionRepository, boolean paramBoolean) {}
    
    public final void accept(Object paramObject)
    {
      this.c.D(paramBoolean);
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    public static final g c = new g();
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class h<T>
    implements g<Throwable>
  {
    public static final h c = new h();
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
  
  static final class i<T>
    implements g<Object>
  {
    i(NightVisionRepository paramNightVisionRepository, NightVisionModeType paramNightVisionModeType) {}
    
    public final void accept(Object paramObject)
    {
      this.c.z(paramNightVisionModeType);
    }
  }
  
  static final class j<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    public static final j c = new j();
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      return Boolean.TRUE;
    }
  }
  
  static final class k<T>
    implements g<Throwable>
  {
    public static final k c = new k();
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
  
  static final class l<T>
    implements g<Object>
  {
    l(NightVisionRepository paramNightVisionRepository, int paramInt) {}
    
    public final void accept(Object paramObject)
    {
      this.c.B(String.valueOf(paramInt));
    }
  }
  
  static final class m<T, R>
    implements io.reactivex.g0.j<Object, Boolean>
  {
    public static final m c = new m();
    
    public final Boolean a(Object paramObject)
    {
      kotlin.jvm.internal.j.e(paramObject, "it");
      return Boolean.TRUE;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\NightVisionRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */