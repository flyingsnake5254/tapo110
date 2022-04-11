package b.d.a;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tplink.ata.params.ATAConnectParams;
import com.tplink.ata.params.ATATransferParams;
import com.tplink.ata.result.ATABaseResult;
import com.tplink.ata.result.ATATransferResult;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.passthrough.params.PassThroughParams;
import com.tplink.cloud.bean.passthrough.result.PassThroughResult;
import com.tplink.cloud.context.TCAccountBean;
import io.reactivex.u;
import io.reactivex.v;
import java.util.Iterator;
import java.util.List;
import java.util.List<[B>;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class s
{
  private static final Gson a = new Gson();
  private String b;
  private String c;
  private String d;
  private b.d.b.c.g e;
  private a f;
  private long g;
  private long h;
  private io.reactivex.m0.g<byte[]> i = io.reactivex.m0.d.n1().l1();
  private io.reactivex.e0.b j = new io.reactivex.e0.b();
  private io.reactivex.e0.b k = new io.reactivex.e0.b();
  private AtomicLong l = new AtomicLong(0L);
  private ReentrantLock m = new ReentrantLock();
  private AtomicBoolean n = new AtomicBoolean(true);
  private io.reactivex.m0.g<Boolean> o = io.reactivex.m0.d.n1().l1();
  private AtomicLong p = new AtomicLong(-1L);
  private AtomicLong q = new AtomicLong(0L);
  
  public s(@NonNull String paramString1, @NonNull String paramString2, @NonNull com.tplink.cloud.context.b paramb, @NonNull a parama)
  {
    this.b = paramString1;
    this.c = paramString2;
    paramString1 = new StringBuilder();
    paramString1.append(paramb.c().getToken());
    paramString1.append("-");
    paramString1.append(new Random().nextInt(16));
    this.d = paramString1.toString();
    this.e = paramb.d();
    this.f = parama;
    this.g = 1L;
  }
  
  private byte[] O(List<byte[]> paramList)
  {
    if (paramList.size() == 1)
    {
      paramList = (byte[])paramList.get(0);
    }
    else
    {
      Object localObject = paramList.iterator();
      int i1 = 0;
      while (((Iterator)localObject).hasNext()) {
        i1 += ((byte[])((Iterator)localObject).next()).length;
      }
      localObject = new byte[i1];
      paramList = paramList.iterator();
      i1 = 0;
      while (paramList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramList.next();
        System.arraycopy(arrayOfByte, 0, localObject, i1, arrayOfByte.length);
        i1 += arrayOfByte.length;
      }
      paramList = (List<byte[]>)localObject;
    }
    this.q.addAndGet(-paramList.length);
    return paramList;
  }
  
  private io.reactivex.q<ATABaseResult> P()
  {
    return this.e.k0(this.c, new CloudParams("passthrough", b())).i(a(ATABaseResult.class));
  }
  
  private io.reactivex.q<ATATransferResult> Q(long paramLong, byte[] paramArrayOfByte)
  {
    return this.e.k0(this.c, new CloudParams("passthrough", c(paramLong, paramArrayOfByte))).i(a(ATATransferResult.class));
  }
  
  private void R()
  {
    this.k.b(io.reactivex.q.W0(g(), TimeUnit.MILLISECONDS).L(new a(this)).N(new m(this)).l0(io.reactivex.l0.a.e()).A(new g(this)).I0(new n(this), new j(this), new c(this)));
  }
  
  private void S()
  {
    this.k.d();
    R();
  }
  
  private void T()
  {
    this.j.b(this.i.b(this.o).L(q.c).l0(io.reactivex.l0.a.c()).N(new p(this)).G0(new h(this)));
  }
  
  private void U()
  {
    this.j.b(io.reactivex.q.W0(150L, TimeUnit.MILLISECONDS).s0(new d(this)).G0(new k(this)));
  }
  
  private void W()
  {
    if (this.m.isHeldByCurrentThread()) {
      this.m.unlock();
    }
  }
  
  private <T extends ATABaseResult> u<CloudResult<PassThroughResult>, T> a(Class<T> paramClass)
  {
    return new f(this, paramClass);
  }
  
  private PassThroughParams b()
  {
    return new PassThroughParams(this.b, new ATAConnectParams(this.d));
  }
  
  private PassThroughParams c(long paramLong, byte[] paramArrayOfByte)
  {
    return new PassThroughParams(this.b, new ATATransferParams(this.d, paramLong, paramArrayOfByte));
  }
  
  private long g()
  {
    long l1 = this.l.get();
    long l2 = 15000L;
    long l3 = l2;
    if (l1 <= 0L)
    {
      l3 = l2;
      if (!this.m.isLocked())
      {
        l3 = this.h;
        if (l3 <= 1L) {
          return 500L;
        }
        if (l3 <= 3L) {
          return 1000L;
        }
        if (l3 <= 6L) {
          return l3 * 500L;
        }
        l3 = 3000L * (l3 - 5L);
        if (l3 > 15000L) {
          l3 = l2;
        }
      }
    }
    return l3;
  }
  
  private long h()
  {
    long l1 = this.g;
    this.g = (1L + l1);
    return l1;
  }
  
  private void i(Throwable paramThrowable)
  {
    e();
    this.f.b(paramThrowable);
  }
  
  public int V(byte[] paramArrayOfByte)
  {
    if (this.p.get() == -1L)
    {
      this.p.set(System.currentTimeMillis());
      U();
    }
    long l1 = this.q.get() + paramArrayOfByte.length;
    if (Math.ceil(l1 / 3.0D) * 4L > 30720L)
    {
      long l2 = paramArrayOfByte.length;
      this.q.compareAndSet(l1 - l2, 0L);
      this.p.set(System.currentTimeMillis());
      this.o.onNext(Boolean.TRUE);
    }
    else
    {
      this.q.addAndGet(paramArrayOfByte.length);
    }
    this.l.incrementAndGet();
    this.i.onNext(paramArrayOfByte);
    return paramArrayOfByte.length;
  }
  
  public void d()
  {
    this.n.compareAndSet(false, true);
  }
  
  public void e()
  {
    this.n.set(true);
    this.j.d();
    this.k.d();
    if ((!this.i.j1()) && (!this.i.k1())) {
      this.i.onComplete();
    }
    if ((!this.o.j1()) && (!this.o.k1())) {
      this.o.onComplete();
    }
  }
  
  public io.reactivex.q<ATABaseResult> f()
  {
    return P().E(new i(this));
  }
  
  public static abstract interface a
  {
    public abstract void b(Throwable paramThrowable);
    
    public abstract void f(byte[] paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */