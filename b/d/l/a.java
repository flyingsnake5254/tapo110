package b.d.l;

import androidx.annotation.NonNull;
import com.tplink.libtpimagedownloadmedia.loader.f;
import com.tplink.libtpimagedownloadmedia.loader.g;
import com.tplink.libtpstreamclientmanager.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  private final Map<String, b.d.l.b.a> a = new ConcurrentHashMap();
  private final ExecutorService b = Executors.newCachedThreadPool(new a());
  
  public static a b()
  {
    return b.a;
  }
  
  public void a(g paramg)
  {
    Object localObject = paramg.b();
    localObject = (b.d.l.b.a)this.a.get(localObject);
    if (localObject != null) {
      ((b.d.l.b.a)localObject).d(paramg);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((b.d.l.b.a)localIterator.next()).e();
    }
    this.a.clear();
    m.V().q0();
  }
  
  public void d(g paramg, f paramf)
  {
    String str = paramg.b();
    b.d.l.b.a locala1 = (b.d.l.b.a)this.a.get(str);
    b.d.l.b.a locala2 = locala1;
    if (locala1 == null) {
      try
      {
        locala2 = new b/d/l/b/a;
        locala2.<init>(str);
        locala2.f(this.b.submit(locala2));
        this.a.put(str, locala2);
      }
      finally {}
    }
    locala2.g(paramg, paramf);
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
      localStringBuilder.append("pool-ImageDownloadManager-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
  
  private static class b
  {
    public static final a a = new a(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */