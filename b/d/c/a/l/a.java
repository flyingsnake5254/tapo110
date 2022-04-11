package b.d.c.a.l;

import b.d.c.a.m.c;
import com.tplink.libtpanalytics.bean.ScreenViewParams;
import com.tplink.libtpanalytics.core.define.e;

public class a
  extends b.d.c.a.d
{
  private b.d.c.a.i.b b;
  private boolean c = true;
  
  public a(e parame, b.d.c.a.i.b paramb)
  {
    super(parame);
    this.b = paramb;
  }
  
  public void b()
  {
    this.c = true;
  }
  
  public void c(String paramString)
  {
    b.d.c.b.b localb = new b.d.c.b.b("screen_view", this.a);
    localb.d(new ScreenViewParams(paramString));
    paramString = b.d.c.b.a.a(localb);
    if (paramString != null)
    {
      this.b.h(paramString);
      if (!this.c) {
        c.f().e();
      }
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    b.d.c.b.b localb = new b.d.c.b.b("screen_view", this.a);
    paramString2 = new ScreenViewParams(paramString2);
    paramString2.setScreenClass(paramString1);
    localb.d(paramString2);
    paramString1 = b.d.c.b.a.a(localb);
    if (paramString1 != null)
    {
      this.b.h(paramString1);
      if (!this.c) {
        c.f().e();
      }
    }
  }
  
  public void e()
  {
    this.c = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */