package b.d.a0.a;

import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import java.util.concurrent.atomic.AtomicBoolean;

class b
{
  private String a;
  private long b;
  private long c;
  private d d;
  private d e;
  private AtomicBoolean f;
  private AtomicBoolean g;
  private AtomicBoolean h;
  private e i;
  private final Object j = new Object();
  private final Object k = new Object();
  private int l;
  private final int m = 2;
  private AtomicBoolean n = new AtomicBoolean(false);
  private final AtomicBoolean o = new AtomicBoolean(true);
  private e p = new a();
  private e q = new b();
  private e r = new c();
  
  b(String paramString)
  {
    this.a = paramString;
    this.f = new AtomicBoolean(false);
    this.g = new AtomicBoolean(false);
    this.h = new AtomicBoolean(false);
    this.l = 1;
  }
  
  b(String paramString, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
    this.f = new AtomicBoolean(false);
    this.g = new AtomicBoolean(false);
    this.h = new AtomicBoolean(false);
    this.l = 1;
  }
  
  private void m()
  {
    synchronized (this.j)
    {
      d locald = this.d;
      if (locald != null)
      {
        e locale = this.i;
        if (locale != null) {
          locale.q(locald);
        }
        return;
      }
      if (this.f.get()) {
        return;
      }
      this.f.set(true);
      this.l += 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("p2pRetryTime ++ ");
      ((StringBuilder)???).append(this.l);
      b.d.p.d.a("CameraVodConnection", ((StringBuilder)???).toString());
      c.b(this.a, 16, this.b, this.c, this.p);
      return;
    }
  }
  
  private void n()
  {
    synchronized (this.k)
    {
      d locald = this.e;
      if (locald != null)
      {
        e locale = this.i;
        if (locale != null) {
          locale.q(locald);
        }
        return;
      }
      if (this.g.get()) {
        return;
      }
      this.g.set(true);
      c.b(this.a, 0, this.b, this.c, this.q);
      return;
    }
  }
  
  void o()
  {
    this.h.set(false);
    Object localObject;
    if (b.d.d.d.c.h(this.a))
    {
      localObject = this.i;
      if (localObject != null) {
        ((e)localObject).j(this.a);
      }
      return;
    }
    if (b.d.d.d.c.i(this.a))
    {
      c.b(this.a, 256, this.b, this.c, this.r);
    }
    else if ((b.d.t.e.e.g(this.a)) && (b.d.t.e.e.h(this.a)))
    {
      this.o.set(false);
      c.b(this.a, 17, this.b, this.c, this.r);
    }
    else if (b.d.d.d.c.k(this.a))
    {
      if ((b.d.d.d.c.l(this.a)) && (b.d.d.a.a.m())) {
        if (this.l >= 2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("p2pRetryTime ");
          ((StringBuilder)localObject).append(this.l);
          b.d.p.d.c("CameraVodConnection", ((StringBuilder)localObject).toString());
          this.n.set(false);
        }
        else
        {
          m();
        }
      }
      if ((b.d.d.a.a.n()) && (!this.n.get())) {
        n();
      }
      if ((b.d.t.e.e.g(this.a)) && (b.d.t.e.e.i(this.a)) && (this.o.get()))
      {
        this.o.set(false);
        b.d.t.e.e.b(this.a, new a(this));
      }
    }
    else
    {
      localObject = this.i;
      if (localObject != null) {
        ((e)localObject).j(this.a);
      }
    }
  }
  
  void r()
  {
    s();
    this.l = 1;
    this.n.set(false);
  }
  
  void s()
  {
    this.h.set(true);
    t(16);
    t(0);
  }
  
  void t(int paramInt)
  {
    if (paramInt == 0) {
      synchronized (this.k)
      {
        if (this.e != null)
        {
          StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
          localStringBuilder1.<init>();
          localStringBuilder1.append("release vod video");
          localStringBuilder1.append(this.e.toString());
          b.d.p.d.c("CameraVodConnection", localStringBuilder1.toString());
          b.d.t.a.c().b(this.e.getPortId(), this.e.getDeviceModel());
        }
        this.e = null;
      }
    }
    if (paramInt == 16) {
      synchronized (this.j)
      {
        if (this.d != null)
        {
          StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
          localStringBuilder2.<init>();
          localStringBuilder2.append("release vod video");
          localStringBuilder2.append(this.d.toString());
          b.d.p.d.c("CameraVodConnection", localStringBuilder2.toString());
          b.d.t.a.c().b(this.d.getPortId(), this.d.getDeviceModel());
        }
        this.d = null;
      }
    }
  }
  
  public void u()
  {
    this.l = 1;
  }
  
  public void v(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void w(long paramLong)
  {
    this.b = paramLong;
  }
  
  void x(e parame)
  {
    this.i = parame;
  }
  
  public void y(boolean paramBoolean)
  {
    this.n.set(paramBoolean);
  }
  
  class a
    implements e
  {
    a() {}
    
    public void j(String paramString)
    {
      b.h(b.this).set(false);
      if ((!b.d(b.this).get()) && (!b.i(b.this).get()) && (b.j(b.this) == null) && (b.e(b.this) != null)) {
        b.e(b.this).j(paramString);
      }
      b.f(b.this).set(false);
    }
    
    public void l(d paramd)
    {
      b.h(b.this).set(false);
      if (b.e(b.this) != null) {
        b.e(b.this).l(paramd);
      }
      b.f(b.this).set(false);
    }
    
    public void q(d paramd)
    {
      synchronized (b.a(b.this))
      {
        if (b.b(b.this) != null) {
          b.d.t.a.c().b(b.b(b.this).getPortId(), b.b(b.this).getDeviceModel());
        }
        b.c(b.this, null);
        if (b.d(b.this).get())
        {
          b.d.t.a.c().b(paramd.getPortId(), paramd.getDeviceModel());
        }
        else
        {
          b.c(b.this, paramd);
          if (b.e(b.this) != null) {
            b.e(b.this).q(paramd);
          }
        }
        b.f(b.this).set(false);
        b.g(b.this, 1);
        return;
      }
    }
  }
  
  class b
    implements e
  {
    b() {}
    
    public void j(String paramString)
    {
      if ((!b.d(b.this).get()) && (!b.f(b.this).get()) && (b.b(b.this) == null) && (b.e(b.this) != null)) {
        b.e(b.this).j(paramString);
      }
      b.i(b.this).set(false);
    }
    
    public void l(d paramd)
    {
      if (b.e(b.this) != null) {
        b.e(b.this).l(paramd);
      }
      b.i(b.this).set(false);
    }
    
    public void q(d paramd)
    {
      synchronized (b.l(b.this))
      {
        if (b.j(b.this) != null) {
          b.d.t.a.c().b(b.j(b.this).getPortId(), b.j(b.this).getDeviceModel());
        }
        b.k(b.this, null);
        if (b.d(b.this).get())
        {
          b.d.t.a.c().b(paramd.getPortId(), paramd.getDeviceModel());
        }
        else
        {
          b.k(b.this, paramd);
          if (b.e(b.this) != null) {
            b.e(b.this).q(paramd);
          }
        }
        b.i(b.this).set(false);
        return;
      }
    }
  }
  
  class c
    implements e
  {
    c() {}
    
    public void j(String paramString)
    {
      if (b.e(b.this) != null) {
        b.e(b.this).j(paramString);
      }
    }
    
    public void l(d paramd)
    {
      if (b.e(b.this) != null) {
        b.e(b.this).l(paramd);
      }
    }
    
    public void q(d paramd)
    {
      if (b.e(b.this) != null) {
        b.e(b.this).q(paramd);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\a0\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */