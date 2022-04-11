package b.d.h;

import android.os.SystemClock;
import b.d.z.b.h;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class b
{
  private long a = 0L;
  private long b = 0L;
  private long c = 0L;
  private final Object d = new Object();
  private boolean e = false;
  private int f = 1;
  private volatile boolean g = false;
  private final Object h = new Object();
  private final boolean i;
  private boolean j;
  private final LinkedBlockingQueue<YUVBuffer> k = new LinkedBlockingQueue();
  private a l;
  private h m;
  private Thread n;
  
  public b(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.j = false;
  }
  
  private void f()
  {
    this.a = 0L;
    this.c = 0L;
    this.b = 0L;
  }
  
  private void n(YUVBuffer paramYUVBuffer)
  {
    if (this.a == 0L) {
      this.a = SystemClock.elapsedRealtimeNanos();
    }
    long l1 = SystemClock.elapsedRealtimeNanos();
    if (this.c == 0L) {
      this.c = l1;
    }
    if (this.b == 0L) {
      this.b = paramYUVBuffer.presentationTimeUs;
    }
    long l2 = paramYUVBuffer.presentationTimeUs;
    long l3 = this.b;
    long l4 = SystemClock.elapsedRealtimeNanos();
    long l5 = this.a;
    l3 = (l2 - l3) * 1000L;
    l2 = l3 - (l1 - this.c);
    l1 = l2;
    if (this.i) {
      l1 = l2 - (l4 - l5);
    }
    l1 *= this.f;
    int i1;
    if (l1 > 0L)
    {
      l2 = l1 / 1000000L;
      i1 = (int)(l1 - 1000000L * l2);
    }
    try
    {
      synchronized (this.d)
      {
        this.d.wait(l2, i1);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    this.a += l3;
    this.b = paramYUVBuffer.presentationTimeUs;
    this.c = SystemClock.elapsedRealtimeNanos();
  }
  
  public void a()
  {
    if (this.m != null)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        ??? = (YUVBuffer)localIterator.next();
        this.m.d((YUVBuffer)???);
      }
    }
    this.k.clear();
    g();
    if (this.g) {
      try
      {
        synchronized (this.h)
        {
          this.h.wait(500L);
        }
        f();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void b(YUVBuffer paramYUVBuffer)
  {
    this.k.offer(paramYUVBuffer);
  }
  
  public void e()
  {
    this.e = true;
  }
  
  public void g()
  {
    this.e = false;
    synchronized (this.d)
    {
      this.d.notifyAll();
      return;
    }
  }
  
  public void h(h paramh)
  {
    this.m = paramh;
  }
  
  public void i(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void j(a parama)
  {
    this.l = parama;
  }
  
  public int k()
  {
    return this.k.size();
  }
  
  public void l()
  {
    f();
    if (this.n == null) {
      this.n = new Thread(new a(this), "renderThread");
    }
    this.j = true;
    this.n.start();
  }
  
  public void m()
  {
    this.j = false;
    g();
    if (this.m != null)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        YUVBuffer localYUVBuffer = (YUVBuffer)localIterator.next();
        this.m.d(localYUVBuffer);
      }
    }
    this.k.clear();
    this.k.offer(new YUVBuffer(-1));
    this.g = false;
  }
  
  public static abstract interface a
  {
    public abstract void j(YUVBuffer paramYUVBuffer);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */