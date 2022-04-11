package b.d.c.a.g;

import b.d.c.a.h.j;
import b.d.c.a.m.c;
import com.tplink.libtpanalytics.core.define.e;
import com.tplink.libtpanalytics.core.define.f;

public class a
  extends b.d.c.a.d
{
  private volatile boolean b = true;
  private b.d.c.a.i.b c;
  private boolean d = true;
  
  public a(e parame, b.d.c.a.i.b paramb)
  {
    super(parame);
    this.c = paramb;
  }
  
  private void b()
  {
    com.tplink.libtpanalytics.database.d.b localb = b.d.c.b.a.a(new b.d.c.b.b("enter_background", this.a));
    if (localb != null) {
      this.c.d(localb);
    }
  }
  
  private void c()
  {
    com.tplink.libtpanalytics.database.d.b localb = b.d.c.b.a.a(new b.d.c.b.b("enter_foreground", this.a));
    if (localb != null) {
      this.c.e(localb);
    }
  }
  
  private void e()
  {
    b.d.c.a.m.b.f().c();
  }
  
  private void f()
  {
    c.f().c();
  }
  
  private void g()
  {
    if ((System.currentTimeMillis() - this.c.l()) / 1000L > 1800L) {
      d();
    }
  }
  
  private void j()
  {
    b.d.c.a.m.b.f().e();
  }
  
  private void k()
  {
    c.f().e();
  }
  
  public void d()
  {
    f.a().c();
    com.tplink.libtpanalytics.database.d.b localb = b.d.c.b.a.a(new b.d.c.b.b("session_start", this.a));
    if (localb != null) {
      this.c.i(localb);
    }
  }
  
  public void h()
  {
    this.b = false;
    this.d = true;
    b();
    j.a().b("bg");
    f();
    e();
  }
  
  public void i()
  {
    if (!this.d) {
      j.a().b("timer");
    }
  }
  
  public void l()
  {
    this.d = false;
    if (!this.b)
    {
      g();
      c();
      k();
      j();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */