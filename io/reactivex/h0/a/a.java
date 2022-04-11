package io.reactivex.h0.a;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.g0.g;
import io.reactivex.g0.h;
import io.reactivex.g0.i;
import io.reactivex.g0.j;
import io.reactivex.g0.k;
import io.reactivex.g0.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class a
{
  static final j<Object, Object> a = new n();
  public static final Runnable b = new j();
  public static final io.reactivex.g0.a c = new g();
  static final g<Object> d = new h();
  public static final g<Throwable> e = new k();
  public static final g<Throwable> f = new s();
  public static final k g = new i();
  static final l<Object> h = new t();
  static final l<Object> i = new l();
  static final Callable<Object> j = new r();
  static final Comparator<Object> k = new q();
  public static final g<e.b.c> l = new p();
  
  public static <T> g<T> a(io.reactivex.g0.a parama)
  {
    return new a(parama);
  }
  
  public static <T> l<T> b()
  {
    return h;
  }
  
  public static <T, U> j<T, U> c(Class<U> paramClass)
  {
    return new f(paramClass);
  }
  
  public static <T> Callable<List<T>> d(int paramInt)
  {
    return new e(paramInt);
  }
  
  public static <T> Callable<Set<T>> e()
  {
    return m.c;
  }
  
  public static <T> g<T> f()
  {
    return d;
  }
  
  public static <T> j<T, T> g()
  {
    return a;
  }
  
  public static <T> Callable<T> h(T paramT)
  {
    return new o(paramT);
  }
  
  public static <T, U> j<T, U> i(U paramU)
  {
    return new o(paramU);
  }
  
  public static <T1, T2, R> j<Object[], R> j(io.reactivex.g0.c<? super T1, ? super T2, ? extends R> paramc)
  {
    b.e(paramc, "f is null");
    return new b(paramc);
  }
  
  public static <T1, T2, T3, R> j<Object[], R> k(h<T1, T2, T3, R> paramh)
  {
    b.e(paramh, "f is null");
    return new c(paramh);
  }
  
  public static <T1, T2, T3, T4, R> j<Object[], R> l(i<T1, T2, T3, T4, R> parami)
  {
    b.e(parami, "f is null");
    return new d(parami);
  }
  
  static final class a<T>
    implements g<T>
  {
    final io.reactivex.g0.a c;
    
    a(io.reactivex.g0.a parama)
    {
      this.c = parama;
    }
    
    public void accept(T paramT)
      throws Exception
    {
      this.c.run();
    }
  }
  
  static final class b<T1, T2, R>
    implements j<Object[], R>
  {
    final io.reactivex.g0.c<? super T1, ? super T2, ? extends R> c;
    
    b(io.reactivex.g0.c<? super T1, ? super T2, ? extends R> paramc)
    {
      this.c = paramc;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 2) {
        return (R)this.c.apply(paramArrayOfObject[0], paramArrayOfObject[1]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 2 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class c<T1, T2, T3, R>
    implements j<Object[], R>
  {
    final h<T1, T2, T3, R> c;
    
    c(h<T1, T2, T3, R> paramh)
    {
      this.c = paramh;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 3) {
        return (R)this.c.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 3 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class d<T1, T2, T3, T4, R>
    implements j<Object[], R>
  {
    final i<T1, T2, T3, T4, R> c;
    
    d(i<T1, T2, T3, T4, R> parami)
    {
      this.c = parami;
    }
    
    public R a(Object[] paramArrayOfObject)
      throws Exception
    {
      if (paramArrayOfObject.length == 4) {
        return (R)this.c.a(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array of size 4 expected but got ");
      localStringBuilder.append(paramArrayOfObject.length);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  static final class e<T>
    implements Callable<List<T>>
  {
    final int c;
    
    e(int paramInt)
    {
      this.c = paramInt;
    }
    
    public List<T> a()
      throws Exception
    {
      return new ArrayList(this.c);
    }
  }
  
  static final class f<T, U>
    implements j<T, U>
  {
    final Class<U> c;
    
    f(Class<U> paramClass)
    {
      this.c = paramClass;
    }
    
    public U apply(T paramT)
      throws Exception
    {
      return (U)this.c.cast(paramT);
    }
  }
  
  static final class g
    implements io.reactivex.g0.a
  {
    public void run() {}
    
    public String toString()
    {
      return "EmptyAction";
    }
  }
  
  static final class h
    implements g<Object>
  {
    public void accept(Object paramObject) {}
    
    public String toString()
    {
      return "EmptyConsumer";
    }
  }
  
  static final class i
    implements k
  {
    public void a(long paramLong) {}
  }
  
  static final class j
    implements Runnable
  {
    public void run() {}
    
    public String toString()
    {
      return "EmptyRunnable";
    }
  }
  
  static final class k
    implements g<Throwable>
  {
    public void a(Throwable paramThrowable)
    {
      io.reactivex.j0.a.r(paramThrowable);
    }
  }
  
  static final class l
    implements l<Object>
  {
    public boolean test(Object paramObject)
    {
      return false;
    }
  }
  
  static enum m
    implements Callable<Set<Object>>
  {
    static
    {
      m localm = new m("INSTANCE", 0);
      c = localm;
      d = new m[] { localm };
    }
    
    public Set<Object> a()
      throws Exception
    {
      return new HashSet();
    }
  }
  
  static final class n
    implements j<Object, Object>
  {
    public Object apply(Object paramObject)
    {
      return paramObject;
    }
    
    public String toString()
    {
      return "IdentityFunction";
    }
  }
  
  static final class o<T, U>
    implements Callable<U>, j<T, U>
  {
    final U c;
    
    o(U paramU)
    {
      this.c = paramU;
    }
    
    public U apply(T paramT)
      throws Exception
    {
      return (U)this.c;
    }
    
    public U call()
      throws Exception
    {
      return (U)this.c;
    }
  }
  
  static final class p
    implements g<e.b.c>
  {
    public void a(e.b.c paramc)
      throws Exception
    {
      paramc.request(Long.MAX_VALUE);
    }
  }
  
  static final class q
    implements Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
  }
  
  static final class r
    implements Callable<Object>
  {
    public Object call()
    {
      return null;
    }
  }
  
  static final class s
    implements g<Throwable>
  {
    public void a(Throwable paramThrowable)
    {
      io.reactivex.j0.a.r(new OnErrorNotImplementedException(paramThrowable));
    }
  }
  
  static final class t
    implements l<Object>
  {
    public boolean test(Object paramObject)
    {
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */