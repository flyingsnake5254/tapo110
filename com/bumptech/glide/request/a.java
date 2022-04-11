package com.bumptech.glide.request;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.h;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.Map;

public abstract class a<T extends a<T>>
  implements Cloneable
{
  @NonNull
  private c H3 = com.bumptech.glide.o.a.c();
  private boolean I3;
  private boolean J3 = true;
  @Nullable
  private Drawable K3;
  private int L3;
  @NonNull
  private f M3 = new f();
  @NonNull
  private Map<Class<?>, com.bumptech.glide.load.i<?>> N3 = new CachedHashCodeArrayMap();
  @NonNull
  private Class<?> O3 = Object.class;
  private boolean P3;
  @Nullable
  private Resources.Theme Q3;
  private boolean R3;
  private boolean S3;
  private boolean T3;
  private boolean U3 = true;
  private boolean V3;
  private int c;
  private float d = 1.0F;
  @NonNull
  private com.bumptech.glide.load.engine.j f = com.bumptech.glide.load.engine.j.e;
  private int p0;
  private boolean p1 = true;
  private int p2 = -1;
  private int p3 = -1;
  @NonNull
  private Priority q = Priority.NORMAL;
  @Nullable
  private Drawable x;
  private int y;
  @Nullable
  private Drawable z;
  
  private boolean I(int paramInt)
  {
    return J(this.c, paramInt);
  }
  
  private static boolean J(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 & paramInt2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @NonNull
  private T S(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> parami)
  {
    return Y(paramDownsampleStrategy, parami, false);
  }
  
  @NonNull
  private T X(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> parami)
  {
    return Y(paramDownsampleStrategy, parami, true);
  }
  
  @NonNull
  private T Y(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> parami, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramDownsampleStrategy = h0(paramDownsampleStrategy, parami);
    } else {
      paramDownsampleStrategy = T(paramDownsampleStrategy, parami);
    }
    paramDownsampleStrategy.U3 = true;
    return paramDownsampleStrategy;
  }
  
  private T Z()
  {
    return this;
  }
  
  @Nullable
  public final Resources.Theme A()
  {
    return this.Q3;
  }
  
  @NonNull
  public final Map<Class<?>, com.bumptech.glide.load.i<?>> B()
  {
    return this.N3;
  }
  
  public final boolean C()
  {
    return this.V3;
  }
  
  public final boolean D()
  {
    return this.S3;
  }
  
  protected final boolean E()
  {
    return this.R3;
  }
  
  public final boolean F()
  {
    return this.p1;
  }
  
  public final boolean G()
  {
    return I(8);
  }
  
  boolean H()
  {
    return this.U3;
  }
  
  public final boolean K()
  {
    return this.J3;
  }
  
  public final boolean L()
  {
    return this.I3;
  }
  
  public final boolean M()
  {
    return I(2048);
  }
  
  public final boolean N()
  {
    return com.bumptech.glide.util.j.u(this.p3, this.p2);
  }
  
  @NonNull
  public T O()
  {
    this.P3 = true;
    return Z();
  }
  
  @CheckResult
  @NonNull
  public T P()
  {
    return T(DownsampleStrategy.e, new com.bumptech.glide.load.resource.bitmap.i());
  }
  
  @CheckResult
  @NonNull
  public T Q()
  {
    return S(DownsampleStrategy.d, new com.bumptech.glide.load.resource.bitmap.j());
  }
  
  @CheckResult
  @NonNull
  public T R()
  {
    return S(DownsampleStrategy.c, new o());
  }
  
  @NonNull
  final T T(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> parami)
  {
    if (this.R3) {
      return d().T(paramDownsampleStrategy, parami);
    }
    h(paramDownsampleStrategy);
    return g0(parami, false);
  }
  
  @CheckResult
  @NonNull
  public T U(int paramInt1, int paramInt2)
  {
    if (this.R3) {
      return d().U(paramInt1, paramInt2);
    }
    this.p3 = paramInt1;
    this.p2 = paramInt2;
    this.c |= 0x200;
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T V(@DrawableRes int paramInt)
  {
    if (this.R3) {
      return d().V(paramInt);
    }
    this.p0 = paramInt;
    paramInt = this.c | 0x80;
    this.c = paramInt;
    this.z = null;
    this.c = (paramInt & 0xFFFFFFBF);
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T W(@NonNull Priority paramPriority)
  {
    if (this.R3) {
      return d().W(paramPriority);
    }
    this.q = ((Priority)com.bumptech.glide.util.i.d(paramPriority));
    this.c |= 0x8;
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T a(@NonNull a<?> parama)
  {
    if (this.R3) {
      return d().a(parama);
    }
    if (J(parama.c, 2)) {
      this.d = parama.d;
    }
    if (J(parama.c, 262144)) {
      this.S3 = parama.S3;
    }
    if (J(parama.c, 1048576)) {
      this.V3 = parama.V3;
    }
    if (J(parama.c, 4)) {
      this.f = parama.f;
    }
    if (J(parama.c, 8)) {
      this.q = parama.q;
    }
    if (J(parama.c, 16))
    {
      this.x = parama.x;
      this.y = 0;
      this.c &= 0xFFFFFFDF;
    }
    if (J(parama.c, 32))
    {
      this.y = parama.y;
      this.x = null;
      this.c &= 0xFFFFFFEF;
    }
    if (J(parama.c, 64))
    {
      this.z = parama.z;
      this.p0 = 0;
      this.c &= 0xFF7F;
    }
    if (J(parama.c, 128))
    {
      this.p0 = parama.p0;
      this.z = null;
      this.c &= 0xFFFFFFBF;
    }
    if (J(parama.c, 256)) {
      this.p1 = parama.p1;
    }
    if (J(parama.c, 512))
    {
      this.p3 = parama.p3;
      this.p2 = parama.p2;
    }
    if (J(parama.c, 1024)) {
      this.H3 = parama.H3;
    }
    if (J(parama.c, 4096)) {
      this.O3 = parama.O3;
    }
    if (J(parama.c, 8192))
    {
      this.K3 = parama.K3;
      this.L3 = 0;
      this.c &= 0xBFFF;
    }
    if (J(parama.c, 16384))
    {
      this.L3 = parama.L3;
      this.K3 = null;
      this.c &= 0xDFFF;
    }
    if (J(parama.c, 32768)) {
      this.Q3 = parama.Q3;
    }
    if (J(parama.c, 65536)) {
      this.J3 = parama.J3;
    }
    if (J(parama.c, 131072)) {
      this.I3 = parama.I3;
    }
    if (J(parama.c, 2048))
    {
      this.N3.putAll(parama.N3);
      this.U3 = parama.U3;
    }
    if (J(parama.c, 524288)) {
      this.T3 = parama.T3;
    }
    if (!this.J3)
    {
      this.N3.clear();
      int i = this.c & 0xF7FF;
      this.c = i;
      this.I3 = false;
      this.c = (i & 0xFFFDFFFF);
      this.U3 = true;
    }
    this.c |= parama.c;
    this.M3.d(parama.M3);
    return a0();
  }
  
  @NonNull
  protected final T a0()
  {
    if (!this.P3) {
      return Z();
    }
    throw new IllegalStateException("You cannot modify locked T, consider clone()");
  }
  
  @NonNull
  public T b()
  {
    if ((this.P3) && (!this.R3)) {
      throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }
    this.R3 = true;
    return O();
  }
  
  @CheckResult
  @NonNull
  public <Y> T b0(@NonNull com.bumptech.glide.load.e<Y> parame, @NonNull Y paramY)
  {
    if (this.R3) {
      return d().b0(parame, paramY);
    }
    com.bumptech.glide.util.i.d(parame);
    com.bumptech.glide.util.i.d(paramY);
    this.M3.e(parame, paramY);
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T c()
  {
    return h0(DownsampleStrategy.e, new com.bumptech.glide.load.resource.bitmap.i());
  }
  
  @CheckResult
  @NonNull
  public T c0(@NonNull c paramc)
  {
    if (this.R3) {
      return d().c0(paramc);
    }
    this.H3 = ((c)com.bumptech.glide.util.i.d(paramc));
    this.c |= 0x400;
    return a0();
  }
  
  @CheckResult
  public T d()
  {
    try
    {
      a locala = (a)super.clone();
      Object localObject = new com/bumptech/glide/load/f;
      ((f)localObject).<init>();
      locala.M3 = ((f)localObject);
      ((f)localObject).d(this.M3);
      localObject = new com/bumptech/glide/util/CachedHashCodeArrayMap;
      ((CachedHashCodeArrayMap)localObject).<init>();
      locala.N3 = ((Map)localObject);
      ((Map)localObject).putAll(this.N3);
      locala.P3 = false;
      locala.R3 = false;
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  @CheckResult
  @NonNull
  public T d0(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.R3) {
      return d().d0(paramFloat);
    }
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.d = paramFloat;
      this.c |= 0x2;
      return a0();
    }
    throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
  }
  
  @CheckResult
  @NonNull
  public T e(@NonNull Class<?> paramClass)
  {
    if (this.R3) {
      return d().e(paramClass);
    }
    this.O3 = ((Class)com.bumptech.glide.util.i.d(paramClass));
    this.c |= 0x1000;
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T e0(boolean paramBoolean)
  {
    if (this.R3) {
      return d().e0(true);
    }
    this.p1 = (paramBoolean ^ true);
    this.c |= 0x100;
    return a0();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof a;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (a)paramObject;
      bool3 = bool2;
      if (Float.compare(((a)paramObject).d, this.d) == 0)
      {
        bool3 = bool2;
        if (this.y == ((a)paramObject).y)
        {
          bool3 = bool2;
          if (com.bumptech.glide.util.j.d(this.x, ((a)paramObject).x))
          {
            bool3 = bool2;
            if (this.p0 == ((a)paramObject).p0)
            {
              bool3 = bool2;
              if (com.bumptech.glide.util.j.d(this.z, ((a)paramObject).z))
              {
                bool3 = bool2;
                if (this.L3 == ((a)paramObject).L3)
                {
                  bool3 = bool2;
                  if (com.bumptech.glide.util.j.d(this.K3, ((a)paramObject).K3))
                  {
                    bool3 = bool2;
                    if (this.p1 == ((a)paramObject).p1)
                    {
                      bool3 = bool2;
                      if (this.p2 == ((a)paramObject).p2)
                      {
                        bool3 = bool2;
                        if (this.p3 == ((a)paramObject).p3)
                        {
                          bool3 = bool2;
                          if (this.I3 == ((a)paramObject).I3)
                          {
                            bool3 = bool2;
                            if (this.J3 == ((a)paramObject).J3)
                            {
                              bool3 = bool2;
                              if (this.S3 == ((a)paramObject).S3)
                              {
                                bool3 = bool2;
                                if (this.T3 == ((a)paramObject).T3)
                                {
                                  bool3 = bool2;
                                  if (this.f.equals(((a)paramObject).f))
                                  {
                                    bool3 = bool2;
                                    if (this.q == ((a)paramObject).q)
                                    {
                                      bool3 = bool2;
                                      if (this.M3.equals(((a)paramObject).M3))
                                      {
                                        bool3 = bool2;
                                        if (this.N3.equals(((a)paramObject).N3))
                                        {
                                          bool3 = bool2;
                                          if (this.O3.equals(((a)paramObject).O3))
                                          {
                                            bool3 = bool2;
                                            if (com.bumptech.glide.util.j.d(this.H3, ((a)paramObject).H3))
                                            {
                                              bool3 = bool2;
                                              if (com.bumptech.glide.util.j.d(this.Q3, ((a)paramObject).Q3)) {
                                                bool3 = true;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool3;
  }
  
  @CheckResult
  @NonNull
  public T f(@NonNull com.bumptech.glide.load.engine.j paramj)
  {
    if (this.R3) {
      return d().f(paramj);
    }
    this.f = ((com.bumptech.glide.load.engine.j)com.bumptech.glide.util.i.d(paramj));
    this.c |= 0x4;
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T f0(@NonNull com.bumptech.glide.load.i<Bitmap> parami)
  {
    return g0(parami, true);
  }
  
  @CheckResult
  @NonNull
  public T g()
  {
    return b0(h.b, Boolean.TRUE);
  }
  
  @NonNull
  T g0(@NonNull com.bumptech.glide.load.i<Bitmap> parami, boolean paramBoolean)
  {
    if (this.R3) {
      return d().g0(parami, paramBoolean);
    }
    m localm = new m(parami, paramBoolean);
    i0(Bitmap.class, parami, paramBoolean);
    i0(Drawable.class, localm, paramBoolean);
    i0(BitmapDrawable.class, localm.c(), paramBoolean);
    i0(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(parami), paramBoolean);
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T h(@NonNull DownsampleStrategy paramDownsampleStrategy)
  {
    return b0(DownsampleStrategy.h, com.bumptech.glide.util.i.d(paramDownsampleStrategy));
  }
  
  @CheckResult
  @NonNull
  final T h0(@NonNull DownsampleStrategy paramDownsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> parami)
  {
    if (this.R3) {
      return d().h0(paramDownsampleStrategy, parami);
    }
    h(paramDownsampleStrategy);
    return f0(parami);
  }
  
  public int hashCode()
  {
    int i = com.bumptech.glide.util.j.l(this.d);
    i = com.bumptech.glide.util.j.o(this.y, i);
    i = com.bumptech.glide.util.j.p(this.x, i);
    i = com.bumptech.glide.util.j.o(this.p0, i);
    i = com.bumptech.glide.util.j.p(this.z, i);
    i = com.bumptech.glide.util.j.o(this.L3, i);
    i = com.bumptech.glide.util.j.p(this.K3, i);
    i = com.bumptech.glide.util.j.q(this.p1, i);
    i = com.bumptech.glide.util.j.o(this.p2, i);
    i = com.bumptech.glide.util.j.o(this.p3, i);
    i = com.bumptech.glide.util.j.q(this.I3, i);
    i = com.bumptech.glide.util.j.q(this.J3, i);
    i = com.bumptech.glide.util.j.q(this.S3, i);
    i = com.bumptech.glide.util.j.q(this.T3, i);
    i = com.bumptech.glide.util.j.p(this.f, i);
    i = com.bumptech.glide.util.j.p(this.q, i);
    i = com.bumptech.glide.util.j.p(this.M3, i);
    i = com.bumptech.glide.util.j.p(this.N3, i);
    i = com.bumptech.glide.util.j.p(this.O3, i);
    i = com.bumptech.glide.util.j.p(this.H3, i);
    return com.bumptech.glide.util.j.p(this.Q3, i);
  }
  
  @NonNull
  <Y> T i0(@NonNull Class<Y> paramClass, @NonNull com.bumptech.glide.load.i<Y> parami, boolean paramBoolean)
  {
    if (this.R3) {
      return d().i0(paramClass, parami, paramBoolean);
    }
    com.bumptech.glide.util.i.d(paramClass);
    com.bumptech.glide.util.i.d(parami);
    this.N3.put(paramClass, parami);
    int i = this.c | 0x800;
    this.c = i;
    this.J3 = true;
    i |= 0x10000;
    this.c = i;
    this.U3 = false;
    if (paramBoolean)
    {
      this.c = (i | 0x20000);
      this.I3 = true;
    }
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T j(@DrawableRes int paramInt)
  {
    if (this.R3) {
      return d().j(paramInt);
    }
    this.y = paramInt;
    paramInt = this.c | 0x20;
    this.c = paramInt;
    this.x = null;
    this.c = (paramInt & 0xFFFFFFEF);
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T j0(@NonNull com.bumptech.glide.load.i<Bitmap>... paramVarArgs)
  {
    if (paramVarArgs.length > 1) {
      return g0(new d(paramVarArgs), true);
    }
    if (paramVarArgs.length == 1) {
      return f0(paramVarArgs[0]);
    }
    return a0();
  }
  
  @CheckResult
  @NonNull
  public T k()
  {
    return X(DownsampleStrategy.c, new o());
  }
  
  @CheckResult
  @NonNull
  public T k0(boolean paramBoolean)
  {
    if (this.R3) {
      return d().k0(paramBoolean);
    }
    this.V3 = paramBoolean;
    this.c |= 0x100000;
    return a0();
  }
  
  @NonNull
  public final com.bumptech.glide.load.engine.j l()
  {
    return this.f;
  }
  
  public final int m()
  {
    return this.y;
  }
  
  @Nullable
  public final Drawable n()
  {
    return this.x;
  }
  
  @Nullable
  public final Drawable o()
  {
    return this.K3;
  }
  
  public final int p()
  {
    return this.L3;
  }
  
  public final boolean q()
  {
    return this.T3;
  }
  
  @NonNull
  public final f r()
  {
    return this.M3;
  }
  
  public final int s()
  {
    return this.p2;
  }
  
  public final int t()
  {
    return this.p3;
  }
  
  @Nullable
  public final Drawable u()
  {
    return this.z;
  }
  
  public final int v()
  {
    return this.p0;
  }
  
  @NonNull
  public final Priority w()
  {
    return this.q;
  }
  
  @NonNull
  public final Class<?> x()
  {
    return this.O3;
  }
  
  @NonNull
  public final c y()
  {
    return this.H3;
  }
  
  public final float z()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */