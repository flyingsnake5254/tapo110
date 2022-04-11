package com.google.android.datatransport.h;

import android.content.Context;
import com.google.android.datatransport.h.x.g;
import com.google.android.datatransport.h.x.j.b0;
import com.google.android.datatransport.h.x.j.c0;
import com.google.android.datatransport.h.x.j.d0;
import com.google.android.datatransport.h.x.j.f0;
import com.google.android.datatransport.h.x.j.g0;
import com.google.android.datatransport.h.x.j.i0;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import java.util.concurrent.Executor;

final class e
  extends s
{
  private d.a.a<r> H3;
  private d.a.a<Executor> c;
  private d.a.a<Context> d;
  private d.a.a f;
  private d.a.a<u> p0;
  private d.a.a<com.google.android.datatransport.h.x.c> p1;
  private d.a.a<q> p2;
  private d.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.s> p3;
  private d.a.a q;
  private d.a.a x;
  private d.a.a<f0> y;
  private d.a.a<SchedulerConfig> z;
  
  private e(Context paramContext)
  {
    g(paramContext);
  }
  
  public static s.a e()
  {
    return new b(null);
  }
  
  private void g(Context paramContext)
  {
    this.c = com.google.android.datatransport.h.u.a.a.a(k.a());
    paramContext = com.google.android.datatransport.h.u.a.c.a(paramContext);
    this.d = paramContext;
    paramContext = com.google.android.datatransport.runtime.backends.i.a(paramContext, com.google.android.datatransport.h.y.c.a(), com.google.android.datatransport.h.y.d.a());
    this.f = paramContext;
    this.q = com.google.android.datatransport.h.u.a.a.a(com.google.android.datatransport.runtime.backends.k.a(this.d, paramContext));
    this.x = i0.a(this.d, b0.a(), c0.a());
    this.y = com.google.android.datatransport.h.u.a.a.a(g0.a(com.google.android.datatransport.h.y.c.a(), com.google.android.datatransport.h.y.d.a(), d0.a(), this.x));
    paramContext = g.b(com.google.android.datatransport.h.y.c.a());
    this.z = paramContext;
    Object localObject = com.google.android.datatransport.h.x.i.a(this.d, this.y, paramContext, com.google.android.datatransport.h.y.d.a());
    this.p0 = ((d.a.a)localObject);
    d.a.a locala1 = this.c;
    d.a.a locala2 = this.q;
    paramContext = this.y;
    this.p1 = com.google.android.datatransport.h.x.d.a(locala1, locala2, (d.a.a)localObject, paramContext, paramContext);
    paramContext = this.d;
    localObject = this.q;
    locala2 = this.y;
    this.p2 = com.google.android.datatransport.runtime.scheduling.jobscheduling.r.a(paramContext, (d.a.a)localObject, locala2, this.p0, this.c, locala2, com.google.android.datatransport.h.y.c.a());
    paramContext = this.c;
    localObject = this.y;
    this.p3 = com.google.android.datatransport.runtime.scheduling.jobscheduling.t.a(paramContext, (d.a.a)localObject, this.p0, (d.a.a)localObject);
    this.H3 = com.google.android.datatransport.h.u.a.a.a(t.a(com.google.android.datatransport.h.y.c.a(), com.google.android.datatransport.h.y.d.a(), this.p1, this.p2, this.p3));
  }
  
  y a()
  {
    return (y)this.y.get();
  }
  
  r c()
  {
    return (r)this.H3.get();
  }
  
  private static final class b
    implements s.a
  {
    private Context a;
    
    public b b(Context paramContext)
    {
      this.a = ((Context)com.google.android.datatransport.h.u.a.d.b(paramContext));
      return this;
    }
    
    public s build()
    {
      com.google.android.datatransport.h.u.a.d.a(this.a, Context.class);
      return new e(this.a, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */