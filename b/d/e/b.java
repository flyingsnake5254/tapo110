package b.d.e;

import androidx.annotation.NonNull;
import b.d.p.d;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class b
  implements a
{
  private boolean a;
  private boolean b;
  private b.d.g.b c;
  private int d;
  private boolean e;
  protected AtomicLong f;
  private ExecutorService g;
  private final long h = 1000L;
  private boolean i;
  
  public b(int paramInt)
  {
    q(paramInt);
  }
  
  private void q(int paramInt)
  {
    this.a = true;
    this.b = false;
    this.e = false;
    this.i = false;
    this.f = new AtomicLong(0L);
    int j = paramInt;
    if (paramInt <= 0) {
      j = 3;
    }
    this.d = j;
    this.g = Executors.newSingleThreadExecutor(new a());
  }
  
  public void a(StreamMediaData paramStreamMediaData)
  {
    this.g.submit(new b(paramStreamMediaData));
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void c()
  {
    b.d.g.b localb = this.c;
    if (localb != null) {
      localb.c();
    }
  }
  
  public void d(float paramFloat)
  {
    b.d.g.b localb = this.c;
    if (localb != null) {
      localb.i(paramFloat);
    }
  }
  
  public void destroy()
  {
    this.a = false;
    b.d.g.b localb = this.c;
    if (localb != null) {
      localb.a();
    }
  }
  
  public void e(long paramLong)
  {
    this.f.set(paramLong);
  }
  
  public float f()
  {
    b.d.g.b localb = this.c;
    if (localb != null) {
      return localb.b();
    }
    return 1.0F;
  }
  
  public void g()
  {
    b.d.g.b localb = this.c;
    if (localb != null) {
      localb.f();
    }
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pool-AudioSoftwareDecoder-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
  
  private class b
    implements Runnable
  {
    StreamMediaData c;
    
    public b(StreamMediaData paramStreamMediaData)
    {
      this.c = paramStreamMediaData;
    }
    
    public void run()
    {
      if (!b.h(b.this)) {
        return;
      }
      if (b.i(b.this)) {
        return;
      }
      Object localObject = this.c;
      if (localObject == null) {
        return;
      }
      localObject = ((StreamMediaData)localObject).rawData;
      if ((localObject != null) && (localObject.length != 0))
      {
        if (!b.j(b.this)) {
          try
          {
            b localb = b.this;
            b.d.g.b localb1 = new b/d/g/b;
            localb1.<init>(11, 4, b.n(b.this));
            b.m(localb, localb1);
            b.l(b.this).h();
            b.k(b.this, true);
          }
          catch (Exception localException)
          {
            b.k(b.this, false);
          }
        }
        if (!b.j(b.this)) {
          return;
        }
        long l = this.c.playTimeMs;
        if ((!b.o(b.this)) && (b.this.f.get() > 0L) && (b.this.f.get() - l > 1000L))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("video ");
          ((StringBuilder)localObject).append(b.this.f.get());
          ((StringBuilder)localObject).append(" audio ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(" mut ");
          ((StringBuilder)localObject).append(b.this.f.get() - l);
          d.a("AudioDecoderImpl", ((StringBuilder)localObject).toString());
          b.p(b.this, true);
          return;
        }
        b.p(b.this, false);
        b.l(b.this).d(new com.tplink.libmediakit.media.audioprocess.a(this.c.deviceIdMD5, System.currentTimeMillis(), (byte[])localObject));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */