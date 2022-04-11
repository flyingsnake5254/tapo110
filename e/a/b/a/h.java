package e.a.b.a;

import java.math.BigInteger;
import java.util.Hashtable;

public abstract class h
{
  protected static e[] a = new e[0];
  protected d b;
  protected e c;
  protected e d;
  protected e[] e;
  protected boolean f;
  protected Hashtable g = null;
  
  protected h(d paramd, e parame1, e parame2)
  {
    this(paramd, parame1, parame2, m(paramd));
  }
  
  protected h(d paramd, e parame1, e parame2, e[] paramArrayOfe)
  {
    this.b = paramd;
    this.c = parame1;
    this.d = parame2;
    this.e = paramArrayOfe;
  }
  
  protected static e[] m(d paramd)
  {
    int i;
    if (paramd == null) {
      i = 0;
    } else {
      i = paramd.r();
    }
    if ((i != 0) && (i != 5))
    {
      e locale = paramd.n(c.b);
      if ((i != 1) && (i != 2)) {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 6) {
              throw new IllegalArgumentException("unknown coordinate system");
            }
          }
          else {
            return new e[] { locale, paramd.o() };
          }
        }
        else {
          return new e[] { locale, locale, locale };
        }
      }
      return new e[] { locale };
    }
    return a;
  }
  
  public h A()
  {
    if (u()) {
      return this;
    }
    int i = j();
    if ((i != 0) && (i != 5))
    {
      e locale = s(0);
      if (locale.h()) {
        return this;
      }
      return B(locale.g());
    }
    return this;
  }
  
  h B(e parame)
  {
    int i = j();
    if (i != 1) {
      if ((i != 2) && (i != 3) && (i != 4))
      {
        if (i != 6) {
          throw new IllegalStateException("not a projective coordinate system");
        }
      }
      else
      {
        e locale = parame.o();
        return c(locale, locale.j(parame));
      }
    }
    return c(parame, parame);
  }
  
  protected abstract boolean C();
  
  protected boolean D()
  {
    boolean bool1 = c.b.equals(this.b.q());
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    BigInteger localBigInteger = this.b.w();
    bool1 = bool2;
    if (localBigInteger != null) {
      if (b.l(this, localBigInteger).u()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public h E(e parame)
  {
    if (u()) {
      parame = this;
    } else {
      parame = i().j(n().j(parame), o(), p(), this.f);
    }
    return parame;
  }
  
  public h F(e parame)
  {
    if (u()) {
      parame = this;
    } else {
      parame = i().j(n(), o().j(parame), p(), this.f);
    }
    return parame;
  }
  
  public abstract h G(h paramh);
  
  public h H()
  {
    return K(this);
  }
  
  public h I(int paramInt)
  {
    if (paramInt >= 0)
    {
      for (h localh = this;; localh = localh.J())
      {
        paramInt--;
        if (paramInt < 0) {
          break;
        }
      }
      return localh;
    }
    throw new IllegalArgumentException("'e' cannot be negative");
  }
  
  public abstract h J();
  
  public h K(h paramh)
  {
    return J().a(paramh);
  }
  
  public abstract h a(h paramh);
  
  protected void b()
  {
    if (v()) {
      return;
    }
    throw new IllegalStateException("point not in normal form");
  }
  
  protected h c(e parame1, e parame2)
  {
    return i().i(n().j(parame1), o().j(parame2), this.f);
  }
  
  protected abstract h d();
  
  public boolean e(h paramh)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramh == null) {
      return false;
    }
    Object localObject1 = i();
    Object localObject2 = paramh.i();
    int i;
    if (localObject1 == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (localObject2 == null) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool3 = u();
    boolean bool4 = paramh.u();
    if ((!bool3) && (!bool4))
    {
      if ((i == 0) || (j == 0))
      {
        if (i != 0) {
          paramh = paramh.A();
        }
      }
      else
      {
        localObject1 = this;
        break label169;
      }
      if (j != 0)
      {
        localObject1 = A();
      }
      else
      {
        if (!((d)localObject1).m((d)localObject2)) {
          return false;
        }
        localObject2 = new h[2];
        localObject2[0] = this;
        localObject2[1] = ((d)localObject1).y(paramh);
        ((d)localObject1).z((h[])localObject2);
        localObject1 = localObject2[0];
        paramh = localObject2[1];
      }
      label169:
      bool5 = bool2;
      if (((h)localObject1).q().equals(paramh.q()))
      {
        bool5 = bool2;
        if (((h)localObject1).r().equals(paramh.r())) {
          bool5 = true;
        }
      }
      return bool5;
    }
    boolean bool5 = bool1;
    if (bool3)
    {
      bool5 = bool1;
      if (bool4) {
        if ((i == 0) && (j == 0))
        {
          bool5 = bool1;
          if (!((d)localObject1).m((d)localObject2)) {}
        }
        else
        {
          bool5 = true;
        }
      }
    }
    return bool5;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return false;
    }
    return e((h)paramObject);
  }
  
  public e f()
  {
    b();
    return q();
  }
  
  public e g()
  {
    b();
    return r();
  }
  
  protected abstract boolean h();
  
  public int hashCode()
  {
    Object localObject = i();
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((d)localObject).hashCode() ^ 0xFFFFFFFF;
    }
    int j = i;
    if (!u())
    {
      localObject = A();
      j = i ^ ((h)localObject).q().hashCode() * 17 ^ ((h)localObject).r().hashCode() * 257;
    }
    return j;
  }
  
  public d i()
  {
    return this.b;
  }
  
  protected int j()
  {
    d locald = this.b;
    int i;
    if (locald == null) {
      i = 0;
    } else {
      i = locald.r();
    }
    return i;
  }
  
  public final h k()
  {
    return A().d();
  }
  
  public byte[] l(boolean paramBoolean)
  {
    if (u()) {
      return new byte[1];
    }
    Object localObject = A();
    byte[] arrayOfByte1 = ((h)localObject).q().e();
    if (paramBoolean)
    {
      arrayOfByte2 = new byte[arrayOfByte1.length + 1];
      int i;
      if (((h)localObject).h()) {
        i = 3;
      } else {
        i = 2;
      }
      arrayOfByte2[0] = ((byte)(byte)i);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
      return arrayOfByte2;
    }
    byte[] arrayOfByte2 = ((h)localObject).r().e();
    localObject = new byte[arrayOfByte1.length + arrayOfByte2.length + 1];
    localObject[0] = ((byte)4);
    System.arraycopy(arrayOfByte1, 0, localObject, 1, arrayOfByte1.length);
    System.arraycopy(arrayOfByte2, 0, localObject, arrayOfByte1.length + 1, arrayOfByte2.length);
    return (byte[])localObject;
  }
  
  public final e n()
  {
    return this.c;
  }
  
  public final e o()
  {
    return this.d;
  }
  
  protected final e[] p()
  {
    return this.e;
  }
  
  public e q()
  {
    return this.c;
  }
  
  public e r()
  {
    return this.d;
  }
  
  public e s(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.e;
      if (paramInt < localObject.length) {
        return localObject[paramInt];
      }
    }
    Object localObject = null;
    return (e)localObject;
  }
  
  boolean t(final boolean paramBoolean)
  {
    if (u()) {
      return true;
    }
    return ((t)i().B(this, "bc_validity", new a(paramBoolean))).b() ^ true;
  }
  
  public String toString()
  {
    if (u()) {
      return "INF";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('(');
    localStringBuffer.append(n());
    localStringBuffer.append(',');
    localStringBuffer.append(o());
    for (int i = 0; i < this.e.length; i++)
    {
      localStringBuffer.append(',');
      localStringBuffer.append(this.e[i]);
    }
    localStringBuffer.append(')');
    return localStringBuffer.toString();
  }
  
  public boolean u()
  {
    Object localObject = this.c;
    boolean bool1 = false;
    boolean bool2;
    if ((localObject != null) && (this.d != null))
    {
      localObject = this.e;
      bool2 = bool1;
      if (localObject.length > 0)
      {
        bool2 = bool1;
        if (!localObject[0].i()) {}
      }
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean v()
  {
    int i = j();
    boolean bool = false;
    if ((i == 0) || (i == 5) || (u()) || (this.e[0].h())) {
      bool = true;
    }
    return bool;
  }
  
  public boolean w()
  {
    return t(true);
  }
  
  boolean x()
  {
    return t(false);
  }
  
  public h y(BigInteger paramBigInteger)
  {
    return i().v().a(this, paramBigInteger);
  }
  
  public abstract h z();
  
  class a
    implements o
  {
    a(boolean paramBoolean) {}
    
    public p a(p paramp)
    {
      if ((paramp instanceof t)) {
        paramp = (t)paramp;
      } else {
        paramp = null;
      }
      Object localObject = paramp;
      if (paramp == null) {
        localObject = new t();
      }
      if (((t)localObject).b()) {
        return (p)localObject;
      }
      if (!((t)localObject).a())
      {
        if (!h.this.C())
        {
          ((t)localObject).e();
          return (p)localObject;
        }
        ((t)localObject).d();
      }
      if ((paramBoolean) && (!((t)localObject).c()))
      {
        if (!h.this.D())
        {
          ((t)localObject).e();
          return (p)localObject;
        }
        ((t)localObject).f();
      }
      return (p)localObject;
    }
  }
  
  public static abstract class b
    extends h
  {
    protected b(d paramd, e parame1, e parame2)
    {
      super(parame1, parame2);
    }
    
    protected b(d paramd, e parame1, e parame2, e[] paramArrayOfe)
    {
      super(parame1, parame2, paramArrayOfe);
    }
    
    protected boolean C()
    {
      Object localObject1 = i();
      e locale1 = this.c;
      e locale2 = ((d)localObject1).o();
      Object localObject2 = ((d)localObject1).p();
      int i = ((d)localObject1).r();
      if (i == 6)
      {
        localObject3 = this.e[0];
        boolean bool = ((e)localObject3).h();
        if (locale1.i())
        {
          localObject4 = this.d.o();
          localObject1 = localObject2;
          if (!bool) {
            localObject1 = ((e)localObject2).j(((e)localObject3).o());
          }
          return localObject4.equals(localObject1);
        }
        locale3 = this.d;
        localObject4 = locale1.o();
        if (bool)
        {
          localObject1 = locale3.o().a(locale3).a(locale2);
          localObject3 = ((e)localObject4).o().a((e)localObject2);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
        else
        {
          locale1 = ((e)localObject3).o();
          localObject1 = locale1.o();
          localObject3 = locale3.a((e)localObject3).l(locale3, locale2, locale1);
          localObject1 = ((e)localObject4).p((e)localObject2, (e)localObject1);
          localObject2 = localObject3;
        }
        return ((e)localObject2).j((e)localObject4).equals(localObject1);
      }
      localObject1 = this.d;
      e locale3 = ((e)localObject1).a(locale1).j((e)localObject1);
      localObject1 = locale2;
      Object localObject3 = localObject2;
      Object localObject4 = locale3;
      if (i != 0) {
        if (i == 1)
        {
          e locale4 = this.e[0];
          localObject1 = locale2;
          localObject3 = localObject2;
          localObject4 = locale3;
          if (!locale4.h())
          {
            localObject3 = locale4.j(locale4.o());
            localObject4 = locale3.j(locale4);
            localObject1 = locale2.j(locale4);
            localObject3 = ((e)localObject2).j((e)localObject3);
          }
        }
        else
        {
          throw new IllegalStateException("unsupported coordinate system");
        }
      }
      return localObject4.equals(locale1.a((e)localObject1).j(locale1.o()).a((e)localObject3));
    }
    
    protected boolean D()
    {
      Object localObject1 = this.b.q();
      boolean bool1 = c.c.equals(localObject1);
      boolean bool2 = true;
      boolean bool3 = true;
      if (bool1)
      {
        if (((e.a)A().f().a(this.b.o())).u() != 0) {
          bool3 = false;
        }
        return bool3;
      }
      if (c.e.equals(localObject1))
      {
        Object localObject2 = A();
        localObject1 = ((h)localObject2).f();
        Object localObject3 = this.b;
        localObject3 = ((d.b)localObject3).H(((e)localObject1).a(((d)localObject3).o()));
        if (localObject3 == null) {
          return false;
        }
        localObject2 = ((e)localObject1).j((e)localObject3).a(((h)localObject2).g()).a(this.b.o());
        bool3 = bool2;
        if (((e.a)localObject2).u() != 0) {
          if (((e.a)((e)localObject2).a((e)localObject1)).u() == 0) {
            bool3 = bool2;
          } else {
            bool3 = false;
          }
        }
        return bool3;
      }
      return super.D();
    }
    
    public h E(e parame)
    {
      if (u()) {
        return this;
      }
      int i = j();
      if (i != 5)
      {
        if (i != 6) {
          return super.E(parame);
        }
        e locale1 = n();
        locale2 = o();
        localObject = p()[0];
        locale3 = locale1.j(parame.o());
        locale2 = locale2.a(locale1).a(locale3);
        parame = ((e)localObject).j(parame);
        localObject = i();
        boolean bool = this.f;
        return ((d)localObject).j(locale3, locale2, new e[] { parame }, bool);
      }
      e locale3 = n();
      e locale2 = o();
      Object localObject = locale3.j(parame);
      parame = locale2.a(locale3).d(parame).a((e)localObject);
      return i().j(locale3, parame, p(), this.f);
    }
    
    public h F(e parame)
    {
      if (u()) {
        return this;
      }
      int i = j();
      if ((i != 5) && (i != 6)) {
        return super.F(parame);
      }
      e locale = n();
      parame = o().a(locale).j(parame).a(locale);
      return i().j(locale, parame, p(), this.f);
    }
    
    public h G(h paramh)
    {
      if (paramh.u()) {
        return this;
      }
      return a(paramh.z());
    }
    
    public b L(int paramInt)
    {
      if (u()) {
        return this;
      }
      Object localObject = i();
      int i = ((d)localObject).r();
      e locale1 = this.c;
      e locale2;
      e locale3;
      boolean bool;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 5) {
            break label127;
          }
          if (i != 6) {
            throw new IllegalStateException("unsupported coordinate system");
          }
        }
        locale2 = this.d;
        locale3 = this.e[0];
        locale1 = locale1.q(paramInt);
        locale2 = locale2.q(paramInt);
        locale3 = locale3.q(paramInt);
        bool = this.f;
      }
      for (localObject = ((d)localObject).j(locale1, locale2, new e[] { locale3 }, bool);; localObject = ((d)localObject).i(locale1.q(paramInt), locale3.q(paramInt), this.f))
      {
        return (b)localObject;
        label127:
        locale3 = this.d;
      }
    }
  }
  
  public static abstract class c
    extends h
  {
    protected c(d paramd, e parame1, e parame2)
    {
      super(parame1, parame2);
    }
    
    protected c(d paramd, e parame1, e parame2, e[] paramArrayOfe)
    {
      super(parame1, parame2, paramArrayOfe);
    }
    
    protected boolean C()
    {
      e locale1 = this.c;
      Object localObject = this.d;
      e locale2 = this.b.o();
      e locale3 = this.b.p();
      e locale4 = ((e)localObject).o();
      int i = j();
      e locale5 = locale4;
      e locale6 = locale2;
      localObject = locale3;
      if (i != 0)
      {
        e locale7;
        if (i != 1)
        {
          if ((i != 2) && (i != 3) && (i != 4)) {
            throw new IllegalStateException("unsupported coordinate system");
          }
          locale7 = this.e[0];
          locale5 = locale4;
          locale6 = locale2;
          localObject = locale3;
          if (!locale7.h())
          {
            locale6 = locale7.o();
            localObject = locale6.o();
            locale5 = locale6.j((e)localObject);
            locale6 = locale2.j((e)localObject);
            localObject = locale3.j(locale5);
            locale5 = locale4;
          }
        }
        else
        {
          locale7 = this.e[0];
          locale5 = locale4;
          locale6 = locale2;
          localObject = locale3;
          if (!locale7.h())
          {
            locale6 = locale7.o();
            localObject = locale7.j(locale6);
            locale5 = locale4.j(locale7);
            locale6 = locale2.j(locale6);
            localObject = locale3.j((e)localObject);
          }
        }
      }
      return locale5.equals(locale1.o().a(locale6).j(locale1).a((e)localObject));
    }
    
    public h G(h paramh)
    {
      if (paramh.u()) {
        return this;
      }
      return a(paramh.z());
    }
    
    protected boolean h()
    {
      return g().s();
    }
  }
  
  public static class d
    extends h.b
  {
    public d(d paramd, e parame1, e parame2, boolean paramBoolean)
    {
      super(parame1, parame2);
      int i = 1;
      int j;
      if (parame1 == null) {
        j = 1;
      } else {
        j = 0;
      }
      if (parame2 != null) {
        i = 0;
      }
      if (j == i)
      {
        if (parame1 != null)
        {
          e.c.v(this.c, this.d);
          if (paramd != null) {
            e.c.v(this.c, this.b.o());
          }
        }
        this.f = paramBoolean;
        return;
      }
      throw new IllegalArgumentException("Exactly one of the field elements is null");
    }
    
    d(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
    {
      super(parame1, parame2, paramArrayOfe);
      this.f = paramBoolean;
    }
    
    public h J()
    {
      if (u()) {
        return this;
      }
      d locald = i();
      Object localObject1 = this.c;
      if (((e)localObject1).i()) {
        return locald.u();
      }
      int i = locald.r();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 6)
          {
            e locale1 = this.d;
            e locale2 = this.e[0];
            bool = locale2.h();
            if (bool) {
              locale3 = locale1;
            } else {
              locale3 = locale1.j(locale2);
            }
            if (bool) {
              locale4 = locale2;
            } else {
              locale4 = locale2.o();
            }
            locale5 = locald.o();
            if (bool) {
              locale6 = locale5;
            } else {
              locale6 = locale5.j(locale4);
            }
            e locale7 = locale1.o().a(locale3).a(locale6);
            if (locale7.i()) {
              return new d(locald, locale7, locald.p().n(), this.f);
            }
            e locale8 = locale7.o();
            if (bool) {
              localObject2 = locale7;
            } else {
              localObject2 = locale7.j(locale4);
            }
            e locale9 = locald.p();
            if (locale9.c() < locald.t() >> 1)
            {
              locale3 = locale1.a((e)localObject1).o();
              if (locale9.h()) {
                localObject1 = locale6.a(locale4).o();
              } else {
                localObject1 = locale6.p(locale9, locale4.o());
              }
              locale3 = locale3.a(locale7).a(locale4).j(locale3).a((e)localObject1).a(locale8);
              if (!locale5.i())
              {
                localObject1 = locale3;
                if (locale5.h()) {
                  break label387;
                }
                localObject1 = locale3.a(locale5.b().j((e)localObject2));
                break label387;
              }
            }
            else
            {
              if (!bool) {
                localObject1 = ((e)localObject1).j(locale2);
              }
              locale3 = ((e)localObject1).p(locale7, locale3).a(locale8);
            }
            localObject1 = locale3.a((e)localObject2);
            label387:
            bool = this.f;
            return new d(locald, locale8, (e)localObject1, new e[] { localObject2 }, bool);
          }
          throw new IllegalStateException("unsupported coordinate system");
        }
        locale3 = this.d;
        e locale4 = this.e[0];
        boolean bool = locale4.h();
        if (bool) {
          localObject2 = localObject1;
        } else {
          localObject2 = ((e)localObject1).j(locale4);
        }
        if (!bool) {
          locale3 = locale3.j(locale4);
        }
        locale4 = ((e)localObject1).o();
        localObject1 = locale4.a(locale3);
        locale3 = ((e)localObject2).o();
        e locale6 = ((e)localObject1).a((e)localObject2);
        e locale5 = locale6.l((e)localObject1, locale3, locald.o());
        localObject1 = ((e)localObject2).j(locale5);
        locale4 = locale4.o().l((e)localObject2, locale5, locale6);
        localObject2 = ((e)localObject2).j(locale3);
        bool = this.f;
        return new d(locald, (e)localObject1, locale4, new e[] { localObject2 }, bool);
      }
      e locale3 = this.d.d((e)localObject1).a((e)localObject1);
      Object localObject2 = locale3.o().a(locale3).a(locald.o());
      return new d(locald, (e)localObject2, ((e)localObject1).p((e)localObject2, locale3.b()), this.f);
    }
    
    public h K(h paramh)
    {
      if (u()) {
        return paramh;
      }
      if (paramh.u()) {
        return J();
      }
      d locald = i();
      e locale1 = this.c;
      if (locale1.i()) {
        return paramh;
      }
      if (locald.r() != 6) {
        return J().a(paramh);
      }
      e locale2 = paramh.c;
      e locale3 = paramh.e[0];
      if ((!locale2.i()) && (locale3.h()))
      {
        locale3 = this.d;
        e locale4 = this.e[0];
        e locale5 = paramh.d;
        e locale6 = locale1.o();
        e locale7 = locale3.o();
        locale1 = locale4.o();
        locale3 = locale3.j(locale4);
        locale3 = locald.o().j(locale1).a(locale7).a(locale3);
        locale5 = locale5.b();
        locale6 = locald.o().a(locale5).j(locale1).a(locale7).l(locale3, locale6, locale1);
        locale7 = locale2.j(locale1);
        locale2 = locale7.a(locale3).o();
        if (locale2.i())
        {
          if (locale6.i()) {
            return paramh.J();
          }
          return locald.u();
        }
        if (locale6.i()) {
          return new d(locald, locale6, locald.p().n(), this.f);
        }
        paramh = locale6.o().j(locale7);
        locale1 = locale6.j(locale2).j(locale1);
        locale2 = locale6.a(locale2).o().l(locale3, locale5, locale1);
        boolean bool = this.f;
        return new d(locald, paramh, locale2, new e[] { locale1 }, bool);
      }
      return J().a(paramh);
    }
    
    public h a(h paramh)
    {
      if (u()) {
        return paramh;
      }
      if (paramh.u()) {
        return this;
      }
      d locald = i();
      int i = locald.r();
      Object localObject = this.c;
      e locale1 = paramh.c;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 6)
          {
            if (((e)localObject).i())
            {
              if (locale1.i()) {
                return locald.u();
              }
              return paramh.a(this);
            }
            locale2 = this.d;
            locale3 = this.e[0];
            locale4 = paramh.d;
            locale5 = paramh.e[0];
            bool1 = locale3.h();
            if (!bool1)
            {
              paramh = locale1.j(locale3);
              locale6 = locale4.j(locale3);
            }
            else
            {
              paramh = locale1;
              locale6 = locale4;
            }
            boolean bool2 = locale5.h();
            if (!bool2)
            {
              localObject = ((e)localObject).j(locale5);
              locale7 = locale2.j(locale5);
            }
            else
            {
              locale7 = locale2;
            }
            locale8 = locale7.a(locale6);
            locale6 = ((e)localObject).a(paramh);
            if (locale6.i())
            {
              if (locale8.i()) {
                return J();
              }
              return locald.u();
            }
            if (locale1.i())
            {
              localObject = A();
              paramh = ((h)localObject).q();
              localObject = ((h)localObject).r();
              locale7 = ((e)localObject).a(locale4).d(paramh);
              locale6 = locale7.o().a(locale7).a(paramh).a(locald.o());
              if (locale6.i()) {
                return new d(locald, locale6, locald.p().n(), this.f);
              }
              paramh = locale7.j(paramh.a(locale6)).a(locale6).a((e)localObject).d(locale6).a(locale6);
              localObject = locald.n(c.b);
            }
            else
            {
              locale7 = locale6.o();
              locale6 = locale8.j((e)localObject);
              localObject = locale8.j(paramh);
              locale6 = locale6.j((e)localObject);
              if (locale6.i()) {
                return new d(locald, locale6, locald.p().n(), this.f);
              }
              paramh = locale8.j(locale7);
              if (!bool2) {
                paramh = paramh.j(locale5);
              }
              locale7 = ((e)localObject).a(locale7).p(paramh, locale2.a(locale3));
              localObject = paramh;
              if (!bool1) {
                localObject = paramh.j(locale3);
              }
              paramh = locale7;
            }
            bool1 = this.f;
            return new d(locald, locale6, paramh, new e[] { localObject }, bool1);
          }
          throw new IllegalStateException("unsupported coordinate system");
        }
        locale7 = this.d;
        locale6 = this.e[0];
        e locale4 = paramh.d;
        e locale2 = paramh.e[0];
        boolean bool1 = locale2.h();
        locale4 = locale6.j(locale4);
        if (bool1) {
          paramh = locale7;
        } else {
          paramh = locale7.j(locale2);
        }
        locale4 = locale4.a(paramh);
        locale1 = locale6.j(locale1);
        if (bool1) {
          paramh = (h)localObject;
        } else {
          paramh = ((e)localObject).j(locale2);
        }
        e locale8 = locale1.a(paramh);
        if (locale8.i())
        {
          if (locale4.i()) {
            return J();
          }
          return locald.u();
        }
        locale1 = locale8.o();
        e locale3 = locale1.j(locale8);
        if (bool1) {
          paramh = locale6;
        } else {
          paramh = locale6.j(locale2);
        }
        e locale9 = locale4.a(locale8);
        e locale10 = locale9.l(locale4, locale1, locald.o()).j(paramh).a(locale3);
        e locale5 = locale8.j(locale10);
        if (bool1) {
          locale6 = locale1;
        } else {
          locale6 = locale1.j(locale2);
        }
        localObject = locale4.l((e)localObject, locale8, locale7).l(locale6, locale9, locale10);
        paramh = locale3.j(paramh);
        bool1 = this.f;
        return new d(locald, locale5, (e)localObject, new e[] { paramh }, bool1);
      }
      e locale6 = this.d;
      e locale7 = paramh.d;
      paramh = ((e)localObject).a(locale1);
      locale7 = locale6.a(locale7);
      if (paramh.i())
      {
        if (locale7.i()) {
          return J();
        }
        return locald.u();
      }
      locale7 = locale7.d(paramh);
      paramh = locale7.o().a(locale7).a(paramh).a(locald.o());
      return new d(locald, paramh, locale7.j(((e)localObject).a(paramh)).a(paramh).a(locale6), this.f);
    }
    
    protected h d()
    {
      return new d(null, f(), g(), false);
    }
    
    protected boolean h()
    {
      e locale1 = n();
      boolean bool1 = locale1.i();
      boolean bool2 = false;
      if (bool1) {
        return false;
      }
      e locale2 = o();
      int i = j();
      if ((i != 5) && (i != 6)) {
        return locale2.d(locale1).s();
      }
      if (locale2.s() != locale1.s()) {
        bool2 = true;
      }
      return bool2;
    }
    
    public e r()
    {
      int i = j();
      if ((i != 5) && (i != 6)) {
        return this.d;
      }
      Object localObject = this.c;
      e locale1 = this.d;
      if ((!u()) && (!((e)localObject).i()))
      {
        locale1 = locale1.a((e)localObject).j((e)localObject);
        localObject = locale1;
        if (6 == i)
        {
          e locale2 = this.e[0];
          localObject = locale1;
          if (!locale2.h()) {
            localObject = locale1.d(locale2);
          }
        }
        return (e)localObject;
      }
      return locale1;
    }
    
    public h z()
    {
      if (u()) {
        return this;
      }
      e locale1 = this.c;
      if (locale1.i()) {
        return this;
      }
      int i = j();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 5)
          {
            if (i == 6)
            {
              locale2 = this.d;
              localObject1 = this.e[0];
              localObject2 = this.b;
              locale2 = locale2.a((e)localObject1);
              bool = this.f;
              return new d((d)localObject2, locale1, locale2, new e[] { localObject1 }, bool);
            }
            throw new IllegalStateException("unsupported coordinate system");
          }
          localObject2 = this.d;
          return new d(this.b, locale1, ((e)localObject2).b(), this.f);
        }
        e locale2 = this.d;
        localObject2 = this.e[0];
        Object localObject1 = this.b;
        locale2 = locale2.a(locale1);
        boolean bool = this.f;
        return new d((d)localObject1, locale1, locale2, new e[] { localObject2 }, bool);
      }
      Object localObject2 = this.d;
      return new d(this.b, locale1, ((e)localObject2).a(locale1), this.f);
    }
  }
  
  public static class e
    extends h.c
  {
    public e(d paramd, e parame1, e parame2, boolean paramBoolean)
    {
      super(parame1, parame2);
      int i = 1;
      int j;
      if (parame1 == null) {
        j = 1;
      } else {
        j = 0;
      }
      if (parame2 != null) {
        i = 0;
      }
      if (j == i)
      {
        this.f = paramBoolean;
        return;
      }
      throw new IllegalArgumentException("Exactly one of the field elements is null");
    }
    
    e(d paramd, e parame1, e parame2, e[] paramArrayOfe, boolean paramBoolean)
    {
      super(parame1, parame2, paramArrayOfe);
      this.f = paramBoolean;
    }
    
    public h H()
    {
      if (u()) {
        return this;
      }
      e locale1 = this.d;
      if (locale1.i()) {
        return this;
      }
      d locald = i();
      int i = locald.r();
      if (i != 0)
      {
        if (i != 4) {
          return J().a(this);
        }
        return Q(false).a(this);
      }
      e locale2 = this.c;
      e locale3 = R(locale1);
      e locale4 = locale3.o();
      e locale5 = P(locale2.o()).a(i().o());
      e locale6 = locale5.o();
      locale6 = P(locale2).j(locale4).r(locale6);
      if (locale6.i()) {
        return i().u();
      }
      locale3 = locale6.j(locale3).g();
      locale5 = locale6.j(locale3).j(locale5);
      locale4 = locale4.o().j(locale3).r(locale5);
      locale5 = locale4.r(locale5).j(locale5.a(locale4)).a(locale2);
      return new e(locald, locale5, locale2.r(locale5).j(locale4).r(locale1), this.f);
    }
    
    public h I(int paramInt)
    {
      if (paramInt >= 0)
      {
        if ((paramInt != 0) && (!u()))
        {
          if (paramInt == 1) {
            return J();
          }
          d locald = i();
          e locale1 = this.d;
          if (locale1.i()) {
            return locald.u();
          }
          int i = locald.r();
          e locale2 = locald.o();
          Object localObject1 = this.c;
          Object localObject2 = this.e;
          if (localObject2.length < 1) {
            localObject3 = locald.n(c.b);
          } else {
            localObject3 = localObject2[0];
          }
          e locale3 = locale1;
          localObject2 = locale2;
          Object localObject4 = localObject1;
          if (!((e)localObject3).h())
          {
            locale3 = locale1;
            localObject2 = locale2;
            localObject4 = localObject1;
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2)
                {
                  if (i == 4)
                  {
                    localObject2 = O();
                    locale3 = locale1;
                    localObject4 = localObject1;
                    break label225;
                  }
                  throw new IllegalStateException("unsupported coordinate system");
                }
                localObject2 = null;
                locale3 = locale1;
                localObject4 = localObject1;
              }
              else
              {
                localObject2 = ((e)localObject3).o();
                localObject4 = ((e)localObject1).j((e)localObject3);
                locale3 = locale1.j((e)localObject2);
              }
              localObject2 = L((e)localObject3, (e)localObject2);
            }
          }
          label225:
          int j = 0;
          localObject1 = localObject4;
          localObject4 = localObject2;
          localObject2 = localObject3;
          while (j < paramInt)
          {
            if (locale3.i()) {
              return locald.u();
            }
            locale2 = P(((e)localObject1).o());
            locale1 = R(locale3);
            localObject3 = locale1.j(locale3);
            e locale4 = R(((e)localObject1).j((e)localObject3));
            e locale5 = R(((e)localObject3).o());
            localObject3 = localObject4;
            locale3 = locale2;
            if (!((e)localObject4).i())
            {
              locale3 = locale2.a((e)localObject4);
              localObject3 = R(locale5.j((e)localObject4));
            }
            localObject1 = locale3.o().r(R(locale4));
            locale3 = locale3.j(locale4.r((e)localObject1)).r(locale5);
            if (((e)localObject2).h()) {
              localObject2 = locale1;
            } else {
              localObject2 = locale1.j((e)localObject2);
            }
            j++;
            localObject4 = localObject3;
          }
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i == 4)
                {
                  bool = this.f;
                  return new e(locald, (e)localObject1, locale3, new e[] { localObject2, localObject4 }, bool);
                }
                throw new IllegalStateException("unsupported coordinate system");
              }
              bool = this.f;
              return new e(locald, (e)localObject1, locale3, new e[] { localObject2 }, bool);
            }
            localObject3 = ((e)localObject1).j((e)localObject2);
            localObject2 = ((e)localObject2).j(((e)localObject2).o());
            boolean bool = this.f;
            return new e(locald, (e)localObject3, locale3, new e[] { localObject2 }, bool);
          }
          Object localObject3 = ((e)localObject2).g();
          localObject2 = ((e)localObject3).o();
          localObject3 = ((e)localObject2).j((e)localObject3);
          return new e(locald, ((e)localObject1).j((e)localObject2), locale3.j((e)localObject3), this.f);
        }
        return this;
      }
      throw new IllegalArgumentException("'e' cannot be negative");
    }
    
    public h J()
    {
      if (u()) {
        return this;
      }
      d locald = i();
      e locale1 = this.d;
      if (locale1.i()) {
        return locald.u();
      }
      int i = locald.r();
      e locale2 = this.c;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 4) {
              return Q(true);
            }
            throw new IllegalStateException("unsupported coordinate system");
          }
          locale3 = this.e[0];
          bool = locale3.h();
          locale4 = locale1.o();
          locale5 = locale4.o();
          localObject = locald.o();
          e locale6 = ((e)localObject).m();
          if (locale6.t().equals(BigInteger.valueOf(3L)))
          {
            if (bool) {
              localObject = locale3;
            } else {
              localObject = locale3.o();
            }
            localObject = P(locale2.a((e)localObject).j(locale2.r((e)localObject)));
            locale7 = locale4.j(locale2);
          }
          else
          {
            locale7 = P(locale2.o());
            if (bool) {}
            for (;;)
            {
              localObject = locale7.a((e)localObject);
              break label281;
              if (((e)localObject).i()) {
                break;
              }
              e locale8 = locale3.o().o();
              if (locale6.c() < ((e)localObject).c())
              {
                localObject = locale7.r(locale8.j(locale6));
                break label281;
              }
              localObject = locale8.j((e)localObject);
            }
            localObject = locale7;
            label281:
            locale7 = locale2.j(locale4);
          }
          locale7 = N(locale7);
          locale2 = ((e)localObject).o().r(R(locale7));
          locale5 = locale7.r(locale2).j((e)localObject).r(M(locale5));
          locale7 = R(locale1);
          localObject = locale7;
          if (!bool) {
            localObject = locale7.j(locale3);
          }
          bool = this.f;
          return new e(locald, locale2, locale5, new e[] { localObject }, bool);
        }
        e locale5 = this.e[0];
        boolean bool = locale5.h();
        locale7 = locald.o();
        localObject = locale7;
        if (!locale7.i())
        {
          localObject = locale7;
          if (!bool) {
            localObject = locale7.j(locale5.o());
          }
        }
        e locale3 = ((e)localObject).a(P(locale2.o()));
        if (bool) {
          localObject = locale1;
        } else {
          localObject = locale1.j(locale5);
        }
        if (bool) {
          locale7 = locale1.o();
        } else {
          locale7 = ((e)localObject).j(locale1);
        }
        locale5 = N(locale2.j(locale7));
        e locale4 = locale3.o().r(R(locale5));
        locale2 = R((e)localObject);
        locale1 = locale4.j(locale2);
        locale7 = R(locale7);
        locale3 = locale5.r(locale4).j(locale3).r(R(locale7.o()));
        if (bool) {
          locale7 = R(locale7);
        } else {
          locale7 = locale2.o();
        }
        localObject = R(locale7).j((e)localObject);
        bool = this.f;
        return new e(locald, locale1, locale3, new e[] { localObject }, bool);
      }
      Object localObject = P(locale2.o()).a(i().o()).d(R(locale1));
      e locale7 = ((e)localObject).o().r(R(locale2));
      return new e(locald, locale7, ((e)localObject).j(locale2.r(locale7)).r(locale1), this.f);
    }
    
    public h K(h paramh)
    {
      if (this == paramh) {
        return H();
      }
      if (u()) {
        return paramh;
      }
      if (paramh.u()) {
        return J();
      }
      e locale1 = this.d;
      if (locale1.i()) {
        return paramh;
      }
      d locald = i();
      int i = locald.r();
      if (i != 0)
      {
        if (i != 4) {
          return J().a(paramh);
        }
        return Q(false).a(paramh);
      }
      e locale2 = this.c;
      e locale3 = paramh.c;
      e locale4 = paramh.d;
      paramh = locale3.r(locale2);
      e locale5 = locale4.r(locale1);
      if (paramh.i())
      {
        if (locale5.i()) {
          return H();
        }
        return this;
      }
      locale4 = paramh.o();
      e locale6 = locale5.o();
      e locale7 = locale4.j(R(locale2).a(locale3)).r(locale6);
      if (locale7.i()) {
        return locald.u();
      }
      locale6 = locale7.j(paramh).g();
      locale5 = locale7.j(locale6).j(locale5);
      paramh = R(locale1).j(locale4).j(paramh).j(locale6).r(locale5);
      locale3 = paramh.r(locale5).j(locale5.a(paramh)).a(locale3);
      return new e(locald, locale3, locale2.r(locale3).j(paramh).r(locale1), this.f);
    }
    
    protected e L(e parame1, e parame2)
    {
      e locale1 = i().o();
      if ((!locale1.i()) && (!parame1.h()))
      {
        e locale2 = parame2;
        if (parame2 == null) {
          locale2 = parame1.o();
        }
        parame1 = locale2.o();
        parame2 = locale1.m();
        if (parame2.c() < locale1.c()) {
          parame1 = parame1.j(parame2).m();
        } else {
          parame1 = parame1.j(locale1);
        }
        return parame1;
      }
      return locale1;
    }
    
    protected e M(e parame)
    {
      return N(R(parame));
    }
    
    protected e N(e parame)
    {
      return R(R(parame));
    }
    
    protected e O()
    {
      e[] arrayOfe = this.e;
      e locale1 = arrayOfe[1];
      e locale2 = locale1;
      if (locale1 == null)
      {
        locale2 = L(arrayOfe[0], null);
        arrayOfe[1] = locale2;
      }
      return locale2;
    }
    
    protected e P(e parame)
    {
      return R(parame).a(parame);
    }
    
    protected e Q(boolean paramBoolean)
    {
      e locale1 = this.c;
      e locale2 = this.d;
      Object localObject = this.e[0];
      e locale3 = O();
      e locale4 = P(locale1.o()).a(locale3);
      e locale5 = R(locale2);
      locale2 = locale5.j(locale2);
      e locale6 = R(locale1.j(locale2));
      locale1 = locale4.o().r(R(locale6));
      locale2 = R(locale2.o());
      locale4 = locale4.j(locale6.r(locale1)).r(locale2);
      if (paramBoolean) {
        locale3 = R(locale2.j(locale3));
      } else {
        locale3 = null;
      }
      if (!((e)localObject).h()) {
        locale5 = locale5.j((e)localObject);
      }
      localObject = i();
      paramBoolean = this.f;
      return new e((d)localObject, locale1, locale4, new e[] { locale5, locale3 }, paramBoolean);
    }
    
    protected e R(e parame)
    {
      return parame.a(parame);
    }
    
    public h a(h paramh)
    {
      if (u()) {
        return paramh;
      }
      if (paramh.u()) {
        return this;
      }
      if (this == paramh) {
        return J();
      }
      d locald = i();
      int i = locald.r();
      Object localObject1 = this.c;
      Object localObject2 = this.d;
      Object localObject3 = paramh.c;
      e locale1 = paramh.d;
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i != 2) && (i != 4)) {
            throw new IllegalStateException("unsupported coordinate system");
          }
          localObject4 = this.e[0];
          e locale2 = paramh.e[0];
          bool1 = ((e)localObject4).h();
          if ((!bool1) && (localObject4.equals(locale2)))
          {
            paramh = ((e)localObject1).r((e)localObject3);
            locale1 = ((e)localObject2).r(locale1);
            if (paramh.i())
            {
              if (locale1.i()) {
                return J();
              }
              return locald.u();
            }
            locale3 = paramh.o();
            localObject1 = ((e)localObject1).j(locale3);
            localObject3 = ((e)localObject3).j(locale3);
            locale3 = ((e)localObject1).r((e)localObject3).j((e)localObject2);
            localObject2 = locale1.o().r((e)localObject1).r((e)localObject3);
            localObject1 = ((e)localObject1).r((e)localObject2).j(locale1).r(locale3);
            localObject4 = paramh.j((e)localObject4);
          }
          do
          {
            localObject3 = null;
            paramh = (h)localObject4;
            localObject4 = localObject3;
            break;
            if (!bool1)
            {
              paramh = ((e)localObject4).o();
              localObject3 = paramh.j((e)localObject3);
              locale1 = paramh.j((e)localObject4).j(locale1);
            }
            bool2 = locale2.h();
            if (!bool2)
            {
              paramh = locale2.o();
              localObject1 = paramh.j((e)localObject1);
              localObject2 = paramh.j(locale2).j((e)localObject2);
            }
            locale3 = ((e)localObject1).r((e)localObject3);
            locale1 = ((e)localObject2).r(locale1);
            if (locale3.i())
            {
              if (locale1.i()) {
                return J();
              }
              return locald.u();
            }
            locale4 = locale3.o();
            paramh = locale4.j(locale3);
            localObject1 = locale4.j((e)localObject1);
            localObject3 = locale1.o().a(paramh).r(R((e)localObject1));
            locale1 = ((e)localObject1).r((e)localObject3).k(locale1, paramh, (e)localObject2);
            if (!bool1) {
              paramh = locale3.j((e)localObject4);
            } else {
              paramh = locale3;
            }
            if (!bool2) {
              paramh = paramh.j(locale2);
            }
            localObject4 = paramh;
            localObject2 = localObject3;
            localObject1 = locale1;
          } while (paramh != locale3);
          localObject4 = locale4;
          localObject1 = locale1;
          localObject2 = localObject3;
          if (i == 4)
          {
            locale1 = L(paramh, (e)localObject4);
            localObject3 = new e[2];
            localObject3[0] = paramh;
            localObject3[1] = locale1;
            paramh = (h)localObject3;
          }
          else
          {
            paramh = new e[] { paramh };
          }
          return new e(locald, (e)localObject2, (e)localObject1, paramh, this.f);
        }
        Object localObject4 = this.e[0];
        paramh = paramh.e[0];
        boolean bool1 = ((e)localObject4).h();
        boolean bool2 = paramh.h();
        if (!bool1) {
          locale1 = locale1.j((e)localObject4);
        }
        if (!bool2) {
          localObject2 = ((e)localObject2).j(paramh);
        }
        locale1 = locale1.r((e)localObject2);
        if (!bool1) {
          localObject3 = ((e)localObject3).j((e)localObject4);
        }
        if (!bool2) {
          localObject1 = ((e)localObject1).j(paramh);
        }
        localObject3 = ((e)localObject3).r((e)localObject1);
        if (((e)localObject3).i())
        {
          if (locale1.i()) {
            return J();
          }
          return locald.u();
        }
        if (!bool1) {
          if (bool2) {
            paramh = (h)localObject4;
          } else {
            paramh = ((e)localObject4).j(paramh);
          }
        }
        e locale3 = ((e)localObject3).o();
        localObject4 = locale3.j((e)localObject3);
        locale3 = locale3.j((e)localObject1);
        e locale4 = locale1.o().j(paramh).r((e)localObject4).r(R(locale3));
        localObject1 = ((e)localObject3).j(locale4);
        localObject2 = locale3.r(locale4).k(locale1, (e)localObject2, (e)localObject4);
        paramh = ((e)localObject4).j(paramh);
        bool1 = this.f;
        return new e(locald, (e)localObject1, (e)localObject2, new e[] { paramh }, bool1);
      }
      paramh = ((e)localObject3).r((e)localObject1);
      locale1 = locale1.r((e)localObject2);
      if (paramh.i())
      {
        if (locale1.i()) {
          return J();
        }
        return locald.u();
      }
      paramh = locale1.d(paramh);
      localObject3 = paramh.o().r((e)localObject1).r((e)localObject3);
      return new e(locald, (e)localObject3, paramh.j(((e)localObject1).r((e)localObject3)).r((e)localObject2), this.f);
    }
    
    protected h d()
    {
      return new e(null, f(), g(), false);
    }
    
    public e s(int paramInt)
    {
      if ((paramInt == 1) && (4 == j())) {
        return O();
      }
      return super.s(paramInt);
    }
    
    public h z()
    {
      if (u()) {
        return this;
      }
      d locald = i();
      if (locald.r() != 0) {
        return new e(locald, this.c, this.d.m(), this.e, this.f);
      }
      return new e(locald, this.c, this.d.m(), this.f);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */