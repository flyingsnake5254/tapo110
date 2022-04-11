package b.d.d0;

import androidx.annotation.NonNull;
import b.d.d0.g2.e;
import b.d.d0.g2.f;
import b.d.d0.i2.a;
import com.tplink.tmp.enumerate.EnumTMPLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.CRC32;

public class e2
  implements y1.b
{
  private byte a;
  private byte b;
  private y1 c;
  private int d = 1;
  private EnumTMPLayerStatus e = EnumTMPLayerStatus.TMP_LAYER_STATUS_IDLE;
  private io.reactivex.m0.g<b.d.d0.g2.g> f = io.reactivex.m0.b.n1().l1();
  private ExecutorService g = Executors.newSingleThreadExecutor();
  private ExecutorService h = Executors.newFixedThreadPool(4);
  private io.reactivex.m0.g<Boolean> i = io.reactivex.m0.b.n1().l1();
  private io.reactivex.m0.g<Boolean> j = io.reactivex.m0.b.n1().l1();
  private final List<c> k = new ArrayList();
  private b.d.d0.i2.b l = new b.d.d0.i2.b(-1);
  
  e2(byte paramByte1, byte paramByte2, @NonNull y1 paramy1)
  {
    this.a = ((byte)paramByte1);
    this.b = ((byte)paramByte2);
    this.c = paramy1;
    paramy1.n(this);
  }
  
  private void W()
  {
    synchronized (this.k)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext()) {
        X((c)localIterator.next());
      }
      return;
    }
  }
  
  private void X(c paramc)
  {
    int m = b.a[this.e.ordinal()];
    if (m != 1)
    {
      if (m != 2)
      {
        if (m == 3) {
          paramc.c(this.l, this);
        }
      }
      else {
        paramc.i(this);
      }
    }
    else {
      paramc.h(this);
    }
  }
  
  private q<b.d.d0.g2.g> Y()
    throws TPGeneralNetworkException
  {
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = (byte[])((y1)localObject1).q(2).c();
      if (this.a == localObject1[0])
      {
        if (this.b == localObject1[1])
        {
          localObject1 = (byte[])this.c.q(2).c();
          if (6 != localObject1[0])
          {
            if ((5 != localObject1[0]) && (4 != localObject1[0]))
            {
              localObject1 = new b.d.d0.g2.g(new e(this.a, this.b, localObject1[0], localObject1[1]));
            }
            else
            {
              localObject2 = (byte[])this.c.q(12).c();
              localObject2 = new f(this.a, this.b, localObject1[0], localObject1[1], (byte[])localObject2);
              localObject1 = null;
              if (((f)localObject2).e() > 0) {
                localObject1 = (byte[])this.c.q(((f)localObject2).e()).c();
              }
              localObject1 = new b.d.d0.g2.g((e)localObject2, (byte[])localObject1);
              int m = ((f)localObject2).c();
              ((f)localObject2).g(1516993677);
              byte[] arrayOfByte = ((b.d.d0.g2.g)localObject1).d();
              CRC32 localCRC32 = new CRC32();
              localCRC32.update(arrayOfByte);
              if (m != (int)localCRC32.getValue()) {
                break label242;
              }
              ((f)localObject2).g(m);
            }
            return q.f0(localObject1);
            label242:
            localObject1 = new TPGeneralNetworkException(64325);
            V(new b.d.d0.i2.b(((TPGeneralNetworkException)localObject1).getErrCode(), ((TPGeneralNetworkException)localObject1).getErrMsg()));
            throw ((Throwable)localObject1);
          }
          Object localObject2 = (byte[])this.c.q(12).c();
          localObject1 = b.d.d0.f2.b.b(new f(this.a, this.b, localObject1[0], localObject1[1], (byte[])localObject2).d());
          V(new b.d.d0.i2.b(((TPGeneralNetworkException)localObject1).getErrCode(), ((TPGeneralNetworkException)localObject1).getErrMsg()));
          throw ((Throwable)localObject1);
        }
        V(new b.d.d0.i2.b(64333));
        throw new TPGeneralNetworkException(64335);
      }
      V(new b.d.d0.i2.b(64334));
      throw new TPGeneralNetworkException(64335);
    }
    throw new TPGeneralNetworkException(64335);
  }
  
  private q<b.d.d0.g2.g> Z()
    throws TPGeneralNetworkException
  {
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = (byte[])((y1)localObject1).q(2).c();
      if (this.a == localObject1[0])
      {
        if (this.b == localObject1[1])
        {
          localObject1 = (byte[])this.c.q(2).c();
          if (6 != localObject1[0])
          {
            Object localObject2 = new e(this.a, this.b, localObject1[0], localObject1[1]);
            if (5 != localObject1[0])
            {
              localObject1 = new b.d.d0.g2.g((e)localObject2);
            }
            else
            {
              localObject2 = (byte[])this.c.q(12).c();
              localObject2 = new f(this.a, this.b, localObject1[0], localObject1[1], (byte[])localObject2);
              localObject1 = null;
              if (((f)localObject2).e() > 0) {
                localObject1 = (byte[])this.c.q(((f)localObject2).e()).c();
              }
              localObject1 = new b.d.d0.g2.g((e)localObject2, (byte[])localObject1);
              int m = ((f)localObject2).c();
              ((f)localObject2).g(1516993677);
              byte[] arrayOfByte = ((b.d.d0.g2.g)localObject1).d();
              CRC32 localCRC32 = new CRC32();
              localCRC32.update(arrayOfByte);
              if (m != (int)localCRC32.getValue()) {
                break label234;
              }
              ((f)localObject2).g(m);
            }
            return q.f0(localObject1);
            label234:
            localObject1 = new TPGeneralNetworkException(64325);
            V(new b.d.d0.i2.b(((TPGeneralNetworkException)localObject1).getErrCode(), ((TPGeneralNetworkException)localObject1).getErrMsg()));
            throw ((Throwable)localObject1);
          }
          localObject1 = b.d.d0.f2.b.c(localObject1[1]);
          V(new b.d.d0.i2.b(((TPGeneralNetworkException)localObject1).getErrCode(), ((TPGeneralNetworkException)localObject1).getErrMsg()));
          throw ((Throwable)localObject1);
        }
        V(new b.d.d0.i2.b(64333));
        throw new TPGeneralNetworkException(64335);
      }
      V(new b.d.d0.i2.b(64334));
      throw new TPGeneralNetworkException(64335);
    }
    throw new TPGeneralNetworkException(64335);
  }
  
  private void a0(b.d.d0.g2.g paramg)
  {
    io.reactivex.m0.g localg = this.f;
    if ((localg != null) && (!localg.j1()) && (!this.f.k1())) {
      this.f.onNext(paramg);
    }
  }
  
  private void b0(Throwable paramThrowable)
  {
    io.reactivex.m0.g localg = this.f;
    if ((localg != null) && (!localg.j1()) && (!this.f.k1())) {
      this.f.onError(paramThrowable);
    }
  }
  
  private q<b.d.d0.i2.b> f0()
  {
    return g0(new b.d.d0.g2.g(new e(this.a, this.b, (byte)2, (byte)0)));
  }
  
  private q<b.d.d0.i2.b> g0(b.d.d0.g2.g paramg)
  {
    return this.i.Q0(1L).N(new o1(this, paramg));
  }
  
  private q<b.d.d0.i2.b> h0()
  {
    return g0(new b.d.d0.g2.g(new e(this.a, this.b, (byte)1, (byte)0))).N(new c1(this)).L(s1.c).Q0(1L).N(new q1(this)).E(new d1(this)).p0(j1.c);
  }
  
  private void i0()
  {
    ExecutorService localExecutorService = this.h;
    if (localExecutorService != null)
    {
      localExecutorService.shutdown();
      this.h = null;
    }
  }
  
  private void j0()
  {
    ExecutorService localExecutorService = this.g;
    if (localExecutorService != null)
    {
      localExecutorService.shutdown();
      this.g = null;
    }
  }
  
  private void k0()
  {
    this.g.execute(new a());
  }
  
  private int q()
  {
    try
    {
      int m = this.d;
      this.d = (m + 1);
      return m;
    }
    finally {}
  }
  
  public void T(c paramc)
  {
    synchronized (this.k)
    {
      if (!this.k.contains(paramc)) {
        this.k.add(paramc);
      }
      X(paramc);
      return;
    }
  }
  
  protected void U()
  {
    int m = this.e.getValue();
    EnumTMPLayerStatus localEnumTMPLayerStatus = EnumTMPLayerStatus.TMP_LAYER_STATUS_CONNECTED;
    if (m > localEnumTMPLayerStatus.getValue()) {
      return;
    }
    this.e = localEnumTMPLayerStatus;
    W();
    this.j.onNext(Boolean.TRUE);
  }
  
  protected void V(b.d.d0.i2.b paramb)
  {
    int m = this.e.getValue();
    Object localObject = EnumTMPLayerStatus.TMP_LAYER_STATUS_DISCONNECTED;
    if (m > ((EnumTMPLayerStatus)localObject).getValue()) {
      return;
    }
    this.e = ((EnumTMPLayerStatus)localObject);
    this.l = paramb;
    W();
    localObject = this.j;
    if ((localObject != null) && (!((io.reactivex.m0.g)localObject).k1()) && (!this.j.j1())) {
      this.j.onError(new TPGeneralNetworkException(paramb.a(), paramb.b()));
    }
  }
  
  public void a(y1 paramy1) {}
  
  public void b(b.d.d0.i2.b paramb, y1 paramy1)
  {
    TPGeneralNetworkException localTPGeneralNetworkException = new TPGeneralNetworkException(paramb.a(), paramb.b());
    paramy1 = this.i;
    if ((paramy1 != null) && (!paramy1.j1()) && (!this.i.k1())) {
      this.i.onError(localTPGeneralNetworkException);
    }
    b0(localTPGeneralNetworkException);
    this.l = paramb;
    this.e = EnumTMPLayerStatus.TMP_LAYER_STATUS_DISCONNECTED;
  }
  
  q<a<b.d.d0.g2.g>> c0(b.d.d0.g2.g paramg, byte paramByte)
  {
    if (this.e == EnumTMPLayerStatus.TMP_LAYER_STATUS_DISCONNECTED) {
      return q.f0(new a(this.l.a(), this.l.b()));
    }
    int m = q();
    paramg.e(new f(this.a, this.b, paramByte, (byte)0, paramg.c(), (byte)0, (byte)0, m, 1516993677));
    return this.i.Q0(1L).N(new f1(this)).N(new g1(this, paramg)).N(new k1(this)).L(new h1(m)).Q0(1L).g0(e1.c).p0(n1.c);
  }
  
  q<b.d.d0.i2.b> d0(b.d.d0.g2.g paramg)
  {
    return this.i.Q0(1L).N(new r1(this)).N(new t1(this, paramg)).N(new l1(this)).L(new p1(paramg)).Q0(1L).g0(i1.c).p0(m1.c);
  }
  
  public void e(y1 paramy1)
  {
    this.i.onNext(Boolean.TRUE);
    k0();
  }
  
  q<a<b.d.d0.g2.g>> e0(b.d.d0.g2.g paramg)
  {
    return c0(paramg, (byte)5);
  }
  
  void m()
  {
    j0();
    i0();
    synchronized (this.k)
    {
      this.k.clear();
      this.c = null;
      this.j = null;
      this.i = null;
      return;
    }
  }
  
  q<b.d.d0.i2.b> n()
  {
    if (this.b == 0) {
      return h0();
    }
    U();
    return q.f0(new b.d.d0.i2.b());
  }
  
  public byte o()
  {
    return this.a;
  }
  
  public byte p()
  {
    return this.b;
  }
  
  class a
    implements Runnable
  {
    boolean c = true;
    
    a() {}
    
    public void run()
    {
      while ((this.c) && (e2.c(e2.this) != null)) {
        e2.c(e2.this).Q0(1L).N(new y0(this)).H0(new b1(this), new z0(this));
      }
      e2.d(e2.this);
      e2.f(e2.this, null);
    }
  }
  
  public static abstract interface c
  {
    public abstract void c(b.d.d0.i2.b paramb, e2 parame2);
    
    public abstract void h(e2 parame2);
    
    public abstract void i(e2 parame2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\e2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */