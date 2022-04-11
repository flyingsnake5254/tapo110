package b.d.w.c.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class e
  implements b.c.a.d
{
  private static volatile e a;
  private final b.c.a.c b;
  private final f c;
  private List<com.tplink.libtputility.log.tiny.bean.c> d = new ArrayList();
  private final Map<String, Long> e = new HashMap();
  
  private e(Context paramContext)
  {
    Object localObject = new HandlerThread("AndroidTinyFileLogger");
    ((HandlerThread)localObject).start();
    localObject = new f(paramContext, ((HandlerThread)localObject).getLooper());
    this.c = ((f)localObject);
    this.b = d.b(paramContext).b(false).c(new b((Handler)localObject)).a();
  }
  
  public static e d(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          e locale = new b/d/w/c/c/e;
          locale.<init>(paramContext);
          a = locale;
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean e(String paramString)
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.e != null))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (com.tplink.libtputility.log.tiny.bean.c)localIterator.next();
        if (((com.tplink.libtputility.log.tiny.bean.c)localObject).c())
        {
          String str = ((com.tplink.libtputility.log.tiny.bean.c)localObject).a();
          Long localLong = (Long)this.e.get(str);
          long l = System.currentTimeMillis();
          if (localLong == null)
          {
            this.e.put(str, Long.valueOf(l));
          }
          else if (paramString.contains(str))
          {
            if (l - localLong.longValue() > ((com.tplink.libtputility.log.tiny.bean.c)localObject).b())
            {
              this.e.put(str, Long.valueOf(l));
              return false;
            }
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void a(int paramInt, @Nullable String paramString1, @NonNull String paramString2)
  {
    if (e(paramString2)) {
      return;
    }
    this.b.a(paramInt, paramString1, paramString2);
  }
  
  public boolean b(int paramInt, @Nullable String paramString)
  {
    return true;
  }
  
  public Future<String> c()
  {
    return this.c.b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\c\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */