package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

public final class u
{
  private final o a = new o();
  @Nullable
  private final a b;
  @Nullable
  private final d c;
  private boolean d;
  @Nullable
  private Surface e;
  private float f;
  private float g;
  private float h;
  private float i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p;
  
  public u(@Nullable Context paramContext)
  {
    paramContext = f(paramContext);
    this.b = paramContext;
    if (paramContext != null) {
      paramContext = d.d();
    } else {
      paramContext = null;
    }
    this.c = paramContext;
    this.j = -9223372036854775807L;
    this.k = -9223372036854775807L;
    this.f = -1.0F;
    this.i = 1.0F;
  }
  
  private static boolean b(long paramLong1, long paramLong2)
  {
    boolean bool;
    if (Math.abs(paramLong1 - paramLong2) <= 20000000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void c()
  {
    if (o0.a >= 30)
    {
      Surface localSurface = this.e;
      if ((localSurface != null) && (this.h != 0.0F))
      {
        this.h = 0.0F;
        q(localSurface, 0.0F);
      }
    }
  }
  
  private static long d(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong2 += (paramLong1 - paramLong2) / paramLong3 * paramLong3;
    if (paramLong1 <= paramLong2)
    {
      paramLong3 = paramLong2 - paramLong3;
    }
    else
    {
      long l1 = paramLong3 + paramLong2;
      paramLong3 = paramLong2;
      paramLong2 = l1;
    }
    if (paramLong2 - paramLong1 >= paramLong1 - paramLong3) {
      paramLong2 = paramLong3;
    }
    return paramLong2;
  }
  
  @Nullable
  private static a f(@Nullable Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramContext != null)
    {
      Context localContext = paramContext.getApplicationContext();
      paramContext = (Context)localObject2;
      if (o0.a >= 17) {
        paramContext = c.c(localContext);
      }
      localObject1 = paramContext;
      if (paramContext == null) {
        localObject1 = b.b(localContext);
      }
    }
    return (a)localObject1;
  }
  
  private void p()
  {
    this.l = 0L;
    this.o = -1L;
    this.m = -1L;
  }
  
  @RequiresApi(30)
  private static void q(Surface paramSurface, float paramFloat)
  {
    int i1;
    if (paramFloat == 0.0F) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    try
    {
      paramSurface.setFrameRate(paramFloat, i1);
    }
    catch (IllegalStateException paramSurface)
    {
      com.google.android.exoplayer2.util.u.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", paramSurface);
    }
  }
  
  private void r(@Nullable Display paramDisplay)
  {
    if (paramDisplay != null)
    {
      long l1 = (1.0E9D / paramDisplay.getRefreshRate());
      this.j = l1;
      this.k = (l1 * 80L / 100L);
    }
    else
    {
      com.google.android.exoplayer2.util.u.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
      this.j = -9223372036854775807L;
      this.k = -9223372036854775807L;
    }
  }
  
  private void s()
  {
    if ((o0.a >= 30) && (this.e != null))
    {
      float f1;
      if (this.a.e()) {
        f1 = this.a.b();
      } else {
        f1 = this.f;
      }
      float f2 = this.g;
      if (f1 == f2) {
        return;
      }
      boolean bool1 = true;
      boolean bool2 = f1 < -1.0F;
      if ((bool2) && (f2 != -1.0F))
      {
        if ((this.a.e()) && (this.a.d() >= 5000000000L)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (bool2) {
          f2 = 0.02F;
        } else {
          f2 = 1.0F;
        }
        if (Math.abs(f1 - this.g) >= f2)
        {
          bool2 = bool1;
          break label174;
        }
      }
      do
      {
        bool2 = false;
        break;
        if (bool2)
        {
          bool2 = bool1;
          break;
        }
      } while (this.a.c() < 30);
      bool2 = bool1;
      label174:
      if (bool2)
      {
        this.g = f1;
        t(false);
      }
    }
  }
  
  private void t(boolean paramBoolean)
  {
    if (o0.a >= 30)
    {
      Surface localSurface = this.e;
      if (localSurface != null)
      {
        float f1 = 0.0F;
        float f2 = f1;
        if (this.d)
        {
          float f3 = this.g;
          f2 = f1;
          if (f3 != -1.0F) {
            f2 = this.i * f3;
          }
        }
        if ((!paramBoolean) && (this.h == f2)) {
          return;
        }
        this.h = f2;
        q(localSurface, f2);
      }
    }
  }
  
  public long a(long paramLong)
  {
    long l1;
    if ((this.o != -1L) && (this.a.e()))
    {
      l1 = this.a.a();
      l1 = this.p + ((float)(l1 * (this.l - this.o)) / this.i);
      if (b(paramLong, l1)) {
        paramLong = l1;
      } else {
        p();
      }
    }
    this.m = this.l;
    this.n = paramLong;
    d locald = this.c;
    if ((locald != null) && (this.j != -9223372036854775807L))
    {
      l1 = locald.d;
      if (l1 == -9223372036854775807L) {
        return paramLong;
      }
      return d(paramLong, l1, this.j) - this.k;
    }
    return paramLong;
  }
  
  public void g()
  {
    a locala = this.b;
    if (locala != null)
    {
      locala.unregister();
      ((d)g.e(this.c)).e();
    }
  }
  
  public void h()
  {
    if (this.b != null)
    {
      ((d)g.e(this.c)).a();
      this.b.a(new a(this));
    }
  }
  
  public void i(float paramFloat)
  {
    this.f = paramFloat;
    this.a.g();
    s();
  }
  
  public void j(long paramLong)
  {
    long l1 = this.m;
    if (l1 != -1L)
    {
      this.o = l1;
      this.p = this.n;
    }
    this.l += 1L;
    this.a.f(paramLong * 1000L);
    s();
  }
  
  public void k(float paramFloat)
  {
    this.i = paramFloat;
    p();
    t(false);
  }
  
  public void l()
  {
    p();
  }
  
  public void m()
  {
    this.d = true;
    p();
    t(false);
  }
  
  public void n()
  {
    this.d = false;
    c();
  }
  
  public void o(@Nullable Surface paramSurface)
  {
    Surface localSurface = paramSurface;
    if ((paramSurface instanceof DummySurface)) {
      localSurface = null;
    }
    if (this.e == localSurface) {
      return;
    }
    c();
    this.e = localSurface;
    t(true);
  }
  
  private static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void unregister();
    
    public static abstract interface a
    {
      public abstract void a(@Nullable Display paramDisplay);
    }
  }
  
  private static final class b
    implements u.a
  {
    private final WindowManager a;
    
    private b(WindowManager paramWindowManager)
    {
      this.a = paramWindowManager;
    }
    
    @Nullable
    public static u.a b(Context paramContext)
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext != null) {
        paramContext = new b(paramContext);
      } else {
        paramContext = null;
      }
      return paramContext;
    }
    
    public void a(u.a.a parama)
    {
      parama.a(this.a.getDefaultDisplay());
    }
    
    public void unregister() {}
  }
  
  @RequiresApi(17)
  private static final class c
    implements u.a, DisplayManager.DisplayListener
  {
    private final DisplayManager a;
    @Nullable
    private u.a.a b;
    
    private c(DisplayManager paramDisplayManager)
    {
      this.a = paramDisplayManager;
    }
    
    private Display b()
    {
      return this.a.getDisplay(0);
    }
    
    @Nullable
    public static u.a c(Context paramContext)
    {
      paramContext = (DisplayManager)paramContext.getSystemService("display");
      if (paramContext != null) {
        paramContext = new c(paramContext);
      } else {
        paramContext = null;
      }
      return paramContext;
    }
    
    public void a(u.a.a parama)
    {
      this.b = parama;
      this.a.registerDisplayListener(this, o0.v());
      parama.a(b());
    }
    
    public void onDisplayAdded(int paramInt) {}
    
    public void onDisplayChanged(int paramInt)
    {
      u.a.a locala = this.b;
      if ((locala != null) && (paramInt == 0)) {
        locala.a(b());
      }
    }
    
    public void onDisplayRemoved(int paramInt) {}
    
    public void unregister()
    {
      this.a.unregisterDisplayListener(this);
      this.b = null;
    }
  }
  
  private static final class d
    implements Choreographer.FrameCallback, Handler.Callback
  {
    private static final d c = new d();
    public volatile long d = -9223372036854775807L;
    private final Handler f;
    private final HandlerThread q;
    private Choreographer x;
    private int y;
    
    private d()
    {
      Object localObject = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
      this.q = ((HandlerThread)localObject);
      ((HandlerThread)localObject).start();
      localObject = o0.u(((HandlerThread)localObject).getLooper(), this);
      this.f = ((Handler)localObject);
      ((Handler)localObject).sendEmptyMessage(0);
    }
    
    private void b()
    {
      int i = this.y + 1;
      this.y = i;
      if (i == 1) {
        ((Choreographer)g.e(this.x)).postFrameCallback(this);
      }
    }
    
    private void c()
    {
      this.x = Choreographer.getInstance();
    }
    
    public static d d()
    {
      return c;
    }
    
    private void f()
    {
      int i = this.y - 1;
      this.y = i;
      if (i == 0)
      {
        ((Choreographer)g.e(this.x)).removeFrameCallback(this);
        this.d = -9223372036854775807L;
      }
    }
    
    public void a()
    {
      this.f.sendEmptyMessage(1);
    }
    
    public void doFrame(long paramLong)
    {
      this.d = paramLong;
      ((Choreographer)g.e(this.x)).postFrameCallbackDelayed(this, 500L);
    }
    
    public void e()
    {
      this.f.sendEmptyMessage(2);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return false;
          }
          f();
          return true;
        }
        b();
        return true;
      }
      c();
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */