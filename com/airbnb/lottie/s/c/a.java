package com.airbnb.lottie.s.c;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class a<K, A>
{
  final List<b> a = new ArrayList(1);
  private boolean b = false;
  private final d<K> c;
  protected float d = 0.0F;
  @Nullable
  protected com.airbnb.lottie.w.c<A> e;
  @Nullable
  private A f = null;
  private float g = -1.0F;
  private float h = -1.0F;
  
  a(List<? extends com.airbnb.lottie.w.a<K>> paramList)
  {
    this.c = n(paramList);
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  private float g()
  {
    if (this.g == -1.0F) {
      this.g = this.c.d();
    }
    return this.g;
  }
  
  private static <T> d<T> n(List<? extends com.airbnb.lottie.w.a<T>> paramList)
  {
    if (paramList.isEmpty()) {
      return new c(null);
    }
    if (paramList.size() == 1) {
      return new f(paramList);
    }
    return new e(paramList);
  }
  
  public void a(b paramb)
  {
    this.a.add(paramb);
  }
  
  protected com.airbnb.lottie.w.a<K> b()
  {
    com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
    com.airbnb.lottie.w.a locala = this.c.b();
    com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
    return locala;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  float c()
  {
    if (this.h == -1.0F) {
      this.h = this.c.e();
    }
    return this.h;
  }
  
  protected float d()
  {
    com.airbnb.lottie.w.a locala = b();
    if (locala.h()) {
      return 0.0F;
    }
    return locala.d.getInterpolation(e());
  }
  
  float e()
  {
    if (this.b) {
      return 0.0F;
    }
    com.airbnb.lottie.w.a locala = b();
    if (locala.h()) {
      return 0.0F;
    }
    return (this.d - locala.e()) / (locala.b() - locala.e());
  }
  
  public float f()
  {
    return this.d;
  }
  
  public A h()
  {
    float f1 = d();
    if ((this.e == null) && (this.c.a(f1))) {
      return (A)this.f;
    }
    Object localObject = i(b(), f1);
    this.f = localObject;
    return (A)localObject;
  }
  
  abstract A i(com.airbnb.lottie.w.a<K> parama, float paramFloat);
  
  public void j()
  {
    for (int i = 0; i < this.a.size(); i++) {
      ((b)this.a.get(i)).a();
    }
  }
  
  public void k()
  {
    this.b = true;
  }
  
  public void l(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.c.isEmpty()) {
      return;
    }
    float f1;
    if (paramFloat < g())
    {
      f1 = g();
    }
    else
    {
      f1 = paramFloat;
      if (paramFloat > c()) {
        f1 = c();
      }
    }
    if (f1 == this.d) {
      return;
    }
    this.d = f1;
    if (this.c.c(f1)) {
      j();
    }
  }
  
  public void m(@Nullable com.airbnb.lottie.w.c<A> paramc)
  {
    com.airbnb.lottie.w.c localc = this.e;
    if (localc != null) {
      localc.c(null);
    }
    this.e = paramc;
    if (paramc != null) {
      paramc.c(this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  private static final class c<T>
    implements a.d<T>
  {
    public boolean a(float paramFloat)
    {
      throw new IllegalStateException("not implemented");
    }
    
    public com.airbnb.lottie.w.a<T> b()
    {
      throw new IllegalStateException("not implemented");
    }
    
    public boolean c(float paramFloat)
    {
      return false;
    }
    
    public float d()
    {
      return 0.0F;
    }
    
    public float e()
    {
      return 1.0F;
    }
    
    public boolean isEmpty()
    {
      return true;
    }
  }
  
  private static abstract interface d<T>
  {
    public abstract boolean a(float paramFloat);
    
    public abstract com.airbnb.lottie.w.a<T> b();
    
    public abstract boolean c(float paramFloat);
    
    @FloatRange(from=0.0D, to=1.0D)
    public abstract float d();
    
    @FloatRange(from=0.0D, to=1.0D)
    public abstract float e();
    
    public abstract boolean isEmpty();
  }
  
  private static final class e<T>
    implements a.d<T>
  {
    private final List<? extends com.airbnb.lottie.w.a<T>> a;
    @NonNull
    private com.airbnb.lottie.w.a<T> b;
    private com.airbnb.lottie.w.a<T> c = null;
    private float d = -1.0F;
    
    e(List<? extends com.airbnb.lottie.w.a<T>> paramList)
    {
      this.a = paramList;
      this.b = f(0.0F);
    }
    
    private com.airbnb.lottie.w.a<T> f(float paramFloat)
    {
      Object localObject = this.a;
      localObject = (com.airbnb.lottie.w.a)((List)localObject).get(((List)localObject).size() - 1);
      if (paramFloat >= ((com.airbnb.lottie.w.a)localObject).e()) {
        return (com.airbnb.lottie.w.a<T>)localObject;
      }
      for (int i = this.a.size() - 2; i >= 1; i--)
      {
        localObject = (com.airbnb.lottie.w.a)this.a.get(i);
        if ((this.b != localObject) && (((com.airbnb.lottie.w.a)localObject).a(paramFloat))) {
          return (com.airbnb.lottie.w.a<T>)localObject;
        }
      }
      return (com.airbnb.lottie.w.a)this.a.get(0);
    }
    
    public boolean a(float paramFloat)
    {
      com.airbnb.lottie.w.a locala1 = this.c;
      com.airbnb.lottie.w.a locala2 = this.b;
      if ((locala1 == locala2) && (this.d == paramFloat)) {
        return true;
      }
      this.c = locala2;
      this.d = paramFloat;
      return false;
    }
    
    @NonNull
    public com.airbnb.lottie.w.a<T> b()
    {
      return this.b;
    }
    
    public boolean c(float paramFloat)
    {
      if (this.b.a(paramFloat)) {
        return this.b.h() ^ true;
      }
      this.b = f(paramFloat);
      return true;
    }
    
    public float d()
    {
      return ((com.airbnb.lottie.w.a)this.a.get(0)).e();
    }
    
    public float e()
    {
      List localList = this.a;
      return ((com.airbnb.lottie.w.a)localList.get(localList.size() - 1)).b();
    }
    
    public boolean isEmpty()
    {
      return false;
    }
  }
  
  private static final class f<T>
    implements a.d<T>
  {
    @NonNull
    private final com.airbnb.lottie.w.a<T> a;
    private float b = -1.0F;
    
    f(List<? extends com.airbnb.lottie.w.a<T>> paramList)
    {
      this.a = ((com.airbnb.lottie.w.a)paramList.get(0));
    }
    
    public boolean a(float paramFloat)
    {
      if (this.b == paramFloat) {
        return true;
      }
      this.b = paramFloat;
      return false;
    }
    
    public com.airbnb.lottie.w.a<T> b()
    {
      return this.a;
    }
    
    public boolean c(float paramFloat)
    {
      return this.a.h() ^ true;
    }
    
    public float d()
    {
      return this.a.e();
    }
    
    public float e()
    {
      return this.a.b();
    }
    
    public boolean isEmpty()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */