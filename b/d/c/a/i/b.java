package b.d.c.a.i;

import android.os.Handler;
import android.os.HandlerThread;
import b.d.c.c.c;

public class b
{
  private Handler a = new Handler(com.tplink.libtpanalytics.core.define.a.c.getLooper());
  private long b = 0L;
  private boolean c = false;
  private b.d.c.c.b d;
  private c e;
  
  public b(b.d.c.c.b paramb, c paramc)
  {
    this.d = paramb;
    this.e = paramc;
  }
  
  private com.tplink.libtpanalytics.database.d.b k(com.tplink.libtpanalytics.database.d.b paramb)
  {
    try
    {
      String str = paramb.d();
      paramb.q(this.e.a(str));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramb;
  }
  
  private void o(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (com.tplink.libtpanalytics.utils.f.a())
    {
      this.b = System.currentTimeMillis();
      c localc = this.e;
      if ((localc != null) && ((localc instanceof com.tplink.libtpanalytics.utils.l.f))) {
        paramb.p(((com.tplink.libtpanalytics.utils.l.f)localc).d());
      }
      this.a.post(new a(this, paramb));
    }
  }
  
  public void a(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void b(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void c(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void d(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void e(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void f(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void g(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void h(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void i(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public void j(com.tplink.libtpanalytics.database.d.b paramb)
  {
    if (!this.c) {
      return;
    }
    o(paramb);
  }
  
  public long l()
  {
    return this.b;
  }
  
  public void p(boolean paramBoolean)
  {
    this.b = 0L;
    this.c = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */