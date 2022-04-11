package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.d.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.k.d;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.u<*>;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class i<R>
  implements d, com.bumptech.glide.request.k.i, h
{
  private static final boolean a = Log.isLoggable("Request", 2);
  @GuardedBy("requestLock")
  private int A;
  @GuardedBy("requestLock")
  private int B;
  @GuardedBy("requestLock")
  private boolean C;
  @Nullable
  private RuntimeException D;
  @Nullable
  private final String b;
  private final com.bumptech.glide.util.k.c c;
  private final Object d;
  @Nullable
  private final f<R> e;
  private final RequestCoordinator f;
  private final Context g;
  private final com.bumptech.glide.e h;
  @Nullable
  private final Object i;
  private final Class<R> j;
  private final a<?> k;
  private final int l;
  private final int m;
  private final Priority n;
  private final com.bumptech.glide.request.k.j<R> o;
  @Nullable
  private final List<f<R>> p;
  private final com.bumptech.glide.request.l.c<? super R> q;
  private final Executor r;
  @GuardedBy("requestLock")
  private u<R> s;
  @GuardedBy("requestLock")
  private k.d t;
  @GuardedBy("requestLock")
  private long u;
  private volatile k v;
  @GuardedBy("requestLock")
  private a w;
  @GuardedBy("requestLock")
  @Nullable
  private Drawable x;
  @GuardedBy("requestLock")
  @Nullable
  private Drawable y;
  @GuardedBy("requestLock")
  @Nullable
  private Drawable z;
  
  private i(Context paramContext, com.bumptech.glide.e parame, @NonNull Object paramObject1, @Nullable Object paramObject2, Class<R> paramClass, a<?> parama, int paramInt1, int paramInt2, Priority paramPriority, com.bumptech.glide.request.k.j<R> paramj, @Nullable f<R> paramf, @Nullable List<f<R>> paramList, RequestCoordinator paramRequestCoordinator, k paramk, com.bumptech.glide.request.l.c<? super R> paramc, Executor paramExecutor)
  {
    String str;
    if (a) {
      str = String.valueOf(super.hashCode());
    } else {
      str = null;
    }
    this.b = str;
    this.c = com.bumptech.glide.util.k.c.a();
    this.d = paramObject1;
    this.g = paramContext;
    this.h = parame;
    this.i = paramObject2;
    this.j = paramClass;
    this.k = parama;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramPriority;
    this.o = paramj;
    this.e = paramf;
    this.p = paramList;
    this.f = paramRequestCoordinator;
    this.v = paramk;
    this.q = paramc;
    this.r = paramExecutor;
    this.w = a.c;
    if ((this.D == null) && (parame.g().a(d.d.class))) {
      this.D = new RuntimeException("Glide request origin trace");
    }
  }
  
  @GuardedBy("requestLock")
  private void h()
  {
    if (!this.C) {
      return;
    }
    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
  }
  
  @GuardedBy("requestLock")
  private boolean i()
  {
    RequestCoordinator localRequestCoordinator = this.f;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.h(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private boolean j()
  {
    RequestCoordinator localRequestCoordinator = this.f;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.b(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private boolean k()
  {
    RequestCoordinator localRequestCoordinator = this.f;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.c(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private void l()
  {
    h();
    this.c.c();
    this.o.a(this);
    k.d locald = this.t;
    if (locald != null)
    {
      locald.a();
      this.t = null;
    }
  }
  
  @GuardedBy("requestLock")
  private Drawable m()
  {
    if (this.x == null)
    {
      Drawable localDrawable = this.k.n();
      this.x = localDrawable;
      if ((localDrawable == null) && (this.k.m() > 0)) {
        this.x = q(this.k.m());
      }
    }
    return this.x;
  }
  
  @GuardedBy("requestLock")
  private Drawable n()
  {
    if (this.z == null)
    {
      Drawable localDrawable = this.k.o();
      this.z = localDrawable;
      if ((localDrawable == null) && (this.k.p() > 0)) {
        this.z = q(this.k.p());
      }
    }
    return this.z;
  }
  
  @GuardedBy("requestLock")
  private Drawable o()
  {
    if (this.y == null)
    {
      Drawable localDrawable = this.k.u();
      this.y = localDrawable;
      if ((localDrawable == null) && (this.k.v() > 0)) {
        this.y = q(this.k.v());
      }
    }
    return this.y;
  }
  
  @GuardedBy("requestLock")
  private boolean p()
  {
    RequestCoordinator localRequestCoordinator = this.f;
    boolean bool;
    if ((localRequestCoordinator != null) && (localRequestCoordinator.getRoot().a())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private Drawable q(@DrawableRes int paramInt)
  {
    Resources.Theme localTheme;
    if (this.k.A() != null) {
      localTheme = this.k.A();
    } else {
      localTheme = this.g.getTheme();
    }
    return com.bumptech.glide.load.k.e.a.a(this.h, paramInt, localTheme);
  }
  
  private void r(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" this: ");
    localStringBuilder.append(this.b);
    Log.v("Request", localStringBuilder.toString());
  }
  
  private static int s(int paramInt, float paramFloat)
  {
    if (paramInt != Integer.MIN_VALUE) {
      paramInt = Math.round(paramFloat * paramInt);
    }
    return paramInt;
  }
  
  @GuardedBy("requestLock")
  private void t()
  {
    RequestCoordinator localRequestCoordinator = this.f;
    if (localRequestCoordinator != null) {
      localRequestCoordinator.d(this);
    }
  }
  
  @GuardedBy("requestLock")
  private void u()
  {
    RequestCoordinator localRequestCoordinator = this.f;
    if (localRequestCoordinator != null) {
      localRequestCoordinator.f(this);
    }
  }
  
  public static <R> i<R> v(Context paramContext, com.bumptech.glide.e parame, Object paramObject1, Object paramObject2, Class<R> paramClass, a<?> parama, int paramInt1, int paramInt2, Priority paramPriority, com.bumptech.glide.request.k.j<R> paramj, f<R> paramf, @Nullable List<f<R>> paramList, RequestCoordinator paramRequestCoordinator, k paramk, com.bumptech.glide.request.l.c<? super R> paramc, Executor paramExecutor)
  {
    return new i(paramContext, parame, paramObject1, paramObject2, paramClass, parama, paramInt1, paramInt2, paramPriority, paramj, paramf, paramList, paramRequestCoordinator, paramk, paramc, paramExecutor);
  }
  
  private void w(GlideException paramGlideException, int paramInt)
  {
    this.c.c();
    synchronized (this.d)
    {
      paramGlideException.setOrigin(this.D);
      int i1 = this.h.h();
      Object localObject2;
      if (i1 <= paramInt)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("Load failed for ");
        ((StringBuilder)localObject2).append(this.i);
        ((StringBuilder)localObject2).append(" with size [");
        ((StringBuilder)localObject2).append(this.A);
        ((StringBuilder)localObject2).append("x");
        ((StringBuilder)localObject2).append(this.B);
        ((StringBuilder)localObject2).append("]");
        Log.w("Glide", ((StringBuilder)localObject2).toString(), paramGlideException);
        if (i1 <= 4) {
          paramGlideException.logRootCauses("Glide");
        }
      }
      this.t = null;
      this.w = a.x;
      int i2 = 1;
      this.C = true;
      try
      {
        localObject2 = this.p;
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          paramInt = 0;
          for (;;)
          {
            i1 = paramInt;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramInt |= ((f)((Iterator)localObject2).next()).g(paramGlideException, this.i, this.o, p());
          }
        }
        i1 = 0;
        localObject2 = this.e;
        if ((localObject2 != null) && (((f)localObject2).g(paramGlideException, this.i, this.o, p()))) {
          paramInt = i2;
        } else {
          paramInt = 0;
        }
        if ((i1 | paramInt) == 0) {
          y();
        }
        this.C = false;
        t();
        return;
      }
      finally
      {
        this.C = false;
      }
    }
  }
  
  @GuardedBy("requestLock")
  private void x(u<R> paramu, R paramR, DataSource paramDataSource, boolean paramBoolean)
  {
    paramBoolean = p();
    this.w = a.q;
    this.s = paramu;
    if (this.h.h() <= 3)
    {
      paramu = new StringBuilder();
      paramu.append("Finished loading ");
      paramu.append(paramR.getClass().getSimpleName());
      paramu.append(" from ");
      paramu.append(paramDataSource);
      paramu.append(" for ");
      paramu.append(this.i);
      paramu.append(" with size [");
      paramu.append(this.A);
      paramu.append("x");
      paramu.append(this.B);
      paramu.append("] in ");
      paramu.append(com.bumptech.glide.util.e.a(this.u));
      paramu.append(" ms");
      Log.d("Glide", paramu.toString());
    }
    boolean bool1 = true;
    this.C = true;
    try
    {
      paramu = this.p;
      boolean bool2;
      if (paramu != null)
      {
        paramu = paramu.iterator();
        bool2 = false;
        for (;;)
        {
          bool3 = bool2;
          if (!paramu.hasNext()) {
            break;
          }
          bool2 |= ((f)paramu.next()).i(paramR, this.i, this.o, paramDataSource, paramBoolean);
        }
      }
      boolean bool3 = false;
      paramu = this.e;
      if ((paramu != null) && (paramu.i(paramR, this.i, this.o, paramDataSource, paramBoolean))) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      if (!(bool2 | bool3))
      {
        paramu = this.q.a(paramDataSource, paramBoolean);
        this.o.e(paramR, paramu);
      }
      this.C = false;
      u();
      return;
    }
    finally
    {
      this.C = false;
    }
  }
  
  @GuardedBy("requestLock")
  private void y()
  {
    if (!j()) {
      return;
    }
    Object localObject1 = null;
    if (this.i == null) {
      localObject1 = n();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = m();
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = o();
    }
    this.o.h((Drawable)localObject1);
  }
  
  public boolean a()
  {
    synchronized (this.d)
    {
      boolean bool;
      if (this.w == a.q) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void b(u<?> paramu, DataSource paramDataSource, boolean paramBoolean)
  {
    this.c.c();
    Object localObject1 = null;
    StringBuilder localStringBuilder = null;
    Object localObject2 = localObject1;
    try
    {
      Object localObject3 = this.d;
      localObject2 = localObject1;
      localObject2 = localStringBuilder;
      try
      {
        this.t = null;
        if (paramu == null)
        {
          localObject2 = localStringBuilder;
          paramu = new com/bumptech/glide/load/engine/GlideException;
          localObject2 = localStringBuilder;
          paramDataSource = new java/lang/StringBuilder;
          localObject2 = localStringBuilder;
          paramDataSource.<init>();
          localObject2 = localStringBuilder;
          paramDataSource.append("Expected to receive a Resource<R> with an object of ");
          localObject2 = localStringBuilder;
          paramDataSource.append(this.j);
          localObject2 = localStringBuilder;
          paramDataSource.append(" inside, but instead got null.");
          localObject2 = localStringBuilder;
          paramu.<init>(paramDataSource.toString());
          localObject2 = localStringBuilder;
          c(paramu);
          localObject2 = localStringBuilder;
          return;
        }
        localObject2 = localStringBuilder;
        localObject1 = paramu.get();
        if (localObject1 != null)
        {
          localObject2 = localStringBuilder;
          if (this.j.isAssignableFrom(localObject1.getClass()))
          {
            localObject2 = localStringBuilder;
            boolean bool = k();
            if (bool) {}
          }
        }
        try
        {
          this.s = null;
          this.w = a.q;
          this.v.k(paramu);
          return;
        }
        finally
        {
          break label406;
        }
        localObject2 = localStringBuilder;
        x(paramu, localObject1, paramDataSource, paramBoolean);
        localObject2 = localStringBuilder;
        return;
        this.s = null;
        localObject2 = new com/bumptech/glide/load/engine/GlideException;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Expected to receive an object of ");
        localStringBuilder.append(this.j);
        localStringBuilder.append(" but instead got ");
        if (localObject1 != null) {
          paramDataSource = localObject1.getClass();
        } else {
          paramDataSource = "";
        }
        localStringBuilder.append(paramDataSource);
        localStringBuilder.append("{");
        localStringBuilder.append(localObject1);
        localStringBuilder.append("} inside Resource{");
        localStringBuilder.append(paramu);
        localStringBuilder.append("}.");
        if (localObject1 != null) {
          paramDataSource = "";
        } else {
          paramDataSource = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        }
        localStringBuilder.append(paramDataSource);
        ((GlideException)localObject2).<init>(localStringBuilder.toString());
        c((GlideException)localObject2);
        this.v.k(paramu);
        return;
      }
      finally
      {
        paramu = (u<?>)localObject2;
      }
      label406:
      localObject2 = paramu;
      localObject2 = paramu;
      throw paramDataSource;
    }
    finally
    {
      if (localObject2 != null) {
        this.v.k((u)localObject2);
      }
    }
  }
  
  public void begin()
  {
    synchronized (this.d)
    {
      h();
      this.c.c();
      this.u = com.bumptech.glide.util.e.b();
      if (this.i == null)
      {
        if (com.bumptech.glide.util.j.u(this.l, this.m))
        {
          this.A = this.l;
          this.B = this.m;
        }
        int i1;
        if (n() == null) {
          i1 = 5;
        } else {
          i1 = 3;
        }
        localObject2 = new com/bumptech/glide/load/engine/GlideException;
        ((GlideException)localObject2).<init>("Received null model");
        w((GlideException)localObject2, i1);
        return;
      }
      a locala1 = this.w;
      Object localObject2 = a.d;
      if (locala1 != localObject2)
      {
        if (locala1 == a.q)
        {
          b(this.s, DataSource.MEMORY_CACHE, false);
          return;
        }
        locala1 = a.f;
        this.w = locala1;
        if (com.bumptech.glide.util.j.u(this.l, this.m)) {
          d(this.l, this.m);
        } else {
          this.o.j(this);
        }
        a locala2 = this.w;
        if (((locala2 == localObject2) || (locala2 == locala1)) && (j())) {
          this.o.b(o());
        }
        if (a)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          ((StringBuilder)localObject2).append("finished run method in ");
          ((StringBuilder)localObject2).append(com.bumptech.glide.util.e.a(this.u));
          r(((StringBuilder)localObject2).toString());
        }
        return;
      }
      localObject2 = new java/lang/IllegalArgumentException;
      ((IllegalArgumentException)localObject2).<init>("Cannot restart a running request");
      throw ((Throwable)localObject2);
    }
  }
  
  public void c(GlideException paramGlideException)
  {
    w(paramGlideException, 5);
  }
  
  public void clear()
  {
    synchronized (this.d)
    {
      h();
      this.c.c();
      Object localObject2 = this.w;
      a locala = a.y;
      if (localObject2 == locala) {
        return;
      }
      l();
      localObject2 = this.s;
      if (localObject2 != null) {
        this.s = null;
      } else {
        localObject2 = null;
      }
      if (i()) {
        this.o.d(o());
      }
      this.w = locala;
      if (localObject2 != null) {
        this.v.k((u)localObject2);
      }
      return;
    }
  }
  
  /* Error */
  public void d(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 114	com/bumptech/glide/request/i:c	Lcom/bumptech/glide/util/k/c;
    //   4: invokevirtual 196	com/bumptech/glide/util/k/c:c	()V
    //   7: aload_0
    //   8: getfield 116	com/bumptech/glide/request/i:d	Ljava/lang/Object;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: getstatic 89	com/bumptech/glide/request/i:a	Z
    //   17: istore 4
    //   19: iload 4
    //   21: ifeq +44 -> 65
    //   24: new 253	java/lang/StringBuilder
    //   27: astore 5
    //   29: aload 5
    //   31: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   34: aload 5
    //   36: ldc_w 498
    //   39: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: aload_0
    //   46: getfield 370	com/bumptech/glide/request/i:u	J
    //   49: invokestatic 375	com/bumptech/glide/util/e:a	(J)D
    //   52: invokevirtual 378	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_0
    //   57: aload 5
    //   59: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 482	com/bumptech/glide/request/i:r	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 150	com/bumptech/glide/request/i:w	Lcom/bumptech/glide/request/i$a;
    //   69: getstatic 471	com/bumptech/glide/request/i$a:f	Lcom/bumptech/glide/request/i$a;
    //   72: if_acmpeq +6 -> 78
    //   75: aload_3
    //   76: monitorexit
    //   77: return
    //   78: getstatic 461	com/bumptech/glide/request/i$a:d	Lcom/bumptech/glide/request/i$a;
    //   81: astore 5
    //   83: aload_0
    //   84: aload 5
    //   86: putfield 150	com/bumptech/glide/request/i:w	Lcom/bumptech/glide/request/i$a;
    //   89: aload_0
    //   90: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   93: invokevirtual 501	com/bumptech/glide/request/a:z	()F
    //   96: fstore 6
    //   98: aload_0
    //   99: iload_1
    //   100: fload 6
    //   102: invokestatic 503	com/bumptech/glide/request/i:s	(IF)I
    //   105: putfield 302	com/bumptech/glide/request/i:A	I
    //   108: aload_0
    //   109: iload_2
    //   110: fload 6
    //   112: invokestatic 503	com/bumptech/glide/request/i:s	(IF)I
    //   115: putfield 308	com/bumptech/glide/request/i:B	I
    //   118: iload 4
    //   120: ifeq +44 -> 164
    //   123: new 253	java/lang/StringBuilder
    //   126: astore 7
    //   128: aload 7
    //   130: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   133: aload 7
    //   135: ldc_w 505
    //   138: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 7
    //   144: aload_0
    //   145: getfield 370	com/bumptech/glide/request/i:u	J
    //   148: invokestatic 375	com/bumptech/glide/util/e:a	(J)D
    //   151: invokevirtual 378	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_0
    //   156: aload 7
    //   158: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 482	com/bumptech/glide/request/i:r	(Ljava/lang/String;)V
    //   164: aload_0
    //   165: getfield 142	com/bumptech/glide/request/i:v	Lcom/bumptech/glide/load/engine/k;
    //   168: astore 8
    //   170: aload_0
    //   171: getfield 120	com/bumptech/glide/request/i:h	Lcom/bumptech/glide/e;
    //   174: astore 9
    //   176: aload_0
    //   177: getfield 122	com/bumptech/glide/request/i:i	Ljava/lang/Object;
    //   180: astore 10
    //   182: aload_0
    //   183: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   186: invokevirtual 508	com/bumptech/glide/request/a:y	()Lcom/bumptech/glide/load/c;
    //   189: astore 11
    //   191: aload_0
    //   192: getfield 302	com/bumptech/glide/request/i:A	I
    //   195: istore_2
    //   196: aload_0
    //   197: getfield 308	com/bumptech/glide/request/i:B	I
    //   200: istore_1
    //   201: aload_0
    //   202: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   205: invokevirtual 510	com/bumptech/glide/request/a:x	()Ljava/lang/Class;
    //   208: astore 12
    //   210: aload_0
    //   211: getfield 124	com/bumptech/glide/request/i:j	Ljava/lang/Class;
    //   214: astore 13
    //   216: aload_0
    //   217: getfield 132	com/bumptech/glide/request/i:n	Lcom/bumptech/glide/Priority;
    //   220: astore 7
    //   222: aload_0
    //   223: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   226: invokevirtual 513	com/bumptech/glide/request/a:l	()Lcom/bumptech/glide/load/engine/j;
    //   229: astore 14
    //   231: aload_0
    //   232: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   235: invokevirtual 516	com/bumptech/glide/request/a:B	()Ljava/util/Map;
    //   238: astore 15
    //   240: aload_0
    //   241: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   244: invokevirtual 519	com/bumptech/glide/request/a:L	()Z
    //   247: istore 16
    //   249: aload_0
    //   250: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   253: invokevirtual 522	com/bumptech/glide/request/a:H	()Z
    //   256: istore 17
    //   258: aload_0
    //   259: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   262: invokevirtual 525	com/bumptech/glide/request/a:r	()Lcom/bumptech/glide/load/f;
    //   265: astore 18
    //   267: aload_0
    //   268: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   271: invokevirtual 528	com/bumptech/glide/request/a:F	()Z
    //   274: istore 19
    //   276: aload_0
    //   277: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   280: invokevirtual 530	com/bumptech/glide/request/a:D	()Z
    //   283: istore 20
    //   285: aload_0
    //   286: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   289: invokevirtual 532	com/bumptech/glide/request/a:C	()Z
    //   292: istore 21
    //   294: aload_0
    //   295: getfield 126	com/bumptech/glide/request/i:k	Lcom/bumptech/glide/request/a;
    //   298: invokevirtual 534	com/bumptech/glide/request/a:q	()Z
    //   301: istore 22
    //   303: aload_0
    //   304: getfield 146	com/bumptech/glide/request/i:r	Ljava/util/concurrent/Executor;
    //   307: astore 23
    //   309: aload 8
    //   311: aload 9
    //   313: aload 10
    //   315: aload 11
    //   317: iload_2
    //   318: iload_1
    //   319: aload 12
    //   321: aload 13
    //   323: aload 7
    //   325: aload 14
    //   327: aload 15
    //   329: iload 16
    //   331: iload 17
    //   333: aload 18
    //   335: iload 19
    //   337: iload 20
    //   339: iload 21
    //   341: iload 22
    //   343: aload_0
    //   344: aload 23
    //   346: invokevirtual 537	com/bumptech/glide/load/engine/k:f	(Lcom/bumptech/glide/e;Ljava/lang/Object;Lcom/bumptech/glide/load/c;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/Priority;Lcom/bumptech/glide/load/engine/j;Ljava/util/Map;ZZLcom/bumptech/glide/load/f;ZZZZLcom/bumptech/glide/request/h;Ljava/util/concurrent/Executor;)Lcom/bumptech/glide/load/engine/k$d;
    //   349: astore 8
    //   351: aload_3
    //   352: astore 7
    //   354: aload_0
    //   355: aload 8
    //   357: putfield 203	com/bumptech/glide/request/i:t	Lcom/bumptech/glide/load/engine/k$d;
    //   360: aload_3
    //   361: astore 7
    //   363: aload_0
    //   364: getfield 150	com/bumptech/glide/request/i:w	Lcom/bumptech/glide/request/i$a;
    //   367: aload 5
    //   369: if_acmpeq +11 -> 380
    //   372: aload_3
    //   373: astore 7
    //   375: aload_0
    //   376: aconst_null
    //   377: putfield 203	com/bumptech/glide/request/i:t	Lcom/bumptech/glide/load/engine/k$d;
    //   380: iload 4
    //   382: ifeq +59 -> 441
    //   385: aload_3
    //   386: astore 7
    //   388: new 253	java/lang/StringBuilder
    //   391: astore 5
    //   393: aload_3
    //   394: astore 7
    //   396: aload 5
    //   398: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   401: aload_3
    //   402: astore 7
    //   404: aload 5
    //   406: ldc_w 539
    //   409: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload_3
    //   414: astore 7
    //   416: aload 5
    //   418: aload_0
    //   419: getfield 370	com/bumptech/glide/request/i:u	J
    //   422: invokestatic 375	com/bumptech/glide/util/e:a	(J)D
    //   425: invokevirtual 378	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_3
    //   430: astore 7
    //   432: aload_0
    //   433: aload 5
    //   435: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokespecial 482	com/bumptech/glide/request/i:r	(Ljava/lang/String;)V
    //   441: aload_3
    //   442: astore 7
    //   444: aload_3
    //   445: monitorexit
    //   446: return
    //   447: astore 5
    //   449: goto +5 -> 454
    //   452: astore 5
    //   454: aload_3
    //   455: astore 7
    //   457: aload_3
    //   458: monitorexit
    //   459: aload 5
    //   461: athrow
    //   462: astore 5
    //   464: aload 7
    //   466: astore_3
    //   467: goto -13 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	i
    //   0	470	1	paramInt1	int
    //   0	470	2	paramInt2	int
    //   11	456	3	localObject1	Object
    //   17	364	4	bool1	boolean
    //   27	407	5	localObject2	Object
    //   447	1	5	localObject3	Object
    //   452	8	5	localObject4	Object
    //   462	1	5	localObject5	Object
    //   96	15	6	f1	float
    //   126	339	7	localObject6	Object
    //   168	188	8	localObject7	Object
    //   174	138	9	locale	com.bumptech.glide.e
    //   180	134	10	localObject8	Object
    //   189	127	11	localc	com.bumptech.glide.load.c
    //   208	112	12	localClass1	Class
    //   214	108	13	localClass2	Class
    //   229	97	14	localj	com.bumptech.glide.load.engine.j
    //   238	90	15	localMap	java.util.Map
    //   247	83	16	bool2	boolean
    //   256	76	17	bool3	boolean
    //   265	69	18	localf	com.bumptech.glide.load.f
    //   274	62	19	bool4	boolean
    //   283	55	20	bool5	boolean
    //   292	48	21	bool6	boolean
    //   301	41	22	bool7	boolean
    //   307	38	23	localExecutor	Executor
    // Exception table:
    //   from	to	target	type
    //   309	351	447	finally
    //   14	19	452	finally
    //   24	65	452	finally
    //   65	77	452	finally
    //   78	118	452	finally
    //   123	164	452	finally
    //   164	309	452	finally
    //   354	360	462	finally
    //   363	372	462	finally
    //   375	380	462	finally
    //   388	393	462	finally
    //   396	401	462	finally
    //   404	413	462	finally
    //   416	429	462	finally
    //   432	441	462	finally
    //   444	446	462	finally
    //   457	459	462	finally
  }
  
  public boolean e()
  {
    synchronized (this.d)
    {
      boolean bool;
      if (this.w == a.y) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public Object f()
  {
    this.c.c();
    return this.d;
  }
  
  public boolean g(d arg1)
  {
    if (!(??? instanceof i)) {
      return false;
    }
    synchronized (this.d)
    {
      int i1 = this.l;
      int i2 = this.m;
      Object localObject2 = this.i;
      Class localClass = this.j;
      a locala = this.k;
      Priority localPriority1 = this.n;
      Object localObject4 = this.p;
      int i3;
      if (localObject4 != null) {
        i3 = ((List)localObject4).size();
      } else {
        i3 = 0;
      }
      Object localObject5 = (i)???;
      synchronized (((i)localObject5).d)
      {
        int i4 = ((i)localObject5).l;
        int i5 = ((i)localObject5).m;
        Object localObject6 = ((i)localObject5).i;
        localObject4 = ((i)localObject5).j;
        ??? = ((i)localObject5).k;
        Priority localPriority2 = ((i)localObject5).n;
        localObject5 = ((i)localObject5).p;
        int i6;
        if (localObject5 != null) {
          i6 = ((List)localObject5).size();
        } else {
          i6 = 0;
        }
        boolean bool;
        if ((i1 == i4) && (i2 == i5) && (com.bumptech.glide.util.j.c(localObject2, localObject6)) && (localClass.equals(localObject4)) && (locala.equals(???)) && (localPriority1 == localPriority2) && (i3 == i6)) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    }
  }
  
  public boolean isComplete()
  {
    synchronized (this.d)
    {
      boolean bool;
      if (this.w == a.q) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isRunning()
  {
    synchronized (this.d)
    {
      a locala = this.w;
      boolean bool;
      if ((locala != a.d) && (locala != a.f)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public void pause()
  {
    synchronized (this.d)
    {
      if (isRunning()) {
        clear();
      }
      return;
    }
  }
  
  private static enum a
  {
    static
    {
      a locala1 = new a("PENDING", 0);
      c = locala1;
      a locala2 = new a("RUNNING", 1);
      d = locala2;
      a locala3 = new a("WAITING_FOR_SIZE", 2);
      f = locala3;
      a locala4 = new a("COMPLETE", 3);
      q = locala4;
      a locala5 = new a("FAILED", 4);
      x = locala5;
      a locala6 = new a("CLEARED", 5);
      y = locala6;
      z = new a[] { locala1, locala2, locala3, locala4, locala5, locala6 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */