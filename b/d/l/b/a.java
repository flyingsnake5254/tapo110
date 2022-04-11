package b.d.l.b;

import android.text.TextUtils;
import b.d.p.d;
import com.tplink.libtpimagedownloadmedia.loader.f;
import com.tplink.libtpimagedownloadmedia.loader.g;
import com.tplink.libtpstreamclientmanager.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  implements b.d.m.b.a, Callable<Boolean>
{
  private static final String c = "a";
  private final String d;
  private Future<Boolean> f;
  private final AtomicInteger p0 = new AtomicInteger(0);
  private boolean q;
  private final List<b> x;
  private final Object y = new Object();
  private final Object z = new Object();
  
  public a(String paramString)
  {
    this.d = paramString;
    this.q = true;
    this.x = new ArrayList();
  }
  
  public void a(String arg1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    this.p0.decrementAndGet();
    Object localObject1 = c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("image：");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(" download success");
    d.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.x.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      b localb = (b)((Iterator)localObject1).next();
      localObject2 = localb.d();
      if ((((g)localObject2).b().equals(???)) && (((g)localObject2).c().equals(paramString2)) && (((g)localObject2).d() == paramInt))
      {
        ??? = localb.b();
        if (??? != null) {
          ???.c(paramArrayOfByte);
        }
        ((Iterator)localObject1).remove();
      }
    }
    synchronized (this.z)
    {
      this.z.notifyAll();
      return;
    }
  }
  
  public void b(String arg1, String paramString2, int paramInt, Exception paramException)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(???)))
    {
      this.p0.decrementAndGet();
      Object localObject1 = c;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("image：");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" download failed ");
      ((StringBuilder)localObject2).append(paramException.toString());
      d.a((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject2 = this.x.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (b)((Iterator)localObject2).next();
        paramException = ((b)localObject1).d();
        if ((paramException.b().equals(???)) && (paramException.c().equals(paramString2)) && (paramException.d() == paramInt)) {
          ((b)localObject1).a();
        }
      }
      synchronized (this.z)
      {
        this.z.notifyAll();
        return;
      }
    }
  }
  
  public Boolean c()
    throws Exception
  {
    d.a(c, "down client start");
    while (this.q)
    {
      if (this.x.size() == 0) {
        synchronized (this.y)
        {
          this.y.wait();
        }
      }
      b localb = (b)this.x.get(0);
      Object localObject4;
      if (localb.c() >= 3)
      {
        ??? = localb.b();
        if (??? != null) {
          ((f)???).c(null);
        }
        this.x.remove(0);
        localObject4 = c;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("image：");
        ((StringBuilder)???).append(localb.d().c());
        ((StringBuilder)???).append(" download failed over 3 times，remove download queue");
        d.a((String)localObject4, ((StringBuilder)???).toString());
      }
      else
      {
        ??? = c;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("image：");
        ((StringBuilder)localObject4).append(localb.d().c());
        ((StringBuilder)localObject4).append(" start download");
        d.a((String)???, ((StringBuilder)localObject4).toString());
        this.p0.set(0);
        this.p0.incrementAndGet();
        m.V().Q(this.d, localb.d().a(), localb.d().d(), localb.d().c(), this);
        if (this.p0.get() > 0) {
          synchronized (this.z)
          {
            this.z.wait();
          }
        }
      }
    }
    d.a(c, "down client terminal");
    return Boolean.TRUE;
  }
  
  public void d(g paramg)
  {
    if (this.q)
    {
      Object localObject = new b(paramg, null);
      this.x.remove(localObject);
      localObject = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("image: ");
      localStringBuilder.append(paramg.c());
      localStringBuilder.append(" remove from download queue");
      d.a((String)localObject, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    this.q = false;
    m.V().w0(this.d);
    synchronized (this.y)
    {
      this.y.notifyAll();
      synchronized (this.z)
      {
        this.z.notifyAll();
        ??? = this.f;
        if (??? != null) {
          ((Future)???).cancel(true);
        }
        return;
      }
    }
  }
  
  public void f(Future<Boolean> paramFuture)
  {
    this.f = paramFuture;
  }
  
  public void g(g paramg, f arg2)
  {
    if (this.q)
    {
      ??? = new b(paramg, ???);
      if (!this.x.contains(???))
      {
        this.x.add(???);
        synchronized (this.y)
        {
          this.y.notifyAll();
          ??? = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("image: ");
          localStringBuilder.append(paramg.c());
          localStringBuilder.append(" has submit download task");
          d.a(???, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\l\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */