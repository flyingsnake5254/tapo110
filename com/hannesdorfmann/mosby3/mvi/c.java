package com.hannesdorfmann.mosby3.mvi;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import io.reactivex.m0.h;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class c<V extends com.hannesdorfmann.mosby3.k.b, VS>
  implements d<V, VS>
{
  private final io.reactivex.m0.b<VS> a = io.reactivex.m0.b.n1();
  private boolean b = false;
  private List<c<V, VS>.b<?>> c = new ArrayList(4);
  private io.reactivex.e0.b d;
  private io.reactivex.e0.c e;
  private io.reactivex.e0.c f;
  private boolean g = true;
  private d<V, VS> h;
  
  public c()
  {
    h();
  }
  
  @MainThread
  private <I> q<I> d(@NonNull V paramV, @NonNull c<V, VS>.b<?> paramc)
  {
    Objects.requireNonNull(paramV, "View is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
    Objects.requireNonNull(paramc, "IntentRelayBinderPair is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
    io.reactivex.m0.g localg = b.a(paramc);
    Objects.requireNonNull(localg, "IntentRelay from binderPair is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
    paramc = b.b(paramc);
    if (paramc != null)
    {
      paramV = paramc.a(paramV);
      if (paramV != null)
      {
        if (this.d == null) {
          this.d = new io.reactivex.e0.b();
        }
        this.d.b((io.reactivex.e0.c)paramV.M0(new a(localg)));
        return localg;
      }
      paramV = new StringBuilder();
      paramV.append("Intent Observable returned from Binder ");
      paramV.append(paramc);
      paramV.append(" is null");
      throw new NullPointerException(paramV.toString());
    }
    paramV = new StringBuilder();
    paramV.append(c.class.getSimpleName());
    paramV.append(" is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
    throw new NullPointerException(paramV.toString());
  }
  
  private void h()
  {
    this.g = true;
    this.c.clear();
    this.b = false;
  }
  
  @MainThread
  private void j(@NonNull final V paramV)
  {
    Objects.requireNonNull(paramV, "View is null");
    if (this.h != null)
    {
      this.e = this.a.G0(new a(paramV));
      return;
    }
    paramV = new StringBuilder();
    paramV.append(d.class.getSimpleName());
    paramV.append(" is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
    throw new NullPointerException(paramV.toString());
  }
  
  @CallSuper
  public void a(@NonNull V paramV)
  {
    if (this.g) {
      e();
    }
    if (this.h != null) {
      j(paramV);
    }
    int i = this.c.size();
    for (int j = 0; j < i; j++) {
      d(paramV, (b)this.c.get(j));
    }
    this.g = false;
  }
  
  @CallSuper
  public void b()
  {
    f(true);
    Object localObject = this.e;
    if (localObject != null)
    {
      ((io.reactivex.e0.c)localObject).dispose();
      this.e = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((io.reactivex.e0.b)localObject).dispose();
      this.d = null;
    }
  }
  
  @CallSuper
  public void destroy()
  {
    f(false);
    io.reactivex.e0.c localc = this.f;
    if (localc != null) {
      localc.dispose();
    }
    k();
    h();
  }
  
  @MainThread
  protected abstract void e();
  
  @Deprecated
  @CallSuper
  public void f(boolean paramBoolean) {}
  
  @MainThread
  protected <I> q<I> g(c<V, I> paramc)
  {
    h localh = h.m1();
    this.c.add(new b(localh, paramc));
    return localh;
  }
  
  @MainThread
  protected void i(@NonNull q<VS> paramq, @NonNull d<V, VS> paramd)
  {
    if (!this.b)
    {
      this.b = true;
      Objects.requireNonNull(paramq, "ViewState Observable is null");
      Objects.requireNonNull(paramd, "ViewStateBinder is null");
      this.h = paramd;
      this.f = ((io.reactivex.e0.c)paramq.M0(new b(this.a)));
      return;
    }
    throw new IllegalStateException("subscribeViewState() method is only allowed to be called once");
  }
  
  protected void k() {}
  
  class a
    implements io.reactivex.g0.g<VS>
  {
    a(com.hannesdorfmann.mosby3.k.b paramb) {}
    
    public void accept(VS paramVS)
      throws Exception
    {
      c.c(c.this).a(paramV, paramVS);
    }
  }
  
  private class b<I>
  {
    private final io.reactivex.m0.g<I> a;
    private final c.c<V, I> b;
    
    public b(c.c<V, I> paramc)
    {
      this.a = paramc;
      c.c localc;
      this.b = localc;
    }
  }
  
  protected static abstract interface c<V extends com.hannesdorfmann.mosby3.k.b, I>
  {
    @NonNull
    public abstract q<I> a(@NonNull V paramV);
  }
  
  protected static abstract interface d<V extends com.hannesdorfmann.mosby3.k.b, VS>
  {
    public abstract void a(@NonNull V paramV, @NonNull VS paramVS);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\mvi\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */