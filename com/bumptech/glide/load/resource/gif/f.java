package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.h;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.request.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class f
{
  private final com.bumptech.glide.l.a a;
  private final Handler b;
  private final List<b> c = new ArrayList();
  final com.bumptech.glide.i d;
  private final e e;
  private boolean f;
  private boolean g;
  private boolean h;
  private h<Bitmap> i;
  private a j;
  private boolean k;
  private a l;
  private Bitmap m;
  private com.bumptech.glide.load.i<Bitmap> n;
  private a o;
  @Nullable
  private d p;
  private int q;
  private int r;
  private int s;
  
  f(com.bumptech.glide.c paramc, com.bumptech.glide.l.a parama, int paramInt1, int paramInt2, com.bumptech.glide.load.i<Bitmap> parami, Bitmap paramBitmap)
  {
    this(paramc.f(), com.bumptech.glide.c.u(paramc.h()), parama, null, i(com.bumptech.glide.c.u(paramc.h()), paramInt1, paramInt2), parami, paramBitmap);
  }
  
  f(e parame, com.bumptech.glide.i parami, com.bumptech.glide.l.a parama, Handler paramHandler, h<Bitmap> paramh, com.bumptech.glide.load.i<Bitmap> parami1, Bitmap paramBitmap)
  {
    this.d = parami;
    parami = paramHandler;
    if (paramHandler == null) {
      parami = new Handler(Looper.getMainLooper(), new c());
    }
    this.e = parame;
    this.b = parami;
    this.i = paramh;
    this.a = parama;
    o(parami1, paramBitmap);
  }
  
  private static com.bumptech.glide.load.c g()
  {
    return new com.bumptech.glide.o.b(Double.valueOf(Math.random()));
  }
  
  private static h<Bitmap> i(com.bumptech.glide.i parami, int paramInt1, int paramInt2)
  {
    return parami.k().m0(((g)((g)g.m0(com.bumptech.glide.load.engine.j.b).k0(true)).e0(true)).U(paramInt1, paramInt2));
  }
  
  private void l()
  {
    if ((this.f) && (!this.g))
    {
      if (this.h)
      {
        boolean bool;
        if (this.o == null) {
          bool = true;
        } else {
          bool = false;
        }
        com.bumptech.glide.util.i.a(bool, "Pending target must be null when starting from the first frame");
        this.a.f();
        this.h = false;
      }
      a locala = this.o;
      if (locala != null)
      {
        this.o = null;
        m(locala);
        return;
      }
      this.g = true;
      int i1 = this.a.e();
      long l1 = SystemClock.uptimeMillis();
      long l2 = i1;
      this.a.b();
      this.l = new a(this.b, this.a.g(), l1 + l2);
      this.i.m0(g.n0(g())).A0(this.a).u0(this.l);
    }
  }
  
  private void n()
  {
    Bitmap localBitmap = this.m;
    if (localBitmap != null)
    {
      this.e.c(localBitmap);
      this.m = null;
    }
  }
  
  private void p()
  {
    if (this.f) {
      return;
    }
    this.f = true;
    this.k = false;
    l();
  }
  
  private void q()
  {
    this.f = false;
  }
  
  void a()
  {
    this.c.clear();
    n();
    q();
    a locala = this.j;
    if (locala != null)
    {
      this.d.m(locala);
      this.j = null;
    }
    locala = this.l;
    if (locala != null)
    {
      this.d.m(locala);
      this.l = null;
    }
    locala = this.o;
    if (locala != null)
    {
      this.d.m(locala);
      this.o = null;
    }
    this.a.clear();
    this.k = true;
  }
  
  ByteBuffer b()
  {
    return this.a.getData().asReadOnlyBuffer();
  }
  
  Bitmap c()
  {
    Object localObject = this.j;
    if (localObject != null) {
      localObject = ((a)localObject).g();
    } else {
      localObject = this.m;
    }
    return (Bitmap)localObject;
  }
  
  int d()
  {
    a locala = this.j;
    int i1;
    if (locala != null) {
      i1 = locala.x;
    } else {
      i1 = -1;
    }
    return i1;
  }
  
  Bitmap e()
  {
    return this.m;
  }
  
  int f()
  {
    return this.a.c();
  }
  
  int h()
  {
    return this.s;
  }
  
  int j()
  {
    return this.a.h() + this.q;
  }
  
  int k()
  {
    return this.r;
  }
  
  @VisibleForTesting
  void m(a parama)
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((d)localObject).a();
    }
    this.g = false;
    if (this.k)
    {
      this.b.obtainMessage(2, parama).sendToTarget();
      return;
    }
    if (!this.f)
    {
      if (this.h) {
        this.b.obtainMessage(2, parama).sendToTarget();
      } else {
        this.o = parama;
      }
      return;
    }
    if (parama.g() != null)
    {
      n();
      localObject = this.j;
      this.j = parama;
      for (int i1 = this.c.size() - 1; i1 >= 0; i1--) {
        ((b)this.c.get(i1)).a();
      }
      if (localObject != null) {
        this.b.obtainMessage(2, localObject).sendToTarget();
      }
    }
    l();
  }
  
  void o(com.bumptech.glide.load.i<Bitmap> parami, Bitmap paramBitmap)
  {
    this.n = ((com.bumptech.glide.load.i)com.bumptech.glide.util.i.d(parami));
    this.m = ((Bitmap)com.bumptech.glide.util.i.d(paramBitmap));
    this.i = this.i.m0(new g().f0(parami));
    this.q = com.bumptech.glide.util.j.h(paramBitmap);
    this.r = paramBitmap.getWidth();
    this.s = paramBitmap.getHeight();
  }
  
  void r(b paramb)
  {
    if (!this.k)
    {
      if (!this.c.contains(paramb))
      {
        boolean bool = this.c.isEmpty();
        this.c.add(paramb);
        if (bool) {
          p();
        }
        return;
      }
      throw new IllegalStateException("Cannot subscribe twice in a row");
    }
    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
  }
  
  void s(b paramb)
  {
    this.c.remove(paramb);
    if (this.c.isEmpty()) {
      q();
    }
  }
  
  @VisibleForTesting
  static class a
    extends com.bumptech.glide.request.k.c<Bitmap>
  {
    private final Handler q;
    final int x;
    private final long y;
    private Bitmap z;
    
    a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.q = paramHandler;
      this.x = paramInt;
      this.y = paramLong;
    }
    
    public void d(@Nullable Drawable paramDrawable)
    {
      this.z = null;
    }
    
    Bitmap g()
    {
      return this.z;
    }
    
    public void i(@NonNull Bitmap paramBitmap, @Nullable com.bumptech.glide.request.l.b<? super Bitmap> paramb)
    {
      this.z = paramBitmap;
      paramBitmap = this.q.obtainMessage(1, this);
      this.q.sendMessageAtTime(paramBitmap, this.y);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  private class c
    implements Handler.Callback
  {
    c() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i == 1)
      {
        paramMessage = (f.a)paramMessage.obj;
        f.this.m(paramMessage);
        return true;
      }
      if (i == 2)
      {
        paramMessage = (f.a)paramMessage.obj;
        f.this.d.m(paramMessage);
      }
      return false;
    }
  }
  
  @VisibleForTesting
  static abstract interface d
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */