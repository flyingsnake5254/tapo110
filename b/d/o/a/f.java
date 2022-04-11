package b.d.o.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.d.d.d.c;
import b.d.i.a.a.g;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  private e a;
  private Map<String, b> b = new ConcurrentHashMap();
  private HandlerThread c;
  private c d;
  private final int e = 15000;
  private boolean f;
  private List<TPMediaDevice> g;
  private g h;
  private io.reactivex.e0.b i = new io.reactivex.e0.b();
  private e j = new a();
  private e k = new b();
  
  private f()
  {
    HandlerThread localHandlerThread = new HandlerThread(f.class.getName());
    this.c = localHandlerThread;
    localHandlerThread.start();
    this.d = new c(this, this.c.getLooper());
    this.g = Collections.synchronizedList(new ArrayList());
    this.h = new g();
    b.d.d.c.a.b();
  }
  
  private void e()
  {
    if (this.f) {
      return;
    }
    Object localObject = this.c;
    if ((localObject == null) || (!((HandlerThread)localObject).isAlive()))
    {
      localObject = new HandlerThread(f.class.getName());
      this.c = ((HandlerThread)localObject);
      ((HandlerThread)localObject).start();
    }
    if (this.d == null) {
      this.d = new c(this, this.c.getLooper());
    }
    this.d.removeMessages(1);
    r();
    localObject = this.d;
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessageDelayed(1, 15000L);
    }
  }
  
  private void f(List<TPMediaDevice> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      paramList = (TPMediaDevice)localIterator.next();
      boolean bool1 = c.i(paramList.getDeviceIdMd5());
      boolean bool2 = c.j(paramList.getDeviceIdMd5());
      if ((!bool1) && (bool2)) {
        l(paramList.getDeviceIdMd5(), null);
      }
    }
  }
  
  private void g(List<TPMediaDevice> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramList);
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if (localb.w())
      {
        int m = localArrayList.size();
        int n = 0;
        for (int i1 = 0; i1 < m; i1++)
        {
          paramList = (TPMediaDevice)localArrayList.get(i1);
          if (paramList.getDeviceIdMd5().equals(localb.v()))
          {
            bool = c.i(paramList.getDeviceIdMd5());
            if (!c.j(paramList.getDeviceIdMd5()))
            {
              i1 = n;
              break label158;
            }
            i1 = 1;
            break label158;
          }
        }
        boolean bool = false;
        i1 = n;
        label158:
        if ((i1 == 0) || (bool)) {
          localb.u();
        }
      }
      else
      {
        localb.u();
      }
    }
  }
  
  private void h()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.b.keySet());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (b)this.b.get(localObject2);
      if (localObject2 != null)
      {
        ((b)localObject2).s();
        ((b)localObject2).z();
        ((b)localObject2).A();
        b.d.p.d.a("LiveConnectionManager", "destroyAllConnections");
      }
    }
  }
  
  public static f m()
  {
    return d.a;
  }
  
  private void t()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.d = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.c = null;
    }
  }
  
  private void x()
  {
    c localc = this.d;
    if (localc != null) {
      localc.removeMessages(1);
    }
  }
  
  public void i(@NonNull String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      paramString = (b)this.b.get(paramString);
      if (paramString != null) {
        paramString.s();
      }
    }
  }
  
  public void j(@NonNull String paramString, int paramInt)
  {
    if (this.b.containsKey(paramString))
    {
      paramString = (b)this.b.get(paramString);
      if (paramString != null) {
        paramString.t(paramInt);
      }
    }
  }
  
  public void k(@NonNull String paramString, BitStreamType paramBitStreamType)
  {
    b localb = (b)this.b.get(paramString);
    if (localb != null)
    {
      localb.F(paramBitStreamType);
      paramString = localb;
    }
    else
    {
      localb = new b(paramString);
      localb.F(paramBitStreamType);
      this.b.put(paramString, localb);
      paramString = localb;
    }
    paramString.D(this.k);
    paramString.B(false);
    paramString.C(true);
    paramString.o();
  }
  
  void l(@NonNull String paramString, BitStreamType paramBitStreamType)
  {
    if (!b.d.d.a.a.l()) {
      return;
    }
    b localb = (b)this.b.get(paramString);
    if (localb != null)
    {
      localb.F(paramBitStreamType);
      paramString = localb;
    }
    else
    {
      localb = new b(paramString);
      localb.F(paramBitStreamType);
      this.b.put(paramString, localb);
      paramString = localb;
    }
    paramString.E(this.j);
    paramString.B(false);
    paramString.q();
  }
  
  public void n()
  {
    x();
    h();
  }
  
  public void o()
  {
    this.f = true;
    x();
  }
  
  public void p()
  {
    this.f = false;
    e();
  }
  
  public void q(List<TPMediaDevice> paramList)
  {
    this.g.clear();
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      paramList = (TPMediaDevice)localIterator.next();
      if (c.k(paramList.getDeviceIdMd5())) {
        this.g.add(paramList);
      }
    }
    r();
    s();
  }
  
  public void r()
  {
    if ((!this.f) && (b.d.d.a.a.l()))
    {
      if (TextUtils.isEmpty(b.d.d.a.a.c())) {
        return;
      }
      g(this.g);
      f(this.g);
    }
  }
  
  public void s()
  {
    this.h.a(this.g);
  }
  
  public void u()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.b.keySet());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (b)this.b.get(localObject2);
      if (localObject2 != null)
      {
        ((b)localObject2).z();
        ((b)localObject2).A();
      }
    }
  }
  
  public void v(e parame)
  {
    this.a = parame;
  }
  
  public void w(String paramString, boolean paramBoolean)
  {
    paramString = (b)this.b.get(paramString);
    if (paramString != null) {
      paramString.G(paramBoolean);
    }
  }
  
  class a
    implements e
  {
    a() {}
    
    public void d(List<d> paramList)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (d)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pre-connection failure");
        localStringBuilder.append(paramList.toString());
        b.d.p.d.c("LiveConnectionManager", localStringBuilder.toString());
      }
    }
    
    public void f(String paramString) {}
    
    public void k(List<d> paramList)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        paramList = new StringBuilder();
        paramList.append("pre-connection success");
        paramList.append(locald.toString());
        b.d.p.d.c("LiveConnectionManager", paramList.toString());
      }
    }
  }
  
  class b
    implements e
  {
    b() {}
    
    public void d(List<d> paramList)
    {
      if (f.a(f.this) != null)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("live connection failure");
          localStringBuilder.append(locald.toString());
          b.d.p.d.c("LiveConnectionManager", localStringBuilder.toString());
        }
        f.a(f.this).d(paramList);
      }
    }
    
    public void f(String paramString)
    {
      if (f.a(f.this) != null) {
        f.a(f.this).f(paramString);
      }
    }
    
    public void k(List<d> paramList)
    {
      if (f.a(f.this) != null)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("live connection success");
          localStringBuilder.append(locald.toString());
          b.d.p.d.c("LiveConnectionManager", localStringBuilder.toString());
        }
        f.a(f.this).k(paramList);
      }
    }
  }
  
  private static class c
    extends Handler
  {
    private f a;
    
    c(f paramf, Looper paramLooper)
    {
      super();
      this.a = ((f)new WeakReference(paramf).get());
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      f localf = this.a;
      if (localf == null) {
        return;
      }
      int i = paramMessage.what;
      if (1 == i)
      {
        f.b(localf);
      }
      else if (2 == i)
      {
        b.d.p.d.c("LiveConnectionManager", "in background 2 minutes");
        f.c(this.a);
        f.d(this.a);
      }
    }
  }
  
  private static class d
  {
    public static f a = new f(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\o\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */