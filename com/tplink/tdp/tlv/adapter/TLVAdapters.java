package com.tplink.tdp.tlv.adapter;

public class TLVAdapters
{
  private static final c<String> a;
  public static final d b;
  private static final c<Integer> c;
  public static final d d;
  private static final c<Boolean> e;
  public static final d f;
  private static final c<Byte> g;
  public static final d h;
  private static final c<Double> i;
  public static final d j;
  private static final c<Float> k;
  public static final d l;
  private static final c<Long> m;
  public static final d n;
  private static final c<Short> o;
  public static final d p;
  private static final c<Character> q;
  public static final d r;
  private static final c<b.d.c0.m.c> s = new c()
  {
    public b.d.c0.m.c b(b.d.c0.m.e.a paramAnonymousa)
    {
      paramAnonymousa.o();
      return new b.d.c0.m.c();
    }
  };
  public static final d t = new a();
  
  static
  {
    Object localObject = new c()
    {
      public String b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.m();
      }
    };
    a = (c)localObject;
    b = b(String.class, (c)localObject);
    localObject = new c()
    {
      public Integer b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.i();
      }
    };
    c = (c)localObject;
    d = c(Integer.TYPE, Integer.class, (c)localObject);
    localObject = new c()
    {
      public Boolean b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.d();
      }
    };
    e = (c)localObject;
    f = c(Boolean.TYPE, Boolean.class, (c)localObject);
    localObject = new c()
    {
      public Byte b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.e();
      }
    };
    g = (c)localObject;
    h = c(Byte.TYPE, Byte.class, (c)localObject);
    localObject = new c()
    {
      public Double b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.g();
      }
    };
    i = (c)localObject;
    j = c(Double.TYPE, Double.class, (c)localObject);
    localObject = new c()
    {
      public Float b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.h();
      }
    };
    k = (c)localObject;
    l = c(Float.TYPE, Float.class, (c)localObject);
    localObject = new c()
    {
      public Long b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.k();
      }
    };
    m = (c)localObject;
    n = c(Long.TYPE, Long.class, (c)localObject);
    localObject = new c()
    {
      public Short b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.l();
      }
    };
    o = (c)localObject;
    p = c(Short.TYPE, Short.class, (c)localObject);
    localObject = new c()
    {
      public Character b(b.d.c0.m.e.a paramAnonymousa)
      {
        return paramAnonymousa.f();
      }
    };
    q = (c)localObject;
    r = c(Character.TYPE, Character.class, (c)localObject);
  }
  
  private static <TT> d b(Class<TT> paramClass, final c<TT> paramc)
  {
    return new b(paramClass, paramc);
  }
  
  private static <TT> d c(Class<TT> paramClass1, final Class<TT> paramClass2, final c<TT> paramc)
  {
    return new c(paramClass1, paramClass2, paramc);
  }
  
  static final class a
    implements d
  {
    public <T> c<T> a(b.d.c0.m.a parama, e<T> parame)
    {
      if (b.d.c0.m.c.class.isAssignableFrom(parame.a())) {
        parama = TLVAdapters.a();
      } else {
        parama = null;
      }
      return parama;
    }
  }
  
  static final class b
    implements d
  {
    b(Class paramClass, c paramc) {}
    
    public <T> c<T> a(b.d.c0.m.a parama, e<T> parame)
    {
      if (parame.a() == this.a) {
        parama = paramc;
      } else {
        parama = null;
      }
      return parama;
    }
  }
  
  static final class c
    implements d
  {
    c(Class paramClass1, Class paramClass2, c paramc) {}
    
    public <T> c<T> a(b.d.c0.m.a parama, e<T> parame)
    {
      parama = parame.a();
      if ((parama != this.a) && (parama != paramClass2)) {
        parama = null;
      } else {
        parama = paramc;
      }
      return parama;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\tlv\adapter\TLVAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */