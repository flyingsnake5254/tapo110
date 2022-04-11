package b.d.d0;

import b.d.d0.f2.e;
import com.tplink.tmp.enumerate.EnumTMPClientStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class c2
  implements y1.b, e2.c, x1.b
{
  private EnumTMPClientStatus a = EnumTMPClientStatus.TMPCLIENT_STATUS_IDLE;
  private d2 b;
  private x1 c;
  private y1 d;
  private b.d.d0.h2.a.c e;
  private e2 f;
  private g<Boolean> g = io.reactivex.m0.b.n1().l1();
  private b.d.d0.i2.b h = new b.d.d0.i2.b(-1);
  private final AtomicInteger i = new AtomicInteger(0);
  private io.reactivex.e0.b j = new io.reactivex.e0.b();
  
  public c2(b.d.d0.h2.a.c paramc)
  {
    this.e = paramc;
    int k = a.a[paramc.e().ordinal()];
    Object localObject;
    if (k != 1)
    {
      if (k != 2)
      {
        localObject = new b.d.d0.h2.b.c((b.d.d0.h2.a.d)paramc);
        ((b.d.d0.h2.b.d)localObject).b(paramc.b());
        this.d = new w1(paramc.e(), (b.d.d0.h2.b.c)localObject);
      }
      else
      {
        localObject = (b.d.d0.h2.a.b)paramc;
        localObject = new b.d.d0.h2.b.b(((b.d.d0.h2.a.b)localObject).l(), ((b.d.d0.h2.a.b)localObject).o(), ((b.d.d0.h2.a.b)localObject).n(), ((b.d.d0.h2.a.b)localObject).p(), ((b.d.d0.h2.a.b)localObject).m());
        ((b.d.d0.h2.b.d)localObject).b(paramc.b());
        this.d = new v1(paramc.e(), (b.d.d0.h2.b.b)localObject);
      }
    }
    else
    {
      localObject = (b.d.d0.h2.a.a)paramc;
      localObject = new b.d.d0.h2.b.a(((b.d.d0.h2.a.a)localObject).m(), ((b.d.d0.h2.a.a)localObject).n(), ((b.d.d0.h2.a.a)localObject).l());
      ((b.d.d0.h2.b.d)localObject).b(paramc.b());
      this.d = new u1((b.d.d0.h2.b.a)localObject);
    }
    this.f = new e2(paramc.c(), paramc.d(), this.d);
    k = paramc.a();
    if (k != 1)
    {
      if (k != 2)
      {
        if (k == 3) {
          this.c = new b2(this.f);
        } else {
          throw new UnsupportedOperationException(String.format("Business Version %d is not supported yet.", new Object[] { Byte.valueOf(paramc.a()) }));
        }
      }
      else {
        this.c = new a2(this.f);
      }
    }
    else {
      this.c = new z1(this.f);
    }
    this.d.n(this);
    this.f.T(this);
    this.c.j(this);
  }
  
  private q<Boolean> S(byte paramByte)
  {
    if ((this.a != EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED) && (this.g != null))
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        if (((e2)localObject).p() == 0) {
          localObject = T(paramByte);
        } else {
          localObject = U(paramByte);
        }
        return (q<Boolean>)localObject;
      }
    }
    return q.f0(Boolean.FALSE);
  }
  
  private q<Boolean> T(byte paramByte)
  {
    return this.g.Q0(1L).N(new v0(this, paramByte)).g0(s0.c).q0(Boolean.FALSE);
  }
  
  private q<Boolean> U(byte paramByte)
  {
    return this.g.Q0(1L).N(new u0(this, paramByte)).g0(k0.c).q0(Boolean.FALSE);
  }
  
  private void W()
  {
    if (this.b != null)
    {
      int k = a.b[this.a.ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k == 3) {
            this.b.a(this.h, this);
          }
        }
        else {
          this.b.b(this);
        }
      }
      else {
        this.b.c(this);
      }
    }
  }
  
  private void m()
  {
    if (this.i.decrementAndGet() <= 0)
    {
      y1 localy1 = this.d;
      if ((localy1 instanceof u1)) {
        ((u1)localy1).z();
      }
      localy1 = this.d;
      if ((localy1 != null) && (localy1.i() >= 0)) {
        this.j.b(q.W0(this.d.i(), TimeUnit.MILLISECONDS).G0(new x0(this)));
      }
    }
  }
  
  private void p()
  {
    this.i.incrementAndGet();
    if (this.j.f() > 0) {
      this.j.d();
    }
  }
  
  protected void P()
  {
    int k = this.a.getValue();
    EnumTMPClientStatus localEnumTMPClientStatus = EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTED;
    if (k >= localEnumTMPClientStatus.getValue()) {
      return;
    }
    this.a = localEnumTMPClientStatus;
    W();
    this.g.onNext(Boolean.TRUE);
  }
  
  protected void Q()
  {
    int k = this.a.getValue();
    EnumTMPClientStatus localEnumTMPClientStatus = EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTING;
    if (k >= localEnumTMPClientStatus.getValue()) {
      return;
    }
    this.a = localEnumTMPClientStatus;
    W();
  }
  
  protected void R(b.d.d0.i2.b paramb)
  {
    int k = this.a.getValue();
    Object localObject = EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED;
    if (k >= ((EnumTMPClientStatus)localObject).getValue()) {
      return;
    }
    this.a = ((EnumTMPClientStatus)localObject);
    this.h = paramb;
    W();
    localObject = this.g;
    if ((localObject != null) && (!((g)localObject).k1()) && (!this.g.j1())) {
      this.g.onError(new TPGeneralNetworkException(paramb.a(), paramb.b()));
    }
    j();
  }
  
  public q<e> V(b.d.d0.f2.d paramd)
  {
    if (this.a == EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED) {
      return q.f0(new e(this.h.a(), this.h.b()));
    }
    if (this.c == null) {
      return q.f0(new e(64527));
    }
    return this.g.Q0(1L).N(new q0(this, paramd)).y(new o0(this)).F(new p0(this));
  }
  
  public void X(d2 paramd2)
  {
    this.b = paramd2;
  }
  
  public void a(y1 paramy1) {}
  
  public void b(b.d.d0.i2.b paramb, y1 paramy1)
  {
    R(paramb);
  }
  
  public void c(b.d.d0.i2.b paramb, e2 parame2)
  {
    R(paramb);
  }
  
  public void d(b.d.d0.i2.b paramb, x1 paramx1)
  {
    R(paramb);
  }
  
  public void e(y1 paramy1) {}
  
  public void f(x1 paramx1) {}
  
  public void g(x1 paramx1) {}
  
  public void h(e2 parame2) {}
  
  public void i(e2 parame2) {}
  
  public void j()
  {
    this.b = null;
    this.g = null;
    Object localObject = this.d;
    if (localObject != null)
    {
      ((y1)localObject).g();
      this.d = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((e2)localObject).m();
      this.f = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((x1)localObject).a();
      this.c = null;
    }
  }
  
  public void k()
  {
    g localg = this.g;
    if ((localg != null) && (!localg.k1()) && (!this.g.j1())) {
      this.g.onError(new TPGeneralNetworkException(64523));
    }
    R(new b.d.d0.i2.b(64523));
    j();
  }
  
  public q<b.d.d0.i2.b> l()
  {
    if (EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED != this.a)
    {
      Object localObject = this.e;
      if (localObject == null)
      {
        localObject = new b.d.d0.i2.b(64536);
        R((b.d.d0.i2.b)localObject);
        return q.f0(localObject);
      }
      if (((b.d.d0.h2.a.c)localObject).e() == null)
      {
        localObject = new b.d.d0.i2.b(64529);
        R((b.d.d0.i2.b)localObject);
        return q.f0(localObject);
      }
      localObject = this.e.f();
      if (((b.d.d0.i2.b)localObject).a() != 0)
      {
        R((b.d.d0.i2.b)localObject);
        return q.f0(localObject);
      }
      return this.d.h().N(new l0(this)).N(new r0(this)).E(new m0(this)).C(new t0(this)).F(new w0(this));
    }
    throw new RuntimeException("TMPClient can't be recycled!");
  }
  
  public EnumTMPClientStatus n()
  {
    return this.a;
  }
  
  public q<Boolean> o()
  {
    return S((byte)4).y(new o0(this)).F(new n0(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\c2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */