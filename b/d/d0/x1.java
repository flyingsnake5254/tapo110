package b.d.d0;

import b.d.d0.f2.e;
import b.d.d0.g2.c;
import b.d.d0.i2.a;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class x1
  implements e2.c
{
  private byte a;
  private byte b;
  private e2 c;
  protected EnumTMPBusinessLayerStatus d = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_IDLE;
  protected g<Boolean> e = io.reactivex.m0.b.n1().l1();
  protected g<Boolean> f = io.reactivex.m0.b.n1().l1();
  protected b.d.d0.i2.b g = new b.d.d0.i2.b(-1);
  private final List<b> h = new ArrayList();
  
  public x1(byte paramByte1, byte paramByte2, e2 parame2)
  {
    this.a = ((byte)paramByte1);
    this.b = ((byte)paramByte2);
    this.c = parame2;
    parame2.T(this);
  }
  
  private void o()
  {
    synchronized (this.h)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        p((b)localIterator.next());
      }
      return;
    }
  }
  
  private void p(b paramb)
  {
    int i = a.a[this.d.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          paramb.d(this.g, this);
        }
      }
      else {
        paramb.g(this);
      }
    }
    else {
      paramb.f(this);
    }
  }
  
  void a()
  {
    this.c = null;
    this.e = null;
    this.f = null;
    synchronized (this.h)
    {
      this.h.clear();
      return;
    }
  }
  
  abstract q<b.d.d0.i2.b> b();
  
  public void c(b.d.d0.i2.b paramb, e2 parame2)
  {
    parame2 = this.e;
    if ((parame2 != null) && (!parame2.k1()) && (!this.e.j1())) {
      this.e.onError(new TPGeneralNetworkException(paramb.a(), paramb.b()));
    }
    this.g = paramb;
    this.d = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED;
  }
  
  public void h(e2 parame2) {}
  
  public void i(e2 parame2)
  {
    this.e.onNext(Boolean.TRUE);
  }
  
  public void j(b paramb)
  {
    synchronized (this.h)
    {
      if (!this.h.contains(paramb)) {
        this.h.add(paramb);
      }
      p(paramb);
      return;
    }
  }
  
  protected void k()
  {
    int i = this.d.getValue();
    EnumTMPBusinessLayerStatus localEnumTMPBusinessLayerStatus = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_CONNECTED;
    if (i >= localEnumTMPBusinessLayerStatus.getValue()) {
      return;
    }
    this.d = localEnumTMPBusinessLayerStatus;
    o();
    this.f.onNext(Boolean.TRUE);
  }
  
  protected void l()
  {
    int i = this.d.getValue();
    EnumTMPBusinessLayerStatus localEnumTMPBusinessLayerStatus = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_CONNECTING;
    if (i >= localEnumTMPBusinessLayerStatus.getValue()) {
      return;
    }
    this.d = localEnumTMPBusinessLayerStatus;
    o();
  }
  
  protected void m(b.d.d0.i2.b paramb)
  {
    int i = this.d.getValue();
    Object localObject = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED;
    if (i >= ((EnumTMPBusinessLayerStatus)localObject).getValue()) {
      return;
    }
    this.d = ((EnumTMPBusinessLayerStatus)localObject);
    this.g = paramb;
    o();
    localObject = this.f;
    if ((localObject != null) && (!((g)localObject).k1()) && (!this.f.j1())) {
      this.f.onError(new TPGeneralNetworkException(paramb.a(), paramb.b()));
    }
  }
  
  abstract q<e> n(b.d.d0.f2.d paramd);
  
  public q<a<b.d.d0.g2.d>> q(b.d.d0.g2.d paramd)
  {
    if (this.d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
      return q.f0(new a(this.g.a(), this.g.b()));
    }
    if (this.c == null) {
      return q.f0(new a(64525));
    }
    if (paramd.a() == null) {
      paramd.d(new c(this.a, this.b));
    }
    return this.e.Q0(1L).N(new k(this, paramd)).g0(new j(this));
  }
  
  public static abstract interface b
  {
    public abstract void d(b.d.d0.i2.b paramb, x1 paramx1);
    
    public abstract void f(x1 paramx1);
    
    public abstract void g(x1 paramx1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\x1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */