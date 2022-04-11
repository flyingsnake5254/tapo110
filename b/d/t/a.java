package b.d.t;

import android.util.Log;
import androidx.annotation.NonNull;
import b.d.t.d.c;
import b.d.t.d.e;
import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  private ExecutorService a = Executors.newCachedThreadPool(new a());
  private ExecutorService b = Executors.newCachedThreadPool(new b());
  
  public static a c()
  {
    return d.a;
  }
  
  public void a(BaseConnection paramBaseConnection, b.d.t.c.a parama)
  {
    if (paramBaseConnection.getConnectionType() == 256) {
      paramBaseConnection = new c(paramBaseConnection, parama);
    } else if (paramBaseConnection.getConnectionType() == 17) {
      paramBaseConnection = new e(paramBaseConnection, parama);
    } else {
      paramBaseConnection = new b.d.t.d.d(paramBaseConnection, parama);
    }
    try
    {
      this.a.submit(paramBaseConnection);
    }
    catch (OutOfMemoryError paramBaseConnection)
    {
      b.d.p.d.c("ConnectionManager", Log.getStackTraceString(paramBaseConnection));
    }
  }
  
  public void b(final int paramInt, final DeviceModel paramDeviceModel)
  {
    if (paramInt >= 0) {
      this.b.submit(new c(paramInt, paramDeviceModel));
    }
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      Thread localThread = new Thread(paramRunnable);
      paramRunnable = new StringBuilder();
      paramRunnable.append("pool-createConnectionPool-");
      paramRunnable.append(this.c.incrementAndGet());
      localThread.setName(paramRunnable.toString());
      return localThread;
    }
  }
  
  class b
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    b() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pool-destroyConnectionPool-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
  
  class c
    implements Runnable
  {
    c(int paramInt, DeviceModel paramDeviceModel) {}
    
    public void run()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy ");
      localStringBuilder.append(paramInt);
      b.d.p.d.c("ConnectionManager", localStringBuilder.toString());
      b.a(paramInt, paramDeviceModel);
    }
  }
  
  private static class d
  {
    public static a a = new a(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */