package com.tplink.iot.widget.camerapreview;

import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import b.d.d.m.f;
import com.hannesdorfmann.mosby3.mvi.c.c;
import com.hannesdorfmann.mosby3.mvi.c.d;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import io.reactivex.q;
import io.reactivex.t;
import kotlin.jvm.internal.FunctionReferenceImpl;

public final class b
  extends com.hannesdorfmann.mosby3.mvi.c<d, e>
{
  private String i;
  private final a j = new a();
  private d k;
  
  private final e r(e parame1, e parame2)
  {
    Boolean localBoolean = parame2.z();
    Object localObject = Boolean.FALSE;
    if ((kotlin.jvm.internal.j.a(localBoolean, localObject)) && (kotlin.jvm.internal.j.a(parame2.v(), localObject)) && (parame2.w() == null))
    {
      localObject = parame1.z();
      localBoolean = Boolean.TRUE;
      if (!kotlin.jvm.internal.j.a(localObject, localBoolean))
      {
        localObject = parame1;
        if (!kotlin.jvm.internal.j.a(parame1.v(), localBoolean)) {}
      }
      else
      {
        localObject = parame2.A(parame1);
      }
      return (e)localObject;
    }
    return parame2.A(parame1);
  }
  
  public void destroy()
  {
    super.destroy();
    this.j.b();
  }
  
  protected void e()
  {
    q localq = q.h0(g(h.a).O0(new i(this)).l0(io.reactivex.d0.b.a.a()), g(f.a).O0(new g(this)).l0(io.reactivex.d0.b.a.a()), g(b.a).O0(new c(this)).l0(io.reactivex.d0.b.a.a()), g(d.a).O0(new e(this)).l0(io.reactivex.d0.b.a.a())).z0(e.a.e().B("initialViewState"), new j(this));
    a locala = a.c;
    Object localObject = locala;
    if (locala != null) {
      localObject = new c(locala);
    }
    i(localq, (c.d)localObject);
  }
  
  public void o(d paramd)
  {
    kotlin.jvm.internal.j.e(paramd, "view");
    super.a(paramd);
    this.k = paramd;
  }
  
  public final MutableLiveData<f<String>> p()
  {
    return this.j.d();
  }
  
  public final void q(String paramString)
  {
    this.i = paramString;
    this.j.g(paramString);
  }
  
  static final class b<V extends com.hannesdorfmann.mosby3.k.b, I>
    implements c.c<d, CameraPreviewInfo>
  {
    public static final b a = new b();
    
    public final q<CameraPreviewInfo> b(d paramd)
    {
      kotlin.jvm.internal.j.e(paramd, "it");
      return paramd.K();
    }
  }
  
  static final class c<T, R>
    implements io.reactivex.g0.j<CameraPreviewInfo, t<? extends e>>
  {
    c(b paramb) {}
    
    public final t<? extends e> a(CameraPreviewInfo paramCameraPreviewInfo)
    {
      kotlin.jvm.internal.j.e(paramCameraPreviewInfo, "previewInfo");
      return b.m(this.c).i(paramCameraPreviewInfo);
    }
  }
  
  static final class d<V extends com.hannesdorfmann.mosby3.k.b, I>
    implements c.c<d, Boolean>
  {
    public static final d a = new d();
    
    public final q<Boolean> b(d paramd)
    {
      kotlin.jvm.internal.j.e(paramd, "it");
      return paramd.getFirmwareIntent();
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends e>>
  {
    e(b paramb) {}
    
    public final t<? extends e> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "it");
      return b.m(this.c).c();
    }
  }
  
  static final class f<V extends com.hannesdorfmann.mosby3.k.b, I>
    implements c.c<d, Boolean>
  {
    public static final f a = new f();
    
    public final q<Boolean> b(d paramd)
    {
      kotlin.jvm.internal.j.e(paramd, "it");
      return paramd.P();
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends e>>
  {
    g(b paramb) {}
    
    public final t<? extends e> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "visible");
      return b.m(this.c).a(paramBoolean.booleanValue());
    }
  }
  
  static final class h<V extends com.hannesdorfmann.mosby3.k.b, I>
    implements c.c<d, Boolean>
  {
    public static final h a = new h();
    
    public final q<Boolean> b(d paramd)
    {
      kotlin.jvm.internal.j.e(paramd, "it");
      return paramd.x0();
    }
  }
  
  static final class i<T, R>
    implements io.reactivex.g0.j<Boolean, t<? extends e>>
  {
    i(b paramb) {}
    
    public final t<? extends e> a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.e(paramBoolean, "isPlay");
      a locala = b.m(this.c);
      if (paramBoolean.booleanValue())
      {
        paramBoolean = b.l(this.c);
        kotlin.jvm.internal.j.c(paramBoolean);
        ViewGroup localViewGroup = paramBoolean.getParentView();
        paramBoolean = b.l(this.c);
        kotlin.jvm.internal.j.c(paramBoolean);
        paramBoolean = locala.f(localViewGroup, paramBoolean.getContextForView());
      }
      else
      {
        paramBoolean = locala.e();
      }
      return paramBoolean;
    }
  }
  
  static final class j<T1, T2, R>
    implements io.reactivex.g0.c<e, e, e>
  {
    j(b paramb) {}
    
    public final e a(e parame1, e parame2)
    {
      kotlin.jvm.internal.j.e(parame1, "t1");
      kotlin.jvm.internal.j.e(parame2, "t2");
      parame1 = b.n(this.c, parame1, parame2);
      parame2 = b.m(this.c);
      kotlin.jvm.internal.j.d(parame1, "this");
      parame2.h(parame1);
      return parame1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */