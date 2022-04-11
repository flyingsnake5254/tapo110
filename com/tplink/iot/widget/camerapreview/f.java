package com.tplink.iot.widget.camerapreview;

import b.d.b.f.b;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareUpdateLevel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import io.reactivex.q;

public final class f
{
  private final FirmwareManager a;
  
  public f()
  {
    b.d.b.f.a locala = b.a(b.d.s.a.a.f(), FirmwareManager.class);
    kotlin.jvm.internal.j.d(locala, "CloudRepositoryProviders…Manager::class.java\n    )");
    this.a = ((FirmwareManager)locala);
  }
  
  public final q<e> a(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
    q localq = this.a.h(paramString);
    paramString = this.a.g(paramString);
    if (paramString == null) {
      paramString = new u();
    }
    paramString = localq.E0(paramString).g0(a.c);
    kotlin.jvm.internal.j.d(paramString, "firmwareManager\n        …          }\n            }");
    return paramString;
  }
  
  static final class a<T, R>
    implements io.reactivex.g0.j<u, e>
  {
    public static final a c = new a();
    
    public final e a(u paramu)
    {
      kotlin.jvm.internal.j.e(paramu, "it");
      if (paramu.f())
      {
        if (FirmwareUpdateLevel.LEVEL4 == paramu.b()) {
          return e.a.c().B("Force update");
        }
        return e.a.g().B("No update");
      }
      return e.a.n().B("Updating");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */