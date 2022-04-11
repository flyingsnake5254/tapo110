package com.tplink.iot.widget.camerapreview;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import io.reactivex.e0.b;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public final class a
{
  private String a;
  private final f b = new f();
  private final h c = new h();
  private e d = e.a.e();
  private final b e = new b();
  
  public final q<e> a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = e.a;
      localObject = q.j(q.f0(((e.a)localObject).l().B("ShowFuncBtn")), q.f0(((e.a)localObject).d().B("HideFuncBtn after 5s")).o(5L, TimeUnit.SECONDS));
      kotlin.jvm.internal.j.d(localObject, "Observable.concat(\n     …it.SECONDS)\n            )");
    }
    else
    {
      localObject = q.f0(e.a.d().B("HideFuncBtn"));
      kotlin.jvm.internal.j.d(localObject, "Observable.just(DisplayV…().setTag(\"HideFuncBtn\"))");
    }
    return (q<e>)localObject;
  }
  
  public final void b()
  {
    this.e.d();
    this.c.c();
  }
  
  public final q<e> c()
  {
    f localf = this.b;
    String str = this.a;
    kotlin.jvm.internal.j.c(str);
    return localf.a(str);
  }
  
  public final MutableLiveData<b.d.d.m.f<String>> d()
  {
    return this.c.d();
  }
  
  public final q<e> e()
  {
    Object localObject1 = this.d.x();
    Object localObject2 = Boolean.TRUE;
    if ((!kotlin.jvm.internal.j.a(localObject1, localObject2)) && ((!(kotlin.jvm.internal.j.a(this.d.z(), localObject2) ^ true)) || (!kotlin.jvm.internal.j.a(this.d.u(), localObject2))))
    {
      localObject1 = q.f0(this.d.B("pause no operation"));
      kotlin.jvm.internal.j.d(localObject1, "Observable.just(displayV…ag(\"pause no operation\"))");
    }
    else
    {
      localObject1 = this.c;
      localObject2 = this.a;
      kotlin.jvm.internal.j.c(localObject2);
      localObject1 = ((h)localObject1).e((String)localObject2).p0(a.c).L0(io.reactivex.l0.a.c());
      kotlin.jvm.internal.j.d(localObject1, "streamDisplayEngine\n    …scribeOn(Schedulers.io())");
    }
    return (q<e>)localObject1;
  }
  
  public final q<e> f(ViewGroup paramViewGroup, Context paramContext)
  {
    kotlin.jvm.internal.j.e(paramViewGroup, "viewGroup");
    kotlin.jvm.internal.j.e(paramContext, "context");
    if (kotlin.jvm.internal.j.a(this.d.x(), Boolean.TRUE))
    {
      paramViewGroup = q.f0(this.d.B("play no operation"));
      kotlin.jvm.internal.j.d(paramViewGroup, "Observable.just(displayV…Tag(\"play no operation\"))");
    }
    else
    {
      h localh = this.c;
      String str = this.a;
      kotlin.jvm.internal.j.c(str);
      paramViewGroup = localh.f(str, paramViewGroup, paramContext).E0(e.a.f().B("playPreLoading")).p0(b.c).L0(io.reactivex.l0.a.c());
      kotlin.jvm.internal.j.d(paramViewGroup, "streamDisplayEngine\n    …scribeOn(Schedulers.io())");
    }
    return paramViewGroup;
  }
  
  public final void g(String paramString)
  {
    this.a = paramString;
    if (paramString != null) {
      this.c.g(paramString);
    }
  }
  
  public final void h(e parame)
  {
    kotlin.jvm.internal.j.e(parame, "<set-?>");
    this.d = parame;
  }
  
  public final q<e> i(CameraPreviewInfo paramCameraPreviewInfo)
  {
    kotlin.jvm.internal.j.e(paramCameraPreviewInfo, "previewInfo");
    if (paramCameraPreviewInfo.m()) {
      paramCameraPreviewInfo = e.a.k(paramCameraPreviewInfo.l(), paramCameraPreviewInfo.f(), Boolean.valueOf(paramCameraPreviewInfo.h())).B("device info");
    } else {
      paramCameraPreviewInfo = e.a.j(paramCameraPreviewInfo.l(), paramCameraPreviewInfo.f(), Boolean.valueOf(paramCameraPreviewInfo.h())).B("device info");
    }
    paramCameraPreviewInfo = q.f0(paramCameraPreviewInfo);
    kotlin.jvm.internal.j.d(paramCameraPreviewInfo, "Observable.just(\n       …(\"device info\")\n        )");
    return paramCameraPreviewInfo;
  }
  
  static final class a<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    public static final a c = new a();
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "it");
      return e.a.b(paramThrowable);
    }
  }
  
  static final class b<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    public static final b c = new b();
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "it");
      return e.a.b(paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */