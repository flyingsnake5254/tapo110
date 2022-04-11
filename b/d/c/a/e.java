package b.d.c.a;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import b.d.c.a.h.k;
import com.tplink.libtpanalytics.core.define.TAException;
import com.tplink.libtpanalytics.net.TPCloudManager;
import com.tplink.libtpanalytics.utils.FragmentStateMonitor;
import com.tplink.libtpanalytics.utils.FragmentStateMonitor.b;
import com.tplink.libtpanalytics.utils.b.b;
import com.tplink.libtpanalytics.utils.b.c;
import com.tplink.libtpanalytics.utils.g;
import com.tplink.libtpanalytics.utils.h;
import com.tplink.libtpanalytics.utils.i;
import com.tplink.libtpanalytics.utils.j;
import com.tplink.libtpanalytics.utils.l.d.b;
import com.tplink.libtpanalytics.utils.l.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class e
  implements b.d.c.c.a
{
  private static b.d.c.c.a a;
  private com.tplink.libtpanalytics.core.define.e b;
  private b.d.c.a.j.b c;
  private b.d.c.a.g.a d;
  private b.d.c.a.i.b e;
  private b.d.c.a.f.a f;
  private b.d.c.a.l.a g;
  private b.d.c.a.k.a h;
  private k i;
  private b.d.c.c.b j;
  private TPCloudManager k;
  private volatile boolean l = false;
  private Application m;
  private String n;
  private String o;
  private String p;
  private final List<d> q = new ArrayList();
  private final b.b r = new a();
  private final FragmentStateMonitor.b s = new b();
  private final b.c t = new b(this);
  private final b.d.c.c.e u = new a(this);
  private final b.d.c.c.e v = new c(this);
  
  private void A(String paramString1, String paramString2)
  {
    this.g.d(paramString2, paramString1);
  }
  
  private void B()
  {
    com.tplink.libtpanalytics.database.d.b localb = b.d.c.b.a.a(new b.d.c.b.b("user_engagement", this.b));
    if (localb != null) {
      this.e.j(localb);
    }
  }
  
  private void C(com.tplink.libtpanalytics.core.define.c paramc)
  {
    Object localObject1 = j.g(this.m).i();
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = com.tplink.libtpanalytics.utils.d.a(this.m);
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        j.g(this.m).m((String)localObject1);
        localObject2 = localObject1;
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = UUID.randomUUID().toString();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        j.g(this.m).m((String)localObject2);
        localObject1 = localObject2;
      }
    }
    paramc.B((String)localObject1);
  }
  
  private void k()
  {
    this.d.d();
  }
  
  public static b.d.c.c.a l()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          e locale = new b/d/c/a/e;
          locale.<init>();
          a = locale;
        }
      }
      finally {}
    }
    return a;
  }
  
  private com.tplink.libtpanalytics.core.define.d m()
  {
    com.tplink.libtpanalytics.core.define.d locald = new com.tplink.libtpanalytics.core.define.d();
    locald.c(h.a());
    locald.d(h.d());
    return locald;
  }
  
  private com.tplink.libtpanalytics.core.define.c n(String paramString)
  {
    com.tplink.libtpanalytics.core.define.c localc = new com.tplink.libtpanalytics.core.define.c();
    localc.o(this.n);
    localc.A(this.o);
    localc.s(this.p);
    localc.r(g.a(this.m));
    localc.q(this.m.getPackageName());
    localc.v(h.c());
    localc.z(h.b());
    localc.y(h.e());
    localc.u(true);
    localc.w(m());
    if (!TextUtils.isEmpty(paramString))
    {
      localc.B(paramString);
      j.g(this.m).m(paramString);
    }
    else
    {
      C(localc);
    }
    return localc;
  }
  
  private com.tplink.libtpanalytics.core.define.e o(com.tplink.cloud.context.b paramb)
  {
    com.tplink.libtpanalytics.core.define.e locale = new com.tplink.libtpanalytics.core.define.e();
    locale.h(this.m);
    locale.f(paramb);
    locale.i(new d.b().h(com.tplink.libtpanalytics.utils.l.e.a(this.m, "tp_analytics_v1.pem")).i(com.tplink.libtpanalytics.utils.l.e.b(this.m, "tp_analytics_v1.pem")).a());
    locale.g(new f());
    locale.j(n(paramb.e().q()));
    paramb = paramb.e().n();
    if (!TextUtils.isEmpty(paramb)) {
      locale.e().x(paramb);
    }
    return locale;
  }
  
  private void p()
  {
    StringBuilder localStringBuilder;
    try
    {
      ApplicationInfo localApplicationInfo = this.m.getPackageManager().getApplicationInfo(this.m.getPackageName(), 128);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      localStringBuilder = null;
    }
    if (localStringBuilder != null)
    {
      String str = localStringBuilder.metaData.getString("ANALYTICS_URL");
      this.p = str;
      if (!TextUtils.isEmpty(str))
      {
        this.o = localStringBuilder.metaData.getString("SECRET");
        this.n = localStringBuilder.metaData.getString("ACCESS_KEY");
        if (!TextUtils.isEmpty(this.o))
        {
          if (!TextUtils.isEmpty(this.n))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("ANALYTICS_URL:");
            localStringBuilder.append(this.p);
            localStringBuilder.append("\nSECRET:");
            localStringBuilder.append(this.o);
            localStringBuilder.append("\nACCESS_KEY:");
            localStringBuilder.append(this.n);
            i.c(localStringBuilder.toString());
          }
          else
          {
            throw new TAException("please configure accessKey in build.gradle");
          }
        }
        else {
          throw new TAException("please configure secret in build.gradle");
        }
      }
      else
      {
        throw new TAException("please configure ANALYTICS_URL");
      }
    }
  }
  
  private void q()
  {
    if (!this.l)
    {
      com.tplink.libtpanalytics.utils.b.f().e(this.r, this.t);
      FragmentStateMonitor.h().n(this.s);
      this.e.p(true);
      this.i.x(true);
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(true);
      }
      b.d.c.a.m.c.f().a();
      b.d.c.a.m.c.f().b(this.u);
      b.d.c.a.m.b.f().a();
      b.d.c.a.m.b.f().b(this.v);
      this.l = true;
    }
  }
  
  private void v()
  {
    this.d.i();
  }
  
  private void w()
  {
    this.d.h();
    this.g.b();
    this.h.e();
  }
  
  private void x()
  {
    this.d.l();
    this.g.e();
    this.h.f();
  }
  
  private void y()
  {
    this.f.e();
  }
  
  private void z(String paramString)
  {
    this.g.c(paramString);
  }
  
  public void a(String paramString)
  {
    this.b.e().p(paramString);
  }
  
  public void b()
  {
    if (this.l)
    {
      com.tplink.libtpanalytics.utils.b.f().d();
      FragmentStateMonitor.h().p(this.s);
      this.e.p(false);
      this.i.x(false);
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(false);
      }
      b.d.c.a.m.c.f().c();
      b.d.c.a.m.c.f().d(this.u);
      b.d.c.a.m.b.f().c();
      b.d.c.a.m.b.f().d(this.v);
      this.l = false;
    }
  }
  
  public void c()
  {
    if (!this.l)
    {
      q();
      k();
    }
  }
  
  public void d(String paramString)
  {
    this.b.e().t(paramString);
  }
  
  public void e()
  {
    com.tplink.libtpanalytics.utils.f.a = true;
  }
  
  public void f(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    this.h.c(paramString, paramBundle);
  }
  
  public void g(Application paramApplication, com.tplink.cloud.context.b paramb, boolean paramBoolean)
  {
    this.m = paramApplication;
    p();
    r(o(paramb));
    i.a = paramBoolean;
    y();
  }
  
  public void r(com.tplink.libtpanalytics.core.define.e parame)
  {
    this.b = parame;
    Object localObject = new com.tplink.libtpanalytics.database.c();
    this.j = ((b.d.c.c.b)localObject);
    ((b.d.c.c.b)localObject).a(parame.c());
    this.b.b().k(this.j);
    this.b.b().l(parame.d());
    this.b.b().e(parame.c());
    localObject = (TPCloudManager)b.d.b.f.b.a(parame.a(), TPCloudManager.class);
    this.k = ((TPCloudManager)localObject);
    ((TPCloudManager)localObject).d(this.b.e());
    this.i = new k(this.j, this.k, parame.e(), parame.b());
    localObject = new b.d.c.a.i.b(this.j, parame.b());
    this.e = ((b.d.c.a.i.b)localObject);
    this.d = new b.d.c.a.g.a(parame, (b.d.c.a.i.b)localObject);
    this.c = new b.d.c.a.j.b(parame, this.e);
    this.f = new b.d.c.a.f.a(parame, this.e);
    this.g = new b.d.c.a.l.a(parame, this.e);
    this.h = new b.d.c.a.k.a(parame, this.e);
    this.q.add(this.d);
    this.q.add(this.c);
    this.q.add(this.f);
    this.q.add(this.g);
    this.q.add(this.h);
    com.tplink.libtpanalytics.utils.b.f().h(parame.c());
    if (parame.e().n()) {
      q();
    } else {
      b();
    }
  }
  
  class a
    implements b.b
  {
    a() {}
    
    public void a()
    {
      e.h(e.this);
    }
    
    public void b()
    {
      e.i(e.this);
    }
  }
  
  class b
    implements FragmentStateMonitor.b
  {
    b() {}
    
    public void a(Fragment paramFragment1, Fragment paramFragment2)
    {
      String str = "";
      if (paramFragment1 != null) {
        paramFragment1 = paramFragment1.getClass().getSimpleName();
      } else {
        paramFragment1 = "";
      }
      if (paramFragment2 != null) {
        str = paramFragment2.getClass().getSimpleName();
      }
      e.j(e.this, paramFragment1, str);
    }
    
    public void b(Fragment paramFragment) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */