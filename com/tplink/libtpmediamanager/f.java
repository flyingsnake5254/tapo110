package com.tplink.libtpmediamanager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import b.d.d.i.a;
import b.d.i.a.b.c.o;
import b.d.j.a.b;
import b.d.o.b.c;
import b.d.p.d;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback;
import com.tplink.libtplivemedia.a.t;
import com.tplink.libtpstreamclientmanager.m;
import com.tplink.libtpstreamconnectionsocket.EncryptException;
import com.tplink.libtpstreamconnectionsocket.UserEncryptException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class f
  implements c
{
  private static volatile f a;
  private final String b = "StreamDisplayManager";
  private final ExecutorService c = Executors.newCachedThreadPool(new a());
  private b<t> d = new b(null);
  private boolean e = false;
  
  public static f j()
  {
    if (a == null) {
      try
      {
        f localf = new com/tplink/libtpmediamanager/f;
        localf.<init>();
        a = localf;
      }
      finally {}
    }
    return a;
  }
  
  private void r(String paramString, Context paramContext)
  {
    t localt = (t)this.d.get(paramString);
    if (localt == null)
    {
      localt = new t(paramString);
      localt.h0(paramContext);
      paramContext = localt;
    }
    else
    {
      localt.h0(paramContext);
      paramContext = localt;
    }
    if (paramContext.I())
    {
      paramContext.y();
    }
    else
    {
      paramContext.e0(true);
      this.c.submit(paramContext);
      this.d.a(paramString, paramContext);
    }
    paramContext.a0();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    t localt = (t)this.d.get(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ConnectType: ");
    ((StringBuilder)localObject).append(paramInt);
    d.a("StreamDisplayManager", ((StringBuilder)localObject).toString());
    if (localt != null)
    {
      if (localt.D() < paramInt) {
        localt.f0(paramInt);
      }
      localt.J().set(true);
    }
    ConnectionTypeManager.INSTANCE.set(paramString, paramInt);
    localObject = RelayTimerManager.INSTANCE;
    ((RelayTimerManager)localObject).refreshRelayTimer();
    ((RelayTimerManager)localObject).subscribePlayStatus(paramString);
  }
  
  public void b(String paramString, Exception paramException)
  {
    if (paramString == null) {
      return;
    }
    if (paramException != null) {
      "401".equals(paramException.getMessage());
    }
    if ((paramException instanceof EncryptException)) {
      a.b(paramString);
    }
    if ((paramException instanceof UserEncryptException)) {
      a.a(paramString);
    }
    t localt = (t)this.d.get(paramString);
    if (localt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("设备： ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" 视频播放发生严重异常！");
      d.a("StreamDisplayManager", localStringBuilder.toString());
      localt.p0(paramException);
    }
  }
  
  public void c(String paramString, byte[] paramArrayOfByte)
  {
    paramString = (t)this.d.get(paramString);
    if (paramString != null) {
      paramString.S(paramArrayOfByte);
    }
  }
  
  public void d(String paramString, BitStreamType paramBitStreamType)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.d.get(paramString);
    if (paramString != null) {
      paramString.c0(paramBitStreamType);
    }
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.d.get(paramString);
    if (paramString != null) {
      paramString.Q(paramBoolean);
    }
  }
  
  public void f(String paramString, BitStreamType paramBitStreamType, boolean paramBoolean, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.d.get(paramString);
    if (paramString != null)
    {
      if ((paramBoolean) && (paramString.I()))
      {
        paramString.y();
        paramString.B();
      }
      paramString.w(paramBitStreamType, paramBoolean, paramInt);
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).X();
    }
  }
  
  public void h(String paramString1, BitStreamType paramBitStreamType, String paramString2)
  {
    t localt = (t)this.d.get(paramString1);
    if (localt != null) {
      localt.l0();
    }
    m.V().A(paramString1, this, paramBitStreamType, paramString2);
  }
  
  public List<String> i()
  {
    d.a("StreamDisplayManager", "销毁全部播放客户端");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      localArrayList.add(localt.E());
      localt.A();
      localt.i0(null);
      localt.z();
    }
    this.d.clear();
    m.V().r0();
    RelayTimerManager.INSTANCE.switchRelayTimer(false);
    return localArrayList;
  }
  
  public List<String> k()
  {
    return new ArrayList(this.d.keySet());
  }
  
  @Nullable
  public t l(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    t localt1 = (t)this.d.get(paramString);
    t localt2 = localt1;
    if (localt1 == null)
    {
      localt2 = new t(paramString);
      this.d.a(paramString, localt2);
    }
    return localt2;
  }
  
  Set<Map.Entry<String, t>> m()
  {
    return this.d.entrySet();
  }
  
  public boolean n()
  {
    if (!this.e)
    {
      this.e = true;
      d.a("StreamDisplayManager", "lockLiveStreamAudio,强制静音");
      return true;
    }
    return false;
  }
  
  public void o(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    if ((this.e) && (!paramBoolean))
    {
      d.a("StreamDisplayManager", "Live stream audio is locked.解除静音失败");
      return;
    }
    t localt = (t)this.d.get(paramString);
    if (localt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("设备:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",静音:");
      localStringBuilder.append(paramBoolean);
      d.a("StreamDisplayManager", localStringBuilder.toString());
      localt.g0(paramBoolean);
    }
  }
  
  public void p(String paramString, boolean paramBoolean)
  {
    t localt = (t)this.d.get(paramString);
    if (localt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("设备:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",静音:");
      localStringBuilder.append(paramBoolean);
      d.a("StreamDisplayManager", localStringBuilder.toString());
      localt.P(paramBoolean);
    }
  }
  
  public void q(String paramString, StreamNotificationCallback paramStreamNotificationCallback)
  {
    if (paramString == null) {
      return;
    }
    m.V().W(paramString).G(paramStreamNotificationCallback);
  }
  
  public void s(String paramString, Context paramContext, BitStreamType paramBitStreamType)
  {
    if (paramString == null) {
      return;
    }
    r(paramString, paramContext);
    t localt = (t)this.d.get(paramString);
    paramContext = localt;
    if (localt == null)
    {
      paramContext = new t(paramString);
      this.d.a(paramString, paramContext);
    }
    m.V().A0(paramString);
    paramContext.B();
    b.a().f(paramString, 0);
    m.V().R(paramString, this, paramBitStreamType);
  }
  
  public void t(String paramString)
  {
    if (paramString == null) {
      return;
    }
    t localt = (t)this.d.remove(paramString);
    if (localt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("设备： ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" 视频播放客户端被销毁！");
      d.a("StreamDisplayManager", localStringBuilder.toString());
      localt.A();
      localt.i0(null);
      localt.z();
    }
    m.V().y0(paramString);
  }
  
  public boolean u()
  {
    if (this.e)
    {
      this.e = false;
      d.a("StreamDisplayManager", "unlockLiveStreamAudio,解除强制静音");
      return true;
    }
    return false;
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
      paramRunnable.append("StreamDisplay-");
      paramRunnable.append(this.c.incrementAndGet());
      localThread.setName(paramRunnable.toString());
      return localThread;
    }
  }
  
  private static class b<V>
    extends ConcurrentHashMap<String, V>
  {
    @Nullable
    public V a(String paramString, V paramV)
    {
      if (paramString == null) {
        return null;
      }
      return (V)super.put(paramString, paramV);
    }
    
    @Nullable
    public V get(Object paramObject)
    {
      if (paramObject == null) {
        return null;
      }
      return (V)super.get(paramObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */