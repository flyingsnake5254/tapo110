package com.tplink.iot.c.c;

import android.os.Build;
import androidx.annotation.NonNull;
import b.d.b.e.k;
import com.tplink.cloud.context.a;
import com.tplink.iot.c.d.p;
import com.tplink.iot.c.d.p.a;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import okhttp3.logging.HttpLoggingInterceptor.Logger;

public class b
  implements p.a
{
  private final String a;
  private final String b;
  private String c;
  private final String d;
  private final String e;
  private String f;
  private final String g;
  private final a h;
  private final k i;
  private final HttpLoggingInterceptor.Logger j;
  private final p k;
  
  public b(String paramString1, IoTWebServiceIdParams paramIoTWebServiceIdParams, String paramString2, @NonNull a parama)
  {
    n(paramString2);
    this.h = parama;
    paramIoTWebServiceIdParams = parama.b();
    this.a = paramIoTWebServiceIdParams;
    paramString2 = parama.q();
    this.b = paramString2;
    this.d = String.format("app:%1$s:%2$s", new Object[] { paramIoTWebServiceIdParams, paramString2 });
    this.e = String.format("%1$s:v%2$s:%3$s:%4$s", new Object[] { paramIoTWebServiceIdParams, parama.d(), parama.o(), parama.l() });
    this.f = null;
    this.g = String.format("%1$s/%2$s(%3$s/;%4$s)", new Object[] { parama.b(), parama.d(), Build.MODEL, parama.o() });
    this.i = parama.i();
    this.j = parama.h();
    this.k = new p(paramString1, this);
  }
  
  public String a()
  {
    return this.h.d();
  }
  
  public String b()
  {
    return this.h.n();
  }
  
  public String c()
  {
    return this.h.l();
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public k f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public String getUserAgent()
  {
    return this.g;
  }
  
  public HttpLoggingInterceptor.Logger h()
  {
    return this.j;
  }
  
  public String i()
  {
    return this.a;
  }
  
  public String j()
  {
    return this.b;
  }
  
  public String k()
  {
    return this.e;
  }
  
  public p l()
  {
    return this.k;
  }
  
  public void m(String paramString)
  {
    this.f = paramString;
  }
  
  public void n(String paramString)
  {
    if (paramString != null) {
      this.c = String.format("ut|%s", new Object[] { paramString });
    } else {
      this.c = null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */