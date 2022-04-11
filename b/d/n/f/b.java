package b.d.n.f;

import android.app.Activity;
import android.text.TextUtils;
import b.d.n.f.c.m;
import b.d.n.f.c.n;
import b.d.n.f.c.o;
import b.d.n.i.g;
import b.d.n.i.h;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;

public final class b
  implements g
{
  private static final String a = "b";
  private static g b;
  private static volatile boolean c = false;
  private n d;
  private o e;
  private m f;
  private IAMRepository g;
  private b.d.n.i.e h;
  
  static
  {
    m();
    io.reactivex.j0.a.A(a.c);
  }
  
  private boolean j()
  {
    if (!c) {
      b.d.n.j.e.a("please call init(...) method first!!");
    }
    return c;
  }
  
  private boolean k(com.tplink.libtpinappmessaging.model.b paramb)
  {
    if (paramb == null)
    {
      paramb = new StringBuilder();
      paramb.append(a);
      paramb.append(" iamContext is null!!");
      b.d.n.j.e.a(paramb.toString());
      return false;
    }
    if (paramb.b() == null)
    {
      paramb = new StringBuilder();
      paramb.append(a);
      paramb.append(" application is null!!");
      b.d.n.j.e.a(paramb.toString());
      return false;
    }
    if (TextUtils.isEmpty(paramb.e()))
    {
      paramb = new StringBuilder();
      paramb.append(a);
      paramb.append(" url is empty!!");
      b.d.n.j.e.a(paramb.toString());
      return false;
    }
    if (paramb.c() == null)
    {
      paramb = new StringBuilder();
      paramb.append(a);
      paramb.append(" iamLogEventHandler is null!!");
      b.d.n.j.e.a(paramb.toString());
      return false;
    }
    if (paramb.d() == null)
    {
      paramb = new StringBuilder();
      paramb.append(a);
      paramb.append(" tcAccountContext is null!!");
      b.d.n.j.e.a(paramb.toString());
      return false;
    }
    if (TextUtils.isEmpty(paramb.a()))
    {
      paramb = new StringBuilder();
      paramb.append(a);
      paramb.append(" appType is empty!!");
      b.d.n.j.e.a(paramb.toString());
      return false;
    }
    return true;
  }
  
  public static g l()
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          b localb = new b/d/n/f/b;
          localb.<init>();
          b = localb;
        }
      }
      finally {}
    }
    return b;
  }
  
  private static void m()
  {
    System.setProperty("rx2.purge-enabled", "true");
    System.setProperty("rx2.purge-period-seconds", "6000");
  }
  
  public void a(String paramString)
  {
    if (j())
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new StringBuilder();
        paramString.append(a);
        paramString.append(" accountId is empty!!");
        b.d.n.j.e.a(paramString.toString());
        return;
      }
      if (paramString.equals(this.g.o())) {
        return;
      }
      b.d.n.j.d.c().f(paramString);
      this.g.H(paramString);
      this.d.o();
      this.e.g();
    }
  }
  
  public void b()
  {
    if (j()) {
      this.h.b();
    }
  }
  
  public void c()
  {
    if (j()) {
      this.g.G();
    }
  }
  
  public void clear()
  {
    if (j())
    {
      this.g.k();
      b.d.n.j.d.c().b();
    }
  }
  
  public void d(Activity paramActivity)
  {
    if (j())
    {
      if (paramActivity == null)
      {
        paramActivity = new StringBuilder();
        paramActivity.append(a);
        paramActivity.append(" context is null!!");
        b.d.n.j.e.a(paramActivity.toString());
        return;
      }
      this.h.d(paramActivity);
    }
  }
  
  public void e(com.tplink.libtpinappmessaging.model.b paramb)
  {
    if (!k(paramb)) {
      return;
    }
    c = true;
    b.d.n.j.a.b().d(paramb.b());
    b.d.n.j.d.c().i(paramb.c());
    b.d.n.j.d.c().g(paramb.a());
    this.g = ((IAMRepository)b.d.b.f.b.c(paramb.d()).a(IAMRepository.class));
    b.d.w.c.a.e("TPInAppMessagingInit", paramb.e());
    this.g.I(paramb.b(), paramb.e());
    this.h = new b.d.n.g.d(paramb.b(), paramb.f());
    this.d = new n(this.g);
    this.e = new o(this.g);
    this.f = new m(this.g);
    this.d.b();
    this.e.g();
  }
  
  public void f(String paramString)
  {
    if (j())
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new StringBuilder();
        paramString.append(a);
        paramString.append(" pageId is empty!!");
        b.d.n.j.e.a(paramString.toString());
        return;
      }
      this.e.c(paramString);
    }
  }
  
  public void g(b.d.n.i.b paramb)
  {
    if (j())
    {
      if (paramb == null) {
        return;
      }
      this.g.j(paramb);
    }
  }
  
  public void h(h paramh)
  {
    if (j())
    {
      if (paramh == null)
      {
        paramh = new StringBuilder();
        paramh.append(a);
        paramh.append(" splashMessageListener is null!!");
        b.d.n.j.e.a(paramh.toString());
        return;
      }
      this.h.c(paramh);
    }
    else if (paramh != null)
    {
      paramh.onFinish();
    }
  }
  
  public void i(String paramString)
  {
    if (j())
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new StringBuilder();
        paramString.append(a);
        paramString.append(" taskId is empty!!");
        b.d.n.j.e.a(paramString.toString());
        return;
      }
      this.f.a(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */