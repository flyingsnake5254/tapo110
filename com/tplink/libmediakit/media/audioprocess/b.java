package com.tplink.libmediakit.media.audioprocess;

import com.tplink.libmediakit.media.audioprocess.processor.AEC;
import com.tplink.libmediakit.media.audioprocess.processor.AECM;
import com.tplink.libmediakit.media.audioprocess.processor.AGC;
import com.tplink.libmediakit.media.audioprocess.processor.EQ;
import com.tplink.libmediakit.media.audioprocess.processor.HS;
import com.tplink.libmediakit.media.audioprocess.processor.NS;
import com.tplink.libmediakit.media.audioprocess.processor.VAD;
import com.tplink.libmediakit.media.audioprocess.processor.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class b<T extends d>
  implements Runnable
{
  boolean H3 = false;
  private final List<f<T>> c = new LinkedList();
  private a<T> d;
  private b f;
  private final Object p0 = new Object();
  private final c p1 = new c();
  boolean p2;
  boolean p3;
  private LinkedBlockingQueue<T> q = new LinkedBlockingQueue();
  private final LinkedBlockingQueue<T> x = new LinkedBlockingQueue();
  private AtomicBoolean y = new AtomicBoolean(false);
  private Queue<T> z;
  
  private void a(f<T> paramf)
  {
    if (this.c.isEmpty())
    {
      paramf.m(this.q);
      paramf.n(this.x);
    }
    else
    {
      Object localObject = this.c;
      localObject = (f)((List)localObject).get(((List)localObject).size() - 1);
      ((f)localObject).n(new LinkedList());
      ((f)localObject).c().addAll(this.x);
      this.x.clear();
      paramf.m(((f)localObject).c());
      paramf.n(this.x);
    }
    this.c.add(paramf);
  }
  
  private void b()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (localf != null) {
        localf.a();
      }
    }
  }
  
  private void e()
    throws InterruptedException
  {
    synchronized (this.p0)
    {
      do
      {
        if (this.p2) {
          return;
        }
      } while (this.q == null);
      if (this.H3)
      {
        this.H3 = false;
        b();
      }
      g("skip process", "processThread start processing");
      Object localObject2;
      int i;
      if (this.c.isEmpty())
      {
        localObject2 = (d)this.q.poll();
        if (localObject2 != null) {
          this.x.offer(localObject2);
        }
        i = 1;
      }
      else
      {
        localObject2 = this.c.iterator();
        int j = 1;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          f localf = (f)((Iterator)localObject2).next();
          if (localf != null)
          {
            localf.k();
            if (!localf.f()) {
              j = 0;
            }
          }
        }
      }
      if (this.d != null) {
        while ((!this.x.isEmpty()) && (!this.p2))
        {
          localObject2 = (d)this.x.poll();
          if (localObject2 != null) {
            this.d.a((d)localObject2);
          }
        }
      }
      if (i != 0)
      {
        this.y.set(true);
        this.p0.wait();
      }
    }
  }
  
  private void f(String paramString)
  {
    e.a("AudioProcessClient", paramString);
  }
  
  public void c(int paramInt)
  {
    if (!this.p1.a(paramInt))
    {
      this.p1.b(paramInt, true);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("enableAlgorithm: ");
      ((StringBuilder)localObject1).append(paramInt);
      f(((StringBuilder)localObject1).toString());
      Object localObject4 = this.p0;
      localObject1 = null;
      if (paramInt == 0)
      {
        try
        {
          localObject1 = new com/tplink/libmediakit/media/audioprocess/processor/AECM;
          ((AECM)localObject1).<init>(this.p1);
          ((AECM)localObject1).t(this.z);
        }
        finally
        {
          break label252;
        }
      }
      else if (paramInt == 1)
      {
        localObject3 = new com/tplink/libmediakit/media/audioprocess/processor/AEC;
        ((AEC)localObject3).<init>(this.p1);
        ((AEC)localObject3).v(this.z);
        ((f)localObject3).o(this.f);
      }
      else if (paramInt == 2)
      {
        localObject3 = new NS(this.p1);
      }
      else if (paramInt == 6)
      {
        localObject3 = new HS(this.p1);
      }
      else if (paramInt == 3)
      {
        localObject3 = new VAD(this.p1);
      }
      else if (paramInt == 4)
      {
        localObject3 = new EQ(this.p1);
      }
      else if (paramInt == 5)
      {
        localObject3 = new AGC(this.p1);
      }
      else if (paramInt == 7)
      {
        localObject3 = new a(this.p1);
      }
      a((f)localObject3);
      return;
      label252:
      throw ((Throwable)localObject3);
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Already enable algorithm ");
    ((StringBuilder)localObject3).append(paramInt);
    throw new IllegalStateException(((StringBuilder)localObject3).toString());
  }
  
  public void d()
  {
    synchronized (this.p0)
    {
      this.H3 = true;
      return;
    }
  }
  
  protected void g(String paramString1, String paramString2)
  {
    e.c("AudioProcessClient", paramString1, paramString2);
  }
  
  public void h(boolean paramBoolean)
  {
    this.p3 = paramBoolean;
    if (this.p1.a(2)) {
      for (int i = this.c.size() - 1; i >= 0; i--)
      {
        f localf = (f)this.c.get(i);
        if ((localf instanceof NS))
        {
          ((NS)localf).t(paramBoolean);
          break;
        }
      }
    }
  }
  
  public void i(T arg1)
  {
    this.q.add(???);
    int i = 0;
    while (i == 0) {
      synchronized (this.p0)
      {
        if (this.q != null)
        {
          if (this.H3)
          {
            this.H3 = false;
            b();
          }
          int j = 1;
          i = 1;
          Object localObject1;
          if (this.c.isEmpty())
          {
            localObject1 = (d)this.q.poll();
            i = j;
            if (localObject1 != null)
            {
              this.x.offer(localObject1);
              i = j;
            }
          }
          else
          {
            Iterator localIterator = this.c.iterator();
            j = i;
            for (;;)
            {
              i = j;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (f)localIterator.next();
              if (localObject1 != null)
              {
                ((f)localObject1).k();
                if (!((f)localObject1).f()) {
                  j = 0;
                }
              }
            }
          }
          if (this.d != null) {
            while (!this.x.isEmpty())
            {
              localObject1 = (d)this.x.poll();
              if (localObject1 != null) {
                this.d.a((d)localObject1);
              }
            }
          }
        }
      }
    }
  }
  
  public void j(float paramFloat)
  {
    if (this.p1.a(1)) {
      for (int i = this.c.size() - 1; i >= 0; i--)
      {
        f localf = (f)this.c.get(i);
        if ((localf instanceof AEC))
        {
          ((AEC)localf).u(paramFloat);
          break;
        }
      }
    }
  }
  
  public void k(a<T> parama)
  {
    this.d = parama;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("frameProcessedListener = ");
    localStringBuilder.append(parama);
    f(localStringBuilder.toString());
  }
  
  public void l(int paramInt)
  {
    this.p1.a = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inputSampleRate = ");
    localStringBuilder.append(paramInt);
    f(localStringBuilder.toString());
  }
  
  public void m(Queue<T> paramQueue)
  {
    this.z = paramQueue;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refQueue = ");
    localStringBuilder.append(paramQueue.toString());
    f(localStringBuilder.toString());
  }
  
  public void n(b paramb)
  {
    this.f = paramb;
  }
  
  public void o()
  {
    if (this.p1.a(1)) {
      for (int i = this.c.size() - 1; i >= 0; i--)
      {
        f localf = (f)this.c.get(i);
        if ((localf instanceof AEC))
        {
          ((AEC)localf).w();
          break;
        }
      }
    }
  }
  
  public void run()
  {
    try
    {
      e();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public static abstract interface a<T extends d>
  {
    public abstract void a(T paramT);
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */