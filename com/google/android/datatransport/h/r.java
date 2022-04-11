package com.google.android.datatransport.h;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.h.y.a;
import java.util.Collections;
import java.util.Set;

public class r
  implements q
{
  private static volatile s a;
  private final a b;
  private final a c;
  private final com.google.android.datatransport.h.x.e d;
  private final com.google.android.datatransport.runtime.scheduling.jobscheduling.q e;
  
  r(a parama1, a parama2, com.google.android.datatransport.h.x.e parame, com.google.android.datatransport.runtime.scheduling.jobscheduling.q paramq, com.google.android.datatransport.runtime.scheduling.jobscheduling.s params)
  {
    this.b = parama1;
    this.c = parama2;
    this.d = parame;
    this.e = paramq;
    params.a();
  }
  
  private i b(m paramm)
  {
    return i.a().i(this.b.a()).k(this.c.a()).j(paramm.g()).h(new h(paramm.b(), paramm.d())).g(paramm.c().a()).d();
  }
  
  public static r c()
  {
    s locals = a;
    if (locals != null) {
      return locals.c();
    }
    throw new IllegalStateException("Not initialized!");
  }
  
  private static Set<b> d(f paramf)
  {
    if ((paramf instanceof g)) {
      return Collections.unmodifiableSet(((g)paramf).a());
    }
    return Collections.singleton(b.b("proto"));
  }
  
  public static void f(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = e.e().a(paramContext).build();
        }
      }
      finally {}
    }
  }
  
  public void a(m paramm, com.google.android.datatransport.g paramg)
  {
    this.d.a(paramm.f().e(paramm.c().c()), b(paramm), paramg);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public com.google.android.datatransport.runtime.scheduling.jobscheduling.q e()
  {
    return this.e;
  }
  
  public com.google.android.datatransport.f g(f paramf)
  {
    return new o(d(paramf), n.a().b(paramf.getName()).c(paramf.getExtras()).a(), this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */