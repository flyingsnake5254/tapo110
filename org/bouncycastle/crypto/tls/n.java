package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.engines.f;
import org.bouncycastle.crypto.engines.j;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.u.d;
import org.bouncycastle.crypto.u.e;

public class n
  extends a
{
  public i0 a(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 103)
        {
          if (paramInt1 != 104)
          {
            switch (paramInt1)
            {
            default: 
              throw new TlsFatalAlert((short)80);
            case 21: 
              return l(paramp0);
            case 20: 
              return p(paramp0, 32, 16);
            case 19: 
              return p(paramp0, 16, 16);
            case 18: 
              return m(paramp0, 32, 8);
            case 17: 
              return m(paramp0, 32, 16);
            case 16: 
              return m(paramp0, 16, 8);
            case 15: 
              return m(paramp0, 16, 16);
            case 14: 
              return x(paramp0, paramInt2);
            case 13: 
              return j(paramp0, 32, paramInt2);
            case 12: 
              return j(paramp0, 16, paramInt2);
            case 11: 
              return n(paramp0, 32, 16);
            case 10: 
              return n(paramp0, 16, 16);
            case 9: 
              return g(paramp0, 32, paramInt2);
            case 8: 
              return g(paramp0, 16, paramInt2);
            }
            return r(paramp0, paramInt2);
          }
          return o(paramp0, 32, 12);
        }
        return o(paramp0, 16, 12);
      }
      return u(paramp0, 16, paramInt2);
    }
    return t(paramp0, paramInt2);
  }
  
  protected org.bouncycastle.crypto.u.a b()
  {
    return new org.bouncycastle.crypto.u.c(h());
  }
  
  protected org.bouncycastle.crypto.u.a c()
  {
    return new d(h());
  }
  
  protected org.bouncycastle.crypto.u.a d()
  {
    return new e(h(), h());
  }
  
  protected org.bouncycastle.crypto.u.a e()
  {
    return new d(k());
  }
  
  protected org.bouncycastle.crypto.c f()
  {
    return new org.bouncycastle.crypto.u.b(h());
  }
  
  protected h0 g(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    return new h0(paramp0, f(), f(), s(paramInt2), s(paramInt2), paramInt1);
  }
  
  protected org.bouncycastle.crypto.c h()
  {
    return new org.bouncycastle.crypto.engines.a();
  }
  
  protected org.bouncycastle.crypto.c i()
  {
    return new org.bouncycastle.crypto.u.b(k());
  }
  
  protected h0 j(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    return new h0(paramp0, i(), i(), s(paramInt2), s(paramInt2), paramInt1);
  }
  
  protected org.bouncycastle.crypto.c k()
  {
    return new org.bouncycastle.crypto.engines.b();
  }
  
  protected i0 l(p0 paramp0)
    throws IOException
  {
    return new k(paramp0);
  }
  
  protected f0 m(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    return new f0(paramp0, b(), b(), paramInt1, paramInt2);
  }
  
  protected f0 n(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    return new f0(paramp0, c(), c(), paramInt1, paramInt2);
  }
  
  protected f0 o(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    return new f0(paramp0, d(), d(), paramInt1, paramInt2, 2);
  }
  
  protected f0 p(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    return new f0(paramp0, e(), e(), paramInt1, paramInt2);
  }
  
  protected org.bouncycastle.crypto.c q()
  {
    return new org.bouncycastle.crypto.u.b(new f());
  }
  
  protected h0 r(p0 paramp0, int paramInt)
    throws IOException
  {
    return new h0(paramp0, q(), q(), s(paramInt), s(paramInt), 24);
  }
  
  protected org.bouncycastle.crypto.g s(int paramInt)
    throws IOException
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5) {
                return m1.n((short)6);
              }
              throw new TlsFatalAlert((short)80);
            }
            return m1.n((short)5);
          }
          return m1.n((short)4);
        }
        return m1.n((short)2);
      }
      return m1.n((short)1);
    }
    return null;
  }
  
  protected z0 t(p0 paramp0, int paramInt)
    throws IOException
  {
    return new z0(paramp0, s(paramInt), s(paramInt));
  }
  
  protected l1 u(p0 paramp0, int paramInt1, int paramInt2)
    throws IOException
  {
    return new l1(paramp0, v(), v(), s(paramInt2), s(paramInt2), paramInt1, false);
  }
  
  protected m v()
  {
    return new org.bouncycastle.crypto.engines.g();
  }
  
  protected org.bouncycastle.crypto.c w()
  {
    return new org.bouncycastle.crypto.u.b(new j());
  }
  
  protected h0 x(p0 paramp0, int paramInt)
    throws IOException
  {
    return new h0(paramp0, w(), w(), s(paramInt), s(paramInt), 16);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */