package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.util.k.a.f;
import com.bumptech.glide.util.k.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class h<R>
  implements f.a, Runnable, Comparable<h<?>>, a.f
{
  private int H3;
  private int I3;
  private j J3;
  private com.bumptech.glide.load.f K3;
  private b<R> L3;
  private int M3;
  private h N3;
  private g O3;
  private long P3;
  private boolean Q3;
  private Object R3;
  private Thread S3;
  private com.bumptech.glide.load.c T3;
  private com.bumptech.glide.load.c U3;
  private Object V3;
  private DataSource W3;
  private com.bumptech.glide.load.data.d<?> X3;
  private volatile f Y3;
  private volatile boolean Z3;
  private volatile boolean a4;
  private boolean b4;
  private final g<R> c = new g();
  private final List<Throwable> d = new ArrayList();
  private final com.bumptech.glide.util.k.c f = com.bumptech.glide.util.k.c.a();
  private com.bumptech.glide.e p0;
  private com.bumptech.glide.load.c p1;
  private Priority p2;
  private n p3;
  private final e q;
  private final Pools.Pool<h<?>> x;
  private final d<?> y = new d();
  private final f z = new f();
  
  h(e parame, Pools.Pool<h<?>> paramPool)
  {
    this.q = parame;
    this.x = paramPool;
  }
  
  private void A()
  {
    int i = a.a[this.O3.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          i();
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized run reason: ");
          localStringBuilder.append(this.O3);
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      else {
        y();
      }
    }
    else
    {
      this.N3 = k(h.c);
      this.Y3 = j();
      y();
    }
  }
  
  private void B()
  {
    this.f.c();
    if (this.Z3)
    {
      Object localObject;
      if (this.d.isEmpty())
      {
        localObject = null;
      }
      else
      {
        localObject = this.d;
        localObject = (Throwable)((List)localObject).get(((List)localObject).size() - 1);
      }
      throw new IllegalStateException("Already notified", (Throwable)localObject);
    }
    this.Z3 = true;
  }
  
  private <Data> u<R> g(com.bumptech.glide.load.data.d<?> paramd, Data paramData, DataSource paramDataSource)
    throws GlideException
  {
    if (paramData == null)
    {
      paramd.b();
      return null;
    }
    try
    {
      long l = com.bumptech.glide.util.e.b();
      paramData = h(paramData, paramDataSource);
      if (Log.isLoggable("DecodeJob", 2))
      {
        paramDataSource = new java/lang/StringBuilder;
        paramDataSource.<init>();
        paramDataSource.append("Decoded result ");
        paramDataSource.append(paramData);
        o(paramDataSource.toString(), l);
      }
      return paramData;
    }
    finally
    {
      paramd.b();
    }
  }
  
  private <Data> u<R> h(Data paramData, DataSource paramDataSource)
    throws GlideException
  {
    return z(paramData, paramDataSource, this.c.h(paramData.getClass()));
  }
  
  private void i()
  {
    if (Log.isLoggable("DecodeJob", 2))
    {
      long l = this.P3;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("data: ");
      ((StringBuilder)localObject).append(this.V3);
      ((StringBuilder)localObject).append(", cache key: ");
      ((StringBuilder)localObject).append(this.T3);
      ((StringBuilder)localObject).append(", fetcher: ");
      ((StringBuilder)localObject).append(this.X3);
      p("Retrieved data", l, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    try
    {
      u localu = g(this.X3, this.V3, this.W3);
      localObject = localu;
    }
    catch (GlideException localGlideException)
    {
      localGlideException.setLoggingDetails(this.U3, this.W3);
      this.d.add(localGlideException);
    }
    if (localObject != null) {
      r((u)localObject, this.W3, this.b4);
    } else {
      y();
    }
  }
  
  private f j()
  {
    int i = a.b[this.N3.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return null;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized stage: ");
          localStringBuilder.append(this.N3);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        return new y(this.c, this);
      }
      return new c(this.c, this);
    }
    return new v(this.c, this);
  }
  
  private h k(h paramh)
  {
    int i = a.b[paramh.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i == 5)
          {
            if (this.J3.b()) {
              paramh = h.d;
            } else {
              paramh = k(h.d);
            }
            return paramh;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized stage: ");
          localStringBuilder.append(paramh);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return h.y;
      }
      if (this.Q3) {
        paramh = h.y;
      } else {
        paramh = h.q;
      }
      return paramh;
    }
    if (this.J3.a()) {
      paramh = h.f;
    } else {
      paramh = k(h.f);
    }
    return paramh;
  }
  
  @NonNull
  private com.bumptech.glide.load.f l(DataSource paramDataSource)
  {
    com.bumptech.glide.load.f localf = this.K3;
    if (Build.VERSION.SDK_INT < 26) {
      return localf;
    }
    boolean bool;
    if ((paramDataSource != DataSource.RESOURCE_DISK_CACHE) && (!this.c.w())) {
      bool = false;
    } else {
      bool = true;
    }
    paramDataSource = k.e;
    Boolean localBoolean = (Boolean)localf.c(paramDataSource);
    if ((localBoolean != null) && ((!localBoolean.booleanValue()) || (bool))) {
      return localf;
    }
    localf = new com.bumptech.glide.load.f();
    localf.d(this.K3);
    localf.e(paramDataSource, Boolean.valueOf(bool));
    return localf;
  }
  
  private int m()
  {
    return this.p2.ordinal();
  }
  
  private void o(String paramString, long paramLong)
  {
    p(paramString, paramLong, null);
  }
  
  private void p(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" in ");
    localStringBuilder.append(com.bumptech.glide.util.e.a(paramLong));
    localStringBuilder.append(", load key: ");
    localStringBuilder.append(this.p3);
    if (paramString2 != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(", ");
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = "";
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", thread: ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.v("DecodeJob", localStringBuilder.toString());
  }
  
  private void q(u<R> paramu, DataSource paramDataSource, boolean paramBoolean)
  {
    B();
    this.L3.b(paramu, paramDataSource, paramBoolean);
  }
  
  private void r(u<R> paramu, DataSource paramDataSource, boolean paramBoolean)
  {
    if ((paramu instanceof q)) {
      ((q)paramu).b();
    }
    Object localObject1 = null;
    Object localObject2 = paramu;
    if (this.y.c())
    {
      localObject2 = t.f(paramu);
      localObject1 = localObject2;
    }
    q((u)localObject2, paramDataSource, paramBoolean);
    this.N3 = h.x;
    try
    {
      if (this.y.c()) {
        this.y.b(this.q, this.K3);
      }
      if (localObject1 != null) {
        ((t)localObject1).h();
      }
      t();
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((t)localObject1).h();
      }
    }
  }
  
  private void s()
  {
    B();
    GlideException localGlideException = new GlideException("Failed to load resource", new ArrayList(this.d));
    this.L3.c(localGlideException);
    u();
  }
  
  private void t()
  {
    if (this.z.b()) {
      x();
    }
  }
  
  private void u()
  {
    if (this.z.c()) {
      x();
    }
  }
  
  private void x()
  {
    this.z.e();
    this.y.a();
    this.c.a();
    this.Z3 = false;
    this.p0 = null;
    this.p1 = null;
    this.K3 = null;
    this.p2 = null;
    this.p3 = null;
    this.L3 = null;
    this.N3 = null;
    this.Y3 = null;
    this.S3 = null;
    this.T3 = null;
    this.V3 = null;
    this.W3 = null;
    this.X3 = null;
    this.P3 = 0L;
    this.a4 = false;
    this.R3 = null;
    this.d.clear();
    this.x.release(this);
  }
  
  private void y()
  {
    this.S3 = Thread.currentThread();
    this.P3 = com.bumptech.glide.util.e.b();
    boolean bool1 = false;
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (this.a4) {
        break;
      }
      bool2 = bool1;
      if (this.Y3 == null) {
        break;
      }
      bool1 = this.Y3.b();
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.N3 = k(this.N3);
      this.Y3 = j();
    } while (this.N3 != h.q);
    c();
    return;
    if (((this.N3 == h.y) || (this.a4)) && (!bool2)) {
      s();
    }
  }
  
  private <Data, ResourceType> u<R> z(Data paramData, DataSource paramDataSource, s<Data, ResourceType, R> params)
    throws GlideException
  {
    com.bumptech.glide.load.f localf = l(paramDataSource);
    paramData = this.p0.i().l(paramData);
    try
    {
      int i = this.H3;
      int j = this.I3;
      c localc = new com/bumptech/glide/load/engine/h$c;
      localc.<init>(this, paramDataSource);
      paramDataSource = params.a(paramData, localf, i, j, localc);
      return paramDataSource;
    }
    finally
    {
      paramData.b();
    }
  }
  
  boolean C()
  {
    h localh = k(h.c);
    boolean bool;
    if ((localh != h.d) && (localh != h.f)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void a(com.bumptech.glide.load.c paramc, Exception paramException, com.bumptech.glide.load.data.d<?> paramd, DataSource paramDataSource)
  {
    paramd.b();
    paramException = new GlideException("Fetching data failed", paramException);
    paramException.setLoggingDetails(paramc, paramDataSource, paramd.a());
    this.d.add(paramException);
    if (Thread.currentThread() != this.S3)
    {
      this.O3 = g.d;
      this.L3.e(this);
    }
    else
    {
      y();
    }
  }
  
  public void b()
  {
    this.a4 = true;
    f localf = this.Y3;
    if (localf != null) {
      localf.cancel();
    }
  }
  
  public void c()
  {
    this.O3 = g.d;
    this.L3.e(this);
  }
  
  @NonNull
  public com.bumptech.glide.util.k.c d()
  {
    return this.f;
  }
  
  public void e(com.bumptech.glide.load.c paramc1, Object paramObject, com.bumptech.glide.load.data.d<?> paramd, DataSource paramDataSource, com.bumptech.glide.load.c paramc2)
  {
    this.T3 = paramc1;
    this.V3 = paramObject;
    this.X3 = paramd;
    this.W3 = paramDataSource;
    this.U3 = paramc2;
    paramObject = this.c.c();
    boolean bool = false;
    if (paramc1 != ((List)paramObject).get(0)) {
      bool = true;
    }
    this.b4 = bool;
    if (Thread.currentThread() != this.S3)
    {
      this.O3 = g.f;
      this.L3.e(this);
    }
    else
    {
      b.a("DecodeJob.decodeFromRetrievedData");
    }
    try
    {
      i();
      return;
    }
    finally
    {
      b.d();
    }
  }
  
  public int f(@NonNull h<?> paramh)
  {
    int i = m() - paramh.m();
    int j = i;
    if (i == 0) {
      j = this.M3 - paramh.M3;
    }
    return j;
  }
  
  h<R> n(com.bumptech.glide.e parame, Object paramObject, n paramn, com.bumptech.glide.load.c paramc, int paramInt1, int paramInt2, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, j paramj, Map<Class<?>, i<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.bumptech.glide.load.f paramf, b<R> paramb, int paramInt3)
  {
    this.c.u(parame, paramObject, paramc, paramInt1, paramInt2, paramj, paramClass, paramClass1, paramPriority, paramf, paramMap, paramBoolean1, paramBoolean2, this.q);
    this.p0 = parame;
    this.p1 = paramc;
    this.p2 = paramPriority;
    this.p3 = paramn;
    this.H3 = paramInt1;
    this.I3 = paramInt2;
    this.J3 = paramj;
    this.Q3 = paramBoolean3;
    this.K3 = paramf;
    this.L3 = paramb;
    this.M3 = paramInt3;
    this.O3 = g.c;
    this.R3 = paramObject;
    return this;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 568
    //   3: aload_0
    //   4: getfield 468	com/bumptech/glide/load/engine/h:R3	Ljava/lang/Object;
    //   7: invokestatic 571	com/bumptech/glide/util/k/b:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   10: aload_0
    //   11: getfield 264	com/bumptech/glide/load/engine/h:X3	Lcom/bumptech/glide/load/data/d;
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 466	com/bumptech/glide/load/engine/h:a4	Z
    //   19: ifeq +21 -> 40
    //   22: aload_0
    //   23: invokespecial 482	com/bumptech/glide/load/engine/h:s	()V
    //   26: aload_1
    //   27: ifnull +9 -> 36
    //   30: aload_1
    //   31: invokeinterface 215 1 0
    //   36: invokestatic 549	com/bumptech/glide/util/k/b:d	()V
    //   39: return
    //   40: aload_0
    //   41: invokespecial 573	com/bumptech/glide/load/engine/h:A	()V
    //   44: aload_1
    //   45: ifnull +9 -> 54
    //   48: aload_1
    //   49: invokeinterface 215 1 0
    //   54: invokestatic 549	com/bumptech/glide/util/k/b:d	()V
    //   57: return
    //   58: astore_2
    //   59: ldc -31
    //   61: iconst_3
    //   62: invokestatic 231	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   65: ifeq +56 -> 121
    //   68: new 148	java/lang/StringBuilder
    //   71: astore_3
    //   72: aload_3
    //   73: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   76: aload_3
    //   77: ldc_w 575
    //   80: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: aload_0
    //   86: getfield 466	com/bumptech/glide/load/engine/h:a4	Z
    //   89: invokevirtual 578	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_3
    //   94: ldc_w 580
    //   97: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_3
    //   102: aload_0
    //   103: getfield 177	com/bumptech/glide/load/engine/h:N3	Lcom/bumptech/glide/load/engine/h$h;
    //   106: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc -31
    //   112: aload_3
    //   113: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: aload_2
    //   117: invokestatic 583	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   120: pop
    //   121: aload_0
    //   122: getfield 177	com/bumptech/glide/load/engine/h:N3	Lcom/bumptech/glide/load/engine/h$h;
    //   125: getstatic 426	com/bumptech/glide/load/engine/h$h:x	Lcom/bumptech/glide/load/engine/h$h;
    //   128: if_acmpeq +18 -> 146
    //   131: aload_0
    //   132: getfield 110	com/bumptech/glide/load/engine/h:d	Ljava/util/List;
    //   135: aload_2
    //   136: invokeinterface 284 2 0
    //   141: pop
    //   142: aload_0
    //   143: invokespecial 482	com/bumptech/glide/load/engine/h:s	()V
    //   146: aload_0
    //   147: getfield 466	com/bumptech/glide/load/engine/h:a4	Z
    //   150: ifne +5 -> 155
    //   153: aload_2
    //   154: athrow
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: aload_2
    //   159: athrow
    //   160: astore_2
    //   161: aload_1
    //   162: ifnull +9 -> 171
    //   165: aload_1
    //   166: invokeinterface 215 1 0
    //   171: invokestatic 549	com/bumptech/glide/util/k/b:d	()V
    //   174: aload_2
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	h
    //   14	152	1	locald	com.bumptech.glide.load.data.d
    //   58	98	2	localThrowable	Throwable
    //   157	2	2	localb	b
    //   160	15	2	localObject	Object
    //   71	42	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	26	58	finally
    //   40	44	58	finally
    //   15	26	157	com/bumptech/glide/load/engine/b
    //   40	44	157	com/bumptech/glide/load/engine/b
    //   59	121	160	finally
    //   121	146	160	finally
    //   146	155	160	finally
    //   155	157	160	finally
    //   158	160	160	finally
  }
  
  @NonNull
  <Z> u<Z> v(DataSource paramDataSource, @NonNull u<Z> paramu)
  {
    Class localClass = paramu.get().getClass();
    Object localObject1 = DataSource.RESOURCE_DISK_CACHE;
    Object localObject2 = null;
    i locali;
    if (paramDataSource != localObject1)
    {
      locali = this.c.r(localClass);
      localObject1 = locali.a(this.p0, paramu, this.H3, this.I3);
    }
    else
    {
      localObject1 = paramu;
      locali = null;
    }
    if (!paramu.equals(localObject1)) {
      paramu.c();
    }
    EncodeStrategy localEncodeStrategy;
    if (this.c.v((u)localObject1))
    {
      paramu = this.c.n((u)localObject1);
      localEncodeStrategy = paramu.b(this.K3);
    }
    else
    {
      localEncodeStrategy = EncodeStrategy.NONE;
      paramu = (u<Z>)localObject2;
    }
    boolean bool = this.c.x(this.T3);
    localObject2 = localObject1;
    if (this.J3.d(bool ^ true, paramDataSource, localEncodeStrategy)) {
      if (paramu != null)
      {
        int i = a.c[localEncodeStrategy.ordinal()];
        if (i != 1)
        {
          if (i == 2)
          {
            paramDataSource = new w(this.c.b(), this.T3, this.p1, this.H3, this.I3, locali, localClass, this.K3);
          }
          else
          {
            paramDataSource = new StringBuilder();
            paramDataSource.append("Unknown strategy: ");
            paramDataSource.append(localEncodeStrategy);
            throw new IllegalArgumentException(paramDataSource.toString());
          }
        }
        else {
          paramDataSource = new d(this.T3, this.p1);
        }
        localObject2 = t.f((u)localObject1);
        this.y.d(paramDataSource, paramu, (t)localObject2);
      }
      else
      {
        throw new Registry.NoResultEncoderAvailableException(((u)localObject1).get().getClass());
      }
    }
    return (u<Z>)localObject2;
  }
  
  void w(boolean paramBoolean)
  {
    if (this.z.d(paramBoolean)) {
      x();
    }
  }
  
  static abstract interface b<R>
  {
    public abstract void b(u<R> paramu, DataSource paramDataSource, boolean paramBoolean);
    
    public abstract void c(GlideException paramGlideException);
    
    public abstract void e(h<?> paramh);
  }
  
  private final class c<Z>
    implements i.a<Z>
  {
    private final DataSource a;
    
    c(DataSource paramDataSource)
    {
      this.a = paramDataSource;
    }
    
    @NonNull
    public u<Z> a(@NonNull u<Z> paramu)
    {
      return h.this.v(this.a, paramu);
    }
  }
  
  private static class d<Z>
  {
    private com.bumptech.glide.load.c a;
    private com.bumptech.glide.load.h<Z> b;
    private t<Z> c;
    
    void a()
    {
      this.a = null;
      this.b = null;
      this.c = null;
    }
    
    void b(h.e parame, com.bumptech.glide.load.f paramf)
    {
      b.a("DecodeJob.encode");
      try
      {
        parame = parame.a();
        com.bumptech.glide.load.c localc = this.a;
        e locale = new com/bumptech/glide/load/engine/e;
        locale.<init>(this.b, this.c, paramf);
        parame.a(localc, locale);
        return;
      }
      finally
      {
        this.c.h();
        b.d();
      }
    }
    
    boolean c()
    {
      boolean bool;
      if (this.c != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    <X> void d(com.bumptech.glide.load.c paramc, com.bumptech.glide.load.h<X> paramh, t<X> paramt)
    {
      this.a = paramc;
      this.b = paramh;
      this.c = paramt;
    }
  }
  
  static abstract interface e
  {
    public abstract a a();
  }
  
  private static class f
  {
    private boolean a;
    private boolean b;
    private boolean c;
    
    private boolean a(boolean paramBoolean)
    {
      if (((this.c) || (paramBoolean) || (this.b)) && (this.a)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
    
    boolean b()
    {
      try
      {
        this.b = true;
        boolean bool = a(false);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    boolean c()
    {
      try
      {
        this.c = true;
        boolean bool = a(false);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    boolean d(boolean paramBoolean)
    {
      try
      {
        this.a = true;
        paramBoolean = a(paramBoolean);
        return paramBoolean;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    void e()
    {
      try
      {
        this.b = false;
        this.a = false;
        this.c = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private static enum g
  {
    static
    {
      g localg1 = new g("INITIALIZE", 0);
      c = localg1;
      g localg2 = new g("SWITCH_TO_SOURCE_SERVICE", 1);
      d = localg2;
      g localg3 = new g("DECODE_DATA", 2);
      f = localg3;
      q = new g[] { localg1, localg2, localg3 };
    }
  }
  
  private static enum h
  {
    static
    {
      h localh1 = new h("INITIALIZE", 0);
      c = localh1;
      h localh2 = new h("RESOURCE_CACHE", 1);
      d = localh2;
      h localh3 = new h("DATA_CACHE", 2);
      f = localh3;
      h localh4 = new h("SOURCE", 3);
      q = localh4;
      h localh5 = new h("ENCODE", 4);
      x = localh5;
      h localh6 = new h("FINISHED", 5);
      y = localh6;
      z = new h[] { localh1, localh2, localh3, localh4, localh5, localh6 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */