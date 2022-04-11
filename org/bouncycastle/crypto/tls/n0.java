package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.a;

public class n0
  extends g1
{
  protected k0 E = null;
  m0 F = null;
  protected byte[] G = null;
  protected x0 H = null;
  protected g0 I = null;
  protected j J = null;
  protected i K = null;
  
  public n0(InputStream paramInputStream, OutputStream paramOutputStream, SecureRandom paramSecureRandom)
  {
    super(paramInputStream, paramOutputStream, paramSecureRandom);
  }
  
  protected void A(short paramShort, ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    if (this.y)
    {
      if ((paramShort == 20) && (this.x == 2))
      {
        F(paramByteArrayInputStream);
        this.x = ((short)15);
        S();
        T();
        this.x = ((short)13);
        h();
        return;
      }
      throw new TlsFatalAlert((short)10);
    }
    if (paramShort != 0)
    {
      if (paramShort != 2)
      {
        if (paramShort != 4)
        {
          if (paramShort != 20)
          {
            if (paramShort != 22)
            {
              if (paramShort != 23) {
                switch (paramShort)
                {
                default: 
                  throw new TlsFatalAlert((short)10);
                case 14: 
                  switch (this.x)
                  {
                  default: 
                    throw new TlsFatalAlert((short)10);
                  case 2: 
                    b0(null);
                  case 3: 
                    this.H.j();
                    this.I = null;
                  case 4: 
                  case 5: 
                    this.H.f();
                  }
                  g1.c(paramByteArrayInputStream);
                  this.x = ((short)8);
                  this.f.h().l();
                  paramByteArrayInputStream = this.E.d();
                  if (paramByteArrayInputStream != null) {
                    U(paramByteArrayInputStream);
                  }
                  this.x = ((short)9);
                  paramByteArrayInputStream = this.K;
                  Object localObject;
                  if (paramByteArrayInputStream == null)
                  {
                    this.H.d();
                    paramByteArrayInputStream = null;
                  }
                  else
                  {
                    localObject = this.I.a(paramByteArrayInputStream);
                    paramByteArrayInputStream = this.H;
                    if (localObject == null)
                    {
                      paramByteArrayInputStream.d();
                      paramByteArrayInputStream = h.a;
                    }
                    else
                    {
                      paramByteArrayInputStream.h((q0)localObject);
                      paramByteArrayInputStream = ((q0)localObject).c();
                    }
                    R(paramByteArrayInputStream);
                    paramByteArrayInputStream = (ByteArrayInputStream)localObject;
                  }
                  this.x = ((short)10);
                  g0();
                  this.x = ((short)11);
                  if (m1.K(n())) {
                    g1.l(n(), this.H);
                  }
                  v0 localv0 = this.f.n();
                  this.r.i = g1.p(n(), localv0, null);
                  if (!m1.K(n())) {
                    g1.l(n(), this.H);
                  }
                  this.f.s(t().f(), t().l());
                  if ((paramByteArrayInputStream != null) && ((paramByteArrayInputStream instanceof k1)))
                  {
                    k1 localk1 = (k1)paramByteArrayInputStream;
                    localObject = m1.G(n(), localk1);
                    if (localObject == null) {
                      paramByteArrayInputStream = this.r.j();
                    } else {
                      paramByteArrayInputStream = localv0.i(((d0)localObject).b());
                    }
                    e0(new q((d0)localObject, localk1.b(paramByteArrayInputStream)));
                    this.x = ((short)12);
                  }
                  S();
                  T();
                  this.x = ((short)13);
                  break;
                case 13: 
                  paramShort = this.x;
                  if ((paramShort != 4) && (paramShort != 5))
                  {
                    if (paramShort != 6) {
                      throw new TlsFatalAlert((short)10);
                    }
                  }
                  else {
                    this.H.f();
                  }
                  if (this.I != null)
                  {
                    this.K = i.b(n(), paramByteArrayInputStream);
                    g1.c(paramByteArrayInputStream);
                    this.H.c(this.K);
                    m1.p0(this.f.h(), this.K.a());
                    this.x = ((short)7);
                    break;
                  }
                  throw new TlsFatalAlert((short)40);
                case 12: 
                  paramShort = this.x;
                  if (paramShort != 2)
                  {
                    if (paramShort != 3)
                    {
                      if ((paramShort == 4) || (paramShort == 5)) {
                        break label727;
                      }
                      throw new TlsFatalAlert((short)10);
                    }
                  }
                  else {
                    b0(null);
                  }
                  this.H.j();
                  this.I = null;
                  this.H.b(paramByteArrayInputStream);
                  g1.c(paramByteArrayInputStream);
                  this.x = ((short)6);
                  break;
                case 11: 
                  label727:
                  paramShort = this.x;
                  if (paramShort != 2)
                  {
                    if (paramShort != 3) {
                      throw new TlsFatalAlert((short)10);
                    }
                  }
                  else {
                    b0(null);
                  }
                  this.s = h.d(paramByteArrayInputStream);
                  g1.c(paramByteArrayInputStream);
                  paramByteArrayInputStream = this.s;
                  if ((paramByteArrayInputStream == null) || (paramByteArrayInputStream.c())) {
                    this.B = false;
                  }
                  this.H.g(this.s);
                  paramByteArrayInputStream = this.E.u();
                  this.I = paramByteArrayInputStream;
                  paramByteArrayInputStream.b(this.s);
                  this.x = ((short)4);
                  break;
                }
              } else if (this.x == 2) {
                b0(g1.N(paramByteArrayInputStream));
              } else {
                throw new TlsFatalAlert((short)10);
              }
            }
            else if (this.x == 4)
            {
              if (this.B)
              {
                this.J = j.b(paramByteArrayInputStream);
                g1.c(paramByteArrayInputStream);
                this.x = ((short)5);
              }
              else
              {
                throw new TlsFatalAlert((short)10);
              }
            }
            else {
              throw new TlsFatalAlert((short)10);
            }
          }
          else
          {
            paramShort = this.x;
            if (paramShort != 13)
            {
              if (paramShort != 14) {
                throw new TlsFatalAlert((short)10);
              }
            }
            else {
              if (this.C) {
                break label1005;
              }
            }
            F(paramByteArrayInputStream);
            this.x = ((short)15);
            h();
            return;
            label1005:
            throw new TlsFatalAlert((short)10);
          }
        }
        else if (this.x == 13)
        {
          if (this.C)
          {
            B();
            c0(paramByteArrayInputStream);
            this.x = ((short)14);
          }
          else
          {
            throw new TlsFatalAlert((short)10);
          }
        }
        else {
          throw new TlsFatalAlert((short)10);
        }
      }
      else if (this.x == 1)
      {
        d0(paramByteArrayInputStream);
        this.x = ((short)2);
        this.f.m();
        b();
        if (this.y)
        {
          this.r.f = a.g(this.q.e());
          this.f.s(t().f(), t().l());
        }
        else
        {
          B();
          paramByteArrayInputStream = this.G;
          if (paramByteArrayInputStream.length > 0) {
            this.p = new j1(paramByteArrayInputStream, null);
          }
        }
      }
      else
      {
        throw new TlsFatalAlert((short)10);
      }
    }
    else
    {
      g1.c(paramByteArrayInputStream);
      if (this.x == 16) {
        O();
      }
    }
  }
  
  public void a0(k0 paramk0)
    throws IOException
  {
    if (paramk0 != null)
    {
      if (this.E == null)
      {
        this.E = paramk0;
        Object localObject = new a0();
        this.r = ((a0)localObject);
        ((a0)localObject).a = 1;
        this.F = new m0(this.g, this.r);
        this.r.g = g1.i(paramk0.w(), this.F.d());
        this.E.e(this.F);
        this.f.l(this.F);
        paramk0 = paramk0.r();
        if ((paramk0 != null) && (paramk0.b()))
        {
          localObject = paramk0.c();
          if (localObject != null)
          {
            this.p = paramk0;
            this.q = ((c0)localObject);
          }
        }
        f0();
        this.x = ((short)1);
        d();
        return;
      }
      throw new IllegalStateException("'connect' can only be called once");
    }
    throw new IllegalArgumentException("'tlsClient' cannot be null");
  }
  
  protected void b0(Vector paramVector)
    throws IOException
  {
    this.E.q(paramVector);
    this.x = ((short)3);
    paramVector = this.E.h();
    this.H = paramVector;
    paramVector.a(n());
  }
  
  protected void c0(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    v localv = v.a(paramByteArrayInputStream);
    g1.c(paramByteArrayInputStream);
    this.E.x(localv);
  }
  
  protected void d0(ByteArrayInputStream paramByteArrayInputStream)
    throws IOException
  {
    Object localObject1 = m1.m0(paramByteArrayInputStream);
    if (!((x)localObject1).g())
    {
      if (((x)localObject1).a(this.f.k()))
      {
        if (((x)localObject1).h(n().a()))
        {
          this.f.u((x)localObject1);
          o().i((x)localObject1);
          this.E.m((x)localObject1);
          this.r.h = m1.Z(32, paramByteArrayInputStream);
          localObject1 = m1.c0(paramByteArrayInputStream);
          this.G = ((byte[])localObject1);
          if (localObject1.length <= 32)
          {
            this.E.s((byte[])localObject1);
            localObject1 = this.G;
            int i = localObject1.length;
            boolean bool1 = false;
            Object localObject2;
            if (i > 0)
            {
              localObject2 = this.p;
              if ((localObject2 != null) && (a.c((byte[])localObject1, ((i1)localObject2).a())))
              {
                bool2 = true;
                break label157;
              }
            }
            boolean bool2 = false;
            label157:
            this.y = bool2;
            i = m1.d0(paramByteArrayInputStream);
            if ((a.p(this.t, i)) && (i != 0) && (!l.a(i)) && (m1.Q(i, n().b())))
            {
              this.E.v(i);
              short s = m1.j0(paramByteArrayInputStream);
              if (a.q(this.u, s))
              {
                this.E.b(s);
                paramByteArrayInputStream = g1.M(paramByteArrayInputStream);
                this.w = paramByteArrayInputStream;
                if (paramByteArrayInputStream != null)
                {
                  localObject1 = paramByteArrayInputStream.keys();
                  while (((Enumeration)localObject1).hasMoreElements())
                  {
                    paramByteArrayInputStream = (Integer)((Enumeration)localObject1).nextElement();
                    if ((!paramByteArrayInputStream.equals(g1.a)) && (m1.B(this.v, paramByteArrayInputStream) == null)) {
                      throw new TlsFatalAlert((short)110);
                    }
                  }
                }
                paramByteArrayInputStream = m1.B(this.w, g1.a);
                if (paramByteArrayInputStream != null)
                {
                  this.A = true;
                  if (!a.o(paramByteArrayInputStream, g1.j(m1.a))) {
                    throw new TlsFatalAlert((short)40);
                  }
                }
                this.E.k(this.A);
                localObject1 = this.v;
                paramByteArrayInputStream = this.w;
                if (this.y) {
                  if ((i == this.q.c()) && (s == this.q.d()))
                  {
                    localObject1 = null;
                    paramByteArrayInputStream = this.q.f();
                  }
                  else
                  {
                    throw new TlsFatalAlert((short)47);
                  }
                }
                localObject2 = this.r;
                ((a0)localObject2).b = i;
                ((a0)localObject2).c = s;
                if (paramByteArrayInputStream != null)
                {
                  bool2 = u0.c(paramByteArrayInputStream);
                  if ((bool2) && (!m1.J(i))) {
                    throw new TlsFatalAlert((short)47);
                  }
                  localObject2 = this.r;
                  ((a0)localObject2).n = bool2;
                  ((a0)localObject2).o = u0.d(paramByteArrayInputStream);
                  this.r.l = H((Hashtable)localObject1, paramByteArrayInputStream, (short)47);
                  this.r.m = u0.e(paramByteArrayInputStream);
                  if ((!this.y) && (m1.H(paramByteArrayInputStream, u0.g, (short)47))) {
                    bool2 = true;
                  } else {
                    bool2 = false;
                  }
                  this.B = bool2;
                  bool2 = bool1;
                  if (!this.y)
                  {
                    bool2 = bool1;
                    if (m1.H(paramByteArrayInputStream, g1.b, (short)47)) {
                      bool2 = true;
                    }
                  }
                  this.C = bool2;
                }
                if (localObject1 != null) {
                  this.E.g(paramByteArrayInputStream);
                }
                this.r.d = g1.s(n(), this.r.b());
                this.r.e = 12;
                return;
              }
              throw new TlsFatalAlert((short)47);
            }
            throw new TlsFatalAlert((short)47);
          }
          throw new TlsFatalAlert((short)47);
        }
        throw new TlsFatalAlert((short)47);
      }
      throw new TlsFatalAlert((short)47);
    }
    throw new TlsFatalAlert((short)47);
  }
  
  protected void e0(q paramq)
    throws IOException
  {
    g1.a locala = new g1.a(this, (short)15);
    paramq.a(locala);
    locala.a();
  }
  
  protected void f()
  {
    super.f();
    this.G = null;
    this.H = null;
    this.I = null;
    this.J = null;
    this.K = null;
  }
  
  protected void f0()
    throws IOException
  {
    this.f.u(this.E.i());
    x localx = this.E.a();
    if (!localx.g())
    {
      o().g(localx);
      Object localObject1 = m1.a;
      Object localObject2 = this.p;
      if (localObject2 != null)
      {
        localObject3 = ((i1)localObject2).a();
        if (localObject3 != null)
        {
          localObject2 = localObject3;
          if (localObject3.length <= 32) {
            break label80;
          }
        }
      }
      localObject2 = localObject1;
      label80:
      boolean bool1 = this.E.c();
      this.t = this.E.j();
      this.u = this.E.o();
      if (localObject2.length > 0)
      {
        c0 localc0 = this.q;
        if (localc0 != null)
        {
          localObject3 = localObject1;
          if (!a.p(this.t, localc0.c())) {
            break label177;
          }
          if (!a.q(this.u, this.q.d()))
          {
            localObject3 = localObject1;
            break label177;
          }
        }
      }
      Object localObject3 = localObject2;
      label177:
      this.v = this.E.y();
      localObject2 = new g1.a(this, (short)1);
      m1.N0(localx, (OutputStream)localObject2);
      ((ByteArrayOutputStream)localObject2).write(this.r.c());
      m1.v0((byte[])localObject3, (OutputStream)localObject2);
      int i;
      if (m1.B(this.v, g1.a) == null) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool2 = a.p(this.t, 255);
      if ((i != 0) && ((bool2 ^ true))) {
        this.t = a.a(this.t, 255);
      }
      if ((bool1) && (!a.p(this.t, 22016))) {
        this.t = a.a(this.t, 22016);
      }
      m1.A0(this.t, (OutputStream)localObject2);
      m1.L0(this.u, (OutputStream)localObject2);
      localObject1 = this.v;
      if (localObject1 != null) {
        g1.W((OutputStream)localObject2, (Hashtable)localObject1);
      }
      ((g1.a)localObject2).a();
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected void g0()
    throws IOException
  {
    g1.a locala = new g1.a(this, (short)16);
    this.H.e(locala);
    locala.a();
  }
  
  protected p0 n()
  {
    return this.F;
  }
  
  c o()
  {
    return this.F;
  }
  
  protected f1 t()
  {
    return this.E;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\n0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */