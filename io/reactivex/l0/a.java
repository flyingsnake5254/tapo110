package io.reactivex.l0;

import io.reactivex.internal.schedulers.b;
import io.reactivex.internal.schedulers.d;
import io.reactivex.internal.schedulers.f;
import io.reactivex.internal.schedulers.g;
import io.reactivex.internal.schedulers.k;
import io.reactivex.internal.schedulers.l;
import io.reactivex.w;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class a
{
  static final w a = io.reactivex.j0.a.h(new h());
  static final w b = io.reactivex.j0.a.e(new b());
  static final w c = io.reactivex.j0.a.f(new c());
  static final w d = l.f();
  static final w e = io.reactivex.j0.a.g(new f());
  
  public static w a()
  {
    return io.reactivex.j0.a.q(b);
  }
  
  public static w b(Executor paramExecutor)
  {
    return new d(paramExecutor, false);
  }
  
  public static w c()
  {
    return io.reactivex.j0.a.s(c);
  }
  
  public static w d()
  {
    return io.reactivex.j0.a.u(a);
  }
  
  public static w e()
  {
    return d;
  }
  
  static final class a
  {
    static final w a = new b();
  }
  
  static final class b
    implements Callable<w>
  {
    public w a()
      throws Exception
    {
      return a.a.a;
    }
  }
  
  static final class c
    implements Callable<w>
  {
    public w a()
      throws Exception
    {
      return a.d.a;
    }
  }
  
  static final class d
  {
    static final w a = new f();
  }
  
  static final class e
  {
    static final w a = new g();
  }
  
  static final class f
    implements Callable<w>
  {
    public w a()
      throws Exception
    {
      return a.e.a;
    }
  }
  
  static final class g
  {
    static final w a = new k();
  }
  
  static final class h
    implements Callable<w>
  {
    public w a()
      throws Exception
    {
      return a.g.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\l0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */