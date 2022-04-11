package org.bouncycastle.crypto.util;

import e.a.b.a.d.e;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.r2.c;
import org.bouncycastle.asn1.u2.o;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.e0;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.crypto.w.u;

public class b
{
  private static Map a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(org.bouncycastle.asn1.n2.g.B, new j(null));
    a.put(e0.m, new j(null));
    a.put(p.t3, new c(null));
    a.put(org.bouncycastle.asn1.n2.g.S, new b(null));
    a.put(p.l3, new d(null));
    a.put(org.bouncycastle.asn1.m2.b.j, new d(null));
    a.put(org.bouncycastle.asn1.m2.b.l, new g(null));
    a.put(p.B2, new f(null));
    a.put(org.bouncycastle.asn1.d2.a.m, new h(null));
    a.put(org.bouncycastle.asn1.o2.a.g, new i(null));
    a.put(org.bouncycastle.asn1.o2.a.h, new i(null));
    a.put(org.bouncycastle.asn1.r2.f.c, new e(null));
    a.put(org.bouncycastle.asn1.r2.f.b, new e(null));
  }
  
  public static org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw)
    throws IOException
  {
    return b(paramw, null);
  }
  
  public static org.bouncycastle.crypto.w.b b(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
    throws IOException
  {
    org.bouncycastle.asn1.x509.a locala = paramw.f();
    k localk = (k)a.get(locala.f());
    if (localk != null) {
      return localk.a(paramw, paramObject);
    }
    paramw = new StringBuilder();
    paramw.append("algorithm identifier in key not recognised: ");
    paramw.append(locala.f());
    throw new IOException(paramw.toString());
  }
  
  private static class b
    extends b.k
  {
    private b()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
      throws IOException
    {
      paramObject = org.bouncycastle.asn1.n2.e.g(paramw.f().i());
      paramw = (org.bouncycastle.asn1.j)paramw.j();
      BigInteger localBigInteger = ((org.bouncycastle.asn1.n2.e)paramObject).h();
      int i;
      if (localBigInteger == null) {
        i = 0;
      } else {
        i = localBigInteger.intValue();
      }
      paramObject = new org.bouncycastle.crypto.w.e(((org.bouncycastle.asn1.n2.e)paramObject).i(), ((org.bouncycastle.asn1.n2.e)paramObject).f(), null, i);
      return new org.bouncycastle.crypto.w.g(paramw.p(), (org.bouncycastle.crypto.w.e)paramObject);
    }
  }
  
  private static class c
    extends b.k
  {
    private c()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
      throws IOException
    {
      BigInteger localBigInteger1 = org.bouncycastle.asn1.u2.b.f(paramw.j()).g();
      Object localObject = org.bouncycastle.asn1.u2.d.g(paramw.f().i());
      BigInteger localBigInteger2 = ((org.bouncycastle.asn1.u2.d)localObject).j();
      BigInteger localBigInteger3 = ((org.bouncycastle.asn1.u2.d)localObject).f();
      BigInteger localBigInteger4 = ((org.bouncycastle.asn1.u2.d)localObject).k();
      paramw = ((org.bouncycastle.asn1.u2.d)localObject).h();
      paramObject = null;
      if (paramw != null) {
        paramw = ((org.bouncycastle.asn1.u2.d)localObject).h();
      } else {
        paramw = null;
      }
      localObject = ((org.bouncycastle.asn1.u2.d)localObject).l();
      if (localObject != null) {
        paramObject = new org.bouncycastle.crypto.w.h(((org.bouncycastle.asn1.u2.f)localObject).h(), ((org.bouncycastle.asn1.u2.f)localObject).g().intValue());
      }
      return new org.bouncycastle.crypto.w.g(localBigInteger1, new org.bouncycastle.crypto.w.e(localBigInteger2, localBigInteger3, localBigInteger4, paramw, (org.bouncycastle.crypto.w.h)paramObject));
    }
  }
  
  private static class d
    extends b.k
  {
    private d()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
      throws IOException
    {
      paramObject = (org.bouncycastle.asn1.j)paramw.j();
      paramw = paramw.f().i();
      if (paramw != null)
      {
        paramw = org.bouncycastle.asn1.x509.j.g(paramw.c());
        paramw = new org.bouncycastle.crypto.w.j(paramw.h(), paramw.i(), paramw.f());
      }
      else
      {
        paramw = null;
      }
      return new org.bouncycastle.crypto.w.l(((org.bouncycastle.asn1.j)paramObject).p(), paramw);
    }
  }
  
  private static class e
    extends b.k
  {
    private e()
    {
      super();
    }
    
    private void b(byte[] paramArrayOfByte)
    {
      for (int i = 0; i < paramArrayOfByte.length / 2; i++)
      {
        int j = paramArrayOfByte[i];
        paramArrayOfByte[i] = ((byte)paramArrayOfByte[(paramArrayOfByte.length - 1 - i)]);
        paramArrayOfByte[(paramArrayOfByte.length - 1 - i)] = ((byte)j);
      }
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
      throws IOException
    {
      paramObject = paramw.i();
      try
      {
        paramObject = (org.bouncycastle.asn1.n)org.bouncycastle.asn1.q.i(((org.bouncycastle.asn1.b)paramObject).o());
        paramObject = ((org.bouncycastle.asn1.n)paramObject).o();
        Object localObject1 = paramw.f().f();
        m localm = org.bouncycastle.asn1.r2.f.b;
        if (((org.bouncycastle.asn1.q)localObject1).equals(localm)) {
          b((byte[])paramObject);
        }
        localObject1 = org.bouncycastle.asn1.r2.d.i(paramw.f().i());
        if (((org.bouncycastle.asn1.r2.d)localObject1).k())
        {
          paramw = c.a(((org.bouncycastle.asn1.r2.d)localObject1).j());
        }
        else
        {
          localObject1 = ((org.bouncycastle.asn1.r2.d)localObject1).h();
          Object localObject2 = ((org.bouncycastle.asn1.r2.b)localObject1).g();
          if (paramw.f().f().equals(localm)) {
            b((byte[])localObject2);
          }
          Object localObject3 = ((org.bouncycastle.asn1.r2.b)localObject1).h();
          localObject2 = new d.e(((org.bouncycastle.asn1.r2.a)localObject3).j(), ((org.bouncycastle.asn1.r2.a)localObject3).g(), ((org.bouncycastle.asn1.r2.a)localObject3).h(), ((org.bouncycastle.asn1.r2.a)localObject3).i(), ((org.bouncycastle.asn1.r2.b)localObject1).f(), new BigInteger(1, (byte[])localObject2));
          localObject3 = ((org.bouncycastle.asn1.r2.b)localObject1).i();
          if (paramw.f().f().equals(localm)) {
            b((byte[])localObject3);
          }
          paramw = new org.bouncycastle.crypto.w.n((e.a.b.a.d)localObject2, org.bouncycastle.asn1.r2.e.a((e.a.b.a.d)localObject2, (byte[])localObject3), ((org.bouncycastle.asn1.r2.b)localObject1).k());
        }
        return new s(org.bouncycastle.asn1.r2.e.a(paramw.a(), (byte[])paramObject), paramw);
      }
      catch (IOException paramw)
      {
        throw new IllegalArgumentException("error recovering public key");
      }
    }
  }
  
  private static class f
    extends b.k
  {
    private f()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
    {
      Object localObject1 = org.bouncycastle.asn1.u2.h.f(paramw.f().i());
      if (((org.bouncycastle.asn1.u2.h)localObject1).i())
      {
        localObject2 = (m)((org.bouncycastle.asn1.u2.h)localObject1).g();
        localObject1 = org.bouncycastle.crypto.q.a.i((m)localObject2);
        paramObject = localObject1;
        if (localObject1 == null) {
          paramObject = org.bouncycastle.asn1.u2.e.c((m)localObject2);
        }
        paramObject = new org.bouncycastle.crypto.w.q((m)localObject2, ((org.bouncycastle.asn1.u2.j)paramObject).f(), ((org.bouncycastle.asn1.u2.j)paramObject).g(), ((org.bouncycastle.asn1.u2.j)paramObject).j(), ((org.bouncycastle.asn1.u2.j)paramObject).h(), ((org.bouncycastle.asn1.u2.j)paramObject).k());
      }
      else if (((org.bouncycastle.asn1.u2.h)localObject1).h())
      {
        paramObject = (org.bouncycastle.crypto.w.n)paramObject;
      }
      else
      {
        paramObject = org.bouncycastle.asn1.u2.j.i(((org.bouncycastle.asn1.u2.h)localObject1).g());
        paramObject = new org.bouncycastle.crypto.w.n(((org.bouncycastle.asn1.u2.j)paramObject).f(), ((org.bouncycastle.asn1.u2.j)paramObject).g(), ((org.bouncycastle.asn1.u2.j)paramObject).j(), ((org.bouncycastle.asn1.u2.j)paramObject).h(), ((org.bouncycastle.asn1.u2.j)paramObject).k());
      }
      Object localObject2 = paramw.i().o();
      localObject1 = new x0((byte[])localObject2);
      paramw = (org.bouncycastle.asn1.x509.w)localObject1;
      if (localObject2[0] == 4)
      {
        paramw = (org.bouncycastle.asn1.x509.w)localObject1;
        if (localObject2[1] == localObject2.length - 2) {
          if (localObject2[2] != 2)
          {
            paramw = (org.bouncycastle.asn1.x509.w)localObject1;
            if (localObject2[2] != 3) {}
          }
          else
          {
            paramw = (org.bouncycastle.asn1.x509.w)localObject1;
            if (new o().a(((org.bouncycastle.crypto.w.n)paramObject).a()) >= localObject2.length - 3) {
              try
              {
                paramw = (org.bouncycastle.asn1.n)org.bouncycastle.asn1.q.i((byte[])localObject2);
              }
              catch (IOException paramw)
              {
                throw new IllegalArgumentException("error recovering public key");
              }
            }
          }
        }
      }
      return new s(new org.bouncycastle.asn1.u2.l(((org.bouncycastle.crypto.w.n)paramObject).a(), paramw).f(), (org.bouncycastle.crypto.w.n)paramObject);
    }
  }
  
  private static class g
    extends b.k
  {
    private g()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
      throws IOException
    {
      paramObject = org.bouncycastle.asn1.m2.a.g(paramw.f().i());
      return new org.bouncycastle.crypto.w.w(((org.bouncycastle.asn1.j)paramw.j()).p(), new u(((org.bouncycastle.asn1.m2.a)paramObject).h(), ((org.bouncycastle.asn1.m2.a)paramObject).f()));
    }
  }
  
  private static class h
    extends b.k
  {
    private h()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
    {
      paramObject = paramw.i();
      try
      {
        paramObject = (org.bouncycastle.asn1.n)org.bouncycastle.asn1.q.i(((org.bouncycastle.asn1.b)paramObject).o());
        byte[] arrayOfByte = ((org.bouncycastle.asn1.n)paramObject).o();
        paramObject = new byte[65];
        paramObject[0] = ((byte)4);
        for (int i = 1; i <= 32; i++)
        {
          paramObject[i] = ((byte)arrayOfByte[(32 - i)]);
          paramObject[(i + 32)] = ((byte)arrayOfByte[(64 - i)]);
        }
        boolean bool = paramw.f().i() instanceof m;
        paramw = paramw.f().i();
        if (bool) {
          paramw = m.r(paramw);
        } else {
          paramw = org.bouncycastle.asn1.d2.e.h(paramw).i();
        }
        paramw = org.bouncycastle.asn1.d2.b.b(paramw);
        return new s(paramw.a().k((byte[])paramObject), paramw);
      }
      catch (IOException paramw)
      {
        throw new IllegalArgumentException("error recovering public key");
      }
    }
  }
  
  private static class i
    extends b.k
  {
    private i()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
    {
      paramObject = paramw.f().f();
      Object localObject = paramw.i();
      try
      {
        localObject = (org.bouncycastle.asn1.n)org.bouncycastle.asn1.q.i(((org.bouncycastle.asn1.b)localObject).o());
        localObject = ((org.bouncycastle.asn1.n)localObject).o();
        int i = 32;
        if (((org.bouncycastle.asn1.q)paramObject).equals(org.bouncycastle.asn1.o2.a.h)) {
          i = 64;
        }
        int j = i * 2;
        paramObject = new byte[j + 1];
        paramObject[0] = ((byte)4);
        for (int k = 1; k <= i; k++)
        {
          paramObject[k] = ((byte)localObject[(i - k)]);
          paramObject[(k + i)] = ((byte)localObject[(j - k)]);
        }
        paramw = org.bouncycastle.asn1.d2.b.b(org.bouncycastle.asn1.d2.e.h(paramw.f().i()).i());
        return new s(paramw.a().k((byte[])paramObject), paramw);
      }
      catch (IOException paramw)
      {
        throw new IllegalArgumentException("error recovering public key");
      }
    }
  }
  
  private static class j
    extends b.k
  {
    private j()
    {
      super();
    }
    
    org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
      throws IOException
    {
      paramw = org.bouncycastle.asn1.n2.j.f(paramw.j());
      return new d0(false, paramw.g(), paramw.h());
    }
  }
  
  private static abstract class k
  {
    abstract org.bouncycastle.crypto.w.b a(org.bouncycastle.asn1.x509.w paramw, Object paramObject)
      throws IOException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */