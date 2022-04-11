package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.k.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class h<TranscodeType>
  extends a<h<TranscodeType>>
  implements Cloneable
{
  protected static final g W3 = (g)((g)((g)new g().f(com.bumptech.glide.load.engine.j.c)).W(Priority.LOW)).e0(true);
  private final Context X3;
  private final i Y3;
  private final Class<TranscodeType> Z3;
  private final c a4;
  private final e b4;
  @NonNull
  private j<?, ? super TranscodeType> c4;
  @Nullable
  private Object d4;
  @Nullable
  private List<f<TranscodeType>> e4;
  @Nullable
  private h<TranscodeType> f4;
  @Nullable
  private h<TranscodeType> g4;
  @Nullable
  private Float h4;
  private boolean i4 = true;
  private boolean j4;
  private boolean k4;
  
  @SuppressLint({"CheckResult"})
  protected h(@NonNull c paramc, i parami, Class<TranscodeType> paramClass, Context paramContext)
  {
    this.a4 = paramc;
    this.Y3 = parami;
    this.Z3 = paramClass;
    this.X3 = paramContext;
    this.c4 = parami.p(paramClass);
    this.b4 = paramc.i();
    s0(parami.n());
    m0(parami.o());
  }
  
  @NonNull
  private h<TranscodeType> C0(@Nullable Object paramObject)
  {
    if (E()) {
      return q0().C0(paramObject);
    }
    this.d4 = paramObject;
    this.j4 = true;
    return (h)a0();
  }
  
  private com.bumptech.glide.request.d D0(Object paramObject, com.bumptech.glide.request.k.j<TranscodeType> paramj, f<TranscodeType> paramf, a<?> parama, RequestCoordinator paramRequestCoordinator, j<?, ? super TranscodeType> paramj1, Priority paramPriority, int paramInt1, int paramInt2, Executor paramExecutor)
  {
    Context localContext = this.X3;
    e locale = this.b4;
    return com.bumptech.glide.request.i.v(localContext, locale, paramObject, this.d4, this.Z3, parama, paramInt1, paramInt2, paramPriority, paramj, paramf, this.e4, paramRequestCoordinator, locale.f(), paramj1.b(), paramExecutor);
  }
  
  private com.bumptech.glide.request.d n0(com.bumptech.glide.request.k.j<TranscodeType> paramj, @Nullable f<TranscodeType> paramf, a<?> parama, Executor paramExecutor)
  {
    return o0(new Object(), paramj, paramf, null, this.c4, parama.w(), parama.t(), parama.s(), parama, paramExecutor);
  }
  
  private com.bumptech.glide.request.d o0(Object paramObject, com.bumptech.glide.request.k.j<TranscodeType> paramj, @Nullable f<TranscodeType> paramf, @Nullable RequestCoordinator paramRequestCoordinator, j<?, ? super TranscodeType> paramj1, Priority paramPriority, int paramInt1, int paramInt2, a<?> parama, Executor paramExecutor)
  {
    Object localObject1;
    if (this.g4 != null)
    {
      localObject1 = new b(paramObject, paramRequestCoordinator);
      paramRequestCoordinator = (RequestCoordinator)localObject1;
    }
    else
    {
      Object localObject2 = null;
      localObject1 = paramRequestCoordinator;
      paramRequestCoordinator = (RequestCoordinator)localObject2;
    }
    paramj1 = p0(paramObject, paramj, paramf, (RequestCoordinator)localObject1, paramj1, paramPriority, paramInt1, paramInt2, parama, paramExecutor);
    if (paramRequestCoordinator == null) {
      return paramj1;
    }
    int i = this.g4.t();
    int j = this.g4.s();
    int k = i;
    int m = j;
    if (com.bumptech.glide.util.j.u(paramInt1, paramInt2))
    {
      k = i;
      m = j;
      if (!this.g4.N())
      {
        k = parama.t();
        m = parama.s();
      }
    }
    paramPriority = this.g4;
    paramRequestCoordinator.m(paramj1, paramPriority.o0(paramObject, paramj, paramf, paramRequestCoordinator, paramPriority.c4, paramPriority.w(), k, m, this.g4, paramExecutor));
    return paramRequestCoordinator;
  }
  
  private com.bumptech.glide.request.d p0(Object paramObject, com.bumptech.glide.request.k.j<TranscodeType> paramj, f<TranscodeType> paramf, @Nullable RequestCoordinator paramRequestCoordinator, j<?, ? super TranscodeType> paramj1, Priority paramPriority, int paramInt1, int paramInt2, a<?> parama, Executor paramExecutor)
  {
    Object localObject1 = this.f4;
    if (localObject1 != null)
    {
      if (!this.k4)
      {
        Object localObject2 = ((h)localObject1).c4;
        if (((h)localObject1).i4) {
          localObject2 = paramj1;
        }
        if (((a)localObject1).G()) {
          localObject1 = this.f4.w();
        } else {
          localObject1 = r0(paramPriority);
        }
        int i = this.f4.t();
        int j = this.f4.s();
        int k = i;
        int m = j;
        if (com.bumptech.glide.util.j.u(paramInt1, paramInt2))
        {
          k = i;
          m = j;
          if (!this.f4.N())
          {
            k = parama.t();
            m = parama.s();
          }
        }
        paramRequestCoordinator = new com.bumptech.glide.request.j(paramObject, paramRequestCoordinator);
        paramj1 = D0(paramObject, paramj, paramf, parama, paramRequestCoordinator, paramj1, paramPriority, paramInt1, paramInt2, paramExecutor);
        this.k4 = true;
        paramPriority = this.f4;
        paramObject = paramPriority.o0(paramObject, paramj, paramf, paramRequestCoordinator, (j)localObject2, (Priority)localObject1, k, m, paramPriority, paramExecutor);
        this.k4 = false;
        paramRequestCoordinator.l(paramj1, (com.bumptech.glide.request.d)paramObject);
        return paramRequestCoordinator;
      }
      throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    }
    if (this.h4 != null)
    {
      paramRequestCoordinator = new com.bumptech.glide.request.j(paramObject, paramRequestCoordinator);
      paramRequestCoordinator.l(D0(paramObject, paramj, paramf, parama, paramRequestCoordinator, paramj1, paramPriority, paramInt1, paramInt2, paramExecutor), D0(paramObject, paramj, paramf, parama.d().d0(this.h4.floatValue()), paramRequestCoordinator, paramj1, r0(paramPriority), paramInt1, paramInt2, paramExecutor));
      return paramRequestCoordinator;
    }
    return D0(paramObject, paramj, paramf, parama, paramRequestCoordinator, paramj1, paramPriority, paramInt1, paramInt2, paramExecutor);
  }
  
  @NonNull
  private Priority r0(@NonNull Priority paramPriority)
  {
    int i = a.b[paramPriority.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          paramPriority = new StringBuilder();
          paramPriority.append("unknown priority: ");
          paramPriority.append(w());
          throw new IllegalArgumentException(paramPriority.toString());
        }
        return Priority.IMMEDIATE;
      }
      return Priority.HIGH;
    }
    return Priority.NORMAL;
  }
  
  @SuppressLint({"CheckResult"})
  private void s0(List<f<Object>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      l0((f)paramList.next());
    }
  }
  
  private <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y v0(@NonNull Y paramY, @Nullable f<TranscodeType> paramf, a<?> parama, Executor paramExecutor)
  {
    com.bumptech.glide.util.i.d(paramY);
    if (this.j4)
    {
      paramf = n0(paramY, paramf, parama, paramExecutor);
      paramExecutor = paramY.c();
      if ((paramf.g(paramExecutor)) && (!y0(parama, paramExecutor)))
      {
        if (!((com.bumptech.glide.request.d)com.bumptech.glide.util.i.d(paramExecutor)).isRunning()) {
          paramExecutor.begin();
        }
        return paramY;
      }
      this.Y3.m(paramY);
      paramY.f(paramf);
      this.Y3.y(paramY, paramf);
      return paramY;
    }
    throw new IllegalArgumentException("You must call #load() before calling #into()");
  }
  
  private boolean y0(a<?> parama, com.bumptech.glide.request.d paramd)
  {
    boolean bool;
    if ((!parama.F()) && (paramd.isComplete())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @CheckResult
  @NonNull
  public h<TranscodeType> A0(@Nullable Object paramObject)
  {
    return C0(paramObject);
  }
  
  @CheckResult
  @NonNull
  public h<TranscodeType> B0(@Nullable String paramString)
  {
    return C0(paramString);
  }
  
  @NonNull
  public com.bumptech.glide.request.c<TranscodeType> E0()
  {
    return F0(Integer.MIN_VALUE, Integer.MIN_VALUE);
  }
  
  @NonNull
  public com.bumptech.glide.request.c<TranscodeType> F0(int paramInt1, int paramInt2)
  {
    com.bumptech.glide.request.e locale = new com.bumptech.glide.request.e(paramInt1, paramInt2);
    return (com.bumptech.glide.request.c)w0(locale, locale, com.bumptech.glide.util.d.a());
  }
  
  @CheckResult
  @NonNull
  public h<TranscodeType> l0(@Nullable f<TranscodeType> paramf)
  {
    if (E()) {
      return q0().l0(paramf);
    }
    if (paramf != null)
    {
      if (this.e4 == null) {
        this.e4 = new ArrayList();
      }
      this.e4.add(paramf);
    }
    return (h)a0();
  }
  
  @CheckResult
  @NonNull
  public h<TranscodeType> m0(@NonNull a<?> parama)
  {
    com.bumptech.glide.util.i.d(parama);
    return (h)super.a(parama);
  }
  
  @CheckResult
  public h<TranscodeType> q0()
  {
    h localh1 = (h)super.d();
    localh1.c4 = localh1.c4.a();
    if (localh1.e4 != null) {
      localh1.e4 = new ArrayList(localh1.e4);
    }
    h localh2 = localh1.f4;
    if (localh2 != null) {
      localh1.f4 = localh2.q0();
    }
    localh2 = localh1.g4;
    if (localh2 != null) {
      localh1.g4 = localh2.q0();
    }
    return localh1;
  }
  
  @Deprecated
  public com.bumptech.glide.request.c<TranscodeType> t0(int paramInt1, int paramInt2)
  {
    return F0(paramInt1, paramInt2);
  }
  
  @NonNull
  public <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y u0(@NonNull Y paramY)
  {
    return w0(paramY, null, com.bumptech.glide.util.d.b());
  }
  
  @NonNull
  <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y w0(@NonNull Y paramY, @Nullable f<TranscodeType> paramf, Executor paramExecutor)
  {
    return v0(paramY, paramf, this, paramExecutor);
  }
  
  @NonNull
  public k<ImageView, TranscodeType> x0(@NonNull ImageView paramImageView)
  {
    com.bumptech.glide.util.j.b();
    com.bumptech.glide.util.i.d(paramImageView);
    if ((!M()) && (K()) && (paramImageView.getScaleType() != null)) {
      switch (a.a[paramImageView.getScaleType().ordinal()])
      {
      default: 
        break;
      case 6: 
        localObject = d().Q();
        break;
      case 3: 
      case 4: 
      case 5: 
        localObject = d().R();
        break;
      case 2: 
        localObject = d().Q();
        break;
      case 1: 
        localObject = d().P();
        break;
      }
    }
    Object localObject = this;
    return (k)v0(this.b4.a(paramImageView, this.Z3), null, (a)localObject, com.bumptech.glide.util.d.b());
  }
  
  @CheckResult
  @NonNull
  public h<TranscodeType> z0(@Nullable File paramFile)
  {
    return C0(paramFile);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */