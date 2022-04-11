package b.d.o.a;

import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
{
  private String a;
  private boolean b;
  private List<d> c;
  private List<d> d;
  private boolean e = false;
  private AtomicBoolean f;
  private AtomicBoolean g;
  private e h;
  private e i;
  private boolean j;
  private final Object k = new Object();
  private final Object l = new Object();
  private BitStreamType m;
  private int n;
  private final int o = 2;
  private AtomicBoolean p = new AtomicBoolean(false);
  private final AtomicBoolean q = new AtomicBoolean(true);
  private e r = new a();
  private e s = new b();
  private e t = new c();
  
  public b(String paramString)
  {
    this.a = paramString;
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.f = new AtomicBoolean(false);
    this.g = new AtomicBoolean(false);
    this.n = 1;
  }
  
  private void p()
  {
    if (this.g.get()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.k)
    {
      if (this.c.size() > 0)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
          if ((d)localIterator.next() == null)
          {
            i1 = 0;
            break label78;
          }
        }
        int i1 = 1;
        label78:
        if (i1 != 0)
        {
          if (this.j)
          {
            localIterator = this.c.iterator();
            while (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (locald.b()) {
                localArrayList.add(locald.a());
              }
            }
          }
          return;
        }
      }
      if (localArrayList.size() > 0)
      {
        ??? = this.i;
        if (??? != null) {
          ((e)???).k(localArrayList);
        }
        return;
      }
      this.g.set(true);
      this.n += 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("p2pRetryTime ++ ");
      ((StringBuilder)???).append(this.n);
      b.d.p.d.a("CameraLiveConnection", ((StringBuilder)???).toString());
      c.a(this.a, 16, this.r, this.m);
      return;
    }
  }
  
  private void r()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.l)
    {
      if (this.d.size() > 0)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
          if ((d)localIterator.next() == null)
          {
            i1 = 0;
            break label67;
          }
        }
        int i1 = 1;
        label67:
        if (i1 != 0)
        {
          if (this.j)
          {
            localIterator = this.d.iterator();
            while (localIterator.hasNext()) {
              localArrayList.add(((d)localIterator.next()).a());
            }
          }
          return;
        }
      }
      if (localArrayList.size() > 0)
      {
        ??? = this.i;
        if (??? != null) {
          ((e)???).k(localArrayList);
        }
        return;
      }
      if (this.f.get()) {
        return;
      }
      this.f.set(true);
      c.a(this.a, 0, this.s, this.m);
      return;
    }
  }
  
  public void A()
  {
    this.n = 1;
    this.p.set(false);
  }
  
  void B(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void C(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  void D(e parame)
  {
    this.i = parame;
  }
  
  void E(e parame)
  {
    this.h = parame;
  }
  
  public void F(BitStreamType paramBitStreamType)
  {
    this.m = paramBitStreamType;
  }
  
  public void G(boolean paramBoolean)
  {
    this.p.set(paramBoolean);
  }
  
  void o()
  {
    C(true);
    B(false);
    Object localObject;
    if (b.d.d.d.c.h(this.a))
    {
      localObject = this.i;
      if (localObject != null) {
        ((e)localObject).f(this.a);
      }
      return;
    }
    if (b.d.d.d.c.i(this.a))
    {
      c.a(this.a, 256, this.t, this.m);
    }
    else if ((b.d.t.e.e.g(this.a)) && (b.d.t.e.e.h(this.a)))
    {
      this.q.set(false);
      c.a(this.a, 17, this.t, this.m);
    }
    else if (b.d.d.d.c.k(this.a))
    {
      if ((b.d.d.d.c.l(this.a)) && (b.d.d.a.a.j())) {
        if (this.n > 2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("p2pRetryTime ");
          ((StringBuilder)localObject).append(this.n);
          b.d.p.d.c("CameraLiveConnection", ((StringBuilder)localObject).toString());
          this.e = true;
          this.p.set(false);
        }
        else
        {
          p();
        }
      }
      if ((b.d.d.a.a.k()) && (!this.p.get())) {
        r();
      }
      if ((b.d.t.e.e.g(this.a)) && (b.d.t.e.e.i(this.a)) && (this.q.get()))
      {
        this.q.set(false);
        b.d.t.e.e.b(this.a, new a(this));
      }
    }
    else
    {
      localObject = this.i;
      if (localObject != null) {
        ((e)localObject).f(this.a);
      }
    }
  }
  
  void q()
  {
    if ((b.d.d.a.a.l()) && (!this.e) && (!this.j)) {
      if (this.n > 2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("p2pRetryTime ");
        localStringBuilder.append(this.n);
        b.d.p.d.c("CameraLiveConnection", localStringBuilder.toString());
        this.e = true;
        this.p.set(false);
      }
      else
      {
        p();
      }
    }
  }
  
  void s()
  {
    C(false);
    B(true);
    t(16);
    t(0);
  }
  
  void t(int paramInt)
  {
    Object localObject2;
    Object localObject3;
    if (paramInt == 0)
    {
      this.f.set(false);
      B(true);
      synchronized (this.l)
      {
        if (this.d.size() > 0)
        {
          localObject2 = this.d.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (d)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localStringBuilder.append(this.a);
              localStringBuilder.append(" connection destroy");
              localStringBuilder.append(((d)localObject3).toString());
              b.d.p.d.c("CameraLiveConnection", localStringBuilder.toString());
              b.d.t.a.c().b(((BaseConnection)localObject3).getPortId(), ((BaseConnection)localObject3).getDeviceModel());
            }
          }
          this.d.clear();
        }
      }
    }
    if (16 == paramInt)
    {
      this.g.set(false);
      synchronized (this.k)
      {
        if (this.c.size() > 0)
        {
          Iterator localIterator = this.c.iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (d)localIterator.next();
            if (localObject2 != null)
            {
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>();
              ((StringBuilder)localObject3).append(this.a);
              ((StringBuilder)localObject3).append(" connection destroy");
              ((StringBuilder)localObject3).append(((d)localObject2).toString());
              b.d.p.d.c("CameraLiveConnection", ((StringBuilder)localObject3).toString());
              b.d.t.a.c().b(((BaseConnection)localObject2).getPortId(), ((BaseConnection)localObject2).getDeviceModel());
            }
          }
          this.c.clear();
        }
      }
    }
  }
  
  void u()
  {
    if (!this.j) {
      synchronized (this.k)
      {
        if (this.c.size() > 0)
        {
          Iterator localIterator = this.c.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if (locald != null)
            {
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localStringBuilder.append(this.a);
              localStringBuilder.append(" connection destroy");
              localStringBuilder.append(locald.toString());
              b.d.p.d.c("CameraLiveConnection", localStringBuilder.toString());
              b.d.t.a.c().b(locald.getPortId(), locald.getDeviceModel());
            }
          }
          this.c.clear();
        }
      }
    }
  }
  
  String v()
  {
    return this.a;
  }
  
  boolean w()
  {
    synchronized (this.k)
    {
      int i1 = this.c.size();
      boolean bool1 = false;
      boolean bool2;
      if (i1 > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool2)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          bool3 = bool1;
          if (locald == null) {
            break label96;
          }
          if (!locald.b())
          {
            bool3 = bool1;
            break label96;
          }
        }
      }
      boolean bool3 = bool2;
      label96:
      return bool3;
    }
  }
  
  public void z()
  {
    this.e = false;
  }
  
  class a
    implements e
  {
    a() {}
    
    public void d(List<d> paramList)
    {
      b.i(b.this, true);
      b.n(b.this).set(false);
      if ((b.k(b.this)) && (!b.c(b.this)))
      {
        if (b.l(b.this) != null) {
          b.l(b.this).d(paramList);
        }
      }
      else if (b.m(b.this) != null) {
        b.m(b.this).d(paramList);
      }
    }
    
    public void f(String paramString)
    {
      b.h(b.this).set(false);
      b.i(b.this, true);
      b.n(b.this).set(false);
      if ((b.k(b.this)) && (!b.d(b.this).get()) && (b.e(b.this).size() <= 0) && (b.l(b.this) != null)) {
        b.l(b.this).f(paramString);
      }
    }
    
    public void k(List<d> paramList)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(b.a(b.this));
      ((StringBuilder)???).append(" onLiveConnectionSuccess");
      b.d.p.d.c("CameraLiveConnection", ((StringBuilder)???).toString());
      b.this.t(16);
      synchronized (b.b(b.this))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          b.g(b.this).add(locald.a());
        }
        b.h(b.this).set(false);
        b.i(b.this, false);
        b.j(b.this, 1);
        if (b.k(b.this))
        {
          if (b.l(b.this) != null) {
            b.l(b.this).k(paramList);
          }
        }
        else if (b.m(b.this) != null) {
          b.m(b.this).k(paramList);
        }
        return;
      }
    }
  }
  
  class b
    implements e
  {
    b() {}
    
    public void d(List<d> paramList)
    {
      if ((b.k(b.this)) && (!b.c(b.this)) && (b.l(b.this) != null)) {
        b.l(b.this).d(paramList);
      }
    }
    
    public void f(String paramString)
    {
      b.d(b.this).set(false);
      if ((b.k(b.this)) && (!b.c(b.this)) && (!b.h(b.this).get()) && (b.g(b.this).size() <= 0) && (b.l(b.this) != null)) {
        b.l(b.this).f(paramString);
      }
    }
    
    public void k(List<d> paramList)
    {
      b.d(b.this).set(false);
      d locald;
      if ((!b.c(b.this)) && (b.k(b.this)))
      {
        b.this.t(0);
        synchronized (b.f(b.this))
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            locald = (d)localIterator.next();
            b.e(b.this).add(locald.a());
          }
          if (b.l(b.this) == null) {
            return;
          }
          b.l(b.this).k(paramList);
        }
      }
      ??? = paramList.iterator();
      while (((Iterator)???).hasNext())
      {
        locald = (d)((Iterator)???).next();
        paramList = new StringBuilder();
        paramList.append(b.a(b.this));
        paramList.append(" connection destroy");
        paramList.append(locald.toString());
        b.d.p.d.c("CameraLiveConnection", paramList.toString());
        b.d.t.a.c().b(locald.getPortId(), locald.getDeviceModel());
      }
    }
  }
  
  class c
    implements e
  {
    c() {}
    
    public void d(List<d> paramList)
    {
      if ((b.k(b.this)) && (!b.c(b.this)) && (b.l(b.this) != null)) {
        b.l(b.this).d(paramList);
      }
    }
    
    public void f(String paramString)
    {
      if ((b.k(b.this)) && (!b.c(b.this)) && (b.l(b.this) != null)) {
        b.l(b.this).f(paramString);
      }
    }
    
    public void k(List<d> paramList)
    {
      if ((b.k(b.this)) && (!b.c(b.this)) && (b.l(b.this) != null)) {
        b.l(b.this).k(paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\o\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */