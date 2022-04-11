package com.tplink.libtpmediamanager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import b.d.b0.a.t;
import b.d.d.i.a;
import b.d.i.a.b.c.o;
import b.d.j.a.b;
import com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback;
import com.tplink.libtpstreamclientmanager.m;
import com.tplink.libtpstreamconnectionsocket.EncryptException;
import com.tplink.libtpstreamconnectionsocket.UserEncryptException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class e
  implements b.d.a0.b.d
{
  private static volatile e a;
  private final AtomicReference<t> b = new AtomicReference();
  private final ExecutorService c = Executors.newCachedThreadPool(new a());
  
  public static e k()
  {
    if (a == null) {
      try
      {
        e locale = new com/tplink/libtpmediamanager/e;
        locale.<init>();
        a = locale;
      }
      finally {}
    }
    return a;
  }
  
  private void q(String paramString, Context paramContext)
  {
    t localt = (t)this.b.get();
    if (localt == null)
    {
      paramString = new t(paramString);
      paramString.a0(paramContext);
    }
    else
    {
      localt.a0(paramContext);
      paramString = localt;
    }
    if (paramString.D())
    {
      paramString.w();
    }
    else
    {
      paramString.W(true);
      this.c.submit(paramString);
      this.b.set(paramString);
    }
    paramString.T();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    t localt = (t)this.b.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ConnectType: ");
    ((StringBuilder)localObject).append(paramInt);
    b.d.p.d.a("PlaybackDisplayManager", ((StringBuilder)localObject).toString());
    if (localt != null)
    {
      if (localt.B() < paramInt) {
        localt.X(paramInt);
      }
      localt.F().set(true);
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
    t localt = (t)this.b.get();
    if (localt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("设备： ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" 视频播放发生严重异常！");
      b.d.p.d.a("PlaybackDisplayManager", localStringBuilder.toString());
      localt.g0(paramException);
    }
  }
  
  public void c(String paramString, byte[] paramArrayOfByte)
  {
    paramString = (t)this.b.get();
    if (paramString != null) {
      paramString.M(paramArrayOfByte);
    }
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.b.get();
    if (paramString != null)
    {
      paramString.w();
      paramString.z();
      paramString.T();
      paramString.k0(paramBoolean);
    }
  }
  
  public void e(String paramString, boolean paramBoolean, float paramFloat)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.b.get();
    if (paramString != null)
    {
      paramString.w();
      paramString.z();
      paramString.T();
      paramString.i0(paramBoolean, paramFloat);
    }
  }
  
  public void f(String paramString, long paramLong)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.b.get();
    if (paramString != null)
    {
      paramString.w();
      paramString.z();
      paramString.T();
      paramString.j0(paramLong);
    }
  }
  
  public void g(String paramString)
  {
    paramString = (t)this.b.get();
    if (paramString != null) {
      paramString.N();
    }
  }
  
  public void h(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramString1 = (t)this.b.get();
    if (paramString1 != null)
    {
      paramString2 = paramString2.split("/");
      int i = paramString2.length;
      float f1 = 1.0F;
      float f2 = f1;
      if (i == 2) {
        try
        {
          f2 = Float.parseFloat(paramString2[0]);
          float f3 = Float.parseFloat(paramString2[1]);
          f2 /= f3;
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
          f2 = f1;
        }
      }
      paramString1.Z(f2);
    }
  }
  
  public void i(String paramString1, String paramString2, long paramLong)
  {
    if (paramString1 == null) {
      return;
    }
    t localt = (t)this.b.get();
    if (localt != null)
    {
      localt.w();
      localt.d0();
    }
    b.a().f(paramString1, 1);
    m.V().G0(paramString1, paramString2, paramLong, 0L, this);
  }
  
  public void j(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.b.get();
    if ((paramString != null) && (paramString.D())) {
      paramString.w();
    }
  }
  
  public t l(String paramString)
  {
    t localt1 = (t)this.b.get();
    t localt2 = localt1;
    if (localt1 == null)
    {
      localt2 = new t(paramString);
      this.b.set(localt2);
    }
    return localt2;
  }
  
  @Nullable
  public t m()
  {
    return (t)this.b.get();
  }
  
  public void n(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = (t)this.b.get();
    if (paramString != null) {
      paramString.S();
    }
  }
  
  public void o(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    t localt = (t)this.b.get();
    if (localt == null) {
      return;
    }
    localt.w();
    localt.d0();
    b.a().f(paramString1, 1);
    m.V().E0(paramString1, paramInt, paramString2, paramLong, 0L, this);
  }
  
  public void p(String paramString, StreamNotificationCallback paramStreamNotificationCallback)
  {
    if (paramString == null) {
      return;
    }
    m.V().a0(paramString).G(paramStreamNotificationCallback);
  }
  
  public void r(String paramString1, Context paramContext, long paramLong, int paramInt, int[] paramArrayOfInt, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    q(paramString1, paramContext);
    n(paramString1);
    t localt = (t)this.b.get();
    paramContext = localt;
    if (localt == null)
    {
      paramContext = new t(paramString1);
      this.b.set(paramContext);
    }
    paramContext.T();
    h(paramString1, paramString2);
    m.V().A0(paramString1);
    paramContext.z();
    b.a().f(paramString1, 1);
    m.V().T(paramString1, paramInt, paramString2, paramArrayOfInt, paramLong, 0L, this);
  }
  
  public void s(String paramString)
  {
    if (paramString == null) {
      return;
    }
    t localt = (t)this.b.getAndSet(null);
    if (localt != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("设备： ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" 视频播放客户端被销毁！");
      b.d.p.d.a("PlaybackDisplayManager", localStringBuilder.toString());
      localt.y();
      localt.b0(null);
      localt.x();
    }
    m.V().C0(paramString);
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
      localStringBuilder.append("VodDisplay-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */